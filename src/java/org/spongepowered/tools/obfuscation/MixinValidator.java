/*    */ package org.spongepowered.tools.obfuscation;
/*    */ public abstract class MixinValidator implements IMixinValidator { protected final ProcessingEnvironment processingEnv; protected final Messager messager;
/*    */   
/*  4 */   public MixinValidator(IMixinAnnotationProcessor paramIMixinAnnotationProcessor, IMixinValidator.ValidationPass paramValidationPass) { this.processingEnv = paramIMixinAnnotationProcessor.getProcessingEnvironment();
/*  5 */     this.messager = (Messager)paramIMixinAnnotationProcessor;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 12 */     this.options = (IOptionProvider)paramIMixinAnnotationProcessor; this.pass = paramValidationPass; }
/* 13 */   protected final IOptionProvider options; protected final IMixinValidator.ValidationPass pass; protected final void error(String paramString, Element paramElement) { this.messager.printMessage(Diagnostic.Kind.ERROR, paramString, paramElement); } protected final Collection<TypeMirror> getMixinsTargeting(TypeMirror paramTypeMirror) { return AnnotatedMixins.getMixinsForEnvironment(this.processingEnv).getMixinsTargeting(paramTypeMirror); } protected final void note(String paramString, Element paramElement) { this.messager.printMessage(Diagnostic.Kind.NOTE, paramString, paramElement); } public final boolean validate(IMixinValidator.ValidationPass paramValidationPass, TypeElement paramTypeElement, AnnotationHandle paramAnnotationHandle, Collection<TypeHandle> paramCollection) { try { if (paramValidationPass != this.pass)
/* 14 */         return true;  } catch (RuntimeException runtimeException) { throw b(null); }
/* 15 */      return validate(paramTypeElement, paramAnnotationHandle, paramCollection); } protected final void warning(String paramString, Element paramElement) { this.messager.printMessage(Diagnostic.Kind.WARNING, paramString, paramElement); }
/*    */ 
/*    */   
/*    */   protected abstract boolean validate(TypeElement paramTypeElement, AnnotationHandle paramAnnotationHandle, Collection<TypeHandle> paramCollection);
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\MixinValidator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */