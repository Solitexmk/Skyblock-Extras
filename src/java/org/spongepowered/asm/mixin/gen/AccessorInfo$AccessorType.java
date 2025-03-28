/*    */ package org.spongepowered.asm.mixin.gen;
/*    */ 
/*    */ import com.google.common.collect.ImmutableSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ public enum AccessorInfo$AccessorType {
/*  7 */   FIELD_GETTER((Set)ImmutableSet.of("get", "is")),
/*    */ 
/*    */   
/*    */   FIELD_SETTER((Set)ImmutableSet.of("set")),
/*    */   
/* 12 */   METHOD_PROXY((Set)ImmutableSet.of("call", "invoke"));
/*    */   
/*    */   public String getExpectedPrefixes() {
/*    */     return this.expectedPrefixes.toString();
/*    */   }
/*    */   
/*    */   private static final AccessorInfo$AccessorType[] $VALUES = new AccessorInfo$AccessorType[] { FIELD_GETTER, FIELD_SETTER, METHOD_PROXY };
/*    */   
/*    */   public boolean isExpectedPrefix(String paramString) {
/*    */     return this.expectedPrefixes.contains(paramString);
/*    */   }
/*    */   
/*    */   AccessorInfo$AccessorType(Set<String> paramSet) {
/*    */     this.expectedPrefixes = paramSet;
/*    */   }
/*    */   
/*    */   private final Set<String> expectedPrefixes;
/*    */   
/*    */   abstract AccessorGenerator getGenerator(AccessorInfo paramAccessorInfo);
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\gen\AccessorInfo$AccessorType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */