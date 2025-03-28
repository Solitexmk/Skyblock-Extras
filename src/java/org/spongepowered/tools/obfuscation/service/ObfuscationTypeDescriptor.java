/*    */ package org.spongepowered.tools.obfuscation.service;
/*    */ 
/*    */ import org.spongepowered.tools.obfuscation.ObfuscationEnvironment;
/*    */ 
/*    */ public class ObfuscationTypeDescriptor
/*    */ {
/*    */   private final String key;
/*    */   private final String inputFileArgName;
/*    */   private final String extraInputFilesArgName;
/*    */   private final String outFileArgName;
/*    */   private final Class<? extends ObfuscationEnvironment> environmentType;
/*    */   
/*    */   public ObfuscationTypeDescriptor(String paramString1, String paramString2, String paramString3, String paramString4, Class<? extends ObfuscationEnvironment> paramClass) {
/* 14 */     this.key = paramString1;
/*    */     this.inputFileArgName = paramString2;
/*    */     this.extraInputFilesArgName = paramString3;
/*    */     this.outFileArgName = paramString4;
/*    */     this.environmentType = paramClass;
/*    */   }
/*    */   
/*    */   public ObfuscationTypeDescriptor(String paramString1, String paramString2, String paramString3, Class<? extends ObfuscationEnvironment> paramClass) {
/*    */     this(paramString1, paramString2, null, paramString3, paramClass);
/*    */   }
/*    */   
/*    */   public String getOutputFileOption() {
/*    */     return this.outFileArgName;
/*    */   }
/*    */   
/*    */   public String getInputFileOption() {
/*    */     return this.inputFileArgName;
/*    */   }
/*    */   
/*    */   public Class<? extends ObfuscationEnvironment> getEnvironmentType() {
/*    */     return this.environmentType;
/*    */   }
/*    */   
/*    */   public String getExtraInputFilesOption() {
/*    */     return this.extraInputFilesArgName;
/*    */   }
/*    */   
/*    */   public final String getKey() {
/*    */     return this.key;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\service\ObfuscationTypeDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */