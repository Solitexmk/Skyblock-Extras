/*    */ package org.spongepowered.asm.mixin.struct;
/*  2 */ public class SourceMap$File { public final int id; public final int lineOffset; public void applyOffset(ClassNode paramClassNode) { for (MethodNode methodNode : paramClassNode.methods)
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
/* 26 */       applyOffset(methodNode); }  }
/*    */   public final int size; public final String sourceFileName; public final String sourceFilePath; public void applyOffset(MethodNode paramMethodNode) { for (ListIterator<AbstractInsnNode> listIterator = paramMethodNode.instructions.iterator(); listIterator.hasNext(); ) { AbstractInsnNode abstractInsnNode = listIterator.next(); try { if (abstractInsnNode instanceof LineNumberNode)
/* 28 */           ((LineNumberNode)abstractInsnNode).line += this.lineOffset - 1;  } catch (RuntimeException runtimeException) { throw b(null); }  }  } public void appendLines(StringBuilder paramStringBuilder) { paramStringBuilder.append("1#").append(this.id).append(",").append(this.size).append(":").append(this.lineOffset).append("\n"); }
/*    */ 
/*    */   
/*    */   public SourceMap$File(int paramInt1, int paramInt2, int paramInt3, String paramString) {
/*    */     this(paramInt1, paramInt2, paramInt3, paramString, null);
/*    */   }
/*    */   
/*    */   public SourceMap$File(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2) {
/*    */     this.id = paramInt1;
/*    */     this.lineOffset = paramInt2;
/*    */     this.size = paramInt3;
/*    */     this.sourceFileName = paramString1;
/*    */     this.sourceFilePath = paramString2;
/*    */   }
/*    */   
/*    */   void appendFile(StringBuilder paramStringBuilder) {
/*    */     try {
/*    */       if (this.sourceFilePath != null) {
/*    */         paramStringBuilder.append("+ ").append(this.id).append(" ").append(this.sourceFileName).append("\n");
/*    */         paramStringBuilder.append(this.sourceFilePath).append("\n");
/*    */       } 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     paramStringBuilder.append(this.id).append(" ").append(this.sourceFileName).append("\n");
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\struct\SourceMap$File.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */