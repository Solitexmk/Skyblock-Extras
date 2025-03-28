package org.spongepowered.tools.obfuscation.interfaces;

import java.util.List;
import org.spongepowered.tools.obfuscation.ObfuscationEnvironment;
import org.spongepowered.tools.obfuscation.mapping.IMappingConsumer;

public interface IObfuscationManager {
  void init();
  
  IObfuscationDataProvider getDataProvider();
  
  IReferenceManager getReferenceManager();
  
  IMappingConsumer createMappingConsumer();
  
  List<ObfuscationEnvironment> getEnvironments();
  
  void writeMappings();
  
  void writeReferences();
}


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\interfaces\IObfuscationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */