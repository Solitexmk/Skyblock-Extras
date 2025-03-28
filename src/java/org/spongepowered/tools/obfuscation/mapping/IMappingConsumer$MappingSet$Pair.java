/*  1 */ package org.spongepowered.tools.obfuscation.mapping;public class IMappingConsumer$MappingSet$Pair<TMapping extends IMapping<TMapping>> { public final TMapping from; public IMappingConsumer$MappingSet$Pair(TMapping paramTMapping1, TMapping paramTMapping2) { this.from = paramTMapping1;
/*    */     
/*  3 */     this.to = paramTMapping2; }
/*    */    public final TMapping to; public boolean equals(Object paramObject) {
/*    */     
/*  6 */     try { if (!(paramObject instanceof IMappingConsumer$MappingSet$Pair))
/*    */         return false;  }
/*    */     catch (RuntimeException runtimeException) { throw b(null); }
/*  9 */      IMappingConsumer$MappingSet$Pair iMappingConsumer$MappingSet$Pair = (IMappingConsumer$MappingSet$Pair)paramObject; try { if (Objects.equal(this.from, iMappingConsumer$MappingSet$Pair.from)) try { if (Objects.equal(this.to, iMappingConsumer$MappingSet$Pair.to)); } catch (RuntimeException runtimeException) { throw b(null); }   } catch (RuntimeException runtimeException) { throw b(null); }  return false; } public String toString() { return String.format("%s -> %s", new Object[] { this.from, this.to }); }
/* 10 */   public int hashCode() { return Objects.hashCode(new Object[] { this.from, this.to }); }
/*    */ 
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\mapping\IMappingConsumer$MappingSet$Pair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */