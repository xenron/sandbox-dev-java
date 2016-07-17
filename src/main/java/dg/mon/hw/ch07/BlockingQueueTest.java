package dg.mon.hw.ch07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.concurrent.*;

public class BlockingQueueTest {
    private static final Logger log = LoggerFactory.getLogger(BlockingQueueTest.class);
    public final static int size1 = 1000000;
    public static BlockingQueue<Object> queue = new ArrayBlockingQueue<Object>(size1);
    public final static int threadNumber = 10;
    public static boolean isOver = false;

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        new Thread(new Runnable() {
            public void run() {
                ExecutorService executorService = Executors.newFixedThreadPool(threadNumber);
                ArrayList<Future<Long>> results = new ArrayList<Future<Long>>();
                for (int i = 0; i < threadNumber; i++) {
                    Future<Long> future = executorService.submit(new BlockingQueue_Push());
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
                BlockingQueueTest.isOver = true;
                log.info("入队列总共执行时间：" + allTime);
            }
        }).start();


        new Thread(new Runnable() {
            public void run() {
                ExecutorService executorService2 = Executors.newFixedThreadPool(threadNumber);
                ArrayList<Future<Long>> results_out = new ArrayList<Future<Long>>();
                for (int i = 0; i < threadNumber; i++) {
                    Future<Long> future = executorService2.submit(new BlockingQueue_Pull());
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

class BlockingQueue_Push implements Callable<Long> {

    @Override
    public Long call() throws Exception {
        long time = System.currentTimeMillis();

        for (int i = 0; i < BlockingQueueTest.size1; i++) {
            BlockingQueueTest.queue.offer(i);
        }

        long time2 = System.currentTimeMillis() - time;
        return time2;
    }
}

class BlockingQueue_Pull implements Callable<Long> {

    @Override
    public Long call() throws Exception {
        long time = System.currentTimeMillis();

        while (!BlockingQueueTest.isOver) {
            BlockingQueueTest.queue.poll();
        }

        long time2 = System.currentTimeMillis() - time;
        return time2;
    }
}
