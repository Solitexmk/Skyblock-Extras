/* 1 */ package org.spongepowered.tools.obfuscation;class AnnotatedMixinElementHandlerShadow$AnnotatedElementShadowMethod extends AnnotatedMixinElementHandlerShadow$AnnotatedElementShadow<ExecutableElement, MappingMethod> { public AnnotatedMixinElementHandlerShadow$AnnotatedElementShadowMethod(ExecutableElement paramExecutableElement, AnnotationHandle paramAnnotationHandle, boolean paramBoolean) { super(paramExecutableElement, paramAnnotationHandle, paramBoolean, IMapping.Type.METHOD); }
/*   */   
/*   */   final AnnotatedMixinElementHandlerShadow this$0;
/*   */   public MappingMethod getMapping(TypeHandle paramTypeHandle, String paramString1, String paramString2) {
/* 5 */     return paramTypeHandle.getMappingMethod(paramString1, paramString2); } public void addMapping(ObfuscationType paramObfuscationType, IMapping<?> paramIMapping) {
/* 6 */     AnnotatedMixinElementHandlerShadow.this.addMethodMapping(paramObfuscationType, setObfuscatedName(paramIMapping), getDesc(), paramIMapping.getDesc());
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\AnnotatedMixinElementHandlerShadow$AnnotatedElementShadowMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */