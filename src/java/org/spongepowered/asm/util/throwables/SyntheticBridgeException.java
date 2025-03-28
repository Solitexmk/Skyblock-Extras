/*     */ package org.spongepowered.asm.util.throwables;public class SyntheticBridgeException extends MixinException { private PrettyPrinter printProblem(PrettyPrinter paramPrettyPrinter, IMixinContext paramIMixinContext, MethodNode paramMethodNode1, MethodNode paramMethodNode2) {
/*   2 */     Type type = Type.getObjectType(paramIMixinContext.getTargetClassRef());
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*     */       ListIterator<AbstractInsnNode> listIterator1, listIterator2;
/*     */ 
/*     */ 
/*     */       
/*     */       Type[] arrayOfType1, arrayOfType2;
/*     */ 
/*     */ 
/*     */       
/*     */       boolean bool;
/*     */ 
/*     */ 
/*     */       
/*     */       Type type1, type2;
/*     */ 
/*     */ 
/*     */       
/*     */       MethodInsnNode methodInsnNode1, methodInsnNode2;
/*     */ 
/*     */ 
/*     */       
/*     */       Type arrayOfType3[], arrayOfType4[], type3, type4;
/*     */ 
/*     */ 
/*     */       
/*     */       byte b;
/*     */ 
/*     */       
/*  34 */       paramPrettyPrinter.add("Analysis").add();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  65 */       switch (SyntheticBridgeException$1.$SwitchMap$org$spongepowered$asm$util$throwables$SyntheticBridgeException$Problem[this.problem.ordinal()]) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 1:
/* 113 */           paramPrettyPrinter.add("The bridge methods are not compatible because they contain incompatible opcodes");
/*     */           paramPrettyPrinter.add("at index " + this.index + ":").add();
/*     */           paramPrettyPrinter.kv("Existing opcode: %s", Bytecode.getOpcodeName(this.a));
/*     */           paramPrettyPrinter.kv("Incoming opcode: %s", Bytecode.getOpcodeName(this.b)).add();
/*     */           paramPrettyPrinter.add("This implies that the bridge methods are from different interfaces. This problem");
/*     */           paramPrettyPrinter.add("may not be resolvable without changing the base interfaces.").add();
/*     */           break;
/*     */         case 2:
/*     */           paramPrettyPrinter.add("The bridge methods are not compatible because they contain different variables at");
/*     */           paramPrettyPrinter.add("opcode index " + this.index + ".").add();
/*     */           listIterator1 = paramMethodNode1.instructions.iterator();
/*     */           listIterator2 = paramMethodNode2.instructions.iterator();
/*     */           arrayOfType1 = Type.getArgumentTypes(paramMethodNode1.desc);
/*     */           arrayOfType2 = Type.getArgumentTypes(paramMethodNode2.desc);
/*     */           bool = false;
/*     */           for (;; abstractInsnNode = listIterator2.next()) {
/*     */             try {
/*     */               if (listIterator1.hasNext() && listIterator2.hasNext()) {
/*     */                 AbstractInsnNode abstractInsnNode = listIterator1.next();
/*     */                 continue;
/*     */               } 
/*     */             } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */               throw b(null);
/*     */             } 
/*     */             break;
/*     */           } 
/*     */           paramPrettyPrinter.add("Since this probably means that the methods come from different interfaces, you");
/*     */           paramPrettyPrinter.add("may have a \"multiple inheritance\" problem, it may not be possible to implement");
/*     */           paramPrettyPrinter.add("both root interfaces");
/*     */           break;
/*     */         case 3:
/*     */           paramPrettyPrinter.add("Incompatible CHECKCAST encountered at opcode " + this.index + ", this could indicate that the bridge");
/*     */           paramPrettyPrinter.add("is casting down for contravariant generic types. It may be possible to coalesce the");
/*     */           paramPrettyPrinter.add("bridges by adjusting the types in the target method.").add();
/*     */           type1 = Type.getObjectType(((TypeInsnNode)this.a).desc);
/*     */           type2 = Type.getObjectType(((TypeInsnNode)this.b).desc);
/*     */           paramPrettyPrinter.kv("Target type", type1);
/*     */           paramPrettyPrinter.kv("Incoming type", type2);
/*     */           paramPrettyPrinter.kv("Common supertype", ClassInfo.getCommonSuperClassOrInterface(type1, type2)).add();
/*     */           break;
/*     */         case 4:
/*     */           paramPrettyPrinter.add("Incompatible invocation targets in synthetic bridge. This is extremely unusual");
/*     */           paramPrettyPrinter.add("and implies that a remapping transformer has incorrectly remapped a method. This");
/*     */           paramPrettyPrinter.add("is an unrecoverable error.");
/*     */           break;
/*     */         case 5:
/*     */           methodInsnNode1 = (MethodInsnNode)this.a;
/*     */           methodInsnNode2 = (MethodInsnNode)this.b;
/*     */           arrayOfType3 = Type.getArgumentTypes(methodInsnNode1.desc);
/*     */           arrayOfType4 = Type.getArgumentTypes(methodInsnNode2.desc);
/*     */           if (arrayOfType3.length != arrayOfType4.length) {
/*     */             int i = (Type.getArgumentTypes(paramMethodNode1.desc)).length;
/*     */             try {
/*     */               try {
/*     */               
/*     */               } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */                 throw b(null);
/*     */               } 
/*     */             } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */               throw b(null);
/*     */             } 
/*     */           } 
/*     */           type3 = Type.getReturnType(methodInsnNode1.desc);
/*     */           type4 = Type.getReturnType(methodInsnNode2.desc);
/*     */           paramPrettyPrinter.add("Incompatible invocation descriptors in synthetic bridge implies that generified");
/*     */           paramPrettyPrinter.add("types are incompatible over one or more generic superclasses or interfaces. It may");
/*     */           paramPrettyPrinter.add("be possible to adjust the generic types on implemented members to rectify this");
/*     */           paramPrettyPrinter.add("problem by coalescing the appropriate generic types.").add();
/*     */           printTypeComparison(paramPrettyPrinter, "return type", type3, type4);
/*     */           b = 0;
/*     */           try {
/*     */             for (; b < arrayOfType3.length; b++)
/*     */               printTypeComparison(paramPrettyPrinter, "arg " + b, arrayOfType3[b], arrayOfType4[b]); 
/*     */           } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */             throw b(null);
/*     */           } 
/*     */           break;
/*     */         case 6:
/*     */           paramPrettyPrinter.add("Mismatched bridge method length implies the bridge methods are incompatible");
/*     */           paramPrettyPrinter.add("and may originate from different superinterfaces. This is an unrecoverable");
/*     */           paramPrettyPrinter.add("error.").add();
/*     */           break;
/*     */       } 
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return paramPrettyPrinter;
/*     */   }
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final SyntheticBridgeException$Problem problem;
/*     */   private final String name;
/*     */   private final String desc;
/*     */   private final int index;
/*     */   private final AbstractInsnNode a;
/*     */   private final AbstractInsnNode b;
/*     */   
/*     */   private PrettyPrinter printMethod(PrettyPrinter paramPrettyPrinter, MethodNode paramMethodNode) {
/*     */     byte b = 0;
/*     */     ListIterator<AbstractInsnNode> listIterator = paramMethodNode.instructions.iterator();
/*     */     while (true) {
/*     */       try {
/*     */         if (listIterator.hasNext()) {
/*     */           try {
/*     */           
/*     */           } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */             throw b(null);
/*     */           } 
/*     */           paramPrettyPrinter.kv((b == this.index) ? ">>>>" : "", Bytecode.describeNode(listIterator.next()));
/*     */           b++;
/*     */           continue;
/*     */         } 
/*     */       } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */         throw b(null);
/*     */       } 
/*     */       break;
/*     */     } 
/*     */     return paramPrettyPrinter.add();
/*     */   }
/*     */   
/*     */   public void printAnalysis(IMixinContext paramIMixinContext, MethodNode paramMethodNode1, MethodNode paramMethodNode2) {
/*     */     PrettyPrinter prettyPrinter = new PrettyPrinter();
/*     */     prettyPrinter.addWrapped(100, getMessage(), new Object[0]).hr();
/*     */     prettyPrinter.add().kv("Method", this.name + this.desc).kv("Problem Type", this.problem).add().hr();
/*     */     String str1 = (String)Annotations.getValue(Annotations.getVisible(paramMethodNode1, MixinMerged.class), "mixin");
/*     */     try {
/*     */     
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     String str2 = (str1 != null) ? str1 : paramIMixinContext.getTargetClassRef().replace('/', '.');
/*     */     printMethod(prettyPrinter.add("Existing method").add().kv("Owner", str2).add(), paramMethodNode1).hr();
/*     */     printMethod(prettyPrinter.add("Incoming method").add().kv("Owner", paramIMixinContext.getClassRef().replace('/', '.')).add(), paramMethodNode2).hr();
/*     */     printProblem(prettyPrinter, paramIMixinContext, paramMethodNode1, paramMethodNode2).print(System.err);
/*     */   }
/*     */   
/*     */   public SyntheticBridgeException(SyntheticBridgeException$Problem paramSyntheticBridgeException$Problem, String paramString1, String paramString2, int paramInt, AbstractInsnNode paramAbstractInsnNode1, AbstractInsnNode paramAbstractInsnNode2) {
/*     */     super(paramSyntheticBridgeException$Problem.getMessage(paramString1, paramString2, paramInt, paramAbstractInsnNode1, paramAbstractInsnNode2));
/*     */     this.problem = paramSyntheticBridgeException$Problem;
/*     */     this.name = paramString1;
/*     */     this.desc = paramString2;
/*     */     this.index = paramInt;
/*     */     this.a = paramAbstractInsnNode1;
/*     */     this.b = paramAbstractInsnNode2;
/*     */   }
/*     */   
/*     */   private PrettyPrinter printTypeComparison(PrettyPrinter paramPrettyPrinter, String paramString, Type paramType1, Type paramType2) {
/*     */     try {
/*     */       paramPrettyPrinter.kv("Target " + paramString, "%s", new Object[] { paramType1 });
/*     */       paramPrettyPrinter.kv("Incoming " + paramString, "%s", new Object[] { paramType2 });
/*     */       if (paramType1.equals(paramType2)) {
/*     */         paramPrettyPrinter.kv("Analysis", "Types match: %s", new Object[] { paramType1 });
/*     */       } else {
/*     */         try {
/*     */           if (paramType1.getSort() != paramType2.getSort()) {
/*     */             paramPrettyPrinter.kv("Analysis", "Types are incompatible");
/*     */           } else if (paramType1.getSort() == 10) {
/*     */             ClassInfo classInfo = ClassInfo.getCommonSuperClassOrInterface(paramType1, paramType2);
/*     */             paramPrettyPrinter.kv("Analysis", "Common supertype: L%s;", new Object[] { classInfo });
/*     */           } 
/*     */         } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */           throw b(null);
/*     */         } 
/*     */       } 
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return paramPrettyPrinter.add();
/*     */   }
/*     */   
/*     */   private static SyntheticBridgeException b(SyntheticBridgeException paramSyntheticBridgeException) {
/*     */     return paramSyntheticBridgeException;
/*     */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\throwables\SyntheticBridgeException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */