/*  1 */ package org.spongepowered.tools.obfuscation;abstract class AnnotatedMixinElementHandlerShadow$AnnotatedElementShadow<E extends Element, M extends IMapping<M>> extends AnnotatedMixinElementHandler$AnnotatedElement<E> { private final boolean shouldRemap; public IMapping.Type getElementType() { return this.type; } private final AnnotatedMixinElementHandler$ShadowElementName name; private final IMapping.Type type; public AnnotatedMixinElementHandler$ShadowElementName getName() {
/*  2 */     return this.name;
/*    */   } protected AnnotatedMixinElementHandlerShadow$AnnotatedElementShadow(E paramE, AnnotationHandle paramAnnotationHandle, boolean paramBoolean, IMapping.Type paramType) {
/*  4 */     super(paramE, paramAnnotationHandle);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 11 */     this.shouldRemap = paramBoolean;
/*    */     this.name = new AnnotatedMixinElementHandler$ShadowElementName((Element)paramE, paramAnnotationHandle);
/*    */     this.type = paramType;
/*    */   }
/*    */   
/*    */   public boolean shouldRemap() {
/*    */     return this.shouldRemap;
/*    */   }
/*    */   
/*    */   public AnnotatedMixinElementHandler$ShadowElementName setObfuscatedName(IMapping<?> paramIMapping) {
/*    */     return setObfuscatedName(paramIMapping.getSimpleName());
/*    */   }
/*    */   
/*    */   public ObfuscationData<M> getObfuscationData(IObfuscationDataProvider paramIObfuscationDataProvider, TypeHandle paramTypeHandle) {
/*    */     return paramIObfuscationDataProvider.getObfEntry((IMapping)getMapping(paramTypeHandle, getName().toString(), getDesc()));
/*    */   }
/*    */   
/*    */   public String toString() {
/*    */     return getElementType().name().toLowerCase();
/*    */   }
/*    */   
/*    */   public AnnotatedMixinElementHandler$ShadowElementName setObfuscatedName(String paramString) {
/*    */     return getName().setObfuscatedName(paramString);
/*    */   }
/*    */   
/*    */   public abstract M getMapping(TypeHandle paramTypeHandle, String paramString1, String paramString2);
/*    */   
/*    */   public abstract void addMapping(ObfuscationType paramObfuscationType, IMapping<?> paramIMapping); }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\AnnotatedMixinElementHandlerShadow$AnnotatedElementShadow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */