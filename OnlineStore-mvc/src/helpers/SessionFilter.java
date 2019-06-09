package helpers;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "sessionFilter", urlPatterns = { "/Controller" })
public class SessionFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// pre process
		String command = request.getParameter("command");
		command = command == null ? "" : command;
		switch (command) {
		case "addItem":
		case "removeItem":
		case "clear":
		case "showItems":
		case "":
			if (((HttpServletRequest) request).getSession(false) == null) {
				String path = "";
				((HttpServletResponse) response).sendRedirect(path);
				System.out.println("no session - redirected");
				return;
			}
		}

		// pass the request along the filter chain
		System.out.println("the request is being forwarded by the filter");
		chain.doFilter(request, response);
		// post process
		System.out.println("the response is being forwarded by the filter");
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
