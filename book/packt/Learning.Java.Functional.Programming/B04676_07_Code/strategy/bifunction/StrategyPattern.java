package packt.strategy.bifunction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class StrategyPattern {

    public static void main(String[] args) {
        Comparator<Task> comparator = (x,y) -> x.getDuration()-y.getDuration();
        Function<List<Task>,Task> FCFSStrategy = t -> t.get(0);
        Function<List<Task>,Task> STFStrategy = t -> t.stream().min(comparator).get();
        Function<List<Task>,Task> LTFStrategy = t -> t.stream().max(comparator).get();
        
        Task tasks[] = {new Task("Quick", 25), new Task("Longest", 200),
            new Task("Fastest", 2), new Task("Slow", 35)};
                
        Tasks taskList1 = new Tasks();
        taskList1.setTasks(Arrays.asList(tasks));
        taskList1.setStrategy(STFStrategy);
        System.out.println(taskList1.getNextTask());

        Tasks taskList2 = new Tasks();
        taskList2.setTasks(Arrays.asList(tasks));
        taskList2.setStrategy(FCFSStrategy);
        System.out.println(taskList2.getNextTask());

        taskList2.setStrategy(LTFStrategy);
        System.out.println(taskList2.getNextTask());
    }

}
