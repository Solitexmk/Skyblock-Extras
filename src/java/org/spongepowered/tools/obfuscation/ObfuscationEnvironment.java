/*    */ package org.spongepowered.tools.obfuscation;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import javax.annotation.processing.Filer;
/*    */ import javax.annotation.processing.Messager;
/*    */ import javax.lang.model.element.TypeElement;
/*    */ import javax.lang.model.type.DeclaredType;
/*    */ import javax.lang.model.type.TypeKind;
/*    */ import javax.lang.model.type.TypeMirror;
/*    */ import org.spongepowered.asm.mixin.injection.struct.MemberInfo;
/*    */ import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
/*    */ import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
/*    */ import org.spongepowered.asm.util.ObfuscationUtil;
/*    */ import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
/*    */ import org.spongepowered.tools.obfuscation.interfaces.IObfuscationEnvironment;
/*    */ import org.spongepowered.tools.obfuscation.mapping.IMappingConsumer;
/*    */ import org.spongepowered.tools.obfuscation.mapping.IMappingProvider;
/*    */ import org.spongepowered.tools.obfuscation.mapping.IMappingWriter;
/*    */ import org.spongepowered.tools.obfuscation.mirror.TypeHandle;
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
/*    */ public abstract class ObfuscationEnvironment
/*    */   implements IObfuscationEnvironment
/*    */ {
/*    */   protected final ObfuscationType type;
/*    */   protected final IMappingProvider mappingProvider;
/*    */   protected final IMappingWriter mappingWriter;
/*    */   protected final ObfuscationEnvironment$RemapperProxy remapper;
/*    */   protected final IMixinAnnotationProcessor ap;
/*    */   protected final String outFileName;
/*    */   protected final List<String> inFileNames;
/*    */   private boolean initDone;
/*    */   
/*    */   public MemberInfo remapDescriptor(MemberInfo paramMemberInfo) {
/*    */     // Byte code:
/*    */     //   0: iconst_0
/*    */     //   1: istore_2
/*    */     //   2: aload_1
/*    */     //   3: getfield owner : Ljava/lang/String;
/*    */     //   6: astore_3
/*    */     //   7: aload_3
/*    */     //   8: ifnull -> 31
/*    */     //   11: aload_0
/*    */     //   12: getfield remapper : Lorg/spongepowered/tools/obfuscation/ObfuscationEnvironment$RemapperProxy;
/*    */     //   15: aload_3
/*    */     //   16: invokevirtual map : (Ljava/lang/String;)Ljava/lang/String;
/*    */     //   19: astore #4
/*    */     //   21: aload #4
/*    */     //   23: ifnull -> 31
/*    */     //   26: aload #4
/*    */     //   28: astore_3
/*    */     //   29: iconst_1
/*    */     //   30: istore_2
/*    */     //   31: aload_1
/*    */     //   32: getfield desc : Ljava/lang/String;
/*    */     //   35: astore #4
/*    */     //   37: aload #4
/*    */     //   39: ifnull -> 73
/*    */     //   42: aload_1
/*    */     //   43: getfield desc : Ljava/lang/String;
/*    */     //   46: aload_0
/*    */     //   47: getfield remapper : Lorg/spongepowered/tools/obfuscation/ObfuscationEnvironment$RemapperProxy;
/*    */     //   50: invokestatic mapDescriptor : (Ljava/lang/String;Lorg/spongepowered/asm/util/ObfuscationUtil$IClassRemapper;)Ljava/lang/String;
/*    */     //   53: astore #5
/*    */     //   55: aload #5
/*    */     //   57: aload_1
/*    */     //   58: getfield desc : Ljava/lang/String;
/*    */     //   61: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   64: ifne -> 73
/*    */     //   67: aload #5
/*    */     //   69: astore #4
/*    */     //   71: iconst_1
/*    */     //   72: istore_2
/*    */     //   73: iload_2
/*    */     //   74: ifeq -> 102
/*    */     //   77: new org/spongepowered/asm/mixin/injection/struct/MemberInfo
/*    */     //   80: dup
/*    */     //   81: aload_1
/*    */     //   82: getfield name : Ljava/lang/String;
/*    */     //   85: aload_3
/*    */     //   86: aload #4
/*    */     //   88: aload_1
/*    */     //   89: getfield matchAll : Z
/*    */     //   92: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
/*    */     //   95: goto -> 103
/*    */     //   98: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*    */     //   101: athrow
/*    */     //   102: aconst_null
/*    */     //   103: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #22	-> 0
/*    */     //   #26	-> 2
/*    */     //   #11	-> 7
/*    */     //   #12	-> 11
/*    */     //   #68	-> 21
/*    */     //   #69	-> 26
/*    */     //   #29	-> 29
/*    */     //   #61	-> 31
/*    */     //   #57	-> 37
/*    */     //   #88	-> 42
/*    */     //   #70	-> 55
/*    */     //   #91	-> 67
/*    */     //   #53	-> 71
/*    */     //   #16	-> 73
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   73	98	98	java/lang/RuntimeException
/*    */   }
/*    */   
/*    */   protected ObfuscationEnvironment(ObfuscationType paramObfuscationType) {
/* 87 */     this.remapper = new ObfuscationEnvironment$RemapperProxy(this); this.type = paramObfuscationType; this.ap = paramObfuscationType.getAnnotationProcessor(); this.inFileNames = paramObfuscationType.getInputFileNames(); this.outFileName = paramObfuscationType.getOutputFileName(); this.mappingProvider = getMappingProvider((Messager)this.ap, this.ap.getProcessingEnvironment().getFiler()); this.mappingWriter = getMappingWriter((Messager)this.ap, this.ap.getProcessingEnvironment().getFiler()); } public MappingMethod getObfMethod(MemberInfo paramMemberInfo) { MappingMethod mappingMethod = getObfMethod(paramMemberInfo.asMethodMapping()); try { if (mappingMethod == null) { try { if (!paramMemberInfo.isFullyQualified())
/*    */             return mappingMethod;  } catch (RuntimeException runtimeException) { throw b(null); }  }
/*    */       else { return mappingMethod; }
/*    */        }
/*    */     catch (RuntimeException runtimeException) { throw b(null); }
/* 92 */      TypeHandle typeHandle = this.ap.getTypeProvider().getTypeHandle(paramMemberInfo.owner);
/*    */     try {
/*    */       if (typeHandle != null)
/*    */         try {
/*    */           if (!typeHandle.isImaginary()) {
/*    */             TypeMirror typeMirror = typeHandle.getElement().getSuperclass();
/*    */             try {
/* 99 */               if (typeMirror.getKind() != TypeKind.DECLARED)
/*    */                 return null; 
/*    */             } catch (RuntimeException runtimeException) {
/*    */               throw b(null);
/*    */             } 
/*    */             String str = ((TypeElement)((DeclaredType)typeMirror).asElement()).getQualifiedName().toString();
/*    */             return getObfMethod(new MemberInfo(paramMemberInfo.name, str.replace('.', '/'), paramMemberInfo.desc, paramMemberInfo.matchAll));
/*    */           } 
/*    */           return null;
/*    */         } catch (RuntimeException runtimeException) {
/*    */           throw b(null);
/*    */         }  
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return null; }
/*    */ 
/*    */   
/*    */   public ObfuscationType getType() {
/*    */     return this.type;
/*    */   }
/*    */   
/*    */   public String toString() {
/*    */     return this.type.toString();
/*    */   }
/*    */   
/*    */   public MappingField getObfField(MemberInfo paramMemberInfo) {
/*    */     return getObfField(paramMemberInfo.asFieldMapping(), true);
/*    */   }
/*    */   
/*    */   public MappingField getObfField(MappingField paramMappingField) {
/*    */     return getObfField(paramMappingField, true);
/*    */   }
/*    */   
/*    */   public MappingField getObfField(MappingField paramMappingField, boolean paramBoolean) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: invokespecial initMappings : ()Z
/*    */     //   4: ifne -> 13
/*    */     //   7: aconst_null
/*    */     //   8: areturn
/*    */     //   9: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*    */     //   12: athrow
/*    */     //   13: aload_0
/*    */     //   14: getfield mappingProvider : Lorg/spongepowered/tools/obfuscation/mapping/IMappingProvider;
/*    */     //   17: aload_1
/*    */     //   18: invokeinterface getFieldMapping : (Lorg/spongepowered/asm/obfuscation/mapping/common/MappingField;)Lorg/spongepowered/asm/obfuscation/mapping/common/MappingField;
/*    */     //   23: astore_3
/*    */     //   24: aload_3
/*    */     //   25: ifnonnull -> 47
/*    */     //   28: iload_2
/*    */     //   29: ifeq -> 45
/*    */     //   32: goto -> 39
/*    */     //   35: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*    */     //   38: athrow
/*    */     //   39: aconst_null
/*    */     //   40: areturn
/*    */     //   41: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*    */     //   44: athrow
/*    */     //   45: aload_1
/*    */     //   46: astore_3
/*    */     //   47: aload_0
/*    */     //   48: aload_3
/*    */     //   49: invokevirtual getOwner : ()Ljava/lang/String;
/*    */     //   52: invokevirtual getObfClass : (Ljava/lang/String;)Ljava/lang/String;
/*    */     //   55: astore #4
/*    */     //   57: aload #4
/*    */     //   59: ifnull -> 100
/*    */     //   62: aload #4
/*    */     //   64: aload_1
/*    */     //   65: invokevirtual getOwner : ()Ljava/lang/String;
/*    */     //   68: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   71: ifne -> 100
/*    */     //   74: goto -> 81
/*    */     //   77: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*    */     //   80: athrow
/*    */     //   81: aload #4
/*    */     //   83: aload_3
/*    */     //   84: invokevirtual getOwner : ()Ljava/lang/String;
/*    */     //   87: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   90: ifeq -> 122
/*    */     //   93: goto -> 100
/*    */     //   96: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*    */     //   99: athrow
/*    */     //   100: aload_3
/*    */     //   101: aload_1
/*    */     //   102: if_acmpeq -> 120
/*    */     //   105: goto -> 112
/*    */     //   108: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*    */     //   111: athrow
/*    */     //   112: aload_3
/*    */     //   113: goto -> 121
/*    */     //   116: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*    */     //   119: athrow
/*    */     //   120: aconst_null
/*    */     //   121: areturn
/*    */     //   122: aload_3
/*    */     //   123: aload #4
/*    */     //   125: invokevirtual move : (Ljava/lang/String;)Lorg/spongepowered/asm/obfuscation/mapping/common/MappingField;
/*    */     //   128: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #54	-> 0
/*    */     //   #1	-> 7
/*    */     //   #42	-> 13
/*    */     //   #43	-> 24
/*    */     //   #25	-> 28
/*    */     //   #76	-> 39
/*    */     //   #62	-> 45
/*    */     //   #100	-> 47
/*    */     //   #94	-> 57
/*    */     //   #51	-> 100
/*    */     //   #17	-> 122
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   0	9	9	java/lang/RuntimeException
/*    */     //   24	32	35	java/lang/RuntimeException
/*    */     //   28	41	41	java/lang/RuntimeException
/*    */     //   57	74	77	java/lang/RuntimeException
/*    */     //   62	93	96	java/lang/RuntimeException
/*    */     //   81	105	108	java/lang/RuntimeException
/*    */     //   100	116	116	java/lang/RuntimeException
/*    */   }
/*    */   
/*    */   public void writeMappings(Collection<IMappingConsumer> paramCollection) {
/*    */     IMappingConsumer.MappingSet mappingSet1 = new IMappingConsumer.MappingSet();
/*    */     IMappingConsumer.MappingSet mappingSet2 = new IMappingConsumer.MappingSet();
/*    */     for (IMappingConsumer iMappingConsumer : paramCollection) {
/*    */       mappingSet1.addAll((Collection)iMappingConsumer.getFieldMappings(this.type));
/*    */       mappingSet2.addAll((Collection)iMappingConsumer.getMethodMappings(this.type));
/*    */     } 
/*    */     this.mappingWriter.write(this.outFileName, this.type, mappingSet1, mappingSet2);
/*    */   }
/*    */   
/*    */   private boolean initMappings() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield initDone : Z
/*    */     //   4: ifne -> 260
/*    */     //   7: aload_0
/*    */     //   8: iconst_1
/*    */     //   9: putfield initDone : Z
/*    */     //   12: aload_0
/*    */     //   13: getfield inFileNames : Ljava/util/List;
/*    */     //   16: ifnonnull -> 77
/*    */     //   19: goto -> 26
/*    */     //   22: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*    */     //   25: athrow
/*    */     //   26: aload_0
/*    */     //   27: getfield ap : Lorg/spongepowered/tools/obfuscation/interfaces/IMixinAnnotationProcessor;
/*    */     //   30: getstatic javax/tools/Diagnostic$Kind.ERROR : Ljavax/tools/Diagnostic$Kind;
/*    */     //   33: new java/lang/StringBuilder
/*    */     //   36: dup
/*    */     //   37: invokespecial <init> : ()V
/*    */     //   40: ldc 'The '
/*    */     //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   45: aload_0
/*    */     //   46: getfield type : Lorg/spongepowered/tools/obfuscation/ObfuscationType;
/*    */     //   49: invokevirtual getConfig : ()Lorg/spongepowered/tools/obfuscation/service/ObfuscationTypeDescriptor;
/*    */     //   52: invokevirtual getInputFileOption : ()Ljava/lang/String;
/*    */     //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   58: ldc ' argument was not supplied, obfuscation processing will not occur'
/*    */     //   60: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   63: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   66: invokeinterface printMessage : (Ljavax/tools/Diagnostic$Kind;Ljava/lang/CharSequence;)V
/*    */     //   71: iconst_0
/*    */     //   72: ireturn
/*    */     //   73: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*    */     //   76: athrow
/*    */     //   77: iconst_0
/*    */     //   78: istore_1
/*    */     //   79: aload_0
/*    */     //   80: getfield inFileNames : Ljava/util/List;
/*    */     //   83: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   88: astore_2
/*    */     //   89: aload_2
/*    */     //   90: invokeinterface hasNext : ()Z
/*    */     //   95: ifeq -> 200
/*    */     //   98: aload_2
/*    */     //   99: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   104: checkcast java/lang/String
/*    */     //   107: astore_3
/*    */     //   108: new java/io/File
/*    */     //   111: dup
/*    */     //   112: aload_3
/*    */     //   113: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   116: astore #4
/*    */     //   118: aload #4
/*    */     //   120: invokevirtual isFile : ()Z
/*    */     //   123: ifeq -> 187
/*    */     //   126: aload_0
/*    */     //   127: getfield ap : Lorg/spongepowered/tools/obfuscation/interfaces/IMixinAnnotationProcessor;
/*    */     //   130: getstatic javax/tools/Diagnostic$Kind.NOTE : Ljavax/tools/Diagnostic$Kind;
/*    */     //   133: new java/lang/StringBuilder
/*    */     //   136: dup
/*    */     //   137: invokespecial <init> : ()V
/*    */     //   140: ldc 'Loading '
/*    */     //   142: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   145: aload_0
/*    */     //   146: getfield type : Lorg/spongepowered/tools/obfuscation/ObfuscationType;
/*    */     //   149: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */     //   152: ldc ' mappings from '
/*    */     //   154: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   157: aload #4
/*    */     //   159: invokevirtual getAbsolutePath : ()Ljava/lang/String;
/*    */     //   162: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   165: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   168: invokeinterface printMessage : (Ljavax/tools/Diagnostic$Kind;Ljava/lang/CharSequence;)V
/*    */     //   173: aload_0
/*    */     //   174: getfield mappingProvider : Lorg/spongepowered/tools/obfuscation/mapping/IMappingProvider;
/*    */     //   177: aload #4
/*    */     //   179: invokeinterface read : (Ljava/io/File;)V
/*    */     //   184: iinc #1, 1
/*    */     //   187: goto -> 197
/*    */     //   190: astore #5
/*    */     //   192: aload #5
/*    */     //   194: invokevirtual printStackTrace : ()V
/*    */     //   197: goto -> 89
/*    */     //   200: iload_1
/*    */     //   201: iconst_1
/*    */     //   202: if_icmpge -> 260
/*    */     //   205: aload_0
/*    */     //   206: getfield ap : Lorg/spongepowered/tools/obfuscation/interfaces/IMixinAnnotationProcessor;
/*    */     //   209: getstatic javax/tools/Diagnostic$Kind.ERROR : Ljavax/tools/Diagnostic$Kind;
/*    */     //   212: new java/lang/StringBuilder
/*    */     //   215: dup
/*    */     //   216: invokespecial <init> : ()V
/*    */     //   219: ldc 'No valid input files for '
/*    */     //   221: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   224: aload_0
/*    */     //   225: getfield type : Lorg/spongepowered/tools/obfuscation/ObfuscationType;
/*    */     //   228: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */     //   231: ldc ' could be read, processing may not be sucessful.'
/*    */     //   233: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   236: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   239: invokeinterface printMessage : (Ljavax/tools/Diagnostic$Kind;Ljava/lang/CharSequence;)V
/*    */     //   244: aload_0
/*    */     //   245: getfield mappingProvider : Lorg/spongepowered/tools/obfuscation/mapping/IMappingProvider;
/*    */     //   248: invokeinterface clear : ()V
/*    */     //   253: goto -> 260
/*    */     //   256: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*    */     //   259: athrow
/*    */     //   260: aload_0
/*    */     //   261: getfield mappingProvider : Lorg/spongepowered/tools/obfuscation/mapping/IMappingProvider;
/*    */     //   264: invokeinterface isEmpty : ()Z
/*    */     //   269: ifne -> 280
/*    */     //   272: iconst_1
/*    */     //   273: goto -> 281
/*    */     //   276: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*    */     //   279: athrow
/*    */     //   280: iconst_0
/*    */     //   281: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #81	-> 0
/*    */     //   #58	-> 7
/*    */     //   #84	-> 12
/*    */     //   #67	-> 26
/*    */     //   #23	-> 71
/*    */     //   #75	-> 77
/*    */     //   #96	-> 79
/*    */     //   #101	-> 108
/*    */     //   #56	-> 118
/*    */     //   #65	-> 126
/*    */     //   #64	-> 173
/*    */     //   #13	-> 184
/*    */     //   #33	-> 187
/*    */     //   #9	-> 190
/*    */     //   #35	-> 192
/*    */     //   #48	-> 197
/*    */     //   #77	-> 200
/*    */     //   #83	-> 205
/*    */     //   #59	-> 244
/*    */     //   #24	-> 260
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   0	19	22	java/lang/Exception
/*    */     //   7	73	73	java/lang/Exception
/*    */     //   118	187	190	java/lang/Exception
/*    */     //   200	253	256	java/lang/Exception
/*    */     //   260	276	276	java/lang/Exception
/*    */   }
/*    */   
/*    */   public MappingMethod getObfMethod(MappingMethod paramMappingMethod) {
/*    */     return getObfMethod(paramMappingMethod, true);
/*    */   }
/*    */   
/*    */   public MappingMethod getObfMethod(MappingMethod paramMappingMethod, boolean paramBoolean) {
/*    */     if (initMappings()) {
/*    */       boolean bool = true;
/*    */       Object object = null;
/*    */     } 
/*    */     return null;
/*    */   }
/*    */   
/*    */   public String getObfClass(String paramString) {
/*    */     try {
/*    */       if (!initMappings())
/*    */         return null; 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return this.mappingProvider.getClassMapping(paramString);
/*    */   }
/*    */   
/*    */   public String remapDescriptor(String paramString) {
/*    */     return ObfuscationUtil.mapDescriptor(paramString, this.remapper);
/*    */   }
/*    */   
/*    */   protected abstract IMappingProvider getMappingProvider(Messager paramMessager, Filer paramFiler);
/*    */   
/*    */   protected abstract IMappingWriter getMappingWriter(Messager paramMessager, Filer paramFiler);
/*    */   
/*    */   private static Exception b(Exception paramException) {
/*    */     return paramException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\ObfuscationEnvironment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */