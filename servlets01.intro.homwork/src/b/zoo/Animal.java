package b.zoo;

public abstract class Animal {

	private static int counter;
	private final int id;

	{
		counter++;
		this.id = counter;
	}

	public abstract String speak();

	public int getId() {
		return id;
	}

}
