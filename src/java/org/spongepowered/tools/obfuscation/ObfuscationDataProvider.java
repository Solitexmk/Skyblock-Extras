/*    */ package org.spongepowered.tools.obfuscation;
/*    */ public class ObfuscationDataProvider implements IObfuscationDataProvider {
/*    */   private final IMixinAnnotationProcessor ap;
/*    */   
/*  5 */   public ObfuscationData<MappingMethod> getObfMethodRecursive(MemberInfo paramMemberInfo) { return getObfEntryRecursive(paramMemberInfo); } private final List<ObfuscationEnvironment> environments; public <T> ObfuscationData<T> getObfEntry(MemberInfo paramMemberInfo) { 
/*  6 */     try { if (paramMemberInfo.isField())
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 76 */         return (ObfuscationData)getObfField(paramMemberInfo); }  } catch (RuntimeException runtimeException) { throw b(null); }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 83 */     return (ObfuscationData)getObfMethod(paramMemberInfo.asMethodMapping()); } public ObfuscationData<MappingField> getObfField(MemberInfo paramMemberInfo) { return getObfField(paramMemberInfo.asFieldMapping()); }
/*    */   public <T> ObfuscationData<T> getObfEntryRecursive(MemberInfo paramMemberInfo) { MemberInfo memberInfo = paramMemberInfo; ObfuscationData<String> obfuscationData = getObfClass(memberInfo.owner); ObfuscationData<?> obfuscationData1 = getObfEntry(memberInfo); try {
/* 85 */       while (obfuscationData1.isEmpty()) { TypeHandle typeHandle = this.ap.getTypeProvider().getTypeHandle(memberInfo.owner); if (typeHandle == null)
/*    */           return (ObfuscationData)obfuscationData1;  }
/*    */     
/*    */     } catch (Exception exception) {
/*    */       exception.printStackTrace(); return getObfEntry(paramMemberInfo);
/*    */     }  return (ObfuscationData)obfuscationData1; } private ObfuscationData<MappingMethod> getRemappedMethod(MemberInfo paramMemberInfo, boolean paramBoolean) { ObfuscationData<MappingMethod> obfuscationData = new ObfuscationData(); for (ObfuscationEnvironment obfuscationEnvironment : this.environments)
/*    */       MappingMethod mappingMethod = obfuscationEnvironment.getObfMethod(paramMemberInfo);  
/* 92 */     try { if (obfuscationData.isEmpty()) try { if (paramBoolean)
/* 93 */             return remapDescriptor(obfuscationData, paramMemberInfo);  return obfuscationData; } catch (RuntimeException runtimeException) { throw b(null); }   } catch (RuntimeException runtimeException) { throw b(null); }  return obfuscationData; }
/*    */ 
/*    */   
/*    */   public ObfuscationData<MappingMethod> getObfMethod(MemberInfo paramMemberInfo) {
/*    */     return getRemappedMethod(paramMemberInfo, paramMemberInfo.isConstructor());
/*    */   }
/*    */   
/*    */   public ObfuscationData<MappingMethod> getObfMethod(MappingMethod paramMappingMethod) {
/*    */     return getRemappedMethod(paramMappingMethod, paramMappingMethod.isConstructor());
/*    */   }
/*    */   
/*    */   private static <T> ObfuscationData<T> applyParents(ObfuscationData<String> paramObfuscationData, ObfuscationData<T> paramObfuscationData1) {
/*    */     for (ObfuscationType obfuscationType : paramObfuscationData1) {
/*    */       String str = paramObfuscationData.get(obfuscationType);
/*    */       T t = paramObfuscationData1.get(obfuscationType);
/*    */       paramObfuscationData1.put(obfuscationType, (T)MemberInfo.fromMapping((IMapping)t).move(str).asMapping());
/*    */     } 
/*    */     return paramObfuscationData1;
/*    */   }
/*    */   
/*    */   public ObfuscationData<MappingField> getObfFieldRecursive(MemberInfo paramMemberInfo) {
/*    */     return getObfEntryRecursive(paramMemberInfo);
/*    */   }
/*    */   
/*    */   public ObfuscationData<String> getObfClass(String paramString) {
/*    */     ObfuscationData<String> obfuscationData = new ObfuscationData<String>(paramString);
/*    */     for (ObfuscationEnvironment obfuscationEnvironment : this.environments) {
/*    */       String str = obfuscationEnvironment.getObfClass(paramString);
/*    */       try {
/*    */         if (str != null)
/*    */           obfuscationData.put(obfuscationEnvironment.getType(), str); 
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } 
/*    */     return obfuscationData;
/*    */   }
/*    */   
/*    */   public ObfuscationDataProvider(IMixinAnnotationProcessor paramIMixinAnnotationProcessor, List<ObfuscationEnvironment> paramList) {
/*    */     this.ap = paramIMixinAnnotationProcessor;
/*    */     this.environments = paramList;
/*    */   }
/*    */   
/*    */   public ObfuscationData<MappingMethod> getRemappedMethod(MappingMethod paramMappingMethod) {
/*    */     return getRemappedMethod(paramMappingMethod, true);
/*    */   }
/*    */   
/*    */   public ObfuscationData<MappingMethod> getRemappedMethod(MemberInfo paramMemberInfo) {
/*    */     return getRemappedMethod(paramMemberInfo, true);
/*    */   }
/*    */   
/*    */   public <T> ObfuscationData<T> getObfEntry(IMapping<T> paramIMapping) {
/*    */     try {
/*    */       if (paramIMapping != null) {
/*    */         try {
/*    */           if (paramIMapping.getType() == IMapping.Type.FIELD)
/*    */             return (ObfuscationData)getObfField((MappingField)paramIMapping); 
/*    */         } catch (RuntimeException runtimeException) {
/*    */           throw b(null);
/*    */         } 
/*    */         try {
/*    */           if (paramIMapping.getType() == IMapping.Type.METHOD)
/*    */             return (ObfuscationData)getObfMethod((MappingMethod)paramIMapping); 
/*    */         } catch (RuntimeException runtimeException) {
/*    */           throw b(null);
/*    */         } 
/*    */       } 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return new ObfuscationData<T>();
/*    */   }
/*    */   
/*    */   private <T> ObfuscationData<T> getObfEntryUsing(MemberInfo paramMemberInfo, TypeHandle paramTypeHandle) {
/*    */     try {
/*    */     
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return (paramTypeHandle == null) ? new ObfuscationData<T>() : getObfEntry(paramMemberInfo.move(paramTypeHandle.getName()));
/*    */   }
/*    */   
/*    */   public ObfuscationData<MappingField> getObfField(MappingField paramMappingField) {
/*    */     ObfuscationData<MappingField> obfuscationData = new ObfuscationData();
/*    */     for (ObfuscationEnvironment obfuscationEnvironment : this.environments)
/*    */       MappingField mappingField = obfuscationEnvironment.getObfField(paramMappingField); 
/*    */     return obfuscationData;
/*    */   }
/*    */   
/*    */   private ObfuscationData<MappingMethod> getRemappedMethod(MappingMethod paramMappingMethod, boolean paramBoolean) {
/*    */     ObfuscationData<MappingMethod> obfuscationData = new ObfuscationData();
/*    */     for (ObfuscationEnvironment obfuscationEnvironment : this.environments) {
/*    */       MappingMethod mappingMethod = obfuscationEnvironment.getObfMethod(paramMappingMethod);
/*    */       try {
/*    */         if (mappingMethod != null)
/*    */           obfuscationData.put(obfuscationEnvironment.getType(), mappingMethod); 
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } 
/*    */     try {
/*    */       if (obfuscationData.isEmpty())
/*    */         try {
/*    */           if (paramBoolean)
/*    */             return remapDescriptor(obfuscationData, new MemberInfo((IMapping)paramMappingMethod)); 
/*    */           return obfuscationData;
/*    */         } catch (RuntimeException runtimeException) {
/*    */           throw b(null);
/*    */         }  
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return obfuscationData;
/*    */   }
/*    */   
/*    */   public ObfuscationData<MappingMethod> remapDescriptor(ObfuscationData<MappingMethod> paramObfuscationData, MemberInfo paramMemberInfo) {
/*    */     for (ObfuscationEnvironment obfuscationEnvironment : this.environments) {
/*    */       MemberInfo memberInfo = obfuscationEnvironment.remapDescriptor(paramMemberInfo);
/*    */       try {
/*    */         if (memberInfo != null)
/*    */           paramObfuscationData.put(obfuscationEnvironment.getType(), memberInfo.asMethodMapping()); 
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } 
/*    */     return paramObfuscationData;
/*    */   }
/*    */   
/*    */   public ObfuscationData<String> getObfClass(TypeHandle paramTypeHandle) {
/*    */     return getObfClass(paramTypeHandle.getName());
/*    */   }
/*    */   
/*    */   private static Exception b(Exception paramException) {
/*    */     return paramException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\ObfuscationDataProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */