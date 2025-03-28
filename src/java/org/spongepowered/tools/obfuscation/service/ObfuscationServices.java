/*    */ package org.spongepowered.tools.obfuscation.service;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.HashSet;
/*    */ import java.util.ServiceConfigurationError;
/*    */ import java.util.ServiceLoader;
/*    */ import java.util.Set;
/*    */ import javax.tools.Diagnostic;
/*    */ import org.spongepowered.tools.obfuscation.ObfuscationType;
/*    */ import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
/*    */ 
/*    */ 
/*    */ public final class ObfuscationServices
/*    */ {
/* 15 */   private final Set<IObfuscationService> services = new HashSet<IObfuscationService>(); public void initProviders(IMixinAnnotationProcessor paramIMixinAnnotationProcessor) { try {
/* 16 */       for (IObfuscationService iObfuscationService : this.serviceLoader) {
/* 17 */         if (!this.services.contains(iObfuscationService)) {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 37 */           this.services.add(iObfuscationService);
/*    */           String str = iObfuscationService.getClass().getSimpleName();
/*    */           Collection<ObfuscationTypeDescriptor> collection = iObfuscationService.getObfuscationTypes();
/*    */           if (collection != null)
/*    */             for (ObfuscationTypeDescriptor obfuscationTypeDescriptor : collection) {
/*    */               try {
/*    */                 ObfuscationType obfuscationType = ObfuscationType.create(obfuscationTypeDescriptor, paramIMixinAnnotationProcessor);
/*    */                 paramIMixinAnnotationProcessor.printMessage(Diagnostic.Kind.NOTE, str + " supports type: \"" + obfuscationType + "\"");
/*    */               } catch (Exception exception) {}
/*    */             }  
/*    */         } 
/*    */       } 
/*    */     } catch (ServiceConfigurationError serviceConfigurationError) {
/*    */       paramIMixinAnnotationProcessor.printMessage(Diagnostic.Kind.ERROR, serviceConfigurationError.getClass().getSimpleName() + ": " + serviceConfigurationError.getMessage());
/*    */       serviceConfigurationError.printStackTrace();
/*    */     }  }
/*    */ 
/*    */   
/*    */   public IObfuscationService getService(Class<? extends IObfuscationService> paramClass) {
/*    */     for (IObfuscationService iObfuscationService : this.serviceLoader) {
/*    */       try {
/*    */         if (paramClass.getName().equals(iObfuscationService.getClass().getName()))
/*    */           return iObfuscationService; 
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } 
/*    */     return null;
/*    */   }
/*    */   
/*    */   public Set<String> getSupportedOptions() {
/*    */     HashSet<String> hashSet = new HashSet();
/*    */     for (IObfuscationService iObfuscationService : this.serviceLoader)
/*    */       Set<String> set = iObfuscationService.getSupportedOptions(); 
/*    */     return hashSet;
/*    */   }
/*    */   
/*    */   public static ObfuscationServices getInstance() {
/*    */     try {
/*    */       if (instance == null)
/*    */         instance = new ObfuscationServices(); 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return instance;
/*    */   }
/*    */   
/*    */   private final ServiceLoader<IObfuscationService> serviceLoader = ServiceLoader.load(IObfuscationService.class, getClass().getClassLoader());
/*    */   private static ObfuscationServices instance;
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\service\ObfuscationServices.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */