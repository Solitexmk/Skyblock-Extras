/*   */ package org.spongepowered.asm.mixin.injection.invoke;
/* 2 */ class RedirectInjector$Meta { public static final String KEY = "redirector"; final int priority; final boolean isFinal; public RedirectInjector$Meta(int paramInt, boolean paramBoolean, String paramString1, String paramString2) { this.priority = paramInt;
/*   */     
/* 4 */     this.isFinal = paramBoolean;
/*   */     this.name = paramString1;
/* 6 */     this.desc = paramString2; } final String name; final String desc; final RedirectInjector this$0; RedirectInjector getOwner() { return RedirectInjector.this; }
/*   */    }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\invoke\RedirectInjector$Meta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */