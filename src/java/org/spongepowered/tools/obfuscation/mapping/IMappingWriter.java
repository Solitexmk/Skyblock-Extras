package org.spongepowered.tools.obfuscation.mapping;

import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.ObfuscationType;

public interface IMappingWriter {
  void write(String paramString, ObfuscationType paramObfuscationType, IMappingConsumer$MappingSet<MappingField> paramIMappingConsumer$MappingSet, IMappingConsumer$MappingSet<MappingMethod> paramIMappingConsumer$MappingSet1);
}


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\mapping\IMappingWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */