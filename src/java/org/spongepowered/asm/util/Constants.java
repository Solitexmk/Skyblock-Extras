/* 1 */ package org.spongepowered.asm.util;public abstract class Constants { public static final File DEBUG_OUTPUT_DIR = new File(".mixin.out");
/*   */   
/* 3 */   public static final String MIXIN_PACKAGE = Mixin.class.getPackage().getName();
/* 4 */   public static final String MIXIN_PACKAGE_REF = MIXIN_PACKAGE.replace('.', '/');
/*   */   public static final String CTOR = "<init>";
/*   */   public static final String CLINIT = "<clinit>";
/*   */   public static final String IMAGINARY_SUPER = "super$";
/*   */   public static final String DEBUG_OUTPUT_PATH = ".mixin.out";
/*   */   public static final String STRING = "Ljava/lang/String;";
/*   */   public static final String OBJECT = "Ljava/lang/Object;";
/*   */   public static final String CLASS = "Ljava/lang/Class;";
/*   */   public static final String SYNTHETIC_PACKAGE = "org.spongepowered.asm.synthetic";
/*   */   public static final char UNICODE_SNOWMAN = '☃'; }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\as\\util\Constants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */