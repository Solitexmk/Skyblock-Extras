/* 1 */ package org.spongepowered.tools.obfuscation;public class ReferenceManager$ReferenceConflictException extends RuntimeException { private static final long serialVersionUID = 1L; public String getNew() { return this.newReference; } private final String oldReference; private final String newReference; public String getOld() {
/* 2 */     return this.oldReference;
/*   */   } public ReferenceManager$ReferenceConflictException(String paramString1, String paramString2) {
/* 4 */     this.oldReference = paramString1;
/*   */     this.newReference = paramString2;
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\ReferenceManager$ReferenceConflictException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */