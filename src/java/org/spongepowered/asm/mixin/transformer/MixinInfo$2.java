/*   */ package org.spongepowered.asm.mixin.transformer;class MixinInfo$2 implements Function<String, String> { public String apply(String paramString) {
/* 2 */     return MixinInfo.this.getParent().remapClassName(MixinInfo.this.getClassRef(), paramString);
/*   */   }
/*   */   
/*   */   final MixinInfo this$0; }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MixinInfo$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */