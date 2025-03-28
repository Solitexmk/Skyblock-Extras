/*    */ package org.spongepowered.asm.mixin.injection.struct;public class ModifyConstantInjectionInfo extends InjectionInfo {
/*  2 */   private static final String CONSTANT_ANNOTATION_CLASS = Constant.class.getName().replace('.', '/');
/*    */   
/*  4 */   public String getSliceId(String paramString) { return Strings.nullToEmpty(paramString); } protected List<AnnotationNode> readInjectionPoints(String paramString) {
/*    */     ImmutableList immutableList;
/*  6 */     List<AnnotationNode> list = super.readInjectionPoints(paramString);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     if (list.isEmpty()) {
/*    */       AnnotationNode annotationNode = new AnnotationNode(CONSTANT_ANNOTATION_CLASS);
/*    */ 
/*    */ 
/*    */       
/* 16 */       annotationNode.visit("log", Boolean.TRUE);
/*    */       immutableList = ImmutableList.of(annotationNode);
/*    */     } 
/*    */     return (List<AnnotationNode>)immutableList;
/*    */   }
/*    */   
/*    */   protected String getDescription() {
/*    */     return "Constant modifier method";
/*    */   }
/*    */   
/*    */   public ModifyConstantInjectionInfo(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode, AnnotationNode paramAnnotationNode) {
/*    */     super(paramMixinTargetContext, paramMethodNode, paramAnnotationNode, "constant");
/*    */   }
/*    */   
/*    */   protected Injector parseInjector(AnnotationNode paramAnnotationNode) {
/*    */     return (Injector)new ModifyConstantInjector(this);
/*    */   }
/*    */   
/*    */   protected void parseInjectionPoints(List<AnnotationNode> paramList) {
/*    */     Type type = Type.getReturnType(this.method.desc);
/*    */     for (AnnotationNode annotationNode : paramList)
/*    */       this.injectionPoints.add(new BeforeConstant(getContext(), annotationNode, type.getDescriptor())); 
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\struct\ModifyConstantInjectionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */