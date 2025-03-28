/*    */ package org.spongepowered.asm.mixin.injection.struct;
/*    */ public final class InjectorGroupInfo$Map extends HashMap<String, InjectorGroupInfo> { private static final long serialVersionUID = 1L; public InjectorGroupInfo parseGroup(AnnotationNode paramAnnotationNode, String paramString) { 
/*  3 */     try { if (paramAnnotationNode == null)
/*    */       {
/*    */         
/*  6 */         return NO_GROUP; }  } catch (RuntimeException runtimeException) { throw b(null); }
/*    */ 
/*    */     
/*  9 */     String str = (String)Annotations.getValue(paramAnnotationNode, "name");
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
/* 24 */     try { if (str == null || str.isEmpty()) str = paramString;  } catch (RuntimeException runtimeException) { throw b(null); }  InjectorGroupInfo injectorGroupInfo = forName(str); Integer integer1 = (Integer)Annotations.getValue(paramAnnotationNode, "min"); try { if (integer1 != null) try { if (integer1.intValue() != -1) injectorGroupInfo.setMinRequired(integer1.intValue());  } catch (RuntimeException runtimeException) { throw b(null); }   } catch (RuntimeException runtimeException) { throw b(null); }  Integer integer2 = (Integer)Annotations.getValue(paramAnnotationNode, "max"); try { if (integer2 != null) try { if (integer2.intValue() != -1)
/*    */             injectorGroupInfo.setMaxAllowed(integer2.intValue());  } catch (RuntimeException runtimeException) { throw b(null); }   } catch (RuntimeException runtimeException) { throw b(null); }  return injectorGroupInfo; } public void validateAll() throws InjectionValidationException { for (InjectorGroupInfo injectorGroupInfo : values())
/* 26 */       injectorGroupInfo.validate();  }
/* 27 */   public InjectorGroupInfo parseGroup(MethodNode paramMethodNode, String paramString) { return parseGroup(Annotations.getInvisible(paramMethodNode, Group.class), paramString); } private static final InjectorGroupInfo NO_GROUP = new InjectorGroupInfo("NONE", true); public InjectorGroupInfo forName(String paramString) { InjectorGroupInfo injectorGroupInfo = super.get(paramString); if (injectorGroupInfo == null) { injectorGroupInfo = new InjectorGroupInfo(paramString); put(paramString, injectorGroupInfo); }  return injectorGroupInfo; } public InjectorGroupInfo get(Object paramObject) { return forName(paramObject.toString()); }
/*    */ 
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\struct\InjectorGroupInfo$Map.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */