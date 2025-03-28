/* 1 */ package org.spongepowered.asm.mixin.throwables;public class MixinException extends RuntimeException { public MixinException(String paramString) { super(paramString); }
/*   */    private static final long serialVersionUID = 1L;
/*   */   public MixinException(String paramString, Throwable paramThrowable) {
/* 4 */     super(paramString, paramThrowable);
/*   */   }
/*   */   public MixinException(Throwable paramThrowable) {
/* 7 */     super(paramThrowable);
/*   */   }
/*   */   
/*   */   public MixinException() {} }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\throwables\MixinException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */