package a;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Srv2", urlPatterns = { "/Srv2" })
public class Srv2DispatchForward extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// PrintWriter out = response.getWriter();
		// out.println("BLA BLA BLA");
		int r = (int) (Math.random() * 11);
		request.setAttribute("luckyNumber", String.valueOf(r));

		ServletContext ctx = getServletContext();
		String path = "/Srv3";
		RequestDispatcher rd = ctx.getRequestDispatcher(path);
		rd.forward(request, response);

		System.out.println("count to 3 before forwarding...");
		for (int i = 1; i <= 3; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(i + " ");
		}
		System.out.println("\nfinished sleep");
		System.out.println("the request was forwarded to: " + path);

	}

}
