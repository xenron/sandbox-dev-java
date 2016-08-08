package packt.strategy.traditional;

import java.util.List;

public class FCFSStrategy implements SchedulingStrategy {

    @Override
    public Task nextTask(List<Task> tasks) {
        return tasks.get(0);
    }    
}
