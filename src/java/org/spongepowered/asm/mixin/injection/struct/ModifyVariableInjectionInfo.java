/* 1 */ package org.spongepowered.asm.mixin.injection.struct;public class ModifyVariableInjectionInfo extends InjectionInfo { public ModifyVariableInjectionInfo(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode, AnnotationNode paramAnnotationNode) { super(paramMixinTargetContext, paramMethodNode, paramAnnotationNode); }
/*   */   
/* 3 */   protected String getDescription() { return "Variable modifier method"; } protected Injector parseInjector(AnnotationNode paramAnnotationNode) {
/* 4 */     return (Injector)new ModifyVariableInjector(this, LocalVariableDiscriminator.parse(paramAnnotationNode));
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\struct\ModifyVariableInjectionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */