/*    */ package org.spongepowered.asm.mixin.injection.struct;
/*  2 */ public class InjectionPointData { public IMixinContext getContext() { return this.context; } public int getOpcode(int paramInt) { 
/*    */     try {  }
/*    */     catch (InvalidMemberDescriptorException invalidMemberDescriptorException)
/*  5 */     { throw b(null); }  return (this.opcode > 0) ? this.opcode : paramInt; }
/*    */ 
/*    */ 
/*    */   
/*    */   public MemberInfo get(String paramString) {
/*    */     try {
/*    */       return MemberInfo.parseAndValidate(get(paramString, ""), this.context);
/*    */     } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) {}
/*    */     throw new InvalidInjectionPointException(this.context, "Failed parsing @At(\"%s\").%s descriptor \"%s\" on %s", new Object[] { this.at, paramString, this.target, InjectionInfo.describeInjector(this.context, this.parent, this.method) });
/*    */   }
/*    */ 
/*    */   
/*    */   public String getSlice() {
/*    */     return this.slice;
/*    */   }
/*    */ 
/*    */   
/*    */   public int get(String paramString, int paramInt) {
/*    */     return parseInt(get(paramString, String.valueOf(paramInt)), paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   private static String parseType(Matcher paramMatcher, String paramString) {
/*    */     try {
/*    */     
/*    */     } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return paramMatcher.matches() ? paramMatcher.group(1) : paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/*    */     return this.type;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getType() {
/*    */     return this.type;
/*    */   }
/*    */ 
/*    */   
/*    */   private static boolean parseBoolean(String paramString, boolean paramBoolean) {
/*    */     try {
/*    */       return Boolean.parseBoolean(paramString);
/*    */     } catch (Exception exception) {
/*    */       return paramBoolean;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String getAt() {
/*    */     return this.at;
/*    */   }
/*    */   
/*    */   public LocalVariableDiscriminator getLocalVariableDiscriminator() {
/*    */     return LocalVariableDiscriminator.parse(this.parent);
/*    */   }
/*    */   
/*    */   public InjectionPointData(IMixinContext paramIMixinContext, MethodNode paramMethodNode, AnnotationNode paramAnnotationNode, String paramString1, List<String> paramList, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4) {
/* 65 */     this.args = new HashMap<String, String>();
/* 66 */     this.context = paramIMixinContext; this.method = paramMethodNode; this.parent = paramAnnotationNode; this.at = paramString1; this.target = paramString2; this.slice = Strings.nullToEmpty(paramString3); this.ordinal = Math.max(-1, paramInt1);
/*    */     this.opcode = paramInt2;
/*    */     this.id = paramString4;
/* 69 */     parseArgs(paramList); this.args.put("target", paramString2); this.args.put("ordinal", String.valueOf(paramInt1)); this.args.put("opcode", String.valueOf(paramInt2)); Matcher matcher = AT_PATTERN.matcher(paramString1); this.type = parseType(matcher, paramString1); this.selector = parseSelector(matcher);
/*    */   }
/* 71 */   public int getOpcode() { return this.opcode; } public MethodNode getMethod() { return this.method; } public boolean get(String paramString, boolean paramBoolean) { return parseBoolean(get(paramString, String.valueOf(paramBoolean)), paramBoolean); } private void parseArgs(List<String> paramList) { try { if (paramList == null) return;  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  for (String str : paramList) { if (str != null) { int i = str.indexOf('='); try { if (i > -1) { this.args.put(str.substring(0, i), str.substring(i + 1)); continue; }  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  this.args.put(str, ""); }  }  } public int getOpcode(int paramInt, int... paramVarArgs) { int[] arrayOfInt; int i; byte b; for (arrayOfInt = paramVarArgs, i = arrayOfInt.length, b = 0; b < i; ) { int j = arrayOfInt[b]; try { if (this.opcode == j)
/* 72 */           return this.opcode;  } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) { throw b(null); }  b++; }  return paramInt; }
/*    */ 
/*    */   
/*    */   private static InjectionPoint.Selector parseSelector(Matcher paramMatcher) {
/*    */     try {
/*    */       if (paramMatcher.matches())
/*    */         try {
/*    */           if (paramMatcher.group(2) != null);
/*    */         } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) {
/*    */           throw b(null);
/*    */         }  
/*    */     } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return InjectionPoint.Selector.DEFAULT;
/*    */   }
/*    */   
/*    */   public MemberInfo getTarget() {
/*    */     try {
/*    */       return MemberInfo.parseAndValidate(this.target, this.context);
/*    */     } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) {
/*    */       throw new InvalidInjectionPointException(this.context, "Failed parsing @At(\"%s\") descriptor \"%s\" on %s", new Object[] { this.at, this.target, InjectionInfo.describeInjector(this.context, this.parent, this.method) });
/*    */     } 
/*    */   }
/*    */   
/*    */   public static String parseType(String paramString) {
/*    */     Matcher matcher = AT_PATTERN.matcher(paramString);
/*    */     return parseType(matcher, paramString);
/*    */   }
/*    */   
/*    */   private static Pattern createPattern() {
/*    */     return Pattern.compile(String.format("^([^:]+):?(%s)?$", new Object[] { Joiner.on('|').join((Object[])InjectionPoint.Selector.values()) }));
/*    */   }
/*    */   
/*    */   private static final Pattern AT_PATTERN = createPattern();
/*    */   private final Map<String, String> args;
/*    */   private final IMixinContext context;
/*    */   private final MethodNode method;
/*    */   private final AnnotationNode parent;
/*    */   private final String at;
/*    */   private final String type;
/*    */   private final InjectionPoint.Selector selector;
/*    */   private final String target;
/*    */   private final String slice;
/*    */   private final int ordinal;
/*    */   private final int opcode;
/*    */   private final String id;
/*    */   
/*    */   public String getId() {
/*    */     return this.id;
/*    */   }
/*    */   
/*    */   public String get(String paramString1, String paramString2) {
/*    */     String str = this.args.get(paramString1);
/*    */     try {
/*    */     
/*    */     } catch (InvalidMemberDescriptorException invalidMemberDescriptorException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return (str != null) ? str : paramString2;
/*    */   }
/*    */   
/*    */   public AnnotationNode getParent() {
/*    */     return this.parent;
/*    */   }
/*    */   
/*    */   public Type getMethodReturnType() {
/*    */     return Type.getReturnType(this.method.desc);
/*    */   }
/*    */   
/*    */   private static int parseInt(String paramString, int paramInt) {
/*    */     try {
/*    */       return Integer.parseInt(paramString);
/*    */     } catch (Exception exception) {
/*    */       return paramInt;
/*    */     } 
/*    */   }
/*    */   
/*    */   public int getOrdinal() {
/*    */     return this.ordinal;
/*    */   }
/*    */   
/*    */   public InjectionPoint.Selector getSelector() {
/*    */     return this.selector;
/*    */   }
/*    */   
/*    */   private static InvalidMemberDescriptorException b(InvalidMemberDescriptorException paramInvalidMemberDescriptorException) {
/*    */     return paramInvalidMemberDescriptorException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\struct\InjectionPointData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */