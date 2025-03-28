/*   */ package org.spongepowered.asm.mixin.injection.modify;
/*   */ 
/*   */ public class LocalVariableDiscriminator$Context$Local {
/*   */   public LocalVariableDiscriminator$Context$Local(String paramString, Type paramType) {
/* 5 */     this.ord = 0; this.name = paramString;
/* 6 */     this.type = paramType;
/*   */   }
/*   */   
/*   */   int ord;
/*   */   String name;
/*   */   Type type;
/*   */   final LocalVariableDiscriminator$Context this$0;
/*   */   
/*   */   public String toString() {
/*   */     return String.format("Local[ordinal=%d, name=%s, type=%s]", new Object[] { Integer.valueOf(this.ord), this.name, this.type });
/*   */   }
/*   */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\modify\LocalVariableDiscriminator$Context$Local.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */