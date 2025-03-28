/*  1 */ package org.spongepowered.asm.mixin.struct;public final class MemberRef$Field extends MemberRef { private static final int OPCODES = 183; public void setDesc(String paramString) { this.insn.desc = paramString; }
/*    */   
/*    */   public final FieldInsnNode insn;
/*    */   public String getOwner() {
/*    */     return this.insn.owner;
/*    */   }
/*    */   public String getDesc() {
/*    */     return this.insn.desc;
/*    */   }
/*    */   public MemberRef$Field(FieldInsnNode paramFieldInsnNode) {
/* 11 */     this.insn = paramFieldInsnNode; } public void setOwner(String paramString) { this.insn.owner = paramString; }
/* 12 */   public String getName() { return this.insn.name; }
/*    */   public void setOpcode(int paramInt) { 
/* 14 */     try { if ((paramInt & 0xB7) == 0)
/*    */       {
/*    */         
/* 17 */         throw new IllegalArgumentException("Invalid opcode for field instruction: 0x" + Integer.toHexString(paramInt)); }  } catch (IllegalArgumentException illegalArgumentException) { throw b(null); }  this.insn.setOpcode(paramInt); } public int getOpcode() { return this.insn.getOpcode(); }
/* 18 */   public void setName(String paramString) { this.insn.name = paramString; }
/*    */ 
/*    */   
/*    */   public boolean isField() {
/*    */     return true;
/*    */   }
/*    */   
/*    */   private static IllegalArgumentException b(IllegalArgumentException paramIllegalArgumentException) {
/*    */     return paramIllegalArgumentException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\struct\MemberRef$Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */