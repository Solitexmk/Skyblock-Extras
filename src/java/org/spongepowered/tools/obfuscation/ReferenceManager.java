/*    */ package org.spongepowered.tools.obfuscation;public class ReferenceManager implements IReferenceManager { private final IMixinAnnotationProcessor ap; private final String outRefMapFileName; private final List<ObfuscationEnvironment> environments; private final ReferenceMapper refMapper;
/*    */   private boolean allowConflicts;
/*    */   
/*  4 */   private PrintWriter newWriter(String paramString1, String paramString2) throws IOException { if (paramString1.matches("^.*[\\\\/:].*$")) {
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
/*    */       
/* 56 */       File file = new File(paramString1);
/*    */       
/*    */       file.getParentFile().mkdirs();
/*    */       this.ap.printMessage(Diagnostic.Kind.NOTE, "Writing " + paramString2 + " to " + file.getAbsolutePath());
/* 60 */       return new PrintWriter(file);
/*    */     } 
/*    */ 
/*    */     
/* 64 */     FileObject fileObject = this.ap.getProcessingEnvironment().getFiler().createResource(StandardLocation.CLASS_OUTPUT, "", paramString1, new javax.lang.model.element.Element[0]); this.ap.printMessage(Diagnostic.Kind.NOTE, "Writing " + paramString2 + " to " + (new File(fileObject.toUri())).getAbsolutePath()); return new PrintWriter(fileObject.openWriter()); } public void setAllowConflicts(boolean paramBoolean) { this.allowConflicts = paramBoolean; }
/*    */   public void write() { try {
/*    */       if (this.outRefMapFileName == null)
/*    */         return; 
/*    */     } catch (Exception exception) {
/*    */       throw b(null);
/*    */     } 
/*    */     PrintWriter printWriter = null;
/*    */     
/* 73 */     try { printWriter = newWriter(this.outRefMapFileName, "refmap"); this.refMapper.write(printWriter); } catch (IOException iOException) { iOException.printStackTrace(); } finally { if (printWriter != null) try { printWriter.close(); } catch (Exception exception) {}  }  } protected void addMapping(ObfuscationType paramObfuscationType, String paramString1, String paramString2, String paramString3) { String str = this.refMapper.addMapping(paramObfuscationType.getKey(), paramString1, paramString2, paramString3); try { if (paramObfuscationType.isDefault()) this.refMapper.addMapping(null, paramString1, paramString2, paramString3);  } catch (ReferenceManager$ReferenceConflictException referenceManager$ReferenceConflictException) { throw b(null); }  try { if (!this.allowConflicts) try { if (str != null) try { if (!str.equals(paramString3))
/* 74 */                 throw new ReferenceManager$ReferenceConflictException(str, paramString3);  } catch (ReferenceManager$ReferenceConflictException referenceManager$ReferenceConflictException) { throw b(null); }
/*    */               }
/*    */         catch (ReferenceManager$ReferenceConflictException referenceManager$ReferenceConflictException)
/*    */         { throw b(null); }
/*    */           }
/*    */     catch (ReferenceManager$ReferenceConflictException referenceManager$ReferenceConflictException)
/*    */     { throw b(null); }
/*    */      }
/*    */ 
/*    */   
/*    */   public ReferenceMapper getMapper() {
/*    */     return this.refMapper;
/*    */   }
/*    */   
/*    */   public ReferenceManager(IMixinAnnotationProcessor paramIMixinAnnotationProcessor, List<ObfuscationEnvironment> paramList) {
/*    */     this.refMapper = new ReferenceMapper();
/*    */     this.ap = paramIMixinAnnotationProcessor;
/*    */     this.environments = paramList;
/*    */     this.outRefMapFileName = this.ap.getOption("outRefMapFile");
/*    */   }
/*    */   
/*    */   public boolean getAllowConflicts() {
/*    */     return this.allowConflicts;
/*    */   }
/*    */   
/*    */   public void addMethodMapping(String paramString1, String paramString2, MemberInfo paramMemberInfo, ObfuscationData<MappingMethod> paramObfuscationData) {
/*    */     for (ObfuscationEnvironment obfuscationEnvironment : this.environments)
/*    */       MappingMethod mappingMethod = paramObfuscationData.get(obfuscationEnvironment.getType()); 
/*    */   }
/*    */   
/*    */   public void addClassMapping(String paramString1, String paramString2, ObfuscationData<String> paramObfuscationData) {
/*    */     for (ObfuscationEnvironment obfuscationEnvironment : this.environments)
/*    */       String str = paramObfuscationData.get(obfuscationEnvironment.getType()); 
/*    */   }
/*    */   
/*    */   public void addFieldMapping(String paramString1, String paramString2, MemberInfo paramMemberInfo, ObfuscationData<MappingField> paramObfuscationData) {
/*    */     for (ObfuscationEnvironment obfuscationEnvironment : this.environments)
/*    */       MappingField mappingField = paramObfuscationData.get(obfuscationEnvironment.getType()); 
/*    */   }
/*    */   
/*    */   public void addMethodMapping(String paramString1, String paramString2, ObfuscationData<MappingMethod> paramObfuscationData) {
/*    */     for (ObfuscationEnvironment obfuscationEnvironment : this.environments)
/*    */       MappingMethod mappingMethod = paramObfuscationData.get(obfuscationEnvironment.getType()); 
/*    */   }
/*    */   
/*    */   private static Exception b(Exception paramException) {
/*    */     return paramException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\ReferenceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */