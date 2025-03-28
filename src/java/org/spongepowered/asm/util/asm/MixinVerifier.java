/*    */ package org.spongepowered.asm.util.asm;public class MixinVerifier extends SimpleVerifier { private Type currentClass; private Type currentSuperClass;
/*    */   protected boolean isInterface(Type paramType) {
/*    */     try {
/*  4 */       if (this.currentClass != null) try { if (paramType.equals(this.currentClass))
/*    */           {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */             
/* 15 */             return this.isInterface; }  } catch (RuntimeException runtimeException) { throw b(null); }
/*    */       
/*    */     
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/* 21 */     return ClassInfo.forType(paramType).isInterface();
/*    */   } private List<Type> currentClassInterfaces; private boolean isInterface;
/*    */   protected boolean isAssignableFrom(Type paramType1, Type paramType2) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: aload_2
/*    */     //   2: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   5: ifeq -> 14
/*    */     //   8: iconst_1
/*    */     //   9: ireturn
/*    */     //   10: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   13: athrow
/*    */     //   14: aload_0
/*    */     //   15: getfield currentClass : Lorg/spongepowered/asm/lib/Type;
/*    */     //   18: ifnull -> 120
/*    */     //   21: aload_1
/*    */     //   22: aload_0
/*    */     //   23: getfield currentClass : Lorg/spongepowered/asm/lib/Type;
/*    */     //   26: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   29: ifeq -> 120
/*    */     //   32: goto -> 39
/*    */     //   35: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   38: athrow
/*    */     //   39: aload_0
/*    */     //   40: aload_2
/*    */     //   41: invokevirtual getSuperClass : (Lorg/spongepowered/asm/lib/Type;)Lorg/spongepowered/asm/lib/Type;
/*    */     //   44: ifnonnull -> 60
/*    */     //   47: goto -> 54
/*    */     //   50: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   53: athrow
/*    */     //   54: iconst_0
/*    */     //   55: ireturn
/*    */     //   56: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   59: athrow
/*    */     //   60: aload_0
/*    */     //   61: getfield isInterface : Z
/*    */     //   64: ifeq -> 109
/*    */     //   67: aload_2
/*    */     //   68: invokevirtual getSort : ()I
/*    */     //   71: bipush #10
/*    */     //   73: if_icmpeq -> 99
/*    */     //   76: goto -> 83
/*    */     //   79: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   82: athrow
/*    */     //   83: aload_2
/*    */     //   84: invokevirtual getSort : ()I
/*    */     //   87: bipush #9
/*    */     //   89: if_icmpne -> 107
/*    */     //   92: goto -> 99
/*    */     //   95: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   98: athrow
/*    */     //   99: iconst_1
/*    */     //   100: goto -> 108
/*    */     //   103: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   106: athrow
/*    */     //   107: iconst_0
/*    */     //   108: ireturn
/*    */     //   109: aload_0
/*    */     //   110: aload_1
/*    */     //   111: aload_0
/*    */     //   112: aload_2
/*    */     //   113: invokevirtual getSuperClass : (Lorg/spongepowered/asm/lib/Type;)Lorg/spongepowered/asm/lib/Type;
/*    */     //   116: invokevirtual isAssignableFrom : (Lorg/spongepowered/asm/lib/Type;Lorg/spongepowered/asm/lib/Type;)Z
/*    */     //   119: ireturn
/*    */     //   120: aload_0
/*    */     //   121: getfield currentClass : Lorg/spongepowered/asm/lib/Type;
/*    */     //   124: ifnull -> 231
/*    */     //   127: aload_2
/*    */     //   128: aload_0
/*    */     //   129: getfield currentClass : Lorg/spongepowered/asm/lib/Type;
/*    */     //   132: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   135: ifeq -> 231
/*    */     //   138: goto -> 145
/*    */     //   141: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   144: athrow
/*    */     //   145: aload_0
/*    */     //   146: aload_1
/*    */     //   147: aload_0
/*    */     //   148: getfield currentSuperClass : Lorg/spongepowered/asm/lib/Type;
/*    */     //   151: invokevirtual isAssignableFrom : (Lorg/spongepowered/asm/lib/Type;Lorg/spongepowered/asm/lib/Type;)Z
/*    */     //   154: ifeq -> 170
/*    */     //   157: goto -> 164
/*    */     //   160: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   163: athrow
/*    */     //   164: iconst_1
/*    */     //   165: ireturn
/*    */     //   166: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   169: athrow
/*    */     //   170: aload_0
/*    */     //   171: getfield currentClassInterfaces : Ljava/util/List;
/*    */     //   174: ifnull -> 229
/*    */     //   177: iconst_0
/*    */     //   178: istore_3
/*    */     //   179: iload_3
/*    */     //   180: aload_0
/*    */     //   181: getfield currentClassInterfaces : Ljava/util/List;
/*    */     //   184: invokeinterface size : ()I
/*    */     //   189: if_icmpge -> 229
/*    */     //   192: aload_0
/*    */     //   193: getfield currentClassInterfaces : Ljava/util/List;
/*    */     //   196: iload_3
/*    */     //   197: invokeinterface get : (I)Ljava/lang/Object;
/*    */     //   202: checkcast org/spongepowered/asm/lib/Type
/*    */     //   205: astore #4
/*    */     //   207: aload_0
/*    */     //   208: aload_1
/*    */     //   209: aload #4
/*    */     //   211: invokevirtual isAssignableFrom : (Lorg/spongepowered/asm/lib/Type;Lorg/spongepowered/asm/lib/Type;)Z
/*    */     //   214: ifeq -> 223
/*    */     //   217: iconst_1
/*    */     //   218: ireturn
/*    */     //   219: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   222: athrow
/*    */     //   223: iinc #3, 1
/*    */     //   226: goto -> 179
/*    */     //   229: iconst_0
/*    */     //   230: ireturn
/*    */     //   231: aload_1
/*    */     //   232: invokestatic forType : (Lorg/spongepowered/asm/lib/Type;)Lorg/spongepowered/asm/mixin/transformer/ClassInfo;
/*    */     //   235: astore_3
/*    */     //   236: aload_3
/*    */     //   237: ifnonnull -> 246
/*    */     //   240: iconst_0
/*    */     //   241: ireturn
/*    */     //   242: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   245: athrow
/*    */     //   246: aload_3
/*    */     //   247: invokevirtual isInterface : ()Z
/*    */     //   250: ifeq -> 259
/*    */     //   253: ldc 'java/lang/Object'
/*    */     //   255: invokestatic forName : (Ljava/lang/String;)Lorg/spongepowered/asm/mixin/transformer/ClassInfo;
/*    */     //   258: astore_3
/*    */     //   259: aload_2
/*    */     //   260: invokestatic forType : (Lorg/spongepowered/asm/lib/Type;)Lorg/spongepowered/asm/mixin/transformer/ClassInfo;
/*    */     //   263: aload_3
/*    */     //   264: invokevirtual hasSuperClass : (Lorg/spongepowered/asm/mixin/transformer/ClassInfo;)Z
/*    */     //   267: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     //   #26	-> 8
/*    */     //   #16	-> 14
/*    */     //   #3	-> 39
/*    */     //   #31	-> 54
/*    */     //   #12	-> 60
/*    */     //   #34	-> 67
/*    */     //   #7	-> 109
/*    */     //   #13	-> 120
/*    */     //   #25	-> 145
/*    */     //   #10	-> 164
/*    */     //   #11	-> 170
/*    */     //   #30	-> 177
/*    */     //   #27	-> 192
/*    */     //   #24	-> 207
/*    */     //   #18	-> 217
/*    */     //   #6	-> 223
/*    */     //   #14	-> 229
/*    */     //   #19	-> 231
/*    */     //   #22	-> 236
/*    */     //   #29	-> 240
/*    */     //   #9	-> 246
/*    */     //   #23	-> 253
/*    */     //   #33	-> 259
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   0	10	10	java/lang/RuntimeException
/*    */     //   14	32	35	java/lang/RuntimeException
/*    */     //   21	47	50	java/lang/RuntimeException
/*    */     //   39	56	56	java/lang/RuntimeException
/*    */     //   60	76	79	java/lang/RuntimeException
/*    */     //   67	92	95	java/lang/RuntimeException
/*    */     //   83	103	103	java/lang/RuntimeException
/*    */     //   120	138	141	java/lang/RuntimeException
/*    */     //   127	157	160	java/lang/RuntimeException
/*    */     //   145	166	166	java/lang/RuntimeException
/*    */     //   207	219	219	java/lang/RuntimeException
/*    */     //   236	242	242	java/lang/RuntimeException
/*    */   }
/*    */   protected Type getSuperClass(Type paramType) {
/*    */     
/* 28 */     try { if (this.currentClass != null) try { if (paramType.equals(this.currentClass))
/*    */           {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */             
/* 36 */             return this.currentSuperClass; }  } catch (RuntimeException runtimeException) { throw b(null); }   } catch (RuntimeException runtimeException) { throw b(null); }  ClassInfo classInfo = ClassInfo.forType(paramType).getSuperClass(); try {  }
/* 37 */     catch (RuntimeException runtimeException) { throw b(null); }  return (classInfo == null) ? null : Type.getType("L" + classInfo.getName() + ";");
/*    */   }
/*    */   
/*    */   public MixinVerifier(Type paramType1, Type paramType2, List<Type> paramList, boolean paramBoolean) {
/*    */     super(paramType1, paramType2, paramList, paramBoolean);
/*    */     this.currentClass = paramType1;
/*    */     this.currentSuperClass = paramType2;
/*    */     this.currentClassInterfaces = paramList;
/*    */     this.isInterface = paramBoolean;
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\asm\MixinVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */