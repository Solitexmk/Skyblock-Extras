/*  1 */ package org.spongepowered.asm.mixin.struct;public abstract class MemberRef { public int hashCode() { return toString().hashCode(); }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/*  8 */     String str = Bytecode.getOpcodeName(getOpcode()); 
/*  9 */     try { (new Object[5])[0] = str; (new Object[5])[1] = getOwner(); (new Object[5])[2] = getName(); } catch (RuntimeException runtimeException) { throw b(null); }  return String.format("%s for %s.%s%s%s", new Object[] { null, null, null, isField() ? ":" : "", getDesc() });
/* 10 */   } private static final int[] H_OPCODES = new int[] { 0, 180, 178, 181, 179, 182, 184, 183, 183, 185 };
/*    */   
/*    */   public boolean equals(Object paramObject) { try {
/* 13 */       if (!(paramObject instanceof MemberRef))
/*    */         return false; 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/* 18 */     MemberRef memberRef = (MemberRef)paramObject; try { if (getOpcode() == memberRef.getOpcode()) try { if (getOwner().equals(memberRef.getOwner())) try { if (getName().equals(memberRef.getName()))
/* 19 */                 try { if (getDesc().equals(memberRef.getDesc())); } catch (RuntimeException runtimeException) { throw b(null); }   } catch (RuntimeException runtimeException) { throw b(null); }   } catch (RuntimeException runtimeException) { throw b(null); }   } catch (RuntimeException runtimeException) { throw b(null); }  return false; } static int tagFromOpcode(int paramInt) { byte b = 1; while (true) { try { if (b < H_OPCODES.length) {
/*    */           try {
/*    */             if (H_OPCODES[b] == paramInt)
/*    */               return b; 
/*    */           } catch (RuntimeException runtimeException) {
/*    */             throw b(null);
/*    */           } 
/*    */           b++;
/*    */         }  }
/*    */       catch (RuntimeException runtimeException)
/*    */       { throw b(null); }
/*    */       
/*    */       return 0; }
/*    */      }
/*    */ 
/*    */   
/*    */   static int opcodeFromTag(int paramInt) {
/*    */     try {
/*    */       if (paramInt >= 0)
/*    */         try {
/*    */           if (paramInt < H_OPCODES.length);
/*    */         } catch (RuntimeException runtimeException) {
/*    */           throw b(null);
/*    */         }  
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return 0;
/*    */   }
/*    */   
/*    */   public abstract boolean isField();
/*    */   
/*    */   public abstract int getOpcode();
/*    */   
/*    */   public abstract void setOpcode(int paramInt);
/*    */   
/*    */   public abstract String getOwner();
/*    */   
/*    */   public abstract void setOwner(String paramString);
/*    */   
/*    */   public abstract String getName();
/*    */   
/*    */   public abstract void setName(String paramString);
/*    */   
/*    */   public abstract String getDesc();
/*    */   
/*    */   public abstract void setDesc(String paramString);
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\struct\MemberRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */