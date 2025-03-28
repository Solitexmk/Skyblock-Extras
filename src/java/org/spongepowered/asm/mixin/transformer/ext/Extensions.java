/*    */ package org.spongepowered.asm.mixin.transformer.ext;public final class Extensions { public void add(IExtension paramIExtension) {
/*  2 */     this.extensions.add(paramIExtension);
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
/* 13 */     this.extensionMap.put(paramIExtension.getClass(), paramIExtension);
/*    */   }
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void preApply(ITargetClassContext paramITargetClassContext) {
/*    */     for (IExtension iExtension : this.activeExtensions)
/* 40 */       iExtension.preApply(paramITargetClassContext); 
/*    */   } private static <T> T lookup(Class<? extends T> paramClass, Map<Class<? extends T>, T> paramMap, List<T> paramList) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: aload_0
/*    */     //   2: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*    */     //   7: astore_3
/*    */     //   8: aload_3
/*    */     //   9: ifnonnull -> 112
/*    */     //   12: aload_2
/*    */     //   13: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   18: astore #4
/*    */     //   20: aload #4
/*    */     //   22: invokeinterface hasNext : ()Z
/*    */     //   27: ifeq -> 60
/*    */     //   30: aload #4
/*    */     //   32: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   37: astore #5
/*    */     //   39: aload_0
/*    */     //   40: aload #5
/*    */     //   42: invokevirtual getClass : ()Ljava/lang/Class;
/*    */     //   45: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
/*    */     //   48: ifeq -> 57
/*    */     //   51: aload #5
/*    */     //   53: astore_3
/*    */     //   54: goto -> 60
/*    */     //   57: goto -> 20
/*    */     //   60: aload_3
/*    */     //   61: ifnonnull -> 103
/*    */     //   64: new java/lang/IllegalArgumentException
/*    */     //   67: dup
/*    */     //   68: new java/lang/StringBuilder
/*    */     //   71: dup
/*    */     //   72: invokespecial <init> : ()V
/*    */     //   75: ldc 'Extension for <'
/*    */     //   77: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   80: aload_0
/*    */     //   81: invokevirtual getName : ()Ljava/lang/String;
/*    */     //   84: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   87: ldc '> could not be found'
/*    */     //   89: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   92: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   95: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   98: athrow
/*    */     //   99: invokestatic b : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
/*    */     //   102: athrow
/*    */     //   103: aload_1
/*    */     //   104: aload_0
/*    */     //   105: aload_3
/*    */     //   106: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*    */     //   111: pop
/*    */     //   112: aload_3
/*    */     //   113: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #4	-> 0
/*    */     //   #28	-> 8
/*    */     //   #10	-> 12
/*    */     //   #45	-> 39
/*    */     //   #1	-> 51
/*    */     //   #18	-> 54
/*    */     //   #30	-> 57
/*    */     //   #43	-> 60
/*    */     //   #6	-> 64
/*    */     //   #17	-> 103
/*    */     //   #14	-> 112
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   60	99	99	java/lang/IllegalArgumentException
/*    */   }
/*    */   private final Map<Class<? extends IExtension>, IExtension> extensionMap = new HashMap<Class<? extends IExtension>, IExtension>();
/*    */   public void add(IClassGenerator paramIClassGenerator) {
/*    */     this.generators.add(paramIClassGenerator);
/*    */     this.generatorMap.put(paramIClassGenerator.getClass(), paramIClassGenerator);
/*    */   }
/*    */   public void postApply(ITargetClassContext paramITargetClassContext) {
/*    */     for (IExtension iExtension : this.activeExtensions)
/* 51 */       iExtension.postApply(paramITargetClassContext); 
/*    */   }
/*    */   
/*    */   private final List<IExtension> extensions = new ArrayList<IExtension>();
/*    */   
/*    */   public List<IExtension> getExtensions() {
/*    */     return Collections.unmodifiableList(this.extensions);
/*    */   }
/*    */   
/*    */   public Extensions(MixinTransformer paramMixinTransformer) {
/*    */     this.transformer = paramMixinTransformer;
/*    */   }
/*    */   
/*    */   private List<IExtension> activeExtensions = Collections.emptyList();
/*    */   private final Map<Class<? extends IClassGenerator>, IClassGenerator> generatorMap = new HashMap<Class<? extends IClassGenerator>, IClassGenerator>();
/*    */   
/*    */   public <T extends IClassGenerator> T getGenerator(Class<? extends IClassGenerator> paramClass) {
/*    */     return (T)lookup(paramClass, this.generatorMap, this.generators);
/*    */   }
/*    */   
/*    */   public void export(MixinEnvironment paramMixinEnvironment, String paramString, boolean paramBoolean, byte[] paramArrayOfbyte) {
/*    */     for (IExtension iExtension : this.activeExtensions)
/*    */       iExtension.export(paramMixinEnvironment, paramString, paramBoolean, paramArrayOfbyte); 
/*    */   }
/*    */   
/*    */   private final List<IClassGenerator> generatorsView = Collections.unmodifiableList(this.generators);
/*    */   
/*    */   public List<IClassGenerator> getGenerators() {
/*    */     return this.generatorsView;
/*    */   }
/*    */   
/*    */   public List<IExtension> getActiveExtensions() {
/*    */     return this.activeExtensions;
/*    */   }
/*    */   
/*    */   private final List<IClassGenerator> generators = new ArrayList<IClassGenerator>();
/*    */   private final MixinTransformer transformer;
/*    */   
/*    */   public MixinTransformer getTransformer() {
/*    */     return this.transformer;
/*    */   }
/*    */   
/*    */   public void select(MixinEnvironment paramMixinEnvironment) {
/*    */     ImmutableList.Builder builder = ImmutableList.builder();
/*    */     for (IExtension iExtension : this.extensions) {
/*    */       try {
/*    */         if (iExtension.checkActive(paramMixinEnvironment))
/*    */           builder.add(iExtension); 
/*    */       } catch (IllegalArgumentException illegalArgumentException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } 
/*    */     this.activeExtensions = (List<IExtension>)builder.build();
/*    */   }
/*    */   
/*    */   public <T extends IExtension> T getExtension(Class<? extends IExtension> paramClass) {
/*    */     return (T)lookup(paramClass, this.extensionMap, this.extensions);
/*    */   }
/*    */   
/*    */   private static IllegalArgumentException b(IllegalArgumentException paramIllegalArgumentException) {
/*    */     return paramIllegalArgumentException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\ext\Extensions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */