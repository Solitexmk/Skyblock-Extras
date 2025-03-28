/*    */ package org.spongepowered.tools.obfuscation;
/*    */ public final class TargetMap extends HashMap<TypeReference, Set<TypeReference>> { private static final long serialVersionUID = 1L;
/*    */   private final String sessionId;
/*    */   
/*  5 */   public String getSessionId() { return this.sessionId; }
/*    */   public void write(boolean paramBoolean) { ObjectOutputStream objectOutputStream = null; FileOutputStream fileOutputStream = null; try { File file = getSessionFile(this.sessionId); try { if (paramBoolean) file.deleteOnExit();  } catch (IOException iOException) { throw b(null); }  fileOutputStream = new FileOutputStream(file, true); objectOutputStream = new ObjectOutputStream(fileOutputStream); objectOutputStream.writeObject(this); } catch (Exception exception) { exception.printStackTrace(); } finally { try { if (objectOutputStream != null)
/*  7 */           try { objectOutputStream.close(); } catch (IOException iOException) { iOException.printStackTrace(); }   } catch (RuntimeException runtimeException) { throw b(null); }  }  } public Collection<TypeReference> getMixinsTargeting(TypeReference paramTypeReference) { return Collections.unmodifiableCollection(getMixinsFor(paramTypeReference)); }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static TargetMap create(String paramString) {
/* 15 */     if (paramString != null) {
/*    */       File file = getSessionFile(paramString);
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
/*    */       if (file.exists())
/* 81 */       { TargetMap targetMap = read(file);
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
/* 93 */         try { if (targetMap != null)
/*    */             return targetMap;  } catch (RuntimeException runtimeException) { throw b(null); }  } 
/*    */     }  return new TargetMap(); } public void readImports(File paramFile) throws IOException { try { if (!paramFile.isFile())
/*    */         return;  }
/*    */     catch (IOException iOException) { throw b(null); }
/* 98 */      for (String str : Files.readLines(paramFile, Charset.defaultCharset())) { String[] arrayOfString = str.split("\t"); try { if (arrayOfString.length == 2) addMixin(arrayOfString[1], arrayOfString[0]);  } catch (IOException iOException) { throw b(null); }  }  } public void addMixin(TypeHandle paramTypeHandle1, TypeHandle paramTypeHandle2) { addMixin(paramTypeHandle1.getReference(), paramTypeHandle2.getReference()); }
/* 99 */   private static TargetMap read(File paramFile) { ObjectInputStream objectInputStream = null; FileInputStream fileInputStream = null; try { fileInputStream = new FileInputStream(paramFile); objectInputStream = new ObjectInputStream(fileInputStream); return (TargetMap)objectInputStream.readObject(); } catch (Exception exception) { exception.printStackTrace(); } finally { try { if (objectInputStream != null)
/*    */           try {
/*    */             objectInputStream.close();
/*    */           } catch (IOException iOException) {
/*    */             iOException.printStackTrace();
/*    */           }   }
/*    */       catch (RuntimeException runtimeException)
/*    */       { throw b(null); }
/*    */        }
/*    */     
/*    */     return null; }
/*    */ 
/*    */   
/*    */   private TargetMap(String paramString) {
/*    */     this.sessionId = paramString;
/*    */   }
/*    */   
/*    */   private static File getSessionFile(String paramString) {
/*    */     File file = new File(System.getProperty("java.io.tmpdir"));
/*    */     return new File(file, String.format("mixin-targetdb-%s.tmp", new Object[] { paramString }));
/*    */   }
/*    */   
/*    */   public Collection<TypeReference> getMixinsTargeting(TypeHandle paramTypeHandle) {
/*    */     return getMixinsTargeting(paramTypeHandle.getReference());
/*    */   }
/*    */   
/*    */   private Set<TypeReference> getMixinsFor(TypeReference paramTypeReference) {
/*    */     Set<TypeReference> set = get(paramTypeReference);
/*    */     if (set == null) {
/*    */       set = new HashSet<TypeReference>();
/*    */       put(paramTypeReference, set);
/*    */     } 
/*    */     return set;
/*    */   }
/*    */   
/*    */   public void addMixin(String paramString1, String paramString2) {
/*    */     addMixin(new TypeReference(paramString1), new TypeReference(paramString2));
/*    */   }
/*    */   
/*    */   public void addMixin(TypeReference paramTypeReference1, TypeReference paramTypeReference2) {
/*    */     Set<TypeReference> set = getMixinsFor(paramTypeReference1);
/*    */     set.add(paramTypeReference2);
/*    */   }
/*    */   
/*    */   public void registerTargets(AnnotatedMixin paramAnnotatedMixin) {
/*    */     registerTargets(paramAnnotatedMixin.getTargets(), paramAnnotatedMixin.getHandle());
/*    */   }
/*    */   
/*    */   public void registerTargets(List<TypeHandle> paramList, TypeHandle paramTypeHandle) {
/*    */     for (TypeHandle typeHandle : paramList)
/*    */       addMixin(typeHandle, paramTypeHandle); 
/*    */   }
/*    */   
/*    */   private TargetMap() {
/*    */     this(String.valueOf(System.currentTimeMillis()));
/*    */   }
/*    */   
/*    */   public Collection<TypeReference> getMixinsTargeting(TypeElement paramTypeElement) {
/*    */     return getMixinsTargeting(new TypeHandle(paramTypeElement));
/*    */   }
/*    */   
/*    */   private static Exception b(Exception paramException) {
/*    */     return paramException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\TargetMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */