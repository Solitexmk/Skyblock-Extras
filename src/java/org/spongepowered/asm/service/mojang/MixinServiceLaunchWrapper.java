/*     */ package org.spongepowered.asm.service.mojang;public class MixinServiceLaunchWrapper implements IMixinService, IClassProvider, IClassBytecodeProvider { public boolean isClassLoaded(String paramString) {
/*   2 */     return this.classLoaderUtil.isClassLoaded(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private IClassNameTransformer nameTransformer;
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<String> getPlatformAgents() {
/*  12 */     return (Collection<String>)ImmutableList.of("org.spongepowered.asm.launch.platform.MixinPlatformAgentFML");
/*     */   }
/*     */   public void init() {
/*     */     
/*  16 */     try { if (findInStackTrace("net.minecraft.launchwrapper.Launch", "launch") < 4)
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
/*  33 */         logger.error("MixinBootstrap.doInit() called during a tweak constructor!"); }  } catch (MixinException mixinException) { throw b(null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  45 */     List<String> list = (List)GlobalProperties.get("TweakClasses");
/*     */ 
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
/*  57 */       if (list != null) {
/*     */         list.add("org.spongepowered.asm.mixin.EnvironmentStateTweaker");
/*     */       }
/*     */     } catch (MixinException mixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkEnv(Object paramObject) {
/*     */     
/*     */     try { if (paramObject.getClass().getClassLoader() != Launch.class.getClassLoader())
/* 108 */         throw new MixinException("Attempted to init the mixin environment in the wrong classloader");  } catch (MixinException mixinException) { throw b(null); }
/*     */   
/*     */   } private final ReEntranceLock lock = new ReEntranceLock(1); public void registerInvalidClass(String paramString) { this.classLoaderUtil.registerInvalidClass(paramString); } public URL[] getClassPath() { return (URL[])Launch.classLoader.getSources().toArray((Object[])new URL[0]); }
/*     */   public MixinEnvironment.Phase getInitialPhase() { try {
/*     */       if (findInStackTrace("net.minecraft.launchwrapper.Launch", "launch") > 132)
/*     */         return MixinEnvironment.Phase.DEFAULT; 
/*     */     } catch (MixinException mixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return MixinEnvironment.Phase.PREINIT; }
/*     */   public ReEntranceLock getReEntranceLock() {
/*     */     return this.lock;
/*     */   }
/*     */   public String getClassRestrictions(String paramString) { String str = "";
/*     */     if (this.classLoaderUtil.isClassClassLoaderExcluded(paramString, null))
/*     */       str = "PACKAGE_CLASSLOADER_EXCLUSION"; 
/*     */     try {
/*     */       if (this.classLoaderUtil.isClassTransformerExcluded(paramString, null)) {
/*     */         try {
/*     */         
/*     */         } catch (MixinException mixinException) {
/*     */           throw b(null);
/*     */         } 
/*     */         str = ((str.length() > 0) ? (str + ",") : "") + "PACKAGE_TRANSFORMER_EXCLUSION";
/*     */       } 
/*     */     } catch (MixinException mixinException) {
/*     */       throw b(null);
/*     */     } 
/* 136 */     return str; } public String getName() { return "LaunchWrapper"; }
/*     */   private ClassNode getClassNode(byte[] paramArrayOfbyte, int paramInt) { ClassNode classNode = new ClassNode(); ClassReader classReader = new ClassReader(paramArrayOfbyte); classReader.accept((ClassVisitor)classNode, paramInt); return classNode; }
/*     */   public final String getSideName() { for (ITweaker iTweaker : GlobalProperties.get("Tweaks")) { try { if (iTweaker.getClass().getName().endsWith(".common.launcher.FMLServerTweaker"))
/*     */           return "SERVER";  }
/*     */       catch (MixinException mixinException) { throw b(null); }
/* 141 */        try { if (iTweaker.getClass().getName().endsWith(".common.launcher.FMLTweaker"))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 147 */           return "CLIENT"; }  } catch (MixinException mixinException) { throw b(null); }  }  String str = getSideName("net.minecraftforge.fml.relauncher.FMLLaunchHandler", "side"); try { if (str != null) return str;  } catch (MixinException mixinException) { throw b(null); }  str = getSideName("cpw.mods.fml.relauncher.FMLLaunchHandler", "side"); try { if (str != null) return str;  } catch (MixinException mixinException) { throw b(null); }  str = getSideName("com.mumfrey.liteloader.launch.LiteLoaderTweaker", "getEnvironmentType"); try { if (str != null)
/* 148 */         return str;  } catch (MixinException mixinException) { throw b(null); }  return "UNKNOWN"; } private final LaunchClassLoaderUtil classLoaderUtil = new LaunchClassLoaderUtil(Launch.classLoader); private String unmapClassName(String paramString) { try { if (this.nameTransformer == null)
/* 149 */         findNameTransformer();  } catch (MixinException mixinException) { throw b(null); }
/*     */     
/*     */     try {
/*     */       if (this.nameTransformer != null)
/*     */         return this.nameTransformer.unmapClassName(paramString); 
/*     */     } catch (MixinException mixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return paramString; }
/*     */ 
/*     */   
/*     */   public byte[] getClassBytes(String paramString1, String paramString2) throws IOException {
/*     */     byte[] arrayOfByte = Launch.classLoader.getClassBytes(paramString1);
/*     */     try {
/*     */       if (arrayOfByte != null)
/*     */         return arrayOfByte; 
/*     */     } catch (Exception exception) {
/*     */       throw b(null);
/*     */     } 
/*     */     URLClassLoader uRLClassLoader = (URLClassLoader)Launch.class.getClassLoader();
/*     */     InputStream inputStream = null;
/*     */     try {
/*     */       String str = paramString2.replace('.', '/').concat(".class");
/*     */       inputStream = uRLClassLoader.getResourceAsStream(str);
/*     */       return IOUtils.toByteArray(inputStream);
/*     */     } catch (Exception exception) {
/*     */       return null;
/*     */     } finally {
/*     */       IOUtils.closeQuietly(inputStream);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void findNameTransformer() {
/*     */     List list = Launch.classLoader.getTransformers();
/*     */     for (IClassTransformer iClassTransformer : list) {
/*     */       try {
/*     */         if (iClassTransformer instanceof IClassNameTransformer) {
/*     */           logger.debug("Found name transformer: {}", new Object[] { iClassTransformer.getClass().getName() });
/*     */           this.nameTransformer = (IClassNameTransformer)iClassTransformer;
/*     */         } 
/*     */       } catch (MixinException mixinException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public InputStream getResourceAsStream(String paramString) {
/*     */     return Launch.classLoader.getResourceAsStream(paramString);
/*     */   }
/*     */   
/*     */   public IClassProvider getClassProvider() {
/*     */     return this;
/*     */   }
/*     */   
/*     */   public IClassBytecodeProvider getBytecodeProvider() {
/*     */     return this;
/*     */   }
/*     */   
/*     */   public Collection<ITransformer> getTransformers() {
/*     */     List list = Launch.classLoader.getTransformers();
/*     */     ArrayList<ITransformer> arrayList = new ArrayList(list.size());
/*     */     for (IClassTransformer iClassTransformer : list) {
/*     */       try {
/*     */         if (iClassTransformer instanceof ITransformer) {
/*     */           arrayList.add((ITransformer)iClassTransformer);
/*     */         } else {
/*     */           arrayList.add(new LegacyTransformerHandle(iClassTransformer));
/*     */         } 
/*     */       } catch (MixinException mixinException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     return arrayList;
/*     */   }
/*     */   
/*     */   private static int findInStackTrace(String paramString1, String paramString2) {
/*     */     Thread thread = Thread.currentThread();
/*     */     try {
/*     */       if (!"main".equals(thread.getName()))
/*     */         return 0; 
/*     */     } catch (MixinException mixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     StackTraceElement[] arrayOfStackTraceElement1 = thread.getStackTrace();
/*     */     StackTraceElement[] arrayOfStackTraceElement2;
/*     */     int i;
/*     */     byte b;
/*     */     for (arrayOfStackTraceElement2 = arrayOfStackTraceElement1, i = arrayOfStackTraceElement2.length, b = 0; b < i; ) {
/*     */       StackTraceElement stackTraceElement = arrayOfStackTraceElement2[b];
/*     */       try {
/*     */         if (paramString1.equals(stackTraceElement.getClassName()))
/*     */           try {
/*     */             if (paramString2.equals(stackTraceElement.getMethodName()))
/*     */               return stackTraceElement.getLineNumber(); 
/*     */           } catch (MixinException mixinException) {
/*     */             throw b(null);
/*     */           }  
/*     */       } catch (MixinException mixinException) {
/*     */         throw b(null);
/*     */       } 
/*     */       b++;
/*     */     } 
/*     */     return 0;
/*     */   }
/*     */   
/*     */   public ClassNode getClassNode(String paramString) throws ClassNotFoundException, IOException {
/*     */     return getClassNode(getClassBytes(paramString, true), 0);
/*     */   }
/*     */   
/*     */   public Class<?> findClass(String paramString, boolean paramBoolean) throws ClassNotFoundException {
/*     */     return Class.forName(paramString, paramBoolean, (ClassLoader)Launch.classLoader);
/*     */   }
/*     */   
/*     */   public void beginPhase() {
/*     */     Launch.classLoader.registerTransformer("org.spongepowered.asm.mixin.transformer.Proxy");
/*     */   }
/*     */   
/*     */   public void prepare() {
/*     */     Launch.classLoader.addClassLoaderExclusion("org.spongepowered.asm.launch.");
/*     */   }
/*     */   
/*     */   public byte[] getClassBytes(String paramString, boolean paramBoolean) throws ClassNotFoundException, IOException {
/*     */     String str1 = paramString.replace('/', '.');
/*     */     String str2 = unmapClassName(str1);
/*     */     Profiler profiler = MixinEnvironment.getProfiler();
/*     */     Profiler.Section section = profiler.begin(1, "class.load");
/*     */     byte[] arrayOfByte = getClassBytes(str2, str1);
/*     */     section.end();
/*     */     if (paramBoolean) {
/*     */       Profiler.Section section1 = profiler.begin(1, "class.transform");
/*     */       arrayOfByte = applyTransformers(str2, str1, arrayOfByte, profiler);
/*     */       section1.end();
/*     */     } 
/*     */     try {
/*     */       if (arrayOfByte == null)
/*     */         throw new ClassNotFoundException(String.format("The specified class '%s' was not found", new Object[] { str1 })); 
/*     */     } catch (ClassNotFoundException classNotFoundException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return arrayOfByte;
/*     */   }
/*     */   
/*     */   private byte[] applyTransformers(String paramString1, String paramString2, byte[] paramArrayOfbyte, Profiler paramProfiler) {
/*     */     try {
/*     */       if (this.classLoaderUtil.isClassExcluded(paramString1, paramString2))
/*     */         return paramArrayOfbyte; 
/*     */     } catch (MixinException mixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     MixinEnvironment mixinEnvironment = MixinEnvironment.getCurrentEnvironment();
/*     */     for (ILegacyClassTransformer iLegacyClassTransformer : mixinEnvironment.getTransformers()) {
/*     */       this.lock.clear();
/*     */       int i = iLegacyClassTransformer.getName().lastIndexOf('.');
/*     */       String str = iLegacyClassTransformer.getName().substring(i + 1);
/*     */       Profiler.Section section = paramProfiler.begin(2, str.toLowerCase());
/*     */       section.setInfo(iLegacyClassTransformer.getName());
/*     */     } 
/*     */     return paramArrayOfbyte;
/*     */   }
/*     */   
/*     */   public Class<?> findClass(String paramString) throws ClassNotFoundException {
/*     */     return Launch.classLoader.findClass(paramString);
/*     */   }
/*     */   
/*     */   public Class<?> findAgentClass(String paramString, boolean paramBoolean) throws ClassNotFoundException {
/*     */     return Class.forName(paramString, paramBoolean, Launch.class.getClassLoader());
/*     */   }
/*     */   
/*     */   private String getSideName(String paramString1, String paramString2) {
/*     */     try {
/*     */       Class<?> clazz = Class.forName(paramString1, false, (ClassLoader)Launch.classLoader);
/*     */       Method method = clazz.getDeclaredMethod(paramString2, new Class[0]);
/*     */       return ((Enum)method.invoke(null, new Object[0])).name();
/*     */     } catch (Exception exception) {
/*     */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static final Logger logger = LogManager.getLogger("mixin");
/*     */   private static final String TRANSFORMER_PROXY_CLASS = "org.spongepowered.asm.mixin.transformer.Proxy";
/*     */   private static final String STATE_TWEAKER = "org.spongepowered.asm.mixin.EnvironmentStateTweaker";
/*     */   private static final String MIXIN_PACKAGE = "org.spongepowered.asm.mixin.";
/*     */   private static final String LAUNCH_PACKAGE = "org.spongepowered.asm.launch.";
/*     */   public static final String BLACKBOARD_KEY_TWEAKS = "Tweaks";
/*     */   public static final String BLACKBOARD_KEY_TWEAKCLASSES = "TweakClasses";
/*     */   
/*     */   public boolean isValid() {
/*     */     try {
/*     */       Launch.classLoader.hashCode();
/*     */     } catch (Throwable throwable) {
/*     */       return false;
/*     */     } 
/*     */     return true;
/*     */   }
/*     */   
/*     */   private static Exception b(Exception paramException) {
/*     */     return paramException;
/*     */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\service\mojang\MixinServiceLaunchWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */