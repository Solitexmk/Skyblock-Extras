/*    */ package org.spongepowered.asm.mixin.transformer;class MixinInfo$SubType$Interface extends MixinInfo$SubType { void validate(MixinInfo$State paramMixinInfo$State, List<ClassInfo> paramList) {
/*    */     
/*  3 */     try { if (!MixinEnvironment.getCompatibilityLevel().supportsMethodsInInterfaces())
/*    */       {
/*    */ 
/*    */         
/*  7 */         throw new InvalidMixinException(this.mixin, "Interface mixin not supported in current enviromnment"); }  } catch (InvalidMixinException invalidMixinException) { throw c(null); }
/*    */ 
/*    */     
/* 10 */     MixinInfo$MixinClassNode mixinInfo$MixinClassNode = paramMixinInfo$State.getClassNode();
/*    */     try {
/*    */       if (!"java/lang/Object".equals(mixinInfo$MixinClassNode.superName))
/*    */         throw new InvalidMixinException(this.mixin, "Super class of " + this + " is invalid, found " + mixinInfo$MixinClassNode.superName.replace('/', '.')); 
/*    */     } catch (InvalidMixinException invalidMixinException) {
/*    */       throw c(null);
/*    */     } 
/*    */   }
/*    */   
/*    */   MixinPreProcessorStandard createPreProcessor(MixinInfo$MixinClassNode paramMixinInfo$MixinClassNode) {
/*    */     return new MixinPreProcessorInterface(this.mixin, paramMixinInfo$MixinClassNode);
/*    */   }
/*    */   
/*    */   MixinInfo$SubType$Interface(MixinInfo paramMixinInfo) {
/*    */     super(paramMixinInfo, "@Mixin", true);
/*    */   }
/*    */   
/*    */   private static InvalidMixinException c(InvalidMixinException paramInvalidMixinException) {
/*    */     return paramInvalidMixinException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MixinInfo$SubType$Interface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */