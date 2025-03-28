/*    */ package org.spongepowered.asm.mixin.transformer;
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
/*    */ public enum ClassInfo$Traversal
/*    */ {
/* 14 */   NONE(null, false, ClassInfo$SearchType.SUPER_CLASSES_ONLY),
/*    */   ALL(null, true, ClassInfo$SearchType.ALL_CLASSES),
/*    */   IMMEDIATE(NONE, true, ClassInfo$SearchType.SUPER_CLASSES_ONLY),
/*    */   SUPER(ALL, false, ClassInfo$SearchType.SUPER_CLASSES_ONLY);
/*    */   
/*    */   ClassInfo$Traversal(ClassInfo$Traversal paramClassInfo$Traversal, boolean paramBoolean, ClassInfo$SearchType paramClassInfo$SearchType) {
/*    */     this.next = (paramClassInfo$Traversal != null) ? paramClassInfo$Traversal : this;
/*    */     this.traverse = paramBoolean;
/*    */     this.searchType = paramClassInfo$SearchType;
/*    */   }
/*    */   
/*    */   public ClassInfo$Traversal next() {
/*    */     return this.next;
/*    */   }
/*    */   
/*    */   private static final ClassInfo$Traversal[] $VALUES = new ClassInfo$Traversal[] { NONE, ALL, IMMEDIATE, SUPER };
/*    */   
/*    */   public ClassInfo$SearchType getSearchType() {
/*    */     return this.searchType;
/*    */   }
/*    */   
/*    */   public boolean canTraverse() {
/*    */     return this.traverse;
/*    */   }
/*    */   
/*    */   private final ClassInfo$Traversal next;
/*    */   private final boolean traverse;
/*    */   private final ClassInfo$SearchType searchType;
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\ClassInfo$Traversal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */