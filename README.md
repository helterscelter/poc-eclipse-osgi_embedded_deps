poc-eclipse-osgi_embedded_deps
==============================

contains POC showing issue with debugging OSGI embedded deps using eclipse

when launching bundles in this project via the eclipse osgi run config,
the bundles cannot find classes referenced from the embedded jar project. 


````

!SESSION 2014-11-20 22:13:00.272 -----------------------------------------------
eclipse.buildId=unknown
java.version=1.7.0_72
java.vendor=Oracle Corporation
BootLoader constants: OS=linux, ARCH=x86_64, WS=gtk, NL=en_US
Command-line arguments:  -dev file:/home/cm460t/workspace/github/poc/osgi_embedded_dep/.metadata/.plugins/org.eclipse.pde.core/SAMPLE/dev.properties -os linux -ws gtk -arch x86_64 -consoleLog -console

!ENTRY helter.osgi.util.use.jaxb.pool 4 0 2014-11-20 22:13:00.771
!MESSAGE FrameworkEvent ERROR
!STACK 0
org.osgi.framework.BundleException: Error starting module.
	at org.eclipse.osgi.container.Module.doStart(Module.java:580)
	at org.eclipse.osgi.container.Module.start(Module.java:439)
	at org.eclipse.osgi.container.ModuleContainer$ContainerStartLevel.incStartLevel(ModuleContainer.java:1582)
	at org.eclipse.osgi.container.ModuleContainer$ContainerStartLevel.incStartLevel(ModuleContainer.java:1562)
	at org.eclipse.osgi.container.ModuleContainer$ContainerStartLevel.doContainerStartLevel(ModuleContainer.java:1533)
	at org.eclipse.osgi.container.ModuleContainer$ContainerStartLevel.dispatchEvent(ModuleContainer.java:1476)
	at org.eclipse.osgi.container.ModuleContainer$ContainerStartLevel.dispatchEvent(ModuleContainer.java:1)
	at org.eclipse.osgi.framework.eventmgr.EventManager.dispatchEvent(EventManager.java:230)
	at org.eclipse.osgi.framework.eventmgr.EventManager$EventThread.run(EventManager.java:340)
Caused by: java.lang.NoClassDefFoundError: helter/osgi/embedded/api/Embedded
	at helter.osgi.util.jaxb.pool.api.JAXBPool.<init>(JAXBPool.java:9)
	at helter.osgi.util.use.jaxb.pool.internal.Activator.<init>(Activator.java:18)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:57)
	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.lang.reflect.Constructor.newInstance(Constructor.java:526)
	at java.lang.Class.newInstance(Class.java:379)
	at org.eclipse.osgi.internal.framework.BundleContextImpl.loadBundleActivator(BundleContextImpl.java:755)
	at org.eclipse.osgi.internal.framework.BundleContextImpl.start(BundleContextImpl.java:706)
	at org.eclipse.osgi.internal.framework.EquinoxBundle.startWorker0(EquinoxBundle.java:936)
	at org.eclipse.osgi.internal.framework.EquinoxBundle$EquinoxModule.startWorker(EquinoxBundle.java:319)
	at org.eclipse.osgi.container.Module.doStart(Module.java:571)
	... 8 more
Caused by: java.lang.ClassNotFoundException: helter.osgi.embedded.api.Embedded cannot be found by helter.osgi.util.jaxb.pool_0.0.1.SNAPSHOT
	at org.eclipse.osgi.internal.loader.BundleLoader.findClassInternal(BundleLoader.java:432)
	at org.eclipse.osgi.internal.loader.BundleLoader.findClass(BundleLoader.java:345)
	at org.eclipse.osgi.internal.loader.BundleLoader.findClass(BundleLoader.java:337)
	at org.eclipse.osgi.internal.loader.ModuleClassLoader.loadClass(ModuleClassLoader.java:160)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:358)
	... 20 more
Root exception:
java.lang.NoClassDefFoundError: helter/osgi/embedded/api/Embedded
	at helter.osgi.util.jaxb.pool.api.JAXBPool.<init>(JAXBPool.java:9)
	at helter.osgi.util.use.jaxb.pool.internal.Activator.<init>(Activator.java:18)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:57)
	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.lang.reflect.Constructor.newInstance(Constructor.java:526)
	at java.lang.Class.newInstance(Class.java:379)
	at org.eclipse.osgi.internal.framework.BundleContextImpl.loadBundleActivator(BundleContextImpl.java:755)
	at org.eclipse.osgi.internal.framework.BundleContextImpl.start(BundleContextImpl.java:706)
	at org.eclipse.osgi.internal.framework.EquinoxBundle.startWorker0(EquinoxBundle.java:936)
	at org.eclipse.osgi.internal.framework.EquinoxBundle$EquinoxModule.startWorker(EquinoxBundle.java:319)
	at org.eclipse.osgi.container.Module.doStart(Module.java:571)
	at org.eclipse.osgi.container.Module.start(Module.java:439)
	at org.eclipse.osgi.container.ModuleContainer$ContainerStartLevel.incStartLevel(ModuleContainer.java:1582)
	at org.eclipse.osgi.container.ModuleContainer$ContainerStartLevel.incStartLevel(ModuleContainer.java:1562)
	at org.eclipse.osgi.container.ModuleContainer$ContainerStartLevel.doContainerStartLevel(ModuleContainer.java:1533)
	at org.eclipse.osgi.container.ModuleContainer$ContainerStartLevel.dispatchEvent(ModuleContainer.java:1476)
	at org.eclipse.osgi.container.ModuleContainer$ContainerStartLevel.dispatchEvent(ModuleContainer.java:1)
	at org.eclipse.osgi.framework.eventmgr.EventManager.dispatchEvent(EventManager.java:230)
	at org.eclipse.osgi.framework.eventmgr.EventManager$EventThread.run(EventManager.java:340)
Caused by: java.lang.ClassNotFoundException: helter.osgi.embedded.api.Embedded cannot be found by helter.osgi.util.jaxb.pool_0.0.1.SNAPSHOT
	at org.eclipse.osgi.internal.loader.BundleLoader.findClassInternal(BundleLoader.java:432)
	at org.eclipse.osgi.internal.loader.BundleLoader.findClass(BundleLoader.java:345)
	at org.eclipse.osgi.internal.loader.BundleLoader.findClass(BundleLoader.java:337)
	at org.eclipse.osgi.internal.loader.ModuleClassLoader.loadClass(ModuleClassLoader.java:160)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:358)
	... 20 more

!ENTRY org.eclipse.osgi 4 0 2014-11-20 22:13:00.810
!MESSAGE Bundle helter.osgi.util.use.jaxb.pool_0.0.1.SNAPSHOT [2] is not active.
osgi> lb\
gogo: EOFException: unexpected EOT in \ escape
osgi> lb
START LEVEL 6
   ID|State      |Level|Name
    0|Active     |    0|OSGi System Bundle (3.10.1.v20140909-1633)
    1|Active     |    4|Logback Classic Module (1.0.7.v20121108-1250)
    2|Resolved   |    4|use.jaxb.pool [helter.osgi.util] (0.0.1.SNAPSHOT)
    3|Active     |    4|Logback Core Module (1.0.7.v20121108-1250)
    4|Active     |    4|Apache Felix Gogo Shell (0.10.0.v201212101605)
    5|Resolved   |    4|Logback Native SLF4J Logger Module (1.0.7.v20121108-1250)
    6|Active     |    4|Apache Felix Gogo Runtime (0.10.0.v201209301036)
    7|Active     |    4|Console plug-in (1.1.0.v20140131-1639)
    8|Active     |    4|jaxb.pool [helter.osgi.util] (0.0.1.SNAPSHOT)
    9|Active     |    4|Apache Felix Gogo Command (0.10.0.v201209301215)
   10|Active     |    4|SLF4J API (1.7.2.v20121108-1250)
osgi> 

````
