package dg.concurrency.hw.ch072;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) throws InterruptedException {

        this.id = id;
    }

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        return "result of TaskWithResult " + id;
    }
}
