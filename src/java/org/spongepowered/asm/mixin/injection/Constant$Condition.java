/*    */ package org.spongepowered.asm.mixin.injection;public enum Constant$Condition {
/*  2 */   LESS_THAN_ZERO(new int[] { 155, 156
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     }),
/* 12 */   LESS_THAN_OR_EQUAL_TO_ZERO(new int[] { 158, 157
/*    */     
/*    */     }),
/* 15 */   GREATER_THAN_OR_EQUAL_TO_ZERO(LESS_THAN_ZERO),
/* 16 */   GREATER_THAN_ZERO(LESS_THAN_OR_EQUAL_TO_ZERO); public int[] getOpcodes() { return this.opcodes; }
/*    */ 
/*    */   
/*    */   private static final Constant$Condition[] $VALUES = new Constant$Condition[] { LESS_THAN_ZERO, LESS_THAN_OR_EQUAL_TO_ZERO, GREATER_THAN_OR_EQUAL_TO_ZERO, GREATER_THAN_ZERO };
/*    */   
/*    */   public Constant$Condition getEquivalentCondition() {
/*    */     return this.equivalence;
/*    */   }
/*    */   
/*    */   Constant$Condition(Constant$Condition paramConstant$Condition, int... paramVarArgs) {
/*    */     this.equivalence = (paramConstant$Condition != null) ? paramConstant$Condition : this;
/*    */     this.opcodes = paramVarArgs;
/*    */   }
/*    */   
/*    */   private final int[] opcodes;
/*    */   private final Constant$Condition equivalence;
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\Constant$Condition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */