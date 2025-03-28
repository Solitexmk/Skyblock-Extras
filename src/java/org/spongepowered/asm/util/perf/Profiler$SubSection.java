/*  1 */ package org.spongepowered.asm.util.perf;class Profiler$SubSection extends Profiler$LiveSection { private final String baseName; public void setInfo(String paramString) { this.root.setInfo(paramString);
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
/* 14 */     super.setInfo(paramString); }
/*    */   private final Profiler$Section root; final Profiler this$0; Profiler$Section getDelegate() { return this.root; } Profiler$Section start() {
/*    */     this.root.start();
/* 17 */     return super.start(); } public String getBaseName() { return this.baseName; }
/* 18 */   public Profiler$Section end() { this.root.stop();
/*    */     return super.end(); }
/*    */ 
/*    */   
/*    */   Profiler$Section invalidate() {
/*    */     this.root.invalidate();
/*    */     return super.invalidate();
/*    */   }
/*    */   
/*    */   public Profiler$Section next(String paramString) {
/*    */     stop();
/*    */     return this.root.next(paramString);
/*    */   }
/*    */   
/*    */   Profiler$SubSection(String paramString1, int paramInt, String paramString2, Profiler$Section paramProfiler$Section) {
/*    */     super(paramProfiler, paramString1, paramInt);
/*    */     this.baseName = paramString2;
/*    */     this.root = paramProfiler$Section;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\perf\Profiler$SubSection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */