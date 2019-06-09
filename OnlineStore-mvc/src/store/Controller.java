package store;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.Item;
import db.ItemNotFoundException;
import db.StoreItems;
import helpers.ShoppingCart;

@WebServlet(urlPatterns = { "/Controller" }, initParams = {
		@WebInitParam(name = "email", value = "support@online.store") })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String supportMail;
	private int hitCounter;
	// private StoreItems store;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// this.store = new StoreItems();
		ServletContext ctx = getServletContext();
		ctx.setAttribute("storeItems", new StoreItems());
		this.supportMail = config.getInitParameter("email");
		System.out.println(getServletName() + " initialized");
		System.out.println("email=" + this.supportMail);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("controller");
		System.out.println(getServletName() + " service. hitCounter=" + ++hitCounter);
		String command = request.getParameter("command");
		command = command != null ? command : "";
		HttpSession session;
		switch (command) {
		case "startShopping":
			System.out.println("startShopping - controller");
			session = request.getSession();
			if (session.isNew()) {
				session.setAttribute("cart", new ShoppingCart());
			}
			break;
		case "clear":
			System.out.println("clear");
			session = request.getSession(false);
			if (session != null) {
				ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
				if (cart != null) {
					cart.clear();
				}
			}
			break;
		case "addItem":
			System.out.println("addItem - controller");
			session = request.getSession(false);
			ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
			StoreItems storeItems = (StoreItems) getServletContext().getAttribute("storeItems");
			try {
				String itemName = request.getParameter("itemName");
				Item item = storeItems.getItem(itemName);
				cart.addItem(item);
			} catch (ItemNotFoundException e) {
				request.setAttribute("errorMessage", e.getMessage());
			}
			break;

		default:
			System.out.println("strange - the cpmmand is: " + command);
			break;
		}

		String path = "/ViewManager";
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
