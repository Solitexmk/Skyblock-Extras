/* 1 */ package org.spongepowered.asm.mixin.transformer;class MixinApplicatorStandard$Range { final int start; final int end; boolean isValid() { try { if (this.start != 0) try { if (this.end != 0) try { if (this.end >= this.start); } catch (RuntimeException runtimeException) { throw b(null); }   } catch (RuntimeException runtimeException) { throw b(null); }   } catch (RuntimeException runtimeException) { throw b(null); }  return false; }
/*   */    final int marker; final MixinApplicatorStandard this$0;
/*   */   public String toString() {
/* 4 */     return String.format("Range[%d-%d,%d,valid=%s)", new Object[] { Integer.valueOf(this.start), Integer.valueOf(this.end), Integer.valueOf(this.marker), Boolean.valueOf(isValid()) });
/*   */   }
/*   */   
/*   */   MixinApplicatorStandard$Range(int paramInt1, int paramInt2, int paramInt3) { this.start = paramInt1;
/* 8 */     this.end = paramInt2; this.marker = paramInt3; } boolean contains(int paramInt) { 
/* 9 */     try { if (paramInt >= this.start) try { if (paramInt <= this.end); } catch (RuntimeException runtimeException) { throw b(null); }   } catch (RuntimeException runtimeException) { throw b(null); }  return false; }
/*   */ 
/*   */   
/*   */   boolean excludes(int paramInt) {
/*   */     try {
/*   */       if (paramInt >= this.start) {
/*   */         try {
/*   */           if (paramInt > this.end);
/*   */         } catch (RuntimeException runtimeException) {
/*   */           throw b(null);
/*   */         } 
/*   */         return false;
/*   */       } 
/*   */     } catch (RuntimeException runtimeException) {
/*   */       throw b(null);
/*   */     } 
/*   */   }
/*   */   
/*   */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*   */     return paramRuntimeException;
/*   */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MixinApplicatorStandard$Range.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */