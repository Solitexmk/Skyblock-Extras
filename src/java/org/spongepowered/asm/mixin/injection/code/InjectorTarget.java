/*    */ package org.spongepowered.asm.mixin.injection.code;public class InjectorTarget { private final ISliceContext context;
/*    */   public MethodNode getMethod() {
/*  3 */     return this.target.method;
/*    */   }
/*  5 */   private final Map<String, ReadOnlyInsnList> cache = new HashMap<String, ReadOnlyInsnList>(); private final Target target;
/*    */   private final String mergedBy;
/*    */   private final int mergedPriority;
/*    */   
/*  9 */   public String toString() { return this.target.toString(); }
/* 10 */   public Target getTarget() { return this.target; }
/*    */   public String getMergedBy() { return this.mergedBy; }
/* 12 */   public InjectorTarget(ISliceContext paramISliceContext, Target paramTarget) { this.context = paramISliceContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 18 */     this.target = paramTarget;
/*    */     
/*    */     AnnotationNode annotationNode = Annotations.getVisible(paramTarget.method, MixinMerged.class);
/*    */     this.mergedBy = (String)Annotations.getValue(annotationNode, "mixin");
/* 22 */     this.mergedPriority = ((Integer)Annotations.getValue(annotationNode, "priority", Integer.valueOf(1000))).intValue(); }
/*    */   public boolean isMerged() { try {  } catch (RuntimeException runtimeException) { throw b(null); }  return (this.mergedBy != null); } public void dispose() { for (ReadOnlyInsnList readOnlyInsnList : this.cache.values())
/* 24 */       readOnlyInsnList.dispose();  this.cache.clear(); } public int getMergedPriority() { return this.mergedPriority; }
/*    */   public InsnList getSlice(String paramString) { ReadOnlyInsnList readOnlyInsnList = this.cache.get(paramString); if (readOnlyInsnList == null) {
/*    */       MethodSlice methodSlice = this.context.getSlice(paramString); if (methodSlice != null)
/* 27 */       { readOnlyInsnList = methodSlice.getSlice(this.target.method); }
/* 28 */       else { readOnlyInsnList = new ReadOnlyInsnList(this.target.method.instructions); }
/*    */     
/*    */     } 
/*    */     return readOnlyInsnList; }
/*    */ 
/*    */   
/*    */   public InsnList getSlice(InjectionPoint paramInjectionPoint) {
/*    */     return getSlice(paramInjectionPoint.getSlice());
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\code\InjectorTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */