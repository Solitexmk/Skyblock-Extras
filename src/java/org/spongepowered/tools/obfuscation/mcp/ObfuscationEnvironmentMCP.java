/* 1 */ package org.spongepowered.tools.obfuscation.mcp;public class ObfuscationEnvironmentMCP extends ObfuscationEnvironment { protected IMappingProvider getMappingProvider(Messager paramMessager, Filer paramFiler) { return (IMappingProvider)new MappingProviderSrg(paramMessager, paramFiler); }
/* 2 */   protected IMappingWriter getMappingWriter(Messager paramMessager, Filer paramFiler) { return (IMappingWriter)new MappingWriterSrg(paramMessager, paramFiler); } protected ObfuscationEnvironmentMCP(ObfuscationType paramObfuscationType) {
/* 3 */     super(paramObfuscationType);
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\mcp\ObfuscationEnvironmentMCP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */