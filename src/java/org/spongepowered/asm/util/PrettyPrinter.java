/*     */ package org.spongepowered.asm.util;
/*     */ public class PrettyPrinter {
/*   3 */   private final PrettyPrinter$HorizontalRule horizontalRule = new PrettyPrinter$HorizontalRule(this, new char[] { '*' }); public PrettyPrinter tr(Object... paramVarArgs) {
/*   4 */     th(true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  41 */     addLine(this.table.addRow(paramVarArgs));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  93 */     this.recalcWidth = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 110 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PrettyPrinter hr(char paramChar) {
/*     */     addLine(new PrettyPrinter$HorizontalRule(this, new char[] { paramChar }));
/* 194 */     return this;
/*     */   }
/*     */   public PrettyPrinter trace() { return trace(getDefaultLoggerName()); }
/*     */   private void logSpecial(Logger paramLogger, Level paramLevel, PrettyPrinter$ISpecialEntry paramPrettyPrinter$ISpecialEntry) { paramLogger.log(paramLevel, "/*{}*/", new Object[] { paramPrettyPrinter$ISpecialEntry.toString() }); }
/*     */   public PrettyPrinter addWrapped(int paramInt, String paramString, Object... paramVarArgs) { String str1 = ""; String str2 = String.format(paramString, paramVarArgs).replace("\t", "    "); Matcher matcher = Pattern.compile("^(\\s+)(.*)$").matcher(str2); if (matcher.matches())
/*     */       str1 = matcher.group(1);  try { for (String str : getWrapped(paramInt, str2, str1))
/*     */         addLine(str);  } catch (Exception exception) { add(str2); }  return this; }
/*     */   public PrettyPrinter kv(String paramString, Object paramObject) { addLine(new PrettyPrinter$KeyValue(this, paramString, paramObject)); return kvWidth(paramString.length()); }
/*     */   public PrettyPrinter add(Object paramObject) { return add(paramObject, 0); }
/*     */   public PrettyPrinter th() { return th(false); }
/*     */   protected int wrapWidth = 80;
/*     */   public PrettyPrinter spacing(int paramInt) { try { if (this.table == null)
/*     */         this.table = new PrettyPrinter$Table();  } catch (RuntimeException runtimeException) { throw b(null); }
/*     */      this.table.setColSpacing(paramInt); return this; }
/*     */   public PrettyPrinter() { this(100); }
/*     */   public PrettyPrinter add(Object paramObject, int paramInt) { String str = Strings.repeat(" ", paramInt); return append(paramObject, paramInt, str); }
/*     */   public PrettyPrinter trace(String paramString, Level paramLevel) { return trace(System.err, LogManager.getLogger(paramString), paramLevel); } public PrettyPrinter hr() { return hr('*'); } private void printString(PrintStream paramPrintStream, String paramString) { try { if (paramString != null)
/*     */         paramPrintStream.printf("/* %-" + this.width + "s */\n", new Object[] { paramString });  }
/*     */     catch (RuntimeException runtimeException) { throw b(null); }
/* 213 */      } public PrettyPrinter table(Object... paramVarArgs) { this.table = new PrettyPrinter$Table(); PrettyPrinter$Column prettyPrinter$Column = null; Object[] arrayOfObject = paramVarArgs; int i = arrayOfObject.length; byte b = 0; while (true) { if (b < i) { Object object = arrayOfObject[b]; if (object instanceof String) { prettyPrinter$Column = this.table.addColumn((String)object); } else { continue; }  } else { break; }  b++; }  return this; }
/*     */   public PrettyPrinter add(Map<?, ?> paramMap) { for (Map.Entry<?, ?> entry : paramMap.entrySet()) { try {  } catch (RuntimeException runtimeException) { throw b(null); }  String str = (entry.getKey() == null) ? "null" : entry.getKey().toString(); kv(str, entry.getValue()); }  return this; }
/*     */   private final List<Object> lines = new ArrayList();
/*     */   private PrettyPrinter$Table table;
/*     */   private boolean recalcWidth;
/* 218 */   protected int width; protected int kvKeyWidth; protected String kvFormat; public PrettyPrinter trace(String paramString) { return trace(System.err, LogManager.getLogger(paramString)); } public PrettyPrinter addWrapped(String paramString, Object... paramVarArgs) { return addWrapped(this.wrapWidth, paramString, paramVarArgs); } public PrettyPrinter trace(PrintStream paramPrintStream, String paramString) { return trace(paramPrintStream, LogManager.getLogger(paramString)); } public PrettyPrinter add(Throwable paramThrowable, int paramInt) { for (; paramThrowable != null; paramThrowable = paramThrowable.getCause()) { add("%s: %s", new Object[] { paramThrowable.getClass().getName(), paramThrowable.getMessage() }); add(paramThrowable.getStackTrace(), paramInt); }  return this; } private List<String> getWrapped(int paramInt, String paramString1, String paramString2) { ArrayList<String> arrayList = new ArrayList(); while (paramString1.length() > paramInt) { int i = paramString1.lastIndexOf(' ', paramInt); if (i < 10) i = paramInt;  }  try { if (paramString1.length() > 0) arrayList.add(paramString1);  } catch (RuntimeException runtimeException) { throw b(null); }  return arrayList; } public PrettyPrinter trace(PrintStream paramPrintStream, Logger paramLogger) { return trace(paramPrintStream, paramLogger, Level.DEBUG); } public PrettyPrinter addIndexed(Object[] paramArrayOfObject) { int i = String.valueOf(paramArrayOfObject.length - 1).length(); String str = "[%" + i + "d] %s"; byte b = 0; try { while (b < paramArrayOfObject.length) { add(str, new Object[] { Integer.valueOf(b), paramArrayOfObject[b] }); b++; }  } catch (RuntimeException runtimeException) { throw b(null); }  return this; } private void updateWidth() { if (this.recalcWidth) { this.recalcWidth = false; Iterator iterator = this.lines.iterator(); }  } private static String getDefaultLoggerName() { String str = (new Throwable()).getStackTrace()[2].getClassName(); int i = str.lastIndexOf('.'); try {  } catch (RuntimeException runtimeException) { throw b(null); }  return (i == -1) ? str : str.substring(i + 1); } public PrettyPrinter add() { addLine(""); return this; } public PrettyPrinter add(String paramString, Object... paramVarArgs) { String str = String.format(paramString, paramVarArgs); addLine(str); this.width = Math.max(this.width, str.length()); return this; } public PrettyPrinter add(Throwable paramThrowable) { return add(paramThrowable, 4); } public int wrapTo() { return this.wrapWidth; } public PrettyPrinter centre() { if (!this.lines.isEmpty()) { Object object = this.lines.get(this.lines.size() - 1); try { if (object instanceof String) addLine(new PrettyPrinter$CentredText(this, this.lines.remove(this.lines.size() - 1)));  } catch (RuntimeException runtimeException) { throw b(null); }  }  return this; } public PrettyPrinter trace(PrintStream paramPrintStream, Logger paramLogger, Level paramLevel) { log(paramLogger, paramLevel); print(paramPrintStream); return this; } private PrettyPrinter th(boolean paramBoolean) { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield table : Lorg/spongepowered/asm/util/PrettyPrinter$Table;
/*     */     //   4: ifnonnull -> 25
/*     */     //   7: aload_0
/*     */     //   8: new org/spongepowered/asm/util/PrettyPrinter$Table
/*     */     //   11: dup
/*     */     //   12: invokespecial <init> : ()V
/*     */     //   15: putfield table : Lorg/spongepowered/asm/util/PrettyPrinter$Table;
/*     */     //   18: goto -> 25
/*     */     //   21: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   24: athrow
/*     */     //   25: iload_1
/*     */     //   26: ifeq -> 46
/*     */     //   29: aload_0
/*     */     //   30: getfield table : Lorg/spongepowered/asm/util/PrettyPrinter$Table;
/*     */     //   33: getfield addHeader : Z
/*     */     //   36: ifeq -> 68
/*     */     //   39: goto -> 46
/*     */     //   42: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   45: athrow
/*     */     //   46: aload_0
/*     */     //   47: getfield table : Lorg/spongepowered/asm/util/PrettyPrinter$Table;
/*     */     //   50: invokevirtual headerAdded : ()V
/*     */     //   53: aload_0
/*     */     //   54: aload_0
/*     */     //   55: getfield table : Lorg/spongepowered/asm/util/PrettyPrinter$Table;
/*     */     //   58: invokespecial addLine : (Ljava/lang/Object;)V
/*     */     //   61: goto -> 68
/*     */     //   64: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   67: athrow
/*     */     //   68: aload_0
/*     */     //   69: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #102	-> 0
/*     */     //   #158	-> 7
/*     */     //   #114	-> 25
/*     */     //   #168	-> 46
/*     */     //   #132	-> 53
/*     */     //   #83	-> 68
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   0	18	21	java/lang/RuntimeException
/*     */     //   25	39	42	java/lang/RuntimeException
/*     */     //   29	61	64	java/lang/RuntimeException } public PrettyPrinter addWithIndices(Collection<?> paramCollection) { return addIndexed(paramCollection.toArray()); }
/* 219 */   public PrettyPrinter table(String... paramVarArgs) { this.table = new PrettyPrinter$Table(); String[] arrayOfString; int i; byte b; for (arrayOfString = paramVarArgs, i = arrayOfString.length, b = 0; b < i; ) { String str = arrayOfString[b]; this.table.addColumn(str);
/*     */       b++; }
/*     */     
/*     */     return this; }
/*     */ 
/*     */   
/*     */   public PrettyPrinter add(Object[] paramArrayOfObject, String paramString) {
/*     */     Object[] arrayOfObject;
/*     */     int i;
/*     */     byte b;
/*     */     for (arrayOfObject = paramArrayOfObject, i = arrayOfObject.length, b = 0; b < i; b++) {
/*     */       Object object = arrayOfObject[b];
/*     */       add(paramString, new Object[] { object });
/*     */     } 
/*     */     return this;
/*     */   }
/*     */   
/*     */   public PrettyPrinter kvWidth(int paramInt) {
/*     */     try {
/*     */       if (paramInt > this.kvKeyWidth) {
/*     */         this.kvKeyWidth = paramInt;
/*     */         this.kvFormat = makeKvFormat(paramInt);
/*     */       } 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     this.recalcWidth = true;
/*     */     return this;
/*     */   }
/*     */   
/*     */   public PrettyPrinter add(Object[] paramArrayOfObject) {
/*     */     return add(paramArrayOfObject, "%s");
/*     */   }
/*     */   
/*     */   private void printSpecial(PrintStream paramPrintStream, PrettyPrinter$ISpecialEntry paramPrettyPrinter$ISpecialEntry) {
/*     */     paramPrintStream.printf("/*%s*/\n", new Object[] { paramPrettyPrinter$ISpecialEntry.toString() });
/*     */   }
/*     */   
/*     */   private void logString(Logger paramLogger, Level paramLevel, String paramString) {
/*     */     try {
/*     */       if (paramString != null)
/*     */         paramLogger.log(paramLevel, String.format("/* %-" + this.width + "s */", new Object[] { paramString })); 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   public PrettyPrinter(int paramInt) {
/*     */     this.width = 100;
/*     */     this.wrapWidth = 80;
/*     */     this.kvKeyWidth = 10;
/*     */     this.kvFormat = makeKvFormat(this.kvKeyWidth);
/*     */     this.width = paramInt;
/*     */   }
/*     */   
/*     */   public PrettyPrinter add(String paramString) {
/*     */     addLine(paramString);
/*     */     this.width = Math.max(this.width, paramString.length());
/*     */     return this;
/*     */   }
/*     */   
/*     */   public PrettyPrinter log(Logger paramLogger) {
/*     */     return log(paramLogger, Level.INFO);
/*     */   }
/*     */   
/*     */   public static void print(Throwable paramThrowable) {
/*     */     (new PrettyPrinter()).add(paramThrowable).print(System.err);
/*     */   }
/*     */   
/*     */   public PrettyPrinter kv(String paramString1, String paramString2, Object... paramVarArgs) {
/*     */     return kv(paramString1, String.format(paramString2, paramVarArgs));
/*     */   }
/*     */   
/*     */   public PrettyPrinter wrapTo(int paramInt) {
/*     */     this.wrapWidth = paramInt;
/*     */     return this;
/*     */   }
/*     */   
/*     */   public PrettyPrinter trace(PrintStream paramPrintStream, Level paramLevel) {
/*     */     return trace(paramPrintStream, getDefaultLoggerName(), paramLevel);
/*     */   }
/*     */   
/*     */   public PrettyPrinter trace(Logger paramLogger, Level paramLevel) {
/*     */     return trace(System.err, paramLogger, paramLevel);
/*     */   }
/*     */   
/*     */   public static void dumpStack() {
/*     */     (new PrettyPrinter()).add(new Exception("Stack trace")).print(System.err);
/*     */   }
/*     */   
/*     */   private void addLine(Object paramObject) {
/*     */     try {
/*     */       if (paramObject == null)
/*     */         return; 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     this.lines.add(paramObject);
/*     */     this.recalcWidth |= paramObject instanceof PrettyPrinter$IVariableWidthEntry;
/*     */   }
/*     */   
/*     */   public PrettyPrinter add(StackTraceElement[] paramArrayOfStackTraceElement, int paramInt) {
/*     */     String str = Strings.repeat(" ", paramInt);
/*     */     StackTraceElement[] arrayOfStackTraceElement;
/*     */     int i;
/*     */     byte b;
/*     */     for (arrayOfStackTraceElement = paramArrayOfStackTraceElement, i = arrayOfStackTraceElement.length, b = 0; b < i; ) {
/*     */       StackTraceElement stackTraceElement = arrayOfStackTraceElement[b];
/*     */       add("%s%s", new Object[] { str, stackTraceElement });
/*     */       b++;
/*     */     } 
/*     */     return this;
/*     */   }
/*     */   
/*     */   private static String makeKvFormat(int paramInt) {
/*     */     return String.format("%%%ds : %%s", new Object[] { Integer.valueOf(paramInt) });
/*     */   }
/*     */   
/*     */   public PrettyPrinter print(PrintStream paramPrintStream) {
/*     */     updateWidth();
/*     */     printSpecial(paramPrintStream, this.horizontalRule);
/*     */     for (PrettyPrinter$ISpecialEntry prettyPrinter$ISpecialEntry : this.lines) {
/*     */       try {
/*     */         if (prettyPrinter$ISpecialEntry instanceof PrettyPrinter$ISpecialEntry) {
/*     */           printSpecial(paramPrintStream, prettyPrinter$ISpecialEntry);
/*     */           continue;
/*     */         } 
/*     */       } catch (RuntimeException runtimeException) {
/*     */         throw b(null);
/*     */       } 
/*     */       printString(paramPrintStream, prettyPrinter$ISpecialEntry.toString());
/*     */     } 
/*     */     printSpecial(paramPrintStream, this.horizontalRule);
/*     */     return this;
/*     */   }
/*     */   
/*     */   public PrettyPrinter trace(PrintStream paramPrintStream) {
/*     */     return trace(paramPrintStream, getDefaultLoggerName());
/*     */   }
/*     */   
/*     */   public PrettyPrinter table() {
/*     */     this.table = new PrettyPrinter$Table();
/*     */     return this;
/*     */   }
/*     */   
/*     */   public PrettyPrinter log(Logger paramLogger, Level paramLevel) {
/*     */     updateWidth();
/*     */     logSpecial(paramLogger, paramLevel, this.horizontalRule);
/*     */     for (PrettyPrinter$ISpecialEntry prettyPrinter$ISpecialEntry : this.lines) {
/*     */       try {
/*     */         if (prettyPrinter$ISpecialEntry instanceof PrettyPrinter$ISpecialEntry)
/*     */           logSpecial(paramLogger, paramLevel, prettyPrinter$ISpecialEntry); 
/*     */       } catch (RuntimeException runtimeException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     logSpecial(paramLogger, paramLevel, this.horizontalRule);
/*     */     return this;
/*     */   }
/*     */   
/*     */   public PrettyPrinter print() {
/*     */     return print(System.err);
/*     */   }
/*     */   
/*     */   private PrettyPrinter append(Object paramObject, int paramInt, String paramString) {
/*     */     try {
/*     */       if (paramObject instanceof String)
/*     */         return add("%s%s", new Object[] { paramString, paramObject }); 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     if (paramObject instanceof Iterable)
/*     */       for (Object object : paramObject)
/*     */         append(object, paramInt, paramString);  
/*     */     try {
/*     */       if (paramObject instanceof Map) {
/*     */         kvWidth(paramInt);
/*     */         return add((Map<?, ?>)paramObject);
/*     */       } 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (paramObject instanceof PrettyPrinter$IPrettyPrintable)
/*     */         return add((PrettyPrinter$IPrettyPrintable)paramObject); 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (paramObject instanceof Throwable)
/*     */         return add((Throwable)paramObject, paramInt); 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (paramObject.getClass().isArray())
/*     */         return add((Object[])paramObject, paramInt + "%s"); 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return add("%s%s", new Object[] { paramString, paramObject });
/*     */   }
/*     */   
/*     */   public PrettyPrinter trace(Level paramLevel) {
/*     */     return trace(getDefaultLoggerName(), paramLevel);
/*     */   }
/*     */   
/*     */   public PrettyPrinter trace(PrintStream paramPrintStream, String paramString, Level paramLevel) {
/*     */     return trace(paramPrintStream, LogManager.getLogger(paramString), paramLevel);
/*     */   }
/*     */   
/*     */   public PrettyPrinter trace(Logger paramLogger) {
/*     */     return trace(System.err, paramLogger);
/*     */   }
/*     */   
/*     */   public PrettyPrinter add(PrettyPrinter$IPrettyPrintable paramPrettyPrinter$IPrettyPrintable) {
/*     */     try {
/*     */       if (paramPrettyPrinter$IPrettyPrintable != null)
/*     */         paramPrettyPrinter$IPrettyPrintable.print(this); 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return this;
/*     */   }
/*     */   
/*     */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*     */     return paramRuntimeException;
/*     */   }
/*     */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\PrettyPrinter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */