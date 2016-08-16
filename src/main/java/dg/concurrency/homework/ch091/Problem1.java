package dg.concurrency.hw.ch091;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Problem1 {
    public static void main(String[] args) {
        int numN = 3;    // could be 3,30,300,1000
        MyInt intVal = new MyInt(0);
        ExecutorService exec = Executors.newFixedThreadPool(numN);
        final long start = System.currentTimeMillis();

        for(int i = 0; i < numN; i++) {
            exec.execute(new IncWithLock(intVal));
        }

        while(!exec.isTerminated()) {
            exec.shutdown();
        }

        long t = System.currentTimeMillis()-start;
        System.out.println("Use ["+t+"] ms to get "+intVal.getIntValue());
        //System.out.println(t);
    }

}
