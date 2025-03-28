/*     */ package org.spongepowered.asm.mixin.transformer;
/*     */ import java.util.ArrayList;
/*     */ import org.spongepowered.asm.mixin.MixinEnvironment;
/*     */ import org.spongepowered.asm.mixin.extensibility.IMixinErrorHandler;
/*     */ import org.spongepowered.asm.mixin.transformer.throwables.InvalidMixinException;
/*     */ import org.spongepowered.asm.util.perf.Profiler;
/*     */ 
/*     */ public class MixinTransformer extends TreeTransformer {
/*   9 */   private int transformedCount = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private IHotSwap initHotSwapper(MixinEnvironment paramMixinEnvironment) {
/*     */     
/*  18 */     try { if (!paramMixinEnvironment.getOption(MixinEnvironment.Option.HOT_SWAP))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 152 */         return null; }  } catch (Throwable throwable1) { throw b(null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 186 */       logger.info("Attempting to load Hot-Swap agent");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 323 */       Class<?> clazz = Class.forName("org.spongepowered.tools.agent.MixinAgent"); Constructor<?> constructor = clazz.getDeclaredConstructor(new Class[] { MixinTransformer.class }); return (IHotSwap)constructor.newInstance(new Object[] { this });
/*     */     } catch (Throwable throwable) {} logger.info("Hot-swap agent could not be loaded, hot swapping of mixins won't work. {}: {}", new Object[] { throwable.getClass().getSimpleName(), throwable.getMessage() }); return null;
/*     */   } public String getName() { return getClass().getName(); } private final List<MixinConfig> pendingConfigs = new ArrayList<MixinConfig>(); private final String sessionId = UUID.randomUUID().toString(); private void handleMixinError(String paramString, InvalidMixinException paramInvalidMixinException, MixinEnvironment paramMixinEnvironment, MixinTransformer$ErrorPhase paramMixinTransformer$ErrorPhase) throws Error { this.errorState = true; IMixinInfo iMixinInfo = paramInvalidMixinException.getMixin(); try { if (iMixinInfo == null) { logger.error("InvalidMixinException has no mixin!", (Throwable)paramInvalidMixinException); throw paramInvalidMixinException; }
/*     */        }
/*     */     catch (Error error) { throw b(null); }
/*     */      IMixinConfig iMixinConfig = iMixinInfo.getConfig(); MixinEnvironment.Phase phase = iMixinInfo.getPhase(); try {
/*     */     
/*     */     } catch (Error error) {
/*     */       throw b(null);
/*     */     }  IMixinErrorHandler.ErrorAction errorAction = iMixinConfig.isRequired() ? IMixinErrorHandler.ErrorAction.ERROR : IMixinErrorHandler.ErrorAction.WARN; try {
/*     */       if (paramMixinEnvironment.getOption(MixinEnvironment.Option.DEBUG_VERBOSE))
/* 334 */         (new PrettyPrinter()).add("Invalid Mixin").centre().hr('-').kvWidth(10).kv("Action", paramMixinTransformer$ErrorPhase.name()).kv("Mixin", iMixinInfo.getClassName()).kv("Config", iMixinConfig.getName()).kv("Phase", phase).hr('-').add("    %s", new Object[] { paramInvalidMixinException.getClass().getName() }).hr('-').addWrapped("    %s", new Object[] { paramInvalidMixinException.getMessage() }).hr('-').add((Throwable)paramInvalidMixinException, 8).trace(errorAction.logLevel); 
/*     */     } catch (Error error) {
/*     */       throw b(null);
/*     */     }  for (IMixinErrorHandler iMixinErrorHandler : getErrorHandlers(iMixinInfo.getPhase())) {
/*     */       IMixinErrorHandler.ErrorAction errorAction1 = paramMixinTransformer$ErrorPhase.onError(iMixinErrorHandler, paramString, paramInvalidMixinException, iMixinInfo, errorAction); if (errorAction1 != null)
/*     */         errorAction = errorAction1; 
/*     */     }  
/*     */     try { logger.log(errorAction.logLevel, paramMixinTransformer$ErrorPhase.getLogMessage(paramString, paramInvalidMixinException, iMixinInfo), (Throwable)paramInvalidMixinException); this.errorState = false;
/* 342 */       if (errorAction == IMixinErrorHandler.ErrorAction.ERROR)
/*     */         throw new MixinApplyError(paramMixinTransformer$ErrorPhase.getErrorMessage(iMixinInfo, iMixinConfig, phase), paramInvalidMixinException);  } catch (Error error) { throw b(null); }  } private void selectConfigs(MixinEnvironment paramMixinEnvironment) { for (Iterator<Config> iterator = Mixins.getConfigs().iterator(); iterator.hasNext(); ) { Config config = iterator.next(); try { MixinConfig mixinConfig = config.get(); try { if (mixinConfig.select(paramMixinEnvironment)) { iterator.remove(); logger.log(this.verboseLoggingLevel, "Selecting config {}", new Object[] { mixinConfig }); mixinConfig.onSelect(); this.pendingConfigs.add(mixinConfig); }  } catch (Exception exception) { throw b(null); }  }
/*     */       catch (Exception exception) { logger.warn(String.format("Failed to select mixin config: %s", new Object[] { config }), exception); }
/*     */        }
/*     */      Collections.sort(this.pendingConfigs); }
/*     */   MixinTransformer() { MixinEnvironment mixinEnvironment = MixinEnvironment.getCurrentEnvironment(); Object object = mixinEnvironment.getActiveTransformer(); try { if (object instanceof ITransformer)
/*     */         throw new MixinException("Terminating MixinTransformer instance " + this);  }
/*     */     catch (org.spongepowered.asm.mixin.transformer.ext.extensions.ExtensionCheckClass.ValidationFailedException validationFailedException) { throw b(null); }
/* 350 */      mixinEnvironment.setActiveTransformer((ITransformer)this); this.lock = this.service.getReEntranceLock(); this.extensions = new Extensions(this); this.hotSwapper = initHotSwapper(mixinEnvironment); this.postProcessor = new MixinPostProcessor(); this.extensions.add((IClassGenerator)new ArgsClassGenerator()); this.extensions.add(new InnerClassGenerator()); this.extensions.add((IExtension)new ExtensionClassExporter(mixinEnvironment)); this.extensions.add((IExtension)new ExtensionCheckClass()); this.extensions.add((IExtension)new ExtensionCheckInterfaces()); this.profiler = MixinEnvironment.getProfiler(); } private byte[] writeClass(TargetClassContext paramTargetClassContext) { return writeClass(paramTargetClassContext.getClassName(), paramTargetClassContext.getClassNode(), paramTargetClassContext.isExportForced()); } private boolean errorState = false; private byte[] writeClass(String paramString, ClassNode paramClassNode, boolean paramBoolean) { Profiler.Section section = this.profiler.begin("write"); byte[] arrayOfByte = writeClass(paramClassNode); section.end(); this.extensions.export(this.currentEnvironment, paramString, paramBoolean, arrayOfByte); return arrayOfByte; }
/*     */   public boolean isDelegationExcluded() { return true; }
/*     */   private int prepareConfigs(MixinEnvironment paramMixinEnvironment) { int i = 0; IHotSwap iHotSwap = this.hotSwapper; for (MixinConfig mixinConfig : this.pendingConfigs) { try { mixinConfig.addListener(this.postProcessor); if (iHotSwap != null)
/*     */           mixinConfig.addListener(new MixinTransformer$1(this, iHotSwap));  } catch (InvalidMixinException invalidMixinException) { throw b(null); }  }  for (MixinConfig mixinConfig : this.pendingConfigs) { try { logger.log(this.verboseLoggingLevel, "Preparing {} ({})", new Object[] { mixinConfig, Integer.valueOf(mixinConfig.getDeclaredMixinCount()) }); mixinConfig.prepare(); i += mixinConfig.getMixinCount(); continue; } catch (InvalidMixinException invalidMixinException) { handleMixinPrepareError(mixinConfig, invalidMixinException, paramMixinEnvironment); continue; } catch (Exception exception) {} String str = exception.getMessage(); logger.error("Error encountered whilst initialising mixin config '" + mixinConfig.getName() + "': " + str, exception); }  for (MixinConfig mixinConfig : this.pendingConfigs) { IMixinConfigPlugin iMixinConfigPlugin = mixinConfig.getPlugin(); try { if (iMixinConfigPlugin == null); } catch (InvalidMixinException invalidMixinException) { throw b(null); }  }  for (MixinConfig mixinConfig : this.pendingConfigs) { try { mixinConfig.postInitialise(); continue; } catch (InvalidMixinException invalidMixinException) { handleMixinPrepareError(mixinConfig, invalidMixinException, paramMixinEnvironment); continue; } catch (Exception exception) {} String str = exception.getMessage(); logger.error("Error encountered during mixin config postInit step'" + mixinConfig.getName() + "': " + str, exception); }
/*     */      this.configs.addAll(this.pendingConfigs); Collections.sort(this.configs); this.pendingConfigs.clear(); return i; }
/*     */   public List<String> reload(String paramString, byte[] paramArrayOfbyte) { try { if (this.lock.getDepth() > 0)
/*     */         throw new MixinApplyError("Cannot reload mixin if re-entrant lock entered");  }
/*     */     catch (org.spongepowered.asm.mixin.transformer.ext.extensions.ExtensionCheckClass.ValidationFailedException validationFailedException) { throw b(null); }
/*     */      ArrayList<String> arrayList = new ArrayList(); for (MixinConfig mixinConfig : this.configs)
/*     */       arrayList.addAll(mixinConfig.reloadMixin(paramString, paramArrayOfbyte));  return arrayList; }
/*     */   private final List<MixinConfig> configs = new ArrayList<MixinConfig>();
/* 361 */   private void dumpClassOnFailure(String paramString, byte[] paramArrayOfbyte, MixinEnvironment paramMixinEnvironment) { if (paramMixinEnvironment.getOption(MixinEnvironment.Option.DUMP_TARGET_ON_FAILURE)) { ExtensionClassExporter extensionClassExporter = (ExtensionClassExporter)this.extensions.getExtension(ExtensionClassExporter.class); extensionClassExporter.dumpClass(paramString.replace('.', '/') + ".target", paramArrayOfbyte); }  } private void apply(TargetClassContext paramTargetClassContext) { paramTargetClassContext.applyMixins(); } private void checkSelect(MixinEnvironment paramMixinEnvironment) { try { if (this.currentEnvironment != paramMixinEnvironment) { select(paramMixinEnvironment); return; }  } catch (org.spongepowered.asm.mixin.transformer.ext.extensions.ExtensionCheckClass.ValidationFailedException validationFailedException) { throw b(null); }  int i = Mixins.getUnvisitedCount(); try { if (i > 0) try { if (this.transformedCount == 0) select(paramMixinEnvironment);  } catch (org.spongepowered.asm.mixin.transformer.ext.extensions.ExtensionCheckClass.ValidationFailedException validationFailedException) { throw b(null); }   } catch (org.spongepowered.asm.mixin.transformer.ext.extensions.ExtensionCheckClass.ValidationFailedException validationFailedException) { throw b(null); }  }
/* 362 */   private List<IMixinErrorHandler> getErrorHandlers(MixinEnvironment.Phase paramPhase) { ArrayList<IMixinErrorHandler> arrayList = new ArrayList(); for (String str : Mixins.getErrorHandlerClasses()) { try { logger.info("Instancing error handler class {}", new Object[] { str }); Class<IMixinErrorHandler> clazz = this.service.getClassProvider().findClass(str, true); IMixinErrorHandler iMixinErrorHandler = clazz.newInstance(); try { if (iMixinErrorHandler != null)
/*     */             arrayList.add(iMixinErrorHandler);  } catch (Throwable throwable) { throw b(null); }  } catch (Throwable throwable) {} }  return arrayList; } public synchronized byte[] transformClassBytes(String paramString1, String paramString2, byte[] paramArrayOfbyte) { try { if (paramString2 != null)
/*     */         try { if (!this.errorState) { MixinEnvironment mixinEnvironment = MixinEnvironment.getCurrentEnvironment(); if (paramArrayOfbyte == null) { for (IClassGenerator iClassGenerator : this.extensions.getGenerators()) { Profiler.Section section1 = this.profiler.begin(new String[] { "generator", iClassGenerator.getClass().getSimpleName().toLowerCase() }); paramArrayOfbyte = iClassGenerator.generate(paramString2); }  return paramArrayOfbyte; }  boolean bool = this.lock.push().check(); Profiler.Section section = this.profiler.begin("mixin"); if (!bool)
/*     */               try { checkSelect(mixinEnvironment); } catch (Exception exception) { this.lock.pop(); section.end(); throw new MixinException(exception); }   try { if (this.postProcessor.canTransform(paramString2)) { Profiler.Section section1 = this.profiler.begin("postprocessor"); byte[] arrayOfByte1 = this.postProcessor.transformClassBytes(paramString1, paramString2, paramArrayOfbyte); section1.end(); this.extensions.export(mixinEnvironment, paramString2, false, arrayOfByte1); byte[] arrayOfByte2 = arrayOfByte1; }  SortedSet sortedSet = null; boolean bool1 = false; for (MixinConfig mixinConfig : this.configs) { if (mixinConfig.packageMatch(paramString2))
/*     */                   bool1 = true;  }  try { if (bool1)
/*     */                   throw new NoClassDefFoundError(String.format("%s is a mixin class and cannot be referenced directly", new Object[] { paramString2 }));  } catch (Exception exception) { throw b(null); }  try { if (sortedSet != null) { try { if (bool) { logger.warn("Re-entrance detected, this will cause serious problems.", (Throwable)new MixinException()); throw new MixinApplyError("Re-entrance error."); }  } catch (Exception exception) { throw b(null); }  try { if (this.hotSwapper != null)
/*     */                       this.hotSwapper.registerTargetClass(paramString2, paramArrayOfbyte);  } catch (Exception exception) { throw b(null); }  try { Profiler.Section section1 = this.profiler.begin("read"); ClassNode classNode = readClass(paramArrayOfbyte, true); TargetClassContext targetClassContext = new TargetClassContext(mixinEnvironment, this.extensions, this.sessionId, paramString2, classNode, sortedSet); section1.end(); paramArrayOfbyte = applyMixins(mixinEnvironment, targetClassContext); this.transformedCount++; } catch (InvalidMixinException invalidMixinException) { dumpClassOnFailure(paramString2, paramArrayOfbyte, mixinEnvironment); handleMixinApplyError(paramString2, invalidMixinException, mixinEnvironment); }  }  }
/*     */               catch (Exception exception) { throw b(null); }
/*     */                return paramArrayOfbyte; }
/* 371 */             catch (Throwable throwable) { throwable.printStackTrace(); dumpClassOnFailure(paramString2, paramArrayOfbyte, mixinEnvironment); throw new MixinTransformerError("An unexpected critical error was encountered", throwable); }
/*     */             finally
/*     */             { this.lock.pop();
/*     */               section.end(); }
/*     */              }
/*     */           
/*     */           return paramArrayOfbyte; }
/*     */         catch (Exception exception)
/*     */         { throw b(null); }
/*     */           }
/*     */     catch (Exception exception)
/*     */     { throw b(null); }
/*     */     
/*     */     return paramArrayOfbyte; }
/*     */ 
/*     */   
/*     */   private Level verboseLoggingLevel = Level.DEBUG;
/*     */   
/*     */   private void select(MixinEnvironment paramMixinEnvironment) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: aload_1
/*     */     //   2: getstatic org/spongepowered/asm/mixin/MixinEnvironment$Option.DEBUG_VERBOSE : Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;
/*     */     //   5: invokevirtual getOption : (Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;)Z
/*     */     //   8: ifeq -> 21
/*     */     //   11: getstatic org/apache/logging/log4j/Level.INFO : Lorg/apache/logging/log4j/Level;
/*     */     //   14: goto -> 24
/*     */     //   17: invokestatic b : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
/*     */     //   20: athrow
/*     */     //   21: getstatic org/apache/logging/log4j/Level.DEBUG : Lorg/apache/logging/log4j/Level;
/*     */     //   24: putfield verboseLoggingLevel : Lorg/apache/logging/log4j/Level;
/*     */     //   27: aload_0
/*     */     //   28: getfield transformedCount : I
/*     */     //   31: ifle -> 76
/*     */     //   34: getstatic org/spongepowered/asm/mixin/transformer/MixinTransformer.logger : Lorg/apache/logging/log4j/Logger;
/*     */     //   37: aload_0
/*     */     //   38: getfield verboseLoggingLevel : Lorg/apache/logging/log4j/Level;
/*     */     //   41: ldc 'Ending {}, applied {} mixins'
/*     */     //   43: iconst_2
/*     */     //   44: anewarray java/lang/Object
/*     */     //   47: dup
/*     */     //   48: iconst_0
/*     */     //   49: aload_0
/*     */     //   50: getfield currentEnvironment : Lorg/spongepowered/asm/mixin/MixinEnvironment;
/*     */     //   53: aastore
/*     */     //   54: dup
/*     */     //   55: iconst_1
/*     */     //   56: aload_0
/*     */     //   57: getfield transformedCount : I
/*     */     //   60: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   63: aastore
/*     */     //   64: invokeinterface log : (Lorg/apache/logging/log4j/Level;Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   69: goto -> 76
/*     */     //   72: invokestatic b : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
/*     */     //   75: athrow
/*     */     //   76: aload_0
/*     */     //   77: getfield currentEnvironment : Lorg/spongepowered/asm/mixin/MixinEnvironment;
/*     */     //   80: aload_1
/*     */     //   81: if_acmpne -> 93
/*     */     //   84: ldc 'Checking for additional'
/*     */     //   86: goto -> 95
/*     */     //   89: invokestatic b : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
/*     */     //   92: athrow
/*     */     //   93: ldc 'Preparing'
/*     */     //   95: astore_2
/*     */     //   96: getstatic org/spongepowered/asm/mixin/transformer/MixinTransformer.logger : Lorg/apache/logging/log4j/Logger;
/*     */     //   99: aload_0
/*     */     //   100: getfield verboseLoggingLevel : Lorg/apache/logging/log4j/Level;
/*     */     //   103: ldc '{} mixins for {}'
/*     */     //   105: iconst_2
/*     */     //   106: anewarray java/lang/Object
/*     */     //   109: dup
/*     */     //   110: iconst_0
/*     */     //   111: aload_2
/*     */     //   112: aastore
/*     */     //   113: dup
/*     */     //   114: iconst_1
/*     */     //   115: aload_1
/*     */     //   116: aastore
/*     */     //   117: invokeinterface log : (Lorg/apache/logging/log4j/Level;Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   122: aload_0
/*     */     //   123: getfield profiler : Lorg/spongepowered/asm/util/perf/Profiler;
/*     */     //   126: iconst_1
/*     */     //   127: invokevirtual setActive : (Z)V
/*     */     //   130: aload_0
/*     */     //   131: getfield profiler : Lorg/spongepowered/asm/util/perf/Profiler;
/*     */     //   134: new java/lang/StringBuilder
/*     */     //   137: dup
/*     */     //   138: invokespecial <init> : ()V
/*     */     //   141: aload_1
/*     */     //   142: invokevirtual getPhase : ()Lorg/spongepowered/asm/mixin/MixinEnvironment$Phase;
/*     */     //   145: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   148: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   151: ldc ':prepare'
/*     */     //   153: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   156: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   159: invokevirtual mark : (Ljava/lang/String;)V
/*     */     //   162: aload_0
/*     */     //   163: getfield profiler : Lorg/spongepowered/asm/util/perf/Profiler;
/*     */     //   166: ldc 'prepare'
/*     */     //   168: invokevirtual begin : (Ljava/lang/String;)Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   171: astore_3
/*     */     //   172: aload_0
/*     */     //   173: aload_1
/*     */     //   174: invokespecial selectConfigs : (Lorg/spongepowered/asm/mixin/MixinEnvironment;)V
/*     */     //   177: aload_0
/*     */     //   178: getfield extensions : Lorg/spongepowered/asm/mixin/transformer/ext/Extensions;
/*     */     //   181: aload_1
/*     */     //   182: invokevirtual select : (Lorg/spongepowered/asm/mixin/MixinEnvironment;)V
/*     */     //   185: aload_0
/*     */     //   186: aload_1
/*     */     //   187: invokespecial prepareConfigs : (Lorg/spongepowered/asm/mixin/MixinEnvironment;)I
/*     */     //   190: istore #4
/*     */     //   192: aload_0
/*     */     //   193: aload_1
/*     */     //   194: putfield currentEnvironment : Lorg/spongepowered/asm/mixin/MixinEnvironment;
/*     */     //   197: aload_0
/*     */     //   198: iconst_0
/*     */     //   199: putfield transformedCount : I
/*     */     //   202: aload_3
/*     */     //   203: invokevirtual end : ()Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   206: pop
/*     */     //   207: aload_3
/*     */     //   208: invokevirtual getTime : ()J
/*     */     //   211: lstore #5
/*     */     //   213: aload_3
/*     */     //   214: invokevirtual getSeconds : ()D
/*     */     //   217: dstore #7
/*     */     //   219: dload #7
/*     */     //   221: ldc2_w 0.25
/*     */     //   224: dcmpl
/*     */     //   225: ifle -> 368
/*     */     //   228: aload_0
/*     */     //   229: getfield profiler : Lorg/spongepowered/asm/util/perf/Profiler;
/*     */     //   232: ldc 'class.load'
/*     */     //   234: invokevirtual get : (Ljava/lang/String;)Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   237: invokevirtual getTime : ()J
/*     */     //   240: lstore #9
/*     */     //   242: aload_0
/*     */     //   243: getfield profiler : Lorg/spongepowered/asm/util/perf/Profiler;
/*     */     //   246: ldc 'class.transform'
/*     */     //   248: invokevirtual get : (Ljava/lang/String;)Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   251: invokevirtual getTime : ()J
/*     */     //   254: lstore #11
/*     */     //   256: aload_0
/*     */     //   257: getfield profiler : Lorg/spongepowered/asm/util/perf/Profiler;
/*     */     //   260: ldc 'mixin.plugin'
/*     */     //   262: invokevirtual get : (Ljava/lang/String;)Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   265: invokevirtual getTime : ()J
/*     */     //   268: lstore #13
/*     */     //   270: new java/text/DecimalFormat
/*     */     //   273: dup
/*     */     //   274: ldc '###0.000'
/*     */     //   276: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   279: dload #7
/*     */     //   281: invokevirtual format : (D)Ljava/lang/String;
/*     */     //   284: astore #15
/*     */     //   286: new java/text/DecimalFormat
/*     */     //   289: dup
/*     */     //   290: ldc '###0.0'
/*     */     //   292: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   295: lload #5
/*     */     //   297: l2d
/*     */     //   298: iload #4
/*     */     //   300: i2d
/*     */     //   301: ddiv
/*     */     //   302: invokevirtual format : (D)Ljava/lang/String;
/*     */     //   305: astore #16
/*     */     //   307: getstatic org/spongepowered/asm/mixin/transformer/MixinTransformer.logger : Lorg/apache/logging/log4j/Logger;
/*     */     //   310: aload_0
/*     */     //   311: getfield verboseLoggingLevel : Lorg/apache/logging/log4j/Level;
/*     */     //   314: ldc 'Prepared {} mixins in {} sec ({}ms avg) ({}ms load, {}ms transform, {}ms plugin)'
/*     */     //   316: bipush #6
/*     */     //   318: anewarray java/lang/Object
/*     */     //   321: dup
/*     */     //   322: iconst_0
/*     */     //   323: iload #4
/*     */     //   325: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   328: aastore
/*     */     //   329: dup
/*     */     //   330: iconst_1
/*     */     //   331: aload #15
/*     */     //   333: aastore
/*     */     //   334: dup
/*     */     //   335: iconst_2
/*     */     //   336: aload #16
/*     */     //   338: aastore
/*     */     //   339: dup
/*     */     //   340: iconst_3
/*     */     //   341: lload #9
/*     */     //   343: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   346: aastore
/*     */     //   347: dup
/*     */     //   348: iconst_4
/*     */     //   349: lload #11
/*     */     //   351: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   354: aastore
/*     */     //   355: dup
/*     */     //   356: iconst_5
/*     */     //   357: lload #13
/*     */     //   359: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   362: aastore
/*     */     //   363: invokeinterface log : (Lorg/apache/logging/log4j/Level;Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   368: aload_0
/*     */     //   369: getfield profiler : Lorg/spongepowered/asm/util/perf/Profiler;
/*     */     //   372: new java/lang/StringBuilder
/*     */     //   375: dup
/*     */     //   376: invokespecial <init> : ()V
/*     */     //   379: aload_1
/*     */     //   380: invokevirtual getPhase : ()Lorg/spongepowered/asm/mixin/MixinEnvironment$Phase;
/*     */     //   383: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   386: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   389: ldc ':apply'
/*     */     //   391: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   394: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   397: invokevirtual mark : (Ljava/lang/String;)V
/*     */     //   400: aload_0
/*     */     //   401: getfield profiler : Lorg/spongepowered/asm/util/perf/Profiler;
/*     */     //   404: aload_1
/*     */     //   405: getstatic org/spongepowered/asm/mixin/MixinEnvironment$Option.DEBUG_PROFILER : Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;
/*     */     //   408: invokevirtual getOption : (Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;)Z
/*     */     //   411: invokevirtual setActive : (Z)V
/*     */     //   414: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #267	-> 0
/*     */     //   #284	-> 27
/*     */     //   #214	-> 34
/*     */     //   #39	-> 76
/*     */     //   #27	-> 96
/*     */     //   #363	-> 122
/*     */     //   #115	-> 130
/*     */     //   #224	-> 162
/*     */     //   #175	-> 172
/*     */     //   #112	-> 177
/*     */     //   #280	-> 185
/*     */     //   #247	-> 192
/*     */     //   #65	-> 197
/*     */     //   #197	-> 202
/*     */     //   #87	-> 207
/*     */     //   #60	-> 213
/*     */     //   #104	-> 219
/*     */     //   #290	-> 228
/*     */     //   #189	-> 242
/*     */     //   #369	-> 256
/*     */     //   #85	-> 270
/*     */     //   #2	-> 286
/*     */     //   #320	-> 307
/*     */     //   #187	-> 325
/*     */     //   #359	-> 363
/*     */     //   #309	-> 368
/*     */     //   #321	-> 400
/*     */     //   #88	-> 414
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   0	17	17	org/spongepowered/asm/mixin/transformer/ext/extensions/ExtensionCheckClass$ValidationFailedException
/*     */     //   24	69	72	org/spongepowered/asm/mixin/transformer/ext/extensions/ExtensionCheckClass$ValidationFailedException
/*     */     //   76	89	89	org/spongepowered/asm/mixin/transformer/ext/extensions/ExtensionCheckClass$ValidationFailedException
/*     */   }
/*     */   
/*     */   public void audit(MixinEnvironment paramMixinEnvironment) {
/*     */     HashSet<String> hashSet = new HashSet();
/*     */     for (MixinConfig mixinConfig : this.configs)
/*     */       hashSet.addAll(mixinConfig.getUnhandledTargets()); 
/*     */     Logger logger = LogManager.getLogger("mixin/audit");
/*     */     for (String str : hashSet) {
/*     */       try {
/*     */         logger.info("Force-loading class {}", new Object[] { str });
/*     */         this.service.getClassProvider().findClass(str, true);
/*     */         continue;
/*     */       } catch (ClassNotFoundException classNotFoundException) {}
/*     */       logger.error("Could not force-load " + str, classNotFoundException);
/*     */     } 
/*     */     for (MixinConfig mixinConfig : this.configs)
/*     */       Iterator<String> iterator = mixinConfig.getUnhandledTargets().iterator(); 
/*     */     try {
/*     */       if (paramMixinEnvironment.getOption(MixinEnvironment.Option.DEBUG_PROFILER))
/*     */         printProfilerSummary(); 
/*     */     } catch (ClassNotFoundException classNotFoundException) {
/*     */       throw b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void handleMixinPrepareError(MixinConfig paramMixinConfig, InvalidMixinException paramInvalidMixinException, MixinEnvironment paramMixinEnvironment) throws MixinPrepareError {
/*     */     handleMixinError(paramMixinConfig.getName(), paramInvalidMixinException, paramMixinEnvironment, MixinTransformer$ErrorPhase.PREPARE);
/*     */   }
/*     */   
/*     */   static final Logger logger = LogManager.getLogger("mixin");
/*     */   
/*     */   private void printProfilerSummary() {
/*     */     // Byte code:
/*     */     //   0: new java/text/DecimalFormat
/*     */     //   3: dup
/*     */     //   4: ldc '(###0.000'
/*     */     //   6: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   9: astore_1
/*     */     //   10: new java/text/DecimalFormat
/*     */     //   13: dup
/*     */     //   14: ldc '(###0.0'
/*     */     //   16: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   19: astore_2
/*     */     //   20: aload_0
/*     */     //   21: getfield profiler : Lorg/spongepowered/asm/util/perf/Profiler;
/*     */     //   24: iconst_0
/*     */     //   25: iconst_0
/*     */     //   26: invokevirtual printer : (ZZ)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   29: astore_3
/*     */     //   30: aload_0
/*     */     //   31: getfield profiler : Lorg/spongepowered/asm/util/perf/Profiler;
/*     */     //   34: ldc 'mixin.prepare'
/*     */     //   36: invokevirtual get : (Ljava/lang/String;)Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   39: invokevirtual getTotalTime : ()J
/*     */     //   42: lstore #4
/*     */     //   44: aload_0
/*     */     //   45: getfield profiler : Lorg/spongepowered/asm/util/perf/Profiler;
/*     */     //   48: ldc 'mixin.read'
/*     */     //   50: invokevirtual get : (Ljava/lang/String;)Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   53: invokevirtual getTotalTime : ()J
/*     */     //   56: lstore #6
/*     */     //   58: aload_0
/*     */     //   59: getfield profiler : Lorg/spongepowered/asm/util/perf/Profiler;
/*     */     //   62: ldc 'mixin.apply'
/*     */     //   64: invokevirtual get : (Ljava/lang/String;)Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   67: invokevirtual getTotalTime : ()J
/*     */     //   70: lstore #8
/*     */     //   72: aload_0
/*     */     //   73: getfield profiler : Lorg/spongepowered/asm/util/perf/Profiler;
/*     */     //   76: ldc 'mixin.write'
/*     */     //   78: invokevirtual get : (Ljava/lang/String;)Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   81: invokevirtual getTotalTime : ()J
/*     */     //   84: lstore #10
/*     */     //   86: aload_0
/*     */     //   87: getfield profiler : Lorg/spongepowered/asm/util/perf/Profiler;
/*     */     //   90: ldc 'mixin'
/*     */     //   92: invokevirtual get : (Ljava/lang/String;)Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   95: invokevirtual getTotalTime : ()J
/*     */     //   98: lstore #12
/*     */     //   100: aload_0
/*     */     //   101: getfield profiler : Lorg/spongepowered/asm/util/perf/Profiler;
/*     */     //   104: ldc 'class.load'
/*     */     //   106: invokevirtual get : (Ljava/lang/String;)Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   109: invokevirtual getTotalTime : ()J
/*     */     //   112: lstore #14
/*     */     //   114: aload_0
/*     */     //   115: getfield profiler : Lorg/spongepowered/asm/util/perf/Profiler;
/*     */     //   118: ldc 'class.transform'
/*     */     //   120: invokevirtual get : (Ljava/lang/String;)Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   123: invokevirtual getTotalTime : ()J
/*     */     //   126: lstore #16
/*     */     //   128: aload_0
/*     */     //   129: getfield profiler : Lorg/spongepowered/asm/util/perf/Profiler;
/*     */     //   132: ldc 'mixin.debug.export'
/*     */     //   134: invokevirtual get : (Ljava/lang/String;)Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   137: invokevirtual getTotalTime : ()J
/*     */     //   140: lstore #18
/*     */     //   142: lload #12
/*     */     //   144: lload #14
/*     */     //   146: lsub
/*     */     //   147: lload #16
/*     */     //   149: lsub
/*     */     //   150: lload #18
/*     */     //   152: lsub
/*     */     //   153: lstore #20
/*     */     //   155: lload #20
/*     */     //   157: l2d
/*     */     //   158: lload #12
/*     */     //   160: l2d
/*     */     //   161: ddiv
/*     */     //   162: ldc2_w 100.0
/*     */     //   165: dmul
/*     */     //   166: dstore #22
/*     */     //   168: lload #14
/*     */     //   170: l2d
/*     */     //   171: lload #12
/*     */     //   173: l2d
/*     */     //   174: ddiv
/*     */     //   175: ldc2_w 100.0
/*     */     //   178: dmul
/*     */     //   179: dstore #24
/*     */     //   181: lload #16
/*     */     //   183: l2d
/*     */     //   184: lload #12
/*     */     //   186: l2d
/*     */     //   187: ddiv
/*     */     //   188: ldc2_w 100.0
/*     */     //   191: dmul
/*     */     //   192: dstore #26
/*     */     //   194: lload #18
/*     */     //   196: l2d
/*     */     //   197: lload #12
/*     */     //   199: l2d
/*     */     //   200: ddiv
/*     */     //   201: ldc2_w 100.0
/*     */     //   204: dmul
/*     */     //   205: dstore #28
/*     */     //   207: lconst_0
/*     */     //   208: lstore #30
/*     */     //   210: aconst_null
/*     */     //   211: astore #32
/*     */     //   213: aload_0
/*     */     //   214: getfield profiler : Lorg/spongepowered/asm/util/perf/Profiler;
/*     */     //   217: invokevirtual getSections : ()Ljava/util/Collection;
/*     */     //   220: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   225: astore #33
/*     */     //   227: aload #33
/*     */     //   229: invokeinterface hasNext : ()Z
/*     */     //   234: ifeq -> 296
/*     */     //   237: aload #33
/*     */     //   239: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   244: checkcast org/spongepowered/asm/util/perf/Profiler$Section
/*     */     //   247: astore #34
/*     */     //   249: aload #34
/*     */     //   251: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   254: ldc 'class.transform.'
/*     */     //   256: invokevirtual startsWith : (Ljava/lang/String;)Z
/*     */     //   259: ifeq -> 274
/*     */     //   262: aload #34
/*     */     //   264: invokevirtual getTotalTime : ()J
/*     */     //   267: goto -> 275
/*     */     //   270: invokestatic b : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
/*     */     //   273: athrow
/*     */     //   274: lconst_0
/*     */     //   275: lstore #35
/*     */     //   277: lload #35
/*     */     //   279: lload #30
/*     */     //   281: lcmp
/*     */     //   282: ifle -> 293
/*     */     //   285: lload #35
/*     */     //   287: lstore #30
/*     */     //   289: aload #34
/*     */     //   291: astore #32
/*     */     //   293: goto -> 227
/*     */     //   296: aload_3
/*     */     //   297: invokevirtual hr : ()Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   300: ldc 'Summary'
/*     */     //   302: invokevirtual add : (Ljava/lang/String;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   305: invokevirtual hr : ()Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   308: invokevirtual add : ()Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   311: pop
/*     */     //   312: ldc '%9d ms %12s seconds)'
/*     */     //   314: astore #33
/*     */     //   316: aload_3
/*     */     //   317: ldc 'Total mixin time'
/*     */     //   319: aload #33
/*     */     //   321: iconst_2
/*     */     //   322: anewarray java/lang/Object
/*     */     //   325: dup
/*     */     //   326: iconst_0
/*     */     //   327: lload #12
/*     */     //   329: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   332: aastore
/*     */     //   333: dup
/*     */     //   334: iconst_1
/*     */     //   335: aload_1
/*     */     //   336: lload #12
/*     */     //   338: l2d
/*     */     //   339: ldc2_w 0.001
/*     */     //   342: dmul
/*     */     //   343: invokevirtual format : (D)Ljava/lang/String;
/*     */     //   346: aastore
/*     */     //   347: invokevirtual kv : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   350: invokevirtual add : ()Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   353: pop
/*     */     //   354: aload_3
/*     */     //   355: ldc 'Preparing mixins'
/*     */     //   357: aload #33
/*     */     //   359: iconst_2
/*     */     //   360: anewarray java/lang/Object
/*     */     //   363: dup
/*     */     //   364: iconst_0
/*     */     //   365: lload #4
/*     */     //   367: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   370: aastore
/*     */     //   371: dup
/*     */     //   372: iconst_1
/*     */     //   373: aload_1
/*     */     //   374: lload #4
/*     */     //   376: l2d
/*     */     //   377: ldc2_w 0.001
/*     */     //   380: dmul
/*     */     //   381: invokevirtual format : (D)Ljava/lang/String;
/*     */     //   384: aastore
/*     */     //   385: invokevirtual kv : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   388: pop
/*     */     //   389: aload_3
/*     */     //   390: ldc 'Reading input'
/*     */     //   392: aload #33
/*     */     //   394: iconst_2
/*     */     //   395: anewarray java/lang/Object
/*     */     //   398: dup
/*     */     //   399: iconst_0
/*     */     //   400: lload #6
/*     */     //   402: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   405: aastore
/*     */     //   406: dup
/*     */     //   407: iconst_1
/*     */     //   408: aload_1
/*     */     //   409: lload #6
/*     */     //   411: l2d
/*     */     //   412: ldc2_w 0.001
/*     */     //   415: dmul
/*     */     //   416: invokevirtual format : (D)Ljava/lang/String;
/*     */     //   419: aastore
/*     */     //   420: invokevirtual kv : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   423: pop
/*     */     //   424: aload_3
/*     */     //   425: ldc 'Applying mixins'
/*     */     //   427: aload #33
/*     */     //   429: iconst_2
/*     */     //   430: anewarray java/lang/Object
/*     */     //   433: dup
/*     */     //   434: iconst_0
/*     */     //   435: lload #8
/*     */     //   437: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   440: aastore
/*     */     //   441: dup
/*     */     //   442: iconst_1
/*     */     //   443: aload_1
/*     */     //   444: lload #8
/*     */     //   446: l2d
/*     */     //   447: ldc2_w 0.001
/*     */     //   450: dmul
/*     */     //   451: invokevirtual format : (D)Ljava/lang/String;
/*     */     //   454: aastore
/*     */     //   455: invokevirtual kv : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   458: pop
/*     */     //   459: aload_3
/*     */     //   460: ldc 'Writing output'
/*     */     //   462: aload #33
/*     */     //   464: iconst_2
/*     */     //   465: anewarray java/lang/Object
/*     */     //   468: dup
/*     */     //   469: iconst_0
/*     */     //   470: lload #10
/*     */     //   472: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   475: aastore
/*     */     //   476: dup
/*     */     //   477: iconst_1
/*     */     //   478: aload_1
/*     */     //   479: lload #10
/*     */     //   481: l2d
/*     */     //   482: ldc2_w 0.001
/*     */     //   485: dmul
/*     */     //   486: invokevirtual format : (D)Ljava/lang/String;
/*     */     //   489: aastore
/*     */     //   490: invokevirtual kv : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   493: invokevirtual add : ()Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   496: pop
/*     */     //   497: aload_3
/*     */     //   498: ldc 'of which'
/*     */     //   500: ldc ''
/*     */     //   502: invokevirtual kv : (Ljava/lang/String;Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   505: pop
/*     */     //   506: aload_3
/*     */     //   507: ldc 'Time spent loading from disk'
/*     */     //   509: aload #33
/*     */     //   511: iconst_2
/*     */     //   512: anewarray java/lang/Object
/*     */     //   515: dup
/*     */     //   516: iconst_0
/*     */     //   517: lload #14
/*     */     //   519: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   522: aastore
/*     */     //   523: dup
/*     */     //   524: iconst_1
/*     */     //   525: aload_1
/*     */     //   526: lload #14
/*     */     //   528: l2d
/*     */     //   529: ldc2_w 0.001
/*     */     //   532: dmul
/*     */     //   533: invokevirtual format : (D)Ljava/lang/String;
/*     */     //   536: aastore
/*     */     //   537: invokevirtual kv : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   540: pop
/*     */     //   541: aload_3
/*     */     //   542: ldc 'Time spent transforming classes'
/*     */     //   544: aload #33
/*     */     //   546: iconst_2
/*     */     //   547: anewarray java/lang/Object
/*     */     //   550: dup
/*     */     //   551: iconst_0
/*     */     //   552: lload #16
/*     */     //   554: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   557: aastore
/*     */     //   558: dup
/*     */     //   559: iconst_1
/*     */     //   560: aload_1
/*     */     //   561: lload #16
/*     */     //   563: l2d
/*     */     //   564: ldc2_w 0.001
/*     */     //   567: dmul
/*     */     //   568: invokevirtual format : (D)Ljava/lang/String;
/*     */     //   571: aastore
/*     */     //   572: invokevirtual kv : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   575: invokevirtual add : ()Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   578: pop
/*     */     //   579: aload #32
/*     */     //   581: ifnull -> 666
/*     */     //   584: aload_3
/*     */     //   585: ldc 'Worst transformer'
/*     */     //   587: aload #32
/*     */     //   589: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   592: invokevirtual kv : (Ljava/lang/String;Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   595: pop
/*     */     //   596: aload_3
/*     */     //   597: ldc 'Class'
/*     */     //   599: aload #32
/*     */     //   601: invokevirtual getInfo : ()Ljava/lang/String;
/*     */     //   604: invokevirtual kv : (Ljava/lang/String;Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   607: pop
/*     */     //   608: aload_3
/*     */     //   609: ldc 'Time spent'
/*     */     //   611: ldc '%s seconds'
/*     */     //   613: iconst_1
/*     */     //   614: anewarray java/lang/Object
/*     */     //   617: dup
/*     */     //   618: iconst_0
/*     */     //   619: aload #32
/*     */     //   621: invokevirtual getTotalSeconds : ()D
/*     */     //   624: invokestatic valueOf : (D)Ljava/lang/Double;
/*     */     //   627: aastore
/*     */     //   628: invokevirtual kv : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   631: pop
/*     */     //   632: aload_3
/*     */     //   633: ldc 'called'
/*     */     //   635: ldc '%d times'
/*     */     //   637: iconst_1
/*     */     //   638: anewarray java/lang/Object
/*     */     //   641: dup
/*     */     //   642: iconst_0
/*     */     //   643: aload #32
/*     */     //   645: invokevirtual getTotalCount : ()I
/*     */     //   648: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   651: aastore
/*     */     //   652: invokevirtual kv : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   655: invokevirtual add : ()Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   658: pop
/*     */     //   659: goto -> 666
/*     */     //   662: invokestatic b : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
/*     */     //   665: athrow
/*     */     //   666: aload_3
/*     */     //   667: ldc '   Time allocation:     Processing mixins'
/*     */     //   669: ldc '%9d ms %10s%% of total)'
/*     */     //   671: iconst_2
/*     */     //   672: anewarray java/lang/Object
/*     */     //   675: dup
/*     */     //   676: iconst_0
/*     */     //   677: lload #20
/*     */     //   679: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   682: aastore
/*     */     //   683: dup
/*     */     //   684: iconst_1
/*     */     //   685: aload_2
/*     */     //   686: dload #22
/*     */     //   688: invokevirtual format : (D)Ljava/lang/String;
/*     */     //   691: aastore
/*     */     //   692: invokevirtual kv : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   695: pop
/*     */     //   696: aload_3
/*     */     //   697: ldc 'Loading classes'
/*     */     //   699: ldc '%9d ms %10s%% of total)'
/*     */     //   701: iconst_2
/*     */     //   702: anewarray java/lang/Object
/*     */     //   705: dup
/*     */     //   706: iconst_0
/*     */     //   707: lload #14
/*     */     //   709: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   712: aastore
/*     */     //   713: dup
/*     */     //   714: iconst_1
/*     */     //   715: aload_2
/*     */     //   716: dload #24
/*     */     //   718: invokevirtual format : (D)Ljava/lang/String;
/*     */     //   721: aastore
/*     */     //   722: invokevirtual kv : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   725: pop
/*     */     //   726: aload_3
/*     */     //   727: ldc 'Running transformers'
/*     */     //   729: ldc '%9d ms %10s%% of total)'
/*     */     //   731: iconst_2
/*     */     //   732: anewarray java/lang/Object
/*     */     //   735: dup
/*     */     //   736: iconst_0
/*     */     //   737: lload #16
/*     */     //   739: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   742: aastore
/*     */     //   743: dup
/*     */     //   744: iconst_1
/*     */     //   745: aload_2
/*     */     //   746: dload #26
/*     */     //   748: invokevirtual format : (D)Ljava/lang/String;
/*     */     //   751: aastore
/*     */     //   752: invokevirtual kv : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   755: pop
/*     */     //   756: lload #18
/*     */     //   758: lconst_0
/*     */     //   759: lcmp
/*     */     //   760: ifle -> 800
/*     */     //   763: aload_3
/*     */     //   764: ldc 'Exporting classes (debug)'
/*     */     //   766: ldc '%9d ms %10s%% of total)'
/*     */     //   768: iconst_2
/*     */     //   769: anewarray java/lang/Object
/*     */     //   772: dup
/*     */     //   773: iconst_0
/*     */     //   774: lload #18
/*     */     //   776: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   779: aastore
/*     */     //   780: dup
/*     */     //   781: iconst_1
/*     */     //   782: aload_2
/*     */     //   783: dload #28
/*     */     //   785: invokevirtual format : (D)Ljava/lang/String;
/*     */     //   788: aastore
/*     */     //   789: invokevirtual kv : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   792: pop
/*     */     //   793: goto -> 800
/*     */     //   796: invokestatic b : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
/*     */     //   799: athrow
/*     */     //   800: aload_3
/*     */     //   801: invokevirtual add : ()Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   804: pop
/*     */     //   805: aload_0
/*     */     //   806: getfield service : Lorg/spongepowered/asm/service/IMixinService;
/*     */     //   809: invokeinterface getClassProvider : ()Lorg/spongepowered/asm/service/IClassProvider;
/*     */     //   814: ldc 'org.spongepowered.metronome.Agent'
/*     */     //   816: iconst_0
/*     */     //   817: invokeinterface findAgentClass : (Ljava/lang/String;Z)Ljava/lang/Class;
/*     */     //   822: astore #34
/*     */     //   824: aload #34
/*     */     //   826: ldc 'getTimes'
/*     */     //   828: iconst_0
/*     */     //   829: anewarray java/lang/Class
/*     */     //   832: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
/*     */     //   835: astore #35
/*     */     //   837: aload #35
/*     */     //   839: aconst_null
/*     */     //   840: iconst_0
/*     */     //   841: anewarray java/lang/Object
/*     */     //   844: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   847: checkcast java/util/Map
/*     */     //   850: astore #36
/*     */     //   852: aload_3
/*     */     //   853: invokevirtual hr : ()Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   856: ldc 'Transformer Times'
/*     */     //   858: invokevirtual add : (Ljava/lang/String;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   861: invokevirtual hr : ()Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   864: invokevirtual add : ()Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   867: pop
/*     */     //   868: bipush #10
/*     */     //   870: istore #37
/*     */     //   872: aload #36
/*     */     //   874: invokeinterface entrySet : ()Ljava/util/Set;
/*     */     //   879: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   884: astore #38
/*     */     //   886: aload #38
/*     */     //   888: invokeinterface hasNext : ()Z
/*     */     //   893: ifeq -> 931
/*     */     //   896: aload #38
/*     */     //   898: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   903: checkcast java/util/Map$Entry
/*     */     //   906: astore #39
/*     */     //   908: iload #37
/*     */     //   910: aload #39
/*     */     //   912: invokeinterface getKey : ()Ljava/lang/Object;
/*     */     //   917: checkcast java/lang/String
/*     */     //   920: invokevirtual length : ()I
/*     */     //   923: invokestatic max : (II)I
/*     */     //   926: istore #37
/*     */     //   928: goto -> 886
/*     */     //   931: aload #36
/*     */     //   933: invokeinterface entrySet : ()Ljava/util/Set;
/*     */     //   938: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   943: astore #38
/*     */     //   945: aload #38
/*     */     //   947: invokeinterface hasNext : ()Z
/*     */     //   952: ifeq -> 1194
/*     */     //   955: aload #38
/*     */     //   957: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   962: checkcast java/util/Map$Entry
/*     */     //   965: astore #39
/*     */     //   967: aload #39
/*     */     //   969: invokeinterface getKey : ()Ljava/lang/Object;
/*     */     //   974: checkcast java/lang/String
/*     */     //   977: astore #40
/*     */     //   979: lconst_0
/*     */     //   980: lstore #41
/*     */     //   982: aload_0
/*     */     //   983: getfield profiler : Lorg/spongepowered/asm/util/perf/Profiler;
/*     */     //   986: invokevirtual getSections : ()Ljava/util/Collection;
/*     */     //   989: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   994: astore #43
/*     */     //   996: aload #43
/*     */     //   998: invokeinterface hasNext : ()Z
/*     */     //   1003: ifeq -> 1044
/*     */     //   1006: aload #43
/*     */     //   1008: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   1013: checkcast org/spongepowered/asm/util/perf/Profiler$Section
/*     */     //   1016: astore #44
/*     */     //   1018: aload #40
/*     */     //   1020: aload #44
/*     */     //   1022: invokevirtual getInfo : ()Ljava/lang/String;
/*     */     //   1025: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1028: ifeq -> 1041
/*     */     //   1031: aload #44
/*     */     //   1033: invokevirtual getTotalTime : ()J
/*     */     //   1036: lstore #41
/*     */     //   1038: goto -> 1044
/*     */     //   1041: goto -> 996
/*     */     //   1044: lload #41
/*     */     //   1046: lconst_0
/*     */     //   1047: lcmp
/*     */     //   1048: ifle -> 1142
/*     */     //   1051: aload_3
/*     */     //   1052: new java/lang/StringBuilder
/*     */     //   1055: dup
/*     */     //   1056: invokespecial <init> : ()V
/*     */     //   1059: ldc '%-'
/*     */     //   1061: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1064: iload #37
/*     */     //   1066: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   1069: ldc 's %8s ms %8s ms in mixin)'
/*     */     //   1071: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1074: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1077: iconst_3
/*     */     //   1078: anewarray java/lang/Object
/*     */     //   1081: dup
/*     */     //   1082: iconst_0
/*     */     //   1083: aload #40
/*     */     //   1085: aastore
/*     */     //   1086: dup
/*     */     //   1087: iconst_1
/*     */     //   1088: aload #39
/*     */     //   1090: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   1095: checkcast java/lang/Long
/*     */     //   1098: invokevirtual longValue : ()J
/*     */     //   1101: lload #41
/*     */     //   1103: ladd
/*     */     //   1104: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   1107: aastore
/*     */     //   1108: dup
/*     */     //   1109: iconst_2
/*     */     //   1110: new java/lang/StringBuilder
/*     */     //   1113: dup
/*     */     //   1114: invokespecial <init> : ()V
/*     */     //   1117: ldc '('
/*     */     //   1119: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1122: lload #41
/*     */     //   1124: invokevirtual append : (J)Ljava/lang/StringBuilder;
/*     */     //   1127: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1130: aastore
/*     */     //   1131: invokevirtual add : (Ljava/lang/String;[Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   1134: pop
/*     */     //   1135: goto -> 1191
/*     */     //   1138: invokestatic b : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
/*     */     //   1141: athrow
/*     */     //   1142: aload_3
/*     */     //   1143: new java/lang/StringBuilder
/*     */     //   1146: dup
/*     */     //   1147: invokespecial <init> : ()V
/*     */     //   1150: ldc '%-'
/*     */     //   1152: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1155: iload #37
/*     */     //   1157: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   1160: ldc 's %8s ms'
/*     */     //   1162: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1165: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1168: iconst_2
/*     */     //   1169: anewarray java/lang/Object
/*     */     //   1172: dup
/*     */     //   1173: iconst_0
/*     */     //   1174: aload #40
/*     */     //   1176: aastore
/*     */     //   1177: dup
/*     */     //   1178: iconst_1
/*     */     //   1179: aload #39
/*     */     //   1181: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   1186: aastore
/*     */     //   1187: invokevirtual add : (Ljava/lang/String;[Ljava/lang/Object;)Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   1190: pop
/*     */     //   1191: goto -> 945
/*     */     //   1194: aload_3
/*     */     //   1195: invokevirtual add : ()Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   1198: pop
/*     */     //   1199: goto -> 1204
/*     */     //   1202: astore #34
/*     */     //   1204: aload_3
/*     */     //   1205: invokevirtual print : ()Lorg/spongepowered/asm/util/PrettyPrinter;
/*     */     //   1208: pop
/*     */     //   1209: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #316	-> 0
/*     */     //   #61	-> 10
/*     */     //   #10	-> 20
/*     */     //   #33	-> 30
/*     */     //   #54	-> 44
/*     */     //   #105	-> 58
/*     */     //   #367	-> 72
/*     */     //   #344	-> 86
/*     */     //   #269	-> 100
/*     */     //   #47	-> 114
/*     */     //   #89	-> 128
/*     */     //   #107	-> 142
/*     */     //   #311	-> 155
/*     */     //   #335	-> 168
/*     */     //   #215	-> 181
/*     */     //   #286	-> 194
/*     */     //   #35	-> 207
/*     */     //   #272	-> 210
/*     */     //   #317	-> 213
/*     */     //   #151	-> 249
/*     */     //   #260	-> 277
/*     */     //   #243	-> 285
/*     */     //   #274	-> 289
/*     */     //   #221	-> 293
/*     */     //   #162	-> 296
/*     */     //   #229	-> 312
/*     */     //   #291	-> 316
/*     */     //   #188	-> 354
/*     */     //   #302	-> 389
/*     */     //   #265	-> 424
/*     */     //   #110	-> 459
/*     */     //   #28	-> 497
/*     */     //   #166	-> 506
/*     */     //   #365	-> 541
/*     */     //   #301	-> 579
/*     */     //   #340	-> 584
/*     */     //   #165	-> 596
/*     */     //   #249	-> 608
/*     */     //   #67	-> 632
/*     */     //   #336	-> 666
/*     */     //   #64	-> 696
/*     */     //   #325	-> 726
/*     */     //   #259	-> 756
/*     */     //   #349	-> 763
/*     */     //   #11	-> 800
/*     */     //   #57	-> 805
/*     */     //   #153	-> 824
/*     */     //   #103	-> 837
/*     */     //   #59	-> 852
/*     */     //   #30	-> 868
/*     */     //   #5	-> 872
/*     */     //   #283	-> 908
/*     */     //   #148	-> 928
/*     */     //   #268	-> 931
/*     */     //   #333	-> 967
/*     */     //   #226	-> 979
/*     */     //   #141	-> 982
/*     */     //   #230	-> 1018
/*     */     //   #238	-> 1031
/*     */     //   #285	-> 1038
/*     */     //   #13	-> 1041
/*     */     //   #109	-> 1044
/*     */     //   #318	-> 1051
/*     */     //   #200	-> 1142
/*     */     //   #80	-> 1191
/*     */     //   #12	-> 1194
/*     */     //   #353	-> 1199
/*     */     //   #366	-> 1202
/*     */     //   #288	-> 1204
/*     */     //   #22	-> 1209
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   249	270	270	java/lang/Throwable
/*     */     //   316	659	662	java/lang/Throwable
/*     */     //   666	793	796	java/lang/Throwable
/*     */     //   805	1199	1202	java/lang/Throwable
/*     */     //   1044	1138	1138	java/lang/Throwable
/*     */   }
/*     */   
/*     */   private void handleMixinApplyError(String paramString, InvalidMixinException paramInvalidMixinException, MixinEnvironment paramMixinEnvironment) throws MixinApplyError {
/*     */     handleMixinError(paramString, paramInvalidMixinException, paramMixinEnvironment, MixinTransformer$ErrorPhase.APPLY);
/*     */   }
/*     */   
/*     */   private final IMixinService service = MixinService.getService();
/*     */   private static final String MIXIN_AGENT_CLASS = "org.spongepowered.tools.agent.MixinAgent";
/*     */   private static final String METRONOME_AGENT_CLASS = "org.spongepowered.metronome.Agent";
/*     */   private final ReEntranceLock lock;
/*     */   private final Extensions extensions;
/*     */   private final IHotSwap hotSwapper;
/*     */   private final MixinPostProcessor postProcessor;
/*     */   private final Profiler profiler;
/*     */   private MixinEnvironment currentEnvironment;
/*     */   
/*     */   private byte[] applyMixins(MixinEnvironment paramMixinEnvironment, TargetClassContext paramTargetClassContext) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield profiler : Lorg/spongepowered/asm/util/perf/Profiler;
/*     */     //   4: ldc 'preapply'
/*     */     //   6: invokevirtual begin : (Ljava/lang/String;)Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   9: astore_3
/*     */     //   10: aload_0
/*     */     //   11: getfield extensions : Lorg/spongepowered/asm/mixin/transformer/ext/Extensions;
/*     */     //   14: aload_2
/*     */     //   15: invokevirtual preApply : (Lorg/spongepowered/asm/mixin/transformer/ext/ITargetClassContext;)V
/*     */     //   18: aload_3
/*     */     //   19: ldc 'apply'
/*     */     //   21: invokevirtual next : (Ljava/lang/String;)Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   24: astore_3
/*     */     //   25: aload_0
/*     */     //   26: aload_2
/*     */     //   27: invokespecial apply : (Lorg/spongepowered/asm/mixin/transformer/TargetClassContext;)V
/*     */     //   30: aload_3
/*     */     //   31: ldc 'postapply'
/*     */     //   33: invokevirtual next : (Ljava/lang/String;)Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   36: astore_3
/*     */     //   37: aload_0
/*     */     //   38: getfield extensions : Lorg/spongepowered/asm/mixin/transformer/ext/Extensions;
/*     */     //   41: aload_2
/*     */     //   42: invokevirtual postApply : (Lorg/spongepowered/asm/mixin/transformer/ext/ITargetClassContext;)V
/*     */     //   45: goto -> 100
/*     */     //   48: astore #4
/*     */     //   50: getstatic org/spongepowered/asm/mixin/transformer/MixinTransformer.logger : Lorg/apache/logging/log4j/Logger;
/*     */     //   53: aload #4
/*     */     //   55: invokevirtual getMessage : ()Ljava/lang/String;
/*     */     //   58: invokeinterface info : (Ljava/lang/String;)V
/*     */     //   63: aload_2
/*     */     //   64: invokevirtual isExportForced : ()Z
/*     */     //   67: ifne -> 87
/*     */     //   70: aload_1
/*     */     //   71: getstatic org/spongepowered/asm/mixin/MixinEnvironment$Option.DEBUG_EXPORT : Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;
/*     */     //   74: invokevirtual getOption : (Lorg/spongepowered/asm/mixin/MixinEnvironment$Option;)Z
/*     */     //   77: ifeq -> 100
/*     */     //   80: goto -> 87
/*     */     //   83: invokestatic b : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
/*     */     //   86: athrow
/*     */     //   87: aload_0
/*     */     //   88: aload_2
/*     */     //   89: invokespecial writeClass : (Lorg/spongepowered/asm/mixin/transformer/TargetClassContext;)[B
/*     */     //   92: pop
/*     */     //   93: goto -> 100
/*     */     //   96: invokestatic b : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
/*     */     //   99: athrow
/*     */     //   100: aload_3
/*     */     //   101: invokevirtual end : ()Lorg/spongepowered/asm/util/perf/Profiler$Section;
/*     */     //   104: pop
/*     */     //   105: aload_0
/*     */     //   106: aload_2
/*     */     //   107: invokespecial writeClass : (Lorg/spongepowered/asm/mixin/transformer/TargetClassContext;)[B
/*     */     //   110: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #368	-> 0
/*     */     //   #31	-> 10
/*     */     //   #289	-> 18
/*     */     //   #155	-> 25
/*     */     //   #276	-> 30
/*     */     //   #23	-> 37
/*     */     //   #169	-> 45
/*     */     //   #244	-> 48
/*     */     //   #305	-> 50
/*     */     //   #207	-> 63
/*     */     //   #373	-> 87
/*     */     //   #74	-> 100
/*     */     //   #42	-> 105
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   37	45	48	org/spongepowered/asm/mixin/transformer/ext/extensions/ExtensionCheckClass$ValidationFailedException
/*     */     //   50	80	83	org/spongepowered/asm/mixin/transformer/ext/extensions/ExtensionCheckClass$ValidationFailedException
/*     */     //   70	93	96	org/spongepowered/asm/mixin/transformer/ext/extensions/ExtensionCheckClass$ValidationFailedException
/*     */   }
/*     */   
/*     */   private static Throwable b(Throwable paramThrowable) {
/*     */     return paramThrowable;
/*     */   }
/*     */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\mixin\transformer\MixinTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */