/*     */ package org.spongepowered.asm.util;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import org.spongepowered.asm.lib.Type;
/*     */ import org.spongepowered.asm.lib.tree.AbstractInsnNode;
/*     */ import org.spongepowered.asm.lib.tree.ClassNode;
/*     */ import org.spongepowered.asm.lib.tree.InsnList;
/*     */ import org.spongepowered.asm.lib.tree.LabelNode;
/*     */ import org.spongepowered.asm.lib.tree.LocalVariableNode;
/*     */ import org.spongepowered.asm.lib.tree.MethodNode;
/*     */ import org.spongepowered.asm.lib.tree.analysis.Analyzer;
/*     */ import org.spongepowered.asm.lib.tree.analysis.AnalyzerException;
/*     */ import org.spongepowered.asm.lib.tree.analysis.BasicValue;
/*     */ import org.spongepowered.asm.lib.tree.analysis.Frame;
/*     */ import org.spongepowered.asm.mixin.transformer.ClassInfo;
/*     */ import org.spongepowered.asm.util.throwables.LVTGeneratorException;
/*     */ 
/*     */ public final class Locals {
/*     */   public static void loadLocals(Type[] paramArrayOfType, InsnList paramInsnList, int paramInt1, int paramInt2) { while (true) {
/*     */       
/*  23 */       try { if (paramInt1 < paramArrayOfType.length) try { if (paramInt2 > 0) {
/*     */ 
/*     */ 
/*     */               
/*     */               try { 
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
/* 131 */                 if (paramArrayOfType[paramInt1] != null)
/*     */                 { paramInsnList.add((AbstractInsnNode)new VarInsnNode(paramArrayOfType[paramInt1].getOpcode(21), paramInt1));
/* 133 */                   paramInt2--; }  } catch (LVTGeneratorException lVTGeneratorException) { throw b(null); }
/*     */                paramInt1++; continue;
/*     */             }  }
/*     */           catch (LVTGeneratorException lVTGeneratorException) { throw b(null); }
/*     */             }
/*     */       catch (LVTGeneratorException lVTGeneratorException) { throw b(null); }
/*     */        break;
/*     */     }  } public static LocalVariableNode[] getLocalsAt(ClassNode paramClassNode, MethodNode paramMethodNode, AbstractInsnNode paramAbstractInsnNode) { byte b1 = 0; while (true) { try { if (b1 < 3) {
/* 141 */           try { if (paramAbstractInsnNode instanceof LabelNode || paramAbstractInsnNode instanceof org.spongepowered.asm.lib.tree.LineNumberNode) { paramAbstractInsnNode = nextNode(paramMethodNode.instructions, paramAbstractInsnNode);
/*     */ 
/*     */               
/*     */               b1++;
/*     */ 
/*     */               
/*     */               continue; }
/*     */              }
/*     */           catch (LVTGeneratorException lVTGeneratorException)
/*     */           { throw b(null); }
/*     */         
/*     */         } }
/*     */       catch (LVTGeneratorException lVTGeneratorException)
/*     */       { throw b(null); }
/*     */ 
/*     */ 
/*     */       
/*     */       break; }
/*     */ 
/*     */ 
/*     */     
/*     */     ClassInfo classInfo = ClassInfo.forName(paramClassNode.name);
/*     */ 
/*     */ 
/*     */     
/*     */     try { if (classInfo == null)
/* 167 */         throw new LVTGeneratorException("Could not load class metadata for " + paramClassNode.name + " generating LVT for " + paramMethodNode.name);  } catch (LVTGeneratorException lVTGeneratorException) { throw b(null); }  ClassInfo.Method method = classInfo.findMethod(paramMethodNode); try { if (method == null) throw new LVTGeneratorException("Could not locate method metadata for " + paramMethodNode.name + " generating LVT in " + paramClassNode.name);  } catch (LVTGeneratorException lVTGeneratorException) { throw b(null); }  List list = method.getFrames(); LocalVariableNode[] arrayOfLocalVariableNode = new LocalVariableNode[paramMethodNode.maxLocals]; int i = 0; byte b2 = 0; try { if ((paramMethodNode.access & 0x8) == 0) arrayOfLocalVariableNode[i++] = new LocalVariableNode("this", paramClassNode.name, null, null, null, 0);  } catch (LVTGeneratorException lVTGeneratorException) { throw b(null); }  int k; byte b3; for (Type[] arrayOfType = Type.getArgumentTypes(paramMethodNode.desc); b3 < k; ) { Type type = arrayOfType[b3]; arrayOfLocalVariableNode[i] = new LocalVariableNode("arg" + b2++, type.toString(), null, null, null, i); i += type.getSize(); b3++; }  int j = i; k = -1; b3 = 0; for (ListIterator<AbstractInsnNode> listIterator = paramMethodNode.instructions.iterator(); listIterator.hasNext();) abstractInsnNode = listIterator.next();  byte b4 = 0; while (true) { try { if (b4 < arrayOfLocalVariableNode.length) { try { if (arrayOfLocalVariableNode[b4] != null) try { if ((arrayOfLocalVariableNode[b4]).desc == null)
/* 168 */                   arrayOfLocalVariableNode[b4] = null;  } catch (LVTGeneratorException lVTGeneratorException) { throw b(null); }   } catch (LVTGeneratorException lVTGeneratorException) { throw b(null); }  b4++; }  } catch (LVTGeneratorException lVTGeneratorException) { throw b(null); }  return arrayOfLocalVariableNode; }  } public static LocalVariableNode getLocalVariableAt(ClassNode paramClassNode, MethodNode paramMethodNode, AbstractInsnNode paramAbstractInsnNode, int paramInt) { return getLocalVariableAt(paramClassNode, paramMethodNode, paramMethodNode.instructions.indexOf(paramAbstractInsnNode), paramInt); }
/*     */ 
/*     */   
/*     */   public static List<LocalVariableNode> generateLocalVariableTable(ClassNode paramClassNode, MethodNode paramMethodNode) {
/*     */     ArrayList<Type> arrayList = null;
/*     */     if (paramClassNode.interfaces != null) {
/*     */       arrayList = new ArrayList();
/*     */       for (String str : paramClassNode.interfaces)
/*     */         arrayList.add(Type.getObjectType(str)); 
/*     */     } 
/*     */     Type type = null;
/*     */     if (paramClassNode.superName != null)
/*     */       type = Type.getObjectType(paramClassNode.superName); 
/*     */     Analyzer analyzer = new Analyzer((Interpreter)new MixinVerifier(Type.getObjectType(paramClassNode.name), type, arrayList, false));
/*     */     try {
/*     */       analyzer.analyze(paramClassNode.name, paramMethodNode);
/*     */     } catch (AnalyzerException analyzerException) {
/*     */       analyzerException.printStackTrace();
/*     */     } 
/*     */     Frame[] arrayOfFrame = analyzer.getFrames();
/*     */     int i = paramMethodNode.instructions.size();
/*     */     ArrayList<LocalVariableNode> arrayList1 = new ArrayList();
/*     */     LocalVariableNode[] arrayOfLocalVariableNode = new LocalVariableNode[paramMethodNode.maxLocals];
/*     */     BasicValue[] arrayOfBasicValue = new BasicValue[paramMethodNode.maxLocals];
/*     */     LabelNode[] arrayOfLabelNode = new LabelNode[i];
/*     */     String[] arrayOfString = new String[paramMethodNode.maxLocals];
/*     */     for (byte b = 0; b < i; b++) {
/*     */       Frame frame = arrayOfFrame[b];
/*     */       try {
/*     */         if (frame != null) {
/*     */           Object object = null;
/*     */           for (byte b1 = 0; b1 < frame.getLocals(); ) {
/*     */             continue;
/*     */             basicValue = (BasicValue)frame.getLocal(b1);
/*     */           } 
/*     */         } 
/*     */       } catch (AnalyzerException analyzerException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     LabelNode labelNode = null;
/*     */     int j = 0;
/*     */     while (true) {
/*     */       try {
/*     */         if (j < arrayOfLocalVariableNode.length) {
/*     */           try {
/*     */             if (arrayOfLocalVariableNode[j] != null) {
/*     */               if (labelNode == null) {
/*     */                 labelNode = new LabelNode();
/*     */                 paramMethodNode.instructions.add((AbstractInsnNode)labelNode);
/*     */               } 
/*     */               (arrayOfLocalVariableNode[j]).end = labelNode;
/*     */               arrayList1.add(arrayOfLocalVariableNode[j]);
/*     */             } 
/*     */           } catch (AnalyzerException analyzerException) {
/*     */             throw b(null);
/*     */           } 
/*     */           j++;
/*     */           continue;
/*     */         } 
/*     */       } catch (AnalyzerException analyzerException) {
/*     */         throw b(null);
/*     */       } 
/*     */       break;
/*     */     } 
/*     */     j = i - 1;
/*     */     while (true) {
/*     */       try {
/*     */         if (j >= 0) {
/*     */           try {
/*     */             if (arrayOfLabelNode[j] != null)
/*     */               paramMethodNode.instructions.insert(paramMethodNode.instructions.get(j), (AbstractInsnNode)arrayOfLabelNode[j]); 
/*     */           } catch (AnalyzerException analyzerException) {
/*     */             throw b(null);
/*     */           } 
/*     */           j--;
/*     */         } 
/*     */       } catch (AnalyzerException analyzerException) {
/*     */         throw b(null);
/*     */       } 
/*     */       return arrayList1;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static List<LocalVariableNode> getLocalVariableTable(ClassNode paramClassNode, MethodNode paramMethodNode) {
/*     */     try {
/*     */       if (paramMethodNode.localVariables.isEmpty())
/*     */         return getGeneratedLocalVariableTable(paramClassNode, paramMethodNode); 
/*     */     } catch (LVTGeneratorException lVTGeneratorException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return paramMethodNode.localVariables;
/*     */   }
/*     */   
/*     */   private static AbstractInsnNode nextNode(InsnList paramInsnList, AbstractInsnNode paramAbstractInsnNode) {
/*     */     int i = paramInsnList.indexOf(paramAbstractInsnNode) + 1;
/*     */     try {
/*     */       if (i > 0)
/*     */         try {
/*     */           if (i < paramInsnList.size())
/*     */             return paramInsnList.get(i); 
/*     */         } catch (LVTGeneratorException lVTGeneratorException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (LVTGeneratorException lVTGeneratorException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return paramAbstractInsnNode;
/*     */   }
/*     */   
/*     */   public static List<LocalVariableNode> getGeneratedLocalVariableTable(ClassNode paramClassNode, MethodNode paramMethodNode) {
/*     */     String str = String.format("%s.%s%s", new Object[] { paramClassNode.name, paramMethodNode.name, paramMethodNode.desc });
/*     */     List<LocalVariableNode> list = calculatedLocalVariables.get(str);
/*     */     try {
/*     */       if (list != null)
/*     */         return list; 
/*     */     } catch (LVTGeneratorException lVTGeneratorException) {
/*     */       throw b(null);
/*     */     } 
/*     */     list = generateLocalVariableTable(paramClassNode, paramMethodNode);
/*     */     calculatedLocalVariables.put(str, list);
/*     */     return list;
/*     */   }
/*     */   
/*     */   private static final Map<String, List<LocalVariableNode>> calculatedLocalVariables = new HashMap<String, List<LocalVariableNode>>();
/*     */   
/*     */   private static boolean isOpcodeInRange(InsnList paramInsnList, LocalVariableNode paramLocalVariableNode, int paramInt) {
/*     */     try {
/*     */       if (paramInsnList.indexOf((AbstractInsnNode)paramLocalVariableNode.start) < paramInt)
/*     */         try {
/*     */           if (paramInsnList.indexOf((AbstractInsnNode)paramLocalVariableNode.end) > paramInt);
/*     */         } catch (LVTGeneratorException lVTGeneratorException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (LVTGeneratorException lVTGeneratorException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   private static LocalVariableNode getLocalVariableAt(ClassNode paramClassNode, MethodNode paramMethodNode, int paramInt1, int paramInt2) {
/*     */     // Byte code:
/*     */     //   0: aconst_null
/*     */     //   1: astore #4
/*     */     //   3: aconst_null
/*     */     //   4: astore #5
/*     */     //   6: aload_0
/*     */     //   7: aload_1
/*     */     //   8: invokestatic getLocalVariableTable : (Lorg/spongepowered/asm/lib/tree/ClassNode;Lorg/spongepowered/asm/lib/tree/MethodNode;)Ljava/util/List;
/*     */     //   11: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   16: astore #6
/*     */     //   18: aload #6
/*     */     //   20: invokeinterface hasNext : ()Z
/*     */     //   25: ifeq -> 88
/*     */     //   28: aload #6
/*     */     //   30: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   35: checkcast org/spongepowered/asm/lib/tree/LocalVariableNode
/*     */     //   38: astore #7
/*     */     //   40: aload #7
/*     */     //   42: getfield index : I
/*     */     //   45: iload_3
/*     */     //   46: if_icmpeq -> 56
/*     */     //   49: goto -> 18
/*     */     //   52: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   55: athrow
/*     */     //   56: aload_1
/*     */     //   57: getfield instructions : Lorg/spongepowered/asm/lib/tree/InsnList;
/*     */     //   60: aload #7
/*     */     //   62: iload_2
/*     */     //   63: invokestatic isOpcodeInRange : (Lorg/spongepowered/asm/lib/tree/InsnList;Lorg/spongepowered/asm/lib/tree/LocalVariableNode;I)Z
/*     */     //   66: ifeq -> 76
/*     */     //   69: aload #7
/*     */     //   71: astore #4
/*     */     //   73: goto -> 85
/*     */     //   76: aload #4
/*     */     //   78: ifnonnull -> 85
/*     */     //   81: aload #7
/*     */     //   83: astore #5
/*     */     //   85: goto -> 18
/*     */     //   88: aload #4
/*     */     //   90: ifnonnull -> 182
/*     */     //   93: aload_1
/*     */     //   94: getfield localVariables : Ljava/util/List;
/*     */     //   97: invokeinterface isEmpty : ()Z
/*     */     //   102: ifne -> 182
/*     */     //   105: goto -> 112
/*     */     //   108: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   111: athrow
/*     */     //   112: aload_0
/*     */     //   113: aload_1
/*     */     //   114: invokestatic getGeneratedLocalVariableTable : (Lorg/spongepowered/asm/lib/tree/ClassNode;Lorg/spongepowered/asm/lib/tree/MethodNode;)Ljava/util/List;
/*     */     //   117: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   122: astore #6
/*     */     //   124: aload #6
/*     */     //   126: invokeinterface hasNext : ()Z
/*     */     //   131: ifeq -> 182
/*     */     //   134: aload #6
/*     */     //   136: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   141: checkcast org/spongepowered/asm/lib/tree/LocalVariableNode
/*     */     //   144: astore #7
/*     */     //   146: aload #7
/*     */     //   148: getfield index : I
/*     */     //   151: iload_3
/*     */     //   152: if_icmpne -> 179
/*     */     //   155: aload_1
/*     */     //   156: getfield instructions : Lorg/spongepowered/asm/lib/tree/InsnList;
/*     */     //   159: aload #7
/*     */     //   161: iload_2
/*     */     //   162: invokestatic isOpcodeInRange : (Lorg/spongepowered/asm/lib/tree/InsnList;Lorg/spongepowered/asm/lib/tree/LocalVariableNode;I)Z
/*     */     //   165: ifeq -> 179
/*     */     //   168: goto -> 175
/*     */     //   171: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   174: athrow
/*     */     //   175: aload #7
/*     */     //   177: astore #4
/*     */     //   179: goto -> 124
/*     */     //   182: aload #4
/*     */     //   184: ifnull -> 196
/*     */     //   187: aload #4
/*     */     //   189: goto -> 198
/*     */     //   192: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   195: athrow
/*     */     //   196: aload #5
/*     */     //   198: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #163	-> 0
/*     */     //   #100	-> 3
/*     */     //   #61	-> 6
/*     */     //   #78	-> 40
/*     */     //   #70	-> 49
/*     */     //   #161	-> 56
/*     */     //   #9	-> 69
/*     */     //   #125	-> 76
/*     */     //   #82	-> 81
/*     */     //   #52	-> 85
/*     */     //   #116	-> 88
/*     */     //   #47	-> 112
/*     */     //   #64	-> 146
/*     */     //   #80	-> 175
/*     */     //   #25	-> 179
/*     */     //   #18	-> 182
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   40	52	52	org/spongepowered/asm/util/throwables/LVTGeneratorException
/*     */     //   88	105	108	org/spongepowered/asm/util/throwables/LVTGeneratorException
/*     */     //   146	168	171	org/spongepowered/asm/util/throwables/LVTGeneratorException
/*     */     //   182	192	192	org/spongepowered/asm/util/throwables/LVTGeneratorException
/*     */   }
/*     */   
/*     */   private static Exception b(Exception paramException) {
/*     */     return paramException;
/*     */   }
/*     */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\Locals.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */