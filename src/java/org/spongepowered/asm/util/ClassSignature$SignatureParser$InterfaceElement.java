/*   */ package org.spongepowered.asm.util;
/* 2 */ class ClassSignature$SignatureParser$InterfaceElement extends ClassSignature$SignatureParser$TokenElement { ClassSignature$SignatureParser$InterfaceElement() { super(paramClassSignature$SignatureParser); } final ClassSignature$SignatureParser this$1; public void visitEnd() {
/* 3 */     this.this$1.this$0.addInterface(this.token);
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\ClassSignature$SignatureParser$InterfaceElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */