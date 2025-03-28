/*    */ package org.spongepowered.asm.mixin.transformer;class MixinInfo$MixinMethodNode extends MethodNode { private final String originalName; public boolean isInjector() { 
/*  2 */     try { if (getInjectorAnnotation() == null) { try { if (isSurrogate()); } catch (RuntimeException runtimeException) { throw b(null); }  return false; }  } catch (RuntimeException runtimeException) { throw b(null); }
/*    */      } final MixinInfo this$0; public AnnotationNode getInjectorAnnotation() {
/*  4 */     return InjectionInfo.getInjectorAnnotation(MixinInfo.this, this); } public boolean isSurrogate() { try {  }
/*  5 */     catch (RuntimeException runtimeException) { throw b(null); }  return (getVisibleAnnotation((Class)Surrogate.class) != null); }
/*    */   
/*  7 */   public String toString() { return String.format("%s%s", new Object[] { this.originalName, this.desc }); }
/*  8 */   public boolean isSynthetic() { return Bytecode.hasFlag(this, 4096); }
/*  9 */   public IMixinInfo getOwner() { return MixinInfo.this; }
/* 10 */   public String getOriginalName() { return this.originalName; } public MixinInfo$MixinMethodNode(int paramInt, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString) { super(327680, paramInt, paramString1, paramString2, paramString3, paramArrayOfString);
/*    */     this.originalName = paramString1; }
/* 12 */   public AnnotationNode getVisibleAnnotation(Class<? extends Annotation> paramClass) { return Annotations.getVisible(this, paramClass); }
/*    */ 
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MixinInfo$MixinMethodNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */