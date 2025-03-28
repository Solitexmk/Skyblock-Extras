/*  1 */ package org.spongepowered.asm.mixin.injection.struct;public class InjectionNodes extends ArrayList<InjectionNodes$InjectionNode> { public void remove(AbstractInsnNode paramAbstractInsnNode) { InjectionNodes$InjectionNode injectionNodes$InjectionNode = get(paramAbstractInsnNode);
/*    */     
/*  3 */     try { if (injectionNodes$InjectionNode != null)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 12 */         injectionNodes$InjectionNode.remove(); }  } catch (RuntimeException runtimeException) { throw b(null); }
/*    */      } private static final long serialVersionUID = 1L; public InjectionNodes$InjectionNode get(AbstractInsnNode paramAbstractInsnNode) { for (InjectionNodes$InjectionNode injectionNodes$InjectionNode : this) {
/*    */       
/*    */       try { if (injectionNodes$InjectionNode.matches(paramAbstractInsnNode))
/* 16 */           return injectionNodes$InjectionNode;  } catch (RuntimeException runtimeException) { throw b(null); }
/*    */     
/* 18 */     }  return null; } public InjectionNodes$InjectionNode add(AbstractInsnNode paramAbstractInsnNode) { InjectionNodes$InjectionNode injectionNodes$InjectionNode = get(paramAbstractInsnNode); if (injectionNodes$InjectionNode == null) {
/* 19 */       injectionNodes$InjectionNode = new InjectionNodes$InjectionNode(paramAbstractInsnNode); add(injectionNodes$InjectionNode);
/* 20 */     }  return injectionNodes$InjectionNode; }
/*    */ 
/*    */   
/*    */   public boolean contains(AbstractInsnNode paramAbstractInsnNode) {
/*    */     try {
/*    */     
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return (get(paramAbstractInsnNode) != null);
/*    */   }
/*    */   
/*    */   public void replace(AbstractInsnNode paramAbstractInsnNode1, AbstractInsnNode paramAbstractInsnNode2) {
/*    */     InjectionNodes$InjectionNode injectionNodes$InjectionNode = get(paramAbstractInsnNode1);
/*    */     try {
/*    */       if (injectionNodes$InjectionNode != null)
/*    */         injectionNodes$InjectionNode.replace(paramAbstractInsnNode2); 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\struct\InjectionNodes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */