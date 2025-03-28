/*    */ package org.spongepowered.asm.mixin.transformer;public class Config { private final String name; private final MixinConfig config;
/*  2 */   public String toString() { return this.config.toString(); }
/*  3 */   public String getName() { return this.name; } @Deprecated
/*  4 */   public static Config create(String paramString, MixinEnvironment paramMixinEnvironment) { return MixinConfig.create(paramString, paramMixinEnvironment); }
/*    */   public boolean isVisited() { return this.config.isVisited(); }
/*    */   public MixinEnvironment getEnvironment() { return this.config.getEnvironment(); }
/*    */   MixinConfig get() { return this.config; }
/*  8 */   public Config(MixinConfig paramMixinConfig) { this.name = paramMixinConfig.getName();
/*    */ 
/*    */ 
/*    */     
/* 12 */     this.config = paramMixinConfig; }
/* 13 */   public int hashCode() { return this.name.hashCode(); } public IMixinConfig getConfig() { return this.config; } public static Config create(String paramString) { return MixinConfig.create(paramString, MixinEnvironment.getDefaultEnvironment()); } public boolean equals(Object paramObject) { 
/* 14 */     try { if (paramObject instanceof Config) try { if (this.name.equals(((Config)paramObject).name)); } catch (RuntimeException runtimeException) { throw b(null); }   } catch (RuntimeException runtimeException) { throw b(null); }  return false; }
/*    */ 
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\Config.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */