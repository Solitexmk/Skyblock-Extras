/*   */ package org.spongepowered.asm.util;
/*   */ class ClassSignature$Lazy extends ClassSignature { private final String sig;
/* 3 */   ClassSignature$Lazy(String paramString) { this.sig = paramString; } private ClassSignature generated; public ClassSignature wake() {
/*   */     
/* 5 */     try { if (this.generated == null)
/* 6 */         this.generated = ClassSignature.of(this.sig);  } catch (RuntimeException runtimeException) { throw b(null); }  return this.generated;
/*   */   }
/*   */   
/*   */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*   */     return paramRuntimeException;
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\ClassSignature$Lazy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */