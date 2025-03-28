/*    */ package org.spongepowered.tools.obfuscation.mirror;
/*  2 */ public final class AnnotationHandle { public AnnotationMirror asMirror() { return this.annotation; } public boolean exists() { 
/*    */     try {  }
/*    */     catch (RuntimeException runtimeException)
/*  5 */     { throw b(null); }  return (this.annotation != null); } private AnnotationHandle(AnnotationMirror paramAnnotationMirror) { this.annotation = paramAnnotationMirror; }
/*    */   public <T> T getValue(String paramString) { return getValue(paramString, null); }
/*    */   public String toString() { try {
/*    */       if (this.annotation == null)
/*    */         return "@{UnknownAnnotation}"; 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return "@" + this.annotation.getAnnotationType().asElement().getSimpleName(); }
/*    */   public <T> T getValue(String paramString, T paramT) { 
/* 15 */     try { if (this.annotation == null)
/*    */       {
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
/* 39 */         return paramT; }  } catch (RuntimeException runtimeException) { throw b(null); }
/*    */      AnnotationValue annotationValue = getAnnotationValue(paramString);
/*    */     
/*    */     try { if (paramT instanceof Enum && annotationValue != null) {
/*    */         VariableElement variableElement = (VariableElement)annotationValue.getValue();
/*    */         try {
/*    */           if (variableElement == null)
/*    */             return paramT; 
/*    */         } catch (RuntimeException runtimeException) {
/*    */           throw b(null);
/*    */         } 
/* 50 */         return (T)Enum.valueOf(paramT.getClass(), variableElement.getSimpleName().toString());
/*    */       }  }
/*    */     catch (RuntimeException runtimeException) { throw b(null); }
/*    */      try {  }
/*    */     catch (RuntimeException runtimeException) { throw b(null); }
/*    */      return (annotationValue != null) ? (T)annotationValue.getValue() : paramT; } protected static <T> List<T> unwrapAnnotationValueList(List<AnnotationValue> paramList) { try { if (paramList == null)
/*    */         return Collections.emptyList();  }
/*    */     catch (RuntimeException runtimeException) { throw b(null); }
/*    */      ArrayList<Object> arrayList = new ArrayList(paramList.size()); for (AnnotationValue annotationValue : paramList) {
/* 59 */       arrayList.add(annotationValue.getValue());
/*    */     }
/*    */     
/* 62 */     return arrayList; }
/*    */   protected AnnotationValue getAnnotationValue(String paramString) { for (ExecutableElement executableElement : this.annotation.getElementValues().keySet()) { try { if (executableElement.getSimpleName().contentEquals(paramString))
/*    */           return this.annotation.getElementValues().get(executableElement);  }
/*    */       catch (RuntimeException runtimeException) { throw b(null); }
/*    */        }
/*    */      return null; }
/*    */   public <T> T getValue() { return getValue("value", null); } protected static AnnotationMirror getAnnotation(Element paramElement, Class<? extends Annotation> paramClass) { try { if (paramElement == null)
/* 69 */         return null;  } catch (RuntimeException runtimeException) { throw b(null); }  List<? extends AnnotationMirror> list = paramElement.getAnnotationMirrors(); try { if (list == null) return null;  } catch (RuntimeException runtimeException) { throw b(null); }  for (AnnotationMirror annotationMirror : list)
/* 70 */       Element element = annotationMirror.getAnnotationType().asElement();  return null; } public boolean getBoolean(String paramString, boolean paramBoolean) { return ((Boolean)getValue(paramString, Boolean.valueOf(paramBoolean))).booleanValue(); }
/* 71 */   public List<AnnotationHandle> getAnnotationList(String paramString) { AnnotationMirror annotationMirror = (AnnotationMirror)getValue(paramString, null); try { if (annotationMirror == null) return Collections.emptyList();  } catch (RuntimeException runtimeException) { throw b(null); }  try { if (annotationMirror instanceof AnnotationMirror) return (List<AnnotationHandle>)ImmutableList.of(of(annotationMirror));  } catch (RuntimeException runtimeException) { throw b(null); }  List list = (List)annotationMirror; ArrayList<AnnotationHandle> arrayList = new ArrayList(list.size()); for (AnnotationValue annotationValue : list) arrayList.add(new AnnotationHandle((AnnotationMirror)annotationValue.getValue())); 
/*    */     return Collections.unmodifiableList(arrayList); }
/*    */ 
/*    */   
/*    */   public static final AnnotationHandle MISSING = new AnnotationHandle(null);
/*    */   private final AnnotationMirror annotation;
/*    */   
/*    */   public <T> List<T> getList(String paramString) {
/*    */     List<AnnotationValue> list = getValue(paramString, Collections.emptyList());
/*    */     return unwrapAnnotationValueList(list);
/*    */   }
/*    */   
/*    */   public static AnnotationHandle of(AnnotationMirror paramAnnotationMirror) {
/*    */     return new AnnotationHandle(paramAnnotationMirror);
/*    */   }
/*    */   
/*    */   public AnnotationHandle getAnnotation(String paramString) {
/*    */     AnnotationMirror annotationMirror = (AnnotationMirror)getValue(paramString);
/*    */     try {
/*    */       if (annotationMirror instanceof AnnotationMirror)
/*    */         return of(annotationMirror); 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     if (annotationMirror instanceof AnnotationValue) {
/*    */       Object object = ((AnnotationValue)annotationMirror).getValue();
/*    */       try {
/*    */         if (object instanceof AnnotationMirror)
/*    */           return of((AnnotationMirror)object); 
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } 
/*    */     return null;
/*    */   }
/*    */   
/*    */   public static AnnotationHandle of(Element paramElement, Class<? extends Annotation> paramClass) {
/*    */     return new AnnotationHandle(getAnnotation(paramElement, paramClass));
/*    */   }
/*    */   
/*    */   public <T> List<T> getList() {
/*    */     return getList("value");
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\mirror\AnnotationHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */