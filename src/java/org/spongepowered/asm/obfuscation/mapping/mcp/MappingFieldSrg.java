/*    */ package org.spongepowered.asm.obfuscation.mapping.mcp;
/*    */ 
/*    */ public class MappingFieldSrg extends MappingField {
/*    */   private final String srg;
/*    */   
/*    */   private static String getNameFromSrg(String paramString) { 
/*  7 */     try { if (paramString == null)
/*  8 */         return null;  } catch (RuntimeException runtimeException) { throw c(null); }
/*    */      int i = paramString.lastIndexOf('/'); 
/*    */     try {  }
/*    */     catch (RuntimeException runtimeException)
/* 12 */     { throw c(null); }  return (i > -1) ? paramString.substring(i + 1) : paramString; }
/* 13 */   public String serialise() { return this.srg; } public MappingFieldSrg(String paramString) { super(getOwnerFromSrg(paramString), getNameFromSrg(paramString), null); this.srg = paramString; } private static String getOwnerFromSrg(String paramString) { 
/* 14 */     try { if (paramString == null)
/* 15 */         return null;  } catch (RuntimeException runtimeException) { throw c(null); }  int i = paramString.lastIndexOf('/'); try {  } catch (RuntimeException runtimeException) { throw c(null); }  return (i > -1) ? paramString.substring(0, i) : null; } public MappingFieldSrg(MappingField paramMappingField) { super(paramMappingField.getOwner(), paramMappingField.getName(), null);
/*    */     this.srg = paramMappingField.getOwner() + "/" + paramMappingField.getName(); }
/*    */ 
/*    */   
/*    */   private static RuntimeException c(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\obfuscation\mapping\mcp\MappingFieldSrg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */