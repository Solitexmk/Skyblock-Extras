/*    */ package org.spongepowered.asm.mixin.injection.invoke;
/*    */ 
/*    */ import org.spongepowered.asm.lib.Type;
/*    */ import org.spongepowered.asm.lib.tree.InsnList;
/*    */ import org.spongepowered.asm.mixin.injection.struct.Target;
/*    */ 
/*    */ public class ModifyArgInjector extends InvokeInjector {
/*    */   private final int index;
/*    */   private final boolean singleArgMode;
/*    */   
/*    */   protected void checkTarget(Target paramTarget) { 
/* 12 */     try { if (!this.isStatic) try { if (paramTarget.isStatic)
/*    */           {
/*    */ 
/*    */ 
/*    */             
/* 17 */             throw new InvalidInjectionException(this.info, "non-static callback method " + this + " targets a static method which is not supported"); }  } catch (InvalidInjectionException invalidInjectionException) { throw d(null); }
/*    */           }
/*    */     catch (InvalidInjectionException invalidInjectionException) { throw d(null); }
/* 20 */      } protected void inject(Target paramTarget, InjectionNodes.InjectionNode paramInjectionNode) { checkTargetForNode(paramTarget, paramInjectionNode);
/*    */     super.inject(paramTarget, paramInjectionNode); }
/*    */   protected int findArgIndex(Target paramTarget, Type[] paramArrayOfType) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield index : I
/*    */     //   4: iconst_m1
/*    */     //   5: if_icmple -> 123
/*    */     //   8: aload_0
/*    */     //   9: getfield index : I
/*    */     //   12: aload_2
/*    */     //   13: arraylength
/*    */     //   14: if_icmpge -> 47
/*    */     //   17: goto -> 24
/*    */     //   20: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*    */     //   23: athrow
/*    */     //   24: aload_2
/*    */     //   25: aload_0
/*    */     //   26: getfield index : I
/*    */     //   29: aaload
/*    */     //   30: aload_0
/*    */     //   31: getfield returnType : Lorg/spongepowered/asm/lib/Type;
/*    */     //   34: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   37: ifne -> 118
/*    */     //   40: goto -> 47
/*    */     //   43: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*    */     //   46: athrow
/*    */     //   47: new org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*    */     //   50: dup
/*    */     //   51: aload_0
/*    */     //   52: getfield info : Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;
/*    */     //   55: new java/lang/StringBuilder
/*    */     //   58: dup
/*    */     //   59: invokespecial <init> : ()V
/*    */     //   62: ldc 'Specified index '
/*    */     //   64: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   67: aload_0
/*    */     //   68: getfield index : I
/*    */     //   71: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*    */     //   74: ldc ' for @ModifyArg is invalid for args '
/*    */     //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   79: aload_2
/*    */     //   80: invokestatic getDescriptor : ([Lorg/spongepowered/asm/lib/Type;)Ljava/lang/String;
/*    */     //   83: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   86: ldc ', expected '
/*    */     //   88: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   91: aload_0
/*    */     //   92: getfield returnType : Lorg/spongepowered/asm/lib/Type;
/*    */     //   95: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */     //   98: ldc ' on '
/*    */     //   100: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   103: aload_0
/*    */     //   104: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */     //   107: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   110: invokespecial <init> : (Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;Ljava/lang/String;)V
/*    */     //   113: athrow
/*    */     //   114: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*    */     //   117: athrow
/*    */     //   118: aload_0
/*    */     //   119: getfield index : I
/*    */     //   122: ireturn
/*    */     //   123: iconst_m1
/*    */     //   124: istore_3
/*    */     //   125: iconst_0
/*    */     //   126: istore #4
/*    */     //   128: iload #4
/*    */     //   130: aload_2
/*    */     //   131: arraylength
/*    */     //   132: if_icmpge -> 257
/*    */     //   135: aload_2
/*    */     //   136: iload #4
/*    */     //   138: aaload
/*    */     //   139: aload_0
/*    */     //   140: getfield returnType : Lorg/spongepowered/asm/lib/Type;
/*    */     //   143: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   146: ifne -> 163
/*    */     //   149: goto -> 156
/*    */     //   152: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*    */     //   155: athrow
/*    */     //   156: goto -> 251
/*    */     //   159: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*    */     //   162: athrow
/*    */     //   163: iload_3
/*    */     //   164: iconst_m1
/*    */     //   165: if_icmpeq -> 248
/*    */     //   168: new org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*    */     //   171: dup
/*    */     //   172: aload_0
/*    */     //   173: getfield info : Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;
/*    */     //   176: new java/lang/StringBuilder
/*    */     //   179: dup
/*    */     //   180: invokespecial <init> : ()V
/*    */     //   183: ldc 'Found duplicate args with index ['
/*    */     //   185: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   188: iload_3
/*    */     //   189: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*    */     //   192: ldc ', '
/*    */     //   194: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   197: iload #4
/*    */     //   199: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*    */     //   202: ldc '] matching type '
/*    */     //   204: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   207: aload_0
/*    */     //   208: getfield returnType : Lorg/spongepowered/asm/lib/Type;
/*    */     //   211: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */     //   214: ldc ' for @ModifyArg target '
/*    */     //   216: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   219: aload_1
/*    */     //   220: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */     //   223: ldc ' in '
/*    */     //   225: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   228: aload_0
/*    */     //   229: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */     //   232: ldc '. Please specify index of desired arg.'
/*    */     //   234: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   237: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   240: invokespecial <init> : (Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;Ljava/lang/String;)V
/*    */     //   243: athrow
/*    */     //   244: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*    */     //   247: athrow
/*    */     //   248: iload #4
/*    */     //   250: istore_3
/*    */     //   251: iinc #4, 1
/*    */     //   254: goto -> 128
/*    */     //   257: iload_3
/*    */     //   258: iconst_m1
/*    */     //   259: if_icmpne -> 318
/*    */     //   262: new org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*    */     //   265: dup
/*    */     //   266: aload_0
/*    */     //   267: getfield info : Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;
/*    */     //   270: new java/lang/StringBuilder
/*    */     //   273: dup
/*    */     //   274: invokespecial <init> : ()V
/*    */     //   277: ldc 'Could not find arg matching type '
/*    */     //   279: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   282: aload_0
/*    */     //   283: getfield returnType : Lorg/spongepowered/asm/lib/Type;
/*    */     //   286: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */     //   289: ldc ' for @ModifyArg target '
/*    */     //   291: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   294: aload_1
/*    */     //   295: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */     //   298: ldc ' in '
/*    */     //   300: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   303: aload_0
/*    */     //   304: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */     //   307: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   310: invokespecial <init> : (Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;Ljava/lang/String;)V
/*    */     //   313: athrow
/*    */     //   314: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*    */     //   317: athrow
/*    */     //   318: iload_3
/*    */     //   319: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #24	-> 0
/*    */     //   #3	-> 8
/*    */     //   #28	-> 47
/*    */     //   #48	-> 80
/*    */     //   #29	-> 118
/*    */     //   #6	-> 123
/*    */     //   #8	-> 125
/*    */     //   #13	-> 135
/*    */     //   #16	-> 156
/*    */     //   #14	-> 163
/*    */     //   #10	-> 168
/*    */     //   #22	-> 248
/*    */     //   #46	-> 251
/*    */     //   #7	-> 257
/*    */     //   #11	-> 262
/*    */     //   #33	-> 318
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   0	17	20	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*    */     //   8	40	43	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*    */     //   24	114	114	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*    */     //   128	149	152	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*    */     //   135	159	159	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*    */     //   163	244	244	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*    */     //   257	314	314	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException } private int injectMultiArgHandler(Target paramTarget, Type[] paramArrayOfType, int paramInt, InsnList paramInsnList) { try {
/* 23 */       if (!Arrays.equals((Object[])paramArrayOfType, (Object[])this.methodArgs))
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
/* 36 */         throw new InvalidInjectionException(this.info, "@ModifyArg method " + this + " targets a method with an invalid signature " + Bytecode.getDescriptor(paramArrayOfType) + ", expected " + Bytecode.getDescriptor(this.methodArgs));
/*    */       }
/*    */     } catch (InvalidInjectionException invalidInjectionException) {
/*    */       throw d(null);
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 50 */     int[] arrayOfInt = storeArgs(paramTarget, paramArrayOfType, paramInsnList, 0); pushArgs(paramArrayOfType, paramInsnList, arrayOfInt, 0, paramInt); invokeHandlerWithArgs(paramArrayOfType, paramInsnList, arrayOfInt, 0, paramArrayOfType.length); pushArgs(paramArrayOfType, paramInsnList, arrayOfInt, paramInt + 1, paramArrayOfType.length);
/*    */     return arrayOfInt[arrayOfInt.length - 1] - paramTarget.getMaxLocals() + paramArrayOfType[paramArrayOfType.length - 1].getSize(); } private int injectSingleArgHandler(Target paramTarget, Type[] paramArrayOfType, int paramInt, InsnList paramInsnList) { int[] arrayOfInt = storeArgs(paramTarget, paramArrayOfType, paramInsnList, paramInt);
/* 52 */     invokeHandlerWithArgs(paramArrayOfType, paramInsnList, arrayOfInt, paramInt, paramInt + 1); pushArgs(paramArrayOfType, paramInsnList, arrayOfInt, paramInt + 1, paramArrayOfType.length); return arrayOfInt[arrayOfInt.length - 1] - paramTarget.getMaxLocals() + paramArrayOfType[paramArrayOfType.length - 1].getSize(); } protected void injectAtInvoke(Target paramTarget, InjectionNodes.InjectionNode paramInjectionNode) { MethodInsnNode methodInsnNode = (MethodInsnNode)paramInjectionNode.getCurrentTarget(); Type[] arrayOfType = Type.getArgumentTypes(methodInsnNode.desc); int i = findArgIndex(paramTarget, arrayOfType);
/* 53 */     InsnList insnList = new InsnList();
/* 54 */     int j = 0; if (this.singleArgMode) { j = injectSingleArgHandler(paramTarget, arrayOfType, i, insnList); } else { j = injectMultiArgHandler(paramTarget, arrayOfType, i, insnList); }
/* 55 */      paramTarget.insns.insertBefore((AbstractInsnNode)methodInsnNode, insnList); paramTarget.addToLocals(j); paramTarget.addToStack(2 - j - 1); }
/*    */ 
/*    */   
/*    */   public ModifyArgInjector(InjectionInfo paramInjectionInfo, int paramInt) {
/*    */     super(paramInjectionInfo, "@ModifyArg");
/*    */     this.index = paramInt;
/*    */     this.singleArgMode = (this.methodArgs.length == 1);
/*    */   }
/*    */   
/*    */   protected void sanityCheck(Target paramTarget, List<InjectionPoint> paramList) {
/*    */     try {
/*    */       super.sanityCheck(paramTarget, paramList);
/*    */       if (this.singleArgMode)
/*    */         try {
/*    */           if (!this.methodArgs[0].equals(this.returnType))
/*    */             throw new InvalidInjectionException(this.info, "@ModifyArg return type on " + this + " must match the parameter type. ARG=" + this.methodArgs[0] + " RETURN=" + this.returnType); 
/*    */         } catch (InvalidInjectionException invalidInjectionException) {
/*    */           throw d(null);
/*    */         }  
/*    */     } catch (InvalidInjectionException invalidInjectionException) {
/*    */       throw d(null);
/*    */     } 
/*    */   }
/*    */   
/*    */   private static InvalidInjectionException d(InvalidInjectionException paramInvalidInjectionException) {
/*    */     return paramInvalidInjectionException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\invoke\ModifyArgInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */