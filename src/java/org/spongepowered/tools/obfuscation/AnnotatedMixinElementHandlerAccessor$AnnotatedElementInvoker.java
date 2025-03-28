/* 1 */ package org.spongepowered.tools.obfuscation;class AnnotatedMixinElementHandlerAccessor$AnnotatedElementInvoker extends AnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor { public AnnotatedMixinElementHandlerAccessor$AnnotatedElementInvoker(ExecutableElement paramExecutableElement, AnnotationHandle paramAnnotationHandle, boolean paramBoolean) { super(paramExecutableElement, paramAnnotationHandle, paramBoolean); } public AccessorInfo.AccessorType getAccessorType() {
/* 2 */     return AccessorInfo.AccessorType.METHOD_PROXY;
/*   */   }
/* 4 */   public String getTargetTypeName() { return TypeUtils.getJavaSignature(getElement()); } public String getAccessorDesc() {
/* 5 */     return TypeUtils.getDescriptor(getElement());
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\AnnotatedMixinElementHandlerAccessor$AnnotatedElementInvoker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */