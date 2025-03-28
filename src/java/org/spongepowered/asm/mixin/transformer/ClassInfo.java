/*     */ package org.spongepowered.asm.mixin.transformer;public final class ClassInfo {
/*     */   public ClassInfo$Method findMethod(String paramString1, String paramString2, int paramInt) {
/*   3 */     return findMember(paramString1, paramString2, paramInt, ClassInfo$Member$Type.METHOD);
/*     */   }
/*     */   private static ClassInfo getCommonSuperClass(ClassInfo paramClassInfo1, ClassInfo paramClassInfo2, boolean paramBoolean) { 
/*   6 */     try { if (paramClassInfo1.hasSuperClass(paramClassInfo2, ClassInfo$Traversal.NONE, paramBoolean))
/*     */       {
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
/*     */ 
/*     */         
/* 262 */         return paramClassInfo2; }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }
/*     */      try { if (paramClassInfo2.hasSuperClass(paramClassInfo1, ClassInfo$Traversal.NONE, paramBoolean))
/*     */         return paramClassInfo1;  }
/*     */     catch (IllegalArgumentException illegalArgumentException) { throw b(null); }
/*     */      try { if (!paramClassInfo1.isInterface())
/*     */         try { if (!paramClassInfo2.isInterface())
/*     */             while (true) { paramClassInfo1 = paramClassInfo1.getSuperClass(); if (paramClassInfo1 == null)
/*     */                 return OBJECT;  if (paramClassInfo2.hasSuperClass(paramClassInfo1, ClassInfo$Traversal.NONE, paramBoolean))
/*     */                 return paramClassInfo1;  }
/*     */               return OBJECT; }
/*     */         catch (IllegalArgumentException illegalArgumentException) { throw b(null); }
/*     */           }
/*     */     catch (IllegalArgumentException illegalArgumentException) { throw b(null); }
/*     */      return OBJECT; } public ClassInfo$Method findMethod(MethodNode paramMethodNode) { return findMethod(paramMethodNode.name, paramMethodNode.desc, paramMethodNode.access); }
/*     */   void addMethod(MethodNode paramMethodNode) { addMethod(paramMethodNode, true); }
/*     */   private void addMethod(MethodNode paramMethodNode, boolean paramBoolean) { try { if (!paramMethodNode.name.startsWith("<"))
/*     */         this.methods.add(new ClassInfo$Method(this, paramMethodNode, paramBoolean));  }
/*     */     catch (IllegalArgumentException illegalArgumentException) { throw b(null); }
/*     */      }
/*     */   public boolean hasSuperClass(ClassInfo paramClassInfo, ClassInfo$Traversal paramClassInfo$Traversal) { return hasSuperClass(paramClassInfo, paramClassInfo$Traversal, false); }
/*     */   public String getClassName() { return this.name.replace('/', '.'); }
/*     */   public ClassInfo$Field findField(FieldNode paramFieldNode) { return findField(paramFieldNode.name, paramFieldNode.desc, paramFieldNode.access); }
/*     */   public ClassInfo$Method findMethodInHierarchy(MethodInsnNode paramMethodInsnNode, ClassInfo$SearchType paramClassInfo$SearchType, int paramInt) { return findMethodInHierarchy(paramMethodInsnNode.name, paramMethodInsnNode.desc, paramClassInfo$SearchType, ClassInfo$Traversal.NONE, paramInt); }
/*     */   private ClassInfo addMethodsRecursive(Set<ClassInfo$Method> paramSet, boolean paramBoolean) { if (this.isInterface)
/* 286 */       for (ClassInfo$Method classInfo$Method : this.methods) { try { if (!classInfo$Method.isAbstract())
/*     */             paramSet.remove(classInfo$Method);  }
/*     */         catch (IllegalArgumentException illegalArgumentException)
/*     */         { throw b(null); }
/*     */          paramSet.add(classInfo$Method); }
/*     */        
/*     */     
/*     */     try { if (!this.isMixin && paramBoolean)
/* 294 */         for (MixinInfo mixinInfo : this.mixins)
/*     */         {
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
/* 306 */           mixinInfo.getClassInfo().addMethodsRecursive(paramSet, paramBoolean); }   } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  for (String str : this.interfaces) forName(str).addMethodsRecursive(paramSet, paramBoolean);  return getSuperClass(); } private static final Logger logger = LogManager.getLogger("mixin"); public ClassInfo$Method findMethodInHierarchy(MethodInsnNode paramMethodInsnNode, ClassInfo$SearchType paramClassInfo$SearchType) { return findMethodInHierarchy(paramMethodInsnNode.name, paramMethodInsnNode.desc, paramClassInfo$SearchType, ClassInfo$Traversal.NONE); } public ClassInfo$Method findMethodInHierarchy(MethodNode paramMethodNode, ClassInfo$SearchType paramClassInfo$SearchType, int paramInt) { return findMethodInHierarchy(paramMethodNode.name, paramMethodNode.desc, paramClassInfo$SearchType, ClassInfo$Traversal.NONE, paramInt); }
/*     */   private ClassInfo findSuperClass(String paramString, ClassInfo$Traversal paramClassInfo$Traversal, boolean paramBoolean, Set<String> paramSet) { ClassInfo classInfo = getSuperClass(); if (classInfo != null) for (ClassInfo classInfo1 : classInfo.getTargets()) { try { if (paramString.equals(classInfo1.getName())) return classInfo;  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  }   if (paramBoolean) { ClassInfo classInfo1 = findInterface(paramString); try { if (classInfo1 != null) return classInfo1;  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  }  if (paramClassInfo$Traversal.canTraverse()) for (MixinInfo mixinInfo : this.mixins) String str = mixinInfo.getClassName();   return null; }
/*     */   public ClassInfo$Field findFieldInHierarchy(String paramString1, String paramString2, ClassInfo$SearchType paramClassInfo$SearchType) { return findFieldInHierarchy(paramString1, paramString2, paramClassInfo$SearchType, ClassInfo$Traversal.NONE); }
/*     */   public boolean isMixin() { return this.isMixin; }
/*     */   private static final ClassInfo OBJECT = new ClassInfo();
/*     */   public static ClassInfo getCommonSuperClass(Type paramType1, Type paramType2) { try { if (paramType1 != null) try { if (paramType2 != null) try { if (paramType1.getSort() == 10)
/*     */                 try { if (paramType2.getSort() == 10)
/* 313 */                     return getCommonSuperClass(forType(paramType1), forType(paramType2));  return OBJECT; } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }   } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }   } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }   } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return OBJECT; }
/* 314 */   private static final Map<String, ClassInfo> cache = new HashMap<String, ClassInfo>(); public static ClassInfo getCommonSuperClass(String paramString1, String paramString2) { try { if (paramString1 != null) try { if (paramString2 != null) return getCommonSuperClass(forName(paramString1), forName(paramString2));  return OBJECT; } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }   } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return OBJECT; } public ClassInfo$Field findFieldInHierarchy(FieldInsnNode paramFieldInsnNode, ClassInfo$SearchType paramClassInfo$SearchType) { return findFieldInHierarchy(paramFieldInsnNode.name, paramFieldInsnNode.desc, paramClassInfo$SearchType, ClassInfo$Traversal.NONE); } public Set<ClassInfo$Method> getMethods() { return Collections.unmodifiableSet(this.methods); } public String getOuterName() { return this.outerName; } public static ClassInfo getCommonSuperClassOrInterface(String paramString1, String paramString2) { try { if (paramString1 != null) try { if (paramString2 != null) return getCommonSuperClassOrInterface(forName(paramString1), forName(paramString2));  return OBJECT; } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }   } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return OBJECT; } private ClassInfo findInterface(String paramString) { for (String str : getInterfaces()) { ClassInfo classInfo1 = forName(str); try { if (paramString.equals(str)) return classInfo1;  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  ClassInfo classInfo2 = classInfo1.findInterface(paramString); try { if (classInfo2 != null) return classInfo2;  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  }  return null; } static ClassInfo fromClassNode(ClassNode paramClassNode) { ClassInfo classInfo = cache.get(paramClassNode.name); if (classInfo == null) { classInfo = new ClassInfo(paramClassNode); cache.put(paramClassNode.name, classInfo); }  return classInfo; } public static ClassInfo forName(String paramString) { paramString = paramString.replace('.', '/'); ClassInfo classInfo = cache.get(paramString); if (classInfo == null) { try { ClassNode classNode = MixinService.getService().getBytecodeProvider().getClassNode(paramString); classInfo = new ClassInfo(classNode); } catch (Exception exception) { logger.catching(Level.TRACE, exception); logger.warn("Error loading class: {} ({}: {})", new Object[] { paramString, exception.getClass().getName(), exception.getMessage() }); }  cache.put(paramString, classInfo); logger.trace("Added class metadata for {} to metadata cache", new Object[] { paramString }); }  return classInfo; } public boolean isSynthetic() { try {  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return ((this.access & 0x1000) != 0); } private static final Profiler profiler = MixinEnvironment.getProfiler(); public static final int INCLUDE_PRIVATE = 2; public static final int INCLUDE_STATIC = 8; public static final int INCLUDE_ALL = 10; private static final String JAVA_LANG_OBJECT = "java/lang/Object"; private final String name; private final String superName; private final String outerName; private final boolean isProbablyStatic; private final Set<String> interfaces; private final Set<ClassInfo$Method> methods; private final Set<ClassInfo$Field> fields; private final Set<MixinInfo> mixins; private final Map<ClassInfo, ClassInfo> correspondingTypes; private final MixinInfo mixin; private final MethodMapper methodMapper; private final boolean isMixin; private final boolean isInterface; private final int access; private ClassInfo superClass; private ClassInfo outerClass; private ClassSignature signature; public boolean hasSuperClass(ClassInfo paramClassInfo, ClassInfo$Traversal paramClassInfo$Traversal, boolean paramBoolean) { try { if (OBJECT == paramClassInfo) return true;  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  try {  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return (findSuperClass(paramClassInfo.name, paramClassInfo$Traversal, paramBoolean) != null); } public String getName() { return this.name; } ClassInfo findCorrespondingType(ClassInfo paramClassInfo) { try { if (paramClassInfo != null) try { if (paramClassInfo.isMixin) try { if (!this.isMixin) { ClassInfo classInfo = this.correspondingTypes.get(paramClassInfo); if (classInfo == null) { classInfo = findSuperTypeForMixin(paramClassInfo); this.correspondingTypes.put(paramClassInfo, classInfo); }  return classInfo; }  return null; } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }   } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }   } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return null; } private ClassInfo findSuperTypeForMixin(ClassInfo paramClassInfo) { ClassInfo classInfo = this; while (true) { try { if (classInfo != null && classInfo != OBJECT) { for (MixinInfo mixinInfo : classInfo.mixins) { try { if (mixinInfo.getClassInfo().equals(paramClassInfo)) return classInfo;  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  }  classInfo = classInfo.getSuperClass(); }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  break; }  return null; } public boolean hasMixinInHierarchy() { try { if (!this.isMixin) return false;  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  ClassInfo classInfo = getSuperClass(); while (true) { try { if (classInfo != null) try { if (classInfo != OBJECT) { try { if (classInfo.isMixin) return true;  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  classInfo = classInfo.getSuperClass(); continue; }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }   } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  break; }  return false; } public ClassInfo$Field findField(String paramString1, String paramString2, int paramInt) { return findMember(paramString1, paramString2, paramInt, ClassInfo$Member$Type.FIELD); } public ClassInfo getSuperClass() { try { if (this.superClass == null) try { if (this.superName != null) this.superClass = forName(this.superName);  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }   } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return this.superClass; } public ClassInfo$Field findFieldInHierarchy(FieldNode paramFieldNode, ClassInfo$SearchType paramClassInfo$SearchType, int paramInt) { return findFieldInHierarchy(paramFieldNode.name, paramFieldNode.desc, paramClassInfo$SearchType, ClassInfo$Traversal.NONE, paramInt); } public ClassInfo$Method findMethodInHierarchy(String paramString1, String paramString2, ClassInfo$SearchType paramClassInfo$SearchType, ClassInfo$Traversal paramClassInfo$Traversal) { return findMethodInHierarchy(paramString1, paramString2, paramClassInfo$SearchType, paramClassInfo$Traversal, 0); } public MethodMapper getMethodMapper() { return this.methodMapper; } private <M extends ClassInfo$Member> M findMember(String paramString1, String paramString2, int paramInt, ClassInfo$Member$Type paramClassInfo$Member$Type) { try {  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  Set set = (Set)((paramClassInfo$Member$Type == ClassInfo$Member$Type.METHOD) ? this.methods : this.fields); for (ClassInfo$Member classInfo$Member : set) { try { if (classInfo$Member.equals(paramString1, paramString2)) try { if (classInfo$Member.matchesFlags(paramInt)) return (M)classInfo$Member;  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }   } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  }  return null; }
/*     */   public ClassInfo findSuperClass(String paramString, ClassInfo$Traversal paramClassInfo$Traversal, boolean paramBoolean) { try { if (OBJECT.name.equals(paramString)) return null;  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return findSuperClass(paramString, paramClassInfo$Traversal, paramBoolean, new HashSet<String>()); } public ClassInfo$Field findFieldInHierarchy(String paramString1, String paramString2, ClassInfo$SearchType paramClassInfo$SearchType, ClassInfo$Traversal paramClassInfo$Traversal, int paramInt) { return findInHierarchy(paramString1, paramString2, paramClassInfo$SearchType, paramClassInfo$Traversal, paramInt, ClassInfo$Member$Type.FIELD); } public static ClassInfo getCommonSuperClassOrInterface(ClassInfo paramClassInfo1, ClassInfo paramClassInfo2) { return getCommonSuperClass(paramClassInfo1, paramClassInfo2, true); } public boolean hasSuperClass(String paramString, ClassInfo$Traversal paramClassInfo$Traversal) { try { if ("java/lang/Object".equals(paramString)) return true;  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  try {  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return (findSuperClass(paramString, paramClassInfo$Traversal) != null); } public boolean equals(Object paramObject) { try { if (!(paramObject instanceof ClassInfo)) return false;  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return ((ClassInfo)paramObject).name.equals(this.name); } public boolean isProbablyStatic() { return this.isProbablyStatic; } static { cache.put("java/lang/Object", OBJECT); } public boolean isInner() { try {  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return (this.outerName != null); } public int hashCode() { return this.name.hashCode(); } public ClassInfo$Method findMethodInHierarchy(String paramString1, String paramString2, ClassInfo$SearchType paramClassInfo$SearchType) { return findMethodInHierarchy(paramString1, paramString2, paramClassInfo$SearchType, ClassInfo$Traversal.NONE); } public Set<ClassInfo$Method> getInterfaceMethods(boolean paramBoolean) { HashSet<ClassInfo$Method> hashSet = new HashSet(); ClassInfo classInfo = addMethodsRecursive(hashSet, paramBoolean); try { if (!this.isInterface) while (true) { try { if (classInfo != null && classInfo != OBJECT) { classInfo = classInfo.addMethodsRecursive(hashSet, paramBoolean); continue; }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  break; }   } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  Iterator<ClassInfo$Method> iterator = hashSet.iterator(); while (true) { try { while (iterator.hasNext()) { if (!((ClassInfo$Method)iterator.next()).isAbstract()) iterator.remove();  }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return Collections.unmodifiableSet(hashSet); }  } public ClassInfo$Field findFieldInHierarchy(FieldInsnNode paramFieldInsnNode, ClassInfo$SearchType paramClassInfo$SearchType, int paramInt) { return findFieldInHierarchy(paramFieldInsnNode.name, paramFieldInsnNode.desc, paramClassInfo$SearchType, ClassInfo$Traversal.NONE, paramInt); } public boolean hasSuperClass(String paramString) { return hasSuperClass(paramString, ClassInfo$Traversal.NONE); } private <M extends ClassInfo$Member> M cloneMember(M paramM) { try { if (paramM instanceof ClassInfo$Method) return (M)new ClassInfo$Method(this, (ClassInfo$Member)paramM);  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return (M)new ClassInfo$Field(this, (ClassInfo$Member)paramM); } public String toString() { return this.name; } private ClassInfo() { this.mixins = new HashSet<MixinInfo>(); this.correspondingTypes = new HashMap<ClassInfo, ClassInfo>(); this.name = "java/lang/Object"; this.superName = null; this.outerName = null; this.isProbablyStatic = true; this.methods = (Set<ClassInfo$Method>)ImmutableSet.of(new ClassInfo$Method(this, "getClass", "()Ljava/lang/Class;"), new ClassInfo$Method(this, "hashCode", "()I"), new ClassInfo$Method(this, "equals", "(Ljava/lang/Object;)Z"), new ClassInfo$Method(this, "clone", "()Ljava/lang/Object;"), new ClassInfo$Method(this, "toString", "()Ljava/lang/String;"), new ClassInfo$Method(this, "notify", "()V"), (Object[])new ClassInfo$Method[] { new ClassInfo$Method(this, "notifyAll", "()V"), new ClassInfo$Method(this, "wait", "(J)V"), new ClassInfo$Method(this, "wait", "(JI)V"), new ClassInfo$Method(this, "wait", "()V"), new ClassInfo$Method(this, "finalize", "()V") }); this.fields = Collections.emptySet(); this.isInterface = false; this.interfaces = Collections.emptySet(); this.access = 1; this.isMixin = false; this.mixin = null; this.methodMapper = null; } public boolean isAbstract() { try {  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return ((this.access & 0x400) != 0); } public ClassInfo$Field findField(FieldInsnNode paramFieldInsnNode, int paramInt) { return findField(paramFieldInsnNode.name, paramFieldInsnNode.desc, paramInt); } public ClassInfo$Field findFieldInHierarchy(FieldNode paramFieldNode, ClassInfo$SearchType paramClassInfo$SearchType) { return findFieldInHierarchy(paramFieldNode.name, paramFieldNode.desc, paramClassInfo$SearchType, ClassInfo$Traversal.NONE); } public String getSuperName() { return this.superName; } public ClassInfo$Method findMethod(MethodInsnNode paramMethodInsnNode, int paramInt) { return findMethod(paramMethodInsnNode.name, paramMethodInsnNode.desc, paramInt); } public static ClassInfo forType(Type paramType) { try { if (paramType.getSort() == 9) return forType(paramType.getElementType());  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  try { if (paramType.getSort() < 9) return null;  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return forName(paramType.getClassName().replace('.', '/')); } public ClassInfo$Method findMethodInHierarchy(MethodNode paramMethodNode, ClassInfo$SearchType paramClassInfo$SearchType) { return findMethodInHierarchy(paramMethodNode.name, paramMethodNode.desc, paramClassInfo$SearchType, ClassInfo$Traversal.NONE); } private <M extends ClassInfo$Member> M findInHierarchy(String paramString1, String paramString2, ClassInfo$SearchType paramClassInfo$SearchType, ClassInfo$Traversal paramClassInfo$Traversal, int paramInt, ClassInfo$Member$Type paramClassInfo$Member$Type) { // Byte code:
/*     */     //   0: aload_3
/*     */     //   1: getstatic org/spongepowered/asm/mixin/transformer/ClassInfo$SearchType.ALL_CLASSES : Lorg/spongepowered/asm/mixin/transformer/ClassInfo$SearchType;
/*     */     //   4: if_acmpne -> 107
/*     */     //   7: aload_0
/*     */     //   8: aload_1
/*     */     //   9: aload_2
/*     */     //   10: iload #5
/*     */     //   12: aload #6
/*     */     //   14: invokespecial findMember : (Ljava/lang/String;Ljava/lang/String;ILorg/spongepowered/asm/mixin/transformer/ClassInfo$Member$Type;)Lorg/spongepowered/asm/mixin/transformer/ClassInfo$Member;
/*     */     //   17: astore #7
/*     */     //   19: aload #7
/*     */     //   21: ifnull -> 31
/*     */     //   24: aload #7
/*     */     //   26: areturn
/*     */     //   27: invokestatic b : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
/*     */     //   30: athrow
/*     */     //   31: aload #4
/*     */     //   33: invokevirtual canTraverse : ()Z
/*     */     //   36: ifeq -> 107
/*     */     //   39: aload_0
/*     */     //   40: getfield mixins : Ljava/util/Set;
/*     */     //   43: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   48: astore #8
/*     */     //   50: aload #8
/*     */     //   52: invokeinterface hasNext : ()Z
/*     */     //   57: ifeq -> 107
/*     */     //   60: aload #8
/*     */     //   62: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   67: checkcast org/spongepowered/asm/mixin/transformer/MixinInfo
/*     */     //   70: astore #9
/*     */     //   72: aload #9
/*     */     //   74: invokevirtual getClassInfo : ()Lorg/spongepowered/asm/mixin/transformer/ClassInfo;
/*     */     //   77: aload_1
/*     */     //   78: aload_2
/*     */     //   79: iload #5
/*     */     //   81: aload #6
/*     */     //   83: invokespecial findMember : (Ljava/lang/String;Ljava/lang/String;ILorg/spongepowered/asm/mixin/transformer/ClassInfo$Member$Type;)Lorg/spongepowered/asm/mixin/transformer/ClassInfo$Member;
/*     */     //   86: astore #10
/*     */     //   88: aload #10
/*     */     //   90: ifnull -> 104
/*     */     //   93: aload_0
/*     */     //   94: aload #10
/*     */     //   96: invokespecial cloneMember : (Lorg/spongepowered/asm/mixin/transformer/ClassInfo$Member;)Lorg/spongepowered/asm/mixin/transformer/ClassInfo$Member;
/*     */     //   99: areturn
/*     */     //   100: invokestatic b : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
/*     */     //   103: athrow
/*     */     //   104: goto -> 50
/*     */     //   107: aload_0
/*     */     //   108: invokevirtual getSuperClass : ()Lorg/spongepowered/asm/mixin/transformer/ClassInfo;
/*     */     //   111: astore #7
/*     */     //   113: aload #7
/*     */     //   115: ifnull -> 191
/*     */     //   118: aload #7
/*     */     //   120: invokevirtual getTargets : ()Ljava/util/List;
/*     */     //   123: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   128: astore #8
/*     */     //   130: aload #8
/*     */     //   132: invokeinterface hasNext : ()Z
/*     */     //   137: ifeq -> 191
/*     */     //   140: aload #8
/*     */     //   142: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   147: checkcast org/spongepowered/asm/mixin/transformer/ClassInfo
/*     */     //   150: astore #9
/*     */     //   152: aload #9
/*     */     //   154: aload_1
/*     */     //   155: aload_2
/*     */     //   156: getstatic org/spongepowered/asm/mixin/transformer/ClassInfo$SearchType.ALL_CLASSES : Lorg/spongepowered/asm/mixin/transformer/ClassInfo$SearchType;
/*     */     //   159: aload #4
/*     */     //   161: invokevirtual next : ()Lorg/spongepowered/asm/mixin/transformer/ClassInfo$Traversal;
/*     */     //   164: iload #5
/*     */     //   166: bipush #-3
/*     */     //   168: iand
/*     */     //   169: aload #6
/*     */     //   171: invokespecial findInHierarchy : (Ljava/lang/String;Ljava/lang/String;Lorg/spongepowered/asm/mixin/transformer/ClassInfo$SearchType;Lorg/spongepowered/asm/mixin/transformer/ClassInfo$Traversal;ILorg/spongepowered/asm/mixin/transformer/ClassInfo$Member$Type;)Lorg/spongepowered/asm/mixin/transformer/ClassInfo$Member;
/*     */     //   174: astore #10
/*     */     //   176: aload #10
/*     */     //   178: ifnull -> 188
/*     */     //   181: aload #10
/*     */     //   183: areturn
/*     */     //   184: invokestatic b : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
/*     */     //   187: athrow
/*     */     //   188: goto -> 130
/*     */     //   191: aload #6
/*     */     //   193: getstatic org/spongepowered/asm/mixin/transformer/ClassInfo$Member$Type.METHOD : Lorg/spongepowered/asm/mixin/transformer/ClassInfo$Member$Type;
/*     */     //   196: if_acmpne -> 373
/*     */     //   199: aload_0
/*     */     //   200: getfield isInterface : Z
/*     */     //   203: ifne -> 229
/*     */     //   206: goto -> 213
/*     */     //   209: invokestatic b : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
/*     */     //   212: athrow
/*     */     //   213: invokestatic getCompatibilityLevel : ()Lorg/spongepowered/asm/mixin/MixinEnvironment$CompatibilityLevel;
/*     */     //   216: invokevirtual supportsMethodsInInterfaces : ()Z
/*     */     //   219: ifeq -> 373
/*     */     //   222: goto -> 229
/*     */     //   225: invokestatic b : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
/*     */     //   228: athrow
/*     */     //   229: aload_0
/*     */     //   230: getfield interfaces : Ljava/util/Set;
/*     */     //   233: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   238: astore #8
/*     */     //   240: aload #8
/*     */     //   242: invokeinterface hasNext : ()Z
/*     */     //   247: ifeq -> 373
/*     */     //   250: aload #8
/*     */     //   252: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   257: checkcast java/lang/String
/*     */     //   260: astore #9
/*     */     //   262: aload #9
/*     */     //   264: invokestatic forName : (Ljava/lang/String;)Lorg/spongepowered/asm/mixin/transformer/ClassInfo;
/*     */     //   267: astore #10
/*     */     //   269: aload #10
/*     */     //   271: ifnonnull -> 307
/*     */     //   274: getstatic org/spongepowered/asm/mixin/transformer/ClassInfo.logger : Lorg/apache/logging/log4j/Logger;
/*     */     //   277: ldc 'Failed to resolve declared interface {} on {}'
/*     */     //   279: iconst_2
/*     */     //   280: anewarray java/lang/Object
/*     */     //   283: dup
/*     */     //   284: iconst_0
/*     */     //   285: aload #9
/*     */     //   287: aastore
/*     */     //   288: dup
/*     */     //   289: iconst_1
/*     */     //   290: aload_0
/*     */     //   291: getfield name : Ljava/lang/String;
/*     */     //   294: aastore
/*     */     //   295: invokeinterface debug : (Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   300: goto -> 240
/*     */     //   303: invokestatic b : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
/*     */     //   306: athrow
/*     */     //   307: aload #10
/*     */     //   309: aload_1
/*     */     //   310: aload_2
/*     */     //   311: getstatic org/spongepowered/asm/mixin/transformer/ClassInfo$SearchType.ALL_CLASSES : Lorg/spongepowered/asm/mixin/transformer/ClassInfo$SearchType;
/*     */     //   314: aload #4
/*     */     //   316: invokevirtual next : ()Lorg/spongepowered/asm/mixin/transformer/ClassInfo$Traversal;
/*     */     //   319: iload #5
/*     */     //   321: bipush #-3
/*     */     //   323: iand
/*     */     //   324: aload #6
/*     */     //   326: invokespecial findInHierarchy : (Ljava/lang/String;Ljava/lang/String;Lorg/spongepowered/asm/mixin/transformer/ClassInfo$SearchType;Lorg/spongepowered/asm/mixin/transformer/ClassInfo$Traversal;ILorg/spongepowered/asm/mixin/transformer/ClassInfo$Member$Type;)Lorg/spongepowered/asm/mixin/transformer/ClassInfo$Member;
/*     */     //   329: astore #11
/*     */     //   331: aload #11
/*     */     //   333: ifnull -> 370
/*     */     //   336: aload_0
/*     */     //   337: getfield isInterface : Z
/*     */     //   340: ifeq -> 359
/*     */     //   343: goto -> 350
/*     */     //   346: invokestatic b : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
/*     */     //   349: athrow
/*     */     //   350: aload #11
/*     */     //   352: goto -> 369
/*     */     //   355: invokestatic b : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
/*     */     //   358: athrow
/*     */     //   359: new org/spongepowered/asm/mixin/transformer/ClassInfo$InterfaceMethod
/*     */     //   362: dup
/*     */     //   363: aload_0
/*     */     //   364: aload #11
/*     */     //   366: invokespecial <init> : (Lorg/spongepowered/asm/mixin/transformer/ClassInfo;Lorg/spongepowered/asm/mixin/transformer/ClassInfo$Member;)V
/*     */     //   369: areturn
/*     */     //   370: goto -> 240
/*     */     //   373: aconst_null
/*     */     //   374: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #240	-> 0
/*     */     //   #299	-> 7
/*     */     //   #273	-> 19
/*     */     //   #263	-> 24
/*     */     //   #131	-> 31
/*     */     //   #197	-> 39
/*     */     //   #95	-> 72
/*     */     //   #143	-> 88
/*     */     //   #90	-> 93
/*     */     //   #31	-> 104
/*     */     //   #81	-> 107
/*     */     //   #112	-> 113
/*     */     //   #231	-> 118
/*     */     //   #235	-> 152
/*     */     //   #175	-> 176
/*     */     //   #312	-> 181
/*     */     //   #108	-> 188
/*     */     //   #58	-> 191
/*     */     //   #30	-> 229
/*     */     //   #134	-> 262
/*     */     //   #86	-> 269
/*     */     //   #139	-> 274
/*     */     //   #43	-> 300
/*     */     //   #224	-> 307
/*     */     //   #76	-> 331
/*     */     //   #260	-> 336
/*     */     //   #133	-> 370
/*     */     //   #4	-> 373
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   19	27	27	java/lang/IllegalArgumentException
/*     */     //   88	100	100	java/lang/IllegalArgumentException
/*     */     //   176	184	184	java/lang/IllegalArgumentException
/*     */     //   191	206	209	java/lang/IllegalArgumentException
/*     */     //   199	222	225	java/lang/IllegalArgumentException
/*     */     //   269	303	303	java/lang/IllegalArgumentException
/*     */     //   331	343	346	java/lang/IllegalArgumentException
/* 315 */     //   336	355	355	java/lang/IllegalArgumentException } public ClassSignature getSignature() { return this.signature.wake(); } void addMixin(MixinInfo paramMixinInfo) { try { if (this.isMixin) throw new IllegalArgumentException("Cannot add target " + this.name + " for " + paramMixinInfo.getClassName() + " because the target is a mixin");  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  this.mixins.add(paramMixinInfo); } private ClassInfo(ClassNode paramClassNode) { this.mixins = new HashSet<MixinInfo>(); this.correspondingTypes = new HashMap<ClassInfo, ClassInfo>(); Profiler.Section section = profiler.begin(1, "class.meta"); try { try { this.name = paramClassNode.name; } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  try { this.superName = (paramClassNode.superName != null) ? paramClassNode.superName : "java/lang/Object"; this.methods = new HashSet<ClassInfo$Method>(); this.fields = new HashSet<ClassInfo$Field>(); } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  try { this.isInterface = ((paramClassNode.access & 0x200) != 0); this.interfaces = new HashSet<String>(); this.access = paramClassNode.access; this.isMixin = paramClassNode instanceof MixinInfo$MixinClassNode; } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  this.mixin = this.isMixin ? ((MixinInfo$MixinClassNode)paramClassNode).getMixin() : null; this.interfaces.addAll(paramClassNode.interfaces); for (MethodNode methodNode : paramClassNode.methods) addMethod(methodNode, this.isMixin);  boolean bool = true; String str = paramClassNode.outerClass; for (FieldNode fieldNode : paramClassNode.fields); this.isProbablyStatic = bool; this.outerName = str; this.methodMapper = new MethodMapper(MixinEnvironment.getCurrentEnvironment(), this); this.signature = ClassSignature.ofLazy(paramClassNode); } finally { section.end(); }  } public Set<MixinInfo> getMixins() { return Collections.unmodifiableSet(this.mixins); } void addInterface(String paramString) { this.interfaces.add(paramString); getSignature().addInterface(paramString); } public ClassInfo$Field findFieldInHierarchy(String paramString1, String paramString2, ClassInfo$SearchType paramClassInfo$SearchType, ClassInfo$Traversal paramClassInfo$Traversal) { return findFieldInHierarchy(paramString1, paramString2, paramClassInfo$SearchType, paramClassInfo$Traversal, 0); } public boolean isPublic() { try {  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return ((this.access & 0x1) != 0); } List<ClassInfo> getTargets() { if (this.mixin != null) { ArrayList<ClassInfo> arrayList = new ArrayList(); arrayList.add(this); arrayList.addAll(this.mixin.getTargets()); }  return (List<ClassInfo>)ImmutableList.of(this); } public Set<String> getInterfaces() { return Collections.unmodifiableSet(this.interfaces); } public boolean isInterface() { return this.isInterface; } private static ClassInfo getCommonSuperClass(ClassInfo paramClassInfo1, ClassInfo paramClassInfo2) { return getCommonSuperClass(paramClassInfo1, paramClassInfo2, false); } public ClassInfo findSuperClass(String paramString, ClassInfo$Traversal paramClassInfo$Traversal) { return findSuperClass(paramString, paramClassInfo$Traversal, false, new HashSet<String>()); } public boolean hasSuperClass(ClassInfo paramClassInfo) { return hasSuperClass(paramClassInfo, ClassInfo$Traversal.NONE, false); } public ClassInfo$Method findMethod(MethodInsnNode paramMethodInsnNode) { return findMethod(paramMethodInsnNode.name, paramMethodInsnNode.desc, 0); } public ClassInfo getOuterClass() { try { if (this.outerClass == null) try { if (this.outerName != null) this.outerClass = forName(this.outerName);  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }   } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return this.outerClass; } public boolean hasMixinTargetInHierarchy() { try { if (this.isMixin) return false;  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  ClassInfo classInfo = getSuperClass(); while (true) { try { if (classInfo != null) try { if (classInfo != OBJECT) { try { if (classInfo.mixins.size() > 0) return true;  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  classInfo = classInfo.getSuperClass(); }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }   } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  break; }  return false; } public static ClassInfo getCommonSuperClassOrInterface(Type paramType1, Type paramType2) { try { if (paramType1 != null) try { if (paramType2 != null) try { if (paramType1.getSort() == 10) try { if (paramType2.getSort() == 10) return getCommonSuperClassOrInterface(forType(paramType1), forType(paramType2));  return OBJECT; } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }   } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }   } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }   } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return OBJECT; } public ClassInfo findSuperClass(String paramString) { return findSuperClass(paramString, ClassInfo$Traversal.NONE); } public ClassInfo$Method findMethod(MethodNode paramMethodNode, int paramInt) { return findMethod(paramMethodNode.name, paramMethodNode.desc, paramInt); } public int getAccess() { return this.access; }
/*     */    public ClassInfo$Method findMethodInHierarchy(String paramString1, String paramString2, ClassInfo$SearchType paramClassInfo$SearchType, ClassInfo$Traversal paramClassInfo$Traversal, int paramInt) {
/* 317 */     return findInHierarchy(paramString1, paramString2, paramClassInfo$SearchType, paramClassInfo$Traversal, paramInt, ClassInfo$Member$Type.METHOD);
/*     */   }
/*     */   
/*     */   private static IllegalArgumentException b(IllegalArgumentException paramIllegalArgumentException) {
/*     */     return paramIllegalArgumentException;
/*     */   }
/*     */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\ClassInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */