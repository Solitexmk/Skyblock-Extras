/*    */ package org.spongepowered.asm.util;
/*  2 */ public abstract class JavaVersion { private static double resolveCurrentVersion() { String str = System.getProperty("java.version");
/*  3 */     Matcher matcher = Pattern.compile("[0-9]+\\.[0-9]+").matcher(str);
/*    */     
/*  5 */     try { if (matcher.find())
/*  6 */         return Double.parseDouble(matcher.group());  } catch (RuntimeException runtimeException) { throw b(null); }
/*    */      return 1.6D; }
/*  8 */   private static RuntimeException b(RuntimeException paramRuntimeException) { return paramRuntimeException; } public static double current() { try { if (current == 0.0D)
/*    */       {
/* 10 */         current = resolveCurrentVersion(); }  } catch (RuntimeException runtimeException) { throw b(null); }
/*    */     
/*    */     return current; }
/*    */ 
/*    */   
/*    */   private static double current = 0.0D; }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\JavaVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */