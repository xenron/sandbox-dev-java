package packt.strategy.functional;

import java.util.List;

@FunctionalInterface
public interface SchedulingStrategy {
    Task nextTask(List<Task> tasks);
}
