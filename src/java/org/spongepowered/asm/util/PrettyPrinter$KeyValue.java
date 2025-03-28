/*   */ package org.spongepowered.asm.util;class PrettyPrinter$KeyValue implements PrettyPrinter$IVariableWidthEntry { private final String key; public String toString() {
/* 2 */     return String.format(PrettyPrinter.this.kvFormat, new Object[] { this.key, this.value });
/*   */   }
/*   */   private final Object value; final PrettyPrinter this$0;
/*   */   public PrettyPrinter$KeyValue(String paramString, Object paramObject) {
/* 6 */     this.key = paramString;
/*   */     this.value = paramObject;
/*   */   }
/*   */   
/*   */   public int getWidth() {
/*   */     return toString().length();
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\PrettyPrinter$KeyValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */