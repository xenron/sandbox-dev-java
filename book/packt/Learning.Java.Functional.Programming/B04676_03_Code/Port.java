package packt;

import java.util.ArrayList;
import java.util.List;

public class Port {
    private List<Boat> boats = new ArrayList();
    
    public Boat add(String name) {
        Boat boat = new Boat().named(name);
        boats.add(boat);
        System.out.println("Added: " + boat);
        return boat;
    }

    public Boat add(Boat boat) {
        boats.add(boat);
        System.out.println("Added: " + boat);
        return boat;
    }
}
