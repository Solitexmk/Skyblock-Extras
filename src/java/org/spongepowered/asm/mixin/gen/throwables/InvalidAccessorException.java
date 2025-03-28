/*  1 */ package org.spongepowered.asm.mixin.gen.throwables;public class InvalidAccessorException extends InvalidMixinException { private static final long serialVersionUID = 2L; private final AccessorInfo info; public InvalidAccessorException(AccessorInfo paramAccessorInfo, String paramString, Throwable paramThrowable) { super(paramAccessorInfo.getContext(), paramString, paramThrowable);
/*  2 */     this.info = paramAccessorInfo; }
/*    */   public InvalidAccessorException(AccessorInfo paramAccessorInfo, String paramString) { super(paramAccessorInfo.getContext(), paramString);
/*  4 */     this.info = paramAccessorInfo; } public InvalidAccessorException(IMixinContext paramIMixinContext, String paramString) { super(paramIMixinContext, paramString);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 14 */     this.info = null; }
/* 15 */   public InvalidAccessorException(AccessorInfo paramAccessorInfo, Throwable paramThrowable) { super(paramAccessorInfo.getContext(), paramThrowable); this.info = paramAccessorInfo; } public AccessorInfo getAccessorInfo() { return this.info; } public InvalidAccessorException(IMixinContext paramIMixinContext, String paramString, Throwable paramThrowable) {
/* 16 */     super(paramIMixinContext, paramString, paramThrowable);
/*    */     this.info = null;
/*    */   } public InvalidAccessorException(IMixinContext paramIMixinContext, Throwable paramThrowable) {
/* 19 */     super(paramIMixinContext, paramThrowable);
/*    */     this.info = null;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\gen\throwables\InvalidAccessorException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */