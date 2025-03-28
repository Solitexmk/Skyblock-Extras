/*    */ package org.spongepowered.tools.obfuscation;
/*    */ 
/*    */ import java.lang.reflect.Method;
/*    */ import javax.annotation.processing.Messager;
/*    */ import javax.lang.model.element.ExecutableElement;
/*    */ import javax.tools.Diagnostic;
/*    */ import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
/*    */ import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
/*    */ import org.spongepowered.tools.obfuscation.mirror.AnnotationHandle;
/*    */ import org.spongepowered.tools.obfuscation.mirror.TypeHandle;
/*    */ 
/*    */ class AnnotatedMixinElementHandlerOverwrite extends AnnotatedMixinElementHandler {
/* 13 */   AnnotatedMixinElementHandlerOverwrite(IMixinAnnotationProcessor paramIMixinAnnotationProcessor, AnnotatedMixin paramAnnotatedMixin) { super(paramIMixinAnnotationProcessor, paramAnnotatedMixin); }
/*    */   public void registerOverwrite(AnnotatedMixinElementHandlerOverwrite$AnnotatedElementOverwrite paramAnnotatedMixinElementHandlerOverwrite$AnnotatedElementOverwrite) { // Byte code:
/*    */     //   0: new org/spongepowered/tools/obfuscation/AnnotatedMixinElementHandler$AliasedElementName
/*    */     //   3: dup
/*    */     //   4: aload_1
/*    */     //   5: invokevirtual getElement : ()Ljavax/lang/model/element/Element;
/*    */     //   8: aload_1
/*    */     //   9: invokevirtual getAnnotation : ()Lorg/spongepowered/tools/obfuscation/mirror/AnnotationHandle;
/*    */     //   12: invokespecial <init> : (Ljavax/lang/model/element/Element;Lorg/spongepowered/tools/obfuscation/mirror/AnnotationHandle;)V
/*    */     //   15: astore_2
/*    */     //   16: aload_0
/*    */     //   17: aload_1
/*    */     //   18: invokevirtual getElement : ()Ljavax/lang/model/element/Element;
/*    */     //   21: checkcast javax/lang/model/element/ExecutableElement
/*    */     //   24: aload_1
/*    */     //   25: invokevirtual getAnnotation : ()Lorg/spongepowered/tools/obfuscation/mirror/AnnotationHandle;
/*    */     //   28: aload_2
/*    */     //   29: ldc '@Overwrite'
/*    */     //   31: iconst_1
/*    */     //   32: iconst_0
/*    */     //   33: invokevirtual validateTargetMethod : (Ljavax/lang/model/element/ExecutableElement;Lorg/spongepowered/tools/obfuscation/mirror/AnnotationHandle;Lorg/spongepowered/tools/obfuscation/AnnotatedMixinElementHandler$AliasedElementName;Ljava/lang/String;ZZ)V
/*    */     //   36: aload_0
/*    */     //   37: aload_1
/*    */     //   38: invokevirtual getElement : ()Ljavax/lang/model/element/Element;
/*    */     //   41: checkcast javax/lang/model/element/ExecutableElement
/*    */     //   44: aload_1
/*    */     //   45: invokevirtual getAnnotation : ()Lorg/spongepowered/tools/obfuscation/mirror/AnnotationHandle;
/*    */     //   48: invokevirtual checkConstraints : (Ljavax/lang/model/element/ExecutableElement;Lorg/spongepowered/tools/obfuscation/mirror/AnnotationHandle;)V
/*    */     //   51: aload_1
/*    */     //   52: invokevirtual shouldRemap : ()Z
/*    */     //   55: ifeq -> 109
/*    */     //   58: aload_0
/*    */     //   59: getfield mixin : Lorg/spongepowered/tools/obfuscation/AnnotatedMixin;
/*    */     //   62: invokevirtual getTargets : ()Ljava/util/List;
/*    */     //   65: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   70: astore_3
/*    */     //   71: aload_3
/*    */     //   72: invokeinterface hasNext : ()Z
/*    */     //   77: ifeq -> 109
/*    */     //   80: aload_3
/*    */     //   81: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   86: checkcast org/spongepowered/tools/obfuscation/mirror/TypeHandle
/*    */     //   89: astore #4
/*    */     //   91: aload_0
/*    */     //   92: aload_1
/*    */     //   93: aload #4
/*    */     //   95: invokespecial registerOverwriteForTarget : (Lorg/spongepowered/tools/obfuscation/AnnotatedMixinElementHandlerOverwrite$AnnotatedElementOverwrite;Lorg/spongepowered/tools/obfuscation/mirror/TypeHandle;)Z
/*    */     //   98: ifne -> 106
/*    */     //   101: return
/*    */     //   102: invokestatic b : (Lorg/spongepowered/tools/obfuscation/Mappings$MappingConflictException;)Lorg/spongepowered/tools/obfuscation/Mappings$MappingConflictException;
/*    */     //   105: athrow
/*    */     //   106: goto -> 71
/*    */     //   109: ldc 'true'
/*    */     //   111: aload_0
/*    */     //   112: getfield ap : Lorg/spongepowered/tools/obfuscation/interfaces/IMixinAnnotationProcessor;
/*    */     //   115: ldc 'disableOverwriteChecker'
/*    */     //   117: invokeinterface getOption : (Ljava/lang/String;)Ljava/lang/String;
/*    */     //   122: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*    */     //   125: ifne -> 286
/*    */     //   128: ldc 'error'
/*    */     //   130: aload_0
/*    */     //   131: getfield ap : Lorg/spongepowered/tools/obfuscation/interfaces/IMixinAnnotationProcessor;
/*    */     //   134: ldc 'overwriteErrorLevel'
/*    */     //   136: invokeinterface getOption : (Ljava/lang/String;)Ljava/lang/String;
/*    */     //   141: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*    */     //   144: ifeq -> 164
/*    */     //   147: goto -> 154
/*    */     //   150: invokestatic b : (Lorg/spongepowered/tools/obfuscation/Mappings$MappingConflictException;)Lorg/spongepowered/tools/obfuscation/Mappings$MappingConflictException;
/*    */     //   153: athrow
/*    */     //   154: getstatic javax/tools/Diagnostic$Kind.ERROR : Ljavax/tools/Diagnostic$Kind;
/*    */     //   157: goto -> 167
/*    */     //   160: invokestatic b : (Lorg/spongepowered/tools/obfuscation/Mappings$MappingConflictException;)Lorg/spongepowered/tools/obfuscation/Mappings$MappingConflictException;
/*    */     //   163: athrow
/*    */     //   164: getstatic javax/tools/Diagnostic$Kind.WARNING : Ljavax/tools/Diagnostic$Kind;
/*    */     //   167: astore_3
/*    */     //   168: aload_0
/*    */     //   169: getfield ap : Lorg/spongepowered/tools/obfuscation/interfaces/IMixinAnnotationProcessor;
/*    */     //   172: invokeinterface getJavadocProvider : ()Lorg/spongepowered/tools/obfuscation/interfaces/IJavadocProvider;
/*    */     //   177: aload_1
/*    */     //   178: invokevirtual getElement : ()Ljavax/lang/model/element/Element;
/*    */     //   181: invokeinterface getJavadoc : (Ljavax/lang/model/element/Element;)Ljava/lang/String;
/*    */     //   186: astore #4
/*    */     //   188: aload #4
/*    */     //   190: ifnonnull -> 214
/*    */     //   193: aload_0
/*    */     //   194: getfield ap : Lorg/spongepowered/tools/obfuscation/interfaces/IMixinAnnotationProcessor;
/*    */     //   197: aload_3
/*    */     //   198: ldc '@Overwrite is missing javadoc comment'
/*    */     //   200: aload_1
/*    */     //   201: invokevirtual getElement : ()Ljavax/lang/model/element/Element;
/*    */     //   204: invokeinterface printMessage : (Ljavax/tools/Diagnostic$Kind;Ljava/lang/CharSequence;Ljavax/lang/model/element/Element;)V
/*    */     //   209: return
/*    */     //   210: invokestatic b : (Lorg/spongepowered/tools/obfuscation/Mappings$MappingConflictException;)Lorg/spongepowered/tools/obfuscation/Mappings$MappingConflictException;
/*    */     //   213: athrow
/*    */     //   214: aload #4
/*    */     //   216: invokevirtual toLowerCase : ()Ljava/lang/String;
/*    */     //   219: ldc '@author'
/*    */     //   221: invokevirtual contains : (Ljava/lang/CharSequence;)Z
/*    */     //   224: ifne -> 250
/*    */     //   227: aload_0
/*    */     //   228: getfield ap : Lorg/spongepowered/tools/obfuscation/interfaces/IMixinAnnotationProcessor;
/*    */     //   231: aload_3
/*    */     //   232: ldc '@Overwrite is missing an @author tag'
/*    */     //   234: aload_1
/*    */     //   235: invokevirtual getElement : ()Ljavax/lang/model/element/Element;
/*    */     //   238: invokeinterface printMessage : (Ljavax/tools/Diagnostic$Kind;Ljava/lang/CharSequence;Ljavax/lang/model/element/Element;)V
/*    */     //   243: goto -> 250
/*    */     //   246: invokestatic b : (Lorg/spongepowered/tools/obfuscation/Mappings$MappingConflictException;)Lorg/spongepowered/tools/obfuscation/Mappings$MappingConflictException;
/*    */     //   249: athrow
/*    */     //   250: aload #4
/*    */     //   252: invokevirtual toLowerCase : ()Ljava/lang/String;
/*    */     //   255: ldc '@reason'
/*    */     //   257: invokevirtual contains : (Ljava/lang/CharSequence;)Z
/*    */     //   260: ifne -> 286
/*    */     //   263: aload_0
/*    */     //   264: getfield ap : Lorg/spongepowered/tools/obfuscation/interfaces/IMixinAnnotationProcessor;
/*    */     //   267: aload_3
/*    */     //   268: ldc '@Overwrite is missing an @reason tag'
/*    */     //   270: aload_1
/*    */     //   271: invokevirtual getElement : ()Ljavax/lang/model/element/Element;
/*    */     //   274: invokeinterface printMessage : (Ljavax/tools/Diagnostic$Kind;Ljava/lang/CharSequence;Ljavax/lang/model/element/Element;)V
/*    */     //   279: goto -> 286
/*    */     //   282: invokestatic b : (Lorg/spongepowered/tools/obfuscation/Mappings$MappingConflictException;)Lorg/spongepowered/tools/obfuscation/Mappings$MappingConflictException;
/*    */     //   285: athrow
/*    */     //   286: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #2	-> 0
/*    */     //   #36	-> 16
/*    */     //   #7	-> 36
/*    */     //   #31	-> 51
/*    */     //   #10	-> 58
/*    */     //   #6	-> 91
/*    */     //   #28	-> 101
/*    */     //   #19	-> 106
/*    */     //   #14	-> 109
/*    */     //   #17	-> 128
/*    */     //   #24	-> 168
/*    */     //   #39	-> 188
/*    */     //   #23	-> 193
/*    */     //   #16	-> 209
/*    */     //   #40	-> 214
/*    */     //   #35	-> 227
/*    */     //   #42	-> 250
/*    */     //   #21	-> 263
/*    */     //   #37	-> 286
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   91	102	102	org/spongepowered/tools/obfuscation/Mappings$MappingConflictException
/*    */     //   109	147	150	org/spongepowered/tools/obfuscation/Mappings$MappingConflictException
/*    */     //   128	160	160	org/spongepowered/tools/obfuscation/Mappings$MappingConflictException
/*    */     //   188	210	210	org/spongepowered/tools/obfuscation/Mappings$MappingConflictException
/*    */     //   214	243	246	org/spongepowered/tools/obfuscation/Mappings$MappingConflictException
/*    */     //   250	279	282	org/spongepowered/tools/obfuscation/Mappings$MappingConflictException } public void registerMerge(ExecutableElement paramExecutableElement) {
/* 15 */     validateTargetMethod(paramExecutableElement, null, new AnnotatedMixinElementHandler$AliasedElementName(paramExecutableElement, AnnotationHandle.MISSING), "overwrite", true, true);
/*    */   }
/*    */   private boolean registerOverwriteForTarget(AnnotatedMixinElementHandlerOverwrite$AnnotatedElementOverwrite paramAnnotatedMixinElementHandlerOverwrite$AnnotatedElementOverwrite, TypeHandle paramTypeHandle) {
/* 18 */     MappingMethod mappingMethod = paramTypeHandle.getMappingMethod(paramAnnotatedMixinElementHandlerOverwrite$AnnotatedElementOverwrite.getSimpleName(), paramAnnotatedMixinElementHandlerOverwrite$AnnotatedElementOverwrite.getDesc());
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     ObfuscationData<MappingMethod> obfuscationData = this.obf.getDataProvider().getObfMethod(mappingMethod);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 29 */     if (obfuscationData.isEmpty()) {
/*    */ 
/*    */       
/* 32 */       Diagnostic.Kind kind = Diagnostic.Kind.ERROR; try { Method method = paramAnnotatedMixinElementHandlerOverwrite$AnnotatedElementOverwrite.getElement().getClass().getMethod("isStatic", new Class[0]); if (((Boolean)method.invoke(paramAnnotatedMixinElementHandlerOverwrite$AnnotatedElementOverwrite.getElement(), new Object[0])).booleanValue())
/*    */           kind = Diagnostic.Kind.WARNING;  }
/*    */       catch (Exception exception) {} this.ap.printMessage(kind, "No obfuscation mapping for @Overwrite method", paramAnnotatedMixinElementHandlerOverwrite$AnnotatedElementOverwrite.getElement());
/*    */     }  try {
/*    */       addMethodMappings(paramAnnotatedMixinElementHandlerOverwrite$AnnotatedElementOverwrite.getSimpleName(), paramAnnotatedMixinElementHandlerOverwrite$AnnotatedElementOverwrite.getDesc(), obfuscationData);
/*    */     } catch (Mappings$MappingConflictException mappings$MappingConflictException) {
/* 38 */       paramAnnotatedMixinElementHandlerOverwrite$AnnotatedElementOverwrite.printMessage((Messager)this.ap, Diagnostic.Kind.ERROR, "Mapping conflict for @Overwrite method: " + mappings$MappingConflictException.getNew().getSimpleName() + " for target " + paramTypeHandle + " conflicts with existing mapping " + mappings$MappingConflictException
/*    */ 
/*    */           
/* 41 */           .getOld().getSimpleName());
/*    */       return false;
/*    */     } 
/*    */     return true;
/*    */   }
/*    */   
/*    */   private static Mappings$MappingConflictException b(Mappings$MappingConflictException paramMappings$MappingConflictException) {
/*    */     return paramMappings$MappingConflictException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\AnnotatedMixinElementHandlerOverwrite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */