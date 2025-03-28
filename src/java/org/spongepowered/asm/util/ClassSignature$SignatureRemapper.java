/*    */ package org.spongepowered.asm.util;
/*    */ class ClassSignature$SignatureRemapper extends SignatureWriter {
/*    */   private static RuntimeException c(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   }
/*    */   
/*  7 */   private final Set<String> localTypeVars = new HashSet<String>();
/*    */   public void visitTypeVariable(String paramString) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield localTypeVars : Ljava/util/Set;
/*    */     //   4: aload_1
/*    */     //   5: invokeinterface contains : (Ljava/lang/Object;)Z
/*    */     //   10: ifne -> 39
/*    */     //   13: aload_0
/*    */     //   14: getfield this$0 : Lorg/spongepowered/asm/util/ClassSignature;
/*    */     //   17: aload_1
/*    */     //   18: invokevirtual getTypeVar : (Ljava/lang/String;)Lorg/spongepowered/asm/util/ClassSignature$TypeVar;
/*    */     //   21: astore_2
/*    */     //   22: aload_2
/*    */     //   23: ifnull -> 39
/*    */     //   26: aload_0
/*    */     //   27: aload_2
/*    */     //   28: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   31: invokespecial visitTypeVariable : (Ljava/lang/String;)V
/*    */     //   34: return
/*    */     //   35: invokestatic c : (Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
/*    */     //   38: athrow
/*    */     //   39: aload_0
/*    */     //   40: aload_1
/*    */     //   41: invokespecial visitTypeVariable : (Ljava/lang/String;)V
/*    */     //   44: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #4	-> 0
/*    */     //   #12	-> 13
/*    */     //   #3	-> 22
/*    */     //   #2	-> 26
/*    */     //   #10	-> 34
/*    */     //   #1	-> 39
/*    */     //   #6	-> 44
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*  8 */     //   22	35	35	java/lang/RuntimeException } final ClassSignature this$0; public void visitFormalTypeParameter(String paramString) { this.localTypeVars.add(paramString);
/*    */ 
/*    */     
/* 11 */     super.visitFormalTypeParameter(paramString); }
/*    */ 
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\ClassSignature$SignatureRemapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */