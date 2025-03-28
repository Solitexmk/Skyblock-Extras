/*    */ package org.spongepowered.tools.obfuscation.mapping.mcp;
/*    */ 
/*    */ import com.google.common.collect.BiMap;
/*    */ import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
/*    */ import org.spongepowered.asm.obfuscation.mapping.mcp.MappingFieldSrg;
/*    */ 
/*    */ public class MappingProviderSrg extends MappingProvider {
/*  8 */   public MappingProviderSrg(Messager paramMessager, Filer paramFiler) { super(paramMessager, paramFiler); }
/*  9 */   public void read(File paramFile) throws IOException { BiMap biMap1 = this.packageMap; BiMap biMap2 = this.classMap; BiMap biMap3 = this.fieldMap; BiMap biMap4 = this.methodMap; Files.readLines(paramFile, Charset.defaultCharset(), new MappingProviderSrg$1(this, biMap1, biMap2, biMap3, biMap4, paramFile)); } public MappingField getFieldMapping(MappingField paramMappingField) { MappingFieldSrg mappingFieldSrg;
/* 10 */     if (paramMappingField.getDesc() != null)
/* 11 */       mappingFieldSrg = new MappingFieldSrg(paramMappingField); 
/*    */     return (MappingField)this.fieldMap.get(mappingFieldSrg); }
/*    */ 
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\mapping\mcp\MappingProviderSrg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */