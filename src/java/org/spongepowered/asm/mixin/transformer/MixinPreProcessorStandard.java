/*     */ package org.spongepowered.asm.mixin.transformer;
/*     */ import org.spongepowered.asm.lib.tree.FieldNode;
/*   3 */ class MixinPreProcessorStandard { private void conformInjector(ClassInfo paramClassInfo, MixinInfo$MixinMethodNode paramMixinInfo$MixinMethodNode, ClassInfo$Method paramClassInfo$Method) { MethodMapper methodMapper = paramClassInfo.getMethodMapper(); methodMapper.remapHandlerMethod(this.mixin, paramMixinInfo$MixinMethodNode, paramClassInfo$Method); } protected void transformField(FieldInsnNode paramFieldInsnNode) { Profiler.Section section = this.profiler.begin("meta"); ClassInfo classInfo = ClassInfo.forName(paramFieldInsnNode.owner); try { if (classInfo == null) throw new RuntimeException(new ClassNotFoundException(paramFieldInsnNode.owner.replace('/', '.')));  } catch (IllegalStateException illegalStateException) { throw b(null); }  ClassInfo$Field classInfo$Field = classInfo.findField(paramFieldInsnNode, 2); try { section.end(); if (classInfo$Field != null) try { if (classInfo$Field.isRenamed()) paramFieldInsnNode.name = classInfo$Field.getName();  } catch (IllegalStateException illegalStateException) { throw b(null); }   } catch (IllegalStateException illegalStateException) { throw b(null); }  } private void conformVisibility(MixinTargetContext paramMixinTargetContext, MixinInfo$MixinMethodNode paramMixinInfo$MixinMethodNode, MixinPreProcessorStandard$SpecialMethod paramMixinPreProcessorStandard$SpecialMethod, MethodNode paramMethodNode) { Bytecode.Visibility visibility1 = Bytecode.getVisibility(paramMethodNode);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 203 */     Bytecode.Visibility visibility2 = Bytecode.getVisibility(paramMixinInfo$MixinMethodNode);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 257 */       if (visibility2.ordinal() >= visibility1.ordinal()) {
/*     */         try {
/*     */           if (visibility1 == Bytecode.Visibility.PRIVATE) {
/*     */             try {
/*     */               if (visibility2.ordinal() > Bytecode.Visibility.PRIVATE.ordinal()) {
/*     */                 paramMixinTargetContext.getTarget().addUpgradedMethod(paramMethodNode);
/*     */               }
/*     */             } catch (IllegalStateException illegalStateException) {
/*     */               throw b(null);
/*     */             } 
/*     */           }
/*     */         } catch (IllegalStateException illegalStateException) {
/*     */           throw b(null);
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } catch (IllegalStateException illegalStateException) {
/*     */       throw b(null);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*     */     String str = String.format("%s %s method %s in %s cannot reduce visibiliy of %s target method", new Object[] { visibility2, paramMixinPreProcessorStandard$SpecialMethod, paramMixinInfo$MixinMethodNode.name, this.mixin, visibility1 });
/*     */ 
/*     */     
/*     */     try {
/*     */       if (paramMixinPreProcessorStandard$SpecialMethod.isOverwrite)
/*     */         
/*     */         try { if (!this.mixin.getParent().conformOverwriteVisibility())
/* 289 */             throw new InvalidMixinException(this.mixin, str);  } catch (IllegalStateException illegalStateException) { throw b(null); }
/*     */          
/*     */     } catch (IllegalStateException illegalStateException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (visibility2 == Bytecode.Visibility.PRIVATE) {
/*     */         try {
/*     */           if (paramMixinPreProcessorStandard$SpecialMethod.isOverwrite)
/*     */             logger.warn("Static binding violation: {}, visibility will be upgraded.", new Object[] { str }); 
/*     */         } catch (IllegalStateException illegalStateException) {
/*     */           throw b(null);
/*     */         } 
/*     */         paramMixinTargetContext.addUpgradedMethod(paramMixinInfo$MixinMethodNode);
/*     */         Bytecode.setVisibility(paramMixinInfo$MixinMethodNode, visibility1);
/*     */       } 
/*     */     } catch (IllegalStateException illegalStateException) {
/*     */       throw b(null);
/*     */     }  }
/*     */   protected boolean validateMethod(MixinTargetContext paramMixinTargetContext, MixinInfo$MixinMethodNode paramMixinInfo$MixinMethodNode) { return true; } protected boolean attachOverwriteMethod(MixinTargetContext paramMixinTargetContext, MixinInfo$MixinMethodNode paramMixinInfo$MixinMethodNode) {
/*     */     return attachSpecialMethod(paramMixinTargetContext, paramMixinInfo$MixinMethodNode, MixinPreProcessorStandard$SpecialMethod.OVERWRITE);
/*     */   } private static String getDynamicInfo(String paramString, AnnotationNode paramAnnotationNode) {
/*     */     String str = Strings.nullToEmpty((String)Annotations.getValue(paramAnnotationNode));
/* 312 */     Type type = (Type)Annotations.getValue(paramAnnotationNode, "mixin"); if (type != null)
/*     */       str = String.format("{%s} %s", new Object[] { type.getClassName(), str }).trim();  try {  } catch (IllegalStateException illegalStateException) { throw b(null); }  return (str.length() > 0) ? String.format(" %s is @Dynamic(%s)", new Object[] { paramString, str }) : ""; } final MixinPreProcessorStandard conform(TargetClassContext paramTargetClassContext) { return conform(paramTargetClassContext.getClassInfo()); }
/*     */   final MixinPreProcessorStandard attach(MixinTargetContext paramMixinTargetContext) { try { if (this.attached)
/* 315 */         throw new IllegalStateException("Preprocessor was already attached");  } catch (IllegalStateException illegalStateException) { throw b(null); }  this.attached = true; Profiler.Section section1 = this.profiler.begin("attach"); Profiler.Section section2 = this.profiler.begin("methods"); attachMethods(paramMixinTargetContext); section2 = section2.next("fields"); attachFields(paramMixinTargetContext); section2 = section2.next("transform"); transform(paramMixinTargetContext); section2.end(); section1.end(); return this; } MixinPreProcessorStandard(MixinInfo paramMixinInfo, MixinInfo$MixinClassNode paramMixinInfo$MixinClassNode) { this.profiler = MixinEnvironment.getProfiler(); this.mixin = paramMixinInfo;
/*     */     this.classNode = paramMixinInfo$MixinClassNode;
/*     */     this.env = paramMixinInfo.getParent().getEnvironment();
/*     */     this.verboseLogging = this.env.getOption(MixinEnvironment.Option.DEBUG_VERBOSE);
/* 319 */     this.strictUnique = this.env.getOption(MixinEnvironment.Option.DEBUG_UNIQUE); }
/*     */ 
/*     */   
/*     */   protected static String getDynamicInfo(FieldNode paramFieldNode) {
/*     */     return getDynamicInfo("Field", Annotations.getInvisible(paramFieldNode, Dynamic.class));
/*     */   }
/*     */   
/*     */   protected void attachMethod(MixinTargetContext paramMixinTargetContext, MixinInfo$MixinMethodNode paramMixinInfo$MixinMethodNode) {
/*     */     ClassInfo$Method classInfo$Method1 = this.mixin.getClassInfo().findMethod(paramMixinInfo$MixinMethodNode);
/*     */     try {
/*     */       if (classInfo$Method1 == null)
/*     */         return; 
/*     */     } catch (IllegalStateException illegalStateException) {
/*     */       throw b(null);
/*     */     } 
/*     */     ClassInfo$Method classInfo$Method2 = this.mixin.getClassInfo().findMethodInHierarchy(paramMixinInfo$MixinMethodNode, ClassInfo$SearchType.SUPER_CLASSES_ONLY);
/*     */     try {
/*     */       if (classInfo$Method2 != null)
/*     */         try {
/*     */           if (classInfo$Method2.isRenamed())
/*     */             paramMixinInfo$MixinMethodNode.name = classInfo$Method1.renameTo(classInfo$Method2.getName()); 
/*     */         } catch (IllegalStateException illegalStateException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (IllegalStateException illegalStateException) {
/*     */       throw b(null);
/*     */     } 
/*     */     MethodNode methodNode = paramMixinTargetContext.findMethod(paramMixinInfo$MixinMethodNode, (AnnotationNode)null);
/*     */     try {
/*     */       if (methodNode != null)
/*     */         conformVisibility(paramMixinTargetContext, paramMixinInfo$MixinMethodNode, MixinPreProcessorStandard$SpecialMethod.MERGE, methodNode); 
/*     */     } catch (IllegalStateException illegalStateException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected static String getDynamicInfo(MethodNode paramMethodNode) {
/*     */     return getDynamicInfo("Method", Annotations.getInvisible(paramMethodNode, Dynamic.class));
/*     */   }
/*     */   
/*     */   private static final Logger logger = LogManager.getLogger("mixin");
/*     */   protected final MixinInfo mixin;
/*     */   protected final MixinInfo$MixinClassNode classNode;
/*     */   protected final MixinEnvironment env;
/*     */   protected final Profiler profiler;
/*     */   private final boolean verboseLogging;
/*     */   private final boolean strictUnique;
/*     */   private boolean prepared;
/*     */   private boolean attached;
/*     */   
/*     */   protected void prepareField(FieldNode paramFieldNode) {}
/*     */   
/*     */   final MixinPreProcessorStandard conform(ClassInfo paramClassInfo) {
/*     */     Profiler.Section section = this.profiler.begin("conform");
/*     */     for (MixinInfo$MixinMethodNode mixinInfo$MixinMethodNode : this.classNode.mixinMethods) {
/*     */       if (mixinInfo$MixinMethodNode.isInjector()) {
/*     */         ClassInfo$Method classInfo$Method = this.mixin.getClassInfo().findMethod(mixinInfo$MixinMethodNode, 10);
/*     */         conformInjector(paramClassInfo, mixinInfo$MixinMethodNode, classInfo$Method);
/*     */       } 
/*     */     } 
/*     */     section.end();
/*     */     return this;
/*     */   }
/*     */   
/*     */   protected boolean attachInjectorMethod(MixinTargetContext paramMixinTargetContext, MixinInfo$MixinMethodNode paramMixinInfo$MixinMethodNode) {
/*     */     return paramMixinInfo$MixinMethodNode.isInjector();
/*     */   }
/*     */   
/*     */   protected boolean attachAccessorMethod(MixinTargetContext paramMixinTargetContext, MixinInfo$MixinMethodNode paramMixinInfo$MixinMethodNode, MixinPreProcessorStandard$SpecialMethod paramMixinPreProcessorStandard$SpecialMethod) {
/*     */     // Byte code:
/*     */     //   0: aload_2
/*     */     //   1: aload_3
/*     */     //   2: getfield annotation : Ljava/lang/Class;
/*     */     //   5: invokevirtual getVisibleAnnotation : (Ljava/lang/Class;)Lorg/spongepowered/asm/lib/tree/AnnotationNode;
/*     */     //   8: astore #4
/*     */     //   10: aload #4
/*     */     //   12: ifnonnull -> 21
/*     */     //   15: iconst_0
/*     */     //   16: ireturn
/*     */     //   17: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   20: athrow
/*     */     //   21: new java/lang/StringBuilder
/*     */     //   24: dup
/*     */     //   25: invokespecial <init> : ()V
/*     */     //   28: aload_3
/*     */     //   29: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   32: ldc ' method '
/*     */     //   34: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   37: aload_2
/*     */     //   38: getfield name : Ljava/lang/String;
/*     */     //   41: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   44: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   47: astore #5
/*     */     //   49: aload_0
/*     */     //   50: aload_2
/*     */     //   51: aload_3
/*     */     //   52: invokevirtual getSpecialMethod : (Lorg/spongepowered/asm/mixin/transformer/MixinInfo$MixinMethodNode;Lorg/spongepowered/asm/mixin/transformer/MixinPreProcessorStandard$SpecialMethod;)Lorg/spongepowered/asm/mixin/transformer/ClassInfo$Method;
/*     */     //   55: astore #6
/*     */     //   57: invokestatic getCompatibilityLevel : ()Lorg/spongepowered/asm/mixin/MixinEnvironment$CompatibilityLevel;
/*     */     //   60: getstatic org/spongepowered/asm/mixin/MixinEnvironment$CompatibilityLevel.JAVA_8 : Lorg/spongepowered/asm/mixin/MixinEnvironment$CompatibilityLevel;
/*     */     //   63: invokevirtual isAtLeast : (Lorg/spongepowered/asm/mixin/MixinEnvironment$CompatibilityLevel;)Z
/*     */     //   66: ifeq -> 209
/*     */     //   69: aload #6
/*     */     //   71: invokevirtual isStatic : ()Z
/*     */     //   74: ifeq -> 209
/*     */     //   77: goto -> 84
/*     */     //   80: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   83: athrow
/*     */     //   84: aload_0
/*     */     //   85: getfield mixin : Lorg/spongepowered/asm/mixin/transformer/MixinInfo;
/*     */     //   88: invokevirtual getTargets : ()Ljava/util/List;
/*     */     //   91: invokeinterface size : ()I
/*     */     //   96: iconst_1
/*     */     //   97: if_icmple -> 140
/*     */     //   100: goto -> 107
/*     */     //   103: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   106: athrow
/*     */     //   107: new org/spongepowered/asm/mixin/gen/throwables/InvalidAccessorException
/*     */     //   110: dup
/*     */     //   111: aload_1
/*     */     //   112: new java/lang/StringBuilder
/*     */     //   115: dup
/*     */     //   116: invokespecial <init> : ()V
/*     */     //   119: aload #5
/*     */     //   121: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   124: ldc ' in multi-target mixin is invalid. Mixin must have exactly 1 target.'
/*     */     //   126: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   129: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   132: invokespecial <init> : (Lorg/spongepowered/asm/mixin/refmap/IMixinContext;Ljava/lang/String;)V
/*     */     //   135: athrow
/*     */     //   136: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   139: athrow
/*     */     //   140: aload_1
/*     */     //   141: aload_2
/*     */     //   142: iconst_1
/*     */     //   143: invokevirtual getUniqueName : (Lorg/spongepowered/asm/lib/tree/MethodNode;Z)Ljava/lang/String;
/*     */     //   146: astore #7
/*     */     //   148: getstatic org/spongepowered/asm/mixin/transformer/MixinPreProcessorStandard.logger : Lorg/apache/logging/log4j/Logger;
/*     */     //   151: aload_0
/*     */     //   152: getfield mixin : Lorg/spongepowered/asm/mixin/transformer/MixinInfo;
/*     */     //   155: invokevirtual getLoggingLevel : ()Lorg/apache/logging/log4j/Level;
/*     */     //   158: ldc 'Renaming @Unique method {}{} to {} in {}'
/*     */     //   160: iconst_4
/*     */     //   161: anewarray java/lang/Object
/*     */     //   164: dup
/*     */     //   165: iconst_0
/*     */     //   166: aload_2
/*     */     //   167: getfield name : Ljava/lang/String;
/*     */     //   170: aastore
/*     */     //   171: dup
/*     */     //   172: iconst_1
/*     */     //   173: aload_2
/*     */     //   174: getfield desc : Ljava/lang/String;
/*     */     //   177: aastore
/*     */     //   178: dup
/*     */     //   179: iconst_2
/*     */     //   180: aload #7
/*     */     //   182: aastore
/*     */     //   183: dup
/*     */     //   184: iconst_3
/*     */     //   185: aload_0
/*     */     //   186: getfield mixin : Lorg/spongepowered/asm/mixin/transformer/MixinInfo;
/*     */     //   189: aastore
/*     */     //   190: invokeinterface log : (Lorg/apache/logging/log4j/Level;Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   195: aload_2
/*     */     //   196: aload #6
/*     */     //   198: aload #7
/*     */     //   200: invokevirtual renameTo : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   203: putfield name : Ljava/lang/String;
/*     */     //   206: goto -> 291
/*     */     //   209: aload #6
/*     */     //   211: invokevirtual isAbstract : ()Z
/*     */     //   214: ifne -> 250
/*     */     //   217: new org/spongepowered/asm/mixin/gen/throwables/InvalidAccessorException
/*     */     //   220: dup
/*     */     //   221: aload_1
/*     */     //   222: new java/lang/StringBuilder
/*     */     //   225: dup
/*     */     //   226: invokespecial <init> : ()V
/*     */     //   229: aload #5
/*     */     //   231: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   234: ldc ' is not abstract'
/*     */     //   236: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   239: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   242: invokespecial <init> : (Lorg/spongepowered/asm/mixin/refmap/IMixinContext;Ljava/lang/String;)V
/*     */     //   245: athrow
/*     */     //   246: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   249: athrow
/*     */     //   250: aload #6
/*     */     //   252: invokevirtual isStatic : ()Z
/*     */     //   255: ifeq -> 291
/*     */     //   258: new org/spongepowered/asm/mixin/gen/throwables/InvalidAccessorException
/*     */     //   261: dup
/*     */     //   262: aload_1
/*     */     //   263: new java/lang/StringBuilder
/*     */     //   266: dup
/*     */     //   267: invokespecial <init> : ()V
/*     */     //   270: aload #5
/*     */     //   272: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   275: ldc ' cannot be static'
/*     */     //   277: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   280: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   283: invokespecial <init> : (Lorg/spongepowered/asm/mixin/refmap/IMixinContext;Ljava/lang/String;)V
/*     */     //   286: athrow
/*     */     //   287: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   290: athrow
/*     */     //   291: aload_1
/*     */     //   292: aload_2
/*     */     //   293: aload_3
/*     */     //   294: getfield annotation : Ljava/lang/Class;
/*     */     //   297: invokevirtual addAccessorMethod : (Lorg/spongepowered/asm/lib/tree/MethodNode;Ljava/lang/Class;)V
/*     */     //   300: iconst_1
/*     */     //   301: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #157	-> 0
/*     */     //   #299	-> 10
/*     */     //   #265	-> 15
/*     */     //   #160	-> 21
/*     */     //   #209	-> 49
/*     */     //   #300	-> 57
/*     */     //   #309	-> 84
/*     */     //   #151	-> 107
/*     */     //   #8	-> 140
/*     */     //   #218	-> 148
/*     */     //   #34	-> 195
/*     */     //   #297	-> 206
/*     */     //   #20	-> 209
/*     */     //   #11	-> 217
/*     */     //   #13	-> 250
/*     */     //   #49	-> 258
/*     */     //   #242	-> 291
/*     */     //   #126	-> 300
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   10	17	17	java/lang/IllegalStateException
/*     */     //   57	77	80	java/lang/IllegalStateException
/*     */     //   69	100	103	java/lang/IllegalStateException
/*     */     //   84	136	136	java/lang/IllegalStateException
/*     */     //   209	246	246	java/lang/IllegalStateException
/*     */     //   250	287	287	java/lang/IllegalStateException
/*     */   }
/*     */   
/*     */   protected void prepareMethod(MixinInfo$MixinMethodNode paramMixinInfo$MixinMethodNode, ClassInfo$Method paramClassInfo$Method) {
/*     */     prepareShadow(paramMixinInfo$MixinMethodNode, paramClassInfo$Method);
/*     */     prepareSoftImplements(paramMixinInfo$MixinMethodNode, paramClassInfo$Method);
/*     */   }
/*     */   
/*     */   protected void prepareSoftImplements(MixinInfo$MixinMethodNode paramMixinInfo$MixinMethodNode, ClassInfo$Method paramClassInfo$Method) {
/*     */     for (InterfaceInfo interfaceInfo : this.mixin.getSoftImplements()) {
/*     */       try {
/*     */         if (interfaceInfo.renameMethod(paramMixinInfo$MixinMethodNode))
/*     */           paramClassInfo$Method.renameTo(paramMixinInfo$MixinMethodNode.name); 
/*     */       } catch (IllegalStateException illegalStateException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void transformMethod(MethodInsnNode paramMethodInsnNode) {
/*     */     Profiler.Section section = this.profiler.begin("meta");
/*     */     ClassInfo classInfo = ClassInfo.forName(paramMethodInsnNode.owner);
/*     */     try {
/*     */       if (classInfo == null)
/*     */         throw new RuntimeException(new ClassNotFoundException(paramMethodInsnNode.owner.replace('/', '.'))); 
/*     */     } catch (IllegalStateException illegalStateException) {
/*     */       throw b(null);
/*     */     } 
/*     */     ClassInfo$Method classInfo$Method = classInfo.findMethodInHierarchy(paramMethodInsnNode, ClassInfo$SearchType.ALL_CLASSES, 2);
/*     */     try {
/*     */       section.end();
/*     */       if (classInfo$Method != null)
/*     */         try {
/*     */           if (classInfo$Method.isRenamed())
/*     */             paramMethodInsnNode.name = classInfo$Method.getName(); 
/*     */         } catch (IllegalStateException illegalStateException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (IllegalStateException illegalStateException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void prepareShadow(MixinInfo$MixinMethodNode paramMixinInfo$MixinMethodNode, ClassInfo$Method paramClassInfo$Method) {
/*     */     AnnotationNode annotationNode = Annotations.getVisible(paramMixinInfo$MixinMethodNode, Shadow.class);
/*     */     try {
/*     */       if (annotationNode == null)
/*     */         return; 
/*     */     } catch (IllegalStateException illegalStateException) {
/*     */       throw b(null);
/*     */     } 
/*     */     String str = (String)Annotations.getValue(annotationNode, "prefix", Shadow.class);
/*     */     if (paramMixinInfo$MixinMethodNode.name.startsWith(str)) {
/*     */       Annotations.setVisible(paramMixinInfo$MixinMethodNode, MixinRenamed.class, new Object[] { "originalName", paramMixinInfo$MixinMethodNode.name });
/*     */       String str1 = paramMixinInfo$MixinMethodNode.name.substring(str.length());
/*     */       paramMixinInfo$MixinMethodNode.name = paramClassInfo$Method.renameTo(str1);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected boolean attachSpecialMethod(MixinTargetContext paramMixinTargetContext, MixinInfo$MixinMethodNode paramMixinInfo$MixinMethodNode, MixinPreProcessorStandard$SpecialMethod paramMixinPreProcessorStandard$SpecialMethod) {
/*     */     // Byte code:
/*     */     //   0: aload_2
/*     */     //   1: aload_3
/*     */     //   2: getfield annotation : Ljava/lang/Class;
/*     */     //   5: invokevirtual getVisibleAnnotation : (Ljava/lang/Class;)Lorg/spongepowered/asm/lib/tree/AnnotationNode;
/*     */     //   8: astore #4
/*     */     //   10: aload #4
/*     */     //   12: ifnonnull -> 21
/*     */     //   15: iconst_0
/*     */     //   16: ireturn
/*     */     //   17: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   20: athrow
/*     */     //   21: aload_3
/*     */     //   22: getfield isOverwrite : Z
/*     */     //   25: ifeq -> 41
/*     */     //   28: aload_0
/*     */     //   29: aload_2
/*     */     //   30: aload_3
/*     */     //   31: invokevirtual checkMixinNotUnique : (Lorg/spongepowered/asm/mixin/transformer/MixinInfo$MixinMethodNode;Lorg/spongepowered/asm/mixin/transformer/MixinPreProcessorStandard$SpecialMethod;)V
/*     */     //   34: goto -> 41
/*     */     //   37: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   40: athrow
/*     */     //   41: aload_0
/*     */     //   42: aload_2
/*     */     //   43: aload_3
/*     */     //   44: invokevirtual getSpecialMethod : (Lorg/spongepowered/asm/mixin/transformer/MixinInfo$MixinMethodNode;Lorg/spongepowered/asm/mixin/transformer/MixinPreProcessorStandard$SpecialMethod;)Lorg/spongepowered/asm/mixin/transformer/ClassInfo$Method;
/*     */     //   47: astore #5
/*     */     //   49: aload_1
/*     */     //   50: aload_2
/*     */     //   51: aload #4
/*     */     //   53: invokevirtual findMethod : (Lorg/spongepowered/asm/lib/tree/MethodNode;Lorg/spongepowered/asm/lib/tree/AnnotationNode;)Lorg/spongepowered/asm/lib/tree/MethodNode;
/*     */     //   56: astore #6
/*     */     //   58: aload #6
/*     */     //   60: ifnonnull -> 179
/*     */     //   63: aload_3
/*     */     //   64: getfield isOverwrite : Z
/*     */     //   67: ifeq -> 83
/*     */     //   70: goto -> 77
/*     */     //   73: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   76: athrow
/*     */     //   77: iconst_0
/*     */     //   78: ireturn
/*     */     //   79: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   82: athrow
/*     */     //   83: aload_1
/*     */     //   84: aload_2
/*     */     //   85: invokevirtual findRemappedMethod : (Lorg/spongepowered/asm/lib/tree/MethodNode;)Lorg/spongepowered/asm/lib/tree/MethodNode;
/*     */     //   88: astore #6
/*     */     //   90: aload #6
/*     */     //   92: ifnonnull -> 165
/*     */     //   95: new org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */     //   98: dup
/*     */     //   99: aload_0
/*     */     //   100: getfield mixin : Lorg/spongepowered/asm/mixin/transformer/MixinInfo;
/*     */     //   103: ldc '%s method %s in %s was not located in the target class %s. %s%s'
/*     */     //   105: bipush #6
/*     */     //   107: anewarray java/lang/Object
/*     */     //   110: dup
/*     */     //   111: iconst_0
/*     */     //   112: aload_3
/*     */     //   113: aastore
/*     */     //   114: dup
/*     */     //   115: iconst_1
/*     */     //   116: aload_2
/*     */     //   117: getfield name : Ljava/lang/String;
/*     */     //   120: aastore
/*     */     //   121: dup
/*     */     //   122: iconst_2
/*     */     //   123: aload_0
/*     */     //   124: getfield mixin : Lorg/spongepowered/asm/mixin/transformer/MixinInfo;
/*     */     //   127: aastore
/*     */     //   128: dup
/*     */     //   129: iconst_3
/*     */     //   130: aload_1
/*     */     //   131: invokevirtual getTarget : ()Lorg/spongepowered/asm/mixin/transformer/TargetClassContext;
/*     */     //   134: aastore
/*     */     //   135: dup
/*     */     //   136: iconst_4
/*     */     //   137: aload_1
/*     */     //   138: invokevirtual getReferenceMapper : ()Lorg/spongepowered/asm/mixin/refmap/IReferenceMapper;
/*     */     //   141: invokeinterface getStatus : ()Ljava/lang/String;
/*     */     //   146: aastore
/*     */     //   147: dup
/*     */     //   148: iconst_5
/*     */     //   149: aload_2
/*     */     //   150: invokestatic getDynamicInfo : (Lorg/spongepowered/asm/lib/tree/MethodNode;)Ljava/lang/String;
/*     */     //   153: aastore
/*     */     //   154: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   157: invokespecial <init> : (Lorg/spongepowered/asm/mixin/extensibility/IMixinInfo;Ljava/lang/String;)V
/*     */     //   160: athrow
/*     */     //   161: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   164: athrow
/*     */     //   165: aload_2
/*     */     //   166: aload #5
/*     */     //   168: aload #6
/*     */     //   170: getfield name : Ljava/lang/String;
/*     */     //   173: invokevirtual renameTo : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   176: putfield name : Ljava/lang/String;
/*     */     //   179: ldc '<init>'
/*     */     //   181: aload #6
/*     */     //   183: getfield name : Ljava/lang/String;
/*     */     //   186: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   189: ifeq -> 231
/*     */     //   192: new org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */     //   195: dup
/*     */     //   196: aload_0
/*     */     //   197: getfield mixin : Lorg/spongepowered/asm/mixin/transformer/MixinInfo;
/*     */     //   200: ldc 'Nice try! %s in %s cannot alias a constructor'
/*     */     //   202: iconst_2
/*     */     //   203: anewarray java/lang/Object
/*     */     //   206: dup
/*     */     //   207: iconst_0
/*     */     //   208: aload_2
/*     */     //   209: getfield name : Ljava/lang/String;
/*     */     //   212: aastore
/*     */     //   213: dup
/*     */     //   214: iconst_1
/*     */     //   215: aload_0
/*     */     //   216: getfield mixin : Lorg/spongepowered/asm/mixin/transformer/MixinInfo;
/*     */     //   219: aastore
/*     */     //   220: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   223: invokespecial <init> : (Lorg/spongepowered/asm/mixin/extensibility/IMixinInfo;Ljava/lang/String;)V
/*     */     //   226: athrow
/*     */     //   227: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   230: athrow
/*     */     //   231: aload_2
/*     */     //   232: aload #6
/*     */     //   234: bipush #8
/*     */     //   236: invokestatic compareFlags : (Lorg/spongepowered/asm/lib/tree/MethodNode;Lorg/spongepowered/asm/lib/tree/MethodNode;I)Z
/*     */     //   239: ifne -> 285
/*     */     //   242: new org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */     //   245: dup
/*     */     //   246: aload_0
/*     */     //   247: getfield mixin : Lorg/spongepowered/asm/mixin/transformer/MixinInfo;
/*     */     //   250: ldc 'STATIC modifier of %s method %s in %s does not match the target'
/*     */     //   252: iconst_3
/*     */     //   253: anewarray java/lang/Object
/*     */     //   256: dup
/*     */     //   257: iconst_0
/*     */     //   258: aload_3
/*     */     //   259: aastore
/*     */     //   260: dup
/*     */     //   261: iconst_1
/*     */     //   262: aload_2
/*     */     //   263: getfield name : Ljava/lang/String;
/*     */     //   266: aastore
/*     */     //   267: dup
/*     */     //   268: iconst_2
/*     */     //   269: aload_0
/*     */     //   270: getfield mixin : Lorg/spongepowered/asm/mixin/transformer/MixinInfo;
/*     */     //   273: aastore
/*     */     //   274: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   277: invokespecial <init> : (Lorg/spongepowered/asm/mixin/extensibility/IMixinInfo;Ljava/lang/String;)V
/*     */     //   280: athrow
/*     */     //   281: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   284: athrow
/*     */     //   285: aload_0
/*     */     //   286: aload_1
/*     */     //   287: aload_2
/*     */     //   288: aload_3
/*     */     //   289: aload #6
/*     */     //   291: invokespecial conformVisibility : (Lorg/spongepowered/asm/mixin/transformer/MixinTargetContext;Lorg/spongepowered/asm/mixin/transformer/MixinInfo$MixinMethodNode;Lorg/spongepowered/asm/mixin/transformer/MixinPreProcessorStandard$SpecialMethod;Lorg/spongepowered/asm/lib/tree/MethodNode;)V
/*     */     //   294: aload #6
/*     */     //   296: getfield name : Ljava/lang/String;
/*     */     //   299: aload_2
/*     */     //   300: getfield name : Ljava/lang/String;
/*     */     //   303: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   306: ifne -> 393
/*     */     //   309: aload_3
/*     */     //   310: getfield isOverwrite : Z
/*     */     //   313: ifeq -> 379
/*     */     //   316: goto -> 323
/*     */     //   319: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   322: athrow
/*     */     //   323: aload #6
/*     */     //   325: getfield access : I
/*     */     //   328: iconst_2
/*     */     //   329: iand
/*     */     //   330: ifne -> 379
/*     */     //   333: goto -> 340
/*     */     //   336: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   339: athrow
/*     */     //   340: new org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */     //   343: dup
/*     */     //   344: aload_0
/*     */     //   345: getfield mixin : Lorg/spongepowered/asm/mixin/transformer/MixinInfo;
/*     */     //   348: new java/lang/StringBuilder
/*     */     //   351: dup
/*     */     //   352: invokespecial <init> : ()V
/*     */     //   355: ldc 'Non-private method cannot be aliased. Found '
/*     */     //   357: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   360: aload #6
/*     */     //   362: getfield name : Ljava/lang/String;
/*     */     //   365: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   368: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   371: invokespecial <init> : (Lorg/spongepowered/asm/mixin/extensibility/IMixinInfo;Ljava/lang/String;)V
/*     */     //   374: athrow
/*     */     //   375: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   378: athrow
/*     */     //   379: aload_2
/*     */     //   380: aload #5
/*     */     //   382: aload #6
/*     */     //   384: getfield name : Ljava/lang/String;
/*     */     //   387: invokevirtual renameTo : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   390: putfield name : Ljava/lang/String;
/*     */     //   393: iconst_1
/*     */     //   394: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #196	-> 0
/*     */     //   #139	-> 10
/*     */     //   #98	-> 15
/*     */     //   #148	-> 21
/*     */     //   #77	-> 28
/*     */     //   #150	-> 41
/*     */     //   #110	-> 49
/*     */     //   #191	-> 58
/*     */     //   #76	-> 63
/*     */     //   #94	-> 77
/*     */     //   #2	-> 83
/*     */     //   #292	-> 90
/*     */     //   #217	-> 95
/*     */     //   #263	-> 131
/*     */     //   #194	-> 150
/*     */     //   #286	-> 154
/*     */     //   #170	-> 165
/*     */     //   #39	-> 179
/*     */     //   #83	-> 192
/*     */     //   #43	-> 231
/*     */     //   #57	-> 242
/*     */     //   #223	-> 285
/*     */     //   #184	-> 294
/*     */     //   #61	-> 309
/*     */     //   #200	-> 340
/*     */     //   #243	-> 379
/*     */     //   #36	-> 393
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   10	17	17	java/lang/IllegalStateException
/*     */     //   21	34	37	java/lang/IllegalStateException
/*     */     //   58	70	73	java/lang/IllegalStateException
/*     */     //   63	79	79	java/lang/IllegalStateException
/*     */     //   90	161	161	java/lang/IllegalStateException
/*     */     //   179	227	227	java/lang/IllegalStateException
/*     */     //   231	281	281	java/lang/IllegalStateException
/*     */     //   285	316	319	java/lang/IllegalStateException
/*     */     //   309	333	336	java/lang/IllegalStateException
/*     */     //   323	375	375	java/lang/IllegalStateException
/*     */   }
/*     */   
/*     */   protected boolean attachShadowMethod(MixinTargetContext paramMixinTargetContext, MixinInfo$MixinMethodNode paramMixinInfo$MixinMethodNode) {
/*     */     return attachSpecialMethod(paramMixinTargetContext, paramMixinInfo$MixinMethodNode, MixinPreProcessorStandard$SpecialMethod.SHADOW);
/*     */   }
/*     */   
/*     */   protected boolean validateField(MixinTargetContext paramMixinTargetContext, FieldNode paramFieldNode, AnnotationNode paramAnnotationNode) {
/*     */     try {
/*     */       if (Bytecode.hasFlag(paramFieldNode, 8))
/*     */         try {
/*     */           if (!Bytecode.hasFlag(paramFieldNode, 2))
/*     */             try {
/*     */               if (!Bytecode.hasFlag(paramFieldNode, 4096))
/*     */                 try {
/*     */                   if (paramAnnotationNode == null)
/*     */                     throw new InvalidMixinException(paramMixinTargetContext, String.format("Mixin %s contains non-private static field %s:%s", new Object[] { paramMixinTargetContext, paramFieldNode.name, paramFieldNode.desc })); 
/*     */                 } catch (IllegalStateException illegalStateException) {
/*     */                   throw b(null);
/*     */                 }  
/*     */             } catch (IllegalStateException illegalStateException) {
/*     */               throw b(null);
/*     */             }  
/*     */         } catch (IllegalStateException illegalStateException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (IllegalStateException illegalStateException) {
/*     */       throw b(null);
/*     */     } 
/*     */     String str = (String)Annotations.getValue(paramAnnotationNode, "prefix", Shadow.class);
/*     */     try {
/*     */       if (paramFieldNode.name.startsWith(str))
/*     */         throw new InvalidMixinException(paramMixinTargetContext, String.format("@Shadow field %s.%s has a shadow prefix. This is not allowed.", new Object[] { paramMixinTargetContext, paramFieldNode.name })); 
/*     */     } catch (IllegalStateException illegalStateException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if ("super$".equals(paramFieldNode.name)) {
/*     */         try {
/*     */           if (paramFieldNode.access != 2)
/*     */             throw new InvalidMixinException(this.mixin, String.format("Imaginary super field %s.%s must be private and non-final", new Object[] { paramMixinTargetContext, paramFieldNode.name })); 
/*     */         } catch (IllegalStateException illegalStateException) {
/*     */           throw b(null);
/*     */         } 
/*     */         try {
/*     */           if (!paramFieldNode.desc.equals("L" + this.mixin.getClassRef() + ";"))
/*     */             throw new InvalidMixinException(this.mixin, String.format("Imaginary super field %s.%s must have the same type as the parent mixin (%s)", new Object[] { paramMixinTargetContext, paramFieldNode.name, this.mixin.getClassName() })); 
/*     */         } catch (IllegalStateException illegalStateException) {
/*     */           throw b(null);
/*     */         } 
/*     */         return false;
/*     */       } 
/*     */     } catch (IllegalStateException illegalStateException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return true;
/*     */   }
/*     */   
/*     */   protected void attachFields(MixinTargetContext paramMixinTargetContext) {
/*     */     for (Iterator<FieldNode> iterator = this.classNode.fields.iterator(); iterator.hasNext(); ) {
/*     */       continue;
/*     */       fieldNode = iterator.next();
/*     */       annotationNode = Annotations.getVisible(fieldNode, Shadow.class);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void checkMethodNotUnique(ClassInfo$Method paramClassInfo$Method, MixinPreProcessorStandard$SpecialMethod paramMixinPreProcessorStandard$SpecialMethod) {
/*     */     try {
/*     */       if (paramClassInfo$Method.isUnique())
/*     */         throw new InvalidMixinException(this.mixin, String.format("%s method %s in %s cannot be @Unique", new Object[] { paramMixinPreProcessorStandard$SpecialMethod, paramClassInfo$Method.getName(), this.mixin })); 
/*     */     } catch (IllegalStateException illegalStateException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void attachMethods(MixinTargetContext paramMixinTargetContext) {
/*     */     for (Iterator<MixinInfo$MixinMethodNode> iterator = this.classNode.mixinMethods.iterator(); iterator.hasNext(); ) {
/*     */       MixinInfo$MixinMethodNode mixinInfo$MixinMethodNode = iterator.next();
/*     */       try {
/*     */         if (!validateMethod(paramMixinTargetContext, mixinInfo$MixinMethodNode))
/*     */           iterator.remove(); 
/*     */       } catch (IllegalStateException illegalStateException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected boolean attachUniqueMethod(MixinTargetContext paramMixinTargetContext, MixinInfo$MixinMethodNode paramMixinInfo$MixinMethodNode) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield mixin : Lorg/spongepowered/asm/mixin/transformer/MixinInfo;
/*     */     //   4: invokevirtual getClassInfo : ()Lorg/spongepowered/asm/mixin/transformer/ClassInfo;
/*     */     //   7: aload_2
/*     */     //   8: bipush #10
/*     */     //   10: invokevirtual findMethod : (Lorg/spongepowered/asm/lib/tree/MethodNode;I)Lorg/spongepowered/asm/mixin/transformer/ClassInfo$Method;
/*     */     //   13: astore_3
/*     */     //   14: aload_3
/*     */     //   15: ifnull -> 63
/*     */     //   18: aload_3
/*     */     //   19: invokevirtual isUnique : ()Z
/*     */     //   22: ifne -> 69
/*     */     //   25: goto -> 32
/*     */     //   28: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   31: athrow
/*     */     //   32: aload_0
/*     */     //   33: getfield mixin : Lorg/spongepowered/asm/mixin/transformer/MixinInfo;
/*     */     //   36: invokevirtual isUnique : ()Z
/*     */     //   39: ifne -> 69
/*     */     //   42: goto -> 49
/*     */     //   45: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   48: athrow
/*     */     //   49: aload_3
/*     */     //   50: invokevirtual isSynthetic : ()Z
/*     */     //   53: ifne -> 69
/*     */     //   56: goto -> 63
/*     */     //   59: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   62: athrow
/*     */     //   63: iconst_0
/*     */     //   64: ireturn
/*     */     //   65: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   68: athrow
/*     */     //   69: aload_3
/*     */     //   70: invokevirtual isSynthetic : ()Z
/*     */     //   73: ifeq -> 97
/*     */     //   76: aload_1
/*     */     //   77: aload_2
/*     */     //   78: invokevirtual transformDescriptor : (Lorg/spongepowered/asm/lib/tree/MethodNode;)V
/*     */     //   81: aload_3
/*     */     //   82: aload_2
/*     */     //   83: getfield desc : Ljava/lang/String;
/*     */     //   86: invokevirtual remapTo : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   89: pop
/*     */     //   90: goto -> 97
/*     */     //   93: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   96: athrow
/*     */     //   97: aload_1
/*     */     //   98: aload_2
/*     */     //   99: aconst_null
/*     */     //   100: invokevirtual findMethod : (Lorg/spongepowered/asm/lib/tree/MethodNode;Lorg/spongepowered/asm/lib/tree/AnnotationNode;)Lorg/spongepowered/asm/lib/tree/MethodNode;
/*     */     //   103: astore #4
/*     */     //   105: aload #4
/*     */     //   107: ifnonnull -> 116
/*     */     //   110: iconst_0
/*     */     //   111: ireturn
/*     */     //   112: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   115: athrow
/*     */     //   116: aload_3
/*     */     //   117: invokevirtual isSynthetic : ()Z
/*     */     //   120: ifeq -> 132
/*     */     //   123: ldc 'synthetic'
/*     */     //   125: goto -> 134
/*     */     //   128: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   131: athrow
/*     */     //   132: ldc '@Unique'
/*     */     //   134: astore #5
/*     */     //   136: aload_2
/*     */     //   137: invokestatic getVisibility : (Lorg/spongepowered/asm/lib/tree/MethodNode;)Lorg/spongepowered/asm/util/Bytecode$Visibility;
/*     */     //   140: invokevirtual ordinal : ()I
/*     */     //   143: getstatic org/spongepowered/asm/util/Bytecode$Visibility.PUBLIC : Lorg/spongepowered/asm/util/Bytecode$Visibility;
/*     */     //   146: invokevirtual ordinal : ()I
/*     */     //   149: if_icmpge -> 224
/*     */     //   152: aload_1
/*     */     //   153: aload_2
/*     */     //   154: iconst_0
/*     */     //   155: invokevirtual getUniqueName : (Lorg/spongepowered/asm/lib/tree/MethodNode;Z)Ljava/lang/String;
/*     */     //   158: astore #6
/*     */     //   160: getstatic org/spongepowered/asm/mixin/transformer/MixinPreProcessorStandard.logger : Lorg/apache/logging/log4j/Logger;
/*     */     //   163: aload_0
/*     */     //   164: getfield mixin : Lorg/spongepowered/asm/mixin/transformer/MixinInfo;
/*     */     //   167: invokevirtual getLoggingLevel : ()Lorg/apache/logging/log4j/Level;
/*     */     //   170: ldc 'Renaming {} method {}{} to {} in {}'
/*     */     //   172: iconst_5
/*     */     //   173: anewarray java/lang/Object
/*     */     //   176: dup
/*     */     //   177: iconst_0
/*     */     //   178: aload #5
/*     */     //   180: aastore
/*     */     //   181: dup
/*     */     //   182: iconst_1
/*     */     //   183: aload_2
/*     */     //   184: getfield name : Ljava/lang/String;
/*     */     //   187: aastore
/*     */     //   188: dup
/*     */     //   189: iconst_2
/*     */     //   190: aload_2
/*     */     //   191: getfield desc : Ljava/lang/String;
/*     */     //   194: aastore
/*     */     //   195: dup
/*     */     //   196: iconst_3
/*     */     //   197: aload #6
/*     */     //   199: aastore
/*     */     //   200: dup
/*     */     //   201: iconst_4
/*     */     //   202: aload_0
/*     */     //   203: getfield mixin : Lorg/spongepowered/asm/mixin/transformer/MixinInfo;
/*     */     //   206: aastore
/*     */     //   207: invokeinterface log : (Lorg/apache/logging/log4j/Level;Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   212: aload_2
/*     */     //   213: aload_3
/*     */     //   214: aload #6
/*     */     //   216: invokevirtual renameTo : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   219: putfield name : Ljava/lang/String;
/*     */     //   222: iconst_0
/*     */     //   223: ireturn
/*     */     //   224: aload_0
/*     */     //   225: getfield strictUnique : Z
/*     */     //   228: ifeq -> 299
/*     */     //   231: new org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */     //   234: dup
/*     */     //   235: aload_0
/*     */     //   236: getfield mixin : Lorg/spongepowered/asm/mixin/transformer/MixinInfo;
/*     */     //   239: ldc 'Method conflict, %s method %s in %s cannot overwrite %s%s in %s'
/*     */     //   241: bipush #6
/*     */     //   243: anewarray java/lang/Object
/*     */     //   246: dup
/*     */     //   247: iconst_0
/*     */     //   248: aload #5
/*     */     //   250: aastore
/*     */     //   251: dup
/*     */     //   252: iconst_1
/*     */     //   253: aload_2
/*     */     //   254: getfield name : Ljava/lang/String;
/*     */     //   257: aastore
/*     */     //   258: dup
/*     */     //   259: iconst_2
/*     */     //   260: aload_0
/*     */     //   261: getfield mixin : Lorg/spongepowered/asm/mixin/transformer/MixinInfo;
/*     */     //   264: aastore
/*     */     //   265: dup
/*     */     //   266: iconst_3
/*     */     //   267: aload #4
/*     */     //   269: getfield name : Ljava/lang/String;
/*     */     //   272: aastore
/*     */     //   273: dup
/*     */     //   274: iconst_4
/*     */     //   275: aload #4
/*     */     //   277: getfield desc : Ljava/lang/String;
/*     */     //   280: aastore
/*     */     //   281: dup
/*     */     //   282: iconst_5
/*     */     //   283: aload_1
/*     */     //   284: invokevirtual getTarget : ()Lorg/spongepowered/asm/mixin/transformer/TargetClassContext;
/*     */     //   287: aastore
/*     */     //   288: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   291: invokespecial <init> : (Lorg/spongepowered/asm/mixin/extensibility/IMixinInfo;Ljava/lang/String;)V
/*     */     //   294: athrow
/*     */     //   295: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   298: athrow
/*     */     //   299: aload_2
/*     */     //   300: ldc org/spongepowered/asm/mixin/Unique
/*     */     //   302: invokestatic getVisible : (Lorg/spongepowered/asm/lib/tree/MethodNode;Ljava/lang/Class;)Lorg/spongepowered/asm/lib/tree/AnnotationNode;
/*     */     //   305: astore #6
/*     */     //   307: aload #6
/*     */     //   309: ifnull -> 338
/*     */     //   312: aload #6
/*     */     //   314: ldc 'silent'
/*     */     //   316: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
/*     */     //   319: invokestatic getValue : (Lorg/spongepowered/asm/lib/tree/AnnotationNode;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   322: checkcast java/lang/Boolean
/*     */     //   325: invokevirtual booleanValue : ()Z
/*     */     //   328: ifne -> 510
/*     */     //   331: goto -> 338
/*     */     //   334: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   337: athrow
/*     */     //   338: aload_2
/*     */     //   339: bipush #64
/*     */     //   341: invokestatic hasFlag : (Lorg/spongepowered/asm/lib/tree/MethodNode;I)Z
/*     */     //   344: ifeq -> 468
/*     */     //   347: goto -> 354
/*     */     //   350: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   353: athrow
/*     */     //   354: aload #4
/*     */     //   356: aload_2
/*     */     //   357: invokestatic compareBridgeMethods : (Lorg/spongepowered/asm/lib/tree/MethodNode;Lorg/spongepowered/asm/lib/tree/MethodNode;)V
/*     */     //   360: getstatic org/spongepowered/asm/mixin/transformer/MixinPreProcessorStandard.logger : Lorg/apache/logging/log4j/Logger;
/*     */     //   363: ldc 'Discarding sythetic bridge method {} in {} because existing method in {} is compatible'
/*     */     //   365: iconst_4
/*     */     //   366: anewarray java/lang/Object
/*     */     //   369: dup
/*     */     //   370: iconst_0
/*     */     //   371: aload #5
/*     */     //   373: aastore
/*     */     //   374: dup
/*     */     //   375: iconst_1
/*     */     //   376: aload_2
/*     */     //   377: getfield name : Ljava/lang/String;
/*     */     //   380: aastore
/*     */     //   381: dup
/*     */     //   382: iconst_2
/*     */     //   383: aload_0
/*     */     //   384: getfield mixin : Lorg/spongepowered/asm/mixin/transformer/MixinInfo;
/*     */     //   387: aastore
/*     */     //   388: dup
/*     */     //   389: iconst_3
/*     */     //   390: aload_1
/*     */     //   391: invokevirtual getTarget : ()Lorg/spongepowered/asm/mixin/transformer/TargetClassContext;
/*     */     //   394: aastore
/*     */     //   395: invokeinterface debug : (Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   400: iconst_1
/*     */     //   401: ireturn
/*     */     //   402: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   405: athrow
/*     */     //   406: astore #7
/*     */     //   408: aload_0
/*     */     //   409: getfield verboseLogging : Z
/*     */     //   412: ifne -> 435
/*     */     //   415: aload_0
/*     */     //   416: getfield env : Lorg/spongepowered/asm/mixin/MixinEnvironment;
/*     */     //   419: getstatic org/spongepowered/asm/mixin/MixinEnvironment$Option.DEBUG_VERIFY : Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;
/*     */     //   422: invokevirtual getOption : (Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;)Z
/*     */     //   425: ifeq -> 451
/*     */     //   428: goto -> 435
/*     */     //   431: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   434: athrow
/*     */     //   435: aload #7
/*     */     //   437: aload_1
/*     */     //   438: aload #4
/*     */     //   440: aload_2
/*     */     //   441: invokevirtual printAnalysis : (Lorg/spongepowered/asm/mixin/refmap/IMixinContext;Lorg/spongepowered/asm/lib/tree/MethodNode;Lorg/spongepowered/asm/lib/tree/MethodNode;)V
/*     */     //   444: goto -> 451
/*     */     //   447: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*     */     //   450: athrow
/*     */     //   451: new org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */     //   454: dup
/*     */     //   455: aload_0
/*     */     //   456: getfield mixin : Lorg/spongepowered/asm/mixin/transformer/MixinInfo;
/*     */     //   459: aload #7
/*     */     //   461: invokevirtual getMessage : ()Ljava/lang/String;
/*     */     //   464: invokespecial <init> : (Lorg/spongepowered/asm/mixin/extensibility/IMixinInfo;Ljava/lang/String;)V
/*     */     //   467: athrow
/*     */     //   468: getstatic org/spongepowered/asm/mixin/transformer/MixinPreProcessorStandard.logger : Lorg/apache/logging/log4j/Logger;
/*     */     //   471: ldc 'Discarding {} public method {} in {} because it already exists in {}'
/*     */     //   473: iconst_4
/*     */     //   474: anewarray java/lang/Object
/*     */     //   477: dup
/*     */     //   478: iconst_0
/*     */     //   479: aload #5
/*     */     //   481: aastore
/*     */     //   482: dup
/*     */     //   483: iconst_1
/*     */     //   484: aload_2
/*     */     //   485: getfield name : Ljava/lang/String;
/*     */     //   488: aastore
/*     */     //   489: dup
/*     */     //   490: iconst_2
/*     */     //   491: aload_0
/*     */     //   492: getfield mixin : Lorg/spongepowered/asm/mixin/transformer/MixinInfo;
/*     */     //   495: aastore
/*     */     //   496: dup
/*     */     //   497: iconst_3
/*     */     //   498: aload_1
/*     */     //   499: invokevirtual getTarget : ()Lorg/spongepowered/asm/mixin/transformer/TargetClassContext;
/*     */     //   502: aastore
/*     */     //   503: invokeinterface warn : (Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   508: iconst_1
/*     */     //   509: ireturn
/*     */     //   510: aload_1
/*     */     //   511: aload_2
/*     */     //   512: invokevirtual addMixinMethod : (Lorg/spongepowered/asm/lib/tree/MethodNode;)V
/*     */     //   515: iconst_1
/*     */     //   516: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #271	-> 0
/*     */     //   #250	-> 14
/*     */     //   #112	-> 63
/*     */     //   #121	-> 69
/*     */     //   #251	-> 76
/*     */     //   #308	-> 81
/*     */     //   #314	-> 97
/*     */     //   #108	-> 105
/*     */     //   #123	-> 110
/*     */     //   #23	-> 116
/*     */     //   #79	-> 136
/*     */     //   #322	-> 152
/*     */     //   #238	-> 160
/*     */     //   #256	-> 212
/*     */     //   #143	-> 222
/*     */     //   #182	-> 224
/*     */     //   #197	-> 231
/*     */     //   #273	-> 284
/*     */     //   #56	-> 288
/*     */     //   #45	-> 299
/*     */     //   #205	-> 307
/*     */     //   #190	-> 338
/*     */     //   #206	-> 354
/*     */     //   #269	-> 360
/*     */     //   #131	-> 391
/*     */     //   #85	-> 395
/*     */     //   #262	-> 400
/*     */     //   #42	-> 406
/*     */     //   #237	-> 408
/*     */     //   #232	-> 435
/*     */     //   #290	-> 451
/*     */     //   #301	-> 468
/*     */     //   #311	-> 499
/*     */     //   #183	-> 503
/*     */     //   #161	-> 508
/*     */     //   #31	-> 510
/*     */     //   #193	-> 515
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   14	25	28	org/spongepowered/asm/util/throwables/SyntheticBridgeException
/*     */     //   18	42	45	org/spongepowered/asm/util/throwables/SyntheticBridgeException
/*     */     //   32	56	59	org/spongepowered/asm/util/throwables/SyntheticBridgeException
/*     */     //   49	65	65	org/spongepowered/asm/util/throwables/SyntheticBridgeException
/*     */     //   69	90	93	org/spongepowered/asm/util/throwables/SyntheticBridgeException
/*     */     //   105	112	112	org/spongepowered/asm/util/throwables/SyntheticBridgeException
/*     */     //   116	128	128	org/spongepowered/asm/util/throwables/SyntheticBridgeException
/*     */     //   224	295	295	org/spongepowered/asm/util/throwables/SyntheticBridgeException
/*     */     //   307	331	334	org/spongepowered/asm/util/throwables/SyntheticBridgeException
/*     */     //   312	347	350	org/spongepowered/asm/util/throwables/SyntheticBridgeException
/*     */     //   338	402	402	java/lang/IllegalStateException
/*     */     //   354	401	406	org/spongepowered/asm/util/throwables/SyntheticBridgeException
/*     */     //   408	428	431	org/spongepowered/asm/util/throwables/SyntheticBridgeException
/*     */     //   415	444	447	org/spongepowered/asm/util/throwables/SyntheticBridgeException
/*     */   }
/*     */   
/*     */   protected void checkMixinNotUnique(MixinInfo$MixinMethodNode paramMixinInfo$MixinMethodNode, MixinPreProcessorStandard$SpecialMethod paramMixinPreProcessorStandard$SpecialMethod) {
/*     */     try {
/*     */       if (this.mixin.isUnique())
/*     */         throw new InvalidMixinException(this.mixin, String.format("%s method %s found in a @Unique mixin %s", new Object[] { paramMixinPreProcessorStandard$SpecialMethod, paramMixinInfo$MixinMethodNode.name, this.mixin })); 
/*     */     } catch (IllegalStateException illegalStateException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   MixinTargetContext createContextFor(TargetClassContext paramTargetClassContext) {
/*     */     MixinTargetContext mixinTargetContext = new MixinTargetContext(this.mixin, this.classNode, paramTargetClassContext);
/*     */     conform(paramTargetClassContext);
/*     */     attach(mixinTargetContext);
/*     */     return mixinTargetContext;
/*     */   }
/*     */   
/*     */   protected void transform(MixinTargetContext paramMixinTargetContext) {
/*     */     for (MethodNode methodNode : this.classNode.methods)
/*     */       ListIterator listIterator = methodNode.instructions.iterator(); 
/*     */   }
/*     */   
/*     */   protected boolean attachAccessorMethod(MixinTargetContext paramMixinTargetContext, MixinInfo$MixinMethodNode paramMixinInfo$MixinMethodNode) {
/*     */     try {
/*     */       if (!attachAccessorMethod(paramMixinTargetContext, paramMixinInfo$MixinMethodNode, MixinPreProcessorStandard$SpecialMethod.ACCESSOR)) {
/*     */         try {
/*     */           if (attachAccessorMethod(paramMixinTargetContext, paramMixinInfo$MixinMethodNode, MixinPreProcessorStandard$SpecialMethod.INVOKER));
/*     */         } catch (IllegalStateException illegalStateException) {
/*     */           throw b(null);
/*     */         } 
/*     */         return false;
/*     */       } 
/*     */     } catch (IllegalStateException illegalStateException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected ClassInfo$Method getSpecialMethod(MixinInfo$MixinMethodNode paramMixinInfo$MixinMethodNode, MixinPreProcessorStandard$SpecialMethod paramMixinPreProcessorStandard$SpecialMethod) {
/*     */     ClassInfo$Method classInfo$Method = this.mixin.getClassInfo().findMethod(paramMixinInfo$MixinMethodNode, 10);
/*     */     checkMethodNotUnique(classInfo$Method, paramMixinPreProcessorStandard$SpecialMethod);
/*     */     return classInfo$Method;
/*     */   }
/*     */   
/*     */   final MixinPreProcessorStandard prepare() {
/*     */     try {
/*     */       if (this.prepared)
/*     */         return this; 
/*     */     } catch (IllegalStateException illegalStateException) {
/*     */       throw b(null);
/*     */     } 
/*     */     this.prepared = true;
/*     */     Profiler.Section section = this.profiler.begin("prepare");
/*     */     for (MixinInfo$MixinMethodNode mixinInfo$MixinMethodNode : this.classNode.mixinMethods) {
/*     */       ClassInfo$Method classInfo$Method = this.mixin.getClassInfo().findMethod(mixinInfo$MixinMethodNode);
/*     */       prepareMethod(mixinInfo$MixinMethodNode, classInfo$Method);
/*     */     } 
/*     */     for (FieldNode fieldNode : this.classNode.fields)
/*     */       prepareField(fieldNode); 
/*     */     section.end();
/*     */     return this;
/*     */   }
/*     */   
/*     */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*     */     return paramRuntimeException;
/*     */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MixinPreProcessorStandard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */