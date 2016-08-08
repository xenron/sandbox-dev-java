package packt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import static packt.GameElements.commands;

public class FunctionalZork {

    private final Scanner scanner;
    private Character character = null;
    private final FunctionalCommands fc;
    private final Command command = new Command();

    private Supplier<Boolean> dropCommand = () -> character.drop(command);
    private Supplier<Boolean> pickupCommand = () -> character.pickup(command);
    private Supplier<Boolean> walkCommand = () -> character.walk(command);
    private Supplier<Boolean> inventoryCommand = () -> character.inventory(command);
    private Supplier<Boolean> lookCommand = () -> {
        GameElements.displayView(GameElements.currentLocation);
        return true;
    };

    private Supplier<Boolean> directionsCommand = () -> {
        GameElements.currentLocation.displayPaths();
        return true;
    };
    private final Supplier<Boolean> quitCommand = () -> {
        System.out.println("Thank you for playing!");
        return true;
    };

    public void initializeCommands() {
        commands.put("drop", dropCommand);
        commands.put("Drop", dropCommand);
        commands.put("pickup", pickupCommand);
        commands.put("Pickup", pickupCommand);
        commands.put("walk", walkCommand);
        commands.put("go", walkCommand);
        commands.put("inventory", inventoryCommand);
        commands.put("inv", inventoryCommand);
        commands.put("look", lookCommand);
        commands.put("directions", directionsCommand);
        commands.put("dir", directionsCommand);
        commands.put("quit", quitCommand);
    }

    public static void main(String[] args) {
        String command = "";
        Stream<String> commandStream;
        FunctionalZork game = new FunctionalZork();
        while (!"Quit".equalsIgnoreCase(command)) {
            System.out.print(">> ");
            commandStream = game.getCommandStream();
            game.parseCommandStream(commandStream);
            command = game.executeCommand();
        }
    }

    public FunctionalZork() {
        scanner = new Scanner(System.in);
        fc = new FunctionalCommands();
        initializeGame();
        character = new Character(GameElements.currentLocation);
    }

    public void initializeGame() {
        System.out.println("Welcome to Functional Zork!\n");
        File file = new File("data.txt");
        try (FileInputStream fis = new FileInputStream(file);
                BufferedReader br = new BufferedReader(new InputStreamReader(fis))) {
            String line = br.readLine();
            while ("Location".equalsIgnoreCase(line)) {
                Location location = new Location()
                        .name(br.readLine())
                        .description(br.readLine());
                line = br.readLine();
                while ("Direction".equalsIgnoreCase(line)) {
                    // Add direction
                    location.addDirection(new Direction()
                            .direction(br.readLine())
                            .location(br.readLine())
                    );
                    line = br.readLine();
                }
                while ("Item".equalsIgnoreCase(line)) {
                    // Add items
                    Item item = new Item()
                            .name(br.readLine())
                            .description(br.readLine());
                    location.addItem(item.getName());
                    GameElements.items.put(item.getName(), item);
                    line = br.readLine();
                }
                while ("NPC".equalsIgnoreCase(line)) {
                    // Add NPC
                    // Imperative solution
                    NPC npc;
//                    npc = new NPC();
//                    npc.setName(br.readLine());
//                    npc.setDescription(br.readLine());
                    // Functional solution
                    npc = new NPC()
                            .name(br.readLine())
                            .description(br.readLine());
                    location.addNPC(npc.getName());
                    GameElements.npcs.put(npc.getName(), npc);
                    line = br.readLine();
                }
                GameElements.locations.put(location.getName(), location);
            }
            if ("StartingLocation".equalsIgnoreCase(line)) {
                GameElements.currentLocation = GameElements.locations.get(br.readLine());
                GameElements.displayView(GameElements.currentLocation);
            } else {
                System.out.println("Missing Starting Location");
            }
            initializeCommands();
            // Test imperative partial solution
//            executeCommandImperative("drop axe and rope");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String additionalProcessing(String token) {
        if (token.equalsIgnoreCase("drop")) {
            // Additional processing
        }
        return token;
    }

    public List<String> processCommand(String commandLine) {
        // Imperative solution
        // Stop words
        List<String> toRemove = Arrays.asList("a", "an", "the", "and");

        List<String> tokens = new ArrayList<>();
        for (String token : commandLine.split("\\s+")) {
            if (!toRemove.contains(token)) {
//                tokens.add(token);
                tokens.add(token.toLowerCase());

                // First approach
                String tmp = token.toLowerCase();
                tmp = additionalProcessing(tmp);
                tokens.add(tmp);

                // Second approach
                tokens.add(additionalProcessing(token.toLowerCase()));
            }
        }
        return tokens;
    }

    public Stream<String> getCommandStream() {
        String commandLine = scanner.nextLine();
//        processCommand(commandLine);

        // Stop words
        List<String> toRemove = Arrays.asList("a", "an", "the", "and");
        Stream<String> commandStream = Pattern
                .compile("\\s+")
                .splitAsStream(commandLine)
                .map(s -> additionalProcessing(s))
                //.map(s -> s.toLowerCase())
                .filter(s -> !toRemove.contains(s));

        return commandStream;
    }

    public void parseCommandStream(Stream<String> tokens) {
        command.clear();
        tokens
                .map(token -> {
                    if (commands.containsKey(token)) {
                        // Make sure this is done only once
                        command.setCommand(token);
                    } else {
                        command.addArgument(token);
                    }
                    return token;
                })
                .allMatch(token -> !"quit".equalsIgnoreCase(token));
    }

    public void executeDropCommand(String command, String arguments[]) {
        // Execute command
        System.out.print("Command: " + command);
        for (String arg : arguments) {
            System.out.print(" " + arg);
        }
        System.out.println();
    }

    public void executeCommandImperative(String commandLine) {
        // Imperative solution variation
        String tokens[] = commandLine.split("\\s+");
        String arguments[] = new String[tokens.length-1];
        int index = 0;
        String cmd = tokens[0];
        if (cmd.equalsIgnoreCase("drop")) {
            // Setup drop command
            while (index+1 < tokens.length) {
                arguments[index] = tokens[index+1];
                index++;
            }
            executeDropCommand(cmd, arguments);
        } else if (cmd.equalsIgnoreCase("pickup")) {
            // Setup drop command
        } else if (cmd.equalsIgnoreCase("go")) {
            // Setup drop command
        } else {
            // Bad command
        }
    }

    public String executeCommand() {
        Supplier<Boolean> nextCommand = commands.get(command.getCommand());
        if (nextCommand != null) {
            fc.addCommand(nextCommand);
            fc.executeCommand();
            return command.getCommand();
        } else {
            System.out.println("Bad commmand");
            return "";
        }

    }
}
