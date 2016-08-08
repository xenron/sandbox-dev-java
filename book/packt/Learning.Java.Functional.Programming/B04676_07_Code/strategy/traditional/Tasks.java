package packt.strategy.traditional;

import java.util.ArrayList;
import java.util.List;

public class Tasks {
    private List<Task> tasks;
    private SchedulingStrategy strategy;
    
    public Tasks() {
        tasks = new ArrayList();
    }
    
    public void addTask(Task task) {
        tasks.add(task);
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void setStrategy(SchedulingStrategy strategy) {
        this.strategy = strategy;
    }
    
    public Task getNextTask() {
        return strategy.nextTask(tasks);
    }
}
