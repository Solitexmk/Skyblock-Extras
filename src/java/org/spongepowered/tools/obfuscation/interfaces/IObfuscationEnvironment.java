package org.spongepowered.tools.obfuscation.interfaces;

import java.util.Collection;
import org.spongepowered.asm.mixin.injection.struct.MemberInfo;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.mapping.IMappingConsumer;

public interface IObfuscationEnvironment {
  MappingMethod getObfMethod(MemberInfo paramMemberInfo);
  
  MappingMethod getObfMethod(MappingMethod paramMappingMethod);
  
  MappingMethod getObfMethod(MappingMethod paramMappingMethod, boolean paramBoolean);
  
  MappingField getObfField(MemberInfo paramMemberInfo);
  
  MappingField getObfField(MappingField paramMappingField);
  
  MappingField getObfField(MappingField paramMappingField, boolean paramBoolean);
  
  String getObfClass(String paramString);
  
  MemberInfo remapDescriptor(MemberInfo paramMemberInfo);
  
  String remapDescriptor(String paramString);
  
  void writeMappings(Collection<IMappingConsumer> paramCollection);
}


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\interfaces\IObfuscationEnvironment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */