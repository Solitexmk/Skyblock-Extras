/* 1 */ package org.spongepowered.asm.mixin.transformer.throwables;public class MixinTransformerError extends Error { public MixinTransformerError(String paramString, Throwable paramThrowable) { super(paramString, paramThrowable); } private static final long serialVersionUID = 1L; public MixinTransformerError(Throwable paramThrowable) {
/* 2 */     super(paramThrowable); } public MixinTransformerError(String paramString) {
/* 3 */     super(paramString);
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\throwables\MixinTransformerError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */