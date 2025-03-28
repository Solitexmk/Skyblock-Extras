/*    */ package org.spongepowered.tools.obfuscation.mapping.common;
/*    */ 
/*    */ public abstract class MappingWriter implements IMappingWriter {
/*    */   private final Messager messager;
/*    */   
/*  6 */   public MappingWriter(Messager paramMessager, Filer paramFiler) { this.messager = paramMessager;
/*  7 */     this.filer = paramFiler; } private final Filer filer; protected PrintWriter openFileWriter(String paramString1, String paramString2) throws IOException { if (paramString1.matches("^.*[\\\\/:].*$")) {
/*    */       File file = new File(paramString1);
/*    */       
/*    */       file.getParentFile().mkdirs();
/* 11 */       this.messager.printMessage(Diagnostic.Kind.NOTE, "Writing " + paramString2 + " to " + file.getAbsolutePath());
/* 12 */       return new PrintWriter(file);
/*    */     } 
/*    */     FileObject fileObject = this.filer.createResource(StandardLocation.CLASS_OUTPUT, "", paramString1, new javax.lang.model.element.Element[0]);
/*    */     this.messager.printMessage(Diagnostic.Kind.NOTE, "Writing " + paramString2 + " to " + (new File(fileObject.toUri())).getAbsolutePath());
/*    */     return new PrintWriter(fileObject.openWriter()); }
/*    */ 
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\mapping\common\MappingWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */