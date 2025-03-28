/*  1 */ package org.spongepowered.asm.mixin.transformer.debug;public class RuntimeDecompiler extends IFernflowerLogger implements IDecompiler, IResultSaver { private final Map<String, Object> options = (Map<String, Object>)ImmutableMap.builder()
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
/* 17 */     .put("din", "0").put("rbr", "0").put("dgs", "1").put("asc", "1").put("den", "1").put("hdc", "1").put("ind", "    ").build();
/*    */   
/*    */   protected final Logger logger;
/*    */   
/*    */   private final File outputPath;
/*    */ 
/*    */   
/*    */   public void createArchive(String paramString1, String paramString2, Manifest paramManifest) {}
/*    */   
/*    */   public void saveFolder(String paramString) {}
/*    */   
/*    */   public void copyFile(String paramString1, String paramString2, String paramString3) {}
/*    */   
/*    */   public void decompile(File paramFile) {
/*    */     try {
/*    */       Fernflower fernflower = new Fernflower(new RuntimeDecompiler$1(this), this, this.options, this);
/* 33 */       fernflower.getStructContext().addSpace(paramFile, true);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       fernflower.decompileContext();
/* 40 */     } catch (Throwable throwable) {
/*    */       this.logger.warn("Decompilation error while processing {}", new Object[] { paramFile.getName() });
/*    */     }  } public void copyEntry(String paramString1, String paramString2, String paramString3, String paramString4) {} public RuntimeDecompiler(File paramFile) { this.logger = LogManager.getLogger("fernflower"); this.outputPath = paramFile;
/* 43 */     if (this.outputPath.exists())
/*    */       try {
/*    */         FileUtils.deleteDirectory(this.outputPath);
/*    */       } catch (IOException iOException) {
/*    */         this.logger.warn("Error cleaning output directory: {}", new Object[] { iOException.getMessage() });
/*    */       }   }
/*    */ 
/*    */   
/*    */   private static final Level[] SEVERITY_LEVELS = new Level[] { Level.TRACE, Level.INFO, Level.WARN, Level.ERROR };
/*    */   
/*    */   public void writeMessage(String paramString, IFernflowerLogger.Severity paramSeverity, Throwable paramThrowable) {
/*    */     this.logger.log(SEVERITY_LEVELS[paramSeverity.ordinal()], paramString, paramThrowable);
/*    */   }
/*    */   
/*    */   public void writeMessage(String paramString, Throwable paramThrowable) {
/*    */     this.logger.warn("{} {}: {}", new Object[] { paramString, paramThrowable.getClass().getSimpleName(), paramThrowable.getMessage() });
/*    */   }
/*    */   
/*    */   public void writeMessage(String paramString, IFernflowerLogger.Severity paramSeverity) {
/*    */     this.logger.log(SEVERITY_LEVELS[paramSeverity.ordinal()], paramString);
/*    */   }
/*    */   
/*    */   public void closeArchive(String paramString1, String paramString2) {}
/*    */   
/*    */   public void startReadingClass(String paramString) {
/*    */     this.logger.info("Decompiling {}", new Object[] { paramString });
/*    */   }
/*    */   
/*    */   public void saveClassEntry(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
/*    */   
/*    */   public void saveDirEntry(String paramString1, String paramString2, String paramString3) {}
/*    */   
/*    */   public void saveClassFile(String paramString1, String paramString2, String paramString3, String paramString4, int[] paramArrayOfint) {
/*    */     File file = new File(this.outputPath, paramString2 + ".java");
/*    */     file.getParentFile().mkdirs();
/*    */     try {
/*    */       this.logger.info("Writing {}", new Object[] { file.getAbsolutePath() });
/*    */       Files.write(paramString4, file, Charsets.UTF_8);
/*    */     } catch (IOException iOException) {
/*    */       writeMessage("Cannot write source file " + file, iOException);
/*    */     } 
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\debug\RuntimeDecompiler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */