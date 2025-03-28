/*    */ package org.spongepowered.asm.mixin.injection.points;@AtCode("RETURN")
/*  2 */ public class BeforeReturn extends InjectionPoint { public boolean checkPriority(int paramInt1, int paramInt2) { return true; }
/*    */   
/*    */   private final int ordinal;
/*    */   public BeforeReturn(InjectionPointData paramInjectionPointData) {
/*  6 */     super(paramInjectionPointData);
/*    */ 
/*    */     
/*  9 */     this.ordinal = paramInjectionPointData.getOrdinal();
/*    */   }
/*    */   public boolean find(String paramString, InsnList paramInsnList, Collection<AbstractInsnNode> paramCollection) {
/* 12 */     boolean bool = false;
/*    */ 
/*    */ 
/*    */     
/* 16 */     int i = Type.getReturnType(paramString).getOpcode(172);
/*    */     byte b = 0;
/*    */     ListIterator<AbstractInsnNode> listIterator = paramInsnList.iterator();
/*    */     while (listIterator.hasNext()) {
/*    */       AbstractInsnNode abstractInsnNode = listIterator.next();
/*    */       try {
/*    */         if (abstractInsnNode instanceof org.spongepowered.asm.lib.tree.InsnNode)
/*    */           try {
/*    */             if (abstractInsnNode.getOpcode() == i) {
/*    */               try {
/*    */                 if (this.ordinal == -1 || this.ordinal == b) {
/*    */                   paramCollection.add(abstractInsnNode);
/*    */                   bool = true;
/*    */                 } 
/*    */               } catch (RuntimeException runtimeException) {
/*    */                 throw b(null);
/*    */               } 
/*    */               b++;
/*    */             } 
/*    */           } catch (RuntimeException runtimeException) {
/*    */             throw b(null);
/*    */           }  
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } 
/*    */     return bool;
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\points\BeforeReturn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */