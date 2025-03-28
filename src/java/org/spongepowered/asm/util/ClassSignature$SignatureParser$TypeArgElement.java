/*    */ package org.spongepowered.asm.util;class ClassSignature$SignatureParser$TypeArgElement extends ClassSignature$SignatureParser$TokenElement {
/*    */   public SignatureVisitor visitArrayType() {
/*  3 */     this.type.setArray();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 17 */     return this;
/*    */   }
/*    */   
/*    */   private final ClassSignature$SignatureParser$TokenElement type;
/*    */   private final char wildcard;
/*    */   final ClassSignature$SignatureParser this$1;
/*    */   
/*    */   public void visitEnd() {}
/*    */   
/*    */   public void visitBaseType(char paramChar) {
/*    */     this.token = this.type.addTypeArgument(paramChar).asToken();
/*    */   }
/*    */   
/*    */   public void visitClassType(String paramString) {
/*    */     this.token = this.type.addTypeArgument(paramString).setWildcard(this.wildcard).asToken();
/*    */   }
/*    */   
/*    */   public void visitTypeArgument() {
/*    */     this.token.addTypeArgument('*');
/*    */   }
/*    */   
/*    */   public SignatureVisitor visitTypeArgument(char paramChar) {
/*    */     return new ClassSignature$SignatureParser$TypeArgElement(this, paramChar);
/*    */   }
/*    */   
/*    */   ClassSignature$SignatureParser$TypeArgElement(ClassSignature$SignatureParser$TokenElement paramClassSignature$SignatureParser$TokenElement, char paramChar) {
/*    */     super(paramClassSignature$SignatureParser);
/*    */     this.type = paramClassSignature$SignatureParser$TokenElement;
/*    */     this.wildcard = paramChar;
/*    */   }
/*    */   
/*    */   public void visitTypeVariable(String paramString) {
/*    */     ClassSignature$TokenHandle classSignature$TokenHandle = this.this$1.this$0.getType(paramString);
/*    */     this.token = this.type.addTypeArgument(classSignature$TokenHandle).setWildcard(this.wildcard).asToken();
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\ClassSignature$SignatureParser$TypeArgElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */