/*     */ package org.spongepowered.asm.util;public class SignaturePrinter { private final String name; private final Type returnType; private final Type[] argTypes; private final String[] argNames; private String modifiers; private boolean fullyQualified;
/*   2 */   public SignaturePrinter(MemberInfo paramMemberInfo) { this(paramMemberInfo.name, paramMemberInfo.desc); } public SignaturePrinter(MethodNode paramMethodNode, String[] paramArrayOfString) {
/*   3 */     this(paramMethodNode.name, Type.VOID_TYPE, Type.getArgumentTypes(paramMethodNode.desc), paramArrayOfString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  45 */     setModifiers(paramMethodNode);
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
/*     */   public void setModifiers(MethodNode paramMethodNode) {
/*     */     String str = getTypeName(Type.getReturnType(paramMethodNode.desc), false, this.fullyQualified);
/*     */     
/*     */     try { if ((paramMethodNode.access & 0x1) != 0)
/*  89 */       { setModifiers("public " + str); } else { try { if ((paramMethodNode.access & 0x4) != 0) { setModifiers("protected " + str); } else { try { if ((paramMethodNode.access & 0x2) != 0) { setModifiers("private " + str); } else { setModifiers(str); }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }
/*     */   
/*     */   } public String toString() { return appendArgs((new StringBuilder()).append(this.modifiers).append(" ").append(this.name), false, true).toString(); } public static String getTypeName(Type paramType, boolean paramBoolean1, boolean paramBoolean2) { 
/*     */     try { String str;
/*     */       switch (paramType.getSort())
/*     */       { case 0:
/*     */           try {
/*     */           
/*     */           } catch (IllegalArgumentException illegalArgumentException) {
/*     */             throw b(null);
/*     */           } 
/*     */           return paramBoolean1 ? "Void" : "void";
/*     */         case 1:
/*     */           
/*     */           try {  }
/*     */           catch (IllegalArgumentException illegalArgumentException)
/* 105 */           { throw b(null); }  return paramBoolean1 ? "Boolean" : "boolean";
/*     */         case 2: try {  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return paramBoolean1 ? "Character" : "char";
/*     */         case 3: try {  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return paramBoolean1 ? "Byte" : "byte";
/*     */         case 4: try {  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return paramBoolean1 ? "Short" : "short";
/*     */         case 5: try {  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return paramBoolean1 ? "Integer" : "int";
/*     */         case 6: try {  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return paramBoolean1 ? "Float" : "float";
/*     */         case 7: try {  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return paramBoolean1 ? "Long" : "long";
/*     */         case 8:
/* 113 */           try {  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return paramBoolean1 ? "Double" : "double";case 9: return getTypeName(paramType.getElementType(), paramBoolean1, paramBoolean2) + arraySuffix(paramType);case 10: str = paramType.getClassName(); if (!paramBoolean2) str = str.substring(str.lastIndexOf('.') + 1);  return str; }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return "Object"; } public SignaturePrinter(String paramString, Type paramType, LocalVariableNode[] paramArrayOfLocalVariableNode) { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokespecial <init> : ()V
/*     */     //   4: aload_0
/*     */     //   5: ldc 'private void'
/*     */     //   7: putfield modifiers : Ljava/lang/String;
/*     */     //   10: aload_0
/*     */     //   11: aload_1
/*     */     //   12: putfield name : Ljava/lang/String;
/*     */     //   15: aload_0
/*     */     //   16: aload_2
/*     */     //   17: putfield returnType : Lorg/spongepowered/asm/lib/Type;
/*     */     //   20: aload_0
/*     */     //   21: aload_3
/*     */     //   22: arraylength
/*     */     //   23: anewarray org/spongepowered/asm/lib/Type
/*     */     //   26: putfield argTypes : [Lorg/spongepowered/asm/lib/Type;
/*     */     //   29: aload_0
/*     */     //   30: aload_3
/*     */     //   31: arraylength
/*     */     //   32: anewarray java/lang/String
/*     */     //   35: putfield argNames : [Ljava/lang/String;
/*     */     //   38: iconst_0
/*     */     //   39: istore #4
/*     */     //   41: iload #4
/*     */     //   43: aload_3
/*     */     //   44: arraylength
/*     */     //   45: if_icmpge -> 106
/*     */     //   48: aload_3
/*     */     //   49: iload #4
/*     */     //   51: aaload
/*     */     //   52: ifnull -> 100
/*     */     //   55: goto -> 62
/*     */     //   58: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   61: athrow
/*     */     //   62: aload_0
/*     */     //   63: getfield argTypes : [Lorg/spongepowered/asm/lib/Type;
/*     */     //   66: iload #4
/*     */     //   68: aload_3
/*     */     //   69: iload #4
/*     */     //   71: aaload
/*     */     //   72: getfield desc : Ljava/lang/String;
/*     */     //   75: invokestatic getType : (Ljava/lang/String;)Lorg/spongepowered/asm/lib/Type;
/*     */     //   78: aastore
/*     */     //   79: aload_0
/*     */     //   80: getfield argNames : [Ljava/lang/String;
/*     */     //   83: iload #4
/*     */     //   85: aload_3
/*     */     //   86: iload #4
/*     */     //   88: aaload
/*     */     //   89: getfield name : Ljava/lang/String;
/*     */     //   92: aastore
/*     */     //   93: goto -> 100
/*     */     //   96: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   99: athrow
/*     */     //   100: iinc #4, 1
/*     */     //   103: goto -> 41
/*     */     //   106: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #31	-> 0
/*     */     //   #14	-> 4
/*     */     //   #11	-> 10
/*     */     //   #79	-> 15
/*     */     //   #86	-> 20
/*     */     //   #99	-> 29
/*     */     //   #96	-> 38
/*     */     //   #42	-> 48
/*     */     //   #69	-> 62
/*     */     //   #29	-> 79
/*     */     //   #15	-> 100
/*     */     //   #76	-> 106
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   41	55	58	java/lang/IllegalArgumentException
/*     */     //   48	93	96	java/lang/IllegalArgumentException }
/* 114 */   private StringBuilder appendType(StringBuilder paramStringBuilder, Type paramType, String paramString) { try { switch (paramType.getSort()) { case 9: return appendArraySuffix(appendType(paramStringBuilder, paramType.getElementType(), paramString), paramType);case 10: return appendType(paramStringBuilder, paramType.getClassName(), paramString); }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  try { paramStringBuilder.append(getTypeName(paramType, false, this.fullyQualified)); if (paramString != null) paramStringBuilder.append(' ').append(paramString);  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return paramStringBuilder; } private StringBuilder appendArgs(StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2) { paramStringBuilder.append('('); byte b = 0; while (true) { try { if (b < this.argTypes.length) { try { if (this.argTypes[b] != null) { try { if (b > 0) try { paramStringBuilder.append(','); if (paramBoolean2)
/* 115 */                       paramStringBuilder.append(' ');  } catch (Exception exception) { throw b(null); }   } catch (Exception exception) { throw b(null); }  try { try { try {  } catch (Exception exception) { throw b(null); }  } catch (Exception exception) { throw b(null); }  String str = paramBoolean1 ? null : (Strings.isNullOrEmpty(this.argNames[b]) ? ("unnamed" + b) : this.argNames[b]); appendType(paramStringBuilder, this.argTypes[b], str); } catch (Exception exception) { throw new RuntimeException(exception); }  }  } catch (Exception exception) { throw b(null); }  b++; continue; }  } catch (Exception exception) { throw b(null); }  break; }
/* 116 */      return paramStringBuilder.append(")"); }
/*     */ 
/*     */   
/*     */   public String getFormattedArgs() {
/*     */     return appendArgs(new StringBuilder(), true, true).toString();
/*     */   }
/*     */   
/*     */   public boolean isFullyQualified() {
/*     */     return this.fullyQualified;
/*     */   }
/*     */   
/*     */   public static String getTypeName(Type paramType, boolean paramBoolean) {
/*     */     return getTypeName(paramType, paramBoolean, false);
/*     */   }
/*     */   
/*     */   public SignaturePrinter(String paramString, Type paramType, Type[] paramArrayOfType) {
/*     */     this.modifiers = "private void";
/*     */     this.name = paramString;
/*     */     this.returnType = paramType;
/*     */     this.argTypes = new Type[paramArrayOfType.length];
/*     */     this.argNames = new String[paramArrayOfType.length];
/*     */     byte b1 = 0, b2 = 0;
/*     */     while (true) {
/*     */       try {
/*     */         if (b1 < paramArrayOfType.length) {
/*     */           try {
/*     */             if (paramArrayOfType[b1] != null) {
/*     */               this.argTypes[b1] = paramArrayOfType[b1];
/*     */               this.argNames[b1] = "var" + b2++;
/*     */             } 
/*     */           } catch (IllegalArgumentException illegalArgumentException) {
/*     */             throw b(null);
/*     */           } 
/*     */           b1++;
/*     */         } 
/*     */       } catch (IllegalArgumentException illegalArgumentException) {
/*     */         throw b(null);
/*     */       } 
/*     */       break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public SignaturePrinter setFullyQualified(boolean paramBoolean) {
/*     */     this.fullyQualified = paramBoolean;
/*     */     return this;
/*     */   }
/*     */   
/*     */   private StringBuilder appendType(StringBuilder paramStringBuilder, String paramString1, String paramString2) {
/*     */     if (!this.fullyQualified)
/*     */       paramString1 = paramString1.substring(paramString1.lastIndexOf('.') + 1); 
/*     */     try {
/*     */       paramStringBuilder.append(paramString1);
/*     */       if (paramString1.endsWith("CallbackInfoReturnable"))
/*     */         paramStringBuilder.append('<').append(getTypeName(this.returnType, true, this.fullyQualified)).append('>'); 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (paramString2 != null)
/*     */         paramStringBuilder.append(' ').append(paramString2); 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return paramStringBuilder;
/*     */   }
/*     */   
/*     */   public String toDescriptor() {
/*     */     StringBuilder stringBuilder = appendArgs(new StringBuilder(), true, false);
/*     */     return stringBuilder.append(getTypeName(this.returnType, false, this.fullyQualified)).toString();
/*     */   }
/*     */   
/*     */   private static String arraySuffix(Type paramType) {
/*     */     return Strings.repeat("[]", paramType.getDimensions());
/*     */   }
/*     */   
/*     */   public SignaturePrinter(String paramString1, String paramString2) {
/*     */     this(paramString1, Type.getReturnType(paramString2), Type.getArgumentTypes(paramString2));
/*     */   }
/*     */   
/*     */   private static StringBuilder appendArraySuffix(StringBuilder paramStringBuilder, Type paramType) {
/*     */     byte b = 0;
/*     */     try {
/*     */       for (; b < paramType.getDimensions(); b++)
/*     */         paramStringBuilder.append("[]"); 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return paramStringBuilder;
/*     */   }
/*     */   
/*     */   public SignaturePrinter(MethodNode paramMethodNode) {
/*     */     this(paramMethodNode.name, Type.VOID_TYPE, Type.getArgumentTypes(paramMethodNode.desc));
/*     */     setModifiers(paramMethodNode);
/*     */   }
/*     */   
/*     */   public SignaturePrinter setModifiers(String paramString) {
/*     */     this.modifiers = paramString.replace("${returnType}", getReturnType());
/*     */     return this;
/*     */   }
/*     */   
/*     */   public SignaturePrinter(String paramString, Type paramType, Type[] paramArrayOfType, String[] paramArrayOfString) {
/*     */     this.modifiers = "private void";
/*     */     this.name = paramString;
/*     */     this.returnType = paramType;
/*     */     this.argTypes = paramArrayOfType;
/*     */     this.argNames = paramArrayOfString;
/*     */     if (this.argTypes.length > this.argNames.length)
/*     */       throw new IllegalArgumentException(String.format("Types array length must not exceed names array length! (names=%d, types=%d)", new Object[] { Integer.valueOf(this.argNames.length), Integer.valueOf(this.argTypes.length) })); 
/*     */   }
/*     */   
/*     */   public String getReturnType() {
/*     */     return getTypeName(this.returnType, false, this.fullyQualified);
/*     */   }
/*     */   
/*     */   private static Exception b(Exception paramException) {
/*     */     return paramException;
/*     */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\SignaturePrinter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */