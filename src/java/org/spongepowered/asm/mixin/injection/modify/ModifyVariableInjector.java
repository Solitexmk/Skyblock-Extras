/*  1 */ package org.spongepowered.asm.mixin.injection.modify;public class ModifyVariableInjector extends Injector { private final LocalVariableDiscriminator discriminator; protected void inject(Target paramTarget, InjectionNodes.InjectionNode paramInjectionNode) { try { if (paramInjectionNode.isReplaced())
/*    */       {
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
/* 31 */         throw new InvalidInjectionException(this.info, "Variable modifier target for " + this + " was removed by another injector"); }  } catch (InvalidImplicitDiscriminatorException invalidImplicitDiscriminatorException) { throw b(null); }
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
/* 54 */     ModifyVariableInjector$Context modifyVariableInjector$Context = new ModifyVariableInjector$Context(this.returnType, this.discriminator.isArgsOnly(), paramTarget, paramInjectionNode.getCurrentTarget()); try { if (this.discriminator.printLVT())
/* 55 */         printLocals(modifyVariableInjector$Context);  } catch (InvalidImplicitDiscriminatorException invalidImplicitDiscriminatorException) { throw b(null); }  String str = Bytecode.getDescriptor(new Type[] { this.returnType }, this.returnType); try { if (!str.equals(this.methodNode.desc)) throw new InvalidInjectionException(this.info, "Variable modifier " + this + " has an invalid signature, expected " + str + " but found " + this.methodNode.desc);  } catch (InvalidImplicitDiscriminatorException invalidImplicitDiscriminatorException) { throw b(null); }  try { int i = this.discriminator.findLocal(modifyVariableInjector$Context); try { if (i > -1)
/* 56 */           inject(modifyVariableInjector$Context, i);  } catch (InvalidImplicitDiscriminatorException invalidImplicitDiscriminatorException) { throw b(null); }  } catch (InvalidImplicitDiscriminatorException invalidImplicitDiscriminatorException) { try { if (this.discriminator.printLVT()) { this.info.addCallbackInvocation(this.methodNode); return; }  } catch (InvalidImplicitDiscriminatorException invalidImplicitDiscriminatorException1) { throw b(null); }  throw new InvalidInjectionException(this.info, "Implicit variable modifier injection failed in " + this, invalidImplicitDiscriminatorException); }  try { paramTarget.insns.insertBefore(modifyVariableInjector$Context.node, modifyVariableInjector$Context.insns); } catch (InvalidImplicitDiscriminatorException invalidImplicitDiscriminatorException) { throw b(null); }  paramTarget.addToStack(this.isStatic ? 1 : 2); } private void printLocals(ModifyVariableInjector$Context paramModifyVariableInjector$Context) { SignaturePrinter signaturePrinter = new SignaturePrinter(this.methodNode.name, this.returnType, this.methodArgs, new String[] { "var" }); try { signaturePrinter.setModifiers(this.methodNode); } catch (InvalidInjectionException invalidInjectionException) { throw b(null); }  try {  } catch (InvalidInjectionException invalidInjectionException) { throw b(null); }  try {  } catch (InvalidInjectionException invalidInjectionException) { throw b(null); }  try {  } catch (InvalidInjectionException invalidInjectionException) { throw b(null); }  (new PrettyPrinter()).kvWidth(20).kv("Target Class", this.classNode.name.replace('/', '.'))
/* 57 */       .kv("Target Method", paramModifyVariableInjector$Context.target.method.name).kv("Callback Name", this.methodNode.name).kv("Capture Type", SignaturePrinter.getTypeName(this.returnType, false)).kv("Instruction", "%s %s", new Object[] { paramModifyVariableInjector$Context.node.getClass().getSimpleName(), Bytecode.getOpcodeName(paramModifyVariableInjector$Context.node.getOpcode()) }).hr().kv("Match mode", this.discriminator.isImplicit(paramModifyVariableInjector$Context) ? "IMPLICIT (match single)" : "EXPLICIT (match by criteria)").kv("Match ordinal", (this.discriminator.getOrdinal() < 0) ? "any" : Integer.valueOf(this.discriminator.getOrdinal())).kv("Match index", (this.discriminator.getIndex() < paramModifyVariableInjector$Context.baseArgIndex) ? "any" : Integer.valueOf(this.discriminator.getIndex())).kv("Match name(s)", this.discriminator.hasNames() ? this.discriminator.getNames() : "any").kv("Args only", Boolean.valueOf(this.discriminator.isArgsOnly())).hr().add(paramModifyVariableInjector$Context).print(System.err); }
/*    */   public ModifyVariableInjector(InjectionInfo paramInjectionInfo, LocalVariableDiscriminator paramLocalVariableDiscriminator) { super(paramInjectionInfo); this.discriminator = paramLocalVariableDiscriminator; }
/* 59 */   protected boolean findTargetNodes(MethodNode paramMethodNode, InjectionPoint paramInjectionPoint, InsnList paramInsnList, Collection<AbstractInsnNode> paramCollection) { if (paramInjectionPoint instanceof ModifyVariableInjector$ContextualInjectionPoint) { Target target = this.info.getContext().getTargetMethod(paramMethodNode); return ((ModifyVariableInjector$ContextualInjectionPoint)paramInjectionPoint).find(target, paramCollection); }  return paramInjectionPoint.find(paramMethodNode.desc, paramInsnList, paramCollection); } private void inject(ModifyVariableInjector$Context paramModifyVariableInjector$Context, int paramInt) { try { if (!this.isStatic) paramModifyVariableInjector$Context.insns.add((AbstractInsnNode)new VarInsnNode(25, 0));  } catch (InvalidInjectionException invalidInjectionException) { throw b(null); }  paramModifyVariableInjector$Context.insns.add((AbstractInsnNode)new VarInsnNode(this.returnType.getOpcode(21), paramInt)); invokeHandler(paramModifyVariableInjector$Context.insns); paramModifyVariableInjector$Context.insns.add((AbstractInsnNode)new VarInsnNode(this.returnType.getOpcode(54), paramInt)); } protected void sanityCheck(Target paramTarget, List<InjectionPoint> paramList) { try { super.sanityCheck(paramTarget, paramList);
/*    */       if (paramTarget.isStatic != this.isStatic)
/*    */         throw new InvalidInjectionException(this.info, "'static' of variable modifier method does not match target in " + this);  }
/*    */     catch (InvalidInjectionException invalidInjectionException)
/*    */     { throw b(null); }
/*    */     
/*    */     int i = this.discriminator.getOrdinal();
/*    */     try {
/*    */       if (i < -1)
/*    */         throw new InvalidInjectionException(this.info, "Invalid ordinal " + i + " specified in " + this); 
/*    */     } catch (InvalidInjectionException invalidInjectionException) {
/*    */       throw b(null);
/*    */     } 
/*    */     try {
/*    */       if (this.discriminator.getIndex() == 0)
/*    */         try {
/*    */           if (!this.isStatic)
/*    */             throw new InvalidInjectionException(this.info, "Invalid index 0 specified in non-static variable modifier " + this); 
/*    */         } catch (InvalidInjectionException invalidInjectionException) {
/*    */           throw b(null);
/*    */         }  
/*    */     } catch (InvalidInjectionException invalidInjectionException) {
/*    */       throw b(null);
/*    */     }  }
/*    */ 
/*    */   
/*    */   private static MixinException b(MixinException paramMixinException) {
/*    */     return paramMixinException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\modify\ModifyVariableInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */