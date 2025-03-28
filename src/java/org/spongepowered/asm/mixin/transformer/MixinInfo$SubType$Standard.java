/*    */ package org.spongepowered.asm.mixin.transformer;
/*  2 */ class MixinInfo$SubType$Standard extends MixinInfo$SubType { void validate(MixinInfo$State paramMixinInfo$State, List<ClassInfo> paramList) { MixinInfo$MixinClassNode mixinInfo$MixinClassNode = paramMixinInfo$State.getClassNode();
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
/* 20 */     for (ClassInfo classInfo : paramList); } MixinInfo$SubType$Standard(MixinInfo paramMixinInfo) {
/* 21 */     super(paramMixinInfo, "@Mixin", false);
/*    */   }
/*    */   
/*    */   MixinPreProcessorStandard createPreProcessor(MixinInfo$MixinClassNode paramMixinInfo$MixinClassNode) {
/*    */     return new MixinPreProcessorStandard(this.mixin, paramMixinInfo$MixinClassNode);
/*    */   }
/*    */   
/*    */   private static InvalidMixinException c(InvalidMixinException paramInvalidMixinException) {
/*    */     return paramInvalidMixinException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MixinInfo$SubType$Standard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */