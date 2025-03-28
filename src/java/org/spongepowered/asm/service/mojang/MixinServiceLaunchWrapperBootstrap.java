/*   */ package org.spongepowered.asm.service.mojang;
/* 2 */ public class MixinServiceLaunchWrapperBootstrap implements IMixinServiceBootstrap { private static final String SERVICE_PACKAGE = "org.spongepowered.asm.service."; private static final String MIXIN_UTIL_PACKAGE = "org.spongepowered.asm.util."; public void bootstrap() { Launch.classLoader.addClassLoaderExclusion("org.spongepowered.asm.service.");
/* 3 */     Launch.classLoader.addClassLoaderExclusion("org.spongepowered.asm.lib.");
/*   */ 
/*   */ 
/*   */     
/* 7 */     Launch.classLoader.addClassLoaderExclusion("org.spongepowered.asm.mixin."); Launch.classLoader.addClassLoaderExclusion("org.spongepowered.asm.util."); }
/* 8 */   private static final String ASM_PACKAGE = "org.spongepowered.asm.lib."; private static final String MIXIN_PACKAGE = "org.spongepowered.asm.mixin."; public String getServiceClassName() { return "org.spongepowered.asm.service.mojang.MixinServiceLaunchWrapper"; } public String getName() { return "LaunchWrapper"; }
/*   */    }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\service\mojang\MixinServiceLaunchWrapperBootstrap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */