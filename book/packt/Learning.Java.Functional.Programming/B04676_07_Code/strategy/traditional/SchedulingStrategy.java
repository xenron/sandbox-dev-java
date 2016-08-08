package packt.strategy.traditional;

import java.util.List;

public interface SchedulingStrategy {
    public Task nextTask(List<Task> tasks);
}
