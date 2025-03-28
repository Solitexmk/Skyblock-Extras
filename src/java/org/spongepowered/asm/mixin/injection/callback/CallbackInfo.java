/*  1 */ package org.spongepowered.asm.mixin.injection.callback;public class CallbackInfo implements Cancellable { private final String name; public static String getCallInfoClassName(Type paramType) { try {  } catch (CancellationException cancellationException) { throw b(null); }  return (paramType.equals(Type.VOID_TYPE) ? CallbackInfo.class.getName() : CallbackInfoReturnable.class.getName()).replace('.', '/'); } private final boolean cancellable; private boolean cancelled; static String getIsCancelledMethodName() {
/*  2 */     return "isCancelled"; } static String getConstructorDescriptor(Type paramType) { 
/*  3 */     try { if (paramType.equals(Type.VOID_TYPE))
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 13 */         return getConstructorDescriptor(); }  } catch (CancellationException cancellationException) { throw b(null); }  try { if (paramType.getSort() != 10)
/*    */         try { if (paramType.getSort() != 9)
/* 15 */             return String.format("(%sZ%s)V", new Object[] { "Ljava/lang/String;", paramType.getDescriptor() });  return String.format("(%sZ%s)V", new Object[] { "Ljava/lang/String;", "Ljava/lang/Object;" }); }
/*    */         catch (CancellationException cancellationException)
/*    */         { throw b(null); }
/*    */           }
/*    */     catch (CancellationException cancellationException)
/*    */     { throw b(null); }
/*    */     
/* 22 */     return String.format("(%sZ%s)V", new Object[] { "Ljava/lang/String;", "Ljava/lang/Object;" }); } public CallbackInfo(String paramString, boolean paramBoolean) { this.name = paramString;
/*    */     this.cancellable = paramBoolean; }
/*    */ 
/*    */   
/*    */   public void cancel() throws CancellationException {
/*    */     try {
/*    */       if (!this.cancellable)
/*    */         throw new CancellationException(String.format("The call %s is not cancellable.", new Object[] { this.name })); 
/*    */     } catch (CancellationException cancellationException) {
/*    */       throw b(null);
/*    */     } 
/*    */     this.cancelled = true;
/*    */   }
/*    */   
/*    */   static String getCallInfoClassName() {
/*    */     return CallbackInfo.class.getName();
/*    */   }
/*    */   
/*    */   static String getConstructorDescriptor() {
/*    */     return String.format("(%sZ)V", new Object[] { "Ljava/lang/String;" });
/*    */   }
/*    */   
/*    */   public String toString() {
/*    */     return String.format("CallbackInfo[TYPE=%s,NAME=%s,CANCELLABLE=%s]", new Object[] { getClass().getSimpleName(), this.name, Boolean.valueOf(this.cancellable) });
/*    */   }
/*    */   
/*    */   public final boolean isCancelled() {
/*    */     return this.cancelled;
/*    */   }
/*    */   
/*    */   public final boolean isCancellable() {
/*    */     return this.cancellable;
/*    */   }
/*    */   
/*    */   public String getId() {
/*    */     return this.name;
/*    */   }
/*    */   
/*    */   static String getIsCancelledMethodSig() {
/*    */     return "()Z";
/*    */   }
/*    */   
/*    */   private static CancellationException b(CancellationException paramCancellationException) {
/*    */     return paramCancellationException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\callback\CallbackInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */