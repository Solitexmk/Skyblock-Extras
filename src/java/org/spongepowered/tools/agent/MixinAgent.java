/*    */ package org.spongepowered.tools.agent;
/*    */ public class MixinAgent implements IHotSwap {
/*    */   public void registerMixinClass(String paramString) {
/*  4 */     classLoader.addMixinClass(paramString);
/*    */   }
/*  6 */   static Instrumentation instrumentation = null;
/*    */   public static void premain(String paramString, Instrumentation paramInstrumentation) {
/*  8 */     System.setProperty("mixin.hotSwap", "true");
/*    */     init(paramInstrumentation);
/*    */   }
/* 11 */   static final Logger logger = LogManager.getLogger("mixin.agent");
/*    */   public static void agentmain(String paramString, Instrumentation paramInstrumentation) {
/* 13 */     init(paramInstrumentation);
/*    */   }
/*    */ 
/*    */   
/*    */   public void registerTargetClass(String paramString, byte[] paramArrayOfbyte) {
/* 18 */     classLoader.addTargetClass(paramString, paramArrayOfbyte); } public static void init(Instrumentation paramInstrumentation) { 
/* 19 */     try { instrumentation = paramInstrumentation;
/*    */ 
/*    */ 
/*    */       
/* 23 */       if (!instrumentation.isRedefineClassesSupported()) logger.error("The instrumentation doesn't support re-definition of classes");  } catch (RuntimeException runtimeException) { throw b(null); }  for (MixinAgent mixinAgent : agents)
/* 24 */       mixinAgent.initTransformer();  } static final MixinAgentClassLoader classLoader = new MixinAgentClassLoader(); public static final byte[] ERROR_BYTECODE = new byte[] { 1 };
/*    */   
/*    */   private void initTransformer() {
/* 27 */     instrumentation.addTransformer(new MixinAgent$Transformer(this), true);
/*    */   } public MixinAgent(MixinTransformer paramMixinTransformer) { this.classTransformer = paramMixinTransformer; agents.add(this); if (instrumentation != null)
/* 29 */       initTransformer();  } private static List<MixinAgent> agents = new ArrayList<MixinAgent>();
/*    */   final MixinTransformer classTransformer;
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\agent\MixinAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */