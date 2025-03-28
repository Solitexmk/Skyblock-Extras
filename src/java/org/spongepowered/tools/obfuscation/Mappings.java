/*    */ package org.spongepowered.tools.obfuscation;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.spongepowered.asm.obfuscation.mapping.IMapping;
/*    */ import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
/*    */ import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
/*    */ import org.spongepowered.tools.obfuscation.mapping.IMappingConsumer;
/*    */ 
/*    */ class Mappings implements IMappingConsumer {
/*    */   public IMappingConsumer.MappingSet<MappingField> getFieldMappings(ObfuscationType paramObfuscationType) {
/* 11 */     IMappingConsumer.MappingSet<MappingField> mappingSet = this.fieldMappings.get(paramObfuscationType);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     try {  }
/*    */     catch (Mappings$MappingConflictException mappings$MappingConflictException)
/* 18 */     { throw b(null); }  return (mappingSet != null) ? mappingSet : new IMappingConsumer.MappingSet();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private final Map<ObfuscationType, IMappingConsumer.MappingSet<MappingField>> fieldMappings = new HashMap<ObfuscationType, IMappingConsumer.MappingSet<MappingField>>();
/*    */ 
/*    */ 
/*    */   
/*    */   public void clear() {
/*    */     
/*    */     try { this.fieldMappings.clear();
/* 30 */       this.methodMappings.clear();
/*    */       if (this.unique != null)
/* 32 */         this.unique.clearMaps();  } catch (Mappings$MappingConflictException mappings$MappingConflictException) { throw b(null); }
/*    */      init(); } public void addMethodMapping(ObfuscationType paramObfuscationType, MappingMethod paramMappingMethod1, MappingMethod paramMappingMethod2) { IMappingConsumer.MappingSet<MappingMethod> mappingSet = this.methodMappings.get(paramObfuscationType);
/*    */     if (mappingSet == null) {
/* 35 */       mappingSet = new IMappingConsumer.MappingSet();
/*    */       this.methodMappings.put(paramObfuscationType, mappingSet);
/*    */     } 
/*    */     mappingSet.add(new IMappingConsumer.MappingSet.Pair((IMapping)paramMappingMethod1, (IMapping)paramMappingMethod2)); }
/*    */ 
/*    */   
/*    */   public Mappings() {
/*    */     init();
/*    */   }
/*    */   
/*    */   public IMappingConsumer asUnique() {
/*    */     try {
/*    */       if (this.unique == null)
/*    */         this.unique = new Mappings$UniqueMappings(this); 
/*    */     } catch (Mappings$MappingConflictException mappings$MappingConflictException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return this.unique;
/*    */   }
/*    */   
/*    */   private final Map<ObfuscationType, IMappingConsumer.MappingSet<MappingMethod>> methodMappings = new HashMap<ObfuscationType, IMappingConsumer.MappingSet<MappingMethod>>();
/*    */   private Mappings$UniqueMappings unique;
/*    */   
/*    */   public void addFieldMapping(ObfuscationType paramObfuscationType, MappingField paramMappingField1, MappingField paramMappingField2) {
/*    */     IMappingConsumer.MappingSet<MappingField> mappingSet = this.fieldMappings.get(paramObfuscationType);
/*    */     if (mappingSet == null) {
/*    */       mappingSet = new IMappingConsumer.MappingSet();
/*    */       this.fieldMappings.put(paramObfuscationType, mappingSet);
/*    */     } 
/*    */     mappingSet.add(new IMappingConsumer.MappingSet.Pair((IMapping)paramMappingField1, (IMapping)paramMappingField2));
/*    */   }
/*    */   
/*    */   private void init() {
/*    */     for (ObfuscationType obfuscationType : ObfuscationType.types()) {
/*    */       this.fieldMappings.put(obfuscationType, new IMappingConsumer.MappingSet());
/*    */       this.methodMappings.put(obfuscationType, new IMappingConsumer.MappingSet());
/*    */     } 
/*    */   }
/*    */   
/*    */   public IMappingConsumer.MappingSet<MappingMethod> getMethodMappings(ObfuscationType paramObfuscationType) {
/*    */     IMappingConsumer.MappingSet<MappingMethod> mappingSet = this.methodMappings.get(paramObfuscationType);
/*    */     try {
/*    */     
/*    */     } catch (Mappings$MappingConflictException mappings$MappingConflictException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return (mappingSet != null) ? mappingSet : new IMappingConsumer.MappingSet();
/*    */   }
/*    */   
/*    */   private static Mappings$MappingConflictException b(Mappings$MappingConflictException paramMappings$MappingConflictException) {
/*    */     return paramMappings$MappingConflictException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\Mappings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */