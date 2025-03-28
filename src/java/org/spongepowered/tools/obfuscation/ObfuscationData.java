/*  1 */ package org.spongepowered.tools.obfuscation;public class ObfuscationData<T> implements Iterable<ObfuscationType> { private final Map<ObfuscationType, T> data; public Iterator<ObfuscationType> iterator() { return this.data.keySet().iterator(); }
/*    */    private final T defaultValue; public ObfuscationData() {
/*  3 */     this(null);
/*    */   }
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
/*    */   public ObfuscationData(T paramT)
/*    */   {
/* 21 */     this.data = new HashMap<ObfuscationType, T>(); this.defaultValue = paramT; } public T get(ObfuscationType paramObfuscationType) { T t = this.data.get(paramObfuscationType);
/*    */     
/*    */     try {  }
/*    */     catch (RuntimeException runtimeException)
/* 25 */     { throw b(null); }  return (t != null) ? t : this.defaultValue; }
/*    */ 
/*    */   
/*    */   public String values() {
/*    */     return "[" + listValues() + "]";
/*    */   }
/*    */   
/*    */   public void put(ObfuscationType paramObfuscationType, T paramT) {
/*    */     this.data.put(paramObfuscationType, paramT);
/*    */   }
/*    */   
/*    */   public String toString() {
/*    */     return String.format("ObfuscationData[%s,DEFAULT=%s]", new Object[] { listValues(), this.defaultValue });
/*    */   }
/*    */   
/*    */   @Deprecated
/*    */   public void add(ObfuscationType paramObfuscationType, T paramT) {
/*    */     put(paramObfuscationType, paramT);
/*    */   }
/*    */   
/*    */   public boolean isEmpty() {
/*    */     return this.data.isEmpty();
/*    */   }
/*    */   
/*    */   private String listValues() {
/*    */     StringBuilder stringBuilder = new StringBuilder();
/*    */     boolean bool = false;
/*    */     for (ObfuscationType obfuscationType : this.data.keySet()) {
/*    */       try {
/*    */         if (bool)
/*    */           stringBuilder.append(','); 
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } 
/*    */     return stringBuilder.toString();
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\ObfuscationData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */