/*    */ package org.spongepowered.tools.obfuscation;
/*    */ public class ObfuscationManager implements IObfuscationManager { private final IMixinAnnotationProcessor ap; private final List<ObfuscationEnvironment> environments; private final IObfuscationDataProvider obfs;
/*    */   
/*  4 */   public IMappingConsumer createMappingConsumer() { Mappings mappings = new Mappings();
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
/* 19 */     this.consumers.add(mappings);
/*    */ 
/*    */ 
/*    */     
/* 23 */     return mappings; } private final IReferenceManager refs; private final List<IMappingConsumer> consumers; private boolean initDone; public void init() { try { if (this.initDone)
/*    */         return;  }
/*    */     catch (RuntimeException runtimeException) { throw b(null); }
/* 26 */      this.initDone = true; ObfuscationServices.getInstance().initProviders(this.ap); for (ObfuscationType obfuscationType : ObfuscationType.types()) { 
/* 27 */       try { if (obfuscationType.isSupported()) this.environments.add(obfuscationType.createEnvironment());  } catch (RuntimeException runtimeException) { throw b(null); }  }  } public IReferenceManager getReferenceManager() { return this.refs; } public IObfuscationDataProvider getDataProvider() { return this.obfs; }
/* 28 */   public void writeMappings() { for (ObfuscationEnvironment obfuscationEnvironment : this.environments)
/*    */       obfuscationEnvironment.writeMappings(this.consumers);  }
/*    */ 
/*    */   
/*    */   public void writeReferences() {
/*    */     this.refs.write();
/*    */   }
/*    */   
/*    */   public ObfuscationManager(IMixinAnnotationProcessor paramIMixinAnnotationProcessor) {
/*    */     this.environments = new ArrayList<ObfuscationEnvironment>();
/*    */     this.consumers = new ArrayList<IMappingConsumer>();
/*    */     this.ap = paramIMixinAnnotationProcessor;
/*    */     this.obfs = new ObfuscationDataProvider(paramIMixinAnnotationProcessor, this.environments);
/*    */     this.refs = new ReferenceManager(paramIMixinAnnotationProcessor, this.environments);
/*    */   }
/*    */   
/*    */   public List<ObfuscationEnvironment> getEnvironments() {
/*    */     return this.environments;
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\ObfuscationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */