package packt.strategy.functional;

import java.util.Arrays;
import java.util.Comparator;

public class StrategyPattern {

    public static void main(String[] args) {
        SchedulingStrategy STF = t -> {
            Task shortest = t.get(0);
            for (Task task : t) {
                if (shortest.getDuration() > task.getDuration()) {
                    shortest = task;
                }
            }
            return shortest;
        };

        // Replace with Stream implementation
        Comparator<Task> comparator = (x,y) -> x.getDuration()-y.getDuration();
//                (x.getDuration()<y.getDuration())? -1 : 
//                        ((x.getDuration() > y.getDuration()) ? 1 : 0);
        SchedulingStrategy FCFSStrategy = t -> t.get(0);
        SchedulingStrategy STFStrategy = t -> t.stream().min(comparator).get();
        SchedulingStrategy LTFStrategy = t -> t.stream().max(comparator).get();
        
        Task tasks[] = {new Task("Quick", 25), new Task("Longest", 200),
            new Task("Shortest", 2), new Task("Slow", 35)};
                
        Tasks taskList1 = new Tasks();
        taskList1.setTasks(Arrays.asList(tasks));
        taskList1.setStrategy(STFStrategy);
//        taskList1.setStrategy(t -> {
//            Task shortest = t.get(0);
//            for (Task task : t) {
//                if (shortest.getDuration() > task.getDuration()) {
//                    shortest = task;
//                }
//            }
//            return shortest;
//        });
        System.out.println(taskList1.getNextTask());

        Tasks taskList2 = new Tasks();
        taskList2.setTasks(Arrays.asList(tasks));
//        taskList2.setStrategy(t -> t.get(0));
        taskList2.setStrategy(FCFSStrategy);
        System.out.println(taskList2.getNextTask());

        taskList2.setStrategy(LTFStrategy);
        System.out.println(taskList2.getNextTask());
    }

}
