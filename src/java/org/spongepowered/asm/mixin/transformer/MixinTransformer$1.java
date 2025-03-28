/*   */ package org.spongepowered.asm.mixin.transformer;class MixinTransformer$1 implements MixinConfig$IListener { public void onPrepare(MixinInfo paramMixinInfo) {
/* 2 */     hotSwapper.registerMixinClass(paramMixinInfo.getClassName());
/*   */   }
/*   */   
/*   */   final IHotSwap val$hotSwapper;
/*   */   final MixinTransformer this$0;
/*   */   
/*   */   public void onInit(MixinInfo paramMixinInfo) {} }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MixinTransformer$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */