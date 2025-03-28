/*    */ package org.spongepowered.asm.mixin.refmap;public final class RemappingReferenceMapper implements IReferenceMapper {
/*  2 */   private static final Map<String, Map<String, String>> srgs = new HashMap<String, Map<String, String>>();
/*  3 */   private final Map<String, Map<String, String>> cache = new HashMap<String, Map<String, String>>();
/*  4 */   private RemappingReferenceMapper(MixinEnvironment paramMixinEnvironment, IReferenceMapper paramIReferenceMapper) { this.refMap = paramIReferenceMapper;
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
/* 20 */     this.refMap.setContext(getMappingEnv(paramMixinEnvironment));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 29 */     String str = getResource(paramMixinEnvironment); this.mappings = loadSrgs(str); logger.info("Remapping refMap {} using {}", new Object[] { paramIReferenceMapper.getResourceName(), str }); } private static String getMappingEnv(MixinEnvironment paramMixinEnvironment) { String str = paramMixinEnvironment.getOptionValue(MixinEnvironment.Option.REFMAP_REMAP_SOURCE_ENV); try {  }
/*    */     catch (RuntimeException runtimeException)
/* 31 */     { throw b(null); }  return Strings.isNullOrEmpty(str) ? "searge" : str; }
/*    */   
/*    */   public boolean isDefault() {
/*    */     return this.refMap.isDefault();
/*    */   }
/*    */   private static final Logger logger = LogManager.getLogger("mixin"); private static final String DEFAULT_RESOURCE_PATH_PROPERTY = "net.minecraftforge.gradle.GradleStart.srg.srg-mcp";
/*    */   private static final String DEFAULT_MAPPING_ENV = "searge";
/*    */   private final IReferenceMapper refMap;
/*    */   private final Map<String, String> mappings;
/*    */   
/*    */   public String getStatus() {
/*    */     return this.refMap.getStatus();
/*    */   }
/*    */   
/*    */   public String remap(String paramString1, String paramString2) {
/*    */     Map<String, String> map = getCache(paramString1);
/*    */     String str = map.get(paramString2);
/*    */     if (str == null) {
/*    */       str = this.refMap.remap(paramString1, paramString2);
/*    */       Iterator iterator = this.mappings.entrySet().iterator();
/*    */     } 
/* 52 */     return str;
/*    */   }
/*    */   
/*    */   private static Map<String, String> loadSrgs(String paramString) {
/*    */     try {
/*    */       if (srgs.containsKey(paramString))
/*    */         return srgs.get(paramString); 
/*    */     } catch (IOException iOException) {
/*    */       throw b(null);
/*    */     } 
/*    */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*    */     srgs.put(paramString, hashMap);
/*    */     File file = new File(paramString);
/*    */     try {
/*    */       if (!file.isFile())
/*    */         return (Map)hashMap; 
/*    */     } catch (IOException iOException) {
/*    */       throw b(null);
/*    */     } 
/*    */     try {
/*    */       Files.readLines(file, Charsets.UTF_8, new RemappingReferenceMapper$1(hashMap));
/*    */     } catch (IOException iOException) {
/*    */       logger.warn("Could not read input SRG file: {}", new Object[] { paramString });
/*    */       logger.catching(iOException);
/*    */     } 
/*    */     return (Map)hashMap;
/*    */   }
/*    */   
/*    */   public String remapWithContext(String paramString1, String paramString2, String paramString3) {
/*    */     return this.refMap.remapWithContext(paramString1, paramString2, paramString3);
/*    */   }
/*    */   
/*    */   public static IReferenceMapper of(MixinEnvironment paramMixinEnvironment, IReferenceMapper paramIReferenceMapper) {
/*    */     try {
/*    */       if (!paramIReferenceMapper.isDefault())
/*    */         try {
/*    */           if (hasData(paramMixinEnvironment))
/*    */             return new RemappingReferenceMapper(paramMixinEnvironment, paramIReferenceMapper); 
/*    */         } catch (RuntimeException runtimeException) {
/*    */           throw b(null);
/*    */         }  
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return paramIReferenceMapper;
/*    */   }
/*    */   
/*    */   private Map<String, String> getCache(String paramString) {
/*    */     Map<Object, Object> map = (Map)this.cache.get(paramString);
/*    */     if (map == null) {
/*    */       map = new HashMap<Object, Object>();
/*    */       this.cache.put(paramString, map);
/*    */     } 
/*    */     return (Map)map;
/*    */   }
/*    */   
/*    */   public void setContext(String paramString) {}
/*    */   
/*    */   private static String getResource(MixinEnvironment paramMixinEnvironment) {
/*    */     String str = paramMixinEnvironment.getOptionValue(MixinEnvironment.Option.REFMAP_REMAP_RESOURCE);
/*    */     try {
/*    */     
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return Strings.isNullOrEmpty(str) ? System.getProperty("net.minecraftforge.gradle.GradleStart.srg.srg-mcp") : str;
/*    */   }
/*    */   
/*    */   public String getContext() {
/*    */     return this.refMap.getContext();
/*    */   }
/*    */   
/*    */   private static boolean hasData(MixinEnvironment paramMixinEnvironment) {
/*    */     String str = getResource(paramMixinEnvironment);
/*    */     try {
/*    */     
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return (str != null && (new File(str)).exists());
/*    */   }
/*    */   
/*    */   public String getResourceName() {
/*    */     return this.refMap.getResourceName();
/*    */   }
/*    */   
/*    */   private static Exception b(Exception paramException) {
/*    */     return paramException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\refmap\RemappingReferenceMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */