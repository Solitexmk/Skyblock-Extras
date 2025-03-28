/* 1 */ package org.spongepowered.asm.mixin.gen;public class InvokerInfo extends AccessorInfo { private MethodNode findTargetMethod() { return findTarget(this.classNode.methods); }
/* 2 */   protected MemberInfo initTarget() { return new MemberInfo(getTargetName(), null, this.method.desc); } public InvokerInfo(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode) {
/* 3 */     super(paramMixinTargetContext, paramMethodNode, (Class)Invoker.class);
/*   */   }
/*   */   
/* 6 */   public void locate() { this.targetMethod = findTargetMethod(); }
/* 7 */   protected Type initTargetFieldType() { return null; } protected AccessorInfo$AccessorType initType() {
/* 8 */     return AccessorInfo$AccessorType.METHOD_PROXY;
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\gen\InvokerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */