/* 1 */ package org.spongepowered.asm.mixin.transformer;class MixinPostProcessor$1 extends ClassVisitor { public MethodVisitor visitMethod(int paramInt, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString) { if ((paramInt & 0x6) == 0)
/*   */     {
/*   */ 
/*   */ 
/*   */ 
/*   */       
/* 7 */       paramInt |= 0x1; } 
/* 8 */     return super.visitMethod(paramInt, paramString1, paramString2, paramString3, paramArrayOfString); } final MixinPostProcessor this$0; MixinPostProcessor$1(int paramInt, ClassVisitor paramClassVisitor) { super(paramInt, paramClassVisitor); }
/* 9 */   public void visit(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString) { super.visit(paramInt1, paramInt2 | 0x1, paramString1, paramString2, paramString3, paramArrayOfString); } public FieldVisitor visitField(int paramInt, String paramString1, String paramString2, String paramString3, Object paramObject) { if ((paramInt & 0x6) == 0)
/*   */       paramInt |= 0x1; 
/*   */     return super.visitField(paramInt, paramString1, paramString2, paramString3, paramObject); }
/*   */    }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MixinPostProcessor$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */