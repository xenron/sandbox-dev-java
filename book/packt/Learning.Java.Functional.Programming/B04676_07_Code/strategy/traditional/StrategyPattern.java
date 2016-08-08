package packt.strategy.traditional;

import java.util.Arrays;

public class StrategyPattern {

    public static void main(String[] args) {
        Task tasks[] = {new Task("Quick",25), new Task("Longest",200), 
            new Task("Shortest",2), new Task("Slow",35)};
        
        Tasks taskList1 = new Tasks();
        taskList1.setTasks(Arrays.asList(tasks));
        taskList1.setStrategy(new STFStrategy());
        System.out.println(taskList1.getNextTask());
        
        Tasks taskList2 = new Tasks();
        taskList2.setTasks(Arrays.asList(tasks));
        taskList2.setStrategy(new FCFSStrategy());
        System.out.println(taskList2.getNextTask());
        
        taskList2.setStrategy(new LTFStrategy());
        System.out.println(taskList2.getNextTask());
    }
    
}
