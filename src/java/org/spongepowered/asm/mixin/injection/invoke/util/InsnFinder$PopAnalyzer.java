/* 1 */ package org.spongepowered.asm.mixin.injection.invoke.util;class InsnFinder$PopAnalyzer extends Analyzer<BasicValue> { protected Frame<BasicValue> newFrame(int paramInt1, int paramInt2) { return new InsnFinder$PopAnalyzer$PopFrame(this, paramInt1, paramInt2); }
/*   */    protected final AbstractInsnNode node;
/*   */   public InsnFinder$PopAnalyzer(AbstractInsnNode paramAbstractInsnNode) {
/* 4 */     super((Interpreter)new BasicInterpreter());
/*   */     this.node = paramAbstractInsnNode;
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\invok\\util\InsnFinder$PopAnalyzer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */