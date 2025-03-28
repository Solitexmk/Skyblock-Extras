/*    */ package org.spongepowered.asm.mixin.transformer;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.ListIterator;
/*    */ import org.spongepowered.asm.lib.tree.AbstractInsnNode;
/*    */ import org.spongepowered.asm.lib.tree.FrameNode;
/*    */ import org.spongepowered.asm.lib.tree.MethodNode;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.gen.Accessor;
/*    */ import org.spongepowered.asm.mixin.gen.Invoker;
/*    */ import org.spongepowered.asm.util.Annotations;
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
/*    */ public class ClassInfo$Method
/*    */   extends ClassInfo$Member
/*    */ {
/*    */   private final List<ClassInfo$FrameData> frames;
/*    */   private boolean isAccessor;
/*    */   final ClassInfo this$0;
/*    */   
/*    */   public ClassInfo$Method(String paramString1, String paramString2, int paramInt) {
/* 42 */     super(ClassInfo$Member$Type.METHOD, paramString1, paramString2, paramInt, false);
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
/* 53 */     this.frames = null;
/*    */   } private List<ClassInfo$FrameData> gatherFrames(MethodNode paramMethodNode) {
/*    */     ArrayList<ClassInfo$FrameData> arrayList = new ArrayList();
/*    */     for (ListIterator<AbstractInsnNode> listIterator = paramMethodNode.instructions.iterator(); listIterator.hasNext(); ) {
/* 57 */       AbstractInsnNode abstractInsnNode = listIterator.next();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       try {
/* 64 */         if (abstractInsnNode instanceof FrameNode)
/*    */           arrayList.add(new ClassInfo$FrameData(paramMethodNode.instructions.indexOf(abstractInsnNode), (FrameNode)abstractInsnNode)); 
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw c(null);
/*    */       } 
/*    */     } 
/*    */     return arrayList;
/*    */   }
/*    */   
/*    */   public ClassInfo$Method(MethodNode paramMethodNode, boolean paramBoolean) {
/*    */     super(ClassInfo$Member$Type.METHOD, paramMethodNode.name, paramMethodNode.desc, paramMethodNode.access, paramBoolean);
/*    */     this.frames = gatherFrames(paramMethodNode);
/*    */     try {
/*    */       setUnique((Annotations.getVisible(paramMethodNode, Unique.class) != null));
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw c(null);
/*    */     } 
/*    */     this.isAccessor = (Annotations.getSingleVisible(paramMethodNode, new Class[] { Accessor.class, Invoker.class }) != null);
/*    */   }
/*    */   
/*    */   public ClassInfo$Method(ClassInfo$Member paramClassInfo$Member) {
/*    */     super(paramClassInfo$Member);
/*    */     this.frames = (paramClassInfo$Member instanceof ClassInfo$Method) ? ((ClassInfo$Method)paramClassInfo$Member).frames : null;
/*    */   }
/*    */   
/*    */   public List<ClassInfo$FrameData> getFrames() {
/*    */     return this.frames;
/*    */   }
/*    */   
/*    */   public ClassInfo getOwner() {
/*    */     return ClassInfo.this;
/*    */   }
/*    */   
/*    */   public ClassInfo$Method(String paramString1, String paramString2) {
/*    */     super(ClassInfo$Member$Type.METHOD, paramString1, paramString2, 1, false);
/*    */     this.frames = null;
/*    */   }
/*    */   
/*    */   public boolean equals(Object paramObject) {
/*    */     try {
/*    */       if (!(paramObject instanceof ClassInfo$Method))
/*    */         return false; 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw c(null);
/*    */     } 
/*    */     return super.equals(paramObject);
/*    */   }
/*    */   
/*    */   public ClassInfo$Method(String paramString1, String paramString2, int paramInt, boolean paramBoolean) {
/*    */     super(ClassInfo$Member$Type.METHOD, paramString1, paramString2, paramInt, paramBoolean);
/*    */     this.frames = null;
/*    */   }
/*    */   
/*    */   public ClassInfo$Method(MethodNode paramMethodNode) {
/*    */     this(paramMethodNode, false);
/*    */     try {
/*    */       setUnique((Annotations.getVisible(paramMethodNode, Unique.class) != null));
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw c(null);
/*    */     } 
/*    */     this.isAccessor = (Annotations.getSingleVisible(paramMethodNode, new Class[] { Accessor.class, Invoker.class }) != null);
/*    */   }
/*    */   
/*    */   public boolean isAccessor() {
/*    */     return this.isAccessor;
/*    */   }
/*    */   
/*    */   private static RuntimeException c(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\ClassInfo$Method.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */