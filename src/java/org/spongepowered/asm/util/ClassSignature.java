/*     */ package org.spongepowered.asm.util;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.spongepowered.asm.lib.tree.ClassNode;
/*     */ 
/*     */ public class ClassSignature {
/*     */   public String getSuperClass() {
/*   9 */     return this.superClass.asType(true);
/*     */   }
/*     */   
/*  12 */   private String findOffsetName(char paramChar, Set<String> paramSet) { return findOffsetName(paramChar, paramSet, "", ""); } public void addInterface(String paramString) {
/*  13 */     this.rawInterfaces.add(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  18 */   private ClassSignature$Token superClass = new ClassSignature$Token("java/lang/Object");
/*     */ 
/*     */ 
/*     */   
/*     */   public static ClassSignature of(ClassNode paramClassNode) {
/*     */     
/*  24 */     try { if (paramClassNode.signature != null)
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
/*  86 */         return of(paramClassNode.signature); }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }
/*     */     
/*     */     return generate(paramClassNode);
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
/*     */   protected String getTypeVar(ClassSignature$TokenHandle paramClassSignature$TokenHandle) {
/*     */     for (Map.Entry<ClassSignature$TypeVar, ClassSignature$TokenHandle> entry : this.types.entrySet())
/* 118 */     { ClassSignature$TypeVar classSignature$TypeVar = (ClassSignature$TypeVar)entry.getKey();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ClassSignature$TokenHandle classSignature$TokenHandle = (ClassSignature$TokenHandle)entry.getValue();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 141 */       try { if (paramClassSignature$TokenHandle != classSignature$TokenHandle) { try { if (paramClassSignature$TokenHandle.asToken() == classSignature$TokenHandle.asToken()) return "T" + classSignature$TypeVar + ";";  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  continue; }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return "T" + classSignature$TypeVar + ";"; }  return paramClassSignature$TokenHandle.token.asType(); } public String toString() { try { while (this.rawInterfaces.size() > 0)
/*     */         addRawInterface(this.rawInterfaces.remove());  }
/*     */     catch (IllegalArgumentException illegalArgumentException) { throw b(null); }
/* 144 */      StringBuilder stringBuilder = new StringBuilder(); if (this.types.size() > 0) { boolean bool = false; StringBuilder stringBuilder1 = new StringBuilder(); for (Map.Entry<ClassSignature$TypeVar, ClassSignature$TokenHandle> entry : this.types.entrySet()) { String str = ((ClassSignature$TokenHandle)entry.getValue()).asBound(); if (!str.isEmpty()) { stringBuilder1.append(entry.getKey()).append(':').append(str); bool = true; }
/*     */          }
/*     */       
/*     */       try {
/*     */         if (bool)
/*     */           stringBuilder.append('<').append(stringBuilder1).append('>'); 
/*     */       } catch (IllegalArgumentException illegalArgumentException) {
/*     */         throw b(null);
/*     */       }  }
/*     */     
/*     */     stringBuilder.append(this.superClass.asType());
/*     */     for (ClassSignature$Token classSignature$Token : this.interfaces)
/*     */       stringBuilder.append(classSignature$Token.asType()); 
/*     */     return stringBuilder.toString(); }
/*     */ 
/*     */   
/*     */   private static ClassSignature generate(ClassNode paramClassNode) {
/*     */     ClassSignature classSignature = new ClassSignature();
/*     */     try {
/*     */     
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     classSignature.setSuperClass(new ClassSignature$Token((paramClassNode.superName != null) ? paramClassNode.superName : "java/lang/Object"));
/*     */     for (String str : paramClassNode.interfaces)
/*     */       classSignature.addInterface(new ClassSignature$Token(str)); 
/*     */     return classSignature;
/*     */   }
/*     */   
/*     */   private String findOffsetName(char paramChar, Set<String> paramSet, String paramString1, String paramString2) {
/*     */     String str = String.format("%s%s%s", new Object[] { paramString1, Character.valueOf(paramChar), paramString2 });
/*     */     try {
/*     */       if (!paramSet.contains(str))
/*     */         return str; 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (paramChar > '@' && paramChar < '[') {
/*     */         int i;
/*     */         for (i = paramChar - 64; i + 65 != paramChar; i = ++i % 26) {
/*     */           str = String.format("%s%s%s", new Object[] { paramString1, Character.valueOf((char)(i + 65)), paramString2 });
/*     */           try {
/*     */             if (!paramSet.contains(str))
/*     */               return str; 
/*     */           } catch (IllegalArgumentException illegalArgumentException) {
/*     */             throw b(null);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   protected ClassSignature$TypeVar getTypeVar(String paramString) {
/*     */     for (ClassSignature$TypeVar classSignature$TypeVar : this.types.keySet()) {
/*     */       try {
/*     */         if (classSignature$TypeVar.matches(paramString))
/*     */           return classSignature$TypeVar; 
/*     */       } catch (IllegalArgumentException illegalArgumentException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   private String findUniqueName(String paramString, Set<String> paramSet) {
/*     */     try {
/*     */       if (!paramSet.contains(paramString))
/*     */         return paramString; 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     if (paramString.length() == 1) {
/*     */       String str1 = findOffsetName(paramString.charAt(0), paramSet);
/*     */       try {
/*     */         if (str1 != null)
/*     */           return str1; 
/*     */       } catch (IllegalArgumentException illegalArgumentException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     String str = findOffsetName('T', paramSet, "", paramString);
/*     */     try {
/*     */       if (str != null)
/*     */         return str; 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     str = findOffsetName('T', paramSet, paramString, "");
/*     */     try {
/*     */       if (str != null)
/*     */         return str; 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     str = findOffsetName('T', paramSet, "T", paramString);
/*     */     try {
/*     */       if (str != null)
/*     */         return str; 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     str = findOffsetName('T', paramSet, "", paramString + "Type");
/*     */     try {
/*     */       if (str != null)
/*     */         return str; 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     throw new IllegalStateException("Failed to conform type var: " + paramString);
/*     */   }
/*     */   
/*     */   public SignatureVisitor getRemapper() {
/*     */     return (SignatureVisitor)new ClassSignature$SignatureRemapper(this);
/*     */   }
/*     */   
/*     */   public ClassSignature wake() {
/*     */     return this;
/*     */   }
/*     */   
/*     */   protected void setSuperClass(ClassSignature$Token paramClassSignature$Token) {
/*     */     this.superClass = paramClassSignature$Token;
/*     */   }
/*     */   
/*     */   protected void addRawInterface(String paramString) {
/*     */     ClassSignature$Token classSignature$Token = new ClassSignature$Token(paramString);
/*     */     String str = classSignature$Token.asType(true);
/*     */     for (ClassSignature$Token classSignature$Token1 : this.interfaces) {
/*     */       try {
/*     */         if (classSignature$Token1.asType(true).equals(str))
/*     */           return; 
/*     */       } catch (IllegalArgumentException illegalArgumentException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     this.interfaces.add(classSignature$Token);
/*     */   }
/*     */   
/*     */   private final Map<ClassSignature$TypeVar, ClassSignature$TokenHandle> types = new LinkedHashMap<ClassSignature$TypeVar, ClassSignature$TokenHandle>();
/*     */   
/*     */   private ClassSignature read(String paramString) {
/*     */     if (paramString != null)
/*     */       try {
/*     */         (new SignatureReader(paramString)).accept(new ClassSignature$SignatureParser(this));
/*     */       } catch (Exception exception) {
/*     */         exception.printStackTrace();
/*     */       }  
/*     */     return this;
/*     */   }
/*     */   
/*     */   private void conform(Set<String> paramSet) {
/*     */     for (ClassSignature$TypeVar classSignature$TypeVar : this.types.keySet()) {
/*     */       String str = findUniqueName(classSignature$TypeVar.getOriginalName(), paramSet);
/*     */       classSignature$TypeVar.rename(str);
/*     */       paramSet.add(str);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected ClassSignature$TokenHandle getType(String paramString) {
/*     */     for (ClassSignature$TypeVar classSignature$TypeVar : this.types.keySet()) {
/*     */       try {
/*     */         if (classSignature$TypeVar.matches(paramString))
/*     */           return this.types.get(classSignature$TypeVar); 
/*     */       } catch (IllegalArgumentException illegalArgumentException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     ClassSignature$TokenHandle classSignature$TokenHandle = new ClassSignature$TokenHandle(this);
/*     */     this.types.put(new ClassSignature$TypeVar(paramString), classSignature$TokenHandle);
/*     */     return classSignature$TokenHandle;
/*     */   }
/*     */   
/*     */   public static ClassSignature ofLazy(ClassNode paramClassNode) {
/*     */     try {
/*     */       if (paramClassNode.signature != null)
/*     */         return new ClassSignature$Lazy(paramClassNode.signature); 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return generate(paramClassNode);
/*     */   }
/*     */   
/*     */   private final Deque<String> rawInterfaces = new LinkedList<String>();
/*     */   protected static final String OBJECT = "java/lang/Object";
/*     */   private final List<ClassSignature$Token> interfaces;
/*     */   
/*     */   ClassSignature() {
/*     */     this.rawInterfaces = new LinkedList<String>();
/*     */   }
/*     */   
/*     */   public void merge(ClassSignature paramClassSignature) {
/*     */     try {
/*     */       HashSet<String> hashSet = new HashSet();
/*     */       for (ClassSignature$TypeVar classSignature$TypeVar : this.types.keySet())
/*     */         hashSet.add(classSignature$TypeVar.toString()); 
/*     */       paramClassSignature.conform(hashSet);
/*     */     } catch (IllegalStateException illegalStateException) {
/*     */       illegalStateException.printStackTrace();
/*     */       return;
/*     */     } 
/*     */     for (Map.Entry<ClassSignature$TypeVar, ClassSignature$TokenHandle> entry : paramClassSignature.types.entrySet())
/*     */       addTypeVar((ClassSignature$TypeVar)entry.getKey(), (ClassSignature$TokenHandle)entry.getValue()); 
/*     */     for (ClassSignature$Token classSignature$Token : paramClassSignature.interfaces)
/*     */       addInterface(classSignature$Token); 
/*     */   }
/*     */   
/*     */   protected void addInterface(ClassSignature$Token paramClassSignature$Token) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: invokevirtual isRaw : ()Z
/*     */     //   4: ifne -> 86
/*     */     //   7: aload_1
/*     */     //   8: iconst_1
/*     */     //   9: invokevirtual asType : (Z)Ljava/lang/String;
/*     */     //   12: astore_2
/*     */     //   13: aload_0
/*     */     //   14: getfield interfaces : Ljava/util/List;
/*     */     //   17: invokeinterface listIterator : ()Ljava/util/ListIterator;
/*     */     //   22: astore_3
/*     */     //   23: aload_3
/*     */     //   24: invokeinterface hasNext : ()Z
/*     */     //   29: ifeq -> 86
/*     */     //   32: aload_3
/*     */     //   33: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   38: checkcast org/spongepowered/asm/util/ClassSignature$Token
/*     */     //   41: astore #4
/*     */     //   43: aload #4
/*     */     //   45: invokevirtual isRaw : ()Z
/*     */     //   48: ifeq -> 83
/*     */     //   51: aload #4
/*     */     //   53: iconst_1
/*     */     //   54: invokevirtual asType : (Z)Ljava/lang/String;
/*     */     //   57: aload_2
/*     */     //   58: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   61: ifeq -> 83
/*     */     //   64: goto -> 71
/*     */     //   67: invokestatic b : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
/*     */     //   70: athrow
/*     */     //   71: aload_3
/*     */     //   72: aload_1
/*     */     //   73: invokeinterface set : (Ljava/lang/Object;)V
/*     */     //   78: return
/*     */     //   79: invokestatic b : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
/*     */     //   82: athrow
/*     */     //   83: goto -> 23
/*     */     //   86: aload_0
/*     */     //   87: getfield interfaces : Ljava/util/List;
/*     */     //   90: aload_1
/*     */     //   91: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   96: pop
/*     */     //   97: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #129	-> 0
/*     */     //   #41	-> 7
/*     */     //   #50	-> 13
/*     */     //   #38	-> 32
/*     */     //   #107	-> 43
/*     */     //   #137	-> 71
/*     */     //   #58	-> 78
/*     */     //   #56	-> 83
/*     */     //   #72	-> 86
/*     */     //   #28	-> 97
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   43	64	67	java/lang/IllegalArgumentException
/*     */     //   51	79	79	java/lang/IllegalArgumentException
/*     */   }
/*     */   
/*     */   protected void addTypeVar(ClassSignature$TypeVar paramClassSignature$TypeVar, ClassSignature$TokenHandle paramClassSignature$TokenHandle) throws IllegalArgumentException {
/*     */     try {
/*     */       if (this.types.containsKey(paramClassSignature$TypeVar))
/*     */         throw new IllegalArgumentException("TypeVar " + paramClassSignature$TypeVar + " is already present on " + this); 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     this.types.put(paramClassSignature$TypeVar, paramClassSignature$TokenHandle);
/*     */   }
/*     */   
/*     */   public static ClassSignature of(String paramString) {
/*     */     return (new ClassSignature()).read(paramString);
/*     */   }
/*     */   
/*     */   private static IllegalArgumentException b(IllegalArgumentException paramIllegalArgumentException) {
/*     */     return paramIllegalArgumentException;
/*     */   }
/*     */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\ClassSignature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */