/*  1 */ package org.spongepowered.asm.mixin.transformer.throwables;public class InvalidMixinException extends MixinException { private static final long serialVersionUID = 2L; public InvalidMixinException(IMixinContext paramIMixinContext, String paramString, Throwable paramThrowable) { super(paramString, paramThrowable);
/*    */ 
/*    */     
/*  4 */     this.mixin = paramIMixinContext.getMixin(); }
/*    */    private final IMixinInfo mixin;
/*    */   public InvalidMixinException(IMixinInfo paramIMixinInfo, String paramString) {
/*  7 */     super(paramString);
/*    */     this.mixin = paramIMixinInfo; } public IMixinInfo getMixin() {
/*  9 */     return this.mixin;
/*    */   }
/* 11 */   public InvalidMixinException(IMixinContext paramIMixinContext, Throwable paramThrowable) { this(paramIMixinContext.getMixin(), paramThrowable); } public InvalidMixinException(IMixinInfo paramIMixinInfo, Throwable paramThrowable) {
/* 12 */     super(paramThrowable);
/*    */     this.mixin = paramIMixinInfo;
/*    */   }
/* 15 */   public InvalidMixinException(IMixinContext paramIMixinContext, String paramString) { this(paramIMixinContext.getMixin(), paramString); } public InvalidMixinException(IMixinInfo paramIMixinInfo, String paramString, Throwable paramThrowable) {
/* 16 */     super(paramString, paramThrowable);
/*    */     this.mixin = paramIMixinInfo;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\throwables\InvalidMixinException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */