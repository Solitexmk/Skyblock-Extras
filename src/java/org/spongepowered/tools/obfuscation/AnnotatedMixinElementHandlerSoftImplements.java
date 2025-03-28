/*    */ package org.spongepowered.tools.obfuscation;
/*    */ 
/*    */ public class AnnotatedMixinElementHandlerSoftImplements extends AnnotatedMixinElementHandler {
/*    */   public void process(AnnotationHandle paramAnnotationHandle) { try {
/*  5 */       if (!this.mixin.remap())
/*    */       {
/*    */         return;
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
/*    */       }
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
/*    */     }
/*    */     catch (Exception exception) {
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
/* 43 */       throw b(null);
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     List list = paramAnnotationHandle.getAnnotationList("value");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 56 */     try { if (list.size() < 1) { this.ap.printMessage(Diagnostic.Kind.WARNING, "Empty @Implements annotation", this.mixin.getMixin(), paramAnnotationHandle.asMirror()); return; }  } catch (Exception exception) { throw b(null); }  for (AnnotationHandle annotationHandle : list) { Interface.Remap remap = (Interface.Remap)annotationHandle.getValue("remap", Interface.Remap.ALL); try { if (remap == Interface.Remap.NONE); } catch (Exception exception) { throw b(null); }  }
/* 57 */      } private void processMethod(Interface.Remap paramRemap, TypeHandle paramTypeHandle, String paramString, ExecutableElement paramExecutableElement) { String str1 = paramExecutableElement.getSimpleName().toString(); String str2 = TypeUtils.getJavaSignature(paramExecutableElement); String str3 = TypeUtils.getDescriptor(paramExecutableElement);
/*    */     if (paramRemap != Interface.Remap.ONLY_PREFIXED) {
/*    */       MethodHandle methodHandle = this.mixin.getHandle().findMethod(str1, str2);
/*    */       try {
/*    */         if (methodHandle != null)
/*    */           addInterfaceMethodMapping(paramRemap, paramTypeHandle, (String)null, methodHandle, str1, str3); 
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } 
/*    */     if (paramString != null) {
/*    */       MethodHandle methodHandle = this.mixin.getHandle().findMethod(paramString + str1, str2);
/*    */       try {
/*    */         if (methodHandle != null)
/*    */           addInterfaceMethodMapping(paramRemap, paramTypeHandle, paramString, methodHandle, str1, str3); 
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw b(null);
/*    */       } 
/*    */     }  }
/*    */ 
/*    */   
/*    */   AnnotatedMixinElementHandlerSoftImplements(IMixinAnnotationProcessor paramIMixinAnnotationProcessor, AnnotatedMixin paramAnnotatedMixin) {
/*    */     super(paramIMixinAnnotationProcessor, paramAnnotatedMixin);
/*    */   }
/*    */   
/*    */   private void addInterfaceMethodMapping(Interface.Remap paramRemap, TypeHandle paramTypeHandle, String paramString1, MethodHandle paramMethodHandle, String paramString2, String paramString3) {
/*    */     MappingMethod mappingMethod = new MappingMethod(paramTypeHandle.getName(), paramString2, paramString3);
/*    */     ObfuscationData<MappingMethod> obfuscationData = this.obf.getDataProvider().getObfMethod(mappingMethod);
/*    */     try {
/*    */       if (obfuscationData.isEmpty()) {
/*    */         try {
/*    */           if (paramRemap.forceRemap())
/*    */             this.ap.printMessage(Diagnostic.Kind.ERROR, "No obfuscation mapping for soft-implementing method", paramMethodHandle.getElement()); 
/*    */         } catch (RuntimeException runtimeException) {
/*    */           throw b(null);
/*    */         } 
/*    */         return;
/*    */       } 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     addMethodMappings(paramMethodHandle.getName(), paramString3, applyPrefix(obfuscationData, paramString1));
/*    */   }
/*    */   
/*    */   private void processSoftImplements(Interface.Remap paramRemap, TypeHandle paramTypeHandle, String paramString) {
/*    */     for (ExecutableElement executableElement : paramTypeHandle.getEnclosedElements(new ElementKind[] { ElementKind.METHOD }))
/*    */       processMethod(paramRemap, paramTypeHandle, paramString, executableElement); 
/*    */     for (TypeHandle typeHandle : paramTypeHandle.getInterfaces())
/*    */       processSoftImplements(paramRemap, typeHandle, paramString); 
/*    */   }
/*    */   
/*    */   private ObfuscationData<MappingMethod> applyPrefix(ObfuscationData<MappingMethod> paramObfuscationData, String paramString) {
/*    */     try {
/*    */       if (paramString == null)
/*    */         return paramObfuscationData; 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     ObfuscationData<MappingMethod> obfuscationData = new ObfuscationData();
/*    */     for (ObfuscationType obfuscationType : paramObfuscationData) {
/*    */       MappingMethod mappingMethod = paramObfuscationData.get(obfuscationType);
/*    */       obfuscationData.put(obfuscationType, mappingMethod.addPrefix(paramString));
/*    */     } 
/*    */     return obfuscationData;
/*    */   }
/*    */   
/*    */   private static Exception b(Exception paramException) {
/*    */     return paramException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\AnnotatedMixinElementHandlerSoftImplements.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */