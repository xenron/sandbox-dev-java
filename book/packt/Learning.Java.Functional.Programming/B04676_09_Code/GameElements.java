package packt;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class GameElements {

    public static Map<String, Location> locations = new HashMap<>();
    public static Map<String, Item> items = new HashMap<>();
    public static Map<String, NPC> npcs = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> commands = new HashMap<>();
    public static Location currentLocation;

    public static void displayLocation(Location location) {
        System.out.println("-------------------");
        System.out.println("Name: " + location.getName());
        System.out.println("Description: " + location.getDescription());
        System.out.println("Items -------- ");

        location.getItems().forEach(name -> System.out.println(GameElements.items.get(name)));

        location.getNPCs().forEach(name -> System.out.println(GameElements.npcs.get(name)));
        System.out.println();
    }

    public static void displayView(Location location) {
        System.out.println(location.getDescription());
        GameElements.currentLocation.displayItems();
        GameElements.currentLocation.displayNPCs();
    }

    public static void displayDirections(Location location) {
        GameElements.currentLocation.displayPaths();
    }

}
