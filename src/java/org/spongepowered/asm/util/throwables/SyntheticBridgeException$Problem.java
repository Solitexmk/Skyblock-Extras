/*    */ package org.spongepowered.asm.util.throwables;
/*    */ 
/*    */ import org.spongepowered.asm.lib.tree.AbstractInsnNode;
/*    */ import org.spongepowered.asm.lib.tree.MethodInsnNode;
/*    */ import org.spongepowered.asm.util.Bytecode;
/*    */ 
/*    */ 
/*    */ public enum SyntheticBridgeException$Problem
/*    */ {
/* 10 */   BAD_INSN("Conflicting opcodes %4$s and %5$s at offset %3$d in synthetic bridge method %1$s%2$s"),
/*    */ 
/*    */ 
/*    */   
/*    */   BAD_LOAD("Conflicting variable access at offset %3$d in synthetic bridge method %1$s%2$s"),
/*    */ 
/*    */   
/* 17 */   BAD_CAST("Conflicting type cast at offset %3$d in synthetic bridge method %1$s%2$s"),
/*    */   BAD_INVOKE_NAME("Conflicting synthetic bridge target method name in synthetic bridge method %1$s%2$s Existing:%6$s Incoming:%7$s"),
/*    */   BAD_INVOKE_DESC("Conflicting synthetic bridge target method descriptor in synthetic bridge method %1$s%2$s Existing:%8$s Incoming:%9$s"),
/*    */   BAD_LENGTH("Mismatched bridge method length for synthetic bridge method %1$s%2$s unexpected extra opcode at offset %3$d");
/*    */   private static final SyntheticBridgeException$Problem[] $VALUES = new SyntheticBridgeException$Problem[] { BAD_INSN, BAD_LOAD, BAD_CAST, BAD_INVOKE_NAME, BAD_INVOKE_DESC, BAD_LENGTH };
/*    */   
/*    */   SyntheticBridgeException$Problem(String paramString1) {
/*    */     this.message = paramString1;
/*    */   }
/*    */   
/*    */   private static String getInsnName(AbstractInsnNode paramAbstractInsnNode) {
/*    */     try {
/*    */     
/*    */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return (paramAbstractInsnNode instanceof MethodInsnNode) ? ((MethodInsnNode)paramAbstractInsnNode).name : "";
/*    */   }
/*    */   
/*    */   String getMessage(String paramString1, String paramString2, int paramInt, AbstractInsnNode paramAbstractInsnNode1, AbstractInsnNode paramAbstractInsnNode2) {
/*    */     return String.format(this.message, new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Bytecode.getOpcodeName(paramAbstractInsnNode1), Bytecode.getOpcodeName(paramAbstractInsnNode1), getInsnName(paramAbstractInsnNode1), getInsnName(paramAbstractInsnNode2), getInsnDesc(paramAbstractInsnNode1), getInsnDesc(paramAbstractInsnNode2) });
/*    */   }
/*    */   
/*    */   private static String getInsnDesc(AbstractInsnNode paramAbstractInsnNode) {
/*    */     try {
/*    */     
/*    */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return (paramAbstractInsnNode instanceof MethodInsnNode) ? ((MethodInsnNode)paramAbstractInsnNode).desc : "";
/*    */   }
/*    */   
/*    */   private final String message;
/*    */   
/*    */   private static SyntheticBridgeException b(SyntheticBridgeException paramSyntheticBridgeException) {
/*    */     return paramSyntheticBridgeException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\throwables\SyntheticBridgeException$Problem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */