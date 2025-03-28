/*    */ package org.spongepowered.asm.service.mojang;final class LaunchClassLoaderUtil { private static final String CACHED_CLASSES_FIELD = "cachedClasses"; private static final String INVALID_CLASSES_FIELD = "invalidClasses"; private static final String CLASS_LOADER_EXCEPTIONS_FIELD = "classLoaderExceptions";
/*    */   private static final String TRANSFORMER_EXCEPTIONS_FIELD = "transformerExceptions";
/*    */   
/*    */   boolean isClassLoaded(String paramString) {
/*  5 */     return this.cachedClasses.containsKey(paramString);
/*    */   }
/*    */   private final LaunchClassLoader classLoader; private final Map<String, Class<?>> cachedClasses; private final Set<String> invalidClasses;
/*    */   private final Set<String> classLoaderExceptions;
/*    */   private final Set<String> transformerExceptions;
/*    */   
/*    */   private static <T> T getField(LaunchClassLoader paramLaunchClassLoader, String paramString) {
/*    */     
/* 13 */     try { Field field = LaunchClassLoader.class.getDeclaredField(paramString);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       field.setAccessible(true);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       return (T)field.get(paramLaunchClassLoader); }
/* 34 */     catch (Exception exception) { exception.printStackTrace(); return null; }  } boolean isClassClassLoaderExcluded(String paramString1, String paramString2) { Iterator<String> iterator = getClassLoaderExceptions().iterator(); while (true) { String str; if (iterator.hasNext()) { str = iterator.next(); try { if (paramString2 != null) try { if (paramString2.startsWith(str))
/* 35 */                 return true;  try { if (paramString1.startsWith(str)) return true;  } catch (RuntimeException runtimeException) { throw b(null); }  } catch (RuntimeException runtimeException) { throw b(null); }   } catch (RuntimeException runtimeException) { throw b(null); }  } else { break; }  try { if (paramString1.startsWith(str)) return true;  } catch (RuntimeException runtimeException) { throw b(null); }
/*    */        }
/*    */     
/*    */     return false; }
/*    */ 
/*    */   
/*    */   Set<String> getClassLoaderExceptions() {
/*    */     try {
/*    */       if (this.classLoaderExceptions != null)
/*    */         return this.classLoaderExceptions; 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return Collections.emptySet();
/*    */   }
/*    */   
/*    */   LaunchClassLoader getClassLoader() {
/*    */     return this.classLoader;
/*    */   }
/*    */   
/*    */   boolean isClassTransformerExcluded(String paramString1, String paramString2) {
/*    */     for (String str : getTransformerExceptions()) {
/*    */       try {
/*    */         if (paramString2 != null)
/*    */           try {
/*    */             if (paramString2.startsWith(str))
/*    */               return true; 
/*    */             try {
/*    */               if (paramString1.startsWith(str))
/*    */                 return true; 
/*    */             } catch (RuntimeException runtimeException) {
/*    */               throw b(null);
/*    */             } 
/*    */           } catch (RuntimeException runtimeException) {
/*    */             throw b(null);
/*    */           }  
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } 
/*    */     return false;
/*    */   }
/*    */   
/*    */   void registerInvalidClass(String paramString) {
/*    */     try {
/*    */       if (this.invalidClasses != null)
/*    */         this.invalidClasses.add(paramString); 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */   }
/*    */   
/*    */   boolean isClassExcluded(String paramString1, String paramString2) {
/*    */     try {
/*    */       if (!isClassClassLoaderExcluded(paramString1, paramString2)) {
/*    */         try {
/*    */           if (isClassTransformerExcluded(paramString1, paramString2));
/*    */         } catch (RuntimeException runtimeException) {
/*    */           throw b(null);
/*    */         } 
/*    */         return false;
/*    */       } 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */   }
/*    */   
/*    */   LaunchClassLoaderUtil(LaunchClassLoader paramLaunchClassLoader) {
/*    */     this.classLoader = paramLaunchClassLoader;
/*    */     this.cachedClasses = getField(paramLaunchClassLoader, "cachedClasses");
/*    */     this.invalidClasses = getField(paramLaunchClassLoader, "invalidClasses");
/*    */     this.classLoaderExceptions = getField(paramLaunchClassLoader, "classLoaderExceptions");
/*    */     this.transformerExceptions = getField(paramLaunchClassLoader, "transformerExceptions");
/*    */   }
/*    */   
/*    */   Set<String> getTransformerExceptions() {
/*    */     try {
/*    */       if (this.transformerExceptions != null)
/*    */         return this.transformerExceptions; 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return Collections.emptySet();
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\service\mojang\LaunchClassLoaderUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */