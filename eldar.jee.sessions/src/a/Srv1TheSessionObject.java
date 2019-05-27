package a;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Srv1", urlPatterns = { "/Srv1" })
public class Srv1TheSessionObject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get a request session
		HttpSession session = request.getSession();
		// set session time (in seconds)
		session.setMaxInactiveInterval(10);

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Welcom to: ");
		out.println(request.getRequestURI());
		out.println("</h1>");

		// display session attributes:
		out.println("=======================================================<br>");
		out.println("the session id: " + session.getId() + "<br>");
		out.println("is new? : " + session.isNew() + "<br>");
		out.println("MaxInactiveInterval: " + session.getMaxInactiveInterval() + " seconds<br>");
		out.println("CreationTime: " + session.getCreationTime() + "<br>");
		out.println("LastAccessedTime: " + session.getLastAccessedTime() + "<br>");
		out.println("=======================================================<br>");

		String root = getServletContext().getContextPath();
		out.println("<a href='" + root + "'>to home</a>");
		out.println("</body></html>");

	}

}
