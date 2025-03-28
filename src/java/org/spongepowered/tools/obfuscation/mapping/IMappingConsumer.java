package org.spongepowered.tools.obfuscation.mapping;

import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.ObfuscationType;

public interface IMappingConsumer {
  void clear();
  
  void addFieldMapping(ObfuscationType paramObfuscationType, MappingField paramMappingField1, MappingField paramMappingField2);
  
  void addMethodMapping(ObfuscationType paramObfuscationType, MappingMethod paramMappingMethod1, MappingMethod paramMappingMethod2);
  
  IMappingConsumer$MappingSet<MappingField> getFieldMappings(ObfuscationType paramObfuscationType);
  
  IMappingConsumer$MappingSet<MappingMethod> getMethodMappings(ObfuscationType paramObfuscationType);
}


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\mapping\IMappingConsumer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */