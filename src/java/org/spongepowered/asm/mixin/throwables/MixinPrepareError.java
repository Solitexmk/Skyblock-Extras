/* 1 */ package org.spongepowered.asm.mixin.throwables;public class MixinPrepareError extends Error { public MixinPrepareError(String paramString, Throwable paramThrowable) { super(paramString, paramThrowable); } private static final long serialVersionUID = 1L; public MixinPrepareError(Throwable paramThrowable) {
/* 2 */     super(paramThrowable);
/*   */   } public MixinPrepareError(String paramString) {
/* 4 */     super(paramString);
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\throwables\MixinPrepareError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */