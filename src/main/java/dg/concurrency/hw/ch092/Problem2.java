package dg.concurrency.hw.ch092;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Problem2 {
    public static void main(String[] args) {
        int numN = 300;      // could be 3,30,300,1000
        MyInt intVal = new MyInt(new AtomicInteger(0));
        ExecutorService exec = Executors.newFixedThreadPool(numN);
        final long start = System.currentTimeMillis();

        for(int i = 0; i < numN; i++) {
            exec.execute(new IncWithoutLock(intVal));
        }

        while(!exec.isTerminated()) {
            exec.shutdown();
        }

        long t = System.currentTimeMillis()-start;
        System.out.println("Use ["+t+"] ms to get "+intVal.getIntValue());
        //System.out.println(t);
    }

}
