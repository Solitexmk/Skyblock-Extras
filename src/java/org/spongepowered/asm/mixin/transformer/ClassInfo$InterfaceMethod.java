/* 1 */ package org.spongepowered.asm.mixin.transformer;public class ClassInfo$InterfaceMethod extends ClassInfo$Method { private final ClassInfo owner; public ClassInfo getOwner() { return this.owner; } final ClassInfo this$0; public ClassInfo$InterfaceMethod(ClassInfo$Member paramClassInfo$Member) {
/* 2 */     super(paramClassInfo, paramClassInfo$Member);
/* 3 */     this.owner = paramClassInfo$Member.getOwner();
/*   */   }
/*   */   public ClassInfo getImplementor() {
/* 6 */     return ClassInfo.this;
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\ClassInfo$InterfaceMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */