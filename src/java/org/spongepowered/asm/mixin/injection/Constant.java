package org.spongepowered.asm.mixin.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Constant {
  boolean nullValue() default false;
  
  int intValue() default 0;
  
  float floatValue() default 0.0F;
  
  long longValue() default 0L;
  
  double doubleValue() default 0.0D;
  
  String stringValue() default "";
  
  Class<?> classValue() default Object.class;
  
  int ordinal() default -1;
  
  String slice() default "";
  
  Constant$Condition[] expandZeroConditions() default {};
  
  boolean log() default false;
}


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\Constant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */