package helter.osgi.util.use.jaxb.pool.internal;

import helter.osgi.util.jaxb.pool.api.JAXBPool;

import java.util.ArrayList;
import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	@SuppressWarnings({ "rawtypes", "unused" })
	private List<ServiceRegistration> regs = new ArrayList<ServiceRegistration>();
	
	JAXBPool pool;
	public Activator() {
		pool = new JAXBPool();
	}

	@Override
	public void start(BundleContext context) throws Exception {
		
		

	}

	@Override
	public void stop(BundleContext context) throws Exception {
	}

}
