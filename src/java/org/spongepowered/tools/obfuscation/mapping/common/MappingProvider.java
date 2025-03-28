/*  1 */ package org.spongepowered.tools.obfuscation.mapping.common;public abstract class MappingProvider implements IMappingProvider { public void clear() { this.packageMap.clear();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 11 */     this.classMap.clear();
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 16 */     this.fieldMap.clear();
/*    */     this.methodMap.clear(); }
/*    */ 
/*    */   
/*    */   public MappingField getFieldMapping(MappingField paramMappingField) {
/*    */     return (MappingField)this.fieldMap.get(paramMappingField);
/*    */   }
/*    */   
/*    */   protected final BiMap<MappingMethod, MappingMethod> methodMap = (BiMap<MappingMethod, MappingMethod>)HashBiMap.create();
/*    */   
/*    */   public String getPackageMapping(String paramString) {
/*    */     return (String)this.packageMap.get(paramString);
/*    */   }
/*    */   
/*    */   protected final BiMap<String, String> classMap = (BiMap<String, String>)HashBiMap.create();
/*    */   
/*    */   public String getClassMapping(String paramString) {
/*    */     return (String)this.classMap.get(paramString);
/*    */   }
/*    */   
/*    */   public MappingMethod getMethodMapping(MappingMethod paramMappingMethod) {
/*    */     return (MappingMethod)this.methodMap.get(paramMappingMethod);
/*    */   }
/*    */   
/*    */   protected final BiMap<String, String> packageMap = (BiMap<String, String>)HashBiMap.create();
/*    */   
/*    */   public boolean isEmpty() {
/*    */     try {
/*    */       if (this.packageMap.isEmpty())
/*    */         try {
/*    */           if (this.classMap.isEmpty())
/*    */             try {
/*    */               if (this.fieldMap.isEmpty())
/*    */                 try {
/*    */                   if (this.methodMap.isEmpty());
/*    */                 } catch (RuntimeException runtimeException) {
/*    */                   throw b(null);
/*    */                 }  
/*    */             } catch (RuntimeException runtimeException) {
/*    */               throw b(null);
/*    */             }  
/*    */         } catch (RuntimeException runtimeException) {
/*    */           throw b(null);
/*    */         }  
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return false;
/*    */   }
/*    */   
/*    */   public MappingProvider(Messager paramMessager, Filer paramFiler) {
/*    */     this.messager = paramMessager;
/*    */     this.filer = paramFiler;
/*    */   }
/*    */   
/*    */   protected final BiMap<MappingField, MappingField> fieldMap = (BiMap<MappingField, MappingField>)HashBiMap.create();
/*    */   protected final Messager messager;
/*    */   protected final Filer filer;
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\mapping\common\MappingProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */