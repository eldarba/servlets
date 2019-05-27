package a;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Srv2", urlPatterns = { "/Srv2" })
public class Srv2SessionInvalidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Welcom to: ");
		out.println(request.getRequestURI());
		out.println("</h1>");

		out.println("=======================================================<br>");
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
			out.println("session with id: " + session.getId() + " invalidated<br>");
		} else {
			out.println("there was no active session<br>");
		}
		out.println("=======================================================<br>");

		String root = getServletContext().getContextPath();
		out.println("<a href='" + root + "'>to home</a>");
		out.println("</body></html>");

	}

}
