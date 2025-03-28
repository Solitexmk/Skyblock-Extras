/*    */ package org.spongepowered.asm.mixin.injection.callback;public class CallbackInfoReturnable<R> extends CallbackInfo { private R returnValue;
/*    */   public long getReturnValueJ() { 
/*  3 */     try { if (this.returnValue == null) return 0L;  } catch (CancellationException cancellationException) { throw c(null); }  return ((Long)this.returnValue).longValue(); }
/*    */   public byte getReturnValueB() { 
/*  5 */     try { if (this.returnValue == null) return 0;  } catch (CancellationException cancellationException) { throw c(null); }  return ((Byte)this.returnValue).byteValue(); } public R getReturnValue() {
/*  6 */     return this.returnValue;
/*    */   }
/*    */   
/*  9 */   public CallbackInfoReturnable(String paramString, boolean paramBoolean, float paramFloat) { super(paramString, paramBoolean);
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
/*    */ 
/*    */     
/* 32 */     this.returnValue = (R)Float.valueOf(paramFloat); } public boolean getReturnValueZ() { try { if (this.returnValue == null)
/*    */         return false;  } catch (CancellationException cancellationException) { throw c(null); }  return ((Boolean)this.returnValue).booleanValue(); }
/*    */   public void setReturnValue(R paramR) throws CancellationException { cancel(); this.returnValue = paramR; }
/*    */   public CallbackInfoReturnable(String paramString, boolean paramBoolean, byte paramByte) { super(paramString, paramBoolean); this.returnValue = (R)Byte.valueOf(paramByte); }
/*    */   public short getReturnValueS() { try { if (this.returnValue == null)
/*    */         return 0;  } catch (CancellationException cancellationException) { throw c(null); }
/*    */      return ((Short)this.returnValue).shortValue(); }
/*    */   public CallbackInfoReturnable(String paramString, boolean paramBoolean, double paramDouble) { super(paramString, paramBoolean); this.returnValue = (R)Double.valueOf(paramDouble); }
/*    */   public float getReturnValueF() { try { if (this.returnValue == null)
/*    */         return 0.0F;  }
/*    */     catch (CancellationException cancellationException) { throw c(null); }
/*    */      return ((Float)this.returnValue).floatValue(); }
/* 44 */   public CallbackInfoReturnable(String paramString, boolean paramBoolean, long paramLong) { super(paramString, paramBoolean); this.returnValue = (R)Long.valueOf(paramLong); }
/*    */   public CallbackInfoReturnable(String paramString, boolean paramBoolean, short paramShort) { super(paramString, paramBoolean); this.returnValue = (R)Short.valueOf(paramShort); }
/*    */   static String getReturnAccessor(Type paramType) { try { if (paramType.getSort() != 10) try { if (paramType.getSort() != 9) return String.format("getReturnValue%s", new Object[] { paramType.getDescriptor() });  return "getReturnValue"; } catch (CancellationException cancellationException) { throw c(null); }   } catch (CancellationException cancellationException) { throw c(null); }  return "getReturnValue"; }
/* 47 */   public CallbackInfoReturnable(String paramString, boolean paramBoolean, R paramR) { super(paramString, paramBoolean); this.returnValue = paramR; } public CallbackInfoReturnable(String paramString, boolean paramBoolean, int paramInt) { super(paramString, paramBoolean); this.returnValue = (R)Integer.valueOf(paramInt); } public char getReturnValueC() { try { if (this.returnValue == null) return Character.MIN_VALUE;  } catch (CancellationException cancellationException) { throw c(null); }  return ((Character)this.returnValue).charValue(); }
/* 48 */   public double getReturnValueD() { try { if (this.returnValue == null) return 0.0D;  } catch (CancellationException cancellationException) { throw c(null); }  return ((Double)this.returnValue).doubleValue(); } static String getReturnDescriptor(Type paramType) { try { if (paramType.getSort() != 10) try { if (paramType.getSort() != 9) return String.format("()%s", new Object[] { paramType.getDescriptor() });  return String.format("()%s", new Object[] { "Ljava/lang/Object;" }); } catch (CancellationException cancellationException) { throw c(null); }   } catch (CancellationException cancellationException) { throw c(null); }  return String.format("()%s", new Object[] { "Ljava/lang/Object;" }); } public int getReturnValueI() { try { if (this.returnValue == null) return 0;  } catch (CancellationException cancellationException) { throw c(null); }  return ((Integer)this.returnValue).intValue(); } public CallbackInfoReturnable(String paramString, boolean paramBoolean, char paramChar) { super(paramString, paramBoolean); this.returnValue = (R)Character.valueOf(paramChar); } public CallbackInfoReturnable(String paramString, boolean paramBoolean1, boolean paramBoolean2) { super(paramString, paramBoolean1); this.returnValue = (R)Boolean.valueOf(paramBoolean2); } public CallbackInfoReturnable(String paramString, boolean paramBoolean) { super(paramString, paramBoolean);
/*    */     this.returnValue = null; }
/*    */ 
/*    */   
/*    */   private static CancellationException c(CancellationException paramCancellationException) {
/*    */     return paramCancellationException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\callback\CallbackInfoReturnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */