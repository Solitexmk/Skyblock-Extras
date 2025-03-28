package org.spongepowered.asm.service;

import java.net.URL;

public interface IClassProvider {
  URL[] getClassPath();
  
  Class<?> findClass(String paramString) throws ClassNotFoundException;
  
  Class<?> findClass(String paramString, boolean paramBoolean) throws ClassNotFoundException;
  
  Class<?> findAgentClass(String paramString, boolean paramBoolean) throws ClassNotFoundException;
}


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\service\IClassProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */