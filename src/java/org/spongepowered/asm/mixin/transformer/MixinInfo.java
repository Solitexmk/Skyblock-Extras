/*   1 */ package org.spongepowered.asm.mixin.transformer;class MixinInfo implements Comparable<MixinInfo>, IMixinInfo { static int mixinOrder = 0; protected boolean readPseudo(ClassNode paramClassNode) { try {  } catch (InvalidMixinException invalidMixinException) { throw b(null); }
/*     */      return (Annotations.getInvisible(paramClassNode, Pseudo.class) != null); } private static final IMixinService classLoaderUtil = MixinService.getService();
/*     */   public MixinInfo$MixinClassNode getClassNode(int paramInt) { return getState().createClassNode(paramInt); }
/*     */   public boolean isLoadable() { return this.type.isLoadable(); }
/*     */   public MixinEnvironment.Phase getPhase() { return this.phase; }
/*   6 */   void validate() { try { if (this.pendingState == null)
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
/*  34 */         throw new IllegalStateException("No pending validation state for " + this); }  } catch (InvalidMixinException invalidMixinException) { throw b(null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 113 */     try { this.pendingState.validate(this.type, this.targetClasses); this.state = this.pendingState; } finally { this.pendingState = null; }  } public IMixinConfig getConfig() { return this.parent; } public byte[] getClassBytes() { return getState().getClassBytes(); } public String getClassRef() { return getClassInfo().getName(); } private boolean shouldApplyMixin(boolean paramBoolean, String paramString) { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield profiler : Lorg/spongepowered/asm/util/perf/Profiler;
/*     */     //   4: ldc 'plugin'
/*     */     //   6: invokevirtual begin : (Ljava/lang/String;)Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   9: astore_3
/*     */     //   10: aload_0
/*     */     //   11: getfield plugin : Lorg/spongepowered/asm/mixin/extensibility/IMixinConfigPlugin;
/*     */     //   14: ifnull -> 52
/*     */     //   17: iload_1
/*     */     //   18: ifne -> 52
/*     */     //   21: goto -> 28
/*     */     //   24: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   27: athrow
/*     */     //   28: aload_0
/*     */     //   29: getfield plugin : Lorg/spongepowered/asm/mixin/extensibility/IMixinConfigPlugin;
/*     */     //   32: aload_2
/*     */     //   33: aload_0
/*     */     //   34: getfield className : Ljava/lang/String;
/*     */     //   37: invokeinterface shouldApplyMixin : (Ljava/lang/String;Ljava/lang/String;)Z
/*     */     //   42: ifeq -> 60
/*     */     //   45: goto -> 52
/*     */     //   48: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   51: athrow
/*     */     //   52: iconst_1
/*     */     //   53: goto -> 61
/*     */     //   56: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   59: athrow
/*     */     //   60: iconst_0
/*     */     //   61: istore #4
/*     */     //   63: aload_3
/*     */     //   64: invokevirtual end : ()Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   67: pop
/*     */     //   68: iload #4
/*     */     //   70: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #36	-> 0
/*     */     //   #79	-> 10
/*     */     //   #65	-> 63
/*     */     //   #74	-> 68
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   10	21	24	org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */     //   17	45	48	org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */     //   28	56	56	org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException }
/* 114 */   MixinTargetContext createContextFor(TargetClassContext paramTargetClassContext) { MixinInfo$MixinClassNode mixinInfo$MixinClassNode = getClassNode(8); Profiler.Section section = this.profiler.begin("pre"); MixinTargetContext mixinTargetContext = this.type.createPreProcessor(mixinInfo$MixinClassNode).prepare().createContextFor(paramTargetClassContext); section.end(); return mixinTargetContext; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Set<String> getInterfaces() {
/*     */     return getState().getInterfaces();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int readPriority(ClassNode paramClassNode) {
/*     */     try {
/*     */       if (paramClassNode == null) {
/*     */         return this.parent.getDefaultMixinPriority();
/*     */       }
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     AnnotationNode annotationNode = Annotations.getInvisible(paramClassNode, Mixin.class);
/*     */     
/* 139 */     try { if (annotationNode == null)
/*     */         throw new InvalidMixinException(this, String.format("The mixin '%s' is missing an @Mixin annotation", new Object[] { this.className }));  }
/*     */     catch (InvalidMixinException invalidMixinException) { throw b(null); }
/*     */      Integer integer = (Integer)Annotations.getValue(annotationNode, "priority"); try {  }
/* 143 */     catch (InvalidMixinException invalidMixinException) { throw b(null); }  return (integer == null) ? this.parent.getDefaultMixinPriority() : integer.intValue();
/*     */   }
/*     */   private ClassInfo getTarget(String paramString, boolean paramBoolean) throws InvalidMixinException { ClassInfo classInfo = ClassInfo.forName(paramString); try { if (classInfo == null) { try { if (isVirtual()) { this.logger.debug("Skipping virtual target {} for {}", new Object[] { paramString, this }); } else { handleTargetError(String.format("@Mixin target %s was not found %s", new Object[] { paramString, this })); }  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  return null; }  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  try { this.type.validateTarget(paramString, classInfo); if (paramBoolean) try { if (classInfo.isPublic()) try { if (!isVirtual()) handleTargetError(String.format("@Mixin target %s is public in %s and should be specified in value", new Object[] { paramString, this }));  } catch (InvalidMixinException invalidMixinException) { throw b(null); }   } catch (InvalidMixinException invalidMixinException) { throw b(null); }   } catch (InvalidMixinException invalidMixinException) { throw b(null); }  return classInfo; }
/* 146 */   List<InterfaceInfo> getSoftImplements() { return Collections.unmodifiableList(getState().getSoftImplements()); } ClassInfo getClassInfo() { return this.info; } void reloadMixin(byte[] paramArrayOfbyte) { try { if (this.pendingState != null) throw new IllegalStateException("Cannot reload mixin while it is initialising");  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  this.pendingState = new MixinInfo$Reloaded(this, this.state, paramArrayOfbyte); validate(); } public int compareTo(MixinInfo paramMixinInfo) { try { if (paramMixinInfo == null)
/*     */         return 0;  } catch (InvalidMixinException invalidMixinException) { throw b(null); }
/*     */      try { if (paramMixinInfo.priority == this.priority)
/*     */         return this.order - paramMixinInfo.order;  }
/*     */     catch (InvalidMixinException invalidMixinException) { throw b(null); }
/*     */      return this.priority - paramMixinInfo.priority; }
/*     */   public boolean isUnique() { return getState().isUnique(); }
/* 153 */   private void handleTargetError(String paramString) { try { if (this.strict) { this.logger.error(paramString); throw new InvalidMixinException(this, paramString); }  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  this.logger.warn(paramString); } private MixinInfo$State getState() { try {  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  return (this.state != null) ? this.state : this.pendingState; } Set<String> getInnerClasses() { return Collections.unmodifiableSet(getState().getInnerClasses()); }
/* 154 */   MixinInfo(IMixinService paramIMixinService, MixinConfig paramMixinConfig, String paramString, boolean paramBoolean1, IMixinConfigPlugin paramIMixinConfigPlugin, boolean paramBoolean2) { this.order = mixinOrder++; this.service = paramIMixinService; this.parent = paramMixinConfig; this.name = paramString; this.className = paramMixinConfig.getMixinPackage() + paramString; this.plugin = paramIMixinConfigPlugin;
/*     */     this.phase = paramMixinConfig.getEnvironment().getPhase();
/*     */     this.strict = paramMixinConfig.getEnvironment().getOption(MixinEnvironment.Option.DEBUG_TARGETS);
/*     */     try {
/*     */       byte[] arrayOfByte = loadMixinClass(this.className, paramBoolean1);
/*     */       this.pendingState = new MixinInfo$State(this, arrayOfByte);
/*     */       this.info = this.pendingState.getClassInfo();
/*     */       this.type = MixinInfo$SubType.getTypeFor(this);
/* 162 */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw invalidMixinException;
/*     */     } catch (Exception exception) {
/*     */       throw new InvalidMixinException(this, exception);
/*     */     } 
/*     */     try {
/*     */       if (!this.type.isLoadable())
/*     */         classLoaderUtil.registerInvalidClass(this.className); 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       this.priority = readPriority(this.pendingState.getClassNode());
/*     */       this.virtual = readPseudo(this.pendingState.getClassNode());
/*     */       this.targetClasses = readTargetClasses(this.pendingState.getClassNode(), paramBoolean2);
/*     */       this.targetClassNames = Collections.unmodifiableList(Lists.transform(this.targetClasses, Functions.toStringFunction()));
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw invalidMixinException;
/*     */     } catch (Exception exception) {
/*     */       throw new InvalidMixinException(this, exception);
/*     */     }  }
/*     */ 
/*     */   
/*     */   public void preApply(String paramString, ClassNode paramClassNode) {
/*     */     if (this.plugin != null) {
/*     */       Profiler.Section section = this.profiler.begin("plugin");
/*     */       this.plugin.preApply(paramString, paramClassNode, this.className, this);
/*     */       section.end();
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isDetachedSuper() {
/*     */     return getState().isDetachedSuper();
/*     */   }
/*     */   
/*     */   private boolean isReloading() {
/*     */     return this.pendingState instanceof MixinInfo$Reloaded;
/*     */   }
/*     */   
/*     */   private final transient Logger logger = LogManager.getLogger("mixin");
/*     */   private final transient Profiler profiler = MixinEnvironment.getProfiler();
/*     */   private final transient MixinConfig parent;
/*     */   private final String name;
/*     */   private final String className;
/*     */   private final int priority;
/*     */   private final boolean virtual;
/*     */   private final List<ClassInfo> targetClasses;
/*     */   private final List<String> targetClassNames;
/*     */   private final transient int order;
/*     */   private final transient IMixinService service;
/*     */   private final transient IMixinConfigPlugin plugin;
/*     */   private final transient MixinEnvironment.Phase phase;
/*     */   private final transient ClassInfo info;
/*     */   private final transient MixinInfo$SubType type;
/*     */   private final transient boolean strict;
/*     */   private transient MixinInfo$State pendingState;
/*     */   private transient MixinInfo$State state;
/*     */   
/*     */   public String getName() {
/*     */     return this.name;
/*     */   }
/*     */   
/*     */   List<ClassInfo> getTargets() {
/*     */     return Collections.unmodifiableList(this.targetClasses);
/*     */   }
/*     */   
/*     */   public boolean isVirtual() {
/*     */     return this.virtual;
/*     */   }
/*     */   
/*     */   public List<String> getTargetClasses() {
/*     */     return this.targetClassNames;
/*     */   }
/*     */   
/*     */   protected List<ClassInfo> readTargetClasses(MixinInfo$MixinClassNode paramMixinInfo$MixinClassNode, boolean paramBoolean) {
/*     */     try {
/*     */       if (paramMixinInfo$MixinClassNode == null)
/*     */         return Collections.emptyList(); 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     AnnotationNode annotationNode = Annotations.getInvisible(paramMixinInfo$MixinClassNode, Mixin.class);
/*     */     try {
/*     */       if (annotationNode == null)
/*     */         throw new InvalidMixinException(this, String.format("The mixin '%s' is missing an @Mixin annotation", new Object[] { this.className })); 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     ArrayList<ClassInfo> arrayList = new ArrayList();
/*     */     List list1 = (List)Annotations.getValue(annotationNode, "value");
/*     */     List list2 = (List)Annotations.getValue(annotationNode, "targets");
/*     */     try {
/*     */       if (list1 != null)
/*     */         readTargets(arrayList, Lists.transform(list1, new MixinInfo$1(this)), paramBoolean, false); 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (list2 != null)
/*     */         readTargets(arrayList, Lists.transform(list2, new MixinInfo$2(this)), paramBoolean, true); 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return arrayList;
/*     */   }
/*     */   
/*     */   public String toString() {
/*     */     return String.format("%s:%s", new Object[] { this.parent.getName(), this.name });
/*     */   }
/*     */   
/*     */   MixinConfig getParent() {
/*     */     return this.parent;
/*     */   }
/*     */   
/*     */   public boolean isAccessor() {
/*     */     return this.type instanceof MixinInfo$SubType$Accessor;
/*     */   }
/*     */   
/*     */   public int getPriority() {
/*     */     return this.priority;
/*     */   }
/*     */   
/*     */   public void postApply(String paramString, ClassNode paramClassNode) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield plugin : Lorg/spongepowered/asm/mixin/extensibility/IMixinConfigPlugin;
/*     */     //   4: ifnull -> 38
/*     */     //   7: aload_0
/*     */     //   8: getfield profiler : Lorg/spongepowered/asm/util/perf/Profiler;
/*     */     //   11: ldc 'plugin'
/*     */     //   13: invokevirtual begin : (Ljava/lang/String;)Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   16: astore_3
/*     */     //   17: aload_0
/*     */     //   18: getfield plugin : Lorg/spongepowered/asm/mixin/extensibility/IMixinConfigPlugin;
/*     */     //   21: aload_1
/*     */     //   22: aload_2
/*     */     //   23: aload_0
/*     */     //   24: getfield className : Ljava/lang/String;
/*     */     //   27: aload_0
/*     */     //   28: invokeinterface postApply : (Ljava/lang/String;Lorg/spongepowered/asm/lib/tree/ClassNode;Ljava/lang/String;Lorg/spongepowered/asm/mixin/extensibility/IMixinInfo;)V
/*     */     //   33: aload_3
/*     */     //   34: invokevirtual end : ()Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   37: pop
/*     */     //   38: aload_0
/*     */     //   39: getfield parent : Lorg/spongepowered/asm/mixin/transformer/MixinConfig;
/*     */     //   42: aload_1
/*     */     //   43: aload_2
/*     */     //   44: invokevirtual postApply : (Ljava/lang/String;Lorg/spongepowered/asm/lib/tree/ClassNode;)V
/*     */     //   47: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #151	-> 0
/*     */     //   #103	-> 7
/*     */     //   #69	-> 17
/*     */     //   #82	-> 33
/*     */     //   #57	-> 38
/*     */     //   #32	-> 47
/*     */   }
/*     */   
/*     */   Set<String> getSyntheticInnerClasses() {
/*     */     return Collections.unmodifiableSet(getState().getSyntheticInnerClasses());
/*     */   }
/*     */   
/*     */   public String getClassName() {
/*     */     return this.className;
/*     */   }
/*     */   
/*     */   public Level getLoggingLevel() {
/*     */     return this.parent.getLoggingLevel();
/*     */   }
/*     */   
/*     */   private void readTargets(Collection<ClassInfo> paramCollection, Collection<String> paramCollection1, boolean paramBoolean1, boolean paramBoolean2) {
/*     */     for (String str1 : paramCollection1)
/*     */       String str2 = str1.replace('/', '.'); 
/*     */   }
/*     */   
/*     */   private byte[] loadMixinClass(String paramString, boolean paramBoolean) throws ClassNotFoundException {
/*     */     // Byte code:
/*     */     //   0: aconst_null
/*     */     //   1: astore_3
/*     */     //   2: iload_2
/*     */     //   3: ifeq -> 61
/*     */     //   6: aload_0
/*     */     //   7: getfield service : Lorg/spongepowered/asm/service/IMixinService;
/*     */     //   10: aload_1
/*     */     //   11: invokeinterface getClassRestrictions : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   16: astore #4
/*     */     //   18: aload #4
/*     */     //   20: invokevirtual length : ()I
/*     */     //   23: ifle -> 61
/*     */     //   26: aload_0
/*     */     //   27: getfield logger : Lorg/apache/logging/log4j/Logger;
/*     */     //   30: ldc 'Classloader restrictions [{}] encountered loading {}, name: {}'
/*     */     //   32: iconst_3
/*     */     //   33: anewarray java/lang/Object
/*     */     //   36: dup
/*     */     //   37: iconst_0
/*     */     //   38: aload #4
/*     */     //   40: aastore
/*     */     //   41: dup
/*     */     //   42: iconst_1
/*     */     //   43: aload_0
/*     */     //   44: aastore
/*     */     //   45: dup
/*     */     //   46: iconst_2
/*     */     //   47: aload_1
/*     */     //   48: aastore
/*     */     //   49: invokeinterface error : (Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   54: goto -> 61
/*     */     //   57: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   60: athrow
/*     */     //   61: aload_0
/*     */     //   62: getfield service : Lorg/spongepowered/asm/service/IMixinService;
/*     */     //   65: invokeinterface getBytecodeProvider : ()Lorg/spongepowered/asm/service/IClassBytecodeProvider;
/*     */     //   70: aload_1
/*     */     //   71: iload_2
/*     */     //   72: invokeinterface getClassBytes : (Ljava/lang/String;Z)[B
/*     */     //   77: astore_3
/*     */     //   78: goto -> 138
/*     */     //   81: astore #4
/*     */     //   83: new java/lang/ClassNotFoundException
/*     */     //   86: dup
/*     */     //   87: ldc 'The specified mixin '%s' was not found'
/*     */     //   89: iconst_1
/*     */     //   90: anewarray java/lang/Object
/*     */     //   93: dup
/*     */     //   94: iconst_0
/*     */     //   95: aload_1
/*     */     //   96: aastore
/*     */     //   97: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   100: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   103: athrow
/*     */     //   104: astore #4
/*     */     //   106: aload_0
/*     */     //   107: getfield logger : Lorg/apache/logging/log4j/Logger;
/*     */     //   110: ldc 'Failed to load mixin {}, the specified mixin will not be applied'
/*     */     //   112: iconst_1
/*     */     //   113: anewarray java/lang/Object
/*     */     //   116: dup
/*     */     //   117: iconst_0
/*     */     //   118: aload_1
/*     */     //   119: aastore
/*     */     //   120: invokeinterface warn : (Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   125: new org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */     //   128: dup
/*     */     //   129: aload_0
/*     */     //   130: ldc 'An error was encountered whilst loading the mixin class'
/*     */     //   132: aload #4
/*     */     //   134: invokespecial <init> : (Lorg/spongepowered/asm/mixin/extensibility/IMixinInfo;Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   137: athrow
/*     */     //   138: aload_3
/*     */     //   139: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #159	-> 0
/*     */     //   #47	-> 2
/*     */     //   #129	-> 6
/*     */     //   #7	-> 18
/*     */     //   #96	-> 26
/*     */     //   #142	-> 61
/*     */     //   #90	-> 78
/*     */     //   #105	-> 81
/*     */     //   #107	-> 83
/*     */     //   #59	-> 104
/*     */     //   #80	-> 106
/*     */     //   #56	-> 125
/*     */     //   #49	-> 138
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	78	81	java/lang/ClassNotFoundException
/*     */     //   2	78	104	java/io/IOException
/*     */     //   18	54	57	java/lang/ClassNotFoundException
/*     */   }
/*     */   
/*     */   private static Exception b(Exception paramException) {
/*     */     return paramException;
/*     */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MixinInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */