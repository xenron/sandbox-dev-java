package packt;

public class NPC {
    private String name;
    private String description;

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public NPC name(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NPC description(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "Name: " + name + "   Description: " + description;
    }
}
