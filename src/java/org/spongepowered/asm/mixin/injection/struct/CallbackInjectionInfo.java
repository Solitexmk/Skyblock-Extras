/* 1 */ package org.spongepowered.asm.mixin.injection.struct;public class CallbackInjectionInfo extends InjectionInfo { protected CallbackInjectionInfo(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode, AnnotationNode paramAnnotationNode) { super(paramMixinTargetContext, paramMethodNode, paramAnnotationNode); }
/*   */ 
/*   */   
/*   */   protected Injector parseInjector(AnnotationNode paramAnnotationNode) {
/* 5 */     boolean bool = ((Boolean)Annotations.getValue(paramAnnotationNode, "cancellable", Boolean.FALSE)).booleanValue();
/*   */     LocalCapture localCapture = (LocalCapture)Annotations.getValue(paramAnnotationNode, "locals", LocalCapture.class, (Enum)LocalCapture.NO_CAPTURE);
/* 7 */     String str = (String)Annotations.getValue(paramAnnotationNode, "id", "");
/*   */     return (Injector)new CallbackInjector(this, bool, localCapture, str);
/*   */   }
/*   */   
/*   */   public String getSliceId(String paramString) {
/*   */     return Strings.nullToEmpty(paramString);
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\struct\CallbackInjectionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */