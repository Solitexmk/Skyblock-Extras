/*    */ package org.spongepowered.asm.mixin.struct;
/*  2 */ public abstract class SpecialMethodInfo implements IInjectionPointContext { protected final AnnotationNode annotation; protected final ClassNode classNode; public SpecialMethodInfo(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode, AnnotationNode paramAnnotationNode) { this.mixin = paramMixinTargetContext;
/*    */ 
/*    */     
/*    */     this.method = paramMethodNode;
/*    */     
/*  7 */     this.annotation = paramAnnotationNode; this.classNode = paramMixinTargetContext.getTargetClassNode(); }
/*  8 */   protected final MethodNode method; protected final MixinTargetContext mixin; public final ClassNode getClassNode() { return this.classNode; } public final AnnotationNode getAnnotation() { return this.annotation; } public final IMixinContext getContext() { return (IMixinContext)this.mixin; }
/*    */    public final MethodNode getMethod() {
/* 10 */     return this.method;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\struct\SpecialMethodInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */