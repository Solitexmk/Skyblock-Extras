/*    */ package org.spongepowered.asm.mixin.injection.struct;public class InjectorGroupInfo { public InjectorGroupInfo validate() throws InjectionValidationException { 
/*  2 */     try { if (this.members.size() == 0)
/*    */       {
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
/* 39 */         return this; }  } catch (InjectionValidationException injectionValidationException) { throw b(null); }
/*    */      int i = 0; for (InjectionInfo injectionInfo : this.members)
/*    */       i += injectionInfo.getInjectedCallbackCount();  int j = getMinRequired();
/*    */     int k = getMaxAllowed();
/*    */     
/*    */     try { if (i < j)
/* 45 */         throw new InjectionValidationException(this, String.format("expected %d invocation(s) but only %d succeeded", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }));  } catch (InjectionValidationException injectionValidationException) { throw b(null); }
/*    */     
/*    */     try {
/*    */       if (i > k)
/*    */         throw new InjectionValidationException(this, String.format("maximum of %d invocation(s) allowed but %d succeeded", new Object[] { Integer.valueOf(k), Integer.valueOf(i) })); 
/*    */     } catch (InjectionValidationException injectionValidationException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return this; }
/*    */ 
/*    */   
/*    */   public void setMinRequired(int paramInt) {
/*    */     // Byte code:
/*    */     //   0: iload_1
/*    */     //   1: iconst_1
/*    */     //   2: if_icmpge -> 45
/*    */     //   5: new java/lang/IllegalArgumentException
/*    */     //   8: dup
/*    */     //   9: new java/lang/StringBuilder
/*    */     //   12: dup
/*    */     //   13: invokespecial <init> : ()V
/*    */     //   16: ldc 'Cannot set zero or negative value for injector group min count. Attempted to set min='
/*    */     //   18: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   21: iload_1
/*    */     //   22: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*    */     //   25: ldc ' on '
/*    */     //   27: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   30: aload_0
/*    */     //   31: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */     //   34: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   37: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   40: athrow
/*    */     //   41: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*    */     //   44: athrow
/*    */     //   45: aload_0
/*    */     //   46: getfield minCallbackCount : I
/*    */     //   49: ifle -> 114
/*    */     //   52: aload_0
/*    */     //   53: getfield minCallbackCount : I
/*    */     //   56: iload_1
/*    */     //   57: if_icmpeq -> 114
/*    */     //   60: goto -> 67
/*    */     //   63: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*    */     //   66: athrow
/*    */     //   67: ldc 'mixin'
/*    */     //   69: invokestatic getLogger : (Ljava/lang/String;)Lorg/apache/logging/log4j/Logger;
/*    */     //   72: ldc 'Conflicting min value '{}' on @Group({}), previously specified {}'
/*    */     //   74: iconst_3
/*    */     //   75: anewarray java/lang/Object
/*    */     //   78: dup
/*    */     //   79: iconst_0
/*    */     //   80: iload_1
/*    */     //   81: invokestatic valueOf : (I)Ljava/lang/Integer;
/*    */     //   84: aastore
/*    */     //   85: dup
/*    */     //   86: iconst_1
/*    */     //   87: aload_0
/*    */     //   88: getfield name : Ljava/lang/String;
/*    */     //   91: aastore
/*    */     //   92: dup
/*    */     //   93: iconst_2
/*    */     //   94: aload_0
/*    */     //   95: getfield minCallbackCount : I
/*    */     //   98: invokestatic valueOf : (I)Ljava/lang/Integer;
/*    */     //   101: aastore
/*    */     //   102: invokeinterface warn : (Ljava/lang/String;[Ljava/lang/Object;)V
/*    */     //   107: goto -> 114
/*    */     //   110: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*    */     //   113: athrow
/*    */     //   114: aload_0
/*    */     //   115: aload_0
/*    */     //   116: getfield minCallbackCount : I
/*    */     //   119: iload_1
/*    */     //   120: invokestatic max : (II)I
/*    */     //   123: putfield minCallbackCount : I
/*    */     //   126: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #1	-> 0
/*    */     //   #9	-> 5
/*    */     //   #17	-> 45
/*    */     //   #30	-> 67
/*    */     //   #16	-> 98
/*    */     //   #3	-> 102
/*    */     //   #15	-> 114
/*    */     //   #21	-> 126
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   0	41	41	java/lang/IllegalArgumentException
/*    */     //   45	60	63	java/lang/IllegalArgumentException
/*    */     //   52	107	110	java/lang/IllegalArgumentException
/*    */   }
/*    */   
/*    */   public int getMaxAllowed() {
/*    */     return Math.min(this.maxCallbackCount, 2147483647);
/*    */   }
/*    */   
/*    */   public Collection<InjectionInfo> getMembers() {
/*    */     return Collections.unmodifiableCollection(this.members);
/*    */   }
/*    */   
/*    */   private int maxCallbackCount = Integer.MAX_VALUE;
/*    */   
/*    */   InjectorGroupInfo(String paramString, boolean paramBoolean) {
/*    */     this.name = paramString;
/*    */     this.isDefault = paramBoolean;
/*    */   }
/*    */   
/*    */   private final List<InjectionInfo> members = new ArrayList<InjectionInfo>();
/*    */   
/*    */   public int getMinRequired() {
/*    */     return Math.max(this.minCallbackCount, 1);
/*    */   }
/*    */   
/*    */   private int minCallbackCount = -1;
/*    */   private final String name;
/*    */   private final boolean isDefault;
/*    */   
/*    */   public String toString() {
/*    */     return String.format("@Group(name=%s, min=%d, max=%d)", new Object[] { getName(), Integer.valueOf(getMinRequired()), Integer.valueOf(getMaxAllowed()) });
/*    */   }
/*    */   
/*    */   public InjectorGroupInfo add(InjectionInfo paramInjectionInfo) {
/*    */     this.members.add(paramInjectionInfo);
/*    */     return this;
/*    */   }
/*    */   
/*    */   public boolean isDefault() {
/*    */     return this.isDefault;
/*    */   }
/*    */   
/*    */   public InjectorGroupInfo(String paramString) {
/*    */     this(paramString, false);
/*    */   }
/*    */   
/*    */   public String getName() {
/*    */     return this.name;
/*    */   }
/*    */   
/*    */   public void setMaxAllowed(int paramInt) {
/*    */     // Byte code:
/*    */     //   0: iload_1
/*    */     //   1: iconst_1
/*    */     //   2: if_icmpge -> 45
/*    */     //   5: new java/lang/IllegalArgumentException
/*    */     //   8: dup
/*    */     //   9: new java/lang/StringBuilder
/*    */     //   12: dup
/*    */     //   13: invokespecial <init> : ()V
/*    */     //   16: ldc 'Cannot set zero or negative value for injector group max count. Attempted to set max='
/*    */     //   18: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   21: iload_1
/*    */     //   22: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*    */     //   25: ldc ' on '
/*    */     //   27: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   30: aload_0
/*    */     //   31: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */     //   34: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   37: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   40: athrow
/*    */     //   41: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*    */     //   44: athrow
/*    */     //   45: aload_0
/*    */     //   46: getfield maxCallbackCount : I
/*    */     //   49: ldc 2147483647
/*    */     //   51: if_icmpge -> 116
/*    */     //   54: aload_0
/*    */     //   55: getfield maxCallbackCount : I
/*    */     //   58: iload_1
/*    */     //   59: if_icmpeq -> 116
/*    */     //   62: goto -> 69
/*    */     //   65: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*    */     //   68: athrow
/*    */     //   69: ldc 'mixin'
/*    */     //   71: invokestatic getLogger : (Ljava/lang/String;)Lorg/apache/logging/log4j/Logger;
/*    */     //   74: ldc 'Conflicting max value '{}' on @Group({}), previously specified {}'
/*    */     //   76: iconst_3
/*    */     //   77: anewarray java/lang/Object
/*    */     //   80: dup
/*    */     //   81: iconst_0
/*    */     //   82: iload_1
/*    */     //   83: invokestatic valueOf : (I)Ljava/lang/Integer;
/*    */     //   86: aastore
/*    */     //   87: dup
/*    */     //   88: iconst_1
/*    */     //   89: aload_0
/*    */     //   90: getfield name : Ljava/lang/String;
/*    */     //   93: aastore
/*    */     //   94: dup
/*    */     //   95: iconst_2
/*    */     //   96: aload_0
/*    */     //   97: getfield maxCallbackCount : I
/*    */     //   100: invokestatic valueOf : (I)Ljava/lang/Integer;
/*    */     //   103: aastore
/*    */     //   104: invokeinterface warn : (Ljava/lang/String;[Ljava/lang/Object;)V
/*    */     //   109: goto -> 116
/*    */     //   112: invokestatic b : (Ljava/lang/Exception;)Ljava/lang/Exception;
/*    */     //   115: athrow
/*    */     //   116: aload_0
/*    */     //   117: aload_0
/*    */     //   118: getfield maxCallbackCount : I
/*    */     //   121: iload_1
/*    */     //   122: invokestatic min : (II)I
/*    */     //   125: putfield maxCallbackCount : I
/*    */     //   128: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #43	-> 0
/*    */     //   #28	-> 5
/*    */     //   #46	-> 45
/*    */     //   #18	-> 69
/*    */     //   #38	-> 100
/*    */     //   #27	-> 104
/*    */     //   #42	-> 116
/*    */     //   #44	-> 128
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   0	41	41	java/lang/IllegalArgumentException
/*    */     //   45	62	65	java/lang/IllegalArgumentException
/*    */     //   54	109	112	java/lang/IllegalArgumentException
/*    */   }
/*    */   
/*    */   private static Exception b(Exception paramException) {
/*    */     return paramException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\struct\InjectorGroupInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */