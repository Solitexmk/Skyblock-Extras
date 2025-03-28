/*    */ package org.spongepowered.asm.mixin.injection;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import org.spongepowered.asm.lib.tree.AbstractInsnNode;
/*    */ import org.spongepowered.asm.lib.tree.InsnList;
/*    */ 
/*    */ 
/*    */ 
/*    */ final class InjectionPoint$Shift
/*    */   extends InjectionPoint
/*    */ {
/*    */   private final InjectionPoint input;
/*    */   private final int shift;
/*    */   
/*    */   public InjectionPoint$Shift(InjectionPoint paramInjectionPoint, int paramInt) {
/* 16 */     if (paramInjectionPoint == null)
/*    */       throw new IllegalArgumentException("Must supply an input injection point for SHIFT"); 
/*    */     this.input = paramInjectionPoint;
/*    */     this.shift = paramInt;
/*    */   }
/*    */   
/*    */   public String toString() {
/*    */     return "InjectionPoint(" + getClass().getSimpleName() + ")[" + this.input + "]";
/*    */   }
/*    */   
/*    */   public boolean find(String paramString, InsnList paramInsnList, Collection<AbstractInsnNode> paramCollection) {
/*    */     // Byte code:
/*    */     //   0: aload_3
/*    */     //   1: instanceof java/util/List
/*    */     //   4: ifeq -> 18
/*    */     //   7: aload_3
/*    */     //   8: checkcast java/util/List
/*    */     //   11: goto -> 26
/*    */     //   14: invokestatic b : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
/*    */     //   17: athrow
/*    */     //   18: new java/util/ArrayList
/*    */     //   21: dup
/*    */     //   22: aload_3
/*    */     //   23: invokespecial <init> : (Ljava/util/Collection;)V
/*    */     //   26: astore #4
/*    */     //   28: aload_0
/*    */     //   29: getfield input : Lorg/spongepowered/asm/mixin/injection/InjectionPoint;
/*    */     //   32: aload_1
/*    */     //   33: aload_2
/*    */     //   34: aload_3
/*    */     //   35: invokevirtual find : (Ljava/lang/String;Lorg/spongepowered/asm/lib/tree/InsnList;Ljava/util/Collection;)Z
/*    */     //   38: pop
/*    */     //   39: iconst_0
/*    */     //   40: istore #5
/*    */     //   42: iload #5
/*    */     //   44: aload #4
/*    */     //   46: invokeinterface size : ()I
/*    */     //   51: if_icmpge -> 99
/*    */     //   54: aload #4
/*    */     //   56: iload #5
/*    */     //   58: aload_2
/*    */     //   59: aload_2
/*    */     //   60: aload #4
/*    */     //   62: iload #5
/*    */     //   64: invokeinterface get : (I)Ljava/lang/Object;
/*    */     //   69: checkcast org/spongepowered/asm/lib/tree/AbstractInsnNode
/*    */     //   72: invokevirtual indexOf : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;)I
/*    */     //   75: aload_0
/*    */     //   76: getfield shift : I
/*    */     //   79: iadd
/*    */     //   80: invokevirtual get : (I)Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;
/*    */     //   83: invokeinterface set : (ILjava/lang/Object;)Ljava/lang/Object;
/*    */     //   88: pop
/*    */     //   89: iinc #5, 1
/*    */     //   92: goto -> 42
/*    */     //   95: invokestatic b : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
/*    */     //   98: athrow
/*    */     //   99: aload_3
/*    */     //   100: aload #4
/*    */     //   102: if_acmpeq -> 127
/*    */     //   105: aload_3
/*    */     //   106: invokeinterface clear : ()V
/*    */     //   111: aload_3
/*    */     //   112: aload #4
/*    */     //   114: invokeinterface addAll : (Ljava/util/Collection;)Z
/*    */     //   119: pop
/*    */     //   120: goto -> 127
/*    */     //   123: invokestatic b : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
/*    */     //   126: athrow
/*    */     //   127: aload_3
/*    */     //   128: invokeinterface size : ()I
/*    */     //   133: ifle -> 144
/*    */     //   136: iconst_1
/*    */     //   137: goto -> 145
/*    */     //   140: invokestatic b : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
/*    */     //   143: athrow
/*    */     //   144: iconst_0
/*    */     //   145: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     //   #9	-> 28
/*    */     //   #10	-> 39
/*    */     //   #11	-> 54
/*    */     //   #3	-> 89
/*    */     //   #7	-> 99
/*    */     //   #6	-> 105
/*    */     //   #2	-> 111
/*    */     //   #15	-> 127
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   0	14	14	java/lang/IllegalArgumentException
/*    */     //   42	95	95	java/lang/IllegalArgumentException
/*    */     //   99	120	123	java/lang/IllegalArgumentException
/*    */     //   127	140	140	java/lang/IllegalArgumentException
/*    */   }
/*    */   
/*    */   private static IllegalArgumentException b(IllegalArgumentException paramIllegalArgumentException) {
/*    */     return paramIllegalArgumentException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\InjectionPoint$Shift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */