/*  1 */ package org.spongepowered.asm.transformers;public abstract class TreeTransformer implements ILegacyClassTransformer { private ClassReader classReader; private ClassNode classNode; protected final byte[] writeClass(ClassNode paramClassNode) { try { if (this.classReader != null && this.classNode == paramClassNode)
/*    */       
/*    */       { 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 13 */         this.classNode = null;
/*    */         
/* 15 */         MixinClassWriter mixinClassWriter1 = new MixinClassWriter(this.classReader, 3); this.classReader = null; paramClassNode.accept((ClassVisitor)mixinClassWriter1); return mixinClassWriter1.toByteArray(); }  }
/*    */     catch (RuntimeException runtimeException) { throw b(null); }
/* 17 */      this.classNode = null; MixinClassWriter mixinClassWriter = new MixinClassWriter(3); paramClassNode.accept((ClassVisitor)mixinClassWriter); return mixinClassWriter.toByteArray(); } protected final ClassNode readClass(byte[] paramArrayOfbyte, boolean paramBoolean) { ClassReader classReader = new ClassReader(paramArrayOfbyte); try { if (paramBoolean)
/* 18 */         this.classReader = classReader;  } catch (RuntimeException runtimeException) { throw b(null); }  ClassNode classNode = new ClassNode(); classReader.accept((ClassVisitor)classNode, 8); return classNode; }
/*    */ 
/*    */   
/*    */   protected final ClassNode readClass(byte[] paramArrayOfbyte) {
/*    */     return readClass(paramArrayOfbyte, true);
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\transformers\TreeTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */