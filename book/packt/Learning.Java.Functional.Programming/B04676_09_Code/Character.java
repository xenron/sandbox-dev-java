package packt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Character {

    private final List<String> items = new ArrayList<>();
    private Location location;

    public Character(Location currentLocation) {
        this.location = currentLocation;
    }

    public boolean pickup(Command command) {
        List<String> arguments = command.getArguments();
        arguments.stream()
                .filter(itemName -> {
                    if (this.location.getItems().contains(itemName)) {
                        return true;
                    } else {
                        System.out.println("Cannot pickup " + itemName);
                        return false;
                    }
                })
                .forEach(itemName -> {
                    items.add(itemName);
                    this.location.getItems().remove(itemName);
                    System.out.println("Picking up " + itemName);
                });
        return true;
    }

    public boolean drop(Command command) {
        List<String> arguments = command.getArguments();
        if (arguments.isEmpty()) {
            System.out.println("Drop what?");
            return false;
        } else {
            boolean droppedItem = false;

            // Functional solution - does not modify droppedItem
//            arguments.stream()
//                    .map(itemName -> {
//                        if (items.remove(itemName)) {
//                            this.location.addItem(itemName);
//                            return "Dropping " + itemName;
//                        } else {
//                            return "Cannot drop " + itemName;
//                        }
//                    })
//                    .forEach(System.out::println);

                for (String itemName : arguments) {
                    droppedItem = items.remove(itemName);
                    if (droppedItem) {
                        this.location.addItem(itemName);
                        System.out.println("Dropping " + itemName);
                        droppedItem = true;
                    } else {
                        System.out.println("Cannot drop " + itemName);
                    }
                }
            return droppedItem;
        }
    }

    public boolean walk(Command command) {
        List<String> directions = command.getArguments();
        if (directions.isEmpty()) {
            System.out.println("Go where?");
            return false;
        } else {
            directions.forEach((direction) -> {
                Optional<String> locationName = GameElements.currentLocation.getLocation(direction);
                System.out.print(locationName
                        .map(name -> {
                            Location newLocation = GameElements.locations.get(name);
                            this.location = newLocation;
                            GameElements.currentLocation = newLocation;
                            GameElements.displayView(GameElements.currentLocation);
                            return "";
                        })
                        .orElse("However, you can't go " + direction + "\n"));
            });
            return true;
        }
    }

    public boolean inventory(Command command) {
        //List<String> arguments = command.getArguments();
        if (items.isEmpty()) {
            System.out.println("You are holding nothing");
        } else {
            System.out.print("You are holding:");
            this.items.forEach((item) -> {
                System.out.print(" " + item);
            });
            System.out.println();
        }
        return true;
    }
}
