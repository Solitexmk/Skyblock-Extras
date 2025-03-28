/*   */ package org.spongepowered.asm.mixin.injection.invoke.arg;public class ArgumentCountException extends IllegalArgumentException { public ArgumentCountException(int paramInt1, int paramInt2, String paramString) {
/* 2 */     super("Invalid number of arguments for setAll, received " + paramInt1 + " but expected " + paramInt2 + ": " + paramString);
/*   */   }
/*   */   
/*   */   private static final long serialVersionUID = 1L; }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\invoke\arg\ArgumentCountException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */