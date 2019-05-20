package b.schools;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SchoolServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String name;
	private String address;
	private int zipCode;
	private List<Student> students = new ArrayList<>();

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.name = config.getInitParameter("name");
		this.address = config.getInitParameter("address");
		this.zipCode = Integer.parseInt(config.getInitParameter("zipCode"));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println(this + "<br>");

		Student student = new Student();
		String name = req.getParameter("name");
		student.setName(name);
		this.students.add(student);
		out.println("student added: " + student);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println(this + "<br>");
		out.println("List of Students ===" + "<br>");
		for (Student student : students) {
			out.println(student + "<br>");
		}
	}

	@Override
	public String toString() {
		return "SchoolServlet [name=" + name + ", address=" + address + ", zipCode=" + zipCode + "]";
	}

}
