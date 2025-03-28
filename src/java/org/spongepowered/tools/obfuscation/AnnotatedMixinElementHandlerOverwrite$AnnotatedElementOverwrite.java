/* 1 */ package org.spongepowered.tools.obfuscation;class AnnotatedMixinElementHandlerOverwrite$AnnotatedElementOverwrite extends AnnotatedMixinElementHandler$AnnotatedElement<ExecutableElement> { public boolean shouldRemap() { return this.shouldRemap; }
/*   */    private final boolean shouldRemap;
/*   */   public AnnotatedMixinElementHandlerOverwrite$AnnotatedElementOverwrite(ExecutableElement paramExecutableElement, AnnotationHandle paramAnnotationHandle, boolean paramBoolean) {
/* 4 */     super(paramExecutableElement, paramAnnotationHandle);
/*   */     this.shouldRemap = paramBoolean;
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\AnnotatedMixinElementHandlerOverwrite$AnnotatedElementOverwrite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */