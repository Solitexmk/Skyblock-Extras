/*     */ package org.spongepowered.asm.util;
/*     */ public final class Bytecode {
/*     */   public static String getSimpleName(AnnotationNode paramAnnotationNode) {
/*   4 */     return getSimpleName(paramAnnotationNode.desc);
/*     */   }
/*   6 */   private static final Object[] CONSTANTS_VALUES = new Object[] { null, Integer.valueOf(-1), 
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
/* 176 */       Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), 
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
/* 224 */       Long.valueOf(0L), Long.valueOf(1L), Float.valueOf(0.0F), Float.valueOf(1.0F), Float.valueOf(2.0F), Double.valueOf(0.0D), Double.valueOf(1.0D) };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isMergeableAnnotation(AnnotationNode paramAnnotationNode) {
/*     */     try {
/*     */       if (paramAnnotationNode.desc.startsWith("L" + Constants.MIXIN_PACKAGE_REF)) {
/*     */         return mergeableAnnotationPattern.matcher(paramAnnotationNode.desc).matches();
/*     */       }
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getBoxingType(Type paramType) {
/*     */     try {
/*     */     
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return (paramType == null) ? null : BOXING_TYPES[paramType.getSort()];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getOpcodeName(AbstractInsnNode paramAbstractInsnNode) {
/*     */     try {
/*     */     
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return (paramAbstractInsnNode != null) ? getOpcodeName(paramAbstractInsnNode.getOpcode()) : "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final Class<?>[] MERGEABLE_MIXIN_ANNOTATIONS = new Class[] { Overwrite.class, Intrinsic.class, Final.class, Debug.class };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Bytecode$Visibility getVisibility(int paramInt) {
/*     */     try {
/*     */       if ((paramInt & 0x4) != 0) {
/*     */         return Bytecode$Visibility.PROTECTED;
/*     */       }
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     
/* 305 */     try { if ((paramInt & 0x2) != 0) return Bytecode$Visibility.PRIVATE;  } catch (SyntheticBridgeException syntheticBridgeException) { throw b(null); }  try { if ((paramInt & 0x1) != 0) return Bytecode$Visibility.PUBLIC;  } catch (SyntheticBridgeException syntheticBridgeException) { throw b(null); }  return Bytecode$Visibility.PACKAGE;
/* 306 */   } public static String generateDescriptor(Object paramObject, Object... paramVarArgs) { StringBuilder stringBuilder = (new StringBuilder()).append('('); Object[] arrayOfObject; int i; byte b; for (arrayOfObject = paramVarArgs, i = arrayOfObject.length, b = 0; b < i; stringBuilder.append(toDescriptor(object)), b++) Object object = arrayOfObject[b];  try {  } catch (SyntheticBridgeException syntheticBridgeException) { throw b(null); }  return stringBuilder.append(')').append((paramObject != null) ? toDescriptor(paramObject) : "V").toString(); } public static String getSimpleName(String paramString) { int i = Math.max(paramString.lastIndexOf('/'), 0); return paramString.substring(i + 1).replace(";", ""); } private static Pattern mergeableAnnotationPattern = getMergeableAnnotationPattern(); public static Type getConstantType(AbstractInsnNode paramAbstractInsnNode) { try { if (paramAbstractInsnNode == null) return null;  } catch (SyntheticBridgeException syntheticBridgeException) { throw b(null); }  if (paramAbstractInsnNode instanceof LdcInsnNode) { Object object = ((LdcInsnNode)paramAbstractInsnNode).cst; try { if (object instanceof Integer)
/* 307 */           return Type.getType("I");  } catch (SyntheticBridgeException syntheticBridgeException) { throw b(null); }  }  int i = Ints.indexOf(CONSTANTS_ALL, paramAbstractInsnNode.getOpcode()); try {  } catch (SyntheticBridgeException syntheticBridgeException) { throw b(null); }  return (i < 0) ? null : Type.getType(CONSTANTS_TYPES[i]); } public static void printNode(AbstractInsnNode paramAbstractInsnNode) { System.err.printf("%s\n", new Object[] { describeNode(paramAbstractInsnNode) }); }
/*     */ 
/*     */   
/*     */   private static List<AnnotationNode> mergeAnnotations(List<AnnotationNode> paramList1, List<AnnotationNode> paramList2, String paramString1, String paramString2) {
/*     */     try {
/*     */       if (paramList1 == null)
/*     */         return paramList2; 
/*     */       if (paramList2 == null)
/*     */         paramList2 = new ArrayList<AnnotationNode>(); 
/*     */       for (AnnotationNode annotationNode : paramList1) {
/*     */         try {
/*     */           if (!isMergeableAnnotation(annotationNode))
/*     */             continue; 
/*     */         } catch (Exception exception) {
/*     */           throw b(null);
/*     */         } 
/*     */         for (Iterator<AnnotationNode> iterator = paramList2.iterator(); iterator.hasNext();) {
/*     */           if (((AnnotationNode)iterator.next()).desc.equals(annotationNode.desc)) {
/*     */             iterator.remove();
/*     */             break;
/*     */           } 
/*     */         } 
/*     */         paramList2.add(annotationNode);
/*     */       } 
/*     */     } catch (Exception exception) {
/*     */       logger.warn("Exception encountered whilst merging annotations for {} {}", new Object[] { paramString1, paramString2 });
/*     */     } 
/*     */     return paramList2;
/*     */   }
/*     */   
/*     */   public static void mergeAnnotations(ClassNode paramClassNode1, ClassNode paramClassNode2) {
/*     */     paramClassNode2.visibleAnnotations = mergeAnnotations(paramClassNode1.visibleAnnotations, paramClassNode2.visibleAnnotations, "class", paramClassNode1.name);
/*     */     paramClassNode2.invisibleAnnotations = mergeAnnotations(paramClassNode1.invisibleAnnotations, paramClassNode2.invisibleAnnotations, "class", paramClassNode1.name);
/*     */   }
/*     */   
/*     */   public static void setVisibility(MethodNode paramMethodNode, Bytecode$Visibility paramBytecode$Visibility) {
/*     */     paramMethodNode.access = setVisibility(paramMethodNode.access, paramBytecode$Visibility.access);
/*     */   }
/*     */   
/*     */   private static String getOpcodeName(int paramInt1, String paramString, int paramInt2) {
/*     */     // Byte code:
/*     */     //   0: iload_0
/*     */     //   1: iload_2
/*     */     //   2: if_icmplt -> 113
/*     */     //   5: iconst_0
/*     */     //   6: istore_3
/*     */     //   7: ldc org/spongepowered/asm/lib/Opcodes
/*     */     //   9: invokevirtual getDeclaredFields : ()[Ljava/lang/reflect/Field;
/*     */     //   12: astore #4
/*     */     //   14: aload #4
/*     */     //   16: arraylength
/*     */     //   17: istore #5
/*     */     //   19: iconst_0
/*     */     //   20: istore #6
/*     */     //   22: iload #6
/*     */     //   24: iload #5
/*     */     //   26: if_icmpge -> 108
/*     */     //   29: aload #4
/*     */     //   31: iload #6
/*     */     //   33: aaload
/*     */     //   34: astore #7
/*     */     //   36: iload_3
/*     */     //   37: ifne -> 66
/*     */     //   40: aload #7
/*     */     //   42: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   45: aload_1
/*     */     //   46: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   49: ifne -> 66
/*     */     //   52: goto -> 59
/*     */     //   55: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   58: athrow
/*     */     //   59: goto -> 102
/*     */     //   62: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   65: athrow
/*     */     //   66: iconst_1
/*     */     //   67: istore_3
/*     */     //   68: aload #7
/*     */     //   70: invokevirtual getType : ()Ljava/lang/Class;
/*     */     //   73: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
/*     */     //   76: if_acmpne -> 102
/*     */     //   79: aload #7
/*     */     //   81: aconst_null
/*     */     //   82: invokevirtual getInt : (Ljava/lang/Object;)I
/*     */     //   85: iload_0
/*     */     //   86: if_icmpne -> 102
/*     */     //   89: goto -> 96
/*     */     //   92: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   95: athrow
/*     */     //   96: aload #7
/*     */     //   98: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   101: areturn
/*     */     //   102: iinc #6, 1
/*     */     //   105: goto -> 22
/*     */     //   108: goto -> 113
/*     */     //   111: astore #4
/*     */     //   113: iload_0
/*     */     //   114: iflt -> 128
/*     */     //   117: iload_0
/*     */     //   118: invokestatic valueOf : (I)Ljava/lang/String;
/*     */     //   121: goto -> 130
/*     */     //   124: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   127: athrow
/*     */     //   128: ldc 'UNKNOWN'
/*     */     //   130: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #41	-> 0
/*     */     //   #215	-> 5
/*     */     //   #271	-> 7
/*     */     //   #294	-> 36
/*     */     //   #290	-> 59
/*     */     //   #74	-> 66
/*     */     //   #246	-> 68
/*     */     //   #69	-> 96
/*     */     //   #193	-> 102
/*     */     //   #19	-> 108
/*     */     //   #70	-> 111
/*     */     //   #186	-> 113
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   7	101	111	java/lang/Exception
/*     */     //   36	52	55	java/lang/Exception
/*     */     //   40	62	62	java/lang/Exception
/*     */     //   68	89	92	java/lang/Exception
/*     */     //   102	108	111	java/lang/Exception
/*     */     //   113	124	124	java/lang/Exception
/*     */   }
/*     */   
/*     */   public static void dumpClass(byte[] paramArrayOfbyte) {
/*     */     ClassReader classReader = new ClassReader(paramArrayOfbyte);
/*     */     CheckClassAdapter.verify(classReader, true, new PrintWriter(System.out));
/*     */   }
/*     */   
/*     */   public static String changeDescriptorReturnType(String paramString1, String paramString2) {
/*     */     try {
/*     */       if (paramString1 == null)
/*     */         return null; 
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (paramString2 == null)
/*     */         return paramString1; 
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return paramString1.substring(0, paramString1.lastIndexOf(')') + 1) + paramString2;
/*     */   }
/*     */   
/*     */   public static boolean compareFlags(MethodNode paramMethodNode1, MethodNode paramMethodNode2, int paramInt) {
/*     */     try {
/*     */     
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return (hasFlag(paramMethodNode1, paramInt) == hasFlag(paramMethodNode2, paramInt));
/*     */   }
/*     */   
/*     */   public static final int[] CONSTANTS_DOUBLE = new int[] { 14, 15 };
/*     */   
/*     */   public static Map<LabelNode, LabelNode> cloneLabels(InsnList paramInsnList) {
/*     */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*     */     for (ListIterator<AbstractInsnNode> listIterator = paramInsnList.iterator(); listIterator.hasNext(); ) {
/*     */       AbstractInsnNode abstractInsnNode = listIterator.next();
/*     */       try {
/*     */         if (abstractInsnNode instanceof LabelNode)
/*     */           hashMap.put(abstractInsnNode, new LabelNode(((LabelNode)abstractInsnNode).getLabel())); 
/*     */       } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     return (Map)hashMap;
/*     */   }
/*     */   
/*     */   public static final int[] CONSTANTS_FLOAT = new int[] { 11, 12, 13 };
/*     */   
/*     */   public static void compareBridgeMethods(MethodNode paramMethodNode1, MethodNode paramMethodNode2) {
/*     */     ListIterator<AbstractInsnNode> listIterator1 = paramMethodNode1.instructions.iterator();
/*     */     ListIterator<AbstractInsnNode> listIterator2 = paramMethodNode2.instructions.iterator();
/*     */     boolean bool = false;
/*     */     for (;; abstractInsnNode1 = listIterator1.next(), abstractInsnNode2 = listIterator2.next()) {
/*     */       try {
/*     */         if (listIterator1.hasNext() && listIterator2.hasNext())
/*     */           continue; 
/*     */       } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */         throw b(null);
/*     */       } 
/*     */       break;
/*     */     } 
/*     */     try {
/*     */       if (!listIterator1.hasNext())
/*     */         try {
/*     */           if (!listIterator2.hasNext())
/*     */             return; 
/*     */           throw new SyntheticBridgeException(SyntheticBridgeException.Problem.BAD_LENGTH, paramMethodNode1.name, paramMethodNode1.desc, bool, null, null);
/*     */         } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     throw new SyntheticBridgeException(SyntheticBridgeException.Problem.BAD_LENGTH, paramMethodNode1.name, paramMethodNode1.desc, bool, null, null);
/*     */   }
/*     */   
/*     */   private static String toDescriptor(Object paramObject) {
/*     */     try {
/*     */       if (paramObject instanceof String)
/*     */         return (String)paramObject; 
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (paramObject instanceof Type)
/*     */         return paramObject.toString(); 
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (paramObject instanceof Class)
/*     */         return Type.getDescriptor((Class)paramObject); 
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */     
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return (paramObject == null) ? "" : paramObject.toString();
/*     */   }
/*     */   
/*     */   public static boolean hasFlag(ClassNode paramClassNode, int paramInt) {
/*     */     try {
/*     */     
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return ((paramClassNode.access & paramInt) == paramInt);
/*     */   }
/*     */   
/*     */   public static MethodInsnNode findSuperInit(MethodNode paramMethodNode, String paramString) {
/*     */     try {
/*     */       if (!"<init>".equals(paramMethodNode.name))
/*     */         return null; 
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     byte b = 0;
/*     */     for (ListIterator<AbstractInsnNode> listIterator = paramMethodNode.instructions.iterator(); listIterator.hasNext(); ) {
/*     */       AbstractInsnNode abstractInsnNode = listIterator.next();
/*     */       try {
/*     */         if (abstractInsnNode instanceof TypeInsnNode)
/*     */           try {
/*     */             if (abstractInsnNode.getOpcode() == 187) {
/*     */               b++;
/*     */               continue;
/*     */             } 
/*     */           } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */             throw b(null);
/*     */           }  
/*     */       } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */         throw b(null);
/*     */       } 
/*     */       try {
/*     */         if (abstractInsnNode instanceof MethodInsnNode && abstractInsnNode.getOpcode() == 183) {
/*     */           MethodInsnNode methodInsnNode = (MethodInsnNode)abstractInsnNode;
/*     */           try {
/*     */             if ("<init>".equals(methodInsnNode.name)) {
/*     */               try {
/*     */                 if (b > 0) {
/*     */                   b--;
/*     */                   continue;
/*     */                 } 
/*     */               } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */                 throw b(null);
/*     */               } 
/*     */               try {
/*     */                 if (methodInsnNode.owner.equals(paramString))
/*     */                   return methodInsnNode; 
/*     */               } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */                 throw b(null);
/*     */               } 
/*     */             } 
/*     */           } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */             throw b(null);
/*     */           } 
/*     */         } 
/*     */       } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   public static boolean hasFlag(MethodNode paramMethodNode, int paramInt) {
/*     */     try {
/*     */     
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return ((paramMethodNode.access & paramInt) == paramInt);
/*     */   }
/*     */   
/*     */   public static void loadArgs(Type[] paramArrayOfType, InsnList paramInsnList, int paramInt) {
/*     */     loadArgs(paramArrayOfType, paramInsnList, paramInt, -1);
/*     */   }
/*     */   
/*     */   public static void setVisibility(FieldNode paramFieldNode, Bytecode$Visibility paramBytecode$Visibility) {
/*     */     paramFieldNode.access = setVisibility(paramFieldNode.access, paramBytecode$Visibility.access);
/*     */   }
/*     */   
/*     */   public static void mergeAnnotations(FieldNode paramFieldNode1, FieldNode paramFieldNode2) {
/*     */     paramFieldNode2.visibleAnnotations = mergeAnnotations(paramFieldNode1.visibleAnnotations, paramFieldNode2.visibleAnnotations, "field", paramFieldNode1.name);
/*     */     paramFieldNode2.invisibleAnnotations = mergeAnnotations(paramFieldNode1.invisibleAnnotations, paramFieldNode2.invisibleAnnotations, "field", paramFieldNode1.name);
/*     */   }
/*     */   
/*     */   public static void printMethod(MethodNode paramMethodNode) {
/*     */     System.err.printf("%s%s\n", new Object[] { paramMethodNode.name, paramMethodNode.desc });
/*     */     ListIterator<AbstractInsnNode> listIterator = paramMethodNode.instructions.iterator();
/*     */     try {
/*     */       for (; listIterator.hasNext(); printNode(listIterator.next()))
/*     */         System.err.print("  "); 
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Pattern getMergeableAnnotationPattern() {
/*     */     StringBuilder stringBuilder = new StringBuilder("^L(");
/*     */     byte b = 0;
/*     */     while (true) {
/*     */       try {
/*     */         if (b < MERGEABLE_MIXIN_ANNOTATIONS.length) {
/*     */           try {
/*     */             if (b > 0)
/*     */               stringBuilder.append('|'); 
/*     */           } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */             throw b(null);
/*     */           } 
/*     */           stringBuilder.append(MERGEABLE_MIXIN_ANNOTATIONS[b].getName().replace('.', '/'));
/*     */           b++;
/*     */           continue;
/*     */         } 
/*     */       } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */         throw b(null);
/*     */       } 
/*     */       break;
/*     */     } 
/*     */     return Pattern.compile(stringBuilder.append(");$").toString());
/*     */   }
/*     */   
/*     */   public static final int[] CONSTANTS_LONG = new int[] { 9, 10 };
/*     */   
/*     */   public static AbstractInsnNode findInsn(MethodNode paramMethodNode, int paramInt) {
/*     */     ListIterator<AbstractInsnNode> listIterator = paramMethodNode.instructions.iterator();
/*     */     while (listIterator.hasNext()) {
/*     */       AbstractInsnNode abstractInsnNode = listIterator.next();
/*     */       try {
/*     */         if (abstractInsnNode.getOpcode() == paramInt)
/*     */           return abstractInsnNode; 
/*     */       } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   public static int getArgsSize(Type[] paramArrayOfType) {
/*     */     int i = 0;
/*     */     Type[] arrayOfType;
/*     */     int j;
/*     */     byte b;
/*     */     for (arrayOfType = paramArrayOfType, j = arrayOfType.length, b = 0; b < j; b++) {
/*     */       Type type = arrayOfType[b];
/*     */       i += type.getSize();
/*     */     } 
/*     */     return i;
/*     */   }
/*     */   
/*     */   public static void mergeAnnotations(MethodNode paramMethodNode1, MethodNode paramMethodNode2) {
/*     */     paramMethodNode2.visibleAnnotations = mergeAnnotations(paramMethodNode1.visibleAnnotations, paramMethodNode2.visibleAnnotations, "method", paramMethodNode1.name);
/*     */     paramMethodNode2.invisibleAnnotations = mergeAnnotations(paramMethodNode1.invisibleAnnotations, paramMethodNode2.invisibleAnnotations, "method", paramMethodNode1.name);
/*     */   }
/*     */   
/*     */   public static void loadArgs(Type[] paramArrayOfType1, InsnList paramInsnList, int paramInt1, int paramInt2, Type[] paramArrayOfType2) {
/*     */     int i = paramInt1;
/*     */     byte b1 = 0;
/*     */     Type[] arrayOfType;
/*     */     int j;
/*     */     byte b2;
/*     */     for (arrayOfType = paramArrayOfType1, j = arrayOfType.length, b2 = 0; b2 < j; i += type.getSize()) {
/*     */       Type type = arrayOfType[b2];
/*     */       try {
/*     */         paramInsnList.add((AbstractInsnNode)new VarInsnNode(type.getOpcode(21), i));
/*     */         if (paramArrayOfType2 != null)
/*     */           try {
/*     */             if (b1 < paramArrayOfType2.length)
/*     */               try {
/*     */                 if (paramArrayOfType2[b1] != null)
/*     */                   paramInsnList.add((AbstractInsnNode)new TypeInsnNode(192, paramArrayOfType2[b1].getInternalName())); 
/*     */               } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */                 throw b(null);
/*     */               }  
/*     */           } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */             throw b(null);
/*     */           }  
/*     */       } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean compareFlags(FieldNode paramFieldNode1, FieldNode paramFieldNode2, int paramInt) {
/*     */     try {
/*     */     
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return (hasFlag(paramFieldNode1, paramInt) == hasFlag(paramFieldNode2, paramInt));
/*     */   }
/*     */   
/*     */   public static void textify(MethodNode paramMethodNode, OutputStream paramOutputStream) {
/*     */     TraceClassVisitor traceClassVisitor = new TraceClassVisitor(new PrintWriter(paramOutputStream));
/*     */     MethodVisitor methodVisitor = traceClassVisitor.visitMethod(paramMethodNode.access, paramMethodNode.name, paramMethodNode.desc, paramMethodNode.signature, (String[])paramMethodNode.exceptions.toArray((Object[])new String[0]));
/*     */     paramMethodNode.accept(methodVisitor);
/*     */     traceClassVisitor.visitEnd();
/*     */   }
/*     */   
/*     */   public static boolean isConstant(AbstractInsnNode paramAbstractInsnNode) {
/*     */     try {
/*     */       if (paramAbstractInsnNode == null)
/*     */         return false; 
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return Ints.contains(CONSTANTS_ALL, paramAbstractInsnNode.getOpcode());
/*     */   }
/*     */   
/*     */   public static int getMaxLineNumber(ClassNode paramClassNode, int paramInt1, int paramInt2) {
/*     */     byte b = 0;
/*     */     for (MethodNode methodNode : paramClassNode.methods)
/*     */       ListIterator listIterator = methodNode.instructions.iterator(); 
/*     */     return Math.max(paramInt1, b + paramInt2);
/*     */   }
/*     */   
/*     */   public static String getUnboxingMethod(Type paramType) {
/*     */     try {
/*     */     
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return (paramType == null) ? null : UNBOXING_METHODS[paramType.getSort()];
/*     */   }
/*     */   
/*     */   public static String getOpcodeName(int paramInt) {
/*     */     return getOpcodeName(paramInt, "UNINITIALIZED_THIS", 1);
/*     */   }
/*     */   
/*     */   public static void printMethodWithOpcodeIndices(MethodNode paramMethodNode) {
/*     */     System.err.printf("%s%s\n", new Object[] { paramMethodNode.name, paramMethodNode.desc });
/*     */     byte b = 0;
/*     */     ListIterator<AbstractInsnNode> listIterator = paramMethodNode.instructions.iterator();
/*     */     try {
/*     */       while (listIterator.hasNext()) {
/*     */         System.err.printf("[%4d] %s\n", new Object[] { Integer.valueOf(b++), describeNode(listIterator.next()) });
/*     */       } 
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void setVisibility(FieldNode paramFieldNode, int paramInt) {
/*     */     paramFieldNode.access = setVisibility(paramFieldNode.access, paramInt);
/*     */   }
/*     */   
/*     */   private static final Logger logger = LogManager.getLogger("mixin");
/*     */   
/*     */   public static void setVisibility(MethodNode paramMethodNode, int paramInt) {
/*     */     paramMethodNode.access = setVisibility(paramMethodNode.access, paramInt);
/*     */   }
/*     */   
/*     */   public static void dumpClass(ClassNode paramClassNode) {
/*     */     ClassWriter classWriter = new ClassWriter(3);
/*     */     paramClassNode.accept((ClassVisitor)classWriter);
/*     */     dumpClass(classWriter.toByteArray());
/*     */   }
/*     */   
/*     */   public static boolean methodIsStatic(MethodNode paramMethodNode) {
/*     */     try {
/*     */     
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return ((paramMethodNode.access & 0x8) == 8);
/*     */   }
/*     */   
/*     */   public static boolean fieldIsStatic(FieldNode paramFieldNode) {
/*     */     try {
/*     */     
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return ((paramFieldNode.access & 0x8) == 8);
/*     */   }
/*     */   
/*     */   private static final String[] UNBOXING_METHODS = new String[] { 
/*     */       null, "booleanValue", "charValue", "byteValue", "shortValue", "intValue", "floatValue", "longValue", "doubleValue", null, 
/*     */       null, null };
/*     */   
/*     */   public static void textify(ClassNode paramClassNode, OutputStream paramOutputStream) {
/*     */     paramClassNode.accept((ClassVisitor)new TraceClassVisitor(new PrintWriter(paramOutputStream)));
/*     */   }
/*     */   
/*     */   public static final int[] CONSTANTS_INT = new int[] { 2, 3, 4, 5, 6, 7, 8 };
/*     */   
/*     */   public static String describeNode(AbstractInsnNode paramAbstractInsnNode) {
/*     */     try {
/*     */       if (paramAbstractInsnNode == null)
/*     */         return String.format("   %-14s ", new Object[] { "null" }); 
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (paramAbstractInsnNode instanceof LabelNode)
/*     */         return String.format("[%s]", new Object[] { ((LabelNode)paramAbstractInsnNode).getLabel() }); 
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     String str = String.format("   %-14s ", new Object[] { paramAbstractInsnNode.getClass().getSimpleName().replace("Node", "") });
/*     */     if (paramAbstractInsnNode instanceof JumpInsnNode) {
/*     */       str = str + String.format("[%s] [%s]", new Object[] { getOpcodeName(paramAbstractInsnNode), ((JumpInsnNode)paramAbstractInsnNode).label.getLabel() });
/*     */     } else if (paramAbstractInsnNode instanceof VarInsnNode) {
/*     */       str = str + String.format("[%s] %d", new Object[] { getOpcodeName(paramAbstractInsnNode), Integer.valueOf(((VarInsnNode)paramAbstractInsnNode).var) });
/*     */     } else if (paramAbstractInsnNode instanceof MethodInsnNode) {
/*     */       MethodInsnNode methodInsnNode = (MethodInsnNode)paramAbstractInsnNode;
/*     */       str = str + String.format("[%s] %s %s %s", new Object[] { getOpcodeName(paramAbstractInsnNode), methodInsnNode.owner, methodInsnNode.name, methodInsnNode.desc });
/*     */     } else if (paramAbstractInsnNode instanceof FieldInsnNode) {
/*     */       FieldInsnNode fieldInsnNode = (FieldInsnNode)paramAbstractInsnNode;
/*     */       str = str + String.format("[%s] %s %s %s", new Object[] { getOpcodeName(paramAbstractInsnNode), fieldInsnNode.owner, fieldInsnNode.name, fieldInsnNode.desc });
/*     */     } else if (paramAbstractInsnNode instanceof LineNumberNode) {
/*     */       LineNumberNode lineNumberNode = (LineNumberNode)paramAbstractInsnNode;
/*     */       str = str + String.format("LINE=[%d] LABEL=[%s]", new Object[] { Integer.valueOf(lineNumberNode.line), lineNumberNode.start.getLabel() });
/*     */     } else if (paramAbstractInsnNode instanceof LdcInsnNode) {
/*     */       str = str + ((LdcInsnNode)paramAbstractInsnNode).cst;
/*     */     } else if (paramAbstractInsnNode instanceof IntInsnNode) {
/*     */       str = str + ((IntInsnNode)paramAbstractInsnNode).operand;
/*     */     } else if (paramAbstractInsnNode instanceof FrameNode) {
/*     */       str = str + String.format("[%s] ", new Object[] { getOpcodeName(((FrameNode)paramAbstractInsnNode).type, "H_INVOKEINTERFACE", -1) });
/*     */     } else {
/*     */       str = str + String.format("[%s] ", new Object[] { getOpcodeName(paramAbstractInsnNode) });
/*     */     } 
/*     */     return str;
/*     */   }
/*     */   
/*     */   public static int getFirstNonArgLocalIndex(Type[] paramArrayOfType, boolean paramBoolean) {
/*     */     try {
/*     */     
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return getArgsSize(paramArrayOfType) + (paramBoolean ? 1 : 0);
/*     */   }
/*     */   
/*     */   public static boolean hasFlag(FieldNode paramFieldNode, int paramInt) {
/*     */     try {
/*     */     
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return ((paramFieldNode.access & paramInt) == paramInt);
/*     */   }
/*     */   
/*     */   private static int setVisibility(int paramInt1, int paramInt2) {
/*     */     return paramInt1 & 0xFFFFFFF8 | paramInt2 & 0x7;
/*     */   }
/*     */   
/*     */   public static String getSimpleName(Class<? extends Annotation> paramClass) {
/*     */     return paramClass.getSimpleName();
/*     */   }
/*     */   
/*     */   public static Bytecode$Visibility getVisibility(FieldNode paramFieldNode) {
/*     */     return getVisibility(paramFieldNode.access & 0x7);
/*     */   }
/*     */   
/*     */   public static String getDescriptor(Type[] paramArrayOfType) {
/*     */     return "(" + Joiner.on("").join((Object[])paramArrayOfType) + ")";
/*     */   }
/*     */   
/*     */   public static final int[] CONSTANTS_ALL = new int[] { 
/*     */       1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 
/*     */       11, 12, 13, 14, 15, 16, 17, 18 };
/*     */   
/*     */   public static Bytecode$Visibility getVisibility(MethodNode paramMethodNode) {
/*     */     return getVisibility(paramMethodNode.access & 0x7);
/*     */   }
/*     */   
/*     */   public static Object getConstant(AbstractInsnNode paramAbstractInsnNode) {
/*     */     try {
/*     */       if (paramAbstractInsnNode == null)
/*     */         return null; 
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (paramAbstractInsnNode instanceof LdcInsnNode)
/*     */         return ((LdcInsnNode)paramAbstractInsnNode).cst; 
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     if (paramAbstractInsnNode instanceof IntInsnNode) {
/*     */       int j = ((IntInsnNode)paramAbstractInsnNode).operand;
/*     */       try {
/*     */         if (paramAbstractInsnNode.getOpcode() != 16)
/*     */           try {
/*     */             if (paramAbstractInsnNode.getOpcode() != 17)
/*     */               throw new IllegalArgumentException("IntInsnNode with invalid opcode " + paramAbstractInsnNode.getOpcode() + " in getConstant"); 
/*     */             return Integer.valueOf(j);
/*     */           } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */             throw b(null);
/*     */           }  
/*     */       } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */         throw b(null);
/*     */       } 
/*     */       return Integer.valueOf(j);
/*     */     } 
/*     */     int i = Ints.indexOf(CONSTANTS_ALL, paramAbstractInsnNode.getOpcode());
/*     */     try {
/*     */     
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return (i < 0) ? null : CONSTANTS_VALUES[i];
/*     */   }
/*     */   
/*     */   private static final String[] BOXING_TYPES = new String[] { 
/*     */       null, "java/lang/Boolean", "java/lang/Character", "java/lang/Byte", "java/lang/Short", "java/lang/Integer", "java/lang/Float", "java/lang/Long", "java/lang/Double", null, 
/*     */       null, null };
/*     */   
/*     */   public static void loadArgs(Type[] paramArrayOfType, InsnList paramInsnList, int paramInt1, int paramInt2) {
/*     */     loadArgs(paramArrayOfType, paramInsnList, paramInt1, paramInt2, null);
/*     */   }
/*     */   
/*     */   public static int getFirstNonArgLocalIndex(MethodNode paramMethodNode) {
/*     */     try {
/*     */     
/*     */     } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return getFirstNonArgLocalIndex(Type.getArgumentTypes(paramMethodNode.desc), ((paramMethodNode.access & 0x8) == 0));
/*     */   }
/*     */   
/*     */   public static String getDescriptor(Type[] paramArrayOfType, Type paramType) {
/*     */     return getDescriptor(paramArrayOfType) + paramType.toString();
/*     */   }
/*     */   
/*     */   public static boolean methodHasLineNumbers(MethodNode paramMethodNode) {
/*     */     for (ListIterator listIterator = paramMethodNode.instructions.iterator(); listIterator.hasNext();) {
/*     */       if (listIterator.next() instanceof LineNumberNode)
/*     */         return true; 
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public static MethodNode findMethod(ClassNode paramClassNode, String paramString1, String paramString2) {
/*     */     for (MethodNode methodNode : paramClassNode.methods) {
/*     */       try {
/*     */         if (methodNode.name.equals(paramString1))
/*     */           try {
/*     */             if (methodNode.desc.equals(paramString2))
/*     */               return methodNode; 
/*     */           } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */             throw b(null);
/*     */           }  
/*     */       } catch (SyntheticBridgeException syntheticBridgeException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   private static final String[] CONSTANTS_TYPES = new String[] { 
/*     */       null, "I", "I", "I", "I", "I", "I", "I", "J", "J", 
/*     */       "F", "F", "F", "D", "D", "I", "I" };
/*     */   
/*     */   private static Exception b(Exception paramException) {
/*     */     return paramException;
/*     */   }
/*     */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\Bytecode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */