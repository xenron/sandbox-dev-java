package packt.strategy.traditional;

import java.util.List;

public class LTFStrategy implements SchedulingStrategy {

    @Override
    public Task nextTask(List<Task> tasks) {
        Task longest = tasks.get(0);
        for(Task task : tasks) {
            if(longest.getDuration() < task.getDuration()) {
                longest = task;
            }
        }
        return longest;
    }    
}
