/*     */ package org.spongepowered.asm.mixin.transformer;class MixinApplicatorStandard {
/*     */   protected final boolean mergeSignatures;
/*     */   protected final Profiler profiler;
/*     */   protected final ClassNode targetClass;
/*     */   protected final String targetName;
/*     */   protected final TargetClassContext context;
/*     */   protected final Logger logger;
/*     */   
/*     */   private static String fieldKey(FieldInsnNode paramFieldInsnNode) {
/*  10 */     return String.format("%s:%s", new Object[] { paramFieldInsnNode.desc, paramFieldInsnNode.name });
/*     */   }
/*     */   
/*     */   protected AbstractInsnNode findInitialiserInjectionPoint(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode, Deque<AbstractInsnNode> paramDeque) {
/*  14 */     HashSet<String> hashSet = new HashSet();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 326 */     for (AbstractInsnNode abstractInsnNode1 : paramDeque) { try { if (abstractInsnNode1.getOpcode() == 181)
/*     */           hashSet.add(fieldKey((FieldInsnNode)abstractInsnNode1));  } catch (InvalidMixinException invalidMixinException) { throw b(null); }
/*     */        }
/*     */      MixinApplicatorStandard$InitialiserInjectionMode mixinApplicatorStandard$InitialiserInjectionMode = getInitialiserInjectionMode(paramMixinTargetContext.getEnvironment()); String str1 = paramMixinTargetContext.getTargetClassInfo().getName(); String str2 = paramMixinTargetContext.getTargetClassInfo().getSuperName(); AbstractInsnNode abstractInsnNode = null; for (ListIterator<AbstractInsnNode> listIterator = paramMethodNode.instructions.iterator(); listIterator.hasNext(); ) { AbstractInsnNode abstractInsnNode1 = listIterator.next(); try { if (abstractInsnNode1.getOpcode() == 183 && "<init>".equals(((MethodInsnNode)abstractInsnNode1).name)) { String str = ((MethodInsnNode)abstractInsnNode1).owner; try { if (str.equals(str1) || str.equals(str2)) { abstractInsnNode = abstractInsnNode1; try { if (mixinApplicatorStandard$InitialiserInjectionMode == MixinApplicatorStandard$InitialiserInjectionMode.SAFE)
/*     */                   break;  }
/*     */               catch (InvalidMixinException invalidMixinException) { throw b(null); }
/*     */                }
/*     */              }
/*     */           catch (InvalidMixinException invalidMixinException) { throw b(null); }
/*     */            }
/*     */          }
/*     */       catch (InvalidMixinException invalidMixinException) { throw b(null); }
/*     */        }
/*     */      return abstractInsnNode; }
/*     */   protected final MethodNode findTargetMethod(MethodNode paramMethodNode) { for (MethodNode methodNode : this.targetClass.methods) { try { if (methodNode.name.equals(paramMethodNode.name))
/*     */           try { if (methodNode.desc.equals(paramMethodNode.desc))
/*     */               return methodNode;  }
/*     */           catch (InvalidMixinException invalidMixinException) { throw b(null); }
/*     */             }
/*     */       catch (InvalidMixinException invalidMixinException) { throw b(null); }
/*     */        }
/*     */      return null; }
/*     */   protected void applyMethods(MixinTargetContext paramMixinTargetContext) { for (MethodNode methodNode : paramMixinTargetContext.getShadowMethods())
/*     */       applyShadowMethod(paramMixinTargetContext, methodNode);  for (MethodNode methodNode : paramMixinTargetContext.getMethods())
/*     */       applyNormalMethod(paramMixinTargetContext, methodNode);  }
/*     */   protected void applySourceMap(TargetClassContext paramTargetClassContext) { this.targetClass.sourceDebug = paramTargetClassContext.getSourceMap().toString(); }
/* 352 */   protected void prepareInjections(MixinTargetContext paramMixinTargetContext) { paramMixinTargetContext.prepareInjections(); } protected void applyFields(MixinTargetContext paramMixinTargetContext) { mergeShadowFields(paramMixinTargetContext); mergeNewFields(paramMixinTargetContext); }
/*     */   protected static final int[] INITIALISER_OPCODE_BLACKLIST = new int[] { 
/*     */       177, 21, 22, 23, 24, 46, 47, 48, 49, 50, 
/*     */       51, 52, 53, 54, 55, 56, 57, 58, 79, 80, 
/*     */       81, 82, 83, 84, 85, 86 };
/*     */   protected void applyInterfaces(MixinTargetContext paramMixinTargetContext) { for (String str : paramMixinTargetContext.getInterfaces()) { try { if (!this.targetClass.interfaces.contains(str)) { this.targetClass.interfaces.add(str); paramMixinTargetContext.getTargetClassInfo().addInterface(str); }
/*     */          }
/*     */       catch (InvalidMixinException invalidMixinException) { throw b(null); }
/*     */        }
/*     */      } protected void displaceIntrinsic(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode1, MethodNode paramMethodNode2) { String str = "proxy+" + paramMethodNode2.name; for (ListIterator<AbstractInsnNode> listIterator = paramMethodNode1.instructions.iterator(); listIterator.hasNext(); ) { AbstractInsnNode abstractInsnNode = listIterator.next(); try { if (abstractInsnNode instanceof MethodInsnNode && abstractInsnNode.getOpcode() != 184) { MethodInsnNode methodInsnNode = (MethodInsnNode)abstractInsnNode; try {
/*     */             if (methodInsnNode.owner.equals(this.targetClass.name))
/*     */               try {
/*     */                 if (methodInsnNode.name.equals(paramMethodNode2.name))
/*     */                   try {
/*     */                     if (methodInsnNode.desc.equals(paramMethodNode2.desc))
/*     */                       methodInsnNode.name = str; 
/*     */                   } catch (InvalidMixinException invalidMixinException) {
/*     */                     throw b(null);
/*     */                   }  
/*     */               } catch (InvalidMixinException invalidMixinException) {
/*     */                 throw b(null);
/*     */               }  
/*     */           } catch (InvalidMixinException invalidMixinException) {
/*     */             throw b(null);
/*     */           }  }
/*     */          }
/*     */       catch (InvalidMixinException invalidMixinException)
/*     */       { throw b(null); }
/*     */        }
/*     */      paramMethodNode2.name = str; } protected void applyInitialisers(MixinTargetContext paramMixinTargetContext) { MethodNode methodNode = getConstructor(paramMixinTargetContext); try {
/*     */       if (methodNode == null)
/*     */         return; 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/* 386 */     }  Deque<AbstractInsnNode> deque = getInitialiser(paramMixinTargetContext, methodNode); try { if (deque != null) try { if (deque.size() != 0) { for (MethodNode methodNode1 : this.targetClass.methods) { try { if ("<init>".equals(methodNode1.name)) { methodNode1.maxStack = Math.max(methodNode1.maxStack, methodNode.maxStack); injectInitialiser(paramMixinTargetContext, methodNode1, deque); }  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  }  return; }  return; } catch (InvalidMixinException invalidMixinException) { throw b(null); }   } catch (InvalidMixinException invalidMixinException) { throw b(null); }  } MixinApplicatorStandard(TargetClassContext paramTargetClassContext) { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokespecial <init> : ()V
/*     */     //   4: aload_0
/*     */     //   5: ldc 'mixin'
/*     */     //   7: invokestatic getLogger : (Ljava/lang/String;)Lorg/apache/logging/log4j/Logger;
/*     */     //   10: putfield logger : Lorg/apache/logging/log4j/Logger;
/*     */     //   13: aload_0
/*     */     //   14: invokestatic getProfiler : ()Lorg/spongepowered/asm/util/perf/Profiler;
/*     */     //   17: putfield profiler : Lorg/spongepowered/asm/util/perf/Profiler;
/*     */     //   20: aload_0
/*     */     //   21: aload_1
/*     */     //   22: putfield context : Lorg/spongepowered/asm/mixin/transformer/TargetClassContext;
/*     */     //   25: aload_0
/*     */     //   26: aload_1
/*     */     //   27: invokevirtual getClassName : ()Ljava/lang/String;
/*     */     //   30: putfield targetName : Ljava/lang/String;
/*     */     //   33: aload_0
/*     */     //   34: aload_1
/*     */     //   35: invokevirtual getClassNode : ()Lorg/spongepowered/asm/lib/tree/ClassNode;
/*     */     //   38: putfield targetClass : Lorg/spongepowered/asm/lib/tree/ClassNode;
/*     */     //   41: aload_1
/*     */     //   42: invokevirtual getExtensions : ()Lorg/spongepowered/asm/mixin/transformer/ext/Extensions;
/*     */     //   45: ldc org/spongepowered/asm/mixin/transformer/ext/extensions/ExtensionClassExporter
/*     */     //   47: invokevirtual getExtension : (Ljava/lang/Class;)Lorg/spongepowered/asm/mixin/transformer/ext/IExtension;
/*     */     //   50: checkcast org/spongepowered/asm/mixin/transformer/ext/extensions/ExtensionClassExporter
/*     */     //   53: astore_2
/*     */     //   54: aload_0
/*     */     //   55: aload_2
/*     */     //   56: invokevirtual isDecompilerActive : ()Z
/*     */     //   59: ifeq -> 89
/*     */     //   62: invokestatic getCurrentEnvironment : ()Lorg/spongepowered/asm/mixin/MixinEnvironment;
/*     */     //   65: getstatic org/spongepowered/asm/mixin/MixinEnvironment$Option.DEBUG_EXPORT_DECOMPILE_MERGESIGNATURES : Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;
/*     */     //   68: invokevirtual getOption : (Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;)Z
/*     */     //   71: ifeq -> 89
/*     */     //   74: goto -> 81
/*     */     //   77: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   80: athrow
/*     */     //   81: iconst_1
/*     */     //   82: goto -> 90
/*     */     //   85: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   88: athrow
/*     */     //   89: iconst_0
/*     */     //   90: putfield mergeSignatures : Z
/*     */     //   93: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #148	-> 0
/*     */     //   #384	-> 4
/*     */     //   #358	-> 13
/*     */     //   #229	-> 20
/*     */     //   #140	-> 25
/*     */     //   #196	-> 33
/*     */     //   #156	-> 41
/*     */     //   #265	-> 54
/*     */     //   #198	-> 62
/*     */     //   #339	-> 93
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   54	74	77	org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */     //   62	85	85	org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException }
/* 387 */   protected boolean mergeIntrinsic(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode1, boolean paramBoolean, MethodNode paramMethodNode2, AnnotationNode paramAnnotationNode) { try { if (paramBoolean) throw new InvalidMixinException(paramMixinTargetContext, "@Intrinsic is not compatible with @Overwrite, remove one of these annotations on " + paramMethodNode1.name + " in " + paramMixinTargetContext);  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  String str = paramMethodNode1.name + paramMethodNode1.desc; try { if (Bytecode.hasFlag(paramMethodNode1, 8)) throw new InvalidMixinException(paramMixinTargetContext, "@Intrinsic method cannot be static, found " + str + " in " + paramMixinTargetContext);  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  if (!Bytecode.hasFlag(paramMethodNode1, 4096)) { AnnotationNode annotationNode = Annotations.getVisible(paramMethodNode1, MixinRenamed.class); try { if (annotationNode != null) { try { if (!((Boolean)Annotations.getValue(annotationNode, "isInterfaceMember", Boolean.FALSE)).booleanValue()) throw new InvalidMixinException(paramMixinTargetContext, "@Intrinsic method must be prefixed interface method, no rename encountered on " + str + " in " + paramMixinTargetContext);  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  } else { throw new InvalidMixinException(paramMixinTargetContext, "@Intrinsic method must be prefixed interface method, no rename encountered on " + str + " in " + paramMixinTargetContext); }
/*     */          }
/*     */       catch (InvalidMixinException invalidMixinException)
/*     */       { throw b(null); }
/*     */        }
/*     */     
/*     */     try {
/*     */       if (!((Boolean)Annotations.getValue(paramAnnotationNode, "displace", Boolean.FALSE)).booleanValue()) {
/*     */         this.logger.log(paramMixinTargetContext.getLoggingLevel(), "Skipping Intrinsic mixin method {} for {}", new Object[] { str, paramMixinTargetContext.getTargetClassRef() });
/*     */         return true;
/*     */       } 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     displaceIntrinsic(paramMixinTargetContext, paramMethodNode1, paramMethodNode2);
/*     */     return false; }
/*     */ 
/*     */   
/*     */   protected final void checkConstraints(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode, AnnotationNode paramAnnotationNode) {
/*     */     try {
/*     */       ConstraintParser.Constraint constraint = ConstraintParser.parse(paramAnnotationNode);
/*     */       try {
/*     */         constraint.check((ITokenProvider)paramMixinTargetContext.getEnvironment());
/*     */       } catch (ConstraintViolationException constraintViolationException) {
/*     */         String str = String.format("Constraint violation: %s on %s in %s", new Object[] { constraintViolationException.getMessage(), paramMethodNode, paramMixinTargetContext });
/*     */         try {
/*     */           this.logger.warn(str);
/*     */           if (!paramMixinTargetContext.getEnvironment().getOption(MixinEnvironment.Option.IGNORE_CONSTRAINTS))
/*     */             throw new InvalidMixinException(paramMixinTargetContext, str, constraintViolationException); 
/*     */         } catch (ConstraintViolationException constraintViolationException1) {
/*     */           throw b(null);
/*     */         } 
/*     */       } 
/*     */     } catch (InvalidConstraintException invalidConstraintException) {
/*     */       throw new InvalidMixinException(paramMixinTargetContext, invalidConstraintException.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void applyAttributes(MixinTargetContext paramMixinTargetContext) {
/*     */     try {
/*     */       if (paramMixinTargetContext.shouldSetSourceFile())
/*     */         this.targetClass.sourceFile = paramMixinTargetContext.getSourceFile(); 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     this.targetClass.version = Math.max(this.targetClass.version, paramMixinTargetContext.getMinRequiredClassVersion());
/*     */   }
/*     */   
/*     */   protected void mergeShadowFields(MixinTargetContext paramMixinTargetContext) {
/*     */     for (Map.Entry<FieldNode, ClassInfo$Field> entry : paramMixinTargetContext.getShadowFields()) {
/*     */       FieldNode fieldNode1 = (FieldNode)entry.getKey();
/*     */       FieldNode fieldNode2 = findTargetField(fieldNode1);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected static final List<Class<? extends Annotation>> CONSTRAINED_ANNOTATIONS = (List<Class<? extends Annotation>>)ImmutableList.of(Overwrite.class, Inject.class, ModifyArg.class, ModifyArgs.class, Redirect.class, ModifyVariable.class, ModifyConstant.class);
/*     */   
/*     */   protected void mergeNewFields(MixinTargetContext paramMixinTargetContext) {
/*     */     for (FieldNode fieldNode1 : paramMixinTargetContext.getFields())
/*     */       FieldNode fieldNode2 = findTargetField(fieldNode1); 
/*     */   }
/*     */   
/*     */   protected final void appendInsns(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode) {
/*     */     try {
/*     */       if (Type.getReturnType(paramMethodNode.desc) != Type.VOID_TYPE)
/*     */         throw new IllegalArgumentException("Attempted to merge insns from a method which does not return void"); 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     MethodNode methodNode = findTargetMethod(paramMethodNode);
/*     */     if (methodNode != null) {
/*     */       AbstractInsnNode abstractInsnNode = Bytecode.findInsn(methodNode, 177);
/*     */       if (abstractInsnNode != null) {
/*     */         ListIterator<AbstractInsnNode> listIterator = paramMethodNode.instructions.iterator();
/*     */         while (listIterator.hasNext()) {
/*     */           AbstractInsnNode abstractInsnNode1 = listIterator.next();
/*     */           try {
/*     */             if (!(abstractInsnNode1 instanceof LineNumberNode))
/*     */               try {
/*     */                 if (abstractInsnNode1.getOpcode() != 177)
/*     */                   methodNode.instructions.insertBefore(abstractInsnNode, abstractInsnNode1); 
/*     */               } catch (InvalidMixinException invalidMixinException) {
/*     */                 throw b(null);
/*     */               }  
/*     */           } catch (InvalidMixinException invalidMixinException) {
/*     */             throw b(null);
/*     */           } 
/*     */         } 
/*     */         methodNode.maxLocals = Math.max(methodNode.maxLocals, paramMethodNode.maxLocals);
/*     */         methodNode.maxStack = Math.max(methodNode.maxStack, paramMethodNode.maxStack);
/*     */       } 
/*     */       return;
/*     */     } 
/*     */     this.targetClass.methods.add(paramMethodNode);
/*     */   }
/*     */   
/*     */   protected void applyInjections(MixinTargetContext paramMixinTargetContext) {
/*     */     paramMixinTargetContext.applyInjections();
/*     */   }
/*     */   
/*     */   protected void checkMethodConstraints(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode) {
/*     */     for (Class<? extends Annotation> clazz : CONSTRAINED_ANNOTATIONS) {
/*     */       AnnotationNode annotationNode = Annotations.getVisible(paramMethodNode, clazz);
/*     */       try {
/*     */         if (annotationNode != null)
/*     */           checkConstraints(paramMixinTargetContext, paramMethodNode, annotationNode); 
/*     */       } catch (InvalidMixinException invalidMixinException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private MixinApplicatorStandard$Range getConstructorRange(MethodNode paramMethodNode) {
/*     */     boolean bool = false;
/*     */     AbstractInsnNode abstractInsnNode = null;
/*     */     int i = 0, j = 0, k = 0, m = -1;
/*     */     for (ListIterator<AbstractInsnNode> listIterator = paramMethodNode.instructions.iterator(); listIterator.hasNext(); ) {
/*     */       AbstractInsnNode abstractInsnNode1 = listIterator.next();
/*     */       if (abstractInsnNode1 instanceof LineNumberNode) {
/*     */         i = ((LineNumberNode)abstractInsnNode1).line;
/*     */         bool = true;
/*     */       } 
/*     */       try {
/*     */         if (abstractInsnNode1 instanceof MethodInsnNode) {
/*     */           try {
/*     */             if (abstractInsnNode1.getOpcode() == 183)
/*     */               try {
/*     */                 if ("<init>".equals(((MethodInsnNode)abstractInsnNode1).name) && m == -1) {
/*     */                   m = paramMethodNode.instructions.indexOf(abstractInsnNode1);
/*     */                   j = i;
/*     */                 } 
/*     */               } catch (InvalidMixinException invalidMixinException) {
/*     */                 throw b(null);
/*     */               }  
/*     */           } catch (InvalidMixinException invalidMixinException) {
/*     */             throw b(null);
/*     */           } 
/*     */           continue;
/*     */         } 
/*     */       } catch (InvalidMixinException invalidMixinException) {
/*     */         throw b(null);
/*     */       } 
/*     */       if (abstractInsnNode1.getOpcode() == 181) {
/*     */         bool = false;
/*     */         continue;
/*     */       } 
/*     */       try {
/*     */         if (abstractInsnNode1.getOpcode() == 177) {
/*     */           if (bool) {
/*     */             k = i;
/*     */             continue;
/*     */           } 
/*     */           k = j;
/*     */           abstractInsnNode = abstractInsnNode1;
/*     */         } 
/*     */       } catch (InvalidMixinException invalidMixinException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     if (abstractInsnNode != null) {
/*     */       LabelNode labelNode = new LabelNode(new Label());
/*     */       paramMethodNode.instructions.insertBefore(abstractInsnNode, (AbstractInsnNode)labelNode);
/*     */       paramMethodNode.instructions.insertBefore(abstractInsnNode, (AbstractInsnNode)new LineNumberNode(j, labelNode));
/*     */     } 
/*     */     return new MixinApplicatorStandard$Range(this, j, k, m);
/*     */   }
/*     */   
/*     */   protected void applyShadowMethod(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode) {
/*     */     MethodNode methodNode = findTargetMethod(paramMethodNode);
/*     */     try {
/*     */       if (methodNode != null)
/*     */         Bytecode.mergeAnnotations(paramMethodNode, methodNode); 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected final void injectInitialiser(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode, Deque<AbstractInsnNode> paramDeque) {
/*     */     Map map = Bytecode.cloneLabels(paramMethodNode.instructions);
/*     */     AbstractInsnNode abstractInsnNode = findInitialiserInjectionPoint(paramMixinTargetContext, paramMethodNode, paramDeque);
/*     */     try {
/*     */       if (abstractInsnNode == null) {
/*     */         this.logger.warn("Failed to locate initialiser injection point in <init>{}, initialiser was not mixed in.", new Object[] { paramMethodNode.desc });
/*     */         return;
/*     */       } 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     for (AbstractInsnNode abstractInsnNode1 : paramDeque) {
/*     */       try {
/*     */         if (abstractInsnNode1 instanceof LabelNode);
/*     */       } catch (InvalidMixinException invalidMixinException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected final void applyMixin(MixinTargetContext paramMixinTargetContext, MixinApplicatorStandard$ApplicatorPass paramMixinApplicatorStandard$ApplicatorPass) {
/*     */     try {
/*     */       switch (MixinApplicatorStandard$1.$SwitchMap$org$spongepowered$asm$mixin$transformer$MixinApplicatorStandard$ApplicatorPass[paramMixinApplicatorStandard$ApplicatorPass.ordinal()]) {
/*     */         case 1:
/*     */           applySignature(paramMixinTargetContext);
/*     */           applyInterfaces(paramMixinTargetContext);
/*     */           applyAttributes(paramMixinTargetContext);
/*     */           applyAnnotations(paramMixinTargetContext);
/*     */           applyFields(paramMixinTargetContext);
/*     */           applyMethods(paramMixinTargetContext);
/*     */           applyInitialisers(paramMixinTargetContext);
/*     */           return;
/*     */         case 2:
/*     */           prepareInjections(paramMixinTargetContext);
/*     */           return;
/*     */         case 3:
/*     */           applyAccessors(paramMixinTargetContext);
/*     */           applyInjections(paramMixinTargetContext);
/*     */           return;
/*     */       } 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     throw new IllegalStateException("Invalid pass specified " + paramMixinApplicatorStandard$ApplicatorPass);
/*     */   }
/*     */   
/*     */   protected void applyNormalMethod(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode) {
/*     */     try {
/*     */       paramMixinTargetContext.transformMethod(paramMethodNode);
/*     */       if (!paramMethodNode.name.startsWith("<")) {
/*     */         checkMethodVisibility(paramMixinTargetContext, paramMethodNode);
/*     */         checkMethodConstraints(paramMixinTargetContext, paramMethodNode);
/*     */         mergeMethod(paramMixinTargetContext, paramMethodNode);
/*     */       } else {
/*     */         try {
/*     */           if ("<clinit>".equals(paramMethodNode.name))
/*     */             appendInsns(paramMixinTargetContext, paramMethodNode); 
/*     */         } catch (InvalidMixinException invalidMixinException) {
/*     */           throw b(null);
/*     */         } 
/*     */       } 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void applySignature(MixinTargetContext paramMixinTargetContext) {
/*     */     try {
/*     */       if (this.mergeSignatures)
/*     */         this.context.mergeSignature(paramMixinTargetContext.getSignature()); 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected final FieldNode findTargetField(FieldNode paramFieldNode) {
/*     */     for (FieldNode fieldNode : this.targetClass.fields) {
/*     */       try {
/*     */         if (fieldNode.name.equals(paramFieldNode.name))
/*     */           return fieldNode; 
/*     */       } catch (InvalidMixinException invalidMixinException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   protected void mergeMethod(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode) {
/*     */     try {
/*     */     
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     boolean bool = (Annotations.getVisible(paramMethodNode, Overwrite.class) != null) ? true : false;
/*     */     MethodNode methodNode = findTargetMethod(paramMethodNode);
/*     */     try {
/*     */       if (methodNode != null) {
/*     */         try {
/*     */           if (isAlreadyMerged(paramMixinTargetContext, paramMethodNode, bool, methodNode))
/*     */             return; 
/*     */         } catch (InvalidMixinException invalidMixinException) {
/*     */           throw b(null);
/*     */         } 
/*     */         AnnotationNode annotationNode = Annotations.getInvisible(paramMethodNode, Intrinsic.class);
/*     */       } 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (bool)
/*     */         throw new InvalidMixinException(paramMixinTargetContext, String.format("Overwrite target \"%s\" was not located in target class %s", new Object[] { paramMethodNode.name, paramMixinTargetContext.getTargetClassRef() })); 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       this.targetClass.methods.add(paramMethodNode);
/*     */       paramMixinTargetContext.methodMerged(paramMethodNode);
/*     */       if (paramMethodNode.signature != null) {
/*     */         if (this.mergeSignatures) {
/*     */           SignatureVisitor signatureVisitor = paramMixinTargetContext.getSignature().getRemapper();
/*     */           (new SignatureReader(paramMethodNode.signature)).accept(signatureVisitor);
/*     */           paramMethodNode.signature = signatureVisitor.toString();
/*     */         } 
/*     */         paramMethodNode.signature = null;
/*     */       } 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   private MixinApplicatorStandard$InitialiserInjectionMode getInitialiserInjectionMode(MixinEnvironment paramMixinEnvironment) {
/*     */     String str = paramMixinEnvironment.getOptionValue(MixinEnvironment.Option.INITIALISER_INJECTION_MODE);
/*     */     try {
/*     */       if (str == null)
/*     */         return MixinApplicatorStandard$InitialiserInjectionMode.DEFAULT; 
/*     */     } catch (Exception exception) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       return MixinApplicatorStandard$InitialiserInjectionMode.valueOf(str.toUpperCase());
/*     */     } catch (Exception exception) {
/*     */       this.logger.warn("Could not parse unexpected value \"{}\" for mixin.initialiserInjectionMode, reverting to DEFAULT", new Object[] { str });
/*     */       return MixinApplicatorStandard$InitialiserInjectionMode.DEFAULT;
/*     */     } 
/*     */   }
/*     */   
/*     */   protected final Deque<AbstractInsnNode> getInitialiser(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode) {
/*     */     MixinApplicatorStandard$Range mixinApplicatorStandard$Range = getConstructorRange(paramMethodNode);
/*     */     try {
/*     */       if (!mixinApplicatorStandard$Range.isValid())
/*     */         return null; 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     int i = 0;
/*     */     ArrayDeque<AbstractInsnNode> arrayDeque = new ArrayDeque();
/*     */     boolean bool = false;
/*     */     short s = -1;
/*     */     Object object = null;
/*     */     for (ListIterator<AbstractInsnNode> listIterator = paramMethodNode.instructions.iterator(mixinApplicatorStandard$Range.marker); listIterator.hasNext(); ) {
/*     */       AbstractInsnNode abstractInsnNode1 = listIterator.next();
/*     */       if (abstractInsnNode1 instanceof LineNumberNode) {
/*     */         i = ((LineNumberNode)abstractInsnNode1).line;
/*     */         AbstractInsnNode abstractInsnNode2 = paramMethodNode.instructions.get(paramMethodNode.instructions.indexOf(abstractInsnNode1) + 1);
/*     */         try {
/*     */           if (i == mixinApplicatorStandard$Range.end && abstractInsnNode2.getOpcode() != 177) {
/*     */             bool = true;
/*     */             s = 177;
/*     */           } 
/*     */         } catch (InvalidMixinException invalidMixinException) {
/*     */           throw b(null);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     AbstractInsnNode abstractInsnNode = arrayDeque.peekLast();
/*     */     try {
/*     */       if (abstractInsnNode != null)
/*     */         try {
/*     */           if (abstractInsnNode.getOpcode() != 181)
/*     */             throw new InvalidMixinException(paramMixinTargetContext, "Could not parse initialiser, expected 0xB5, found 0x" + Integer.toHexString(abstractInsnNode.getOpcode()) + " in " + paramMixinTargetContext); 
/*     */         } catch (InvalidMixinException invalidMixinException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return arrayDeque;
/*     */   }
/*     */   
/*     */   void apply(SortedSet<MixinInfo> paramSortedSet) {
/*     */     ArrayList arrayList = new ArrayList();
/*     */     for (MixinInfo mixinInfo : paramSortedSet) {
/*     */       this.logger.log(mixinInfo.getLoggingLevel(), "Mixing {} from {} into {}", new Object[] { mixinInfo.getName(), mixinInfo.getParent(), this.targetName });
/*     */     } 
/*     */     MixinTargetContext mixinTargetContext = null;
/*     */     try {
/*     */       for (MixinTargetContext mixinTargetContext1 : arrayList)
/*     */         (mixinTargetContext = mixinTargetContext1).preApply(this.targetName, this.targetClass); 
/*     */       MixinApplicatorStandard$ApplicatorPass[] arrayOfMixinApplicatorStandard$ApplicatorPass;
/*     */       int i;
/*     */       byte b;
/*     */       for (arrayOfMixinApplicatorStandard$ApplicatorPass = MixinApplicatorStandard$ApplicatorPass.values(), i = arrayOfMixinApplicatorStandard$ApplicatorPass.length, b = 0; b < i; ) {
/*     */         MixinApplicatorStandard$ApplicatorPass mixinApplicatorStandard$ApplicatorPass = arrayOfMixinApplicatorStandard$ApplicatorPass[b];
/*     */         Profiler.Section section = this.profiler.begin(new String[] { "pass", mixinApplicatorStandard$ApplicatorPass.name().toLowerCase() });
/*     */         for (MixinTargetContext mixinTargetContext1 : arrayList)
/*     */           applyMixin(mixinTargetContext = mixinTargetContext1, mixinApplicatorStandard$ApplicatorPass); 
/*     */         section.end();
/*     */         b++;
/*     */       } 
/*     */       for (MixinTargetContext mixinTargetContext1 : arrayList)
/*     */         (mixinTargetContext = mixinTargetContext1).postApply(this.targetName, this.targetClass); 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw invalidMixinException;
/*     */     } catch (Exception exception) {
/*     */       throw new InvalidMixinException(mixinTargetContext, "Unexpecteded " + exception.getClass().getSimpleName() + " whilst applying the mixin class: " + exception.getMessage(), exception);
/*     */     } 
/*     */     applySourceMap(this.context);
/*     */     this.context.processDebugTasks();
/*     */   }
/*     */   
/*     */   protected boolean isAlreadyMerged(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode1, boolean paramBoolean, MethodNode paramMethodNode2) {
/*     */     AnnotationNode annotationNode = Annotations.getVisible(paramMethodNode2, MixinMerged.class);
/*     */     try {
/*     */       if (annotationNode == null) {
/*     */         try {
/*     */           if (Annotations.getVisible(paramMethodNode2, Final.class) != null) {
/*     */             this.logger.warn("Overwrite prohibited for @Final method {} in {}. Skipping method.", new Object[] { paramMethodNode1.name, paramMixinTargetContext });
/*     */             return true;
/*     */           } 
/*     */         } catch (InvalidMixinException invalidMixinException) {
/*     */           throw b(null);
/*     */         } 
/*     */         return false;
/*     */       } 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     String str1 = (String)Annotations.getValue(annotationNode, "sessionId");
/*     */     try {
/*     */       if (!this.context.getSessionId().equals(str1))
/*     */         throw new ClassFormatError("Invalid @MixinMerged annotation found in" + paramMixinTargetContext + " at " + paramMethodNode1.name + " in " + this.targetClass.name); 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (Bytecode.hasFlag(paramMethodNode2, 4160))
/*     */         try {
/*     */           if (Bytecode.hasFlag(paramMethodNode1, 4160)) {
/*     */             try {
/*     */               if (paramMixinTargetContext.getEnvironment().getOption(MixinEnvironment.Option.DEBUG_VERBOSE))
/*     */                 this.logger.warn("Synthetic bridge method clash for {} in {}", new Object[] { paramMethodNode1.name, paramMixinTargetContext }); 
/*     */             } catch (InvalidMixinException invalidMixinException) {
/*     */               throw b(null);
/*     */             } 
/*     */             return true;
/*     */           } 
/*     */         } catch (InvalidMixinException invalidMixinException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     String str2 = (String)Annotations.getValue(annotationNode, "mixin");
/*     */     int i = ((Integer)Annotations.getValue(annotationNode, "priority")).intValue();
/*     */     try {
/*     */       if (i >= paramMixinTargetContext.getPriority())
/*     */         try {
/*     */           if (!str2.equals(paramMixinTargetContext.getClassName())) {
/*     */             this.logger.warn("Method overwrite conflict for {} in {}, previously written by {}. Skipping method.", new Object[] { paramMethodNode1.name, paramMixinTargetContext, str2 });
/*     */             return true;
/*     */           } 
/*     */         } catch (InvalidMixinException invalidMixinException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (Annotations.getVisible(paramMethodNode2, Final.class) != null) {
/*     */         this.logger.warn("Method overwrite conflict for @Final method {} in {} declared by {}. Skipping method.", new Object[] { paramMethodNode1.name, paramMixinTargetContext, str2 });
/*     */         return true;
/*     */       } 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   protected MethodNode getConstructor(MixinTargetContext paramMixinTargetContext) {
/*     */     MethodNode methodNode = null;
/*     */     for (MethodNode methodNode1 : paramMixinTargetContext.getMethods()) {
/*     */       try {
/*     */         if ("<init>".equals(methodNode1.name))
/*     */           try {
/*     */             if (Bytecode.methodHasLineNumbers(methodNode1)) {
/*     */               if (methodNode == null) {
/*     */                 methodNode = methodNode1;
/*     */                 continue;
/*     */               } 
/*     */               this.logger.warn(String.format("Mixin %s has multiple constructors, %s was selected\n", new Object[] { paramMixinTargetContext, methodNode.desc }));
/*     */             } 
/*     */           } catch (InvalidMixinException invalidMixinException) {
/*     */             throw b(null);
/*     */           }  
/*     */       } catch (InvalidMixinException invalidMixinException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     return methodNode;
/*     */   }
/*     */   
/*     */   protected void applyAnnotations(MixinTargetContext paramMixinTargetContext) {
/*     */     ClassNode classNode = paramMixinTargetContext.getClassNode();
/*     */     Bytecode.mergeAnnotations(classNode, this.targetClass);
/*     */   }
/*     */   
/*     */   protected void applyAccessors(MixinTargetContext paramMixinTargetContext) {
/*     */     List<MethodNode> list = paramMixinTargetContext.generateAccessors();
/*     */     for (MethodNode methodNode : list) {
/*     */       try {
/*     */         if (!methodNode.name.startsWith("<"))
/*     */           mergeMethod(paramMixinTargetContext, methodNode); 
/*     */       } catch (InvalidMixinException invalidMixinException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void checkMethodVisibility(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode) {
/*     */     try {
/*     */       if (Bytecode.hasFlag(paramMethodNode, 8))
/*     */         try {
/*     */           if (!Bytecode.hasFlag(paramMethodNode, 2))
/*     */             try {
/*     */               if (!Bytecode.hasFlag(paramMethodNode, 4096))
/*     */                 try {
/*     */                   if (Annotations.getVisible(paramMethodNode, Overwrite.class) == null)
/*     */                     throw new InvalidMixinException(paramMixinTargetContext, String.format("Mixin %s contains non-private static method %s", new Object[] { paramMixinTargetContext, paramMethodNode })); 
/*     */                 } catch (InvalidMixinException invalidMixinException) {
/*     */                   throw b(null);
/*     */                 }  
/*     */             } catch (InvalidMixinException invalidMixinException) {
/*     */               throw b(null);
/*     */             }  
/*     */         } catch (InvalidMixinException invalidMixinException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Exception b(Exception paramException) {
/*     */     return paramException;
/*     */   }
/*     */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MixinApplicatorStandard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */