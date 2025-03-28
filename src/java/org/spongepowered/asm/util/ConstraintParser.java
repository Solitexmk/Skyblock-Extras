/*    */ package org.spongepowered.asm.util;
/*  2 */ public final class ConstraintParser { private static RuntimeException b(RuntimeException paramRuntimeException) { return paramRuntimeException; } public static ConstraintParser$Constraint parse(AnnotationNode paramAnnotationNode) { String str = Annotations.<String>getValue(paramAnnotationNode, "constraints", "");
/*    */ 
/*    */     
/*  5 */     return parse(str); }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static ConstraintParser$Constraint parse(String paramString) {
/*    */     
/* 15 */     try { if (paramString != null) try { if (paramString.length() != 0) { String[] arrayOfString1 = paramString.replaceAll("\\s", "").toUpperCase().split(";"); ConstraintParser$Constraint constraintParser$Constraint = null; String[] arrayOfString2; int i; byte b; for (arrayOfString2 = arrayOfString1, i = arrayOfString2.length, b = 0; b < i; ) { String str = arrayOfString2[b]; ConstraintParser$Constraint constraintParser$Constraint1 = new ConstraintParser$Constraint(str); if (constraintParser$Constraint == null) { constraintParser$Constraint = constraintParser$Constraint1; } else { constraintParser$Constraint.append(constraintParser$Constraint1); }  }  try {  } catch (RuntimeException runtimeException) { throw b(null); }  return (constraintParser$Constraint != null) ? constraintParser$Constraint : ConstraintParser$Constraint.NONE; }  return ConstraintParser$Constraint.NONE; } catch (RuntimeException runtimeException) { throw b(null); }   } catch (RuntimeException runtimeException) { throw b(null); }
/*    */     
/*    */     return ConstraintParser$Constraint.NONE;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\ConstraintParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */