/* 1 */ package org.spongepowered.asm.mixin.injection.throwables;public class InvalidInjectionPointException extends InvalidInjectionException { public InvalidInjectionPointException(InjectionInfo paramInjectionInfo, String paramString, Object... paramVarArgs) { super(paramInjectionInfo, String.format(paramString, paramVarArgs)); } private static final long serialVersionUID = 2L; public InvalidInjectionPointException(InjectionInfo paramInjectionInfo, Throwable paramThrowable, String paramString, Object... paramVarArgs) {
/* 2 */     super(paramInjectionInfo, String.format(paramString, paramVarArgs), paramThrowable); } public InvalidInjectionPointException(IMixinContext paramIMixinContext, Throwable paramThrowable, String paramString, Object... paramVarArgs) {
/* 3 */     super(paramIMixinContext, String.format(paramString, paramVarArgs), paramThrowable);
/*   */   }
/*   */ 
/*   */   
/*   */   public InvalidInjectionPointException(IMixinContext paramIMixinContext, String paramString, Object... paramVarArgs) {
/* 8 */     super(paramIMixinContext, String.format(paramString, paramVarArgs));
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\throwables\InvalidInjectionPointException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */