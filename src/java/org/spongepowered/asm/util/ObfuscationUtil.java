/*    */ package org.spongepowered.asm.util;
/*    */ public abstract class ObfuscationUtil {
/*    */   public static String mapDescriptor(String paramString, ObfuscationUtil$IClassRemapper paramObfuscationUtil$IClassRemapper) {
/*  4 */     return remapDescriptor(paramString, paramObfuscationUtil$IClassRemapper, false);
/*    */   }
/*  6 */   public static String unmapDescriptor(String paramString, ObfuscationUtil$IClassRemapper paramObfuscationUtil$IClassRemapper) { return remapDescriptor(paramString, paramObfuscationUtil$IClassRemapper, true); } private static Object remap(String paramString, ObfuscationUtil$IClassRemapper paramObfuscationUtil$IClassRemapper, boolean paramBoolean) { try {  }
/*    */     catch (IllegalArgumentException illegalArgumentException)
/*  8 */     { throw b(null); }  String str = paramBoolean ? paramObfuscationUtil$IClassRemapper.unmap(paramString) : paramObfuscationUtil$IClassRemapper.map(paramString);
/*    */     try {
/*    */     
/*    */     } catch (IllegalArgumentException illegalArgumentException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return (str != null) ? str : paramString; }
/*    */ 
/*    */   
/*    */   private static String remapDescriptor(String paramString, ObfuscationUtil$IClassRemapper paramObfuscationUtil$IClassRemapper, boolean paramBoolean) {
/* 18 */     StringBuilder stringBuilder1 = new StringBuilder(); StringBuilder stringBuilder2 = null; for (byte b = 0; b < paramString.length(); b++) {
/*    */       char c = paramString.charAt(b);
/*    */       try {
/* 21 */         if (stringBuilder2 != null) { if (c == ';') {
/* 22 */             stringBuilder1.append('L').append(remap(stringBuilder2.toString(), paramObfuscationUtil$IClassRemapper, paramBoolean)).append(';');
/*    */             stringBuilder2 = null;
/*    */           } else {
/*    */             stringBuilder2.append(c);
/*    */           }  }
/*    */         else if (c == 'L')
/*    */         { stringBuilder2 = new StringBuilder(); }
/*    */         else
/*    */         { stringBuilder1.append(c); }
/*    */       
/*    */       } catch (IllegalArgumentException illegalArgumentException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } 
/*    */     try {
/*    */       if (stringBuilder2 != null)
/*    */         throw new IllegalArgumentException("Invalid descriptor '" + paramString + "', missing ';'"); 
/*    */     } catch (IllegalArgumentException illegalArgumentException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return stringBuilder1.toString();
/*    */   }
/*    */   
/*    */   private static IllegalArgumentException b(IllegalArgumentException paramIllegalArgumentException) {
/*    */     return paramIllegalArgumentException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\ObfuscationUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */