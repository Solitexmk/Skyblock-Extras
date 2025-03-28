/*    */ package org.spongepowered.tools.obfuscation;class AnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor extends AnnotatedMixinElementHandler$AnnotatedElement<ExecutableElement> { private final boolean shouldRemap; public String toString() { try {  }
/*  2 */     catch (RuntimeException runtimeException) { throw b(null); }  return (this.targetName != null) ? this.targetName : "<invalid>"; } private final TypeMirror returnType; private String targetName; public String getAnnotationValue() {
/*  3 */     return (String)getAnnotation().getValue(); } public AccessorInfo.AccessorType getAccessorType() { try {  }
/*  4 */     catch (RuntimeException runtimeException) { throw b(null); }  return (this.returnType.getKind() == TypeKind.VOID) ? AccessorInfo.AccessorType.FIELD_SETTER : AccessorInfo.AccessorType.FIELD_GETTER; }
/*  5 */   public String getTargetTypeName() { return TypeUtils.getTypeName(getTargetType()); }
/*  6 */   public String getTargetName() { return this.targetName; } public TypeMirror getTargetType() { 
/*  7 */     try { switch (AnnotatedMixinElementHandlerAccessor$1.$SwitchMap$org$spongepowered$asm$mixin$gen$AccessorInfo$AccessorType[getAccessorType().ordinal()])
/*    */       
/*    */       { 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/*    */         case 1:
/* 15 */           return this.returnType;case 2: return ((VariableElement)getElement().getParameters().get(0)).asType(); }  } catch (RuntimeException runtimeException) { throw b(null); }  return null; } public String getAccessorDesc() { return TypeUtils.getInternalName(getTargetType()); } public MemberInfo getContext() { return new MemberInfo(getTargetName(), null, getAccessorDesc()); }
/*    */   public void setTargetName(String paramString) { this.targetName = paramString; }
/* 17 */   public boolean shouldRemap() { return this.shouldRemap; } public AnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor(ExecutableElement paramExecutableElement, AnnotationHandle paramAnnotationHandle, boolean paramBoolean) {
/* 18 */     super(paramExecutableElement, paramAnnotationHandle);
/*    */     this.shouldRemap = paramBoolean;
/*    */     this.returnType = getElement().getReturnType();
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\AnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */