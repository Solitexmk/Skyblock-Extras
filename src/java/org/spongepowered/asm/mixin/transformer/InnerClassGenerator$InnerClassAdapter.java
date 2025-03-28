/*  1 */ package org.spongepowered.asm.mixin.transformer;class InnerClassGenerator$InnerClassAdapter extends ClassRemapper { public void visitInnerClass(String paramString1, String paramString2, String paramString3, int paramInt) { try { if (paramString1.startsWith(this.info.getOriginalName() + "$"))
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/*  8 */         throw new InvalidMixinException(this.info.getOwner(), "Found unsupported nested inner class " + paramString1 + " in " + this.info
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */             
/* 14 */             .getOriginalName()); }  } catch (InvalidMixinException invalidMixinException) { throw b(null); }
/*    */     
/*    */     super.visitInnerClass(paramString1, paramString2, paramString3, paramInt); }
/*    */ 
/*    */   
/*    */   private final InnerClassGenerator$InnerClassInfo info;
/*    */   
/*    */   private static InvalidMixinException b(InvalidMixinException paramInvalidMixinException) {
/*    */     return paramInvalidMixinException;
/*    */   }
/*    */   
/*    */   public void visitSource(String paramString1, String paramString2) {
/*    */     super.visitSource(paramString1, paramString2);
/*    */     AnnotationVisitor annotationVisitor = this.cv.visitAnnotation("Lorg/spongepowered/asm/mixin/transformer/meta/MixinInner;", false);
/*    */     annotationVisitor.visit("mixin", this.info.getOwner().toString());
/*    */     annotationVisitor.visit("name", this.info.getOriginalName().substring(this.info.getOriginalName().lastIndexOf('/') + 1));
/*    */     annotationVisitor.visitEnd();
/*    */   }
/*    */   
/*    */   public InnerClassGenerator$InnerClassAdapter(ClassVisitor paramClassVisitor, InnerClassGenerator$InnerClassInfo paramInnerClassGenerator$InnerClassInfo) {
/*    */     super(327680, paramClassVisitor, paramInnerClassGenerator$InnerClassInfo);
/*    */     this.info = paramInnerClassGenerator$InnerClassInfo;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\InnerClassGenerator$InnerClassAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */