/*   */ package org.spongepowered.asm.util.asm;
/* 2 */ public class MethodVisitorEx extends MethodVisitor { public MethodVisitorEx(MethodVisitor paramMethodVisitor) { super(327680, paramMethodVisitor); } public void visitConstant(byte paramByte) { 
/* 3 */     try { if (paramByte > -2) try { if (paramByte < 6)
/*   */           
/* 5 */           { visitInsn(Bytecode.CONSTANTS_INT[paramByte + 1]); return; }  }
/* 6 */         catch (RuntimeException runtimeException) { throw b(null); }   } catch (RuntimeException runtimeException) { throw b(null); }
/* 7 */      visitIntInsn(16, paramByte); }
/*   */ 
/*   */   
/*   */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*   */     return paramRuntimeException;
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\asm\MethodVisitorEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */