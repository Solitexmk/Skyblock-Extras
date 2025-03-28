package org.spongepowered.asm.util;

interface ClassSignature$IToken {
  public static final String WILDCARDS = "+-";
  
  String asType();
  
  String asBound();
  
  ClassSignature$Token asToken();
  
  ClassSignature$IToken setArray(boolean paramBoolean);
  
  ClassSignature$IToken setWildcard(char paramChar);
}


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\ClassSignature$IToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */