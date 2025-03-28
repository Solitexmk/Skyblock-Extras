/*   */ package org.spongepowered.asm.mixin.injection;
/*   */ abstract class InjectionPoint$CompositeInjectionPoint extends InjectionPoint { protected final InjectionPoint[] components;
/*   */   
/* 4 */   protected InjectionPoint$CompositeInjectionPoint(InjectionPoint... paramVarArgs) { if (paramVarArgs != null) try { if (paramVarArgs.length >= 2) { this.components = paramVarArgs; return; }  throw new IllegalArgumentException("Must supply two or more component injection points for composite point!"); }
/*   */       catch (IllegalArgumentException illegalArgumentException) { throw b(null); }
/* 6 */         throw new IllegalArgumentException("Must supply two or more component injection points for composite point!"); } public String toString() { return "CompositeInjectionPoint(" + getClass().getSimpleName() + ")[" + Joiner.on(',').join((Object[])this.components) + "]"; }
/*   */ 
/*   */   
/*   */   private static IllegalArgumentException b(IllegalArgumentException paramIllegalArgumentException) {
/*   */     return paramIllegalArgumentException;
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\InjectionPoint$CompositeInjectionPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */