/*
 * Written by Osama Oransa
 * This project is written for the book
 * Java Enterprise Edition 7 Performance Tuning (EN6428).
 */
package osa.ora.outofmemory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Osama Oransa
 */
public class TooManyThreads {

    /**
     * test main method
     *
     * @param args
     */
    public static void main(String args[]) {
        new TooManyThreads().createThreads();
    }

    /**
     * method to create big number of threads
     */
    public void createThreads() {
        int threadPoolSize = 100;
        while (true) {
            System.out.println("Thread size=" + threadPoolSize);
            ExecutorService execSvc = Executors.newFixedThreadPool(threadPoolSize);

            for (int i = 0; i < threadPoolSize; i++) {
                execSvc.execute(new MyThread());
            }
            //check if executor service finished executing threads
            while (!execSvc.isTerminated()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    //
                }
                execSvc.shutdown();
            }
            threadPoolSize *= 10;
        }
    }

    /**
     * internal class that wraps Thread class so we can trace it in our
     * analysis.
     */
    class MyThread implements Runnable {

        @Override
        public void run() {
            //do no thing
        }
    }
}
