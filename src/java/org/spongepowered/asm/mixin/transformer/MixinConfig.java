/*   1 */ package org.spongepowered.asm.mixin.transformer;final class MixinConfig implements Comparable<MixinConfig>, IMixinConfig { int getDeclaredMixinCount() { return getCollectionSize((Collection<?>[])new Collection[] { this.mixinClasses, this.mixinClassesClient, this.mixinClassesServer }); }
/*     */ 
/*     */ 
/*     */   
/*     */   int getMixinCount() {
/*   6 */     return this.mixins.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Level getLoggingLevel() {
/*     */     
/*     */     try {  }
/*     */     catch (InvalidMixinException invalidMixinException)
/*  20 */     { throw b(null); }  return this.verboseLogging ? Level.INFO : Level.DEBUG;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean requireOverwriteAnnotations() {
/*  26 */     return this.overwriteOptions.requireOverwriteAnnotations;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  30 */     return this.name;
/*     */   } @SerializedName("overwrites")
/*  32 */   private MixinConfig$OverwriteOptions overwriteOptions = new MixinConfig$OverwriteOptions(); @SerializedName("setSourceFile") private boolean setSourceFile = false; public MixinEnvironment getEnvironment() { return this.env; }
/*     */   public int getPriority() { return this.priority; }
/*     */   private void initCompatibilityLevel() { try { if (this.compatibility == null) return;  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  MixinEnvironment.CompatibilityLevel compatibilityLevel1 = MixinEnvironment.CompatibilityLevel.valueOf(this.compatibility.trim().toUpperCase()); MixinEnvironment.CompatibilityLevel compatibilityLevel2 = MixinEnvironment.getCompatibilityLevel(); try { if (compatibilityLevel1 == compatibilityLevel2) return;  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  try { if (compatibilityLevel2.isAtLeast(compatibilityLevel1)) try { if (!compatibilityLevel2.canSupport(compatibilityLevel1))
/*     */             throw new MixinInitialisationError("Mixin config " + this.name + " requires compatibility level " + compatibilityLevel1 + " which is too old");  } catch (InvalidMixinException invalidMixinException) { throw b(null); }   } catch (InvalidMixinException invalidMixinException) { throw b(null); }  try { if (!compatibilityLevel2.canElevateTo(compatibilityLevel1))
/*     */         throw new MixinInitialisationError("Mixin config " + this.name + " requires compatibility level " + compatibilityLevel1 + " which is prohibited by " + compatibilityLevel2);  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  MixinEnvironment.setCompatibilityLevel(compatibilityLevel1); }
/*  37 */   String remapClassName(String paramString1, String paramString2) { return getReferenceMapper().remap(paramString1, paramString2); }
/*  38 */   private final Logger logger = LogManager.getLogger("mixin"); private final transient List<MixinInfo> mixins = new ArrayList<MixinInfo>(); private final transient Set<String> unhandledTargets = new HashSet<String>(); public boolean isRequired() { return this.required; } private final transient int order = configOrder++; public boolean select(MixinEnvironment paramMixinEnvironment) { try { this.visited = true; } catch (InvalidMixinException invalidMixinException) { throw b(null); }  return (this.env == paramMixinEnvironment); } public Set<String> getUnhandledTargets() { return Collections.unmodifiableSet(this.unhandledTargets); } private void initInjectionPoints() { try { if (this.injectorOptions.injectionPoints == null) {
/*     */         return;
/*     */       } }
/*     */     catch (Throwable throwable)
/*     */     { throw b(null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 187 */     for (String str : this.injectorOptions.injectionPoints)
/*     */     { 
/*     */       try { Class<?> clazz = this.service.getClassProvider().findClass(str, true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         try { if (InjectionPoint.class.isAssignableFrom(clazz))
/* 222 */           { InjectionPoint.register(clazz); continue; }  } catch (Throwable throwable) { throw b(null); }  this.logger.error("Unable to register injection point {} for {}, class must extend InjectionPoint", new Object[] { clazz, this }); }
/* 223 */       catch (Throwable throwable) { this.logger.catching(throwable); }  }  }
/*     */   public String getDefaultInjectorGroup() { String str = this.injectorOptions.defaultGroup; try { if (str != null)
/*     */         try { if (!str.isEmpty()); } catch (InvalidMixinException invalidMixinException) { throw b(null); }   }
/*     */     catch (InvalidMixinException invalidMixinException) { throw b(null); }
/*     */      return "default"; }
/*     */   public boolean hasMixinsFor(String paramString) { return this.mixinMapping.containsKey(paramString); } private static final Set<String> globalMixinList = new HashSet<String>(); void postInitialise() { if (this.plugin != null) { List<String> list = this.plugin.getMixins(); prepareMixins(list, true); }
/* 229 */      for (Iterator<MixinInfo> iterator = this.mixins.iterator(); iterator.hasNext(); ) { MixinInfo mixinInfo = iterator.next(); try { mixinInfo.validate(); for (MixinConfig$IListener mixinConfig$IListener : this.listeners)
/*     */           mixinConfig$IListener.onInit(mixinInfo);  continue; } catch (InvalidMixinException invalidMixinException) { this.logger.error(invalidMixinException.getMixin() + ": " + invalidMixinException.getMessage(), (Throwable)invalidMixinException); removeMixin(mixinInfo); iterator.remove(); continue; } catch (Exception exception) {} this.logger.error(exception.getMessage(), exception); }  } private boolean checkVersion() throws MixinInitialisationError { try { if (this.version == null)
/*     */         this.logger.error("Mixin config {} does not specify \"minVersion\" property", new Object[] { this.name });  } catch (MixinInitialisationError mixinInitialisationError) { throw b(null); }  VersionNumber versionNumber1 = VersionNumber.parse(this.version); VersionNumber versionNumber2 = VersionNumber.parse(this.env.getVersion()); try { if (versionNumber1.compareTo(versionNumber2) > 0) { try { this.logger.warn("Mixin config {} requires mixin subsystem version {} but {} was found. The mixin config will not be applied.", new Object[] { this.name, versionNumber1, versionNumber2 }); if (this.required)
/*     */             throw new MixinInitialisationError("Required mixin config " + this.name + " requires mixin subsystem version " + versionNumber1);  } catch (MixinInitialisationError mixinInitialisationError) { throw b(null); }  return false; }  } catch (MixinInitialisationError mixinInitialisationError) { throw b(null); }
/*     */      return true; }
/*     */   void prepare() { try { if (this.prepared)
/*     */         return;  }
/* 236 */     catch (InvalidMixinException invalidMixinException) { throw b(null); }
/*     */     
/*     */     try {
/*     */       this.prepared = true;
/*     */       prepareMixins(this.mixinClasses, false);
/*     */       switch (MixinConfig$1.$SwitchMap$org$spongepowered$asm$mixin$MixinEnvironment$Side[this.env.getSide().ordinal()]) {
/*     */         case 1:
/*     */           prepareMixins(this.mixinClassesClient, false);
/*     */           return;
/*     */         case 2:
/*     */           prepareMixins(this.mixinClassesServer, false);
/*     */           return;
/*     */       } 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     this.logger.warn("Mixin environment was unable to detect the current side, sided mixins will not be applied"); }
/*     */ 
/*     */   
/*     */   private final transient Map<String, List<MixinInfo>> mixinMapping = new HashMap<String, List<MixinInfo>>();
/*     */   
/*     */   private static int getCollectionSize(Collection<?>... paramVarArgs) {
/*     */     int i = 0;
/*     */     Collection<?>[] arrayOfCollection;
/*     */     int j;
/*     */     byte b;
/*     */     for (arrayOfCollection = paramVarArgs, j = arrayOfCollection.length, b = 0; b < j; ) {
/*     */       Collection<?> collection = arrayOfCollection[b];
/*     */       if (collection != null)
/*     */         i += collection.size(); 
/*     */     } 
/*     */     return i;
/*     */   }
/*     */   
/*     */   public int getDefaultMixinPriority() {
/*     */     return this.mixinPriority;
/*     */   }
/*     */   
/*     */   boolean isVisited() {
/*     */     return this.visited;
/*     */   }
/*     */   
/*     */   public IMixinConfigPlugin getPlugin() {
/*     */     return this.plugin;
/*     */   }
/*     */   
/*     */   public List<String> reloadMixin(String paramString, byte[] paramArrayOfbyte) {
/*     */     for (MixinInfo mixinInfo : this.mixins) {
/*     */       try {
/*     */         if (mixinInfo.getClassName().equals(paramString)) {
/*     */           mixinInfo.reloadMixin(paramArrayOfbyte);
/*     */           return mixinInfo.getTargetClasses();
/*     */         } 
/*     */       } catch (InvalidMixinException invalidMixinException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     return Collections.emptyList();
/*     */   }
/*     */   
/*     */   private transient boolean visited = false;
/*     */   
/*     */   public boolean conformOverwriteVisibility() {
/*     */     return this.overwriteOptions.conformAccessModifiers;
/*     */   }
/*     */   
/*     */   public String getMixinPackage() {
/*     */     return this.mixinPackage;
/*     */   }
/*     */   
/*     */   public List<MixinInfo> getMixinsFor(String paramString) {
/*     */     return mixinsFor(paramString);
/*     */   }
/*     */   
/*     */   void addListener(MixinConfig$IListener paramMixinConfig$IListener) {
/*     */     this.listeners.add(paramMixinConfig$IListener);
/*     */   }
/*     */   
/*     */   static Config create(String paramString, MixinEnvironment paramMixinEnvironment) {
/*     */     try {
/*     */       IMixinService iMixinService = MixinService.getService();
/*     */       MixinConfig mixinConfig = (MixinConfig)(new Gson()).fromJson(new InputStreamReader(iMixinService.getResourceAsStream(paramString)), MixinConfig.class);
/*     */       if (mixinConfig.onLoad(iMixinService, paramString, paramMixinEnvironment))
/*     */         return mixinConfig.getHandle(); 
/*     */       return null;
/*     */     } catch (Exception exception) {
/*     */       exception.printStackTrace();
/*     */       throw new IllegalArgumentException(String.format("The specified resource '%s' was invalid or could not be read", new Object[] { paramString }), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean onLoad(IMixinService paramIMixinService, String paramString, MixinEnvironment paramMixinEnvironment) {
/*     */     try {
/*     */       this.service = paramIMixinService;
/*     */       this.name = paramString;
/*     */       this.env = parseSelector(this.selector, paramMixinEnvironment);
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     this.required &= !this.env.getOption(MixinEnvironment.Option.IGNORE_REQUIRED) ? 1 : 0;
/*     */     initCompatibilityLevel();
/*     */     initInjectionPoints();
/*     */     return checkVersion();
/*     */   }
/*     */   
/*     */   public boolean shouldSetSourceFile() {
/*     */     return this.setSourceFile;
/*     */   }
/*     */   
/*     */   public int getDefaultRequiredInjections() {
/*     */     return this.injectorOptions.defaultRequireValue;
/*     */   }
/*     */   
/*     */   public int compareTo(MixinConfig paramMixinConfig) {
/*     */     try {
/*     */       if (paramMixinConfig == null)
/*     */         return 0; 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (paramMixinConfig.priority == this.priority)
/*     */         return this.order - paramMixinConfig.order; 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return this.priority - paramMixinConfig.priority;
/*     */   }
/*     */   
/*     */   private static int configOrder = 0;
/*     */   private transient Config handle;
/*     */   @SerializedName("target")
/*     */   private String selector;
/*     */   @SerializedName("minVersion")
/*     */   private String version;
/*     */   @SerializedName("compatibilityLevel")
/*     */   private String compatibility;
/*     */   @SerializedName("required")
/*     */   private boolean required;
/*     */   @SerializedName("priority")
/*     */   private int priority;
/*     */   @SerializedName("mixinPriority")
/*     */   private int mixinPriority;
/*     */   @SerializedName("package")
/*     */   private String mixinPackage;
/*     */   @SerializedName("mixins")
/*     */   private List<String> mixinClasses;
/*     */   @SerializedName("client")
/*     */   private List<String> mixinClassesClient;
/*     */   @SerializedName("server")
/*     */   private List<String> mixinClassesServer;
/*     */   @SerializedName("refmap")
/*     */   private String refMapperConfig;
/*     */   @SerializedName("verbose")
/*     */   private boolean verboseLogging;
/*     */   private final transient List<MixinConfig$IListener> listeners;
/*     */   private transient IMixinService service;
/*     */   private transient MixinEnvironment env;
/*     */   private transient String name;
/*     */   @SerializedName("plugin")
/*     */   private String pluginClassName;
/*     */   @SerializedName("injectors")
/*     */   private MixinConfig$InjectorOptions injectorOptions;
/*     */   private transient IMixinConfigPlugin plugin;
/*     */   private transient IReferenceMapper refMapper;
/*     */   private transient boolean prepared;
/*     */   
/*     */   private List<MixinInfo> mixinsFor(String paramString) {
/*     */     List<MixinInfo> list = this.mixinMapping.get(paramString);
/*     */     if (list == null) {
/*     */       list = new ArrayList();
/*     */       this.mixinMapping.put(paramString, list);
/*     */     } 
/*     */     return list;
/*     */   }
/*     */   
/*     */   public Set<String> getTargets() {
/*     */     return Collections.unmodifiableSet(this.mixinMapping.keySet());
/*     */   }
/*     */   
/*     */   private MixinEnvironment parseSelector(String paramString, MixinEnvironment paramMixinEnvironment) {
/*     */     if (paramString != null) {
/*     */       String[] arrayOfString1 = paramString.split("[&\\| ]");
/*     */       String[] arrayOfString2 = arrayOfString1;
/*     */       int i = arrayOfString2.length;
/*     */       boolean bool = false;
/*     */     } 
/*     */     return paramMixinEnvironment;
/*     */   }
/*     */   
/*     */   private void prepareMixins(List<String> paramList, boolean paramBoolean) {
/*     */     try {
/*     */       if (paramList == null)
/*     */         return; 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     for (String str1 : paramList)
/*     */       String str2 = this.mixinPackage + str1; 
/*     */   }
/*     */   
/*     */   private MixinConfig() {
/*     */     this.listeners = new ArrayList<MixinConfig$IListener>();
/*     */     this.injectorOptions = new MixinConfig$InjectorOptions();
/*     */     this.overwriteOptions = new MixinConfig$OverwriteOptions();
/*     */     this.prepared = false;
/*     */     this.visited = false;
/*     */   }
/*     */   
/*     */   void onSelect() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield pluginClassName : Ljava/lang/String;
/*     */     //   4: ifnull -> 78
/*     */     //   7: aload_0
/*     */     //   8: getfield service : Lorg/spongepowered/asm/service/IMixinService;
/*     */     //   11: invokeinterface getClassProvider : ()Lorg/spongepowered/asm/service/IClassProvider;
/*     */     //   16: aload_0
/*     */     //   17: getfield pluginClassName : Ljava/lang/String;
/*     */     //   20: iconst_1
/*     */     //   21: invokeinterface findClass : (Ljava/lang/String;Z)Ljava/lang/Class;
/*     */     //   26: astore_1
/*     */     //   27: aload_0
/*     */     //   28: aload_1
/*     */     //   29: invokevirtual newInstance : ()Ljava/lang/Object;
/*     */     //   32: checkcast org/spongepowered/asm/mixin/extensibility/IMixinConfigPlugin
/*     */     //   35: putfield plugin : Lorg/spongepowered/asm/mixin/extensibility/IMixinConfigPlugin;
/*     */     //   38: aload_0
/*     */     //   39: getfield plugin : Lorg/spongepowered/asm/mixin/extensibility/IMixinConfigPlugin;
/*     */     //   42: ifnull -> 65
/*     */     //   45: aload_0
/*     */     //   46: getfield plugin : Lorg/spongepowered/asm/mixin/extensibility/IMixinConfigPlugin;
/*     */     //   49: aload_0
/*     */     //   50: getfield mixinPackage : Ljava/lang/String;
/*     */     //   53: invokeinterface onLoad : (Ljava/lang/String;)V
/*     */     //   58: goto -> 65
/*     */     //   61: invokestatic b : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
/*     */     //   64: athrow
/*     */     //   65: goto -> 78
/*     */     //   68: astore_1
/*     */     //   69: aload_1
/*     */     //   70: invokevirtual printStackTrace : ()V
/*     */     //   73: aload_0
/*     */     //   74: aconst_null
/*     */     //   75: putfield plugin : Lorg/spongepowered/asm/mixin/extensibility/IMixinConfigPlugin;
/*     */     //   78: aload_0
/*     */     //   79: getfield mixinPackage : Ljava/lang/String;
/*     */     //   82: ldc '.'
/*     */     //   84: invokevirtual endsWith : (Ljava/lang/String;)Z
/*     */     //   87: ifne -> 123
/*     */     //   90: new java/lang/StringBuilder
/*     */     //   93: dup
/*     */     //   94: invokespecial <init> : ()V
/*     */     //   97: aload_0
/*     */     //   98: dup_x1
/*     */     //   99: getfield mixinPackage : Ljava/lang/String;
/*     */     //   102: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   105: ldc '.'
/*     */     //   107: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   110: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   113: putfield mixinPackage : Ljava/lang/String;
/*     */     //   116: goto -> 123
/*     */     //   119: invokestatic b : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
/*     */     //   122: athrow
/*     */     //   123: iconst_0
/*     */     //   124: istore_1
/*     */     //   125: aload_0
/*     */     //   126: getfield refMapperConfig : Ljava/lang/String;
/*     */     //   129: ifnonnull -> 181
/*     */     //   132: aload_0
/*     */     //   133: getfield plugin : Lorg/spongepowered/asm/mixin/extensibility/IMixinConfigPlugin;
/*     */     //   136: ifnull -> 166
/*     */     //   139: goto -> 146
/*     */     //   142: invokestatic b : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
/*     */     //   145: athrow
/*     */     //   146: aload_0
/*     */     //   147: aload_0
/*     */     //   148: getfield plugin : Lorg/spongepowered/asm/mixin/extensibility/IMixinConfigPlugin;
/*     */     //   151: invokeinterface getRefMapperConfig : ()Ljava/lang/String;
/*     */     //   156: putfield refMapperConfig : Ljava/lang/String;
/*     */     //   159: goto -> 166
/*     */     //   162: invokestatic b : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
/*     */     //   165: athrow
/*     */     //   166: aload_0
/*     */     //   167: getfield refMapperConfig : Ljava/lang/String;
/*     */     //   170: ifnonnull -> 181
/*     */     //   173: iconst_1
/*     */     //   174: istore_1
/*     */     //   175: aload_0
/*     */     //   176: ldc 'mixin.refmap.json'
/*     */     //   178: putfield refMapperConfig : Ljava/lang/String;
/*     */     //   181: aload_0
/*     */     //   182: aload_0
/*     */     //   183: getfield refMapperConfig : Ljava/lang/String;
/*     */     //   186: invokestatic read : (Ljava/lang/String;)Lorg/spongepowered/asm/mixin/refmap/ReferenceMapper;
/*     */     //   189: putfield refMapper : Lorg/spongepowered/asm/mixin/refmap/IReferenceMapper;
/*     */     //   192: aload_0
/*     */     //   193: dup
/*     */     //   194: getfield verboseLogging : Z
/*     */     //   197: aload_0
/*     */     //   198: getfield env : Lorg/spongepowered/asm/mixin/MixinEnvironment;
/*     */     //   201: getstatic org/spongepowered/asm/mixin/MixinEnvironment$Option.DEBUG_VERBOSE : Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;
/*     */     //   204: invokevirtual getOption : (Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;)Z
/*     */     //   207: ior
/*     */     //   208: putfield verboseLogging : Z
/*     */     //   211: iload_1
/*     */     //   212: ifne -> 287
/*     */     //   215: aload_0
/*     */     //   216: getfield refMapper : Lorg/spongepowered/asm/mixin/refmap/IReferenceMapper;
/*     */     //   219: invokeinterface isDefault : ()Z
/*     */     //   224: ifeq -> 287
/*     */     //   227: goto -> 234
/*     */     //   230: invokestatic b : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
/*     */     //   233: athrow
/*     */     //   234: aload_0
/*     */     //   235: getfield env : Lorg/spongepowered/asm/mixin/MixinEnvironment;
/*     */     //   238: getstatic org/spongepowered/asm/mixin/MixinEnvironment$Option.DISABLE_REFMAP : Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;
/*     */     //   241: invokevirtual getOption : (Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;)Z
/*     */     //   244: ifne -> 287
/*     */     //   247: goto -> 254
/*     */     //   250: invokestatic b : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
/*     */     //   253: athrow
/*     */     //   254: aload_0
/*     */     //   255: getfield logger : Lorg/apache/logging/log4j/Logger;
/*     */     //   258: ldc 'Reference map '{}' for {} could not be read. If this is a development environment you can ignore this message'
/*     */     //   260: iconst_2
/*     */     //   261: anewarray java/lang/Object
/*     */     //   264: dup
/*     */     //   265: iconst_0
/*     */     //   266: aload_0
/*     */     //   267: getfield refMapperConfig : Ljava/lang/String;
/*     */     //   270: aastore
/*     */     //   271: dup
/*     */     //   272: iconst_1
/*     */     //   273: aload_0
/*     */     //   274: aastore
/*     */     //   275: invokeinterface warn : (Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   280: goto -> 287
/*     */     //   283: invokestatic b : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
/*     */     //   286: athrow
/*     */     //   287: aload_0
/*     */     //   288: getfield env : Lorg/spongepowered/asm/mixin/MixinEnvironment;
/*     */     //   291: getstatic org/spongepowered/asm/mixin/MixinEnvironment$Option.REFMAP_REMAP : Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;
/*     */     //   294: invokevirtual getOption : (Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;)Z
/*     */     //   297: ifeq -> 322
/*     */     //   300: aload_0
/*     */     //   301: aload_0
/*     */     //   302: getfield env : Lorg/spongepowered/asm/mixin/MixinEnvironment;
/*     */     //   305: aload_0
/*     */     //   306: getfield refMapper : Lorg/spongepowered/asm/mixin/refmap/IReferenceMapper;
/*     */     //   309: invokestatic of : (Lorg/spongepowered/asm/mixin/MixinEnvironment;Lorg/spongepowered/asm/mixin/refmap/IReferenceMapper;)Lorg/spongepowered/asm/mixin/refmap/IReferenceMapper;
/*     */     //   312: putfield refMapper : Lorg/spongepowered/asm/mixin/refmap/IReferenceMapper;
/*     */     //   315: goto -> 322
/*     */     //   318: invokestatic b : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
/*     */     //   321: athrow
/*     */     //   322: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #194	-> 0
/*     */     //   #36	-> 7
/*     */     //   #183	-> 27
/*     */     //   #192	-> 38
/*     */     //   #51	-> 45
/*     */     //   #182	-> 65
/*     */     //   #167	-> 68
/*     */     //   #127	-> 69
/*     */     //   #57	-> 73
/*     */     //   #50	-> 78
/*     */     //   #227	-> 90
/*     */     //   #10	-> 123
/*     */     //   #173	-> 125
/*     */     //   #14	-> 132
/*     */     //   #132	-> 146
/*     */     //   #202	-> 166
/*     */     //   #197	-> 173
/*     */     //   #64	-> 175
/*     */     //   #131	-> 181
/*     */     //   #100	-> 192
/*     */     //   #130	-> 211
/*     */     //   #155	-> 254
/*     */     //   #46	-> 287
/*     */     //   #28	-> 300
/*     */     //   #138	-> 322
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   7	65	68	java/lang/Throwable
/*     */     //   27	58	61	java/lang/Throwable
/*     */     //   78	116	119	java/lang/Throwable
/*     */     //   125	139	142	java/lang/Throwable
/*     */     //   132	159	162	java/lang/Throwable
/*     */     //   181	227	230	java/lang/Throwable
/*     */     //   215	247	250	java/lang/Throwable
/*     */     //   234	280	283	java/lang/Throwable
/*     */     //   287	315	318	java/lang/Throwable
/*     */   }
/*     */   
/*     */   public List<String> getClasses() {
/*     */     return Collections.unmodifiableList(this.mixinClasses);
/*     */   }
/*     */   
/*     */   private void removeMixin(MixinInfo paramMixinInfo) {
/*     */     for (List<MixinInfo> list : this.mixinMapping.values())
/*     */       Iterator iterator = list.iterator(); 
/*     */   }
/*     */   
/*     */   public Config getHandle() {
/*     */     try {
/*     */       if (this.handle == null)
/*     */         this.handle = new Config(this); 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return this.handle;
/*     */   }
/*     */   
/*     */   void postApply(String paramString, ClassNode paramClassNode) {
/*     */     this.unhandledTargets.remove(paramString);
/*     */   }
/*     */   
/*     */   public IReferenceMapper getReferenceMapper() {
/*     */     try {
/*     */       if (this.env.getOption(MixinEnvironment.Option.DISABLE_REFMAP))
/*     */         return (IReferenceMapper)ReferenceMapper.DEFAULT_MAPPER; 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     this.refMapper.setContext(this.env.getRefmapObfuscationContext());
/*     */     return this.refMapper;
/*     */   }
/*     */   
/*     */   public boolean packageMatch(String paramString) {
/*     */     return paramString.startsWith(this.mixinPackage);
/*     */   }
/*     */   
/*     */   public String getName() {
/*     */     return this.name;
/*     */   }
/*     */   
/*     */   public int getMaxShiftByValue() {
/*     */     return Math.min(Math.max(this.injectorOptions.maxShiftBy, 0), 5);
/*     */   }
/*     */   
/*     */   private static Throwable b(Throwable paramThrowable) {
/*     */     return paramThrowable;
/*     */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MixinConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */