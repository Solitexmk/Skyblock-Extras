/*    */ package org.spongepowered.asm.mixin.transformer;
/*    */ class MixinInfo$Reloaded extends MixinInfo$State { private final MixinInfo$State previous;
/*    */   final MixinInfo this$0;
/*    */   
/*    */   private static MixinReloadException b(MixinReloadException paramMixinReloadException) {
/*    */     return paramMixinReloadException;
/*    */   }
/*    */   
/*    */   protected void validateChanges(MixinInfo$SubType paramMixinInfo$SubType, List<ClassInfo> paramList) { 
/* 10 */     try { if (!this.syntheticInnerClasses.equals(this.previous.syntheticInnerClasses))
/*    */         throw new MixinReloadException(MixinInfo.this, "Cannot change inner classes");  } catch (MixinReloadException mixinReloadException) { throw b(null); }  try { if (!this.interfaces.equals(this.previous.interfaces))
/*    */         throw new MixinReloadException(MixinInfo.this, "Cannot change interfaces");  } catch (MixinReloadException mixinReloadException) { throw b(null); }  try { if (!(new HashSet(this.softImplements)).equals(new HashSet<InterfaceInfo>(this.previous.softImplements)))
/* 13 */         throw new MixinReloadException(MixinInfo.this, "Cannot change soft interfaces");  } catch (MixinReloadException mixinReloadException) { throw b(null); }  List<ClassInfo> list = MixinInfo.this.readTargetClasses(this.classNode, true); try { if (!(new HashSet(list)).equals(new HashSet<ClassInfo>(paramList)))
/*    */         throw new MixinReloadException(MixinInfo.this, "Cannot change target classes");  } catch (MixinReloadException mixinReloadException) { throw b(null); }
/* 15 */      int i = MixinInfo.this.readPriority(this.classNode); try { if (i != MixinInfo.this.getPriority())
/* 16 */         throw new MixinReloadException(MixinInfo.this, "Cannot change mixin priority");  } catch (MixinReloadException mixinReloadException) { throw b(null); }  } MixinInfo$Reloaded(MixinInfo$State paramMixinInfo$State, byte[] paramArrayOfbyte) { super(paramMixinInfo, paramArrayOfbyte, paramMixinInfo$State.getClassInfo()); this.previous = paramMixinInfo$State; }
/*    */    }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MixinInfo$Reloaded.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */