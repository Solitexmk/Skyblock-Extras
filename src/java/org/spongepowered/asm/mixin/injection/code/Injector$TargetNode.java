/*  1 */ package org.spongepowered.asm.mixin.injection.code;public final class Injector$TargetNode { final AbstractInsnNode insn; Injector$TargetNode(AbstractInsnNode paramAbstractInsnNode) { this.insn = paramAbstractInsnNode; }
/*    */ 
/*    */   
/*  4 */   final Set<InjectionPoint> nominators = new HashSet<InjectionPoint>();
/*    */   
/*    */   public int hashCode() {
/*  7 */     return this.insn.hashCode();
/*  8 */   } public AbstractInsnNode getNode() { return this.insn; } public boolean equals(Object paramObject) { 
/*  9 */     try { if (paramObject != null) try { if (paramObject.getClass() == Injector$TargetNode.class) { try {  } catch (RuntimeException runtimeException) { throw b(null); }  return (((Injector$TargetNode)paramObject).insn == this.insn); }  return false; } catch (RuntimeException runtimeException) { throw b(null); }   } catch (RuntimeException runtimeException) { throw b(null); }
/* 10 */      return false; } public Set<InjectionPoint> getNominators() { return Collections.unmodifiableSet(this.nominators); }
/*    */ 
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\code\Injector$TargetNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */