/*    */ package org.spongepowered.asm.mixin.refmap;
/*  2 */ public final class ReferenceMapper implements IReferenceMapper, Serializable { private String remap(Map<String, Map<String, String>> paramMap, String paramString1, String paramString2) { if (paramString1 == null)
/*    */     {
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 55 */       for (Map<String, String> map1 : paramMap.values())
/*    */       { 
/*    */         try { if (map1.containsKey(paramString2))
/* 58 */             return (String)map1.get(paramString2);  } catch (JsonParseException jsonParseException) { throw b(null); }  }  }  Map map = paramMap.get(paramString1); try { if (map == null)
/*    */         return paramString2;  }
/*    */     catch (JsonParseException jsonParseException) { throw b(null); }
/* 61 */      String str = (String)map.get(paramString2); try {  } catch (JsonParseException jsonParseException) { throw b(null); }
/*    */      return (str != null) ? str : paramString2; } public String getResourceName() { return this.resource; } private transient String context = null;
/* 63 */   public static ReferenceMapper read(String paramString) { Logger logger = LogManager.getLogger("mixin"); InputStreamReader inputStreamReader = null; try { IMixinService iMixinService = MixinService.getService(); InputStream inputStream = iMixinService.getResourceAsStream(paramString); if (inputStream != null) { inputStreamReader = new InputStreamReader(inputStream);
/*    */ 
/*    */         
/*    */         ReferenceMapper referenceMapper = readJson(inputStreamReader);
/*    */ 
/*    */         
/*    */         referenceMapper.setResourceName(paramString); }
/*    */        }
/* 71 */     catch (JsonParseException jsonParseException) { logger.error("Invalid REFMAP JSON in " + paramString + ": " + jsonParseException.getClass().getName() + " " + jsonParseException.getMessage()); } catch (Exception exception) { logger.error("Failed reading REFMAP JSON from " + paramString + ": " + exception.getClass().getName() + " " + exception.getMessage()); } finally { IOUtils.closeQuietly(inputStreamReader); }
/*    */      return DEFAULT_MAPPER; }
/*    */   private final Map<String, Map<String, String>> mappings = Maps.newHashMap(); public String remap(String paramString1, String paramString2) { return remapWithContext(this.context, paramString1, paramString2); } private final Map<String, Map<String, Map<String, String>>> data = Maps.newHashMap(); public static final ReferenceMapper DEFAULT_MAPPER = new ReferenceMapper(true, "invalid"); private static final long serialVersionUID = 2L; public static final String DEFAULT_RESOURCE = "mixin.refmap.json"; private final transient boolean readOnly; public String remapWithContext(String paramString1, String paramString2, String paramString3) { Map<String, Map<String, String>> map = this.mappings; if (paramString1 != null) { map = this.data.get(paramString1); if (map == null)
/* 74 */         map = this.mappings;  }  return remap(map, paramString2, paramString3); }
/*    */   private transient String resource;
/*    */   public String addMapping(String paramString1, String paramString2, String paramString3, String paramString4) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield readOnly : Z
/*    */     //   4: ifne -> 46
/*    */     //   7: aload_3
/*    */     //   8: ifnull -> 46
/*    */     //   11: goto -> 18
/*    */     //   14: invokestatic b : (Lcom/google/gson/JsonParseException;)Lcom/google/gson/JsonParseException;
/*    */     //   17: athrow
/*    */     //   18: aload #4
/*    */     //   20: ifnull -> 46
/*    */     //   23: goto -> 30
/*    */     //   26: invokestatic b : (Lcom/google/gson/JsonParseException;)Lcom/google/gson/JsonParseException;
/*    */     //   29: athrow
/*    */     //   30: aload_3
/*    */     //   31: aload #4
/*    */     //   33: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   36: ifeq -> 52
/*    */     //   39: goto -> 46
/*    */     //   42: invokestatic b : (Lcom/google/gson/JsonParseException;)Lcom/google/gson/JsonParseException;
/*    */     //   45: athrow
/*    */     //   46: aconst_null
/*    */     //   47: areturn
/*    */     //   48: invokestatic b : (Lcom/google/gson/JsonParseException;)Lcom/google/gson/JsonParseException;
/*    */     //   51: athrow
/*    */     //   52: aload_0
/*    */     //   53: getfield mappings : Ljava/util/Map;
/*    */     //   56: astore #5
/*    */     //   58: aload_1
/*    */     //   59: ifnull -> 100
/*    */     //   62: aload_0
/*    */     //   63: getfield data : Ljava/util/Map;
/*    */     //   66: aload_1
/*    */     //   67: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*    */     //   72: checkcast java/util/Map
/*    */     //   75: astore #5
/*    */     //   77: aload #5
/*    */     //   79: ifnonnull -> 100
/*    */     //   82: invokestatic newHashMap : ()Ljava/util/HashMap;
/*    */     //   85: astore #5
/*    */     //   87: aload_0
/*    */     //   88: getfield data : Ljava/util/Map;
/*    */     //   91: aload_1
/*    */     //   92: aload #5
/*    */     //   94: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*    */     //   99: pop
/*    */     //   100: aload #5
/*    */     //   102: aload_2
/*    */     //   103: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*    */     //   108: checkcast java/util/Map
/*    */     //   111: astore #6
/*    */     //   113: aload #6
/*    */     //   115: ifnonnull -> 138
/*    */     //   118: new java/util/HashMap
/*    */     //   121: dup
/*    */     //   122: invokespecial <init> : ()V
/*    */     //   125: astore #6
/*    */     //   127: aload #5
/*    */     //   129: aload_2
/*    */     //   130: aload #6
/*    */     //   132: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*    */     //   137: pop
/*    */     //   138: aload #6
/*    */     //   140: aload_3
/*    */     //   141: aload #4
/*    */     //   143: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*    */     //   148: checkcast java/lang/String
/*    */     //   151: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #33	-> 0
/*    */     //   #78	-> 46
/*    */     //   #35	-> 52
/*    */     //   #27	-> 58
/*    */     //   #16	-> 62
/*    */     //   #50	-> 77
/*    */     //   #34	-> 82
/*    */     //   #1	-> 87
/*    */     //   #47	-> 100
/*    */     //   #44	-> 113
/*    */     //   #14	-> 118
/*    */     //   #32	-> 127
/*    */     //   #57	-> 138
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   0	11	14	com/google/gson/JsonParseException
/*    */     //   7	23	26	com/google/gson/JsonParseException
/*    */     //   18	39	42	com/google/gson/JsonParseException
/*    */     //   30	48	48	com/google/gson/JsonParseException }
/* 77 */   public static ReferenceMapper read(Reader paramReader, String paramString) { try { ReferenceMapper referenceMapper = readJson(paramReader); referenceMapper.setResourceName(paramString); return referenceMapper; } catch (Exception exception) { return DEFAULT_MAPPER; }  } private static ReferenceMapper readJson(Reader paramReader) { return (ReferenceMapper)(new Gson()).fromJson(paramReader, ReferenceMapper.class); } public ReferenceMapper() { this(false, "mixin.refmap.json"); } public String getStatus() { try {  } catch (JsonParseException jsonParseException) { throw b(null); }  return isDefault() ? "No refMap loaded." : ("Using refmap " + getResourceName()); } public boolean isDefault() { return this.readOnly; } public void write(Appendable paramAppendable) { (new GsonBuilder()).setPrettyPrinting().create().toJson(this, paramAppendable); } private void setResourceName(String paramString) { try { if (!this.readOnly) { try {  } catch (JsonParseException jsonParseException) { throw b(null); }  this.resource = (paramString != null) ? paramString : "<unknown resource>"; }  } catch (JsonParseException jsonParseException) { throw b(null); }  } public String getContext() { return this.context; }
/*    */   private ReferenceMapper(boolean paramBoolean, String paramString) { this.readOnly = paramBoolean; this.resource = paramString; }
/* 79 */   public void setContext(String paramString) { this.context = paramString; }
/*    */ 
/*    */   
/*    */   private static JsonParseException b(JsonParseException paramJsonParseException) {
/*    */     return paramJsonParseException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\refmap\ReferenceMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */