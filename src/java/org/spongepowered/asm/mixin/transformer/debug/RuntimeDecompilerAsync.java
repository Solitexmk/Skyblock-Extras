/*    */ package org.spongepowered.asm.mixin.transformer.debug;
/*    */ 
/*    */ 
/*    */ public class RuntimeDecompilerAsync extends RuntimeDecompiler implements Runnable, Thread.UncaughtExceptionHandler {
/*  5 */   public RuntimeDecompilerAsync(File paramFile) { super(paramFile);
/*    */     
/*    */     this.thread.setDaemon(true);
/*    */     
/*  9 */     this.thread.setPriority(1);
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
/* 30 */     this.thread.setUncaughtExceptionHandler(this); this.thread.start(); } private void flush() { this.run = false; while (true) {
/*    */       File file; try {
/* 32 */         if ((file = this.queue.poll()) != null) {
/*    */           decompile(file);
/*    */           continue;
/*    */         } 
/*    */       } catch (RuntimeException runtimeException) {
/*    */         throw b(null);
/*    */       } 
/*    */       break;
/*    */     }  }
/*    */ 
/*    */   
/*    */   public void run() {
/*    */     while (this.run) {
/*    */       try {
/*    */         File file = this.queue.take();
/*    */         super.decompile(file);
/*    */         continue;
/*    */       } catch (InterruptedException null) {
/*    */         this.run = false;
/*    */         continue;
/*    */       } catch (Exception exception) {}
/*    */       exception.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   private boolean run = true;
/*    */   
/*    */   public void decompile(File paramFile) {
/*    */     try {
/*    */       if (this.run) {
/*    */         this.queue.offer(paramFile);
/*    */       } else {
/*    */         super.decompile(paramFile);
/*    */       } 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */   }
/*    */   
/*    */   private final BlockingQueue<File> queue = new LinkedBlockingQueue<File>();
/*    */   
/*    */   public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
/*    */     this.logger.error("Async decompiler encountered an error and will terminate. Further decompile requests will be handled synchronously. {} {}", new Object[] { paramThrowable.getClass().getName(), paramThrowable.getMessage() });
/*    */     flush();
/*    */   }
/*    */   
/*    */   private final Thread thread = new Thread(this, "Decompiler thread");
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\debug\RuntimeDecompilerAsync.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */