/*    */ package org.spongepowered.tools.obfuscation;class AnnotatedMixinElementHandler$ShadowElementName extends AnnotatedMixinElementHandler$AliasedElementName { private final boolean hasPrefix; private final String prefix; private final String baseName; private String obfuscated;
/*  2 */   AnnotatedMixinElementHandler$ShadowElementName(Element paramElement, AnnotationHandle paramAnnotationHandle) { super(paramElement, paramAnnotationHandle);
/*    */ 
/*    */ 
/*    */     
/*  6 */     this.prefix = (String)paramAnnotationHandle.getValue("prefix", "shadow$");
/*    */     
/*    */     boolean bool = false;
/*  9 */     String str = this.originalName;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 17 */     if (str.startsWith(this.prefix)) { bool = true; str = str.substring(this.prefix.length()); }  this.hasPrefix = bool; this.obfuscated = this.baseName = str; }
/* 18 */   public String name() { return prefix(this.baseName); } public AnnotatedMixinElementHandler$ShadowElementName setObfuscatedName(IMapping<?> paramIMapping) { this.obfuscated = paramIMapping.getName(); return this; } public String baseName() { return this.baseName; } public String toString() { return this.baseName; }
/* 19 */   public AnnotatedMixinElementHandler$ShadowElementName setObfuscatedName(String paramString) { this.obfuscated = paramString; return this; } public boolean hasPrefix() { return this.hasPrefix; } public String obfuscated() { return prefix(this.obfuscated); } public String prefix() { try {  } catch (RuntimeException runtimeException) { throw c(null); }  return this.hasPrefix ? this.prefix : ""; } public String prefix(String paramString) { try {  }
/* 20 */     catch (RuntimeException runtimeException) { throw c(null); }  return this.hasPrefix ? (this.prefix + paramString) : paramString; }
/*    */ 
/*    */   
/*    */   private static RuntimeException c(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\AnnotatedMixinElementHandler$ShadowElementName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */