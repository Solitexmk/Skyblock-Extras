/*    */ package org.spongepowered.asm.mixin.injection.modify;public class LocalVariableDiscriminator { private final boolean argsOnly; private final int ordinal; private final int index; private final Set<String> names; private final boolean print; public Set<String> getNames() {
/*  2 */     return this.names;
/*    */   }
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
/*    */   public LocalVariableDiscriminator(boolean paramBoolean1, int paramInt1, int paramInt2, Set<String> paramSet, boolean paramBoolean2) {
/* 30 */     this.argsOnly = paramBoolean1;
/*    */ 
/*    */     
/*    */     this.ordinal = paramInt1;
/*    */     
/*    */     this.index = paramInt2;
/*    */     
/*    */     this.names = Collections.unmodifiableSet(paramSet);
/*    */     
/* 39 */     this.print = paramBoolean2;
/*    */   }
/*    */   public int getOrdinal() { return this.ordinal; } public int findLocal(Type paramType, boolean paramBoolean, Target paramTarget, AbstractInsnNode paramAbstractInsnNode) { try {
/*    */       return findLocal(new LocalVariableDiscriminator$Context(paramType, paramBoolean, paramTarget, paramAbstractInsnNode));
/*    */     } catch (InvalidImplicitDiscriminatorException invalidImplicitDiscriminatorException) {
/*    */       return -2;
/*    */     }  } private int findExplicitLocal(LocalVariableDiscriminator$Context paramLocalVariableDiscriminator$Context) { for (int i = paramLocalVariableDiscriminator$Context.baseArgIndex; i < paramLocalVariableDiscriminator$Context.locals.length; )
/* 46 */     { LocalVariableDiscriminator$Context$Local localVariableDiscriminator$Context$Local = paramLocalVariableDiscriminator$Context.locals[i]; try { if (localVariableDiscriminator$Context$Local != null)
/*    */           try { if (localVariableDiscriminator$Context$Local.type.equals(paramLocalVariableDiscriminator$Context.returnType))
/*    */               try { if (this.ordinal > -1) { try { if (this.ordinal == localVariableDiscriminator$Context$Local.ord)
/* 49 */                       return i;  } catch (InvalidImplicitDiscriminatorException invalidImplicitDiscriminatorException) { throw b(null); }  } else { try { if (this.index >= paramLocalVariableDiscriminator$Context.baseArgIndex) { try { if (this.index == i)
/*    */                           return i;  } catch (InvalidImplicitDiscriminatorException invalidImplicitDiscriminatorException) { throw b(null); }  } else { try { if (this.names.contains(localVariableDiscriminator$Context$Local.name))
/*    */                           return i;  } catch (InvalidImplicitDiscriminatorException invalidImplicitDiscriminatorException) { throw b(null); }  }  } catch (InvalidImplicitDiscriminatorException invalidImplicitDiscriminatorException) { throw b(null); }  }  } catch (InvalidImplicitDiscriminatorException invalidImplicitDiscriminatorException) { throw b(null); }
/*    */                 }
/* 53 */           catch (InvalidImplicitDiscriminatorException invalidImplicitDiscriminatorException) { throw b(null); }   } catch (InvalidImplicitDiscriminatorException invalidImplicitDiscriminatorException) { throw b(null); }
/* 54 */        i++; }  return -1; }
/* 55 */   public boolean printLVT() { return this.print; } public int findLocal(LocalVariableDiscriminator$Context paramLocalVariableDiscriminator$Context) { try { if (isImplicit(paramLocalVariableDiscriminator$Context)) return findImplicitLocal(paramLocalVariableDiscriminator$Context);  } catch (InvalidImplicitDiscriminatorException invalidImplicitDiscriminatorException) { throw b(null); }  return findExplicitLocal(paramLocalVariableDiscriminator$Context); } private int findImplicitLocal(LocalVariableDiscriminator$Context paramLocalVariableDiscriminator$Context) { int i = 0; byte b = 0;
/*    */     for (int j = paramLocalVariableDiscriminator$Context.baseArgIndex; j < paramLocalVariableDiscriminator$Context.locals.length; ) {
/*    */       LocalVariableDiscriminator$Context$Local localVariableDiscriminator$Context$Local = paramLocalVariableDiscriminator$Context.locals[j];
/*    */       try {
/*    */         if (localVariableDiscriminator$Context$Local != null)
/*    */           try {
/*    */             if (localVariableDiscriminator$Context$Local.type.equals(paramLocalVariableDiscriminator$Context.returnType)) {
/*    */               b++;
/*    */               i = j;
/*    */             } 
/*    */           } catch (InvalidImplicitDiscriminatorException invalidImplicitDiscriminatorException) {
/*    */             throw b(null);
/*    */           }  
/*    */       } catch (InvalidImplicitDiscriminatorException invalidImplicitDiscriminatorException) {
/*    */         throw b(null);
/*    */       } 
/*    */     } 
/*    */     try {
/*    */       if (b == 1)
/*    */         return i; 
/*    */     } catch (InvalidImplicitDiscriminatorException invalidImplicitDiscriminatorException) {
/*    */       throw b(null);
/*    */     } 
/*    */     throw new InvalidImplicitDiscriminatorException("Found " + b + " candidate variables but exactly 1 is required."); }
/*    */ 
/*    */   
/*    */   public boolean isArgsOnly() {
/*    */     return this.argsOnly;
/*    */   }
/*    */   
/*    */   public static LocalVariableDiscriminator parse(AnnotationNode paramAnnotationNode) {
/*    */     boolean bool1 = ((Boolean)Annotations.getValue(paramAnnotationNode, "argsOnly", Boolean.FALSE)).booleanValue();
/*    */     int i = ((Integer)Annotations.getValue(paramAnnotationNode, "ordinal", Integer.valueOf(-1))).intValue();
/*    */     int j = ((Integer)Annotations.getValue(paramAnnotationNode, "index", Integer.valueOf(-1))).intValue();
/*    */     boolean bool2 = ((Boolean)Annotations.getValue(paramAnnotationNode, "print", Boolean.FALSE)).booleanValue();
/*    */     HashSet<String> hashSet = new HashSet();
/*    */     List list = (List)Annotations.getValue(paramAnnotationNode, "name", null);
/*    */     try {
/*    */       if (list != null)
/*    */         hashSet.addAll(list); 
/*    */     } catch (InvalidImplicitDiscriminatorException invalidImplicitDiscriminatorException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return new LocalVariableDiscriminator(bool1, i, j, hashSet, bool2);
/*    */   }
/*    */   
/*    */   public int getIndex() {
/*    */     return this.index;
/*    */   }
/*    */   
/*    */   protected boolean isImplicit(LocalVariableDiscriminator$Context paramLocalVariableDiscriminator$Context) {
/*    */     try {
/*    */       if (this.ordinal < 0)
/*    */         try {
/*    */           if (this.index < paramLocalVariableDiscriminator$Context.baseArgIndex)
/*    */             try {
/*    */               if (this.names.isEmpty());
/*    */             } catch (InvalidImplicitDiscriminatorException invalidImplicitDiscriminatorException) {
/*    */               throw b(null);
/*    */             }  
/*    */         } catch (InvalidImplicitDiscriminatorException invalidImplicitDiscriminatorException) {
/*    */           throw b(null);
/*    */         }  
/*    */     } catch (InvalidImplicitDiscriminatorException invalidImplicitDiscriminatorException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return false;
/*    */   }
/*    */   
/*    */   public boolean hasNames() {
/*    */     try {
/*    */     
/*    */     } catch (InvalidImplicitDiscriminatorException invalidImplicitDiscriminatorException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return !this.names.isEmpty();
/*    */   }
/*    */   
/*    */   private static InvalidImplicitDiscriminatorException b(InvalidImplicitDiscriminatorException paramInvalidImplicitDiscriminatorException) {
/*    */     return paramInvalidImplicitDiscriminatorException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\modify\LocalVariableDiscriminator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */