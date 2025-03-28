/*  1 */ package org.spongepowered.asm.mixin.transformer;class MixinInfo$SubType$Accessor extends MixinInfo$SubType { private final Collection<String> interfaces = new ArrayList<String>();
/*    */   MixinPreProcessorStandard createPreProcessor(MixinInfo$MixinClassNode paramMixinInfo$MixinClassNode) {
/*  3 */     return new MixinPreProcessorAccessor(this.mixin, paramMixinInfo$MixinClassNode);
/*    */   }
/*    */   
/*  6 */   MixinInfo$SubType$Accessor(MixinInfo paramMixinInfo) { super(paramMixinInfo, "@Mixin", false);
/*    */ 
/*    */     
/*  9 */     this.interfaces.add(paramMixinInfo.getClassRef()); } void validate(MixinInfo$State paramMixinInfo$State, List<ClassInfo> paramList) { MixinInfo$MixinClassNode mixinInfo$MixinClassNode = paramMixinInfo$State.getClassNode();
/*    */     
/* 11 */     try { if (!"java/lang/Object".equals(mixinInfo$MixinClassNode.superName))
/*    */       {
/*    */ 
/*    */         
/* 15 */         throw new InvalidMixinException(this.mixin, "Super class of " + this + " is invalid, found " + mixinInfo$MixinClassNode.superName.replace('/', '.')); }  } catch (InvalidMixinException invalidMixinException) { throw c(null); }  }
/* 16 */   Collection<String> getInterfaces() { return this.interfaces; } boolean isLoadable() { return true; }
/*    */ 
/*    */   
/*    */   void validateTarget(String paramString, ClassInfo paramClassInfo) {
/*    */     boolean bool = paramClassInfo.isInterface();
/*    */     try {
/*    */       if (bool)
/*    */         try {
/*    */           if (!MixinEnvironment.getCompatibilityLevel().supportsMethodsInInterfaces())
/*    */             throw new InvalidMixinException(this.mixin, "Accessor mixin targetting an interface is not supported in current enviromnment"); 
/*    */         } catch (InvalidMixinException invalidMixinException) {
/*    */           throw c(null);
/*    */         }  
/*    */     } catch (InvalidMixinException invalidMixinException) {
/*    */       throw c(null);
/*    */     } 
/*    */   }
/*    */   
/*    */   private static InvalidMixinException c(InvalidMixinException paramInvalidMixinException) {
/*    */     return paramInvalidMixinException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MixinInfo$SubType$Accessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */