/*   */ package org.spongepowered.asm.mixin.injection.points;
/*   */ @AtCode("HEAD")
/* 3 */ public class MethodHead extends InjectionPoint { public MethodHead(InjectionPointData paramInjectionPointData) { super(paramInjectionPointData); }
/* 4 */   public boolean find(String paramString, InsnList paramInsnList, Collection<AbstractInsnNode> paramCollection) { paramCollection.add(paramInsnList.getFirst());
/* 5 */     return true; } public boolean checkPriority(int paramInt1, int paramInt2) { return true; }
/*   */    }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\points\MethodHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */