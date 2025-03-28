/*   1 */ package org.spongepowered.asm.util.perf;public final class Profiler { private final Map<String, Profiler$Section> sections = new TreeMap<String, Profiler$Section>();
/*     */   
/*     */   boolean isHead(Profiler$Section paramProfiler$Section) {
/*     */     
/*     */     try {  }
/*     */     catch (NoSuchElementException noSuchElementException)
/*   7 */     { throw b(null); }  return (this.stack.peek() == paramProfiler$Section);
/*     */   }
/*   9 */   public Profiler$Section get(String paramString) { Profiler$Section profiler$Section = this.sections.get(paramString);
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
/*     */     try {
/*  83 */       if (profiler$Section == null) {
/*     */         try {
/*     */         
/*     */         } catch (NoSuchElementException noSuchElementException) {
/*     */           throw b(null);
/*     */         } 
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
/*     */         profiler$Section = this.active ? new Profiler$LiveSection(this, paramString, this.phases.size() - 1) : new Profiler$Section(this, paramString);
/*     */       } 
/*     */     } catch (NoSuchElementException noSuchElementException) {
/*     */       throw b(null);
/*     */     } 
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
/* 117 */     return profiler$Section; } private Profiler$Section getSubSection(String paramString1, String paramString2, Profiler$Section paramProfiler$Section) { Profiler$Section profiler$Section = this.sections.get(paramString1); if (profiler$Section == null) { profiler$Section = new Profiler$SubSection(this, paramString1, this.phases.size() - 1, paramString2, paramProfiler$Section); this.sections.put(paramString1, profiler$Section); }  return profiler$Section; }
/*     */   public void setActive(boolean paramBoolean) { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield active : Z
/*     */     //   4: ifne -> 18
/*     */     //   7: iload_1
/*     */     //   8: ifne -> 29
/*     */     //   11: goto -> 18
/*     */     //   14: invokestatic b : (Ljava/util/NoSuchElementException;)Ljava/util/NoSuchElementException;
/*     */     //   17: athrow
/*     */     //   18: iload_1
/*     */     //   19: ifne -> 40
/*     */     //   22: goto -> 29
/*     */     //   25: invokestatic b : (Ljava/util/NoSuchElementException;)Ljava/util/NoSuchElementException;
/*     */     //   28: athrow
/*     */     //   29: aload_0
/*     */     //   30: invokevirtual reset : ()V
/*     */     //   33: goto -> 40
/*     */     //   36: invokestatic b : (Ljava/util/NoSuchElementException;)Ljava/util/NoSuchElementException;
/*     */     //   39: athrow
/*     */     //   40: aload_0
/*     */     //   41: iload_1
/*     */     //   42: putfield active : Z
/*     */     //   45: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #28	-> 0
/*     */     //   #46	-> 29
/*     */     //   #122	-> 40
/*     */     //   #100	-> 45
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   0	11	14	java/util/NoSuchElementException
/*     */     //   7	22	25	java/util/NoSuchElementException
/*     */     //   18	33	36	java/util/NoSuchElementException }
/*     */   public void mark(String paramString) { long l = 0L; for (Profiler$Section profiler$Section : this.sections.values()) l += profiler$Section.getTime();  if (l == 0L) { int i = this.phases.size(); this.phases.set(i - 1, paramString); return; }  this.phases.add(paramString); for (Profiler$Section profiler$Section : this.sections.values()) profiler$Section.mark();  }
/*     */   public Profiler$Section begin(int paramInt, String... paramVarArgs) { return begin(paramInt, Joiner.on('.').join((Object[])paramVarArgs)); }
/*     */   public Profiler$Section begin(String paramString) { return begin(0, paramString); }
/*     */   public void reset() { for (Profiler$Section profiler$Section : this.sections.values())
/*     */       profiler$Section.invalidate();  this.sections.clear(); this.phases.clear(); this.phases.add("Initial"); this.stack.clear(); }
/*     */   public Profiler$Section begin(int paramInt, String paramString) { // Byte code:
/*     */     //   0: iload_1
/*     */     //   1: iconst_1
/*     */     //   2: iand
/*     */     //   3: ifeq -> 14
/*     */     //   6: iconst_1
/*     */     //   7: goto -> 15
/*     */     //   10: invokestatic b : (Ljava/util/NoSuchElementException;)Ljava/util/NoSuchElementException;
/*     */     //   13: athrow
/*     */     //   14: iconst_0
/*     */     //   15: istore_3
/*     */     //   16: iload_1
/*     */     //   17: iconst_2
/*     */     //   18: iand
/*     */     //   19: ifeq -> 30
/*     */     //   22: iconst_1
/*     */     //   23: goto -> 31
/*     */     //   26: invokestatic b : (Ljava/util/NoSuchElementException;)Ljava/util/NoSuchElementException;
/*     */     //   29: athrow
/*     */     //   30: iconst_0
/*     */     //   31: istore #4
/*     */     //   33: aload_2
/*     */     //   34: astore #5
/*     */     //   36: aload_0
/*     */     //   37: getfield stack : Ljava/util/Deque;
/*     */     //   40: invokeinterface peek : ()Ljava/lang/Object;
/*     */     //   45: checkcast org/spongepowered/asm/util/perf/Profiler$Section
/*     */     //   48: astore #6
/*     */     //   50: aload #6
/*     */     //   52: ifnull -> 191
/*     */     //   55: new java/lang/StringBuilder
/*     */     //   58: dup
/*     */     //   59: invokespecial <init> : ()V
/*     */     //   62: aload #6
/*     */     //   64: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   67: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   70: iload_3
/*     */     //   71: ifeq -> 90
/*     */     //   74: goto -> 81
/*     */     //   77: invokestatic b : (Ljava/util/NoSuchElementException;)Ljava/util/NoSuchElementException;
/*     */     //   80: athrow
/*     */     //   81: ldc ' -> '
/*     */     //   83: goto -> 92
/*     */     //   86: invokestatic b : (Ljava/util/NoSuchElementException;)Ljava/util/NoSuchElementException;
/*     */     //   89: athrow
/*     */     //   90: ldc '.'
/*     */     //   92: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   95: aload #5
/*     */     //   97: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   100: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   103: astore #5
/*     */     //   105: aload #6
/*     */     //   107: invokevirtual isRoot : ()Z
/*     */     //   110: ifeq -> 191
/*     */     //   113: iload_3
/*     */     //   114: ifne -> 191
/*     */     //   117: goto -> 124
/*     */     //   120: invokestatic b : (Ljava/util/NoSuchElementException;)Ljava/util/NoSuchElementException;
/*     */     //   123: athrow
/*     */     //   124: aload #6
/*     */     //   126: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   129: ldc ' -> '
/*     */     //   131: invokevirtual lastIndexOf : (Ljava/lang/String;)I
/*     */     //   134: istore #7
/*     */     //   136: new java/lang/StringBuilder
/*     */     //   139: dup
/*     */     //   140: invokespecial <init> : ()V
/*     */     //   143: iload #7
/*     */     //   145: iconst_m1
/*     */     //   146: if_icmple -> 168
/*     */     //   149: aload #6
/*     */     //   151: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   154: iload #7
/*     */     //   156: iconst_4
/*     */     //   157: iadd
/*     */     //   158: invokevirtual substring : (I)Ljava/lang/String;
/*     */     //   161: goto -> 173
/*     */     //   164: invokestatic b : (Ljava/util/NoSuchElementException;)Ljava/util/NoSuchElementException;
/*     */     //   167: athrow
/*     */     //   168: aload #6
/*     */     //   170: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   173: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   176: ldc '.'
/*     */     //   178: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   181: aload_2
/*     */     //   182: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   185: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   188: astore_2
/*     */     //   189: iconst_1
/*     */     //   190: istore_3
/*     */     //   191: aload_0
/*     */     //   192: iload_3
/*     */     //   193: ifeq -> 204
/*     */     //   196: aload_2
/*     */     //   197: goto -> 206
/*     */     //   200: invokestatic b : (Ljava/util/NoSuchElementException;)Ljava/util/NoSuchElementException;
/*     */     //   203: athrow
/*     */     //   204: aload #5
/*     */     //   206: invokevirtual get : (Ljava/lang/String;)Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   209: astore #7
/*     */     //   211: iload_3
/*     */     //   212: ifeq -> 256
/*     */     //   215: aload #6
/*     */     //   217: ifnull -> 256
/*     */     //   220: goto -> 227
/*     */     //   223: invokestatic b : (Ljava/util/NoSuchElementException;)Ljava/util/NoSuchElementException;
/*     */     //   226: athrow
/*     */     //   227: aload_0
/*     */     //   228: getfield active : Z
/*     */     //   231: ifeq -> 256
/*     */     //   234: goto -> 241
/*     */     //   237: invokestatic b : (Ljava/util/NoSuchElementException;)Ljava/util/NoSuchElementException;
/*     */     //   240: athrow
/*     */     //   241: aload_0
/*     */     //   242: aload #5
/*     */     //   244: aload #6
/*     */     //   246: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   249: aload #7
/*     */     //   251: invokespecial getSubSection : (Ljava/lang/String;Ljava/lang/String;Lorg/spongepowered/asm/util/perf/Profiler$Section;)Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   254: astore #7
/*     */     //   256: aload #7
/*     */     //   258: iload #4
/*     */     //   260: invokevirtual setFine : (Z)Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   263: iload_3
/*     */     //   264: invokevirtual setRoot : (Z)Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   267: pop
/*     */     //   268: aload_0
/*     */     //   269: getfield stack : Ljava/util/Deque;
/*     */     //   272: aload #7
/*     */     //   274: invokeinterface push : (Ljava/lang/Object;)V
/*     */     //   279: aload #7
/*     */     //   281: invokevirtual start : ()Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   284: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #45	-> 0
/*     */     //   #102	-> 16
/*     */     //   #69	-> 33
/*     */     //   #49	-> 36
/*     */     //   #43	-> 50
/*     */     //   #37	-> 55
/*     */     //   #55	-> 105
/*     */     //   #59	-> 124
/*     */     //   #106	-> 136
/*     */     //   #16	-> 189
/*     */     //   #105	-> 191
/*     */     //   #52	-> 211
/*     */     //   #65	-> 241
/*     */     //   #110	-> 256
/*     */     //   #8	-> 268
/*     */     //   #5	-> 279
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   0	10	10	java/util/NoSuchElementException
/*     */     //   16	26	26	java/util/NoSuchElementException
/*     */     //   50	74	77	java/util/NoSuchElementException
/*     */     //   55	86	86	java/util/NoSuchElementException
/*     */     //   105	117	120	java/util/NoSuchElementException
/*     */     //   136	164	164	java/util/NoSuchElementException
/*     */     //   191	200	200	java/util/NoSuchElementException
/*     */     //   211	220	223	java/util/NoSuchElementException
/*     */     //   215	234	237	java/util/NoSuchElementException }
/* 125 */   private void printSectionRow(PrettyPrinter paramPrettyPrinter, int paramInt, int[] paramArrayOfint, Profiler$Section paramProfiler$Section, boolean paramBoolean) { try {  } catch (NoSuchElementException noSuchElementException) { throw b(null); }  boolean bool = (paramProfiler$Section.getDelegate() != paramProfiler$Section) ? true : false; Object[] arrayOfObject = new Object[paramInt]; byte b1 = 1; try { if (paramBoolean) { try {  } catch (NoSuchElementException noSuchElementException) { throw b(null); }  arrayOfObject[0] = bool ? ("  > " + paramProfiler$Section.getBaseName()) : paramProfiler$Section.getName(); }  } catch (NoSuchElementException noSuchElementException) { throw b(null); }  try {  } catch (NoSuchElementException noSuchElementException) { throw b(null); }  arrayOfObject[0] = (bool ? "+ " : "  ") + paramProfiler$Section.getName(); long[] arrayOfLong1 = paramProfiler$Section.getTimes(); long[] arrayOfLong2; int i; byte b3; for (arrayOfLong2 = arrayOfLong1, i = arrayOfLong2.length, b3 = 0; b3 < i; ) { long l = arrayOfLong2[b3]; try { if (b1 == paramArrayOfint[1]) arrayOfObject[b1++] = paramProfiler$Section.getTotalTime() + " ms";  } catch (NoSuchElementException noSuchElementException) { throw b(null); }  try { if (b1 >= paramArrayOfint[2]) try { if (b1 < arrayOfObject.length) arrayOfObject[b1++] = l + " ms";  } catch (NoSuchElementException noSuchElementException) { throw b(null); }   } catch (NoSuchElementException noSuchElementException) { throw b(null); }  b3++; }  arrayOfObject[paramArrayOfint[3]] = Integer.valueOf(paramProfiler$Section.getTotalCount()); arrayOfObject[paramArrayOfint[4]] = (new DecimalFormat("   ###0.000 ms")).format(paramProfiler$Section.getTotalAverageTime()); byte b2 = 0; while (true) { try { if (b2 < arrayOfObject.length) { try { if (arrayOfObject[b2] == null) arrayOfObject[b2] = "-";  } catch (NoSuchElementException noSuchElementException) { throw b(null); }  b2++; }  } catch (NoSuchElementException noSuchElementException) { throw b(null); }  break; }  paramPrettyPrinter.tr(arrayOfObject); }
/*     */   public PrettyPrinter printer(boolean paramBoolean1, boolean paramBoolean2) { // Byte code:
/*     */     //   0: new org/spongepowered/asm/util/PrettyPrinter
/*     */     //   3: dup
/*     */     //   4: invokespecial <init> : ()V
/*     */     //   7: astore_3
/*     */     //   8: aload_0
/*     */     //   9: getfield phases : Ljava/util/List;
/*     */     //   12: invokeinterface size : ()I
/*     */     //   17: iconst_4
/*     */     //   18: iadd
/*     */     //   19: istore #4
/*     */     //   21: iconst_5
/*     */     //   22: newarray int
/*     */     //   24: dup
/*     */     //   25: iconst_0
/*     */     //   26: iconst_0
/*     */     //   27: iastore
/*     */     //   28: dup
/*     */     //   29: iconst_1
/*     */     //   30: iconst_1
/*     */     //   31: iastore
/*     */     //   32: dup
/*     */     //   33: iconst_2
/*     */     //   34: iconst_2
/*     */     //   35: iastore
/*     */     //   36: dup
/*     */     //   37: iconst_3
/*     */     //   38: iload #4
/*     */     //   40: iconst_2
/*     */     //   41: isub
/*     */     //   42: iastore
/*     */     //   43: dup
/*     */     //   44: iconst_4
/*     */     //   45: iload #4
/*     */     //   47: iconst_1
/*     */     //   48: isub
/*     */     //   49: iastore
/*     */     //   50: astore #5
/*     */     //   52: iload #4
/*     */     //   54: iconst_2
/*     */     //   55: imul
/*     */     //   56: anewarray java/lang/Object
/*     */     //   59: astore #6
/*     */     //   61: iconst_0
/*     */     //   62: istore #7
/*     */     //   64: iconst_0
/*     */     //   65: istore #8
/*     */     //   67: iload #7
/*     */     //   69: iload #4
/*     */     //   71: if_icmpge -> 293
/*     */     //   74: aload #6
/*     */     //   76: iload #8
/*     */     //   78: iconst_1
/*     */     //   79: iadd
/*     */     //   80: getstatic org/spongepowered/asm/util/PrettyPrinter$Alignment.RIGHT : Lorg/spongepowered/asm/util/PrettyPrinter$Alignment;
/*     */     //   83: aastore
/*     */     //   84: iload #7
/*     */     //   86: aload #5
/*     */     //   88: iconst_0
/*     */     //   89: iaload
/*     */     //   90: if_icmpne -> 158
/*     */     //   93: goto -> 100
/*     */     //   96: invokestatic b : (Ljava/util/NoSuchElementException;)Ljava/util/NoSuchElementException;
/*     */     //   99: athrow
/*     */     //   100: aload #6
/*     */     //   102: iload #8
/*     */     //   104: new java/lang/StringBuilder
/*     */     //   107: dup
/*     */     //   108: invokespecial <init> : ()V
/*     */     //   111: iload_2
/*     */     //   112: ifeq -> 131
/*     */     //   115: goto -> 122
/*     */     //   118: invokestatic b : (Ljava/util/NoSuchElementException;)Ljava/util/NoSuchElementException;
/*     */     //   121: athrow
/*     */     //   122: ldc ''
/*     */     //   124: goto -> 133
/*     */     //   127: invokestatic b : (Ljava/util/NoSuchElementException;)Ljava/util/NoSuchElementException;
/*     */     //   130: athrow
/*     */     //   131: ldc '  '
/*     */     //   133: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   136: ldc 'Section'
/*     */     //   138: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   141: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   144: aastore
/*     */     //   145: aload #6
/*     */     //   147: iload #8
/*     */     //   149: iconst_1
/*     */     //   150: iadd
/*     */     //   151: getstatic org/spongepowered/asm/util/PrettyPrinter$Alignment.LEFT : Lorg/spongepowered/asm/util/PrettyPrinter$Alignment;
/*     */     //   154: aastore
/*     */     //   155: goto -> 281
/*     */     //   158: iload #7
/*     */     //   160: aload #5
/*     */     //   162: iconst_1
/*     */     //   163: iaload
/*     */     //   164: if_icmpne -> 181
/*     */     //   167: aload #6
/*     */     //   169: iload #8
/*     */     //   171: ldc '    TOTAL'
/*     */     //   173: aastore
/*     */     //   174: goto -> 281
/*     */     //   177: invokestatic b : (Ljava/util/NoSuchElementException;)Ljava/util/NoSuchElementException;
/*     */     //   180: athrow
/*     */     //   181: iload #7
/*     */     //   183: aload #5
/*     */     //   185: iconst_3
/*     */     //   186: iaload
/*     */     //   187: if_icmpne -> 204
/*     */     //   190: aload #6
/*     */     //   192: iload #8
/*     */     //   194: ldc '    Count'
/*     */     //   196: aastore
/*     */     //   197: goto -> 281
/*     */     //   200: invokestatic b : (Ljava/util/NoSuchElementException;)Ljava/util/NoSuchElementException;
/*     */     //   203: athrow
/*     */     //   204: iload #7
/*     */     //   206: aload #5
/*     */     //   208: iconst_4
/*     */     //   209: iaload
/*     */     //   210: if_icmpne -> 227
/*     */     //   213: aload #6
/*     */     //   215: iload #8
/*     */     //   217: ldc 'Avg. '
/*     */     //   219: aastore
/*     */     //   220: goto -> 281
/*     */     //   223: invokestatic b : (Ljava/util/NoSuchElementException;)Ljava/util/NoSuchElementException;
/*     */     //   226: athrow
/*     */     //   227: iload #7
/*     */     //   229: aload #5
/*     */     //   231: iconst_2
/*     */     //   232: iaload
/*     */     //   233: isub
/*     */     //   234: aload_0
/*     */     //   235: getfield phases : Ljava/util/List;
/*     */     //   238: invokeinterface size : ()I
/*     */     //   243: if_icmpge -> 274
/*     */     //   246: aload #6
/*     */     //   248: iload #8
/*     */     //   250: aload_0
/*     */     //   251: getfield phases : Ljava/util/List;
/*     */     //   254: iload #7
/*     */     //   256: aload #5
/*     */     //   258: iconst_2
/*     */     //   259: iaload
/*     */     //   260: isub
/*     */     //   261: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   266: aastore
/*     */     //   267: goto -> 281
/*     */     //   270: invokestatic b : (Ljava/util/NoSuchElementException;)Ljava/util/NoSuchElementException;
/*     */     //   273: athrow
/*     */     //   274: aload #6
/*     */     //   276: iload #8
/*     */     //   278: ldc ''
/*     */     //   280: aastore
/*     */     //   281: iinc #7, 1
/*     */     //   284: iload #7
/*     */     //   286: iconst_2
/*     */     //   287: imul
/*     */     //   288: istore #8
/*     */     //   290: goto -> 67
/*     */     //   293: aload_3
/*     */     //   294: aload #6
/*     */     //   296: invokevirtual table : ([Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   299: invokevirtual th : ()Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   302: invokevirtual hr : ()Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   305: invokevirtual add : ()Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   308: pop
/*     */     //   309: aload_0
/*     */     //   310: getfield sections : Ljava/util/Map;
/*     */     //   313: invokeinterface values : ()Ljava/util/Collection;
/*     */     //   318: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   323: astore #7
/*     */     //   325: aload #7
/*     */     //   327: invokeinterface hasNext : ()Z
/*     */     //   332: ifeq -> 513
/*     */     //   335: aload #7
/*     */     //   337: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   342: checkcast org/spongepowered/asm/util/perf/Profiler$Section
/*     */     //   345: astore #8
/*     */     //   347: aload #8
/*     */     //   349: invokevirtual isFine : ()Z
/*     */     //   352: ifeq -> 366
/*     */     //   355: iload_1
/*     */     //   356: ifeq -> 325
/*     */     //   359: goto -> 366
/*     */     //   362: invokestatic b : (Ljava/util/NoSuchElementException;)Ljava/util/NoSuchElementException;
/*     */     //   365: athrow
/*     */     //   366: iload_2
/*     */     //   367: ifeq -> 394
/*     */     //   370: aload #8
/*     */     //   372: invokevirtual getDelegate : ()Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   375: aload #8
/*     */     //   377: if_acmpeq -> 394
/*     */     //   380: goto -> 387
/*     */     //   383: invokestatic b : (Ljava/util/NoSuchElementException;)Ljava/util/NoSuchElementException;
/*     */     //   386: athrow
/*     */     //   387: goto -> 325
/*     */     //   390: invokestatic b : (Ljava/util/NoSuchElementException;)Ljava/util/NoSuchElementException;
/*     */     //   393: athrow
/*     */     //   394: aload_0
/*     */     //   395: aload_3
/*     */     //   396: iload #4
/*     */     //   398: aload #5
/*     */     //   400: aload #8
/*     */     //   402: iload_2
/*     */     //   403: invokespecial printSectionRow : (Lorg/spongepowered/asm/util/PrettyPrinter;I[ILorg/spongepowered/asm/util/perf/Profiler$Section;Z)V
/*     */     //   406: iload_2
/*     */     //   407: ifeq -> 510
/*     */     //   410: aload_0
/*     */     //   411: getfield sections : Ljava/util/Map;
/*     */     //   414: invokeinterface values : ()Ljava/util/Collection;
/*     */     //   419: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   424: astore #9
/*     */     //   426: aload #9
/*     */     //   428: invokeinterface hasNext : ()Z
/*     */     //   433: ifeq -> 510
/*     */     //   436: aload #9
/*     */     //   438: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   443: checkcast org/spongepowered/asm/util/perf/Profiler$Section
/*     */     //   446: astore #10
/*     */     //   448: aload #10
/*     */     //   450: invokevirtual getDelegate : ()Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   453: astore #11
/*     */     //   455: aload #10
/*     */     //   457: invokevirtual isFine : ()Z
/*     */     //   460: ifeq -> 474
/*     */     //   463: iload_1
/*     */     //   464: ifeq -> 426
/*     */     //   467: goto -> 474
/*     */     //   470: invokestatic b : (Ljava/util/NoSuchElementException;)Ljava/util/NoSuchElementException;
/*     */     //   473: athrow
/*     */     //   474: aload #11
/*     */     //   476: aload #8
/*     */     //   478: if_acmpne -> 426
/*     */     //   481: aload #11
/*     */     //   483: aload #10
/*     */     //   485: if_acmpne -> 495
/*     */     //   488: goto -> 426
/*     */     //   491: invokestatic b : (Ljava/util/NoSuchElementException;)Ljava/util/NoSuchElementException;
/*     */     //   494: athrow
/*     */     //   495: aload_0
/*     */     //   496: aload_3
/*     */     //   497: iload #4
/*     */     //   499: aload #5
/*     */     //   501: aload #10
/*     */     //   503: iload_2
/*     */     //   504: invokespecial printSectionRow : (Lorg/spongepowered/asm/util/PrettyPrinter;I[ILorg/spongepowered/asm/util/perf/Profiler$Section;Z)V
/*     */     //   507: goto -> 426
/*     */     //   510: goto -> 325
/*     */     //   513: aload_3
/*     */     //   514: invokevirtual add : ()Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   517: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #60	-> 0
/*     */     //   #120	-> 8
/*     */     //   #84	-> 21
/*     */     //   #119	-> 52
/*     */     //   #88	-> 61
/*     */     //   #103	-> 74
/*     */     //   #47	-> 84
/*     */     //   #6	-> 100
/*     */     //   #17	-> 145
/*     */     //   #15	-> 158
/*     */     //   #74	-> 167
/*     */     //   #56	-> 181
/*     */     //   #22	-> 190
/*     */     //   #26	-> 204
/*     */     //   #116	-> 213
/*     */     //   #20	-> 227
/*     */     //   #53	-> 246
/*     */     //   #2	-> 274
/*     */     //   #32	-> 281
/*     */     //   #31	-> 293
/*     */     //   #71	-> 309
/*     */     //   #62	-> 347
/*     */     //   #27	-> 387
/*     */     //   #121	-> 394
/*     */     //   #14	-> 406
/*     */     //   #96	-> 410
/*     */     //   #12	-> 448
/*     */     //   #23	-> 455
/*     */     //   #90	-> 488
/*     */     //   #58	-> 495
/*     */     //   #68	-> 507
/*     */     //   #99	-> 510
/*     */     //   #25	-> 513
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   67	93	96	java/util/NoSuchElementException
/*     */     //   74	115	118	java/util/NoSuchElementException
/*     */     //   100	127	127	java/util/NoSuchElementException
/*     */     //   158	177	177	java/util/NoSuchElementException
/*     */     //   181	200	200	java/util/NoSuchElementException
/*     */     //   204	223	223	java/util/NoSuchElementException
/*     */     //   227	270	270	java/util/NoSuchElementException
/*     */     //   347	359	362	java/util/NoSuchElementException
/*     */     //   366	380	383	java/util/NoSuchElementException
/*     */     //   370	390	390	java/util/NoSuchElementException
/*     */     //   455	467	470	java/util/NoSuchElementException
/* 126 */     //   481	491	491	java/util/NoSuchElementException } public Profiler() { this.phases.add("Initial"); } private final List<String> phases = new ArrayList<String>();
/* 127 */   public Profiler$Section begin(String... paramVarArgs) { return begin(0, paramVarArgs); } private final Deque<Profiler$Section> stack = new LinkedList<Profiler$Section>(); public Collection<Profiler$Section> getSections() { return Collections.unmodifiableCollection(this.sections.values()); } public static final int ROOT = 1; public static final int FINE = 2; private boolean active; void end(Profiler$Section paramProfiler$Section) { try { Profiler$Section profiler$Section1 = this.stack.pop(), profiler$Section2 = profiler$Section1; while (true) { try { if (profiler$Section2 != paramProfiler$Section) {
/*     */             try {
/*     */               if (profiler$Section2 == null)
/*     */                 try {
/*     */                   if (this.active) {
/*     */                     try {
/*     */                       if (profiler$Section1 == null)
/*     */                         throw new IllegalStateException("Attempted to pop " + paramProfiler$Section + " but the stack is empty"); 
/*     */                     } catch (NoSuchElementException noSuchElementException) {
/*     */                       throw b(null);
/*     */                     } 
/*     */                     throw new IllegalStateException("Attempted to pop " + paramProfiler$Section + " which was not in the stack, head was " + profiler$Section1);
/*     */                   } 
/*     */                 } catch (NoSuchElementException noSuchElementException) {
/*     */                   throw b(null);
/*     */                 }  
/*     */             } catch (NoSuchElementException noSuchElementException) {
/*     */               throw b(null);
/*     */             } 
/*     */             profiler$Section2 = this.stack.pop();
/*     */           }  }
/*     */         catch (NoSuchElementException noSuchElementException)
/*     */         { throw b(null); }
/*     */         
/*     */         break; }
/*     */        }
/*     */     catch (NoSuchElementException noSuchElementException)
/*     */     { try {
/*     */         if (this.active)
/*     */           throw new IllegalStateException("Attempted to pop " + paramProfiler$Section + " but the stack is empty"); 
/*     */       } catch (NoSuchElementException noSuchElementException1) {
/*     */         throw b(null);
/*     */       }  }
/*     */      }
/*     */ 
/*     */   
/*     */   private static NoSuchElementException b(NoSuchElementException paramNoSuchElementException) {
/*     */     return paramNoSuchElementException;
/*     */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\perf\Profiler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */