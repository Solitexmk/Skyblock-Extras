/*    */ package org.spongepowered.asm.util;
/*    */ 
/*    */ class PrettyPrinter$Row implements PrettyPrinter$IVariableWidthEntry {
/*    */   final PrettyPrinter$Table table;
/*    */   final String[] args;
/*    */   
/*    */   public String toString() {
/*  8 */     Object[] arrayOfObject = new Object[this.table.columns.size()];
/*    */     
/* 10 */     for (byte b = 0; b < arrayOfObject.length; ) { PrettyPrinter$Column prettyPrinter$Column = this.table.columns.get(b); try { if (b >= this.args.length) { arrayOfObject[b] = ""; } else { try {  } catch (RuntimeException runtimeException) { throw b(null); }  arrayOfObject[b] = (this.args[b].length() > prettyPrinter$Column.getMaxWidth()) ? this.args[b].substring(0, prettyPrinter$Column.getMaxWidth()) : this.args[b]; }  } catch (RuntimeException runtimeException) { throw b(null); }  }
/* 11 */      return String.format(this.table.format, arrayOfObject); } public int getWidth() { return toString().length(); }
/*    */   
/*    */   public PrettyPrinter$Row(PrettyPrinter$Table paramPrettyPrinter$Table, Object... paramVarArgs) {
/* 14 */     this.table = paramPrettyPrinter$Table.grow(paramVarArgs.length); this.args = new String[paramVarArgs.length];
/* 15 */     byte b = 0; try { while (b < paramVarArgs.length)
/* 16 */       { this.args[b] = paramVarArgs[b].toString(); ((PrettyPrinter$Column)this.table.columns.get(b)).setMinWidth(this.args[b].length());
/* 17 */         b++; }  } catch (RuntimeException runtimeException) { throw b(null); }
/*    */   
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\PrettyPrinter$Row.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */