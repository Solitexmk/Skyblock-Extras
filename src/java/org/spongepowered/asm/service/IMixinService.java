package org.spongepowered.asm.service;

import java.io.InputStream;
import java.util.Collection;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.util.ReEntranceLock;

public interface IMixinService {
  String getName();
  
  boolean isValid();
  
  void prepare();
  
  MixinEnvironment.Phase getInitialPhase();
  
  void init();
  
  void beginPhase();
  
  void checkEnv(Object paramObject);
  
  ReEntranceLock getReEntranceLock();
  
  IClassProvider getClassProvider();
  
  IClassBytecodeProvider getBytecodeProvider();
  
  Collection<String> getPlatformAgents();
  
  InputStream getResourceAsStream(String paramString);
  
  void registerInvalidClass(String paramString);
  
  boolean isClassLoaded(String paramString);
  
  String getClassRestrictions(String paramString);
  
  Collection<ITransformer> getTransformers();
  
  String getSideName();
}


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\service\IMixinService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */