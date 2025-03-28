/* 1 */ package org.spongepowered.asm.mixin.injection.throwables;public class InjectionValidationException extends Exception { private static final long serialVersionUID = 1L; public InjectionValidationException(InjectorGroupInfo paramInjectorGroupInfo, String paramString) { super(paramString);
/* 2 */     this.group = paramInjectorGroupInfo; }
/*   */    private final InjectorGroupInfo group; public InjectorGroupInfo getGroup() {
/* 4 */     return this.group;
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\throwables\InjectionValidationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */