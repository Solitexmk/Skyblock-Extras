/*    */ package org.spongepowered.tools.obfuscation;class Mappings$UniqueMappings implements IMappingConsumer { public IMappingConsumer.MappingSet<MappingMethod> getMethodMappings(ObfuscationType paramObfuscationType) {
/*  2 */     return this.mappings.getMethodMappings(paramObfuscationType);
/*    */   }
/*    */   private final IMappingConsumer mappings; private final Map<ObfuscationType, Map<MappingField, MappingField>> fields;
/*    */   private final Map<ObfuscationType, Map<MappingMethod, MappingMethod>> methods;
/*    */   
/*    */   public void addMethodMapping(ObfuscationType paramObfuscationType, MappingMethod paramMappingMethod1, MappingMethod paramMappingMethod2) {
/*    */     
/*  9 */     try { if (!checkForExistingMapping(paramObfuscationType, paramMappingMethod1, paramMappingMethod2, this.methods))
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
/* 23 */         this.mappings.addMethodMapping(paramObfuscationType, paramMappingMethod1, paramMappingMethod2); }  } catch (Mappings$MappingConflictException mappings$MappingConflictException) { throw b(null); }
/*    */   
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Mappings$UniqueMappings(IMappingConsumer paramIMappingConsumer) {
/* 30 */     this.fields = new HashMap<ObfuscationType, Map<MappingField, MappingField>>();
/*    */     this.methods = new HashMap<ObfuscationType, Map<MappingMethod, MappingMethod>>();
/*    */     this.mappings = paramIMappingConsumer;
/*    */   }
/*    */   
/*    */   public void clear() {
/*    */     clearMaps();
/*    */     this.mappings.clear();
/*    */   }
/*    */   
/*    */   private <TMapping extends IMapping<TMapping>> boolean checkForExistingMapping(ObfuscationType paramObfuscationType, TMapping paramTMapping1, TMapping paramTMapping2, Map<ObfuscationType, Map<TMapping, TMapping>> paramMap) throws Mappings$MappingConflictException {
/*    */     Map<Object, Object> map = (Map)paramMap.get(paramObfuscationType);
/*    */     if (map == null) {
/*    */       map = new HashMap<Object, Object>();
/*    */       paramMap.put(paramObfuscationType, map);
/*    */     } 
/*    */     IMapping iMapping = (IMapping)map.get(paramTMapping1);
/*    */     try {
/*    */       if (iMapping != null) {
/*    */         try {
/*    */           if (iMapping.equals(paramTMapping2))
/*    */             return true; 
/*    */         } catch (Mappings$MappingConflictException mappings$MappingConflictException) {
/*    */           throw b(null);
/*    */         } 
/*    */         throw new Mappings$MappingConflictException(iMapping, paramTMapping2);
/*    */       } 
/*    */     } catch (Mappings$MappingConflictException mappings$MappingConflictException) {
/*    */       throw b(null);
/*    */     } 
/*    */     map.put(paramTMapping1, paramTMapping2);
/*    */     return false;
/*    */   }
/*    */   
/*    */   public IMappingConsumer.MappingSet<MappingField> getFieldMappings(ObfuscationType paramObfuscationType) {
/*    */     return this.mappings.getFieldMappings(paramObfuscationType);
/*    */   }
/*    */   
/*    */   protected void clearMaps() {
/*    */     this.fields.clear();
/*    */     this.methods.clear();
/*    */   }
/*    */   
/*    */   public void addFieldMapping(ObfuscationType paramObfuscationType, MappingField paramMappingField1, MappingField paramMappingField2) {
/*    */     try {
/*    */       if (!checkForExistingMapping(paramObfuscationType, paramMappingField1, paramMappingField2, this.fields))
/*    */         this.mappings.addFieldMapping(paramObfuscationType, paramMappingField1, paramMappingField2); 
/*    */     } catch (Mappings$MappingConflictException mappings$MappingConflictException) {
/*    */       throw b(null);
/*    */     } 
/*    */   }
/*    */   
/*    */   private static Mappings$MappingConflictException b(Mappings$MappingConflictException paramMappings$MappingConflictException) {
/*    */     return paramMappings$MappingConflictException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\Mappings$UniqueMappings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */