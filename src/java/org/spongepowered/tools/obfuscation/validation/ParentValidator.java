/*   */ package org.spongepowered.tools.obfuscation.validation;
/*   */ public class ParentValidator extends MixinValidator { public boolean validate(TypeElement paramTypeElement, AnnotationHandle paramAnnotationHandle, Collection<TypeHandle> paramCollection) { 
/* 3 */     try { if (paramTypeElement.getEnclosingElement().getKind() != ElementKind.PACKAGE) try { if (!paramTypeElement.getModifiers().contains(Modifier.STATIC)) error("Inner class mixin must be declared static", paramTypeElement);  } catch (RuntimeException runtimeException) { throw c(null); }   } catch (RuntimeException runtimeException) { throw c(null); }  return true; }
/* 4 */   private static RuntimeException c(RuntimeException paramRuntimeException) { return paramRuntimeException; } public ParentValidator(IMixinAnnotationProcessor paramIMixinAnnotationProcessor) { super(paramIMixinAnnotationProcessor, IMixinValidator.ValidationPass.EARLY); }
/*   */    }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\validation\ParentValidator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */