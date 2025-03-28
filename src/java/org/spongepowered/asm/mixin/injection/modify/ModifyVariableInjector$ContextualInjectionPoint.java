/*   */ package org.spongepowered.asm.mixin.injection.modify;abstract class ModifyVariableInjector$ContextualInjectionPoint extends InjectionPoint {
/*   */   public boolean find(String paramString, InsnList paramInsnList, Collection<AbstractInsnNode> paramCollection) {
/* 3 */     throw new InvalidInjectionException(this.context, getAtCode() + " injection point must be used in conjunction with @ModifyVariable");
/*   */   }
/*   */   
/*   */   protected final IMixinContext context;
/*   */   
/*   */   abstract boolean find(Target paramTarget, Collection<AbstractInsnNode> paramCollection);
/*   */   
/*   */   ModifyVariableInjector$ContextualInjectionPoint(IMixinContext paramIMixinContext) {
/*   */     this.context = paramIMixinContext;
/*   */   }
/*   */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\modify\ModifyVariableInjector$ContextualInjectionPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */