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
public class Srv1CounterSession extends HttpServlet {
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

		PrintWriter out = response.getWriter();
		out.println("sum = " + session.getAttribute("sum"));

	}

}
