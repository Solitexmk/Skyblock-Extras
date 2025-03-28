/*     */ package org.spongepowered.asm.mixin.injection.invoke;
/*     */ import org.spongepowered.asm.lib.Type;
/*     */ import org.spongepowered.asm.lib.tree.AbstractInsnNode;
/*     */ import org.spongepowered.asm.lib.tree.FieldInsnNode;
/*     */ import org.spongepowered.asm.mixin.injection.struct.InjectionNodes;
/*     */ import org.spongepowered.asm.mixin.injection.struct.Target;
/*     */ import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;
/*     */ 
/*     */ public class RedirectInjector extends InvokeInjector {
/*     */   private static final String KEY_NOMINATORS = "nominators";
/*     */   private static final String KEY_FUZZ = "fuzz";
/*     */   
/*     */   public RedirectInjector(InjectionInfo paramInjectionInfo) {
/*  14 */     this(paramInjectionInfo, "@Redirect");
/*     */   } private static final String KEY_OPCODE = "opcode"; protected RedirectInjector$Meta meta;
/*     */   protected void checkTarget(Target paramTarget) {}
/*     */   public void injectArrayRedirect(Target paramTarget, FieldInsnNode paramFieldInsnNode, AbstractInsnNode paramAbstractInsnNode, boolean paramBoolean, String paramString) {
/*     */     // Byte code:
/*     */     //   0: aload_3
/*     */     //   1: ifnonnull -> 54
/*     */     //   4: ldc ''
/*     */     //   6: astore #6
/*     */     //   8: new org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   11: dup
/*     */     //   12: aload_0
/*     */     //   13: getfield info : Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;
/*     */     //   16: ldc 'Array element %s on %s could not locate a matching %s instruction in %s. %s'
/*     */     //   18: iconst_5
/*     */     //   19: anewarray java/lang/Object
/*     */     //   22: dup
/*     */     //   23: iconst_0
/*     */     //   24: aload_0
/*     */     //   25: getfield annotationType : Ljava/lang/String;
/*     */     //   28: aastore
/*     */     //   29: dup
/*     */     //   30: iconst_1
/*     */     //   31: aload_0
/*     */     //   32: aastore
/*     */     //   33: dup
/*     */     //   34: iconst_2
/*     */     //   35: aload #5
/*     */     //   37: aastore
/*     */     //   38: dup
/*     */     //   39: iconst_3
/*     */     //   40: aload_1
/*     */     //   41: aastore
/*     */     //   42: dup
/*     */     //   43: iconst_4
/*     */     //   44: aload #6
/*     */     //   46: aastore
/*     */     //   47: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   50: invokespecial <init> : (Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;Ljava/lang/String;)V
/*     */     //   53: athrow
/*     */     //   54: aload_0
/*     */     //   55: getfield isStatic : Z
/*     */     //   58: ifne -> 91
/*     */     //   61: aload_1
/*     */     //   62: getfield insns : Lorg/spongepowered/asm/lib/tree/InsnList;
/*     */     //   65: aload_2
/*     */     //   66: new org/spongepowered/asm/lib/tree/VarInsnNode
/*     */     //   69: dup
/*     */     //   70: bipush #25
/*     */     //   72: iconst_0
/*     */     //   73: invokespecial <init> : (II)V
/*     */     //   76: invokevirtual insertBefore : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;)V
/*     */     //   79: aload_1
/*     */     //   80: iconst_1
/*     */     //   81: invokevirtual addToStack : (I)V
/*     */     //   84: goto -> 91
/*     */     //   87: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   90: athrow
/*     */     //   91: new org/spongepowered/asm/lib/tree/InsnList
/*     */     //   94: dup
/*     */     //   95: invokespecial <init> : ()V
/*     */     //   98: astore #6
/*     */     //   100: iload #4
/*     */     //   102: ifeq -> 143
/*     */     //   105: aload_0
/*     */     //   106: aload_1
/*     */     //   107: getfield arguments : [Lorg/spongepowered/asm/lib/Type;
/*     */     //   110: aload #6
/*     */     //   112: aload_1
/*     */     //   113: invokevirtual getArgIndices : ()[I
/*     */     //   116: iconst_0
/*     */     //   117: aload_1
/*     */     //   118: getfield arguments : [Lorg/spongepowered/asm/lib/Type;
/*     */     //   121: arraylength
/*     */     //   122: invokevirtual pushArgs : ([Lorg/spongepowered/asm/lib/Type;Lorg/spongepowered/asm/lib/tree/InsnList;[III)V
/*     */     //   125: aload_1
/*     */     //   126: aload_1
/*     */     //   127: getfield arguments : [Lorg/spongepowered/asm/lib/Type;
/*     */     //   130: invokestatic getArgsSize : ([Lorg/spongepowered/asm/lib/Type;)I
/*     */     //   133: invokevirtual addToStack : (I)V
/*     */     //   136: goto -> 143
/*     */     //   139: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   142: athrow
/*     */     //   143: aload_1
/*     */     //   144: aload_3
/*     */     //   145: aload_0
/*     */     //   146: aload #6
/*     */     //   148: invokevirtual invokeHandler : (Lorg/spongepowered/asm/lib/tree/InsnList;)Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;
/*     */     //   151: aload #6
/*     */     //   153: invokevirtual replaceNode : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;Lorg/spongepowered/asm/lib/tree/InsnList;)V
/*     */     //   156: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #15	-> 0
/*     */     //   #265	-> 4
/*     */     //   #255	-> 8
/*     */     //   #193	-> 54
/*     */     //   #122	-> 61
/*     */     //   #17	-> 79
/*     */     //   #224	-> 91
/*     */     //   #213	-> 100
/*     */     //   #206	-> 105
/*     */     //   #91	-> 125
/*     */     //   #79	-> 143
/*     */     //   #144	-> 156
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   54	84	87	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   100	136	139	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */   }
/*     */   public void injectAtScalarField(Target paramTarget, FieldInsnNode paramFieldInsnNode, int paramInt, Type paramType1, Type paramType2) {
/*     */     // Byte code:
/*     */     //   0: aconst_null
/*     */     //   1: astore #6
/*     */     //   3: new org/spongepowered/asm/lib/tree/InsnList
/*     */     //   6: dup
/*     */     //   7: invokespecial <init> : ()V
/*     */     //   10: astore #7
/*     */     //   12: iload_3
/*     */     //   13: sipush #178
/*     */     //   16: if_icmpeq -> 33
/*     */     //   19: iload_3
/*     */     //   20: sipush #180
/*     */     //   23: if_icmpne -> 73
/*     */     //   26: goto -> 33
/*     */     //   29: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   32: athrow
/*     */     //   33: aload_0
/*     */     //   34: aload #7
/*     */     //   36: aload_1
/*     */     //   37: aload_2
/*     */     //   38: iload_3
/*     */     //   39: sipush #178
/*     */     //   42: if_icmpne -> 60
/*     */     //   45: goto -> 52
/*     */     //   48: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   51: athrow
/*     */     //   52: iconst_1
/*     */     //   53: goto -> 61
/*     */     //   56: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   59: athrow
/*     */     //   60: iconst_0
/*     */     //   61: aload #4
/*     */     //   63: aload #5
/*     */     //   65: invokespecial injectAtGetField : (Lorg/spongepowered/asm/lib/tree/InsnList;Lorg/spongepowered/asm/mixin/injection/struct/Target;Lorg/spongepowered/asm/lib/tree/FieldInsnNode;ZLorg/spongepowered/asm/lib/Type;Lorg/spongepowered/asm/lib/Type;)Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;
/*     */     //   68: astore #6
/*     */     //   70: goto -> 169
/*     */     //   73: iload_3
/*     */     //   74: sipush #179
/*     */     //   77: if_icmpeq -> 94
/*     */     //   80: iload_3
/*     */     //   81: sipush #181
/*     */     //   84: if_icmpne -> 134
/*     */     //   87: goto -> 94
/*     */     //   90: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   93: athrow
/*     */     //   94: aload_0
/*     */     //   95: aload #7
/*     */     //   97: aload_1
/*     */     //   98: aload_2
/*     */     //   99: iload_3
/*     */     //   100: sipush #179
/*     */     //   103: if_icmpne -> 121
/*     */     //   106: goto -> 113
/*     */     //   109: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   112: athrow
/*     */     //   113: iconst_1
/*     */     //   114: goto -> 122
/*     */     //   117: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   120: athrow
/*     */     //   121: iconst_0
/*     */     //   122: aload #4
/*     */     //   124: aload #5
/*     */     //   126: invokespecial injectAtPutField : (Lorg/spongepowered/asm/lib/tree/InsnList;Lorg/spongepowered/asm/mixin/injection/struct/Target;Lorg/spongepowered/asm/lib/tree/FieldInsnNode;ZLorg/spongepowered/asm/lib/Type;Lorg/spongepowered/asm/lib/Type;)Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;
/*     */     //   129: astore #6
/*     */     //   131: goto -> 169
/*     */     //   134: new org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   137: dup
/*     */     //   138: aload_0
/*     */     //   139: getfield info : Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;
/*     */     //   142: ldc 'Unspported opcode %s for %s'
/*     */     //   144: iconst_2
/*     */     //   145: anewarray java/lang/Object
/*     */     //   148: dup
/*     */     //   149: iconst_0
/*     */     //   150: iload_3
/*     */     //   151: invokestatic getOpcodeName : (I)Ljava/lang/String;
/*     */     //   154: aastore
/*     */     //   155: dup
/*     */     //   156: iconst_1
/*     */     //   157: aload_0
/*     */     //   158: getfield info : Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;
/*     */     //   161: aastore
/*     */     //   162: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   165: invokespecial <init> : (Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;Ljava/lang/String;)V
/*     */     //   168: athrow
/*     */     //   169: aload_1
/*     */     //   170: aload_2
/*     */     //   171: aload #6
/*     */     //   173: aload #7
/*     */     //   175: invokevirtual replaceNode : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;Lorg/spongepowered/asm/lib/tree/InsnList;)V
/*     */     //   178: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #20	-> 0
/*     */     //   #176	-> 3
/*     */     //   #139	-> 12
/*     */     //   #128	-> 33
/*     */     //   #204	-> 73
/*     */     //   #100	-> 94
/*     */     //   #243	-> 134
/*     */     //   #16	-> 169
/*     */     //   #69	-> 178
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   12	26	29	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   19	45	48	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   33	56	56	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   73	87	90	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   80	106	109	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   94	117	117	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */   }
/*     */   private static Type[] getArrayArgs(Type paramType, int paramInt, Type... paramVarArgs) {
/*  24 */     int i = paramType.getDimensions() + paramInt;
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
/*     */     
/*  99 */     Type[] arrayOfType = new Type[i + paramVarArgs.length];
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
/* 214 */     byte b = 0; while (true) { try { if (b < arrayOfType.length) { try { try {  } catch (InvalidInjectionException invalidInjectionException) { throw d(null); }  }
/*     */           catch (InvalidInjectionException invalidInjectionException) { throw d(null); }
/* 216 */            arrayOfType[b] = (b == 0) ? paramType : ((b < i) ? Type.INT_TYPE : paramVarArgs[i - b]); b++; }
/*     */          }
/*     */       catch (InvalidInjectionException invalidInjectionException)
/*     */       { throw d(null); }
/*     */       
/*     */       return arrayOfType; }
/*     */   
/*     */   }
/*     */   protected void addTargetNode(Target paramTarget, List<InjectionNodes.InjectionNode> paramList, AbstractInsnNode paramAbstractInsnNode, Set<InjectionPoint> paramSet) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: aload_3
/*     */     //   2: invokevirtual getInjectionNode : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;)Lorg/spongepowered/asm/mixin/injection/struct/InjectionNodes$InjectionNode;
/*     */     //   5: astore #5
/*     */     //   7: aconst_null
/*     */     //   8: astore #6
/*     */     //   10: bipush #8
/*     */     //   12: istore #7
/*     */     //   14: iconst_0
/*     */     //   15: istore #8
/*     */     //   17: aload #5
/*     */     //   19: ifnull -> 194
/*     */     //   22: aload #5
/*     */     //   24: ldc 'redirector'
/*     */     //   26: invokevirtual getDecoration : (Ljava/lang/String;)Ljava/lang/Object;
/*     */     //   29: checkcast org/spongepowered/asm/mixin/injection/invoke/RedirectInjector$Meta
/*     */     //   32: astore #9
/*     */     //   34: aload #9
/*     */     //   36: ifnull -> 194
/*     */     //   39: aload #9
/*     */     //   41: invokevirtual getOwner : ()Lorg/spongepowered/asm/mixin/injection/invoke/RedirectInjector;
/*     */     //   44: aload_0
/*     */     //   45: if_acmpeq -> 194
/*     */     //   48: goto -> 55
/*     */     //   51: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   54: athrow
/*     */     //   55: aload #9
/*     */     //   57: getfield priority : I
/*     */     //   60: aload_0
/*     */     //   61: getfield meta : Lorg/spongepowered/asm/mixin/injection/invoke/RedirectInjector$Meta;
/*     */     //   64: getfield priority : I
/*     */     //   67: if_icmplt -> 142
/*     */     //   70: goto -> 77
/*     */     //   73: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   76: athrow
/*     */     //   77: getstatic org/spongepowered/asm/mixin/injection/code/Injector.logger : Lorg/apache/logging/log4j/Logger;
/*     */     //   80: ldc '{} conflict. Skipping {} with priority {}, already redirected by {} with priority {}'
/*     */     //   82: iconst_5
/*     */     //   83: anewarray java/lang/Object
/*     */     //   86: dup
/*     */     //   87: iconst_0
/*     */     //   88: aload_0
/*     */     //   89: getfield annotationType : Ljava/lang/String;
/*     */     //   92: aastore
/*     */     //   93: dup
/*     */     //   94: iconst_1
/*     */     //   95: aload_0
/*     */     //   96: getfield info : Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;
/*     */     //   99: aastore
/*     */     //   100: dup
/*     */     //   101: iconst_2
/*     */     //   102: aload_0
/*     */     //   103: getfield meta : Lorg/spongepowered/asm/mixin/injection/invoke/RedirectInjector$Meta;
/*     */     //   106: getfield priority : I
/*     */     //   109: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   112: aastore
/*     */     //   113: dup
/*     */     //   114: iconst_3
/*     */     //   115: aload #9
/*     */     //   117: getfield name : Ljava/lang/String;
/*     */     //   120: aastore
/*     */     //   121: dup
/*     */     //   122: iconst_4
/*     */     //   123: aload #9
/*     */     //   125: getfield priority : I
/*     */     //   128: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   131: aastore
/*     */     //   132: invokeinterface warn : (Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   137: return
/*     */     //   138: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   141: athrow
/*     */     //   142: aload #9
/*     */     //   144: getfield isFinal : Z
/*     */     //   147: ifeq -> 194
/*     */     //   150: new org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   153: dup
/*     */     //   154: aload_0
/*     */     //   155: getfield info : Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;
/*     */     //   158: ldc '%s conflict: %s failed because target was already remapped by %s'
/*     */     //   160: iconst_3
/*     */     //   161: anewarray java/lang/Object
/*     */     //   164: dup
/*     */     //   165: iconst_0
/*     */     //   166: aload_0
/*     */     //   167: getfield annotationType : Ljava/lang/String;
/*     */     //   170: aastore
/*     */     //   171: dup
/*     */     //   172: iconst_1
/*     */     //   173: aload_0
/*     */     //   174: aastore
/*     */     //   175: dup
/*     */     //   176: iconst_2
/*     */     //   177: aload #9
/*     */     //   179: getfield name : Ljava/lang/String;
/*     */     //   182: aastore
/*     */     //   183: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   186: invokespecial <init> : (Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;Ljava/lang/String;)V
/*     */     //   189: athrow
/*     */     //   190: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   193: athrow
/*     */     //   194: aload #4
/*     */     //   196: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   201: astore #9
/*     */     //   203: aload #9
/*     */     //   205: invokeinterface hasNext : ()Z
/*     */     //   210: ifeq -> 304
/*     */     //   213: aload #9
/*     */     //   215: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   220: checkcast org/spongepowered/asm/mixin/injection/InjectionPoint
/*     */     //   223: astore #10
/*     */     //   225: aload #10
/*     */     //   227: instanceof org/spongepowered/asm/mixin/injection/points/BeforeNew
/*     */     //   230: ifeq -> 272
/*     */     //   233: aload_0
/*     */     //   234: aload #10
/*     */     //   236: checkcast org/spongepowered/asm/mixin/injection/points/BeforeNew
/*     */     //   239: invokespecial getCtorRedirect : (Lorg/spongepowered/asm/mixin/injection/points/BeforeNew;)Lorg/spongepowered/asm/mixin/injection/invoke/RedirectInjector$ConstructorRedirectData;
/*     */     //   242: astore #6
/*     */     //   244: aload #6
/*     */     //   246: aload #10
/*     */     //   248: checkcast org/spongepowered/asm/mixin/injection/points/BeforeNew
/*     */     //   251: invokevirtual hasDescriptor : ()Z
/*     */     //   254: ifne -> 265
/*     */     //   257: iconst_1
/*     */     //   258: goto -> 266
/*     */     //   261: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   264: athrow
/*     */     //   265: iconst_0
/*     */     //   266: putfield wildcard : Z
/*     */     //   269: goto -> 301
/*     */     //   272: aload #10
/*     */     //   274: instanceof org/spongepowered/asm/mixin/injection/points/BeforeFieldAccess
/*     */     //   277: ifeq -> 301
/*     */     //   280: aload #10
/*     */     //   282: checkcast org/spongepowered/asm/mixin/injection/points/BeforeFieldAccess
/*     */     //   285: astore #11
/*     */     //   287: aload #11
/*     */     //   289: invokevirtual getFuzzFactor : ()I
/*     */     //   292: istore #7
/*     */     //   294: aload #11
/*     */     //   296: invokevirtual getArrayOpcode : ()I
/*     */     //   299: istore #8
/*     */     //   301: goto -> 203
/*     */     //   304: aload_1
/*     */     //   305: aload_3
/*     */     //   306: invokevirtual addInjectionNode : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;)Lorg/spongepowered/asm/mixin/injection/struct/InjectionNodes$InjectionNode;
/*     */     //   309: astore #9
/*     */     //   311: aload #9
/*     */     //   313: ldc 'redirector'
/*     */     //   315: aload_0
/*     */     //   316: getfield meta : Lorg/spongepowered/asm/mixin/injection/invoke/RedirectInjector$Meta;
/*     */     //   319: invokevirtual decorate : (Ljava/lang/String;Ljava/lang/Object;)Lorg/spongepowered/asm/mixin/injection/struct/InjectionNodes$InjectionNode;
/*     */     //   322: pop
/*     */     //   323: aload #9
/*     */     //   325: ldc 'nominators'
/*     */     //   327: aload #4
/*     */     //   329: invokevirtual decorate : (Ljava/lang/String;Ljava/lang/Object;)Lorg/spongepowered/asm/mixin/injection/struct/InjectionNodes$InjectionNode;
/*     */     //   332: pop
/*     */     //   333: aload_3
/*     */     //   334: instanceof org/spongepowered/asm/lib/tree/TypeInsnNode
/*     */     //   337: ifeq -> 374
/*     */     //   340: aload_3
/*     */     //   341: invokevirtual getOpcode : ()I
/*     */     //   344: sipush #187
/*     */     //   347: if_icmpne -> 374
/*     */     //   350: goto -> 357
/*     */     //   353: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   356: athrow
/*     */     //   357: aload #9
/*     */     //   359: ldc 'ctor'
/*     */     //   361: aload #6
/*     */     //   363: invokevirtual decorate : (Ljava/lang/String;Ljava/lang/Object;)Lorg/spongepowered/asm/mixin/injection/struct/InjectionNodes$InjectionNode;
/*     */     //   366: pop
/*     */     //   367: goto -> 400
/*     */     //   370: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   373: athrow
/*     */     //   374: aload #9
/*     */     //   376: ldc 'fuzz'
/*     */     //   378: iload #7
/*     */     //   380: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   383: invokevirtual decorate : (Ljava/lang/String;Ljava/lang/Object;)Lorg/spongepowered/asm/mixin/injection/struct/InjectionNodes$InjectionNode;
/*     */     //   386: pop
/*     */     //   387: aload #9
/*     */     //   389: ldc 'opcode'
/*     */     //   391: iload #8
/*     */     //   393: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   396: invokevirtual decorate : (Ljava/lang/String;Ljava/lang/Object;)Lorg/spongepowered/asm/mixin/injection/struct/InjectionNodes$InjectionNode;
/*     */     //   399: pop
/*     */     //   400: aload_2
/*     */     //   401: aload #9
/*     */     //   403: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   408: pop
/*     */     //   409: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #50	-> 0
/*     */     //   #92	-> 7
/*     */     //   #127	-> 10
/*     */     //   #76	-> 14
/*     */     //   #131	-> 17
/*     */     //   #195	-> 22
/*     */     //   #252	-> 34
/*     */     //   #196	-> 55
/*     */     //   #119	-> 77
/*     */     //   #137	-> 109
/*     */     //   #259	-> 132
/*     */     //   #83	-> 137
/*     */     //   #241	-> 142
/*     */     //   #106	-> 150
/*     */     //   #151	-> 194
/*     */     //   #219	-> 225
/*     */     //   #254	-> 233
/*     */     //   #164	-> 244
/*     */     //   #272	-> 272
/*     */     //   #248	-> 280
/*     */     //   #123	-> 287
/*     */     //   #73	-> 294
/*     */     //   #221	-> 301
/*     */     //   #28	-> 304
/*     */     //   #218	-> 311
/*     */     //   #40	-> 323
/*     */     //   #2	-> 333
/*     */     //   #199	-> 357
/*     */     //   #30	-> 374
/*     */     //   #134	-> 387
/*     */     //   #114	-> 400
/*     */     //   #48	-> 409
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   34	48	51	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   39	70	73	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   55	138	138	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   142	190	190	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   244	261	261	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   311	350	353	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   340	370	370	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */   }
/*     */   protected boolean checkDescriptor(String paramString1, Target paramTarget, String paramString2) {
/*     */     try {
/*     */       if (this.methodNode.desc.equals(paramString1))
/*     */         return false; 
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw d(null);
/*     */     } 
/*     */     int i = paramString1.indexOf(')');
/*     */     String str = String.format("%s%s%s", new Object[] { paramString1.substring(0, i), Joiner.on("").join((Object[])paramTarget.arguments), paramString1.substring(i) });
/*     */     try {
/*     */       if (this.methodNode.desc.equals(str))
/*     */         return true; 
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw d(null);
/*     */     } 
/*     */     throw new InvalidInjectionException(this.info, String.format("%s method %s %s has an invalid signature. Expected %s but found %s", new Object[] { this.annotationType, paramString2, this, paramString1, this.methodNode.desc }));
/*     */   }
/*     */   private void injectAtSetArray(Target paramTarget, FieldInsnNode paramFieldInsnNode, AbstractInsnNode paramAbstractInsnNode, Type paramType1, Type paramType2) { String str = Bytecode.generateDescriptor(null, (Object[])getArrayArgs(paramType2, 1, new Type[] { paramType2.getElementType() }));
/*     */     boolean bool = checkDescriptor(str, paramTarget, "array setter");
/* 246 */     injectArrayRedirect(paramTarget, paramFieldInsnNode, paramAbstractInsnNode, bool, "array setter"); } private void injectAtFieldAccess(Target paramTarget, InjectionNodes.InjectionNode paramInjectionNode) { FieldInsnNode fieldInsnNode = (FieldInsnNode)paramInjectionNode.getCurrentTarget(); int i = fieldInsnNode.getOpcode(); Type type1 = Type.getType("L" + fieldInsnNode.owner + ";"); Type type2 = Type.getType(fieldInsnNode.desc); try {  }
/*     */     catch (InvalidInjectionException invalidInjectionException) { throw d(null); }
/*     */      byte b1 = (type2.getSort() == 9) ? type2.getDimensions() : 0; try {  }
/*     */     catch (InvalidInjectionException invalidInjectionException) { throw d(null); }
/*     */      byte b2 = (this.returnType.getSort() == 9) ? this.returnType.getDimensions() : 0; try { if (b2 > b1)
/*     */         throw new InvalidInjectionException(this.info, "Dimensionality of handler method is greater than target array on " + this);  }
/*     */     catch (InvalidInjectionException invalidInjectionException) { throw d(null); }
/*     */      try { if (b2 == 0 && b1 > 0) { int j = ((Integer)paramInjectionNode.getDecoration("fuzz")).intValue(); int k = ((Integer)paramInjectionNode.getDecoration("opcode")).intValue(); injectAtArrayField(paramTarget, fieldInsnNode, i, type1, type2, j, k); }
/*     */        }
/*     */     catch (InvalidInjectionException invalidInjectionException)
/*     */     { throw d(null); }
/*     */      injectAtScalarField(paramTarget, fieldInsnNode, i, type1, type2); }
/*     */   protected void inject(Target paramTarget, InjectionNodes.InjectionNode paramInjectionNode) { 
/*     */     try { if (!preInject(paramInjectionNode))
/*     */         return;  }
/*     */     catch (InvalidInjectionException invalidInjectionException)
/* 262 */     { throw d(null); }  try { if (paramInjectionNode.isReplaced())
/*     */         throw new UnsupportedOperationException("Redirector target failure for " + this.info);  } catch (InvalidInjectionException invalidInjectionException) { throw d(null); }  try { if (paramInjectionNode.getCurrentTarget() instanceof MethodInsnNode) { checkTargetForNode(paramTarget, paramInjectionNode); injectAtInvoke(paramTarget, paramInjectionNode); return; }  } catch (InvalidInjectionException invalidInjectionException) { throw d(null); }
/*     */      try { if (paramInjectionNode.getCurrentTarget() instanceof FieldInsnNode) { checkTargetForNode(paramTarget, paramInjectionNode); injectAtFieldAccess(paramTarget, paramInjectionNode); }
/*     */        }
/*     */     catch (InvalidInjectionException invalidInjectionException) { throw d(null); }
/* 267 */      try { if (paramInjectionNode.getCurrentTarget() instanceof TypeInsnNode) try { if (paramInjectionNode.getCurrentTarget().getOpcode() == 187) { try { if (!this.isStatic) try { if (paramTarget.isStatic) throw new InvalidInjectionException(this.info, String.format("non-static callback method %s has a static target which is not supported", new Object[] { this }));  } catch (InvalidInjectionException invalidInjectionException) { throw d(null); }   } catch (InvalidInjectionException invalidInjectionException) { throw d(null); }  injectAtConstructor(paramTarget, paramInjectionNode); }  } catch (InvalidInjectionException invalidInjectionException) { throw d(null); }   } catch (InvalidInjectionException invalidInjectionException) { throw d(null); }
/*     */      throw new InvalidInjectionException(this.info, String.format("%s annotation on is targetting an invalid insn in %s in %s", new Object[] { this.annotationType, paramTarget, this })); } private Map<BeforeNew, RedirectInjector$ConstructorRedirectData> ctorRedirectors = new HashMap<BeforeNew, RedirectInjector$ConstructorRedirectData>(); private void injectAtArrayField(Target paramTarget, FieldInsnNode paramFieldInsnNode, int paramInt1, Type paramType1, Type paramType2, int paramInt2, int paramInt3) { Type type = paramType2.getElementType(); try { if (paramInt1 != 178)
/*     */         try { if (paramInt1 != 180)
/* 270 */             throw new InvalidInjectionException(this.info, String.format("Unspported opcode %s for array access %s", new Object[] { Bytecode.getOpcodeName(paramInt1), this.info }));  } catch (InvalidInjectionException invalidInjectionException) { throw d(null); }   } catch (InvalidInjectionException invalidInjectionException) { throw d(null); }  try { if (this.returnType.getSort() != 0) { if (paramInt3 != 190)
/* 271 */           paramInt3 = type.getOpcode(46);  AbstractInsnNode abstractInsnNode1 = BeforeFieldAccess.findArrayNode(paramTarget.insns, paramFieldInsnNode, paramInt3, paramInt2); injectAtGetArray(paramTarget, paramFieldInsnNode, abstractInsnNode1, paramType1, paramType2); }  } catch (InvalidInjectionException invalidInjectionException) { throw d(null); }  AbstractInsnNode abstractInsnNode = BeforeFieldAccess.findArrayNode(paramTarget.insns, paramFieldInsnNode, type.getOpcode(79), paramInt2); injectAtSetArray(paramTarget, paramFieldInsnNode, abstractInsnNode, paramType1, paramType2); } protected boolean preInject(InjectionNodes.InjectionNode paramInjectionNode) { RedirectInjector$Meta redirectInjector$Meta = (RedirectInjector$Meta)paramInjectionNode.getDecoration("redirector"); try { if (redirectInjector$Meta.getOwner() != this) { Injector.logger.warn("{} conflict. Skipping {} with priority {}, already redirected by {} with priority {}", new Object[] { this.annotationType, this.info, Integer.valueOf(this.meta.priority), redirectInjector$Meta.name, Integer.valueOf(redirectInjector$Meta.priority) });
/*     */         return false; }
/*     */        }
/*     */     catch (InvalidInjectionException invalidInjectionException)
/*     */     { throw d(null); }
/*     */     
/*     */     return true; }
/*     */ 
/*     */   
/*     */   protected void postInject(Target paramTarget, InjectionNodes.InjectionNode paramInjectionNode) {
/*     */     try {
/*     */       super.postInject(paramTarget, paramInjectionNode);
/*     */       if (paramInjectionNode.getOriginalTarget() instanceof TypeInsnNode && paramInjectionNode.getOriginalTarget().getOpcode() == 187) {
/*     */         RedirectInjector$ConstructorRedirectData redirectInjector$ConstructorRedirectData = (RedirectInjector$ConstructorRedirectData)paramInjectionNode.getDecoration("ctor");
/*     */         try {
/*     */           if (redirectInjector$ConstructorRedirectData.wildcard)
/*     */             try {
/*     */               if (redirectInjector$ConstructorRedirectData.injected == 0)
/*     */                 throw new InvalidInjectionException(this.info, String.format("%s ctor invocation was not found in %s", new Object[] { this.annotationType, paramTarget })); 
/*     */             } catch (InvalidInjectionException invalidInjectionException) {
/*     */               throw d(null);
/*     */             }  
/*     */         } catch (InvalidInjectionException invalidInjectionException) {
/*     */           throw d(null);
/*     */         } 
/*     */       } 
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw d(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void injectAtInvoke(Target paramTarget, InjectionNodes.InjectionNode paramInjectionNode) {
/*     */     // Byte code:
/*     */     //   0: new org/spongepowered/asm/mixin/injection/invoke/RedirectInjector$RedirectedInvoke
/*     */     //   3: dup
/*     */     //   4: aload_1
/*     */     //   5: aload_2
/*     */     //   6: invokevirtual getCurrentTarget : ()Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;
/*     */     //   9: checkcast org/spongepowered/asm/lib/tree/MethodInsnNode
/*     */     //   12: invokespecial <init> : (Lorg/spongepowered/asm/mixin/injection/struct/Target;Lorg/spongepowered/asm/lib/tree/MethodInsnNode;)V
/*     */     //   15: astore_3
/*     */     //   16: aload_0
/*     */     //   17: aload_3
/*     */     //   18: invokevirtual validateParams : (Lorg/spongepowered/asm/mixin/injection/invoke/RedirectInjector$RedirectedInvoke;)V
/*     */     //   21: new org/spongepowered/asm/lib/tree/InsnList
/*     */     //   24: dup
/*     */     //   25: invokespecial <init> : ()V
/*     */     //   28: astore #4
/*     */     //   30: aload_3
/*     */     //   31: getfield locals : [Lorg/spongepowered/asm/lib/Type;
/*     */     //   34: invokestatic getArgsSize : ([Lorg/spongepowered/asm/lib/Type;)I
/*     */     //   37: iconst_1
/*     */     //   38: iadd
/*     */     //   39: istore #5
/*     */     //   41: iconst_1
/*     */     //   42: istore #6
/*     */     //   44: aload_0
/*     */     //   45: aload_1
/*     */     //   46: aload_3
/*     */     //   47: getfield locals : [Lorg/spongepowered/asm/lib/Type;
/*     */     //   50: aload #4
/*     */     //   52: iconst_0
/*     */     //   53: invokevirtual storeArgs : (Lorg/spongepowered/asm/mixin/injection/struct/Target;[Lorg/spongepowered/asm/lib/Type;Lorg/spongepowered/asm/lib/tree/InsnList;I)[I
/*     */     //   56: astore #7
/*     */     //   58: aload_3
/*     */     //   59: getfield captureTargetArgs : Z
/*     */     //   62: ifeq -> 109
/*     */     //   65: aload_1
/*     */     //   66: getfield arguments : [Lorg/spongepowered/asm/lib/Type;
/*     */     //   69: invokestatic getArgsSize : ([Lorg/spongepowered/asm/lib/Type;)I
/*     */     //   72: istore #8
/*     */     //   74: iload #5
/*     */     //   76: iload #8
/*     */     //   78: iadd
/*     */     //   79: istore #5
/*     */     //   81: iload #6
/*     */     //   83: iload #8
/*     */     //   85: iadd
/*     */     //   86: istore #6
/*     */     //   88: iconst_2
/*     */     //   89: anewarray [I
/*     */     //   92: dup
/*     */     //   93: iconst_0
/*     */     //   94: aload #7
/*     */     //   96: aastore
/*     */     //   97: dup
/*     */     //   98: iconst_1
/*     */     //   99: aload_1
/*     */     //   100: invokevirtual getArgIndices : ()[I
/*     */     //   103: aastore
/*     */     //   104: invokestatic concat : ([[I)[I
/*     */     //   107: astore #7
/*     */     //   109: aload_0
/*     */     //   110: aload_0
/*     */     //   111: getfield methodArgs : [Lorg/spongepowered/asm/lib/Type;
/*     */     //   114: aload #4
/*     */     //   116: aload #7
/*     */     //   118: invokevirtual invokeHandlerWithArgs : ([Lorg/spongepowered/asm/lib/Type;Lorg/spongepowered/asm/lib/tree/InsnList;[I)Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;
/*     */     //   121: astore #8
/*     */     //   123: aload_1
/*     */     //   124: aload_3
/*     */     //   125: getfield node : Lorg/spongepowered/asm/lib/tree/MethodInsnNode;
/*     */     //   128: aload #8
/*     */     //   130: aload #4
/*     */     //   132: invokevirtual replaceNode : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;Lorg/spongepowered/asm/lib/tree/InsnList;)V
/*     */     //   135: aload_1
/*     */     //   136: iload #5
/*     */     //   138: invokevirtual addToLocals : (I)V
/*     */     //   141: aload_1
/*     */     //   142: iload #6
/*     */     //   144: invokevirtual addToStack : (I)V
/*     */     //   147: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #171	-> 0
/*     */     //   #3	-> 16
/*     */     //   #115	-> 21
/*     */     //   #174	-> 30
/*     */     //   #264	-> 41
/*     */     //   #27	-> 44
/*     */     //   #228	-> 58
/*     */     //   #107	-> 65
/*     */     //   #244	-> 74
/*     */     //   #161	-> 81
/*     */     //   #70	-> 88
/*     */     //   #239	-> 109
/*     */     //   #6	-> 123
/*     */     //   #47	-> 135
/*     */     //   #12	-> 141
/*     */     //   #66	-> 147
/*     */   }
/*     */   
/*     */   private AbstractInsnNode injectAtGetField(InsnList paramInsnList, Target paramTarget, FieldInsnNode paramFieldInsnNode, boolean paramBoolean, Type paramType1, Type paramType2) {
/*     */     try {
/*     */     
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw d(null);
/*     */     } 
/*     */     String str = paramBoolean ? Bytecode.generateDescriptor(paramType2, new Object[0]) : Bytecode.generateDescriptor(paramType2, new Object[] { paramType1 });
/*     */     boolean bool = checkDescriptor(str, paramTarget, "getter");
/*     */     try {
/*     */       if (!this.isStatic)
/*     */         try {
/*     */           paramInsnList.add((AbstractInsnNode)new VarInsnNode(25, 0));
/*     */           if (!paramBoolean)
/*     */             paramInsnList.add((AbstractInsnNode)new InsnNode(95)); 
/*     */         } catch (InvalidInjectionException invalidInjectionException) {
/*     */           throw d(null);
/*     */         }  
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw d(null);
/*     */     } 
/*     */     try {
/*     */       if (bool) {
/*     */         pushArgs(paramTarget.arguments, paramInsnList, paramTarget.getArgIndices(), 0, paramTarget.arguments.length);
/*     */         paramTarget.addToStack(Bytecode.getArgsSize(paramTarget.arguments));
/*     */       } 
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw d(null);
/*     */     } 
/*     */     try {
/*     */     
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw d(null);
/*     */     } 
/*     */     paramTarget.addToStack(this.isStatic ? 0 : 1);
/*     */     return invokeHandler(paramInsnList);
/*     */   }
/*     */   
/*     */   private static String getGetArrayHandlerDescriptor(AbstractInsnNode paramAbstractInsnNode, Type paramType1, Type paramType2) {
/*     */     try {
/*     */       if (paramAbstractInsnNode != null)
/*     */         try {
/*     */           if (paramAbstractInsnNode.getOpcode() == 190)
/*     */             return Bytecode.generateDescriptor(Type.INT_TYPE, (Object[])getArrayArgs(paramType2, 0, new Type[0])); 
/*     */         } catch (InvalidInjectionException invalidInjectionException) {
/*     */           throw d(null);
/*     */         }  
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw d(null);
/*     */     } 
/*     */     return Bytecode.generateDescriptor(paramType1, (Object[])getArrayArgs(paramType2, 1, new Type[0]));
/*     */   }
/*     */   
/*     */   private RedirectInjector$ConstructorRedirectData getCtorRedirect(BeforeNew paramBeforeNew) {
/*     */     RedirectInjector$ConstructorRedirectData redirectInjector$ConstructorRedirectData = this.ctorRedirectors.get(paramBeforeNew);
/*     */     if (redirectInjector$ConstructorRedirectData == null) {
/*     */       redirectInjector$ConstructorRedirectData = new RedirectInjector$ConstructorRedirectData();
/*     */       this.ctorRedirectors.put(paramBeforeNew, redirectInjector$ConstructorRedirectData);
/*     */     } 
/*     */     return redirectInjector$ConstructorRedirectData;
/*     */   }
/*     */   
/*     */   protected void injectAtConstructor(Target paramTarget, InjectionNodes.InjectionNode paramInjectionNode) {
/*     */     RedirectInjector$ConstructorRedirectData redirectInjector$ConstructorRedirectData = (RedirectInjector$ConstructorRedirectData)paramInjectionNode.getDecoration("ctor");
/*     */     try {
/*     */       if (redirectInjector$ConstructorRedirectData == null)
/*     */         throw new InvalidInjectionException(this.info, String.format("%s ctor redirector has no metadata, the injector failed a preprocessing phase", new Object[] { this.annotationType })); 
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw d(null);
/*     */     } 
/*     */     TypeInsnNode typeInsnNode = (TypeInsnNode)paramInjectionNode.getCurrentTarget();
/*     */     AbstractInsnNode abstractInsnNode = paramTarget.get(paramTarget.indexOf((AbstractInsnNode)typeInsnNode) + 1);
/*     */     MethodInsnNode methodInsnNode = paramTarget.findInitNodeFor(typeInsnNode);
/*     */     try {
/*     */       if (methodInsnNode == null) {
/*     */         try {
/*     */           if (!redirectInjector$ConstructorRedirectData.wildcard)
/*     */             throw new InvalidInjectionException(this.info, String.format("%s ctor invocation was not found in %s", new Object[] { this.annotationType, paramTarget })); 
/*     */         } catch (InvalidInjectionException invalidInjectionException) {
/*     */           throw d(null);
/*     */         } 
/*     */         return;
/*     */       } 
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw d(null);
/*     */     } 
/*     */     try {
/*     */     
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw d(null);
/*     */     } 
/*     */     boolean bool = (abstractInsnNode.getOpcode() == 89) ? true : false;
/*     */     String str = methodInsnNode.desc.replace(")V", ")L" + typeInsnNode.desc + ";");
/*     */     boolean bool1 = false;
/*     */     try {
/*     */       bool1 = checkDescriptor(str, paramTarget, "constructor");
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       try {
/*     */         if (!redirectInjector$ConstructorRedirectData.wildcard)
/*     */           throw invalidInjectionException; 
/*     */       } catch (InvalidInjectionException invalidInjectionException1) {
/*     */         throw d(null);
/*     */       } 
/*     */       return;
/*     */     } 
/*     */     try {
/*     */       if (bool)
/*     */         paramTarget.removeNode(abstractInsnNode); 
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw d(null);
/*     */     } 
/*     */     try {
/*     */       if (this.isStatic) {
/*     */         paramTarget.removeNode((AbstractInsnNode)typeInsnNode);
/*     */       } else {
/*     */         paramTarget.replaceNode((AbstractInsnNode)typeInsnNode, (AbstractInsnNode)new VarInsnNode(25, 0));
/*     */       } 
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw d(null);
/*     */     } 
/*     */     InsnList insnList = new InsnList();
/*     */     try {
/*     */       if (bool1) {
/*     */         pushArgs(paramTarget.arguments, insnList, paramTarget.getArgIndices(), 0, paramTarget.arguments.length);
/*     */         paramTarget.addToStack(Bytecode.getArgsSize(paramTarget.arguments));
/*     */       } 
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw d(null);
/*     */     } 
/*     */     invokeHandler(insnList);
/*     */     if (bool) {
/*     */       LabelNode labelNode = new LabelNode();
/*     */       insnList.add((AbstractInsnNode)new InsnNode(89));
/*     */       insnList.add((AbstractInsnNode)new JumpInsnNode(199, labelNode));
/*     */       throwException(insnList, "java/lang/NullPointerException", String.format("%s constructor handler %s returned null for %s", new Object[] { this.annotationType, this, typeInsnNode.desc.replace('/', '.') }));
/*     */       insnList.add((AbstractInsnNode)labelNode);
/*     */     } 
/*     */     insnList.add((AbstractInsnNode)new InsnNode(87));
/*     */     paramTarget.replaceNode((AbstractInsnNode)methodInsnNode, insnList);
/*     */     redirectInjector$ConstructorRedirectData.injected++;
/*     */   }
/*     */   
/*     */   private AbstractInsnNode injectAtPutField(InsnList paramInsnList, Target paramTarget, FieldInsnNode paramFieldInsnNode, boolean paramBoolean, Type paramType1, Type paramType2) {
/*     */     // Byte code:
/*     */     //   0: iload #4
/*     */     //   2: ifeq -> 25
/*     */     //   5: aconst_null
/*     */     //   6: iconst_1
/*     */     //   7: anewarray java/lang/Object
/*     */     //   10: dup
/*     */     //   11: iconst_0
/*     */     //   12: aload #6
/*     */     //   14: aastore
/*     */     //   15: invokestatic generateDescriptor : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   18: goto -> 43
/*     */     //   21: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   24: athrow
/*     */     //   25: aconst_null
/*     */     //   26: iconst_2
/*     */     //   27: anewarray java/lang/Object
/*     */     //   30: dup
/*     */     //   31: iconst_0
/*     */     //   32: aload #5
/*     */     //   34: aastore
/*     */     //   35: dup
/*     */     //   36: iconst_1
/*     */     //   37: aload #6
/*     */     //   39: aastore
/*     */     //   40: invokestatic generateDescriptor : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   43: astore #7
/*     */     //   45: aload_0
/*     */     //   46: aload #7
/*     */     //   48: aload_2
/*     */     //   49: ldc 'setter'
/*     */     //   51: invokevirtual checkDescriptor : (Ljava/lang/String;Lorg/spongepowered/asm/mixin/injection/struct/Target;Ljava/lang/String;)Z
/*     */     //   54: istore #8
/*     */     //   56: aload_0
/*     */     //   57: getfield isStatic : Z
/*     */     //   60: ifne -> 187
/*     */     //   63: iload #4
/*     */     //   65: ifeq -> 109
/*     */     //   68: goto -> 75
/*     */     //   71: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   74: athrow
/*     */     //   75: aload_1
/*     */     //   76: new org/spongepowered/asm/lib/tree/VarInsnNode
/*     */     //   79: dup
/*     */     //   80: bipush #25
/*     */     //   82: iconst_0
/*     */     //   83: invokespecial <init> : (II)V
/*     */     //   86: invokevirtual add : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;)V
/*     */     //   89: aload_1
/*     */     //   90: new org/spongepowered/asm/lib/tree/InsnNode
/*     */     //   93: dup
/*     */     //   94: bipush #95
/*     */     //   96: invokespecial <init> : (I)V
/*     */     //   99: invokevirtual add : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;)V
/*     */     //   102: goto -> 187
/*     */     //   105: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   108: athrow
/*     */     //   109: aload_2
/*     */     //   110: aload #6
/*     */     //   112: invokevirtual getSize : ()I
/*     */     //   115: invokevirtual allocateLocals : (I)I
/*     */     //   118: istore #9
/*     */     //   120: aload_1
/*     */     //   121: new org/spongepowered/asm/lib/tree/VarInsnNode
/*     */     //   124: dup
/*     */     //   125: aload #6
/*     */     //   127: bipush #54
/*     */     //   129: invokevirtual getOpcode : (I)I
/*     */     //   132: iload #9
/*     */     //   134: invokespecial <init> : (II)V
/*     */     //   137: invokevirtual add : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;)V
/*     */     //   140: aload_1
/*     */     //   141: new org/spongepowered/asm/lib/tree/VarInsnNode
/*     */     //   144: dup
/*     */     //   145: bipush #25
/*     */     //   147: iconst_0
/*     */     //   148: invokespecial <init> : (II)V
/*     */     //   151: invokevirtual add : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;)V
/*     */     //   154: aload_1
/*     */     //   155: new org/spongepowered/asm/lib/tree/InsnNode
/*     */     //   158: dup
/*     */     //   159: bipush #95
/*     */     //   161: invokespecial <init> : (I)V
/*     */     //   164: invokevirtual add : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;)V
/*     */     //   167: aload_1
/*     */     //   168: new org/spongepowered/asm/lib/tree/VarInsnNode
/*     */     //   171: dup
/*     */     //   172: aload #6
/*     */     //   174: bipush #21
/*     */     //   176: invokevirtual getOpcode : (I)I
/*     */     //   179: iload #9
/*     */     //   181: invokespecial <init> : (II)V
/*     */     //   184: invokevirtual add : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;)V
/*     */     //   187: iload #8
/*     */     //   189: ifeq -> 229
/*     */     //   192: aload_0
/*     */     //   193: aload_2
/*     */     //   194: getfield arguments : [Lorg/spongepowered/asm/lib/Type;
/*     */     //   197: aload_1
/*     */     //   198: aload_2
/*     */     //   199: invokevirtual getArgIndices : ()[I
/*     */     //   202: iconst_0
/*     */     //   203: aload_2
/*     */     //   204: getfield arguments : [Lorg/spongepowered/asm/lib/Type;
/*     */     //   207: arraylength
/*     */     //   208: invokevirtual pushArgs : ([Lorg/spongepowered/asm/lib/Type;Lorg/spongepowered/asm/lib/tree/InsnList;[III)V
/*     */     //   211: aload_2
/*     */     //   212: aload_2
/*     */     //   213: getfield arguments : [Lorg/spongepowered/asm/lib/Type;
/*     */     //   216: invokestatic getArgsSize : ([Lorg/spongepowered/asm/lib/Type;)I
/*     */     //   219: invokevirtual addToStack : (I)V
/*     */     //   222: goto -> 229
/*     */     //   225: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   228: athrow
/*     */     //   229: aload_2
/*     */     //   230: aload_0
/*     */     //   231: getfield isStatic : Z
/*     */     //   234: ifne -> 257
/*     */     //   237: iload #4
/*     */     //   239: ifne -> 257
/*     */     //   242: goto -> 249
/*     */     //   245: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   248: athrow
/*     */     //   249: iconst_1
/*     */     //   250: goto -> 258
/*     */     //   253: invokestatic d : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   256: athrow
/*     */     //   257: iconst_0
/*     */     //   258: invokevirtual addToStack : (I)V
/*     */     //   261: aload_0
/*     */     //   262: aload_1
/*     */     //   263: invokevirtual invokeHandler : (Lorg/spongepowered/asm/lib/tree/InsnList;)Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;
/*     */     //   266: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #217	-> 0
/*     */     //   #103	-> 45
/*     */     //   #208	-> 56
/*     */     //   #186	-> 63
/*     */     //   #104	-> 75
/*     */     //   #22	-> 89
/*     */     //   #160	-> 109
/*     */     //   #225	-> 120
/*     */     //   #212	-> 140
/*     */     //   #273	-> 154
/*     */     //   #247	-> 167
/*     */     //   #159	-> 187
/*     */     //   #152	-> 192
/*     */     //   #37	-> 211
/*     */     //   #34	-> 229
/*     */     //   #179	-> 261
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   0	21	21	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   56	68	71	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   63	105	105	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   187	222	225	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   229	242	245	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   237	253	253	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */   }
/*     */   
/*     */   protected void validateParams(RedirectInjector$RedirectedInvoke paramRedirectInjector$RedirectedInvoke) {
/*     */     int i = this.methodArgs.length;
/*     */     String str = String.format("%s handler method %s", new Object[] { this.annotationType, this });
/*     */     try {
/*     */       if (!paramRedirectInjector$RedirectedInvoke.returnType.equals(this.returnType))
/*     */         throw new InvalidInjectionException(this.info, String.format("%s has an invalid signature. Expected return type %s found %s", new Object[] { str, this.returnType, paramRedirectInjector$RedirectedInvoke.returnType })); 
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw d(null);
/*     */     } 
/*     */     for (byte b = 0; b < i; ) {
/*     */       Type type1 = null;
/*     */       try {
/*     */         if (b >= this.methodArgs.length)
/*     */           throw new InvalidInjectionException(this.info, String.format("%s has an invalid signature. Not enough arguments found for capture of target method args, expected %d but found %d", new Object[] { str, Integer.valueOf(i), Integer.valueOf(this.methodArgs.length) })); 
/*     */       } catch (InvalidInjectionException invalidInjectionException) {
/*     */         throw d(null);
/*     */       } 
/*     */       Type type2 = this.methodArgs[b];
/*     */       if (b < paramRedirectInjector$RedirectedInvoke.locals.length) {
/*     */         type1 = paramRedirectInjector$RedirectedInvoke.locals[b];
/*     */       } else {
/*     */         paramRedirectInjector$RedirectedInvoke.captureTargetArgs = true;
/*     */         i = Math.max(i, paramRedirectInjector$RedirectedInvoke.locals.length + paramRedirectInjector$RedirectedInvoke.target.arguments.length);
/*     */         int j = b - paramRedirectInjector$RedirectedInvoke.locals.length;
/*     */         try {
/*     */           if (j >= paramRedirectInjector$RedirectedInvoke.target.arguments.length)
/*     */             throw new InvalidInjectionException(this.info, String.format("%s has an invalid signature. Found unexpected additional target argument with type %s at index %d", new Object[] { str, type2, Integer.valueOf(b) })); 
/*     */         } catch (InvalidInjectionException invalidInjectionException) {
/*     */           throw d(null);
/*     */         } 
/*     */         type1 = paramRedirectInjector$RedirectedInvoke.target.arguments[j];
/*     */       } 
/*     */       AnnotationNode annotationNode = Annotations.getInvisibleParameter(this.methodNode, Coerce.class, b);
/*     */       try {
/*     */         if (type2.equals(type1)) {
/*     */           try {
/*     */             if (annotationNode != null)
/*     */               try {
/*     */                 if (this.info.getContext().getOption(MixinEnvironment.Option.DEBUG_VERBOSE))
/*     */                   Injector.logger.warn("Redundant @Coerce on {} argument {}, {} is identical to {}", new Object[] { str, Integer.valueOf(b), type1, type2 }); 
/*     */               } catch (InvalidInjectionException invalidInjectionException) {
/*     */                 throw d(null);
/*     */               }  
/*     */           } catch (InvalidInjectionException invalidInjectionException) {
/*     */             throw d(null);
/*     */           } 
/*     */         } else {
/*     */           boolean bool = Injector.canCoerce(type2, type1);
/*     */           try {
/*     */             if (annotationNode == null) {
/*     */               (new Object[4])[0] = str;
/*     */               (new Object[4])[1] = type2;
/*     */               (new Object[4])[2] = Integer.valueOf(b);
/*     */               (new Object[4])[3] = type1;
/*     */             } 
/*     */           } catch (InvalidInjectionException invalidInjectionException) {
/*     */             throw d(null);
/*     */           } 
/*     */           try {
/*     */             if (!bool)
/*     */               throw new InvalidInjectionException(this.info, String.format("%s has an invalid signature. Cannot @Coerce argument type %s at index %d to %s", new Object[] { str, type1, Integer.valueOf(b), type2 })); 
/*     */           } catch (InvalidInjectionException invalidInjectionException) {
/*     */             throw d(null);
/*     */           } 
/*     */         } 
/*     */       } catch (InvalidInjectionException invalidInjectionException) {
/*     */         throw d(null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void injectAtGetArray(Target paramTarget, FieldInsnNode paramFieldInsnNode, AbstractInsnNode paramAbstractInsnNode, Type paramType1, Type paramType2) {
/*     */     String str = getGetArrayHandlerDescriptor(paramAbstractInsnNode, this.returnType, paramType2);
/*     */     boolean bool = checkDescriptor(str, paramTarget, "array getter");
/*     */     injectArrayRedirect(paramTarget, paramFieldInsnNode, paramAbstractInsnNode, bool, "array getter");
/*     */   }
/*     */   
/*     */   protected RedirectInjector(InjectionInfo paramInjectionInfo, String paramString) {
/*     */     super(paramInjectionInfo, paramString);
/*     */     int i = paramInjectionInfo.getContext().getPriority();
/*     */     try {
/*     */     
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw d(null);
/*     */     } 
/*     */     boolean bool = (Annotations.getVisible(this.methodNode, Final.class) != null) ? true : false;
/*     */     this.meta = new RedirectInjector$Meta(this, i, bool, this.info.toString(), this.methodNode.desc);
/*     */   }
/*     */   
/*     */   private static InvalidInjectionException d(InvalidInjectionException paramInvalidInjectionException) {
/*     */     return paramInvalidInjectionException;
/*     */   }
/*     */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\invoke\RedirectInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */