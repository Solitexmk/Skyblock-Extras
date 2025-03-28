/*    */ package org.spongepowered.tools.obfuscation.mapping.mcp;
/*    */ import java.io.PrintWriter;
/*    */ import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
/*    */ import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
/*    */ import org.spongepowered.tools.obfuscation.ObfuscationType;
/*    */ import org.spongepowered.tools.obfuscation.mapping.IMappingConsumer;
/*    */ 
/*    */ public class MappingWriterSrg extends MappingWriter {
/*    */   public MappingWriterSrg(Messager paramMessager, Filer paramFiler) {
/* 10 */     super(paramMessager, paramFiler);
/*    */   }
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
/*    */   protected void writeFieldMappings(PrintWriter paramPrintWriter, IMappingConsumer.MappingSet<MappingField> paramMappingSet) {
/* 24 */     for (IMappingConsumer.MappingSet.Pair<MappingField> pair : paramMappingSet)
/*    */       paramPrintWriter.println(formatFieldMapping(pair));  } public void write(String paramString, ObfuscationType paramObfuscationType, IMappingConsumer.MappingSet<MappingField> paramMappingSet, IMappingConsumer.MappingSet<MappingMethod> paramMappingSet1) {
/*    */     try {
/* 27 */       if (paramString == null)
/*    */         return; 
/*    */     } catch (Exception exception) {
/*    */       throw b(null);
/*    */     }  PrintWriter printWriter = null; 
/*    */     try { printWriter = openFileWriter(paramString, paramObfuscationType + " output SRGs");
/*    */       writeFieldMappings(printWriter, paramMappingSet);
/* 34 */       writeMethodMappings(printWriter, paramMappingSet1); } catch (IOException iOException) { iOException.printStackTrace(); }
/*    */     finally { if (printWriter != null)
/* 36 */         try { printWriter.close(); }
/*    */         catch (Exception exception) {}  }
/*    */   
/*    */   }
/*    */   
/*    */   protected void writeMethodMappings(PrintWriter paramPrintWriter, IMappingConsumer.MappingSet<MappingMethod> paramMappingSet) {
/*    */     for (IMappingConsumer.MappingSet.Pair<MappingMethod> pair : paramMappingSet)
/*    */       paramPrintWriter.println(formatMethodMapping(pair)); 
/*    */   }
/*    */   
/*    */   protected String formatFieldMapping(IMappingConsumer.MappingSet.Pair<MappingField> paramPair) {
/*    */     return String.format("FD: %s/%s %s/%s", new Object[] { ((MappingField)paramPair.from).getOwner(), ((MappingField)paramPair.from).getName(), ((MappingField)paramPair.to).getOwner(), ((MappingField)paramPair.to).getName() });
/*    */   }
/*    */   
/*    */   protected String formatMethodMapping(IMappingConsumer.MappingSet.Pair<MappingMethod> paramPair) {
/*    */     return String.format("MD: %s %s %s %s", new Object[] { ((MappingMethod)paramPair.from).getName(), ((MappingMethod)paramPair.from).getDesc(), ((MappingMethod)paramPair.to).getName(), ((MappingMethod)paramPair.to).getDesc() });
/*    */   }
/*    */   
/*    */   private static Exception b(Exception paramException) {
/*    */     return paramException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\mapping\mcp\MappingWriterSrg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */