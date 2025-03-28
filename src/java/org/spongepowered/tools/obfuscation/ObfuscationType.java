/*    */ package org.spongepowered.tools.obfuscation;
/*    */ 
/*    */ import org.spongepowered.tools.obfuscation.service.ObfuscationTypeDescriptor;
/*    */ 
/*    */ public final class ObfuscationType {
/*    */   public final ObfuscationEnvironment createEnvironment() { try {
/*  7 */       Class clazz = this.descriptor.getEnvironmentType();
/*    */       
/*  9 */       Constructor<ObfuscationEnvironment> constructor = clazz.getDeclaredConstructor(new Class[] { ObfuscationType.class });
/*    */ 
/*    */ 
/*    */       
/* 13 */       constructor.setAccessible(true);
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
/* 27 */       return constructor.newInstance(new Object[] { this });
/*    */     } catch (Exception exception) {
/*    */       throw new RuntimeException(exception);
/*    */     }  }
/*    */   
/*    */   public String getKey() {
/*    */     return this.key;
/*    */   }
/*    */   private static final Map<String, ObfuscationType> types = new LinkedHashMap<String, ObfuscationType>(); private final String key;
/*    */   private final ObfuscationTypeDescriptor descriptor;
/*    */   
/*    */   public static ObfuscationType get(String paramString) {
/*    */     ObfuscationType obfuscationType = types.get(paramString);
/*    */     
/*    */     try { if (obfuscationType == null)
/* 42 */         throw new IllegalArgumentException("Obfuscation type with key " + paramString + " was not registered");  } catch (RuntimeException runtimeException) { throw b(null); }
/*    */     
/*    */     return obfuscationType;
/*    */   }
/*    */   
/*    */   private final IMixinAnnotationProcessor ap;
/*    */   private final IOptionProvider options;
/*    */   
/*    */   public ObfuscationTypeDescriptor getConfig() {
/*    */     return this.descriptor;
/*    */   }
/*    */   
/*    */   public boolean isSupported() {
/*    */     try {
/*    */     
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return (getInputFileNames().size() > 0);
/*    */   }
/*    */   
/*    */   public static Iterable<ObfuscationType> types() {
/*    */     return types.values();
/*    */   }
/*    */   
/*    */   public String getOutputFileName() {
/*    */     return this.options.getOption(this.descriptor.getOutputFileOption());
/*    */   }
/*    */   
/*    */   public IMixinAnnotationProcessor getAnnotationProcessor() {
/*    */     return this.ap;
/*    */   }
/*    */   
/*    */   public String toString() {
/*    */     return this.key;
/*    */   }
/*    */   
/*    */   public static ObfuscationType create(ObfuscationTypeDescriptor paramObfuscationTypeDescriptor, IMixinAnnotationProcessor paramIMixinAnnotationProcessor) {
/*    */     String str = paramObfuscationTypeDescriptor.getKey();
/*    */     try {
/*    */       if (types.containsKey(str))
/*    */         throw new IllegalArgumentException("Obfuscation type with key " + str + " was already registered"); 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     ObfuscationType obfuscationType = new ObfuscationType(paramObfuscationTypeDescriptor, paramIMixinAnnotationProcessor);
/*    */     types.put(str, obfuscationType);
/*    */     return obfuscationType;
/*    */   }
/*    */   
/*    */   private ObfuscationType(ObfuscationTypeDescriptor paramObfuscationTypeDescriptor, IMixinAnnotationProcessor paramIMixinAnnotationProcessor) {
/*    */     this.key = paramObfuscationTypeDescriptor.getKey();
/*    */     this.descriptor = paramObfuscationTypeDescriptor;
/*    */     this.ap = paramIMixinAnnotationProcessor;
/*    */     this.options = (IOptionProvider)paramIMixinAnnotationProcessor;
/*    */   }
/*    */   
/*    */   public List<String> getInputFileNames() {
/*    */     ImmutableList.Builder builder = ImmutableList.builder();
/*    */     String str1 = this.options.getOption(this.descriptor.getInputFileOption());
/*    */     try {
/*    */       if (str1 != null)
/*    */         builder.add(str1); 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     String str2 = this.options.getOption(this.descriptor.getExtraInputFilesOption());
/*    */     if (str2 != null) {
/*    */       String[] arrayOfString;
/*    */       int i;
/*    */       byte b;
/*    */       for (arrayOfString = str2.split(";"), i = arrayOfString.length, b = 0; b < i; ) {
/*    */         String str = arrayOfString[b];
/*    */         builder.add(str.trim());
/*    */         b++;
/*    */       } 
/*    */     } 
/*    */     return (List<String>)builder.build();
/*    */   }
/*    */   
/*    */   public boolean isDefault() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield options : Lorg/spongepowered/tools/obfuscation/interfaces/IOptionProvider;
/*    */     //   4: ldc 'defaultObfuscationEnv'
/*    */     //   6: invokeinterface getOption : (Ljava/lang/String;)Ljava/lang/String;
/*    */     //   11: astore_1
/*    */     //   12: aload_1
/*    */     //   13: ifnonnull -> 35
/*    */     //   16: aload_0
/*    */     //   17: getfield key : Ljava/lang/String;
/*    */     //   20: ldc 'searge'
/*    */     //   22: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   25: ifne -> 67
/*    */     //   28: goto -> 35
/*    */     //   31: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   34: athrow
/*    */     //   35: aload_1
/*    */     //   36: ifnull -> 75
/*    */     //   39: goto -> 46
/*    */     //   42: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   45: athrow
/*    */     //   46: aload_0
/*    */     //   47: getfield key : Ljava/lang/String;
/*    */     //   50: aload_1
/*    */     //   51: invokevirtual toLowerCase : ()Ljava/lang/String;
/*    */     //   54: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   57: ifeq -> 75
/*    */     //   60: goto -> 67
/*    */     //   63: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   66: athrow
/*    */     //   67: iconst_1
/*    */     //   68: goto -> 76
/*    */     //   71: invokestatic b : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   74: athrow
/*    */     //   75: iconst_0
/*    */     //   76: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #43	-> 0
/*    */     //   #35	-> 12
/*    */     //   #44	-> 51
/*    */     //   #3	-> 76
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   12	28	31	java/lang/RuntimeException
/*    */     //   16	39	42	java/lang/RuntimeException
/*    */     //   35	60	63	java/lang/RuntimeException
/*    */     //   46	71	71	java/lang/RuntimeException
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\ObfuscationType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */