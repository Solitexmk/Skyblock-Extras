/*    */ package org.spongepowered.asm.service;
/*    */ 
/*    */ import java.util.ServiceLoader;
/*    */ 
/*    */ public final class MixinService {
/*  6 */   public static IMixinService getService() { return getInstance().getServiceInstance(); }
/*  7 */   private final Set<String> bootedServices = new HashSet<String>(); private MixinService() { runBootServices(); } private static final Logger logger = LogManager.getLogger("mixin"); public static void boot() { getInstance(); } private synchronized IMixinService getServiceInstance() { try { if (this.service == null) {
/*    */ 
/*    */         
/*    */         try { 
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
/* 26 */           this.service = initService();
/*    */           if (this.service == null)
/* 28 */             throw new ServiceNotAvailableError("No mixin host service is available");  } catch (RuntimeException runtimeException) { throw b(null); }
/*    */       
/*    */       } }
/*    */     catch (RuntimeException runtimeException)
/*    */     { throw b(null); }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 40 */     return this.service; } private IMixinService service = null; private static MixinService instance; private ServiceLoader<IMixinServiceBootstrap> bootstrapServiceLoader; private ServiceLoader<IMixinService> serviceLoader; private void runBootServices() { this.bootstrapServiceLoader = ServiceLoader.load(IMixinServiceBootstrap.class, getClass().getClassLoader()); for (IMixinServiceBootstrap iMixinServiceBootstrap : this.bootstrapServiceLoader) { try { iMixinServiceBootstrap.bootstrap(); this.bootedServices.add(iMixinServiceBootstrap.getServiceClassName()); }
/* 41 */       catch (Throwable throwable) {} }  } private static MixinService getInstance() { try { if (instance == null) instance = new MixinService();  } catch (RuntimeException runtimeException) { throw b(null); }  return instance; }
/* 42 */   private IMixinService initService() { this.serviceLoader = ServiceLoader.load(IMixinService.class, getClass().getClassLoader()); Iterator<IMixinService> iterator = this.serviceLoader.iterator(); while (iterator.hasNext()) { try { IMixinService iMixinService = iterator.next(); try { if (this.bootedServices.contains(iMixinService.getClass().getName())) logger.debug("MixinService [{}] was successfully booted in {}", new Object[] { iMixinService.getName(), getClass().getClassLoader() });  } catch (ServiceConfigurationError serviceConfigurationError) { throw b(null); }  if (iMixinService.isValid())
/*    */           return iMixinService;  }
/*    */       catch (ServiceConfigurationError serviceConfigurationError)
/*    */       { serviceConfigurationError.printStackTrace(); }
/*    */       catch (Throwable throwable)
/*    */       { throwable.printStackTrace(); }
/*    */        }
/*    */     
/*    */     return null; }
/*    */ 
/*    */   
/*    */   private static Throwable b(Throwable paramThrowable) {
/*    */     return paramThrowable;
/*    */   }
/*    */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\org\spongepowered\asm\service\MixinService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */