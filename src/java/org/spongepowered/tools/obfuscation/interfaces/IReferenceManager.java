package org.spongepowered.tools.obfuscation.interfaces;

import org.spongepowered.asm.mixin.injection.struct.MemberInfo;
import org.spongepowered.asm.mixin.refmap.ReferenceMapper;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.ObfuscationData;

public interface IReferenceManager {
  void setAllowConflicts(boolean paramBoolean);
  
  boolean getAllowConflicts();
  
  void write();
  
  ReferenceMapper getMapper();
  
  void addMethodMapping(String paramString1, String paramString2, ObfuscationData<MappingMethod> paramObfuscationData);
  
  void addMethodMapping(String paramString1, String paramString2, MemberInfo paramMemberInfo, ObfuscationData<MappingMethod> paramObfuscationData);
  
  void addFieldMapping(String paramString1, String paramString2, MemberInfo paramMemberInfo, ObfuscationData<MappingField> paramObfuscationData);
  
  void addClassMapping(String paramString1, String paramString2, ObfuscationData<String> paramObfuscationData);
}


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\interfaces\IReferenceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */