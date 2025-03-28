/*  1 */ package org.spongepowered.asm.util;class ClassSignature$TokenHandle implements ClassSignature$IToken { public ClassSignature$IToken setWildcard(char paramChar) { try { if ("+-".indexOf(paramChar) > -1)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/*  9 */         this.wildcard = paramChar; }  } catch (RuntimeException runtimeException) { throw b(null); }
/*    */     
/*    */     return this; }
/*    */   
/*    */   final ClassSignature$Token token;
/*    */   boolean array;
/*    */   char wildcard;
/*    */   final ClassSignature this$0;
/*    */   
/*    */   public String asType() {
/*    */     StringBuilder stringBuilder = new StringBuilder();
/*    */     try {
/* 21 */       if (this.wildcard > '\000')
/*    */         stringBuilder.append(this.wildcard); 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     try {
/*    */       if (this.array)
/*    */         stringBuilder.append('['); 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return stringBuilder.append(ClassSignature.this.getTypeVar(this)).toString();
/*    */   }
/*    */   
/*    */   public ClassSignature$IToken setArray(boolean paramBoolean) {
/*    */     this.array |= paramBoolean;
/*    */     return this;
/*    */   }
/*    */   
/*    */   ClassSignature$TokenHandle(ClassSignature$Token paramClassSignature$Token) {
/*    */     this.token = paramClassSignature$Token;
/*    */   }
/*    */   
/*    */   public ClassSignature$Token asToken() {
/*    */     return this.token;
/*    */   }
/*    */   
/*    */   public String asBound() {
/*    */     return this.token.asBound();
/*    */   }
/*    */   
/*    */   ClassSignature$TokenHandle(ClassSignature paramClassSignature) {
/*    */     this(new ClassSignature$Token());
/*    */   }
/*    */   
/*    */   public String toString() {
/*    */     return this.token.toString();
/*    */   }
/*    */   
/*    */   public ClassSignature$TokenHandle clone() {
/*    */     return new ClassSignature$TokenHandle(this.token);
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\ClassSignature$TokenHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */