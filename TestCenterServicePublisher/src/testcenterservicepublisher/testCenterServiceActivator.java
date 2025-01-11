package testcenterservicepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class testCenterServiceActivator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		testCenterServiceActivator.context = bundleContext;
		this.registry();
		System.out.println("Testing Center Service Started...");
	}

	private void registry() {
		
		testCenterService service = new testCenterServiceImpl();
		context.registerService(testCenterService.class, service, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		testCenterServiceActivator.context = null;
		System.out.println("Testing Center Service Stopped...");
	}

}
