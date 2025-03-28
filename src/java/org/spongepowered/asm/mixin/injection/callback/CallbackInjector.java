/*     */ package org.spongepowered.asm.mixin.injection.callback;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.spongepowered.asm.lib.Type;
/*     */ import org.spongepowered.asm.lib.tree.AbstractInsnNode;
/*     */ import org.spongepowered.asm.lib.tree.InsnList;
/*     */ import org.spongepowered.asm.lib.tree.MethodNode;
/*     */ import org.spongepowered.asm.lib.tree.VarInsnNode;
/*     */ import org.spongepowered.asm.mixin.injection.InjectionPoint;
/*     */ import org.spongepowered.asm.mixin.injection.struct.InjectionNodes;
/*     */ import org.spongepowered.asm.mixin.injection.struct.Target;
/*     */ import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;
/*     */ 
/*     */ public class CallbackInjector extends Injector {
/*     */   private final boolean cancellable;
/*     */   private final LocalCapture localCapture;
/*     */   private final String identifier;
/*     */   private final Map<Integer, String> ids;
/*     */   private int totalInjections;
/*     */   private int callbackInfoVar;
/*     */   private String lastId;
/*     */   private String lastDesc;
/*     */   private Target lastTarget;
/*     */   private String callbackInfoClass;
/*     */   
/*     */   private void printLocals(CallbackInjector$Callback paramCallbackInjector$Callback) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: invokevirtual getDescriptorWithAllLocals : ()Ljava/lang/String;
/*     */     //   4: invokestatic getArgumentTypes : (Ljava/lang/String;)[Lorg/spongepowered/asm/lib/Type;
/*     */     //   7: astore_2
/*     */     //   8: new org/spongepowered/asm/util/SignaturePrinter
/*     */     //   11: dup
/*     */     //   12: aload_1
/*     */     //   13: getfield target : Lorg/spongepowered/asm/mixin/injection/struct/Target;
/*     */     //   16: getfield method : Lorg/spongepowered/asm/lib/tree/MethodNode;
/*     */     //   19: aload_1
/*     */     //   20: getfield argNames : [Ljava/lang/String;
/*     */     //   23: invokespecial <init> : (Lorg/spongepowered/asm/lib/tree/MethodNode;[Ljava/lang/String;)V
/*     */     //   26: astore_3
/*     */     //   27: new org/spongepowered/asm/util/SignaturePrinter
/*     */     //   30: dup
/*     */     //   31: aload_0
/*     */     //   32: getfield methodNode : Lorg/spongepowered/asm/lib/tree/MethodNode;
/*     */     //   35: getfield name : Ljava/lang/String;
/*     */     //   38: aload_1
/*     */     //   39: getfield target : Lorg/spongepowered/asm/mixin/injection/struct/Target;
/*     */     //   42: getfield returnType : Lorg/spongepowered/asm/lib/Type;
/*     */     //   45: aload_2
/*     */     //   46: aload_1
/*     */     //   47: getfield argNames : [Ljava/lang/String;
/*     */     //   50: invokespecial <init> : (Ljava/lang/String;Lorg/spongepowered/asm/lib/Type;[Lorg/spongepowered/asm/lib/Type;[Ljava/lang/String;)V
/*     */     //   53: astore #4
/*     */     //   55: aload #4
/*     */     //   57: aload_0
/*     */     //   58: getfield methodNode : Lorg/spongepowered/asm/lib/tree/MethodNode;
/*     */     //   61: invokevirtual setModifiers : (Lorg/spongepowered/asm/lib/tree/MethodNode;)V
/*     */     //   64: new org/spongepowered/asm/util/PrettyPrinter
/*     */     //   67: dup
/*     */     //   68: invokespecial <init> : ()V
/*     */     //   71: astore #5
/*     */     //   73: aload #5
/*     */     //   75: ldc 'Target Class'
/*     */     //   77: aload_0
/*     */     //   78: getfield classNode : Lorg/spongepowered/asm/lib/tree/ClassNode;
/*     */     //   81: getfield name : Ljava/lang/String;
/*     */     //   84: bipush #47
/*     */     //   86: bipush #46
/*     */     //   88: invokevirtual replace : (CC)Ljava/lang/String;
/*     */     //   91: invokevirtual kv : (Ljava/lang/String;Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   94: pop
/*     */     //   95: aload #5
/*     */     //   97: ldc 'Target Method'
/*     */     //   99: aload_3
/*     */     //   100: invokevirtual kv : (Ljava/lang/String;Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   103: pop
/*     */     //   104: aload #5
/*     */     //   106: ldc 'Target Max LOCALS'
/*     */     //   108: aload_1
/*     */     //   109: getfield target : Lorg/spongepowered/asm/mixin/injection/struct/Target;
/*     */     //   112: invokevirtual getMaxLocals : ()I
/*     */     //   115: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   118: invokevirtual kv : (Ljava/lang/String;Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   121: pop
/*     */     //   122: aload #5
/*     */     //   124: ldc 'Initial Frame Size'
/*     */     //   126: aload_1
/*     */     //   127: getfield frameSize : I
/*     */     //   130: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   133: invokevirtual kv : (Ljava/lang/String;Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   136: pop
/*     */     //   137: aload #5
/*     */     //   139: ldc 'Callback Name'
/*     */     //   141: aload_0
/*     */     //   142: getfield methodNode : Lorg/spongepowered/asm/lib/tree/MethodNode;
/*     */     //   145: getfield name : Ljava/lang/String;
/*     */     //   148: invokevirtual kv : (Ljava/lang/String;Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   151: pop
/*     */     //   152: aload #5
/*     */     //   154: ldc 'Instruction'
/*     */     //   156: ldc '%s %s'
/*     */     //   158: iconst_2
/*     */     //   159: anewarray java/lang/Object
/*     */     //   162: dup
/*     */     //   163: iconst_0
/*     */     //   164: aload_1
/*     */     //   165: getfield node : Lorg/spongepowered/asm/mixin/injection/struct/InjectionNodes$InjectionNode;
/*     */     //   168: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   171: invokevirtual getSimpleName : ()Ljava/lang/String;
/*     */     //   174: aastore
/*     */     //   175: dup
/*     */     //   176: iconst_1
/*     */     //   177: aload_1
/*     */     //   178: getfield node : Lorg/spongepowered/asm/mixin/injection/struct/InjectionNodes$InjectionNode;
/*     */     //   181: invokevirtual getCurrentTarget : ()Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;
/*     */     //   184: invokevirtual getOpcode : ()I
/*     */     //   187: invokestatic getOpcodeName : (I)Ljava/lang/String;
/*     */     //   190: aastore
/*     */     //   191: invokevirtual kv : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   194: pop
/*     */     //   195: aload #5
/*     */     //   197: invokevirtual hr : ()Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   200: pop
/*     */     //   201: aload_1
/*     */     //   202: getfield locals : [Lorg/spongepowered/asm/lib/tree/LocalVariableNode;
/*     */     //   205: arraylength
/*     */     //   206: aload_1
/*     */     //   207: getfield frameSize : I
/*     */     //   210: if_icmple -> 496
/*     */     //   213: aload #5
/*     */     //   215: ldc '  %s  %20s  %s'
/*     */     //   217: iconst_3
/*     */     //   218: anewarray java/lang/Object
/*     */     //   221: dup
/*     */     //   222: iconst_0
/*     */     //   223: ldc 'LOCAL'
/*     */     //   225: aastore
/*     */     //   226: dup
/*     */     //   227: iconst_1
/*     */     //   228: ldc 'TYPE'
/*     */     //   230: aastore
/*     */     //   231: dup
/*     */     //   232: iconst_2
/*     */     //   233: ldc 'NAME'
/*     */     //   235: aastore
/*     */     //   236: invokevirtual add : (Ljava/lang/String;[Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   239: pop
/*     */     //   240: iconst_0
/*     */     //   241: istore #6
/*     */     //   243: iload #6
/*     */     //   245: aload_1
/*     */     //   246: getfield locals : [Lorg/spongepowered/asm/lib/tree/LocalVariableNode;
/*     */     //   249: arraylength
/*     */     //   250: if_icmpge -> 490
/*     */     //   253: iload #6
/*     */     //   255: aload_1
/*     */     //   256: getfield frameSize : I
/*     */     //   259: if_icmpne -> 278
/*     */     //   262: goto -> 269
/*     */     //   265: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   268: athrow
/*     */     //   269: ldc '>'
/*     */     //   271: goto -> 280
/*     */     //   274: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   277: athrow
/*     */     //   278: ldc ' '
/*     */     //   280: astore #7
/*     */     //   282: aload_1
/*     */     //   283: getfield locals : [Lorg/spongepowered/asm/lib/tree/LocalVariableNode;
/*     */     //   286: iload #6
/*     */     //   288: aaload
/*     */     //   289: ifnull -> 382
/*     */     //   292: aload #5
/*     */     //   294: ldc '%s [%3d]  %20s  %-50s %s'
/*     */     //   296: iconst_5
/*     */     //   297: anewarray java/lang/Object
/*     */     //   300: dup
/*     */     //   301: iconst_0
/*     */     //   302: aload #7
/*     */     //   304: aastore
/*     */     //   305: dup
/*     */     //   306: iconst_1
/*     */     //   307: iload #6
/*     */     //   309: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   312: aastore
/*     */     //   313: dup
/*     */     //   314: iconst_2
/*     */     //   315: aload_1
/*     */     //   316: getfield localTypes : [Lorg/spongepowered/asm/lib/Type;
/*     */     //   319: iload #6
/*     */     //   321: aaload
/*     */     //   322: iconst_0
/*     */     //   323: invokestatic getTypeName : (Lorg/spongepowered/asm/lib/Type;Z)Ljava/lang/String;
/*     */     //   326: aastore
/*     */     //   327: dup
/*     */     //   328: iconst_3
/*     */     //   329: iload #6
/*     */     //   331: aload_1
/*     */     //   332: getfield locals : [Lorg/spongepowered/asm/lib/tree/LocalVariableNode;
/*     */     //   335: iload #6
/*     */     //   337: aaload
/*     */     //   338: getfield name : Ljava/lang/String;
/*     */     //   341: invokestatic meltSnowman : (ILjava/lang/String;)Ljava/lang/String;
/*     */     //   344: aastore
/*     */     //   345: dup
/*     */     //   346: iconst_4
/*     */     //   347: iload #6
/*     */     //   349: aload_1
/*     */     //   350: getfield frameSize : I
/*     */     //   353: if_icmplt -> 372
/*     */     //   356: goto -> 363
/*     */     //   359: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   362: athrow
/*     */     //   363: ldc '<capture>'
/*     */     //   365: goto -> 374
/*     */     //   368: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   371: athrow
/*     */     //   372: ldc ''
/*     */     //   374: aastore
/*     */     //   375: invokevirtual add : (Ljava/lang/String;[Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   378: pop
/*     */     //   379: goto -> 484
/*     */     //   382: iload #6
/*     */     //   384: ifle -> 437
/*     */     //   387: aload_1
/*     */     //   388: getfield localTypes : [Lorg/spongepowered/asm/lib/Type;
/*     */     //   391: iload #6
/*     */     //   393: iconst_1
/*     */     //   394: isub
/*     */     //   395: aaload
/*     */     //   396: ifnull -> 437
/*     */     //   399: goto -> 406
/*     */     //   402: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   405: athrow
/*     */     //   406: aload_1
/*     */     //   407: getfield localTypes : [Lorg/spongepowered/asm/lib/Type;
/*     */     //   410: iload #6
/*     */     //   412: iconst_1
/*     */     //   413: isub
/*     */     //   414: aaload
/*     */     //   415: invokevirtual getSize : ()I
/*     */     //   418: iconst_1
/*     */     //   419: if_icmple -> 437
/*     */     //   422: goto -> 429
/*     */     //   425: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   428: athrow
/*     */     //   429: iconst_1
/*     */     //   430: goto -> 438
/*     */     //   433: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   436: athrow
/*     */     //   437: iconst_0
/*     */     //   438: istore #8
/*     */     //   440: aload #5
/*     */     //   442: ldc '%s [%3d]  %20s'
/*     */     //   444: iconst_3
/*     */     //   445: anewarray java/lang/Object
/*     */     //   448: dup
/*     */     //   449: iconst_0
/*     */     //   450: aload #7
/*     */     //   452: aastore
/*     */     //   453: dup
/*     */     //   454: iconst_1
/*     */     //   455: iload #6
/*     */     //   457: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   460: aastore
/*     */     //   461: dup
/*     */     //   462: iconst_2
/*     */     //   463: iload #8
/*     */     //   465: ifeq -> 477
/*     */     //   468: ldc '<top>'
/*     */     //   470: goto -> 479
/*     */     //   473: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   476: athrow
/*     */     //   477: ldc '-'
/*     */     //   479: aastore
/*     */     //   480: invokevirtual add : (Ljava/lang/String;[Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   483: pop
/*     */     //   484: iinc #6, 1
/*     */     //   487: goto -> 243
/*     */     //   490: aload #5
/*     */     //   492: invokevirtual hr : ()Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   495: pop
/*     */     //   496: aload #5
/*     */     //   498: invokevirtual add : ()Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   501: ldc '/**'
/*     */     //   503: invokevirtual add : (Ljava/lang/String;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   506: ldc ' * Expected callback signature'
/*     */     //   508: invokevirtual add : (Ljava/lang/String;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   511: ldc ' * /'
/*     */     //   513: invokevirtual add : (Ljava/lang/String;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   516: pop
/*     */     //   517: aload #5
/*     */     //   519: ldc '%s {'
/*     */     //   521: iconst_1
/*     */     //   522: anewarray java/lang/Object
/*     */     //   525: dup
/*     */     //   526: iconst_0
/*     */     //   527: aload #4
/*     */     //   529: aastore
/*     */     //   530: invokevirtual add : (Ljava/lang/String;[Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   533: pop
/*     */     //   534: aload #5
/*     */     //   536: ldc '    // Method body'
/*     */     //   538: invokevirtual add : (Ljava/lang/String;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   541: ldc '}'
/*     */     //   543: invokevirtual add : (Ljava/lang/String;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   546: invokevirtual add : ()Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   549: getstatic java/lang/System.err : Ljava/io/PrintStream;
/*     */     //   552: invokevirtual print : (Ljava/io/PrintStream;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   555: pop
/*     */     //   556: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #8	-> 0
/*     */     //   #168	-> 8
/*     */     //   #179	-> 27
/*     */     //   #195	-> 55
/*     */     //   #85	-> 64
/*     */     //   #22	-> 73
/*     */     //   #75	-> 95
/*     */     //   #140	-> 104
/*     */     //   #169	-> 122
/*     */     //   #104	-> 137
/*     */     //   #187	-> 152
/*     */     //   #65	-> 181
/*     */     //   #88	-> 191
/*     */     //   #6	-> 195
/*     */     //   #131	-> 201
/*     */     //   #94	-> 213
/*     */     //   #48	-> 240
/*     */     //   #35	-> 253
/*     */     //   #54	-> 282
/*     */     //   #134	-> 292
/*     */     //   #122	-> 341
/*     */     //   #56	-> 375
/*     */     //   #111	-> 382
/*     */     //   #23	-> 440
/*     */     //   #42	-> 484
/*     */     //   #99	-> 490
/*     */     //   #61	-> 496
/*     */     //   #109	-> 517
/*     */     //   #31	-> 534
/*     */     //   #153	-> 556
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   243	262	265	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   253	274	274	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   282	356	359	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   292	368	368	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   382	399	402	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   387	422	425	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   406	433	433	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   440	473	473	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */   }
/*     */   
/*     */   private void createCallbackInfo(CallbackInjector$Callback paramCallbackInjector$Callback, boolean paramBoolean) { 
/*  32 */     try { if (paramCallbackInjector$Callback.target != this.lastTarget)
/*     */       
/*     */       { 
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
/* 139 */         this.lastId = null;
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
/* 158 */         this.lastDesc = null; }  } catch (InvalidInjectionException invalidInjectionException) { throw c(null); }  this.lastTarget = paramCallbackInjector$Callback.target; String str1 = getIdentifier(paramCallbackInjector$Callback); String str2 = paramCallbackInjector$Callback.getCallbackInfoConstructorDescriptor(); try { if (str1.equals(this.lastId))
/*     */         try { if (str2.equals(this.lastDesc))
/*     */             try { if (!paramCallbackInjector$Callback.isAtReturn)
/*     */                 try { if (!this.cancellable)
/*     */                     return;  }
/*     */                 catch (InvalidInjectionException invalidInjectionException) { throw c(null); }
/*     */                   }
/*     */             catch (InvalidInjectionException invalidInjectionException) { throw c(null); }
/*     */               }
/*     */         catch (InvalidInjectionException invalidInjectionException) { throw c(null); }
/*     */           }
/*     */     catch (InvalidInjectionException invalidInjectionException) { throw c(null); }
/* 170 */      instanceCallbackInfo(paramCallbackInjector$Callback, str1, str2, paramBoolean); } private String generateBadLVTMessage(CallbackInjector$Callback paramCallbackInjector$Callback) { int i = paramCallbackInjector$Callback.target.indexOf(paramCallbackInjector$Callback.node); List<String> list1 = summariseLocals(this.methodNode.desc, paramCallbackInjector$Callback.target.arguments.length + 1); List<String> list2 = summariseLocals(paramCallbackInjector$Callback.getDescriptorWithAllLocals(), paramCallbackInjector$Callback.frameSize); return String.format("LVT in %s has incompatible changes at opcode %d in callback %s.\nExpected: %s\n   Found: %s", new Object[] { paramCallbackInjector$Callback.target, Integer.valueOf(i), this, list1, list2 }); }
/*     */   protected boolean isStatic() { return this.isStatic; }
/*     */   private void invokeCallback(CallbackInjector$Callback paramCallbackInjector$Callback, MethodNode paramMethodNode) { try { if (!this.isStatic)
/*     */         paramCallbackInjector$Callback.add((AbstractInsnNode)new VarInsnNode(25, 0), false, true);  }
/*     */     catch (InvalidInjectionException invalidInjectionException)
/*     */     { throw c(null); }
/*     */      try {
/*     */       if (paramCallbackInjector$Callback.captureArgs()) {
/*     */         try {
/*     */         
/*     */         } catch (InvalidInjectionException invalidInjectionException) {
/*     */           throw c(null);
/*     */         }  Bytecode.loadArgs(paramCallbackInjector$Callback.target.arguments, paramCallbackInjector$Callback, this.isStatic ? 0 : 1, -1);
/*     */       } 
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw c(null);
/*     */     }  try {
/*     */       loadOrCreateCallbackInfo(paramCallbackInjector$Callback); if (paramCallbackInjector$Callback.canCaptureLocals)
/*     */         Locals.loadLocals(paramCallbackInjector$Callback.localTypes, paramCallbackInjector$Callback, paramCallbackInjector$Callback.frameSize, paramCallbackInjector$Callback.extraArgs); 
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw c(null);
/*     */     }  invokeHandler(paramCallbackInjector$Callback, paramMethodNode); }
/*     */   protected void instanceCallbackInfo(CallbackInjector$Callback paramCallbackInjector$Callback, String paramString1, String paramString2, boolean paramBoolean) { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: aload_2
/*     */     //   2: putfield lastId : Ljava/lang/String;
/*     */     //   5: aload_0
/*     */     //   6: aload_3
/*     */     //   7: putfield lastDesc : Ljava/lang/String;
/*     */     //   10: aload_0
/*     */     //   11: aload_1
/*     */     //   12: invokevirtual marshalVar : ()I
/*     */     //   15: putfield callbackInfoVar : I
/*     */     //   18: aload_0
/*     */     //   19: aload_1
/*     */     //   20: getfield target : Lorg/spongepowered/asm/mixin/injection/struct/Target;
/*     */     //   23: invokevirtual getCallbackInfoClass : ()Ljava/lang/String;
/*     */     //   26: putfield callbackInfoClass : Ljava/lang/String;
/*     */     //   29: iload #4
/*     */     //   31: ifeq -> 85
/*     */     //   34: aload_0
/*     */     //   35: getfield totalInjections : I
/*     */     //   38: iconst_1
/*     */     //   39: if_icmple -> 85
/*     */     //   42: goto -> 49
/*     */     //   45: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   48: athrow
/*     */     //   49: aload_1
/*     */     //   50: getfield isAtReturn : Z
/*     */     //   53: ifne -> 85
/*     */     //   56: goto -> 63
/*     */     //   59: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   62: athrow
/*     */     //   63: aload_0
/*     */     //   64: getfield cancellable : Z
/*     */     //   67: ifne -> 85
/*     */     //   70: goto -> 77
/*     */     //   73: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   76: athrow
/*     */     //   77: iconst_1
/*     */     //   78: goto -> 86
/*     */     //   81: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   84: athrow
/*     */     //   85: iconst_0
/*     */     //   86: istore #5
/*     */     //   88: aload_1
/*     */     //   89: new org/spongepowered/asm/lib/tree/TypeInsnNode
/*     */     //   92: dup
/*     */     //   93: sipush #187
/*     */     //   96: aload_0
/*     */     //   97: getfield callbackInfoClass : Ljava/lang/String;
/*     */     //   100: invokespecial <init> : (ILjava/lang/String;)V
/*     */     //   103: iconst_1
/*     */     //   104: iload #4
/*     */     //   106: ifne -> 117
/*     */     //   109: iconst_1
/*     */     //   110: goto -> 118
/*     */     //   113: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   116: athrow
/*     */     //   117: iconst_0
/*     */     //   118: iload #5
/*     */     //   120: invokevirtual add : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;ZZZ)V
/*     */     //   123: aload_1
/*     */     //   124: new org/spongepowered/asm/lib/tree/InsnNode
/*     */     //   127: dup
/*     */     //   128: bipush #89
/*     */     //   130: invokespecial <init> : (I)V
/*     */     //   133: iconst_1
/*     */     //   134: iconst_1
/*     */     //   135: iload #5
/*     */     //   137: invokevirtual add : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;ZZZ)V
/*     */     //   140: aload_1
/*     */     //   141: new org/spongepowered/asm/lib/tree/LdcInsnNode
/*     */     //   144: dup
/*     */     //   145: aload_2
/*     */     //   146: invokespecial <init> : (Ljava/lang/Object;)V
/*     */     //   149: iconst_1
/*     */     //   150: iload #4
/*     */     //   152: ifne -> 163
/*     */     //   155: iconst_1
/*     */     //   156: goto -> 164
/*     */     //   159: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   162: athrow
/*     */     //   163: iconst_0
/*     */     //   164: iload #5
/*     */     //   166: invokevirtual add : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;ZZZ)V
/*     */     //   169: aload_1
/*     */     //   170: new org/spongepowered/asm/lib/tree/InsnNode
/*     */     //   173: dup
/*     */     //   174: aload_0
/*     */     //   175: getfield cancellable : Z
/*     */     //   178: ifeq -> 189
/*     */     //   181: iconst_4
/*     */     //   182: goto -> 190
/*     */     //   185: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   188: athrow
/*     */     //   189: iconst_3
/*     */     //   190: invokespecial <init> : (I)V
/*     */     //   193: iconst_1
/*     */     //   194: iload #4
/*     */     //   196: ifne -> 203
/*     */     //   199: iconst_1
/*     */     //   200: goto -> 204
/*     */     //   203: iconst_0
/*     */     //   204: iload #5
/*     */     //   206: invokevirtual add : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;ZZZ)V
/*     */     //   209: aload_1
/*     */     //   210: getfield isAtReturn : Z
/*     */     //   213: ifeq -> 290
/*     */     //   216: aload_1
/*     */     //   217: new org/spongepowered/asm/lib/tree/VarInsnNode
/*     */     //   220: dup
/*     */     //   221: aload_1
/*     */     //   222: getfield target : Lorg/spongepowered/asm/mixin/injection/struct/Target;
/*     */     //   225: getfield returnType : Lorg/spongepowered/asm/lib/Type;
/*     */     //   228: bipush #21
/*     */     //   230: invokevirtual getOpcode : (I)I
/*     */     //   233: aload_1
/*     */     //   234: invokevirtual marshalVar : ()I
/*     */     //   237: invokespecial <init> : (II)V
/*     */     //   240: iconst_1
/*     */     //   241: iload #4
/*     */     //   243: ifne -> 261
/*     */     //   246: goto -> 253
/*     */     //   249: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   252: athrow
/*     */     //   253: iconst_1
/*     */     //   254: goto -> 262
/*     */     //   257: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   260: athrow
/*     */     //   261: iconst_0
/*     */     //   262: invokevirtual add : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;ZZ)V
/*     */     //   265: aload_1
/*     */     //   266: new org/spongepowered/asm/lib/tree/MethodInsnNode
/*     */     //   269: dup
/*     */     //   270: sipush #183
/*     */     //   273: aload_0
/*     */     //   274: getfield callbackInfoClass : Ljava/lang/String;
/*     */     //   277: ldc '<init>'
/*     */     //   279: aload_3
/*     */     //   280: iconst_0
/*     */     //   281: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
/*     */     //   284: invokevirtual add : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;)V
/*     */     //   287: goto -> 316
/*     */     //   290: aload_1
/*     */     //   291: new org/spongepowered/asm/lib/tree/MethodInsnNode
/*     */     //   294: dup
/*     */     //   295: sipush #183
/*     */     //   298: aload_0
/*     */     //   299: getfield callbackInfoClass : Ljava/lang/String;
/*     */     //   302: ldc '<init>'
/*     */     //   304: aload_3
/*     */     //   305: iconst_0
/*     */     //   306: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
/*     */     //   309: iconst_0
/*     */     //   310: iconst_0
/*     */     //   311: iload #5
/*     */     //   313: invokevirtual add : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;ZZZ)V
/*     */     //   316: iload #4
/*     */     //   318: ifeq -> 409
/*     */     //   321: aload_1
/*     */     //   322: getfield target : Lorg/spongepowered/asm/mixin/injection/struct/Target;
/*     */     //   325: aload_0
/*     */     //   326: getfield callbackInfoVar : I
/*     */     //   329: new java/lang/StringBuilder
/*     */     //   332: dup
/*     */     //   333: invokespecial <init> : ()V
/*     */     //   336: ldc 'callbackInfo'
/*     */     //   338: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   341: aload_0
/*     */     //   342: getfield callbackInfoVar : I
/*     */     //   345: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   348: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   351: new java/lang/StringBuilder
/*     */     //   354: dup
/*     */     //   355: invokespecial <init> : ()V
/*     */     //   358: ldc 'L'
/*     */     //   360: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   363: aload_0
/*     */     //   364: getfield callbackInfoClass : Ljava/lang/String;
/*     */     //   367: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   370: ldc ';'
/*     */     //   372: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   375: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   378: invokevirtual addLocalVariable : (ILjava/lang/String;Ljava/lang/String;)V
/*     */     //   381: aload_1
/*     */     //   382: new org/spongepowered/asm/lib/tree/VarInsnNode
/*     */     //   385: dup
/*     */     //   386: bipush #58
/*     */     //   388: aload_0
/*     */     //   389: getfield callbackInfoVar : I
/*     */     //   392: invokespecial <init> : (II)V
/*     */     //   395: iconst_0
/*     */     //   396: iconst_0
/*     */     //   397: iload #5
/*     */     //   399: invokevirtual add : (Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;ZZZ)V
/*     */     //   402: goto -> 409
/*     */     //   405: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   408: athrow
/*     */     //   409: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #79	-> 0
/*     */     //   #162	-> 5
/*     */     //   #84	-> 10
/*     */     //   #100	-> 18
/*     */     //   #115	-> 29
/*     */     //   #167	-> 88
/*     */     //   #14	-> 123
/*     */     //   #80	-> 140
/*     */     //   #51	-> 169
/*     */     //   #12	-> 209
/*     */     //   #190	-> 216
/*     */     //   #124	-> 265
/*     */     //   #95	-> 290
/*     */     //   #180	-> 316
/*     */     //   #41	-> 321
/*     */     //   #171	-> 381
/*     */     //   #181	-> 409
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   0	42	45	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   34	56	59	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   49	70	73	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   63	81	81	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   88	113	113	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   118	159	159	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   164	185	185	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   204	246	249	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   216	257	257	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   316	402	405	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException } protected void inject(Target paramTarget, InjectionNodes.InjectionNode paramInjectionNode) { LocalVariableNode[] arrayOfLocalVariableNode = null; 
/* 193 */     try { if (this.localCapture.isCaptureLocals() || this.localCapture.isPrintLocals()) arrayOfLocalVariableNode = Locals.getLocalsAt(this.classNode, paramTarget.method, paramInjectionNode.getCurrentTarget());  } catch (InvalidInjectionException invalidInjectionException) { throw c(null); }
/*     */ 
/*     */     
/* 196 */     inject(new CallbackInjector$Callback(this, this.methodNode, paramTarget, paramInjectionNode, arrayOfLocalVariableNode, this.localCapture.isCaptureLocals())); }
/*     */    public CallbackInjector(InjectionInfo paramInjectionInfo, boolean paramBoolean, LocalCapture paramLocalCapture, String paramString) { super(paramInjectionInfo); this.ids = new HashMap<Integer, String>(); this.totalInjections = 0; this.callbackInfoVar = -1; this.cancellable = paramBoolean; this.localCapture = paramLocalCapture; this.identifier = paramString; } protected void injectCancellationCode(CallbackInjector$Callback paramCallbackInjector$Callback) { try { if (!this.cancellable)
/* 198 */         return;  } catch (InvalidInjectionException invalidInjectionException) { throw c(null); }  paramCallbackInjector$Callback.add((AbstractInsnNode)new VarInsnNode(25, this.callbackInfoVar)); paramCallbackInjector$Callback.add((AbstractInsnNode)new MethodInsnNode(182, this.callbackInfoClass, CallbackInfo.getIsCancelledMethodName(), CallbackInfo.getIsCancelledMethodSig(), false));
/*     */     LabelNode labelNode = new LabelNode();
/*     */     paramCallbackInjector$Callback.add((AbstractInsnNode)new JumpInsnNode(153, labelNode));
/*     */     injectReturnCode(paramCallbackInjector$Callback);
/*     */     paramCallbackInjector$Callback.add((AbstractInsnNode)labelNode); }
/*     */ 
/*     */   
/*     */   private String getIdentifier(CallbackInjector$Callback paramCallbackInjector$Callback) {
/*     */     try {
/*     */     
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw c(null);
/*     */     } 
/*     */     String str1 = Strings.isNullOrEmpty(this.identifier) ? paramCallbackInjector$Callback.target.method.name : this.identifier;
/*     */     String str2 = this.ids.get(Integer.valueOf(paramCallbackInjector$Callback.node.getId()));
/*     */     try {
/*     */     
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw c(null);
/*     */     } 
/*     */     return str1 + (Strings.isNullOrEmpty(str2) ? "" : (":" + str2));
/*     */   }
/*     */   
/*     */   private void inject(CallbackInjector$Callback paramCallbackInjector$Callback) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield localCapture : Lorg/spongepowered/asm/mixin/injection/callback/LocalCapture;
/*     */     //   4: invokevirtual isPrintLocals : ()Z
/*     */     //   7: ifeq -> 31
/*     */     //   10: aload_0
/*     */     //   11: aload_1
/*     */     //   12: invokespecial printLocals : (Lorg/spongepowered/asm/mixin/injection/callback/CallbackInjector$Callback;)V
/*     */     //   15: aload_0
/*     */     //   16: getfield info : Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;
/*     */     //   19: aload_0
/*     */     //   20: getfield methodNode : Lorg/spongepowered/asm/lib/tree/MethodNode;
/*     */     //   23: invokevirtual addCallbackInvocation : (Lorg/spongepowered/asm/lib/tree/MethodNode;)V
/*     */     //   26: return
/*     */     //   27: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   30: athrow
/*     */     //   31: aload_0
/*     */     //   32: getfield methodNode : Lorg/spongepowered/asm/lib/tree/MethodNode;
/*     */     //   35: astore_2
/*     */     //   36: aload_1
/*     */     //   37: aload_0
/*     */     //   38: getfield methodNode : Lorg/spongepowered/asm/lib/tree/MethodNode;
/*     */     //   41: getfield desc : Ljava/lang/String;
/*     */     //   44: invokevirtual checkDescriptor : (Ljava/lang/String;)Z
/*     */     //   47: ifne -> 431
/*     */     //   50: aload_0
/*     */     //   51: getfield info : Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;
/*     */     //   54: invokevirtual getTargets : ()Ljava/util/Collection;
/*     */     //   57: invokeinterface size : ()I
/*     */     //   62: iconst_1
/*     */     //   63: if_icmple -> 78
/*     */     //   66: goto -> 73
/*     */     //   69: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   72: athrow
/*     */     //   73: return
/*     */     //   74: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   77: athrow
/*     */     //   78: aload_1
/*     */     //   79: getfield canCaptureLocals : Z
/*     */     //   82: ifeq -> 256
/*     */     //   85: aload_0
/*     */     //   86: getfield classNode : Lorg/spongepowered/asm/lib/tree/ClassNode;
/*     */     //   89: aload_0
/*     */     //   90: getfield methodNode : Lorg/spongepowered/asm/lib/tree/MethodNode;
/*     */     //   93: getfield name : Ljava/lang/String;
/*     */     //   96: aload_1
/*     */     //   97: invokevirtual getDescriptor : ()Ljava/lang/String;
/*     */     //   100: invokestatic findMethod : (Lorg/spongepowered/asm/lib/tree/ClassNode;Ljava/lang/String;Ljava/lang/String;)Lorg/spongepowered/asm/lib/tree/MethodNode;
/*     */     //   103: astore_3
/*     */     //   104: aload_3
/*     */     //   105: ifnull -> 129
/*     */     //   108: aload_3
/*     */     //   109: ldc org/spongepowered/asm/mixin/injection/Surrogate
/*     */     //   111: invokestatic getVisible : (Lorg/spongepowered/asm/lib/tree/MethodNode;Ljava/lang/Class;)Lorg/spongepowered/asm/lib/tree/AnnotationNode;
/*     */     //   114: ifnull -> 129
/*     */     //   117: goto -> 124
/*     */     //   120: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   123: athrow
/*     */     //   124: aload_3
/*     */     //   125: astore_2
/*     */     //   126: goto -> 253
/*     */     //   129: aload_0
/*     */     //   130: aload_1
/*     */     //   131: invokespecial generateBadLVTMessage : (Lorg/spongepowered/asm/mixin/injection/callback/CallbackInjector$Callback;)Ljava/lang/String;
/*     */     //   134: astore #4
/*     */     //   136: getstatic org/spongepowered/asm/mixin/injection/callback/CallbackInjector$1.$SwitchMap$org$spongepowered$asm$mixin$injection$callback$LocalCapture : [I
/*     */     //   139: aload_0
/*     */     //   140: getfield localCapture : Lorg/spongepowered/asm/mixin/injection/callback/LocalCapture;
/*     */     //   143: invokevirtual ordinal : ()I
/*     */     //   146: iaload
/*     */     //   147: lookupswitch default -> 224, 1 -> 172, 2 -> 204
/*     */     //   172: getstatic org/spongepowered/asm/mixin/injection/code/Injector.logger : Lorg/apache/logging/log4j/Logger;
/*     */     //   175: ldc 'Injection error: {}'
/*     */     //   177: iconst_1
/*     */     //   178: anewarray java/lang/Object
/*     */     //   181: dup
/*     */     //   182: iconst_0
/*     */     //   183: aload #4
/*     */     //   185: aastore
/*     */     //   186: invokeinterface error : (Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   191: aload_0
/*     */     //   192: aload_1
/*     */     //   193: ldc 'org/spongepowered/asm/mixin/injection/throwables/InjectionError'
/*     */     //   195: aload #4
/*     */     //   197: invokespecial generateErrorMethod : (Lorg/spongepowered/asm/mixin/injection/callback/CallbackInjector$Callback;Ljava/lang/String;Ljava/lang/String;)Lorg/spongepowered/asm/lib/tree/MethodNode;
/*     */     //   200: astore_2
/*     */     //   201: goto -> 253
/*     */     //   204: getstatic org/spongepowered/asm/mixin/injection/code/Injector.logger : Lorg/apache/logging/log4j/Logger;
/*     */     //   207: ldc 'Injection warning: {}'
/*     */     //   209: iconst_1
/*     */     //   210: anewarray java/lang/Object
/*     */     //   213: dup
/*     */     //   214: iconst_0
/*     */     //   215: aload #4
/*     */     //   217: aastore
/*     */     //   218: invokeinterface warn : (Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   223: return
/*     */     //   224: getstatic org/spongepowered/asm/mixin/injection/code/Injector.logger : Lorg/apache/logging/log4j/Logger;
/*     */     //   227: ldc 'Critical injection failure: {}'
/*     */     //   229: iconst_1
/*     */     //   230: anewarray java/lang/Object
/*     */     //   233: dup
/*     */     //   234: iconst_0
/*     */     //   235: aload #4
/*     */     //   237: aastore
/*     */     //   238: invokeinterface error : (Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   243: new org/spongepowered/asm/mixin/injection/throwables/InjectionError
/*     */     //   246: dup
/*     */     //   247: aload #4
/*     */     //   249: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   252: athrow
/*     */     //   253: goto -> 431
/*     */     //   256: aload_0
/*     */     //   257: getfield methodNode : Lorg/spongepowered/asm/lib/tree/MethodNode;
/*     */     //   260: getfield desc : Ljava/lang/String;
/*     */     //   263: ldc 'Lorg/spongepowered/asm/mixin/injection/callback/CallbackInfo;'
/*     */     //   265: ldc 'Lorg/spongepowered/asm/mixin/injection/callback/CallbackInfoReturnable;'
/*     */     //   267: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
/*     */     //   270: astore_3
/*     */     //   271: aload_1
/*     */     //   272: aload_3
/*     */     //   273: invokevirtual checkDescriptor : (Ljava/lang/String;)Z
/*     */     //   276: ifeq -> 322
/*     */     //   279: new org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   282: dup
/*     */     //   283: aload_0
/*     */     //   284: getfield info : Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;
/*     */     //   287: new java/lang/StringBuilder
/*     */     //   290: dup
/*     */     //   291: invokespecial <init> : ()V
/*     */     //   294: ldc 'Invalid descriptor on '
/*     */     //   296: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   299: aload_0
/*     */     //   300: getfield info : Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;
/*     */     //   303: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   306: ldc '! CallbackInfoReturnable is required!'
/*     */     //   308: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   311: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   314: invokespecial <init> : (Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;Ljava/lang/String;)V
/*     */     //   317: athrow
/*     */     //   318: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   321: athrow
/*     */     //   322: aload_0
/*     */     //   323: getfield classNode : Lorg/spongepowered/asm/lib/tree/ClassNode;
/*     */     //   326: aload_0
/*     */     //   327: getfield methodNode : Lorg/spongepowered/asm/lib/tree/MethodNode;
/*     */     //   330: getfield name : Ljava/lang/String;
/*     */     //   333: aload_1
/*     */     //   334: invokevirtual getDescriptor : ()Ljava/lang/String;
/*     */     //   337: invokestatic findMethod : (Lorg/spongepowered/asm/lib/tree/ClassNode;Ljava/lang/String;Ljava/lang/String;)Lorg/spongepowered/asm/lib/tree/MethodNode;
/*     */     //   340: astore #4
/*     */     //   342: aload #4
/*     */     //   344: ifnull -> 370
/*     */     //   347: aload #4
/*     */     //   349: ldc org/spongepowered/asm/mixin/injection/Surrogate
/*     */     //   351: invokestatic getVisible : (Lorg/spongepowered/asm/lib/tree/MethodNode;Ljava/lang/Class;)Lorg/spongepowered/asm/lib/tree/AnnotationNode;
/*     */     //   354: ifnull -> 370
/*     */     //   357: goto -> 364
/*     */     //   360: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   363: athrow
/*     */     //   364: aload #4
/*     */     //   366: astore_2
/*     */     //   367: goto -> 431
/*     */     //   370: new org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   373: dup
/*     */     //   374: aload_0
/*     */     //   375: getfield info : Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;
/*     */     //   378: new java/lang/StringBuilder
/*     */     //   381: dup
/*     */     //   382: invokespecial <init> : ()V
/*     */     //   385: ldc 'Invalid descriptor on '
/*     */     //   387: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   390: aload_0
/*     */     //   391: getfield info : Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;
/*     */     //   394: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   397: ldc '! Expected '
/*     */     //   399: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   402: aload_1
/*     */     //   403: invokevirtual getDescriptor : ()Ljava/lang/String;
/*     */     //   406: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   409: ldc ' but found '
/*     */     //   411: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   414: aload_0
/*     */     //   415: getfield methodNode : Lorg/spongepowered/asm/lib/tree/MethodNode;
/*     */     //   418: getfield desc : Ljava/lang/String;
/*     */     //   421: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   424: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   427: invokespecial <init> : (Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;Ljava/lang/String;)V
/*     */     //   430: athrow
/*     */     //   431: aload_0
/*     */     //   432: aload_1
/*     */     //   433: invokespecial dupReturnValue : (Lorg/spongepowered/asm/mixin/injection/callback/CallbackInjector$Callback;)V
/*     */     //   436: aload_0
/*     */     //   437: getfield cancellable : Z
/*     */     //   440: ifne -> 458
/*     */     //   443: aload_0
/*     */     //   444: getfield totalInjections : I
/*     */     //   447: iconst_1
/*     */     //   448: if_icmple -> 471
/*     */     //   451: goto -> 458
/*     */     //   454: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   457: athrow
/*     */     //   458: aload_0
/*     */     //   459: aload_1
/*     */     //   460: iconst_1
/*     */     //   461: invokespecial createCallbackInfo : (Lorg/spongepowered/asm/mixin/injection/callback/CallbackInjector$Callback;Z)V
/*     */     //   464: goto -> 471
/*     */     //   467: invokestatic c : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   470: athrow
/*     */     //   471: aload_0
/*     */     //   472: aload_1
/*     */     //   473: aload_2
/*     */     //   474: invokespecial invokeCallback : (Lorg/spongepowered/asm/mixin/injection/callback/CallbackInjector$Callback;Lorg/spongepowered/asm/lib/tree/MethodNode;)V
/*     */     //   477: aload_0
/*     */     //   478: aload_1
/*     */     //   479: invokevirtual injectCancellationCode : (Lorg/spongepowered/asm/mixin/injection/callback/CallbackInjector$Callback;)V
/*     */     //   482: aload_1
/*     */     //   483: invokevirtual inject : ()V
/*     */     //   486: aload_0
/*     */     //   487: getfield info : Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;
/*     */     //   490: aload_1
/*     */     //   491: getfield target : Lorg/spongepowered/asm/mixin/injection/struct/Target;
/*     */     //   494: invokevirtual notifyInjected : (Lorg/spongepowered/asm/mixin/injection/struct/Target;)V
/*     */     //   497: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #103	-> 0
/*     */     //   #1	-> 10
/*     */     //   #98	-> 15
/*     */     //   #105	-> 26
/*     */     //   #182	-> 31
/*     */     //   #183	-> 36
/*     */     //   #172	-> 50
/*     */     //   #63	-> 73
/*     */     //   #55	-> 78
/*     */     //   #141	-> 85
/*     */     //   #81	-> 104
/*     */     //   #30	-> 124
/*     */     //   #137	-> 129
/*     */     //   #174	-> 136
/*     */     //   #175	-> 172
/*     */     //   #128	-> 191
/*     */     //   #118	-> 201
/*     */     //   #154	-> 204
/*     */     //   #7	-> 223
/*     */     //   #58	-> 224
/*     */     //   #20	-> 243
/*     */     //   #53	-> 253
/*     */     //   #152	-> 256
/*     */     //   #89	-> 271
/*     */     //   #145	-> 279
/*     */     //   #78	-> 322
/*     */     //   #83	-> 342
/*     */     //   #156	-> 364
/*     */     //   #57	-> 370
/*     */     //   #194	-> 431
/*     */     //   #199	-> 436
/*     */     //   #70	-> 458
/*     */     //   #11	-> 471
/*     */     //   #159	-> 477
/*     */     //   #52	-> 482
/*     */     //   #132	-> 486
/*     */     //   #125	-> 497
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   0	27	27	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   36	66	69	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   50	74	74	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   104	117	120	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   271	318	318	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   342	357	360	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   431	451	454	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   443	464	467	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */   }
/*     */   
/*     */   private MethodNode generateErrorMethod(CallbackInjector$Callback paramCallbackInjector$Callback, String paramString1, String paramString2) {
/*     */     MethodNode methodNode = this.info.addMethod(this.methodNode.access, this.methodNode.name + "$missing", paramCallbackInjector$Callback.getDescriptor());
/*     */     try {
/*     */     
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw c(null);
/*     */     } 
/*     */     methodNode.maxLocals = Bytecode.getFirstNonArgLocalIndex(Type.getArgumentTypes(paramCallbackInjector$Callback.getDescriptor()), !this.isStatic);
/*     */     methodNode.maxStack = 3;
/*     */     InsnList insnList = methodNode.instructions;
/*     */     insnList.add((AbstractInsnNode)new TypeInsnNode(187, paramString1));
/*     */     insnList.add((AbstractInsnNode)new InsnNode(89));
/*     */     insnList.add((AbstractInsnNode)new LdcInsnNode(paramString2));
/*     */     insnList.add((AbstractInsnNode)new MethodInsnNode(183, paramString1, "<init>", "(Ljava/lang/String;)V", false));
/*     */     insnList.add((AbstractInsnNode)new InsnNode(191));
/*     */     return methodNode;
/*     */   }
/*     */   
/*     */   static String meltSnowman(int paramInt, String paramString) {
/*     */     try {
/*     */       if (paramString != null)
/*     */         try {
/*     */           if ('☃' == paramString.charAt(0));
/*     */         } catch (InvalidInjectionException invalidInjectionException) {
/*     */           throw c(null);
/*     */         }  
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw c(null);
/*     */     } 
/*     */     return paramString;
/*     */   }
/*     */   
/*     */   private static List<String> summariseLocals(Type[] paramArrayOfType, int paramInt) {
/*     */     ArrayList<String> arrayList = new ArrayList();
/*     */     try {
/*     */       if (paramArrayOfType != null)
/*     */         while (true) {
/*     */           try {
/*     */             if (paramInt < paramArrayOfType.length) {
/*     */               try {
/*     */                 if (paramArrayOfType[paramInt] != null)
/*     */                   arrayList.add(paramArrayOfType[paramInt].toString()); 
/*     */               } catch (InvalidInjectionException invalidInjectionException) {
/*     */                 throw c(null);
/*     */               } 
/*     */               paramInt++;
/*     */             } 
/*     */           } catch (InvalidInjectionException invalidInjectionException) {
/*     */             throw c(null);
/*     */           } 
/*     */           break;
/*     */         }  
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw c(null);
/*     */     } 
/*     */     return arrayList;
/*     */   }
/*     */   
/*     */   private void loadOrCreateCallbackInfo(CallbackInjector$Callback paramCallbackInjector$Callback) {
/*     */     try {
/*     */       if (!this.cancellable) {
/*     */         try {
/*     */           if (this.totalInjections > 1) {
/*     */             paramCallbackInjector$Callback.add((AbstractInsnNode)new VarInsnNode(25, this.callbackInfoVar), false, true);
/*     */             return;
/*     */           } 
/*     */         } catch (InvalidInjectionException invalidInjectionException) {
/*     */           throw c(null);
/*     */         } 
/*     */         createCallbackInfo(paramCallbackInjector$Callback, false);
/*     */         return;
/*     */       } 
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw c(null);
/*     */     } 
/*     */     paramCallbackInjector$Callback.add((AbstractInsnNode)new VarInsnNode(25, this.callbackInfoVar), false, true);
/*     */   }
/*     */   
/*     */   private void dupReturnValue(CallbackInjector$Callback paramCallbackInjector$Callback) {
/*     */     try {
/*     */       if (!paramCallbackInjector$Callback.isAtReturn)
/*     */         return; 
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw c(null);
/*     */     } 
/*     */     paramCallbackInjector$Callback.add((AbstractInsnNode)new InsnNode(89));
/*     */     paramCallbackInjector$Callback.add((AbstractInsnNode)new VarInsnNode(paramCallbackInjector$Callback.target.returnType.getOpcode(54), paramCallbackInjector$Callback.marshalVar()));
/*     */   }
/*     */   
/*     */   protected void addTargetNode(Target paramTarget, List<InjectionNodes.InjectionNode> paramList, AbstractInsnNode paramAbstractInsnNode, Set<InjectionPoint> paramSet) {
/*     */     InjectionNodes.InjectionNode injectionNode = paramTarget.addInjectionNode(paramAbstractInsnNode);
/*     */     for (InjectionPoint injectionPoint : paramSet) {
/*     */       String str1 = injectionPoint.getId();
/*     */       try {
/*     */         if (Strings.isNullOrEmpty(str1))
/*     */           continue; 
/*     */       } catch (InvalidInjectionException invalidInjectionException) {
/*     */         throw c(null);
/*     */       } 
/*     */       String str2 = this.ids.get(Integer.valueOf(injectionNode.getId()));
/*     */       try {
/*     */         if (str2 != null)
/*     */           try {
/*     */             if (!str2.equals(str1)) {
/*     */               Injector.logger.warn("Conflicting id for {} insn in {}, found id {} on {}, previously defined as {}", new Object[] { Bytecode.getOpcodeName(paramAbstractInsnNode), paramTarget.toString(), str1, this.info, str2 });
/*     */               break;
/*     */             } 
/*     */           } catch (InvalidInjectionException invalidInjectionException) {
/*     */             throw c(null);
/*     */           }  
/*     */       } catch (InvalidInjectionException invalidInjectionException) {
/*     */         throw c(null);
/*     */       } 
/*     */       this.ids.put(Integer.valueOf(injectionNode.getId()), str1);
/*     */     } 
/*     */     paramList.add(injectionNode);
/*     */     this.totalInjections++;
/*     */   }
/*     */   
/*     */   private static List<String> summariseLocals(String paramString, int paramInt) {
/*     */     return summariseLocals(Type.getArgumentTypes(paramString), paramInt);
/*     */   }
/*     */   
/*     */   protected void sanityCheck(Target paramTarget, List<InjectionPoint> paramList) {
/*     */     try {
/*     */       super.sanityCheck(paramTarget, paramList);
/*     */       if (paramTarget.isStatic != this.isStatic)
/*     */         throw new InvalidInjectionException(this.info, "'static' modifier of callback method does not match target in " + this); 
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw c(null);
/*     */     } 
/*     */     if ("<init>".equals(paramTarget.method.name))
/*     */       for (InjectionPoint injectionPoint : paramList) {
/*     */         try {
/*     */           if (!injectionPoint.getClass().equals(BeforeReturn.class))
/*     */             throw new InvalidInjectionException(this.info, "Found injection point type " + injectionPoint.getClass().getSimpleName() + " targetting a ctor in " + this + ". Only RETURN allowed for a ctor target"); 
/*     */         } catch (InvalidInjectionException invalidInjectionException) {
/*     */           throw c(null);
/*     */         } 
/*     */       }  
/*     */   }
/*     */   
/*     */   protected void injectReturnCode(CallbackInjector$Callback paramCallbackInjector$Callback) {
/*     */     try {
/*     */       if (paramCallbackInjector$Callback.target.returnType.equals(Type.VOID_TYPE)) {
/*     */         paramCallbackInjector$Callback.add((AbstractInsnNode)new InsnNode(177));
/*     */       } else {
/*     */         paramCallbackInjector$Callback.add((AbstractInsnNode)new VarInsnNode(25, paramCallbackInjector$Callback.marshalVar()));
/*     */         String str = CallbackInfoReturnable.getReturnAccessor(paramCallbackInjector$Callback.target.returnType);
/*     */       } 
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw c(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static InvalidInjectionException c(InvalidInjectionException paramInvalidInjectionException) {
/*     */     return paramInvalidInjectionException;
/*     */   }
/*     */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\callback\CallbackInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */