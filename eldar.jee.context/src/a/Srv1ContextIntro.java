package a;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Srv1", urlPatterns = { "/Srv1" })
public class Srv1ContextIntro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get the context in which this servletis running

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Welcom to: ");
		out.println(request.getRequestURI());
		out.println("</h1>");

		ServletContext ctx = getServletContext();
		// display
		out.println("=======================================================<br>");
		out.println("getServerInfo: " + ctx.getServerInfo() + "<br>");
		out.println("getContextPath: " + ctx.getContextPath() + "<br>");
		out.println("getInitParameter: x = " + ctx.getInitParameter("x") + "<br>");
		out.println("<br>== find files MIME type:<br>");
		out.println("mime type of index.html: " + ctx.getMimeType("index.html") + "<br>");
		out.println("mime type of servlets.pdf: " + ctx.getMimeType("files/servlets.pdf") + "<br>");
		out.println("=======================================================<br>");

		String root = getServletContext().getContextPath();
		out.println("<a href='" + root + "'>to home</a>");
		out.println("</body></html>");

	}

}
