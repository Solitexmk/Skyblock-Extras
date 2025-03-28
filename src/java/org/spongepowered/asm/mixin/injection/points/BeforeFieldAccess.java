/*    */ package org.spongepowered.asm.mixin.injection.points;@AtCode("FIELD")
/*  2 */ public class BeforeFieldAccess extends BeforeInvoke { private static final String ARRAY_GET = "get"; private static final String ARRAY_SET = "set"; private static final String ARRAY_LENGTH = "length"; public int getArrayOpcode() { return this.arrOpcode; } public static final int ARRAY_SEARCH_FUZZ_DEFAULT = 8; private final int opcode; private final int arrOpcode; private final int fuzzFactor; private int getArrayOpcode(String paramString) { 
/*  3 */     try { if (this.arrOpcode != 190)
/*    */       {
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
/* 30 */         return Type.getType(paramString).getElementType().getOpcode(this.arrOpcode); }  } catch (RuntimeException runtimeException) { throw c(null); }
/*    */     
/*    */     return this.arrOpcode; }
/*    */    protected boolean addInsn(InsnList paramInsnList, Collection<AbstractInsnNode> paramCollection, AbstractInsnNode paramAbstractInsnNode) {
/*    */     if (this.arrOpcode > 0) {
/* 35 */       FieldInsnNode fieldInsnNode = (FieldInsnNode)paramAbstractInsnNode;
/*    */ 
/*    */       
/* 38 */       int i = getArrayOpcode(fieldInsnNode.desc);
/*    */ 
/*    */       
/*    */       try {
/* 42 */         log("{} > > > > searching for array access opcode {} fuzz={}", new Object[] { this.className, Bytecode.getOpcodeName(i), Integer.valueOf(this.fuzzFactor) });
/* 43 */         if (findArrayNode(paramInsnList, fieldInsnNode, i, this.fuzzFactor) == null) {
/*    */           log("{} > > > > > failed to locate matching insn", new Object[] { this.className });
/*    */           return false;
/*    */         } 
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw c(null);
/*    */       } 
/*    */     } 
/*    */     log("{} > > > > > adding matching insn", new Object[] { this.className });
/*    */     return super.addInsn(paramInsnList, paramCollection, paramAbstractInsnNode);
/*    */   }
/*    */   
/*    */   public BeforeFieldAccess(InjectionPointData paramInjectionPointData) {
/*    */     super(paramInjectionPointData);
/*    */     this.opcode = paramInjectionPointData.getOpcode(-1, new int[] { 180, 181, 178, 179, -1 });
/*    */     String str = paramInjectionPointData.get("array", "");
/*    */     try {
/*    */       try {
/*    */         try {
/*    */         
/*    */         } catch (RuntimeException runtimeException) {
/*    */           throw c(null);
/*    */         } 
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw c(null);
/*    */       } 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw c(null);
/*    */     } 
/*    */     this.arrOpcode = "get".equalsIgnoreCase(str) ? 46 : ("set".equalsIgnoreCase(str) ? 79 : ("length".equalsIgnoreCase(str) ? 190 : 0));
/*    */     this.fuzzFactor = Math.min(Math.max(paramInjectionPointData.get("fuzz", 8), 1), 32);
/*    */   }
/*    */   
/*    */   public int getFuzzFactor() {
/*    */     return this.fuzzFactor;
/*    */   }
/*    */   
/*    */   protected boolean matchesInsn(AbstractInsnNode paramAbstractInsnNode) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: instanceof org/spongepowered/asm/lib/tree/FieldInsnNode
/*    */     //   4: ifeq -> 124
/*    */     //   7: aload_1
/*    */     //   8: checkcast org/spongepowered/asm/lib/tree/FieldInsnNode
/*    */     //   11: invokevirtual getOpcode : ()I
/*    */     //   14: aload_0
/*    */     //   15: getfield opcode : I
/*    */     //   18: if_icmpeq -> 43
/*    */     //   21: goto -> 28
/*    */     //   24: invokestatic c : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   27: athrow
/*    */     //   28: aload_0
/*    */     //   29: getfield opcode : I
/*    */     //   32: iconst_m1
/*    */     //   33: if_icmpne -> 124
/*    */     //   36: goto -> 43
/*    */     //   39: invokestatic c : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   42: athrow
/*    */     //   43: aload_0
/*    */     //   44: getfield arrOpcode : I
/*    */     //   47: ifne -> 63
/*    */     //   50: goto -> 57
/*    */     //   53: invokestatic c : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   56: athrow
/*    */     //   57: iconst_1
/*    */     //   58: ireturn
/*    */     //   59: invokestatic c : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   62: athrow
/*    */     //   63: aload_1
/*    */     //   64: invokevirtual getOpcode : ()I
/*    */     //   67: sipush #178
/*    */     //   70: if_icmpeq -> 96
/*    */     //   73: aload_1
/*    */     //   74: invokevirtual getOpcode : ()I
/*    */     //   77: sipush #180
/*    */     //   80: if_icmpeq -> 96
/*    */     //   83: goto -> 90
/*    */     //   86: invokestatic c : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   89: athrow
/*    */     //   90: iconst_0
/*    */     //   91: ireturn
/*    */     //   92: invokestatic c : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   95: athrow
/*    */     //   96: aload_1
/*    */     //   97: checkcast org/spongepowered/asm/lib/tree/FieldInsnNode
/*    */     //   100: getfield desc : Ljava/lang/String;
/*    */     //   103: invokestatic getType : (Ljava/lang/String;)Lorg/spongepowered/asm/lib/Type;
/*    */     //   106: invokevirtual getSort : ()I
/*    */     //   109: bipush #9
/*    */     //   111: if_icmpne -> 122
/*    */     //   114: iconst_1
/*    */     //   115: goto -> 123
/*    */     //   118: invokestatic c : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   121: athrow
/*    */     //   122: iconst_0
/*    */     //   123: ireturn
/*    */     //   124: iconst_0
/*    */     //   125: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #32	-> 0
/*    */     //   #40	-> 43
/*    */     //   #41	-> 57
/*    */     //   #15	-> 63
/*    */     //   #17	-> 90
/*    */     //   #9	-> 96
/*    */     //   #44	-> 124
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   0	21	24	java/lang/RuntimeException
/*    */     //   7	36	39	java/lang/RuntimeException
/*    */     //   28	50	53	java/lang/RuntimeException
/*    */     //   43	59	59	java/lang/RuntimeException
/*    */     //   63	83	86	java/lang/RuntimeException
/*    */     //   73	92	92	java/lang/RuntimeException
/*    */     //   96	118	118	java/lang/RuntimeException
/*    */   }
/*    */   
/*    */   public static AbstractInsnNode findArrayNode(InsnList paramInsnList, FieldInsnNode paramFieldInsnNode, int paramInt1, int paramInt2) {
/*    */     boolean bool = false;
/*    */     for (ListIterator<AbstractInsnNode> listIterator = paramInsnList.iterator(paramInsnList.indexOf((AbstractInsnNode)paramFieldInsnNode) + 1); listIterator.hasNext(); ) {
/*    */       AbstractInsnNode abstractInsnNode = listIterator.next();
/*    */       try {
/*    */         if (abstractInsnNode.getOpcode() == paramInt1)
/*    */           return abstractInsnNode; 
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw c(null);
/*    */       } 
/*    */     } 
/*    */     return null;
/*    */   }
/*    */   
/*    */   private static RuntimeException c(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\points\BeforeFieldAccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */