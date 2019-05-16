package my.first.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	// 1 - create
	public MyServlet() {
		System.out.println("From CTOR");
	}
	
	
	// 2 - initialize - to load data from web.xml
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config); // leave this invocation to the super method
		System.out.println("From init method");
	}


	// 3. service - runs as many time as clients ask for the servlet
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("from service"); // write to server console
		/*
		 * in order to write to the client we need an IO object that can do that. we get
		 * it from the response parameter of the method
		 */
		PrintWriter out = resp.getWriter();
		out.println("Hi"); // write to client

	}


	// 4. destroy
	@Override
	public void destroy() {
		System.out.println("from destroy");
	}
	
	

}
