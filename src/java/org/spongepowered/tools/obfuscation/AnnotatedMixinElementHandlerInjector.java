/*     */ package org.spongepowered.tools.obfuscation;
/*     */ 
/*     */ import javax.lang.model.element.AnnotationMirror;
/*     */ import javax.tools.Diagnostic;
/*     */ import org.spongepowered.asm.mixin.injection.struct.InjectionPointData;
/*     */ import org.spongepowered.asm.mixin.injection.struct.InvalidMemberDescriptorException;
/*     */ import org.spongepowered.asm.mixin.injection.struct.MemberInfo;
/*     */ import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
/*     */ import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
/*     */ import org.spongepowered.tools.obfuscation.mirror.TypeHandle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class AnnotatedMixinElementHandlerInjector
/*     */   extends AnnotatedMixinElementHandler
/*     */ {
/*     */   private boolean registerInjector(AnnotatedMixinElementHandlerInjector$AnnotatedElementInjector paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjector, String paramString, MemberInfo paramMemberInfo, TypeHandle paramTypeHandle) {
/*     */     // Byte code:
/*     */     //   0: aload #4
/*     */     //   2: aload_3
/*     */     //   3: invokevirtual findDescriptor : (Lorg/spongepowered/asm/mixin/injection/struct/MemberInfo;)Ljava/lang/String;
/*     */     //   6: astore #5
/*     */     //   8: aload #5
/*     */     //   10: ifnonnull -> 203
/*     */     //   13: aload_0
/*     */     //   14: getfield mixin : Lorg/spongepowered/tools/obfuscation/AnnotatedMixin;
/*     */     //   17: invokevirtual isMultiTarget : ()Z
/*     */     //   20: ifeq -> 40
/*     */     //   23: goto -> 30
/*     */     //   26: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   29: athrow
/*     */     //   30: getstatic javax/tools/Diagnostic$Kind.ERROR : Ljavax/tools/Diagnostic$Kind;
/*     */     //   33: goto -> 43
/*     */     //   36: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   39: athrow
/*     */     //   40: getstatic javax/tools/Diagnostic$Kind.WARNING : Ljavax/tools/Diagnostic$Kind;
/*     */     //   43: astore #6
/*     */     //   45: aload #4
/*     */     //   47: invokevirtual isSimulated : ()Z
/*     */     //   50: ifeq -> 99
/*     */     //   53: aload_1
/*     */     //   54: aload_0
/*     */     //   55: getfield ap : Lorg/spongepowered/tools/obfuscation/interfaces/IMixinAnnotationProcessor;
/*     */     //   58: getstatic javax/tools/Diagnostic$Kind.NOTE : Ljavax/tools/Diagnostic$Kind;
/*     */     //   61: new java/lang/StringBuilder
/*     */     //   64: dup
/*     */     //   65: invokespecial <init> : ()V
/*     */     //   68: aload_1
/*     */     //   69: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   72: ldc ' target ''
/*     */     //   74: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   77: aload_2
/*     */     //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   81: ldc '' in @Pseudo mixin will not be obfuscated'
/*     */     //   83: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   86: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   89: invokevirtual printMessage : (Ljavax/annotation/processing/Messager;Ljavax/tools/Diagnostic$Kind;Ljava/lang/CharSequence;)V
/*     */     //   92: goto -> 201
/*     */     //   95: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   98: athrow
/*     */     //   99: aload #4
/*     */     //   101: invokevirtual isImaginary : ()Z
/*     */     //   104: ifeq -> 153
/*     */     //   107: aload_1
/*     */     //   108: aload_0
/*     */     //   109: getfield ap : Lorg/spongepowered/tools/obfuscation/interfaces/IMixinAnnotationProcessor;
/*     */     //   112: aload #6
/*     */     //   114: new java/lang/StringBuilder
/*     */     //   117: dup
/*     */     //   118: invokespecial <init> : ()V
/*     */     //   121: aload_1
/*     */     //   122: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   125: ldc ' target requires method signature because enclosing type information for '
/*     */     //   127: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   130: aload #4
/*     */     //   132: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   135: ldc ' is unavailable'
/*     */     //   137: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   140: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   143: invokevirtual printMessage : (Ljavax/annotation/processing/Messager;Ljavax/tools/Diagnostic$Kind;Ljava/lang/CharSequence;)V
/*     */     //   146: goto -> 201
/*     */     //   149: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   152: athrow
/*     */     //   153: aload_3
/*     */     //   154: invokevirtual isInitialiser : ()Z
/*     */     //   157: ifne -> 201
/*     */     //   160: aload_1
/*     */     //   161: aload_0
/*     */     //   162: getfield ap : Lorg/spongepowered/tools/obfuscation/interfaces/IMixinAnnotationProcessor;
/*     */     //   165: aload #6
/*     */     //   167: new java/lang/StringBuilder
/*     */     //   170: dup
/*     */     //   171: invokespecial <init> : ()V
/*     */     //   174: ldc 'Unable to determine signature for '
/*     */     //   176: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   179: aload_1
/*     */     //   180: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   183: ldc ' target method'
/*     */     //   185: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   188: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   191: invokevirtual printMessage : (Ljavax/annotation/processing/Messager;Ljavax/tools/Diagnostic$Kind;Ljava/lang/CharSequence;)V
/*     */     //   194: goto -> 201
/*     */     //   197: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   200: athrow
/*     */     //   201: iconst_1
/*     */     //   202: ireturn
/*     */     //   203: new java/lang/StringBuilder
/*     */     //   206: dup
/*     */     //   207: invokespecial <init> : ()V
/*     */     //   210: aload_1
/*     */     //   211: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   214: ldc ' target '
/*     */     //   216: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   219: aload_3
/*     */     //   220: getfield name : Ljava/lang/String;
/*     */     //   223: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   226: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   229: astore #6
/*     */     //   231: aload #4
/*     */     //   233: aload_3
/*     */     //   234: getfield name : Ljava/lang/String;
/*     */     //   237: aload #5
/*     */     //   239: invokevirtual getMappingMethod : (Ljava/lang/String;Ljava/lang/String;)Lorg/spongepowered/asm/obfuscation/mapping/common/MappingMethod;
/*     */     //   242: astore #7
/*     */     //   244: aload_0
/*     */     //   245: getfield obf : Lorg/spongepowered/tools/obfuscation/interfaces/IObfuscationManager;
/*     */     //   248: invokeinterface getDataProvider : ()Lorg/spongepowered/tools/obfuscation/interfaces/IObfuscationDataProvider;
/*     */     //   253: aload #7
/*     */     //   255: invokeinterface getObfMethod : (Lorg/spongepowered/asm/obfuscation/mapping/common/MappingMethod;)Lorg/spongepowered/tools/obfuscation/ObfuscationData;
/*     */     //   260: astore #8
/*     */     //   262: aload #8
/*     */     //   264: invokevirtual isEmpty : ()Z
/*     */     //   267: ifeq -> 377
/*     */     //   270: aload #4
/*     */     //   272: invokevirtual isSimulated : ()Z
/*     */     //   275: ifeq -> 306
/*     */     //   278: goto -> 285
/*     */     //   281: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   284: athrow
/*     */     //   285: aload_0
/*     */     //   286: getfield obf : Lorg/spongepowered/tools/obfuscation/interfaces/IObfuscationManager;
/*     */     //   289: invokeinterface getDataProvider : ()Lorg/spongepowered/tools/obfuscation/interfaces/IObfuscationDataProvider;
/*     */     //   294: aload #7
/*     */     //   296: invokeinterface getRemappedMethod : (Lorg/spongepowered/asm/obfuscation/mapping/common/MappingMethod;)Lorg/spongepowered/tools/obfuscation/ObfuscationData;
/*     */     //   301: astore #8
/*     */     //   303: goto -> 377
/*     */     //   306: aload_3
/*     */     //   307: invokevirtual isClassInitialiser : ()Z
/*     */     //   310: ifeq -> 319
/*     */     //   313: iconst_1
/*     */     //   314: ireturn
/*     */     //   315: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   318: athrow
/*     */     //   319: aload_3
/*     */     //   320: invokevirtual isConstructor : ()Z
/*     */     //   323: ifeq -> 336
/*     */     //   326: getstatic javax/tools/Diagnostic$Kind.WARNING : Ljavax/tools/Diagnostic$Kind;
/*     */     //   329: goto -> 339
/*     */     //   332: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   335: athrow
/*     */     //   336: getstatic javax/tools/Diagnostic$Kind.ERROR : Ljavax/tools/Diagnostic$Kind;
/*     */     //   339: astore #9
/*     */     //   341: aload_1
/*     */     //   342: aload #9
/*     */     //   344: new java/lang/StringBuilder
/*     */     //   347: dup
/*     */     //   348: invokespecial <init> : ()V
/*     */     //   351: ldc 'No obfuscation mapping for '
/*     */     //   353: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   356: aload #6
/*     */     //   358: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   361: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   364: aload_1
/*     */     //   365: invokevirtual getElement : ()Ljavax/lang/model/element/Element;
/*     */     //   368: aload_1
/*     */     //   369: invokevirtual getAnnotation : ()Lorg/spongepowered/tools/obfuscation/mirror/AnnotationHandle;
/*     */     //   372: invokevirtual addMessage : (Ljavax/tools/Diagnostic$Kind;Ljava/lang/CharSequence;Ljavax/lang/model/element/Element;Lorg/spongepowered/tools/obfuscation/mirror/AnnotationHandle;)V
/*     */     //   375: iconst_0
/*     */     //   376: ireturn
/*     */     //   377: aload_0
/*     */     //   378: getfield obf : Lorg/spongepowered/tools/obfuscation/interfaces/IObfuscationManager;
/*     */     //   381: invokeinterface getReferenceManager : ()Lorg/spongepowered/tools/obfuscation/interfaces/IReferenceManager;
/*     */     //   386: astore #9
/*     */     //   388: aload_3
/*     */     //   389: getfield owner : Ljava/lang/String;
/*     */     //   392: ifnonnull -> 412
/*     */     //   395: aload_0
/*     */     //   396: getfield mixin : Lorg/spongepowered/tools/obfuscation/AnnotatedMixin;
/*     */     //   399: invokevirtual isMultiTarget : ()Z
/*     */     //   402: ifne -> 427
/*     */     //   405: goto -> 412
/*     */     //   408: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   411: athrow
/*     */     //   412: aload #4
/*     */     //   414: invokevirtual isSimulated : ()Z
/*     */     //   417: ifeq -> 434
/*     */     //   420: goto -> 427
/*     */     //   423: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   426: athrow
/*     */     //   427: aload #8
/*     */     //   429: invokestatic stripOwnerData : (Lorg/spongepowered/tools/obfuscation/ObfuscationData;)Lorg/spongepowered/tools/obfuscation/ObfuscationData;
/*     */     //   432: astore #8
/*     */     //   434: aload #9
/*     */     //   436: aload_0
/*     */     //   437: getfield classRef : Ljava/lang/String;
/*     */     //   440: aload_2
/*     */     //   441: aload #8
/*     */     //   443: invokeinterface addMethodMapping : (Ljava/lang/String;Ljava/lang/String;Lorg/spongepowered/tools/obfuscation/ObfuscationData;)V
/*     */     //   448: goto -> 716
/*     */     //   451: astore #10
/*     */     //   453: aload_0
/*     */     //   454: getfield mixin : Lorg/spongepowered/tools/obfuscation/AnnotatedMixin;
/*     */     //   457: invokevirtual isMultiTarget : ()Z
/*     */     //   460: ifeq -> 472
/*     */     //   463: ldc 'Multi-target'
/*     */     //   465: goto -> 474
/*     */     //   468: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   471: athrow
/*     */     //   472: ldc 'Target'
/*     */     //   474: astore #11
/*     */     //   476: aload_1
/*     */     //   477: invokevirtual hasCoerceArgument : ()Z
/*     */     //   480: ifeq -> 645
/*     */     //   483: aload_3
/*     */     //   484: getfield owner : Ljava/lang/String;
/*     */     //   487: ifnonnull -> 645
/*     */     //   490: goto -> 497
/*     */     //   493: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   496: athrow
/*     */     //   497: aload_3
/*     */     //   498: getfield desc : Ljava/lang/String;
/*     */     //   501: ifnonnull -> 645
/*     */     //   504: goto -> 511
/*     */     //   507: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   510: athrow
/*     */     //   511: aload #10
/*     */     //   513: invokevirtual getOld : ()Ljava/lang/String;
/*     */     //   516: invokestatic parse : (Ljava/lang/String;)Lorg/spongepowered/asm/mixin/injection/struct/MemberInfo;
/*     */     //   519: astore #12
/*     */     //   521: aload #10
/*     */     //   523: invokevirtual getNew : ()Ljava/lang/String;
/*     */     //   526: invokestatic parse : (Ljava/lang/String;)Lorg/spongepowered/asm/mixin/injection/struct/MemberInfo;
/*     */     //   529: astore #13
/*     */     //   531: aload #12
/*     */     //   533: getfield name : Ljava/lang/String;
/*     */     //   536: aload #13
/*     */     //   538: getfield name : Ljava/lang/String;
/*     */     //   541: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   544: ifeq -> 645
/*     */     //   547: aload #8
/*     */     //   549: invokestatic stripDescriptors : (Lorg/spongepowered/tools/obfuscation/ObfuscationData;)Lorg/spongepowered/tools/obfuscation/ObfuscationData;
/*     */     //   552: astore #8
/*     */     //   554: aload #9
/*     */     //   556: iconst_1
/*     */     //   557: invokeinterface setAllowConflicts : (Z)V
/*     */     //   562: aload #9
/*     */     //   564: aload_0
/*     */     //   565: getfield classRef : Ljava/lang/String;
/*     */     //   568: aload_2
/*     */     //   569: aload #8
/*     */     //   571: invokeinterface addMethodMapping : (Ljava/lang/String;Ljava/lang/String;Lorg/spongepowered/tools/obfuscation/ObfuscationData;)V
/*     */     //   576: aload #9
/*     */     //   578: iconst_0
/*     */     //   579: invokeinterface setAllowConflicts : (Z)V
/*     */     //   584: aload_1
/*     */     //   585: aload_0
/*     */     //   586: getfield ap : Lorg/spongepowered/tools/obfuscation/interfaces/IMixinAnnotationProcessor;
/*     */     //   589: getstatic javax/tools/Diagnostic$Kind.WARNING : Ljavax/tools/Diagnostic$Kind;
/*     */     //   592: new java/lang/StringBuilder
/*     */     //   595: dup
/*     */     //   596: invokespecial <init> : ()V
/*     */     //   599: ldc 'Coerced '
/*     */     //   601: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   604: aload #11
/*     */     //   606: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   609: ldc ' reference has conflicting descriptors for '
/*     */     //   611: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   614: aload #6
/*     */     //   616: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   619: ldc ': Storing bare references '
/*     */     //   621: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   624: aload #8
/*     */     //   626: invokevirtual values : ()Ljava/lang/String;
/*     */     //   629: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   632: ldc ' in refMap'
/*     */     //   634: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   637: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   640: invokevirtual printMessage : (Ljavax/annotation/processing/Messager;Ljavax/tools/Diagnostic$Kind;Ljava/lang/CharSequence;)V
/*     */     //   643: iconst_1
/*     */     //   644: ireturn
/*     */     //   645: aload_1
/*     */     //   646: aload_0
/*     */     //   647: getfield ap : Lorg/spongepowered/tools/obfuscation/interfaces/IMixinAnnotationProcessor;
/*     */     //   650: getstatic javax/tools/Diagnostic$Kind.ERROR : Ljavax/tools/Diagnostic$Kind;
/*     */     //   653: new java/lang/StringBuilder
/*     */     //   656: dup
/*     */     //   657: invokespecial <init> : ()V
/*     */     //   660: aload #11
/*     */     //   662: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   665: ldc ' reference conflict for '
/*     */     //   667: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   670: aload #6
/*     */     //   672: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   675: ldc ': '
/*     */     //   677: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   680: aload_2
/*     */     //   681: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   684: ldc ' -> '
/*     */     //   686: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   689: aload #10
/*     */     //   691: invokevirtual getNew : ()Ljava/lang/String;
/*     */     //   694: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   697: ldc ' previously defined as '
/*     */     //   699: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   702: aload #10
/*     */     //   704: invokevirtual getOld : ()Ljava/lang/String;
/*     */     //   707: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   710: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   713: invokevirtual printMessage : (Ljavax/annotation/processing/Messager;Ljavax/tools/Diagnostic$Kind;Ljava/lang/CharSequence;)V
/*     */     //   716: iconst_1
/*     */     //   717: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #11	-> 0
/*     */     //   #131	-> 8
/*     */     //   #84	-> 13
/*     */     //   #90	-> 45
/*     */     //   #55	-> 53
/*     */     //   #24	-> 99
/*     */     //   #54	-> 107
/*     */     //   #46	-> 153
/*     */     //   #81	-> 160
/*     */     //   #41	-> 201
/*     */     //   #31	-> 203
/*     */     //   #98	-> 231
/*     */     //   #67	-> 244
/*     */     //   #83	-> 262
/*     */     //   #57	-> 270
/*     */     //   #32	-> 285
/*     */     //   #111	-> 306
/*     */     //   #44	-> 313
/*     */     //   #76	-> 319
/*     */     //   #71	-> 341
/*     */     //   #38	-> 375
/*     */     //   #74	-> 377
/*     */     //   #91	-> 388
/*     */     //   #5	-> 427
/*     */     //   #127	-> 434
/*     */     //   #52	-> 448
/*     */     //   #120	-> 451
/*     */     //   #108	-> 453
/*     */     //   #9	-> 476
/*     */     //   #95	-> 511
/*     */     //   #30	-> 521
/*     */     //   #88	-> 531
/*     */     //   #21	-> 547
/*     */     //   #8	-> 554
/*     */     //   #47	-> 562
/*     */     //   #10	-> 576
/*     */     //   #125	-> 584
/*     */     //   #82	-> 626
/*     */     //   #106	-> 640
/*     */     //   #100	-> 643
/*     */     //   #113	-> 645
/*     */     //   #50	-> 691
/*     */     //   #103	-> 713
/*     */     //   #40	-> 716
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   8	23	26	org/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException
/*     */     //   13	36	36	org/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException
/*     */     //   45	95	95	org/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException
/*     */     //   99	149	149	org/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException
/*     */     //   153	194	197	org/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException
/*     */     //   262	278	281	org/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException
/*     */     //   306	315	315	org/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException
/*     */     //   319	332	332	org/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException
/*     */     //   388	405	408	org/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException
/*     */     //   388	448	451	org/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException
/*     */     //   395	420	423	org/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException
/*     */     //   453	468	468	org/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException
/*     */     //   476	490	493	org/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException
/*     */     //   483	504	507	org/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException
/*     */   }
/*     */   
/*     */   AnnotatedMixinElementHandlerInjector(IMixinAnnotationProcessor paramIMixinAnnotationProcessor, AnnotatedMixin paramAnnotatedMixin) {
/*  87 */     super(paramIMixinAnnotationProcessor, paramAnnotatedMixin);
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerInjectionPoint(AnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint, String paramString) {
/*     */     try {
/*  93 */       if (this.mixin.isInterface()) {
/*     */         this.ap.printMessage(Diagnostic.Kind.ERROR, "Injector in interface is unsupported", paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint.getElement());
/*     */       }
/*     */     } catch (ReferenceManager$ReferenceConflictException referenceManager$ReferenceConflictException) {
/*     */       throw b(null);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 105 */       if (!paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint.shouldRemap()) {
/*     */         return;
/*     */       }
/*     */     } catch (ReferenceManager$ReferenceConflictException referenceManager$ReferenceConflictException) {
/*     */       throw b(null);
/*     */     } 
/*     */     
/*     */     String str1 = InjectionPointData.parseType((String)paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint.getAt().getValue("value"));
/*     */     
/*     */     String str2 = (String)paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint.getAt().getValue("target");
/*     */ 
/*     */     
/*     */     try { if ("NEW".equals(str1))
/*     */       { remapNewTarget(String.format(paramString, new Object[] { str1 + ".<target>" }), str2, paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint);
/*     */         remapNewTarget(String.format(paramString, new Object[] { str1 + ".args[class]" }), paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint.getAtArg("class"), paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint); }
/*     */       else
/* 121 */       { remapReference(String.format(paramString, new Object[] { str1 + ".<target>" }), str2, paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint); }  }
/*     */     catch (ReferenceManager$ReferenceConflictException referenceManager$ReferenceConflictException) { throw b(null); }
/*     */      } protected final void remapReference(String paramString1, String paramString2, AnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint) { try { if (paramString2 == null)
/*     */         return;  }
/*     */     catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }
/*     */      try {  }
/*     */     catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }
/* 128 */      AnnotationMirror annotationMirror = ((this.ap.getCompilerEnvironment() == IMixinAnnotationProcessor.CompilerEnvironment.JDT) ? paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint.getAt() : paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint.getAnnotation()).asMirror(); MemberInfo memberInfo = MemberInfo.parse(paramString2); try { if (!memberInfo.isFullyQualified())
/*     */       { 
/* 130 */         try { if (memberInfo.owner == null) { try {  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  } else {  }  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  String str = "signature"; this.ap.printMessage(Diagnostic.Kind.ERROR, paramString1 + " is not fully qualified, missing " + str, paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint.getElement(), annotationMirror); }  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }
/*     */      try {
/* 132 */       memberInfo.validate();
/*     */     } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) {
/*     */       this.ap.printMessage(Diagnostic.Kind.ERROR, invalidMemberDescriptorException.getMessage(), paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint.getElement(), annotationMirror);
/*     */     } 
/*     */     try {
/*     */       if (memberInfo.isField()) {
/*     */         ObfuscationData obfuscationData = this.obf.getDataProvider().getObfFieldRecursive(memberInfo);
/*     */         if (obfuscationData.isEmpty()) {
/*     */           this.ap.printMessage(Diagnostic.Kind.WARNING, "Cannot find field mapping for " + paramString1 + " '" + paramString2 + "'", paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint.getElement(), annotationMirror);
/*     */           return;
/*     */         } 
/*     */         this.obf.getReferenceManager().addFieldMapping(this.classRef, paramString2, memberInfo, obfuscationData);
/*     */       } else {
/*     */         ObfuscationData obfuscationData = this.obf.getDataProvider().getObfMethodRecursive(memberInfo);
/*     */         try {
/*     */           if (obfuscationData.isEmpty())
/*     */             try {
/*     */               if (memberInfo.owner == null || !memberInfo.owner.startsWith("java/lang/")) {
/*     */                 this.ap.printMessage(Diagnostic.Kind.WARNING, "Cannot find method mapping for " + paramString1 + " '" + paramString2 + "'", paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint.getElement(), annotationMirror);
/*     */                 return;
/*     */               } 
/*     */             } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) {
/*     */               throw b(null);
/*     */             }  
/*     */         } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) {
/*     */           throw b(null);
/*     */         } 
/*     */         this.obf.getReferenceManager().addMethodMapping(this.classRef, paramString2, memberInfo, obfuscationData);
/*     */       } 
/*     */     } catch (ReferenceManager$ReferenceConflictException referenceManager$ReferenceConflictException) {
/*     */       this.ap.printMessage(Diagnostic.Kind.ERROR, "Unexpected reference conflict for " + paramString1 + ": " + paramString2 + " -> " + referenceManager$ReferenceConflictException.getNew() + " previously defined as " + referenceManager$ReferenceConflictException.getOld(), paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint.getElement(), annotationMirror);
/*     */       return;
/*     */     } 
/*     */     paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint.notifyRemapped(); }
/*     */ 
/*     */   
/*     */   protected final void remapNewTarget(String paramString1, String paramString2, AnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint) {
/*     */     try {
/*     */       if (paramString2 == null)
/*     */         return; 
/*     */     } catch (ReferenceManager$ReferenceConflictException referenceManager$ReferenceConflictException) {
/*     */       throw b(null);
/*     */     } 
/*     */     MemberInfo memberInfo = MemberInfo.parse(paramString2);
/*     */     String str = memberInfo.toCtorType();
/*     */     if (str != null) {
/*     */       String str1 = memberInfo.toCtorDesc();
/*     */       try {
/*     */       
/*     */       } catch (ReferenceManager$ReferenceConflictException referenceManager$ReferenceConflictException) {
/*     */         throw b(null);
/*     */       } 
/*     */       MappingMethod mappingMethod = new MappingMethod(str, ".", (str1 != null) ? str1 : "()V");
/*     */       ObfuscationData<MappingMethod> obfuscationData = this.obf.getDataProvider().getRemappedMethod(mappingMethod);
/*     */       try {
/*     */         if (obfuscationData.isEmpty())
/*     */           this.ap.printMessage(Diagnostic.Kind.WARNING, "Cannot find class mapping for " + paramString1 + " '" + str + "'", paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint.getElement(), paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint.getAnnotation().asMirror()); 
/*     */       } catch (ReferenceManager$ReferenceConflictException referenceManager$ReferenceConflictException) {
/*     */         throw b(null);
/*     */       } 
/*     */       ObfuscationData<String> obfuscationData1 = new ObfuscationData();
/*     */       for (ObfuscationType obfuscationType : obfuscationData) {
/*     */         MappingMethod mappingMethod1 = obfuscationData.get(obfuscationType);
/*     */         try {
/*     */           if (str1 == null)
/*     */             obfuscationData1.put(obfuscationType, mappingMethod1.getOwner()); 
/*     */         } catch (ReferenceManager$ReferenceConflictException referenceManager$ReferenceConflictException) {
/*     */           throw b(null);
/*     */         } 
/*     */       } 
/*     */       this.obf.getReferenceManager().addClassMapping(this.classRef, paramString2, obfuscationData1);
/*     */     } 
/*     */     paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint.notifyRemapped();
/*     */   }
/*     */   
/*     */   public void registerInjector(AnnotatedMixinElementHandlerInjector$AnnotatedElementInjector paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjector) {
/*     */     try {
/*     */       if (this.mixin.isInterface())
/*     */         this.ap.printMessage(Diagnostic.Kind.ERROR, "Injector in interface is unsupported", paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjector.getElement()); 
/*     */     } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) {
/*     */       throw b(null);
/*     */     } 
/*     */     for (String str : paramAnnotatedMixinElementHandlerInjector$AnnotatedElementInjector.getAnnotation().getList("method"))
/*     */       MemberInfo memberInfo = MemberInfo.parse(str); 
/*     */   }
/*     */   
/*     */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*     */     return paramRuntimeException;
/*     */   }
/*     */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\AnnotatedMixinElementHandlerInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */