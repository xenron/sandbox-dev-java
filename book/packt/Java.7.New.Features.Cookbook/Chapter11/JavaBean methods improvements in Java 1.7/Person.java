package packt;

public class Person {
    private String name;

    public Person() {
        this("Jane", 23);
    }

    public Person(String name, int age) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }  
}

