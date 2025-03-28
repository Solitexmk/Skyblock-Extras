/*  1 */ package org.spongepowered.asm.mixin.injection.points;@AtCode("INVOKE") public class BeforeInvoke extends InjectionPoint { public BeforeInvoke setLogging(boolean paramBoolean) { this.log = paramBoolean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*  8 */     return this; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected final MemberInfo target;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected final boolean allowPermissive;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected final int ordinal;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected final String className;
/*    */ 
/*    */ 
/*    */   
/*    */   protected final IMixinContext context;
/*    */ 
/*    */ 
/*    */   
/*    */   protected final Logger logger;
/*    */ 
/*    */ 
/*    */   
/*    */   private boolean log;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean matchesInsn(AbstractInsnNode paramAbstractInsnNode) {
/*    */     return paramAbstractInsnNode instanceof org.spongepowered.asm.lib.tree.MethodInsnNode;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean addInsn(InsnList paramInsnList, Collection<AbstractInsnNode> paramCollection, AbstractInsnNode paramAbstractInsnNode) {
/*    */     paramCollection.add(paramAbstractInsnNode);
/* 56 */     return true;
/*    */   }
/*    */   
/*    */   protected boolean find(String paramString, InsnList paramInsnList, Collection<AbstractInsnNode> paramCollection, MemberInfo paramMemberInfo, BeforeInvoke$SearchType paramBeforeInvoke$SearchType) {
/*    */     // Byte code:
/*    */     //   0: aload #4
/*    */     //   2: ifnonnull -> 11
/*    */     //   5: iconst_0
/*    */     //   6: ireturn
/*    */     //   7: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   10: athrow
/*    */     //   11: aload #5
/*    */     //   13: getstatic org/spongepowered/asm/mixin/injection/points/BeforeInvoke$SearchType.PERMISSIVE : Lorg/spongepowered/asm/mixin/injection/points/BeforeInvoke$SearchType;
/*    */     //   16: if_acmpne -> 32
/*    */     //   19: aload #4
/*    */     //   21: aconst_null
/*    */     //   22: invokevirtual transform : (Ljava/lang/String;)Lorg/spongepowered/asm/mixin/injection/struct/MemberInfo;
/*    */     //   25: goto -> 34
/*    */     //   28: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   31: athrow
/*    */     //   32: aload #4
/*    */     //   34: astore #6
/*    */     //   36: iconst_0
/*    */     //   37: istore #7
/*    */     //   39: iconst_0
/*    */     //   40: istore #8
/*    */     //   42: aload_2
/*    */     //   43: invokevirtual iterator : ()Ljava/util/ListIterator;
/*    */     //   46: astore #9
/*    */     //   48: aload #9
/*    */     //   50: invokeinterface hasNext : ()Z
/*    */     //   55: ifeq -> 253
/*    */     //   58: aload #9
/*    */     //   60: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   65: checkcast org/spongepowered/asm/lib/tree/AbstractInsnNode
/*    */     //   68: astore #10
/*    */     //   70: aload_0
/*    */     //   71: aload #10
/*    */     //   73: invokevirtual matchesInsn : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;)Z
/*    */     //   76: ifeq -> 242
/*    */     //   79: new org/spongepowered/asm/mixin/injection/struct/MemberInfo
/*    */     //   82: dup
/*    */     //   83: aload #10
/*    */     //   85: invokespecial <init> : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;)V
/*    */     //   88: astore #11
/*    */     //   90: aload_0
/*    */     //   91: ldc '{} is considering insn {}'
/*    */     //   93: iconst_2
/*    */     //   94: anewarray java/lang/Object
/*    */     //   97: dup
/*    */     //   98: iconst_0
/*    */     //   99: aload_0
/*    */     //   100: getfield className : Ljava/lang/String;
/*    */     //   103: aastore
/*    */     //   104: dup
/*    */     //   105: iconst_1
/*    */     //   106: aload #11
/*    */     //   108: aastore
/*    */     //   109: invokevirtual log : (Ljava/lang/String;[Ljava/lang/Object;)V
/*    */     //   112: aload #6
/*    */     //   114: aload #11
/*    */     //   116: getfield owner : Ljava/lang/String;
/*    */     //   119: aload #11
/*    */     //   121: getfield name : Ljava/lang/String;
/*    */     //   124: aload #11
/*    */     //   126: getfield desc : Ljava/lang/String;
/*    */     //   129: invokevirtual matches : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
/*    */     //   132: ifeq -> 242
/*    */     //   135: aload_0
/*    */     //   136: ldc '{} > found a matching insn, checking preconditions...'
/*    */     //   138: iconst_1
/*    */     //   139: anewarray java/lang/Object
/*    */     //   142: dup
/*    */     //   143: iconst_0
/*    */     //   144: aload_0
/*    */     //   145: getfield className : Ljava/lang/String;
/*    */     //   148: aastore
/*    */     //   149: invokevirtual log : (Ljava/lang/String;[Ljava/lang/Object;)V
/*    */     //   152: aload_0
/*    */     //   153: aload #11
/*    */     //   155: iload #7
/*    */     //   157: invokevirtual matchesInsn : (Lorg/spongepowered/asm/mixin/injection/struct/MemberInfo;I)Z
/*    */     //   160: ifeq -> 239
/*    */     //   163: goto -> 170
/*    */     //   166: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   169: athrow
/*    */     //   170: aload_0
/*    */     //   171: ldc '{} > > > found a matching insn at ordinal {}'
/*    */     //   173: iconst_2
/*    */     //   174: anewarray java/lang/Object
/*    */     //   177: dup
/*    */     //   178: iconst_0
/*    */     //   179: aload_0
/*    */     //   180: getfield className : Ljava/lang/String;
/*    */     //   183: aastore
/*    */     //   184: dup
/*    */     //   185: iconst_1
/*    */     //   186: iload #7
/*    */     //   188: invokestatic valueOf : (I)Ljava/lang/Integer;
/*    */     //   191: aastore
/*    */     //   192: invokevirtual log : (Ljava/lang/String;[Ljava/lang/Object;)V
/*    */     //   195: aload_0
/*    */     //   196: aload_2
/*    */     //   197: aload_3
/*    */     //   198: aload #10
/*    */     //   200: invokevirtual addInsn : (Lorg/spongepowered/asm/lib/tree/InsnList;Ljava/util/Collection;Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;)Z
/*    */     //   203: ifeq -> 223
/*    */     //   206: goto -> 213
/*    */     //   209: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   212: athrow
/*    */     //   213: iinc #8, 1
/*    */     //   216: goto -> 223
/*    */     //   219: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   222: athrow
/*    */     //   223: aload_0
/*    */     //   224: getfield ordinal : I
/*    */     //   227: iload #7
/*    */     //   229: if_icmpne -> 239
/*    */     //   232: goto -> 253
/*    */     //   235: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   238: athrow
/*    */     //   239: iinc #7, 1
/*    */     //   242: aload_0
/*    */     //   243: aload_1
/*    */     //   244: aload_2
/*    */     //   245: aload #10
/*    */     //   247: invokevirtual inspectInsn : (Ljava/lang/String;Lorg/spongepowered/asm/lib/tree/InsnList;Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;)V
/*    */     //   250: goto -> 48
/*    */     //   253: aload #5
/*    */     //   255: getstatic org/spongepowered/asm/mixin/injection/points/BeforeInvoke$SearchType.PERMISSIVE : Lorg/spongepowered/asm/mixin/injection/points/BeforeInvoke$SearchType;
/*    */     //   258: if_acmpne -> 323
/*    */     //   261: iload #8
/*    */     //   263: iconst_1
/*    */     //   264: if_icmple -> 323
/*    */     //   267: goto -> 274
/*    */     //   270: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   273: athrow
/*    */     //   274: aload_0
/*    */     //   275: getfield logger : Lorg/apache/logging/log4j/Logger;
/*    */     //   278: ldc 'A permissive match for {} using "{}" in {} matched {} instructions, this may cause unexpected behaviour. To inhibit permissive search set mixin.env.allowPermissiveMatch=false'
/*    */     //   280: iconst_4
/*    */     //   281: anewarray java/lang/Object
/*    */     //   284: dup
/*    */     //   285: iconst_0
/*    */     //   286: aload_0
/*    */     //   287: getfield className : Ljava/lang/String;
/*    */     //   290: aastore
/*    */     //   291: dup
/*    */     //   292: iconst_1
/*    */     //   293: aload #4
/*    */     //   295: aastore
/*    */     //   296: dup
/*    */     //   297: iconst_2
/*    */     //   298: aload_0
/*    */     //   299: getfield context : Lorg/spongepowered/asm/mixin/refmap/IMixinContext;
/*    */     //   302: aastore
/*    */     //   303: dup
/*    */     //   304: iconst_3
/*    */     //   305: iload #8
/*    */     //   307: invokestatic valueOf : (I)Ljava/lang/Integer;
/*    */     //   310: aastore
/*    */     //   311: invokeinterface warn : (Ljava/lang/String;[Ljava/lang/Object;)V
/*    */     //   316: goto -> 323
/*    */     //   319: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   322: athrow
/*    */     //   323: iload #8
/*    */     //   325: ifle -> 336
/*    */     //   328: iconst_1
/*    */     //   329: goto -> 337
/*    */     //   332: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   335: athrow
/*    */     //   336: iconst_0
/*    */     //   337: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     //   #49	-> 5
/*    */     //   #20	-> 11
/*    */     //   #39	-> 36
/*    */     //   #42	-> 39
/*    */     //   #54	-> 42
/*    */     //   #45	-> 48
/*    */     //   #28	-> 58
/*    */     //   #25	-> 70
/*    */     //   #5	-> 79
/*    */     //   #10	-> 90
/*    */     //   #17	-> 112
/*    */     //   #4	-> 135
/*    */     //   #15	-> 152
/*    */     //   #24	-> 170
/*    */     //   #50	-> 195
/*    */     //   #36	-> 213
/*    */     //   #47	-> 223
/*    */     //   #40	-> 232
/*    */     //   #29	-> 239
/*    */     //   #35	-> 242
/*    */     //   #43	-> 250
/*    */     //   #14	-> 253
/*    */     //   #6	-> 274
/*    */     //   #38	-> 307
/*    */     //   #12	-> 311
/*    */     //   #23	-> 323
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   0	7	7	java/lang/RuntimeException
/*    */     //   11	28	28	java/lang/RuntimeException
/*    */     //   90	163	166	java/lang/RuntimeException
/*    */     //   135	206	209	java/lang/RuntimeException
/*    */     //   170	216	219	java/lang/RuntimeException
/*    */     //   223	235	235	java/lang/RuntimeException
/*    */     //   253	267	270	java/lang/RuntimeException
/*    */     //   261	316	319	java/lang/RuntimeException
/*    */     //   323	332	332	java/lang/RuntimeException
/*    */   }
/*    */   
/*    */   private String getClassName() {
/*    */     InjectionPoint.AtCode atCode = getClass().<InjectionPoint.AtCode>getAnnotation(InjectionPoint.AtCode.class);
/*    */     try {
/*    */     
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return String.format("@At(%s)", new Object[] { (atCode != null) ? atCode.value() : getClass().getSimpleName().toUpperCase() });
/*    */   }
/*    */   
/*    */   protected void inspectInsn(String paramString, InsnList paramInsnList, AbstractInsnNode paramAbstractInsnNode) {}
/*    */   
/*    */   protected boolean matchesInsn(MemberInfo paramMemberInfo, int paramInt) {
/*    */     try {
/*    */       log("{} > > comparing target ordinal {} with current ordinal {}", new Object[] { this.className, Integer.valueOf(this.ordinal), Integer.valueOf(paramInt) });
/*    */       if (this.ordinal != -1) {
/*    */         try {
/*    */           if (this.ordinal == paramInt);
/*    */         } catch (RuntimeException runtimeException) {
/*    */           throw b(null);
/*    */         } 
/*    */         return false;
/*    */       } 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean find(String paramString, InsnList paramInsnList, Collection<AbstractInsnNode> paramCollection) {
/*    */     try {
/*    */       log("{} is searching for an injection point in method with descriptor {}", new Object[] { this.className, paramString });
/*    */       if (!find(paramString, paramInsnList, paramCollection, this.target, BeforeInvoke$SearchType.STRICT))
/*    */         try {
/*    */           if (this.target.desc != null)
/*    */             try {
/*    */               if (this.allowPermissive) {
/*    */                 this.logger.warn("STRICT match for {} using \"{}\" in {} returned 0 results, attempting permissive search. To inhibit permissive search set mixin.env.allowPermissiveMatch=false", new Object[] { this.className, this.target, this.context });
/*    */                 return find(paramString, paramInsnList, paramCollection, this.target, BeforeInvoke$SearchType.PERMISSIVE);
/*    */               } 
/*    */             } catch (RuntimeException runtimeException) {
/*    */               throw b(null);
/*    */             }  
/*    */         } catch (RuntimeException runtimeException) {
/*    */           throw b(null);
/*    */         }  
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return true;
/*    */   }
/*    */   
/*    */   public BeforeInvoke(InjectionPointData paramInjectionPointData) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: invokespecial <init> : (Lorg/spongepowered/asm/mixin/injection/struct/InjectionPointData;)V
/*    */     //   5: aload_0
/*    */     //   6: ldc 'mixin'
/*    */     //   8: invokestatic getLogger : (Ljava/lang/String;)Lorg/apache/logging/log4j/Logger;
/*    */     //   11: putfield logger : Lorg/apache/logging/log4j/Logger;
/*    */     //   14: aload_0
/*    */     //   15: iconst_0
/*    */     //   16: putfield log : Z
/*    */     //   19: aload_0
/*    */     //   20: aload_1
/*    */     //   21: invokevirtual getTarget : ()Lorg/spongepowered/asm/mixin/injection/struct/MemberInfo;
/*    */     //   24: putfield target : Lorg/spongepowered/asm/mixin/injection/struct/MemberInfo;
/*    */     //   27: aload_0
/*    */     //   28: aload_1
/*    */     //   29: invokevirtual getOrdinal : ()I
/*    */     //   32: putfield ordinal : I
/*    */     //   35: aload_0
/*    */     //   36: aload_1
/*    */     //   37: ldc 'log'
/*    */     //   39: iconst_0
/*    */     //   40: invokevirtual get : (Ljava/lang/String;Z)Z
/*    */     //   43: putfield log : Z
/*    */     //   46: aload_0
/*    */     //   47: aload_0
/*    */     //   48: invokespecial getClassName : ()Ljava/lang/String;
/*    */     //   51: putfield className : Ljava/lang/String;
/*    */     //   54: aload_0
/*    */     //   55: aload_1
/*    */     //   56: invokevirtual getContext : ()Lorg/spongepowered/asm/mixin/refmap/IMixinContext;
/*    */     //   59: putfield context : Lorg/spongepowered/asm/mixin/refmap/IMixinContext;
/*    */     //   62: aload_0
/*    */     //   63: aload_0
/*    */     //   64: getfield context : Lorg/spongepowered/asm/mixin/refmap/IMixinContext;
/*    */     //   67: getstatic org/spongepowered/asm/mixin/MixinEnvironment$Option.REFMAP_REMAP : Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;
/*    */     //   70: invokeinterface getOption : (Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;)Z
/*    */     //   75: ifeq -> 125
/*    */     //   78: aload_0
/*    */     //   79: getfield context : Lorg/spongepowered/asm/mixin/refmap/IMixinContext;
/*    */     //   82: getstatic org/spongepowered/asm/mixin/MixinEnvironment$Option.REFMAP_REMAP_ALLOW_PERMISSIVE : Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;
/*    */     //   85: invokeinterface getOption : (Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;)Z
/*    */     //   90: ifeq -> 125
/*    */     //   93: aload_0
/*    */     //   94: getfield context : Lorg/spongepowered/asm/mixin/refmap/IMixinContext;
/*    */     //   97: invokeinterface getReferenceMapper : ()Lorg/spongepowered/asm/mixin/refmap/IReferenceMapper;
/*    */     //   102: invokeinterface isDefault : ()Z
/*    */     //   107: ifne -> 125
/*    */     //   110: goto -> 117
/*    */     //   113: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   116: athrow
/*    */     //   117: iconst_1
/*    */     //   118: goto -> 126
/*    */     //   121: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   124: athrow
/*    */     //   125: iconst_0
/*    */     //   126: putfield allowPermissive : Z
/*    */     //   129: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #51	-> 0
/*    */     //   #31	-> 5
/*    */     //   #52	-> 14
/*    */     //   #32	-> 19
/*    */     //   #26	-> 27
/*    */     //   #9	-> 35
/*    */     //   #19	-> 46
/*    */     //   #46	-> 54
/*    */     //   #13	-> 62
/*    */     //   #37	-> 97
/*    */     //   #53	-> 129
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   78	110	113	java/lang/RuntimeException
/*    */     //   93	121	121	java/lang/RuntimeException
/*    */   }
/*    */   
/*    */   protected void log(String paramString, Object... paramVarArgs) {
/*    */     try {
/*    */       if (this.log)
/*    */         this.logger.info(paramString, paramVarArgs); 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\points\BeforeInvoke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */