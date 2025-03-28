/*  1 */ package org.spongepowered.asm.mixin.struct;class SourceMap$Stratum { private static final String STRATUM_MARK = "*S"; private static final String FILE_MARK = "*F"; public SourceMap$File addFile(int paramInt1, int paramInt2, String paramString1, String paramString2) { SourceMap$File sourceMap$File = this.files.get(paramString2);
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
/* 13 */     if (sourceMap$File == null) {
/*    */       
/* 15 */       sourceMap$File = new SourceMap$File(this.files.size() + 1, paramInt1, paramInt2, paramString1, paramString2); this.files.put(paramString2, sourceMap$File);
/*    */     }  return sourceMap$File; } private static final String LINES_MARK = "*L"; public final String name; private final Map<String, SourceMap$File> files = new LinkedHashMap<String, SourceMap$File>(); void appendTo(StringBuilder paramStringBuilder) { paramStringBuilder.append("*S").append(" ").append(this.name).append("\n"); paramStringBuilder.append("*F").append("\n");
/*    */     for (SourceMap$File sourceMap$File : this.files.values())
/*    */       sourceMap$File.appendFile(paramStringBuilder); 
/* 19 */     paramStringBuilder.append("*L").append("\n");
/*    */     for (SourceMap$File sourceMap$File : this.files.values())
/*    */       sourceMap$File.appendLines(paramStringBuilder);  }
/*    */ 
/*    */   
/*    */   public SourceMap$Stratum(String paramString) {
/*    */     this.name = paramString;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\struct\SourceMap$Stratum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */