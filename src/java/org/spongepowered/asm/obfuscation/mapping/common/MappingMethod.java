/*    */ package org.spongepowered.asm.obfuscation.mapping.common;public class MappingMethod implements IMapping<MappingMethod> { private final String owner; private final String name; private final String desc;
/*    */   public MappingMethod copy() {
/*  3 */     return new MappingMethod(getOwner(), getSimpleName(), getDesc());
/*    */   }
/*    */   
/*  6 */   public MappingMethod(String paramString1, String paramString2) { this(getOwnerFromName(paramString1), getBaseName(paramString1), paramString2); }
/*    */   private static String getOwnerFromName(String paramString) { 
/*  8 */     try { if (paramString == null)
/*    */       {
/*    */         
/* 11 */         return null; }  } catch (RuntimeException runtimeException) { throw b(null); }  int i = paramString.lastIndexOf('/'); try {  } catch (RuntimeException runtimeException) { throw b(null); }
/* 12 */      return (i > -1) ? paramString.substring(0, i) : null; } public String getSimpleName() { return this.name; }
/* 13 */   public MappingMethod addPrefix(String paramString) { String str = getSimpleName(); 
/* 14 */     try { if (str != null) try { if (!str.startsWith(paramString))
/*    */           {
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
/* 32 */             return new MappingMethod(getOwner(), paramString + str, getDesc());
/*    */           }
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
/* 45 */           return this; } catch (RuntimeException runtimeException) { throw b(null); }   } catch (RuntimeException runtimeException) { throw b(null); }  return this; }
/* 46 */   public MappingMethod remap(String paramString) { return new MappingMethod(getOwner(), paramString, getDesc()); } public MappingMethod move(String paramString) { return new MappingMethod(paramString, getSimpleName(), getDesc()); }
/*    */ 
/*    */   
/*    */   public IMapping.Type getType() {
/*    */     return IMapping.Type.METHOD;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return Objects.hashCode(new Object[] { getName(), getDesc() });
/*    */   }
/*    */   
/*    */   private static String getBaseName(String paramString) {
/*    */     try {
/*    */       if (paramString == null)
/*    */         return null; 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     int i = paramString.lastIndexOf('/');
/*    */     try {
/*    */     
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return (i > -1) ? paramString.substring(i + 1) : paramString;
/*    */   }
/*    */   
/*    */   public String getOwner() {
/*    */     return this.owner;
/*    */   }
/*    */   
/*    */   public boolean equals(Object paramObject) {
/*    */     try {
/*    */       if (this == paramObject)
/*    */         return true; 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     try {
/*    */       if (paramObject instanceof MappingMethod) {
/*    */         try {
/*    */           if (Objects.equal(this.name, ((MappingMethod)paramObject).name))
/*    */             try {
/*    */               if (Objects.equal(this.desc, ((MappingMethod)paramObject).desc));
/*    */             } catch (RuntimeException runtimeException) {
/*    */               throw b(null);
/*    */             }  
/*    */         } catch (RuntimeException runtimeException) {
/*    */           throw b(null);
/*    */         } 
/*    */         return false;
/*    */       } 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return false;
/*    */   }
/*    */   
/*    */   public String getName() {
/*    */     try {
/*    */       if (this.name == null)
/*    */         return null; 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     try {
/*    */     
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return ((this.owner != null) ? (this.owner + "/") : "") + this.name;
/*    */   }
/*    */   
/*    */   public MappingMethod getSuper() {
/*    */     return null;
/*    */   }
/*    */   
/*    */   public String serialise() {
/*    */     return toString();
/*    */   }
/*    */   
/*    */   public MappingMethod(String paramString1, String paramString2, String paramString3) {
/*    */     this.owner = paramString1;
/*    */     this.name = paramString2;
/*    */     this.desc = paramString3;
/*    */   }
/*    */   
/*    */   public String getDesc() {
/*    */     return this.desc;
/*    */   }
/*    */   
/*    */   public MappingMethod transform(String paramString) {
/*    */     return new MappingMethod(getOwner(), getSimpleName(), paramString);
/*    */   }
/*    */   
/*    */   public boolean isConstructor() {
/*    */     return "<init>".equals(this.name);
/*    */   }
/*    */   
/*    */   public String toString() {
/*    */     String str = getDesc();
/*    */     try {
/*    */       (new Object[3])[0] = getName();
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     try {
/*    */       (new Object[3])[1] = (str != null) ? " " : "";
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return String.format("%s%s%s", new Object[] { null, null, (str != null) ? str : "" });
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\obfuscation\mapping\common\MappingMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */