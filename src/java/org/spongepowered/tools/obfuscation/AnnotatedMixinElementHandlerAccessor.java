/*    */ package org.spongepowered.tools.obfuscation;
/*    */ 
/*    */ import javax.annotation.processing.Messager;
/*    */ import javax.tools.Diagnostic;
/*    */ import org.spongepowered.asm.mixin.gen.AccessorInfo;
/*    */ import org.spongepowered.asm.mixin.injection.struct.Target;
/*    */ import org.spongepowered.asm.mixin.refmap.IMixinContext;
/*    */ import org.spongepowered.asm.mixin.refmap.IReferenceMapper;
/*    */ import org.spongepowered.asm.mixin.refmap.ReferenceMapper;
/*    */ import org.spongepowered.asm.obfuscation.mapping.IMapping;
/*    */ import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
/*    */ import org.spongepowered.tools.obfuscation.mirror.FieldHandle;
/*    */ import org.spongepowered.tools.obfuscation.mirror.TypeHandle;
/*    */ 
/*    */ public class AnnotatedMixinElementHandlerAccessor extends AnnotatedMixinElementHandler implements IMixinContext {
/* 16 */   public String getClassName() { return this.mixin.getClassRef().replace('/', '.'); } private String inflectAccessorTarget(AnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor) {
/* 17 */     return AccessorInfo.inflectTarget(paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor.getSimpleName(), paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor.getAccessorType(), "", this, false);
/*    */   }
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
/*    */   public boolean getOption(MixinEnvironment.Option paramOption) {
/* 32 */     throw new UnsupportedOperationException("Options not available at compile time");
/*    */   }
/*    */   private void registerInvokerForTarget(AnnotatedMixinElementHandlerAccessor$AnnotatedElementInvoker paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementInvoker, TypeHandle paramTypeHandle) {
/*    */     // Byte code:
/*    */     //   0: aload_2
/*    */     //   1: aload_1
/*    */     //   2: invokevirtual getTargetName : ()Ljava/lang/String;
/*    */     //   5: aload_1
/*    */     //   6: invokevirtual getTargetTypeName : ()Ljava/lang/String;
/*    */     //   9: iconst_0
/*    */     //   10: invokevirtual findMethod : (Ljava/lang/String;Ljava/lang/String;Z)Lorg/spongepowered/tools/obfuscation/mirror/MethodHandle;
/*    */     //   13: astore_3
/*    */     //   14: aload_3
/*    */     //   15: ifnonnull -> 93
/*    */     //   18: aload_2
/*    */     //   19: invokevirtual isImaginary : ()Z
/*    */     //   22: ifne -> 76
/*    */     //   25: goto -> 32
/*    */     //   28: invokestatic b : (Lorg/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException;)Lorg/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException;
/*    */     //   31: athrow
/*    */     //   32: aload_1
/*    */     //   33: aload_0
/*    */     //   34: getfield ap : Lorg/spongepowered/tools/obfuscation/interfaces/IMixinAnnotationProcessor;
/*    */     //   37: getstatic javax/tools/Diagnostic$Kind.ERROR : Ljavax/tools/Diagnostic$Kind;
/*    */     //   40: new java/lang/StringBuilder
/*    */     //   43: dup
/*    */     //   44: invokespecial <init> : ()V
/*    */     //   47: ldc 'Could not locate @Invoker target '
/*    */     //   49: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   52: aload_1
/*    */     //   53: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */     //   56: ldc ' in target '
/*    */     //   58: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   61: aload_2
/*    */     //   62: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */     //   65: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   68: invokevirtual printMessage : (Ljavax/annotation/processing/Messager;Ljavax/tools/Diagnostic$Kind;Ljava/lang/CharSequence;)V
/*    */     //   71: return
/*    */     //   72: invokestatic b : (Lorg/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException;)Lorg/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException;
/*    */     //   75: athrow
/*    */     //   76: new org/spongepowered/tools/obfuscation/mirror/MethodHandle
/*    */     //   79: dup
/*    */     //   80: aload_2
/*    */     //   81: aload_1
/*    */     //   82: invokevirtual getTargetName : ()Ljava/lang/String;
/*    */     //   85: aload_1
/*    */     //   86: invokevirtual getDesc : ()Ljava/lang/String;
/*    */     //   89: invokespecial <init> : (Lorg/spongepowered/tools/obfuscation/mirror/TypeHandle;Ljava/lang/String;Ljava/lang/String;)V
/*    */     //   92: astore_3
/*    */     //   93: aload_1
/*    */     //   94: invokevirtual shouldRemap : ()Z
/*    */     //   97: ifne -> 105
/*    */     //   100: return
/*    */     //   101: invokestatic b : (Lorg/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException;)Lorg/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException;
/*    */     //   104: athrow
/*    */     //   105: aload_0
/*    */     //   106: getfield obf : Lorg/spongepowered/tools/obfuscation/interfaces/IObfuscationManager;
/*    */     //   109: invokeinterface getDataProvider : ()Lorg/spongepowered/tools/obfuscation/interfaces/IObfuscationDataProvider;
/*    */     //   114: aload_3
/*    */     //   115: iconst_0
/*    */     //   116: invokevirtual asMapping : (Z)Lorg/spongepowered/asm/obfuscation/mapping/common/MappingMethod;
/*    */     //   119: aload_2
/*    */     //   120: invokevirtual getName : ()Ljava/lang/String;
/*    */     //   123: invokevirtual move : (Ljava/lang/String;)Lorg/spongepowered/asm/obfuscation/mapping/common/MappingMethod;
/*    */     //   126: invokeinterface getObfMethod : (Lorg/spongepowered/asm/obfuscation/mapping/common/MappingMethod;)Lorg/spongepowered/tools/obfuscation/ObfuscationData;
/*    */     //   131: astore #4
/*    */     //   133: aload #4
/*    */     //   135: invokevirtual isEmpty : ()Z
/*    */     //   138: ifeq -> 229
/*    */     //   141: aload_0
/*    */     //   142: getfield mixin : Lorg/spongepowered/tools/obfuscation/AnnotatedMixin;
/*    */     //   145: invokevirtual isMultiTarget : ()Z
/*    */     //   148: ifeq -> 184
/*    */     //   151: goto -> 158
/*    */     //   154: invokestatic b : (Lorg/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException;)Lorg/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException;
/*    */     //   157: athrow
/*    */     //   158: new java/lang/StringBuilder
/*    */     //   161: dup
/*    */     //   162: invokespecial <init> : ()V
/*    */     //   165: ldc ' in target '
/*    */     //   167: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   170: aload_2
/*    */     //   171: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */     //   174: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   177: goto -> 186
/*    */     //   180: invokestatic b : (Lorg/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException;)Lorg/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException;
/*    */     //   183: athrow
/*    */     //   184: ldc ''
/*    */     //   186: astore #5
/*    */     //   188: aload_1
/*    */     //   189: aload_0
/*    */     //   190: getfield ap : Lorg/spongepowered/tools/obfuscation/interfaces/IMixinAnnotationProcessor;
/*    */     //   193: getstatic javax/tools/Diagnostic$Kind.WARNING : Ljavax/tools/Diagnostic$Kind;
/*    */     //   196: new java/lang/StringBuilder
/*    */     //   199: dup
/*    */     //   200: invokespecial <init> : ()V
/*    */     //   203: ldc 'Unable to locate obfuscation mapping'
/*    */     //   205: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   208: aload #5
/*    */     //   210: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   213: ldc ' for @Accessor target '
/*    */     //   215: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   218: aload_1
/*    */     //   219: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */     //   222: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   225: invokevirtual printMessage : (Ljavax/annotation/processing/Messager;Ljavax/tools/Diagnostic$Kind;Ljava/lang/CharSequence;)V
/*    */     //   228: return
/*    */     //   229: aload #4
/*    */     //   231: invokestatic stripOwnerData : (Lorg/spongepowered/tools/obfuscation/ObfuscationData;)Lorg/spongepowered/tools/obfuscation/ObfuscationData;
/*    */     //   234: astore #4
/*    */     //   236: aload_0
/*    */     //   237: getfield obf : Lorg/spongepowered/tools/obfuscation/interfaces/IObfuscationManager;
/*    */     //   240: invokeinterface getReferenceManager : ()Lorg/spongepowered/tools/obfuscation/interfaces/IReferenceManager;
/*    */     //   245: aload_0
/*    */     //   246: getfield mixin : Lorg/spongepowered/tools/obfuscation/AnnotatedMixin;
/*    */     //   249: invokevirtual getClassRef : ()Ljava/lang/String;
/*    */     //   252: aload_1
/*    */     //   253: invokevirtual getTargetName : ()Ljava/lang/String;
/*    */     //   256: aload_1
/*    */     //   257: invokevirtual getContext : ()Lorg/spongepowered/asm/mixin/injection/struct/MemberInfo;
/*    */     //   260: aload #4
/*    */     //   262: invokeinterface addMethodMapping : (Ljava/lang/String;Ljava/lang/String;Lorg/spongepowered/asm/mixin/injection/struct/MemberInfo;Lorg/spongepowered/tools/obfuscation/ObfuscationData;)V
/*    */     //   267: goto -> 337
/*    */     //   270: astore #5
/*    */     //   272: aload_1
/*    */     //   273: aload_0
/*    */     //   274: getfield ap : Lorg/spongepowered/tools/obfuscation/interfaces/IMixinAnnotationProcessor;
/*    */     //   277: getstatic javax/tools/Diagnostic$Kind.ERROR : Ljavax/tools/Diagnostic$Kind;
/*    */     //   280: new java/lang/StringBuilder
/*    */     //   283: dup
/*    */     //   284: invokespecial <init> : ()V
/*    */     //   287: ldc 'Mapping conflict for @Invoker target '
/*    */     //   289: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   292: aload_1
/*    */     //   293: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */     //   296: ldc ': '
/*    */     //   298: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   301: aload #5
/*    */     //   303: invokevirtual getNew : ()Ljava/lang/String;
/*    */     //   306: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   309: ldc ' for target '
/*    */     //   311: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   314: aload_2
/*    */     //   315: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */     //   318: ldc ' conflicts with existing mapping '
/*    */     //   320: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   323: aload #5
/*    */     //   325: invokevirtual getOld : ()Ljava/lang/String;
/*    */     //   328: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   331: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   334: invokevirtual printMessage : (Ljavax/annotation/processing/Messager;Ljavax/tools/Diagnostic$Kind;Ljava/lang/CharSequence;)V
/*    */     //   337: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #33	-> 0
/*    */     //   #31	-> 14
/*    */     //   #5	-> 18
/*    */     //   #22	-> 32
/*    */     //   #51	-> 71
/*    */     //   #15	-> 76
/*    */     //   #4	-> 93
/*    */     //   #8	-> 100
/*    */     //   #11	-> 105
/*    */     //   #14	-> 133
/*    */     //   #49	-> 141
/*    */     //   #40	-> 188
/*    */     //   #66	-> 228
/*    */     //   #71	-> 229
/*    */     //   #72	-> 236
/*    */     //   #48	-> 267
/*    */     //   #56	-> 270
/*    */     //   #24	-> 272
/*    */     //   #67	-> 325
/*    */     //   #29	-> 334
/*    */     //   #2	-> 337
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   14	25	28	org/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException
/*    */     //   18	72	72	org/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException
/*    */     //   93	101	101	org/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException
/*    */     //   133	151	154	org/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException
/*    */     //   141	180	180	org/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException
/*    */     //   236	267	270	org/spongepowered/tools/obfuscation/ReferenceManager$ReferenceConflictException
/*    */   }
/*    */   
/*    */   public int getPriority() {
/* 39 */     throw new UnsupportedOperationException("Priority not available at compile time");
/*    */   }
/* 41 */   public String getTargetClassRef() { throw new UnsupportedOperationException("Target class not available at compile time"); }
/*    */   public Target getTargetMethod(MethodNode paramMethodNode) {
/*    */     throw new UnsupportedOperationException("Target not available at compile time");
/*    */   } public void registerAccessor(AnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor) { 
/* 45 */     try { if (paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor.getAccessorType() == null) {
/*    */         paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor.printMessage((Messager)this.ap, Diagnostic.Kind.WARNING, "Unsupported accessor type");
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
/*    */         return;
/*    */       }  }
/*    */     catch (ReferenceManager$ReferenceConflictException referenceManager$ReferenceConflictException)
/* 64 */     { throw b(null); }  String str = getAccessorTargetName(paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor); try { if (str == null) { paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor.printMessage((Messager)this.ap, Diagnostic.Kind.WARNING, "Cannot inflect accessor target name"); return; }  } catch (ReferenceManager$ReferenceConflictException referenceManager$ReferenceConflictException) { throw b(null); }  paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor.setTargetName(str); for (TypeHandle typeHandle : this.mixin.getTargets()) { try { if (paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor.getAccessorType() == AccessorInfo.AccessorType.METHOD_PROXY) { registerInvokerForTarget((AnnotatedMixinElementHandlerAccessor$AnnotatedElementInvoker)paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor, typeHandle); continue; }  } catch (ReferenceManager$ReferenceConflictException referenceManager$ReferenceConflictException) { throw b(null); }  registerAccessorForTarget(paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor, typeHandle); }  } private void registerAccessorForTarget(AnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor, TypeHandle paramTypeHandle) { FieldHandle fieldHandle = paramTypeHandle.findField(paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor.getTargetName(), paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor.getTargetTypeName(), false); try { if (fieldHandle == null) { try { if (!paramTypeHandle.isImaginary()) { paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor.printMessage((Messager)this.ap, Diagnostic.Kind.ERROR, "Could not locate @Accessor target " + paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor + " in target " + paramTypeHandle); return; }  } catch (ReferenceManager$ReferenceConflictException referenceManager$ReferenceConflictException) { throw b(null); }  fieldHandle = new FieldHandle(paramTypeHandle.getName(), paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor.getTargetName(), paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor.getDesc()); }  } catch (ReferenceManager$ReferenceConflictException referenceManager$ReferenceConflictException) { throw b(null); }  try { if (!paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor.shouldRemap())
/*    */         return;  } catch (ReferenceManager$ReferenceConflictException referenceManager$ReferenceConflictException) { throw b(null); }  ObfuscationData<IMapping> obfuscationData = this.obf.getDataProvider().getObfField(fieldHandle.asMapping(false).move(paramTypeHandle.getName())); try { if (obfuscationData.isEmpty()) { try {  } catch (ReferenceManager$ReferenceConflictException referenceManager$ReferenceConflictException) { throw b(null); }
/*    */          String str = this.mixin.isMultiTarget() ? (" in target " + paramTypeHandle) : ""; paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor.printMessage((Messager)this.ap, Diagnostic.Kind.WARNING, "Unable to locate obfuscation mapping" + str + " for @Accessor target " + paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor); return; }
/*    */        }
/*    */     catch (ReferenceManager$ReferenceConflictException referenceManager$ReferenceConflictException) { throw b(null); }
/*    */      obfuscationData = AnnotatedMixinElementHandler.stripOwnerData(obfuscationData); try { this.obf.getReferenceManager().addFieldMapping(this.mixin.getClassRef(), paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor.getTargetName(), paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor.getContext(), obfuscationData); }
/* 70 */     catch (ReferenceManager$ReferenceConflictException referenceManager$ReferenceConflictException) { paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor.printMessage((Messager)this.ap, Diagnostic.Kind.ERROR, "Mapping conflict for @Accessor target " + paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor + ": " + referenceManager$ReferenceConflictException.getNew() + " for target " + paramTypeHandle + " conflicts with existing mapping " + referenceManager$ReferenceConflictException.getOld()); }  } public Extensions getExtensions() { throw new UnsupportedOperationException("Mixin Extensions not available at compile time"); } public ReferenceMapper getReferenceMapper() { return null; } public AnnotatedMixinElementHandlerAccessor(IMixinAnnotationProcessor paramIMixinAnnotationProcessor, AnnotatedMixin paramAnnotatedMixin) { super(paramIMixinAnnotationProcessor, paramAnnotatedMixin); }
/*    */   private String getAccessorTargetName(AnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor) { String str = paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor.getAnnotationValue(); try { if (Strings.isNullOrEmpty(str)) return inflectAccessorTarget(paramAnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor);  } catch (ReferenceManager$ReferenceConflictException referenceManager$ReferenceConflictException) { throw b(null); }  return str; }
/*    */   public IMixinInfo getMixin() { throw new UnsupportedOperationException("MixinInfo not available at compile time"); }
/* 73 */   public String getClassRef() { return this.mixin.getClassRef(); }
/*    */ 
/*    */   
/*    */   private static ReferenceManager$ReferenceConflictException b(ReferenceManager$ReferenceConflictException paramReferenceManager$ReferenceConflictException) {
/*    */     return paramReferenceManager$ReferenceConflictException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\AnnotatedMixinElementHandlerAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */