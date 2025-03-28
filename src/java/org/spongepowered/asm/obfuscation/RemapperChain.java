/*    */ package org.spongepowered.asm.obfuscation;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.spongepowered.asm.mixin.extensibility.IRemapper;
/*    */ 
/*    */ public class RemapperChain implements IRemapper {
/*    */   public String mapDesc(String paramString) {
/*  9 */     for (IRemapper iRemapper : this.remappers) {
/*    */       
/* 11 */       String str = iRemapper.mapDesc(paramString);
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
/*    */       try { if (str != null && !str.equals(paramString))
/* 36 */           paramString = str;  }
/*    */       catch (RuntimeException runtimeException) { throw b(null); }
/*    */     
/*    */     }  return paramString; } public String mapFieldName(String paramString1, String paramString2, String paramString3) { for (IRemapper iRemapper : this.remappers) {
/* 40 */       String str = iRemapper.mapFieldName(paramString1, paramString2, paramString3);
/*    */       try {
/*    */         if (str != null && !str.equals(paramString2))
/*    */           paramString2 = str; 
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } 
/*    */     return paramString2; }
/*    */ 
/*    */   
/*    */   public String unmap(String paramString) {
/*    */     for (IRemapper iRemapper : this.remappers) {
/*    */       String str = iRemapper.unmap(paramString);
/*    */       try {
/*    */         if (str != null && !str.equals(paramString))
/*    */           paramString = str; 
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } 
/*    */     return paramString;
/*    */   }
/*    */   
/*    */   private final List<IRemapper> remappers = new ArrayList<IRemapper>();
/*    */   
/*    */   public String unmapDesc(String paramString) {
/*    */     for (IRemapper iRemapper : this.remappers)
/*    */       String str = iRemapper.unmapDesc(paramString); 
/*    */     return paramString;
/*    */   }
/*    */   
/*    */   public String map(String paramString) {
/*    */     for (IRemapper iRemapper : this.remappers)
/*    */       String str = iRemapper.map(paramString); 
/*    */     return paramString;
/*    */   }
/*    */   
/*    */   public String mapMethodName(String paramString1, String paramString2, String paramString3) {
/*    */     for (IRemapper iRemapper : this.remappers) {
/*    */       String str = iRemapper.mapMethodName(paramString1, paramString2, paramString3);
/*    */       try {
/*    */         if (str != null && !str.equals(paramString2))
/*    */           paramString2 = str; 
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } 
/*    */     return paramString2;
/*    */   }
/*    */   
/*    */   public RemapperChain add(IRemapper paramIRemapper) {
/*    */     this.remappers.add(paramIRemapper);
/*    */     return this;
/*    */   }
/*    */   
/*    */   public String toString() {
/*    */     return String.format("RemapperChain[%d]", new Object[] { Integer.valueOf(this.remappers.size()) });
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\obfuscation\RemapperChain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */