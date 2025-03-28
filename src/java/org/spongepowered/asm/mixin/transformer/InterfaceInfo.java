/*    */ package org.spongepowered.asm.mixin.transformer;
/*    */ public final class InterfaceInfo {
/*    */   private final MixinInfo mixin;
/*    */   private final String prefix;
/*    */   
/*    */   static InterfaceInfo fromAnnotation(MixinInfo paramMixinInfo, AnnotationNode paramAnnotationNode) {
/*  7 */     String str = (String)Annotations.getValue(paramAnnotationNode, "prefix");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     Type type = (Type)Annotations.getValue(paramAnnotationNode, "iface");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 23 */     Boolean bool = (Boolean)Annotations.getValue(paramAnnotationNode, "unique");
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 62 */     try { if (str != null) try { if (type != null) { try {  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  return new InterfaceInfo(paramMixinInfo, str, type, (bool != null && bool.booleanValue())); }  throw new InvalidMixinException(paramMixinInfo, String.format("@Interface annotation on %s is missing a required parameter", new Object[] { paramMixinInfo })); } catch (InvalidMixinException invalidMixinException) { throw b(null); }   } catch (InvalidMixinException invalidMixinException) { throw b(null); }
/*    */     
/*    */     throw new InvalidMixinException(paramMixinInfo, String.format("@Interface annotation on %s is missing a required parameter", new Object[] { paramMixinInfo }));
/*    */   }
/*    */   
/*    */   private final Type iface;
/*    */   private final boolean unique;
/*    */   private Set<String> methods;
/*    */   
/*    */   private void decorateUniqueMethod(MethodNode paramMethodNode) {
/*    */     try {
/*    */       if (!this.unique)
/*    */         return; 
/*    */     } catch (InvalidMixinException invalidMixinException) {
/*    */       throw b(null);
/*    */     } 
/*    */     try {
/*    */       if (Annotations.getVisible(paramMethodNode, Unique.class) == null) {
/*    */         Annotations.setVisible(paramMethodNode, Unique.class, new Object[0]);
/*    */         this.mixin.getClassInfo().findMethod(paramMethodNode).setUnique(true);
/*    */       } 
/*    */     } catch (InvalidMixinException invalidMixinException) {
/*    */       throw b(null);
/*    */     } 
/*    */   }
/*    */   
/*    */   private InterfaceInfo(MixinInfo paramMixinInfo, String paramString, Type paramType, boolean paramBoolean) {
/*    */     if (paramString != null)
/*    */       try {
/*    */         if (paramString.length() >= 2)
/*    */           try {
/*    */             if (paramString.endsWith("$")) {
/*    */               this.mixin = paramMixinInfo;
/*    */               this.prefix = paramString;
/*    */               this.iface = paramType;
/*    */               this.unique = paramBoolean;
/*    */               return;
/*    */             } 
/*    */             throw new InvalidMixinException(paramMixinInfo, String.format("Prefix %s for iface %s is not valid", new Object[] { paramString, paramType.toString() }));
/*    */           } catch (InvalidMixinException invalidMixinException) {
/*    */             throw b(null);
/*    */           }  
/*    */       } catch (InvalidMixinException invalidMixinException) {
/*    */         throw b(null);
/*    */       }  
/*    */     throw new InvalidMixinException(paramMixinInfo, String.format("Prefix %s for iface %s is not valid", new Object[] { paramString, paramType.toString() }));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     null = this.mixin.hashCode();
/*    */     null = 31 * null + this.prefix.hashCode();
/*    */     return 31 * null + this.iface.hashCode();
/*    */   }
/*    */   
/*    */   public String getInternalName() {
/*    */     return this.iface.getInternalName();
/*    */   }
/*    */   
/*    */   public String getPrefix() {
/*    */     return this.prefix;
/*    */   }
/*    */   
/*    */   private void initMethods() {
/*    */     this.methods = new HashSet<String>();
/*    */     readInterface(this.iface.getInternalName());
/*    */   }
/*    */   
/*    */   public boolean isUnique() {
/*    */     return this.unique;
/*    */   }
/*    */   
/*    */   public String getName() {
/*    */     return this.iface.getClassName();
/*    */   }
/*    */   
/*    */   private void readInterface(String paramString) {
/*    */     ClassInfo classInfo = ClassInfo.forName(paramString);
/*    */     for (ClassInfo$Method classInfo$Method : classInfo.getMethods())
/*    */       this.methods.add(classInfo$Method.toString()); 
/*    */     for (String str : classInfo.getInterfaces())
/*    */       readInterface(str); 
/*    */   }
/*    */   
/*    */   public boolean equals(Object paramObject) {
/*    */     try {
/*    */       if (this == paramObject)
/*    */         return true; 
/*    */     } catch (InvalidMixinException invalidMixinException) {
/*    */       throw b(null);
/*    */     } 
/*    */     try {
/*    */       if (paramObject != null) {
/*    */         try {
/*    */           if (getClass() != paramObject.getClass())
/*    */             return false; 
/*    */         } catch (InvalidMixinException invalidMixinException) {
/*    */           throw b(null);
/*    */         } 
/*    */       } else {
/*    */         return false;
/*    */       } 
/*    */     } catch (InvalidMixinException invalidMixinException) {
/*    */       throw b(null);
/*    */     } 
/*    */     InterfaceInfo interfaceInfo = (InterfaceInfo)paramObject;
/*    */     try {
/*    */       if (this.mixin.equals(interfaceInfo.mixin))
/*    */         try {
/*    */           if (this.prefix.equals(interfaceInfo.prefix))
/*    */             try {
/*    */               if (this.iface.equals(interfaceInfo.iface));
/*    */             } catch (InvalidMixinException invalidMixinException) {
/*    */               throw b(null);
/*    */             }  
/*    */         } catch (InvalidMixinException invalidMixinException) {
/*    */           throw b(null);
/*    */         }  
/*    */     } catch (InvalidMixinException invalidMixinException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return false;
/*    */   }
/*    */   
/*    */   public boolean renameMethod(MethodNode paramMethodNode) {
/*    */     try {
/*    */       if (this.methods == null)
/*    */         initMethods(); 
/*    */     } catch (InvalidMixinException invalidMixinException) {
/*    */       throw b(null);
/*    */     } 
/*    */     try {
/*    */       if (!paramMethodNode.name.startsWith(this.prefix)) {
/*    */         try {
/*    */           if (this.methods.contains(paramMethodNode.name + paramMethodNode.desc))
/*    */             decorateUniqueMethod(paramMethodNode); 
/*    */         } catch (InvalidMixinException invalidMixinException) {
/*    */           throw b(null);
/*    */         } 
/*    */         return false;
/*    */       } 
/*    */     } catch (InvalidMixinException invalidMixinException) {
/*    */       throw b(null);
/*    */     } 
/*    */     String str1 = paramMethodNode.name.substring(this.prefix.length());
/*    */     String str2 = str1 + paramMethodNode.desc;
/*    */     try {
/*    */       if (!this.methods.contains(str2))
/*    */         throw new InvalidMixinException(this.mixin, String.format("%s does not exist in target interface %s", new Object[] { str1, getName() })); 
/*    */     } catch (InvalidMixinException invalidMixinException) {
/*    */       throw b(null);
/*    */     } 
/*    */     try {
/*    */       if ((paramMethodNode.access & 0x1) == 0)
/*    */         throw new InvalidMixinException(this.mixin, String.format("%s cannot implement %s because it is not visible", new Object[] { str1, getName() })); 
/*    */     } catch (InvalidMixinException invalidMixinException) {
/*    */       throw b(null);
/*    */     } 
/*    */     Annotations.setVisible(paramMethodNode, MixinRenamed.class, new Object[] { "originalName", paramMethodNode.name, "isInterfaceMember", Boolean.valueOf(true) });
/*    */     decorateUniqueMethod(paramMethodNode);
/*    */     paramMethodNode.name = str1;
/*    */     return true;
/*    */   }
/*    */   
/*    */   public Type getIface() {
/*    */     return this.iface;
/*    */   }
/*    */   
/*    */   private static InvalidMixinException b(InvalidMixinException paramInvalidMixinException) {
/*    */     return paramInvalidMixinException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\InterfaceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */