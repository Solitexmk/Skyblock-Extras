/*  1 */ package org.spongepowered.asm.util;public class ReEntranceLock { private final int maxDepth; public boolean isSet() { return this.semaphore; }
/*    */    private int depth; private boolean semaphore; public ReEntranceLock push() {
/*  3 */     this.depth++;
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
/* 14 */     checkAndSet();
/*    */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public ReEntranceLock set() {
/*    */     this.semaphore = true;
/* 21 */     return this;
/*    */   }
/*    */   
/*    */   public ReEntranceLock clear() {
/*    */     this.semaphore = false;
/*    */     return this;
/*    */   }
/*    */   
/*    */   public boolean check() {
/*    */     try {
/*    */     
/*    */     } catch (IllegalStateException illegalStateException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return (this.depth > this.maxDepth);
/*    */   }
/*    */   
/*    */   public int getDepth() {
/*    */     return this.depth;
/*    */   }
/*    */   
/*    */   public int getMaxDepth() {
/*    */     return this.maxDepth;
/*    */   }
/*    */   
/*    */   public ReEntranceLock(int paramInt) {
/*    */     this.depth = 0;
/*    */     this.semaphore = false;
/*    */     this.maxDepth = paramInt;
/*    */   }
/*    */   
/*    */   public ReEntranceLock pop() {
/*    */     try {
/*    */       if (this.depth == 0)
/*    */         throw new IllegalStateException("ReEntranceLock pop() with zero depth"); 
/*    */     } catch (IllegalStateException illegalStateException) {
/*    */       throw b(null);
/*    */     } 
/*    */     this.depth--;
/*    */     return this;
/*    */   }
/*    */   
/*    */   public boolean checkAndSet() {
/*    */     return this.semaphore |= check();
/*    */   }
/*    */   
/*    */   private static IllegalStateException b(IllegalStateException paramIllegalStateException) {
/*    */     return paramIllegalStateException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\ReEntranceLock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */