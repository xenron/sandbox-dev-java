package packt;

import java.util.ArrayList;
import java.util.List;

public class Command {
    private String command;
    private final List<String> arguments = new ArrayList<>();

    public void setCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
    
    public void addArgument(String argument) {
        this.arguments.add(argument);
    }

    public List<String> getArguments() {
        return arguments;
    }
    
    public void clear() {
        this.command = "";
        this.arguments.clear();
    }
}
