/*    */ package org.spongepowered.asm.mixin.injection.invoke;
/*    */ 
/*    */ import org.spongepowered.asm.lib.Type;
/*    */ import org.spongepowered.asm.lib.tree.AbstractInsnNode;
/*    */ import org.spongepowered.asm.lib.tree.InsnList;
/*    */ import org.spongepowered.asm.lib.tree.InsnNode;
/*    */ import org.spongepowered.asm.mixin.injection.struct.Target;
/*    */ import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;
/*    */ 
/*    */ public class ModifyArgsInjector extends InvokeInjector {
/*    */   private final ArgsClassGenerator argsClassGenerator;
/*    */   
/* 13 */   private void unpackArgs(InsnList paramInsnList, String paramString, Type[] paramArrayOfType) { byte b = 0; while (true) { try { if (b < paramArrayOfType.length)
/*    */         
/*    */         { 
/*    */           
/*    */           try { 
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */             
/* 49 */             if (b < paramArrayOfType.length - 1) paramInsnList.add((AbstractInsnNode)new InsnNode(89));  } catch (InvalidInjectionException invalidInjectionException) { throw d(null); }  try { paramInsnList.add((AbstractInsnNode)new MethodInsnNode(182, paramString, "$" + b, "()" + paramArrayOfType[b].getDescriptor(), false)); if (b < paramArrayOfType.length - 1) try { if (paramArrayOfType[b].getSize() == 1) { paramInsnList.add((AbstractInsnNode)new InsnNode(95)); } else { paramInsnList.add((AbstractInsnNode)new InsnNode(93)); paramInsnList.add((AbstractInsnNode)new InsnNode(88)); }  } catch (InvalidInjectionException invalidInjectionException) { throw d(null); }   } catch (InvalidInjectionException invalidInjectionException) { throw d(null); }  b++; continue; }  } catch (InvalidInjectionException invalidInjectionException) { throw d(null); }  break; }  }
/*    */   protected void injectAtInvoke(Target paramTarget, InjectionNodes.InjectionNode paramInjectionNode) { // Byte code:
/*    */     //   0: aload_2
/*    */     //   1: invokevirtual getCurrentTarget : ()Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;
/*    */     //   4: checkcast org/spongepowered/asm/lib/tree/MethodInsnNode
/*    */     //   7: astore_3
/*    */     //   8: aload_3
/*    */     //   9: getfield desc : Ljava/lang/String;
/*    */     //   12: invokestatic getArgumentTypes : (Ljava/lang/String;)[Lorg/spongepowered/asm/lib/Type;
/*    */     //   15: astore #4
/*    */     //   17: aload #4
/*    */     //   19: arraylength
/*    */     //   20: ifne -> 82
/*    */     //   23: new org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*    */     //   26: dup
/*    */     //   27: aload_0
/*    */     //   28: getfield info : Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;
/*    */     //   31: new java/lang/StringBuilder
/*    */     //   34: dup
/*    */     //   35: invokespecial <init> : ()V
/*    */     //   38: ldc '@ModifyArgs injector '
/*    */     //   40: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   43: aload_0
/*    */     //   44: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */     //   47: ldc ' targets a method invocation '
/*    */     //   49: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   52: aload_3
/*    */     //   53: getfield name : Ljava/lang/String;
/*    */     //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   59: aload_3
/*    */     //   60: getfield desc : Ljava/lang/String;
/*    */     //   63: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   66: ldc ' with no arguments!'
/*    */     //   68: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   71: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   74: invokespecial <init> : (Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;Ljava/lang/String;)V
/*    */     //   77: athrow
/*    */     //   78: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*    */     //   81: athrow
/*    */     //   82: aload_0
/*    */     //   83: getfield argsClassGenerator : Lorg/spongepowered/asm/mixin/injection/invoke/arg/ArgsClassGenerator;
/*    */     //   86: aload_3
/*    */     //   87: getfield desc : Ljava/lang/String;
/*    */     //   90: invokevirtual getClassRef : (Ljava/lang/String;)Ljava/lang/String;
/*    */     //   93: astore #5
/*    */     //   95: aload_0
/*    */     //   96: aload_1
/*    */     //   97: invokespecial verifyTarget : (Lorg/spongepowered/asm/mixin/injection/struct/Target;)Z
/*    */     //   100: istore #6
/*    */     //   102: new org/spongepowered/asm/lib/tree/InsnList
/*    */     //   105: dup
/*    */     //   106: invokespecial <init> : ()V
/*    */     //   109: astore #7
/*    */     //   111: aload_1
/*    */     //   112: iconst_1
/*    */     //   113: invokevirtual addToStack : (I)V
/*    */     //   116: aload_0
/*    */     //   117: aload #7
/*    */     //   119: aload #5
/*    */     //   121: aload_3
/*    */     //   122: invokespecial packArgs : (Lorg/spongepowered/asm/lib/tree/InsnList;Ljava/lang/String;Lorg/spongepowered/asm/lib/tree/MethodInsnNode;)V
/*    */     //   125: iload #6
/*    */     //   127: ifeq -> 173
/*    */     //   130: aload_1
/*    */     //   131: aload_1
/*    */     //   132: getfield arguments : [Lorg/spongepowered/asm/lib/Type;
/*    */     //   135: invokestatic getArgsSize : ([Lorg/spongepowered/asm/lib/Type;)I
/*    */     //   138: invokevirtual addToStack : (I)V
/*    */     //   141: aload_1
/*    */     //   142: getfield arguments : [Lorg/spongepowered/asm/lib/Type;
/*    */     //   145: aload #7
/*    */     //   147: aload_1
/*    */     //   148: getfield isStatic : Z
/*    */     //   151: ifeq -> 169
/*    */     //   154: goto -> 161
/*    */     //   157: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*    */     //   160: athrow
/*    */     //   161: iconst_0
/*    */     //   162: goto -> 170
/*    */     //   165: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*    */     //   168: athrow
/*    */     //   169: iconst_1
/*    */     //   170: invokestatic loadArgs : ([Lorg/spongepowered/asm/lib/Type;Lorg/spongepowered/asm/lib/tree/InsnList;I)V
/*    */     //   173: aload_0
/*    */     //   174: aload #7
/*    */     //   176: invokevirtual invokeHandler : (Lorg/spongepowered/asm/lib/tree/InsnList;)Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;
/*    */     //   179: pop
/*    */     //   180: aload_0
/*    */     //   181: aload #7
/*    */     //   183: aload #5
/*    */     //   185: aload #4
/*    */     //   187: invokespecial unpackArgs : (Lorg/spongepowered/asm/lib/tree/InsnList;Ljava/lang/String;[Lorg/spongepowered/asm/lib/Type;)V
/*    */     //   190: aload_1
/*    */     //   191: getfield insns : Lorg/spongepowered/asm/lib/tree/InsnList;
/*    */     //   194: aload_3
/*    */     //   195: aload #7
/*    */     //   197: invokevirtual insertBefore : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;Lorg/spongepowered/asm/lib/tree/InsnList;)V
/*    */     //   200: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #19	-> 0
/*    */     //   #10	-> 8
/*    */     //   #8	-> 17
/*    */     //   #16	-> 23
/*    */     //   #45	-> 82
/*    */     //   #44	-> 95
/*    */     //   #2	-> 102
/*    */     //   #39	-> 111
/*    */     //   #9	-> 116
/*    */     //   #41	-> 125
/*    */     //   #6	-> 130
/*    */     //   #24	-> 141
/*    */     //   #12	-> 173
/*    */     //   #29	-> 180
/*    */     //   #21	-> 190
/*    */     //   #17	-> 200
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   17	78	78	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*    */     //   111	154	157	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/* 50 */     //   130	165	165	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException } private boolean verifyTarget(Target paramTarget) { String str = String.format("(L%s;)V", new Object[] { ArgsClassGenerator.ARGS_REF }); if (!this.methodNode.desc.equals(str)) { String str1 = Bytecode.changeDescriptorReturnType(paramTarget.method.desc, "V"); String str2 = String.format("(L%s;%s", new Object[] { ArgsClassGenerator.ARGS_REF, str1.substring(1) }); try { if (this.methodNode.desc.equals(str2)) return true;  } catch (InvalidInjectionException invalidInjectionException) { throw d(null); }  throw new InvalidInjectionException(this.info, "@ModifyArgs injector " + this + " has an invalid signature " + this.methodNode.desc + ", expected " + str + " or " + str2); }  return false; }
/*    */ 
/*    */   
/*    */   protected void checkTarget(Target paramTarget) {
/*    */     checkTargetModifiers(paramTarget, false);
/*    */   }
/*    */   
/*    */   private void packArgs(InsnList paramInsnList, String paramString, MethodInsnNode paramMethodInsnNode) {
/*    */     String str = Bytecode.changeDescriptorReturnType(paramMethodInsnNode.desc, "L" + paramString + ";");
/*    */     try {
/*    */       paramInsnList.add((AbstractInsnNode)new MethodInsnNode(184, paramString, "of", str, false));
/*    */       paramInsnList.add((AbstractInsnNode)new InsnNode(89));
/*    */       if (!this.isStatic) {
/*    */         paramInsnList.add((AbstractInsnNode)new VarInsnNode(25, 0));
/*    */         paramInsnList.add((AbstractInsnNode)new InsnNode(95));
/*    */       } 
/*    */     } catch (InvalidInjectionException invalidInjectionException) {
/*    */       throw d(null);
/*    */     } 
/*    */   }
/*    */   
/*    */   protected void inject(Target paramTarget, InjectionNodes.InjectionNode paramInjectionNode) {
/*    */     checkTargetForNode(paramTarget, paramInjectionNode);
/*    */     super.inject(paramTarget, paramInjectionNode);
/*    */   }
/*    */   
/*    */   public ModifyArgsInjector(InjectionInfo paramInjectionInfo) {
/*    */     super(paramInjectionInfo, "@ModifyArgs");
/*    */     this.argsClassGenerator = (ArgsClassGenerator)paramInjectionInfo.getContext().getExtensions().getGenerator(ArgsClassGenerator.class);
/*    */   }
/*    */   
/*    */   private static InvalidInjectionException d(InvalidInjectionException paramInvalidInjectionException) {
/*    */     return paramInvalidInjectionException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\invoke\ModifyArgsInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */