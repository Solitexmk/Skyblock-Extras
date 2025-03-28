/*    */ package org.spongepowered.tools.agent;
/*    */ 
/*    */ import java.lang.instrument.ClassFileTransformer;
/*    */ import java.util.List;
/*    */ import org.spongepowered.asm.mixin.transformer.throwables.MixinReloadException;
/*    */ import org.spongepowered.asm.service.IMixinService;
/*    */ 
/*    */ class MixinAgent$Transformer implements ClassFileTransformer {
/*    */   final MixinAgent this$0;
/*    */   
/*    */   public byte[] transform(ClassLoader paramClassLoader, String paramString, Class<?> paramClass, ProtectionDomain paramProtectionDomain, byte[] paramArrayOfbyte) throws IllegalClassFormatException { 
/* 12 */     try { if (paramClass == null)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 18 */         return null; }  } catch (Throwable throwable) { throw b(null); }
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
/* 32 */     byte[] arrayOfByte = MixinAgent.classLoader.getFakeMixinBytecode(paramClass); if (arrayOfByte != null) { List<String> list = reloadMixin(paramString, paramArrayOfbyte); try { if (list != null)
/*    */           try { if (reApplyMixins(list))
/*    */               return arrayOfByte;  return MixinAgent.ERROR_BYTECODE; } catch (Throwable throwable) { throw b(null); }   } catch (Throwable throwable) { throw b(null); }
/*    */        return MixinAgent.ERROR_BYTECODE; }
/*    */      try { MixinAgent.logger.info("Redefining class " + paramString); return MixinAgent.this.classTransformer.transformClassBytes(null, paramString, paramArrayOfbyte); }
/* 37 */     catch (Throwable throwable)
/*    */     { MixinAgent.logger.error("Error while re-transforming class " + paramString, throwable); return MixinAgent.ERROR_BYTECODE; }
/* 39 */      } private boolean reApplyMixins(List<String> paramList) { IMixinService iMixinService = MixinService.getService(); for (String str1 : paramList)
/*    */       String str2 = str1.replace('/', '.'); 
/*    */     return true; }
/*    */ 
/*    */   
/*    */   private List<String> reloadMixin(String paramString, byte[] paramArrayOfbyte) {
/*    */     MixinAgent.logger.info("Redefining mixin {}", new Object[] { paramString });
/*    */     try {
/*    */       return MixinAgent.this.classTransformer.reload(paramString.replace('/', '.'), paramArrayOfbyte);
/*    */     } catch (MixinReloadException mixinReloadException) {
/*    */       MixinAgent.logger.error("Mixin {} cannot be reloaded, needs a restart to be applied: {} ", new Object[] { mixinReloadException.getMixinInfo(), mixinReloadException.getMessage() });
/*    */     } catch (Throwable throwable) {
/*    */       MixinAgent.logger.error("Error while finding targets for mixin " + paramString, throwable);
/*    */     } 
/*    */     return null;
/*    */   }
/*    */   
/*    */   private static Throwable b(Throwable paramThrowable) {
/*    */     return paramThrowable;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\agent\MixinAgent$Transformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */