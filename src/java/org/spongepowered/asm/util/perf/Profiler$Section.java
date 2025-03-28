/*  1 */ package org.spongepowered.asm.util.perf;public class Profiler$Section { static final String SEPARATOR_ROOT = " -> "; static final String SEPARATOR_CHILD = "."; private final String name; private boolean root; private boolean fine; protected boolean invalidated; private String info; final Profiler this$0; public long getTime() { return 0L; }
/*    */ 
/*    */   
/*    */   protected Profiler$Section stop() {
/*  5 */     return this;
/*    */   }
/*  7 */   public long[] getTimes() { return new long[1]; }
/*  8 */   public boolean isFine() { return this.fine; }
/*  9 */   public final String toString() { return this.name; }
/* 10 */   Profiler$Section start() { return this; } public String getName() {
/* 11 */     return this.name;
/*    */   } public void setInfo(String paramString) {
/*    */     this.info = paramString;
/*    */   }
/*    */   void mark() {}
/*    */   public long getTotalTime() {
/*    */     return 0L;
/*    */   }
/*    */   Profiler$Section(String paramString) { this.name = paramString;
/* 20 */     this.info = paramString; } public double getTotalAverageTime() { return 0.0D; }
/*    */   public Profiler$Section end() { try {
/*    */       if (!this.invalidated)
/*    */         Profiler.this.end(this); 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     }  return this; }
/*    */   public boolean isRoot() { return this.root; }
/* 28 */   Profiler$Section setFine(boolean paramBoolean) { this.fine = paramBoolean; return this; }
/* 29 */   public double getTotalSeconds() { return 0.0D; } public String getBaseName() { return this.name; } public int getCount() { return 0; }
/* 30 */   public Profiler$Section next(String paramString) { end(); return Profiler.this.begin(paramString); } public double getSeconds() { return 0.0D; } public double getAverageTime() { return 0.0D; } Profiler$Section invalidate() { this.invalidated = true;
/*    */     return this; }
/* 32 */   Profiler$Section setRoot(boolean paramBoolean) { this.root = paramBoolean;
/* 33 */     return this; } public String getInfo() { return this.info; }
/* 34 */   Profiler$Section getDelegate() { return this; } public int getTotalCount() {
/* 35 */     return 0;
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\perf\Profiler$Section.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */