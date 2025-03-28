/*  1 */ package org.spongepowered.asm.mixin.injection.struct;public class InjectionNodes$InjectionNode implements Comparable<InjectionNodes$InjectionNode> { public boolean isRemoved() { try {  } catch (RuntimeException runtimeException) { throw b(null); }  return (this.currentTarget == null); } public <V> V getDecoration(String paramString) { try {  }
/*  2 */     catch (RuntimeException runtimeException) { throw b(null); }  return (this.decorations == null) ? null : (V)this.decorations.get(paramString); }
/*    */ 
/*    */   
/*    */   public InjectionNodes$InjectionNode replace(AbstractInsnNode paramAbstractInsnNode) {
/*  6 */     this.currentTarget = paramAbstractInsnNode;
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
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 24 */     return this;
/*    */   }
/*    */   
/*    */   public int getId() {
/*    */     return this.id;
/*    */   }
/*    */   
/*    */   public AbstractInsnNode getCurrentTarget() {
/*    */     return this.currentTarget;
/*    */   }
/*    */   
/*    */   public InjectionNodes$InjectionNode remove() {
/*    */     this.currentTarget = null;
/*    */     return this;
/*    */   }
/*    */   
/*    */   public boolean isReplaced() {
/*    */     try {
/*    */     
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return (this.originalTarget != this.currentTarget);
/*    */   }
/*    */   
/*    */   public InjectionNodes$InjectionNode(AbstractInsnNode paramAbstractInsnNode) {
/*    */     this.currentTarget = this.originalTarget = paramAbstractInsnNode;
/*    */     this.id = nextId++;
/*    */   }
/*    */   
/*    */   public int compareTo(InjectionNodes$InjectionNode paramInjectionNodes$InjectionNode) {
/*    */     try {
/*    */     
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return (paramInjectionNodes$InjectionNode == null) ? Integer.MAX_VALUE : (hashCode() - paramInjectionNodes$InjectionNode.hashCode());
/*    */   }
/*    */   
/*    */   public <V> InjectionNodes$InjectionNode decorate(String paramString, V paramV) {
/*    */     try {
/*    */       if (this.decorations == null)
/*    */         this.decorations = new HashMap<String, Object>(); 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     this.decorations.put(paramString, paramV);
/*    */     return this;
/*    */   }
/*    */   
/*    */   private static int nextId = 0;
/*    */   private final int id;
/*    */   private final AbstractInsnNode originalTarget;
/*    */   private AbstractInsnNode currentTarget;
/*    */   private Map<String, Object> decorations;
/*    */   
/*    */   public boolean hasDecoration(String paramString) {
/*    */     try {
/*    */       if (this.decorations != null)
/*    */         try {
/*    */           if (this.decorations.get(paramString) != null);
/*    */         } catch (RuntimeException runtimeException) {
/*    */           throw b(null);
/*    */         }  
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return false;
/*    */   }
/*    */   
/*    */   public AbstractInsnNode getOriginalTarget() {
/*    */     return this.originalTarget;
/*    */   }
/*    */   
/*    */   public boolean matches(AbstractInsnNode paramAbstractInsnNode) {
/*    */     try {
/*    */       if (this.originalTarget != paramAbstractInsnNode) {
/*    */         try {
/*    */           if (this.currentTarget == paramAbstractInsnNode);
/*    */         } catch (RuntimeException runtimeException) {
/*    */           throw b(null);
/*    */         } 
/*    */         return false;
/*    */       } 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */   }
/*    */   
/*    */   public String toString() {
/*    */     return String.format("InjectionNode[%s]", new Object[] { Bytecode.describeNode(this.currentTarget).replaceAll("\\s+", " ") });
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\struct\InjectionNodes$InjectionNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */