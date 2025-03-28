/*     */ package org.spongepowered.asm.mixin.transformer;
/*     */ 
/*     */ class TargetClassContext extends ClassContext implements ITargetClassContext {
/*   4 */   private void checkMerges() { for (MethodNode methodNode : this.mixinMethods) {
/*     */ 
/*     */ 
/*     */       
/*     */       try { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  72 */         if (!methodNode.name.startsWith("<"))
/*     */           logger.debug("Unexpected: Registered method {}{} in {} was not merged", new Object[] { methodNode.name, methodNode.desc, this });  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); } 
/*     */     }  }
/*     */   boolean isApplied() { return this.applied; }
/*     */   void mergeSignature(ClassSignature paramClassSignature) { this.signature.merge(paramClassSignature); }
/*     */   void addMixinMethod(MethodNode paramMethodNode) { this.mixinMethods.add(paramMethodNode); } void applyMixins() { try { if (this.applied)
/*     */         throw new IllegalStateException("Mixins already applied to target class " + this.className);  }
/*     */     catch (IllegalArgumentException illegalArgumentException) { throw b(null); }
/*  80 */      this.applied = true; MixinApplicatorStandard mixinApplicatorStandard = createApplicator(); mixinApplicatorStandard.apply(this.mixins); applySignature(); upgradeMethods(); checkMerges(); }
/*     */   public String toString() { return this.className; }
/*     */   FieldNode findAliasedField(Deque<String> paramDeque, String paramString) { String str = paramDeque.poll(); try { if (str == null) return null;  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  for (FieldNode fieldNode : this.classNode.fields) { try { if (fieldNode.name.equals(str)) try { if (fieldNode.desc.equals(paramString)) return fieldNode;  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }   } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  }  return findAliasedField(paramDeque, paramString); }
/*     */   String getSessionId() { return this.sessionId; }
/*  84 */   SourceMap getSourceMap() { return this.sourceMap; } private MixinApplicatorStandard createApplicator() { try { if (this.classInfo.isInterface()) return new MixinApplicatorInterface(this);  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }
/*     */     
/*     */     return new MixinApplicatorStandard(this); } public ClassInfo getClassInfo() { return this.classInfo; } List<FieldNode> getFields() { return this.classNode.fields; } String getClassName() { return this.className; }
/*     */   String getClassRef() {
/*     */     return this.classNode.name;
/*     */   }
/*     */   List<MethodNode> getMethods() {
/*     */     return this.classNode.methods;
/*     */   }
/*     */   Target getTargetMethod(MethodNode paramMethodNode) {
/*     */     try {
/*     */       if (!this.classNode.methods.contains(paramMethodNode))
/*     */         throw new IllegalArgumentException("Invalid target method supplied to getTargetMethod()"); 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     String str = paramMethodNode.name + paramMethodNode.desc;
/*     */     Target target = this.targetMethods.get(str);
/*     */     if (target == null) {
/* 103 */       target = new Target(this.classNode, paramMethodNode);
/*     */       this.targetMethods.put(str, target);
/*     */     } 
/*     */     return target;
/*     */   }
/*     */   
/*     */   TargetClassContext(MixinEnvironment paramMixinEnvironment, Extensions paramExtensions, String paramString1, String paramString2, ClassNode paramClassNode, SortedSet<MixinInfo> paramSortedSet) {
/*     */     this.targetMethods = new HashMap<String, Target>();
/*     */     this.mixinMethods = new HashSet<MethodNode>();
/*     */     this.env = paramMixinEnvironment;
/*     */     this.extensions = paramExtensions;
/*     */     this.sessionId = paramString1;
/*     */     this.className = paramString2;
/*     */     this.classNode = paramClassNode;
/*     */     this.classInfo = ClassInfo.fromClassNode(paramClassNode);
/*     */     this.signature = this.classInfo.getSignature();
/*     */     this.mixins = paramSortedSet;
/*     */     this.sourceMap = new SourceMap(paramClassNode.sourceFile);
/*     */     this.sourceMap.addFile(this.classNode);
/*     */   }
/*     */   
/*     */   private MethodNode findAliasedMethod(Deque<String> paramDeque, String paramString, boolean paramBoolean) {
/*     */     String str = paramDeque.poll();
/*     */     try {
/*     */       if (str == null)
/*     */         return null; 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     for (MethodNode methodNode : this.classNode.methods) {
/*     */       try {
/*     */         if (methodNode.name.equals(str))
/*     */           try {
/*     */             if (methodNode.desc.equals(paramString))
/*     */               return methodNode; 
/*     */           } catch (IllegalArgumentException illegalArgumentException) {
/*     */             throw b(null);
/*     */           }  
/*     */       } catch (IllegalArgumentException illegalArgumentException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     if (paramBoolean)
/*     */       for (MethodNode methodNode : this.mixinMethods) {
/*     */         try {
/*     */           if (methodNode.name.equals(str))
/*     */             try {
/*     */               if (methodNode.desc.equals(paramString))
/*     */                 return methodNode; 
/*     */             } catch (IllegalArgumentException illegalArgumentException) {
/*     */               throw b(null);
/*     */             }  
/*     */         } catch (IllegalArgumentException illegalArgumentException) {
/*     */           throw b(null);
/*     */         } 
/*     */       }  
/*     */     return findAliasedMethod(paramDeque, paramString);
/*     */   }
/*     */   
/*     */   void methodMerged(MethodNode paramMethodNode) {
/*     */     try {
/*     */       if (!this.mixinMethods.remove(paramMethodNode))
/*     */         logger.debug("Unexpected: Merged unregistered method {}{} in {}", new Object[] { paramMethodNode.name, paramMethodNode.desc, this }); 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   MethodNode findAliasedMethod(Deque<String> paramDeque, String paramString) {
/*     */     return findAliasedMethod(paramDeque, paramString, false);
/*     */   }
/*     */   
/*     */   boolean isExportForced() {
/*     */     return this.forceExport;
/*     */   }
/*     */   
/*     */   String getUniqueName(FieldNode paramFieldNode) {
/*     */     String str = Integer.toHexString(this.nextUniqueFieldIndex++);
/*     */     return String.format("fd%s$%s$%s", new Object[] { this.sessionId.substring(30), paramFieldNode.name, str });
/*     */   }
/*     */   
/*     */   private void applySignature() {
/*     */     (getClassNode()).signature = this.signature.toString();
/*     */   }
/*     */   
/*     */   public ClassNode getClassNode() {
/*     */     return this.classNode;
/*     */   }
/*     */   
/*     */   Extensions getExtensions() {
/*     */     return this.extensions;
/*     */   }
/*     */   
/*     */   MethodNode findMethod(Deque<String> paramDeque, String paramString) {
/*     */     return findAliasedMethod(paramDeque, paramString, true);
/*     */   }
/*     */   
/*     */   String getUniqueName(MethodNode paramMethodNode, boolean paramBoolean) {
/*     */     String str1 = Integer.toHexString(this.nextUniqueMethodIndex++);
/*     */     try {
/*     */     
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     String str2 = paramBoolean ? "%2$s_$md$%1$s$%3$s" : "md%s$%s$%s";
/*     */     return String.format(str2, new Object[] { this.sessionId.substring(30), paramMethodNode.name, str1 });
/*     */   }
/*     */   
/*     */   void processDebugTasks() {
/*     */     try {
/*     */       if (!this.env.getOption(MixinEnvironment.Option.DEBUG_VERBOSE))
/*     */         return; 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     AnnotationNode annotationNode = Annotations.getVisible(this.classNode, Debug.class);
/*     */     try {
/*     */       if (annotationNode != null)
/*     */         try {
/*     */           this.forceExport = Boolean.TRUE.equals(Annotations.getValue(annotationNode, "export"));
/*     */           if (Boolean.TRUE.equals(Annotations.getValue(annotationNode, "print")))
/*     */             Bytecode.textify(this.classNode, System.err); 
/*     */         } catch (IllegalArgumentException illegalArgumentException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     for (MethodNode methodNode : this.classNode.methods)
/*     */       AnnotationNode annotationNode1 = Annotations.getVisible(methodNode, Debug.class); 
/*     */   }
/*     */   
/*     */   private static final Logger logger = LogManager.getLogger("mixin");
/*     */   private final MixinEnvironment env;
/*     */   private final Extensions extensions;
/*     */   private final String sessionId;
/*     */   private final String className;
/*     */   private final ClassNode classNode;
/*     */   private final ClassInfo classInfo;
/*     */   private final SourceMap sourceMap;
/*     */   private final ClassSignature signature;
/*     */   private final SortedSet<MixinInfo> mixins;
/*     */   private final Map<String, Target> targetMethods;
/*     */   private final Set<MethodNode> mixinMethods;
/*     */   private int nextUniqueMethodIndex;
/*     */   private int nextUniqueFieldIndex;
/*     */   private boolean applied;
/*     */   private boolean forceExport;
/*     */   
/*     */   SortedSet<MixinInfo> getMixins() {
/*     */     return this.mixins;
/*     */   }
/*     */   
/*     */   private static IllegalArgumentException b(IllegalArgumentException paramIllegalArgumentException) {
/*     */     return paramIllegalArgumentException;
/*     */   }
/*     */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\TargetClassContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */