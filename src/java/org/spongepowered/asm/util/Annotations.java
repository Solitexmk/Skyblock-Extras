/*   1 */ package org.spongepowered.asm.util;public final class Annotations { public static AnnotationNode getInvisible(MethodNode paramMethodNode, Class<? extends Annotation> paramClass) { return get(paramMethodNode.invisibleAnnotations, Type.getDescriptor(paramClass)); }
/*     */   
/*     */   public static AnnotationNode getVisible(MethodNode paramMethodNode, Class<? extends Annotation> paramClass) {
/*     */     return get(paramMethodNode.visibleAnnotations, Type.getDescriptor(paramClass));
/*     */   }
/*   6 */   public static <T> T getValue(AnnotationNode paramAnnotationNode, String paramString) { boolean bool = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  46 */     try { if (paramAnnotationNode != null) try { if (paramAnnotationNode.values != null)
/*     */           
/*     */           { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*  72 */             for (T t : paramAnnotationNode.values)
/*     */             
/*     */             { 
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
/*     */                 if (bool)
/*  93 */                   return t;  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  }  return null; }  return null; }
/*     */         catch (IllegalArgumentException illegalArgumentException) { throw b(null); }
/*     */           }
/*     */     catch (IllegalArgumentException illegalArgumentException) { throw b(null); }
/*     */      return null; } private static <T extends Enum<T>> T toEnumValue(Class<T> paramClass, String[] paramArrayOfString) { try { if (!paramClass.getName().equals(Type.getType(paramArrayOfString[0]).getClassName()))
/*     */         throw new IllegalArgumentException("The supplied enum class does not match the stored enum value");  }
/*     */     catch (IllegalArgumentException illegalArgumentException) { throw b(null); }
/* 100 */      return Enum.valueOf(paramClass, paramArrayOfString[1]); } public static <T> T getValue(AnnotationNode paramAnnotationNode) { return getValue(paramAnnotationNode, "value"); }
/* 101 */   public static <T extends Enum<T>> List<T> getValue(AnnotationNode paramAnnotationNode, String paramString, boolean paramBoolean, Class<T> paramClass) { List list = (List)getValue(paramAnnotationNode, paramString); if (list instanceof List) { ListIterator<String[]> listIterator = ((List)list).listIterator(); try { while (listIterator.hasNext()) listIterator.set(toEnumValue(paramClass, listIterator.next()));  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }
/*     */        }
/*     */     
/*     */     if (list instanceof String[]) {
/*     */       ArrayList<T> arrayList = new ArrayList();
/*     */       arrayList.add(toEnumValue(paramClass, (String[])list));
/*     */       return arrayList;
/*     */     } 
/*     */     return Collections.emptyList(); }
/*     */ 
/*     */   
/*     */   public static AnnotationNode get(List<AnnotationNode> paramList, String paramString) {
/*     */     try {
/*     */       if (paramList == null)
/*     */         return null; 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     for (AnnotationNode annotationNode : paramList) {
/*     */       try {
/*     */         if (paramString.equals(annotationNode.desc))
/*     */           return annotationNode; 
/*     */       } catch (IllegalArgumentException illegalArgumentException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   public static AnnotationNode getVisibleParameter(MethodNode paramMethodNode, Class<? extends Annotation> paramClass, int paramInt) {
/*     */     return getParameter((List<AnnotationNode>[])paramMethodNode.visibleParameterAnnotations, Type.getDescriptor(paramClass), paramInt);
/*     */   }
/*     */   
/*     */   public static <T extends Enum<T>> T getValue(AnnotationNode paramAnnotationNode, String paramString, Class<T> paramClass, T paramT) {
/*     */     String[] arrayOfString = getValue(paramAnnotationNode, paramString);
/*     */     try {
/*     */       if (arrayOfString == null)
/*     */         return paramT; 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return toEnumValue(paramClass, arrayOfString);
/*     */   }
/*     */   
/*     */   public static AnnotationNode getSingleInvisible(MethodNode paramMethodNode, Class<? extends Annotation>... paramVarArgs) {
/*     */     return getSingle(paramMethodNode.invisibleAnnotations, paramVarArgs);
/*     */   }
/*     */   
/*     */   public static <T> T getValue(AnnotationNode paramAnnotationNode, String paramString, Class<?> paramClass) {
/*     */     Preconditions.checkNotNull(paramClass, "annotationClass cannot be null");
/*     */     Object object = getValue(paramAnnotationNode, paramString);
/*     */     if (object == null)
/*     */       try {
/*     */         object = paramClass.getDeclaredMethod(paramString, new Class[0]).getDefaultValue();
/*     */       } catch (NoSuchMethodException noSuchMethodException) {} 
/*     */     return (T)object;
/*     */   }
/*     */   
/*     */   public static void setInvisible(MethodNode paramMethodNode, Class<? extends Annotation> paramClass, Object... paramVarArgs) {
/*     */     AnnotationNode annotationNode = createNode(Type.getDescriptor(paramClass), paramVarArgs);
/*     */     paramMethodNode.invisibleAnnotations = add(paramMethodNode.invisibleAnnotations, annotationNode);
/*     */   }
/*     */   
/*     */   public static AnnotationNode getSingleVisible(MethodNode paramMethodNode, Class<? extends Annotation>... paramVarArgs) {
/*     */     return getSingle(paramMethodNode.visibleAnnotations, paramVarArgs);
/*     */   }
/*     */   
/*     */   public static <T> T getValue(AnnotationNode paramAnnotationNode, String paramString, T paramT) {
/*     */     T t = (T)getValue(paramAnnotationNode, paramString);
/*     */     try {
/*     */     
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return (t != null) ? t : paramT;
/*     */   }
/*     */   
/*     */   private static AnnotationNode createNode(String paramString, Object... paramVarArgs) {
/*     */     AnnotationNode annotationNode = new AnnotationNode(paramString);
/*     */     byte b = 0;
/*     */     while (true) {
/*     */       try {
/*     */         if (b < paramVarArgs.length - 1) {
/*     */           try {
/*     */             if (!(paramVarArgs[b] instanceof String))
/*     */               throw new IllegalArgumentException("Annotation keys must be strings, found " + paramVarArgs[b].getClass().getSimpleName() + " with " + paramVarArgs[b].toString() + " at index " + b + " creating " + paramString); 
/*     */           } catch (IllegalArgumentException illegalArgumentException) {
/*     */             throw b(null);
/*     */           } 
/*     */           annotationNode.visit((String)paramVarArgs[b], paramVarArgs[b + 1]);
/*     */           b += 2;
/*     */           continue;
/*     */         } 
/*     */       } catch (IllegalArgumentException illegalArgumentException) {
/*     */         throw b(null);
/*     */       } 
/*     */       return annotationNode;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void setVisible(FieldNode paramFieldNode, Class<? extends Annotation> paramClass, Object... paramVarArgs) {
/*     */     AnnotationNode annotationNode = createNode(Type.getDescriptor(paramClass), paramVarArgs);
/*     */     paramFieldNode.visibleAnnotations = add(paramFieldNode.visibleAnnotations, annotationNode);
/*     */   }
/*     */   
/*     */   public static <T> List<T> getValue(AnnotationNode paramAnnotationNode, String paramString, boolean paramBoolean) {
/*     */     List list = (List)getValue(paramAnnotationNode, paramString);
/*     */     try {
/*     */       if (list instanceof List)
/*     */         return list; 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     if (list != null) {
/*     */       ArrayList<List> arrayList = new ArrayList();
/*     */       arrayList.add(list);
/*     */       return (List)arrayList;
/*     */     } 
/*     */     return Collections.emptyList();
/*     */   }
/*     */   
/*     */   public static AnnotationNode getVisible(FieldNode paramFieldNode, Class<? extends Annotation> paramClass) {
/*     */     return get(paramFieldNode.visibleAnnotations, Type.getDescriptor(paramClass));
/*     */   }
/*     */   
/*     */   public static AnnotationNode getVisible(ClassNode paramClassNode, Class<? extends Annotation> paramClass) {
/*     */     return get(paramClassNode.visibleAnnotations, Type.getDescriptor(paramClass));
/*     */   }
/*     */   
/*     */   public static void setInvisible(FieldNode paramFieldNode, Class<? extends Annotation> paramClass, Object... paramVarArgs) {
/*     */     AnnotationNode annotationNode = createNode(Type.getDescriptor(paramClass), paramVarArgs);
/*     */     paramFieldNode.invisibleAnnotations = add(paramFieldNode.invisibleAnnotations, annotationNode);
/*     */   }
/*     */   
/*     */   public static void setVisible(MethodNode paramMethodNode, Class<? extends Annotation> paramClass, Object... paramVarArgs) {
/*     */     AnnotationNode annotationNode = createNode(Type.getDescriptor(paramClass), paramVarArgs);
/*     */     paramMethodNode.visibleAnnotations = add(paramMethodNode.visibleAnnotations, annotationNode);
/*     */   }
/*     */   
/*     */   public static AnnotationNode getInvisible(ClassNode paramClassNode, Class<? extends Annotation> paramClass) {
/*     */     return get(paramClassNode.invisibleAnnotations, Type.getDescriptor(paramClass));
/*     */   }
/*     */   
/*     */   private static AnnotationNode getSingle(List<AnnotationNode> paramList, Class<? extends Annotation>[] paramArrayOfClass) {
/*     */     ArrayList<AnnotationNode> arrayList = new ArrayList();
/*     */     Class<? extends Annotation>[] arrayOfClass;
/*     */     int j;
/*     */     byte b;
/*     */     for (arrayOfClass = paramArrayOfClass, j = arrayOfClass.length, b = 0; b < j; ) {
/*     */       Class<? extends Annotation> clazz = arrayOfClass[b];
/*     */       AnnotationNode annotationNode = get(paramList, Type.getDescriptor(clazz));
/*     */       try {
/*     */         if (annotationNode != null)
/*     */           arrayList.add(annotationNode); 
/*     */       } catch (IllegalArgumentException illegalArgumentException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     int i = arrayList.size();
/*     */     try {
/*     */       if (i > 1)
/*     */         throw new IllegalArgumentException("Conflicting annotations found: " + Lists.transform(arrayList, new Annotations$1())); 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */     
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return (i == 0) ? null : arrayList.get(0);
/*     */   }
/*     */   
/*     */   public static AnnotationNode getInvisibleParameter(MethodNode paramMethodNode, Class<? extends Annotation> paramClass, int paramInt) {
/*     */     return getParameter((List<AnnotationNode>[])paramMethodNode.invisibleParameterAnnotations, Type.getDescriptor(paramClass), paramInt);
/*     */   }
/*     */   
/*     */   public static AnnotationNode getInvisible(FieldNode paramFieldNode, Class<? extends Annotation> paramClass) {
/*     */     return get(paramFieldNode.invisibleAnnotations, Type.getDescriptor(paramClass));
/*     */   }
/*     */   
/*     */   public static AnnotationNode getParameter(List<AnnotationNode>[] paramArrayOfList, String paramString, int paramInt) {
/*     */     try {
/*     */       if (paramArrayOfList != null)
/*     */         try {
/*     */           if (paramInt >= 0)
/*     */             try {
/*     */               if (paramInt < paramArrayOfList.length)
/*     */                 return get(paramArrayOfList[paramInt], paramString); 
/*     */               return null;
/*     */             } catch (IllegalArgumentException illegalArgumentException) {
/*     */               throw b(null);
/*     */             }  
/*     */         } catch (IllegalArgumentException illegalArgumentException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   private static List<AnnotationNode> add(List<AnnotationNode> paramList, AnnotationNode paramAnnotationNode) {
/*     */     if (paramList == null) {
/*     */       paramList = new ArrayList<AnnotationNode>(1);
/*     */     } else {
/*     */       paramList.remove(get(paramList, paramAnnotationNode.desc));
/*     */     } 
/*     */     paramList.add(paramAnnotationNode);
/*     */     return paramList;
/*     */   }
/*     */   
/*     */   private static IllegalArgumentException b(IllegalArgumentException paramIllegalArgumentException) {
/*     */     return paramIllegalArgumentException;
/*     */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\Annotations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */