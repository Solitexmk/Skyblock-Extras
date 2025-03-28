package org.spongepowered.asm.mixin.refmap;

import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.mixin.injection.struct.Target;
import org.spongepowered.asm.mixin.transformer.ext.Extensions;

public interface IMixinContext {
  IMixinInfo getMixin();
  
  Extensions getExtensions();
  
  String getClassName();
  
  String getClassRef();
  
  String getTargetClassRef();
  
  IReferenceMapper getReferenceMapper();
  
  boolean getOption(MixinEnvironment.Option paramOption);
  
  int getPriority();
  
  Target getTargetMethod(MethodNode paramMethodNode);
}


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\refmap\IMixinContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */