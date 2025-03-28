/*  1 */ package org.spongepowered.tools.obfuscation.mirror;public class TypeReference implements Serializable, Comparable<TypeReference> { public String getClassName() { return this.name.replace('/', '.'); }
/*    */ 
/*    */ 
/*    */   
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final String name;
/*    */   private transient TypeHandle handle;
/*    */   
/*    */   public int hashCode() {
/*    */     return this.name.hashCode();
/*    */   }
/*    */   
/*    */   public TypeReference(TypeHandle paramTypeHandle) {
/* 14 */     this.name = paramTypeHandle.getName(); this.handle = paramTypeHandle; } public TypeHandle getHandle(ProcessingEnvironment paramProcessingEnvironment) { if (this.handle == null) { TypeElement typeElement = paramProcessingEnvironment.getElementUtils().getTypeElement(getClassName()); try { this.handle = new TypeHandle(typeElement); }
/* 15 */       catch (Exception exception) { exception.printStackTrace(); }
/*    */        }
/* 17 */      return this.handle; } public TypeReference(String paramString) {
/* 18 */     this.name = paramString;
/*    */   }
/*    */   
/*    */   public boolean equals(Object paramObject) {
/*    */     try {
/*    */       if (paramObject instanceof TypeReference)
/*    */         try {
/*    */           if (compareTo((TypeReference)paramObject) == 0);
/*    */         } catch (RuntimeException runtimeException) {
/*    */           throw b(null);
/*    */         }  
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return false;
/*    */   }
/*    */   
/*    */   public String getName() {
/*    */     return this.name;
/*    */   }
/*    */   
/*    */   public String toString() {
/*    */     return String.format("TypeReference[%s]", new Object[] { this.name });
/*    */   }
/*    */   
/*    */   public int compareTo(TypeReference paramTypeReference) {
/*    */     try {
/*    */     
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return (paramTypeReference == null) ? -1 : this.name.compareTo(paramTypeReference.name);
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\mirror\TypeReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */