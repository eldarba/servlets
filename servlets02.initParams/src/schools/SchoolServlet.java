package schools;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SchoolServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String name;
	private String address;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config); // do not omit invoking the original method
		this.name = config.getInitParameter("name");
		this.address = config.getInitParameter("address");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html"); // add http response header that content is html
		PrintWriter out = resp.getWriter();
		out.print("servlet name: " + getServletName() + "<br>");
		out.print("school name: " + this.name + "<br>");
		out.print("school address: " + this.address + "<br>");
	}

	@Override
	public void destroy() {
		System.out.println(getServletName() + " is destryed");
		System.out.println("reaources are being closed");
	}

}
