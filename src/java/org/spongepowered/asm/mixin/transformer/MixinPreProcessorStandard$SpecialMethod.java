/*    */ package org.spongepowered.asm.mixin.transformer;
/*    */ import java.lang.annotation.Annotation;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.gen.Accessor;
/*    */ 
/*    */ enum MixinPreProcessorStandard$SpecialMethod {
/*  7 */   MERGE(true),
/*    */ 
/*    */ 
/*    */   
/*    */   OVERWRITE(true, (Class)Overwrite.class),
/*    */ 
/*    */   
/*    */   SHADOW(false, (Class)Shadow.class),
/*    */ 
/*    */   
/* 17 */   ACCESSOR(false, (Class)Accessor.class),
/*    */   INVOKER(false, (Class)Invoker.class);
/*    */   
/*    */   MixinPreProcessorStandard$SpecialMethod(boolean paramBoolean) {
/*    */     this.isOverwrite = paramBoolean;
/*    */     this.annotation = null;
/*    */     this.description = "overwrite";
/*    */   }
/*    */   
/*    */   public String toString() {
/*    */     return this.description;
/*    */   }
/*    */   
/*    */   private static final MixinPreProcessorStandard$SpecialMethod[] $VALUES = new MixinPreProcessorStandard$SpecialMethod[] { MERGE, OVERWRITE, SHADOW, ACCESSOR, INVOKER };
/*    */   final boolean isOverwrite;
/*    */   final Class<? extends Annotation> annotation;
/*    */   final String description;
/*    */   
/*    */   MixinPreProcessorStandard$SpecialMethod(boolean paramBoolean, Class<? extends Annotation> paramClass) {
/*    */     this.isOverwrite = paramBoolean;
/*    */     this.annotation = paramClass;
/*    */     this.description = "@" + Bytecode.getSimpleName(paramClass);
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MixinPreProcessorStandard$SpecialMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */