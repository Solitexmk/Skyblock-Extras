/*    */ package org.spongepowered.tools.obfuscation;abstract class AnnotatedMixinElementHandler$AnnotatedElement<E extends Element> { protected final E element; public E getElement() {
/*  2 */     return this.element;
/*    */   } protected final AnnotationHandle annotation; private final String desc; public String getSimpleName() {
/*  4 */     return getElement().getSimpleName().toString(); } public AnnotationHandle getAnnotation() {
/*  5 */     return this.annotation;
/*    */   }
/*    */   
/*    */   public AnnotatedMixinElementHandler$AnnotatedElement(E paramE, AnnotationHandle paramAnnotationHandle) {
/*  9 */     this.element = paramE;
/*    */     this.annotation = paramAnnotationHandle;
/* 11 */     this.desc = TypeUtils.getDescriptor((Element)paramE);
/*    */   }
/*    */   
/*    */   public final void printMessage(Messager paramMessager, Diagnostic.Kind paramKind, CharSequence paramCharSequence) {
/*    */     paramMessager.printMessage(paramKind, paramCharSequence, (Element)this.element, this.annotation.asMirror());
/*    */   }
/*    */   
/*    */   public String getDesc() {
/*    */     return this.desc;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\AnnotatedMixinElementHandler$AnnotatedElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */