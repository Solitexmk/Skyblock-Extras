/*    */ package org.spongepowered.asm.util;class PrettyPrinter$Column { private final PrettyPrinter$Table table; private PrettyPrinter$Alignment align; private int minWidth; void setMinWidth(int paramInt) {
/*    */     
/*  3 */     try { if (paramInt > this.minWidth)
/*    */       
/*    */       { 
/*    */         
/*  7 */         this.minWidth = paramInt;
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
/* 38 */         updateFormat(); }  } catch (RuntimeException runtimeException) { throw b(null); }
/*    */   
/*    */   } private int maxWidth; private int size; private String title; private String format;
/*    */   void setWidth(int paramInt) {
/*    */     
/*    */     try { if (paramInt > this.size)
/*    */       { this.size = paramInt;
/* 45 */         updateFormat(); }  } catch (RuntimeException runtimeException) { throw b(null); }  } void setMaxWidth(int paramInt) { this.size = Math.min(this.size, this.maxWidth); this.maxWidth = Math.max(1, paramInt); updateFormat(); }
/* 46 */   PrettyPrinter$Column(PrettyPrinter$Table paramPrettyPrinter$Table, PrettyPrinter$Alignment paramPrettyPrinter$Alignment, int paramInt, String paramString) { this(paramPrettyPrinter$Table, paramString);
/*    */     this.align = paramPrettyPrinter$Alignment;
/*    */     this.size = paramInt; }
/*    */ 
/*    */   
/*    */   public String toString() {
/*    */     try {
/*    */       if (this.title.length() > this.maxWidth)
/*    */         return this.title.substring(0, this.maxWidth); 
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     return this.title;
/*    */   }
/*    */   
/*    */   PrettyPrinter$Column(PrettyPrinter$Table paramPrettyPrinter$Table, String paramString) {
/*    */     this(paramPrettyPrinter$Table);
/*    */     this.title = paramString;
/*    */     this.minWidth = paramString.length();
/*    */     updateFormat();
/*    */   }
/*    */   
/*    */   void setTitle(String paramString) {
/*    */     this.title = paramString;
/*    */     setWidth(paramString.length());
/*    */   }
/*    */   
/*    */   private void updateFormat() {
/*    */     try {
/*    */     
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     int i = Math.min(this.maxWidth, (this.size == 0) ? this.minWidth : this.size);
/*    */     try {
/*    */     
/*    */     } catch (RuntimeException runtimeException) {
/*    */       throw b(null);
/*    */     } 
/*    */     this.format = "%" + ((this.align == PrettyPrinter$Alignment.RIGHT) ? "" : "-") + i + "s";
/*    */     this.table.updateFormat();
/*    */   }
/*    */   
/*    */   int getMaxWidth() {
/*    */     return this.maxWidth;
/*    */   }
/*    */   
/*    */   void setAlignment(PrettyPrinter$Alignment paramPrettyPrinter$Alignment) {
/*    */     this.align = paramPrettyPrinter$Alignment;
/*    */     updateFormat();
/*    */   }
/*    */   
/*    */   PrettyPrinter$Column(PrettyPrinter$Table paramPrettyPrinter$Table) {
/*    */     this.align = PrettyPrinter$Alignment.LEFT;
/*    */     this.minWidth = 1;
/*    */     this.maxWidth = Integer.MAX_VALUE;
/*    */     this.size = 0;
/*    */     this.title = "";
/*    */     this.format = "%s";
/*    */     this.table = paramPrettyPrinter$Table;
/*    */   }
/*    */   
/*    */   String getFormat() {
/*    */     return this.format;
/*    */   }
/*    */   
/*    */   String getTitle() {
/*    */     return this.title;
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\PrettyPrinter$Column.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */