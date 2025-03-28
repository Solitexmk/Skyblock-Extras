package org.spongepowered.asm.obfuscation.mapping;

public interface IMapping<TMapping> {
  IMapping$Type getType();
  
  TMapping move(String paramString);
  
  TMapping remap(String paramString);
  
  TMapping transform(String paramString);
  
  TMapping copy();
  
  String getName();
  
  String getSimpleName();
  
  String getOwner();
  
  String getDesc();
  
  TMapping getSuper();
  
  String serialise();
}


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\obfuscation\mapping\IMapping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */