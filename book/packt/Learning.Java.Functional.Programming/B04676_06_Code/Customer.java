package packt;

import java.util.Optional;

public class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Customer(int id) {
        this.id = id;
        this.name = "Default Name";
    }

    public Customer(int id, Optional<String> name) {
        this.id = id;
//        this.name = name.get();
        if(name.isPresent()) {
            this.name = name.get();
        } else {
            this.name = "Default Name";
        }
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
        return "Customer{" + "id=" + id + ", name=" + name + '}';
    }
}
