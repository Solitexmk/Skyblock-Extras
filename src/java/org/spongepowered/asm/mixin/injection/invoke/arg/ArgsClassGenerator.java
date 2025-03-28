/*     */ package org.spongepowered.asm.mixin.injection.invoke.arg;
/*     */ 
/*     */ public final class ArgsClassGenerator implements IClassGenerator {
/*   4 */   private void generateGetters(String paramString1, String paramString2, Type[] paramArrayOfType, ClassVisitor paramClassVisitor) { boolean bool = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Type[] arrayOfType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     byte b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 122 */     for (arrayOfType = paramArrayOfType, i = arrayOfType.length, b = 0; b < i; ) { Type type = arrayOfType[b];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       String str1 = "$" + bool;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       String str2 = "()" + type.getDescriptor();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       MethodVisitorEx methodVisitorEx = new MethodVisitorEx(paramClassVisitor.visitMethod(1, str1, str2, null, null));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 178 */       methodVisitorEx.visitCode(); }
/*     */      }
/*     */   public byte[] generate(String paramString) { return getBytes(paramString); } public static final String ARGS_REF = ARGS_NAME.replace('.', '/'); private void generateToString(String paramString1, String paramString2, Type[] paramArrayOfType, ClassVisitor paramClassVisitor) { MethodVisitor methodVisitor = paramClassVisitor.visitMethod(1, "toString", "()Ljava/lang/String;", null, null); methodVisitor.visitCode();
/* 181 */     methodVisitor.visitLdcInsn("Args" + getSignature(paramArrayOfType));
/*     */     methodVisitor.visitInsn(176);
/*     */     methodVisitor.visitMaxs(1, 1);
/*     */     methodVisitor.visitEnd(); }
/*     */   private int nextIndex = 1;
/*     */   private final Map<String, byte[]> classBytes = (Map)new HashMap<String, byte>(); public String getClassName(String paramString) { String str1 = Bytecode.changeDescriptorReturnType(paramString, "V");
/*     */     String str2 = (String)this.classNames.get(str1);
/*     */     if (str2 == null) {
/*     */       str2 = String.format("%s%d", new Object[] { "org.spongepowered.asm.synthetic.args.Args$", Integer.valueOf(this.nextIndex++) });
/*     */       this.classNames.put(str1, str2);
/*     */     } 
/*     */     return str2; } private void generateSetters(String paramString1, String paramString2, Type[] paramArrayOfType, ClassVisitor paramClassVisitor) { generateIndexedSetter(paramString1, paramString2, paramArrayOfType, paramClassVisitor);
/*     */     generateMultiSetter(paramString1, paramString2, paramArrayOfType, paramClassVisitor); } private final BiMap<String, String> classNames = (BiMap<String, String>)HashBiMap.create(); private static void throwAIOOBE(MethodVisitorEx paramMethodVisitorEx, int paramInt) {
/*     */     paramMethodVisitorEx.visitTypeInsn(187, "org/spongepowered/asm/mixin/injection/invoke/arg/ArgumentIndexOutOfBoundsException");
/*     */     paramMethodVisitorEx.visitInsn(89);
/* 196 */     paramMethodVisitorEx.visitVarInsn(21, paramInt);
/*     */     paramMethodVisitorEx.visitMethodInsn(183, "org/spongepowered/asm/mixin/injection/invoke/arg/ArgumentIndexOutOfBoundsException", "<init>", "(I)V", false);
/*     */     paramMethodVisitorEx.visitInsn(191);
/*     */   }
/*     */   
/*     */   public String getClassRef(String paramString) {
/*     */     return getClassName(paramString).replace('.', '/');
/*     */   }
/*     */   
/*     */   private void generateMultiSetter(String paramString1, String paramString2, Type[] paramArrayOfType, ClassVisitor paramClassVisitor) {
/*     */     MethodVisitorEx methodVisitorEx = new MethodVisitorEx(paramClassVisitor.visitMethod(1, "setAll", "([Ljava/lang/Object;)V", null, null));
/*     */     methodVisitorEx.visitCode();
/*     */     Label label1 = new Label(), label2 = new Label();
/*     */     byte b1 = 6;
/*     */     methodVisitorEx.visitVarInsn(25, 1);
/*     */     methodVisitorEx.visitInsn(190);
/*     */     methodVisitorEx.visitInsn(89);
/*     */     methodVisitorEx.visitConstant((byte)paramArrayOfType.length);
/*     */     methodVisitorEx.visitJumpInsn(159, label1);
/*     */     methodVisitorEx.visitTypeInsn(187, "org/spongepowered/asm/mixin/injection/invoke/arg/ArgumentCountException");
/*     */     methodVisitorEx.visitInsn(89);
/*     */     methodVisitorEx.visitInsn(93);
/*     */     methodVisitorEx.visitInsn(88);
/*     */     methodVisitorEx.visitConstant((byte)paramArrayOfType.length);
/*     */     methodVisitorEx.visitLdcInsn(getSignature(paramArrayOfType));
/*     */     methodVisitorEx.visitMethodInsn(183, "org/spongepowered/asm/mixin/injection/invoke/arg/ArgumentCountException", "<init>", "(IILjava/lang/String;)V", false);
/*     */     methodVisitorEx.visitInsn(191);
/*     */     methodVisitorEx.visitLabel(label1);
/*     */     methodVisitorEx.visitInsn(87);
/*     */     methodVisitorEx.visitVarInsn(25, 0);
/*     */     methodVisitorEx.visitFieldInsn(180, paramString1, "values", "[Ljava/lang/Object;");
/*     */     for (byte b2 = 0; b2 < paramArrayOfType.length; methodVisitorEx.visitConstant(b2), methodVisitorEx.visitVarInsn(25, 1), methodVisitorEx.visitConstant(b2))
/*     */       methodVisitorEx.visitInsn(89); 
/*     */     methodVisitorEx.visitInsn(177);
/*     */     methodVisitorEx.visitLabel(label2);
/*     */     throwNPE(methodVisitorEx, "Argument with primitive type cannot be set to NULL");
/*     */     methodVisitorEx.visitInsn(177);
/*     */     methodVisitorEx.visitMaxs(b1, 2);
/*     */     methodVisitorEx.visitEnd();
/*     */   }
/*     */   
/*     */   public static final String ARGS_NAME = Args.class.getName();
/*     */   public static final String GETTER_PREFIX = "$";
/*     */   private static final String CLASS_NAME_BASE = "org.spongepowered.asm.synthetic.args.Args$";
/*     */   private static final String OBJECT = "java/lang/Object";
/*     */   private static final String OBJECT_ARRAY = "[Ljava/lang/Object;";
/*     */   private static final String VALUES_FIELD = "values";
/*     */   private static final String CTOR_DESC = "([Ljava/lang/Object;)V";
/*     */   private static final String SET = "set";
/*     */   private static final String SET_DESC = "(ILjava/lang/Object;)V";
/*     */   private static final String SETALL = "setAll";
/*     */   private static final String SETALL_DESC = "([Ljava/lang/Object;)V";
/*     */   private static final String NPE = "java/lang/NullPointerException";
/*     */   private static final String NPE_CTOR_DESC = "(Ljava/lang/String;)V";
/*     */   private static final String AIOOBE = "org/spongepowered/asm/mixin/injection/invoke/arg/ArgumentIndexOutOfBoundsException";
/*     */   private static final String AIOOBE_CTOR_DESC = "(I)V";
/*     */   private static final String ACE = "org/spongepowered/asm/mixin/injection/invoke/arg/ArgumentCountException";
/*     */   private static final String ACE_CTOR_DESC = "(IILjava/lang/String;)V";
/*     */   
/*     */   private void generateIndexedSetter(String paramString1, String paramString2, Type[] paramArrayOfType, ClassVisitor paramClassVisitor) {
/*     */     MethodVisitorEx methodVisitorEx = new MethodVisitorEx(paramClassVisitor.visitMethod(1, "set", "(ILjava/lang/Object;)V", null, null));
/*     */     methodVisitorEx.visitCode();
/*     */     Label label1 = new Label(), label2 = new Label();
/*     */     Label[] arrayOfLabel = new Label[paramArrayOfType.length];
/*     */     byte b = 0;
/*     */     try {
/*     */       while (b < arrayOfLabel.length) {
/*     */         arrayOfLabel[b] = new Label();
/*     */         b++;
/*     */       } 
/*     */     } catch (RuntimeException runtimeException) {
/*     */       throw b(null);
/*     */     } 
/*     */     methodVisitorEx.visitVarInsn(25, 0);
/*     */     methodVisitorEx.visitFieldInsn(180, paramString1, "values", "[Ljava/lang/Object;");
/*     */     for (b = 0; b < paramArrayOfType.length; methodVisitorEx.visitJumpInsn(159, arrayOfLabel[b]), b = (byte)(b + 1)) {
/*     */       methodVisitorEx.visitVarInsn(21, 1);
/*     */       methodVisitorEx.visitConstant(b);
/*     */     } 
/*     */     throwAIOOBE(methodVisitorEx, 1);
/*     */     for (b = 0; b < paramArrayOfType.length; ) {
/*     */       String str = Bytecode.getBoxingType(paramArrayOfType[b]);
/*     */       try {
/*     */         methodVisitorEx.visitLabel(arrayOfLabel[b]);
/*     */         methodVisitorEx.visitVarInsn(21, 1);
/*     */         methodVisitorEx.visitVarInsn(25, 2);
/*     */       } catch (RuntimeException runtimeException) {
/*     */         throw b(null);
/*     */       } 
/*     */     } 
/*     */     methodVisitorEx.visitLabel(label2);
/*     */     methodVisitorEx.visitInsn(89);
/*     */     methodVisitorEx.visitJumpInsn(199, label1);
/*     */     throwNPE(methodVisitorEx, "Argument with primitive type cannot be set to NULL");
/*     */     methodVisitorEx.visitLabel(label1);
/*     */     methodVisitorEx.visitInsn(83);
/*     */     methodVisitorEx.visitInsn(177);
/*     */     methodVisitorEx.visitMaxs(6, 3);
/*     */     methodVisitorEx.visitEnd();
/*     */   }
/*     */   
/*     */   private static String getSignature(Type[] paramArrayOfType) {
/*     */     return (new SignaturePrinter("", null, paramArrayOfType)).setFullyQualified(true).getFormattedArgs();
/*     */   }
/*     */   
/*     */   private static void unbox(MethodVisitor paramMethodVisitor, Type paramType) {
/*     */     String str = Bytecode.getBoxingType(paramType);
/*     */     if (str != null) {
/*     */       String str1 = Bytecode.getUnboxingMethod(paramType);
/*     */       String str2 = "()" + paramType.getDescriptor();
/*     */       paramMethodVisitor.visitTypeInsn(192, str);
/*     */     } 
/*     */     paramMethodVisitor.visitTypeInsn(192, paramType.getInternalName());
/*     */   }
/*     */   
/*     */   private static void box(MethodVisitor paramMethodVisitor, Type paramType) {
/*     */     String str = Bytecode.getBoxingType(paramType);
/*     */     if (str != null) {
/*     */       String str1 = String.format("(%s)L%s;", new Object[] { paramType.getDescriptor(), str });
/*     */       paramMethodVisitor.visitMethodInsn(184, str, "valueOf", str1, false);
/*     */     } 
/*     */   }
/*     */   
/*     */   private byte[] generateClass(String paramString1, String paramString2) {
/*     */     CheckClassAdapter checkClassAdapter;
/*     */     String str = paramString1.replace('.', '/');
/*     */     Type[] arrayOfType = Type.getArgumentTypes(paramString2);
/*     */     ClassWriter classWriter1 = new ClassWriter(2);
/*     */     ClassWriter classWriter2 = classWriter1;
/*     */     if (MixinEnvironment.getCurrentEnvironment().getOption(MixinEnvironment.Option.DEBUG_VERIFY))
/*     */       checkClassAdapter = new CheckClassAdapter((ClassVisitor)classWriter1); 
/*     */     checkClassAdapter.visit(50, 4129, str, null, ARGS_REF, null);
/*     */     checkClassAdapter.visitSource(paramString1.substring(paramString1.lastIndexOf('.') + 1) + ".java", null);
/*     */     generateCtor(str, paramString2, arrayOfType, (ClassVisitor)checkClassAdapter);
/*     */     generateToString(str, paramString2, arrayOfType, (ClassVisitor)checkClassAdapter);
/*     */     generateFactory(str, paramString2, arrayOfType, (ClassVisitor)checkClassAdapter);
/*     */     generateSetters(str, paramString2, arrayOfType, (ClassVisitor)checkClassAdapter);
/*     */     generateGetters(str, paramString2, arrayOfType, (ClassVisitor)checkClassAdapter);
/*     */     checkClassAdapter.visitEnd();
/*     */     return classWriter1.toByteArray();
/*     */   }
/*     */   
/*     */   private void generateFactory(String paramString1, String paramString2, Type[] paramArrayOfType, ClassVisitor paramClassVisitor) {
/*     */     String str = Bytecode.changeDescriptorReturnType(paramString2, "L" + paramString1 + ";");
/*     */     MethodVisitorEx methodVisitorEx = new MethodVisitorEx(paramClassVisitor.visitMethod(9, "of", str, null, null));
/*     */     methodVisitorEx.visitCode();
/*     */     methodVisitorEx.visitTypeInsn(187, paramString1);
/*     */     methodVisitorEx.visitInsn(89);
/*     */     methodVisitorEx.visitConstant((byte)paramArrayOfType.length);
/*     */     methodVisitorEx.visitTypeInsn(189, "java/lang/Object");
/*     */     boolean bool = false;
/*     */     Type[] arrayOfType;
/*     */     int i;
/*     */     byte b;
/*     */     for (arrayOfType = paramArrayOfType, i = arrayOfType.length, b = 0; b < i; ) {
/*     */       Type type = arrayOfType[b];
/*     */       methodVisitorEx.visitInsn(89);
/*     */       methodVisitorEx.visitConstant(bool);
/*     */       methodVisitorEx.visitVarInsn(type.getOpcode(21), bool);
/*     */     } 
/*     */     methodVisitorEx.visitMethodInsn(183, paramString1, "<init>", "([Ljava/lang/Object;)V", false);
/*     */     methodVisitorEx.visitInsn(176);
/*     */     methodVisitorEx.visitMaxs(6, Bytecode.getArgsSize(paramArrayOfType));
/*     */     methodVisitorEx.visitEnd();
/*     */   }
/*     */   
/*     */   private static void throwNPE(MethodVisitorEx paramMethodVisitorEx, String paramString) {
/*     */     paramMethodVisitorEx.visitTypeInsn(187, "java/lang/NullPointerException");
/*     */     paramMethodVisitorEx.visitInsn(89);
/*     */     paramMethodVisitorEx.visitLdcInsn(paramString);
/*     */     paramMethodVisitorEx.visitMethodInsn(183, "java/lang/NullPointerException", "<init>", "(Ljava/lang/String;)V", false);
/*     */     paramMethodVisitorEx.visitInsn(191);
/*     */   }
/*     */   
/*     */   private void generateCtor(String paramString1, String paramString2, Type[] paramArrayOfType, ClassVisitor paramClassVisitor) {
/*     */     MethodVisitor methodVisitor = paramClassVisitor.visitMethod(2, "<init>", "([Ljava/lang/Object;)V", null, null);
/*     */     methodVisitor.visitCode();
/*     */     methodVisitor.visitVarInsn(25, 0);
/*     */     methodVisitor.visitVarInsn(25, 1);
/*     */     methodVisitor.visitMethodInsn(183, ARGS_REF, "<init>", "([Ljava/lang/Object;)V", false);
/*     */     methodVisitor.visitInsn(177);
/*     */     methodVisitor.visitMaxs(2, 2);
/*     */     methodVisitor.visitEnd();
/*     */   }
/*     */   
/*     */   public byte[] getBytes(String paramString) {
/*     */     byte[] arrayOfByte = this.classBytes.get(paramString);
/*     */     if (arrayOfByte == null) {
/*     */       String str = (String)this.classNames.inverse().get(paramString);
/*     */       try {
/*     */         if (str == null)
/*     */           return null; 
/*     */       } catch (RuntimeException runtimeException) {
/*     */         throw b(null);
/*     */       } 
/*     */       arrayOfByte = generateClass(paramString, str);
/*     */       this.classBytes.put(paramString, arrayOfByte);
/*     */     } 
/*     */     return arrayOfByte;
/*     */   }
/*     */   
/*     */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*     */     return paramRuntimeException;
/*     */   }
/*     */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\invoke\arg\ArgsClassGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */