package a;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * The MyStatisticsListener class keeps statistics of requests and sessiom
 */
// The annotation used to declare a listener for various types of event, in
// agiven web application context.
// @WebListener
public class MyStatisticsListener implements HttpSessionListener, ServletRequestListener {

	private Map<String, Long> sessionsTimeMap = new HashMap<>();
	private int numberOfSessionsCreated;
	private int numberOfSessionsDestroyed;
	private int numberOfRequestsCreated;
	private int numberOfRequestsDestroyed;
	private long totalSessionsTime;

	// HttpSessionListener interface
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		String sessionId = se.getSession().getId();
		numberOfSessionsCreated++;
		sessionsTimeMap.put(sessionId, System.currentTimeMillis());
		System.out.println("session " + sessionId + " created [sessoion #" + numberOfSessionsCreated + "]");
		System.out.println("number of live sessions: " + sessionsTimeMap.size());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		String sessionId = se.getSession().getId();
		numberOfSessionsDestroyed++;
		long sessionTime = System.currentTimeMillis() - sessionsTimeMap.get(sessionId);
		totalSessionsTime += sessionTime;
		System.out.println("session " + sessionId + " destroied after: " + sessionTime / 1000 + " seconds.");
		System.out.println(
				"average session time is: " + totalSessionsTime / numberOfSessionsDestroyed / 1000 + " seconds");
		sessionsTimeMap.remove(sessionId);
	}

	// ServletRequestListener interface

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("request  number " + ++numberOfRequestsCreated + " initialized");
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("request  number " + ++numberOfRequestsDestroyed + " destroyed");
	}

}
