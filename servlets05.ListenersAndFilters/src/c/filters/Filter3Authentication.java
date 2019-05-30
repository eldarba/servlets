package c.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter3Authentication implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// pre-process actions - before we pass the request on toward resource
		System.out.println("from filter 3 pre-process");
		String password = request.getParameter("password");
		if (!(password != null && password.equals("admin"))) {
			System.out.println("filter 3 blocked the request");
			PrintWriter out = response.getWriter();
			out.println("You shall not pass!");
			return;
		}
		chain.doFilter(request, response); // pass the request (not blocked)
		// post-process actions - before we pass the response on towards client
		System.out.println("from filter 3 post-process");

	}

}
