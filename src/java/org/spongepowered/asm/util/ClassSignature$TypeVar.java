/*    */ package org.spongepowered.asm.util;
/*    */ class ClassSignature$TypeVar implements Comparable<ClassSignature$TypeVar> { private final String originalName; private String currentName; public int compareTo(ClassSignature$TypeVar paramClassSignature$TypeVar) {
/*    */     return this.currentName.compareTo(paramClassSignature$TypeVar.currentName);
/*    */   } public boolean equals(Object paramObject) {
/*    */     return this.currentName.equals(paramObject);
/*    */   } public int hashCode() {
/*    */     return this.currentName.hashCode();
/*  8 */   } ClassSignature$TypeVar(String paramString) { this.currentName = this.originalName = paramString; }
/*    */   void rename(String paramString) { this.currentName = paramString; }
/*    */   String getOriginalName() { return this.originalName; } public String toString() {
/* 11 */     return this.currentName; } public boolean matches(String paramString) {
/* 12 */     return this.originalName.equals(paramString);
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\ClassSignature$TypeVar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */