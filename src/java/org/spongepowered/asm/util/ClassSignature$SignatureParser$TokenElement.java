/*    */ package org.spongepowered.asm.util;
/*  2 */ abstract class ClassSignature$SignatureParser$TokenElement extends ClassSignature$SignatureParser$SignatureElement { protected ClassSignature$Token token; public void visitClassType(String paramString) { getToken().setType(paramString); } private boolean array; final ClassSignature$SignatureParser this$1; ClassSignature$Token addTypeArgument() {
/*  3 */     return this.token.addTypeArgument('*').asToken();
/*    */   }
/*    */   
/*    */   ClassSignature$SignatureParser$TokenElement()
/*    */   {
/*  8 */     super(paramClassSignature$SignatureParser);
/*  9 */   } protected void setArray() { this.array = true; }
/* 10 */   ClassSignature$IToken addTypeArgument(ClassSignature$TokenHandle paramClassSignature$TokenHandle) { return this.token.addTypeArgument(paramClassSignature$TokenHandle).setArray(getArray()); } public SignatureVisitor visitTypeArgument(char paramChar) {
/* 11 */     return new ClassSignature$SignatureParser$TypeArgElement(ClassSignature$SignatureParser.this, this, paramChar);
/*    */   }
/*    */   
/*    */   ClassSignature$IToken addTypeArgument(char paramChar) {
/* 15 */     return this.token.addTypeArgument(paramChar).setArray(getArray()); } public void visitInnerClassType(String paramString) {
/* 16 */     this.token.addInnerClass(paramString);
/*    */   }
/* 18 */   ClassSignature$IToken addTypeArgument(String paramString) { return this.token.addTypeArgument(paramString).setArray(getArray()); }
/* 19 */   public SignatureVisitor visitClassBound() { getToken(); return new ClassSignature$SignatureParser$BoundElement(ClassSignature$SignatureParser.this, this, true); } public ClassSignature$Token getToken() { try {
/* 20 */       if (this.token == null)
/*    */         this.token = new ClassSignature$Token(); 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/* 24 */     }  return this.token; } public SignatureVisitor visitInterfaceBound() { getToken(); return new ClassSignature$SignatureParser$BoundElement(ClassSignature$SignatureParser.this, this, false); }
/* 25 */   public SignatureVisitor visitArrayType() { setArray();
/*    */     return this; }
/*    */ 
/*    */   
/*    */   ClassSignature$IToken addTypeArgument(ClassSignature$Token paramClassSignature$Token) {
/*    */     return this.token.addTypeArgument(paramClassSignature$Token).setArray(getArray());
/*    */   }
/*    */   
/*    */   private boolean getArray() {
/*    */     boolean bool = this.array;
/*    */     this.array = false;
/*    */     return bool;
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\ClassSignature$SignatureParser$TokenElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */