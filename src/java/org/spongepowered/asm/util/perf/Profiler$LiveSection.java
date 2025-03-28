/*    */ package org.spongepowered.asm.util.perf;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ 
/*    */ class Profiler$LiveSection extends Profiler$Section {
/*  6 */   public long[] getTimes() { long[] arrayOfLong = new long[this.cursor + 1];
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 12 */     System.arraycopy(this.times, 0, arrayOfLong, 0, Math.min(this.times.length, this.cursor));
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
/* 28 */     arrayOfLong[this.cursor] = this.time; return arrayOfLong; } public double getAverageTime() { try {  } catch (RuntimeException runtimeException) { throw c(null); }  return (this.count > 0) ? (this.time / this.count) : 0.0D; } private int cursor = 0; Profiler$LiveSection(String paramString, int paramInt) { super(paramProfiler, paramString); this.cursor = paramInt; }
/*    */   public long getTime() { return this.time; }
/*    */   private long start = 0L;
/*    */   public int getCount() { return this.count; }
/* 32 */   void mark() { try { if (this.cursor >= this.times.length) this.times = Arrays.copyOf(this.times, this.cursor + 4);  } catch (RuntimeException runtimeException) { throw c(null); }
/*    */      this.times[this.cursor] = this.time; this.markedTime += this.time;
/* 34 */     this.markedCount += this.count; this.time = 0L; this.count = 0; this.cursor++; }
/* 35 */   Profiler$Section start() { this.start = System.currentTimeMillis(); return this; } public Profiler$Section end() { try { stop(); if (!this.invalidated) Profiler.this.end(this);  } catch (RuntimeException runtimeException) { throw c(null); }  return this; } public long getTotalTime() { return this.time + this.markedTime; }
/* 36 */   public double getTotalAverageTime() { try {  } catch (RuntimeException runtimeException) { throw c(null); }  return (this.count > 0) ? ((this.time + this.markedTime) / (this.count + this.markedCount)) : 0.0D; } protected Profiler$Section stop() { try { if (this.start > 0L) this.time += System.currentTimeMillis() - this.start;  } catch (RuntimeException runtimeException) { throw c(null); }  this.start = 0L; this.count++; return this; } private long[] times = new long[0]; private long time; private long markedTime; private int count; private int markedCount; final Profiler this$0;
/* 37 */   public int getTotalCount() { return this.count + this.markedCount; }
/* 38 */   public double getTotalSeconds() { return (this.time + this.markedTime) * 0.001D; } public double getSeconds() {
/* 39 */     return this.time * 0.001D;
/*    */   }
/*    */   
/*    */   private static RuntimeException c(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\perf\Profiler$LiveSection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */