/*    */ package org.spongepowered.asm.mixin.transformer;abstract class ClassInfo$Member { private final ClassInfo$Member$Type type; private final String memberName; private final String memberDesc; private final boolean isInjected; private final int modifiers; private String currentName; private String currentDesc; private boolean decoratedFinal; private boolean decoratedMutable; private boolean unique;
/*  2 */   protected ClassInfo$Member(ClassInfo$Member$Type paramClassInfo$Member$Type, String paramString1, String paramString2, int paramInt) { this(paramClassInfo$Member$Type, paramString1, paramString2, paramInt, false); }
/*  3 */   protected String getDisplayFormat() { return "%s%s"; }
/*  4 */   public int getAccess() { return this.modifiers; } public boolean isFinal() { try {  }
/*  5 */     catch (RuntimeException runtimeException) { throw b(null); }  return ((this.modifiers & 0x10) != 0); }
/*    */ 
/*    */   
/*  8 */   public String getName() { return this.currentName; } public boolean matchesFlags(int paramInt) { 
/*  9 */     try { if (((this.modifiers ^ 0xFFFFFFFF | paramInt & 0x2) & 0x2) != 0) try { if (((this.modifiers ^ 0xFFFFFFFF | paramInt & 0x8) & 0x8) != 0); } catch (RuntimeException runtimeException) { throw b(null); }   } catch (RuntimeException runtimeException) { throw b(null); }  return false; }
/*    */   public boolean isSynthetic() { 
/*    */     try {  }
/*    */     catch (RuntimeException runtimeException)
/* 13 */     { throw b(null); }  return ((this.modifiers & 0x1000) != 0); } public boolean isRemapped() { try {  }
/* 14 */     catch (RuntimeException runtimeException) { throw b(null); }  return !this.currentDesc.equals(this.memberDesc); }
/*    */   
/*    */   public boolean equals(Object paramObject) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: instanceof org/spongepowered/asm/mixin/transformer/ClassInfo$Member
/*    */     //   4: ifne -> 13
/*    */     //   7: iconst_0
/*    */     //   8: ireturn
/*    */     //   9: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   12: athrow
/*    */     //   13: aload_1
/*    */     //   14: checkcast org/spongepowered/asm/mixin/transformer/ClassInfo$Member
/*    */     //   17: astore_2
/*    */     //   18: aload_2
/*    */     //   19: getfield memberName : Ljava/lang/String;
/*    */     //   22: aload_0
/*    */     //   23: getfield memberName : Ljava/lang/String;
/*    */     //   26: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   29: ifne -> 53
/*    */     //   32: aload_2
/*    */     //   33: getfield currentName : Ljava/lang/String;
/*    */     //   36: aload_0
/*    */     //   37: getfield currentName : Ljava/lang/String;
/*    */     //   40: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   43: ifeq -> 103
/*    */     //   46: goto -> 53
/*    */     //   49: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   52: athrow
/*    */     //   53: aload_2
/*    */     //   54: getfield memberDesc : Ljava/lang/String;
/*    */     //   57: aload_0
/*    */     //   58: getfield memberDesc : Ljava/lang/String;
/*    */     //   61: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   64: ifne -> 95
/*    */     //   67: goto -> 74
/*    */     //   70: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   73: athrow
/*    */     //   74: aload_2
/*    */     //   75: getfield currentDesc : Ljava/lang/String;
/*    */     //   78: aload_0
/*    */     //   79: getfield currentDesc : Ljava/lang/String;
/*    */     //   82: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   85: ifeq -> 103
/*    */     //   88: goto -> 95
/*    */     //   91: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   94: athrow
/*    */     //   95: iconst_1
/*    */     //   96: goto -> 104
/*    */     //   99: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   102: athrow
/*    */     //   103: iconst_0
/*    */     //   104: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #16	-> 0
/*    */     //   #10	-> 7
/*    */     //   #1	-> 13
/*    */     //   #15	-> 18
/*    */     //   #33	-> 61
/*    */     //   #47	-> 104
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   0	9	9	java/lang/RuntimeException
/*    */     //   18	46	49	java/lang/RuntimeException
/*    */     //   32	67	70	java/lang/RuntimeException
/*    */     //   53	88	91	java/lang/RuntimeException
/*    */     //   74	99	99	java/lang/RuntimeException
/*    */   }
/* 19 */   protected ClassInfo$Member(ClassInfo$Member paramClassInfo$Member) { this(paramClassInfo$Member.type, paramClassInfo$Member.memberName, paramClassInfo$Member.memberDesc, paramClassInfo$Member.modifiers, paramClassInfo$Member.isInjected);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     this.currentName = paramClassInfo$Member.currentName;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 36 */     this.currentDesc = paramClassInfo$Member.currentDesc; this.unique = paramClassInfo$Member.unique; } public boolean isDecoratedMutable() { return this.decoratedMutable; }
/*    */   public String getOriginalName() { return this.memberName; }
/*    */   public boolean isAbstract() { try {
/*    */     
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     }  return ((this.modifiers & 0x400) != 0); }
/*    */   public String toString() { return String.format(getDisplayFormat(), new Object[] { this.memberName, this.memberDesc }); }
/*    */   public boolean isUnique() { return this.unique; }
/*    */   protected ClassInfo$Member(ClassInfo$Member$Type paramClassInfo$Member$Type, String paramString1, String paramString2, int paramInt, boolean paramBoolean) { this.type = paramClassInfo$Member$Type; this.memberName = paramString1; this.memberDesc = paramString2; this.isInjected = paramBoolean;
/*    */     this.currentName = paramString1;
/*    */     this.currentDesc = paramString2;
/* 48 */     this.modifiers = paramInt; }
/* 49 */   public String remapTo(String paramString) { this.currentDesc = paramString; return paramString; } public boolean isInjected() { return this.isInjected; } public String renameTo(String paramString) { this.currentName = paramString; return paramString; } public boolean isStatic() { try {  } catch (RuntimeException runtimeException) { throw b(null); }  return ((this.modifiers & 0x8) != 0); }
/*    */   public void setDecoratedFinal(boolean paramBoolean1, boolean paramBoolean2) { this.decoratedFinal = paramBoolean1; this.decoratedMutable = paramBoolean2; } public boolean isPrivate() { try {  } catch (RuntimeException runtimeException) { throw b(null); }  return ((this.modifiers & 0x2) != 0); } public void setUnique(boolean paramBoolean) { this.unique = paramBoolean; } public boolean equals(String paramString1, String paramString2) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield memberName : Ljava/lang/String;
/*    */     //   4: aload_1
/*    */     //   5: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   8: ifne -> 29
/*    */     //   11: aload_0
/*    */     //   12: getfield currentName : Ljava/lang/String;
/*    */     //   15: aload_1
/*    */     //   16: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   19: ifeq -> 73
/*    */     //   22: goto -> 29
/*    */     //   25: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   28: athrow
/*    */     //   29: aload_0
/*    */     //   30: getfield memberDesc : Ljava/lang/String;
/*    */     //   33: aload_2
/*    */     //   34: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   37: ifne -> 65
/*    */     //   40: goto -> 47
/*    */     //   43: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   46: athrow
/*    */     //   47: aload_0
/*    */     //   48: getfield currentDesc : Ljava/lang/String;
/*    */     //   51: aload_2
/*    */     //   52: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   55: ifeq -> 73
/*    */     //   58: goto -> 65
/*    */     //   61: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   64: athrow
/*    */     //   65: iconst_1
/*    */     //   66: goto -> 74
/*    */     //   69: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   72: athrow
/*    */     //   73: iconst_0
/*    */     //   74: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #43	-> 0
/*    */     //   #46	-> 34
/*    */     //   #11	-> 74
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   0	22	25	java/lang/RuntimeException
/*    */     //   11	40	43	java/lang/RuntimeException
/*    */     //   29	58	61	java/lang/RuntimeException
/* 50 */     //   47	69	69	java/lang/RuntimeException } public String getOriginalDesc() { return this.memberDesc; }
/* 51 */   public String getDesc() { return this.currentDesc; }
/* 52 */   public int hashCode() { return toString().hashCode(); }
/* 53 */   public boolean isDecoratedFinal() { return this.decoratedFinal; }
/* 54 */   public ClassInfo getImplementor() { return getOwner(); } public boolean isRenamed() { try {  }
/* 55 */     catch (RuntimeException runtimeException) { throw b(null); }  return !this.currentName.equals(this.memberName); }
/*    */ 
/*    */   
/*    */   public abstract ClassInfo getOwner();
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\ClassInfo$Member.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */