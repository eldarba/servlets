package a;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RectangleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Rectangle</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Rectangle</h1>");

		int width = (int) (Math.random() * 25) + 5;
		int height = (int) (Math.random() * 25) + 5;

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				out.print(" *");
			}
			out.println("<br>");
		}

		out.println("<a href='index.html'>home</a>");
		out.println("<br>");

		out.println("</body>");
		out.println("</html>");
	}

}
