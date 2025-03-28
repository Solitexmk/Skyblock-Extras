package org.spongepowered.asm.mixin.transformer.ext;

import org.spongepowered.asm.mixin.MixinEnvironment;

public interface IExtension {
  boolean checkActive(MixinEnvironment paramMixinEnvironment);
  
  void preApply(ITargetClassContext paramITargetClassContext);
  
  void postApply(ITargetClassContext paramITargetClassContext);
  
  void export(MixinEnvironment paramMixinEnvironment, String paramString, boolean paramBoolean, byte[] paramArrayOfbyte);
}


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\ext\IExtension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */