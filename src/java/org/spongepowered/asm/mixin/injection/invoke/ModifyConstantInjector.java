/*    */ package org.spongepowered.asm.mixin.injection.invoke;
/*    */ 
/*    */ import org.apache.logging.log4j.Level;
/*    */ import org.spongepowered.asm.lib.Type;
/*    */ import org.spongepowered.asm.lib.tree.AbstractInsnNode;
/*    */ import org.spongepowered.asm.lib.tree.FieldInsnNode;
/*    */ import org.spongepowered.asm.lib.tree.InsnList;
/*    */ import org.spongepowered.asm.lib.tree.InsnNode;
/*    */ import org.spongepowered.asm.lib.tree.JumpInsnNode;
/*    */ import org.spongepowered.asm.lib.tree.VarInsnNode;
/*    */ import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
/*    */ import org.spongepowered.asm.mixin.injection.struct.InjectionNodes;
/*    */ import org.spongepowered.asm.mixin.injection.struct.Target;
/*    */ import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;
/*    */ import org.spongepowered.asm.util.Bytecode;
/*    */ import org.spongepowered.asm.util.Locals;
/*    */ import org.spongepowered.asm.util.SignaturePrinter;
/*    */ 
/*    */ public class ModifyConstantInjector extends RedirectInjector {
/*    */   private static final int OPCODE_OFFSET = 6;
/*    */   
/* 22 */   private void checkNarrowing(Target paramTarget, AbstractInsnNode paramAbstractInsnNode, Type paramType1, Type paramType2, int paramInt, String paramString) { int i = paramType1.getSort();
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
/* 40 */     int j = paramType2.getSort();
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 45 */     if (j < i)
/*    */     { String str1 = SignaturePrinter.getTypeName(paramType1, false);
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
/*    */       String str2 = SignaturePrinter.getTypeName(paramType2, false);
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
/*    */       try {  }
/*    */       catch (UnsupportedOperationException unsupportedOperationException)
/* 77 */       { throw b(null); }  String str3 = (j == 1) ? ". Implicit conversion to <boolean> can cause nondeterministic (JVM-specific) behaviour!" : ""; try {  } catch (UnsupportedOperationException unsupportedOperationException) { throw b(null); }  Level level = (j == 1) ? Level.ERROR : Level.WARN; (new Object[7])[0] = str1; (new Object[7])[1] = str2; (new Object[7])[2] = this.info; (new Object[7])[3] = paramTarget; }  } private void injectConstantModifier(Target paramTarget, AbstractInsnNode paramAbstractInsnNode) { Type type = Bytecode.getConstantType(paramAbstractInsnNode); try { if (type.getSort() <= 5) try { if (this.info.getContext().getOption(MixinEnvironment.Option.DEBUG_VERBOSE))
/* 78 */             checkNarrowing(paramTarget, paramAbstractInsnNode, type);  } catch (UnsupportedOperationException unsupportedOperationException) { throw b(null); }   } catch (UnsupportedOperationException unsupportedOperationException) { throw b(null); }  InsnList insnList1 = new InsnList(); InsnList insnList2 = new InsnList(); AbstractInsnNode abstractInsnNode = invokeConstantHandler(type, paramTarget, insnList1, insnList2); paramTarget.wrapNode(paramAbstractInsnNode, abstractInsnNode, insnList1, insnList2); }
/*    */ 
/*    */   
/*    */   protected void inject(Target paramTarget, InjectionNodes.InjectionNode paramInjectionNode) {
/*    */     try {
/*    */       if (!preInject(paramInjectionNode))
/*    */         return; 
/*    */     } catch (UnsupportedOperationException unsupportedOperationException) {
/*    */       throw b(null);
/*    */     } 
/*    */     try {
/*    */       if (paramInjectionNode.isReplaced())
/*    */         throw new UnsupportedOperationException("Target failure for " + this.info); 
/*    */     } catch (UnsupportedOperationException unsupportedOperationException) {
/*    */       throw b(null);
/*    */     } 
/*    */     AbstractInsnNode abstractInsnNode = paramInjectionNode.getCurrentTarget();
/*    */     try {
/*    */       if (abstractInsnNode instanceof JumpInsnNode) {
/*    */         checkTargetModifiers(paramTarget, false);
/*    */         injectExpandedConstantModifier(paramTarget, (JumpInsnNode)abstractInsnNode);
/*    */         return;
/*    */       } 
/*    */     } catch (UnsupportedOperationException unsupportedOperationException) {
/*    */       throw b(null);
/*    */     } 
/*    */     try {
/*    */       if (Bytecode.isConstant(abstractInsnNode)) {
/*    */         checkTargetModifiers(paramTarget, false);
/*    */         injectConstantModifier(paramTarget, abstractInsnNode);
/*    */         return;
/*    */       } 
/*    */     } catch (UnsupportedOperationException unsupportedOperationException) {
/*    */       throw b(null);
/*    */     } 
/*    */     throw new InvalidInjectionException(this.info, this.annotationType + " annotation is targetting an invalid insn in " + paramTarget + " in " + this);
/*    */   }
/*    */   
/*    */   private void checkNarrowing(Target paramTarget, AbstractInsnNode paramAbstractInsnNode, Type paramType) {
/*    */     AbstractInsnNode abstractInsnNode = (new InsnFinder()).findPopInsn(paramTarget, paramAbstractInsnNode);
/*    */     try {
/*    */       if (abstractInsnNode == null)
/*    */         return; 
/*    */     } catch (UnsupportedOperationException unsupportedOperationException) {
/*    */       throw b(null);
/*    */     } 
/*    */     if (abstractInsnNode instanceof FieldInsnNode) {
/*    */       FieldInsnNode fieldInsnNode = (FieldInsnNode)abstractInsnNode;
/*    */       Type type = Type.getType(fieldInsnNode.desc);
/*    */       checkNarrowing(paramTarget, paramAbstractInsnNode, paramType, type, paramTarget.indexOf(abstractInsnNode), String.format("%s %s %s.%s", new Object[] { Bytecode.getOpcodeName(abstractInsnNode), SignaturePrinter.getTypeName(type, false), fieldInsnNode.owner.replace('/', '.'), fieldInsnNode.name }));
/*    */     } 
/*    */     try {
/*    */       if (abstractInsnNode.getOpcode() == 172) {
/*    */         checkNarrowing(paramTarget, paramAbstractInsnNode, paramType, paramTarget.returnType, paramTarget.indexOf(abstractInsnNode), "RETURN " + SignaturePrinter.getTypeName(paramTarget.returnType, false));
/*    */       } else if (abstractInsnNode.getOpcode() == 54) {
/*    */         int i = ((VarInsnNode)abstractInsnNode).var;
/*    */         LocalVariableNode localVariableNode = Locals.getLocalVariableAt(paramTarget.classNode, paramTarget.method, abstractInsnNode, i);
/*    */       } 
/*    */     } catch (UnsupportedOperationException unsupportedOperationException) {
/*    */       throw b(null);
/*    */     } 
/*    */   }
/*    */   
/*    */   private void injectExpandedConstantModifier(Target paramTarget, JumpInsnNode paramJumpInsnNode) {
/*    */     int i = paramJumpInsnNode.getOpcode();
/*    */     try {
/*    */       if (i >= 155)
/*    */         try {
/*    */           if (i <= 158) {
/*    */             InsnList insnList = new InsnList();
/*    */             insnList.add((AbstractInsnNode)new InsnNode(3));
/*    */             AbstractInsnNode abstractInsnNode = invokeConstantHandler(Type.getType("I"), paramTarget, insnList, insnList);
/*    */             insnList.add((AbstractInsnNode)new JumpInsnNode(i + 6, paramJumpInsnNode.label));
/*    */             paramTarget.replaceNode((AbstractInsnNode)paramJumpInsnNode, abstractInsnNode, insnList);
/*    */             paramTarget.addToStack(1);
/*    */             return;
/*    */           } 
/*    */           throw new InvalidInjectionException(this.info, this.annotationType + " annotation selected an invalid opcode " + Bytecode.getOpcodeName(i) + " in " + paramTarget + " in " + this);
/*    */         } catch (UnsupportedOperationException unsupportedOperationException) {
/*    */           throw b(null);
/*    */         }  
/*    */     } catch (UnsupportedOperationException unsupportedOperationException) {
/*    */       throw b(null);
/*    */     } 
/*    */     throw new InvalidInjectionException(this.info, this.annotationType + " annotation selected an invalid opcode " + Bytecode.getOpcodeName(i) + " in " + paramTarget + " in " + this);
/*    */   }
/*    */   
/*    */   public ModifyConstantInjector(InjectionInfo paramInjectionInfo) {
/*    */     super(paramInjectionInfo, "@ModifyConstant");
/*    */   }
/*    */   
/*    */   private AbstractInsnNode invokeConstantHandler(Type paramType, Target paramTarget, InsnList paramInsnList1, InsnList paramInsnList2) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: iconst_1
/*    */     //   2: anewarray java/lang/Object
/*    */     //   5: dup
/*    */     //   6: iconst_0
/*    */     //   7: aload_1
/*    */     //   8: aastore
/*    */     //   9: invokestatic generateDescriptor : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/String;
/*    */     //   12: astore #5
/*    */     //   14: aload_0
/*    */     //   15: aload #5
/*    */     //   17: aload_2
/*    */     //   18: ldc 'getter'
/*    */     //   20: invokevirtual checkDescriptor : (Ljava/lang/String;Lorg/spongepowered/asm/mixin/injection/struct/Target;Ljava/lang/String;)Z
/*    */     //   23: istore #6
/*    */     //   25: aload_0
/*    */     //   26: getfield isStatic : Z
/*    */     //   29: ifne -> 58
/*    */     //   32: aload_3
/*    */     //   33: new org/spongepowered/asm/lib/tree/VarInsnNode
/*    */     //   36: dup
/*    */     //   37: bipush #25
/*    */     //   39: iconst_0
/*    */     //   40: invokespecial <init> : (II)V
/*    */     //   43: invokevirtual insert : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;)V
/*    */     //   46: aload_2
/*    */     //   47: iconst_1
/*    */     //   48: invokevirtual addToStack : (I)V
/*    */     //   51: goto -> 58
/*    */     //   54: invokestatic b : (Ljava/lang/UnsupportedOperationException;)Ljava/lang/UnsupportedOperationException;
/*    */     //   57: athrow
/*    */     //   58: iload #6
/*    */     //   60: ifeq -> 101
/*    */     //   63: aload_0
/*    */     //   64: aload_2
/*    */     //   65: getfield arguments : [Lorg/spongepowered/asm/lib/Type;
/*    */     //   68: aload #4
/*    */     //   70: aload_2
/*    */     //   71: invokevirtual getArgIndices : ()[I
/*    */     //   74: iconst_0
/*    */     //   75: aload_2
/*    */     //   76: getfield arguments : [Lorg/spongepowered/asm/lib/Type;
/*    */     //   79: arraylength
/*    */     //   80: invokevirtual pushArgs : ([Lorg/spongepowered/asm/lib/Type;Lorg/spongepowered/asm/lib/tree/InsnList;[III)V
/*    */     //   83: aload_2
/*    */     //   84: aload_2
/*    */     //   85: getfield arguments : [Lorg/spongepowered/asm/lib/Type;
/*    */     //   88: invokestatic getArgsSize : ([Lorg/spongepowered/asm/lib/Type;)I
/*    */     //   91: invokevirtual addToStack : (I)V
/*    */     //   94: goto -> 101
/*    */     //   97: invokestatic b : (Ljava/lang/UnsupportedOperationException;)Ljava/lang/UnsupportedOperationException;
/*    */     //   100: athrow
/*    */     //   101: aload_0
/*    */     //   102: aload #4
/*    */     //   104: invokevirtual invokeHandler : (Lorg/spongepowered/asm/lib/tree/InsnList;)Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;
/*    */     //   107: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #75	-> 0
/*    */     //   #28	-> 14
/*    */     //   #54	-> 25
/*    */     //   #47	-> 32
/*    */     //   #33	-> 46
/*    */     //   #16	-> 58
/*    */     //   #61	-> 63
/*    */     //   #70	-> 83
/*    */     //   #18	-> 101
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   25	51	54	java/lang/UnsupportedOperationException
/*    */     //   58	94	97	java/lang/UnsupportedOperationException
/*    */   }
/*    */   
/*    */   private static UnsupportedOperationException b(UnsupportedOperationException paramUnsupportedOperationException) {
/*    */     return paramUnsupportedOperationException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\invoke\ModifyConstantInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */