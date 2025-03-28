/*    */ package org.spongepowered.asm.mixin.injection.code;public abstract class Injector {
/*  2 */   protected static final Logger logger = LogManager.getLogger("mixin"); protected InjectionInfo info; protected final ClassNode classNode;
/*    */   protected final MethodNode methodNode;
/*    */   protected final Type[] methodArgs;
/*    */   protected final Type returnType;
/*    */   protected final boolean isStatic;
/*    */   
/*  8 */   protected boolean findTargetNodes(MethodNode paramMethodNode, InjectionPoint paramInjectionPoint, InsnList paramInsnList, Collection<AbstractInsnNode> paramCollection) { return paramInjectionPoint.find(paramMethodNode.desc, paramInsnList, paramCollection); }
/*  9 */   protected void throwException(InsnList paramInsnList, String paramString1, String paramString2) { paramInsnList.add((AbstractInsnNode)new TypeInsnNode(187, paramString1));
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
/*    */     
/* 73 */     paramInsnList.add((AbstractInsnNode)new InsnNode(89)); paramInsnList.add((AbstractInsnNode)new LdcInsnNode(paramString2)); paramInsnList.add((AbstractInsnNode)new MethodInsnNode(183, paramString1, "<init>", "(Ljava/lang/String;)V", false)); paramInsnList.add((AbstractInsnNode)new InsnNode(191)); }
/*    */   protected AbstractInsnNode invokeHandler(InsnList paramInsnList) { return invokeHandler(paramInsnList, this.methodNode); }
/*    */   public static boolean canCoerce(String paramString1, String paramString2) { try { if (paramString1.length() <= 1) try { if (paramString2.length() <= 1) return canCoerce(paramString1.charAt(0), paramString2.charAt(0));  return false; } catch (InvalidInjectionException invalidInjectionException) { throw b(null); }   } catch (InvalidInjectionException invalidInjectionException) { throw b(null); }  return false; }
/*    */   public final void inject(Target paramTarget, List<InjectionNodes.InjectionNode> paramList) { for (InjectionNodes.InjectionNode injectionNode : paramList) { try { if (injectionNode.isRemoved()) if (this.info.getContext().getOption(MixinEnvironment.Option.DEBUG_VERBOSE)) logger.warn("Target node for {} was removed by a previous injector in {}", new Object[] { this.info, paramTarget });   } catch (InvalidInjectionException invalidInjectionException) { throw b(null); }  }  for (InjectionNodes.InjectionNode injectionNode : paramList) postInject(paramTarget, injectionNode);  }
/*    */   protected AbstractInsnNode invokeHandler(InsnList paramInsnList, MethodNode paramMethodNode) { try {  } catch (InvalidInjectionException invalidInjectionException) { throw b(null); }  boolean bool = ((paramMethodNode.access & 0x2) != 0) ? true : false; try { try {  } catch (InvalidInjectionException invalidInjectionException) { throw b(null); }  } catch (InvalidInjectionException invalidInjectionException) { throw b(null); }  char c = this.isStatic ? '¸' : (bool ? '·' : '¶'); MethodInsnNode methodInsnNode = new MethodInsnNode(c, this.classNode.name, paramMethodNode.name, paramMethodNode.desc, false); paramInsnList.add((AbstractInsnNode)methodInsnNode); this.info.addCallbackInvocation(paramMethodNode); return (AbstractInsnNode)methodInsnNode; } protected void postInject(Target paramTarget, InjectionNodes.InjectionNode paramInjectionNode) {} private Collection<Injector$TargetNode> findTargetNodes(InjectorTarget paramInjectorTarget, List<InjectionPoint> paramList) { IMixinContext iMixinContext = this.info.getContext(); MethodNode methodNode = paramInjectorTarget.getMethod(); TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>(); ArrayList arrayList = new ArrayList(32); for (InjectionPoint injectionPoint : paramList) { try { arrayList.clear(); if (paramInjectorTarget.isMerged()) try { if (!iMixinContext.getClassName().equals(paramInjectorTarget.getMergedBy()))
/*    */               try { if (!injectionPoint.checkPriority(paramInjectorTarget.getMergedPriority(), iMixinContext.getPriority()))
/* 79 */                   throw new InvalidInjectionException(this.info, String.format("%s on %s with priority %d cannot inject into %s merged by %s with priority %d", new Object[] { injectionPoint, this, Integer.valueOf(iMixinContext.getPriority()), paramInjectorTarget, paramInjectorTarget.getMergedBy(), Integer.valueOf(paramInjectorTarget.getMergedPriority()) }));  } catch (InvalidInjectionException invalidInjectionException) { throw b(null); }   } catch (InvalidInjectionException invalidInjectionException) { throw b(null); }   } catch (InvalidInjectionException invalidInjectionException) { throw b(null); }  }  return treeMap.values(); }
/* 80 */   protected void sanityCheck(Target paramTarget, List<InjectionPoint> paramList) { try { if (paramTarget.classNode != this.classNode) throw new InvalidInjectionException(this.info, "Target class does not match injector class in " + this);  } catch (InvalidInjectionException invalidInjectionException) { throw b(null); }  } protected void addTargetNode(Target paramTarget, List<InjectionNodes.InjectionNode> paramList, AbstractInsnNode paramAbstractInsnNode, Set<InjectionPoint> paramSet) { paramList.add(paramTarget.addInjectionNode(paramAbstractInsnNode)); } public final List<InjectionNodes.InjectionNode> find(InjectorTarget paramInjectorTarget, List<InjectionPoint> paramList) { sanityCheck(paramInjectorTarget.getTarget(), paramList); ArrayList<InjectionNodes.InjectionNode> arrayList = new ArrayList(); for (Injector$TargetNode injector$TargetNode : findTargetNodes(paramInjectorTarget, paramList)) addTargetNode(paramInjectorTarget.getTarget(), arrayList, injector$TargetNode.insn, injector$TargetNode.nominators);  return arrayList; } public String toString() { return String.format("%s::%s", new Object[] { this.classNode.name, this.methodNode.name }); } public Injector(InjectionInfo paramInjectionInfo) { this(paramInjectionInfo.getClassNode(), paramInjectionInfo.getMethod()); this.info = paramInjectionInfo; } private Injector(ClassNode paramClassNode, MethodNode paramMethodNode) { this.classNode = paramClassNode;
/*    */     this.methodNode = paramMethodNode;
/*    */     this.methodArgs = Type.getArgumentTypes(this.methodNode.desc);
/*    */     this.returnType = Type.getReturnType(this.methodNode.desc);
/*    */     this.isStatic = Bytecode.methodIsStatic(this.methodNode); }
/*    */ 
/*    */   
/*    */   private static boolean canCoerce(ClassInfo paramClassInfo1, ClassInfo paramClassInfo2) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: ifnull -> 50
/*    */     //   4: aload_1
/*    */     //   5: ifnull -> 50
/*    */     //   8: goto -> 15
/*    */     //   11: invokestatic b : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*    */     //   14: athrow
/*    */     //   15: aload_1
/*    */     //   16: aload_0
/*    */     //   17: if_acmpeq -> 42
/*    */     //   20: goto -> 27
/*    */     //   23: invokestatic b : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*    */     //   26: athrow
/*    */     //   27: aload_1
/*    */     //   28: aload_0
/*    */     //   29: invokevirtual hasSuperClass : (Lorg/spongepowered/asm/mixin/transformer/ClassInfo;)Z
/*    */     //   32: ifeq -> 50
/*    */     //   35: goto -> 42
/*    */     //   38: invokestatic b : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*    */     //   41: athrow
/*    */     //   42: iconst_1
/*    */     //   43: goto -> 51
/*    */     //   46: invokestatic b : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*    */     //   49: athrow
/*    */     //   50: iconst_0
/*    */     //   51: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #75	-> 0
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   0	8	11	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*    */     //   4	20	23	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*    */     //   15	35	38	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*    */     //   27	46	46	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*    */   }
/*    */   
/*    */   public static boolean canCoerce(Type paramType1, Type paramType2) {
/*    */     try {
/*    */       if (paramType1.getSort() == 10)
/*    */         try {
/*    */           if (paramType2.getSort() == 10)
/*    */             return canCoerce(ClassInfo.forType(paramType1), ClassInfo.forType(paramType2)); 
/*    */         } catch (InvalidInjectionException invalidInjectionException) {
/*    */           throw b(null);
/*    */         }  
/*    */     } catch (InvalidInjectionException invalidInjectionException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return canCoerce(paramType1.getDescriptor(), paramType2.getDescriptor());
/*    */   }
/*    */   
/*    */   public static boolean canCoerce(char paramChar1, char paramChar2) {
/*    */     try {
/*    */       if (paramChar2 == 'I')
/*    */         try {
/*    */           if ("IBSCZ".indexOf(paramChar1) > -1);
/*    */         } catch (InvalidInjectionException invalidInjectionException) {
/*    */           throw b(null);
/*    */         }  
/*    */     } catch (InvalidInjectionException invalidInjectionException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return false;
/*    */   }
/*    */   
/*    */   protected abstract void inject(Target paramTarget, InjectionNodes.InjectionNode paramInjectionNode);
/*    */   
/*    */   private static InvalidInjectionException b(InvalidInjectionException paramInvalidInjectionException) {
/*    */     return paramInvalidInjectionException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\code\Injector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */