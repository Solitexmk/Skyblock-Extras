/*  1 */ package org.spongepowered.tools.obfuscation.struct;public class InjectorRemap { private final boolean remap; public void clearMessage() { this.message = null; }
/*    */    private Message message; private int remappedCount;
/*    */   public void notifyRemapped() {
/*  4 */     this.remappedCount++;
/*    */ 
/*    */ 
/*    */     
/*  8 */     clearMessage(); } public void dispatchPendingMessages(Messager paramMessager) { try { if (this.remappedCount == 0)
/*    */         
/*    */         try { if (this.message != null)
/* 11 */             this.message.sendTo(paramMessager);  } catch (RuntimeException runtimeException) { throw b(null); }
/*    */           }
/*    */     catch (RuntimeException runtimeException) { throw b(null); }
/* 14 */      } public InjectorRemap(boolean paramBoolean) { this.remap = paramBoolean; }
/*    */ 
/*    */   
/*    */   public boolean shouldRemap() {
/*    */     return this.remap;
/*    */   }
/*    */   
/*    */   public void addMessage(Diagnostic.Kind paramKind, CharSequence paramCharSequence, Element paramElement, AnnotationHandle paramAnnotationHandle) {
/*    */     this.message = new Message(paramKind, paramCharSequence, paramElement, paramAnnotationHandle);
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\struct\InjectorRemap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */