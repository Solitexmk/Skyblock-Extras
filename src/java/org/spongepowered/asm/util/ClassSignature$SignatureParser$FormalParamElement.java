/*   */ package org.spongepowered.asm.util;
/*   */ class ClassSignature$SignatureParser$FormalParamElement extends ClassSignature$SignatureParser$TokenElement {
/*   */   ClassSignature$SignatureParser$FormalParamElement(String paramString) {
/* 4 */     super(paramClassSignature$SignatureParser);
/*   */     this.handle = paramClassSignature$SignatureParser.this$0.getType(paramString);
/*   */     this.token = this.handle.asToken();
/*   */   }
/*   */   
/*   */   private final ClassSignature$TokenHandle handle;
/*   */   final ClassSignature$SignatureParser this$1;
/*   */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\ClassSignature$SignatureParser$FormalParamElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */