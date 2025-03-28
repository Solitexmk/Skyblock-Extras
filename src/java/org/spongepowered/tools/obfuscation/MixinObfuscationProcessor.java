/*    */ package org.spongepowered.tools.obfuscation;public abstract class MixinObfuscationProcessor extends AbstractProcessor { protected AnnotatedMixins mixins;
/*    */   
/*    */   public SourceVersion getSupportedSourceVersion() { 
/*  4 */     try { return SourceVersion.valueOf("RELEASE_8");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */        }
/*    */     
/* 15 */     catch (IllegalArgumentException illegalArgumentException) { return super.getSupportedSourceVersion(); }  } public synchronized void init(ProcessingEnvironment paramProcessingEnvironment) { super.init(paramProcessingEnvironment); this.mixins = AnnotatedMixins.getMixinsForEnvironment(paramProcessingEnvironment); }
/* 16 */   protected void processMixins(RoundEnvironment paramRoundEnvironment) { this.mixins.onPassStarted(); for (Element element : paramRoundEnvironment.getElementsAnnotatedWith((Class)Mixin.class)) { try { if (element.getKind() != ElementKind.CLASS)
/* 17 */           try { if (element.getKind() != ElementKind.INTERFACE) { this.mixins.printMessage(Diagnostic.Kind.ERROR, "Found an @Mixin annotation on an element which is not a class or interface", element); continue; }  this.mixins.registerMixin((TypeElement)element); } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }   } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  }  } protected void postProcess(RoundEnvironment paramRoundEnvironment) { this.mixins.onPassCompleted(paramRoundEnvironment); }
/*    */ 
/*    */   
/*    */   public Set<String> getSupportedOptions() {
/*    */     return SupportedOptions.getAllOptions();
/*    */   }
/*    */   
/*    */   private static IllegalArgumentException b(IllegalArgumentException paramIllegalArgumentException) {
/*    */     return paramIllegalArgumentException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\MixinObfuscationProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */