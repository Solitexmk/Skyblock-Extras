/*  1 */ package org.spongepowered.asm.mixin.injection.points;@AtCode("NEW") public class BeforeNew extends InjectionPoint { public boolean hasDescriptor() { try {  } catch (RuntimeException runtimeException) { throw b(null); }  return (this.desc != null); }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final String target;
/*    */ 
/*    */ 
/*    */   
/*    */   private final String desc;
/*    */ 
/*    */ 
/*    */   
/*    */   private final int ordinal;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private boolean matchesOwner(TypeInsnNode paramTypeInsnNode) {
/*    */     
/* 22 */     try { if (this.target != null) { try { if (this.target.equals(paramTypeInsnNode.desc)); } catch (RuntimeException runtimeException) { throw b(null); }  return false; }  } catch (RuntimeException runtimeException) { throw b(null); }
/* 23 */      } public BeforeNew(InjectionPointData paramInjectionPointData) { super(paramInjectionPointData);
/*    */     
/*    */     this.ordinal = paramInjectionPointData.getOrdinal();
/*    */     String str = Strings.emptyToNull(paramInjectionPointData.get("class", paramInjectionPointData.get("target", "")).replace('.', '/'));
/*    */     MemberInfo memberInfo = MemberInfo.parseAndValidate(str, paramInjectionPointData.getContext());
/*    */     this.target = memberInfo.toCtorType();
/* 29 */     this.desc = memberInfo.toCtorDesc(); }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean find(String paramString, InsnList paramInsnList, Collection<AbstractInsnNode> paramCollection)
/*    */   {
/* 35 */     boolean bool1 = false;
/* 36 */     boolean bool2 = false; ArrayList arrayList = new ArrayList(); try {  } catch (RuntimeException runtimeException) { throw b(null); }  Collection collection = (this.desc != null) ? arrayList : paramCollection; ListIterator<AbstractInsnNode> listIterator = paramInsnList.iterator(); while (listIterator.hasNext()) { continue; abstractInsnNode = listIterator.next(); }  if (this.desc != null)
/* 37 */       for (TypeInsnNode typeInsnNode : arrayList) { if (findCtor(paramInsnList, typeInsnNode)) { paramCollection.add(typeInsnNode); bool1 = true; }  }   return bool1; } protected boolean findCtor(InsnList paramInsnList, TypeInsnNode paramTypeInsnNode) { int i = paramInsnList.indexOf((AbstractInsnNode)paramTypeInsnNode);
/*    */     for (ListIterator<AbstractInsnNode> listIterator = paramInsnList.iterator(i); listIterator.hasNext(); ) {
/*    */       AbstractInsnNode abstractInsnNode = listIterator.next();
/*    */       try {
/*    */         if (abstractInsnNode instanceof MethodInsnNode && abstractInsnNode.getOpcode() == 183) {
/*    */           MethodInsnNode methodInsnNode = (MethodInsnNode)abstractInsnNode;
/*    */           try {
/*    */             if ("<init>".equals(methodInsnNode.name))
/*    */               try {
/*    */                 if (methodInsnNode.owner.equals(paramTypeInsnNode.desc))
/*    */                   try {
/*    */                     if (methodInsnNode.desc.equals(this.desc))
/*    */                       return true; 
/*    */                   } catch (RuntimeException runtimeException) {
/*    */                     throw b(null);
/*    */                   }  
/*    */               } catch (RuntimeException runtimeException) {
/*    */                 throw b(null);
/*    */               }  
/*    */           } catch (RuntimeException runtimeException) {
/*    */             throw b(null);
/*    */           } 
/*    */         } 
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } 
/*    */     return false; }
/*    */ 
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\points\BeforeNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */