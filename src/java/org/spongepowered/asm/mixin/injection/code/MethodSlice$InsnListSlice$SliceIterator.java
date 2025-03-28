/*  1 */ package org.spongepowered.asm.mixin.injection.code;class MethodSlice$InsnListSlice$SliceIterator implements ListIterator<AbstractInsnNode> { private final ListIterator<AbstractInsnNode> iter; private int start; public int previousIndex() { return this.index - this.start - 1; } private int end; private int index; public MethodSlice$InsnListSlice$SliceIterator(ListIterator<AbstractInsnNode> paramListIterator, int paramInt1, int paramInt2, int paramInt3) {
/*  2 */     this.iter = paramListIterator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 16 */     this.start = paramInt1;
/*    */ 
/*    */     
/*    */     this.end = paramInt2;
/*    */     
/* 21 */     this.index = paramInt3; } public void add(AbstractInsnNode paramAbstractInsnNode) { throw new UnsupportedOperationException("Cannot add insn using slice"); }
/* 22 */   public AbstractInsnNode previous() { try { if (this.index <= this.start) throw new NoSuchElementException();  } catch (NoSuchElementException noSuchElementException) { throw b(null); }  this.index--; return this.iter.previous(); } public AbstractInsnNode next() { try { if (this.index > this.end)
/*    */         throw new NoSuchElementException();  } catch (NoSuchElementException noSuchElementException) { throw b(null); }
/* 24 */      this.index++; return this.iter.next(); }
/*    */ 
/*    */   
/*    */   public void set(AbstractInsnNode paramAbstractInsnNode) {
/*    */     throw new UnsupportedOperationException("Cannot set insn using slice");
/*    */   }
/*    */   
/*    */   public int nextIndex() {
/*    */     return this.index - this.start;
/*    */   }
/*    */   
/*    */   public void remove() {
/*    */     throw new UnsupportedOperationException("Cannot remove insn from slice");
/*    */   }
/*    */   
/*    */   public boolean hasPrevious() {
/*    */     try {
/*    */     
/*    */     } catch (NoSuchElementException noSuchElementException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return (this.index > this.start);
/*    */   }
/*    */   
/*    */   public boolean hasNext() {
/*    */     try {
/*    */       if (this.index <= this.end)
/*    */         try {
/*    */           if (this.iter.hasNext());
/*    */         } catch (NoSuchElementException noSuchElementException) {
/*    */           throw b(null);
/*    */         }  
/*    */     } catch (NoSuchElementException noSuchElementException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return false;
/*    */   }
/*    */   
/*    */   private static NoSuchElementException b(NoSuchElementException paramNoSuchElementException) {
/*    */     return paramNoSuchElementException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\code\MethodSlice$InsnListSlice$SliceIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */