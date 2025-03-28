/*   */ package org.spongepowered.tools.obfuscation;public final class SupportedOptions { public static Set<String> getAllOptions() {
/* 2 */     ImmutableSet.Builder builder = ImmutableSet.builder();
/* 3 */     builder.add((Object[])new String[] { "tokens", "outRefMapFile", "disableTargetValidator", "disableTargetExport", "disableOverwriteChecker", "overwriteErrorLevel", "defaultObfuscationEnv", "dependencyTargetsFile" });
/*   */ 
/*   */ 
/*   */     
/* 7 */     builder.addAll(ObfuscationServices.getInstance().getSupportedOptions());
/*   */     return (Set<String>)builder.build();
/*   */   }
/*   */   
/*   */   public static final String TOKENS = "tokens";
/*   */   public static final String OUT_REFMAP_FILE = "outRefMapFile";
/*   */   public static final String DISABLE_TARGET_VALIDATOR = "disableTargetValidator";
/*   */   public static final String DISABLE_TARGET_EXPORT = "disableTargetExport";
/*   */   public static final String DISABLE_OVERWRITE_CHECKER = "disableOverwriteChecker";
/*   */   public static final String OVERWRITE_ERROR_LEVEL = "overwriteErrorLevel";
/*   */   public static final String DEFAULT_OBFUSCATION_ENV = "defaultObfuscationEnv";
/*   */   public static final String DEPENDENCY_TARGETS_FILE = "dependencyTargetsFile"; }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\SupportedOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */