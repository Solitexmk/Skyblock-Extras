/*     */ package org.spongepowered.asm.util;class ClassSignature$Token implements ClassSignature$IToken { static final String SYMBOLS = "+-*";
/*     */   private final boolean inner;
/*     */   private boolean array;
/*     */   
/*     */   boolean isRaw() { 
/*     */     try {  }
/*     */     catch (RuntimeException runtimeException)
/*   8 */     { throw b(null); }  return (this.signature == null); } private List<ClassSignature$IToken> getSuffix() { 
/*   9 */     try { if (this.suffix == null)
/*     */       {
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
/* 109 */         this.suffix = new ArrayList<ClassSignature$IToken>(); }  } catch (RuntimeException runtimeException) { throw b(null); }  return this.suffix; } public String asBound() { StringBuilder stringBuilder = new StringBuilder(); try { if (this.type != null)
/*     */         stringBuilder.append(this.type);  } catch (RuntimeException runtimeException) { throw b(null); }  if (this.classBound != null)
/* 111 */       for (ClassSignature$Token classSignature$Token : this.classBound)
/*     */         stringBuilder.append(classSignature$Token.asType());  
/*     */     if (this.ifaceBound != null)
/*     */       for (ClassSignature$Token classSignature$Token : this.ifaceBound)
/*     */         stringBuilder.append(':').append(classSignature$Token.asType());  
/*     */     return stringBuilder.toString(); }
/*     */ 
/*     */   
/*     */   boolean hasInterfaceBound() {
/*     */     try {
/*     */     
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return (this.ifaceBound != null);
/*     */   }
/*     */   
/*     */   ClassSignature$Token(boolean paramBoolean) {
/*     */     this(null, paramBoolean);
/*     */   }
/*     */   
/*     */   ClassSignature$Token(String paramString, boolean paramBoolean) {
/*     */     this.inner = paramBoolean;
/*     */     this.type = paramString;
/*     */   }
/*     */   
/*     */   private List<ClassSignature$Token> getClassBound() {
/*     */     try {
/*     */       if (this.classBound == null)
/*     */         this.classBound = new ArrayList<ClassSignature$Token>(); 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return this.classBound;
/*     */   }
/*     */   
/*     */   public String asType() {
/*     */     return asType(false);
/*     */   }
/*     */   
/*     */   ClassSignature$IToken addTypeArgument(char paramChar) {
/*     */     try {
/*     */       if (this.tail != null)
/*     */         return this.tail.addTypeArgument(paramChar); 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     ClassSignature$Token classSignature$Token = new ClassSignature$Token(paramChar);
/*     */     getSignature().add(classSignature$Token);
/*     */     return classSignature$Token;
/*     */   }
/*     */   
/*     */   String getClassType() {
/*     */     try {
/*     */     
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return (this.type != null) ? this.type : "java/lang/Object";
/*     */   }
/*     */   
/*     */   ClassSignature$Token addBound(String paramString, boolean paramBoolean) {
/*     */     try {
/*     */       if (paramBoolean)
/*     */         return addClassBound(paramString); 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return addInterfaceBound(paramString);
/*     */   }
/*     */   
/*     */   ClassSignature$Token(char paramChar) {
/*     */     this();
/*     */     this.symbol = paramChar;
/*     */   }
/*     */   
/*     */   public String asType(boolean paramBoolean) {
/*     */     // Byte code:
/*     */     //   0: new java/lang/StringBuilder
/*     */     //   3: dup
/*     */     //   4: invokespecial <init> : ()V
/*     */     //   7: astore_2
/*     */     //   8: aload_0
/*     */     //   9: getfield array : Z
/*     */     //   12: ifeq -> 29
/*     */     //   15: aload_2
/*     */     //   16: bipush #91
/*     */     //   18: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   21: pop
/*     */     //   22: goto -> 29
/*     */     //   25: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   28: athrow
/*     */     //   29: aload_0
/*     */     //   30: getfield symbol : C
/*     */     //   33: ifeq -> 52
/*     */     //   36: aload_2
/*     */     //   37: aload_0
/*     */     //   38: getfield symbol : C
/*     */     //   41: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   44: pop
/*     */     //   45: goto -> 52
/*     */     //   48: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   51: athrow
/*     */     //   52: aload_0
/*     */     //   53: getfield type : Ljava/lang/String;
/*     */     //   56: ifnonnull -> 68
/*     */     //   59: aload_2
/*     */     //   60: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   63: areturn
/*     */     //   64: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   67: athrow
/*     */     //   68: aload_0
/*     */     //   69: getfield inner : Z
/*     */     //   72: ifne -> 89
/*     */     //   75: aload_2
/*     */     //   76: bipush #76
/*     */     //   78: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   81: pop
/*     */     //   82: goto -> 89
/*     */     //   85: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   88: athrow
/*     */     //   89: aload_2
/*     */     //   90: aload_0
/*     */     //   91: getfield type : Ljava/lang/String;
/*     */     //   94: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   97: pop
/*     */     //   98: iload_1
/*     */     //   99: ifne -> 232
/*     */     //   102: aload_0
/*     */     //   103: getfield signature : Ljava/util/List;
/*     */     //   106: ifnull -> 175
/*     */     //   109: goto -> 116
/*     */     //   112: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   115: athrow
/*     */     //   116: aload_2
/*     */     //   117: bipush #60
/*     */     //   119: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   122: pop
/*     */     //   123: aload_0
/*     */     //   124: getfield signature : Ljava/util/List;
/*     */     //   127: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   132: astore_3
/*     */     //   133: aload_3
/*     */     //   134: invokeinterface hasNext : ()Z
/*     */     //   139: ifeq -> 168
/*     */     //   142: aload_3
/*     */     //   143: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   148: checkcast org/spongepowered/asm/util/ClassSignature$IToken
/*     */     //   151: astore #4
/*     */     //   153: aload_2
/*     */     //   154: aload #4
/*     */     //   156: invokeinterface asType : ()Ljava/lang/String;
/*     */     //   161: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   164: pop
/*     */     //   165: goto -> 133
/*     */     //   168: aload_2
/*     */     //   169: bipush #62
/*     */     //   171: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   174: pop
/*     */     //   175: aload_0
/*     */     //   176: getfield suffix : Ljava/util/List;
/*     */     //   179: ifnull -> 232
/*     */     //   182: aload_0
/*     */     //   183: getfield suffix : Ljava/util/List;
/*     */     //   186: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   191: astore_3
/*     */     //   192: aload_3
/*     */     //   193: invokeinterface hasNext : ()Z
/*     */     //   198: ifeq -> 232
/*     */     //   201: aload_3
/*     */     //   202: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   207: checkcast org/spongepowered/asm/util/ClassSignature$IToken
/*     */     //   210: astore #4
/*     */     //   212: aload_2
/*     */     //   213: bipush #46
/*     */     //   215: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   218: aload #4
/*     */     //   220: invokeinterface asType : ()Ljava/lang/String;
/*     */     //   225: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   228: pop
/*     */     //   229: goto -> 192
/*     */     //   232: aload_0
/*     */     //   233: getfield inner : Z
/*     */     //   236: ifne -> 253
/*     */     //   239: aload_2
/*     */     //   240: bipush #59
/*     */     //   242: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   245: pop
/*     */     //   246: goto -> 253
/*     */     //   249: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   252: athrow
/*     */     //   253: aload_2
/*     */     //   254: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   257: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #31	-> 0
/*     */     //   #7	-> 8
/*     */     //   #95	-> 15
/*     */     //   #60	-> 29
/*     */     //   #22	-> 36
/*     */     //   #66	-> 52
/*     */     //   #63	-> 59
/*     */     //   #3	-> 68
/*     */     //   #55	-> 75
/*     */     //   #47	-> 89
/*     */     //   #102	-> 98
/*     */     //   #92	-> 102
/*     */     //   #6	-> 116
/*     */     //   #44	-> 123
/*     */     //   #45	-> 153
/*     */     //   #23	-> 165
/*     */     //   #1	-> 168
/*     */     //   #29	-> 175
/*     */     //   #49	-> 182
/*     */     //   #32	-> 212
/*     */     //   #43	-> 229
/*     */     //   #57	-> 232
/*     */     //   #69	-> 239
/*     */     //   #11	-> 253
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   8	22	25	java/lang/RuntimeException
/*     */     //   29	45	48	java/lang/RuntimeException
/*     */     //   52	64	64	java/lang/RuntimeException
/*     */     //   68	82	85	java/lang/RuntimeException
/*     */     //   89	109	112	java/lang/RuntimeException
/*     */     //   232	246	249	java/lang/RuntimeException
/*     */   }
/*     */   
/*     */   ClassSignature$Token addInnerClass(String paramString) {
/*     */     this.tail = new ClassSignature$Token(paramString, true);
/*     */     getSuffix().add(this.tail);
/*     */     return this.tail;
/*     */   }
/*     */   
/*     */   ClassSignature$IToken addTypeArgument(ClassSignature$TokenHandle paramClassSignature$TokenHandle) {
/*     */     try {
/*     */       if (this.tail != null)
/*     */         return this.tail.addTypeArgument(paramClassSignature$TokenHandle); 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     ClassSignature$TokenHandle classSignature$TokenHandle = paramClassSignature$TokenHandle.clone();
/*     */     getSignature().add(classSignature$TokenHandle);
/*     */     return classSignature$TokenHandle;
/*     */   }
/*     */   
/*     */   ClassSignature$IToken addTypeArgument(ClassSignature$Token paramClassSignature$Token) {
/*     */     try {
/*     */       if (this.tail != null)
/*     */         return this.tail.addTypeArgument(paramClassSignature$Token); 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     getSignature().add(paramClassSignature$Token);
/*     */     return paramClassSignature$Token;
/*     */   }
/*     */   
/*     */   private List<ClassSignature$Token> getIfaceBound() {
/*     */     try {
/*     */       if (this.ifaceBound == null)
/*     */         this.ifaceBound = new ArrayList<ClassSignature$Token>(); 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return this.ifaceBound;
/*     */   }
/*     */   
/*     */   ClassSignature$Token(String paramString) {
/*     */     this(paramString, false);
/*     */   }
/*     */   
/*     */   public ClassSignature$Token asToken() {
/*     */     return this;
/*     */   }
/*     */   
/*     */   ClassSignature$Token addClassBound(String paramString) {
/*     */     ClassSignature$Token classSignature$Token = new ClassSignature$Token(paramString);
/*     */     getClassBound().add(classSignature$Token);
/*     */     return classSignature$Token;
/*     */   }
/*     */   
/*     */   public String toString() {
/*     */     return asType();
/*     */   }
/*     */   
/*     */   private List<ClassSignature$IToken> getSignature() {
/*     */     try {
/*     */       if (this.signature == null)
/*     */         this.signature = new ArrayList<ClassSignature$IToken>(); 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return this.signature;
/*     */   }
/*     */   
/*     */   ClassSignature$IToken addTypeArgument(String paramString) {
/*     */     try {
/*     */       if (this.tail != null)
/*     */         return this.tail.addTypeArgument(paramString); 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     ClassSignature$Token classSignature$Token = new ClassSignature$Token(paramString);
/*     */     getSignature().add(classSignature$Token);
/*     */     return classSignature$Token;
/*     */   }
/*     */   
/*     */   ClassSignature$Token() {
/*     */     this(false);
/*     */   }
/*     */   
/*     */   public ClassSignature$IToken setArray(boolean paramBoolean) {
/*     */     this.array |= paramBoolean;
/*     */     return this;
/*     */   }
/*     */   
/*     */   ClassSignature$Token setSymbol(char paramChar) {
/*     */     try {
/*     */       if (this.symbol == '\000')
/*     */         try {
/*     */           if ("+-*".indexOf(paramChar) > -1)
/*     */             this.symbol = paramChar; 
/*     */         } catch (RuntimeException runtimeException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return this;
/*     */   }
/*     */   
/*     */   ClassSignature$Token setType(String paramString) {
/*     */     try {
/*     */       if (this.type == null)
/*     */         this.type = paramString; 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return this;
/*     */   }
/*     */   
/*     */   public ClassSignature$IToken setWildcard(char paramChar) {
/*     */     try {
/*     */       if ("+-".indexOf(paramChar) == -1)
/*     */         return this; 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return setSymbol(paramChar);
/*     */   }
/*     */   
/*     */   boolean hasClassBound() {
/*     */     try {
/*     */     
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return (this.classBound != null);
/*     */   }
/*     */   
/*     */   private char symbol = Character.MIN_VALUE;
/*     */   private String type;
/*     */   private List<ClassSignature$Token> classBound;
/*     */   private List<ClassSignature$Token> ifaceBound;
/*     */   private List<ClassSignature$IToken> signature;
/*     */   private List<ClassSignature$IToken> suffix;
/*     */   private ClassSignature$Token tail;
/*     */   
/*     */   ClassSignature$Token addInterfaceBound(String paramString) {
/*     */     ClassSignature$Token classSignature$Token = new ClassSignature$Token(paramString);
/*     */     getIfaceBound().add(classSignature$Token);
/*     */     return classSignature$Token;
/*     */   }
/*     */   
/*     */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*     */     return paramRuntimeException;
/*     */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\ClassSignature$Token.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */