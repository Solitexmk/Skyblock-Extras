/*  1 */ package org.spongepowered.asm.mixin.injection.code;public final class MethodSlice { public String getId() { return this.id; }
/*  2 */    private static final Logger logger = LogManager.getLogger("mixin"); private final ISliceContext owner; private final String id;
/*    */   private final InjectionPoint from;
/*    */   private final InjectionPoint to;
/*    */   private final String name;
/*    */   
/*    */   private static String getSliceName(String paramString) {
/*  8 */     return String.format("@Slice[%s]", new Object[] { Strings.nullToEmpty(paramString) });
/*    */   }
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
/*    */   private MethodSlice(ISliceContext paramISliceContext, String paramString, InjectionPoint paramInjectionPoint1, InjectionPoint paramInjectionPoint2) {
/* 46 */     if (paramInjectionPoint1 == null) try { if (paramInjectionPoint2 == null)
/*    */         {
/*    */           
/* 49 */           throw new InvalidSliceException(paramISliceContext, String.format("%s is redundant. No 'from' or 'to' value specified", new Object[] { this })); }  } catch (InvalidSliceException invalidSliceException) { throw b(null); }
/*    */     
/*    */     
/* 52 */     this.owner = paramISliceContext; this.id = Strings.nullToEmpty(paramString); this.from = paramInjectionPoint1;
/* 53 */     this.to = paramInjectionPoint2;
/*    */     this.name = getSliceName(paramString);
/*    */   }
/*    */   
/*    */   public ReadOnlyInsnList getSlice(MethodNode paramMethodNode) {
/*    */     int i = paramMethodNode.instructions.size() - 1;
/*    */     int j = find(paramMethodNode, this.from, 0, 0, this.name + "(from)");
/*    */     int k = find(paramMethodNode, this.to, i, j, this.name + "(to)");
/*    */     try {
/*    */       if (j > k)
/*    */         throw new InvalidSliceException(this.owner, String.format("%s is negative size. Range(%d -> %d)", new Object[] { describe(), Integer.valueOf(j), Integer.valueOf(k) })); 
/*    */     } catch (InvalidSliceException invalidSliceException) {
/*    */       throw b(null);
/*    */     } 
/*    */     try {
/*    */       if (j >= 0)
/*    */         try {
/*    */           if (k >= 0)
/*    */             try {
/*    */               if (j <= i)
/*    */                 try {
/*    */                   if (k <= i) {
/*    */                     try {
/*    */                       if (j == 0)
/*    */                         try {
/*    */                           if (k == i)
/*    */                             return new ReadOnlyInsnList(paramMethodNode.instructions); 
/*    */                         } catch (InvalidSliceException invalidSliceException) {
/*    */                           throw b(null);
/*    */                         }  
/*    */                     } catch (InvalidSliceException invalidSliceException) {
/*    */                       throw b(null);
/*    */                     } 
/*    */                     return new MethodSlice$InsnListSlice(paramMethodNode.instructions, j, k);
/*    */                   } 
/*    */                   throw new InjectionError("Unexpected critical error in " + this + ": out of bounds start=" + j + " end=" + k + " lim=" + i);
/*    */                 } catch (InvalidSliceException invalidSliceException) {
/*    */                   throw b(null);
/*    */                 }  
/*    */             } catch (InvalidSliceException invalidSliceException) {
/*    */               throw b(null);
/*    */             }  
/*    */         } catch (InvalidSliceException invalidSliceException) {
/*    */           throw b(null);
/*    */         }  
/*    */     } catch (InvalidSliceException invalidSliceException) {
/*    */       throw b(null);
/*    */     } 
/*    */     throw new InjectionError("Unexpected critical error in " + this + ": out of bounds start=" + j + " end=" + k + " lim=" + i);
/*    */   }
/*    */   
/*    */   public String toString() {
/*    */     return describe();
/*    */   }
/*    */   
/*    */   public static MethodSlice parse(ISliceContext paramISliceContext, Slice paramSlice) {
/*    */     String str = paramSlice.id();
/*    */     At at1 = paramSlice.from();
/*    */     At at2 = paramSlice.to();
/*    */     try {
/*    */     
/*    */     } catch (InvalidSliceException invalidSliceException) {
/*    */       throw b(null);
/*    */     } 
/*    */     InjectionPoint injectionPoint1 = (at1 != null) ? InjectionPoint.parse(paramISliceContext, at1) : null;
/*    */     try {
/*    */     
/*    */     } catch (InvalidSliceException invalidSliceException) {
/*    */       throw b(null);
/*    */     } 
/*    */     InjectionPoint injectionPoint2 = (at2 != null) ? InjectionPoint.parse(paramISliceContext, at2) : null;
/*    */     return new MethodSlice(paramISliceContext, str, injectionPoint1, injectionPoint2);
/*    */   }
/*    */   
/*    */   private String describe(String paramString) {
/*    */     return describeSlice(paramString, this.owner);
/*    */   }
/*    */   
/*    */   private static String describeSlice(String paramString, ISliceContext paramISliceContext) {
/*    */     String str = Bytecode.getSimpleName(paramISliceContext.getAnnotation());
/*    */     MethodNode methodNode = paramISliceContext.getMethod();
/*    */     return String.format("%s->%s(%s)::%s%s", new Object[] { paramISliceContext.getContext(), str, paramString, methodNode.name, methodNode.desc });
/*    */   }
/*    */   
/*    */   private int find(MethodNode paramMethodNode, InjectionPoint paramInjectionPoint, int paramInt1, int paramInt2, String paramString) {
/*    */     try {
/*    */       if (paramInjectionPoint == null)
/*    */         return paramInt1; 
/*    */     } catch (InvalidSliceException invalidSliceException) {
/*    */       throw b(null);
/*    */     } 
/*    */     LinkedList<AbstractInsnNode> linkedList = new LinkedList();
/*    */     ReadOnlyInsnList readOnlyInsnList = new ReadOnlyInsnList(paramMethodNode.instructions);
/*    */     boolean bool = paramInjectionPoint.find(paramMethodNode.desc, readOnlyInsnList, linkedList);
/*    */     InjectionPoint.Selector selector = paramInjectionPoint.getSelector();
/*    */     try {
/*    */       if (linkedList.size() != 1)
/*    */         try {
/*    */           if (selector == InjectionPoint.Selector.ONE)
/*    */             throw new InvalidSliceException(this.owner, String.format("%s requires 1 result but found %d", new Object[] { describe(paramString), Integer.valueOf(linkedList.size()) })); 
/*    */         } catch (InvalidSliceException invalidSliceException) {
/*    */           throw b(null);
/*    */         }  
/*    */     } catch (InvalidSliceException invalidSliceException) {
/*    */       throw b(null);
/*    */     } 
/*    */     try {
/*    */       if (!bool) {
/*    */         try {
/*    */           if (this.owner.getContext().getOption(MixinEnvironment.Option.DEBUG_VERBOSE))
/*    */             logger.warn("{} did not match any instructions", new Object[] { describe(paramString) }); 
/*    */         } catch (InvalidSliceException invalidSliceException) {
/*    */           throw b(null);
/*    */         } 
/*    */         return paramInt2;
/*    */       } 
/*    */     } catch (InvalidSliceException invalidSliceException) {
/*    */       throw b(null);
/*    */     } 
/*    */     try {
/*    */     
/*    */     } catch (InvalidSliceException invalidSliceException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return paramMethodNode.instructions.indexOf((selector == InjectionPoint.Selector.FIRST) ? linkedList.getFirst() : linkedList.getLast());
/*    */   }
/*    */   
/*    */   private String describe() {
/*    */     return describe(this.name);
/*    */   }
/*    */   
/*    */   public static MethodSlice parse(ISliceContext paramISliceContext, AnnotationNode paramAnnotationNode) {
/*    */     String str = (String)Annotations.getValue(paramAnnotationNode, "id");
/*    */     AnnotationNode annotationNode1 = (AnnotationNode)Annotations.getValue(paramAnnotationNode, "from");
/*    */     AnnotationNode annotationNode2 = (AnnotationNode)Annotations.getValue(paramAnnotationNode, "to");
/*    */     try {
/*    */     
/*    */     } catch (InvalidSliceException invalidSliceException) {
/*    */       throw b(null);
/*    */     } 
/*    */     InjectionPoint injectionPoint1 = (annotationNode1 != null) ? InjectionPoint.parse(paramISliceContext, annotationNode1) : null;
/*    */     try {
/*    */     
/*    */     } catch (InvalidSliceException invalidSliceException) {
/*    */       throw b(null);
/*    */     } 
/*    */     InjectionPoint injectionPoint2 = (annotationNode2 != null) ? InjectionPoint.parse(paramISliceContext, annotationNode2) : null;
/*    */     return new MethodSlice(paramISliceContext, str, injectionPoint1, injectionPoint2);
/*    */   }
/*    */   
/*    */   private static InvalidSliceException b(InvalidSliceException paramInvalidSliceException) {
/*    */     return paramInvalidSliceException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\code\MethodSlice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */