/*    */ package org.spongepowered.tools.obfuscation;
/*    */ import javax.annotation.processing.Messager;
/*    */ import javax.lang.model.element.Element;
/*    */ import javax.tools.Diagnostic;
/*    */ import org.spongepowered.asm.obfuscation.mapping.IMapping;
/*    */ import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
/*    */ import org.spongepowered.tools.obfuscation.mirror.TypeHandle;
/*    */ 
/*    */ class AnnotatedMixinElementHandlerShadow extends AnnotatedMixinElementHandler {
/*    */   private static Mappings$MappingConflictException b(Mappings$MappingConflictException paramMappings$MappingConflictException) {
/*    */     return paramMappings$MappingConflictException;
/*    */   }
/*    */   
/*    */   private void registerShadowForTarget(AnnotatedMixinElementHandlerShadow$AnnotatedElementShadow<?, ?> paramAnnotatedMixinElementHandlerShadow$AnnotatedElementShadow, TypeHandle paramTypeHandle) {
/* 15 */     ObfuscationData<?> obfuscationData = paramAnnotatedMixinElementHandlerShadow$AnnotatedElementShadow.getObfuscationData(this.obf.getDataProvider(), paramTypeHandle); try { if (obfuscationData.isEmpty())
/*    */       { try {
/*    */         
/*    */         } catch (Mappings$MappingConflictException mappings$MappingConflictException) {
/*    */           throw b(null);
/*    */         }  String str = this.mixin.isMultiTarget() ? (" in target " + paramTypeHandle) : ""; 
/*    */         try { if (paramTypeHandle.isSimulated())
/* 22 */           { paramAnnotatedMixinElementHandlerShadow$AnnotatedElementShadow.printMessage((Messager)this.ap, Diagnostic.Kind.WARNING, "Unable to locate obfuscation mapping" + str + " for @Shadow " + paramAnnotatedMixinElementHandlerShadow$AnnotatedElementShadow); }
/* 23 */           else { paramAnnotatedMixinElementHandlerShadow$AnnotatedElementShadow.printMessage((Messager)this.ap, Diagnostic.Kind.WARNING, "Unable to locate obfuscation mapping" + str + " for @Shadow " + paramAnnotatedMixinElementHandlerShadow$AnnotatedElementShadow); }  } catch (Mappings$MappingConflictException mappings$MappingConflictException) { throw b(null); }  }  } catch (Mappings$MappingConflictException mappings$MappingConflictException) { throw b(null); }
/*    */      for (ObfuscationType obfuscationType : obfuscationData) { try { paramAnnotatedMixinElementHandlerShadow$AnnotatedElementShadow.addMapping(obfuscationType, (IMapping)obfuscationData.get(obfuscationType)); }
/* 25 */       catch (Mappings$MappingConflictException mappings$MappingConflictException) { paramAnnotatedMixinElementHandlerShadow$AnnotatedElementShadow.printMessage((Messager)this.ap, Diagnostic.Kind.ERROR, "Mapping conflict for @Shadow " + paramAnnotatedMixinElementHandlerShadow$AnnotatedElementShadow + ": " + mappings$MappingConflictException.getNew().getSimpleName() + " for target " + paramTypeHandle + " conflicts with existing mapping " + mappings$MappingConflictException.getOld().getSimpleName()); }
/*    */        }
/*    */   
/*    */   }
/*    */   
/*    */   public void registerShadow(AnnotatedMixinElementHandlerShadow$AnnotatedElementShadow<?, ?> paramAnnotatedMixinElementHandlerShadow$AnnotatedElementShadow) {
/*    */     try {
/*    */       validateTarget((Element)paramAnnotatedMixinElementHandlerShadow$AnnotatedElementShadow.getElement(), paramAnnotatedMixinElementHandlerShadow$AnnotatedElementShadow.getAnnotation(), paramAnnotatedMixinElementHandlerShadow$AnnotatedElementShadow.getName(), "@Shadow");
/*    */       if (!paramAnnotatedMixinElementHandlerShadow$AnnotatedElementShadow.shouldRemap())
/*    */         return; 
/*    */     } catch (Mappings$MappingConflictException mappings$MappingConflictException) {
/*    */       throw b(null);
/*    */     } 
/*    */     for (TypeHandle typeHandle : this.mixin.getTargets())
/*    */       registerShadowForTarget(paramAnnotatedMixinElementHandlerShadow$AnnotatedElementShadow, typeHandle); 
/*    */   }
/*    */   
/*    */   AnnotatedMixinElementHandlerShadow(IMixinAnnotationProcessor paramIMixinAnnotationProcessor, AnnotatedMixin paramAnnotatedMixin) {
/*    */     super(paramIMixinAnnotationProcessor, paramAnnotatedMixin);
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\AnnotatedMixinElementHandlerShadow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */