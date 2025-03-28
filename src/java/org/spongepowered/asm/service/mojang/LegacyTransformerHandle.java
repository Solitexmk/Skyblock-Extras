/*   */ package org.spongepowered.asm.service.mojang;class LegacyTransformerHandle implements ILegacyClassTransformer { public boolean isDelegationExcluded() { try {  }
/* 2 */     catch (RuntimeException runtimeException) { throw b(null); }  return (this.transformer.getClass().getAnnotation(Resource.class) != null); }
/*   */    private final IClassTransformer transformer;
/*   */   LegacyTransformerHandle(IClassTransformer paramIClassTransformer) {
/* 5 */     this.transformer = paramIClassTransformer; } public byte[] transformClassBytes(String paramString1, String paramString2, byte[] paramArrayOfbyte) { return this.transformer.transform(paramString1, paramString2, paramArrayOfbyte); }
/* 6 */   public String getName() { return this.transformer.getClass().getName(); }
/*   */ 
/*   */   
/*   */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*   */     return paramRuntimeException;
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\service\mojang\LegacyTransformerHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */