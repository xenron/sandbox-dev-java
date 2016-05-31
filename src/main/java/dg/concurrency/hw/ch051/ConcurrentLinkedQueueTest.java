package dg.concurrency.hw.ch051;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.concurrent.*;

public class ConcurrentLinkedQueueTest {
    private static final Logger log = LoggerFactory.getLogger(ConcurrentLinkedQueueTest.class);
    public static ConcurrentLinkedQueue<Object> queue = new ConcurrentLinkedQueue<Object>();
    public final static int size1 = 1000000;
    public final static int threadNumber = 10;
    public static boolean isOver = false;

    public static void main(String[] args) throws InterruptedException,
            ExecutionException {

        new Thread(new Runnable() {
            public void run() {
                ExecutorService executorService = Executors.newFixedThreadPool(threadNumber);
                ArrayList<Future<Long>> results = new ArrayList<Future<Long>>();
                for (int i = 0; i < threadNumber; i++) {
                    Future<Long> future = executorService.submit(new ConcurrentLinkedQueue_Push());
                    results.add(future);
                }

                long allTime = 0;
                for (Future<Long> fs : results) {
                    try {
                        allTime += fs.get();
                    } catch (InterruptedException e) {
                        log.info("" + e);
                        return;
                    } catch (ExecutionException e) {
                        log.info("" + e);
                    } finally {
                        executorService.shutdown();
                    }
                }
                ConcurrentLinkedQueueTest.isOver = true;
                log.info("入队列总共执行时间：" + allTime);
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                ExecutorService executorService2 = Executors.newFixedThreadPool(threadNumber);
                ArrayList<Future<Long>> results_out = new ArrayList<Future<Long>>();
                for (int i = 0; i < threadNumber; i++) {
                    Future<Long> future = executorService2.submit(new ConcurrentLinkedQueue_Pull());
                    results_out.add(future);
                }

                long allTime_out = 0;
                for (Future<Long> fs : results_out) {
                    try {
                        allTime_out += fs.get();
                        // log.info("" + fs.get());
                    } catch (InterruptedException e) {
                        log.info("" + e);
                        return;
                    } catch (ExecutionException e) {
                        log.info("" + e);
                    } finally {
                        executorService2.shutdown();
                    }
                }
                log.info("出队列总共执行时间：" + allTime_out);
            }
        }).start();
    }
}

class ConcurrentLinkedQueue_Push implements Callable<Long> {

    @Override
    public Long call() throws Exception {
        long time = System.currentTimeMillis();

        for (int i = 0; i < ConcurrentLinkedQueueTest.size1; i++) {
            ConcurrentLinkedQueueTest.queue.offer(i);
        }

        long time2 = System.currentTimeMillis() - time;
        return time2;
    }
}

class ConcurrentLinkedQueue_Pull implements Callable<Long> {

    @Override
    public Long call() throws Exception {
        long time = System.currentTimeMillis();
        while (!ConcurrentLinkedQueueTest.isOver) {
            ConcurrentLinkedQueueTest.queue.poll();
        }
        long time2 = System.currentTimeMillis() - time;
        return time2;
    }
}
