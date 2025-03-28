/*   */ package org.spongepowered.asm.mixin.injection;
/*   */ 
/*   */ 
/*   */ final class InjectionPoint$Union extends InjectionPoint$CompositeInjectionPoint {
/* 5 */   public InjectionPoint$Union(InjectionPoint... paramVarArgs) { super(paramVarArgs); } public boolean find(String paramString, InsnList paramInsnList, Collection<AbstractInsnNode> paramCollection) {
/* 6 */     LinkedHashSet<AbstractInsnNode> linkedHashSet = new LinkedHashSet(); byte b = 0; try { for (; b < this.components.length; b++)
/* 7 */         this.components[b].find(paramString, paramInsnList, linkedHashSet);  } catch (RuntimeException runtimeException) { throw b(null); }  try { paramCollection.addAll(linkedHashSet); }
/* 8 */     catch (RuntimeException runtimeException) { throw b(null); }  return (linkedHashSet.size() > 0);
/*   */   }
/*   */   
/*   */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*   */     return paramRuntimeException;
/*   */   }
/*   */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\InjectionPoint$Union.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */