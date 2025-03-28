package org.spongepowered.asm.service;

public interface ILegacyClassTransformer extends ITransformer {
  String getName();
  
  boolean isDelegationExcluded();
  
  byte[] transformClassBytes(String paramString1, String paramString2, byte[] paramArrayOfbyte);
}


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\service\ILegacyClassTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */