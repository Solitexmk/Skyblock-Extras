/*  1 */ package org.spongepowered.tools.obfuscation;@SupportedAnnotationTypes({"org.spongepowered.asm.mixin.injection.Inject", "org.spongepowered.asm.mixin.injection.ModifyArg", "org.spongepowered.asm.mixin.injection.ModifyArgs", "org.spongepowered.asm.mixin.injection.Redirect", "org.spongepowered.asm.mixin.injection.At"}) public class MixinObfuscationProcessorInjection extends MixinObfuscationProcessor { private void processInjectors(RoundEnvironment paramRoundEnvironment, Class<? extends Annotation> paramClass) { for (Element element1 : paramRoundEnvironment.getElementsAnnotatedWith(paramClass)) {
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
/* 32 */       Element element2 = element1.getEnclosingElement();
/*    */       try {
/*    */         if (!(element2 instanceof TypeElement))
/*    */           throw new IllegalStateException("@" + paramClass.getSimpleName() + " element has unexpected parent with type " + TypeUtils.getElementType(element2)); 
/*    */       } catch (IllegalStateException illegalStateException) {
/*    */         throw b(null);
/*    */       } 
/*    */       AnnotationHandle annotationHandle = AnnotationHandle.of(element1, paramClass);
/*    */       try {
/*    */         if (element1.getKind() == ElementKind.METHOD) {
/*    */           this.mixins.registerInjector((TypeElement)element2, (ExecutableElement)element1, annotationHandle);
/*    */           continue;
/*    */         } 
/*    */       } catch (IllegalStateException illegalStateException) {
/*    */         throw b(null);
/*    */       } 
/*    */       this.mixins.printMessage(Diagnostic.Kind.WARNING, "Found an @" + paramClass.getSimpleName() + " annotation on an element which is not a method: " + element1.toString());
/*    */     }  }
/*    */ 
/*    */   
/*    */   public boolean process(Set<? extends TypeElement> paramSet, RoundEnvironment paramRoundEnvironment) {
/*    */     try {
/*    */       if (paramRoundEnvironment.processingOver()) {
/*    */         postProcess(paramRoundEnvironment);
/*    */         return true;
/*    */       } 
/*    */     } catch (IllegalStateException illegalStateException) {
/*    */       throw b(null);
/*    */     } 
/*    */     processMixins(paramRoundEnvironment);
/*    */     processInjectors(paramRoundEnvironment, (Class)Inject.class);
/*    */     processInjectors(paramRoundEnvironment, (Class)ModifyArg.class);
/*    */     processInjectors(paramRoundEnvironment, (Class)ModifyArgs.class);
/*    */     processInjectors(paramRoundEnvironment, (Class)Redirect.class);
/*    */     processInjectors(paramRoundEnvironment, (Class)ModifyVariable.class);
/*    */     processInjectors(paramRoundEnvironment, (Class)ModifyConstant.class);
/*    */     postProcess(paramRoundEnvironment);
/*    */     return true;
/*    */   }
/*    */   
/*    */   protected void postProcess(RoundEnvironment paramRoundEnvironment) {
/*    */     super.postProcess(paramRoundEnvironment);
/*    */     try {
/*    */       this.mixins.writeReferences();
/*    */     } catch (Exception exception) {
/*    */       exception.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   private static IllegalStateException b(IllegalStateException paramIllegalStateException) {
/*    */     return paramIllegalStateException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\MixinObfuscationProcessorInjection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */