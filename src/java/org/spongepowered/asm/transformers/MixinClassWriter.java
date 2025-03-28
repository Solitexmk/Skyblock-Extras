/* 1 */ package org.spongepowered.asm.transformers;public class MixinClassWriter extends ClassWriter { public MixinClassWriter(int paramInt) { super(paramInt); } public MixinClassWriter(ClassReader paramClassReader, int paramInt) {
/* 2 */     super(paramClassReader, paramInt);
/*   */   } protected String getCommonSuperClass(String paramString1, String paramString2) {
/* 4 */     return ClassInfo.getCommonSuperClass(paramString1, paramString2).getName();
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\transformers\MixinClassWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */