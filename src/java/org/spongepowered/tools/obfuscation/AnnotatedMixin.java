/*     */ package org.spongepowered.tools.obfuscation;class AnnotatedMixin { private final AnnotationHandle annotation; private final Messager messager; private final ITypeHandleProvider typeProvider; private final IObfuscationManager obf; private final IMappingConsumer mappings; private final TypeElement mixin; private final List<ExecutableElement> methods; private final TypeHandle handle; private final List<TypeHandle> targets; @Deprecated
/*   2 */   public TypeHandle getPrimaryTarget() { return this.primaryTarget; }
/*     */   
/*     */   private final TypeHandle primaryTarget; private final String classRef; private final boolean remap; private final boolean virtual; private final AnnotatedMixinElementHandlerOverwrite overwrites; private final AnnotatedMixinElementHandlerShadow shadows; private final AnnotatedMixinElementHandlerInjector injectors; private final AnnotatedMixinElementHandlerAccessor accessors; private final AnnotatedMixinElementHandlerSoftImplements softImplements; private boolean validated;
/*     */   
/*     */   private void addTarget(TypeHandle paramTypeHandle) {
/*   7 */     this.targets.add(paramTypeHandle);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerOverwrite(ExecutableElement paramExecutableElement, AnnotationHandle paramAnnotationHandle, boolean paramBoolean) {
/*  17 */     this.methods.remove(paramExecutableElement);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     this.overwrites.registerOverwrite(new AnnotatedMixinElementHandlerOverwrite$AnnotatedElementOverwrite(paramExecutableElement, paramAnnotationHandle, paramBoolean));
/*     */   }
/*     */   public String toString() {
/*     */     return this.mixin.getSimpleName().toString();
/*     */   }
/*     */   public AnnotationHandle getAnnotation() {
/*     */     return this.annotation;
/*     */   }
/*     */   private void addSoftTarget(TypeHandle paramTypeHandle, String paramString) {
/*     */     ObfuscationData obfuscationData = this.obf.getDataProvider().getObfClass(paramTypeHandle);
/*     */     try {
/*     */       if (!obfuscationData.isEmpty())
/*     */         this.obf.getReferenceManager().addClassMapping(this.classRef, paramString, obfuscationData); 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/* 122 */     addTarget(paramTypeHandle);
/*     */   }
/*     */   
/*     */   public boolean isInterface() {
/*     */     try {
/*     */     
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return (this.mixin.getKind() == ElementKind.INTERFACE);
/*     */   }
/*     */   
/*     */   public void registerAccessor(ExecutableElement paramExecutableElement, AnnotationHandle paramAnnotationHandle, boolean paramBoolean) {
/*     */     this.methods.remove(paramExecutableElement);
/*     */     this.accessors.registerAccessor(new AnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor(paramExecutableElement, paramAnnotationHandle, paramBoolean));
/*     */   }
/*     */   
/*     */   private void runFinalValidation() {
/*     */     for (ExecutableElement executableElement : this.methods)
/*     */       this.overwrites.registerMerge(executableElement); 
/*     */   }
/*     */   
/*     */   public List<TypeHandle> getTargets() {
/*     */     return this.targets;
/*     */   }
/*     */   
/*     */   public void registerInvoker(ExecutableElement paramExecutableElement, AnnotationHandle paramAnnotationHandle, boolean paramBoolean) {
/*     */     this.methods.remove(paramExecutableElement);
/*     */     this.accessors.registerAccessor(new AnnotatedMixinElementHandlerAccessor$AnnotatedElementInvoker(paramExecutableElement, paramAnnotationHandle, paramBoolean));
/*     */   }
/*     */   
/*     */   public void registerInjector(ExecutableElement paramExecutableElement, AnnotationHandle paramAnnotationHandle, InjectorRemap paramInjectorRemap) {
/*     */     this.methods.remove(paramExecutableElement);
/*     */     this.injectors.registerInjector(new AnnotatedMixinElementHandlerInjector$AnnotatedElementInjector(paramExecutableElement, paramAnnotationHandle, paramInjectorRemap));
/*     */     List list1 = paramAnnotationHandle.getAnnotationList("at");
/*     */     for (AnnotationHandle annotationHandle : list1)
/*     */       registerInjectionPoint(paramExecutableElement, paramAnnotationHandle, annotationHandle, paramInjectorRemap, "@At(%s)"); 
/*     */     List list2 = paramAnnotationHandle.getAnnotationList("slice");
/*     */     for (AnnotationHandle annotationHandle1 : list2) {
/*     */       String str = (String)annotationHandle1.getValue("id", "");
/*     */       AnnotationHandle annotationHandle2 = annotationHandle1.getAnnotation("from");
/*     */     } 
/*     */   }
/*     */   
/*     */   AnnotatedMixin runValidators(IMixinValidator.ValidationPass paramValidationPass, Collection<IMixinValidator> paramCollection) {
/*     */     for (IMixinValidator iMixinValidator : paramCollection) {
/*     */       try {
/*     */         if (!iMixinValidator.validate(paramValidationPass, this.mixin, this.annotation, this.targets))
/*     */           break; 
/*     */       } catch (RuntimeException runtimeException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     try {
/*     */       if (paramValidationPass == IMixinValidator.ValidationPass.FINAL)
/*     */         try {
/*     */           if (!this.validated) {
/*     */             this.validated = true;
/*     */             runFinalValidation();
/*     */           } 
/*     */         } catch (RuntimeException runtimeException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return this;
/*     */   }
/*     */   
/*     */   public boolean isMultiTarget() {
/*     */     try {
/*     */     
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return (this.targets.size() > 1);
/*     */   }
/*     */   
/*     */   public IMappingConsumer getMappings() {
/*     */     return this.mappings;
/*     */   }
/*     */   
/*     */   public TypeHandle getHandle() {
/*     */     return this.handle;
/*     */   }
/*     */   
/*     */   private TypeHandle initTargets() {
/*     */     TypeHandle typeHandle = null;
/*     */     try {
/*     */       for (TypeMirror typeMirror : this.annotation.getList()) {
/*     */         TypeHandle typeHandle1 = new TypeHandle((DeclaredType)typeMirror);
/*     */         try {
/*     */           if (this.targets.contains(typeHandle1))
/*     */             continue; 
/*     */         } catch (Exception exception) {
/*     */           throw b(null);
/*     */         } 
/*     */         addTarget(typeHandle1);
/*     */       } 
/*     */     } catch (Exception exception) {
/*     */       printMessage(Diagnostic.Kind.WARNING, "Error processing public targets: " + exception.getClass().getName() + ": " + exception.getMessage(), this);
/*     */     } 
/*     */     try {
/*     */       for (String str : this.annotation.getList("targets"))
/*     */         TypeHandle typeHandle1 = this.typeProvider.getTypeHandle(str); 
/*     */     } catch (Exception exception) {
/*     */       printMessage(Diagnostic.Kind.WARNING, "Error processing private targets: " + exception.getClass().getName() + ": " + exception.getMessage(), this);
/*     */     } 
/*     */     try {
/*     */       if (typeHandle == null)
/*     */         printMessage(Diagnostic.Kind.ERROR, "Mixin has no targets", this); 
/*     */     } catch (Exception exception) {
/*     */       throw b(null);
/*     */     } 
/*     */     return typeHandle;
/*     */   }
/*     */   
/*     */   private void printMessage(Diagnostic.Kind paramKind, CharSequence paramCharSequence, AnnotatedMixin paramAnnotatedMixin) {
/*     */     this.messager.printMessage(paramKind, paramCharSequence, this.mixin, this.annotation.asMirror());
/*     */   }
/*     */   
/*     */   public String getClassRef() {
/*     */     return this.classRef;
/*     */   }
/*     */   
/*     */   public AnnotatedMixin(IMixinAnnotationProcessor paramIMixinAnnotationProcessor, TypeElement paramTypeElement) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokespecial <init> : ()V
/*     */     //   4: aload_0
/*     */     //   5: new java/util/ArrayList
/*     */     //   8: dup
/*     */     //   9: invokespecial <init> : ()V
/*     */     //   12: putfield targets : Ljava/util/List;
/*     */     //   15: aload_0
/*     */     //   16: iconst_0
/*     */     //   17: putfield validated : Z
/*     */     //   20: aload_0
/*     */     //   21: aload_1
/*     */     //   22: invokeinterface getTypeProvider : ()Lorg/spongepowered/tools/obfuscation/interfaces/ITypeHandleProvider;
/*     */     //   27: putfield typeProvider : Lorg/spongepowered/tools/obfuscation/interfaces/ITypeHandleProvider;
/*     */     //   30: aload_0
/*     */     //   31: aload_1
/*     */     //   32: invokeinterface getObfuscationManager : ()Lorg/spongepowered/tools/obfuscation/interfaces/IObfuscationManager;
/*     */     //   37: putfield obf : Lorg/spongepowered/tools/obfuscation/interfaces/IObfuscationManager;
/*     */     //   40: aload_0
/*     */     //   41: aload_0
/*     */     //   42: getfield obf : Lorg/spongepowered/tools/obfuscation/interfaces/IObfuscationManager;
/*     */     //   45: invokeinterface createMappingConsumer : ()Lorg/spongepowered/tools/obfuscation/mapping/IMappingConsumer;
/*     */     //   50: putfield mappings : Lorg/spongepowered/tools/obfuscation/mapping/IMappingConsumer;
/*     */     //   53: aload_0
/*     */     //   54: aload_1
/*     */     //   55: putfield messager : Ljavax/annotation/processing/Messager;
/*     */     //   58: aload_0
/*     */     //   59: aload_2
/*     */     //   60: putfield mixin : Ljavax/lang/model/element/TypeElement;
/*     */     //   63: aload_0
/*     */     //   64: new org/spongepowered/tools/obfuscation/mirror/TypeHandle
/*     */     //   67: dup
/*     */     //   68: aload_2
/*     */     //   69: invokespecial <init> : (Ljavax/lang/model/element/TypeElement;)V
/*     */     //   72: putfield handle : Lorg/spongepowered/tools/obfuscation/mirror/TypeHandle;
/*     */     //   75: aload_0
/*     */     //   76: new java/util/ArrayList
/*     */     //   79: dup
/*     */     //   80: aload_0
/*     */     //   81: getfield handle : Lorg/spongepowered/tools/obfuscation/mirror/TypeHandle;
/*     */     //   84: iconst_1
/*     */     //   85: anewarray javax/lang/model/element/ElementKind
/*     */     //   88: dup
/*     */     //   89: iconst_0
/*     */     //   90: getstatic javax/lang/model/element/ElementKind.METHOD : Ljavax/lang/model/element/ElementKind;
/*     */     //   93: aastore
/*     */     //   94: invokevirtual getEnclosedElements : ([Ljavax/lang/model/element/ElementKind;)Ljava/util/List;
/*     */     //   97: invokespecial <init> : (Ljava/util/Collection;)V
/*     */     //   100: putfield methods : Ljava/util/List;
/*     */     //   103: aload_0
/*     */     //   104: aload_0
/*     */     //   105: getfield handle : Lorg/spongepowered/tools/obfuscation/mirror/TypeHandle;
/*     */     //   108: ldc org/spongepowered/asm/mixin/Pseudo
/*     */     //   110: invokevirtual getAnnotation : (Ljava/lang/Class;)Lorg/spongepowered/tools/obfuscation/mirror/AnnotationHandle;
/*     */     //   113: invokevirtual exists : ()Z
/*     */     //   116: putfield virtual : Z
/*     */     //   119: aload_0
/*     */     //   120: aload_0
/*     */     //   121: getfield handle : Lorg/spongepowered/tools/obfuscation/mirror/TypeHandle;
/*     */     //   124: ldc org/spongepowered/asm/mixin/Mixin
/*     */     //   126: invokevirtual getAnnotation : (Ljava/lang/Class;)Lorg/spongepowered/tools/obfuscation/mirror/AnnotationHandle;
/*     */     //   129: putfield annotation : Lorg/spongepowered/tools/obfuscation/mirror/AnnotationHandle;
/*     */     //   132: aload_0
/*     */     //   133: aload_2
/*     */     //   134: invokestatic getInternalName : (Ljavax/lang/model/element/TypeElement;)Ljava/lang/String;
/*     */     //   137: putfield classRef : Ljava/lang/String;
/*     */     //   140: aload_0
/*     */     //   141: aload_0
/*     */     //   142: invokespecial initTargets : ()Lorg/spongepowered/tools/obfuscation/mirror/TypeHandle;
/*     */     //   145: putfield primaryTarget : Lorg/spongepowered/tools/obfuscation/mirror/TypeHandle;
/*     */     //   148: aload_0
/*     */     //   149: aload_0
/*     */     //   150: getfield annotation : Lorg/spongepowered/tools/obfuscation/mirror/AnnotationHandle;
/*     */     //   153: ldc 'remap'
/*     */     //   155: iconst_1
/*     */     //   156: invokevirtual getBoolean : (Ljava/lang/String;Z)Z
/*     */     //   159: ifeq -> 182
/*     */     //   162: aload_0
/*     */     //   163: getfield targets : Ljava/util/List;
/*     */     //   166: invokeinterface size : ()I
/*     */     //   171: ifle -> 182
/*     */     //   174: iconst_1
/*     */     //   175: goto -> 183
/*     */     //   178: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   181: athrow
/*     */     //   182: iconst_0
/*     */     //   183: putfield remap : Z
/*     */     //   186: aload_0
/*     */     //   187: new org/spongepowered/tools/obfuscation/AnnotatedMixinElementHandlerOverwrite
/*     */     //   190: dup
/*     */     //   191: aload_1
/*     */     //   192: aload_0
/*     */     //   193: invokespecial <init> : (Lorg/spongepowered/tools/obfuscation/interfaces/IMixinAnnotationProcessor;Lorg/spongepowered/tools/obfuscation/AnnotatedMixin;)V
/*     */     //   196: putfield overwrites : Lorg/spongepowered/tools/obfuscation/AnnotatedMixinElementHandlerOverwrite;
/*     */     //   199: aload_0
/*     */     //   200: new org/spongepowered/tools/obfuscation/AnnotatedMixinElementHandlerShadow
/*     */     //   203: dup
/*     */     //   204: aload_1
/*     */     //   205: aload_0
/*     */     //   206: invokespecial <init> : (Lorg/spongepowered/tools/obfuscation/interfaces/IMixinAnnotationProcessor;Lorg/spongepowered/tools/obfuscation/AnnotatedMixin;)V
/*     */     //   209: putfield shadows : Lorg/spongepowered/tools/obfuscation/AnnotatedMixinElementHandlerShadow;
/*     */     //   212: aload_0
/*     */     //   213: new org/spongepowered/tools/obfuscation/AnnotatedMixinElementHandlerInjector
/*     */     //   216: dup
/*     */     //   217: aload_1
/*     */     //   218: aload_0
/*     */     //   219: invokespecial <init> : (Lorg/spongepowered/tools/obfuscation/interfaces/IMixinAnnotationProcessor;Lorg/spongepowered/tools/obfuscation/AnnotatedMixin;)V
/*     */     //   222: putfield injectors : Lorg/spongepowered/tools/obfuscation/AnnotatedMixinElementHandlerInjector;
/*     */     //   225: aload_0
/*     */     //   226: new org/spongepowered/tools/obfuscation/AnnotatedMixinElementHandlerAccessor
/*     */     //   229: dup
/*     */     //   230: aload_1
/*     */     //   231: aload_0
/*     */     //   232: invokespecial <init> : (Lorg/spongepowered/tools/obfuscation/interfaces/IMixinAnnotationProcessor;Lorg/spongepowered/tools/obfuscation/AnnotatedMixin;)V
/*     */     //   235: putfield accessors : Lorg/spongepowered/tools/obfuscation/AnnotatedMixinElementHandlerAccessor;
/*     */     //   238: aload_0
/*     */     //   239: new org/spongepowered/tools/obfuscation/AnnotatedMixinElementHandlerSoftImplements
/*     */     //   242: dup
/*     */     //   243: aload_1
/*     */     //   244: aload_0
/*     */     //   245: invokespecial <init> : (Lorg/spongepowered/tools/obfuscation/interfaces/IMixinAnnotationProcessor;Lorg/spongepowered/tools/obfuscation/AnnotatedMixin;)V
/*     */     //   248: putfield softImplements : Lorg/spongepowered/tools/obfuscation/AnnotatedMixinElementHandlerSoftImplements;
/*     */     //   251: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #92	-> 0
/*     */     //   #111	-> 4
/*     */     //   #8	-> 15
/*     */     //   #26	-> 20
/*     */     //   #47	-> 30
/*     */     //   #53	-> 40
/*     */     //   #35	-> 53
/*     */     //   #44	-> 58
/*     */     //   #72	-> 63
/*     */     //   #114	-> 75
/*     */     //   #68	-> 103
/*     */     //   #115	-> 119
/*     */     //   #121	-> 132
/*     */     //   #20	-> 140
/*     */     //   #75	-> 148
/*     */     //   #108	-> 186
/*     */     //   #82	-> 199
/*     */     //   #58	-> 212
/*     */     //   #69	-> 225
/*     */     //   #42	-> 238
/*     */     //   #97	-> 251
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   162	178	178	java/lang/RuntimeException
/*     */   }
/*     */   
/*     */   public boolean remap() {
/*     */     return this.remap;
/*     */   }
/*     */   
/*     */   public void registerInjectionPoint(ExecutableElement paramExecutableElement, AnnotationHandle paramAnnotationHandle1, AnnotationHandle paramAnnotationHandle2, InjectorRemap paramInjectorRemap, String paramString) {
/*     */     this.injectors.registerInjectionPoint(new AnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint(paramExecutableElement, paramAnnotationHandle1, paramAnnotationHandle2, paramInjectorRemap), paramString);
/*     */   }
/*     */   
/*     */   public void registerSoftImplements(AnnotationHandle paramAnnotationHandle) {
/*     */     this.softImplements.process(paramAnnotationHandle);
/*     */   }
/*     */   
/*     */   public void registerShadow(VariableElement paramVariableElement, AnnotationHandle paramAnnotationHandle, boolean paramBoolean) {
/*     */     this.shadows.getClass();
/*     */     this.shadows.registerShadow(new AnnotatedMixinElementHandlerShadow$AnnotatedElementShadowField(this.shadows, paramVariableElement, paramAnnotationHandle, paramBoolean));
/*     */   }
/*     */   
/*     */   public TypeElement getMixin() {
/*     */     return this.mixin;
/*     */   }
/*     */   
/*     */   public void registerShadow(ExecutableElement paramExecutableElement, AnnotationHandle paramAnnotationHandle, boolean paramBoolean) {
/*     */     this.methods.remove(paramExecutableElement);
/*     */     this.shadows.getClass();
/*     */     this.shadows.registerShadow(new AnnotatedMixinElementHandlerShadow$AnnotatedElementShadowMethod(this.shadows, paramExecutableElement, paramAnnotationHandle, paramBoolean));
/*     */   }
/*     */   
/*     */   private static Exception b(Exception paramException) {
/*     */     return paramException;
/*     */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\AnnotatedMixin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */