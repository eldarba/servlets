package b.zoo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ZooServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String name;
	private String address;
	private int zipCode;
	private List<Animal> animals = new ArrayList<>();

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.name = config.getInitParameter("name");
		this.address = config.getInitParameter("address");
		this.zipCode = Integer.parseInt(config.getInitParameter("zipCode"));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Animal animal = null;
		// get the type of animal to add
		String animalType = req.getParameter("animalType");
		switch (animalType) {
		case "dog":
			animal = new Dog();
			break;
		case "cat":
			animal = new Cat();
			break;
		default:
			break;
		}

		if (animal != null) {
			this.animals.add(animal);
		}

		PrintWriter out = resp.getWriter();
		out.println("animal added: " + animal);
	}

}
