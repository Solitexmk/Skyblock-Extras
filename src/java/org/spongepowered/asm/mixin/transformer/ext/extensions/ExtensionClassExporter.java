/*    */ package org.spongepowered.asm.mixin.transformer.ext.extensions;
/*    */ 
/*    */ public class ExtensionClassExporter implements IExtension {
/*    */   private static final String DECOMPILER_CLASS = "org.spongepowered.asm.mixin.transformer.debug.RuntimeDecompiler";
/*    */   private static final String EXPORT_CLASS_DIR = "class";
/*    */   private static final String EXPORT_JAVA_DIR = "java";
/*    */   
/*    */   private IDecompiler initDecompiler(MixinEnvironment paramMixinEnvironment, File paramFile) { try {
/*  9 */       if (!paramMixinEnvironment.getOption(MixinEnvironment.Option.DEBUG_EXPORT_DECOMPILE)) {
/*    */         return null;
/*    */       }
/*    */     } catch (Throwable throwable) {
/*    */       throw b(null);
/*    */     } 
/*    */     
/*    */     try {
/*    */       boolean bool = paramMixinEnvironment.getOption(MixinEnvironment.Option.DEBUG_EXPORT_DECOMPILE_THREADED);
/*    */       try {
/*    */       
/*    */       } catch (Throwable throwable) {
/*    */         throw b(null);
/*    */       } 
/*    */       
/*    */       try { logger.info("Attempting to load Fernflower decompiler{}", new Object[] { bool ? " (Threaded mode)" : "" }); }
/*    */       catch (Throwable throwable)
/* 26 */       { throw b(null); }  String str = "org.spongepowered.asm.mixin.transformer.debug.RuntimeDecompiler" + (bool ? "Async" : ""); Class<?> clazz = Class.forName(str); Constructor<?> constructor = clazz.getDeclaredConstructor(new Class[] { File.class });
/*    */       IDecompiler iDecompiler = (IDecompiler)constructor.newInstance(new Object[] { paramFile });
/*    */       try {
/*    */       
/*    */       } catch (Throwable throwable) {
/*    */         throw b(null);
/*    */       } 
/*    */       logger.info("Fernflower decompiler was successfully initialised, exported classes will be decompiled{}", new Object[] { bool ? " in a separate thread" : "" });
/* 34 */       return iDecompiler;
/*    */     } catch (Throwable throwable) {
/*    */       logger.info("Fernflower could not be loaded, exported classes will not be decompiled. {}: {}", new Object[] { throwable.getClass().getSimpleName(), throwable.getMessage() });
/*    */       return null;
/*    */     }  }
/*    */   public void export(MixinEnvironment paramMixinEnvironment, String paramString, boolean paramBoolean, byte[] paramArrayOfbyte) { // Byte code:
/*    */     //   0: iload_3
/*    */     //   1: ifne -> 21
/*    */     //   4: aload_1
/*    */     //   5: getstatic org/spongepowered/asm/mixin/MixinEnvironment$Option.DEBUG_EXPORT : Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;
/*    */     //   8: invokevirtual getOption : (Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;)Z
/*    */     //   11: ifeq -> 120
/*    */     //   14: goto -> 21
/*    */     //   17: invokestatic b : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
/*    */     //   20: athrow
/*    */     //   21: aload_1
/*    */     //   22: getstatic org/spongepowered/asm/mixin/MixinEnvironment$Option.DEBUG_EXPORT_FILTER : Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;
/*    */     //   25: invokevirtual getOptionValue : (Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;)Ljava/lang/String;
/*    */     //   28: astore #5
/*    */     //   30: iload_3
/*    */     //   31: ifne -> 63
/*    */     //   34: aload #5
/*    */     //   36: ifnull -> 63
/*    */     //   39: goto -> 46
/*    */     //   42: invokestatic b : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
/*    */     //   45: athrow
/*    */     //   46: aload_0
/*    */     //   47: aload #5
/*    */     //   49: aload_2
/*    */     //   50: invokespecial applyFilter : (Ljava/lang/String;Ljava/lang/String;)Z
/*    */     //   53: ifeq -> 120
/*    */     //   56: goto -> 63
/*    */     //   59: invokestatic b : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
/*    */     //   62: athrow
/*    */     //   63: invokestatic getProfiler : ()Lorg/spongepowered/asm/util/perf/Profiler;
/*    */     //   66: ldc 'debug.export'
/*    */     //   68: invokevirtual begin : (Ljava/lang/String;)Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*    */     //   71: astore #6
/*    */     //   73: aload_0
/*    */     //   74: aload_2
/*    */     //   75: bipush #46
/*    */     //   77: bipush #47
/*    */     //   79: invokevirtual replace : (CC)Ljava/lang/String;
/*    */     //   82: aload #4
/*    */     //   84: invokevirtual dumpClass : (Ljava/lang/String;[B)Ljava/io/File;
/*    */     //   87: astore #7
/*    */     //   89: aload_0
/*    */     //   90: getfield decompiler : Lorg/spongepowered/asm/mixin/transformer/ext/IDecompiler;
/*    */     //   93: ifnull -> 114
/*    */     //   96: aload_0
/*    */     //   97: getfield decompiler : Lorg/spongepowered/asm/mixin/transformer/ext/IDecompiler;
/*    */     //   100: aload #7
/*    */     //   102: invokeinterface decompile : (Ljava/io/File;)V
/*    */     //   107: goto -> 114
/*    */     //   110: invokestatic b : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
/*    */     //   113: athrow
/*    */     //   114: aload #6
/*    */     //   116: invokevirtual end : ()Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*    */     //   119: pop
/*    */     //   120: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     //   #28	-> 21
/*    */     //   #38	-> 30
/*    */     //   #12	-> 63
/*    */     //   #42	-> 73
/*    */     //   #19	-> 89
/*    */     //   #3	-> 96
/*    */     //   #18	-> 114
/*    */     //   #6	-> 120
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   0	14	17	java/lang/RuntimeException
/*    */     //   30	39	42	java/lang/RuntimeException
/*    */     //   34	56	59	java/lang/RuntimeException
/*    */     //   89	107	110	java/lang/RuntimeException } public void preApply(ITargetClassContext paramITargetClassContext) {} public File dumpClass(String paramString, byte[] paramArrayOfbyte) { File file = new File(this.classExportDir, paramString + ".class");
/*    */     
/* 41 */     try { FileUtils.writeByteArrayToFile(file, paramArrayOfbyte); } catch (IOException iOException) {} return file; }
/*    */   public void postApply(ITargetClassContext paramITargetClassContext) {}
/* 43 */   private boolean applyFilter(String paramString1, String paramString2) { return Pattern.compile(prepareFilter(paramString1), 2).matcher(paramString2).matches(); } public boolean isDecompilerActive() { try {  } catch (RuntimeException runtimeException) { throw b(null); }  return (this.decompiler != null); } public ExtensionClassExporter(MixinEnvironment paramMixinEnvironment) { this.classExportDir = new File(Constants.DEBUG_OUTPUT_DIR, "class"); this.decompiler = initDecompiler(paramMixinEnvironment, new File(Constants.DEBUG_OUTPUT_DIR, "java")); try {
/*    */       FileUtils.deleteDirectory(this.classExportDir);
/* 45 */     } catch (IOException iOException) {
/*    */       logger.warn("Error cleaning class output directory: {}", new Object[] { iOException.getMessage() });
/*    */     }  }
/*    */ 
/*    */   
/*    */   public boolean checkActive(MixinEnvironment paramMixinEnvironment) {
/*    */     return true;
/*    */   }
/*    */   
/*    */   private String prepareFilter(String paramString) {
/*    */     paramString = "^\\Q" + paramString.replace("**", "").replace("*", "").replace("?", "") + "\\E$";
/*    */     return paramString.replace("", "\\E.*\\Q").replace("", "\\E[^\\.]+\\Q").replace("", "\\E.\\Q").replace("\\Q\\E", "");
/*    */   }
/*    */   
/*    */   private static final Logger logger = LogManager.getLogger("mixin");
/*    */   private final File classExportDir;
/*    */   private final IDecompiler decompiler;
/*    */   
/*    */   private static Throwable b(Throwable paramThrowable) {
/*    */     return paramThrowable;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\ext\extensions\ExtensionClassExporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */