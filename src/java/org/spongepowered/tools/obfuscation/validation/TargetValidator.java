/*  1 */ package org.spongepowered.tools.obfuscation.validation;public class TargetValidator extends MixinValidator { private boolean validateSuperClass(TypeMirror paramTypeMirror1, TypeMirror paramTypeMirror2) { try { if (TypeUtils.isAssignable(this.processingEnv, paramTypeMirror1, paramTypeMirror2))
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
/* 22 */         return true; }  } catch (RuntimeException runtimeException) { throw c(null); }
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
/* 35 */     return validateSuperClassRecursive(paramTypeMirror1, paramTypeMirror2); }
/*    */   
/*    */   private boolean checkMixinsFor(TypeMirror paramTypeMirror1, TypeMirror paramTypeMirror2) { for (TypeMirror typeMirror : getMixinsTargeting(paramTypeMirror1)) {
/*    */       
/* 39 */       try { if (TypeUtils.isAssignable(this.processingEnv, typeMirror, paramTypeMirror2))
/*    */         {
/* 41 */           return true; }  } catch (RuntimeException runtimeException) { throw c(null); } 
/*    */     }  return false; }
/* 43 */   public TargetValidator(IMixinAnnotationProcessor paramIMixinAnnotationProcessor) { super(paramIMixinAnnotationProcessor, IMixinValidator.ValidationPass.LATE); } private void validateClassMixin(TypeElement paramTypeElement, Collection<TypeHandle> paramCollection) { TypeMirror typeMirror = paramTypeElement.getSuperclass(); for (TypeHandle typeHandle : paramCollection) { TypeMirror typeMirror1 = typeHandle.getType(); try { if (typeMirror1 != null) try { if (!validateSuperClass(typeMirror1, typeMirror)) error("Superclass " + typeMirror + " of " + paramTypeElement + " was not found in the hierarchy of target class " + typeMirror1, paramTypeElement);  } catch (RuntimeException runtimeException) { throw c(null); }   } catch (RuntimeException runtimeException) { throw c(null); }  }  } public boolean validate(TypeElement paramTypeElement, AnnotationHandle paramAnnotationHandle, Collection<TypeHandle> paramCollection) { try { if ("true".equalsIgnoreCase(this.options.getOption("disableTargetValidator")))
/* 44 */         return true;  } catch (RuntimeException runtimeException) { throw c(null); }  try { if (paramTypeElement.getKind() == ElementKind.INTERFACE) { validateInterfaceMixin(paramTypeElement, paramCollection); } else { validateClassMixin(paramTypeElement, paramCollection); }
/*    */        }
/*    */     catch (RuntimeException runtimeException) { throw c(null); }
/*    */      return true; } private void validateInterfaceMixin(TypeElement paramTypeElement, Collection<TypeHandle> paramCollection) { boolean bool = false; for (Element element : paramTypeElement.getEnclosedElements()) {
/* 48 */       if (element.getKind() == ElementKind.METHOD)
/*    */         continue; 
/*    */       continue;
/*    */       bool1 = AnnotationHandle.of((Element)SYNTHETIC_LOCAL_VARIABLE_5, Accessor.class).exists();
/*    */       bool2 = AnnotationHandle.of((Element)SYNTHETIC_LOCAL_VARIABLE_5, Invoker.class).exists();
/*    */     } 
/*    */     try {
/*    */       if (!bool)
/*    */         return; 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw c(null);
/*    */     } 
/*    */     for (TypeHandle typeHandle : paramCollection) {
/*    */       TypeElement typeElement = typeHandle.getElement();
/*    */       try {
/*    */         if (typeElement != null)
/*    */           try {
/*    */             if (typeElement.getKind() != ElementKind.INTERFACE)
/*    */               error("Targetted type '" + typeHandle + " of " + paramTypeElement + " is not an interface", paramTypeElement); 
/*    */           } catch (RuntimeException runtimeException) {
/*    */             throw c(null);
/*    */           }  
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw c(null);
/*    */       } 
/*    */     }  }
/*    */ 
/*    */   
/*    */   private boolean validateSuperClassRecursive(TypeMirror paramTypeMirror1, TypeMirror paramTypeMirror2) {
/*    */     try {
/*    */       if (!(paramTypeMirror1 instanceof DeclaredType))
/*    */         return false; 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw c(null);
/*    */     } 
/*    */     try {
/*    */       if (TypeUtils.isAssignable(this.processingEnv, paramTypeMirror1, paramTypeMirror2))
/*    */         return true; 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw c(null);
/*    */     } 
/*    */     TypeElement typeElement = (TypeElement)((DeclaredType)paramTypeMirror1).asElement();
/*    */     TypeMirror typeMirror = typeElement.getSuperclass();
/*    */     try {
/*    */       if (typeMirror.getKind() == TypeKind.NONE)
/*    */         return false; 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw c(null);
/*    */     } 
/*    */     try {
/*    */       if (checkMixinsFor(typeMirror, paramTypeMirror2))
/*    */         return true; 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw c(null);
/*    */     } 
/*    */     return validateSuperClassRecursive(typeMirror, paramTypeMirror2);
/*    */   }
/*    */   
/*    */   private static RuntimeException c(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\validation\TargetValidator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */