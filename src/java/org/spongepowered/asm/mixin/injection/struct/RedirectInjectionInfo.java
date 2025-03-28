/* 1 */ package org.spongepowered.asm.mixin.injection.struct;public class RedirectInjectionInfo extends InjectionInfo { protected Injector parseInjector(AnnotationNode paramAnnotationNode) { return (Injector)new RedirectInjector(this); } protected String getDescription() {
/* 2 */     return "Redirector";
/*   */   } public RedirectInjectionInfo(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode, AnnotationNode paramAnnotationNode) {
/* 4 */     super(paramMixinTargetContext, paramMethodNode, paramAnnotationNode);
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\struct\RedirectInjectionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */