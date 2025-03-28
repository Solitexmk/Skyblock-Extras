/*    */ package org.spongepowered.asm.mixin.transformer;class MixinInfo$State { private byte[] mixinBytes; private final ClassInfo classInfo; private boolean detachedSuper; private boolean unique; protected final Set<String> interfaces; protected final List<InterfaceInfo> softImplements; protected final Set<String> syntheticInnerClasses; protected final Set<String> innerClasses; protected MixinInfo$MixinClassNode classNode;
/*    */   final MixinInfo this$0;
/*    */   
/*    */   private void validateRemappable(Class<Shadow> paramClass, String paramString, AnnotationNode paramAnnotationNode) { 
/*  5 */     try { if (paramAnnotationNode != null) try { if (((Boolean)Annotations.getValue(paramAnnotationNode, "remap", Boolean.TRUE)).booleanValue())
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
/* 51 */             throw new InvalidMixinException(MixinInfo.this, "Found a remappable @" + paramClass.getSimpleName() + " annotation on " + paramString + " in " + this); }  } catch (InvalidMixinException invalidMixinException) { throw b(null); }
/*    */           }
/*    */     catch (InvalidMixinException invalidMixinException) { throw b(null); }
/*    */      } boolean isDetachedSuper() { return this.detachedSuper; }
/*    */   ClassInfo getClassInfo() { return this.classInfo; }
/*    */   List<? extends InterfaceInfo> getSoftImplements() { return this.softImplements; }
/*    */   MixinInfo$State(MixinInfo paramMixinInfo, byte[] paramArrayOfbyte) { this(paramArrayOfbyte, null); }
/*    */   Set<String> getInnerClasses() { return this.innerClasses; }
/*    */   MixinInfo$MixinClassNode createClassNode(int paramInt) { MixinInfo$MixinClassNode mixinInfo$MixinClassNode = new MixinInfo$MixinClassNode(MixinInfo.this, MixinInfo.this); ClassReader classReader = new ClassReader(this.mixinBytes); classReader.accept((ClassVisitor)mixinInfo$MixinClassNode, paramInt); return mixinInfo$MixinClassNode; }
/*    */   byte[] getClassBytes() { return this.mixinBytes; }
/*    */   private void validateInner() { try { if (!this.classInfo.isProbablyStatic())
/*    */         throw new InvalidMixinException(MixinInfo.this, "Inner class mixin must be declared static");  }
/*    */     catch (InvalidMixinException invalidMixinException) { throw b(null); }
/*    */      }
/*    */   private void validateClassVersion() { if (this.classNode.version > MixinEnvironment.getCompatibilityLevel().classVersion()) { String str = "."; MixinEnvironment.CompatibilityLevel[] arrayOfCompatibilityLevel = MixinEnvironment.CompatibilityLevel.values(); int i = arrayOfCompatibilityLevel.length; boolean bool = false; }
/*    */      }
/* 67 */   private void validateRemappables(List<ClassInfo> paramList) { if (paramList.size() > 1) { for (FieldNode fieldNode : this.classNode.fields) {
/*    */         validateRemappable(Shadow.class, fieldNode.name, Annotations.getVisible(fieldNode, Shadow.class));
/*    */       }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       for (MethodNode methodNode : this.classNode.methods)
/*    */       { validateRemappable(Shadow.class, methodNode.name, Annotations.getVisible(methodNode, Shadow.class));
/*    */ 
/*    */ 
/*    */ 
/*    */         
/*    */         AnnotationNode annotationNode = Annotations.getVisible(methodNode, Overwrite.class);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/*    */         try { if (annotationNode != null)
/*    */           { 
/*    */             try { if ((methodNode.access & 0x8) != 0)
/*    */               { 
/*    */                 try { if ((methodNode.access & 0x1) == 0)
/* 92 */                     throw new InvalidMixinException(MixinInfo.this, "Found @Overwrite annotation on " + methodNode.name + " in " + MixinInfo.this);  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  continue; }  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  throw new InvalidMixinException(MixinInfo.this, "Found @Overwrite annotation on " + methodNode.name + " in " + MixinInfo.this); }  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  }  }  }
/*    */   MixinInfo$MixinClassNode getClassNode() { return this.classNode; }
/* 94 */   private void complete() { this.classNode = null; } Set<String> getSyntheticInnerClasses() { return this.syntheticInnerClasses; } MixinInfo$State(byte[] paramArrayOfbyte, ClassInfo paramClassInfo) { this.interfaces = new HashSet<String>(); this.softImplements = new ArrayList<InterfaceInfo>(); this.syntheticInnerClasses = new HashSet<String>(); this.innerClasses = new HashSet<String>(); this.mixinBytes = paramArrayOfbyte; connect(); this.classInfo = (paramClassInfo != null) ? paramClassInfo : ClassInfo.fromClassNode(getClassNode()); } void readImplementations(MixinInfo$SubType paramMixinInfo$SubType) { this.interfaces.addAll(this.classNode.interfaces); this.interfaces.addAll(paramMixinInfo$SubType.getInterfaces()); AnnotationNode annotationNode = Annotations.getInvisible(this.classNode, Implements.class); try { if (annotationNode == null) return;  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  List list = (List)Annotations.getValue(annotationNode); try { if (list == null) return;  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  for (AnnotationNode annotationNode1 : list) InterfaceInfo interfaceInfo = InterfaceInfo.fromAnnotation(MixinInfo.this, annotationNode1);  }
/* 95 */   Set<String> getInterfaces() { return this.interfaces; } private void connect() { this.classNode = createClassNode(0); } protected void validateChanges(MixinInfo$SubType paramMixinInfo$SubType, List<ClassInfo> paramList) { paramMixinInfo$SubType.createPreProcessor(this.classNode).prepare(); } void readInnerClasses() { for (InnerClassNode innerClassNode : this.classNode.innerClasses) { continue; classInfo = ClassInfo.forName(((InnerClassNode)SYNTHETIC_LOCAL_VARIABLE_2).name); }  } boolean isUnique() { return this.unique; } void validate(MixinInfo$SubType paramMixinInfo$SubType, List<ClassInfo> paramList) { MixinPreProcessorStandard mixinPreProcessorStandard = paramMixinInfo$SubType.createPreProcessor(getClassNode()).prepare();
/*    */     for (ClassInfo classInfo : paramList)
/*    */       mixinPreProcessorStandard.conform(classInfo); 
/*    */     try {
/*    */       paramMixinInfo$SubType.validate(this, paramList);
/*    */       this.detachedSuper = paramMixinInfo$SubType.isDetachedSuper();
/*    */     } catch (InvalidMixinException invalidMixinException) {
/*    */       throw b(null);
/*    */     } 
/*    */     this.unique = (Annotations.getVisible(getClassNode(), Unique.class) != null);
/*    */     validateInner();
/*    */     validateClassVersion();
/*    */     validateRemappables(paramList);
/*    */     readImplementations(paramMixinInfo$SubType);
/*    */     readInnerClasses();
/*    */     validateChanges(paramMixinInfo$SubType, paramList);
/*    */     complete(); }
/*    */ 
/*    */   
/*    */   private static InvalidMixinException b(InvalidMixinException paramInvalidMixinException) {
/*    */     return paramInvalidMixinException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MixinInfo$State.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */