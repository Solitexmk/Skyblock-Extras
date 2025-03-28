/*     */ package org.spongepowered.tools.obfuscation.mirror;
/*     */ import javax.lang.model.element.Element;
/*     */ import javax.lang.model.type.DeclaredType;
/*     */ import javax.lang.model.type.TypeMirror;
/*     */ 
/*     */ public abstract class TypeUtils {
/*     */   private static final int MAX_GENERIC_RECURSION_DEPTH = 5;
/*     */   private static final String OBJECT_SIG = "java.lang.Object";
/*     */   private static final String OBJECT_REF = "java/lang/Object";
/*     */   
/*     */   public static String getDescriptor(Element paramElement) {
/*     */     
/*  13 */     try { if (paramElement instanceof ExecutableElement)
/*     */       {
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
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  84 */         return getDescriptor((ExecutableElement)paramElement); }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  try { if (paramElement instanceof VariableElement)
/*  85 */         return getInternalName((VariableElement)paramElement);  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return getInternalName(paramElement.asType());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getJavaSignature(Element paramElement) {
/*     */     if (paramElement instanceof ExecutableElement)
/*     */     { ExecutableElement executableElement = (ExecutableElement)paramElement;
/*  94 */       StringBuilder stringBuilder = (new StringBuilder()).append("(");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 104 */       boolean bool = false; Iterator<? extends VariableElement> iterator = executableElement.getParameters().iterator(); }  return getTypeName(paramElement.asType());
/*     */   }
/*     */   public static String getName(ExecutableElement paramExecutableElement) { try {  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return (paramExecutableElement != null) ? paramExecutableElement.getSimpleName().toString() : null; }
/*     */   public static String getInternalName(VariableElement paramVariableElement) { try { if (paramVariableElement == null)
/*     */         return null;  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return getInternalName(paramVariableElement.asType()); }
/*     */   public static PackageElement getPackage(TypeElement paramTypeElement) { Element element = paramTypeElement.getEnclosingElement(); while (true) { try { if (element != null && !(element instanceof PackageElement)) { element = element.getEnclosingElement(); continue; }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  break; }  return (PackageElement)element; }
/*     */   public static PackageElement getPackage(TypeMirror paramTypeMirror) { try { if (!(paramTypeMirror instanceof DeclaredType))
/*     */         return null;  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return getPackage((TypeElement)((DeclaredType)paramTypeMirror).asElement()); }
/*     */   public static String getInternalName(TypeElement paramTypeElement) { try { if (paramTypeElement == null)
/*     */         return null;  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append(paramTypeElement.getSimpleName()); Element element = paramTypeElement.getEnclosingElement(); while (true) { try { if (element != null) { try { if (element instanceof TypeElement) { stringBuilder.insert(0, "$").insert(0, element.getSimpleName()); } else { try { if (element instanceof PackageElement)
/*     */                   stringBuilder.insert(0, "/").insert(0, ((PackageElement)element).getQualifiedName().toString().replace('.', '/'));  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  element = element.getEnclosingElement(); continue; }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }
/*     */        break; }
/*     */      return stringBuilder.toString(); } private static DeclaredType getUpperBound0(TypeMirror paramTypeMirror, int paramInt) { try { if (paramInt == 0)
/*     */         throw new IllegalStateException("Generic symbol \"" + paramTypeMirror + "\" is too complex, exceeded " + '\005' + " iterations attempting to determine upper bound");  }
/*     */     catch (IllegalStateException illegalStateException) { throw b(null); }
/*     */      try { if (paramTypeMirror instanceof DeclaredType)
/*     */         return (DeclaredType)paramTypeMirror;  }
/*     */     catch (IllegalStateException illegalStateException) { throw b(null); }
/*     */      if (paramTypeMirror instanceof TypeVariable)
/*     */       try { TypeMirror typeMirror = ((TypeVariable)paramTypeMirror).getUpperBound(); return getUpperBound0(typeMirror, --paramInt); }
/*     */       catch (IllegalStateException illegalStateException) { throw illegalStateException; }
/*     */       catch (IllegalArgumentException illegalArgumentException) { throw illegalArgumentException; }
/*     */       catch (Exception exception) { throw new IllegalArgumentException("Unable to compute upper bound of type symbol " + paramTypeMirror); }
/*     */         return null; } private static DeclaredType getUpperBound(TypeMirror paramTypeMirror) { try { return getUpperBound0(paramTypeMirror, 5); }
/* 128 */     catch (IllegalStateException illegalStateException) { throw new IllegalArgumentException("Type symbol \"" + paramTypeMirror + "\" is too complex", illegalStateException); } catch (IllegalArgumentException illegalArgumentException) { throw new IllegalArgumentException("Unable to compute upper bound of type symbol " + paramTypeMirror, illegalArgumentException); }  }
/*     */   public static String getInternalName(DeclaredType paramDeclaredType) { try { if (paramDeclaredType == null)
/*     */         return "java/lang/Object";  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return getInternalName((TypeElement)paramDeclaredType.asElement()); } public static String getInternalName(TypeMirror paramTypeMirror) { try { switch (TypeUtils$1.$SwitchMap$javax$lang$model$type$TypeKind[paramTypeMirror.getKind().ordinal()]) { case 1: return "[" + getInternalName(((ArrayType)paramTypeMirror).getComponentType());
/*     */         case 2: return "L" + getInternalName((DeclaredType)paramTypeMirror) + ";";
/*     */         case 3:
/*     */           return "L" + getInternalName(getUpperBound(paramTypeMirror)) + ";";
/*     */         case 5:
/* 135 */           return "Z";case 6: return "B";case 7: return "C";case 8: return "D";case 9: return "F";case 10: return "I";case 11: return "J";case 12: return "S";case 13: return "V";case 4: return "Ljava/lang/Object;"; }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  throw new IllegalArgumentException("Unable to parse type symbol " + paramTypeMirror + " with " + paramTypeMirror.getKind() + " to equivalent bytecode type"); } public static Visibility getVisibility(Element paramElement) { try { if (paramElement == null) return null;  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  for (Modifier modifier : paramElement.getModifiers()) { try { switch (TypeUtils$1.$SwitchMap$javax$lang$model$element$Modifier[modifier.ordinal()]) { case 1: return Visibility.PUBLIC;case 2: return Visibility.PROTECTED;case 3: return Visibility.PRIVATE; }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  }  return Visibility.PACKAGE; } public static String getName(VariableElement paramVariableElement) { try {  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return (paramVariableElement != null) ? paramVariableElement.getSimpleName().toString() : null; } public static String getTypeName(TypeMirror paramTypeMirror) { try { switch (TypeUtils$1.$SwitchMap$javax$lang$model$type$TypeKind[paramTypeMirror.getKind().ordinal()]) { case 1: return getTypeName(((ArrayType)paramTypeMirror).getComponentType()) + "[]";case 2: return getTypeName((DeclaredType)paramTypeMirror);case 3: return getTypeName(getUpperBound(paramTypeMirror));case 4: return "java.lang.Object"; }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return paramTypeMirror.toString(); }
/* 136 */   public static String getElementType(Element paramElement) { try { if (paramElement instanceof TypeElement) return "TypeElement";  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  try { if (paramElement instanceof ExecutableElement)
/*     */         return "ExecutableElement";  }
/*     */     catch (IllegalArgumentException illegalArgumentException)
/*     */     { throw b(null); }
/*     */     
/*     */     try {
/*     */       if (paramElement instanceof VariableElement)
/*     */         return "VariableElement"; 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (paramElement instanceof PackageElement)
/*     */         return "PackageElement"; 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (paramElement instanceof javax.lang.model.element.TypeParameterElement)
/*     */         return "TypeParameterElement"; 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return paramElement.getClass().getSimpleName(); }
/*     */ 
/*     */   
/*     */   public static boolean isAssignable(ProcessingEnvironment paramProcessingEnvironment, TypeMirror paramTypeMirror1, TypeMirror paramTypeMirror2) {
/*     */     boolean bool = paramProcessingEnvironment.getTypeUtils().isAssignable(paramTypeMirror1, paramTypeMirror2);
/*     */     try {
/*     */       if (!bool)
/*     */         try {
/*     */           if (paramTypeMirror1 instanceof DeclaredType && paramTypeMirror2 instanceof DeclaredType) {
/*     */             TypeMirror typeMirror1 = toRawType(paramProcessingEnvironment, (DeclaredType)paramTypeMirror1);
/*     */             TypeMirror typeMirror2 = toRawType(paramProcessingEnvironment, (DeclaredType)paramTypeMirror2);
/*     */             return paramProcessingEnvironment.getTypeUtils().isAssignable(typeMirror1, typeMirror2);
/*     */           } 
/*     */         } catch (IllegalArgumentException illegalArgumentException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return bool;
/*     */   }
/*     */   
/*     */   private static TypeMirror toRawType(ProcessingEnvironment paramProcessingEnvironment, DeclaredType paramDeclaredType) {
/*     */     return paramProcessingEnvironment.getElementUtils().getTypeElement(((TypeElement)paramDeclaredType.asElement()).getQualifiedName()).asType();
/*     */   }
/*     */   
/*     */   public static String getTypeName(DeclaredType paramDeclaredType) {
/*     */     try {
/*     */       if (paramDeclaredType == null)
/*     */         return "java.lang.Object"; 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return getInternalName((TypeElement)paramDeclaredType.asElement()).replace('/', '.');
/*     */   }
/*     */   
/*     */   public static String getDescriptor(ExecutableElement paramExecutableElement) {
/*     */     try {
/*     */       if (paramExecutableElement == null)
/*     */         return null; 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     StringBuilder stringBuilder = new StringBuilder();
/*     */     for (VariableElement variableElement : paramExecutableElement.getParameters())
/*     */       stringBuilder.append(getInternalName(variableElement)); 
/*     */     String str = getInternalName(paramExecutableElement.getReturnType());
/*     */     return String.format("(%s)%s", new Object[] { stringBuilder, str });
/*     */   }
/*     */   
/*     */   public static String stripGenerics(String paramString) {
/*     */     StringBuilder stringBuilder = new StringBuilder();
/*     */     for (byte b1 = 0, b2 = 0; b1 < paramString.length(); ) {
/*     */       char c = paramString.charAt(b1);
/*     */       try {
/*     */         if (c == '<')
/*     */           b2++; 
/*     */       } catch (IllegalArgumentException illegalArgumentException) {
/*     */         throw b(null);
/*     */       } 
/*     */       try {
/*     */         if (b2 == 0) {
/*     */           stringBuilder.append(c);
/*     */         } else {
/*     */           try {
/*     */             if (c == '>')
/*     */               b2--; 
/*     */           } catch (IllegalArgumentException illegalArgumentException) {
/*     */             throw b(null);
/*     */           } 
/*     */         } 
/*     */       } catch (IllegalArgumentException illegalArgumentException) {
/*     */         throw b(null);
/*     */       } 
/*     */       b1++;
/*     */     } 
/*     */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static String getJavaSignature(String paramString) {
/*     */     return (new SignaturePrinter("", paramString)).setFullyQualified(true).toDescriptor();
/*     */   }
/*     */   
/*     */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*     */     return paramRuntimeException;
/*     */   }
/*     */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\mirror\TypeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */