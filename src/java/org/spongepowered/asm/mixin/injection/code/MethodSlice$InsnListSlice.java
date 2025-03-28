/*  1 */ package org.spongepowered.asm.mixin.injection.code;final class MethodSlice$InsnListSlice extends ReadOnlyInsnList { private final int start; public int size() { return this.end - this.start + 1; }
/*    */    private final int end; protected MethodSlice$InsnListSlice(InsnList paramInsnList, int paramInt1, int paramInt2) {
/*  3 */     super(paramInsnList);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     this.start = paramInt1;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 21 */     this.end = paramInt2; } public ListIterator<AbstractInsnNode> iterator() { return iterator(0); }
/* 22 */   public AbstractInsnNode[] toArray() { AbstractInsnNode[] arrayOfAbstractInsnNode1 = super.toArray(); AbstractInsnNode[] arrayOfAbstractInsnNode2 = new AbstractInsnNode[size()]; System.arraycopy(arrayOfAbstractInsnNode1, this.start, arrayOfAbstractInsnNode2, 0, arrayOfAbstractInsnNode2.length);
/*    */     return arrayOfAbstractInsnNode2; }
/*    */ 
/*    */   
/*    */   public AbstractInsnNode getLast() {
/*    */     return super.get(this.end);
/*    */   }
/*    */   
/*    */   public ListIterator<AbstractInsnNode> iterator(int paramInt) {
/*    */     return new MethodSlice$InsnListSlice$SliceIterator(super.iterator(this.start + paramInt), this.start, this.end, this.start + paramInt);
/*    */   }
/*    */   
/*    */   public AbstractInsnNode getFirst() {
/*    */     return super.get(this.start);
/*    */   }
/*    */   
/*    */   public int indexOf(AbstractInsnNode paramAbstractInsnNode) {
/*    */     int i = super.indexOf(paramAbstractInsnNode);
/*    */     try {
/*    */       if (i >= this.start)
/*    */         try {
/*    */           if (i <= this.end);
/*    */         } catch (RuntimeException runtimeException) {
/*    */           throw b(null);
/*    */         }  
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return -1;
/*    */   }
/*    */   
/*    */   public AbstractInsnNode get(int paramInt) {
/*    */     return super.get(this.start + paramInt);
/*    */   }
/*    */   
/*    */   public int realIndexOf(AbstractInsnNode paramAbstractInsnNode) {
/*    */     return super.indexOf(paramAbstractInsnNode);
/*    */   }
/*    */   
/*    */   public boolean contains(AbstractInsnNode paramAbstractInsnNode) {
/*    */     AbstractInsnNode[] arrayOfAbstractInsnNode;
/*    */     int i;
/*    */     byte b;
/*    */     for (arrayOfAbstractInsnNode = toArray(), i = arrayOfAbstractInsnNode.length, b = 0; b < i; ) {
/*    */       AbstractInsnNode abstractInsnNode = arrayOfAbstractInsnNode[b];
/*    */       try {
/*    */         if (abstractInsnNode == paramAbstractInsnNode)
/*    */           return true; 
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } 
/*    */     return false;
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\code\MethodSlice$InsnListSlice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */