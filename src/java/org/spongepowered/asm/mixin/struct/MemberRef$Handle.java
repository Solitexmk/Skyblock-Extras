/*  1 */ package org.spongepowered.asm.mixin.struct;public final class MemberRef$Handle extends MemberRef { private org.spongepowered.asm.lib.Handle handle; public String getDesc() { return this.handle.getDesc(); }
/*    */   public String getOwner() { return this.handle.getOwner(); }
/*  3 */   public MemberRef$Handle(org.spongepowered.asm.lib.Handle paramHandle) { this.handle = paramHandle; } public void setName(String paramString) { try {  } catch (RuntimeException runtimeException) { throw c(null); }  boolean bool = (this.handle.getTag() == 9) ? true : false;
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
/* 23 */     this.handle = new org.spongepowered.asm.lib.Handle(this.handle.getTag(), this.handle.getOwner(), paramString, this.handle.getDesc(), bool); }
/*    */   public void setDesc(String paramString) { try {  } catch (RuntimeException runtimeException) { throw c(null); }  boolean bool = (this.handle.getTag() == 9) ? true : false; this.handle = new org.spongepowered.asm.lib.Handle(this.handle.getTag(), this.handle.getOwner(), this.handle.getName(), paramString, bool); } public void setOpcode(int paramInt) { int i = MemberRef.tagFromOpcode(paramInt); try { if (i == 0)
/*    */         throw new MixinTransformerError("Invalid opcode " + Bytecode.getOpcodeName(paramInt) + " for method handle " + this.handle + ".");  } catch (RuntimeException runtimeException) { throw c(null); }  try {  } catch (RuntimeException runtimeException) { throw c(null); }
/* 26 */      boolean bool = (i == 9) ? true : false; this.handle = new org.spongepowered.asm.lib.Handle(i, this.handle.getOwner(), this.handle.getName(), this.handle.getDesc(), bool); } public void setOwner(String paramString) { try {  } catch (RuntimeException runtimeException) { throw c(null); }  boolean bool = (this.handle.getTag() == 9) ? true : false; this.handle = new org.spongepowered.asm.lib.Handle(this.handle.getTag(), paramString, this.handle.getName(), this.handle.getDesc(), bool); } public int getOpcode() { int i = MemberRef.opcodeFromTag(this.handle.getTag()); try { if (i == 0) throw new MixinTransformerError("Invalid tag " + this.handle.getTag() + " for method handle " + this.handle + ".");  } catch (RuntimeException runtimeException) { throw c(null); }  return i; } public org.spongepowered.asm.lib.Handle getMethodHandle() { return this.handle; }
/*    */   public String getName() { return this.handle.getName(); }
/* 28 */   public boolean isField() { try { switch (this.handle.getTag()) { case 5: case 6: case 7: case 8: case 9: return false;
/* 29 */         case 1: case 2: case 3: case 4: return true; }  } catch (RuntimeException runtimeException) { throw c(null); }  throw new MixinTransformerError("Invalid tag " + this.handle.getTag() + " for method handle " + this.handle + "."); }
/*    */ 
/*    */   
/*    */   private static RuntimeException c(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\struct\MemberRef$Handle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */