/*     */ package org.spongepowered.asm.util;public class ConstraintParser$Constraint { private ConstraintParser$Constraint next;
/*     */   private int max;
/*     */   private int min;
/*     */   private String[] constraint;
/*     */   private String token;
/*     */   private final String expr;
/*     */   
/*     */   public int getMax() {
/*   9 */     return this.max;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMin() {
/*  19 */     return this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  30 */     return String.format("Constraint(%s [%d-%d])", new Object[] { this.token, Integer.valueOf(this.min), Integer.valueOf(this.max) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  38 */   private static final Pattern pattern = Pattern.compile(
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  94 */       "^([A-Z0-9\\-_\\.]+)\\((?:(<|<=|>|>=|=)?([0-9]+)(<|(-)([0-9]+)?|>|(\\+)([0-9]+)?)?)?\\)$"); private void parse() { try { if (!has(1))
/*     */         return;  } catch (InvalidConstraintException invalidConstraintException) { throw b(null); }
/*  96 */      this.max = this.min = val(1); boolean bool = has(0); try { if (has(4)) { try { if (bool)
/*     */             throw new InvalidConstraintException("Unexpected modifier '" + elem(0) + "' in " + this.expr + " parsing range");  } catch (InvalidConstraintException invalidConstraintException) { throw b(null); }  try { this.max = val(4); if (this.max < this.min)
/*     */             throw new InvalidConstraintException("Invalid range specified '" + this.max + "' is less than " + this.min + " in " + this.expr);  } catch (InvalidConstraintException invalidConstraintException) { throw b(null); }  }  } catch (InvalidConstraintException invalidConstraintException) { throw b(null); }  try { if (has(6)) { try { if (bool)
/*  99 */             throw new InvalidConstraintException("Unexpected modifier '" + elem(0) + "' in " + this.expr + " parsing range");  } catch (InvalidConstraintException invalidConstraintException) { throw b(null); }  this.max = this.min + val(6); return; }  } catch (InvalidConstraintException invalidConstraintException) { throw b(null); }  try { if (bool) { try { if (has(3))
/* 100 */             throw new InvalidConstraintException("Unexpected trailing modifier '" + elem(3) + "' in " + this.expr);  } catch (InvalidConstraintException invalidConstraintException) { throw b(null); }  String str = elem(0); }  } catch (InvalidConstraintException invalidConstraintException) { throw b(null); }  if (has(2)) { String str = elem(2); try { if ("<".equals(str)) { this.max = this.min; this.min = Integer.MIN_VALUE; } else { this.max = Integer.MAX_VALUE; }  } catch (InvalidConstraintException invalidConstraintException) { throw b(null); }  }
/* 101 */      } public static final ConstraintParser$Constraint NONE = new ConstraintParser$Constraint(); ConstraintParser$Constraint(String paramString) { this.min = Integer.MIN_VALUE; this.max = Integer.MAX_VALUE; this.expr = paramString;
/*     */     Matcher matcher = pattern.matcher(paramString);
/*     */     try {
/*     */       if (!matcher.matches())
/*     */         throw new InvalidConstraintException("Constraint syntax was invalid parsing: " + this.expr); 
/*     */     } catch (InvalidConstraintException invalidConstraintException) {
/*     */       throw b(null);
/*     */     } 
/*     */     this.token = matcher.group(1);
/*     */     this.constraint = new String[] { matcher.group(2), matcher.group(3), matcher.group(4), matcher.group(5), matcher.group(6), matcher.group(7), matcher.group(8) };
/*     */     parse(); }
/*     */ 
/*     */   
/*     */   public String getRangeHumanReadable() {
/*     */     try {
/*     */       if (this.min == Integer.MIN_VALUE)
/*     */         try {
/*     */           if (this.max == Integer.MAX_VALUE)
/*     */             return "ANY VALUE"; 
/*     */         } catch (InvalidConstraintException invalidConstraintException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (InvalidConstraintException invalidConstraintException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (this.min == Integer.MIN_VALUE)
/*     */         return String.format("less than or equal to %d", new Object[] { Integer.valueOf(this.max) }); 
/*     */     } catch (InvalidConstraintException invalidConstraintException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (this.max == Integer.MAX_VALUE)
/*     */         return String.format("greater than or equal to %d", new Object[] { Integer.valueOf(this.min) }); 
/*     */     } catch (InvalidConstraintException invalidConstraintException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (this.min == this.max)
/*     */         return String.format("%d", new Object[] { Integer.valueOf(this.min) }); 
/*     */     } catch (InvalidConstraintException invalidConstraintException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return String.format("between %d and %d", new Object[] { Integer.valueOf(this.min), Integer.valueOf(this.max) });
/*     */   }
/*     */   
/*     */   void append(ConstraintParser$Constraint paramConstraintParser$Constraint) {
/*     */     try {
/*     */       if (this.next != null) {
/*     */         this.next.append(paramConstraintParser$Constraint);
/*     */         return;
/*     */       } 
/*     */     } catch (InvalidConstraintException invalidConstraintException) {
/*     */       throw b(null);
/*     */     } 
/*     */     this.next = paramConstraintParser$Constraint;
/*     */   }
/*     */   
/*     */   private ConstraintParser$Constraint() {
/*     */     this.min = Integer.MIN_VALUE;
/*     */     this.max = Integer.MAX_VALUE;
/*     */     this.expr = null;
/*     */     this.token = "*";
/*     */     this.constraint = new String[0];
/*     */   }
/*     */   
/*     */   private int val(int paramInt) {
/*     */     try {
/*     */     
/*     */     } catch (InvalidConstraintException invalidConstraintException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return (this.constraint[paramInt] != null) ? Integer.parseInt(this.constraint[paramInt]) : 0;
/*     */   }
/*     */   
/*     */   private String elem(int paramInt) {
/*     */     return this.constraint[paramInt];
/*     */   }
/*     */   
/*     */   public void check(ITokenProvider paramITokenProvider) throws ConstraintViolationException {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getstatic org/spongepowered/asm/util/ConstraintParser$Constraint.NONE : Lorg/spongepowered/asm/util/ConstraintParser$Constraint;
/*     */     //   4: if_acmpeq -> 226
/*     */     //   7: aload_1
/*     */     //   8: aload_0
/*     */     //   9: getfield token : Ljava/lang/String;
/*     */     //   12: invokeinterface getToken : (Ljava/lang/String;)Ljava/lang/Integer;
/*     */     //   17: astore_2
/*     */     //   18: aload_2
/*     */     //   19: ifnonnull -> 66
/*     */     //   22: new org/spongepowered/asm/util/throwables/ConstraintViolationException
/*     */     //   25: dup
/*     */     //   26: new java/lang/StringBuilder
/*     */     //   29: dup
/*     */     //   30: invokespecial <init> : ()V
/*     */     //   33: ldc 'The token ''
/*     */     //   35: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   38: aload_0
/*     */     //   39: getfield token : Ljava/lang/String;
/*     */     //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   45: ldc '' could not be resolved in '
/*     */     //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   50: aload_1
/*     */     //   51: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   54: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   57: aload_0
/*     */     //   58: invokespecial <init> : (Ljava/lang/String;Lorg/spongepowered/asm/util/ConstraintParser$Constraint;)V
/*     */     //   61: athrow
/*     */     //   62: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   65: athrow
/*     */     //   66: aload_2
/*     */     //   67: invokevirtual intValue : ()I
/*     */     //   70: aload_0
/*     */     //   71: getfield min : I
/*     */     //   74: if_icmpge -> 146
/*     */     //   77: new org/spongepowered/asm/util/throwables/ConstraintViolationException
/*     */     //   80: dup
/*     */     //   81: new java/lang/StringBuilder
/*     */     //   84: dup
/*     */     //   85: invokespecial <init> : ()V
/*     */     //   88: ldc 'Token ''
/*     */     //   90: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   93: aload_0
/*     */     //   94: getfield token : Ljava/lang/String;
/*     */     //   97: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   100: ldc '' has a value ('
/*     */     //   102: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   105: aload_2
/*     */     //   106: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   109: ldc ') which is less than the minimum value '
/*     */     //   111: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   114: aload_0
/*     */     //   115: getfield min : I
/*     */     //   118: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   121: ldc ' in '
/*     */     //   123: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   126: aload_1
/*     */     //   127: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   130: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   133: aload_0
/*     */     //   134: aload_2
/*     */     //   135: invokevirtual intValue : ()I
/*     */     //   138: invokespecial <init> : (Ljava/lang/String;Lorg/spongepowered/asm/util/ConstraintParser$Constraint;I)V
/*     */     //   141: athrow
/*     */     //   142: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   145: athrow
/*     */     //   146: aload_2
/*     */     //   147: invokevirtual intValue : ()I
/*     */     //   150: aload_0
/*     */     //   151: getfield max : I
/*     */     //   154: if_icmple -> 226
/*     */     //   157: new org/spongepowered/asm/util/throwables/ConstraintViolationException
/*     */     //   160: dup
/*     */     //   161: new java/lang/StringBuilder
/*     */     //   164: dup
/*     */     //   165: invokespecial <init> : ()V
/*     */     //   168: ldc 'Token ''
/*     */     //   170: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   173: aload_0
/*     */     //   174: getfield token : Ljava/lang/String;
/*     */     //   177: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   180: ldc '' has a value ('
/*     */     //   182: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   185: aload_2
/*     */     //   186: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   189: ldc ') which is greater than the maximum value '
/*     */     //   191: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   194: aload_0
/*     */     //   195: getfield max : I
/*     */     //   198: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   201: ldc ' in '
/*     */     //   203: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   206: aload_1
/*     */     //   207: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   210: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   213: aload_0
/*     */     //   214: aload_2
/*     */     //   215: invokevirtual intValue : ()I
/*     */     //   218: invokespecial <init> : (Ljava/lang/String;Lorg/spongepowered/asm/util/ConstraintParser$Constraint;I)V
/*     */     //   221: athrow
/*     */     //   222: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   225: athrow
/*     */     //   226: aload_0
/*     */     //   227: getfield next : Lorg/spongepowered/asm/util/ConstraintParser$Constraint;
/*     */     //   230: ifnull -> 248
/*     */     //   233: aload_0
/*     */     //   234: getfield next : Lorg/spongepowered/asm/util/ConstraintParser$Constraint;
/*     */     //   237: aload_1
/*     */     //   238: invokevirtual check : (Lorg/spongepowered/asm/util/ITokenProvider;)V
/*     */     //   241: goto -> 248
/*     */     //   244: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   247: athrow
/*     */     //   248: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #69	-> 0
/*     */     //   #21	-> 7
/*     */     //   #85	-> 18
/*     */     //   #12	-> 22
/*     */     //   #34	-> 66
/*     */     //   #62	-> 77
/*     */     //   #35	-> 135
/*     */     //   #14	-> 146
/*     */     //   #1	-> 157
/*     */     //   #67	-> 215
/*     */     //   #41	-> 226
/*     */     //   #45	-> 233
/*     */     //   #27	-> 248
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   18	62	62	org/spongepowered/asm/util/throwables/ConstraintViolationException
/*     */     //   66	142	142	org/spongepowered/asm/util/throwables/ConstraintViolationException
/*     */     //   146	222	222	org/spongepowered/asm/util/throwables/ConstraintViolationException
/*     */     //   226	241	244	org/spongepowered/asm/util/throwables/ConstraintViolationException
/*     */   }
/*     */   
/*     */   public String getToken() {
/*     */     return this.token;
/*     */   }
/*     */   
/*     */   private boolean has(int paramInt) {
/*     */     try {
/*     */     
/*     */     } catch (InvalidConstraintException invalidConstraintException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return (this.constraint[paramInt] != null);
/*     */   }
/*     */   
/*     */   private static Exception b(Exception paramException) {
/*     */     return paramException;
/*     */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\ConstraintParser$Constraint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */