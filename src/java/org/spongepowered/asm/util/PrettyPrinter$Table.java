/*  1 */ package org.spongepowered.asm.util;class PrettyPrinter$Table implements PrettyPrinter$IVariableWidthEntry { public int getWidth() { String str = toString();
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
/*    */     try {  }
/*    */     catch (RuntimeException runtimeException)
/* 15 */     { throw b(null); }  return (str != null) ? str.length() : 0; }
/*    */ 
/*    */   
/*    */   int colSpacing = 2; boolean addHeader = true;
/*    */   PrettyPrinter$Column add(PrettyPrinter$Column paramPrettyPrinter$Column) {
/*    */     this.columns.add(paramPrettyPrinter$Column);
/*    */     return paramPrettyPrinter$Column;
/*    */   }
/*    */   String getFormat() {
/*    */     return this.format;
/*    */   }
/*    */   PrettyPrinter$Column addColumn(String paramString) {
/*    */     return add(new PrettyPrinter$Column(this, paramString));
/*    */   }
/*    */   final List<PrettyPrinter$Row> rows = new ArrayList<PrettyPrinter$Row>();
/*    */   
/*    */   PrettyPrinter$Row addRow(Object... paramVarArgs) {
/*    */     return add(new PrettyPrinter$Row(this, paramVarArgs));
/*    */   }
/*    */   
/*    */   void setColSpacing(int paramInt) {
/*    */     this.colSpacing = Math.max(0, paramInt);
/*    */     updateFormat();
/*    */   }
/*    */   
/*    */   public String toString() { int i = 0;
/* 41 */     String[] arrayOfString = new String[this.columns.size()]; byte b = 0; while (true) { try { if (b < this.columns.size()) { try { arrayOfString[b] = ((PrettyPrinter$Column)this.columns.get(b)).toString(); } catch (RuntimeException runtimeException) { throw b(null); }  i |= !arrayOfString[b].isEmpty() ? 1 : 0; }  }
/*    */       catch (RuntimeException runtimeException) { throw b(null); }
/*    */        break; }
/*    */      try {  }
/*    */     catch (RuntimeException runtimeException) { throw b(null); }
/*    */      return (i != 0) ? String.format(this.format, (Object[])arrayOfString) : null; } Object[] getTitles() { ArrayList<String> arrayList = new ArrayList(); for (PrettyPrinter$Column prettyPrinter$Column : this.columns)
/* 47 */       arrayList.add(prettyPrinter$Column.getTitle());  return arrayList.toArray(); } PrettyPrinter$Column addColumn(PrettyPrinter$Alignment paramPrettyPrinter$Alignment, int paramInt, String paramString) { return add(new PrettyPrinter$Column(this, paramPrettyPrinter$Alignment, paramInt, paramString)); } String format = "%s";
/* 48 */   void updateFormat() { String str = Strings.repeat(" ", this.colSpacing); StringBuilder stringBuilder = new StringBuilder(); boolean bool = false; for (PrettyPrinter$Column prettyPrinter$Column : this.columns) { try { if (bool)
/*    */           stringBuilder.append(str);  }
/*    */       catch (RuntimeException runtimeException)
/*    */       { throw b(null); }
/*    */       
/*    */       bool = true;
/*    */       stringBuilder.append(prettyPrinter$Column.getFormat()); }
/*    */     
/*    */     this.format = stringBuilder.toString(); }
/*    */ 
/*    */   
/*    */   PrettyPrinter$Table grow(int paramInt) {
/*    */     try {
/*    */       while (this.columns.size() < paramInt)
/*    */         this.columns.add(new PrettyPrinter$Column(this)); 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     updateFormat();
/*    */     return this;
/*    */   }
/*    */   
/*    */   void headerAdded() {
/*    */     this.addHeader = false;
/*    */   }
/*    */   
/*    */   PrettyPrinter$Row add(PrettyPrinter$Row paramPrettyPrinter$Row) {
/*    */     this.rows.add(paramPrettyPrinter$Row);
/*    */     return paramPrettyPrinter$Row;
/*    */   }
/*    */   
/*    */   final List<PrettyPrinter$Column> columns = new ArrayList<PrettyPrinter$Column>();
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\PrettyPrinter$Table.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */