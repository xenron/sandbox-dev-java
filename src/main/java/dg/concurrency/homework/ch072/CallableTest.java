package dg.concurrency.hw.ch072;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableTest {
    public static void main(String[] args) throws Exception {
//        test1();
//        test2();
//        test3();
        test4();
    }

    /**
     * 以BlockingQueue阻塞队列显式的接受子线程的返回值，操控灵活
     *
     * @throws Exception
     */
    public static void test1() throws Exception {
        ExecutorService pool = Executors.newCachedThreadPool();
        BlockingQueue<Future<String>> blockingQueue = new ArrayBlockingQueue<Future<String>>(10);
        CompletionService<String> service = new ExecutorCompletionService<String>(pool, blockingQueue);
        // 相当于是用来存放Executor执行的结果的一种容器
        for (int i = 0; i < 10; i++) {
            Callable<String> callable = new TaskWithResult(i);
            service.submit(callable);
        }
        String string = null;
        int count = 0;
        while (true) {
            Future<String> future = blockingQueue.take();
            string = future.get();
            count++;
            System.out.println(future.isDone() + "..value:===" + string);
            if (count == 10) {
                break;
            }
        }
        pool.shutdown();
    }

    /**
     * 用 Join()方法等待所有子线程执行完，再收集执行结果
     *
     * @throws Exception
     */
    public static void test2() throws Exception {
        List<Thread> list = new ArrayList<Thread>();
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<FutureTask<String>> results = new ArrayList<FutureTask<String>>(); // Future
        // 相当于是用来存放Executor执行的结果的一种容器
        for (int i = 0; i < 10; i++) {
            Callable<String> callable = new TaskWithResult(i);
            FutureTask<String> futureTask = new FutureTask<String>(callable);
            Thread thread = new Thread(futureTask);
            thread.start();
            results.add(futureTask);
            list.add(thread);
        }
        long time0 = System.currentTimeMillis();
        for (Thread thread : list) {
            thread.join();
        }
        System.out.println("共耗时:" + (System.currentTimeMillis() - time0));

        String string = null;
        for (FutureTask<String> fs : results) {
            if (fs.isDone()) {
                try {
                    string = fs.get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(string);
            } else {
                System.out.println("is not done!");
            }
        }
        exec.shutdown();
    }

    /**
     * 此种方式获取子线程的值是最为方便
     *
     * @throws Exception
     */
    public static void test3() throws Exception {
        ExecutorService pool = Executors.newCachedThreadPool();
        CompletionService<String> service = new ExecutorCompletionService<String>(pool);
        // 相当于是用来存放Executor执行的结果的一种容器
        for (int i = 0; i < 10; i++) {
            Callable<String> callable = new TaskWithResult(i);
            service.submit(callable);
        }

        String string = null;
        for (int i = 0; i < 10; i++) {
            Future<String> future = service.take();//阻塞模式循环获取队列的值
            string = future.get();
            System.out.println(string);
        }
        pool.shutdown();
    }

    /**
     * 以BlockingQueue阻塞队列显式的接受子线程的返回值，操控灵活
     *
     * @throws Exception
     */
    public static void test4() throws Exception {
//        ExecutorService pool = Executors.newCachedThreadPool();
////        BlockingQueue<Future<String>> blockingQueue = new ArrayBlockingQueue<Future<String>>(10);
//        BlockingQueue<Future<Message>> blockingQueue = new ArrayBlockingQueue<Future<Message>>(10);
//        Producer producer = new Producer(blockingQueue);
//        Consumer consumer = new Consumer(blockingQueue);
//        CompletionService<Message> service = new ExecutorCompletionService<Message>(pool, blockingQueue);
//        // 相当于是用来存放Executor执行的结果的一种容器
//        for (int i = 0; i < 10; i++) {
//            Callable<String> callable = new TaskWithResult(i);
//            service.submit(callable);
//        }
//        String string = null;
//        int count = 0;
//        while (true) {
//            Future<String> future = blockingQueue.take();
//            string = future.get();
//            count++;
//            System.out.println(future.isDone() + "..value:===" + string);
//            if (count == 10) {
//                break;
//            }
//        }
//        pool.shutdown();

//        //创建大小为10的 BlockingQueue
//        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
//        Producer producer = new Producer(queue);
//        Consumer consumer = new Consumer(queue);
//        //开启 producer线程向队列中生产消息
//        new Thread(producer).start();
//        //开启 consumer线程 中队列中消费消息
//        new Thread(consumer).start();
//        System.out.println("Producer and Consumer has been started");
    }
}
