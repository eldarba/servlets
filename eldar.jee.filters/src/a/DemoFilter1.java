package a;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(urlPatterns = { "/filtered/*" }, servletNames = { "a.Srv1", "a.Srv2" }, initParams = {
		@WebInitParam(name = "a", value = "1"), @WebInitParam(name = "b", value = "2") })
public class DemoFilter1 implements Filter {

	public DemoFilter1() {
		System.out.println("from demo filter 1 CTOR");
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("from demo filter 1 init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// place your code here
		System.out.println("from demo filter 1 pre-processing");
		// pass the request along the filter chain
		chain.doFilter(request, response);
		System.out.println("from demo filter 1 post-processing");
	}

	@Override
	public void destroy() {
		System.out.println("from demo filter 1 destroy");
	}

}
