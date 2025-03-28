/*    */ package org.spongepowered.asm.util;
/*    */ 
/*    */ public final class VersionNumber implements Comparable<VersionNumber>, Serializable {
/*    */   public boolean equals(Object paramObject) { 
/*  5 */     try { if (!(paramObject instanceof VersionNumber))
/*    */       {
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
/* 44 */         return false; }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }
/*    */      try {
/*    */     
/*    */     } catch (IllegalArgumentException illegalArgumentException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return (((VersionNumber)paramObject).value == this.value); } private static final long serialVersionUID = 1L; public String toString() { short[] arrayOfShort = unpack(this.value);
/*    */     
/* 52 */     try { (new Object[5])[0] = Short.valueOf(arrayOfShort[0]); (new Object[5])[1] = Short.valueOf(arrayOfShort[1]); }
/*    */     catch (IllegalArgumentException illegalArgumentException)
/*    */     
/* 55 */     { throw b(null); }  try { (new Object[5])[2] = ((this.value & 0x7FFFFFFFL) > 0L) ? String.format(".%d", new Object[] { Short.valueOf(arrayOfShort[2]) }) : ""; if ((this.value & 0x7FFFL) > 0L) (new Object[1])[0] = Short.valueOf(arrayOfShort[3]);  }
/*    */     catch (IllegalArgumentException illegalArgumentException)
/*    */     { throw b(null); }
/*    */     
/*    */     return String.format("%d.%d%3$s%4$s%5$s", new Object[] { null, null, null, "", this.suffix }); }
/*    */ 
/*    */   
/*    */   private VersionNumber(short paramShort1, short paramShort2, short paramShort3, short paramShort4) {
/*    */     this(paramShort1, paramShort2, paramShort3, paramShort4, null);
/*    */   }
/*    */   
/*    */   public static VersionNumber parse(String paramString) {
/*    */     return parse(paramString, NONE);
/*    */   }
/*    */   
/*    */   private VersionNumber(short[] paramArrayOfshort) {
/*    */     this(paramArrayOfshort, null);
/*    */   }
/*    */   
/*    */   private static short[] unpack(long paramLong) {
/*    */     return new short[] { (short)(int)(paramLong >> 48L), (short)(int)(paramLong >> 32L & 0x7FFFL), (short)(int)(paramLong >> 16L & 0x7FFFL), (short)(int)(paramLong & 0x7FFFL) };
/*    */   }
/*    */   
/*    */   public static final VersionNumber NONE = new VersionNumber();
/*    */   
/*    */   private VersionNumber(short[] paramArrayOfshort, String paramString) {
/*    */     this.value = pack(paramArrayOfshort);
/*    */     this.suffix = (paramString != null) ? paramString : "";
/*    */   }
/*    */   
/*    */   public int compareTo(VersionNumber paramVersionNumber) {
/*    */     try {
/*    */       if (paramVersionNumber == null)
/*    */         return 1; 
/*    */     } catch (IllegalArgumentException illegalArgumentException) {
/*    */       throw b(null);
/*    */     } 
/*    */     long l = this.value - paramVersionNumber.value;
/*    */     try {
/*    */       try {
/*    */       
/*    */       } catch (IllegalArgumentException illegalArgumentException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } catch (IllegalArgumentException illegalArgumentException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return (l > 0L) ? 1 : ((l < 0L) ? -1 : 0);
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return (int)(this.value >> 32L) ^ (int)(this.value & 0xFFFFFFFFL);
/*    */   }
/*    */   
/*    */   public static VersionNumber parse(String paramString1, String paramString2) {
/*    */     return parse(paramString1, parse(paramString2));
/*    */   }
/*    */   
/*    */   private VersionNumber(short paramShort1, short paramShort2, short paramShort3, short paramShort4, String paramString) {
/*    */     this.value = pack(new short[] { paramShort1, paramShort2, paramShort3, paramShort4 });
/*    */     this.suffix = (paramString != null) ? paramString : "";
/*    */   }
/*    */   
/*    */   private VersionNumber() {
/*    */     this.value = 0L;
/*    */     this.suffix = "";
/*    */   }
/*    */   
/*    */   private static final Pattern PATTERN = Pattern.compile("^(\\d{1,5})(?:\\.(\\d{1,5})(?:\\.(\\d{1,5})(?:\\.(\\d{1,5}))?)?)?(-[a-zA-Z0-9_\\-]+)?$");
/*    */   private final long value;
/*    */   private final String suffix;
/*    */   
/*    */   private static VersionNumber parse(String paramString, VersionNumber paramVersionNumber) {
/*    */     try {
/*    */       if (paramString == null)
/*    */         return paramVersionNumber; 
/*    */     } catch (IllegalArgumentException illegalArgumentException) {
/*    */       throw b(null);
/*    */     } 
/*    */     Matcher matcher = PATTERN.matcher(paramString);
/*    */     try {
/*    */       if (!matcher.matches())
/*    */         return paramVersionNumber; 
/*    */     } catch (IllegalArgumentException illegalArgumentException) {
/*    */       throw b(null);
/*    */     } 
/*    */     short[] arrayOfShort = new short[4];
/*    */     for (byte b = 0; b < 4;)
/*    */       str = matcher.group(b + 1); 
/*    */     return new VersionNumber(arrayOfShort, matcher.group(5));
/*    */   }
/*    */   
/*    */   private static long pack(short... paramVarArgs) {
/*    */     return paramVarArgs[0] << 48L | paramVarArgs[1] << 32L | (paramVarArgs[2] << 16) | paramVarArgs[3];
/*    */   }
/*    */   
/*    */   private static IllegalArgumentException b(IllegalArgumentException paramIllegalArgumentException) {
/*    */     return paramIllegalArgumentException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\VersionNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */