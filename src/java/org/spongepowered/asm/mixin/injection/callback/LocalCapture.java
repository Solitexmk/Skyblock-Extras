/*    */ package org.spongepowered.asm.mixin.injection.callback;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum LocalCapture
/*    */ {
/*  8 */   NO_CAPTURE(false, false),
/*    */   
/*    */   PRINT(false, true),
/*    */   
/* 12 */   CAPTURE_FAILSOFT, CAPTURE_FAILHARD,
/*    */   CAPTURE_FAILEXCEPTION; LocalCapture(boolean paramBoolean1, boolean paramBoolean2) { this.captureLocals = paramBoolean1;
/* 14 */     this.printLocals = paramBoolean2; } boolean isCaptureLocals() {
/* 15 */     return this.captureLocals;
/*    */   }
/*    */   
/*    */   boolean isPrintLocals() {
/*    */     return this.printLocals;
/*    */   }
/*    */   
/*    */   private final boolean captureLocals;
/*    */   private final boolean printLocals;
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\callback\LocalCapture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */