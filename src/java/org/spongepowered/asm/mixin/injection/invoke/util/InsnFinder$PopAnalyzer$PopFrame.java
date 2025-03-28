/*    */ package org.spongepowered.asm.mixin.injection.invoke.util;class InsnFinder$PopAnalyzer$PopFrame extends Frame<BasicValue> { public BasicValue pop() throws IndexOutOfBoundsException {
/*    */     try {
/*  3 */       if (this.state == InsnFinder$AnalyzerState.ANALYSE)
/*    */ 
/*    */         
/*    */         try { 
/*    */           
/*  8 */           if (--this.depth == 0)
/*    */           
/*    */           { 
/*    */ 
/*    */ 
/*    */ 
/*    */             
/* 15 */             this.state = InsnFinder$AnalyzerState.COMPLETE;
/*    */ 
/*    */             
/* 18 */             throw new InsnFinder$AnalysisResultException(this.current); }  } catch (IndexOutOfBoundsException indexOutOfBoundsException) { throw b(null); }
/*    */          
/*    */     } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
/*    */       throw b(null);
/* 22 */     }  return (BasicValue)super.pop();
/*    */   }
/*    */   
/*    */   private AbstractInsnNode current;
/*    */   private InsnFinder$AnalyzerState state;
/*    */   
/*    */   public void push(BasicValue paramBasicValue) throws IndexOutOfBoundsException {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield current : Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;
/*    */     //   4: aload_0
/*    */     //   5: getfield this$0 : Lorg/spongepowered/asm/mixin/injection/invoke/util/InsnFinder$PopAnalyzer;
/*    */     //   8: getfield node : Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;
/*    */     //   11: if_acmpne -> 55
/*    */     //   14: aload_0
/*    */     //   15: getfield state : Lorg/spongepowered/asm/mixin/injection/invoke/util/InsnFinder$AnalyzerState;
/*    */     //   18: getstatic org/spongepowered/asm/mixin/injection/invoke/util/InsnFinder$AnalyzerState.SEARCH : Lorg/spongepowered/asm/mixin/injection/invoke/util/InsnFinder$AnalyzerState;
/*    */     //   21: if_acmpne -> 55
/*    */     //   24: goto -> 31
/*    */     //   27: invokestatic b : (Ljava/lang/IndexOutOfBoundsException;)Ljava/lang/IndexOutOfBoundsException;
/*    */     //   30: athrow
/*    */     //   31: aload_0
/*    */     //   32: getstatic org/spongepowered/asm/mixin/injection/invoke/util/InsnFinder$AnalyzerState.ANALYSE : Lorg/spongepowered/asm/mixin/injection/invoke/util/InsnFinder$AnalyzerState;
/*    */     //   35: putfield state : Lorg/spongepowered/asm/mixin/injection/invoke/util/InsnFinder$AnalyzerState;
/*    */     //   38: aload_0
/*    */     //   39: dup
/*    */     //   40: getfield depth : I
/*    */     //   43: iconst_1
/*    */     //   44: iadd
/*    */     //   45: putfield depth : I
/*    */     //   48: goto -> 82
/*    */     //   51: invokestatic b : (Ljava/lang/IndexOutOfBoundsException;)Ljava/lang/IndexOutOfBoundsException;
/*    */     //   54: athrow
/*    */     //   55: aload_0
/*    */     //   56: getfield state : Lorg/spongepowered/asm/mixin/injection/invoke/util/InsnFinder$AnalyzerState;
/*    */     //   59: getstatic org/spongepowered/asm/mixin/injection/invoke/util/InsnFinder$AnalyzerState.ANALYSE : Lorg/spongepowered/asm/mixin/injection/invoke/util/InsnFinder$AnalyzerState;
/*    */     //   62: if_acmpne -> 82
/*    */     //   65: aload_0
/*    */     //   66: dup
/*    */     //   67: getfield depth : I
/*    */     //   70: iconst_1
/*    */     //   71: iadd
/*    */     //   72: putfield depth : I
/*    */     //   75: goto -> 82
/*    */     //   78: invokestatic b : (Ljava/lang/IndexOutOfBoundsException;)Ljava/lang/IndexOutOfBoundsException;
/*    */     //   81: athrow
/*    */     //   82: aload_0
/*    */     //   83: aload_1
/*    */     //   84: invokespecial push : (Lorg/spongepowered/asm/lib/tree/analysis/Value;)V
/*    */     //   87: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #5	-> 0
/*    */     //   #10	-> 31
/*    */     //   #17	-> 38
/*    */     //   #7	-> 55
/*    */     //   #16	-> 65
/*    */     //   #2	-> 82
/*    */     //   #13	-> 87
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   0	24	27	java/lang/IndexOutOfBoundsException
/*    */     //   14	51	51	java/lang/IndexOutOfBoundsException
/*    */     //   55	75	78	java/lang/IndexOutOfBoundsException
/*    */   }
/*    */   
/*    */   public void execute(AbstractInsnNode paramAbstractInsnNode, Interpreter<BasicValue> paramInterpreter) throws AnalyzerException {
/*    */     this.current = paramAbstractInsnNode;
/*    */     super.execute(paramAbstractInsnNode, paramInterpreter);
/*    */   }
/*    */   
/*    */   private int depth = 0;
/*    */   final InsnFinder$PopAnalyzer this$0;
/*    */   
/*    */   public InsnFinder$PopAnalyzer$PopFrame(int paramInt1, int paramInt2) {
/*    */     super(paramInt1, paramInt2);
/*    */     this.depth = 0;
/*    */   }
/*    */   
/*    */   private static IndexOutOfBoundsException b(IndexOutOfBoundsException paramIndexOutOfBoundsException) {
/*    */     return paramIndexOutOfBoundsException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\invok\\util\InsnFinder$PopAnalyzer$PopFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */