/*    */ package org.spongepowered.asm.mixin.injection.modify;
/*    */ @AtCode("LOAD")
/*    */ public class BeforeLoadLocal extends ModifyVariableInjector$ContextualInjectionPoint { private final Type returnType; private final LocalVariableDiscriminator discriminator;
/*  4 */   protected BeforeLoadLocal(InjectionPointData paramInjectionPointData, int paramInt, boolean paramBoolean) { super(paramInjectionPointData.getContext());
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 10 */     this.returnType = paramInjectionPointData.getMethodReturnType();
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
/* 22 */     this.discriminator = paramInjectionPointData.getLocalVariableDiscriminator(); this.opcode = paramInjectionPointData.getOpcode(this.returnType.getOpcode(paramInt)); this.ordinal = paramInjectionPointData.getOrdinal(); this.opcodeAfter = paramBoolean; }
/*    */   private final int opcode; private final int ordinal; private boolean opcodeAfter; protected BeforeLoadLocal(InjectionPointData paramInjectionPointData) { this(paramInjectionPointData, 21, false); } boolean find(Target paramTarget, Collection<AbstractInsnNode> paramCollection) { BeforeLoadLocal$SearchState beforeLoadLocal$SearchState = new BeforeLoadLocal$SearchState(this.ordinal, this.discriminator.printLVT());
/*    */     ListIterator<AbstractInsnNode> listIterator = paramTarget.method.instructions.iterator();
/* 25 */     while (listIterator.hasNext()) {
/*    */       continue;
/*    */       abstractInsnNode = listIterator.next();
/*    */     } 
/*    */     return beforeLoadLocal$SearchState.success(); }
/*    */ 
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\modify\BeforeLoadLocal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */