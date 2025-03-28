/*    */ package org.spongepowered.asm.mixin.injection.modify;
/*  2 */ class BeforeLoadLocal$SearchState { void setPendingCheck() { this.pendingCheck = true; } void register(VarInsnNode paramVarInsnNode) {
/*  3 */     this.varNode = paramVarInsnNode;
/*    */   } void check(Collection<AbstractInsnNode> paramCollection, AbstractInsnNode paramAbstractInsnNode, int paramInt) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: iconst_0
/*    */     //   2: putfield pendingCheck : Z
/*    */     //   5: iload_3
/*    */     //   6: aload_0
/*    */     //   7: getfield varNode : Lorg/spongepowered/asm/lib/tree/VarInsnNode;
/*    */     //   10: getfield var : I
/*    */     //   13: if_icmpeq -> 48
/*    */     //   16: iload_3
/*    */     //   17: bipush #-2
/*    */     //   19: if_icmpgt -> 43
/*    */     //   22: goto -> 29
/*    */     //   25: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   28: athrow
/*    */     //   29: aload_0
/*    */     //   30: getfield print : Z
/*    */     //   33: ifne -> 48
/*    */     //   36: goto -> 43
/*    */     //   39: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   42: athrow
/*    */     //   43: return
/*    */     //   44: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   47: athrow
/*    */     //   48: aload_0
/*    */     //   49: getfield targetOrdinal : I
/*    */     //   52: iconst_m1
/*    */     //   53: if_icmpeq -> 74
/*    */     //   56: aload_0
/*    */     //   57: getfield targetOrdinal : I
/*    */     //   60: aload_0
/*    */     //   61: getfield ordinal : I
/*    */     //   64: if_icmpne -> 94
/*    */     //   67: goto -> 74
/*    */     //   70: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   73: athrow
/*    */     //   74: aload_1
/*    */     //   75: aload_2
/*    */     //   76: invokeinterface add : (Ljava/lang/Object;)Z
/*    */     //   81: pop
/*    */     //   82: aload_0
/*    */     //   83: iconst_1
/*    */     //   84: putfield found : Z
/*    */     //   87: goto -> 94
/*    */     //   90: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   93: athrow
/*    */     //   94: aload_0
/*    */     //   95: dup
/*    */     //   96: getfield ordinal : I
/*    */     //   99: iconst_1
/*    */     //   100: iadd
/*    */     //   101: putfield ordinal : I
/*    */     //   104: aload_0
/*    */     //   105: aconst_null
/*    */     //   106: putfield varNode : Lorg/spongepowered/asm/lib/tree/VarInsnNode;
/*    */     //   109: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #4	-> 0
/*    */     //   #16	-> 5
/*    */     //   #7	-> 43
/*    */     //   #18	-> 48
/*    */     //   #9	-> 74
/*    */     //   #15	-> 82
/*    */     //   #8	-> 94
/*    */     //   #12	-> 104
/*    */     //   #5	-> 109
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   0	22	25	java/lang/RuntimeException
/*    */     //   16	36	39	java/lang/RuntimeException
/*    */     //   29	44	44	java/lang/RuntimeException
/*    */     //   48	67	70	java/lang/RuntimeException
/*    */     //   56	87	90	java/lang/RuntimeException
/*  6 */   } private int ordinal = 0;
/*    */ 
/*    */   
/*    */   BeforeLoadLocal$SearchState(int paramInt, boolean paramBoolean) {
/* 10 */     this.targetOrdinal = paramInt;
/*    */ 
/*    */     
/* 13 */     this.print = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   private boolean found = false;
/*    */   
/*    */   boolean isPendingCheck() {
/* 20 */     return this.pendingCheck;
/*    */   } private boolean pendingCheck = false; private final boolean print; private final int targetOrdinal; private VarInsnNode varNode; boolean success() {
/* 22 */     return this.found;
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\modify\BeforeLoadLocal$SearchState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */