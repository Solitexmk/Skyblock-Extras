/*     */ package org.spongepowered.asm.mixin.transformer;public class MixinTargetContext extends ClassContext implements IMixinContext { public void transformDescriptor(TypeInsnNode paramTypeInsnNode) {
/*     */     try {
/*   3 */       if (!this.inheritsFromMixin) try { if (this.innerClasses.size() == 0)
/*     */           {
/*     */             return;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */            }
/*     */         
/*     */         catch (InvalidMixinException invalidMixinException)
/*     */         
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 149 */           throw b(null); }
/*     */       
/*     */     
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     paramTypeInsnNode.desc = transformSingleDescriptor(paramTypeInsnNode.desc, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object transformConstant(MethodNode paramMethodNode, Iterator<AbstractInsnNode> paramIterator, Object paramObject) {
/*     */     if (paramObject instanceof Type)
/* 250 */     { Type type = (Type)paramObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       String str = transformDescriptor(type);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       try { if (!type.toString().equals(str))
/* 300 */           return Type.getType(str);  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  return paramObject; }  try { if (paramObject instanceof Handle) return transformHandle(paramMethodNode, paramIterator, (Handle)paramObject);  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  return paramObject;
/*     */   }
/*     */   protected void requireVersion(int paramInt) { try { this.minRequiredClassVersion = Math.max(this.minRequiredClassVersion, paramInt); if (paramInt > MixinEnvironment.getCompatibilityLevel().classVersion()) throw new InvalidMixinException(this, "Unsupported mixin class version " + paramInt);  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  }
/*     */   public void preApply(String paramString, ClassNode paramClassNode) { this.mixin.preApply(paramString, paramClassNode); }
/*     */   public IReferenceMapper getReferenceMapper() { return this.mixin.getParent().getReferenceMapper(); }
/*     */   public ClassNode getTargetClassNode() { return getTarget().getClassNode(); }
/*     */   public Level getLoggingLevel() { return this.mixin.getLoggingLevel(); }
/*     */   public int getDefaultRequiredInjections() { return this.mixin.getParent().getDefaultRequiredInjections(); }
/*     */   public List<FieldNode> getFields() { return this.classNode.fields; }
/*     */   public void applyInjections() { for (InjectionInfo injectionInfo : this.injectors) injectionInfo.inject();  for (InjectionInfo injectionInfo : this.injectors) injectionInfo.postInject();  this.injectors.clear(); } public MixinEnvironment getEnvironment() { return this.mixin.getParent().getEnvironment(); } private void checkFinal(MethodNode paramMethodNode, Iterator<AbstractInsnNode> paramIterator, FieldInsnNode paramFieldInsnNode) { try { if (!paramFieldInsnNode.owner.equals(getTarget().getClassRef()))
/* 310 */         return;  } catch (InvalidMixinException invalidMixinException) { throw b(null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int i = paramFieldInsnNode.getOpcode();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try { if (i != 180)
/*     */         
/*     */         try { if (i != 178)
/*     */           { for (Map.Entry<FieldNode, ClassInfo$Field> entry : this.shadowFields.entrySet())
/*     */             { FieldNode fieldNode = (FieldNode)entry.getKey();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/*     */               if (fieldNode.desc.equals(paramFieldInsnNode.desc))
/*     */               { 
/*     */                 try { if (!fieldNode.name.equals(paramFieldInsnNode.name)) {
/*     */                     continue;
/*     */                   } }
/*     */                 catch (InvalidMixinException invalidMixinException)
/* 340 */                 { throw b(null); }  ClassInfo$Field classInfo$Field = (ClassInfo$Field)entry.getValue(); try { if (classInfo$Field.isDecoratedFinal()) try { if (classInfo$Field.isDecoratedMutable()) { try { if (this.mixin.getParent().getEnvironment().getOption(MixinEnvironment.Option.DEBUG_VERBOSE)) logger.warn("Write access to @Mutable @Final field {} in {}::{}", new Object[] { classInfo$Field, this.mixin, paramMethodNode.name });  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  } else { try { if (!"<init>".equals(paramMethodNode.name)) { try { if ("<clinit>".equals(paramMethodNode.name)) logger.warn("@Final field {} in {} should be final", new Object[] { classInfo$Field, this.mixin });  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  try { logger.error("Write access detected to @Final field {} in {}::{}", new Object[] { classInfo$Field, this.mixin, paramMethodNode.name }); if (this.mixin.getParent().getEnvironment().getOption(MixinEnvironment.Option.DEBUG_VERIFY)) throw new InvalidMixinException(this.mixin, "Write access detected to @Final field " + classInfo$Field + " in " + this.mixin + "::" + paramMethodNode.name);  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  return; }  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  logger.warn("@Final field {} in {} should be final", new Object[] { classInfo$Field, this.mixin }); }  } catch (InvalidMixinException invalidMixinException) { throw b(null); }   } catch (InvalidMixinException invalidMixinException) { throw b(null); }  }  }  return; }  return; } catch (InvalidMixinException invalidMixinException) { throw b(null); }   } catch (InvalidMixinException invalidMixinException) { throw b(null); }  }
/*     */   void addShadowField(FieldNode paramFieldNode, ClassInfo$Field paramClassInfo$Field) { this.shadowFields.put(paramFieldNode, paramClassInfo$Field); }
/*     */   public List<MethodNode> getMethods() { return this.classNode.methods; }
/* 343 */   public ClassSignature getSignature() { return getClassInfo().getSignature(); } public void postApply(String paramString, ClassNode paramClassNode) { try { this.injectorGroups.validateAll(); } catch (InjectionValidationException injectionValidationException) { InjectorGroupInfo injectorGroupInfo = injectionValidationException.getGroup(); throw new InjectionError(String.format("Critical injection failure: Callback group %s in %s failed injection check: %s", new Object[] { injectorGroupInfo, this.mixin, injectionValidationException.getMessage() })); }  this.mixin.postApply(paramString, paramClassNode); } public String getSourceFile() { return this.classNode.sourceFile; }
/*     */   public Collection<MethodNode> getShadowMethods() { return this.shadowMethods; }
/*     */   public String toString() { return this.mixin.toString(); }
/*     */   void addShadowMethod(MethodNode paramMethodNode) { this.shadowMethods.add(paramMethodNode); }
/*     */   public TargetClassContext getTarget() { return this.targetClass; }
/*     */   public String getTargetClassRef() { return getTarget().getClassRef(); }
/*     */   private String transformMethodDescriptor(String paramString) { StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append('('); Type[] arrayOfType; int i; byte b; for (arrayOfType = Type.getArgumentTypes(paramString), i = arrayOfType.length, b = 0; b < i; b++) { Type type = arrayOfType[b]; stringBuilder.append(transformSingleDescriptor(type)); }  return stringBuilder.append(')').append(transformSingleDescriptor(Type.getReturnType(paramString))).toString(); }
/*     */   private void transformTypeNode(MethodNode paramMethodNode, Iterator<AbstractInsnNode> paramIterator, TypeInsnNode paramTypeInsnNode, AbstractInsnNode paramAbstractInsnNode) { try { if (paramTypeInsnNode.getOpcode() == 192)
/*     */         try { if (paramTypeInsnNode.desc.equals(getTarget().getClassRef()))
/*     */             try { if (paramAbstractInsnNode.getOpcode() == 25)
/*     */                 try { if (((VarInsnNode)paramAbstractInsnNode).var == 0) { paramIterator.remove(); return; }  } catch (InvalidMixinException invalidMixinException) { throw b(null); }
/*     */                   }
/*     */             catch (InvalidMixinException invalidMixinException) { throw b(null); }
/*     */               }
/*     */         catch (InvalidMixinException invalidMixinException) { throw b(null); }
/*     */           }
/*     */     catch (InvalidMixinException invalidMixinException) { throw b(null); }
/* 360 */      try { if (paramTypeInsnNode.desc.equals(getClassRef())) { paramTypeInsnNode.desc = getTarget().getClassRef(); } else { String str = (String)this.innerClasses.get(paramTypeInsnNode.desc); try { if (str != null) paramTypeInsnNode.desc = str;  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  }  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  transformDescriptor(paramTypeInsnNode); } MethodNode findRemappedMethod(MethodNode paramMethodNode) { RemapperChain remapperChain = getEnvironment().getRemappers(); String str = remapperChain.mapMethodName(getTarget().getClassRef(), paramMethodNode.name, paramMethodNode.desc); try { if (str.equals(paramMethodNode.name)) return null;  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  LinkedList<String> linkedList = new LinkedList(); linkedList.add(str); return getTarget().findAliasedMethod(linkedList, paramMethodNode.desc); } public IMixinInfo getMixin() { return this.mixin; } public List<MethodNode> generateAccessors() { for (AccessorInfo accessorInfo : this.accessors) accessorInfo.locate();  ArrayList<MethodNode> arrayList = new ArrayList(); for (AccessorInfo accessorInfo : this.accessors) { MethodNode methodNode = accessorInfo.generate(); getTarget().addMixinMethod(methodNode); arrayList.add(methodNode); }  return arrayList; } MethodNode findMethod(MethodNode paramMethodNode, AnnotationNode paramAnnotationNode) { LinkedList<String> linkedList = new LinkedList(); linkedList.add(paramMethodNode.name); if (paramAnnotationNode != null) { List<? extends String> list = (List)Annotations.getValue(paramAnnotationNode, "aliases"); try { if (list != null) linkedList.addAll(list);  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  }  return getTarget().findMethod(linkedList, paramMethodNode.desc); }
/*     */   private void transformMethodRef(MethodNode paramMethodNode, Iterator<AbstractInsnNode> paramIterator, MemberRef paramMemberRef) { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: aload_3
/*     */     //   2: invokevirtual transformDescriptor : (Lorg/spongepowered/asm/mixin/struct/MemberRef;)V
/*     */     //   5: aload_3
/*     */     //   6: invokevirtual getOwner : ()Ljava/lang/String;
/*     */     //   9: aload_0
/*     */     //   10: invokevirtual getClassRef : ()Ljava/lang/String;
/*     */     //   13: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   16: ifeq -> 133
/*     */     //   19: aload_3
/*     */     //   20: aload_0
/*     */     //   21: invokevirtual getTarget : ()Lorg/spongepowered/asm/mixin/transformer/TargetClassContext;
/*     */     //   24: invokevirtual getClassRef : ()Ljava/lang/String;
/*     */     //   27: invokevirtual setOwner : (Ljava/lang/String;)V
/*     */     //   30: aload_0
/*     */     //   31: invokevirtual getClassInfo : ()Lorg/spongepowered/asm/mixin/transformer/ClassInfo;
/*     */     //   34: aload_3
/*     */     //   35: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   38: aload_3
/*     */     //   39: invokevirtual getDesc : ()Ljava/lang/String;
/*     */     //   42: bipush #10
/*     */     //   44: invokevirtual findMethod : (Ljava/lang/String;Ljava/lang/String;I)Lorg/spongepowered/asm/mixin/transformer/ClassInfo$Method;
/*     */     //   47: astore #4
/*     */     //   49: aload #4
/*     */     //   51: ifnull -> 122
/*     */     //   54: aload #4
/*     */     //   56: invokevirtual isRenamed : ()Z
/*     */     //   59: ifeq -> 122
/*     */     //   62: goto -> 69
/*     */     //   65: invokestatic b : (Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;)Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;
/*     */     //   68: athrow
/*     */     //   69: aload #4
/*     */     //   71: invokevirtual getOriginalName : ()Ljava/lang/String;
/*     */     //   74: aload_3
/*     */     //   75: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   78: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   81: ifeq -> 122
/*     */     //   84: goto -> 91
/*     */     //   87: invokestatic b : (Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;)Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;
/*     */     //   90: athrow
/*     */     //   91: aload #4
/*     */     //   93: invokevirtual isSynthetic : ()Z
/*     */     //   96: ifeq -> 122
/*     */     //   99: goto -> 106
/*     */     //   102: invokestatic b : (Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;)Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;
/*     */     //   105: athrow
/*     */     //   106: aload_3
/*     */     //   107: aload #4
/*     */     //   109: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   112: invokevirtual setName : (Ljava/lang/String;)V
/*     */     //   115: goto -> 122
/*     */     //   118: invokestatic b : (Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;)Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;
/*     */     //   121: athrow
/*     */     //   122: aload_0
/*     */     //   123: aload_1
/*     */     //   124: aload_3
/*     */     //   125: aload #4
/*     */     //   127: invokevirtual upgradeMethodRef : (Lorg/spongepowered/asm/lib/tree/MethodNode;Lorg/spongepowered/asm/mixin/struct/MemberRef;Lorg/spongepowered/asm/mixin/transformer/ClassInfo$Method;)V
/*     */     //   130: goto -> 282
/*     */     //   133: aload_0
/*     */     //   134: getfield innerClasses : Lcom/google/common/collect/BiMap;
/*     */     //   137: aload_3
/*     */     //   138: invokevirtual getOwner : ()Ljava/lang/String;
/*     */     //   141: invokeinterface containsKey : (Ljava/lang/Object;)Z
/*     */     //   146: ifeq -> 188
/*     */     //   149: aload_3
/*     */     //   150: aload_0
/*     */     //   151: getfield innerClasses : Lcom/google/common/collect/BiMap;
/*     */     //   154: aload_3
/*     */     //   155: invokevirtual getOwner : ()Ljava/lang/String;
/*     */     //   158: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   163: checkcast java/lang/String
/*     */     //   166: invokevirtual setOwner : (Ljava/lang/String;)V
/*     */     //   169: aload_3
/*     */     //   170: aload_0
/*     */     //   171: aload_3
/*     */     //   172: invokevirtual getDesc : ()Ljava/lang/String;
/*     */     //   175: invokespecial transformMethodDescriptor : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   178: invokevirtual setDesc : (Ljava/lang/String;)V
/*     */     //   181: goto -> 282
/*     */     //   184: invokestatic b : (Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;)Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;
/*     */     //   187: athrow
/*     */     //   188: aload_0
/*     */     //   189: getfield detachedSuper : Z
/*     */     //   192: ifne -> 209
/*     */     //   195: aload_0
/*     */     //   196: getfield inheritsFromMixin : Z
/*     */     //   199: ifeq -> 282
/*     */     //   202: goto -> 209
/*     */     //   205: invokestatic b : (Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;)Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;
/*     */     //   208: athrow
/*     */     //   209: aload_3
/*     */     //   210: invokevirtual getOpcode : ()I
/*     */     //   213: sipush #183
/*     */     //   216: if_icmpne -> 239
/*     */     //   219: goto -> 226
/*     */     //   222: invokestatic b : (Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;)Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;
/*     */     //   225: athrow
/*     */     //   226: aload_0
/*     */     //   227: aload_1
/*     */     //   228: aload_3
/*     */     //   229: invokespecial updateStaticBinding : (Lorg/spongepowered/asm/lib/tree/MethodNode;Lorg/spongepowered/asm/mixin/struct/MemberRef;)V
/*     */     //   232: goto -> 282
/*     */     //   235: invokestatic b : (Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;)Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;
/*     */     //   238: athrow
/*     */     //   239: aload_3
/*     */     //   240: invokevirtual getOpcode : ()I
/*     */     //   243: sipush #182
/*     */     //   246: if_icmpne -> 282
/*     */     //   249: aload_3
/*     */     //   250: invokevirtual getOwner : ()Ljava/lang/String;
/*     */     //   253: invokestatic forName : (Ljava/lang/String;)Lorg/spongepowered/asm/mixin/transformer/ClassInfo;
/*     */     //   256: invokevirtual isMixin : ()Z
/*     */     //   259: ifeq -> 282
/*     */     //   262: goto -> 269
/*     */     //   265: invokestatic b : (Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;)Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;
/*     */     //   268: athrow
/*     */     //   269: aload_0
/*     */     //   270: aload_1
/*     */     //   271: aload_3
/*     */     //   272: invokespecial updateDynamicBinding : (Lorg/spongepowered/asm/lib/tree/MethodNode;Lorg/spongepowered/asm/mixin/struct/MemberRef;)V
/*     */     //   275: goto -> 282
/*     */     //   278: invokestatic b : (Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;)Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;
/*     */     //   281: athrow
/*     */     //   282: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #146	-> 0
/*     */     //   #312	-> 5
/*     */     //   #118	-> 19
/*     */     //   #116	-> 30
/*     */     //   #303	-> 49
/*     */     //   #58	-> 106
/*     */     //   #138	-> 122
/*     */     //   #324	-> 130
/*     */     //   #251	-> 149
/*     */     //   #47	-> 169
/*     */     //   #151	-> 188
/*     */     //   #323	-> 209
/*     */     //   #297	-> 226
/*     */     //   #44	-> 239
/*     */     //   #258	-> 269
/*     */     //   #308	-> 282
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   49	62	65	org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */     //   54	84	87	org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */     //   69	99	102	org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */     //   91	115	118	org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */     //   133	184	184	org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */     //   188	202	205	org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */     //   195	219	222	org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */     //   209	235	235	org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */     //   239	262	265	org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */     //   249	275	278	org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException }
/* 362 */   private void updateBinding(MethodNode paramMethodNode, MemberRef paramMemberRef, ClassInfo$Traversal paramClassInfo$Traversal) { try { if (!"<init>".equals(paramMethodNode.name)) { try { if (!paramMemberRef.getOwner().equals(getTarget().getClassRef())) { try { if (getTarget().getClassRef().startsWith("<")) return;  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  } else { return; }  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  } else { return; }  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  ClassInfo$Method classInfo$Method = this.targetClassInfo.findMethodInHierarchy(paramMemberRef.getName(), paramMemberRef.getDesc(), paramClassInfo$Traversal.getSearchType(), paramClassInfo$Traversal);
/*     */     try {
/*     */       if (classInfo$Method != null) {
/*     */         try {
/*     */           if (classInfo$Method.getOwner().isMixin())
/*     */             throw new InvalidMixinException(this, "Invalid " + paramMemberRef + " in " + this + " resolved " + classInfo$Method.getOwner() + " but is mixin."); 
/*     */         } catch (InvalidMixinException invalidMixinException) {
/*     */           throw b(null);
/*     */         } 
/*     */         paramMemberRef.setOwner(classInfo$Method.getImplementor().getName());
/*     */       } 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (ClassInfo.forName(paramMemberRef.getOwner()).isMixin())
/*     */         throw new MixinTransformerError("Error resolving " + paramMemberRef + " in " + this); 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     }  }
/*     */ 
/*     */   
/*     */   public Extensions getExtensions() {
/*     */     return this.targetClass.getExtensions();
/*     */   }
/*     */   
/*     */   private Handle transformHandle(MethodNode paramMethodNode, Iterator<AbstractInsnNode> paramIterator, Handle paramHandle) {
/*     */     MemberRef.Handle handle = new MemberRef.Handle(paramHandle);
/*     */     try {
/*     */       if (handle.isField()) {
/*     */         transformFieldRef(paramMethodNode, paramIterator, (MemberRef)handle);
/*     */       } else {
/*     */         transformMethodRef(paramMethodNode, paramIterator, (MemberRef)handle);
/*     */       } 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return handle.getMethodHandle();
/*     */   }
/*     */   
/*     */   private void transformFieldRef(MethodNode paramMethodNode, Iterator<AbstractInsnNode> paramIterator, MemberRef paramMemberRef) {
/*     */     try {
/*     */       if ("super$".equals(paramMemberRef.getName())) {
/*     */         try {
/*     */           if (paramMemberRef instanceof MemberRef.Field) {
/*     */             processImaginarySuper(paramMethodNode, ((MemberRef.Field)paramMemberRef).insn);
/*     */             paramIterator.remove();
/*     */           } 
/*     */         } catch (InvalidMixinException invalidMixinException) {
/*     */           throw b(null);
/*     */         } 
/*     */         throw new InvalidMixinException(this.mixin, "Cannot call imaginary super from method handle.");
/*     */       } 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     transformDescriptor(paramMemberRef);
/*     */     if (paramMemberRef.getOwner().equals(getClassRef())) {
/*     */       paramMemberRef.setOwner(getTarget().getClassRef());
/*     */       ClassInfo$Field classInfo$Field = getClassInfo().findField(paramMemberRef.getName(), paramMemberRef.getDesc(), 10);
/*     */       try {
/*     */         if (classInfo$Field != null)
/*     */           try {
/*     */             if (classInfo$Field.isRenamed())
/*     */               try {
/*     */                 if (classInfo$Field.getOriginalName().equals(paramMemberRef.getName()))
/*     */                   try {
/*     */                     if (classInfo$Field.isStatic())
/*     */                       paramMemberRef.setName(classInfo$Field.getName()); 
/*     */                   } catch (InvalidMixinException invalidMixinException) {
/*     */                     throw b(null);
/*     */                   }  
/*     */               } catch (InvalidMixinException invalidMixinException) {
/*     */                 throw b(null);
/*     */               }  
/*     */           } catch (InvalidMixinException invalidMixinException) {
/*     */             throw b(null);
/*     */           }  
/*     */       } catch (InvalidMixinException invalidMixinException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     ClassInfo classInfo = ClassInfo.forName(paramMemberRef.getOwner());
/*     */     if (classInfo.isMixin()) {
/*     */       ClassInfo classInfo1 = this.targetClassInfo.findCorrespondingType(classInfo);
/*     */       try {
/*     */       
/*     */       } catch (InvalidMixinException invalidMixinException) {
/*     */         throw b(null);
/*     */       } 
/*     */       paramMemberRef.setOwner((classInfo1 != null) ? classInfo1.getName() : getTarget().getClassRef());
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean shouldSetSourceFile() {
/*     */     return this.mixin.getParent().shouldSetSourceFile();
/*     */   }
/*     */   
/*     */   MixinInfo getInfo() {
/*     */     return this.mixin;
/*     */   }
/*     */   
/*     */   public int getPriority() {
/*     */     return this.mixin.getPriority();
/*     */   }
/*     */   
/*     */   private void validateMethod(MethodNode paramMethodNode) {
/*     */     if (Annotations.getInvisible(paramMethodNode, SoftOverride.class) != null) {
/*     */       ClassInfo$Method classInfo$Method = this.targetClassInfo.findMethodInHierarchy(paramMethodNode.name, paramMethodNode.desc, ClassInfo$SearchType.SUPER_CLASSES_ONLY, ClassInfo$Traversal.SUPER);
/*     */       try {
/*     */         if (classInfo$Method != null) {
/*     */           try {
/*     */             if (!classInfo$Method.isInjected())
/*     */               throw new InvalidMixinException(this, "Mixin method " + paramMethodNode.name + paramMethodNode.desc + " is tagged with @SoftOverride but no valid method was found in superclasses of " + getTarget().getClassName()); 
/*     */           } catch (InvalidMixinException invalidMixinException) {
/*     */             throw b(null);
/*     */           } 
/*     */           return;
/*     */         } 
/*     */       } catch (InvalidMixinException invalidMixinException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private String transformDescriptor(Type paramType) {
/*     */     try {
/*     */       if (paramType.getSort() == 11)
/*     */         return transformMethodDescriptor(paramType.getDescriptor()); 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return transformSingleDescriptor(paramType);
/*     */   }
/*     */   
/*     */   public String getDefaultInjectorGroup() {
/*     */     return this.mixin.getParent().getDefaultInjectorGroup();
/*     */   }
/*     */   
/*     */   public boolean getOption(MixinEnvironment.Option paramOption) {
/*     */     return getEnvironment().getOption(paramOption);
/*     */   }
/*     */   
/*     */   public String getUniqueName(MethodNode paramMethodNode, boolean paramBoolean) {
/*     */     return getTarget().getUniqueName(paramMethodNode, paramBoolean);
/*     */   }
/*     */   
/*     */   public ClassInfo findRealType(ClassInfo paramClassInfo) {
/*     */     try {
/*     */       if (paramClassInfo == getClassInfo())
/*     */         return this.targetClassInfo; 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     ClassInfo classInfo = this.targetClassInfo.findCorrespondingType(paramClassInfo);
/*     */     try {
/*     */       if (classInfo == null)
/*     */         throw new InvalidMixinException(this, "Resolution error: unable to find corresponding type for " + paramClassInfo + " in hierarchy of " + this.targetClassInfo); 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return classInfo;
/*     */   }
/*     */   
/*     */   private String transformSingleDescriptor(Type paramType) {
/*     */     try {
/*     */       if (paramType.getSort() < 9)
/*     */         return paramType.toString(); 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return transformSingleDescriptor(paramType.toString(), false);
/*     */   }
/*     */   
/*     */   public int getMaxShiftByValue() {
/*     */     return this.mixin.getParent().getMaxShiftByValue();
/*     */   }
/*     */   
/*     */   FieldNode findRemappedField(FieldNode paramFieldNode) {
/*     */     RemapperChain remapperChain = getEnvironment().getRemappers();
/*     */     String str = remapperChain.mapFieldName(getTarget().getClassRef(), paramFieldNode.name, paramFieldNode.desc);
/*     */     try {
/*     */       if (str.equals(paramFieldNode.name))
/*     */         return null; 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     LinkedList<String> linkedList = new LinkedList();
/*     */     linkedList.add(str);
/*     */     return getTarget().findAliasedField(linkedList, paramFieldNode.desc);
/*     */   }
/*     */   
/*     */   public Set<String> getInterfaces() {
/*     */     return this.mixin.getInterfaces();
/*     */   }
/*     */   
/*     */   FieldNode findField(FieldNode paramFieldNode, AnnotationNode paramAnnotationNode) {
/*     */     LinkedList<String> linkedList = new LinkedList();
/*     */     linkedList.add(paramFieldNode.name);
/*     */     if (paramAnnotationNode != null) {
/*     */       List<? extends String> list = (List)Annotations.getValue(paramAnnotationNode, "aliases");
/*     */       try {
/*     */         if (list != null)
/*     */           linkedList.addAll(list); 
/*     */       } catch (InvalidMixinException invalidMixinException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     return getTarget().findAliasedField(linkedList, paramFieldNode.desc);
/*     */   }
/*     */   
/*     */   protected ClassInfo getClassInfo() {
/*     */     return this.mixin.getClassInfo();
/*     */   }
/*     */   
/*     */   void addMixinMethod(MethodNode paramMethodNode) {
/*     */     Annotations.setVisible(paramMethodNode, MixinMerged.class, new Object[] { "mixin", getClassName() });
/*     */     getTarget().addMixinMethod(paramMethodNode);
/*     */   }
/*     */   
/*     */   public InjectorGroupInfo.Map getInjectorGroups() {
/*     */     return this.injectorGroups;
/*     */   }
/*     */   
/*     */   private void transformLVT(MethodNode paramMethodNode) {
/*     */     try {
/*     */       if (paramMethodNode.localVariables == null)
/*     */         return; 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     for (LocalVariableNode localVariableNode : paramMethodNode.localVariables) {
/*     */       if (localVariableNode != null) {
/*     */         try {
/*     */           if (localVariableNode.desc == null)
/*     */             continue; 
/*     */         } catch (InvalidMixinException invalidMixinException) {
/*     */           throw b(null);
/*     */         } 
/*     */         localVariableNode.desc = transformSingleDescriptor(Type.getType(localVariableNode.desc));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   void methodMerged(MethodNode paramMethodNode) {
/*     */     this.mergedMethods.add(paramMethodNode);
/*     */     this.targetClassInfo.addMethod(paramMethodNode);
/*     */     getTarget().methodMerged(paramMethodNode);
/*     */     Annotations.setVisible(paramMethodNode, MixinMerged.class, new Object[] { "mixin", getClassName(), "priority", Integer.valueOf(getPriority()), "sessionId", this.sessionId });
/*     */   }
/*     */   
/*     */   public SourceMap.File getStratum() {
/*     */     return this.stratum;
/*     */   }
/*     */   
/*     */   private void updateStaticBinding(MethodNode paramMethodNode, MemberRef paramMemberRef) {
/*     */     updateBinding(paramMethodNode, paramMemberRef, ClassInfo$Traversal.SUPER);
/*     */   }
/*     */   
/*     */   public void transformDescriptor(MemberRef paramMemberRef) {
/*     */     try {
/*     */       if (!this.inheritsFromMixin)
/*     */         try {
/*     */           if (this.innerClasses.size() == 0)
/*     */             return; 
/*     */         } catch (InvalidMixinException invalidMixinException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if (paramMemberRef.isField()) {
/*     */         paramMemberRef.setDesc(transformSingleDescriptor(paramMemberRef.getDesc(), false));
/*     */       } else {
/*     */         paramMemberRef.setDesc(transformMethodDescriptor(paramMemberRef.getDesc()));
/*     */       } 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean requireOverwriteAnnotations() {
/*     */     return this.mixin.getParent().requireOverwriteAnnotations();
/*     */   }
/*     */   
/*     */   public Target getTargetMethod(MethodNode paramMethodNode) {
/*     */     return getTarget().getTargetMethod(paramMethodNode);
/*     */   }
/*     */   
/*     */   public String getClassName() {
/*     */     return this.mixin.getClassName();
/*     */   }
/*     */   
/*     */   private void updateDynamicBinding(MethodNode paramMethodNode, MemberRef paramMemberRef) {
/*     */     updateBinding(paramMethodNode, paramMemberRef, ClassInfo$Traversal.ALL);
/*     */   }
/*     */   
/*     */   public String getUniqueName(FieldNode paramFieldNode) {
/*     */     return getTarget().getUniqueName(paramFieldNode);
/*     */   }
/*     */   
/*     */   public String getClassRef() {
/*     */     return this.mixin.getClassRef();
/*     */   }
/*     */   
/*     */   private String transformSingleDescriptor(String paramString, boolean paramBoolean) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: astore_3
/*     */     //   2: aload_3
/*     */     //   3: ldc '['
/*     */     //   5: invokevirtual startsWith : (Ljava/lang/String;)Z
/*     */     //   8: ifne -> 27
/*     */     //   11: aload_3
/*     */     //   12: ldc 'L'
/*     */     //   14: invokevirtual startsWith : (Ljava/lang/String;)Z
/*     */     //   17: ifeq -> 69
/*     */     //   20: goto -> 27
/*     */     //   23: invokestatic b : (Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;)Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;
/*     */     //   26: athrow
/*     */     //   27: aload_3
/*     */     //   28: ldc '['
/*     */     //   30: invokevirtual startsWith : (Ljava/lang/String;)Z
/*     */     //   33: ifeq -> 52
/*     */     //   36: goto -> 43
/*     */     //   39: invokestatic b : (Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;)Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;
/*     */     //   42: athrow
/*     */     //   43: aload_3
/*     */     //   44: iconst_1
/*     */     //   45: invokevirtual substring : (I)Ljava/lang/String;
/*     */     //   48: astore_3
/*     */     //   49: goto -> 2
/*     */     //   52: aload_3
/*     */     //   53: iconst_1
/*     */     //   54: aload_3
/*     */     //   55: ldc ';'
/*     */     //   57: invokevirtual indexOf : (Ljava/lang/String;)I
/*     */     //   60: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   63: astore_3
/*     */     //   64: iconst_1
/*     */     //   65: istore_2
/*     */     //   66: goto -> 2
/*     */     //   69: iload_2
/*     */     //   70: ifne -> 79
/*     */     //   73: aload_1
/*     */     //   74: areturn
/*     */     //   75: invokestatic b : (Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;)Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;
/*     */     //   78: athrow
/*     */     //   79: aload_0
/*     */     //   80: getfield innerClasses : Lcom/google/common/collect/BiMap;
/*     */     //   83: aload_3
/*     */     //   84: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   89: checkcast java/lang/String
/*     */     //   92: astore #4
/*     */     //   94: aload #4
/*     */     //   96: ifnull -> 111
/*     */     //   99: aload_1
/*     */     //   100: aload_3
/*     */     //   101: aload #4
/*     */     //   103: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
/*     */     //   106: areturn
/*     */     //   107: invokestatic b : (Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;)Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;
/*     */     //   110: athrow
/*     */     //   111: aload_0
/*     */     //   112: getfield innerClasses : Lcom/google/common/collect/BiMap;
/*     */     //   115: invokeinterface inverse : ()Lcom/google/common/collect/BiMap;
/*     */     //   120: aload_3
/*     */     //   121: invokeinterface containsKey : (Ljava/lang/Object;)Z
/*     */     //   126: ifeq -> 135
/*     */     //   129: aload_1
/*     */     //   130: areturn
/*     */     //   131: invokestatic b : (Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;)Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;
/*     */     //   134: athrow
/*     */     //   135: aload_3
/*     */     //   136: invokestatic forName : (Ljava/lang/String;)Lorg/spongepowered/asm/mixin/transformer/ClassInfo;
/*     */     //   139: astore #5
/*     */     //   141: aload #5
/*     */     //   143: invokevirtual isMixin : ()Z
/*     */     //   146: ifne -> 155
/*     */     //   149: aload_1
/*     */     //   150: areturn
/*     */     //   151: invokestatic b : (Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;)Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;
/*     */     //   154: athrow
/*     */     //   155: aload_1
/*     */     //   156: aload_3
/*     */     //   157: aload_0
/*     */     //   158: aload #5
/*     */     //   160: invokevirtual findRealType : (Lorg/spongepowered/asm/mixin/transformer/ClassInfo;)Lorg/spongepowered/asm/mixin/transformer/ClassInfo;
/*     */     //   163: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   166: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
/*     */     //   169: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #288	-> 0
/*     */     //   #259	-> 2
/*     */     //   #294	-> 27
/*     */     //   #76	-> 43
/*     */     //   #126	-> 49
/*     */     //   #320	-> 52
/*     */     //   #120	-> 64
/*     */     //   #212	-> 69
/*     */     //   #240	-> 73
/*     */     //   #16	-> 79
/*     */     //   #98	-> 94
/*     */     //   #215	-> 99
/*     */     //   #243	-> 111
/*     */     //   #210	-> 129
/*     */     //   #196	-> 135
/*     */     //   #152	-> 141
/*     */     //   #95	-> 149
/*     */     //   #291	-> 155
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	20	23	org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */     //   11	36	39	org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */     //   69	75	75	org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */     //   94	107	107	org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */     //   111	131	131	org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */     //   141	151	151	org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */   }
/*     */   
/*     */   public Set<Map.Entry<FieldNode, ClassInfo$Field>> getShadowFields() {
/*     */     return this.shadowFields.entrySet();
/*     */   }
/*     */   
/*     */   public void transformDescriptor(MethodNode paramMethodNode) {
/*     */     try {
/*     */       if (!this.inheritsFromMixin)
/*     */         try {
/*     */           if (this.innerClasses.size() == 0)
/*     */             return; 
/*     */         } catch (InvalidMixinException invalidMixinException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     paramMethodNode.desc = transformMethodDescriptor(paramMethodNode.desc);
/*     */   }
/*     */   
/*     */   public ClassNode getClassNode() {
/*     */     return this.classNode;
/*     */   }
/*     */   
/*     */   public ClassInfo getTargetClassInfo() {
/*     */     return this.targetClassInfo;
/*     */   }
/*     */   
/*     */   private void processImaginarySuper(MethodNode paramMethodNode, FieldInsnNode paramFieldInsnNode) {
/*     */     try {
/*     */       if (paramFieldInsnNode.getOpcode() != 180) {
/*     */         try {
/*     */           if ("<init>".equals(paramMethodNode.name))
/*     */             throw new InvalidMixinException(this, "Illegal imaginary super declaration: field " + paramFieldInsnNode.name + " must not specify an initialiser"); 
/*     */         } catch (InvalidMixinException invalidMixinException) {
/*     */           throw b(null);
/*     */         } 
/*     */         throw new InvalidMixinException(this, "Illegal imaginary super access: found " + Bytecode.getOpcodeName(paramFieldInsnNode.getOpcode()) + " opcode in " + paramMethodNode.name + paramMethodNode.desc);
/*     */       } 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     try {
/*     */       if ((paramMethodNode.access & 0x2) == 0)
/*     */         try {
/*     */           if ((paramMethodNode.access & 0x8) == 0) {
/*     */             try {
/*     */               if (Annotations.getInvisible(paramMethodNode, SoftOverride.class) == null)
/*     */                 throw new InvalidMixinException(this, "Illegal imaginary super access: method " + paramMethodNode.name + paramMethodNode.desc + " is not decorated with @SoftOverride"); 
/*     */             } catch (InvalidMixinException invalidMixinException) {
/*     */               throw b(null);
/*     */             } 
/*     */             for (ListIterator<AbstractInsnNode> listIterator = paramMethodNode.instructions.iterator(paramMethodNode.instructions.indexOf((AbstractInsnNode)paramFieldInsnNode)); listIterator.hasNext(); ) {
/*     */               AbstractInsnNode abstractInsnNode = listIterator.next();
/*     */               if (abstractInsnNode instanceof MethodInsnNode) {
/*     */                 MethodInsnNode methodInsnNode = (MethodInsnNode)abstractInsnNode;
/*     */                 try {
/*     */                   if (methodInsnNode.owner.equals(getClassRef()))
/*     */                     try {
/*     */                       if (methodInsnNode.name.equals(paramMethodNode.name))
/*     */                         try {
/*     */                           if (methodInsnNode.desc.equals(paramMethodNode.desc)) {
/*     */                             methodInsnNode.setOpcode(183);
/*     */                             updateStaticBinding(paramMethodNode, (MemberRef)new MemberRef.Method(methodInsnNode));
/*     */                             return;
/*     */                           } 
/*     */                         } catch (InvalidMixinException invalidMixinException) {
/*     */                           throw b(null);
/*     */                         }  
/*     */                     } catch (InvalidMixinException invalidMixinException) {
/*     */                       throw b(null);
/*     */                     }  
/*     */                 } catch (InvalidMixinException invalidMixinException) {
/*     */                   throw b(null);
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */             throw new InvalidMixinException(this, "Illegal imaginary super access: could not find INVOKE for " + paramMethodNode.name + paramMethodNode.desc);
/*     */           } 
/*     */           throw new InvalidMixinException(this, "Illegal imaginary super access: method " + paramMethodNode.name + paramMethodNode.desc + " is private or static");
/*     */         } catch (InvalidMixinException invalidMixinException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     throw new InvalidMixinException(this, "Illegal imaginary super access: method " + paramMethodNode.name + paramMethodNode.desc + " is private or static");
/*     */   }
/*     */   
/*     */   public void transformDescriptor(FieldNode paramFieldNode) {
/*     */     try {
/*     */       if (!this.inheritsFromMixin)
/*     */         try {
/*     */           if (this.innerClasses.size() == 0)
/*     */             return; 
/*     */         } catch (InvalidMixinException invalidMixinException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */     paramFieldNode.desc = transformSingleDescriptor(paramFieldNode.desc, false);
/*     */   }
/*     */   
/*     */   public void prepareInjections() {
/*     */     this.injectors.clear();
/*     */     for (MethodNode methodNode : this.mergedMethods) {
/*     */       continue;
/*     */       injectionInfo = InjectionInfo.parse(this, (MethodNode)SYNTHETIC_LOCAL_VARIABLE_2);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void transformConstantNode(MethodNode paramMethodNode, Iterator<AbstractInsnNode> paramIterator, LdcInsnNode paramLdcInsnNode) {
/*     */     paramLdcInsnNode.cst = transformConstant(paramMethodNode, paramIterator, paramLdcInsnNode.cst);
/*     */   }
/*     */   
/*     */   public int getMinRequiredClassVersion() {
/*     */     return this.minRequiredClassVersion;
/*     */   }
/*     */   
/*     */   private void transformInvokeDynamicNode(MethodNode paramMethodNode, Iterator<AbstractInsnNode> paramIterator, InvokeDynamicInsnNode paramInvokeDynamicInsnNode) {
/*     */     requireVersion(51);
/*     */     paramInvokeDynamicInsnNode.desc = transformMethodDescriptor(paramInvokeDynamicInsnNode.desc);
/*     */     paramInvokeDynamicInsnNode.bsm = transformHandle(paramMethodNode, paramIterator, paramInvokeDynamicInsnNode.bsm);
/*     */     byte b = 0;
/*     */     try {
/*     */       for (; b < paramInvokeDynamicInsnNode.bsmArgs.length; b++)
/*     */         paramInvokeDynamicInsnNode.bsmArgs[b] = transformConstant(paramMethodNode, paramIterator, paramInvokeDynamicInsnNode.bsmArgs[b]); 
/*     */     } catch (InvalidMixinException invalidMixinException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void transformMethod(MethodNode paramMethodNode) {
/*     */     validateMethod(paramMethodNode);
/*     */     transformDescriptor(paramMethodNode);
/*     */     transformLVT(paramMethodNode);
/*     */     this.stratum.applyOffset(paramMethodNode);
/*     */     AbstractInsnNode abstractInsnNode = null;
/*     */     for (ListIterator<AbstractInsnNode> listIterator = paramMethodNode.instructions.iterator(); listIterator.hasNext(); ) {
/*     */       AbstractInsnNode abstractInsnNode1 = listIterator.next();
/*     */       try {
/*     */         if (abstractInsnNode1 instanceof MethodInsnNode) {
/*     */           transformMethodRef(paramMethodNode, listIterator, (MemberRef)new MemberRef.Method((MethodInsnNode)abstractInsnNode1));
/*     */         } else {
/*     */           try {
/*     */             if (abstractInsnNode1 instanceof FieldInsnNode) {
/*     */               transformFieldRef(paramMethodNode, listIterator, (MemberRef)new MemberRef.Field((FieldInsnNode)abstractInsnNode1));
/*     */               checkFinal(paramMethodNode, listIterator, (FieldInsnNode)abstractInsnNode1);
/*     */             } else {
/*     */               try {
/*     */                 if (abstractInsnNode1 instanceof TypeInsnNode) {
/*     */                   transformTypeNode(paramMethodNode, listIterator, (TypeInsnNode)abstractInsnNode1, abstractInsnNode);
/*     */                 } else {
/*     */                   try {
/*     */                     if (abstractInsnNode1 instanceof LdcInsnNode) {
/*     */                       transformConstantNode(paramMethodNode, listIterator, (LdcInsnNode)abstractInsnNode1);
/*     */                     } else {
/*     */                       try {
/*     */                         if (abstractInsnNode1 instanceof InvokeDynamicInsnNode)
/*     */                           transformInvokeDynamicNode(paramMethodNode, listIterator, (InvokeDynamicInsnNode)abstractInsnNode1); 
/*     */                       } catch (InvalidMixinException invalidMixinException) {
/*     */                         throw b(null);
/*     */                       } 
/*     */                     } 
/*     */                   } catch (InvalidMixinException invalidMixinException) {
/*     */                     throw b(null);
/*     */                   } 
/*     */                 } 
/*     */               } catch (InvalidMixinException invalidMixinException) {
/*     */                 throw b(null);
/*     */               } 
/*     */             } 
/*     */           } catch (InvalidMixinException invalidMixinException) {
/*     */             throw b(null);
/*     */           } 
/*     */         } 
/*     */       } catch (InvalidMixinException invalidMixinException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   MixinTargetContext(MixinInfo paramMixinInfo, ClassNode paramClassNode, TargetClassContext paramTargetClassContext) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokespecial <init> : ()V
/*     */     //   4: aload_0
/*     */     //   5: invokestatic create : ()Lcom/google/common/collect/HashBiMap;
/*     */     //   8: putfield innerClasses : Lcom/google/common/collect/BiMap;
/*     */     //   11: aload_0
/*     */     //   12: new java/util/ArrayList
/*     */     //   15: dup
/*     */     //   16: invokespecial <init> : ()V
/*     */     //   19: putfield shadowMethods : Ljava/util/List;
/*     */     //   22: aload_0
/*     */     //   23: new java/util/LinkedHashMap
/*     */     //   26: dup
/*     */     //   27: invokespecial <init> : ()V
/*     */     //   30: putfield shadowFields : Ljava/util/Map;
/*     */     //   33: aload_0
/*     */     //   34: new java/util/ArrayList
/*     */     //   37: dup
/*     */     //   38: invokespecial <init> : ()V
/*     */     //   41: putfield mergedMethods : Ljava/util/List;
/*     */     //   44: aload_0
/*     */     //   45: new org/spongepowered/asm/mixin/injection/struct/InjectorGroupInfo$Map
/*     */     //   48: dup
/*     */     //   49: invokespecial <init> : ()V
/*     */     //   52: putfield injectorGroups : Lorg/spongepowered/asm/mixin/injection/struct/InjectorGroupInfo$Map;
/*     */     //   55: aload_0
/*     */     //   56: new java/util/ArrayList
/*     */     //   59: dup
/*     */     //   60: invokespecial <init> : ()V
/*     */     //   63: putfield injectors : Ljava/util/List;
/*     */     //   66: aload_0
/*     */     //   67: new java/util/ArrayList
/*     */     //   70: dup
/*     */     //   71: invokespecial <init> : ()V
/*     */     //   74: putfield accessors : Ljava/util/List;
/*     */     //   77: aload_0
/*     */     //   78: getstatic org/spongepowered/asm/mixin/MixinEnvironment$CompatibilityLevel.JAVA_6 : Lorg/spongepowered/asm/mixin/MixinEnvironment$CompatibilityLevel;
/*     */     //   81: invokevirtual classVersion : ()I
/*     */     //   84: putfield minRequiredClassVersion : I
/*     */     //   87: aload_0
/*     */     //   88: aload_1
/*     */     //   89: putfield mixin : Lorg/spongepowered/asm/mixin/transformer/MixinInfo;
/*     */     //   92: aload_0
/*     */     //   93: aload_2
/*     */     //   94: putfield classNode : Lorg/spongepowered/asm/lib/tree/ClassNode;
/*     */     //   97: aload_0
/*     */     //   98: aload_3
/*     */     //   99: putfield targetClass : Lorg/spongepowered/asm/mixin/transformer/TargetClassContext;
/*     */     //   102: aload_0
/*     */     //   103: aload_0
/*     */     //   104: invokevirtual getTarget : ()Lorg/spongepowered/asm/mixin/transformer/TargetClassContext;
/*     */     //   107: invokevirtual getClassRef : ()Ljava/lang/String;
/*     */     //   110: invokestatic forName : (Ljava/lang/String;)Lorg/spongepowered/asm/mixin/transformer/ClassInfo;
/*     */     //   113: putfield targetClassInfo : Lorg/spongepowered/asm/mixin/transformer/ClassInfo;
/*     */     //   116: aload_0
/*     */     //   117: aload_3
/*     */     //   118: invokevirtual getSourceMap : ()Lorg/spongepowered/asm/mixin/struct/SourceMap;
/*     */     //   121: aload_0
/*     */     //   122: getfield classNode : Lorg/spongepowered/asm/lib/tree/ClassNode;
/*     */     //   125: invokevirtual addFile : (Lorg/spongepowered/asm/lib/tree/ClassNode;)Lorg/spongepowered/asm/mixin/struct/SourceMap$File;
/*     */     //   128: putfield stratum : Lorg/spongepowered/asm/mixin/struct/SourceMap$File;
/*     */     //   131: aload_0
/*     */     //   132: aload_1
/*     */     //   133: invokevirtual getClassInfo : ()Lorg/spongepowered/asm/mixin/transformer/ClassInfo;
/*     */     //   136: invokevirtual hasMixinInHierarchy : ()Z
/*     */     //   139: ifne -> 152
/*     */     //   142: aload_0
/*     */     //   143: getfield targetClassInfo : Lorg/spongepowered/asm/mixin/transformer/ClassInfo;
/*     */     //   146: invokevirtual hasMixinTargetInHierarchy : ()Z
/*     */     //   149: ifeq -> 160
/*     */     //   152: iconst_1
/*     */     //   153: goto -> 161
/*     */     //   156: invokestatic b : (Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;)Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;
/*     */     //   159: athrow
/*     */     //   160: iconst_0
/*     */     //   161: putfield inheritsFromMixin : Z
/*     */     //   164: aload_0
/*     */     //   165: aload_0
/*     */     //   166: getfield classNode : Lorg/spongepowered/asm/lib/tree/ClassNode;
/*     */     //   169: getfield superName : Ljava/lang/String;
/*     */     //   172: aload_0
/*     */     //   173: invokevirtual getTarget : ()Lorg/spongepowered/asm/mixin/transformer/TargetClassContext;
/*     */     //   176: invokevirtual getClassNode : ()Lorg/spongepowered/asm/lib/tree/ClassNode;
/*     */     //   179: getfield superName : Ljava/lang/String;
/*     */     //   182: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   185: ifne -> 196
/*     */     //   188: iconst_1
/*     */     //   189: goto -> 197
/*     */     //   192: invokestatic b : (Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;)Lorg/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException;
/*     */     //   195: athrow
/*     */     //   196: iconst_0
/*     */     //   197: putfield detachedSuper : Z
/*     */     //   200: aload_0
/*     */     //   201: aload_3
/*     */     //   202: invokevirtual getSessionId : ()Ljava/lang/String;
/*     */     //   205: putfield sessionId : Ljava/lang/String;
/*     */     //   208: aload_0
/*     */     //   209: aload_2
/*     */     //   210: getfield version : I
/*     */     //   213: invokevirtual requireVersion : (I)V
/*     */     //   216: aload_3
/*     */     //   217: invokevirtual getExtensions : ()Lorg/spongepowered/asm/mixin/transformer/ext/Extensions;
/*     */     //   220: ldc org/spongepowered/asm/mixin/transformer/InnerClassGenerator
/*     */     //   222: invokevirtual getGenerator : (Ljava/lang/Class;)Lorg/spongepowered/asm/mixin/transformer/ext/IClassGenerator;
/*     */     //   225: checkcast org/spongepowered/asm/mixin/transformer/InnerClassGenerator
/*     */     //   228: astore #4
/*     */     //   230: aload_0
/*     */     //   231: getfield mixin : Lorg/spongepowered/asm/mixin/transformer/MixinInfo;
/*     */     //   234: invokevirtual getInnerClasses : ()Ljava/util/Set;
/*     */     //   237: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   242: astore #5
/*     */     //   244: aload #5
/*     */     //   246: invokeinterface hasNext : ()Z
/*     */     //   251: ifeq -> 293
/*     */     //   254: aload #5
/*     */     //   256: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   261: checkcast java/lang/String
/*     */     //   264: astore #6
/*     */     //   266: aload_0
/*     */     //   267: getfield innerClasses : Lcom/google/common/collect/BiMap;
/*     */     //   270: aload #6
/*     */     //   272: aload #4
/*     */     //   274: aload_0
/*     */     //   275: getfield mixin : Lorg/spongepowered/asm/mixin/transformer/MixinInfo;
/*     */     //   278: aload #6
/*     */     //   280: aload_0
/*     */     //   281: invokevirtual registerInnerClass : (Lorg/spongepowered/asm/mixin/transformer/MixinInfo;Ljava/lang/String;Lorg/spongepowered/asm/mixin/transformer/MixinTargetContext;)Ljava/lang/String;
/*     */     //   284: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   289: pop
/*     */     //   290: goto -> 244
/*     */     //   293: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #352	-> 0
/*     */     //   #54	-> 4
/*     */     //   #197	-> 11
/*     */     //   #119	-> 22
/*     */     //   #292	-> 33
/*     */     //   #271	-> 44
/*     */     //   #130	-> 55
/*     */     //   #214	-> 66
/*     */     //   #181	-> 77
/*     */     //   #207	-> 87
/*     */     //   #62	-> 92
/*     */     //   #172	-> 97
/*     */     //   #285	-> 102
/*     */     //   #161	-> 116
/*     */     //   #69	-> 131
/*     */     //   #77	-> 164
/*     */     //   #247	-> 200
/*     */     //   #92	-> 208
/*     */     //   #226	-> 216
/*     */     //   #143	-> 230
/*     */     //   #361	-> 266
/*     */     //   #317	-> 290
/*     */     //   #164	-> 293
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   142	156	156	org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */     //   161	192	192	org/spongepowered/asm/mixin/transformer/throwables/InvalidMixinException
/*     */   }
/*     */   
/*     */   private static final Logger logger = LogManager.getLogger("mixin");
/*     */   private final MixinInfo mixin;
/*     */   private final ClassNode classNode;
/*     */   private final TargetClassContext targetClass;
/*     */   private final String sessionId;
/*     */   private final ClassInfo targetClassInfo;
/*     */   private final BiMap<String, String> innerClasses;
/*     */   private final List<MethodNode> shadowMethods;
/*     */   private final Map<FieldNode, ClassInfo$Field> shadowFields;
/*     */   private final List<MethodNode> mergedMethods;
/*     */   private final InjectorGroupInfo.Map injectorGroups;
/*     */   private final List<InjectionInfo> injectors;
/*     */   private final List<AccessorInfo> accessors;
/*     */   private final boolean inheritsFromMixin;
/*     */   private final boolean detachedSuper;
/*     */   private final SourceMap.File stratum;
/*     */   private int minRequiredClassVersion;
/*     */   
/*     */   void addAccessorMethod(MethodNode paramMethodNode, Class<? extends Annotation> paramClass) {
/*     */     this.accessors.add(AccessorInfo.of(this, paramMethodNode, paramClass));
/*     */   }
/*     */   
/*     */   private static InvalidMixinException b(InvalidMixinException paramInvalidMixinException) {
/*     */     return paramInvalidMixinException;
/*     */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MixinTargetContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */