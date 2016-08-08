package packt;

public class Item {
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public Item name(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Item description(String description) {
        this.description = description;
        return this;
    }
    
    @Override
    public String toString() {
            return "Name: " + this.name + "  Description: " + this.description;
    }
}
