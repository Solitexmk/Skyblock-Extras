/*    */ package org.spongepowered.asm.mixin.transformer;class InnerClassGenerator$InnerClassInfo extends Remapper { private final String name; private final String originalName; private final MixinInfo owner; private final MixinTargetContext target; private final String ownerName; private final String targetName;
/*  2 */   String getOwnerName() { return this.ownerName; }
/*  3 */   public String mapMethodName(String paramString1, String paramString2, String paramString3) { if (this.ownerName.equalsIgnoreCase(paramString1))
/*  4 */     { ClassInfo$Method classInfo$Method = this.owner.getClassInfo().findMethod(paramString2, paramString3, 10);
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
/* 15 */       try { if (classInfo$Method != null) return classInfo$Method.getName();  } catch (RuntimeException runtimeException) { throw c(null); }  }  return super.mapMethodName(paramString1, paramString2, paramString3); } MixinInfo getOwner() { return this.owner; }
/* 16 */   InnerClassGenerator$InnerClassInfo(String paramString1, String paramString2, MixinInfo paramMixinInfo, MixinTargetContext paramMixinTargetContext) { this.name = paramString1; this.originalName = paramString2;
/*    */ 
/*    */     
/* 19 */     this.owner = paramMixinInfo;
/*    */     this.ownerName = paramMixinInfo.getClassRef();
/* 21 */     this.target = paramMixinTargetContext; this.targetName = paramMixinTargetContext.getTargetClassRef(); }
/* 22 */   String getOriginalName() { return this.originalName; } String getName() { return this.name; }
/* 23 */   public String map(String paramString) { try { if (this.originalName.equals(paramString)) return this.name;  } catch (RuntimeException runtimeException) { throw c(null); }  try { if (this.ownerName.equals(paramString)) return this.targetName;  } catch (RuntimeException runtimeException) { throw c(null); }  return paramString; } byte[] getClassBytes() throws ClassNotFoundException, IOException { return MixinService.getService().getBytecodeProvider().getClassBytes(this.originalName, true); }
/* 24 */   String getTargetName() { return this.targetName; }
/* 25 */   public String toString() { return this.name; } MixinTargetContext getTarget() {
/* 26 */     return this.target;
/*    */   }
/*    */   
/*    */   private static RuntimeException c(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\InnerClassGenerator$InnerClassInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */