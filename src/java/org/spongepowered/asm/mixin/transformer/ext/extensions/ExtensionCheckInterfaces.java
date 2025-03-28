/*  1 */ package org.spongepowered.asm.mixin.transformer.ext.extensions;public class ExtensionCheckInterfaces implements IExtension { private static final String AUDIT_DIR = "audit"; private static final String IMPL_REPORT_FILENAME = "mixin_implementation_report"; public ExtensionCheckInterfaces() { File file = new File(Constants.DEBUG_OUTPUT_DIR, "audit");
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
/* 63 */     file.mkdirs(); this.csv = new File(file, "mixin_implementation_report.csv"); this.report = new File(file, "mixin_implementation_report.txt"); try { Files.write("Class,Method,Signature,Interface\n", this.csv, Charsets.ISO_8859_1); } catch (IOException iOException) {} try { String str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()); Files.write("Mixin Implementation Report generated on " + str + "\n", this.report, Charsets.ISO_8859_1); } catch (IOException iOException) {} }
/* 64 */   private static final String IMPL_REPORT_CSV_FILENAME = "mixin_implementation_report.csv"; private static final String IMPL_REPORT_TXT_FILENAME = "mixin_implementation_report.txt"; public void export(MixinEnvironment paramMixinEnvironment, String paramString, boolean paramBoolean, byte[] paramArrayOfbyte) {} public boolean checkActive(MixinEnvironment paramMixinEnvironment) { this.strict = paramMixinEnvironment.getOption(MixinEnvironment.Option.CHECK_IMPLEMENTS_STRICT); return paramMixinEnvironment.getOption(MixinEnvironment.Option.CHECK_IMPLEMENTS); } private void appendToTextReport(PrettyPrinter paramPrettyPrinter) { FileOutputStream fileOutputStream = null; try { fileOutputStream = new FileOutputStream(this.report, true); PrintStream printStream = new PrintStream(fileOutputStream); printStream.print("\n"); paramPrettyPrinter.print(printStream);
/*    */ 
/*    */ 
/*    */       
/*    */        }
/*    */     
/* 70 */     catch (Exception exception)
/*    */     {  }
/*    */     finally
/*    */     { IOUtils.closeQuietly(fileOutputStream); }
/*    */      }
/*    */ 
/*    */   
/*    */   private static final Logger logger = LogManager.getLogger("mixin");
/*    */   private final File csv;
/*    */   private final File report;
/*    */   
/*    */   public void preApply(ITargetClassContext paramITargetClassContext) {
/*    */     ClassInfo classInfo = paramITargetClassContext.getClassInfo();
/*    */     for (ClassInfo.Method method : classInfo.getInterfaceMethods(false))
/*    */       this.interfaceMethods.put(classInfo, method); 
/*    */   }
/*    */   
/*    */   private void appendToCSVReport(String paramString1, ClassInfo.Method paramMethod, String paramString2) {
/*    */     try {
/*    */       Files.append(String.format("%s,%s,%s,%s\n", new Object[] { paramString1, paramMethod.getName(), paramMethod.getDesc(), paramString2 }), this.csv, Charsets.ISO_8859_1);
/*    */     } catch (IOException iOException) {}
/*    */   }
/*    */   
/*    */   private final Multimap<ClassInfo, ClassInfo.Method> interfaceMethods = (Multimap<ClassInfo, ClassInfo.Method>)HashMultimap.create();
/*    */   private boolean strict;
/*    */   
/*    */   public void postApply(ITargetClassContext paramITargetClassContext) {
/*    */     ClassInfo classInfo = paramITargetClassContext.getClassInfo();
/*    */     try {
/*    */       if (classInfo.isAbstract())
/*    */         try {
/*    */           if (!this.strict) {
/*    */             logger.info("{} is skipping abstract target {}", new Object[] { getClass().getSimpleName(), paramITargetClassContext });
/*    */             return;
/*    */           } 
/*    */         } catch (RuntimeException runtimeException) {
/*    */           throw b(null);
/*    */         }  
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     String str = classInfo.getName().replace('/', '.');
/*    */     boolean bool = false;
/*    */     PrettyPrinter prettyPrinter = new PrettyPrinter();
/*    */     prettyPrinter.add("Class: %s", new Object[] { str }).hr();
/*    */     prettyPrinter.add("%-32s %-47s  %s", new Object[] { "Return Type", "Missing Method", "From Interface" }).hr();
/*    */     Set set = classInfo.getInterfaceMethods(true);
/*    */     HashSet hashSet = new HashSet(classInfo.getSuperClass().getInterfaceMethods(true));
/*    */     hashSet.addAll(this.interfaceMethods.removeAll(classInfo));
/*    */     for (ClassInfo.Method method1 : set)
/*    */       ClassInfo.Method method2 = classInfo.findMethodInHierarchy(method1.getName(), method1.getDesc(), ClassInfo.SearchType.ALL_CLASSES, ClassInfo.Traversal.ALL); 
/*    */     try {
/*    */       if (bool) {
/*    */         prettyPrinter.hr().add("%82s%s: %d", new Object[] { "", "Total unimplemented", Integer.valueOf(bool) });
/*    */         prettyPrinter.print(System.err);
/*    */         appendToTextReport(prettyPrinter);
/*    */       } 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\ext\extensions\ExtensionCheckInterfaces.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */