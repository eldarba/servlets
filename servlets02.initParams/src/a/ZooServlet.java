package a;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "zoo-servlet", urlPatterns = { "/zoo/haifa" }, initParams = {
		@WebInitParam(name = "name", value = "Haifa Zoo"),
		@WebInitParam(name = "address", value = "Merkazit Hamifraz, Haifa") })
public class ZooServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("servlet name: " + getServletName() + "<br>");
		out.print("zoo name: " + getServletConfig().getInitParameter("name") + "<br>");
		out.print("zoo address: " + getServletConfig().getInitParameter("address") + "<br>");
	}

}
