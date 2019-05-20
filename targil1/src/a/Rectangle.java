package a;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Rectangle extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("<h1>ELDAR</h1>");
		int width = (int) (Math.random() * 21) + 5;
		int hegiht = (int) (Math.random() * 21) + 5;

		for (int i = 0; i < hegiht; i++) {
			for (int j = 0; j < width; j++) {
				out.print(" * ");
			}
			out.print("<br>");
		}
	}

}
