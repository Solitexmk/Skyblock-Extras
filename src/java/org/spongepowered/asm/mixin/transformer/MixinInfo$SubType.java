/*  1 */ package org.spongepowered.asm.mixin.transformer;abstract class MixinInfo$SubType { protected final MixinInfo mixin; protected final String annotationType; MixinInfo$SubType(MixinInfo paramMixinInfo, String paramString, boolean paramBoolean) { this.mixin = paramMixinInfo;
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
/* 12 */     this.annotationType = paramString;
/*    */     this.targetMustBeInterface = paramBoolean; }
/*    */    protected final boolean targetMustBeInterface; protected boolean detached; static MixinInfo$SubType getTypeFor(MixinInfo paramMixinInfo) {
/*    */     try {
/*    */       if (!paramMixinInfo.getClassInfo().isInterface())
/*    */         return new MixinInfo$SubType$Standard(paramMixinInfo); 
/*    */     } catch (InvalidMixinException invalidMixinException) {
/*    */       throw b(null);
/*    */     } 
/*    */     boolean bool = false;
/* 22 */     for (ClassInfo$Method classInfo$Method : paramMixinInfo.getClassInfo().getMethods()) {
/*    */       try {
/*    */       
/*    */       } catch (InvalidMixinException invalidMixinException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } 
/*    */     try {
/*    */       if (bool)
/*    */         return new MixinInfo$SubType$Interface(paramMixinInfo); 
/*    */     } catch (InvalidMixinException invalidMixinException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return new MixinInfo$SubType$Accessor(paramMixinInfo);
/*    */   }
/*    */   
/*    */   Collection<String> getInterfaces() {
/*    */     return Collections.emptyList();
/*    */   }
/*    */   
/*    */   boolean isLoadable() {
/*    */     return false;
/*    */   }
/*    */   
/*    */   boolean isDetachedSuper() {
/*    */     return this.detached;
/*    */   }
/*    */   
/*    */   void validateTarget(String paramString, ClassInfo paramClassInfo) {
/*    */     boolean bool = paramClassInfo.isInterface();
/*    */     try {
/*    */       if (bool != this.targetMustBeInterface) {
/*    */         try {
/*    */         
/*    */         } catch (InvalidMixinException invalidMixinException) {
/*    */           throw b(null);
/*    */         } 
/*    */         String str = bool ? "" : "not ";
/*    */         throw new InvalidMixinException(this.mixin, this.annotationType + " target type mismatch: " + paramString + " is " + str + "an interface in " + this);
/*    */       } 
/*    */     } catch (InvalidMixinException invalidMixinException) {
/*    */       throw b(null);
/*    */     } 
/*    */   }
/*    */   
/*    */   abstract void validate(MixinInfo$State paramMixinInfo$State, List<ClassInfo> paramList);
/*    */   
/*    */   abstract MixinPreProcessorStandard createPreProcessor(MixinInfo$MixinClassNode paramMixinInfo$MixinClassNode);
/*    */   
/*    */   private static InvalidMixinException b(InvalidMixinException paramInvalidMixinException) {
/*    */     return paramInvalidMixinException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MixinInfo$SubType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */