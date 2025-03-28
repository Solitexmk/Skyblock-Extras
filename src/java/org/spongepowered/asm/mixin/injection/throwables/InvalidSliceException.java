/*  1 */ package org.spongepowered.asm.mixin.injection.throwables;public class InvalidSliceException extends InvalidInjectionException { public InvalidSliceException(IMixinContext paramIMixinContext, String paramString, Throwable paramThrowable) { super(paramIMixinContext, paramString, paramThrowable); } private static final long serialVersionUID = 1L; public InvalidSliceException(ISliceContext paramISliceContext, String paramString, Throwable paramThrowable) {
/*  2 */     super(paramISliceContext.getContext(), paramString, paramThrowable);
/*    */   } public InvalidSliceException(ISliceContext paramISliceContext, Throwable paramThrowable) {
/*  4 */     super(paramISliceContext.getContext(), paramThrowable);
/*    */   }
/*    */   
/*    */   public InvalidSliceException(IMixinContext paramIMixinContext, Throwable paramThrowable)
/*    */   {
/*  9 */     super(paramIMixinContext, paramThrowable); } public InvalidSliceException(ISliceContext paramISliceContext, String paramString) {
/* 10 */     super(paramISliceContext.getContext(), paramString);
/*    */   } public InvalidSliceException(IMixinContext paramIMixinContext, String paramString) {
/* 12 */     super(paramIMixinContext, paramString);
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\throwables\InvalidSliceException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */