/*    */ package org.spongepowered.asm.mixin.injection.throwables;
/*    */ public class InvalidInjectionException extends InvalidMixinException { private static final long serialVersionUID = 2L;
/*    */   
/*  4 */   public InvalidInjectionException(InjectionInfo paramInjectionInfo, String paramString) { super(paramInjectionInfo.getContext(), paramString);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 12 */     this.info = paramInjectionInfo; } private final InjectionInfo info; public InvalidInjectionException(IMixinContext paramIMixinContext, String paramString) { super(paramIMixinContext, paramString);
/* 13 */     this.info = null; }
/*    */ 
/*    */   
/*    */   public InvalidInjectionException(InjectionInfo paramInjectionInfo, Throwable paramThrowable) {
/*    */     super(paramInjectionInfo.getContext(), paramThrowable);
/* 18 */     this.info = paramInjectionInfo;
/* 19 */   } public InjectionInfo getInjectionInfo() { return this.info; } public InvalidInjectionException(IMixinContext paramIMixinContext, Throwable paramThrowable) { super(paramIMixinContext, paramThrowable); this.info = null; }
/*    */ 
/*    */   
/*    */   public InvalidInjectionException(IMixinContext paramIMixinContext, String paramString, Throwable paramThrowable) {
/*    */     super(paramIMixinContext, paramString, paramThrowable);
/*    */     this.info = null;
/*    */   }
/*    */   
/*    */   public InvalidInjectionException(InjectionInfo paramInjectionInfo, String paramString, Throwable paramThrowable) {
/*    */     super(paramInjectionInfo.getContext(), paramString, paramThrowable);
/*    */     this.info = paramInjectionInfo;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\throwables\InvalidInjectionException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */