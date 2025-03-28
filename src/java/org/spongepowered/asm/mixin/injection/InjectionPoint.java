/*     */ package org.spongepowered.asm.mixin.injection;
/*     */ public abstract class InjectionPoint {
/*     */   public static List<InjectionPoint> parse(IMixinContext paramIMixinContext, MethodNode paramMethodNode, AnnotationNode paramAnnotationNode, List<AnnotationNode> paramList) {
/*   4 */     ImmutableList.Builder builder = ImmutableList.builder();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  91 */     for (AnnotationNode annotationNode : paramList) {
/*     */       InjectionPoint injectionPoint = parse(paramIMixinContext, paramMethodNode, paramAnnotationNode, annotationNode);
/*     */     }
/*     */     return (List<InjectionPoint>)builder.build();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int DEFAULT_ALLOWED_SHIFT_BY = 0;
/*     */   
/*     */   public static final int MAX_ALLOWED_SHIFT_BY = 5;
/*     */ 
/*     */   
/*     */   protected InjectionPoint(InjectionPointData paramInjectionPointData) {
/*     */     this(paramInjectionPointData.getSlice(), paramInjectionPointData.getSelector(), paramInjectionPointData.getId());
/*     */   }
/*     */ 
/*     */   
/*     */   private static void validateByValue(IMixinContext paramIMixinContext, MethodNode paramMethodNode, AnnotationNode paramAnnotationNode, InjectionPoint paramInjectionPoint, int paramInt) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokeinterface getMixin : ()Lorg/spongepowered/asm/mixin/extensibility/IMixinInfo;
/*     */     //   6: invokeinterface getConfig : ()Lorg/spongepowered/asm/mixin/extensibility/IMixinConfig;
/*     */     //   11: invokeinterface getEnvironment : ()Lorg/spongepowered/asm/mixin/MixinEnvironment;
/*     */     //   16: astore #5
/*     */     //   18: aload #5
/*     */     //   20: getstatic org/spongepowered/asm/mixin/MixinEnvironment$Option.SHIFT_BY_VIOLATION_BEHAVIOUR : Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;
/*     */     //   23: getstatic org/spongepowered/asm/mixin/injection/InjectionPoint$ShiftByViolationBehaviour.WARN : Lorg/spongepowered/asm/mixin/injection/InjectionPoint$ShiftByViolationBehaviour;
/*     */     //   26: invokevirtual getOption : (Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;Ljava/lang/Enum;)Ljava/lang/Enum;
/*     */     //   29: checkcast org/spongepowered/asm/mixin/injection/InjectionPoint$ShiftByViolationBehaviour
/*     */     //   32: astore #6
/*     */     //   34: aload #6
/*     */     //   36: getstatic org/spongepowered/asm/mixin/injection/InjectionPoint$ShiftByViolationBehaviour.IGNORE : Lorg/spongepowered/asm/mixin/injection/InjectionPoint$ShiftByViolationBehaviour;
/*     */     //   39: if_acmpne -> 47
/*     */     //   42: return
/*     */     //   43: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   46: athrow
/*     */     //   47: ldc 'the maximum allowed value: '
/*     */     //   49: astore #7
/*     */     //   51: ldc 'Increase the value of maxShiftBy to suppress this warning.'
/*     */     //   53: astore #8
/*     */     //   55: iconst_0
/*     */     //   56: istore #9
/*     */     //   58: aload_0
/*     */     //   59: instanceof org/spongepowered/asm/mixin/transformer/MixinTargetContext
/*     */     //   62: ifeq -> 74
/*     */     //   65: aload_0
/*     */     //   66: checkcast org/spongepowered/asm/mixin/transformer/MixinTargetContext
/*     */     //   69: invokevirtual getMaxShiftByValue : ()I
/*     */     //   72: istore #9
/*     */     //   74: iload #4
/*     */     //   76: iload #9
/*     */     //   78: if_icmpgt -> 86
/*     */     //   81: return
/*     */     //   82: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   85: athrow
/*     */     //   86: iload #4
/*     */     //   88: iconst_5
/*     */     //   89: if_icmple -> 103
/*     */     //   92: ldc 'MAX_ALLOWED_SHIFT_BY='
/*     */     //   94: astore #7
/*     */     //   96: ldc 'You must use an alternate query or a custom injection point.'
/*     */     //   98: astore #8
/*     */     //   100: iconst_5
/*     */     //   101: istore #9
/*     */     //   103: ldc '@%s(%s) Shift.BY=%d on %s::%s exceeds %s%d. %s'
/*     */     //   105: bipush #8
/*     */     //   107: anewarray java/lang/Object
/*     */     //   110: dup
/*     */     //   111: iconst_0
/*     */     //   112: aload_2
/*     */     //   113: invokestatic getSimpleName : (Lorg/spongepowered/asm/lib/tree/AnnotationNode;)Ljava/lang/String;
/*     */     //   116: aastore
/*     */     //   117: dup
/*     */     //   118: iconst_1
/*     */     //   119: aload_3
/*     */     //   120: aastore
/*     */     //   121: dup
/*     */     //   122: iconst_2
/*     */     //   123: iload #4
/*     */     //   125: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   128: aastore
/*     */     //   129: dup
/*     */     //   130: iconst_3
/*     */     //   131: aload_0
/*     */     //   132: aastore
/*     */     //   133: dup
/*     */     //   134: iconst_4
/*     */     //   135: aload_1
/*     */     //   136: getfield name : Ljava/lang/String;
/*     */     //   139: aastore
/*     */     //   140: dup
/*     */     //   141: iconst_5
/*     */     //   142: aload #7
/*     */     //   144: aastore
/*     */     //   145: dup
/*     */     //   146: bipush #6
/*     */     //   148: iload #9
/*     */     //   150: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   153: aastore
/*     */     //   154: dup
/*     */     //   155: bipush #7
/*     */     //   157: aload #8
/*     */     //   159: aastore
/*     */     //   160: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   163: astore #10
/*     */     //   165: aload #6
/*     */     //   167: getstatic org/spongepowered/asm/mixin/injection/InjectionPoint$ShiftByViolationBehaviour.WARN : Lorg/spongepowered/asm/mixin/injection/InjectionPoint$ShiftByViolationBehaviour;
/*     */     //   170: if_acmpne -> 203
/*     */     //   173: iload #9
/*     */     //   175: iconst_5
/*     */     //   176: if_icmpge -> 203
/*     */     //   179: goto -> 186
/*     */     //   182: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   185: athrow
/*     */     //   186: ldc 'mixin'
/*     */     //   188: invokestatic getLogger : (Ljava/lang/String;)Lorg/apache/logging/log4j/Logger;
/*     */     //   191: aload #10
/*     */     //   193: invokeinterface warn : (Ljava/lang/String;)V
/*     */     //   198: return
/*     */     //   199: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   202: athrow
/*     */     //   203: new org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   206: dup
/*     */     //   207: aload_0
/*     */     //   208: aload #10
/*     */     //   210: invokespecial <init> : (Lorg/spongepowered/asm/mixin/refmap/IMixinContext;Ljava/lang/String;)V
/*     */     //   213: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #8	-> 0
/*     */     //   #52	-> 18
/*     */     //   #86	-> 34
/*     */     //   #103	-> 42
/*     */     //   #81	-> 47
/*     */     //   #122	-> 51
/*     */     //   #133	-> 55
/*     */     //   #13	-> 58
/*     */     //   #131	-> 65
/*     */     //   #12	-> 74
/*     */     //   #99	-> 81
/*     */     //   #75	-> 86
/*     */     //   #89	-> 92
/*     */     //   #55	-> 96
/*     */     //   #18	-> 100
/*     */     //   #53	-> 103
/*     */     //   #34	-> 125
/*     */     //   #3	-> 160
/*     */     //   #62	-> 165
/*     */     //   #10	-> 186
/*     */     //   #70	-> 198
/*     */     //   #117	-> 203
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   34	43	43	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   74	82	82	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   165	179	182	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   173	199	199	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */   }
/*     */ 
/*     */   
/*     */   public static InjectionPoint parse(IMixinContext paramIMixinContext, MethodNode paramMethodNode, AnnotationNode paramAnnotationNode, At paramAt) {
/* 114 */     return parse(paramIMixinContext, paramMethodNode, paramAnnotationNode, paramAt.value(), paramAt.shift(), paramAt.by(), Arrays.asList(paramAt.args()), paramAt.target(), paramAt.slice(), paramAt.ordinal(), paramAt.opcode(), paramAt.id());
/*     */   } public static InjectionPoint shift(InjectionPoint paramInjectionPoint, int paramInt) { return new InjectionPoint$Shift(paramInjectionPoint, paramInt); } public static void register(Class<? extends InjectionPoint> paramClass) { InjectionPoint$AtCode injectionPoint$AtCode = paramClass.<InjectionPoint$AtCode>getAnnotation(InjectionPoint$AtCode.class);
/*     */     try {
/*     */       if (injectionPoint$AtCode == null)
/*     */         throw new IllegalArgumentException("Injection point class " + paramClass + " is not annotated with @AtCode"); 
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw b(null);
/*     */     } 
/*     */     Class clazz = types.get(injectionPoint$AtCode.value());
/*     */     try {
/*     */       if (clazz != null)
/*     */         try {
/*     */           if (!clazz.equals(paramClass))
/* 127 */             LogManager.getLogger("mixin").debug("Overriding InjectionPoint {} with {} (previously {})", new Object[] { injectionPoint$AtCode.value(), paramClass.getName(), clazz.getName() }); 
/*     */         } catch (InvalidInjectionException invalidInjectionException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw b(null);
/*     */     }  types.put(injectionPoint$AtCode.value(), paramClass); } public static InjectionPoint parse(IMixinContext paramIMixinContext, MethodNode paramMethodNode, AnnotationNode paramAnnotationNode1, AnnotationNode paramAnnotationNode2) { ImmutableList immutableList; String str1 = (String)Annotations.getValue(paramAnnotationNode2, "value"); List list = (List)Annotations.getValue(paramAnnotationNode2, "args"); String str2 = (String)Annotations.getValue(paramAnnotationNode2, "target", ""); String str3 = (String)Annotations.getValue(paramAnnotationNode2, "slice", ""); At$Shift at$Shift = (At$Shift)Annotations.getValue(paramAnnotationNode2, "shift", At$Shift.class, At$Shift.NONE); int i = ((Integer)Annotations.getValue(paramAnnotationNode2, "by", Integer.valueOf(0))).intValue(); int j = ((Integer)Annotations.getValue(paramAnnotationNode2, "ordinal", Integer.valueOf(-1))).intValue(); int k = ((Integer)Annotations.getValue(paramAnnotationNode2, "opcode", Integer.valueOf(0))).intValue(); String str4 = (String)Annotations.getValue(paramAnnotationNode2, "id"); if (list == null)
/* 134 */       immutableList = ImmutableList.of();  return parse(paramIMixinContext, paramMethodNode, paramAnnotationNode1, str1, at$Shift, i, (List<String>)immutableList, str2, str3, j, k, str4); }
/*     */ 
/*     */   
/*     */   private static InjectionPoint shift(IMixinContext paramIMixinContext, MethodNode paramMethodNode, AnnotationNode paramAnnotationNode, InjectionPoint paramInjectionPoint, At$Shift paramAt$Shift, int paramInt) {
/*     */     try {
/*     */       if (paramInjectionPoint != null) {
/*     */         try {
/*     */           if (paramAt$Shift == At$Shift.BEFORE)
/*     */             return before(paramInjectionPoint); 
/*     */         } catch (InvalidInjectionException invalidInjectionException) {
/*     */           throw b(null);
/*     */         } 
/*     */         try {
/*     */           if (paramAt$Shift == At$Shift.AFTER)
/*     */             return after(paramInjectionPoint); 
/*     */         } catch (InvalidInjectionException invalidInjectionException) {
/*     */           throw b(null);
/*     */         } 
/*     */       } 
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return paramInjectionPoint;
/*     */   }
/*     */   
/*     */   public static InjectionPoint after(InjectionPoint paramInjectionPoint) {
/*     */     return new InjectionPoint$Shift(paramInjectionPoint, 1);
/*     */   }
/*     */   
/*     */   public InjectionPoint(String paramString1, InjectionPoint$Selector paramInjectionPoint$Selector, String paramString2) {
/*     */     this.slice = paramString1;
/*     */     this.selector = paramInjectionPoint$Selector;
/*     */     this.id = paramString2;
/*     */   }
/*     */   
/*     */   public InjectionPoint$Selector getSelector() {
/*     */     return this.selector;
/*     */   }
/*     */   
/*     */   public static InjectionPoint parse(IMixinContext paramIMixinContext, MethodNode paramMethodNode, AnnotationNode paramAnnotationNode, String paramString1, At$Shift paramAt$Shift, int paramInt1, List<String> paramList, String paramString2, String paramString3, int paramInt2, int paramInt3, String paramString4) {
/*     */     InjectionPointData injectionPointData = new InjectionPointData(paramIMixinContext, paramMethodNode, paramAnnotationNode, paramString1, paramList, paramString2, paramString3, paramInt2, paramInt3, paramString4);
/*     */     Class<? extends InjectionPoint> clazz = findClass(paramIMixinContext, injectionPointData);
/*     */     InjectionPoint injectionPoint = create(paramIMixinContext, injectionPointData, clazz);
/*     */     return shift(paramIMixinContext, paramMethodNode, paramAnnotationNode, injectionPoint, paramAt$Shift, paramInt1);
/*     */   }
/*     */   
/*     */   public static InjectionPoint parse(IInjectionPointContext paramIInjectionPointContext, At paramAt) {
/*     */     return parse(paramIInjectionPointContext.getContext(), paramIInjectionPointContext.getMethod(), paramIInjectionPointContext.getAnnotation(), paramAt.value(), paramAt.shift(), paramAt.by(), Arrays.asList(paramAt.args()), paramAt.target(), paramAt.slice(), paramAt.ordinal(), paramAt.opcode(), paramAt.id());
/*     */   }
/*     */   
/*     */   public String toString() {
/*     */     return String.format("@At(\"%s\")", new Object[] { getAtCode() });
/*     */   }
/*     */   
/*     */   public String getSlice() {
/*     */     return this.slice;
/*     */   }
/*     */   
/*     */   public String getId() {
/*     */     return this.id;
/*     */   }
/*     */   
/*     */   protected String getAtCode() {
/*     */     InjectionPoint$AtCode injectionPoint$AtCode = getClass().<InjectionPoint$AtCode>getAnnotation(InjectionPoint$AtCode.class);
/*     */     try {
/*     */     
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return (injectionPoint$AtCode == null) ? getClass().getName() : injectionPoint$AtCode.value();
/*     */   }
/*     */   
/*     */   public static InjectionPoint or(InjectionPoint... paramVarArgs) {
/*     */     return new InjectionPoint$Union(paramVarArgs);
/*     */   }
/*     */   
/*     */   private static Map<String, Class<? extends InjectionPoint>> types = new HashMap<String, Class<? extends InjectionPoint>>();
/*     */   private final String slice;
/*     */   private final InjectionPoint$Selector selector;
/*     */   private final String id;
/*     */   
/*     */   public static InjectionPoint before(InjectionPoint paramInjectionPoint) {
/*     */     return new InjectionPoint$Shift(paramInjectionPoint, -1);
/*     */   }
/*     */   
/*     */   public static InjectionPoint and(InjectionPoint... paramVarArgs) {
/*     */     return new InjectionPoint$Intersection(paramVarArgs);
/*     */   }
/*     */   
/*     */   protected InjectionPoint() {
/*     */     this("", InjectionPoint$Selector.DEFAULT, null);
/*     */   }
/*     */   
/*     */   private static Class<? extends InjectionPoint> findClass(IMixinContext paramIMixinContext, InjectionPointData paramInjectionPointData) {
/*     */     String str = paramInjectionPointData.getType();
/*     */     Class<?> clazz = types.get(str);
/*     */     try {
/*     */       if (clazz == null)
/*     */         if (str.matches("^([A-Za-z_][A-Za-z0-9_]*\\.)+[A-Za-z_][A-Za-z0-9_]*$")) {
/*     */           try {
/*     */             clazz = Class.forName(str);
/*     */             types.put(str, clazz);
/*     */           } catch (Exception exception) {
/*     */             throw new InvalidInjectionException(paramIMixinContext, paramInjectionPointData + " could not be loaded or is not a valid InjectionPoint", exception);
/*     */           } 
/*     */         } else {
/*     */           throw new InvalidInjectionException(paramIMixinContext, paramInjectionPointData + " is not a valid injection point specifier");
/*     */         }  
/*     */     } catch (Exception exception) {
/*     */       throw b(null);
/*     */     } 
/*     */     return (Class)clazz;
/*     */   }
/*     */   
/*     */   public static InjectionPoint parse(IInjectionPointContext paramIInjectionPointContext, AnnotationNode paramAnnotationNode) {
/*     */     return parse(paramIInjectionPointContext.getContext(), paramIInjectionPointContext.getMethod(), paramIInjectionPointContext.getAnnotation(), paramAnnotationNode);
/*     */   }
/*     */   
/*     */   public boolean checkPriority(int paramInt1, int paramInt2) {
/*     */     try {
/*     */     
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return (paramInt1 < paramInt2);
/*     */   }
/*     */   
/*     */   public static List<InjectionPoint> parse(IInjectionPointContext paramIInjectionPointContext, List<AnnotationNode> paramList) {
/*     */     return parse(paramIInjectionPointContext.getContext(), paramIInjectionPointContext.getMethod(), paramIInjectionPointContext.getAnnotation(), paramList);
/*     */   }
/*     */   
/*     */   protected static AbstractInsnNode nextNode(InsnList paramInsnList, AbstractInsnNode paramAbstractInsnNode) {
/*     */     int i = paramInsnList.indexOf(paramAbstractInsnNode) + 1;
/*     */     try {
/*     */       if (i > 0)
/*     */         try {
/*     */           if (i < paramInsnList.size())
/*     */             return paramInsnList.get(i); 
/*     */         } catch (InvalidInjectionException invalidInjectionException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return paramAbstractInsnNode;
/*     */   }
/*     */   
/*     */   static {
/*     */     register((Class)BeforeFieldAccess.class);
/*     */     register((Class)BeforeInvoke.class);
/*     */     register((Class)BeforeNew.class);
/*     */     register((Class)BeforeReturn.class);
/*     */     register((Class)BeforeStringInvoke.class);
/*     */     register((Class)JumpInsnPoint.class);
/*     */     register((Class)MethodHead.class);
/*     */     register((Class)AfterInvoke.class);
/*     */     register((Class)BeforeLoadLocal.class);
/*     */     register((Class)AfterStoreLocal.class);
/*     */     register((Class)BeforeFinalReturn.class);
/*     */     register((Class)BeforeConstant.class);
/*     */   }
/*     */   
/*     */   private static InjectionPoint create(IMixinContext paramIMixinContext, InjectionPointData paramInjectionPointData, Class<? extends InjectionPoint> paramClass) {
/*     */     Constructor<? extends InjectionPoint> constructor = null;
/*     */     try {
/*     */       constructor = paramClass.getDeclaredConstructor(new Class[] { InjectionPointData.class });
/*     */       constructor.setAccessible(true);
/*     */     } catch (NoSuchMethodException noSuchMethodException) {
/*     */       throw new InvalidInjectionException(paramIMixinContext, paramClass.getName() + " must contain a constructor which accepts an InjectionPointData", noSuchMethodException);
/*     */     } 
/*     */     InjectionPoint injectionPoint = null;
/*     */     try {
/*     */       injectionPoint = constructor.newInstance(new Object[] { paramInjectionPointData });
/*     */     } catch (Exception exception) {
/*     */       throw new InvalidInjectionException(paramIMixinContext, "Error whilst instancing injection point " + paramClass.getName() + " for " + paramInjectionPointData.getAt(), exception);
/*     */     } 
/*     */     return injectionPoint;
/*     */   }
/*     */   
/*     */   public abstract boolean find(String paramString, InsnList paramInsnList, Collection<AbstractInsnNode> paramCollection);
/*     */   
/*     */   private static Exception b(Exception paramException) {
/*     */     return paramException;
/*     */   }
/*     */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\InjectionPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */