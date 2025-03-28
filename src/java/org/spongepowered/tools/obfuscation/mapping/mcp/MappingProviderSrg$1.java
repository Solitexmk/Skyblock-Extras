/*    */ package org.spongepowered.tools.obfuscation.mapping.mcp;class MappingProviderSrg$1 implements LineProcessor<String> {
/*    */   final BiMap val$packageMap;
/*    */   final BiMap val$classMap;
/*    */   final BiMap val$fieldMap;
/*    */   
/*    */   public boolean processLine(String paramString) throws IOException {
/*    */     try {
/*  8 */       if (!Strings.isNullOrEmpty(paramString)) try { if (!paramString.startsWith("#")) {
/*    */             String str = paramString.substring(0, 2);
/*    */ 
/*    */ 
/*    */             
/* 13 */             String[] arrayOfString = paramString.substring(4).split(" "); try { if (str.equals("PK")) { packageMap.forcePut(arrayOfString[0], arrayOfString[1]); }
/*    */               else { try { if (str.equals("CL")) { classMap.forcePut(arrayOfString[0], arrayOfString[1]); }
/*    */                   else { 
/*    */                     try { if (str.equals("FD"))
/* 17 */                       { fieldMap.forcePut((new MappingFieldSrg(arrayOfString[0])).copy(), (new MappingFieldSrg(arrayOfString[1])).copy()); } else { try { if (str.equals("MD")) { methodMap.forcePut(new MappingMethod(arrayOfString[0], arrayOfString[1]), new MappingMethod(arrayOfString[2], arrayOfString[3])); } else { throw new MixinException("Invalid SRG file: " + input); }  } catch (IOException iOException) { throw b(null); }  }  } catch (IOException iOException) { throw b(null); }
/*    */                      }
/*    */                    }
/*    */                 catch (IOException iOException)
/*    */                 { throw b(null); }
/*    */                  }
/*    */                }
/*    */             catch (IOException iOException)
/*    */             { throw b(null); }
/*    */             
/*    */             return true;
/*    */           } 
/*    */           return true; }
/*    */         catch (IOException iOException)
/*    */         { throw b(null); }
/*    */          
/*    */     } catch (IOException iOException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return true;
/*    */   }
/*    */   
/*    */   final BiMap val$methodMap;
/*    */   final File val$input;
/*    */   final MappingProviderSrg this$0;
/*    */   
/*    */   private static IOException b(IOException paramIOException) {
/*    */     return paramIOException;
/*    */   }
/*    */   
/*    */   public String getResult() {
/*    */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\mapping\mcp\MappingProviderSrg$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */