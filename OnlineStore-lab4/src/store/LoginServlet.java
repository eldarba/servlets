package store;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		System.out.println(userName);
		request.setAttribute("userName", userName != null && !userName.equals("") ? userName : "Guest");
		// "======= display ======================"
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Online Store</h1>");
		out.println("<hr>");
		out.println("<h3>Welcome " + request.getAttribute("userName") + "!</h3>");
		out.println("</body>");
		out.println("</html>");
		// "======= ======= ======================"
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
