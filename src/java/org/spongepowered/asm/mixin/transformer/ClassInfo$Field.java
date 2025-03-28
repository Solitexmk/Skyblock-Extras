/*    */ package org.spongepowered.asm.mixin.transformer;class ClassInfo$Field extends ClassInfo$Member { public ClassInfo$Field(FieldNode paramFieldNode) {
/*  2 */     this(paramFieldNode, false);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   final ClassInfo this$0;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ClassInfo$Field(FieldNode paramFieldNode, boolean paramBoolean) {
/* 18 */     super(ClassInfo$Member$Type.FIELD, paramFieldNode.name, paramFieldNode.desc, paramFieldNode.access, paramBoolean); try { setUnique((Annotations.getVisible(paramFieldNode, Unique.class) != null)); if (Annotations.getVisible(paramFieldNode, Shadow.class) != null) { try {  }
/*    */         catch (RuntimeException runtimeException) { throw c(null); }
/*    */          boolean bool1 = (Annotations.getVisible(paramFieldNode, Final.class) != null) ? true : false; try {  }
/*    */         catch (RuntimeException runtimeException) { throw c(null); }
/* 22 */          boolean bool2 = (Annotations.getVisible(paramFieldNode, Mutable.class) != null) ? true : false; setDecoratedFinal(bool1, bool2); }  } catch (RuntimeException runtimeException) { throw c(null); }
/*    */   
/* 24 */   } public ClassInfo getOwner() { return ClassInfo.this; } protected String getDisplayFormat() { return "%s:%s"; }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/*    */     try {
/*    */       if (!(paramObject instanceof ClassInfo$Field))
/*    */         return false; 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw c(null);
/*    */     } 
/*    */     return super.equals(paramObject);
/*    */   }
/*    */   
/*    */   public ClassInfo$Field(String paramString1, String paramString2, int paramInt, boolean paramBoolean) {
/*    */     super(ClassInfo$Member$Type.FIELD, paramString1, paramString2, paramInt, paramBoolean);
/*    */   }
/*    */   
/*    */   public ClassInfo$Field(String paramString1, String paramString2, int paramInt) {
/*    */     super(ClassInfo$Member$Type.FIELD, paramString1, paramString2, paramInt, false);
/*    */   }
/*    */   
/*    */   public ClassInfo$Field(ClassInfo$Member paramClassInfo$Member) {
/*    */     super(paramClassInfo$Member);
/*    */   }
/*    */   
/*    */   private static RuntimeException c(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\ClassInfo$Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */