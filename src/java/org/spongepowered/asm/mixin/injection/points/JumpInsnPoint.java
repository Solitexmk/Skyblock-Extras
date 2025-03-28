/*    */ package org.spongepowered.asm.mixin.injection.points;
/*    */ 
/*    */ import java.util.ListIterator;
/*    */ import org.spongepowered.asm.lib.tree.AbstractInsnNode;
/*    */ 
/*    */ @AtCode("JUMP")
/*    */ public class JumpInsnPoint extends InjectionPoint {
/*    */   private final int opCode;
/*    */   
/* 10 */   public JumpInsnPoint(InjectionPointData paramInjectionPointData) { this.opCode = paramInjectionPointData.getOpcode(-1, new int[] { 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 198, 199, -1 });
/*    */ 
/*    */     
/* 13 */     this.ordinal = paramInjectionPointData.getOrdinal(); } private final int ordinal; public boolean find(String paramString, InsnList paramInsnList, Collection<AbstractInsnNode> paramCollection) { boolean bool1 = false;
/* 14 */     boolean bool2 = false; ListIterator<AbstractInsnNode> listIterator = paramInsnList.iterator(); while (listIterator.hasNext()) {
/*    */       continue; abstractInsnNode = listIterator.next();
/* 16 */     }  return bool1; }
/*    */ 
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\points\JumpInsnPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */