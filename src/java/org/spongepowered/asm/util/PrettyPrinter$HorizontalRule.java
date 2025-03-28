/*   */ package org.spongepowered.asm.util;class PrettyPrinter$HorizontalRule implements PrettyPrinter$ISpecialEntry {
/*   */   public PrettyPrinter$HorizontalRule(char... paramVarArgs) {
/* 3 */     this.hrChars = paramVarArgs;
/*   */   }
/*   */   
/*   */   private final char[] hrChars;
/*   */   final PrettyPrinter this$0;
/*   */   
/*   */   public String toString() {
/*   */     return Strings.repeat(new String(this.hrChars), PrettyPrinter.this.width + 2);
/*   */   }
/*   */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\PrettyPrinter$HorizontalRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */