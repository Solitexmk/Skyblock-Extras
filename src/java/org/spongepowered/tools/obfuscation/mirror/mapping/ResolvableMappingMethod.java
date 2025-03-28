/*    */ package org.spongepowered.tools.obfuscation.mirror.mapping;public final class ResolvableMappingMethod extends MappingMethod {
/*    */   public MappingMethod remap(String paramString) {
/*  3 */     return new ResolvableMappingMethod(this.ownerHandle, paramString, getDesc());
/*    */   } private final TypeHandle ownerHandle;
/*    */   public MappingMethod copy() {
/*  6 */     return new ResolvableMappingMethod(this.ownerHandle, getSimpleName(), getDesc());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ResolvableMappingMethod(TypeHandle paramTypeHandle, String paramString1, String paramString2) {
/* 12 */     super(paramTypeHandle.getName(), paramString1, paramString2);
/*    */     this.ownerHandle = paramTypeHandle;
/*    */   } public MappingMethod move(TypeHandle paramTypeHandle) {
/* 15 */     return new ResolvableMappingMethod(paramTypeHandle, getSimpleName(), getDesc());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MappingMethod transform(String paramString) {
/* 21 */     return new ResolvableMappingMethod(this.ownerHandle, getSimpleName(), paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public MappingMethod getSuper() {
/*    */     try {
/* 27 */       if (this.ownerHandle == null)
/*    */         return super.getSuper(); 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw c(null);
/*    */     } 
/*    */     String str1 = getSimpleName();
/*    */     String str2 = getDesc();
/*    */     String str3 = TypeUtils.getJavaSignature(str2);
/*    */     TypeHandle typeHandle = this.ownerHandle.getSuperclass();
/*    */     try {
/*    */       if (typeHandle != null)
/*    */         try {
/*    */           if (typeHandle.findMethod(str1, str3) != null)
/*    */             return typeHandle.getMappingMethod(str1, str2); 
/*    */         } catch (RuntimeException runtimeException) {
/*    */           throw c(null);
/*    */         }  
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw c(null);
/*    */     } 
/*    */     for (TypeHandle typeHandle1 : this.ownerHandle.getInterfaces()) {
/*    */       try {
/*    */         if (typeHandle1.findMethod(str1, str3) != null)
/*    */           return typeHandle1.getMappingMethod(str1, str2); 
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw c(null);
/*    */       } 
/*    */     } 
/*    */     try {
/*    */       if (typeHandle != null)
/*    */         return typeHandle.getMappingMethod(str1, str2).getSuper(); 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw c(null);
/*    */     } 
/*    */     return super.getSuper();
/*    */   }
/*    */   
/*    */   private static RuntimeException c(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\mirror\mapping\ResolvableMappingMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */