/*   */ package org.spongepowered.tools.obfuscation;
/*   */ final class ObfuscationEnvironment$RemapperProxy implements ObfuscationUtil.IClassRemapper { final ObfuscationEnvironment this$0; public String unmap(String paramString) { 
/* 3 */     try { if (ObfuscationEnvironment.this.mappingProvider == null)
/*   */       {
/* 5 */         return null; }  } catch (RuntimeException runtimeException) { throw b(null); }  return ObfuscationEnvironment.this.mappingProvider.getClassMapping(paramString); }
/* 6 */   private static RuntimeException b(RuntimeException paramRuntimeException) { return paramRuntimeException; } public String map(String paramString) { try { if (ObfuscationEnvironment.this.mappingProvider == null)
/* 7 */         return null;  } catch (RuntimeException runtimeException) { throw b(null); }
/*   */     
/*   */     return ObfuscationEnvironment.this.mappingProvider.getClassMapping(paramString); }
/*   */    }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\ObfuscationEnvironment$RemapperProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */