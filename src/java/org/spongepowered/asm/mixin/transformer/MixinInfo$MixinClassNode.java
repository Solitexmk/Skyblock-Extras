/*    */ package org.spongepowered.asm.mixin.transformer;
/*    */ class MixinInfo$MixinClassNode extends ClassNode {
/*  3 */   public MethodVisitor visitMethod(int paramInt, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString) { MixinInfo$MixinMethodNode mixinInfo$MixinMethodNode = new MixinInfo$MixinMethodNode(MixinInfo.this, paramInt, paramString1, paramString2, paramString3, paramArrayOfString); this.methods.add(mixinInfo$MixinMethodNode);
/*  4 */     return (MethodVisitor)mixinInfo$MixinMethodNode; } public MixinInfo$MixinClassNode(MixinInfo paramMixinInfo1, MixinInfo paramMixinInfo2) { this(327680); }
/*    */ 
/*    */ 
/*    */   
/*  8 */   public final List<MixinInfo$MixinMethodNode> mixinMethods = this.methods;
/*  9 */   final MixinInfo this$0; public MixinInfo getMixin() { return MixinInfo.this; } public MixinInfo$MixinClassNode(int paramInt) {
/* 10 */     super(paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MixinInfo$MixinClassNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */