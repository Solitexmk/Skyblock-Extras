/*    */ package org.spongepowered.tools.obfuscation.mirror;
/*  2 */ public class MethodHandle extends MemberHandle<MappingMethod> { private final ExecutableElement element; public Visibility getVisibility() { return TypeUtils.getVisibility(this.element); } private final TypeHandle ownerHandle; public String toString() {
/*    */     
/*    */     try {  }
/*    */     catch (RuntimeException runtimeException)
/*  6 */     { throw b(null); }  String str1 = (getOwner() != null) ? ("L" + getOwner() + ";") : "";
/*    */ 
/*    */ 
/*    */     
/*    */     String str2 = Strings.nullToEmpty(getName());
/*    */ 
/*    */     
/* 13 */     String str3 = Strings.nullToEmpty(getDesc());
/*    */ 
/*    */     
/* 16 */     return String.format("%s%s%s", new Object[] { str1, str2, str3 });
/*    */   }
/*    */   
/*    */   private MethodHandle(TypeHandle paramTypeHandle, ExecutableElement paramExecutableElement, String paramString1, String paramString2) {
/*    */     super((paramTypeHandle != null) ? paramTypeHandle.getName() : null, paramString1, paramString2);
/* 21 */     this.element = paramExecutableElement;
/*    */     this.ownerHandle = paramTypeHandle;
/*    */   }
/*    */   
/*    */   public MethodHandle(TypeHandle paramTypeHandle, String paramString1, String paramString2) {
/*    */     this(paramTypeHandle, (ExecutableElement)null, paramString1, paramString2);
/*    */   }
/*    */   
/*    */   public MethodHandle(TypeHandle paramTypeHandle, ExecutableElement paramExecutableElement) {
/*    */     this(paramTypeHandle, paramExecutableElement, TypeUtils.getName(paramExecutableElement), TypeUtils.getDescriptor(paramExecutableElement));
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
/*    */   public MappingMethod asMapping(boolean paramBoolean) {
/*    */     try {
/*    */       if (paramBoolean) {
/*    */         try {
/*    */           if (this.ownerHandle != null)
/*    */             return (MappingMethod)new ResolvableMappingMethod(this.ownerHandle, getName(), getDesc()); 
/*    */         } catch (RuntimeException runtimeException) {
/*    */           throw b(null);
/*    */         } 
/*    */         return new MappingMethod(getOwner(), getName(), getDesc());
/*    */       } 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return new MappingMethod(null, getName(), getDesc());
/*    */   }
/*    */   
/*    */   public ExecutableElement getElement() {
/*    */     return this.element;
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\mirror\MethodHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */