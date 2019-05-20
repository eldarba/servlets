package b.schools;

public class Student {

	private static int counter;
	private final int id;
	private String name;

	{
		counter++;
		this.id = counter;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

}
