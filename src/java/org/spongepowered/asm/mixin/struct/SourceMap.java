/*    */ package org.spongepowered.asm.mixin.struct;public class SourceMap { private static final String DEFAULT_STRATUM = "Mixin"; private static final String NEWLINE = "\n"; private final String sourceFile; private final Map<String, SourceMap$Stratum> strata; private int nextLineOffset; private String defaultStratum;
/*  2 */   public SourceMap(String paramString) { this.strata = new LinkedHashMap<String, SourceMap$Stratum>();
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
/* 20 */     this.nextLineOffset = 1; this.defaultStratum = "Mixin";
/*    */     this.sourceFile = paramString; }
/*    */   public SourceMap$File addFile(String paramString1, String paramString2, String paramString3, int paramInt) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield strata : Ljava/util/Map;
/*    */     //   4: aload_1
/*    */     //   5: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*    */     //   10: checkcast org/spongepowered/asm/mixin/struct/SourceMap$Stratum
/*    */     //   13: astore #5
/*    */     //   15: aload #5
/*    */     //   17: ifnonnull -> 43
/*    */     //   20: new org/spongepowered/asm/mixin/struct/SourceMap$Stratum
/*    */     //   23: dup
/*    */     //   24: aload_1
/*    */     //   25: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   28: astore #5
/*    */     //   30: aload_0
/*    */     //   31: getfield strata : Ljava/util/Map;
/*    */     //   34: aload_1
/*    */     //   35: aload #5
/*    */     //   37: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*    */     //   42: pop
/*    */     //   43: aload #5
/*    */     //   45: aload_0
/*    */     //   46: getfield nextLineOffset : I
/*    */     //   49: iload #4
/*    */     //   51: aload_2
/*    */     //   52: aload_3
/*    */     //   53: invokevirtual addFile : (IILjava/lang/String;Ljava/lang/String;)Lorg/spongepowered/asm/mixin/struct/SourceMap$File;
/*    */     //   56: astore #6
/*    */     //   58: aload_0
/*    */     //   59: dup
/*    */     //   60: getfield nextLineOffset : I
/*    */     //   63: iload #4
/*    */     //   65: iadd
/*    */     //   66: putfield nextLineOffset : I
/*    */     //   69: aload #6
/*    */     //   71: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #4	-> 0
/*    */     //   #28	-> 15
/*    */     //   #10	-> 20
/*    */     //   #7	-> 30
/*    */     //   #21	-> 43
/*    */     //   #18	-> 58
/*    */     //   #17	-> 69 } public String toString() { StringBuilder stringBuilder = new StringBuilder();
/*    */     appendTo(stringBuilder);
/* 24 */     return stringBuilder.toString(); }
/*    */   public SourceMap$File addFile(ClassNode paramClassNode) { return addFile(this.defaultStratum, paramClassNode); }
/*    */   public String getPseudoGeneratedSourceFile() { return this.sourceFile.replace(".java", "$mixin.java"); }
/*    */   public String getSourceFile() { return this.sourceFile; }
/*    */   public SourceMap$File addFile(String paramString1, String paramString2, int paramInt) { return addFile(this.defaultStratum, paramString1, paramString2, paramInt); } private void appendTo(StringBuilder paramStringBuilder) { paramStringBuilder.append("SMAP").append("\n"); paramStringBuilder.append(getSourceFile()).append("\n"); paramStringBuilder.append(this.defaultStratum).append("\n");
/* 29 */     for (SourceMap$Stratum sourceMap$Stratum : this.strata.values())
/*    */       sourceMap$Stratum.appendTo(paramStringBuilder); 
/*    */     paramStringBuilder.append("*E").append("\n"); }
/*    */ 
/*    */   
/*    */   public SourceMap$File addFile(String paramString, ClassNode paramClassNode) {
/*    */     return addFile(paramString, paramClassNode.sourceFile, paramClassNode.name + ".java", Bytecode.getMaxLineNumber(paramClassNode, 500, 50));
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\struct\SourceMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */