/* 1 */ package org.spongepowered.asm.mixin.transformer;enum MixinTransformer$ErrorPhase$2 { IMixinErrorHandler.ErrorAction onError(IMixinErrorHandler paramIMixinErrorHandler, String paramString, InvalidMixinException paramInvalidMixinException, IMixinInfo paramIMixinInfo, IMixinErrorHandler.ErrorAction paramErrorAction) { try { return paramIMixinErrorHandler.onApplyError(paramString, (Throwable)paramInvalidMixinException, paramIMixinInfo, paramErrorAction); }
/* 2 */     catch (AbstractMethodError abstractMethodError)
/* 3 */     { return paramErrorAction; }
/* 4 */      } protected String getContext(IMixinInfo paramIMixinInfo, String paramString) { return String.format("%s -> %s", new Object[] { paramIMixinInfo, paramString }); }
/*   */    }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MixinTransformer$ErrorPhase$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */