/* 1 */ package org.spongepowered.asm.mixin.transformer.throwables;public class MixinReloadException extends MixinException { private static final long serialVersionUID = 2L; public IMixinInfo getMixinInfo() { return this.mixinInfo; } private final IMixinInfo mixinInfo; public MixinReloadException(IMixinInfo paramIMixinInfo, String paramString) {
/* 2 */     super(paramString);
/*   */     
/* 4 */     this.mixinInfo = paramIMixinInfo;
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\throwables\MixinReloadException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */