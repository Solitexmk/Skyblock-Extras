/* 1 */ package org.spongepowered.asm.util;class ClassSignature$SignatureParser$BoundElement extends ClassSignature$SignatureParser$TokenElement { private final ClassSignature$SignatureParser$TokenElement type; public void visitClassType(String paramString) { this.token = this.type.token.addBound(paramString, this.classBound); } private final boolean classBound; final ClassSignature$SignatureParser this$1; public SignatureVisitor visitTypeArgument(char paramChar) {
/* 2 */     return new ClassSignature$SignatureParser$TypeArgElement(ClassSignature$SignatureParser.this, this, paramChar);
/*   */   }
/*   */ 
/*   */   
/*   */   public void visitTypeArgument()
/*   */   {
/* 8 */     this.token.addTypeArgument('*'); } ClassSignature$SignatureParser$BoundElement(ClassSignature$SignatureParser$TokenElement paramClassSignature$SignatureParser$TokenElement, boolean paramBoolean) {
/* 9 */     super(paramClassSignature$SignatureParser);
/*   */     this.type = paramClassSignature$SignatureParser$TokenElement;
/*   */     this.classBound = paramBoolean;
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\ClassSignature$SignatureParser$BoundElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */