/*  1 */ package org.spongepowered.tools.obfuscation;class AnnotatedMixinElementHandler$AliasedElementName { protected final String originalName; public boolean isCaseSensitive() { return this.caseSensitive; }
/*    */    private final List<String> aliases; private boolean caseSensitive;
/*    */   public boolean hasPrefix() {
/*  4 */     return false; } public AnnotatedMixinElementHandler$AliasedElementName(Element paramElement, AnnotationHandle paramAnnotationHandle) { this.originalName = paramElement.getSimpleName().toString(); this.aliases = paramAnnotationHandle.getList("aliases"); }
/*    */   public boolean hasAliases() { try {  }
/*  6 */     catch (RuntimeException runtimeException) { throw b(null); }  return (this.aliases.size() > 0); }
/*  7 */   public AnnotatedMixinElementHandler$AliasedElementName setCaseSensitive(boolean paramBoolean) { this.caseSensitive = paramBoolean;
/*    */ 
/*    */     
/* 10 */     return this; } public String baseName() { return this.originalName; } public List<String> getAliases() { return this.aliases; }
/* 11 */   public String elementName() { return this.originalName; }
/*    */ 
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\AnnotatedMixinElementHandler$AliasedElementName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */