package org.spongepowered.tools.obfuscation.interfaces;

import org.spongepowered.asm.mixin.injection.struct.MemberInfo;
import org.spongepowered.asm.obfuscation.mapping.IMapping;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.ObfuscationData;
import org.spongepowered.tools.obfuscation.mirror.TypeHandle;

public interface IObfuscationDataProvider {
  <T> ObfuscationData<T> getObfEntryRecursive(MemberInfo paramMemberInfo);
  
  <T> ObfuscationData<T> getObfEntry(MemberInfo paramMemberInfo);
  
  <T> ObfuscationData<T> getObfEntry(IMapping<T> paramIMapping);
  
  ObfuscationData<MappingMethod> getObfMethodRecursive(MemberInfo paramMemberInfo);
  
  ObfuscationData<MappingMethod> getObfMethod(MemberInfo paramMemberInfo);
  
  ObfuscationData<MappingMethod> getRemappedMethod(MemberInfo paramMemberInfo);
  
  ObfuscationData<MappingMethod> getObfMethod(MappingMethod paramMappingMethod);
  
  ObfuscationData<MappingMethod> getRemappedMethod(MappingMethod paramMappingMethod);
  
  ObfuscationData<MappingField> getObfFieldRecursive(MemberInfo paramMemberInfo);
  
  ObfuscationData<MappingField> getObfField(MemberInfo paramMemberInfo);
  
  ObfuscationData<MappingField> getObfField(MappingField paramMappingField);
  
  ObfuscationData<String> getObfClass(TypeHandle paramTypeHandle);
  
  ObfuscationData<String> getObfClass(String paramString);
}


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\interfaces\IObfuscationDataProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */