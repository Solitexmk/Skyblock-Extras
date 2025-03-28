/* 1 */ package org.spongepowered.asm.mixin.transformer.throwables;public class InvalidInterfaceMixinException extends InvalidMixinException { public InvalidInterfaceMixinException(IMixinInfo paramIMixinInfo, String paramString, Throwable paramThrowable) { super(paramIMixinInfo, paramString, paramThrowable); } private static final long serialVersionUID = 2L; public InvalidInterfaceMixinException(IMixinContext paramIMixinContext, Throwable paramThrowable) {
/* 2 */     super(paramIMixinContext, paramThrowable);
/*   */   }
/*   */   
/* 5 */   public InvalidInterfaceMixinException(IMixinInfo paramIMixinInfo, String paramString) { super(paramIMixinInfo, paramString); } public InvalidInterfaceMixinException(IMixinContext paramIMixinContext, String paramString, Throwable paramThrowable) {
/* 6 */     super(paramIMixinContext, paramString, paramThrowable);
/*   */   }
/* 8 */   public InvalidInterfaceMixinException(IMixinContext paramIMixinContext, String paramString) { super(paramIMixinContext, paramString); } public InvalidInterfaceMixinException(IMixinInfo paramIMixinInfo, Throwable paramThrowable) {
/* 9 */     super(paramIMixinInfo, paramThrowable);
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\throwables\InvalidInterfaceMixinException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */