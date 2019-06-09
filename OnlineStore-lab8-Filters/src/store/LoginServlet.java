package store;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ======= invalidate session ===========
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		// ======= ======= ======================

		String userName = request.getParameter("userName");
		System.out.println(userName);
		request.setAttribute("userName", userName != null && !userName.equals("") ? userName : "Guest");

		// ===== last visit cookie ==============A
		String lastVisit = "This is your first visit";
		Cookie[] cookieArr = request.getCookies();
		if (cookieArr != null) {
			for (Cookie cookie : cookieArr) {
				if (cookie.getName().equals("lastVisit")) {
					lastVisit = cookie.getValue();
					break;
				}
			}
		}
		// plant cookie for next visit
		Cookie cookie = new Cookie("lastVisit", new Date().toString().replaceAll(" ", "_"));
		/*
		 * set the cookie path so browsers come back with it only when requesting this
		 * path and it's sub paths: /OnlineStore-lab5/Login
		 */
		cookie.setPath(request.getRequestURI()); // /OnlineStore-lab5/Login
		// set expiration for 1 week
		cookie.setMaxAge(60 * 60 * 24 * 7);
		response.addCookie(cookie);
		// ======================================A

		// ======= display ======================B
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Online Store</h1>");
		out.println("<hr>");
		out.println("<h3>Welcome " + request.getAttribute("userName") + "!</h3>");
		out.println("Last Visit: " + lastVisit);

		out.println("</body>");
		out.println("</html>");
		// ======= ======= ======================B

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
