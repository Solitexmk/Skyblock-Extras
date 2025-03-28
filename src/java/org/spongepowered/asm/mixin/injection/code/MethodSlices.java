/*    */ package org.spongepowered.asm.mixin.injection.code;public final class MethodSlices {
/*    */   public MethodSlice get(String paramString) {
/*  3 */     return this.slices.get(paramString);
/*    */   }
/*    */   private final InjectionInfo info;
/*    */   private final Map<String, MethodSlice> slices;
/*    */   
/*    */   private MethodSlices(InjectionInfo paramInjectionInfo) {
/*  9 */     this.slices = new HashMap<String, MethodSlice>(4);
/* 10 */     this.info = paramInjectionInfo;
/*    */   } private void add(MethodSlice paramMethodSlice) {
/* 12 */     String str = this.info.getSliceId(paramMethodSlice.getId());
/*    */ 
/*    */     
/* 15 */     try { if (this.slices.containsKey(str))
/*    */       {
/*    */ 
/*    */         
/* 19 */         throw new InvalidSliceException(this.info, paramMethodSlice + " has a duplicate id, '" + str + "' was already defined"); }  } catch (InvalidSliceException invalidSliceException) { throw b(null); }
/*    */     
/*    */     this.slices.put(str, paramMethodSlice);
/*    */   }
/*    */   
/*    */   public static MethodSlices parse(InjectionInfo paramInjectionInfo) {
/*    */     MethodSlices methodSlices = new MethodSlices(paramInjectionInfo);
/*    */     AnnotationNode annotationNode = paramInjectionInfo.getAnnotation();
/*    */     if (annotationNode != null)
/*    */       for (AnnotationNode annotationNode1 : Annotations.getValue(annotationNode, "slice", true)) {
/*    */         MethodSlice methodSlice = MethodSlice.parse((ISliceContext)paramInjectionInfo, annotationNode1);
/*    */         methodSlices.add(methodSlice);
/*    */       }  
/*    */     return methodSlices;
/*    */   }
/*    */   
/*    */   public String toString() {
/*    */     return String.format("MethodSlices%s", new Object[] { this.slices.keySet() });
/*    */   }
/*    */   
/*    */   private static InvalidSliceException b(InvalidSliceException paramInvalidSliceException) {
/*    */     return paramInvalidSliceException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\code\MethodSlices.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */