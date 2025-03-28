/*  1 */ package org.spongepowered.asm.mixin.transformer;public final class Proxy implements IClassTransformer, ILegacyClassTransformer { private static MixinTransformer transformer = new MixinTransformer();
/*    */   
/*  3 */   private static List<Proxy> proxies = new ArrayList<Proxy>();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isDelegationExcluded() {
/*  9 */     return true; } public byte[] transformClassBytes(String paramString1, String paramString2, byte[] paramArrayOfbyte) { 
/* 10 */     try { if (this.isActive)
/*    */         return transformer.transformClassBytes(paramString1, paramString2, paramArrayOfbyte);  }
/*    */     catch (RuntimeException runtimeException) { throw b(null); }
/* 13 */      return paramArrayOfbyte; }
/* 14 */   private boolean isActive = true; public Proxy() { for (Proxy proxy : proxies)
/* 15 */       proxy.isActive = false;  proxies.add(this);
/* 16 */     LogManager.getLogger("mixin").debug("Adding new mixin transformer proxy #{}", new Object[] { Integer.valueOf(proxies.size()) }); } public String getName() { return getClass().getName(); } public byte[] transform(String paramString1, String paramString2, byte[] paramArrayOfbyte) {
/*    */     try {
/* 18 */       if (this.isActive)
/*    */         return transformer.transformClassBytes(paramString1, paramString2, paramArrayOfbyte); 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return paramArrayOfbyte;
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */