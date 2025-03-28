/*    */ package org.spongepowered.asm.mixin.injection.callback;class CallbackInjector$Callback extends InsnList { private final MethodNode handler; private final AbstractInsnNode head; final Target target; final InjectionNodes.InjectionNode node; final LocalVariableNode[] locals; final Type[] localTypes; final int frameSize; final int extraArgs; final boolean canCaptureLocals;
/*    */   void add(AbstractInsnNode paramAbstractInsnNode, boolean paramBoolean1, boolean paramBoolean2) {
/*  3 */     add(paramAbstractInsnNode, paramBoolean1, paramBoolean2, false);
/*    */   } final boolean isAtReturn; final String desc; final String descl; final String[] argNames; int ctor; int invoke; private int marshalVar; private boolean captureArgs; final CallbackInjector this$0; String getDescriptorWithAllLocals() {
/*  5 */     return this.target.getCallbackDescriptor(true, this.localTypes, this.target.arguments, this.frameSize, 32767);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   String getCallbackInfoConstructorDescriptor()
/*    */   {
/*    */     
/*    */     try {  }
/*    */     catch (RuntimeException runtimeException)
/* 20 */     { throw b(null); }  return this.isAtReturn ? CallbackInfo.getConstructorDescriptor(this.target.returnType) : CallbackInfo.getConstructorDescriptor(); } boolean checkDescriptor(String paramString) {
/*    */     
/* 22 */     try { if (getDescriptor().equals(paramString))
/*    */       {
/* 24 */         return true; }  } catch (RuntimeException runtimeException) { throw b(null); }
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
/*    */     try {
/*    */       if (this.target.getSimpleCallbackDescriptor().equals(paramString)) {
/*    */         
/*    */         try { if (!this.canCaptureLocals)
/*    */           { this.captureArgs = false;
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
/* 60 */             return true; }  } catch (RuntimeException runtimeException) { throw b(null); }
/*    */       
/*    */       }
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 70 */     Type[] arrayOfType1 = Type.getArgumentTypes(paramString);
/*    */     Type[] arrayOfType2 = Type.getArgumentTypes(this.descl);
/*    */     try {
/*    */       if (arrayOfType1.length != arrayOfType2.length)
/*    */         return false; 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     for (byte b = 0; b < arrayOfType2.length; ) {
/*    */       Type type = arrayOfType1[b];
/*    */       try {
/*    */         if (!type.equals(arrayOfType2[b])) {
/*    */           try {
/*    */             if (type.getSort() == 9)
/*    */               return false; 
/*    */           } catch (RuntimeException runtimeException) {
/*    */             throw b(null);
/*    */           } 
/*    */           try {
/*    */             if (Annotations.getInvisibleParameter(this.handler, Coerce.class, b) == null)
/*    */               return false; 
/*    */           } catch (RuntimeException runtimeException) {
/*    */             throw b(null);
/*    */           } 
/*    */           try {
/*    */             if (!Injector.canCoerce(arrayOfType1[b], arrayOfType2[b]))
/*    */               return false; 
/*    */           } catch (RuntimeException runtimeException) {
/*    */             throw b(null);
/*    */           } 
/*    */         } 
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } 
/*    */     return true;
/*    */   }
/*    */   
/*    */   String getDescriptor() {
/*    */     try {
/*    */     
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return this.canCaptureLocals ? this.descl : this.desc;
/*    */   }
/*    */   
/*    */   CallbackInjector$Callback(CallbackInjector paramCallbackInjector, MethodNode paramMethodNode, Target paramTarget, InjectionNodes.InjectionNode paramInjectionNode, LocalVariableNode[] paramArrayOfLocalVariableNode, boolean paramBoolean) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: putfield this$0 : Lorg/spongepowered/asm/mixin/injection/callback/CallbackInjector;
/*    */     //   5: aload_0
/*    */     //   6: invokespecial <init> : ()V
/*    */     //   9: aload_0
/*    */     //   10: iconst_m1
/*    */     //   11: putfield marshalVar : I
/*    */     //   14: aload_0
/*    */     //   15: iconst_1
/*    */     //   16: putfield captureArgs : Z
/*    */     //   19: aload_0
/*    */     //   20: aload_2
/*    */     //   21: putfield handler : Lorg/spongepowered/asm/lib/tree/MethodNode;
/*    */     //   24: aload_0
/*    */     //   25: aload_3
/*    */     //   26: putfield target : Lorg/spongepowered/asm/mixin/injection/struct/Target;
/*    */     //   29: aload_0
/*    */     //   30: aload_3
/*    */     //   31: getfield insns : Lorg/spongepowered/asm/lib/tree/InsnList;
/*    */     //   34: invokevirtual getFirst : ()Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;
/*    */     //   37: putfield head : Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;
/*    */     //   40: aload_0
/*    */     //   41: aload #4
/*    */     //   43: putfield node : Lorg/spongepowered/asm/mixin/injection/struct/InjectionNodes$InjectionNode;
/*    */     //   46: aload_0
/*    */     //   47: aload #5
/*    */     //   49: putfield locals : [Lorg/spongepowered/asm/lib/tree/LocalVariableNode;
/*    */     //   52: aload_0
/*    */     //   53: aload #5
/*    */     //   55: ifnull -> 67
/*    */     //   58: aload #5
/*    */     //   60: arraylength
/*    */     //   61: anewarray org/spongepowered/asm/lib/Type
/*    */     //   64: goto -> 68
/*    */     //   67: aconst_null
/*    */     //   68: putfield localTypes : [Lorg/spongepowered/asm/lib/Type;
/*    */     //   71: aload_0
/*    */     //   72: aload_3
/*    */     //   73: getfield arguments : [Lorg/spongepowered/asm/lib/Type;
/*    */     //   76: aload_1
/*    */     //   77: invokevirtual isStatic : ()Z
/*    */     //   80: ifne -> 91
/*    */     //   83: iconst_1
/*    */     //   84: goto -> 92
/*    */     //   87: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   90: athrow
/*    */     //   91: iconst_0
/*    */     //   92: invokestatic getFirstNonArgLocalIndex : ([Lorg/spongepowered/asm/lib/Type;Z)I
/*    */     //   95: putfield frameSize : I
/*    */     //   98: aconst_null
/*    */     //   99: astore #7
/*    */     //   101: aload #5
/*    */     //   103: ifnull -> 292
/*    */     //   106: aload_1
/*    */     //   107: invokevirtual isStatic : ()Z
/*    */     //   110: ifeq -> 128
/*    */     //   113: goto -> 120
/*    */     //   116: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   119: athrow
/*    */     //   120: iconst_0
/*    */     //   121: goto -> 129
/*    */     //   124: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   127: athrow
/*    */     //   128: iconst_1
/*    */     //   129: istore #8
/*    */     //   131: new java/util/ArrayList
/*    */     //   134: dup
/*    */     //   135: invokespecial <init> : ()V
/*    */     //   138: astore #7
/*    */     //   140: iconst_0
/*    */     //   141: istore #9
/*    */     //   143: iload #9
/*    */     //   145: aload #5
/*    */     //   147: arraylength
/*    */     //   148: if_icmpgt -> 292
/*    */     //   151: iload #9
/*    */     //   153: aload_0
/*    */     //   154: getfield frameSize : I
/*    */     //   157: if_icmpne -> 203
/*    */     //   160: goto -> 167
/*    */     //   163: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   166: athrow
/*    */     //   167: aload #7
/*    */     //   169: aload_3
/*    */     //   170: getfield returnType : Lorg/spongepowered/asm/lib/Type;
/*    */     //   173: getstatic org/spongepowered/asm/lib/Type.VOID_TYPE : Lorg/spongepowered/asm/lib/Type;
/*    */     //   176: if_acmpne -> 195
/*    */     //   179: goto -> 186
/*    */     //   182: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   185: athrow
/*    */     //   186: ldc 'ci'
/*    */     //   188: goto -> 197
/*    */     //   191: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   194: athrow
/*    */     //   195: ldc 'cir'
/*    */     //   197: invokeinterface add : (Ljava/lang/Object;)Z
/*    */     //   202: pop
/*    */     //   203: iload #9
/*    */     //   205: aload #5
/*    */     //   207: arraylength
/*    */     //   208: if_icmpge -> 286
/*    */     //   211: aload #5
/*    */     //   213: iload #9
/*    */     //   215: aaload
/*    */     //   216: ifnull -> 286
/*    */     //   219: goto -> 226
/*    */     //   222: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   225: athrow
/*    */     //   226: aload_0
/*    */     //   227: getfield localTypes : [Lorg/spongepowered/asm/lib/Type;
/*    */     //   230: iload #9
/*    */     //   232: aload #5
/*    */     //   234: iload #9
/*    */     //   236: aaload
/*    */     //   237: getfield desc : Ljava/lang/String;
/*    */     //   240: invokestatic getType : (Ljava/lang/String;)Lorg/spongepowered/asm/lib/Type;
/*    */     //   243: aastore
/*    */     //   244: iload #9
/*    */     //   246: iload #8
/*    */     //   248: if_icmplt -> 286
/*    */     //   251: goto -> 258
/*    */     //   254: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   257: athrow
/*    */     //   258: aload #7
/*    */     //   260: iload #9
/*    */     //   262: aload #5
/*    */     //   264: iload #9
/*    */     //   266: aaload
/*    */     //   267: getfield name : Ljava/lang/String;
/*    */     //   270: invokestatic meltSnowman : (ILjava/lang/String;)Ljava/lang/String;
/*    */     //   273: invokeinterface add : (Ljava/lang/Object;)Z
/*    */     //   278: pop
/*    */     //   279: goto -> 286
/*    */     //   282: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   285: athrow
/*    */     //   286: iinc #9, 1
/*    */     //   289: goto -> 143
/*    */     //   292: aload_0
/*    */     //   293: iconst_0
/*    */     //   294: aload_0
/*    */     //   295: getfield handler : Lorg/spongepowered/asm/lib/tree/MethodNode;
/*    */     //   298: invokestatic getFirstNonArgLocalIndex : (Lorg/spongepowered/asm/lib/tree/MethodNode;)I
/*    */     //   301: aload_0
/*    */     //   302: getfield frameSize : I
/*    */     //   305: iconst_1
/*    */     //   306: iadd
/*    */     //   307: isub
/*    */     //   308: invokestatic max : (II)I
/*    */     //   311: putfield extraArgs : I
/*    */     //   314: aload_0
/*    */     //   315: aload #7
/*    */     //   317: ifnull -> 347
/*    */     //   320: aload #7
/*    */     //   322: aload #7
/*    */     //   324: invokeinterface size : ()I
/*    */     //   329: anewarray java/lang/String
/*    */     //   332: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
/*    */     //   337: checkcast [Ljava/lang/String;
/*    */     //   340: goto -> 348
/*    */     //   343: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   346: athrow
/*    */     //   347: aconst_null
/*    */     //   348: putfield argNames : [Ljava/lang/String;
/*    */     //   351: aload_0
/*    */     //   352: iload #6
/*    */     //   354: ifeq -> 394
/*    */     //   357: aload #5
/*    */     //   359: ifnull -> 394
/*    */     //   362: goto -> 369
/*    */     //   365: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   368: athrow
/*    */     //   369: aload #5
/*    */     //   371: arraylength
/*    */     //   372: aload_0
/*    */     //   373: getfield frameSize : I
/*    */     //   376: if_icmple -> 394
/*    */     //   379: goto -> 386
/*    */     //   382: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   385: athrow
/*    */     //   386: iconst_1
/*    */     //   387: goto -> 395
/*    */     //   390: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   393: athrow
/*    */     //   394: iconst_0
/*    */     //   395: putfield canCaptureLocals : Z
/*    */     //   398: aload_0
/*    */     //   399: aload_0
/*    */     //   400: getfield node : Lorg/spongepowered/asm/mixin/injection/struct/InjectionNodes$InjectionNode;
/*    */     //   403: invokevirtual getCurrentTarget : ()Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;
/*    */     //   406: instanceof org/spongepowered/asm/lib/tree/InsnNode
/*    */     //   409: ifeq -> 444
/*    */     //   412: aload_0
/*    */     //   413: aload_0
/*    */     //   414: getfield node : Lorg/spongepowered/asm/mixin/injection/struct/InjectionNodes$InjectionNode;
/*    */     //   417: invokevirtual getCurrentTarget : ()Lorg/spongepowered/asm/lib/tree/AbstractInsnNode;
/*    */     //   420: invokevirtual getOpcode : ()I
/*    */     //   423: invokespecial isValueReturnOpcode : (I)Z
/*    */     //   426: ifeq -> 444
/*    */     //   429: goto -> 436
/*    */     //   432: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   435: athrow
/*    */     //   436: iconst_1
/*    */     //   437: goto -> 445
/*    */     //   440: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   443: athrow
/*    */     //   444: iconst_0
/*    */     //   445: putfield isAtReturn : Z
/*    */     //   448: aload_0
/*    */     //   449: aload_3
/*    */     //   450: aload_0
/*    */     //   451: getfield localTypes : [Lorg/spongepowered/asm/lib/Type;
/*    */     //   454: aload_3
/*    */     //   455: getfield arguments : [Lorg/spongepowered/asm/lib/Type;
/*    */     //   458: invokevirtual getCallbackDescriptor : ([Lorg/spongepowered/asm/lib/Type;[Lorg/spongepowered/asm/lib/Type;)Ljava/lang/String;
/*    */     //   461: putfield desc : Ljava/lang/String;
/*    */     //   464: aload_0
/*    */     //   465: aload_3
/*    */     //   466: iconst_1
/*    */     //   467: aload_0
/*    */     //   468: getfield localTypes : [Lorg/spongepowered/asm/lib/Type;
/*    */     //   471: aload_3
/*    */     //   472: getfield arguments : [Lorg/spongepowered/asm/lib/Type;
/*    */     //   475: aload_0
/*    */     //   476: getfield frameSize : I
/*    */     //   479: aload_0
/*    */     //   480: getfield extraArgs : I
/*    */     //   483: invokevirtual getCallbackDescriptor : (Z[Lorg/spongepowered/asm/lib/Type;[Lorg/spongepowered/asm/lib/Type;II)Ljava/lang/String;
/*    */     //   486: putfield descl : Ljava/lang/String;
/*    */     //   489: aload_0
/*    */     //   490: aload_3
/*    */     //   491: getfield arguments : [Lorg/spongepowered/asm/lib/Type;
/*    */     //   494: arraylength
/*    */     //   495: aload_0
/*    */     //   496: getfield canCaptureLocals : Z
/*    */     //   499: ifeq -> 519
/*    */     //   502: aload_0
/*    */     //   503: getfield localTypes : [Lorg/spongepowered/asm/lib/Type;
/*    */     //   506: arraylength
/*    */     //   507: aload_0
/*    */     //   508: getfield frameSize : I
/*    */     //   511: isub
/*    */     //   512: goto -> 520
/*    */     //   515: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   518: athrow
/*    */     //   519: iconst_0
/*    */     //   520: iadd
/*    */     //   521: putfield invoke : I
/*    */     //   524: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #28	-> 0
/*    */     //   #37	-> 9
/*    */     //   #61	-> 14
/*    */     //   #62	-> 19
/*    */     //   #25	-> 24
/*    */     //   #68	-> 29
/*    */     //   #19	-> 40
/*    */     //   #29	-> 46
/*    */     //   #27	-> 52
/*    */     //   #59	-> 71
/*    */     //   #6	-> 98
/*    */     //   #9	-> 101
/*    */     //   #10	-> 106
/*    */     //   #7	-> 131
/*    */     //   #14	-> 140
/*    */     //   #1	-> 151
/*    */     //   #35	-> 167
/*    */     //   #51	-> 203
/*    */     //   #54	-> 226
/*    */     //   #39	-> 244
/*    */     //   #49	-> 258
/*    */     //   #21	-> 286
/*    */     //   #30	-> 292
/*    */     //   #46	-> 314
/*    */     //   #52	-> 351
/*    */     //   #65	-> 398
/*    */     //   #53	-> 448
/*    */     //   #32	-> 464
/*    */     //   #36	-> 489
/*    */     //   #67	-> 524
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   68	87	87	java/lang/RuntimeException
/*    */     //   101	113	116	java/lang/RuntimeException
/*    */     //   106	124	124	java/lang/RuntimeException
/*    */     //   143	160	163	java/lang/RuntimeException
/*    */     //   151	179	182	java/lang/RuntimeException
/*    */     //   167	191	191	java/lang/RuntimeException
/*    */     //   203	219	222	java/lang/RuntimeException
/*    */     //   211	251	254	java/lang/RuntimeException
/*    */     //   226	279	282	java/lang/RuntimeException
/*    */     //   292	343	343	java/lang/RuntimeException
/*    */     //   348	362	365	java/lang/RuntimeException
/*    */     //   357	379	382	java/lang/RuntimeException
/*    */     //   369	390	390	java/lang/RuntimeException
/*    */     //   395	429	432	java/lang/RuntimeException
/*    */     //   412	440	440	java/lang/RuntimeException
/*    */     //   445	515	515	java/lang/RuntimeException
/*    */   }
/*    */   
/*    */   void add(AbstractInsnNode paramAbstractInsnNode, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/*    */     try {
/*    */       if (paramBoolean3) {
/*    */         this.target.insns.insertBefore(this.head, paramAbstractInsnNode);
/*    */       } else {
/*    */         add(paramAbstractInsnNode);
/*    */       } 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     try {
/*    */     
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     try {
/*    */       this.ctor += paramBoolean1 ? 1 : 0;
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     this.invoke += paramBoolean2 ? 1 : 0;
/*    */   }
/*    */   
/*    */   void inject() {
/*    */     this.target.insertBefore(this.node, this);
/*    */     this.target.addToStack(Math.max(this.invoke, this.ctor));
/*    */   }
/*    */   
/*    */   boolean captureArgs() {
/*    */     return this.captureArgs;
/*    */   }
/*    */   
/*    */   int marshalVar() {
/*    */     try {
/*    */       if (this.marshalVar < 0)
/*    */         this.marshalVar = this.target.allocateLocal(); 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return this.marshalVar;
/*    */   }
/*    */   
/*    */   private boolean isValueReturnOpcode(int paramInt) {
/*    */     try {
/*    */       if (paramInt >= 172)
/*    */         try {
/*    */           if (paramInt < 177);
/*    */         } catch (RuntimeException runtimeException) {
/*    */           throw b(null);
/*    */         }  
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return false;
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\callback\CallbackInjector$Callback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */