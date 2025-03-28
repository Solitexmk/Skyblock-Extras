/*   */ package org.spongepowered.asm.mixin.injection.invoke.util;public class InsnFinder { public AbstractInsnNode findPopInsn(Target paramTarget, AbstractInsnNode paramAbstractInsnNode) {
/*   */     
/* 3 */     try { (new InsnFinder$PopAnalyzer(paramAbstractInsnNode)).analyze(paramTarget.classNode.name, paramTarget.method);
/*   */        }
/*   */     
/* 6 */     catch (AnalyzerException analyzerException) { 
/* 7 */       try { if (analyzerException.getCause() instanceof InsnFinder$AnalysisResultException)
/* 8 */           return ((InsnFinder$AnalysisResultException)analyzerException.getCause()).getResult();  } catch (AnalyzerException analyzerException1) { throw b(null); }  logger.catching((Throwable)analyzerException); }
/* 9 */      return null;
/*   */   }
/*   */   
/*   */   private static final Logger logger = LogManager.getLogger("mixin");
/*   */   
/*   */   private static AnalyzerException b(AnalyzerException paramAnalyzerException) {
/*   */     return paramAnalyzerException;
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\invok\\util\InsnFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */