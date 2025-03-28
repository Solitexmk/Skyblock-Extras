/*    */ package org.spongepowered.asm.mixin.injection.points;
/*    */ import org.spongepowered.asm.lib.tree.AbstractInsnNode;
/*    */ 
/*    */ @AtCode("TAIL")
/*    */ public class BeforeFinalReturn extends InjectionPoint {
/*    */   public boolean find(String paramString, InsnList paramInsnList, Collection<AbstractInsnNode> paramCollection) {
/*  7 */     AbstractInsnNode abstractInsnNode = null;
/*    */     
/*    */     int i = Type.getReturnType(paramString).getOpcode(172);
/*    */     ListIterator<AbstractInsnNode> listIterator = paramInsnList.iterator();
/*    */     while (listIterator.hasNext()) {
/*    */       AbstractInsnNode abstractInsnNode1 = listIterator.next();
/*    */       
/* 14 */       try { if (abstractInsnNode1 instanceof org.spongepowered.asm.lib.tree.InsnNode && abstractInsnNode1.getOpcode() == i) abstractInsnNode = abstractInsnNode1;  } catch (InvalidInjectionException invalidInjectionException) { throw b(null); } 
/* 15 */     }  try { if (abstractInsnNode == null)
/* 16 */         throw new InvalidInjectionException(this.context, "TAIL could not locate a valid RETURN in the target method!");  } catch (InvalidInjectionException invalidInjectionException) { throw b(null); }  paramCollection.add(abstractInsnNode); return true;
/*    */   }
/*    */   
/*    */   private final IMixinContext context;
/*    */   
/*    */   private static InvalidInjectionException b(InvalidInjectionException paramInvalidInjectionException) {
/*    */     return paramInvalidInjectionException;
/*    */   }
/*    */   
/*    */   public boolean checkPriority(int paramInt1, int paramInt2) {
/*    */     return true;
/*    */   }
/*    */   
/*    */   public BeforeFinalReturn(InjectionPointData paramInjectionPointData) {
/*    */     super(paramInjectionPointData);
/*    */     this.context = paramInjectionPointData.getContext();
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\points\BeforeFinalReturn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */