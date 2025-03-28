/*    */ package org.spongepowered.tools.obfuscation.mirror;
/*  2 */ public class FieldHandle extends MemberHandle<MappingField> { private final VariableElement element; public boolean isRawType() { return this.rawType; } private final boolean rawType; private FieldHandle(String paramString1, VariableElement paramVariableElement, boolean paramBoolean, String paramString2, String paramString3) {
/*  3 */     super(paramString1, paramString2, paramString3);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 11 */     this.element = paramVariableElement;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 20 */     this.rawType = paramBoolean; } public MappingField asMapping(boolean paramBoolean) { try {  } catch (RuntimeException runtimeException) { throw b(null); }
/*    */      return new MappingField(paramBoolean ? getOwner() : null, getName(), getDesc()); }
/* 22 */   public FieldHandle(String paramString, VariableElement paramVariableElement) { this(paramString, paramVariableElement, false); }
/*    */ 
/*    */   
/*    */   public FieldHandle(TypeElement paramTypeElement, VariableElement paramVariableElement) {
/*    */     this(TypeUtils.getInternalName(paramTypeElement), paramVariableElement);
/*    */   }
/*    */   
/*    */   public String toString() {
/*    */     try {
/*    */     
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     String str1 = (getOwner() != null) ? ("L" + getOwner() + ";") : "";
/*    */     String str2 = Strings.nullToEmpty(getName());
/*    */     String str3 = Strings.nullToEmpty(getDesc());
/*    */     return String.format("%s%s:%s", new Object[] { str1, str2, str3 });
/*    */   }
/*    */   
/*    */   public FieldHandle(String paramString1, String paramString2, String paramString3) {
/*    */     this(paramString1, (VariableElement)null, false, paramString2, paramString3);
/*    */   }
/*    */   
/*    */   public FieldHandle(TypeElement paramTypeElement, VariableElement paramVariableElement, boolean paramBoolean) {
/*    */     this(TypeUtils.getInternalName(paramTypeElement), paramVariableElement, paramBoolean);
/*    */   }
/*    */   
/*    */   public Visibility getVisibility() {
/*    */     return TypeUtils.getVisibility(this.element);
/*    */   }
/*    */   
/*    */   public FieldHandle(String paramString, VariableElement paramVariableElement, boolean paramBoolean) {
/*    */     this(paramString, paramVariableElement, paramBoolean, TypeUtils.getName(paramVariableElement), TypeUtils.getInternalName(paramVariableElement));
/*    */   }
/*    */   
/*    */   public boolean isImaginary() {
/*    */     try {
/*    */     
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return (this.element == null);
/*    */   }
/*    */   
/*    */   public VariableElement getElement() {
/*    */     return this.element;
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\mirror\FieldHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */