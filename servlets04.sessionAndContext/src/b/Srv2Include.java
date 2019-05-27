package b;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Srv2", urlPatterns = { "/Srv2" })
public class Srv2Include extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("line 1<br>");
		out.println("line 2<br>");

		// content from other resource
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Srv3");
		rd.include(request, response);
		//

		out.println("line 3<br>");
		out.println("line 4<br>");
		out.println("</body></html>");
	}

}
