/*  1 */ package org.spongepowered.asm.mixin.refmap;final class RemappingReferenceMapper$1 implements LineProcessor<Object> { public Object getResult() { return null; }
/*    */ 
/*    */ 
/*    */   
/*    */   final Map val$map;
/*    */   
/*    */   public boolean processLine(String paramString) throws IOException {
/*    */     try {
/*  9 */       if (!Strings.isNullOrEmpty(paramString)) try { if (!paramString.startsWith("#")) {
/* 10 */             boolean bool1 = false, bool2 = false; try { try {  } catch (IOException iOException) { throw b(null); }  }
/*    */             catch (IOException iOException) { throw b(null); }
/* 12 */              if (bool2 = paramString.startsWith("MD: ") ? true : (paramString.startsWith("FD: ") ? true : false)) { String[] arrayOfString = paramString.substring(4).split(" ", 4); map.put(arrayOfString[bool1].substring(arrayOfString[bool1].lastIndexOf('/') + 1), arrayOfString[bool2].substring(arrayOfString[bool2].lastIndexOf('/') + 1)); }
/*    */             
/*    */             return true;
/*    */           } 
/*    */           return true; }
/*    */         catch (IOException iOException)
/*    */         { throw b(null); }
/*    */          
/*    */     } catch (IOException iOException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return true;
/*    */   }
/*    */   
/*    */   private static IOException b(IOException paramIOException) {
/*    */     return paramIOException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\refmap\RemappingReferenceMapper$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */