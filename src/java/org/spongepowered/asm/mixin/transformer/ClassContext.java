/*    */ package org.spongepowered.asm.mixin.transformer;
/*    */ abstract class ClassContext {
/*  3 */   private final Set<ClassInfo$Method> upgradedMethods = new HashSet<ClassInfo$Method>();
/*    */   
/*    */   protected void upgradeMethodRef(MethodNode paramMethodNode, MemberRef paramMemberRef, ClassInfo$Method paramClassInfo$Method) {
/*    */     try {
/*  7 */       if (paramMemberRef.getOpcode() != 183)
/*    */       {
/*    */         return;
/*    */ 
/*    */ 
/*    */       
/*    */       }
/*    */ 
/*    */ 
/*    */     
/*    */     }
/*    */     catch (IllegalStateException illegalStateException) {
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 23 */       throw b(null);
/*    */     } 
/*    */     try {
/* 26 */       if (this.upgradedMethods.contains(paramClassInfo$Method))
/*    */         paramMemberRef.setOpcode(182); 
/*    */     } catch (IllegalStateException illegalStateException) {
/*    */       throw b(null);
/*    */     } 
/*    */   }
/*    */   
/*    */   private void upgradeMethod(MethodNode paramMethodNode) {
/*    */     for (ListIterator<AbstractInsnNode> listIterator = paramMethodNode.instructions.iterator(); listIterator.hasNext(); ) {
/*    */       AbstractInsnNode abstractInsnNode = listIterator.next();
/*    */       try {
/*    */         if (!(abstractInsnNode instanceof org.spongepowered.asm.lib.tree.MethodInsnNode));
/*    */       } catch (IllegalStateException illegalStateException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   void addUpgradedMethod(MethodNode paramMethodNode) {
/*    */     ClassInfo$Method classInfo$Method = getClassInfo().findMethod(paramMethodNode);
/*    */     try {
/*    */       if (classInfo$Method == null)
/*    */         throw new IllegalStateException("Meta method for " + paramMethodNode.name + " not located in " + this); 
/*    */     } catch (IllegalStateException illegalStateException) {
/*    */       throw b(null);
/*    */     } 
/*    */     this.upgradedMethods.add(classInfo$Method);
/*    */   }
/*    */   
/*    */   protected void upgradeMethods() {
/*    */     for (MethodNode methodNode : (getClassNode()).methods)
/*    */       upgradeMethod(methodNode); 
/*    */   }
/*    */   
/*    */   abstract String getClassRef();
/*    */   
/*    */   abstract ClassNode getClassNode();
/*    */   
/*    */   abstract ClassInfo getClassInfo();
/*    */   
/*    */   private static IllegalStateException b(IllegalStateException paramIllegalStateException) {
/*    */     return paramIllegalStateException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\ClassContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */