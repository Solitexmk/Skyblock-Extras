/*   */ package org.spongepowered.asm.util;
/*   */ 
/*   */ 
/*   */ 
/*   */ public enum Bytecode$Visibility
/*   */ {
/* 7 */   PRIVATE(2),
/* 8 */   PROTECTED(4),
/* 9 */   PACKAGE(0),
/*   */   PUBLIC(1);
/*   */   
/*   */   Bytecode$Visibility(int paramInt1) {
/*   */     this.access = paramInt1;
/*   */   }
/*   */   
/*   */   private static final Bytecode$Visibility[] $VALUES = new Bytecode$Visibility[] { PRIVATE, PROTECTED, PACKAGE, PUBLIC };
/*   */   static final int MASK = 7;
/*   */   final int access;
/*   */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\Bytecode$Visibility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */