/*   */ package org.spongepowered.asm.mixin.transformer;
/*   */ 
/*   */ class MixinPreProcessorInterface extends MixinPreProcessorStandard {
/* 4 */   MixinPreProcessorInterface(MixinInfo paramMixinInfo, MixinInfo$MixinClassNode paramMixinInfo$MixinClassNode) { super(paramMixinInfo, paramMixinInfo$MixinClassNode); } protected boolean validateField(MixinTargetContext paramMixinTargetContext, FieldNode paramFieldNode, AnnotationNode paramAnnotationNode) { 
/* 5 */     try { if (!Bytecode.hasFlag(paramFieldNode, 8))
/*   */         throw new InvalidInterfaceMixinException(this.mixin, "Interface mixin contains an instance field! Found " + paramFieldNode.name + " in " + this.mixin);  } catch (InvalidInterfaceMixinException invalidInterfaceMixinException) { throw b(null); }
/* 7 */      return super.validateField(paramMixinTargetContext, paramFieldNode, paramAnnotationNode); } protected void prepareMethod(MixinInfo$MixinMethodNode paramMixinInfo$MixinMethodNode, ClassInfo$Method paramClassInfo$Method) {
/*   */     
/* 9 */     try { if (!Bytecode.hasFlag(paramMixinInfo$MixinMethodNode, 1)) try { if (!Bytecode.hasFlag(paramMixinInfo$MixinMethodNode, 4096)) throw new InvalidInterfaceMixinException(this.mixin, "Interface mixin contains a non-public method! Found " + paramClassInfo$Method + " in " + this.mixin);  } catch (InvalidInterfaceMixinException invalidInterfaceMixinException) { throw b(null); }   } catch (InvalidInterfaceMixinException invalidInterfaceMixinException) { throw b(null); }
/*   */     
/*   */     super.prepareMethod(paramMixinInfo$MixinMethodNode, paramClassInfo$Method);
/*   */   }
/*   */   
/*   */   private static InvalidInterfaceMixinException b(InvalidInterfaceMixinException paramInvalidInterfaceMixinException) {
/*   */     return paramInvalidInterfaceMixinException;
/*   */   }
/*   */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MixinPreProcessorInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */