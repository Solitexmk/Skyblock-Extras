/*    */ package org.spongepowered.asm.mixin.injection.points;
/*    */ 
/*    */ import org.spongepowered.asm.lib.tree.AbstractInsnNode;
/*    */ import org.spongepowered.asm.lib.tree.MethodInsnNode;
/*    */ 
/*    */ @AtCode("INVOKE_ASSIGN")
/*    */ public class AfterInvoke extends BeforeInvoke {
/*  8 */   public AfterInvoke(InjectionPointData paramInjectionPointData) { super(paramInjectionPointData); } protected boolean addInsn(InsnList paramInsnList, Collection<AbstractInsnNode> paramCollection, AbstractInsnNode paramAbstractInsnNode) {
/*  9 */     MethodInsnNode methodInsnNode = (MethodInsnNode)paramAbstractInsnNode; try { if (Type.getReturnType(methodInsnNode.desc) == Type.VOID_TYPE) return false;  } catch (RuntimeException runtimeException) { throw c(null); }  paramAbstractInsnNode = InjectionPoint.nextNode(paramInsnList, paramAbstractInsnNode); try { if (paramAbstractInsnNode instanceof org.spongepowered.asm.lib.tree.VarInsnNode && paramAbstractInsnNode.getOpcode() >= 54)
/* 10 */         paramAbstractInsnNode = InjectionPoint.nextNode(paramInsnList, paramAbstractInsnNode);  } catch (RuntimeException runtimeException) { throw c(null); }  paramCollection.add(paramAbstractInsnNode);
/*    */     return true;
/*    */   }
/*    */   
/*    */   private static RuntimeException c(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\points\AfterInvoke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */