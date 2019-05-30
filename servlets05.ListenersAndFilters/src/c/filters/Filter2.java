package c.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter2 implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// pre-process actions - before we pass the request on toward resource
		System.out.println("from filter 2 pre-process");
		chain.doFilter(request, response); // pass the request (not blocked)
		// post-process actions - before we pass the response on towards client
		System.out.println("from filter 2 post-process");

	}

}
