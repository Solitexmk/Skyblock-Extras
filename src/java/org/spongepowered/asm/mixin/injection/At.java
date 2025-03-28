package org.spongepowered.asm.mixin.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface At {
  String id() default "";
  
  String value();
  
  String slice() default "";
  
  At$Shift shift() default At$Shift.NONE;
  
  int by() default 0;
  
  String[] args() default {};
  
  String target() default "";
  
  int ordinal() default -1;
  
  int opcode() default -1;
  
  boolean remap() default true;
}


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\injection\At.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */