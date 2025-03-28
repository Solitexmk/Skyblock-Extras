/*     */ package org.spongepowered.asm.mixin.injection.struct;public final class MemberInfo { public final String owner; public final String name; public final String desc;
/*     */   public final boolean matchAll;
/*     */   private final boolean forceField;
/*     */   private final String unparsed;
/*     */   
/*     */   public boolean matches(String paramString1, String paramString2, String paramString3, int paramInt) { try {
/*   7 */       if (this.desc != null) try { if (paramString3 != null) try { if (!this.desc.equals(paramString3))
/*     */               {
/*     */                 
/*  10 */                 return false; }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }
/*     */           
/*     */            }
/*     */         catch (IllegalArgumentException illegalArgumentException)
/*     */         { throw b(null); }
/*     */       
/*     */     
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  35 */       if (this.name != null) try { if (paramString2 != null) try { if (!this.name.equals(paramString2))
/*     */               {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/*  44 */                 return false; }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }
/*     */           
/*     */            }
/*     */         catch (IllegalArgumentException illegalArgumentException)
/*     */         { throw b(null); }
/*     */       
/*     */     
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  99 */     try { if (this.owner != null) try { if (paramString1 != null) try { if (!this.owner.equals(paramString1))
/*     */               {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 175 */                 return false; }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }   } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }   } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  try { if (paramInt != 0) { try { if (this.matchAll); } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return false; }  }
/*     */     catch (IllegalArgumentException illegalArgumentException) { throw b(null); }
/*     */      } private MemberInfo(MemberInfo paramMemberInfo, MappingMethod paramMappingMethod, boolean paramBoolean) { this.owner = paramBoolean ? paramMappingMethod.getOwner() : paramMemberInfo.owner; this.name = paramMappingMethod.getSimpleName(); this.desc = paramMappingMethod.getDesc(); this.matchAll = paramMemberInfo.matchAll; this.forceField = false; this.unparsed = null; }
/* 178 */   public MemberInfo(AbstractInsnNode paramAbstractInsnNode) { this.matchAll = false; this.forceField = false; this.unparsed = null; if (paramAbstractInsnNode instanceof MethodInsnNode) { MethodInsnNode methodInsnNode = (MethodInsnNode)paramAbstractInsnNode; this.owner = methodInsnNode.owner; this.name = methodInsnNode.name;
/*     */ 
/*     */       
/*     */       this.desc = methodInsnNode.desc; }
/*     */     else
/* 183 */     { if (paramAbstractInsnNode instanceof FieldInsnNode)
/* 184 */       { FieldInsnNode fieldInsnNode = (FieldInsnNode)paramAbstractInsnNode; this.owner = fieldInsnNode.owner; this.name = fieldInsnNode.name; this.desc = fieldInsnNode.desc; }  throw new IllegalArgumentException("insn must be an instance of MethodInsnNode or FieldInsnNode"); }  }
/*     */   private static MemberInfo parse(String paramString1, IReferenceMapper paramIReferenceMapper, String paramString2) { // Byte code:
/*     */     //   0: aconst_null
/*     */     //   1: astore_3
/*     */     //   2: aconst_null
/*     */     //   3: astore #4
/*     */     //   5: aload_0
/*     */     //   6: invokestatic nullToEmpty : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   9: ldc '\s'
/*     */     //   11: ldc ''
/*     */     //   13: invokevirtual replaceAll : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   16: astore #5
/*     */     //   18: aload_1
/*     */     //   19: ifnull -> 33
/*     */     //   22: aload_1
/*     */     //   23: aload_2
/*     */     //   24: aload #5
/*     */     //   26: invokeinterface remap : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   31: astore #5
/*     */     //   33: aload #5
/*     */     //   35: bipush #46
/*     */     //   37: invokevirtual lastIndexOf : (I)I
/*     */     //   40: istore #6
/*     */     //   42: aload #5
/*     */     //   44: bipush #59
/*     */     //   46: invokevirtual indexOf : (I)I
/*     */     //   49: istore #7
/*     */     //   51: iload #6
/*     */     //   53: iconst_m1
/*     */     //   54: if_icmple -> 88
/*     */     //   57: aload #5
/*     */     //   59: iconst_0
/*     */     //   60: iload #6
/*     */     //   62: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   65: bipush #46
/*     */     //   67: bipush #47
/*     */     //   69: invokevirtual replace : (CC)Ljava/lang/String;
/*     */     //   72: astore #4
/*     */     //   74: aload #5
/*     */     //   76: iload #6
/*     */     //   78: iconst_1
/*     */     //   79: iadd
/*     */     //   80: invokevirtual substring : (I)Ljava/lang/String;
/*     */     //   83: astore #5
/*     */     //   85: goto -> 139
/*     */     //   88: iload #7
/*     */     //   90: iconst_m1
/*     */     //   91: if_icmple -> 139
/*     */     //   94: aload #5
/*     */     //   96: ldc 'L'
/*     */     //   98: invokevirtual startsWith : (Ljava/lang/String;)Z
/*     */     //   101: ifeq -> 139
/*     */     //   104: goto -> 111
/*     */     //   107: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   110: athrow
/*     */     //   111: aload #5
/*     */     //   113: iconst_1
/*     */     //   114: iload #7
/*     */     //   116: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   119: bipush #46
/*     */     //   121: bipush #47
/*     */     //   123: invokevirtual replace : (CC)Ljava/lang/String;
/*     */     //   126: astore #4
/*     */     //   128: aload #5
/*     */     //   130: iload #7
/*     */     //   132: iconst_1
/*     */     //   133: iadd
/*     */     //   134: invokevirtual substring : (I)Ljava/lang/String;
/*     */     //   137: astore #5
/*     */     //   139: aload #5
/*     */     //   141: bipush #40
/*     */     //   143: invokevirtual indexOf : (I)I
/*     */     //   146: istore #8
/*     */     //   148: aload #5
/*     */     //   150: bipush #58
/*     */     //   152: invokevirtual indexOf : (I)I
/*     */     //   155: istore #9
/*     */     //   157: iload #8
/*     */     //   159: iconst_m1
/*     */     //   160: if_icmple -> 184
/*     */     //   163: aload #5
/*     */     //   165: iload #8
/*     */     //   167: invokevirtual substring : (I)Ljava/lang/String;
/*     */     //   170: astore_3
/*     */     //   171: aload #5
/*     */     //   173: iconst_0
/*     */     //   174: iload #8
/*     */     //   176: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   179: astore #5
/*     */     //   181: goto -> 210
/*     */     //   184: iload #9
/*     */     //   186: iconst_m1
/*     */     //   187: if_icmple -> 210
/*     */     //   190: aload #5
/*     */     //   192: iload #9
/*     */     //   194: iconst_1
/*     */     //   195: iadd
/*     */     //   196: invokevirtual substring : (I)Ljava/lang/String;
/*     */     //   199: astore_3
/*     */     //   200: aload #5
/*     */     //   202: iconst_0
/*     */     //   203: iload #9
/*     */     //   205: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   208: astore #5
/*     */     //   210: aload #5
/*     */     //   212: bipush #47
/*     */     //   214: invokevirtual indexOf : (I)I
/*     */     //   217: iconst_m1
/*     */     //   218: if_icmpgt -> 239
/*     */     //   221: aload #5
/*     */     //   223: bipush #46
/*     */     //   225: invokevirtual indexOf : (I)I
/*     */     //   228: iconst_m1
/*     */     //   229: if_icmple -> 259
/*     */     //   232: goto -> 239
/*     */     //   235: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   238: athrow
/*     */     //   239: aload #4
/*     */     //   241: ifnonnull -> 259
/*     */     //   244: goto -> 251
/*     */     //   247: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   250: athrow
/*     */     //   251: aload #5
/*     */     //   253: astore #4
/*     */     //   255: ldc ''
/*     */     //   257: astore #5
/*     */     //   259: aload #5
/*     */     //   261: ldc '*'
/*     */     //   263: invokevirtual endsWith : (Ljava/lang/String;)Z
/*     */     //   266: istore #10
/*     */     //   268: iload #10
/*     */     //   270: ifeq -> 288
/*     */     //   273: aload #5
/*     */     //   275: iconst_0
/*     */     //   276: aload #5
/*     */     //   278: invokevirtual length : ()I
/*     */     //   281: iconst_1
/*     */     //   282: isub
/*     */     //   283: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   286: astore #5
/*     */     //   288: aload #5
/*     */     //   290: invokevirtual isEmpty : ()Z
/*     */     //   293: ifeq -> 299
/*     */     //   296: aconst_null
/*     */     //   297: astore #5
/*     */     //   299: new org/spongepowered/asm/mixin/injection/struct/MemberInfo
/*     */     //   302: dup
/*     */     //   303: aload #5
/*     */     //   305: aload #4
/*     */     //   307: aload_3
/*     */     //   308: iload #10
/*     */     //   310: aload_0
/*     */     //   311: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
/*     */     //   314: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #20	-> 0
/*     */     //   #124	-> 2
/*     */     //   #154	-> 5
/*     */     //   #21	-> 18
/*     */     //   #67	-> 22
/*     */     //   #115	-> 33
/*     */     //   #121	-> 42
/*     */     //   #34	-> 51
/*     */     //   #151	-> 57
/*     */     //   #148	-> 74
/*     */     //   #54	-> 88
/*     */     //   #163	-> 111
/*     */     //   #103	-> 128
/*     */     //   #5	-> 139
/*     */     //   #74	-> 148
/*     */     //   #86	-> 157
/*     */     //   #60	-> 163
/*     */     //   #93	-> 171
/*     */     //   #28	-> 184
/*     */     //   #114	-> 190
/*     */     //   #135	-> 200
/*     */     //   #160	-> 210
/*     */     //   #147	-> 251
/*     */     //   #82	-> 255
/*     */     //   #165	-> 259
/*     */     //   #94	-> 268
/*     */     //   #190	-> 273
/*     */     //   #167	-> 288
/*     */     //   #49	-> 296
/*     */     //   #87	-> 299
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   88	104	107	java/lang/IllegalArgumentException
/*     */     //   210	232	235	java/lang/IllegalArgumentException
/*     */     //   221	244	247	java/lang/IllegalArgumentException }
/*     */   public MemberInfo(String paramString1, String paramString2, String paramString3) { this(paramString1, paramString2, paramString3, false); }
/*     */   public boolean isField() { try { if (!this.forceField) { try { if (this.desc != null) try { if (!this.desc.startsWith("(")); } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }   } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return false; }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  } public boolean matches(String paramString1, String paramString2) { return matches(paramString1, paramString2, 0); } public MemberInfo(IMapping<?> paramIMapping) { this.owner = paramIMapping.getOwner(); this.name = paramIMapping.getSimpleName(); this.desc = paramIMapping.getDesc(); this.matchAll = false; this.forceField = (paramIMapping.getType() == IMapping.Type.FIELD); this.unparsed = null; } public boolean matches(String paramString1, String paramString2, int paramInt) { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield name : Ljava/lang/String;
/*     */     //   4: ifnull -> 25
/*     */     //   7: aload_0
/*     */     //   8: getfield name : Ljava/lang/String;
/*     */     //   11: aload_1
/*     */     //   12: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   15: ifeq -> 101
/*     */     //   18: goto -> 25
/*     */     //   21: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   24: athrow
/*     */     //   25: aload_0
/*     */     //   26: getfield desc : Ljava/lang/String;
/*     */     //   29: ifnull -> 68
/*     */     //   32: goto -> 39
/*     */     //   35: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   38: athrow
/*     */     //   39: aload_2
/*     */     //   40: ifnull -> 101
/*     */     //   43: goto -> 50
/*     */     //   46: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   49: athrow
/*     */     //   50: aload_2
/*     */     //   51: aload_0
/*     */     //   52: getfield desc : Ljava/lang/String;
/*     */     //   55: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   58: ifeq -> 101
/*     */     //   61: goto -> 68
/*     */     //   64: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   67: athrow
/*     */     //   68: iload_3
/*     */     //   69: ifeq -> 93
/*     */     //   72: goto -> 79
/*     */     //   75: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   78: athrow
/*     */     //   79: aload_0
/*     */     //   80: getfield matchAll : Z
/*     */     //   83: ifeq -> 101
/*     */     //   86: goto -> 93
/*     */     //   89: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   92: athrow
/*     */     //   93: iconst_1
/*     */     //   94: goto -> 102
/*     */     //   97: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*     */     //   100: athrow
/*     */     //   101: iconst_0
/*     */     //   102: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #47	-> 0
/*     */     //   #132	-> 55
/*     */     //   #122	-> 102
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   0	18	21	java/lang/IllegalArgumentException
/*     */     //   7	32	35	java/lang/IllegalArgumentException
/*     */     //   25	43	46	java/lang/IllegalArgumentException
/*     */     //   39	61	64	java/lang/IllegalArgumentException
/*     */     //   50	72	75	java/lang/IllegalArgumentException
/*     */     //   68	86	89	java/lang/IllegalArgumentException
/* 187 */     //   79	97	97	java/lang/IllegalArgumentException } public MemberInfo(String paramString1, String paramString2, boolean paramBoolean) { this(paramString1, paramString2, null, paramBoolean); } public MemberInfo remapUsing(MappingMethod paramMappingMethod, boolean paramBoolean) { return new MemberInfo(this, paramMappingMethod, paramBoolean); } public MemberInfo validate() throws InvalidMemberDescriptorException { try { if (this.owner != null) { try { if (!this.owner.matches("(?i)^[\\w\\p{Sc}/]+$")) throw new InvalidMemberDescriptorException("Invalid owner: " + this.owner);  } catch (Exception exception) { throw b(null); }  try { if (this.unparsed != null) try { if (this.unparsed.lastIndexOf('.') > 0) try { if (this.owner.startsWith("L")) throw new InvalidMemberDescriptorException("Malformed owner: " + this.owner + " If you are seeing this message unexpectedly and the owner appears to be correct, replace the owner descriptor with formal type L" + this.owner + "; to suppress this error");  } catch (Exception exception) { throw b(null); }   } catch (Exception exception) { throw b(null); }   } catch (Exception exception) { throw b(null); }  }  } catch (Exception exception) { throw b(null); }  try { if (this.name != null) try { if (!this.name.matches("(?i)^<?[\\w\\p{Sc}]+>?$")) throw new InvalidMemberDescriptorException("Invalid name: " + this.name);  } catch (Exception exception) { throw b(null); }   } catch (Exception exception) { throw b(null); }  try { if (this.desc != null) { try { if (!this.desc.matches("^(\\([\\w\\p{Sc}\\[/;]*\\))?\\[*[\\w\\p{Sc}/;]+$")) throw new InvalidMemberDescriptorException("Invalid descriptor: " + this.desc);  } catch (Exception exception) { throw b(null); }  try { if (isField()) { try { if (!this.desc.equals(Type.getType(this.desc).getDescriptor())) throw new InvalidMemberDescriptorException("Invalid field type in descriptor: " + this.desc);  } catch (Exception exception) { throw b(null); }  } else { try { Type.getArgumentTypes(this.desc); } catch (Exception exception) { throw new InvalidMemberDescriptorException("Invalid descriptor: " + this.desc); }  String str = this.desc.substring(this.desc.indexOf(')') + 1); try { Type type = Type.getType(str); try { if (!str.equals(type.getDescriptor())) throw new InvalidMemberDescriptorException("Invalid return type \"" + str + "\" in descriptor: " + this.desc);  } catch (Exception exception) { throw b(null); }  } catch (Exception exception) { throw new InvalidMemberDescriptorException("Invalid return type \"" + str + "\" in descriptor: " + this.desc); }  }  } catch (Exception exception) { throw b(null); }  }  } catch (Exception exception) { throw b(null); }  return this; }
/*     */   public static MemberInfo parseAndValidate(String paramString, IMixinContext paramIMixinContext) throws InvalidMemberDescriptorException { return parse(paramString, paramIMixinContext.getReferenceMapper(), paramIMixinContext.getClassRef()).validate(); }
/*     */   public boolean matches(String paramString1, String paramString2, String paramString3) { return matches(paramString1, paramString2, paramString3, 0); }
/*     */   public MemberInfo(String paramString1, String paramString2, String paramString3, boolean paramBoolean) { this(paramString1, paramString2, paramString3, paramBoolean, null); }
/*     */   public static MemberInfo fromMapping(IMapping<?> paramIMapping) { return new MemberInfo(paramIMapping); }
/*     */   private MemberInfo(MemberInfo paramMemberInfo, String paramString) { this.owner = paramString; this.name = paramMemberInfo.name; this.desc = paramMemberInfo.desc; this.matchAll = paramMemberInfo.matchAll; this.forceField = paramMemberInfo.forceField; this.unparsed = null; }
/*     */   public static MemberInfo parseAndValidate(String paramString) throws InvalidMemberDescriptorException { return parse(paramString, null, null).validate(); }
/* 194 */   @Deprecated public String toSrg() { try { if (!isFullyQualified()) throw new MixinException("Cannot convert unqualified reference to SRG mapping");  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  try { if (this.desc.startsWith("(")) return this.owner + "/" + this.name + " " + this.desc;  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  return this.owner + "/" + this.name; } public static MemberInfo parse(String paramString) { return parse(paramString, null, null); } public MemberInfo(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4) { if (paramString2 != null) try { if (paramString2.contains("."))
/*     */           throw new IllegalArgumentException("Attempt to instance a MemberInfo with an invalid owner format");  }
/*     */       catch (IllegalArgumentException illegalArgumentException)
/*     */       { throw b(null); }
/*     */        
/*     */     this.owner = paramString2;
/*     */     this.name = paramString1;
/*     */     this.desc = paramString3;
/*     */     this.matchAll = paramBoolean;
/*     */     this.forceField = false;
/*     */     this.unparsed = paramString4; }
/*     */ 
/*     */   
/*     */   public boolean isFullyQualified() {
/*     */     try {
/*     */       if (this.owner != null)
/*     */         try {
/*     */           if (this.name != null)
/*     */             try {
/*     */               if (this.desc != null);
/*     */             } catch (IllegalArgumentException illegalArgumentException) {
/*     */               throw b(null);
/*     */             }  
/*     */         } catch (IllegalArgumentException illegalArgumentException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public static MemberInfo parse(String paramString, IMixinContext paramIMixinContext) {
/*     */     return parse(paramString, paramIMixinContext.getReferenceMapper(), paramIMixinContext.getClassRef());
/*     */   }
/*     */   
/*     */   public MemberInfo transform(String paramString) {
/*     */     try {
/*     */       if (paramString == null)
/*     */         try {
/*     */           if (this.desc == null)
/*     */             return this; 
/*     */           try {
/*     */             if (paramString != null)
/*     */               try {
/*     */                 if (paramString.equals(this.desc))
/*     */                   return this; 
/*     */               } catch (IllegalArgumentException illegalArgumentException) {
/*     */                 throw b(null);
/*     */               }  
/*     */           } catch (IllegalArgumentException illegalArgumentException) {
/*     */             throw b(null);
/*     */           } 
/*     */         } catch (IllegalArgumentException illegalArgumentException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (paramString != null)
/*     */         try {
/*     */           if (paramString.equals(this.desc))
/*     */             return this; 
/*     */         } catch (IllegalArgumentException illegalArgumentException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isClassInitialiser() {
/*     */     return "<clinit>".equals(this.name);
/*     */   }
/*     */   
/*     */   public String toCtorDesc() {
/*     */     try {
/*     */       if (this.desc != null)
/*     */         try {
/*     */           if (this.desc.startsWith("("))
/*     */             try {
/*     */               if (this.desc.indexOf(')') > -1)
/*     */                 return this.desc.substring(0, this.desc.indexOf(')') + 1) + "V"; 
/*     */             } catch (IllegalArgumentException illegalArgumentException) {
/*     */               throw b(null);
/*     */             }  
/*     */         } catch (IllegalArgumentException illegalArgumentException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   public boolean isInitialiser() {
/*     */     try {
/*     */       if (!isConstructor()) {
/*     */         try {
/*     */           if (isClassInitialiser());
/*     */         } catch (IllegalArgumentException illegalArgumentException) {
/*     */           throw b(null);
/*     */         } 
/*     */         return false;
/*     */       } 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   public MemberInfo move(String paramString) {
/*     */     try {
/*     */       if (paramString == null)
/*     */         try {
/*     */           if (this.owner == null)
/*     */             return this; 
/*     */           try {
/*     */             if (paramString != null)
/*     */               try {
/*     */                 if (paramString.equals(this.owner))
/*     */                   return this; 
/*     */               } catch (IllegalArgumentException illegalArgumentException) {
/*     */                 throw b(null);
/*     */               }  
/*     */           } catch (IllegalArgumentException illegalArgumentException) {
/*     */             throw b(null);
/*     */           } 
/*     */         } catch (IllegalArgumentException illegalArgumentException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (paramString != null)
/*     */         try {
/*     */           if (paramString.equals(this.owner))
/*     */             return this; 
/*     */         } catch (IllegalArgumentException illegalArgumentException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   public MappingField asFieldMapping() {
/*     */     try {
/*     */       if (!isField())
/*     */         throw new MixinException("Cannot convert non-field reference " + this + " to FieldMapping"); 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return new MappingField(this.owner, this.name, this.desc);
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*     */     try {
/*     */       if (paramObject != null) {
/*     */         try {
/*     */           if (paramObject.getClass() != MemberInfo.class)
/*     */             return false; 
/*     */         } catch (IllegalArgumentException illegalArgumentException) {
/*     */           throw b(null);
/*     */         } 
/*     */       } else {
/*     */         return false;
/*     */       } 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     MemberInfo memberInfo = (MemberInfo)paramObject;
/*     */     try {
/*     */       if (this.matchAll == memberInfo.matchAll)
/*     */         try {
/*     */           if (this.forceField == memberInfo.forceField)
/*     */             try {
/*     */               if (Objects.equal(this.owner, memberInfo.owner))
/*     */                 try {
/*     */                   if (Objects.equal(this.name, memberInfo.name))
/*     */                     try {
/*     */                       if (Objects.equal(this.desc, memberInfo.desc));
/*     */                     } catch (IllegalArgumentException illegalArgumentException) {
/*     */                       throw b(null);
/*     */                     }  
/*     */                 } catch (IllegalArgumentException illegalArgumentException) {
/*     */                   throw b(null);
/*     */                 }  
/*     */             } catch (IllegalArgumentException illegalArgumentException) {
/*     */               throw b(null);
/*     */             }  
/*     */         } catch (IllegalArgumentException illegalArgumentException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public boolean isConstructor() {
/*     */     return "<init>".equals(this.name);
/*     */   }
/*     */   
/*     */   public MappingMethod asMethodMapping() {
/*     */     try {
/*     */       if (!isFullyQualified())
/*     */         throw new MixinException("Cannot convert unqualified reference " + this + " to MethodMapping"); 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (isField())
/*     */         throw new MixinException("Cannot convert a non-method reference " + this + " to MethodMapping"); 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return new MappingMethod(this.owner, this.name, this.desc);
/*     */   }
/*     */   
/*     */   public String toString() {
/*     */     try {
/*     */     
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     String str1 = (this.owner != null) ? ("L" + this.owner + ";") : "";
/*     */     try {
/*     */     
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     String str2 = (this.name != null) ? this.name : "";
/*     */     try {
/*     */     
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     String str3 = this.matchAll ? "*" : "";
/*     */     try {
/*     */     
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     String str4 = (this.desc != null) ? this.desc : "";
/*     */     try {
/*     */       try {
/*     */       
/*     */       } catch (IllegalArgumentException illegalArgumentException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     String str5 = str4.startsWith("(") ? "" : ((this.desc != null) ? ":" : "");
/*     */     return str1 + str2 + str3 + str5 + str4;
/*     */   }
/*     */   
/*     */   public IMapping<?> asMapping() {
/*     */     try {
/*     */     
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return isField() ? (IMapping<?>)asFieldMapping() : (IMapping<?>)asMethodMapping();
/*     */   }
/*     */   
/*     */   public String toCtorType() {
/*     */     try {
/*     */       if (this.unparsed == null)
/*     */         return null; 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     String str = getReturnType();
/*     */     try {
/*     */       if (str != null)
/*     */         return str; 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (this.owner != null)
/*     */         return this.owner; 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (this.name != null)
/*     */         try {
/*     */           if (this.desc == null)
/*     */             return this.name; 
/*     */         } catch (IllegalArgumentException illegalArgumentException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */     
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return (this.desc != null) ? this.desc : this.unparsed;
/*     */   }
/*     */   
/*     */   public MemberInfo(String paramString, boolean paramBoolean) {
/*     */     this(paramString, null, null, paramBoolean);
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*     */     return Objects.hashCode(new Object[] { Boolean.valueOf(this.matchAll), this.owner, this.name, this.desc });
/*     */   }
/*     */   
/*     */   public String getReturnType() {
/*     */     try {
/*     */       if (this.desc != null)
/*     */         try {
/*     */           if (this.desc.indexOf(')') != -1)
/*     */             try {
/*     */               if (this.desc.indexOf('(') == 0) {
/*     */                 String str = this.desc.substring(this.desc.indexOf(')') + 1);
/*     */                 try {
/*     */                   if (str.startsWith("L"))
/*     */                     try {
/*     */                       if (str.endsWith(";"))
/*     */                         return str.substring(1, str.length() - 1); 
/*     */                     } catch (IllegalArgumentException illegalArgumentException) {
/*     */                       throw b(null);
/*     */                     }  
/*     */                 } catch (IllegalArgumentException illegalArgumentException) {
/*     */                   throw b(null);
/*     */                 } 
/*     */                 return str;
/*     */               } 
/*     */               return null;
/*     */             } catch (IllegalArgumentException illegalArgumentException) {
/*     */               throw b(null);
/*     */             }  
/*     */         } catch (IllegalArgumentException illegalArgumentException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   public String toDescriptor() {
/*     */     try {
/*     */       if (this.desc == null)
/*     */         return ""; 
/*     */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return (new SignaturePrinter(this)).setFullyQualified(true).toDescriptor();
/*     */   }
/*     */   
/*     */   private static Exception b(Exception paramException) {
/*     */     return paramException;
/*     */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\struct\MemberInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */