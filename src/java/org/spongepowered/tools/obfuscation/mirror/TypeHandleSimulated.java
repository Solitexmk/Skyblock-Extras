/*    */ package org.spongepowered.tools.obfuscation.mirror;
/*    */ public class TypeHandleSimulated extends TypeHandle {
/*  3 */   public boolean isPublic() { return true; } private final TypeElement simulatedType; public MappingMethod getMappingMethod(String paramString1, String paramString2) {
/*  4 */     String str1 = (new SignaturePrinter(paramString1, paramString2)).setFullyQualified(true).toDescriptor();
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
/* 31 */     String str2 = TypeUtils.stripGenerics(str1);
/*    */     
/*    */     MethodHandle methodHandle = findMethodRecursive(this, paramString1, str1, str2, true);
/*    */     
/*    */     try {  }
/*    */     catch (RuntimeException runtimeException)
/* 37 */     { throw b(null); }  return (methodHandle != null) ? methodHandle.asMapping(true) : super.getMappingMethod(paramString1, paramString2);
/*    */   }
/*    */   
/*    */   public String findDescriptor(MemberInfo paramMemberInfo) {
/*    */     try {
/*    */     
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return (paramMemberInfo != null) ? paramMemberInfo.desc : null;
/*    */   }
/*    */   
/*    */   public FieldHandle findField(String paramString1, String paramString2, boolean paramBoolean) {
/*    */     return new FieldHandle(null, paramString1, paramString2);
/*    */   }
/*    */   
/*    */   public AnnotationHandle getAnnotation(Class<? extends Annotation> paramClass) {
/*    */     return null;
/*    */   }
/*    */   
/*    */   public TypeHandle getSuperclass() {
/*    */     return null;
/*    */   }
/*    */   
/*    */   private static MethodHandle findMethodRecursive(TypeMirror paramTypeMirror, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
/*    */     try {
/*    */       if (!(paramTypeMirror instanceof DeclaredType))
/*    */         return null; 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     TypeElement typeElement = (TypeElement)((DeclaredType)paramTypeMirror).asElement();
/*    */     return findMethodRecursive(new TypeHandle(typeElement), paramString1, paramString2, paramString3, paramBoolean);
/*    */   }
/*    */   
/*    */   public TypeHandleSimulated(String paramString, TypeMirror paramTypeMirror) {
/*    */     this(TypeUtils.getPackage(paramTypeMirror), paramString, paramTypeMirror);
/*    */   }
/*    */   
/*    */   public TypeHandleSimulated(PackageElement paramPackageElement, String paramString, TypeMirror paramTypeMirror) {
/*    */     super(paramPackageElement, paramString);
/*    */     this.simulatedType = (TypeElement)((DeclaredType)paramTypeMirror).asElement();
/*    */   }
/*    */   
/*    */   public boolean isSimulated() {
/*    */     return true;
/*    */   }
/*    */   
/*    */   private static MethodHandle findMethodRecursive(TypeHandle paramTypeHandle, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
/*    */     TypeElement typeElement = paramTypeHandle.getTargetElement();
/*    */     try {
/*    */       if (typeElement == null)
/*    */         return null; 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     MethodHandle methodHandle = TypeHandle.findMethod(paramTypeHandle, paramString1, paramString2, paramString3, paramBoolean);
/*    */     try {
/*    */       if (methodHandle != null)
/*    */         return methodHandle; 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     for (TypeMirror typeMirror1 : typeElement.getInterfaces())
/*    */       methodHandle = findMethodRecursive(typeMirror1, paramString1, paramString2, paramString3, paramBoolean); 
/*    */     TypeMirror typeMirror = typeElement.getSuperclass();
/*    */     try {
/*    */       if (typeMirror != null)
/*    */         try {
/*    */           if (typeMirror.getKind() != TypeKind.NONE)
/*    */             return findMethodRecursive(typeMirror, paramString1, paramString2, paramString3, paramBoolean); 
/*    */           return null;
/*    */         } catch (RuntimeException runtimeException) {
/*    */           throw b(null);
/*    */         }  
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return null;
/*    */   }
/*    */   
/*    */   public boolean isImaginary() {
/*    */     return false;
/*    */   }
/*    */   
/*    */   protected TypeElement getTargetElement() {
/*    */     return this.simulatedType;
/*    */   }
/*    */   
/*    */   public MethodHandle findMethod(String paramString1, String paramString2, boolean paramBoolean) {
/*    */     return new MethodHandle(null, paramString1, paramString2);
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\mirror\TypeHandleSimulated.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */