/*     */ package org.spongepowered.tools.obfuscation;
/*     */ 
/*     */ abstract class AnnotatedMixinElementHandler {
/*     */   protected final AnnotatedMixin mixin;
/*     */   protected final String classRef;
/*     */   protected final IMixinAnnotationProcessor ap;
/*     */   protected final IObfuscationManager obf;
/*     */   private IMappingConsumer mappings;
/*     */   
/*  10 */   AnnotatedMixinElementHandler(IMixinAnnotationProcessor paramIMixinAnnotationProcessor, AnnotatedMixin paramAnnotatedMixin) { this.ap = paramIMixinAnnotationProcessor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  76 */     this.mixin = paramAnnotatedMixin;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 109 */     this.classRef = paramAnnotatedMixin.getClassRef(); this.obf = paramIMixinAnnotationProcessor.getObfuscationManager(); }
/*     */   protected final void addMethodMapping(ObfuscationType paramObfuscationType, AnnotatedMixinElementHandler$ShadowElementName paramAnnotatedMixinElementHandler$ShadowElementName, String paramString1, String paramString2) { addMethodMapping(paramObfuscationType, paramAnnotatedMixinElementHandler$ShadowElementName.name(), paramAnnotatedMixinElementHandler$ShadowElementName.obfuscated(), paramString1, paramString2); }
/*     */   protected final void addFieldMappings(String paramString1, String paramString2, ObfuscationData<MappingField> paramObfuscationData) { for (ObfuscationType obfuscationType : paramObfuscationData) { MappingField mappingField = paramObfuscationData.get(obfuscationType); addFieldMapping(obfuscationType, paramString1, mappingField.getSimpleName(), paramString2, mappingField.getDesc()); }  }
/*     */   private IMappingConsumer getMappings() { if (this.mappings == null) { IMappingConsumer iMappingConsumer = this.mixin.getMappings(); try { if (iMappingConsumer instanceof Mappings) { this.mappings = ((Mappings)iMappingConsumer).asUnique(); } else { this.mappings = iMappingConsumer; }  } catch (InvalidConstraintException invalidConstraintException) { throw b(null); }  }  return this.mappings; }
/* 113 */   protected final void validateTarget(Element paramElement, AnnotationHandle paramAnnotationHandle, AnnotatedMixinElementHandler$AliasedElementName paramAnnotatedMixinElementHandler$AliasedElementName, String paramString) { try { if (paramElement instanceof ExecutableElement) { validateTargetMethod((ExecutableElement)paramElement, paramAnnotationHandle, paramAnnotatedMixinElementHandler$AliasedElementName, paramString, false, false); } else { try { if (paramElement instanceof VariableElement) validateTargetField((VariableElement)paramElement, paramAnnotationHandle, paramAnnotatedMixinElementHandler$AliasedElementName, paramString);  } catch (InvalidConstraintException invalidConstraintException) { throw b(null); }  }  } catch (InvalidConstraintException invalidConstraintException) { throw b(null); }  } protected final void validateTargetMethod(ExecutableElement paramExecutableElement, AnnotationHandle paramAnnotationHandle, AnnotatedMixinElementHandler$AliasedElementName paramAnnotatedMixinElementHandler$AliasedElementName, String paramString, boolean paramBoolean1, boolean paramBoolean2) { String str = TypeUtils.getJavaSignature(paramExecutableElement); for (TypeHandle typeHandle : this.mixin.getTargets()) { try { if (typeHandle.isImaginary()) continue;  } catch (InvalidConstraintException invalidConstraintException) { throw b(null); }  MethodHandle methodHandle = typeHandle.findMethod(paramExecutableElement); try { if (methodHandle == null && paramAnnotatedMixinElementHandler$AliasedElementName.hasPrefix()) methodHandle = typeHandle.findMethod(paramAnnotatedMixinElementHandler$AliasedElementName.baseName(), str);  } catch (InvalidConstraintException invalidConstraintException) { throw b(null); }  try { if (methodHandle == null && paramAnnotatedMixinElementHandler$AliasedElementName.hasAliases()) for (String str1 : paramAnnotatedMixinElementHandler$AliasedElementName.getAliases()) { if ((methodHandle = typeHandle.findMethod(str1, str)) != null) break;  }   } catch (InvalidConstraintException invalidConstraintException) { throw b(null); }  try { if (methodHandle != null) try { if (paramBoolean1) validateMethodVisibility(paramExecutableElement, paramAnnotationHandle, paramString, typeHandle, methodHandle);  } catch (InvalidConstraintException invalidConstraintException) { throw b(null); }   } catch (InvalidConstraintException invalidConstraintException) { throw b(null); }  }  } protected final void validateTargetField(VariableElement paramVariableElement, AnnotationHandle paramAnnotationHandle, AnnotatedMixinElementHandler$AliasedElementName paramAnnotatedMixinElementHandler$AliasedElementName, String paramString) { String str = paramVariableElement.asType().toString(); for (TypeHandle typeHandle : this.mixin.getTargets()) { try { if (typeHandle.isImaginary()); } catch (InvalidConstraintException invalidConstraintException) { throw b(null); }  }  }
/*     */   protected final void checkConstraints(ExecutableElement paramExecutableElement, AnnotationHandle paramAnnotationHandle) { try { ConstraintParser.Constraint constraint = ConstraintParser.parse((String)paramAnnotationHandle.getValue("constraints")); try { constraint.check(this.ap.getTokenProvider()); } catch (ConstraintViolationException constraintViolationException) { this.ap.printMessage(Diagnostic.Kind.ERROR, constraintViolationException.getMessage(), paramExecutableElement, paramAnnotationHandle.asMirror()); }  } catch (InvalidConstraintException invalidConstraintException) { this.ap.printMessage(Diagnostic.Kind.WARNING, invalidConstraintException.getMessage(), paramExecutableElement, paramAnnotationHandle.asMirror()); }  }
/*     */   protected static <T extends IMapping<T>> ObfuscationData<T> stripDescriptors(ObfuscationData<T> paramObfuscationData) { ObfuscationData<Object> obfuscationData = new ObfuscationData(); for (ObfuscationType obfuscationType : paramObfuscationData) { IMapping iMapping = (IMapping)paramObfuscationData.get(obfuscationType); obfuscationData.put(obfuscationType, iMapping.transform(null)); }  return (ObfuscationData)obfuscationData; } protected final void validateReferencedTarget(ExecutableElement paramExecutableElement, AnnotationHandle paramAnnotationHandle, MemberInfo paramMemberInfo, String paramString) { String str = paramMemberInfo.toDescriptor(); for (TypeHandle typeHandle : this.mixin.getTargets()) { try { if (typeHandle.isImaginary())
/*     */           continue;  } catch (InvalidConstraintException invalidConstraintException) { throw b(null); }
/* 117 */        MethodHandle methodHandle = typeHandle.findMethod(paramMemberInfo.name, str); try { if (methodHandle == null) this.ap.printMessage(Diagnostic.Kind.WARNING, "Cannot find target method for " + paramString + " in " + typeHandle, paramExecutableElement, paramAnnotationHandle.asMirror());  } catch (InvalidConstraintException invalidConstraintException) { throw b(null); }  }  } protected final void addFieldMapping(ObfuscationType paramObfuscationType, String paramString1, String paramString2, String paramString3, String paramString4) { MappingField mappingField1 = new MappingField(this.classRef, paramString1, paramString3); MappingField mappingField2 = new MappingField(this.classRef, paramString2, paramString4); getMappings().addFieldMapping(paramObfuscationType, mappingField1, mappingField2); } protected final void addMethodMappings(String paramString1, String paramString2, ObfuscationData<MappingMethod> paramObfuscationData) { for (ObfuscationType obfuscationType : paramObfuscationData) MappingMethod mappingMethod = paramObfuscationData.get(obfuscationType);  } private void printMessage(Diagnostic.Kind paramKind, String paramString, Element paramElement, AnnotationHandle paramAnnotationHandle) { try { if (paramAnnotationHandle == null) { this.ap.printMessage(paramKind, paramString, paramElement); } else { this.ap.printMessage(paramKind, paramString, paramElement, paramAnnotationHandle.asMirror()); }  } catch (InvalidConstraintException invalidConstraintException) { throw b(null); }  } protected static <T extends IMapping<T>> ObfuscationData<T> stripOwnerData(ObfuscationData<T> paramObfuscationData) { ObfuscationData<Object> obfuscationData = new ObfuscationData(); for (ObfuscationType obfuscationType : paramObfuscationData) { IMapping iMapping = (IMapping)paramObfuscationData.get(obfuscationType); obfuscationData.put(obfuscationType, iMapping.move(null)); }  return (ObfuscationData)obfuscationData; }
/* 118 */   protected final void addMethodMapping(ObfuscationType paramObfuscationType, String paramString1, String paramString2, String paramString3, String paramString4) { MappingMethod mappingMethod1 = new MappingMethod(this.classRef, paramString1, paramString3); MappingMethod mappingMethod2 = new MappingMethod(this.classRef, paramString2, paramString4);
/*     */     getMappings().addMethodMapping(paramObfuscationType, mappingMethod1, mappingMethod2); }
/*     */ 
/*     */   
/*     */   private void validateMethodVisibility(ExecutableElement paramExecutableElement, AnnotationHandle paramAnnotationHandle, String paramString, TypeHandle paramTypeHandle, MethodHandle paramMethodHandle) {
/*     */     Visibility visibility1 = paramMethodHandle.getVisibility();
/*     */     try {
/*     */       if (visibility1 == null)
/*     */         return; 
/*     */     } catch (InvalidConstraintException invalidConstraintException) {
/*     */       throw b(null);
/*     */     } 
/*     */     Visibility visibility2 = TypeUtils.getVisibility(paramExecutableElement);
/*     */     String str = "visibility of " + visibility1 + " method in " + paramTypeHandle;
/*     */     try {
/*     */       if (visibility1.ordinal() > visibility2.ordinal()) {
/*     */         printMessage(Diagnostic.Kind.WARNING, visibility2 + " " + paramString + " method cannot reduce " + str, paramExecutableElement, paramAnnotationHandle);
/*     */       } else {
/*     */         try {
/*     */           if (visibility1 == Visibility.PRIVATE)
/*     */             try {
/*     */               if (visibility2.ordinal() > visibility1.ordinal())
/*     */                 printMessage(Diagnostic.Kind.WARNING, visibility2 + " " + paramString + " method will upgrade " + str, paramExecutableElement, paramAnnotationHandle); 
/*     */             } catch (InvalidConstraintException invalidConstraintException) {
/*     */               throw b(null);
/*     */             }  
/*     */         } catch (InvalidConstraintException invalidConstraintException) {
/*     */           throw b(null);
/*     */         } 
/*     */       } 
/*     */     } catch (InvalidConstraintException invalidConstraintException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected final void addFieldMapping(ObfuscationType paramObfuscationType, AnnotatedMixinElementHandler$ShadowElementName paramAnnotatedMixinElementHandler$ShadowElementName, String paramString1, String paramString2) {
/*     */     addFieldMapping(paramObfuscationType, paramAnnotatedMixinElementHandler$ShadowElementName.name(), paramAnnotatedMixinElementHandler$ShadowElementName.obfuscated(), paramString1, paramString2);
/*     */   }
/*     */   
/*     */   private static InvalidConstraintException b(InvalidConstraintException paramInvalidConstraintException) {
/*     */     return paramInvalidConstraintException;
/*     */   }
/*     */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\AnnotatedMixinElementHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */