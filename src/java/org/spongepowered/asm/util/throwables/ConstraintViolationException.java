/*  1 */ package org.spongepowered.asm.util.throwables;public class ConstraintViolationException extends Exception { private static final String MISSING_VALUE = "UNRESOLVED"; private static final long serialVersionUID = 1L; public ConstraintViolationException(String paramString, Throwable paramThrowable, ConstraintParser.Constraint paramConstraint, int paramInt) { super(paramString, paramThrowable);
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 24 */     this.constraint = paramConstraint;
/*    */     
/* 26 */     this.badValue = String.valueOf(paramInt); }
/*    */    private final ConstraintParser.Constraint constraint; private final String badValue;
/*    */   public ConstraintViolationException(Throwable paramThrowable, ConstraintParser.Constraint paramConstraint) {
/*    */     super(paramThrowable);
/*    */     this.constraint = paramConstraint;
/*    */     this.badValue = "UNRESOLVED";
/*    */   }
/*    */   public ConstraintViolationException(ConstraintParser.Constraint paramConstraint, int paramInt) {
/* 34 */     this.constraint = paramConstraint;
/*    */     this.badValue = String.valueOf(paramInt);
/*    */   }
/*    */   
/*    */   public ConstraintViolationException(String paramString, ConstraintParser.Constraint paramConstraint) {
/*    */     super(paramString);
/*    */     this.constraint = paramConstraint;
/*    */     this.badValue = "UNRESOLVED";
/*    */   }
/*    */   
/*    */   public ConstraintViolationException(String paramString, Throwable paramThrowable, ConstraintParser.Constraint paramConstraint) {
/*    */     super(paramString, paramThrowable);
/*    */     this.constraint = paramConstraint;
/*    */     this.badValue = "UNRESOLVED";
/*    */   }
/*    */   
/*    */   public ConstraintParser.Constraint getConstraint() {
/*    */     return this.constraint;
/*    */   }
/*    */   
/*    */   public ConstraintViolationException(String paramString, ConstraintParser.Constraint paramConstraint, int paramInt) {
/*    */     super(paramString);
/*    */     this.constraint = paramConstraint;
/*    */     this.badValue = String.valueOf(paramInt);
/*    */   }
/*    */   
/*    */   public ConstraintViolationException(Throwable paramThrowable, ConstraintParser.Constraint paramConstraint, int paramInt) {
/*    */     super(paramThrowable);
/*    */     this.constraint = paramConstraint;
/*    */     this.badValue = String.valueOf(paramInt);
/*    */   }
/*    */   
/*    */   public ConstraintViolationException(ConstraintParser.Constraint paramConstraint) {
/*    */     this.constraint = paramConstraint;
/*    */     this.badValue = "UNRESOLVED";
/*    */   }
/*    */   
/*    */   public String getBadValue() {
/*    */     return this.badValue;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\throwables\ConstraintViolationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */