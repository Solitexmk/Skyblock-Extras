/*  1 */ package org.spongepowered.asm.mixin.transformer;class MixinPostProcessor extends TreeTransformer implements MixinConfig$IListener { public boolean isDelegationExcluded() { return true; }
/*  2 */   public void onPrepare(MixinInfo paramMixinInfo) { String str = paramMixinInfo.getClassName();
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
/* 52 */     try { if (paramMixinInfo.isLoadable())
/*    */         registerLoadable(str);  } catch (RuntimeException runtimeException) { throw b(null); }
/*    */      try { if (paramMixinInfo.isAccessor())
/* 55 */         registerAccessor(paramMixinInfo);  } catch (RuntimeException runtimeException) { throw b(null); }
/*    */      }
/*    */   boolean canTransform(String paramString) { try { if (!this.syntheticInnerClasses.contains(paramString)) { try { if (this.loadable.contains(paramString)); }
/*    */         catch (RuntimeException runtimeException) { throw b(null); }
/*    */          return false; }
/*    */        }
/*    */     catch (RuntimeException runtimeException) { throw b(null); }
/*    */      } private byte[] processAccessor(byte[] paramArrayOfbyte, MixinInfo paramMixinInfo) { try {
/*    */       if (!MixinEnvironment.getCompatibilityLevel().isAtLeast(MixinEnvironment.CompatibilityLevel.JAVA_8))
/*    */         return paramArrayOfbyte; 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/* 67 */     }  boolean bool = false;
/*    */     MixinInfo$MixinClassNode mixinInfo$MixinClassNode = paramMixinInfo.getClassNode(0);
/*    */     ClassInfo classInfo = paramMixinInfo.getTargets().get(0);
/*    */     for (MixinInfo$MixinMethodNode mixinInfo$MixinMethodNode : mixinInfo$MixinClassNode.mixinMethods) {
/*    */       try {
/*    */         if (!Bytecode.hasFlag(mixinInfo$MixinMethodNode, 8));
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } 
/*    */     try {
/*    */       if (bool)
/*    */         return writeClass(mixinInfo$MixinClassNode); 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return paramArrayOfbyte; }
/*    */ 
/*    */   
/*    */   private static ClassInfo$Method getAccessorMethod(MixinInfo paramMixinInfo, MethodNode paramMethodNode, ClassInfo paramClassInfo) throws MixinTransformerError {
/*    */     ClassInfo$Method classInfo$Method = paramMixinInfo.getClassInfo().findMethod(paramMethodNode, 10);
/*    */     try {
/*    */       if (!classInfo$Method.isRenamed())
/*    */         throw new MixinTransformerError("Unexpected state: " + paramMixinInfo + " loaded before " + paramClassInfo + " was conformed"); 
/*    */     } catch (MixinTransformerError mixinTransformerError) {
/*    */       throw b(null);
/*    */     } 
/*    */     return classInfo$Method;
/*    */   }
/*    */   
/*    */   public String getName() {
/*    */     return getClass().getName();
/*    */   }
/*    */   
/*    */   public byte[] transformClassBytes(String paramString1, String paramString2, byte[] paramArrayOfbyte) {
/*    */     try {
/*    */       if (this.syntheticInnerClasses.contains(paramString2))
/*    */         return processSyntheticInner(paramArrayOfbyte); 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     if (this.accessorMixins.containsKey(paramString2)) {
/*    */       MixinInfo mixinInfo = this.accessorMixins.get(paramString2);
/*    */       return processAccessor(paramArrayOfbyte, mixinInfo);
/*    */     } 
/*    */     return paramArrayOfbyte;
/*    */   }
/*    */   
/*    */   void registerLoadable(String paramString) {
/*    */     this.loadable.add(paramString);
/*    */   }
/*    */   
/*    */   private static void createProxy(MethodNode paramMethodNode, ClassInfo paramClassInfo, ClassInfo$Method paramClassInfo$Method) {
/*    */     paramMethodNode.instructions.clear();
/*    */     Type[] arrayOfType = Type.getArgumentTypes(paramMethodNode.desc);
/*    */     Type type = Type.getReturnType(paramMethodNode.desc);
/*    */     Bytecode.loadArgs(arrayOfType, paramMethodNode.instructions, 0);
/*    */     paramMethodNode.instructions.add((AbstractInsnNode)new MethodInsnNode(184, paramClassInfo.getName(), paramClassInfo$Method.getName(), paramMethodNode.desc, false));
/*    */     paramMethodNode.instructions.add((AbstractInsnNode)new InsnNode(type.getOpcode(172)));
/*    */     paramMethodNode.maxStack = Bytecode.getFirstNonArgLocalIndex(arrayOfType, false);
/*    */     paramMethodNode.maxLocals = 0;
/*    */   }
/*    */   
/*    */   void registerAccessor(MixinInfo paramMixinInfo) {
/*    */     registerLoadable(paramMixinInfo.getClassName());
/*    */     this.accessorMixins.put(paramMixinInfo.getClassName(), paramMixinInfo);
/*    */   }
/*    */   
/*    */   private final Set<String> syntheticInnerClasses = new HashSet<String>();
/*    */   private final Map<String, MixinInfo> accessorMixins;
/*    */   private final Set<String> loadable;
/*    */   
/*    */   private byte[] processSyntheticInner(byte[] paramArrayOfbyte) {
/*    */     ClassReader classReader = new ClassReader(paramArrayOfbyte);
/*    */     MixinClassWriter mixinClassWriter = new MixinClassWriter(classReader, 0);
/*    */     MixinPostProcessor$1 mixinPostProcessor$1 = new MixinPostProcessor$1(this, 327680, (ClassVisitor)mixinClassWriter);
/*    */     classReader.accept(mixinPostProcessor$1, 8);
/*    */     return mixinClassWriter.toByteArray();
/*    */   }
/*    */   
/*    */   public void onInit(MixinInfo paramMixinInfo) {
/*    */     for (String str : paramMixinInfo.getSyntheticInnerClasses())
/*    */       registerSyntheticInner(str.replace('/', '.')); 
/*    */   }
/*    */   
/*    */   MixinPostProcessor() {
/*    */     this.accessorMixins = new HashMap<String, MixinInfo>();
/*    */     this.loadable = new HashSet<String>();
/*    */   }
/*    */   
/*    */   void registerSyntheticInner(String paramString) {
/*    */     this.syntheticInnerClasses.add(paramString);
/*    */   }
/*    */   
/*    */   private static Throwable b(Throwable paramThrowable) {
/*    */     return paramThrowable;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MixinPostProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */