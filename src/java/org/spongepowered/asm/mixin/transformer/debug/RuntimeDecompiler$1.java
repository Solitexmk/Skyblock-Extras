/*   */ package org.spongepowered.asm.mixin.transformer.debug;class RuntimeDecompiler$1 implements IBytecodeProvider {
/*   */   public byte[] getBytecode(String paramString1, String paramString2) throws IOException {
/*   */     try {
/* 4 */       if (this.byteCode == null)
/*   */         this.byteCode = InterpreterUtil.getBytes(new File(paramString1)); 
/*   */     } catch (IOException iOException) {
/*   */       throw b(null);
/*   */     } 
/*   */     return this.byteCode;
/*   */   }
/*   */   
/*   */   private byte[] byteCode;
/*   */   final RuntimeDecompiler this$0;
/*   */   
/*   */   private static IOException b(IOException paramIOException) {
/*   */     return paramIOException;
/*   */   }
/*   */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\debug\RuntimeDecompiler$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */