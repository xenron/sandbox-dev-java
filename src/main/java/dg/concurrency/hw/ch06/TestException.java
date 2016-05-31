package dg.concurrency.hw.ch06;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class TestException {
    static class ExecuteRunnable implements Runnable {
        CountDownLatch countDownLatch;
        int i;

        public ExecuteRunnable(CountDownLatch countDownLatch, int i) {
            this.countDownLatch = countDownLatch;
            this.i = i;
        }

        @Override
        public void run() {
            Integer in = null;
            int a = 5;
            int b = 0;
            int c = a / b;
        }
    }

    public static void main(String[] args) {

        LogExceptionThreadFactory factory = new LogExceptionThreadFactory();
        ExecutorService executor = Executors.newFixedThreadPool(10, factory);
        CountDownLatch countDownLatch = new CountDownLatch(10000);
        try {
            for (int i = 0; i < 10000; i++) {
                executor.execute(new ExecuteRunnable(countDownLatch, i));
            }
        } catch (Throwable e) {
            System.out.println("子线程异常未被捕获");
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            System.out.println("Failed to wait all sub threads to complete");
        }
    }
}

class LogExceptionThreadFactory implements ThreadFactory {
    private static final ThreadFactory DEFAULT_THREAD_FACTORY = Executors.defaultThreadFactory();
    private volatile boolean runStatus = Boolean.TRUE;

    @Override
    public Thread newThread(Runnable r) {
        if (r == null) throw new NullPointerException();
        Thread t = DEFAULT_THREAD_FACTORY.newThread(r);
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("子线程出现异常，子线程ID:" + t.getId() + "，异常信息：" + e.getMessage());
                runStatus = Boolean.FALSE;
            }
        });
        return t;
    }

    public boolean isRunStatus() {
        return runStatus;
    }

    public void setRunStatus(boolean runStatus) {
        this.runStatus = runStatus;
    }

}
