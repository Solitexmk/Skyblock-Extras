/*   */ package org.spongepowered.asm.mixin.injection.struct;
/* 2 */ public class ModifyArgsInjectionInfo extends InjectionInfo { protected Injector parseInjector(AnnotationNode paramAnnotationNode) { return (Injector)new ModifyArgsInjector(this); }
/* 3 */   public ModifyArgsInjectionInfo(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode, AnnotationNode paramAnnotationNode) { super(paramMixinTargetContext, paramMethodNode, paramAnnotationNode); } protected String getDescription() {
/* 4 */     return "Multi-argument modifier method";
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\struct\ModifyArgsInjectionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */