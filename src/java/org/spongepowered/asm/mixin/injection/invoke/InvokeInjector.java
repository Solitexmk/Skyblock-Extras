/*    */ package org.spongepowered.asm.mixin.injection.invoke;public abstract class InvokeInjector extends Injector { protected final String annotationType;
/*    */   
/*    */   protected void checkTarget(Target paramTarget) {
/*  4 */     checkTargetModifiers(paramTarget, true);
/*    */   }
/*    */   
/*    */   public InvokeInjector(InjectionInfo paramInjectionInfo, String paramString) {
/*  8 */     super(paramInjectionInfo);
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
/* 20 */     this.annotationType = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void inject(Target paramTarget, InjectionNodes.InjectionNode paramInjectionNode)
/*    */   {
/*    */     try {
/*    */       if (!(paramInjectionNode.getCurrentTarget() instanceof org.spongepowered.asm.lib.tree.MethodInsnNode)) {
/*    */         throw new InvalidInjectionException(this.info, this.annotationType + " annotation on is targetting a non-method insn in " + paramTarget + " in " + this);
/*    */       }
/*    */     } catch (InvalidInjectionException invalidInjectionException) {
/*    */       throw c(null);
/*    */     } 
/* 33 */     injectAtInvoke(paramTarget, paramInjectionNode); } protected final void checkTargetModifiers(Target paramTarget, boolean paramBoolean) { try { if (paramBoolean) try { if (paramTarget.isStatic != this.isStatic) throw new InvalidInjectionException(this.info, "'static' modifier of handler method does not match target in " + this);  } catch (InvalidInjectionException invalidInjectionException) { throw c(null); }   } catch (InvalidInjectionException invalidInjectionException) { throw c(null); }  try { if (!paramBoolean) try { if (!this.isStatic) try { if (paramTarget.isStatic)
/* 34 */                 throw new InvalidInjectionException(this.info, "non-static callback method " + this + " targets a static method which is not supported");  } catch (InvalidInjectionException invalidInjectionException) { throw c(null); }   } catch (InvalidInjectionException invalidInjectionException) { throw c(null); }   } catch (InvalidInjectionException invalidInjectionException) { throw c(null); }  }
/*    */   protected int[] storeArgs(Target paramTarget, Type[] paramArrayOfType, InsnList paramInsnList, int paramInt) { int[] arrayOfInt = paramTarget.generateArgMap(paramArrayOfType, paramInt); storeArgs(paramArrayOfType, paramInsnList, arrayOfInt, paramInt, paramArrayOfType.length); return arrayOfInt; }
/*    */   protected AbstractInsnNode invokeHandlerWithArgs(Type[] paramArrayOfType, InsnList paramInsnList, int[] paramArrayOfint, int paramInt1, int paramInt2) { try { if (!this.isStatic)
/*    */         paramInsnList.add((AbstractInsnNode)new VarInsnNode(25, 0));  }
/*    */     catch (InvalidInjectionException invalidInjectionException) { throw c(null); }
/*    */      pushArgs(paramArrayOfType, paramInsnList, paramArrayOfint, paramInt1, paramInt2); return invokeHandler(paramInsnList); } protected void storeArgs(Type[] paramArrayOfType, InsnList paramInsnList, int[] paramArrayOfint, int paramInt1, int paramInt2) { int i = paramInt2 - 1; try { for (; i >= paramInt1; i--)
/* 40 */         paramInsnList.add((AbstractInsnNode)new VarInsnNode(paramArrayOfType[i].getOpcode(54), paramArrayOfint[i]));  } catch (InvalidInjectionException invalidInjectionException) { throw c(null); }  }
/*    */   protected void checkTargetForNode(Target paramTarget, InjectionNodes.InjectionNode paramInjectionNode) { // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: getfield isCtor : Z
/*    */     //   4: ifeq -> 98
/*    */     //   7: aload_1
/*    */     //   8: invokevirtual findSuperInitNode : ()Lorg/spongepowered/asm/lib/tree/MethodInsnNode;
/*    */     //   11: astore_3
/*    */     //   12: aload_1
/*    */     //   13: aload_3
/*    */     //   14: invokevirtual indexOf : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;)I
/*    */     //   17: istore #4
/*    */     //   19: aload_1
/*    */     //   20: aload_2
/*    */     //   21: invokevirtual getCurrentTarget : ()Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;
/*    */     //   24: invokevirtual indexOf : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;)I
/*    */     //   27: istore #5
/*    */     //   29: iload #5
/*    */     //   31: iload #4
/*    */     //   33: if_icmpgt -> 98
/*    */     //   36: aload_0
/*    */     //   37: getfield isStatic : Z
/*    */     //   40: ifne -> 97
/*    */     //   43: goto -> 50
/*    */     //   46: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*    */     //   49: athrow
/*    */     //   50: new org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*    */     //   53: dup
/*    */     //   54: aload_0
/*    */     //   55: getfield info : Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;
/*    */     //   58: new java/lang/StringBuilder
/*    */     //   61: dup
/*    */     //   62: invokespecial <init> : ()V
/*    */     //   65: ldc 'Pre-super '
/*    */     //   67: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   70: aload_0
/*    */     //   71: getfield annotationType : Ljava/lang/String;
/*    */     //   74: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   77: ldc ' invocation must be static in '
/*    */     //   79: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   82: aload_0
/*    */     //   83: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */     //   86: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   89: invokespecial <init> : (Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;Ljava/lang/String;)V
/*    */     //   92: athrow
/*    */     //   93: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*    */     //   96: athrow
/*    */     //   97: return
/*    */     //   98: aload_0
/*    */     //   99: aload_1
/*    */     //   100: iconst_1
/*    */     //   101: invokevirtual checkTargetModifiers : (Lorg/spongepowered/asm/mixin/injection/struct/Target;Z)V
/*    */     //   104: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #31	-> 0
/*    */     //   #11	-> 7
/*    */     //   #43	-> 12
/*    */     //   #35	-> 19
/*    */     //   #12	-> 29
/*    */     //   #32	-> 36
/*    */     //   #13	-> 50
/*    */     //   #39	-> 97
/*    */     //   #18	-> 98
/*    */     //   #24	-> 104
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   29	43	46	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/* 41 */     //   36	93	93	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException } protected AbstractInsnNode invokeHandlerWithArgs(Type[] paramArrayOfType, InsnList paramInsnList, int[] paramArrayOfint) { return invokeHandlerWithArgs(paramArrayOfType, paramInsnList, paramArrayOfint, 0, paramArrayOfType.length); } protected void pushArgs(Type[] paramArrayOfType, InsnList paramInsnList, int[] paramArrayOfint, int paramInt1, int paramInt2) { int i = paramInt1; try { while (i < paramInt2) { paramInsnList.add((AbstractInsnNode)new VarInsnNode(paramArrayOfType[i].getOpcode(21), paramArrayOfint[i])); i++; }  } catch (InvalidInjectionException invalidInjectionException) { throw c(null); }
/* 42 */      } protected void sanityCheck(Target paramTarget, List<InjectionPoint> paramList) { super.sanityCheck(paramTarget, paramList);
/*    */     checkTarget(paramTarget); }
/*    */ 
/*    */   
/*    */   protected abstract void injectAtInvoke(Target paramTarget, InjectionNodes.InjectionNode paramInjectionNode);
/*    */   
/*    */   private static InvalidInjectionException c(InvalidInjectionException paramInvalidInjectionException) {
/*    */     return paramInvalidInjectionException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\invoke\InvokeInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */