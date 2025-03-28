/* 1 */ package org.spongepowered.asm.mixin.transformer.throwables;public class MixinTargetAlreadyLoadedException extends InvalidMixinException { private static final long serialVersionUID = 1L; public String getTarget() { return this.target; }
/*   */   
/*   */   private final String target;
/*   */   public MixinTargetAlreadyLoadedException(IMixinInfo paramIMixinInfo, String paramString1, String paramString2) {
/* 5 */     super(paramIMixinInfo, paramString1);
/* 6 */     this.target = paramString2; } public MixinTargetAlreadyLoadedException(IMixinInfo paramIMixinInfo, String paramString1, String paramString2, Throwable paramThrowable) {
/* 7 */     super(paramIMixinInfo, paramString1, paramThrowable);
/*   */     this.target = paramString2;
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\throwables\MixinTargetAlreadyLoadedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */