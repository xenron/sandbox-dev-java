package packt;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class FunctionalCommands {
    private final List<Supplier<Boolean>> commands = new ArrayList<>();

    public void addCommand(Supplier<Boolean> command) {
        commands.add(command);
    }

    public void executeCommand() {
        commands.forEach(Supplier::get);
        commands.clear();
    }    
}
