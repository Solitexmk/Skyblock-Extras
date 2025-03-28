/*   */ package org.spongepowered.asm.util;
/* 2 */ class ClassSignature$SignatureParser extends SignatureVisitor { private ClassSignature$SignatureParser$FormalParamElement param; public SignatureVisitor visitInterfaceBound() { return this.param.visitInterfaceBound(); } final ClassSignature this$0; public SignatureVisitor visitSuperclass() {
/* 3 */     return new ClassSignature$SignatureParser$SuperClassElement(this); }
/* 4 */   public SignatureVisitor visitClassBound() { return this.param.visitClassBound(); } ClassSignature$SignatureParser() {
/*   */     super(327680);
/*   */   }
/* 7 */   public SignatureVisitor visitInterface() { return new ClassSignature$SignatureParser$InterfaceElement(this); } public void visitFormalTypeParameter(String paramString) {
/* 8 */     this.param = new ClassSignature$SignatureParser$FormalParamElement(this, paramString);
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\ClassSignature$SignatureParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */