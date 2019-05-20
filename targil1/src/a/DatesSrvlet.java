package a;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DatesSrvlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Date initialDate = new Date();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date now = new Date();
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Dates</h1>");
		out.println("initial date: " + initialDate + "<br>");
		out.println("now: " + now + "<br>");
		out.println("</body>");
		out.println("</html>");
	}

}
