/*    */ package org.spongepowered.tools.obfuscation;
/*    */ 
/*    */ import javax.lang.model.element.Element;
/*    */ 
/*    */ @SupportedAnnotationTypes({"org.spongepowered.asm.mixin.Mixin", "org.spongepowered.asm.mixin.Shadow", "org.spongepowered.asm.mixin.Overwrite", "org.spongepowered.asm.mixin.gen.Accessor", "org.spongepowered.asm.mixin.Implements"})
/*    */ public class MixinObfuscationProcessorTargets extends MixinObfuscationProcessor {
/*  7 */   private void processInvokers(RoundEnvironment paramRoundEnvironment) { for (Element element1 : paramRoundEnvironment.getElementsAnnotatedWith((Class)Invoker.class)) {
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
/* 18 */       Element element2 = element1.getEnclosingElement();
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
/* 61 */       try { if (!(element2 instanceof TypeElement)) { this.mixins.printMessage(Diagnostic.Kind.ERROR, "Unexpected parent with type " + TypeUtils.getElementType(element2), element1); continue; }  } catch (RuntimeException runtimeException) { throw b(null); }  try { if (element1.getKind() == ElementKind.METHOD) { this.mixins.registerInvoker((TypeElement)element2, (ExecutableElement)element1); continue; }
/*    */          }
/*    */       catch (RuntimeException runtimeException) { throw b(null); }
/*    */        this.mixins.printMessage(Diagnostic.Kind.ERROR, "Element is not a method", element1);
/*    */     }  } public boolean process(Set<? extends TypeElement> paramSet, RoundEnvironment paramRoundEnvironment) { try { if (paramRoundEnvironment.processingOver()) { postProcess(paramRoundEnvironment); return true; }
/*    */        }
/*    */     catch (RuntimeException runtimeException) { throw b(null); }
/* 68 */      processMixins(paramRoundEnvironment); processShadows(paramRoundEnvironment); processOverwrites(paramRoundEnvironment); processAccessors(paramRoundEnvironment);
/*    */     processInvokers(paramRoundEnvironment);
/*    */     processImplements(paramRoundEnvironment);
/*    */     postProcess(paramRoundEnvironment);
/*    */     return true; }
/*    */ 
/*    */   
/*    */   protected void postProcess(RoundEnvironment paramRoundEnvironment) {
/*    */     super.postProcess(paramRoundEnvironment);
/*    */     try {
/*    */       this.mixins.writeReferences();
/*    */       this.mixins.writeMappings();
/*    */     } catch (Exception exception) {
/*    */       exception.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   private void processImplements(RoundEnvironment paramRoundEnvironment) {
/*    */     for (Element element : paramRoundEnvironment.getElementsAnnotatedWith((Class)Implements.class)) {
/*    */       try {
/*    */         if (element.getKind() == ElementKind.CLASS || element.getKind() == ElementKind.INTERFACE) {
/*    */           AnnotationHandle annotationHandle = AnnotationHandle.of(element, Implements.class);
/*    */           this.mixins.registerSoftImplements((TypeElement)element, annotationHandle);
/*    */         } 
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private void processOverwrites(RoundEnvironment paramRoundEnvironment) {
/*    */     for (Element element1 : paramRoundEnvironment.getElementsAnnotatedWith((Class)Overwrite.class)) {
/*    */       Element element2 = element1.getEnclosingElement();
/*    */       try {
/*    */         if (!(element2 instanceof TypeElement))
/*    */           this.mixins.printMessage(Diagnostic.Kind.ERROR, "Unexpected parent with type " + TypeUtils.getElementType(element2), element1); 
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private void processShadows(RoundEnvironment paramRoundEnvironment) {
/*    */     for (Element element1 : paramRoundEnvironment.getElementsAnnotatedWith((Class)Shadow.class))
/*    */       Element element2 = element1.getEnclosingElement(); 
/*    */   }
/*    */   
/*    */   private void processAccessors(RoundEnvironment paramRoundEnvironment) {
/*    */     for (Element element1 : paramRoundEnvironment.getElementsAnnotatedWith((Class)Accessor.class))
/*    */       Element element2 = element1.getEnclosingElement(); 
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\MixinObfuscationProcessorTargets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */