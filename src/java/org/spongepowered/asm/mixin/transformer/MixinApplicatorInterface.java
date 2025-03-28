/*    */ package org.spongepowered.asm.mixin.transformer;
/*    */ import org.spongepowered.asm.lib.tree.FieldNode;
/*    */ import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;
/*    */ 
/*    */ class MixinApplicatorInterface extends MixinApplicatorStandard {
/*    */   MixinApplicatorInterface(TargetClassContext paramTargetClassContext) {
/*  7 */     super(paramTargetClassContext);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void applyInjections(MixinTargetContext paramMixinTargetContext) {}
/*    */   
/*    */   protected void prepareInjections(MixinTargetContext paramMixinTargetContext) {
/* 14 */     for (MethodNode methodNode : this.targetClass.methods) { try { InjectionInfo injectionInfo = InjectionInfo.parse(paramMixinTargetContext, methodNode); try { if (injectionInfo != null)
/* 15 */             throw new InvalidInterfaceMixinException(paramMixinTargetContext, injectionInfo + " is not supported on interface mixin method " + methodNode.name);  } catch (InvalidInjectionException invalidInjectionException) { throw b(null); }
/*    */          }
/* 17 */       catch (InvalidInjectionException invalidInjectionException) {} }
/*    */   
/*    */   }
/*    */   
/*    */   protected void applyInitialisers(MixinTargetContext paramMixinTargetContext) {}
/* 22 */   protected void applyFields(MixinTargetContext paramMixinTargetContext) { for (Map.Entry<FieldNode, ClassInfo$Field> entry : paramMixinTargetContext.getShadowFields())
/*    */       FieldNode fieldNode = (FieldNode)entry.getKey(); 
/*    */     mergeNewFields(paramMixinTargetContext); } protected void applyInterfaces(MixinTargetContext paramMixinTargetContext) {
/* 25 */     for (String str : paramMixinTargetContext.getInterfaces()) {
/*    */       try {
/*    */         if (!this.targetClass.name.equals(str))
/*    */           try {
/*    */             if (!this.targetClass.interfaces.contains(str)) {
/*    */               this.targetClass.interfaces.add(str);
/*    */               paramMixinTargetContext.getTargetClassInfo().addInterface(str);
/*    */             } 
/*    */           } catch (InvalidInjectionException invalidInjectionException) {
/*    */             throw b(null);
/*    */           }  
/*    */       } catch (InvalidInjectionException invalidInjectionException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private static InvalidInjectionException b(InvalidInjectionException paramInvalidInjectionException) {
/*    */     return paramInvalidInjectionException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MixinApplicatorInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */