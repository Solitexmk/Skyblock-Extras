/*    */ package org.spongepowered.asm.mixin.injection.points;
/*    */ import org.spongepowered.asm.lib.tree.AbstractInsnNode;
/*    */ import org.spongepowered.asm.lib.tree.InsnList;
/*    */ 
/*    */ @AtCode("INVOKE_STRING")
/*    */ public class BeforeStringInvoke extends BeforeInvoke {
/*    */   public boolean find(String paramString, InsnList paramInsnList, Collection<AbstractInsnNode> paramCollection) {
/*  8 */     this.foundLdc = false;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 18 */     return super.find(paramString, paramInsnList, paramCollection);
/*    */   }
/*    */   
/*    */   private static final String STRING_VOID_SIG = "(Ljava/lang/String;)V";
/*    */   private final String ldcValue;
/*    */   private boolean foundLdc;
/*    */   
/*    */   protected boolean matchesInsn(MemberInfo paramMemberInfo, int paramInt) {
/*    */     try {
/*    */       log("{} > > found LDC \"{}\" = {}", new Object[] { this.className, this.ldcValue, Boolean.valueOf(this.foundLdc) });
/*    */       if (this.foundLdc)
/*    */         try {
/*    */           if (super.matchesInsn(paramMemberInfo, paramInt));
/*    */         } catch (IllegalArgumentException illegalArgumentException) {
/*    */           throw b(null);
/*    */         }  
/*    */     } catch (IllegalArgumentException illegalArgumentException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return false;
/*    */   }
/*    */   
/*    */   public BeforeStringInvoke(InjectionPointData paramInjectionPointData) {
/*    */     super(paramInjectionPointData);
/*    */     this.ldcValue = paramInjectionPointData.get("ldc", null);
/*    */     if (this.ldcValue == null)
/*    */       throw new IllegalArgumentException(getClass().getSimpleName() + " requires named argument \"ldc\" to specify the desired target"); 
/*    */     try {
/*    */       if (!"(Ljava/lang/String;)V".equals(this.target.desc))
/*    */         throw new IllegalArgumentException(getClass().getSimpleName() + " requires target method with with signature " + "(Ljava/lang/String;)V"); 
/*    */     } catch (IllegalArgumentException illegalArgumentException) {
/*    */       throw b(null);
/*    */     } 
/*    */   }
/*    */   
/*    */   protected void inspectInsn(String paramString, InsnList paramInsnList, AbstractInsnNode paramAbstractInsnNode) {
/*    */     // Byte code:
/*    */     //   0: aload_3
/*    */     //   1: instanceof org/spongepowered/asm/lib/tree/LdcInsnNode
/*    */     //   4: ifeq -> 81
/*    */     //   7: aload_3
/*    */     //   8: checkcast org/spongepowered/asm/lib/tree/LdcInsnNode
/*    */     //   11: astore #4
/*    */     //   13: aload #4
/*    */     //   15: getfield cst : Ljava/lang/Object;
/*    */     //   18: instanceof java/lang/String
/*    */     //   21: ifeq -> 81
/*    */     //   24: aload_0
/*    */     //   25: getfield ldcValue : Ljava/lang/String;
/*    */     //   28: aload #4
/*    */     //   30: getfield cst : Ljava/lang/Object;
/*    */     //   33: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   36: ifeq -> 81
/*    */     //   39: goto -> 46
/*    */     //   42: invokestatic b : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
/*    */     //   45: athrow
/*    */     //   46: aload_0
/*    */     //   47: ldc '{} > found a matching LDC with value {}'
/*    */     //   49: iconst_2
/*    */     //   50: anewarray java/lang/Object
/*    */     //   53: dup
/*    */     //   54: iconst_0
/*    */     //   55: aload_0
/*    */     //   56: getfield className : Ljava/lang/String;
/*    */     //   59: aastore
/*    */     //   60: dup
/*    */     //   61: iconst_1
/*    */     //   62: aload #4
/*    */     //   64: getfield cst : Ljava/lang/Object;
/*    */     //   67: aastore
/*    */     //   68: invokevirtual log : (Ljava/lang/String;[Ljava/lang/Object;)V
/*    */     //   71: aload_0
/*    */     //   72: iconst_1
/*    */     //   73: putfield foundLdc : Z
/*    */     //   76: return
/*    */     //   77: invokestatic b : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
/*    */     //   80: athrow
/*    */     //   81: aload_0
/*    */     //   82: iconst_0
/*    */     //   83: putfield foundLdc : Z
/*    */     //   86: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #19	-> 0
/*    */     //   #2	-> 7
/*    */     //   #6	-> 13
/*    */     //   #17	-> 46
/*    */     //   #7	-> 71
/*    */     //   #14	-> 76
/*    */     //   #4	-> 81
/*    */     //   #12	-> 86
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   13	39	42	java/lang/IllegalArgumentException
/*    */     //   24	77	77	java/lang/IllegalArgumentException
/*    */   }
/*    */   
/*    */   private static IllegalArgumentException b(IllegalArgumentException paramIllegalArgumentException) {
/*    */     return paramIllegalArgumentException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\points\BeforeStringInvoke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */