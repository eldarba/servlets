package b;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Srv3", urlPatterns = { "/Srv3" })
public class Srv3SumSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(30); // 30 seconds
		String str = request.getParameter("number");
		str = str == null ? "0" : str;
		int number = Integer.parseInt(str);

		if (session.isNew()) {
			System.out.println("this is a new session");
			session.setAttribute("sum", number);
		} else {
			System.out.println("this is an old session");
			int oldSum = (Integer) session.getAttribute("sum");
			session.setAttribute("sum", oldSum + number);
		}

		/*
		 * this part of the code is just a form so we can send numbers easily.
		 */
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Welcom to: ");
		out.println(request.getRequestURI());
		out.println("</h1>");
		out.println("<div>");
		out.println("Current Sum = " + session.getAttribute("sum"));
		out.println("</div>");
		out.println("<div>");
		out.println("Seesion will be invalidated after " + session.getMaxInactiveInterval() + " sconds of inactivity");
		out.println("</div>");
		out.println("<form action=''>");
		out.println("number to add <input name='number' /><br>");
		out.println("<button type='submit'>add</button><br>");
		out.println("</form>");
		String root = getServletContext().getContextPath();
		out.println("<a href='" + root + "'>to home</a>");
		out.println("</body></html>");

	}

}
