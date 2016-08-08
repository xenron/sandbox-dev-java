package packt.strategy.bifunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Tasks {
    private List<Task> tasks;
    private Function<List<Task>,Task> strategy;
    
    public Tasks() {
        tasks = new ArrayList();
    }
    
    public void addTask(Task task) {
        tasks.add(task);
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void setStrategy(Function<List<Task>,Task> strategy) {
        this.strategy = strategy;
    }
    
    public Task getNextTask() {
        return strategy.apply(tasks);
    }
}
