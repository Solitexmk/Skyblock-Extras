/* 1 */ package org.spongepowered.asm.service.mojang;public class Blackboard implements IGlobalPropertyService { public final <T> T getProperty(String paramString) { return (T)Launch.blackboard.get(paramString); }
/*   */   
/*   */   public final void setProperty(String paramString, Object paramObject) {
/* 4 */     Launch.blackboard.put(paramString, paramObject);
/*   */   } public final String getPropertyString(String paramString1, String paramString2) {
/* 6 */     Object object = Launch.blackboard.get(paramString1); try {  }
/*   */     catch (RuntimeException runtimeException)
/* 8 */     { throw b(null); }  return (object != null) ? object.toString() : paramString2;
/*   */   }
/*   */   
/*   */   public final <T> T getProperty(String paramString, T paramT) {
/*   */     Object object = Launch.blackboard.get(paramString);
/*   */     try {
/*   */     
/*   */     } catch (RuntimeException runtimeException) {
/*   */       throw b(null);
/*   */     } 
/*   */     return (object != null) ? (T)object : paramT;
/*   */   }
/*   */   
/*   */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*   */     return paramRuntimeException;
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\service\mojang\Blackboard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */