/*   */ package org.spongepowered.asm.mixin.injection.invoke.util;class InsnFinder$AnalysisResultException extends RuntimeException { private static final long serialVersionUID = 1L; public InsnFinder$AnalysisResultException(AbstractInsnNode paramAbstractInsnNode) {
/* 2 */     this.result = paramAbstractInsnNode;
/*   */   } private AbstractInsnNode result; public AbstractInsnNode getResult() {
/* 4 */     return this.result;
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\invok\\util\InsnFinder$AnalysisResultException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */