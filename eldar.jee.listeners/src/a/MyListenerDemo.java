package a;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//The annotation used to declare a listener for various types of event, in agiven web application context.
@WebListener
public class MyListenerDemo implements HttpSessionListener, ServletRequestListener {

	// HttpSessionListener interface
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		String sessionId = se.getSession().getId();
		System.out.println("session " + sessionId + " created");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		String sessionId = se.getSession().getId();
		System.out.println("session " + sessionId + " destroied");
	}

	// ServletRequestListener interface

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("request  initialized");
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("request destroyed");
	}

}
