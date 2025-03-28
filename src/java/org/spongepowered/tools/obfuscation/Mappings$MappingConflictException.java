/*   */ package org.spongepowered.tools.obfuscation;public class Mappings$MappingConflictException extends RuntimeException { private static final long serialVersionUID = 1L;
/*   */   public IMapping<?> getOld() {
/* 3 */     return this.oldMapping;
/*   */   } private final IMapping<?> oldMapping; private final IMapping<?> newMapping;
/*   */   public Mappings$MappingConflictException(IMapping<?> paramIMapping1, IMapping<?> paramIMapping2) {
/* 6 */     this.oldMapping = paramIMapping1;
/*   */     this.newMapping = paramIMapping2;
/*   */   }
/*   */   
/*   */   public IMapping<?> getNew() {
/*   */     return this.newMapping;
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\Mappings$MappingConflictException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */