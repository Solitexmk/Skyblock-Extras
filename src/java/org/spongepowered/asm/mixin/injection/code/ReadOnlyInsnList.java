/*  1 */ package org.spongepowered.asm.mixin.injection.code;class ReadOnlyInsnList extends InsnList { public final void insertBefore(AbstractInsnNode paramAbstractInsnNode, InsnList paramInsnList) { throw new UnsupportedOperationException(); } private InsnList insnList; public AbstractInsnNode[] toArray() {
/*  2 */     return this.insnList.toArray(); }
/*  3 */   void dispose() { this.insnList = null; }
/*  4 */   public final void remove(AbstractInsnNode paramAbstractInsnNode) { throw new UnsupportedOperationException(); }
/*  5 */   public final void insert(AbstractInsnNode paramAbstractInsnNode) { throw new UnsupportedOperationException(); } public final void add(InsnList paramInsnList) {
/*  6 */     throw new UnsupportedOperationException();
/*    */   }
/*  8 */   public AbstractInsnNode getFirst() { return this.insnList.getFirst(); }
/*  9 */   public final void insert(InsnList paramInsnList) { throw new UnsupportedOperationException(); }
/* 10 */   public final void set(AbstractInsnNode paramAbstractInsnNode1, AbstractInsnNode paramAbstractInsnNode2) { throw new UnsupportedOperationException(); }
/* 11 */   public final void add(AbstractInsnNode paramAbstractInsnNode) { throw new UnsupportedOperationException(); }
/* 12 */   public final void insert(AbstractInsnNode paramAbstractInsnNode1, AbstractInsnNode paramAbstractInsnNode2) { throw new UnsupportedOperationException(); } public final void insertBefore(AbstractInsnNode paramAbstractInsnNode1, AbstractInsnNode paramAbstractInsnNode2) {
/* 13 */     throw new UnsupportedOperationException();
/*    */   }
/* 15 */   public ListIterator<AbstractInsnNode> iterator(int paramInt) { return this.insnList.iterator(paramInt); }
/* 16 */   public AbstractInsnNode get(int paramInt) { return this.insnList.get(paramInt); }
/* 17 */   public final void insert(AbstractInsnNode paramAbstractInsnNode, InsnList paramInsnList) { throw new UnsupportedOperationException(); }
/* 18 */   public AbstractInsnNode getLast() { return this.insnList.getLast(); } public final void resetLabels() {
/* 19 */     this.insnList.resetLabels();
/*    */   }
/* 21 */   public int indexOf(AbstractInsnNode paramAbstractInsnNode) { return this.insnList.indexOf(paramAbstractInsnNode); }
/* 22 */   public int size() { return this.insnList.size(); }
/* 23 */   public ListIterator<AbstractInsnNode> iterator() { return this.insnList.iterator(); } public boolean contains(AbstractInsnNode paramAbstractInsnNode) {
/* 24 */     return this.insnList.contains(paramAbstractInsnNode);
/*    */   }
/*    */   
/*    */   public ReadOnlyInsnList(InsnList paramInsnList) {
/*    */     this.insnList = paramInsnList;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\code\ReadOnlyInsnList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */