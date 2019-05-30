package b.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyRequestListener implements ServletRequestListener {

	private int numberOfRequests;

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		numberOfRequests++;
		System.out.println("request initialized: " + numberOfRequests);
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("request destroyed: " + numberOfRequests);
	}

}
