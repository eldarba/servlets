package store;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.StoreItems;

@WebServlet(urlPatterns = { "/Controller" }, initParams = {
		@WebInitParam(name = "email", value = "support@online.store") })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String supportMail;
	private int hitCounter;
	private StoreItems store;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.store = new StoreItems();
		this.supportMail = config.getInitParameter("email");
		System.out.println(getServletName() + " initialized");
		System.out.println("email=" + this.supportMail);
		System.out.println("store=" + this.store);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(getServletName() + " service. hitCounter=" + ++hitCounter);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
