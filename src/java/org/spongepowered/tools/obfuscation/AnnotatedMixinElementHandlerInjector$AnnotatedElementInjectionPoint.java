/*    */ package org.spongepowered.tools.obfuscation;
/*    */ class AnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint extends AnnotatedMixinElementHandler$AnnotatedElement<ExecutableElement> { private final AnnotationHandle at;
/*    */   private Map<String, String> args;
/*    */   private final InjectorRemap state;
/*    */   
/*  6 */   public AnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint(ExecutableElement paramExecutableElement, AnnotationHandle paramAnnotationHandle1, AnnotationHandle paramAnnotationHandle2, InjectorRemap paramInjectorRemap) { super(paramExecutableElement, paramAnnotationHandle1);
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
/* 17 */     this.at = paramAnnotationHandle2; this.state = paramInjectorRemap; } public String getAtArg(String paramString) { if (this.args == null) { this.args = new HashMap<String, String>(); for (String str : this.at.getList("args")) { try { if (str == null); } catch (RuntimeException runtimeException) { throw b(null); }  }
/*    */        }
/* 19 */      return this.args.get(paramString); }
/*    */ 
/*    */   
/*    */   public void notifyRemapped() {
/*    */     this.state.notifyRemapped();
/*    */   }
/*    */   
/*    */   public boolean shouldRemap() {
/*    */     return this.at.getBoolean("remap", this.state.shouldRemap());
/*    */   }
/*    */   
/*    */   public AnnotationHandle getAt() {
/*    */     return this.at;
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\AnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */