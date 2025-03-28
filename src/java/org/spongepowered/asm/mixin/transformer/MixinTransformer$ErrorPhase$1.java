/*   */ package org.spongepowered.asm.mixin.transformer;enum MixinTransformer$ErrorPhase$1 { IMixinErrorHandler.ErrorAction onError(IMixinErrorHandler paramIMixinErrorHandler, String paramString, InvalidMixinException paramInvalidMixinException, IMixinInfo paramIMixinInfo, IMixinErrorHandler.ErrorAction paramErrorAction) { 
/* 2 */     try { return paramIMixinErrorHandler.onPrepareError(paramIMixinInfo.getConfig(), (Throwable)paramInvalidMixinException, paramIMixinInfo, paramErrorAction); }
/*   */     
/* 4 */     catch (AbstractMethodError abstractMethodError) { return paramErrorAction; }
/* 5 */      } protected String getContext(IMixinInfo paramIMixinInfo, String paramString) { return String.format("preparing %s in %s", new Object[] { paramIMixinInfo.getName(), paramString }); }
/*   */    }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MixinTransformer$ErrorPhase$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */