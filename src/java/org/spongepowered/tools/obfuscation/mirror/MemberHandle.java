/* 1 */ package org.spongepowered.tools.obfuscation.mirror;public abstract class MemberHandle<T extends IMapping<T>> { private final String owner; public final String getDesc() { return this.desc; } private final String name; private final String desc; public final String getOwner() {
/* 2 */     return this.owner; } public final String getName() {
/* 3 */     return this.name;
/*   */   }
/*   */ 
/*   */   
/*   */   protected MemberHandle(String paramString1, String paramString2, String paramString3) {
/* 8 */     this.owner = paramString1;
/*   */     this.name = paramString2;
/*   */     this.desc = paramString3;
/*   */   }
/*   */   
/*   */   public abstract Visibility getVisibility();
/*   */   
/*   */   public abstract T asMapping(boolean paramBoolean); }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\mirror\MemberHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */