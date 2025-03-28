/*     */ package org.spongepowered.asm.mixin.injection.struct;
/*   2 */ public abstract class InjectionInfo extends SpecialMethodInfo implements ISliceContext { static String describeInjector(IMixinContext paramIMixinContext, AnnotationNode paramAnnotationNode, MethodNode paramMethodNode) { return String.format("%s->@%s::%s%s", new Object[] { paramIMixinContext.toString(), Bytecode.getSimpleName(paramAnnotationNode), paramMethodNode.name, paramMethodNode.desc }); } public int getInjectedCallbackCount() {
/*   3 */     return this.injectedCallbackCount;
/*     */   }
/*   5 */   public void inject() { for (Map.Entry<Target, List<InjectionNodes$InjectionNode>> entry : this.targetNodes.entrySet())
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 171 */       this.injector.inject((Target)entry.getKey(), (List)entry.getValue()); }  this.targets.clear(); } public static String getInjectorPrefix(AnnotationNode paramAnnotationNode) { try { if (paramAnnotationNode != null) { try { if (paramAnnotationNode.desc.endsWith(ModifyArg.class.getSimpleName() + ";")) return "modify";  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  try { if (paramAnnotationNode.desc.endsWith(ModifyArgs.class.getSimpleName() + ";")) return "args";  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  try { if (paramAnnotationNode.desc.endsWith(Redirect.class.getSimpleName() + ";")) return "redirect";  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  try { if (paramAnnotationNode.desc.endsWith(ModifyVariable.class.getSimpleName() + ";")) return "localvar";  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  try { if (paramAnnotationNode.desc.endsWith(ModifyConstant.class.getSimpleName() + ";")) return "constant";  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  }  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  return "handler"; } protected final List<InjectionPoint> injectionPoints = new ArrayList<InjectionPoint>(); public boolean isValid() { try { if (this.targets.size() > 0) try { if (this.injectionPoints.size() > 0); } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }   } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  return false; } private int injectedCallbackCount = 0; public MethodNode addMethod(int paramInt, String paramString1, String paramString2) { MethodNode methodNode = new MethodNode(327680, paramInt | 0x1000, paramString1, paramString2, null, null); this.injectedMethods.add(methodNode); return methodNode; } protected Set<MemberInfo> parseTargets(String paramString) { List list = Annotations.getValue(this.annotation, "method", false); try { if (list == null) throw new InvalidInjectionException(this, String.format("%s annotation on %s is missing method name", new Object[] { paramString, this.method.name }));  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  LinkedHashSet<MemberInfo> linkedHashSet = new LinkedHashSet(); for (String str : list) { try { MemberInfo memberInfo = MemberInfo.parseAndValidate(str, (IMixinContext)this.mixin); try { if (memberInfo.owner != null) try { if (!memberInfo.owner.equals(this.mixin.getTargetClassRef())) {
/* 172 */                 throw new InvalidInjectionException(this, String.format("%s annotation on %s specifies a target class '%s', which is not supported", new Object[] { paramString, this.method.name, memberInfo.owner }));
/*     */               } }
/*     */             catch (InvalidMemberDescriptorException invalidMemberDescriptorException)
/*     */             { throw b(null); }
/*     */           
/*     */            }
/*     */         catch (InvalidMemberDescriptorException invalidMemberDescriptorException)
/*     */         { throw b(null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 189 */         linkedHashSet.add(memberInfo); } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) {} }  return linkedHashSet; }
/*     */   private int requiredCallbackCount = 0;
/* 191 */   protected String getDescription() { return "Callback method"; } protected String getDynamicInfo() { AnnotationNode annotationNode = Annotations.getInvisible(this.method, Dynamic.class); String str = Strings.nullToEmpty((String)Annotations.getValue(annotationNode)); Type type = (Type)Annotations.getValue(annotationNode, "mixin"); if (type != null) str = String.format("{%s} %s", new Object[] { type.getClassName(), str }).trim();  try {  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  return (str.length() > 0) ? String.format(" Method is @Dynamic(%s)", new Object[] { str }) : ""; } public MethodSlice getSlice(String paramString) { return this.slices.get(getSliceId(paramString)); } public void addCallbackInvocation(MethodNode paramMethodNode) { this.injectedCallbackCount++; } private int maxCallbackCount = Integer.MAX_VALUE; protected final Map<Target, List<InjectionNodes$InjectionNode>> targetNodes = new LinkedHashMap<Target, List<InjectionNodes$InjectionNode>>(); private final List<MethodNode> injectedMethods = new ArrayList<MethodNode>(0); private void findMethods(Set<MemberInfo> paramSet, String paramString) { try { this.targets.clear(); } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  boolean bool = this.mixin.getEnvironment().getOption(MixinEnvironment.Option.REFMAP_REMAP) ? true : true; for (MemberInfo memberInfo : paramSet) boolean bool1 = false, bool2 = false;  try { if (this.targets.size() == 0) { (new Object[6])[0] = paramString; (new Object[6])[1] = this.method.name; (new Object[6])[2] = namesOf(paramSet); (new Object[6])[3] = this.mixin.getTarget(); (new Object[6])[4] = this.mixin.getReferenceMapper().getStatus(); (new Object[6])[5] = getDynamicInfo(); }  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  } private int expectedCallbackCount = 1; public String getSliceId(String paramString) { return ""; } public Collection<MethodNode> getTargets() { return this.targets; } private void checkTarget(MethodNode paramMethodNode) { AnnotationNode annotationNode = Annotations.getVisible(paramMethodNode, MixinMerged.class); try { if (annotationNode == null) return;  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  try { if (Annotations.getVisible(paramMethodNode, Final.class) != null) throw new InvalidInjectionException(this, String.format("%s cannot inject into @Final method %s::%s%s merged by %s", new Object[] { this, this.classNode.name, paramMethodNode.name, paramMethodNode.desc, Annotations.getValue(annotationNode, "mixin") }));  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  } public static InjectionInfo parse(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode) { AnnotationNode annotationNode = getInjectorAnnotation(paramMixinTargetContext.getMixin(), paramMethodNode); try { if (annotationNode == null) return null;  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  try { if (annotationNode.desc.endsWith(Inject.class.getSimpleName() + ";")) return new CallbackInjectionInfo(paramMixinTargetContext, paramMethodNode, annotationNode);  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  try { if (annotationNode.desc.endsWith(ModifyArg.class.getSimpleName() + ";")) return new ModifyArgInjectionInfo(paramMixinTargetContext, paramMethodNode, annotationNode);  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  try { if (annotationNode.desc.endsWith(ModifyArgs.class.getSimpleName() + ";")) return new ModifyArgsInjectionInfo(paramMixinTargetContext, paramMethodNode, annotationNode);  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  try { if (annotationNode.desc.endsWith(Redirect.class.getSimpleName() + ";")) return new RedirectInjectionInfo(paramMixinTargetContext, paramMethodNode, annotationNode);  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  try { if (annotationNode.desc.endsWith(ModifyVariable.class.getSimpleName() + ";")) return new ModifyVariableInjectionInfo(paramMixinTargetContext, paramMethodNode, annotationNode);  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  try { if (annotationNode.desc.endsWith(ModifyConstant.class.getSimpleName() + ";")) return new ModifyConstantInjectionInfo(paramMixinTargetContext, paramMethodNode, annotationNode);  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  return null; } public void postInject() { for (MethodNode methodNode : this.injectedMethods) this.classNode.methods.add(methodNode);  String str1 = getDescription(); String str2 = this.mixin.getReferenceMapper().getStatus(); String str3 = getDynamicInfo(); try { if (this.mixin.getEnvironment().getOption(MixinEnvironment.Option.DEBUG_INJECTORS)) try { if (this.injectedCallbackCount < this.expectedCallbackCount) throw new InvalidInjectionException(this, String.format("Injection validation failed: %s %s%s in %s expected %d invocation(s) but %d succeeded. %s%s", new Object[] { str1, this.method.name, this.method.desc, this.mixin, Integer.valueOf(this.expectedCallbackCount), Integer.valueOf(this.injectedCallbackCount), str2, str3 }));  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }   } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  try { if (this.injectedCallbackCount < this.requiredCallbackCount) throw new InjectionError(String.format("Critical injection failure: %s %s%s in %s failed injection check, (%d/%d) succeeded. %s%s", new Object[] { str1, this.method.name, this.method.desc, this.mixin, Integer.valueOf(this.injectedCallbackCount), Integer.valueOf(this.requiredCallbackCount), str2, str3 }));  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  try { if (this.injectedCallbackCount > this.maxCallbackCount) throw new InjectionError(String.format("Critical injection failure: %s %s%s in %s failed injection check, %d succeeded of %d allowed.%s", new Object[] { str1, this.method.name, this.method.desc, this.mixin, Integer.valueOf(this.injectedCallbackCount), Integer.valueOf(this.maxCallbackCount), str3 }));  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  } protected void readAnnotation() { try { if (this.annotation == null) return;  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  String str = "@" + Bytecode.getSimpleName(this.annotation); List<AnnotationNode> list = readInjectionPoints(str); findMethods(parseTargets(str), str); parseInjectionPoints(list); parseRequirements(); this.injector = parseInjector(this.annotation); }
/*     */   public String toString() { return describeInjector((IMixinContext)this.mixin, this.annotation, this.method); } public void notifyInjected(Target paramTarget) {} protected final Deque<MethodNode> targets = new ArrayDeque<MethodNode>(); protected final boolean isStatic; protected final MethodSlices slices; protected final String atKey; protected Injector injector; protected InjectorGroupInfo group; public static AnnotationNode getInjectorAnnotation(IMixinInfo paramIMixinInfo, MethodNode paramMethodNode) { AnnotationNode annotationNode = null; try { annotationNode = Annotations.getSingleVisible(paramMethodNode, new Class[] { Inject.class, ModifyArg.class, ModifyArgs.class, Redirect.class, ModifyVariable.class, ModifyConstant.class }); } catch (IllegalArgumentException illegalArgumentException) { throw new InvalidMixinException(paramIMixinInfo, String.format("Error parsing annotations on %s in %s: %s", new Object[] { paramMethodNode.name, paramIMixinInfo.getClassName(), illegalArgumentException.getMessage() })); }  return annotationNode; } public void prepare() { this.targetNodes.clear(); for (MethodNode methodNode : this.targets) { Target target = this.mixin.getTargetMethod(methodNode); InjectorTarget injectorTarget = new InjectorTarget(this, target); this.targetNodes.put(target, this.injector.find(injectorTarget, this.injectionPoints)); injectorTarget.dispose(); }  } protected InjectionInfo(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode, AnnotationNode paramAnnotationNode, String paramString) { super(paramMixinTargetContext, paramMethodNode, paramAnnotationNode); this.isStatic = Bytecode.methodIsStatic(paramMethodNode); this.slices = MethodSlices.parse(this); this.atKey = paramString; readAnnotation(); } protected void parseInjectionPoints(List<AnnotationNode> paramList) { this.injectionPoints.addAll(InjectionPoint.parse((IMixinContext)this.mixin, this.method, this.annotation, paramList)); } protected void parseRequirements() { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: aload_0
/*     */     //   2: getfield mixin : Lorg/spongepowered/asm/mixin/transformer/MixinTargetContext;
/*     */     //   5: invokevirtual getInjectorGroups : ()Lorg/spongepowered/asm/mixin/injection/struct/InjectorGroupInfo$Map;
/*     */     //   8: aload_0
/*     */     //   9: getfield method : Lorg/spongepowered/asm/lib/tree/MethodNode;
/*     */     //   12: aload_0
/*     */     //   13: getfield mixin : Lorg/spongepowered/asm/mixin/transformer/MixinTargetContext;
/*     */     //   16: invokevirtual getDefaultInjectorGroup : ()Ljava/lang/String;
/*     */     //   19: invokevirtual parseGroup : (Lorg/spongepowered/asm/lib/tree/MethodNode;Ljava/lang/String;)Lorg/spongepowered/asm/mixin/injection/struct/InjectorGroupInfo;
/*     */     //   22: aload_0
/*     */     //   23: invokevirtual add : (Lorg/spongepowered/asm/mixin/injection/struct/InjectionInfo;)Lorg/spongepowered/asm/mixin/injection/struct/InjectorGroupInfo;
/*     */     //   26: putfield group : Lorg/spongepowered/asm/mixin/injection/struct/InjectorGroupInfo;
/*     */     //   29: aload_0
/*     */     //   30: getfield annotation : Lorg/spongepowered/asm/lib/tree/AnnotationNode;
/*     */     //   33: ldc 'expect'
/*     */     //   35: invokestatic getValue : (Lorg/spongepowered/asm/lib/tree/AnnotationNode;Ljava/lang/String;)Ljava/lang/Object;
/*     */     //   38: checkcast java/lang/Integer
/*     */     //   41: astore_1
/*     */     //   42: aload_1
/*     */     //   43: ifnull -> 61
/*     */     //   46: aload_0
/*     */     //   47: aload_1
/*     */     //   48: invokevirtual intValue : ()I
/*     */     //   51: putfield expectedCallbackCount : I
/*     */     //   54: goto -> 61
/*     */     //   57: invokestatic b : (Lorg/spongepowered/asm/mixin/injection/struct/InvalidMemberDescriptorException;)Lorg/spongepowered/asm/mixin/injection/struct/InvalidMemberDescriptorException;
/*     */     //   60: athrow
/*     */     //   61: aload_0
/*     */     //   62: getfield annotation : Lorg/spongepowered/asm/lib/tree/AnnotationNode;
/*     */     //   65: ldc 'require'
/*     */     //   67: invokestatic getValue : (Lorg/spongepowered/asm/lib/tree/AnnotationNode;Ljava/lang/String;)Ljava/lang/Object;
/*     */     //   70: checkcast java/lang/Integer
/*     */     //   73: astore_2
/*     */     //   74: aload_2
/*     */     //   75: ifnull -> 108
/*     */     //   78: aload_2
/*     */     //   79: invokevirtual intValue : ()I
/*     */     //   82: iconst_m1
/*     */     //   83: if_icmple -> 108
/*     */     //   86: goto -> 93
/*     */     //   89: invokestatic b : (Lorg/spongepowered/asm/mixin/injection/struct/InvalidMemberDescriptorException;)Lorg/spongepowered/asm/mixin/injection/struct/InvalidMemberDescriptorException;
/*     */     //   92: athrow
/*     */     //   93: aload_0
/*     */     //   94: aload_2
/*     */     //   95: invokevirtual intValue : ()I
/*     */     //   98: putfield requiredCallbackCount : I
/*     */     //   101: goto -> 136
/*     */     //   104: invokestatic b : (Lorg/spongepowered/asm/mixin/injection/struct/InvalidMemberDescriptorException;)Lorg/spongepowered/asm/mixin/injection/struct/InvalidMemberDescriptorException;
/*     */     //   107: athrow
/*     */     //   108: aload_0
/*     */     //   109: getfield group : Lorg/spongepowered/asm/mixin/injection/struct/InjectorGroupInfo;
/*     */     //   112: invokevirtual isDefault : ()Z
/*     */     //   115: ifeq -> 136
/*     */     //   118: aload_0
/*     */     //   119: aload_0
/*     */     //   120: getfield mixin : Lorg/spongepowered/asm/mixin/transformer/MixinTargetContext;
/*     */     //   123: invokevirtual getDefaultRequiredInjections : ()I
/*     */     //   126: putfield requiredCallbackCount : I
/*     */     //   129: goto -> 136
/*     */     //   132: invokestatic b : (Lorg/spongepowered/asm/mixin/injection/struct/InvalidMemberDescriptorException;)Lorg/spongepowered/asm/mixin/injection/struct/InvalidMemberDescriptorException;
/*     */     //   135: athrow
/*     */     //   136: aload_0
/*     */     //   137: getfield annotation : Lorg/spongepowered/asm/lib/tree/AnnotationNode;
/*     */     //   140: ldc 'allow'
/*     */     //   142: invokestatic getValue : (Lorg/spongepowered/asm/lib/tree/AnnotationNode;Ljava/lang/String;)Ljava/lang/Object;
/*     */     //   145: checkcast java/lang/Integer
/*     */     //   148: astore_3
/*     */     //   149: aload_3
/*     */     //   150: ifnull -> 179
/*     */     //   153: aload_0
/*     */     //   154: aload_0
/*     */     //   155: getfield requiredCallbackCount : I
/*     */     //   158: iconst_1
/*     */     //   159: invokestatic max : (II)I
/*     */     //   162: aload_3
/*     */     //   163: invokevirtual intValue : ()I
/*     */     //   166: invokestatic max : (II)I
/*     */     //   169: putfield maxCallbackCount : I
/*     */     //   172: goto -> 179
/*     */     //   175: invokestatic b : (Lorg/spongepowered/asm/mixin/injection/struct/InvalidMemberDescriptorException;)Lorg/spongepowered/asm/mixin/injection/struct/InvalidMemberDescriptorException;
/*     */     //   178: athrow
/*     */     //   179: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #173	-> 0
/*     */     //   #185	-> 29
/*     */     //   #49	-> 42
/*     */     //   #68	-> 46
/*     */     //   #31	-> 61
/*     */     //   #95	-> 74
/*     */     //   #135	-> 93
/*     */     //   #140	-> 108
/*     */     //   #121	-> 118
/*     */     //   #8	-> 136
/*     */     //   #97	-> 149
/*     */     //   #106	-> 153
/*     */     //   #112	-> 179
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   42	54	57	org/spongepowered/asm/mixin/injection/struct/InvalidMemberDescriptorException
/*     */     //   74	86	89	org/spongepowered/asm/mixin/injection/struct/InvalidMemberDescriptorException
/*     */     //   78	104	104	org/spongepowered/asm/mixin/injection/struct/InvalidMemberDescriptorException
/*     */     //   108	129	132	org/spongepowered/asm/mixin/injection/struct/InvalidMemberDescriptorException
/* 192 */     //   149	172	175	org/spongepowered/asm/mixin/injection/struct/InvalidMemberDescriptorException } private static String namesOf(Collection<MemberInfo> paramCollection) { boolean bool = false; int i = paramCollection.size(); StringBuilder stringBuilder = new StringBuilder(); for (MemberInfo memberInfo : paramCollection) { try { if (bool) try { if (bool == i - 1) { stringBuilder.append(" or "); } else { stringBuilder.append(", "); }  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }   } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  }  return stringBuilder.toString(); } protected InjectionInfo(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode, AnnotationNode paramAnnotationNode) { this(paramMixinTargetContext, paramMethodNode, paramAnnotationNode, "at"); } protected List<AnnotationNode> readInjectionPoints(String paramString) { List<AnnotationNode> list = Annotations.getValue(this.annotation, this.atKey, false);
/*     */     try {
/*     */       if (list == null)
/*     */         throw new InvalidInjectionException(this, String.format("%s annotation on %s is missing '%s' value(s)", new Object[] { paramString, this.method.name, this.atKey })); 
/*     */     } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return list; }
/*     */ 
/*     */   
/*     */   protected abstract Injector parseInjector(AnnotationNode paramAnnotationNode);
/*     */   
/*     */   private static InvalidMemberDescriptorException b(InvalidMemberDescriptorException paramInvalidMemberDescriptorException) {
/*     */     return paramInvalidMemberDescriptorException;
/*     */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\struct\InjectionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */