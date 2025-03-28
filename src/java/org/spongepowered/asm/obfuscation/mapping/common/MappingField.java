/*  1 */ package org.spongepowered.asm.obfuscation.mapping.common;public class MappingField implements IMapping<MappingField> { private final String owner; private final String name; private final String desc; public MappingField transform(String paramString) { return new MappingField(getOwner(), getName(), paramString); }
/*    */ 
/*    */   
/*    */   public final String getDesc() {
/*  5 */     return this.desc;
/*    */   }
/*  7 */   public String toString() { return String.format("L%s;%s:%s", new Object[] { getOwner(), getName(), Strings.nullToEmpty(getDesc()) }); } public MappingField(String paramString1, String paramString2) {
/*  8 */     this(paramString1, paramString2, null);
/*    */   } public MappingField copy() {
/* 10 */     return new MappingField(getOwner(), getName(), getDesc());
/*    */   }
/*    */   public int hashCode() {
/* 13 */     return Objects.hashCode(new Object[] { toString() });
/*    */   }
/* 15 */   public final String getSimpleName() { return this.name; }
/*    */   public boolean equals(Object paramObject) { try {
/* 17 */       if (this == paramObject) {
/*    */         return true;
/*    */       }
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 27 */     try { if (paramObject instanceof MappingField) return Objects.equal(toString(), ((MappingField)paramObject).toString());  } catch (RuntimeException runtimeException) { throw b(null); }  return false; }
/* 28 */   public final String getOwner() { return this.owner; } public MappingField move(String paramString) { return new MappingField(paramString, getName(), getDesc()); } public String serialise() { return toString(); }
/* 29 */   public MappingField(String paramString1, String paramString2, String paramString3) { this.owner = paramString1; this.name = paramString2; this.desc = paramString3; } public MappingField getSuper() { return null; } public IMapping.Type getType() { return IMapping.Type.FIELD; } public String getName() { return this.name; } public MappingField remap(String paramString) {
/* 30 */     return new MappingField(getOwner(), paramString, getDesc());
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\obfuscation\mapping\common\MappingField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */