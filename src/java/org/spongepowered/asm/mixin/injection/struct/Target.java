/*     */ package org.spongepowered.asm.mixin.injection.struct;public class Target implements Comparable<Target>, Iterable<AbstractInsnNode> { public void replaceNode(AbstractInsnNode paramAbstractInsnNode1, AbstractInsnNode paramAbstractInsnNode2) {
/*   2 */     this.insns.insertBefore(paramAbstractInsnNode1, paramAbstractInsnNode2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  76 */     this.insns.remove(paramAbstractInsnNode1);
/*     */     this.injectionNodes.replace(paramAbstractInsnNode1, paramAbstractInsnNode2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ClassNode classNode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final MethodNode method;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final InsnList insns;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isStatic;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isCtor;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Type[] arguments;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Type returnType;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int maxStack;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int maxLocals;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int allocateArgMapLocal(int paramInt1, int paramInt2) {
/*     */     if (paramInt1 >= this.argMapVars.size())
/* 135 */     { int j = allocateLocals(paramInt2); byte b = 0; try { for (; b < paramInt2; b++)
/*     */           this.argMapVars.add(Integer.valueOf(j + b));  } catch (RuntimeException runtimeException) { throw b(null); }  return j; }  int i = ((Integer)this.argMapVars.get(paramInt1)).intValue(); try { if (paramInt2 > 1 && paramInt1 + paramInt2 > this.argMapVars.size()) { int j = allocateLocals(1); try { if (j == i + 1) { this.argMapVars.add(Integer.valueOf(j)); return i; }  } catch (RuntimeException runtimeException) { throw b(null); }
/* 137 */          this.argMapVars.set(paramInt1, Integer.valueOf(j)); this.argMapVars.add(Integer.valueOf(allocateLocals(1))); return j; }  } catch (RuntimeException runtimeException) { throw b(null); }  return i;
/* 138 */   } public int indexOf(InjectionNodes$InjectionNode paramInjectionNodes$InjectionNode) { return this.insns.indexOf(paramInjectionNodes$InjectionNode.getCurrentTarget()); } public int getMaxStack() { return this.maxStack; } public InjectionNodes$InjectionNode getInjectionNode(AbstractInsnNode paramAbstractInsnNode) { return this.injectionNodes.get(paramAbstractInsnNode); }
/*     */ 
/*     */   
/*     */   public String getCallbackDescriptor(Type[] paramArrayOfType1, Type[] paramArrayOfType2) {
/*     */     return getCallbackDescriptor(false, paramArrayOfType1, paramArrayOfType2, 0, 32767);
/*     */   }
/*     */   
/*     */   public void replaceNode(AbstractInsnNode paramAbstractInsnNode, InsnList paramInsnList) {
/*     */     this.insns.insertBefore(paramAbstractInsnNode, paramInsnList);
/*     */     removeNode(paramAbstractInsnNode);
/*     */   }
/*     */   
/*     */   public void replaceNode(AbstractInsnNode paramAbstractInsnNode1, AbstractInsnNode paramAbstractInsnNode2, InsnList paramInsnList) {
/*     */     this.insns.insertBefore(paramAbstractInsnNode1, paramInsnList);
/*     */     this.insns.remove(paramAbstractInsnNode1);
/*     */     this.injectionNodes.replace(paramAbstractInsnNode1, paramAbstractInsnNode2);
/*     */   }
/*     */   
/*     */   public String getSimpleCallbackDescriptor() {
/*     */     return String.format("(L%s;)V", new Object[] { getCallbackInfoClass() });
/*     */   }
/*     */   
/*     */   public String getCallbackInfoClass() {
/*     */     try {
/*     */       if (this.callbackInfoClass == null)
/*     */         this.callbackInfoClass = CallbackInfo.getCallInfoClassName(this.returnType); 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return this.callbackInfoClass;
/*     */   }
/*     */   
/*     */   public void addToLocals(int paramInt) {
/*     */     setMaxLocals(this.maxLocals + paramInt);
/*     */   }
/*     */   
/*     */   public AbstractInsnNode get(int paramInt) {
/*     */     return this.insns.get(paramInt);
/*     */   }
/*     */   
/*     */   public MethodInsnNode findInitNodeFor(TypeInsnNode paramTypeInsnNode) {
/*     */     int i = indexOf((AbstractInsnNode)paramTypeInsnNode);
/*     */     for (ListIterator<AbstractInsnNode> listIterator = this.insns.iterator(i); listIterator.hasNext(); ) {
/*     */       AbstractInsnNode abstractInsnNode = listIterator.next();
/*     */       try {
/*     */         if (abstractInsnNode instanceof MethodInsnNode && abstractInsnNode.getOpcode() == 183) {
/*     */           MethodInsnNode methodInsnNode = (MethodInsnNode)abstractInsnNode;
/*     */           try {
/*     */             if ("<init>".equals(methodInsnNode.name))
/*     */               try {
/*     */                 if (methodInsnNode.owner.equals(paramTypeInsnNode.desc))
/*     */                   return methodInsnNode; 
/*     */               } catch (RuntimeException runtimeException) {
/*     */                 throw b(null);
/*     */               }  
/*     */           } catch (RuntimeException runtimeException) {
/*     */             throw b(null);
/*     */           } 
/*     */         } 
/*     */       } catch (RuntimeException runtimeException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   public int getMaxLocals() {
/*     */     return this.maxLocals;
/*     */   }
/*     */   
/*     */   public int compareTo(Target paramTarget) {
/*     */     try {
/*     */       if (paramTarget == null)
/*     */         return Integer.MAX_VALUE; 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return toString().compareTo(paramTarget.toString());
/*     */   }
/*     */   
/*     */   private final InjectionNodes injectionNodes = new InjectionNodes();
/*     */   private String callbackInfoClass;
/*     */   private String callbackDescriptor;
/*     */   private int[] argIndices;
/*     */   private List<Integer> argMapVars;
/*     */   private LabelNode start;
/*     */   private LabelNode end;
/*     */   
/*     */   public int getCurrentMaxLocals() {
/*     */     return this.method.maxLocals;
/*     */   }
/*     */   
/*     */   public int[] generateArgMap(Type[] paramArrayOfType, int paramInt) {
/*     */     try {
/*     */       if (this.argMapVars == null)
/*     */         this.argMapVars = new ArrayList<Integer>(); 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     int[] arrayOfInt = new int[paramArrayOfType.length];
/*     */     for (int i = paramInt, j = 0; i < paramArrayOfType.length; ) {
/*     */       int k = paramArrayOfType[i].getSize();
/*     */       arrayOfInt[i] = allocateArgMapLocal(j, k);
/*     */       j += k;
/*     */       i++;
/*     */     } 
/*     */     return arrayOfInt;
/*     */   }
/*     */   
/*     */   public void insertBefore(AbstractInsnNode paramAbstractInsnNode, InsnList paramInsnList) {
/*     */     this.insns.insertBefore(paramAbstractInsnNode, paramInsnList);
/*     */   }
/*     */   
/*     */   public int indexOf(AbstractInsnNode paramAbstractInsnNode) {
/*     */     return this.insns.indexOf(paramAbstractInsnNode);
/*     */   }
/*     */   
/*     */   public MethodInsnNode findSuperInitNode() {
/*     */     try {
/*     */       if (!this.isCtor)
/*     */         return null; 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return Bytecode.findSuperInit(this.method, ClassInfo.forName(this.classNode.name).getSuperName());
/*     */   }
/*     */   
/*     */   public void setMaxLocals(int paramInt) {
/*     */     try {
/*     */       if (paramInt > this.method.maxLocals)
/*     */         this.method.maxLocals = paramInt; 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addLocalVariable(int paramInt, String paramString1, String paramString2) {
/*     */     try {
/*     */       if (this.start == null) {
/*     */         this.start = new LabelNode(new Label());
/*     */         this.end = new LabelNode(new Label());
/*     */         this.insns.insert((AbstractInsnNode)this.start);
/*     */         this.insns.add((AbstractInsnNode)this.end);
/*     */       } 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     addLocalVariable(paramInt, paramString1, paramString2, this.start, this.end);
/*     */   }
/*     */   
/*     */   public void insertBefore(InjectionNodes$InjectionNode paramInjectionNodes$InjectionNode, InsnList paramInsnList) {
/*     */     this.insns.insertBefore(paramInjectionNodes$InjectionNode.getCurrentTarget(), paramInsnList);
/*     */   }
/*     */   
/*     */   public int getCurrentMaxStack() {
/*     */     return this.method.maxStack;
/*     */   }
/*     */   
/*     */   public String toString() {
/*     */     return String.format("%s::%s%s", new Object[] { this.classNode.name, this.method.name, this.method.desc });
/*     */   }
/*     */   
/*     */   public Target(ClassNode paramClassNode, MethodNode paramMethodNode) {
/*     */     this.classNode = paramClassNode;
/*     */     this.method = paramMethodNode;
/*     */     this.insns = paramMethodNode.instructions;
/*     */     this.isStatic = Bytecode.methodIsStatic(paramMethodNode);
/*     */     this.isCtor = paramMethodNode.name.equals("<init>");
/*     */     this.arguments = Type.getArgumentTypes(paramMethodNode.desc);
/*     */     this.returnType = Type.getReturnType(paramMethodNode.desc);
/*     */     this.maxStack = paramMethodNode.maxStack;
/*     */     this.maxLocals = paramMethodNode.maxLocals;
/*     */   }
/*     */   
/*     */   private void addLocalVariable(int paramInt, String paramString1, String paramString2, LabelNode paramLabelNode1, LabelNode paramLabelNode2) {
/*     */     try {
/*     */       if (this.method.localVariables == null)
/*     */         this.method.localVariables = new ArrayList(); 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     this.method.localVariables.add(new LocalVariableNode(paramString1, paramString2, null, paramLabelNode1, paramLabelNode2, paramInt));
/*     */   }
/*     */   
/*     */   public void wrapNode(AbstractInsnNode paramAbstractInsnNode1, AbstractInsnNode paramAbstractInsnNode2, InsnList paramInsnList1, InsnList paramInsnList2) {
/*     */     this.insns.insertBefore(paramAbstractInsnNode1, paramInsnList1);
/*     */     this.insns.insert(paramAbstractInsnNode1, paramInsnList2);
/*     */     this.injectionNodes.replace(paramAbstractInsnNode1, paramAbstractInsnNode2);
/*     */   }
/*     */   
/*     */   public int[] getArgIndices() {
/*     */     try {
/*     */       if (this.argIndices == null) {
/*     */         try {
/*     */         
/*     */         } catch (RuntimeException runtimeException) {
/*     */           throw b(null);
/*     */         } 
/*     */         this.argIndices = calcArgIndices(this.isStatic ? 0 : 1);
/*     */       } 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return this.argIndices;
/*     */   }
/*     */   
/*     */   public int allocateLocals(int paramInt) {
/*     */     int i = this.method.maxLocals;
/*     */     this.method.maxLocals += paramInt;
/*     */     return i;
/*     */   }
/*     */   
/*     */   public void setMaxStack(int paramInt) {
/*     */     try {
/*     */       if (paramInt > this.method.maxStack)
/*     */         this.method.maxStack = paramInt; 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   private int[] calcArgIndices(int paramInt) {
/*     */     int[] arrayOfInt = new int[this.arguments.length];
/*     */     for (byte b = 0; b < this.arguments.length; ) {
/*     */       arrayOfInt[b] = paramInt;
/*     */       paramInt += this.arguments[b].getSize();
/*     */       b++;
/*     */     } 
/*     */     return arrayOfInt;
/*     */   }
/*     */   
/*     */   public void addToStack(int paramInt) {
/*     */     setMaxStack(this.maxStack + paramInt);
/*     */   }
/*     */   
/*     */   public Iterator<AbstractInsnNode> iterator() {
/*     */     return this.insns.iterator();
/*     */   }
/*     */   
/*     */   public void removeNode(AbstractInsnNode paramAbstractInsnNode) {
/*     */     this.insns.remove(paramAbstractInsnNode);
/*     */     this.injectionNodes.remove(paramAbstractInsnNode);
/*     */   }
/*     */   
/*     */   public int allocateLocal() {
/*     */     return allocateLocals(1);
/*     */   }
/*     */   
/*     */   public String getCallbackDescriptor(boolean paramBoolean, Type[] paramArrayOfType1, Type[] paramArrayOfType2, int paramInt1, int paramInt2) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield callbackDescriptor : Ljava/lang/String;
/*     */     //   4: ifnonnull -> 60
/*     */     //   7: aload_0
/*     */     //   8: ldc '(%sL%s;)V'
/*     */     //   10: iconst_2
/*     */     //   11: anewarray java/lang/Object
/*     */     //   14: dup
/*     */     //   15: iconst_0
/*     */     //   16: aload_0
/*     */     //   17: getfield method : Lorg/spongepowered/asm/lib/tree/MethodNode;
/*     */     //   20: getfield desc : Ljava/lang/String;
/*     */     //   23: iconst_1
/*     */     //   24: aload_0
/*     */     //   25: getfield method : Lorg/spongepowered/asm/lib/tree/MethodNode;
/*     */     //   28: getfield desc : Ljava/lang/String;
/*     */     //   31: bipush #41
/*     */     //   33: invokevirtual indexOf : (I)I
/*     */     //   36: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   39: aastore
/*     */     //   40: dup
/*     */     //   41: iconst_1
/*     */     //   42: aload_0
/*     */     //   43: invokevirtual getCallbackInfoClass : ()Ljava/lang/String;
/*     */     //   46: aastore
/*     */     //   47: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   50: putfield callbackDescriptor : Ljava/lang/String;
/*     */     //   53: goto -> 60
/*     */     //   56: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   59: athrow
/*     */     //   60: iload_1
/*     */     //   61: ifeq -> 75
/*     */     //   64: aload_2
/*     */     //   65: ifnonnull -> 84
/*     */     //   68: goto -> 75
/*     */     //   71: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   74: athrow
/*     */     //   75: aload_0
/*     */     //   76: getfield callbackDescriptor : Ljava/lang/String;
/*     */     //   79: areturn
/*     */     //   80: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   83: athrow
/*     */     //   84: new java/lang/StringBuilder
/*     */     //   87: dup
/*     */     //   88: aload_0
/*     */     //   89: getfield callbackDescriptor : Ljava/lang/String;
/*     */     //   92: iconst_0
/*     */     //   93: aload_0
/*     */     //   94: getfield callbackDescriptor : Ljava/lang/String;
/*     */     //   97: bipush #41
/*     */     //   99: invokevirtual indexOf : (I)I
/*     */     //   102: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   105: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   108: astore #6
/*     */     //   110: iload #4
/*     */     //   112: istore #7
/*     */     //   114: iload #7
/*     */     //   116: aload_2
/*     */     //   117: arraylength
/*     */     //   118: if_icmpge -> 176
/*     */     //   121: iload #5
/*     */     //   123: ifle -> 176
/*     */     //   126: goto -> 133
/*     */     //   129: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   132: athrow
/*     */     //   133: aload_2
/*     */     //   134: iload #7
/*     */     //   136: aaload
/*     */     //   137: ifnull -> 170
/*     */     //   140: goto -> 147
/*     */     //   143: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   146: athrow
/*     */     //   147: aload #6
/*     */     //   149: aload_2
/*     */     //   150: iload #7
/*     */     //   152: aaload
/*     */     //   153: invokevirtual getDescriptor : ()Ljava/lang/String;
/*     */     //   156: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   159: pop
/*     */     //   160: iinc #5, -1
/*     */     //   163: goto -> 170
/*     */     //   166: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   169: athrow
/*     */     //   170: iinc #7, 1
/*     */     //   173: goto -> 114
/*     */     //   176: aload #6
/*     */     //   178: ldc ')V'
/*     */     //   180: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   183: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   186: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #132	-> 0
/*     */     //   #96	-> 7
/*     */     //   #4	-> 43
/*     */     //   #104	-> 47
/*     */     //   #20	-> 60
/*     */     //   #27	-> 75
/*     */     //   #87	-> 84
/*     */     //   #101	-> 110
/*     */     //   #110	-> 133
/*     */     //   #34	-> 147
/*     */     //   #107	-> 160
/*     */     //   #134	-> 170
/*     */     //   #95	-> 176
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   0	53	56	java/lang/RuntimeException
/*     */     //   60	68	71	java/lang/RuntimeException
/*     */     //   64	80	80	java/lang/RuntimeException
/*     */     //   114	126	129	java/lang/RuntimeException
/*     */     //   121	140	143	java/lang/RuntimeException
/*     */     //   133	163	166	java/lang/RuntimeException
/*     */   }
/*     */   
/*     */   public InjectionNodes$InjectionNode addInjectionNode(AbstractInsnNode paramAbstractInsnNode) {
/*     */     return this.injectionNodes.add(paramAbstractInsnNode);
/*     */   }
/*     */   
/*     */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*     */     return paramRuntimeException;
/*     */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\struct\Target.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */