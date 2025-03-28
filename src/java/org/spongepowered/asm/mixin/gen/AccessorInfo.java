/*  1 */ package org.spongepowered.asm.mixin.gen;public class AccessorInfo extends SpecialMethodInfo { private static <TNode> String getNodeDesc(TNode paramTNode) { try { try {  } catch (InvalidAccessorException invalidAccessorException) { throw b(null); }  } catch (InvalidAccessorException invalidAccessorException) { throw b(null); }  return (paramTNode instanceof MethodNode) ? ((MethodNode)paramTNode).desc : ((paramTNode instanceof FieldNode) ? ((FieldNode)paramTNode).desc : null); } private static boolean isUpperCase(String paramString) { return paramString.toUpperCase().equals(paramString); } public String toString() { return String.format("%s->@%s[%s]::%s%s", new Object[] { this.mixin.toString(), Bytecode.getSimpleName(this.annotation), this.type.toString(), this.method.name, this.method.desc }); } public static String inflectTarget(String paramString1, AccessorInfo$AccessorType paramAccessorInfo$AccessorType, String paramString2, IMixinContext paramIMixinContext, boolean paramBoolean) { Matcher matcher = PATTERN_ACCESSOR.matcher(paramString1);
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
/* 78 */     if (matcher.matches()) { String str1 = matcher.group(1); String str2 = matcher.group(3); String str3 = matcher.group(4); }
/*    */      return null; }
/*    */   private FieldNode findTargetField() { return findTarget(this.classNode.fields); }
/*    */   public final Type getTargetFieldType() { return this.targetFieldType; }
/*    */   public void locate() { this.targetField = findTargetField(); } protected Type initTargetFieldType() { try { switch (AccessorInfo$1.$SwitchMap$org$spongepowered$asm$mixin$gen$AccessorInfo$AccessorType[this.type.ordinal()]) { case 1:
/*    */           try { if (this.argTypes.length > 0)
/*    */               throw new InvalidAccessorException(this.mixin, this + " must take exactly 0 arguments, found " + this.argTypes.length);  }
/*    */           catch (InvalidAccessorException invalidAccessorException) { throw b(null); }
/* 86 */            return this.returnType;case 2: try { if (this.argTypes.length != 1)
/*    */               throw new InvalidAccessorException(this.mixin, this + " must take exactly 1 argument, found " + this.argTypes.length);  } catch (InvalidAccessorException invalidAccessorException) { throw b(null); }  return this.argTypes[0]; }  } catch (InvalidAccessorException invalidAccessorException) { throw b(null); }  throw new InvalidAccessorException(this.mixin, "Computed unsupported accessor type " + this.type + " for " + this); } protected String getTargetName() { String str = (String)Annotations.getValue(this.annotation); if (Strings.isNullOrEmpty(str)) { String str1 = inflectTarget(); try { if (str1 == null)
/*    */           throw new InvalidAccessorException(this.mixin, "Failed to inflect target name for " + this + ", supported prefixes: [get, set, is]");  } catch (InvalidAccessorException invalidAccessorException) { throw b(null); }  }  return (MemberInfo.parse(str, (IMixinContext)this.mixin)).name; } protected static final Pattern PATTERN_ACCESSOR = Pattern.compile("^(get|set|is|invoke|call)(([A-Z])(.*?))(_\\$md.*)?$"); protected final Type[] argTypes; protected final Type returnType; protected final AccessorInfo$AccessorType type;
/* 89 */   private static String toLowerCase(String paramString, boolean paramBoolean) { try {  } catch (InvalidAccessorException invalidAccessorException) { throw b(null); }  return paramBoolean ? paramString.toLowerCase() : paramString; }
/*    */ 
/*    */   
/*    */   private final Type targetFieldType;
/*    */   protected final MemberInfo target;
/*    */   protected FieldNode targetField;
/*    */   protected MethodNode targetMethod;
/*    */   
/*    */   public final Type getReturnType() {
/*    */     return this.returnType;
/*    */   }
/*    */   
/*    */   protected AccessorInfo(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode, Class<? extends Annotation> paramClass) {
/*    */     super(paramMixinTargetContext, paramMethodNode, Annotations.getVisible(paramMethodNode, paramClass));
/*    */     this.argTypes = Type.getArgumentTypes(paramMethodNode.desc);
/*    */     this.returnType = Type.getReturnType(paramMethodNode.desc);
/*    */     this.type = initType();
/*    */     this.targetFieldType = initTargetFieldType();
/*    */     this.target = initTarget();
/*    */   }
/*    */   
/*    */   public MethodNode generate() {
/*    */     MethodNode methodNode = this.type.getGenerator(this).generate();
/*    */     Bytecode.mergeAnnotations(this.method, methodNode);
/*    */     return methodNode;
/*    */   }
/*    */   
/*    */   public AccessorInfo(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode) {
/*    */     this(paramMixinTargetContext, paramMethodNode, (Class)Accessor.class);
/*    */   }
/*    */   
/*    */   public static AccessorInfo of(MixinTargetContext paramMixinTargetContext, MethodNode paramMethodNode, Class<? extends Annotation> paramClass) {
/*    */     try {
/*    */       if (paramClass == Accessor.class)
/*    */         return new AccessorInfo(paramMixinTargetContext, paramMethodNode); 
/*    */     } catch (InvalidAccessorException invalidAccessorException) {
/*    */       throw b(null);
/*    */     } 
/*    */     try {
/*    */       if (paramClass == Invoker.class)
/*    */         return new InvokerInfo(paramMixinTargetContext, paramMethodNode); 
/*    */     } catch (InvalidAccessorException invalidAccessorException) {
/*    */       throw b(null);
/*    */     } 
/*    */     throw new InvalidAccessorException(paramMixinTargetContext, "Could not parse accessor for unknown type " + paramClass.getName());
/*    */   }
/*    */   
/*    */   public final MethodNode getTargetMethod() {
/*    */     return this.targetMethod;
/*    */   }
/*    */   
/*    */   protected AccessorInfo$AccessorType initType() {
/*    */     try {
/*    */       if (this.returnType.equals(Type.VOID_TYPE))
/*    */         return AccessorInfo$AccessorType.FIELD_SETTER; 
/*    */     } catch (InvalidAccessorException invalidAccessorException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return AccessorInfo$AccessorType.FIELD_GETTER;
/*    */   }
/*    */   
/*    */   public final FieldNode getTargetField() {
/*    */     return this.targetField;
/*    */   }
/*    */   
/*    */   protected <TNode> TNode findTarget(List<TNode> paramList) {
/*    */     // Byte code:
/*    */     //   0: aconst_null
/*    */     //   1: astore_2
/*    */     //   2: new java/util/ArrayList
/*    */     //   5: dup
/*    */     //   6: invokespecial <init> : ()V
/*    */     //   9: astore_3
/*    */     //   10: aload_1
/*    */     //   11: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   16: astore #4
/*    */     //   18: aload #4
/*    */     //   20: invokeinterface hasNext : ()Z
/*    */     //   25: ifeq -> 142
/*    */     //   28: aload #4
/*    */     //   30: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   35: astore #5
/*    */     //   37: aload #5
/*    */     //   39: invokestatic getNodeDesc : (Ljava/lang/Object;)Ljava/lang/String;
/*    */     //   42: astore #6
/*    */     //   44: aload #6
/*    */     //   46: ifnull -> 18
/*    */     //   49: aload #6
/*    */     //   51: aload_0
/*    */     //   52: getfield target : Lorg/spongepowered/asm/mixin/injection/struct/MemberInfo;
/*    */     //   55: getfield desc : Ljava/lang/String;
/*    */     //   58: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   61: ifne -> 71
/*    */     //   64: goto -> 18
/*    */     //   67: invokestatic b : (Lorg/spongepowered/asm/mixin/gen/throwables/InvalidAccessorException;)Lorg/spongepowered/asm/mixin/gen/throwables/InvalidAccessorException;
/*    */     //   70: athrow
/*    */     //   71: aload #5
/*    */     //   73: invokestatic getNodeName : (Ljava/lang/Object;)Ljava/lang/String;
/*    */     //   76: astore #7
/*    */     //   78: aload #7
/*    */     //   80: ifnull -> 139
/*    */     //   83: aload #7
/*    */     //   85: aload_0
/*    */     //   86: getfield target : Lorg/spongepowered/asm/mixin/injection/struct/MemberInfo;
/*    */     //   89: getfield name : Ljava/lang/String;
/*    */     //   92: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   95: ifeq -> 108
/*    */     //   98: goto -> 105
/*    */     //   101: invokestatic b : (Lorg/spongepowered/asm/mixin/gen/throwables/InvalidAccessorException;)Lorg/spongepowered/asm/mixin/gen/throwables/InvalidAccessorException;
/*    */     //   104: athrow
/*    */     //   105: aload #5
/*    */     //   107: astore_2
/*    */     //   108: aload #7
/*    */     //   110: aload_0
/*    */     //   111: getfield target : Lorg/spongepowered/asm/mixin/injection/struct/MemberInfo;
/*    */     //   114: getfield name : Ljava/lang/String;
/*    */     //   117: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*    */     //   120: ifeq -> 139
/*    */     //   123: aload_3
/*    */     //   124: aload #5
/*    */     //   126: invokeinterface add : (Ljava/lang/Object;)Z
/*    */     //   131: pop
/*    */     //   132: goto -> 139
/*    */     //   135: invokestatic b : (Lorg/spongepowered/asm/mixin/gen/throwables/InvalidAccessorException;)Lorg/spongepowered/asm/mixin/gen/throwables/InvalidAccessorException;
/*    */     //   138: athrow
/*    */     //   139: goto -> 18
/*    */     //   142: aload_2
/*    */     //   143: ifnull -> 199
/*    */     //   146: aload_3
/*    */     //   147: invokeinterface size : ()I
/*    */     //   152: iconst_1
/*    */     //   153: if_icmple -> 197
/*    */     //   156: goto -> 163
/*    */     //   159: invokestatic b : (Lorg/spongepowered/asm/mixin/gen/throwables/InvalidAccessorException;)Lorg/spongepowered/asm/mixin/gen/throwables/InvalidAccessorException;
/*    */     //   162: athrow
/*    */     //   163: ldc 'mixin'
/*    */     //   165: invokestatic getLogger : (Ljava/lang/String;)Lorg/apache/logging/log4j/Logger;
/*    */     //   168: ldc '{} found an exact match for {} but other candidates were found!'
/*    */     //   170: iconst_2
/*    */     //   171: anewarray java/lang/Object
/*    */     //   174: dup
/*    */     //   175: iconst_0
/*    */     //   176: aload_0
/*    */     //   177: aastore
/*    */     //   178: dup
/*    */     //   179: iconst_1
/*    */     //   180: aload_0
/*    */     //   181: getfield target : Lorg/spongepowered/asm/mixin/injection/struct/MemberInfo;
/*    */     //   184: aastore
/*    */     //   185: invokeinterface debug : (Ljava/lang/String;[Ljava/lang/Object;)V
/*    */     //   190: goto -> 197
/*    */     //   193: invokestatic b : (Lorg/spongepowered/asm/mixin/gen/throwables/InvalidAccessorException;)Lorg/spongepowered/asm/mixin/gen/throwables/InvalidAccessorException;
/*    */     //   196: athrow
/*    */     //   197: aload_2
/*    */     //   198: areturn
/*    */     //   199: aload_3
/*    */     //   200: invokeinterface size : ()I
/*    */     //   205: iconst_1
/*    */     //   206: if_icmpne -> 221
/*    */     //   209: aload_3
/*    */     //   210: iconst_0
/*    */     //   211: invokeinterface get : (I)Ljava/lang/Object;
/*    */     //   216: areturn
/*    */     //   217: invokestatic b : (Lorg/spongepowered/asm/mixin/gen/throwables/InvalidAccessorException;)Lorg/spongepowered/asm/mixin/gen/throwables/InvalidAccessorException;
/*    */     //   220: athrow
/*    */     //   221: aload_3
/*    */     //   222: invokeinterface size : ()I
/*    */     //   227: ifne -> 239
/*    */     //   230: ldc 'No'
/*    */     //   232: goto -> 241
/*    */     //   235: invokestatic b : (Lorg/spongepowered/asm/mixin/gen/throwables/InvalidAccessorException;)Lorg/spongepowered/asm/mixin/gen/throwables/InvalidAccessorException;
/*    */     //   238: athrow
/*    */     //   239: ldc 'Multiple'
/*    */     //   241: astore #4
/*    */     //   243: new org/spongepowered/asm/mixin/gen/throwables/InvalidAccessorException
/*    */     //   246: dup
/*    */     //   247: aload_0
/*    */     //   248: new java/lang/StringBuilder
/*    */     //   251: dup
/*    */     //   252: invokespecial <init> : ()V
/*    */     //   255: aload #4
/*    */     //   257: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   260: ldc ' candidates were found matching '
/*    */     //   262: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   265: aload_0
/*    */     //   266: getfield target : Lorg/spongepowered/asm/mixin/injection/struct/MemberInfo;
/*    */     //   269: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */     //   272: ldc ' in '
/*    */     //   274: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   277: aload_0
/*    */     //   278: getfield classNode : Lorg/spongepowered/asm/lib/tree/ClassNode;
/*    */     //   281: getfield name : Ljava/lang/String;
/*    */     //   284: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   287: ldc ' for '
/*    */     //   289: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   292: aload_0
/*    */     //   293: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */     //   296: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   299: invokespecial <init> : (Lorg/spongepowered/asm/mixin/gen/AccessorInfo;Ljava/lang/String;)V
/*    */     //   302: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #59	-> 0
/*    */     //   #88	-> 2
/*    */     //   #42	-> 10
/*    */     //   #58	-> 37
/*    */     //   #23	-> 44
/*    */     //   #16	-> 64
/*    */     //   #29	-> 71
/*    */     //   #66	-> 78
/*    */     //   #31	-> 83
/*    */     //   #69	-> 105
/*    */     //   #2	-> 108
/*    */     //   #75	-> 123
/*    */     //   #84	-> 139
/*    */     //   #26	-> 142
/*    */     //   #5	-> 146
/*    */     //   #18	-> 163
/*    */     //   #49	-> 197
/*    */     //   #21	-> 199
/*    */     //   #55	-> 209
/*    */     //   #53	-> 221
/*    */     //   #73	-> 243
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   49	67	67	org/spongepowered/asm/mixin/gen/throwables/InvalidAccessorException
/*    */     //   78	98	101	org/spongepowered/asm/mixin/gen/throwables/InvalidAccessorException
/*    */     //   108	132	135	org/spongepowered/asm/mixin/gen/throwables/InvalidAccessorException
/*    */     //   142	156	159	org/spongepowered/asm/mixin/gen/throwables/InvalidAccessorException
/*    */     //   146	190	193	org/spongepowered/asm/mixin/gen/throwables/InvalidAccessorException
/*    */     //   199	217	217	org/spongepowered/asm/mixin/gen/throwables/InvalidAccessorException
/*    */     //   221	235	235	org/spongepowered/asm/mixin/gen/throwables/InvalidAccessorException
/*    */   }
/*    */   
/*    */   public final Type[] getArgTypes() {
/*    */     return this.argTypes;
/*    */   }
/*    */   
/*    */   public final MemberInfo getTarget() {
/*    */     return this.target;
/*    */   }
/*    */   
/*    */   private static <TNode> String getNodeName(TNode paramTNode) {
/*    */     try {
/*    */       try {
/*    */       
/*    */       } catch (InvalidAccessorException invalidAccessorException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } catch (InvalidAccessorException invalidAccessorException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return (paramTNode instanceof MethodNode) ? ((MethodNode)paramTNode).name : ((paramTNode instanceof FieldNode) ? ((FieldNode)paramTNode).name : null);
/*    */   }
/*    */   
/*    */   protected String inflectTarget() {
/*    */     return inflectTarget(this.method.name, this.type, toString(), (IMixinContext)this.mixin, this.mixin.getEnvironment().getOption(MixinEnvironment.Option.DEBUG_VERBOSE));
/*    */   }
/*    */   
/*    */   protected MemberInfo initTarget() {
/*    */     MemberInfo memberInfo = new MemberInfo(getTargetName(), null, this.targetFieldType.getDescriptor());
/*    */     this.annotation.visit("target", memberInfo.toString());
/*    */     return memberInfo;
/*    */   }
/*    */   
/*    */   private static InvalidAccessorException b(InvalidAccessorException paramInvalidAccessorException) {
/*    */     return paramInvalidAccessorException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\gen\AccessorInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */