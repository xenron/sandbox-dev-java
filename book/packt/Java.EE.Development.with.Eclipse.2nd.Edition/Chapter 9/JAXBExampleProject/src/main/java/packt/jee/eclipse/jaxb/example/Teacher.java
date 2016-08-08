package packt.jee.eclipse.jaxb.example;

public class Teacher {
	private int id;
	private String name;
	
	public Teacher() {}
	
	public Teacher (int id, String name) {
		this.id = id;
		this.name = name;
	}

	//Getters and setters follow	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
