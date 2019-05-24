package b.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SrvCookie")
public class SrvCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// find a cookie
		Cookie[] arr = request.getCookies();
		String color = null;
		if (arr != null) {
			for (Cookie currCookie : arr) {
				if (currCookie.getName().equals("color")) {
					color = currCookie.getValue();
					break;
				}
			}
		}

		PrintWriter out = response.getWriter();
		out.println("color = " + color);

		// plant a cookie
		Cookie cookie = new Cookie("color", "red");
		cookie.setMaxAge(10); // will be saved in browser for 10 seconds
		response.addCookie(cookie); // add cookie to the response
	}

}
