/*     */ package org.spongepowered.asm.mixin.injection.points;
/*     */ import com.google.common.primitives.Ints;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.spongepowered.asm.lib.tree.AbstractInsnNode;
/*     */ import org.spongepowered.asm.lib.tree.InsnList;
/*     */ import org.spongepowered.asm.mixin.injection.Constant;
/*     */ import org.spongepowered.asm.mixin.injection.InjectionPoint.AtCode;
/*     */ import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;
/*     */ import org.spongepowered.asm.mixin.refmap.IMixinContext;
/*     */ import org.spongepowered.asm.util.Bytecode;
/*     */ 
/*     */ @AtCode("CONSTANT")
/*     */ public class BeforeConstant extends InjectionPoint {
/*     */   public boolean find(String paramString, InsnList paramInsnList, Collection<AbstractInsnNode> paramCollection) {
/*  20 */     boolean bool1 = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  60 */     log("BeforeConstant is searching for constants in method with descriptor {}", new Object[] { paramString });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 113 */     ListIterator<AbstractInsnNode> listIterator = paramInsnList.iterator(); byte b; boolean bool2; for (b = 0, bool2 = false; listIterator.hasNext(); ) { AbstractInsnNode abstractInsnNode = listIterator.next(); try {  }
/*     */       catch (InvalidInjectionException invalidInjectionException) { throw b(null); }
/*     */        boolean bool = this.expand ? matchesConditionalInsn(bool2, abstractInsnNode) : matchesConstantInsn(abstractInsnNode); try { if (bool) { try {  }
/*     */           catch (InvalidInjectionException invalidInjectionException)
/*     */           { throw b(null); }
/*     */            try {
/*     */             log("    BeforeConstant found a matching constant{} at ordinal {}", new Object[] { (this.matchByType != null) ? " TYPE" : " value", Integer.valueOf(b) }); if (this.ordinal == -1 || this.ordinal == b) {
/* 120 */               log("      BeforeConstant found {}", new Object[] { Bytecode.describeNode(abstractInsnNode).trim() }); paramCollection.add(abstractInsnNode);
/*     */               bool1 = true;
/*     */             } 
/*     */           } catch (InvalidInjectionException invalidInjectionException) {
/*     */             throw b(null);
/*     */           } 
/*     */           b++; }
/*     */          }
/*     */       catch (InvalidInjectionException invalidInjectionException)
/*     */       { throw b(null); }
/*     */        }
/*     */     
/*     */     return bool1;
/*     */   }
/*     */   
/*     */   private String validateDiscriminator(IMixinContext paramIMixinContext, String paramString1, Boolean paramBoolean, String paramString2) {
/*     */     int i = count(new Object[] { paramBoolean, this.intValue, this.floatValue, this.longValue, this.doubleValue, this.stringValue, this.typeValue });
/*     */     if (i == 1) {
/*     */       paramString1 = null;
/*     */     } else {
/*     */       try {
/*     */         if (i > 1)
/*     */           throw new InvalidInjectionException(paramIMixinContext, "Conflicting constant discriminators specified " + paramString2 + " for " + paramIMixinContext); 
/*     */       } catch (InvalidInjectionException invalidInjectionException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     return paramString1;
/*     */   }
/*     */   
/*     */   private boolean matchesConditionalInsn(int paramInt, AbstractInsnNode paramAbstractInsnNode) {
/*     */     int[] arrayOfInt;
/*     */     int i;
/*     */     byte b;
/*     */     for (arrayOfInt = this.expandOpcodes, i = arrayOfInt.length, b = 0; b < i; b++) {
/*     */       int j = arrayOfInt[b];
/*     */       int k = paramAbstractInsnNode.getOpcode();
/*     */       try {
/*     */         if (k == j) {
/*     */           try {
/*     */             if (paramInt != 148)
/*     */               try {
/*     */                 if (paramInt != 149)
/*     */                   try {
/*     */                     if (paramInt != 150)
/*     */                       try {
/*     */                         if (paramInt != 151)
/*     */                           try {
/*     */                             if (paramInt != 152) {
/*     */                               log("  BeforeConstant found {} instruction", new Object[] { Bytecode.getOpcodeName(k) });
/*     */                               return true;
/*     */                             } 
/*     */                             log("  BeforeConstant is ignoring {} following {}", new Object[] { Bytecode.getOpcodeName(k), Bytecode.getOpcodeName(paramInt) });
/*     */                             return false;
/*     */                           } catch (InvalidInjectionException invalidInjectionException) {
/*     */                             throw b(null);
/*     */                           }  
/*     */                       } catch (InvalidInjectionException invalidInjectionException) {
/*     */                         throw b(null);
/*     */                       }  
/*     */                   } catch (InvalidInjectionException invalidInjectionException) {
/*     */                     throw b(null);
/*     */                   }  
/*     */               } catch (InvalidInjectionException invalidInjectionException) {
/*     */                 throw b(null);
/*     */               }  
/*     */           } catch (InvalidInjectionException invalidInjectionException) {
/*     */             throw b(null);
/*     */           } 
/*     */           log("  BeforeConstant is ignoring {} following {}", new Object[] { Bytecode.getOpcodeName(k), Bytecode.getOpcodeName(paramInt) });
/*     */           return false;
/*     */         } 
/*     */       } catch (InvalidInjectionException invalidInjectionException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     try {
/*     */       if (this.intValue != null)
/*     */         try {
/*     */           if (this.intValue.intValue() == 0 && Bytecode.isConstant(paramAbstractInsnNode)) {
/*     */             Object object = Bytecode.getConstant(paramAbstractInsnNode);
/*     */             try {
/*     */               log("  BeforeConstant found INTEGER constant: value = {}", new Object[] { object });
/*     */               if (object instanceof Integer)
/*     */                 try {
/*     */                   if (((Integer)object).intValue() == 0);
/*     */                 } catch (InvalidInjectionException invalidInjectionException) {
/*     */                   throw b(null);
/*     */                 }  
/*     */             } catch (InvalidInjectionException invalidInjectionException) {
/*     */               throw b(null);
/*     */             } 
/*     */           } 
/*     */         } catch (InvalidInjectionException invalidInjectionException) {
/*     */           throw b(null);
/*     */         }  
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw b(null);
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public BeforeConstant(IMixinContext paramIMixinContext, AnnotationNode paramAnnotationNode, String paramString) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: aload_2
/*     */     //   2: ldc 'slice'
/*     */     //   4: ldc ''
/*     */     //   6: invokestatic getValue : (Lorg/spongepowered/asm/lib/tree/AnnotationNode;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   9: checkcast java/lang/String
/*     */     //   12: getstatic org/spongepowered/asm/mixin/injection/InjectionPoint$Selector.DEFAULT : Lorg/spongepowered/asm/mixin/injection/InjectionPoint$Selector;
/*     */     //   15: aconst_null
/*     */     //   16: invokespecial <init> : (Ljava/lang/String;Lorg/spongepowered/asm/mixin/injection/InjectionPoint$Selector;Ljava/lang/String;)V
/*     */     //   19: aload_2
/*     */     //   20: ldc 'nullValue'
/*     */     //   22: aconst_null
/*     */     //   23: checkcast java/lang/Boolean
/*     */     //   26: invokestatic getValue : (Lorg/spongepowered/asm/lib/tree/AnnotationNode;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   29: checkcast java/lang/Boolean
/*     */     //   32: astore #4
/*     */     //   34: aload_0
/*     */     //   35: aload_2
/*     */     //   36: ldc 'ordinal'
/*     */     //   38: iconst_m1
/*     */     //   39: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   42: invokestatic getValue : (Lorg/spongepowered/asm/lib/tree/AnnotationNode;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   45: checkcast java/lang/Integer
/*     */     //   48: invokevirtual intValue : ()I
/*     */     //   51: putfield ordinal : I
/*     */     //   54: aload_0
/*     */     //   55: aload #4
/*     */     //   57: ifnull -> 83
/*     */     //   60: aload #4
/*     */     //   62: invokevirtual booleanValue : ()Z
/*     */     //   65: ifeq -> 83
/*     */     //   68: goto -> 75
/*     */     //   71: invokestatic b : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   74: athrow
/*     */     //   75: iconst_1
/*     */     //   76: goto -> 84
/*     */     //   79: invokestatic b : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   82: athrow
/*     */     //   83: iconst_0
/*     */     //   84: putfield nullValue : Z
/*     */     //   87: aload_0
/*     */     //   88: aload_2
/*     */     //   89: ldc 'intValue'
/*     */     //   91: aconst_null
/*     */     //   92: checkcast java/lang/Integer
/*     */     //   95: invokestatic getValue : (Lorg/spongepowered/asm/lib/tree/AnnotationNode;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   98: checkcast java/lang/Integer
/*     */     //   101: putfield intValue : Ljava/lang/Integer;
/*     */     //   104: aload_0
/*     */     //   105: aload_2
/*     */     //   106: ldc 'floatValue'
/*     */     //   108: aconst_null
/*     */     //   109: checkcast java/lang/Float
/*     */     //   112: invokestatic getValue : (Lorg/spongepowered/asm/lib/tree/AnnotationNode;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   115: checkcast java/lang/Float
/*     */     //   118: putfield floatValue : Ljava/lang/Float;
/*     */     //   121: aload_0
/*     */     //   122: aload_2
/*     */     //   123: ldc 'longValue'
/*     */     //   125: aconst_null
/*     */     //   126: checkcast java/lang/Long
/*     */     //   129: invokestatic getValue : (Lorg/spongepowered/asm/lib/tree/AnnotationNode;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   132: checkcast java/lang/Long
/*     */     //   135: putfield longValue : Ljava/lang/Long;
/*     */     //   138: aload_0
/*     */     //   139: aload_2
/*     */     //   140: ldc 'doubleValue'
/*     */     //   142: aconst_null
/*     */     //   143: checkcast java/lang/Double
/*     */     //   146: invokestatic getValue : (Lorg/spongepowered/asm/lib/tree/AnnotationNode;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   149: checkcast java/lang/Double
/*     */     //   152: putfield doubleValue : Ljava/lang/Double;
/*     */     //   155: aload_0
/*     */     //   156: aload_2
/*     */     //   157: ldc 'stringValue'
/*     */     //   159: aconst_null
/*     */     //   160: checkcast java/lang/String
/*     */     //   163: invokestatic getValue : (Lorg/spongepowered/asm/lib/tree/AnnotationNode;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   166: checkcast java/lang/String
/*     */     //   169: putfield stringValue : Ljava/lang/String;
/*     */     //   172: aload_0
/*     */     //   173: aload_2
/*     */     //   174: ldc 'classValue'
/*     */     //   176: aconst_null
/*     */     //   177: checkcast org/spongepowered/asm/lib/Type
/*     */     //   180: invokestatic getValue : (Lorg/spongepowered/asm/lib/tree/AnnotationNode;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   183: checkcast org/spongepowered/asm/lib/Type
/*     */     //   186: putfield typeValue : Lorg/spongepowered/asm/lib/Type;
/*     */     //   189: aload_0
/*     */     //   190: aload_0
/*     */     //   191: aload_1
/*     */     //   192: aload_3
/*     */     //   193: aload #4
/*     */     //   195: ldc 'on @Constant annotation'
/*     */     //   197: invokespecial validateDiscriminator : (Lorg/spongepowered/asm/mixin/refmap/IMixinContext;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   200: putfield matchByType : Ljava/lang/String;
/*     */     //   203: aload_0
/*     */     //   204: aload_0
/*     */     //   205: aload_2
/*     */     //   206: ldc 'expandZeroConditions'
/*     */     //   208: iconst_1
/*     */     //   209: ldc org/spongepowered/asm/mixin/injection/Constant$Condition
/*     */     //   211: invokestatic getValue : (Lorg/spongepowered/asm/lib/tree/AnnotationNode;Ljava/lang/String;ZLjava/lang/Class;)Ljava/util/List;
/*     */     //   214: invokespecial parseExpandOpcodes : (Ljava/util/List;)[I
/*     */     //   217: putfield expandOpcodes : [I
/*     */     //   220: aload_0
/*     */     //   221: aload_0
/*     */     //   222: getfield expandOpcodes : [I
/*     */     //   225: arraylength
/*     */     //   226: ifle -> 237
/*     */     //   229: iconst_1
/*     */     //   230: goto -> 238
/*     */     //   233: invokestatic b : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   236: athrow
/*     */     //   237: iconst_0
/*     */     //   238: putfield expand : Z
/*     */     //   241: aload_0
/*     */     //   242: aload_2
/*     */     //   243: ldc 'log'
/*     */     //   245: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
/*     */     //   248: invokestatic getValue : (Lorg/spongepowered/asm/lib/tree/AnnotationNode;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   251: checkcast java/lang/Boolean
/*     */     //   254: invokevirtual booleanValue : ()Z
/*     */     //   257: putfield log : Z
/*     */     //   260: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #44	-> 0
/*     */     //   #81	-> 19
/*     */     //   #73	-> 34
/*     */     //   #59	-> 54
/*     */     //   #57	-> 87
/*     */     //   #70	-> 104
/*     */     //   #80	-> 121
/*     */     //   #104	-> 138
/*     */     //   #97	-> 155
/*     */     //   #55	-> 172
/*     */     //   #48	-> 189
/*     */     //   #108	-> 203
/*     */     //   #66	-> 220
/*     */     //   #43	-> 241
/*     */     //   #86	-> 260
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   34	68	71	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   60	79	79	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   84	233	233	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */   }
/*     */   
/*     */   protected void log(String paramString, Object... paramVarArgs) {
/*     */     try {
/*     */       if (this.log)
/*     */         logger.info(paramString, paramVarArgs); 
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static int count(Object... paramVarArgs) {
/*     */     byte b1 = 0;
/*     */     Object[] arrayOfObject;
/*     */     int i;
/*     */     byte b2;
/*     */     for (arrayOfObject = paramVarArgs, i = arrayOfObject.length, b2 = 0; b2 < i; ) {
/*     */       Object object = arrayOfObject[b2];
/*     */       try {
/*     */         if (object != null)
/*     */           b1++; 
/*     */       } catch (InvalidInjectionException invalidInjectionException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     return b1;
/*     */   }
/*     */   
/*     */   private static final Logger logger = LogManager.getLogger("mixin");
/*     */   private final int ordinal;
/*     */   private final boolean nullValue;
/*     */   private final Integer intValue;
/*     */   private final Float floatValue;
/*     */   private final Long longValue;
/*     */   private final Double doubleValue;
/*     */   private final String stringValue;
/*     */   private final Type typeValue;
/*     */   private final int[] expandOpcodes;
/*     */   private final boolean expand;
/*     */   private final String matchByType;
/*     */   private final boolean log;
/*     */   
/*     */   private int[] parseExpandOpcodes(List<Constant.Condition> paramList) {
/*     */     HashSet hashSet = new HashSet();
/*     */     for (Constant.Condition condition1 : paramList) {
/*     */       Constant.Condition condition2 = condition1.getEquivalentCondition();
/*     */       int arrayOfInt[] = condition2.getOpcodes(), i = arrayOfInt.length;
/*     */       boolean bool = false;
/*     */     } 
/*     */     return Ints.toArray(hashSet);
/*     */   }
/*     */   
/*     */   private boolean matchesConstantInsn(AbstractInsnNode paramAbstractInsnNode) {
/*     */     try {
/*     */       if (!Bytecode.isConstant(paramAbstractInsnNode))
/*     */         return false; 
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw b(null);
/*     */     } 
/*     */     Object object = Bytecode.getConstant(paramAbstractInsnNode);
/*     */     try {
/*     */       if (object == null) {
/*     */         try {
/*     */           log("  BeforeConstant found NULL constant: nullValue = {}", new Object[] { Boolean.valueOf(this.nullValue) });
/*     */           if (!this.nullValue) {
/*     */             try {
/*     */               if ("Ljava/lang/Object;".equals(this.matchByType));
/*     */             } catch (InvalidInjectionException invalidInjectionException) {
/*     */               throw b(null);
/*     */             } 
/*     */             return false;
/*     */           } 
/*     */         } catch (InvalidInjectionException invalidInjectionException) {
/*     */           throw b(null);
/*     */         } 
/*     */       } else {
/*     */         try {
/*     */           if (object instanceof Integer) {
/*     */             try {
/*     */               log("  BeforeConstant found INTEGER constant: value = {}, intValue = {}", new Object[] { object, this.intValue });
/*     */               if (!object.equals(this.intValue)) {
/*     */                 try {
/*     */                   if ("I".equals(this.matchByType));
/*     */                 } catch (InvalidInjectionException invalidInjectionException) {
/*     */                   throw b(null);
/*     */                 } 
/*     */                 return false;
/*     */               } 
/*     */             } catch (InvalidInjectionException invalidInjectionException) {
/*     */               throw b(null);
/*     */             } 
/*     */           } else {
/*     */             try {
/*     */               if (object instanceof Float) {
/*     */                 try {
/*     */                   log("  BeforeConstant found FLOAT constant: value = {}, floatValue = {}", new Object[] { object, this.floatValue });
/*     */                   if (!object.equals(this.floatValue)) {
/*     */                     try {
/*     */                       if ("F".equals(this.matchByType));
/*     */                     } catch (InvalidInjectionException invalidInjectionException) {
/*     */                       throw b(null);
/*     */                     } 
/*     */                     return false;
/*     */                   } 
/*     */                 } catch (InvalidInjectionException invalidInjectionException) {
/*     */                   throw b(null);
/*     */                 } 
/*     */               } else {
/*     */                 try {
/*     */                   if (object instanceof Long) {
/*     */                     try {
/*     */                       log("  BeforeConstant found LONG constant: value = {}, longValue = {}", new Object[] { object, this.longValue });
/*     */                       if (!object.equals(this.longValue)) {
/*     */                         try {
/*     */                           if ("J".equals(this.matchByType));
/*     */                         } catch (InvalidInjectionException invalidInjectionException) {
/*     */                           throw b(null);
/*     */                         } 
/*     */                         return false;
/*     */                       } 
/*     */                     } catch (InvalidInjectionException invalidInjectionException) {
/*     */                       throw b(null);
/*     */                     } 
/*     */                   } else {
/*     */                     try {
/*     */                       if (object instanceof Double) {
/*     */                         try {
/*     */                           log("  BeforeConstant found DOUBLE constant: value = {}, doubleValue = {}", new Object[] { object, this.doubleValue });
/*     */                           if (!object.equals(this.doubleValue)) {
/*     */                             try {
/*     */                               if ("D".equals(this.matchByType));
/*     */                             } catch (InvalidInjectionException invalidInjectionException) {
/*     */                               throw b(null);
/*     */                             } 
/*     */                             return false;
/*     */                           } 
/*     */                         } catch (InvalidInjectionException invalidInjectionException) {
/*     */                           throw b(null);
/*     */                         } 
/*     */                       } else {
/*     */                         try {
/*     */                           if (object instanceof String) {
/*     */                             try {
/*     */                               log("  BeforeConstant found STRING constant: value = {}, stringValue = {}", new Object[] { object, this.stringValue });
/*     */                               if (!object.equals(this.stringValue)) {
/*     */                                 try {
/*     */                                   if ("Ljava/lang/String;".equals(this.matchByType));
/*     */                                 } catch (InvalidInjectionException invalidInjectionException) {
/*     */                                   throw b(null);
/*     */                                 } 
/*     */                                 return false;
/*     */                               } 
/*     */                             } catch (InvalidInjectionException invalidInjectionException) {
/*     */                               throw b(null);
/*     */                             } 
/*     */                           } else {
/*     */                             try {
/*     */                               if (object instanceof Type) {
/*     */                                 try {
/*     */                                   log("  BeforeConstant found CLASS constant: value = {}, typeValue = {}", new Object[] { object, this.typeValue });
/*     */                                   if (!object.equals(this.typeValue)) {
/*     */                                     try {
/*     */                                       if ("Ljava/lang/Class;".equals(this.matchByType));
/*     */                                     } catch (InvalidInjectionException invalidInjectionException) {
/*     */                                       throw b(null);
/*     */                                     } 
/*     */                                     return false;
/*     */                                   } 
/*     */                                 } catch (InvalidInjectionException invalidInjectionException) {
/*     */                                   throw b(null);
/*     */                                 } 
/*     */                               } else {
/*     */                                 return false;
/*     */                               } 
/*     */                             } catch (InvalidInjectionException invalidInjectionException) {
/*     */                               throw b(null);
/*     */                             } 
/*     */                           } 
/*     */                         } catch (InvalidInjectionException invalidInjectionException) {
/*     */                           throw b(null);
/*     */                         } 
/*     */                       } 
/*     */                     } catch (InvalidInjectionException invalidInjectionException) {
/*     */                       throw b(null);
/*     */                     } 
/*     */                   } 
/*     */                 } catch (InvalidInjectionException invalidInjectionException) {
/*     */                   throw b(null);
/*     */                 } 
/*     */               } 
/*     */             } catch (InvalidInjectionException invalidInjectionException) {
/*     */               throw b(null);
/*     */             } 
/*     */           } 
/*     */         } catch (InvalidInjectionException invalidInjectionException) {
/*     */           throw b(null);
/*     */         } 
/*     */       } 
/*     */     } catch (InvalidInjectionException invalidInjectionException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   public BeforeConstant(InjectionPointData paramInjectionPointData) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: aload_1
/*     */     //   2: invokespecial <init> : (Lorg/spongepowered/asm/mixin/injection/struct/InjectionPointData;)V
/*     */     //   5: aload_1
/*     */     //   6: ldc 'nullValue'
/*     */     //   8: aconst_null
/*     */     //   9: invokevirtual get : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   12: astore_2
/*     */     //   13: aload_2
/*     */     //   14: ifnull -> 31
/*     */     //   17: aload_2
/*     */     //   18: invokestatic parseBoolean : (Ljava/lang/String;)Z
/*     */     //   21: invokestatic valueOf : (Z)Ljava/lang/Boolean;
/*     */     //   24: goto -> 32
/*     */     //   27: invokestatic b : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   30: athrow
/*     */     //   31: aconst_null
/*     */     //   32: astore_3
/*     */     //   33: aload_0
/*     */     //   34: aload_1
/*     */     //   35: invokevirtual getOrdinal : ()I
/*     */     //   38: putfield ordinal : I
/*     */     //   41: aload_0
/*     */     //   42: aload_3
/*     */     //   43: ifnull -> 68
/*     */     //   46: aload_3
/*     */     //   47: invokevirtual booleanValue : ()Z
/*     */     //   50: ifeq -> 68
/*     */     //   53: goto -> 60
/*     */     //   56: invokestatic b : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   59: athrow
/*     */     //   60: iconst_1
/*     */     //   61: goto -> 69
/*     */     //   64: invokestatic b : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   67: athrow
/*     */     //   68: iconst_0
/*     */     //   69: putfield nullValue : Z
/*     */     //   72: aload_0
/*     */     //   73: aload_1
/*     */     //   74: ldc 'intValue'
/*     */     //   76: ldc ''
/*     */     //   78: invokevirtual get : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   81: invokestatic tryParse : (Ljava/lang/String;)Ljava/lang/Integer;
/*     */     //   84: putfield intValue : Ljava/lang/Integer;
/*     */     //   87: aload_0
/*     */     //   88: aload_1
/*     */     //   89: ldc 'floatValue'
/*     */     //   91: ldc ''
/*     */     //   93: invokevirtual get : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   96: invokestatic tryParse : (Ljava/lang/String;)Ljava/lang/Float;
/*     */     //   99: putfield floatValue : Ljava/lang/Float;
/*     */     //   102: aload_0
/*     */     //   103: aload_1
/*     */     //   104: ldc 'longValue'
/*     */     //   106: ldc ''
/*     */     //   108: invokevirtual get : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   111: invokestatic tryParse : (Ljava/lang/String;)Ljava/lang/Long;
/*     */     //   114: putfield longValue : Ljava/lang/Long;
/*     */     //   117: aload_0
/*     */     //   118: aload_1
/*     */     //   119: ldc 'doubleValue'
/*     */     //   121: ldc ''
/*     */     //   123: invokevirtual get : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   126: invokestatic tryParse : (Ljava/lang/String;)Ljava/lang/Double;
/*     */     //   129: putfield doubleValue : Ljava/lang/Double;
/*     */     //   132: aload_0
/*     */     //   133: aload_1
/*     */     //   134: ldc 'stringValue'
/*     */     //   136: aconst_null
/*     */     //   137: invokevirtual get : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   140: putfield stringValue : Ljava/lang/String;
/*     */     //   143: aload_1
/*     */     //   144: ldc 'classValue'
/*     */     //   146: aconst_null
/*     */     //   147: invokevirtual get : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   150: astore #4
/*     */     //   152: aload_0
/*     */     //   153: aload #4
/*     */     //   155: ifnull -> 177
/*     */     //   158: aload #4
/*     */     //   160: bipush #46
/*     */     //   162: bipush #47
/*     */     //   164: invokevirtual replace : (CC)Ljava/lang/String;
/*     */     //   167: invokestatic getObjectType : (Ljava/lang/String;)Lorg/spongepowered/asm/lib/Type;
/*     */     //   170: goto -> 178
/*     */     //   173: invokestatic b : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   176: athrow
/*     */     //   177: aconst_null
/*     */     //   178: putfield typeValue : Lorg/spongepowered/asm/lib/Type;
/*     */     //   181: aload_0
/*     */     //   182: aload_0
/*     */     //   183: aload_1
/*     */     //   184: invokevirtual getContext : ()Lorg/spongepowered/asm/mixin/refmap/IMixinContext;
/*     */     //   187: ldc 'V'
/*     */     //   189: aload_3
/*     */     //   190: ldc 'in @At("CONSTANT") args'
/*     */     //   192: invokespecial validateDiscriminator : (Lorg/spongepowered/asm/mixin/refmap/IMixinContext;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   195: putfield matchByType : Ljava/lang/String;
/*     */     //   198: ldc 'V'
/*     */     //   200: aload_0
/*     */     //   201: getfield matchByType : Ljava/lang/String;
/*     */     //   204: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   207: ifeq -> 228
/*     */     //   210: new org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   213: dup
/*     */     //   214: aload_1
/*     */     //   215: invokevirtual getContext : ()Lorg/spongepowered/asm/mixin/refmap/IMixinContext;
/*     */     //   218: ldc 'No constant discriminator could be parsed in @At("CONSTANT") args'
/*     */     //   220: invokespecial <init> : (Lorg/spongepowered/asm/mixin/refmap/IMixinContext;Ljava/lang/String;)V
/*     */     //   223: athrow
/*     */     //   224: invokestatic b : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   227: athrow
/*     */     //   228: new java/util/ArrayList
/*     */     //   231: dup
/*     */     //   232: invokespecial <init> : ()V
/*     */     //   235: astore #5
/*     */     //   237: aload_1
/*     */     //   238: ldc 'expandZeroConditions'
/*     */     //   240: ldc ''
/*     */     //   242: invokevirtual get : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   245: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   248: astore #6
/*     */     //   250: invokestatic values : ()[Lorg/spongepowered/asm/mixin/injection/Constant$Condition;
/*     */     //   253: astore #7
/*     */     //   255: aload #7
/*     */     //   257: arraylength
/*     */     //   258: istore #8
/*     */     //   260: iconst_0
/*     */     //   261: istore #9
/*     */     //   263: iload #9
/*     */     //   265: iload #8
/*     */     //   267: if_icmpge -> 316
/*     */     //   270: aload #7
/*     */     //   272: iload #9
/*     */     //   274: aaload
/*     */     //   275: astore #10
/*     */     //   277: aload #6
/*     */     //   279: aload #10
/*     */     //   281: invokevirtual name : ()Ljava/lang/String;
/*     */     //   284: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   287: invokevirtual contains : (Ljava/lang/CharSequence;)Z
/*     */     //   290: ifeq -> 310
/*     */     //   293: aload #5
/*     */     //   295: aload #10
/*     */     //   297: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   302: pop
/*     */     //   303: goto -> 310
/*     */     //   306: invokestatic b : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   309: athrow
/*     */     //   310: iinc #9, 1
/*     */     //   313: goto -> 263
/*     */     //   316: aload_0
/*     */     //   317: aload_0
/*     */     //   318: aload #5
/*     */     //   320: invokespecial parseExpandOpcodes : (Ljava/util/List;)[I
/*     */     //   323: putfield expandOpcodes : [I
/*     */     //   326: aload_0
/*     */     //   327: aload_0
/*     */     //   328: getfield expandOpcodes : [I
/*     */     //   331: arraylength
/*     */     //   332: ifle -> 343
/*     */     //   335: iconst_1
/*     */     //   336: goto -> 344
/*     */     //   339: invokestatic b : (Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;)Lorg/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException;
/*     */     //   342: athrow
/*     */     //   343: iconst_0
/*     */     //   344: putfield expand : Z
/*     */     //   347: aload_0
/*     */     //   348: aload_1
/*     */     //   349: ldc 'log'
/*     */     //   351: iconst_0
/*     */     //   352: invokevirtual get : (Ljava/lang/String;Z)Z
/*     */     //   355: putfield log : Z
/*     */     //   358: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #116	-> 0
/*     */     //   #99	-> 5
/*     */     //   #47	-> 13
/*     */     //   #89	-> 33
/*     */     //   #68	-> 41
/*     */     //   #72	-> 72
/*     */     //   #45	-> 87
/*     */     //   #26	-> 102
/*     */     //   #92	-> 117
/*     */     //   #85	-> 132
/*     */     //   #29	-> 143
/*     */     //   #76	-> 152
/*     */     //   #93	-> 181
/*     */     //   #119	-> 198
/*     */     //   #54	-> 210
/*     */     //   #31	-> 228
/*     */     //   #53	-> 237
/*     */     //   #64	-> 250
/*     */     //   #63	-> 277
/*     */     //   #30	-> 293
/*     */     //   #40	-> 310
/*     */     //   #8	-> 316
/*     */     //   #74	-> 326
/*     */     //   #24	-> 347
/*     */     //   #83	-> 358
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   13	27	27	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   33	53	56	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   46	64	64	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   152	173	173	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   178	224	224	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   277	303	306	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */     //   316	339	339	org/spongepowered/asm/mixin/injection/throwables/InvalidInjectionException
/*     */   }
/*     */   
/*     */   private static InvalidInjectionException b(InvalidInjectionException paramInvalidInjectionException) {
/*     */     return paramInvalidInjectionException;
/*     */   }
/*     */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\points\BeforeConstant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */