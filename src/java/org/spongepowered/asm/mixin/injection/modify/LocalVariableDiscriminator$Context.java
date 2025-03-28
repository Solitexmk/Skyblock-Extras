/*    */ package org.spongepowered.asm.mixin.injection.modify;
/*    */ public class LocalVariableDiscriminator$Context implements PrettyPrinter.IPrettyPrintable { final Target target; final Type returnType;
/*    */   final AbstractInsnNode node;
/*    */   
/*  5 */   public void print(PrettyPrinter paramPrettyPrinter) { paramPrettyPrinter.add("%5s  %7s  %30s  %-50s  %s", new Object[] { "INDEX", "ORDINAL", "TYPE", "NAME", "CANDIDATE" });
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
/* 17 */     for (int i = this.baseArgIndex; i < this.locals.length;)
/*    */     {
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
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 45 */       localVariableDiscriminator$Context$Local = this.locals[i]; }  } final int baseArgIndex; final LocalVariableDiscriminator$Context$Local[] locals; private final boolean isStatic; private void initOrdinals() {
/*    */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*    */     for (byte b = 0; b < this.locals.length; ) {
/* 48 */       Integer integer = Integer.valueOf(0); if (this.locals[b] != null) { integer = (Integer)hashMap.get((this.locals[b]).type); try {  } catch (RuntimeException runtimeException) { throw b(null); }
/* 49 */          hashMap.put((this.locals[b]).type, integer = Integer.valueOf((integer == null) ? 0 : (integer.intValue() + 1))); (this.locals[b]).ord = integer.intValue(); }
/*    */     
/*    */     } 
/*    */   }
/*    */   
/*    */   public LocalVariableDiscriminator$Context(Type paramType, boolean paramBoolean, Target paramTarget, AbstractInsnNode paramAbstractInsnNode) {
/*    */     this.isStatic = Bytecode.methodIsStatic(paramTarget.method);
/*    */     this.returnType = paramType;
/*    */     this.target = paramTarget;
/*    */     this.node = paramAbstractInsnNode;
/*    */     this.baseArgIndex = this.isStatic ? 0 : 1;
/*    */     this.locals = initLocals(paramTarget, paramBoolean, paramAbstractInsnNode);
/*    */     initOrdinals();
/*    */   }
/*    */   
/*    */   private LocalVariableDiscriminator$Context$Local[] initLocals(Target paramTarget, boolean paramBoolean, AbstractInsnNode paramAbstractInsnNode) {
/*    */     if (!paramBoolean) {
/*    */       LocalVariableNode[] arrayOfLocalVariableNode = Locals.getLocalsAt(paramTarget.classNode, paramTarget.method, paramAbstractInsnNode);
/*    */       if (arrayOfLocalVariableNode != null) {
/*    */         LocalVariableDiscriminator$Context$Local[] arrayOfLocalVariableDiscriminator$Context$Local1 = new LocalVariableDiscriminator$Context$Local[arrayOfLocalVariableNode.length];
/*    */         byte b = 0;
/*    */         while (true) {
/*    */           try {
/*    */             if (b < arrayOfLocalVariableNode.length) {
/*    */               try {
/*    */                 if (arrayOfLocalVariableNode[b] != null)
/*    */                   arrayOfLocalVariableDiscriminator$Context$Local1[b] = new LocalVariableDiscriminator$Context$Local(this, (arrayOfLocalVariableNode[b]).name, Type.getType((arrayOfLocalVariableNode[b]).desc)); 
/*    */               } catch (RuntimeException runtimeException) {
/*    */                 throw b(null);
/*    */               } 
/*    */               b++;
/*    */             } 
/*    */           } catch (RuntimeException runtimeException) {
/*    */             throw b(null);
/*    */           } 
/*    */           break;
/*    */         } 
/*    */         return arrayOfLocalVariableDiscriminator$Context$Local1;
/*    */       } 
/*    */     } 
/*    */     LocalVariableDiscriminator$Context$Local[] arrayOfLocalVariableDiscriminator$Context$Local = new LocalVariableDiscriminator$Context$Local[this.baseArgIndex + paramTarget.arguments.length];
/*    */     try {
/*    */       if (!this.isStatic)
/*    */         arrayOfLocalVariableDiscriminator$Context$Local[0] = new LocalVariableDiscriminator$Context$Local(this, "this", Type.getType(paramTarget.classNode.name)); 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     for (int i = this.baseArgIndex; i < arrayOfLocalVariableDiscriminator$Context$Local.length; arrayOfLocalVariableDiscriminator$Context$Local[i] = new LocalVariableDiscriminator$Context$Local(this, "arg" + i, type), i++)
/*    */       Type type = paramTarget.arguments[i - this.baseArgIndex]; 
/*    */     return arrayOfLocalVariableDiscriminator$Context$Local;
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\modify\LocalVariableDiscriminator$Context.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */