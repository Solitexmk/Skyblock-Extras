/* 1 */ package org.spongepowered.asm.mixin.injection.throwables;public class InjectionError extends Error { public InjectionError(String paramString, Throwable paramThrowable) { super(paramString, paramThrowable); }
/*   */    private static final long serialVersionUID = 1L; public InjectionError() {}
/*   */   public InjectionError(String paramString) {
/* 4 */     super(paramString);
/*   */   } public InjectionError(Throwable paramThrowable) {
/* 6 */     super(paramThrowable);
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\throwables\InjectionError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */