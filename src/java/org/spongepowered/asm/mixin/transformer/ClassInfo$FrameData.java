/*    */ package org.spongepowered.asm.mixin.transformer;
/*    */ public class ClassInfo$FrameData {
/*    */   public String toString() {
/*  4 */     return String.format("FrameData[index=%d, type=%s, locals=%d]", new Object[] { Integer.valueOf(this.index), FRAMETYPES[this.type + 1], Integer.valueOf(this.locals) });
/*    */   }
/*    */   ClassInfo$FrameData(int paramInt1, int paramInt2, int paramInt3) {
/*  7 */     this.index = paramInt1;
/*    */ 
/*    */     
/*    */     this.type = paramInt2;
/*    */     
/* 12 */     this.locals = paramInt3;
/*    */   }
/*    */   
/*    */   ClassInfo$FrameData(int paramInt, FrameNode paramFrameNode) {
/*    */     this.index = paramInt;
/*    */     this.type = paramFrameNode.type;
/*    */     this.locals = (paramFrameNode.local != null) ? paramFrameNode.local.size() : 0;
/*    */   }
/*    */   
/*    */   private static final String[] FRAMETYPES = new String[] { "NEW", "FULL", "APPEND", "CHOP", "SAME", "SAME1" };
/*    */   public final int index;
/*    */   public final int type;
/*    */   public final int locals;
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\ClassInfo$FrameData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */