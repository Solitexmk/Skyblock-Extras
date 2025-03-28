/*   */ package org.spongepowered.asm.util;
/*   */ 
/*   */ class PrettyPrinter$CentredText {
/*   */   public PrettyPrinter$CentredText(Object paramObject) {
/* 5 */     this.centred = paramObject;
/*   */   }
/*   */   
/*   */   private final Object centred;
/*   */   final PrettyPrinter this$0;
/*   */   
/*   */   public String toString() {
/*   */     String str = this.centred.toString();
/*   */     return String.format("%" + ((PrettyPrinter.this.width - str.length()) / 2 + str.length()) + "s", new Object[] { str });
/*   */   }
/*   */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\PrettyPrinter$CentredText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */