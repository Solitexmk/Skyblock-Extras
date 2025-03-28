/* 1 */ package org.spongepowered.asm.mixin.throwables;public class MixinApplyError extends Error { public MixinApplyError(Throwable paramThrowable) { super(paramThrowable); }
/*   */    private static final long serialVersionUID = 1L; public MixinApplyError(String paramString, Throwable paramThrowable) {
/* 3 */     super(paramString, paramThrowable); } public MixinApplyError(String paramString) {
/* 4 */     super(paramString);
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\throwables\MixinApplyError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */