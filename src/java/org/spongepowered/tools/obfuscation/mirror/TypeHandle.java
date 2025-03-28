/*  1 */ package org.spongepowered.tools.obfuscation.mirror;public class TypeHandle { private final String name; private final PackageElement pkg; private final TypeElement element; private TypeReference reference; protected static <T extends Element> List<T> getEnclosedElements(TypeElement paramTypeElement, ElementKind... paramVarArgs) { try { if (paramVarArgs != null) try { if (paramVarArgs.length >= 1) {
/*    */ 
/*    */ 
/*    */             
/*    */             try { 
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
/* 33 */               if (paramTypeElement == null)
/*    */               {
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
/* 68 */                 return Collections.emptyList(); }  } catch (NullPointerException nullPointerException) { throw b(null); }
/*    */             
/*    */             ImmutableList.Builder builder = ImmutableList.builder();
/*    */             for (Element element : paramTypeElement.getEnclosedElements()) {
/*    */               ElementKind[] arrayOfElementKind;
/*    */               int i;
/*    */               byte b;
/* 75 */               for (arrayOfElementKind = paramVarArgs, i = arrayOfElementKind.length, b = 0; b < i; ) { ElementKind elementKind = arrayOfElementKind[b]; try { if (element.getKind() == elementKind) { builder.add(element); break; }  } catch (NullPointerException nullPointerException) { throw b(null); }
/*    */                  }
/*    */             
/*    */             }  return (List<T>)builder.build();
/*    */           }  return (List)getEnclosedElements(paramTypeElement); }
/*    */         catch (NullPointerException nullPointerException) { throw b(null); }
/*    */           }
/*    */     catch (NullPointerException nullPointerException) { throw b(null); }
/*    */      return (List)getEnclosedElements(paramTypeElement); } public TypeHandle(TypeElement paramTypeElement) { this.pkg = TypeUtils.getPackage(paramTypeElement); this.name = TypeUtils.getInternalName(paramTypeElement); this.element = paramTypeElement; }
/* 84 */   public TypeHandle(PackageElement paramPackageElement, String paramString) { this.name = paramString.replace('.', '/'); this.pkg = paramPackageElement; this.element = null; }
/*    */   public TypeHandle getSuperclass() { TypeElement typeElement = getTargetElement(); try { if (typeElement == null) return null;  } catch (NullPointerException nullPointerException) { throw b(null); }  TypeMirror typeMirror = typeElement.getSuperclass(); try { if (typeMirror != null) try { if (typeMirror.getKind() != TypeKind.NONE) return new TypeHandle((DeclaredType)typeMirror);  return null; } catch (NullPointerException nullPointerException) { throw b(null); }   } catch (NullPointerException nullPointerException) { throw b(null); }  return null; }
/* 86 */   public final FieldHandle findField(VariableElement paramVariableElement) { return findField(paramVariableElement, true); } public final TypeElement getElement() { return this.element; } protected static List<? extends Element> getEnclosedElements(TypeElement paramTypeElement) { try {  } catch (NullPointerException nullPointerException) { throw b(null); }  return (paramTypeElement != null) ? paramTypeElement.getEnclosedElements() : Collections.<Element>emptyList(); } public AnnotationHandle getAnnotation(Class<? extends Annotation> paramClass) { return AnnotationHandle.of(getTargetElement(), paramClass); } public <T extends Element> List<T> getEnclosedElements(ElementKind... paramVarArgs) { return getEnclosedElements(getTargetElement(), paramVarArgs); } public MappingMethod getMappingMethod(String paramString1, String paramString2) { return (MappingMethod)new ResolvableMappingMethod(this, paramString1, paramString2); } public final String toString() { return this.name.replace('/', '.'); } public List<TypeHandle> getInterfaces() { try { if (getTargetElement() == null) return Collections.emptyList();  } catch (NullPointerException nullPointerException) { throw b(null); }  ImmutableList.Builder builder = ImmutableList.builder(); for (TypeMirror typeMirror : getTargetElement().getInterfaces()) builder.add(new TypeHandle((DeclaredType)typeMirror));  return (List<TypeHandle>)builder.build(); } protected TypeElement getTargetElement() { return this.element; } public final PackageElement getPackage() { return this.pkg; } public boolean isImaginary() { try {  } catch (NullPointerException nullPointerException) { throw b(null); }  return (getTargetElement() == null); } public final String getName() { return this.name; }
/*    */   public final MethodHandle findMethod(ExecutableElement paramExecutableElement, boolean paramBoolean) { return findMethod(paramExecutableElement.getSimpleName().toString(), TypeUtils.getJavaSignature(paramExecutableElement), paramBoolean); }
/*    */   public TypeHandle(DeclaredType paramDeclaredType) { this((TypeElement)paramDeclaredType.asElement()); } protected static boolean compareElement(Element paramElement, String paramString1, String paramString2, boolean paramBoolean) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: invokeinterface getSimpleName : ()Ljavax/lang/model/element/Name;
/*    */     //   6: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   9: astore #4
/*    */     //   11: aload_0
/*    */     //   12: invokestatic getJavaSignature : (Ljavax/lang/model/element/Element;)Ljava/lang/String;
/*    */     //   15: astore #5
/*    */     //   17: aload #5
/*    */     //   19: invokestatic stripGenerics : (Ljava/lang/String;)Ljava/lang/String;
/*    */     //   22: astore #6
/*    */     //   24: iload_3
/*    */     //   25: ifeq -> 41
/*    */     //   28: aload_1
/*    */     //   29: aload #4
/*    */     //   31: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   34: goto -> 47
/*    */     //   37: invokestatic b : (Ljava/lang/NullPointerException;)Ljava/lang/NullPointerException;
/*    */     //   40: athrow
/*    */     //   41: aload_1
/*    */     //   42: aload #4
/*    */     //   44: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*    */     //   47: istore #7
/*    */     //   49: iload #7
/*    */     //   51: ifeq -> 108
/*    */     //   54: aload_2
/*    */     //   55: invokevirtual length : ()I
/*    */     //   58: ifeq -> 100
/*    */     //   61: goto -> 68
/*    */     //   64: invokestatic b : (Ljava/lang/NullPointerException;)Ljava/lang/NullPointerException;
/*    */     //   67: athrow
/*    */     //   68: aload_2
/*    */     //   69: aload #5
/*    */     //   71: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   74: ifne -> 100
/*    */     //   77: goto -> 84
/*    */     //   80: invokestatic b : (Ljava/lang/NullPointerException;)Ljava/lang/NullPointerException;
/*    */     //   83: athrow
/*    */     //   84: aload_2
/*    */     //   85: aload #6
/*    */     //   87: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   90: ifeq -> 108
/*    */     //   93: goto -> 100
/*    */     //   96: invokestatic b : (Ljava/lang/NullPointerException;)Ljava/lang/NullPointerException;
/*    */     //   99: athrow
/*    */     //   100: iconst_1
/*    */     //   101: goto -> 109
/*    */     //   104: invokestatic b : (Ljava/lang/NullPointerException;)Ljava/lang/NullPointerException;
/*    */     //   107: athrow
/*    */     //   108: iconst_0
/*    */     //   109: ireturn
/*    */     //   110: astore #4
/*    */     //   112: iconst_0
/*    */     //   113: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #49	-> 0
/*    */     //   #12	-> 11
/*    */     //   #62	-> 17
/*    */     //   #81	-> 24
/*    */     //   #34	-> 49
/*    */     //   #45	-> 110
/*    */     //   #80	-> 112
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   0	109	110	java/lang/NullPointerException
/*    */     //   24	37	37	java/lang/NullPointerException
/*    */     //   49	61	64	java/lang/NullPointerException
/*    */     //   54	77	80	java/lang/NullPointerException
/*    */     //   68	93	96	java/lang/NullPointerException
/* 88 */     //   84	104	104	java/lang/NullPointerException } public boolean isPublic() { try { if (getTargetElement() != null) try { if (getTargetElement().getModifiers().contains(Modifier.PUBLIC)); } catch (NullPointerException nullPointerException) { throw b(null); }   } catch (NullPointerException nullPointerException) { throw b(null); }  return false; } public final MethodHandle findMethod(String paramString1, String paramString2) { return findMethod(paramString1, paramString2, true); } public final List<? extends Element> getEnclosedElements() { return getEnclosedElements(getTargetElement()); } public final FieldHandle findField(String paramString1, String paramString2) { return findField(paramString1, paramString2, true); } public MethodHandle findMethod(String paramString1, String paramString2, boolean paramBoolean) { String str = TypeUtils.stripGenerics(paramString2); return findMethod(this, paramString1, paramString2, str, paramBoolean); } public boolean isSimulated() { return false; } public final TypeReference getReference() { try { if (this.reference == null) this.reference = new TypeReference(this);  } catch (NullPointerException nullPointerException) { throw b(null); }  return this.reference; } protected static MethodHandle findMethod(TypeHandle paramTypeHandle, String paramString1, String paramString2, String paramString3, boolean paramBoolean) { for (ExecutableElement executableElement : getEnclosedElements(paramTypeHandle.getTargetElement(), new ElementKind[] { ElementKind.CONSTRUCTOR, ElementKind.METHOD })) { try { if (!compareElement(executableElement, paramString1, paramString2, paramBoolean)) { try { if (compareElement(executableElement, paramString1, paramString3, paramBoolean)) return new MethodHandle(paramTypeHandle, executableElement);  } catch (NullPointerException nullPointerException) { throw b(null); }  continue; }  } catch (NullPointerException nullPointerException) { throw b(null); }  return new MethodHandle(paramTypeHandle, executableElement); }  return null; } public TypeMirror getType() { try {  } catch (NullPointerException nullPointerException) { throw b(null); }  return (getTargetElement() != null) ? getTargetElement().asType() : null; } public final FieldHandle findField(VariableElement paramVariableElement, boolean paramBoolean) { return findField(paramVariableElement.getSimpleName().toString(), TypeUtils.getTypeName(paramVariableElement.asType()), paramBoolean); }
/* 89 */   public FieldHandle findField(String paramString1, String paramString2, boolean paramBoolean) { String str = TypeUtils.stripGenerics(paramString2); for (VariableElement variableElement : getEnclosedElements(new ElementKind[] { ElementKind.FIELD })) { try { if (compareElement(variableElement, paramString1, paramString2, paramBoolean))
/*    */           return new FieldHandle(getTargetElement(), variableElement);  } catch (NullPointerException nullPointerException) { throw b(null); }  try { if (compareElement(variableElement, paramString1, str, paramBoolean))
/* 91 */           return new FieldHandle(getTargetElement(), variableElement, true);  } catch (NullPointerException nullPointerException) { throw b(null); }  }  return null; } public final MethodHandle findMethod(ExecutableElement paramExecutableElement) { return findMethod(paramExecutableElement, true); } public String findDescriptor(MemberInfo paramMemberInfo) {
/* 92 */     String str = paramMemberInfo.desc;
/*    */     if (str == null)
/*    */       for (ExecutableElement executableElement : getEnclosedElements(new ElementKind[] { ElementKind.METHOD })) {
/*    */         if (executableElement.getSimpleName().toString().equals(paramMemberInfo.name)) {
/*    */           str = TypeUtils.getDescriptor(executableElement);
/*    */           break;
/*    */         } 
/*    */       }  
/*    */     return str;
/*    */   }
/*    */   
/*    */   private static NullPointerException b(NullPointerException paramNullPointerException) {
/*    */     return paramNullPointerException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\mirror\TypeHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */