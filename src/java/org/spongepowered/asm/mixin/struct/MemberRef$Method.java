/*    */ package org.spongepowered.asm.mixin.struct;public final class MemberRef$Method extends MemberRef { private static final int OPCODES = 191;
/*    */   
/*    */   public String getName() {
/*  4 */     return this.insn.name;
/*    */   } public final MethodInsnNode insn; public MemberRef$Method(MethodInsnNode paramMethodInsnNode) {
/*    */     this.insn = paramMethodInsnNode;
/*    */   } public void setDesc(String paramString) {
/*  8 */     this.insn.desc = paramString; }
/*  9 */   public void setOwner(String paramString) { this.insn.owner = paramString; }
/* 10 */   public String getOwner() { return this.insn.owner; }
/* 11 */   public String getDesc() { return this.insn.desc; } public void setOpcode(int paramInt) { 
/* 12 */     try { if ((paramInt & 0xBF) == 0)
/*    */       {
/* 14 */         throw new IllegalArgumentException("Invalid opcode for method instruction: 0x" + Integer.toHexString(paramInt)); }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }
/* 15 */      this.insn.setOpcode(paramInt); }
/*    */   public int getOpcode() { return this.insn.getOpcode(); }
/* 17 */   public void setName(String paramString) { this.insn.name = paramString; } public boolean isField() {
/* 18 */     return false;
/*    */   }
/*    */   
/*    */   private static IllegalArgumentException b(IllegalArgumentException paramIllegalArgumentException) {
/*    */     return paramIllegalArgumentException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\struct\MemberRef$Method.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */