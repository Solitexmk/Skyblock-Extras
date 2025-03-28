/* 1 */ package org.spongepowered.asm.mixin.injection.callback;public class CancellationException extends RuntimeException { public CancellationException(String paramString, Throwable paramThrowable) { super(paramString, paramThrowable); }
/*   */    private static final long serialVersionUID = 1L;
/*   */   public CancellationException(Throwable paramThrowable) {
/* 4 */     super(paramThrowable); } public CancellationException(String paramString) {
/* 5 */     super(paramString);
/*   */   }
/*   */   
/*   */   public CancellationException() {} }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\callback\CancellationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */