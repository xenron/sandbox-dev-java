package packt;

public class Direction {
    private String direction;
    private String location;

    public Direction() {
        this.direction = "";
        this.location = "";
    }
    
    public Direction(String direction, String location) {
        this.direction = direction;
        this.location = location;
    }
    public String getDirection() {
        return direction;
    }

    public Direction direction(String direction) {
        this.direction = direction;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Direction location(String location) {
        this.location = location;
        return this;
    }
}
