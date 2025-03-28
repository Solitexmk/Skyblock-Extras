/*   */ package org.spongepowered.asm.mixin.throwables;
/* 2 */ public class ClassAlreadyLoadedException extends MixinException { public ClassAlreadyLoadedException(String paramString, Throwable paramThrowable) { super(paramString, paramThrowable); } private static final long serialVersionUID = 1L; public ClassAlreadyLoadedException(String paramString) {
/* 3 */     super(paramString);
/*   */   } public ClassAlreadyLoadedException(Throwable paramThrowable) {
/* 5 */     super(paramThrowable);
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\throwables\ClassAlreadyLoadedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */