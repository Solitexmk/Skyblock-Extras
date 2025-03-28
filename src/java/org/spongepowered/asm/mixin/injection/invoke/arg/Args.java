/*   */ package org.spongepowered.asm.mixin.injection.invoke.arg;
/*   */ public abstract class Args {
/* 3 */   public int size() { return this.values.length; } protected final Object[] values; public <T> T get(int paramInt) {
/* 4 */     return (T)this.values[paramInt];
/*   */   }
/*   */   
/*   */   protected Args(Object[] paramArrayOfObject) {
/*   */     this.values = paramArrayOfObject;
/*   */   }
/*   */   
/*   */   public abstract <T> void set(int paramInt, T paramT);
/*   */   
/*   */   public abstract void setAll(Object... paramVarArgs);
/*   */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\invoke\arg\Args.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */