/*  1 */ package org.spongepowered.tools.obfuscation.struct;public class Message { private Diagnostic.Kind kind; private CharSequence msg; private final Element element; private final AnnotationMirror annotation; private final AnnotationValue value; public Diagnostic.Kind getKind() { return this.kind; }
/*    */    public Message(Diagnostic.Kind paramKind, CharSequence paramCharSequence, Element paramElement, AnnotationMirror paramAnnotationMirror) {
/*  3 */     this(paramKind, paramCharSequence, paramElement, paramAnnotationMirror, (AnnotationValue)null);
/*    */   }
/*    */   
/*  6 */   public Message setKind(Diagnostic.Kind paramKind) { this.kind = paramKind;
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
/* 27 */     return this; } public AnnotationMirror getAnnotation() { return this.annotation; }
/* 28 */   public Message setMsg(CharSequence paramCharSequence) { this.msg = paramCharSequence; return this; } public Message sendTo(Messager paramMessager) { try { if (this.value != null) { paramMessager.printMessage(this.kind, this.msg, this.element, this.annotation, this.value); } else { try { if (this.annotation != null) { paramMessager.printMessage(this.kind, this.msg, this.element, this.annotation); } else { try { if (this.element != null) { paramMessager.printMessage(this.kind, this.msg, this.element); } else { paramMessager.printMessage(this.kind, this.msg); }  } catch (RuntimeException runtimeException) { throw b(null); }  }
/*    */            }
/*    */         catch (RuntimeException runtimeException) { throw b(null); }
/*    */          }
/*    */        }
/*    */     catch (RuntimeException runtimeException) { throw b(null); }
/* 34 */      return this; }
/*    */ 
/*    */   
/*    */   public Message(Diagnostic.Kind paramKind, CharSequence paramCharSequence) {
/*    */     this(paramKind, paramCharSequence, (Element)null, (AnnotationMirror)null, (AnnotationValue)null);
/*    */   }
/*    */   
/*    */   public CharSequence getMsg() {
/*    */     return this.msg;
/*    */   }
/*    */   
/*    */   public Message(Diagnostic.Kind paramKind, CharSequence paramCharSequence, Element paramElement) {
/*    */     this(paramKind, paramCharSequence, paramElement, (AnnotationMirror)null, (AnnotationValue)null);
/*    */   }
/*    */   
/*    */   public Message(Diagnostic.Kind paramKind, CharSequence paramCharSequence, Element paramElement, AnnotationHandle paramAnnotationHandle) {
/*    */     this(paramKind, paramCharSequence, paramElement, paramAnnotationHandle.asMirror(), (AnnotationValue)null);
/*    */   }
/*    */   
/*    */   public Message(Diagnostic.Kind paramKind, CharSequence paramCharSequence, Element paramElement, AnnotationHandle paramAnnotationHandle, AnnotationValue paramAnnotationValue) {
/*    */     this(paramKind, paramCharSequence, paramElement, paramAnnotationHandle.asMirror(), paramAnnotationValue);
/*    */   }
/*    */   
/*    */   public Element getElement() {
/*    */     return this.element;
/*    */   }
/*    */   
/*    */   public Message(Diagnostic.Kind paramKind, CharSequence paramCharSequence, Element paramElement, AnnotationMirror paramAnnotationMirror, AnnotationValue paramAnnotationValue) {
/*    */     this.kind = paramKind;
/*    */     this.msg = paramCharSequence;
/*    */     this.element = paramElement;
/*    */     this.annotation = paramAnnotationMirror;
/*    */     this.value = paramAnnotationValue;
/*    */   }
/*    */   
/*    */   public AnnotationValue getValue() {
/*    */     return this.value;
/*    */   }
/*    */   
/*    */   private static RuntimeException b(RuntimeException paramRuntimeException) {
/*    */     return paramRuntimeException;
/*    */   } }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\tools\obfuscation\struct\Message.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */