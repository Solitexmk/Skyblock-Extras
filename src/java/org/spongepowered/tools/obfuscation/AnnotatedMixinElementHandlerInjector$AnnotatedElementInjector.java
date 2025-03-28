/*  1 */ package org.spongepowered.tools.obfuscation;class AnnotatedMixinElementHandlerInjector$AnnotatedElementInjector extends AnnotatedMixinElementHandler$AnnotatedElement<ExecutableElement> { public AnnotatedMixinElementHandlerInjector$AnnotatedElementInjector(ExecutableElement paramExecutableElement, AnnotationHandle paramAnnotationHandle, InjectorRemap paramInjectorRemap) { super(paramExecutableElement, paramAnnotationHandle);
/*    */     
/*  3 */     this.state = paramInjectorRemap; }
/*  4 */   private final InjectorRemap state; public String toString() { return getAnnotation().toString(); } public boolean hasCoerceArgument() { try { if (!this.annotation.toString().equals("@Inject"))
/*  5 */         return false;  } catch (RuntimeException runtimeException) { throw b(null); }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 12 */     Iterator<? extends VariableElement> iterator = this.element.getParameters().iterator(); if (iterator.hasNext()) { VariableElement variableElement = iterator.next();
/*    */       return AnnotationHandle.of(variableElement, Coerce.class).exists(); }
/*    */     
/*    */     return false; }
/*    */ 
/*    */   
/*    */   public void addMessage(Diagnostic.Kind paramKind, CharSequence paramCharSequence, Element paramElement, AnnotationHandle paramAnnotationHandle) {
/*    */     this.state.addMessage(paramKind, paramCharSequence, paramElement, paramAnnotationHandle);
/*    */   }
/*    */   
/*    */   public boolean shouldRemap() {
/*    */     return this.state.shouldRemap();
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\AnnotatedMixinElementHandlerInjector$AnnotatedElementInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */