/*    */ package org.spongepowered.asm.mixin.transformer;final class InnerClassGenerator implements IClassGenerator { private static String getUniqueReference(String paramString, MixinTargetContext paramMixinTargetContext) {
/*  2 */     String str = paramString.substring(paramString.lastIndexOf('$') + 1);
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
/* 19 */     if (str.matches("^[0-9]+$"))
/*    */       str = "Anonymous"; 
/*    */     return String.format("%s$%s$%s", new Object[] { paramMixinTargetContext.getTargetClassRef(), str, UUID.randomUUID().toString().replace("-", "") });
/*    */   }
/*    */   private static InvalidMixinException b(InvalidMixinException paramInvalidMixinException) {
/*    */     return paramInvalidMixinException;
/*    */   }
/*    */   private final Map<String, InnerClassGenerator$InnerClassInfo> innerClasses = new HashMap<String, InnerClassGenerator$InnerClassInfo>();
/*    */   private final Map<String, String> innerClassNames = new HashMap<String, String>();
/*    */   
/*    */   private byte[] generate(InnerClassGenerator$InnerClassInfo paramInnerClassGenerator$InnerClassInfo) {
/*    */     try {
/*    */       logger.debug("Generating mapped inner class {} (originally {})", new Object[] { paramInnerClassGenerator$InnerClassInfo.getName(), paramInnerClassGenerator$InnerClassInfo.getOriginalName() });
/* 32 */       ClassReader classReader = new ClassReader(paramInnerClassGenerator$InnerClassInfo.getClassBytes()); MixinClassWriter mixinClassWriter = new MixinClassWriter(classReader, 0); classReader.accept((ClassVisitor)new InnerClassGenerator$InnerClassAdapter((ClassVisitor)mixinClassWriter, paramInnerClassGenerator$InnerClassInfo), 8);
/* 33 */       return mixinClassWriter.toByteArray();
/*    */     } catch (InvalidMixinException invalidMixinException) {
/*    */       throw invalidMixinException;
/*    */     } catch (Exception exception) {
/*    */       logger.catching(exception);
/*    */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   private static final Logger logger = LogManager.getLogger("mixin");
/*    */   
/*    */   public byte[] generate(String paramString) {
/*    */     String str = paramString.replace('.', '/');
/*    */     InnerClassGenerator$InnerClassInfo innerClassGenerator$InnerClassInfo = this.innerClasses.get(str);
/*    */     try {
/*    */       if (innerClassGenerator$InnerClassInfo != null)
/*    */         return generate(innerClassGenerator$InnerClassInfo); 
/*    */     } catch (InvalidMixinException invalidMixinException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return null;
/*    */   }
/*    */   
/*    */   public String registerInnerClass(MixinInfo paramMixinInfo, String paramString, MixinTargetContext paramMixinTargetContext) {
/*    */     String str1 = String.format("%s%s", new Object[] { paramString, paramMixinTargetContext });
/*    */     String str2 = this.innerClassNames.get(str1);
/*    */     if (str2 == null) {
/*    */       str2 = getUniqueReference(paramString, paramMixinTargetContext);
/*    */       this.innerClassNames.put(str1, str2);
/*    */       this.innerClasses.put(str2, new InnerClassGenerator$InnerClassInfo(str2, paramString, paramMixinInfo, paramMixinTargetContext));
/*    */       (new Object[4])[0] = paramString;
/*    */       (new Object[4])[1] = paramMixinInfo.getClassRef();
/*    */       (new Object[4])[2] = paramMixinTargetContext.getTargetClassRef();
/*    */       (new Object[4])[3] = str2;
/*    */     } 
/*    */     return str2;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\InnerClassGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */