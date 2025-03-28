/*   */ package org.spongepowered.asm.mixin.injection.invoke;
/*   */ class RedirectInjector$RedirectedInvoke {
/*   */   RedirectInjector$RedirectedInvoke(Target paramTarget, MethodInsnNode paramMethodInsnNode) {
/* 4 */     this.target = paramTarget;
/*   */     
/*   */     this.node = paramMethodInsnNode;
/* 7 */     this.returnType = Type.getReturnType(paramMethodInsnNode.desc);
/*   */     this.args = Type.getArgumentTypes(paramMethodInsnNode.desc);
/* 9 */     this.locals = (paramMethodInsnNode.getOpcode() == 184) ? this.args : (Type[])ObjectArrays.concat(Type.getType("L" + paramMethodInsnNode.owner + ";"), (Object[])this.args);
/*   */   }
/*   */   
/*   */   final Target target;
/*   */   final MethodInsnNode node;
/*   */   final Type returnType;
/*   */   final Type[] args;
/*   */   final Type[] locals;
/*   */   boolean captureTargetArgs = false;
/*   */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\invoke\RedirectInjector$RedirectedInvoke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */