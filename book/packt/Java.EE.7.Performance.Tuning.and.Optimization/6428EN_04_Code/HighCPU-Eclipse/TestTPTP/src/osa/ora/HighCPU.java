/*
 * Written by Osama Oransa
 * This project is written for the book
 * Java Enterprise Edition 7 Performance Tuning (EN6428)
 */
package osa.ora;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Osama Oransa
 */
public class HighCPU {

    public static void main(String[] args) {
        ExecutorService execSvc = Executors.newFixedThreadPool(40);

        for (int i = 0; i < 1000; i++) {
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
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("running!!");
        int arraySize = 200000;
        int[] bigArray = new int[arraySize];
        //fill the array with random numbers
        for (int i = 0; i < arraySize; i++) {
            //bigArray[i] = ThreadLocalRandom.current().nextInt(50000);
            bigArray[i] = new Random().nextInt(50000);
        }
        Arrays.sort(bigArray);
        System.out.println("finished!");
    }
}
