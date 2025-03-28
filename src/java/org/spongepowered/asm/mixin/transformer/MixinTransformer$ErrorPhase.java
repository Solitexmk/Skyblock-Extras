/*    */ package org.spongepowered.asm.mixin.transformer;
/*    */ 
/*    */ enum MixinTransformer$ErrorPhase {
/*  4 */   PREPARE,
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 11 */   APPLY;
/*    */   private final String text = name().toLowerCase();
/*    */   private static final MixinTransformer$ErrorPhase[] $VALUES = new MixinTransformer$ErrorPhase[] { PREPARE, APPLY };
/*    */   
/*    */   public String getErrorMessage(IMixinInfo paramIMixinInfo, IMixinConfig paramIMixinConfig, MixinEnvironment.Phase paramPhase) {
/*    */     return String.format("Mixin [%s] from phase [%s] in config [%s] FAILED during %s", new Object[] { paramIMixinInfo, paramPhase, paramIMixinConfig, name() });
/*    */   }
/*    */   
/*    */   public String getLogMessage(String paramString, InvalidMixinException paramInvalidMixinException, IMixinInfo paramIMixinInfo) {
/*    */     return String.format("Mixin %s failed %s: %s %s", new Object[] { this.text, getContext(paramIMixinInfo, paramString), paramInvalidMixinException.getClass().getName(), paramInvalidMixinException.getMessage() });
/*    */   }
/*    */   
/*    */   abstract IMixinErrorHandler.ErrorAction onError(IMixinErrorHandler paramIMixinErrorHandler, String paramString, InvalidMixinException paramInvalidMixinException, IMixinInfo paramIMixinInfo, IMixinErrorHandler.ErrorAction paramErrorAction);
/*    */   
/*    */   protected abstract String getContext(IMixinInfo paramIMixinInfo, String paramString);
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MixinTransformer$ErrorPhase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */