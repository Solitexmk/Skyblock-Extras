/*  1 */ package org.spongepowered.asm.mixin.transformer;public class MethodMapper { private static final Logger logger = LogManager.getLogger("mixin");
/*    */   
/*  3 */   public String getHandlerName(MixinInfo$MixinMethodNode paramMixinInfo$MixinMethodNode) { String str1 = InjectionInfo.getInjectorPrefix(paramMixinInfo$MixinMethodNode.getInjectorAnnotation());
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
/* 21 */     String str2 = getClassUID(paramMixinInfo$MixinMethodNode.getOwner().getClassRef());
/*    */ 
/*    */ 
/*    */     
/*    */     try {  }
/*    */     catch (RuntimeException runtimeException)
/* 27 */     { throw b(null); }  String str3 = getMethodUID(paramMixinInfo$MixinMethodNode.name, paramMixinInfo$MixinMethodNode.desc, !paramMixinInfo$MixinMethodNode.isSurrogate());
/*    */     return String.format("%s$%s$%s%s", new Object[] { str1, paramMixinInfo$MixinMethodNode.name, str2, str3 }); } private static String finagle(int paramInt) { String str = Integer.toHexString(paramInt);
/* 29 */     StringBuilder stringBuilder = new StringBuilder();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     for (byte b = 0; b < str.length(); )
/* 37 */     { char c = str.charAt(b); try {  }
/*    */       catch (RuntimeException runtimeException)
/*    */       { throw b(null); }
/* 40 */        stringBuilder.append(c = (char)(c + ((c < ':') ? 49 : 10))); b++; }  return Strings.padStart(stringBuilder.toString(), 3, 'z'); } private static final List<String> classes = new ArrayList<String>(); private static String getClassUID(String paramString) { int i = classes.indexOf(paramString); if (i < 0) { i = classes.size(); classes.add(paramString); }
/* 41 */      return finagle(i); }
/*    */ 
/*    */   
/*    */   public MethodMapper(MixinEnvironment paramMixinEnvironment, ClassInfo paramClassInfo) {
/*    */     this.info = paramClassInfo;
/*    */   }
/*    */   
/*    */   private static final Map<String, Counter> methods = new HashMap<String, Counter>();
/*    */   private final ClassInfo info;
/*    */   
/*    */   public void remapHandlerMethod(MixinInfo paramMixinInfo, MethodNode paramMethodNode, ClassInfo$Method paramClassInfo$Method) {
/*    */     try {
/*    */       if (paramMethodNode instanceof MixinInfo$MixinMethodNode)
/*    */         try {
/*    */           if (((MixinInfo$MixinMethodNode)paramMethodNode).isInjector()) {
/*    */             try {
/*    */               if (paramClassInfo$Method.isUnique())
/*    */                 logger.warn("Redundant @Unique on injector method {} in {}. Injectors are implicitly unique", new Object[] { paramClassInfo$Method, paramMixinInfo }); 
/*    */             } catch (RuntimeException runtimeException) {
/*    */               throw b(null);
/*    */             } 
/*    */             try {
/*    */               if (paramClassInfo$Method.isRenamed()) {
/*    */                 paramMethodNode.name = paramClassInfo$Method.getName();
/*    */                 return;
/*    */               } 
/*    */             } catch (RuntimeException runtimeException) {
/*    */               throw b(null);
/*    */             } 
/*    */             String str = getHandlerName((MixinInfo$MixinMethodNode)paramMethodNode);
/*    */             paramMethodNode.name = paramClassInfo$Method.renameTo(str);
/*    */             return;
/*    */           } 
/*    */           return;
/*    */         } catch (RuntimeException runtimeException) {
/*    */           throw b(null);
/*    */         }  
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */   }
/*    */   
/*    */   public ClassInfo getClassInfo() {
/*    */     return this.info;
/*    */   }
/*    */   
/*    */   private static String getMethodUID(String paramString1, String paramString2, boolean paramBoolean) {
/*    */     String str = String.format("%s%s", new Object[] { paramString1, paramString2 });
/*    */     Counter counter = methods.get(str);
/*    */     if (counter == null) {
/*    */       counter = new Counter();
/*    */       methods.put(str, counter);
/*    */     } 
/*    */     try {
/*    */       if (paramBoolean)
/*    */         counter.value++; 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return String.format("%03x", new Object[] { Integer.valueOf(counter.value) });
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MethodMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */