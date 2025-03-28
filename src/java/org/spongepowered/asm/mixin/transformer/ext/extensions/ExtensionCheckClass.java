/*   */ package org.spongepowered.asm.mixin.transformer.ext.extensions;public class ExtensionCheckClass implements IExtension { public void postApply(ITargetClassContext paramITargetClassContext) { try {
/* 2 */       paramITargetClassContext.getClassNode().accept((ClassVisitor)new CheckClassAdapter((ClassVisitor)new MixinClassWriter(2)));
/* 3 */     } catch (RuntimeException runtimeException) {
/* 4 */       throw new ExtensionCheckClass$ValidationFailedException(runtimeException.getMessage(), runtimeException);
/* 5 */     }  } public boolean checkActive(MixinEnvironment paramMixinEnvironment) { return paramMixinEnvironment.getOption(MixinEnvironment.Option.DEBUG_VERIFY); }
/*   */ 
/*   */   
/*   */   public void preApply(ITargetClassContext paramITargetClassContext) {}
/*   */   
/*   */   public void export(MixinEnvironment paramMixinEnvironment, String paramString, boolean paramBoolean, byte[] paramArrayOfbyte) {} }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\ext\extensions\ExtensionCheckClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */