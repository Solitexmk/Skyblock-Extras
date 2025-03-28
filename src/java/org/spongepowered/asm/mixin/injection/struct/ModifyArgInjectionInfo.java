/* 1 */ package org.spongepowered.asm.mixin.injection.struct;public class ModifyArgInjectionInfo extends InjectionInfo { protected Injector parseInjector(AnnotationNode paramAnnotationNode) { int i = ((Integer)Annotations.getValue(paramAnnotationNode, "index", Integer.valueOf(-1))).intValue();
/*   */ 
/*   */ 
/*   */     
/* 5 */     return (Injector)new ModifyArgInjector(this, i); }
/*   */ 
/*   */   
/*   */   public ModifyArgInjectionInfo(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode, AnnotationNode paramAnnotationNode) {
/*   */     super(paramMixinTargetContext, paramMethodNode, paramAnnotationNode);
/*   */   }
/*   */   
/*   */   protected String getDescription() {
/*   */     return "Argument modifier method";
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\struct\ModifyArgInjectionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */