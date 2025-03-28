/*     */ package org.spongepowered.tools.obfuscation;final class AnnotatedMixins implements IMixinAnnotationProcessor, ITokenProvider, ITypeHandleProvider, IJavadocProvider {
/*     */   public void printMessage(Diagnostic.Kind paramKind, CharSequence paramCharSequence, Element paramElement) {
/*   3 */     this.processingEnv.getMessager().printMessage(paramKind, paramCharSequence, paramElement);
/*     */   } public String getOption(String paramString) {
/*     */     
/*   6 */     try { if (paramString == null)
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
/*  45 */         return null; }  } catch (NullPointerException nullPointerException) { throw b(null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 120 */     String str = this.processingEnv.getOptions().get(paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try { if (str != null)
/* 154 */         return str;  } catch (NullPointerException nullPointerException) { throw b(null); }
/*     */     
/*     */     return getProperties().getProperty(paramString);
/*     */   }
/*     */   private final Map<String, AnnotatedMixin> mixins = new HashMap<String, AnnotatedMixin>();
/*     */   public Properties getProperties() {
/*     */     if (this.properties == null) {
/*     */       this.properties = new Properties();
/*     */       try {
/*     */         Filer filer = this.processingEnv.getFiler();
/*     */         FileObject fileObject = filer.getResource(StandardLocation.SOURCE_PATH, "", "mixin.properties");
/*     */         if (fileObject != null) {
/*     */           InputStream inputStream = fileObject.openInputStream();
/*     */           this.properties.load(inputStream);
/*     */           inputStream.close();
/*     */         } 
/*     */       } catch (Exception exception) {}
/*     */     } 
/*     */     return this.properties;
/*     */   }
/*     */   public Collection<TypeMirror> getMixinsTargeting(TypeElement paramTypeElement) { ArrayList<TypeMirror> arrayList = new ArrayList();
/*     */     for (TypeReference typeReference : this.targets.getMixinsTargeting(paramTypeElement))
/* 176 */     { TypeHandle typeHandle = typeReference.getHandle(this.processingEnv); try { if (typeHandle != null) arrayList.add(typeHandle.getType());  } catch (NullPointerException nullPointerException) { throw b(null); }  }  return arrayList; }
/* 177 */   public TypeHandle getTypeHandle(String paramString) { paramString = paramString.replace('/', '.'); Elements elements = this.processingEnv.getElementUtils(); TypeElement typeElement = elements.getTypeElement(paramString); try { if (typeElement != null) try { return new TypeHandle(typeElement); } catch (NullPointerException nullPointerException) {}  } catch (ClassCastException classCastException) { throw b(null); }  int i = paramString.lastIndexOf('.'); if (i > -1) { String str = paramString.substring(0, i); PackageElement packageElement = elements.getPackageElement(str); try { if (packageElement != null) return new TypeHandle(packageElement, paramString);  } catch (NullPointerException nullPointerException) { throw b(null); }  }  return null; } private AnnotatedMixins(ProcessingEnvironment paramProcessingEnvironment) { this.env = detectEnvironment(paramProcessingEnvironment); this.processingEnv = paramProcessingEnvironment; printMessage(Diagnostic.Kind.NOTE, "SpongePowered MIXIN Annotation Processor Version=0.7.11"); this.targets = initTargetMap(); this.obf = new ObfuscationManager(this); this.obf.init(); this.validators = (List<IMixinValidator>)ImmutableList.of(new ParentValidator(this), new TargetValidator(this)); initTokenCache(getOption("tokens")); } public String getJavadoc(Element paramElement) { Elements elements = this.processingEnv.getElementUtils(); return elements.getDocComment(paramElement); }
/*     */   public void onPassCompleted(RoundEnvironment paramRoundEnvironment) { try { if (!"true".equalsIgnoreCase(getOption("disableTargetExport")))
/*     */         this.targets.write(true);  }
/*     */     catch (NullPointerException nullPointerException) { throw b(null); }
/*     */      try {  }
/* 182 */     catch (NullPointerException nullPointerException) { throw b(null); }  for (AnnotatedMixin annotatedMixin : paramRoundEnvironment.processingOver() ? (Object<?>)this.mixins.values() : (Object<?>)this.mixinsForPass) { try {  } catch (NullPointerException nullPointerException) { throw b(null); }  }  } public TypeHandle getSimulatedHandle(String paramString, TypeMirror paramTypeMirror) { paramString = paramString.replace('/', '.'); int i = paramString.lastIndexOf('.'); if (i > -1) { String str = paramString.substring(0, i); PackageElement packageElement = this.processingEnv.getElementUtils().getPackageElement(str); try { if (packageElement != null) return (TypeHandle)new TypeHandleSimulated(packageElement, paramString, paramTypeMirror);  } catch (NullPointerException nullPointerException) { throw b(null); }  }  return (TypeHandle)new TypeHandleSimulated(paramString, paramTypeMirror); } private boolean shouldRemap(AnnotatedMixin paramAnnotatedMixin, AnnotationHandle paramAnnotationHandle) { return paramAnnotationHandle.getBoolean("remap", paramAnnotatedMixin.remap()); } public void printMessage(Diagnostic.Kind paramKind, CharSequence paramCharSequence, Element paramElement, AnnotationMirror paramAnnotationMirror, AnnotationValue paramAnnotationValue) { this.processingEnv.getMessager().printMessage(paramKind, paramCharSequence, paramElement, paramAnnotationMirror, paramAnnotationValue); }
/*     */   public ITokenProvider getTokenProvider() { return this; }
/* 184 */   private IMixinAnnotationProcessor.CompilerEnvironment detectEnvironment(ProcessingEnvironment paramProcessingEnvironment) { try { if (paramProcessingEnvironment.getClass().getName().contains("jdt")) return IMixinAnnotationProcessor.CompilerEnvironment.JDT;  } catch (NullPointerException nullPointerException) { throw b(null); }
/*     */     
/*     */     return IMixinAnnotationProcessor.CompilerEnvironment.JAVAC; }
/*     */ 
/*     */   
/*     */   public Integer getToken(String paramString) {
/*     */     try {
/*     */       if (this.tokenCache.containsKey(paramString))
/*     */         return this.tokenCache.get(paramString); 
/*     */     } catch (Exception exception) {
/*     */       throw b(null);
/*     */     } 
/*     */     String str = getOption(paramString);
/*     */     Integer integer = null;
/*     */     try {
/*     */       integer = Integer.valueOf(Integer.parseInt(str));
/*     */     } catch (Exception exception) {}
/*     */     this.tokenCache.put(paramString, integer);
/*     */     return integer;
/*     */   }
/*     */   
/*     */   public void registerAccessor(TypeElement paramTypeElement, ExecutableElement paramExecutableElement) {
/*     */     AnnotatedMixin annotatedMixin = getMixin(paramTypeElement);
/*     */     try {
/*     */       if (annotatedMixin == null) {
/*     */         printMessage(Diagnostic.Kind.ERROR, "Found @Accessor annotation on a non-mixin method", paramExecutableElement);
/*     */         return;
/*     */       } 
/*     */     } catch (NullPointerException nullPointerException) {
/*     */       throw b(null);
/*     */     } 
/*     */     AnnotationHandle annotationHandle = AnnotationHandle.of(paramExecutableElement, Accessor.class);
/*     */     annotatedMixin.registerAccessor(paramExecutableElement, annotationHandle, shouldRemap(annotatedMixin, annotationHandle));
/*     */   }
/*     */   
/*     */   public void onPassStarted() {
/*     */     this.mixinsForPass.clear();
/*     */   }
/*     */   
/*     */   public Collection<TypeMirror> getMixinsTargeting(TypeMirror paramTypeMirror) {
/*     */     return getMixinsTargeting((TypeElement)((DeclaredType)paramTypeMirror).asElement());
/*     */   }
/*     */   
/*     */   public static AnnotatedMixins getMixinsForEnvironment(ProcessingEnvironment paramProcessingEnvironment) {
/*     */     AnnotatedMixins annotatedMixins = instances.get(paramProcessingEnvironment);
/*     */     if (annotatedMixins == null) {
/*     */       annotatedMixins = new AnnotatedMixins(paramProcessingEnvironment);
/*     */       instances.put(paramProcessingEnvironment, annotatedMixins);
/*     */     } 
/*     */     return annotatedMixins;
/*     */   }
/*     */   
/*     */   private static Map<ProcessingEnvironment, AnnotatedMixins> instances = new HashMap<ProcessingEnvironment, AnnotatedMixins>();
/*     */   private final List<AnnotatedMixin> mixinsForPass = new ArrayList<AnnotatedMixin>();
/*     */   
/*     */   public ITypeHandleProvider getTypeProvider() {
/*     */     return this;
/*     */   }
/*     */   
/*     */   public void clear() {
/*     */     this.mixins.clear();
/*     */   }
/*     */   
/*     */   public void writeMappings() {
/*     */     this.obf.writeMappings();
/*     */   }
/*     */   
/*     */   public void registerInvoker(TypeElement paramTypeElement, ExecutableElement paramExecutableElement) {
/*     */     AnnotatedMixin annotatedMixin = getMixin(paramTypeElement);
/*     */     try {
/*     */       if (annotatedMixin == null) {
/*     */         printMessage(Diagnostic.Kind.ERROR, "Found @Accessor annotation on a non-mixin method", paramExecutableElement);
/*     */         return;
/*     */       } 
/*     */     } catch (NullPointerException nullPointerException) {
/*     */       throw b(null);
/*     */     } 
/*     */     AnnotationHandle annotationHandle = AnnotationHandle.of(paramExecutableElement, Invoker.class);
/*     */     annotatedMixin.registerInvoker(paramExecutableElement, annotationHandle, shouldRemap(annotatedMixin, annotationHandle));
/*     */   }
/*     */   
/*     */   public IJavadocProvider getJavadocProvider() {
/*     */     return this;
/*     */   }
/*     */   
/*     */   public void registerShadow(TypeElement paramTypeElement, VariableElement paramVariableElement, AnnotationHandle paramAnnotationHandle) {
/*     */     AnnotatedMixin annotatedMixin = getMixin(paramTypeElement);
/*     */     try {
/*     */       if (annotatedMixin == null) {
/*     */         printMessage(Diagnostic.Kind.ERROR, "Found @Shadow annotation on a non-mixin field", paramVariableElement);
/*     */         return;
/*     */       } 
/*     */     } catch (NullPointerException nullPointerException) {
/*     */       throw b(null);
/*     */     } 
/*     */     annotatedMixin.registerShadow(paramVariableElement, paramAnnotationHandle, shouldRemap(annotatedMixin, paramAnnotationHandle));
/*     */   }
/*     */   
/*     */   private final Map<String, Integer> tokenCache = new HashMap<String, Integer>();
/*     */   private static final String MAPID_SYSTEM_PROPERTY = "mixin.target.mapid";
/*     */   private final IMixinAnnotationProcessor.CompilerEnvironment env;
/*     */   private final ProcessingEnvironment processingEnv;
/*     */   private final IObfuscationManager obf;
/*     */   private final List<IMixinValidator> validators;
/*     */   private final TargetMap targets;
/*     */   private Properties properties;
/*     */   
/*     */   public void registerOverwrite(TypeElement paramTypeElement, ExecutableElement paramExecutableElement) {
/*     */     AnnotatedMixin annotatedMixin = getMixin(paramTypeElement);
/*     */     try {
/*     */       if (annotatedMixin == null) {
/*     */         printMessage(Diagnostic.Kind.ERROR, "Found @Overwrite annotation on a non-mixin method", paramExecutableElement);
/*     */         return;
/*     */       } 
/*     */     } catch (NullPointerException nullPointerException) {
/*     */       throw b(null);
/*     */     } 
/*     */     AnnotationHandle annotationHandle = AnnotationHandle.of(paramExecutableElement, Overwrite.class);
/*     */     annotatedMixin.registerOverwrite(paramExecutableElement, annotationHandle, shouldRemap(annotatedMixin, annotationHandle));
/*     */   }
/*     */   
/*     */   public AnnotatedMixin getMixin(String paramString) {
/*     */     return this.mixins.get(paramString);
/*     */   }
/*     */   
/*     */   public void registerSoftImplements(TypeElement paramTypeElement, AnnotationHandle paramAnnotationHandle) {
/*     */     AnnotatedMixin annotatedMixin = getMixin(paramTypeElement);
/*     */     try {
/*     */       if (annotatedMixin == null) {
/*     */         printMessage(Diagnostic.Kind.ERROR, "Found @Implements annotation on a non-mixin class");
/*     */         return;
/*     */       } 
/*     */     } catch (NullPointerException nullPointerException) {
/*     */       throw b(null);
/*     */     } 
/*     */     annotatedMixin.registerSoftImplements(paramAnnotationHandle);
/*     */   }
/*     */   
/*     */   public void printMessage(Diagnostic.Kind paramKind, CharSequence paramCharSequence) {
/*     */     try {
/*     */       if (this.env != IMixinAnnotationProcessor.CompilerEnvironment.JAVAC) {
/*     */         try {
/*     */           if (paramKind != Diagnostic.Kind.NOTE) {
/*     */             this.processingEnv.getMessager().printMessage(paramKind, paramCharSequence);
/*     */             return;
/*     */           } 
/*     */         } catch (NullPointerException nullPointerException) {
/*     */           throw b(null);
/*     */         } 
/*     */         return;
/*     */       } 
/*     */     } catch (NullPointerException nullPointerException) {
/*     */       throw b(null);
/*     */     } 
/*     */     this.processingEnv.getMessager().printMessage(paramKind, paramCharSequence);
/*     */   }
/*     */   
/*     */   protected TargetMap initTargetMap() {
/*     */     TargetMap targetMap = TargetMap.create(System.getProperty("mixin.target.mapid"));
/*     */     System.setProperty("mixin.target.mapid", targetMap.getSessionId());
/*     */     String str = getOption("dependencyTargetsFile");
/*     */     try {
/*     */       if (str != null)
/*     */         try {
/*     */           targetMap.readImports(new File(str));
/*     */         } catch (IOException iOException) {
/*     */           printMessage(Diagnostic.Kind.WARNING, "Could not read from specified imports file: " + str);
/*     */         }  
/*     */     } catch (NullPointerException nullPointerException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return targetMap;
/*     */   }
/*     */   
/*     */   public void registerShadow(TypeElement paramTypeElement, ExecutableElement paramExecutableElement, AnnotationHandle paramAnnotationHandle) {
/*     */     AnnotatedMixin annotatedMixin = getMixin(paramTypeElement);
/*     */     try {
/*     */       if (annotatedMixin == null) {
/*     */         printMessage(Diagnostic.Kind.ERROR, "Found @Shadow annotation on a non-mixin method", paramExecutableElement);
/*     */         return;
/*     */       } 
/*     */     } catch (NullPointerException nullPointerException) {
/*     */       throw b(null);
/*     */     } 
/*     */     annotatedMixin.registerShadow(paramExecutableElement, paramAnnotationHandle, shouldRemap(annotatedMixin, paramAnnotationHandle));
/*     */   }
/*     */   
/*     */   public AnnotatedMixin getMixin(TypeElement paramTypeElement) {
/*     */     return getMixin(paramTypeElement.getQualifiedName().toString());
/*     */   }
/*     */   
/*     */   public ProcessingEnvironment getProcessingEnvironment() {
/*     */     return this.processingEnv;
/*     */   }
/*     */   
/*     */   private void initTokenCache(String paramString) {
/*     */     if (paramString != null) {
/*     */       Pattern pattern = Pattern.compile("^([A-Z0-9\\-_\\.]+)=([0-9]+)$");
/*     */       String[] arrayOfString1 = paramString.replaceAll("\\s", "").toUpperCase().split("[;,]");
/*     */       String[] arrayOfString2 = arrayOfString1;
/*     */       int i = arrayOfString2.length;
/*     */       boolean bool = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void printMessage(Diagnostic.Kind paramKind, CharSequence paramCharSequence, Element paramElement, AnnotationMirror paramAnnotationMirror) {
/*     */     this.processingEnv.getMessager().printMessage(paramKind, paramCharSequence, paramElement, paramAnnotationMirror);
/*     */   }
/*     */   
/*     */   public void writeReferences() {
/*     */     this.obf.writeReferences();
/*     */   }
/*     */   
/*     */   public IObfuscationManager getObfuscationManager() {
/*     */     return this.obf;
/*     */   }
/*     */   
/*     */   public IMixinAnnotationProcessor.CompilerEnvironment getCompilerEnvironment() {
/*     */     return this.env;
/*     */   }
/*     */   
/*     */   public void registerInjector(TypeElement paramTypeElement, ExecutableElement paramExecutableElement, AnnotationHandle paramAnnotationHandle) {
/*     */     AnnotatedMixin annotatedMixin = getMixin(paramTypeElement);
/*     */     try {
/*     */       if (annotatedMixin == null) {
/*     */         printMessage(Diagnostic.Kind.ERROR, "Found " + paramAnnotationHandle + " annotation on a non-mixin method", paramExecutableElement);
/*     */         return;
/*     */       } 
/*     */     } catch (NullPointerException nullPointerException) {
/*     */       throw b(null);
/*     */     } 
/*     */     InjectorRemap injectorRemap = new InjectorRemap(shouldRemap(annotatedMixin, paramAnnotationHandle));
/*     */     annotatedMixin.registerInjector(paramExecutableElement, paramAnnotationHandle, injectorRemap);
/*     */     injectorRemap.dispatchPendingMessages((Messager)this);
/*     */   }
/*     */   
/*     */   public void registerMixin(TypeElement paramTypeElement) {
/*     */     String str = paramTypeElement.getQualifiedName().toString();
/*     */     if (!this.mixins.containsKey(str)) {
/*     */       AnnotatedMixin annotatedMixin = new AnnotatedMixin(this, paramTypeElement);
/*     */       this.targets.registerTargets(annotatedMixin);
/*     */       annotatedMixin.runValidators(IMixinValidator.ValidationPass.EARLY, this.validators);
/*     */       this.mixins.put(str, annotatedMixin);
/*     */       this.mixinsForPass.add(annotatedMixin);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Exception b(Exception paramException) {
/*     */     return paramException;
/*     */   }
/*     */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\AnnotatedMixins.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */