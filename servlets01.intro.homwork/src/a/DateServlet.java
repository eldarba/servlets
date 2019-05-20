package a;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Date date = new Date();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Date Servlet</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<h1>Dates</h1>");
		out.println("initial date: " + this.date);
		out.println("<br>");
		out.println("current date: " + new Date());
		out.println("<br>");

		out.println("<a href=''>home</a>");
		out.println("<br>");

		out.println("</body>");
		out.println("</html>");
	}

}
