/*    */ package org.spongepowered.asm.mixin.injection;
/*    */ 
/*    */ final class InjectionPoint$Intersection extends InjectionPoint$CompositeInjectionPoint {
/*    */   public InjectionPoint$Intersection(InjectionPoint... paramVarArgs) {
/*  5 */     super(paramVarArgs);
/*    */   }
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
/*    */   public boolean find(String paramString, InsnList paramInsnList, Collection<AbstractInsnNode> paramCollection) {
/* 21 */     boolean bool = false; ArrayList[] arrayOfArrayList = (ArrayList[])Array.newInstance(ArrayList.class, this.components.length); byte b1 = 0; try { while (b1 < this.components.length)
/* 22 */       { arrayOfArrayList[b1] = new ArrayList(); this.components[b1].find(paramString, paramInsnList, arrayOfArrayList[b1]); b1++; }  } catch (RuntimeException runtimeException) { throw b(null); }
/*    */     
/*    */     ArrayList<AbstractInsnNode> arrayList = arrayOfArrayList[0];
/*    */     for (byte b2 = 0; b2 < arrayList.size(); bool1 = true, bool2 = true) {
/*    */       boolean bool1, bool2;
/*    */       AbstractInsnNode abstractInsnNode = arrayList.get(b2);
/*    */     } 
/*    */     return bool;
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\InjectionPoint$Intersection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */