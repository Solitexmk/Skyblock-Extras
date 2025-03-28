/*    */ package org.spongepowered.tools.agent;
/*    */ 
/*    */ class MixinAgentClassLoader extends ClassLoader {
/*  4 */   private Map<Class<?>, byte[]> mixins = (Map)new HashMap<Class<?>, byte>();
/*    */   
/*  6 */   private Map<String, byte[]> targets = (Map)new HashMap<String, byte>();
/*    */ 
/*    */ 
/*    */   
/*    */   byte[] getFakeMixinBytecode(Class<?> paramClass) {
/* 11 */     return this.mixins.get(paramClass);
/*    */   }
/*    */   byte[] getOriginalTargetBytecode(String paramString) {
/*    */     return this.targets.get(paramString);
/*    */   }
/* 16 */   void addMixinClass(String paramString) { logger.debug("Mixin class {} added to class loader", new Object[] { paramString });
/*    */     
/*    */     try { byte[] arrayOfByte = materialise(paramString);
/* 19 */       Class<?> clazz = defineClass(paramString, arrayOfByte, 0, arrayOfByte.length);
/* 20 */       clazz.newInstance(); this.mixins.put(clazz, arrayOfByte); }
/*    */     catch (Throwable throwable) { logger.catching(throwable); }
/* 22 */      } void addTargetClass(String paramString, byte[] paramArrayOfbyte) { this.targets.put(paramString, paramArrayOfbyte); } private byte[] materialise(String paramString) {
/* 23 */     ClassWriter classWriter = new ClassWriter(3);
/*    */ 
/*    */     
/* 26 */     classWriter.visit(MixinEnvironment.getCompatibilityLevel().classVersion(), 1, paramString.replace('.', '/'), null, Type.getInternalName(Object.class), null); MethodVisitor methodVisitor = classWriter.visitMethod(1, "<init>", "()V", null, null); methodVisitor.visitCode(); methodVisitor.visitVarInsn(25, 0); methodVisitor.visitMethodInsn(183, Type.getInternalName(Object.class), "<init>", "()V", false); methodVisitor.visitInsn(177); methodVisitor.visitMaxs(1, 1); methodVisitor.visitEnd();
/*    */     classWriter.visitEnd();
/* 28 */     return classWriter.toByteArray();
/*    */   }
/* 30 */   private static final Logger logger = LogManager.getLogger("mixin.agent");
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\agent\MixinAgentClassLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */