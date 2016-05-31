package dg.concurrency.hw.ch102;

import java.util.concurrent.TimeUnit;

public class TestDeadLock1 implements Runnable {
    private boolean flag;
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public TestDeadLock1(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (lock1) {
                System.out.println("线程" + Thread.currentThread().getName() + "：取得 lock1");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("线程" + Thread.currentThread().getName() + "：取得 lock2");
                }
            }
        } else {
            synchronized (lock2) {
                System.out.println("线程" + Thread.currentThread().getName() + "：取得 lock2");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("线程" + Thread.currentThread().getName() + "：取得 lock1");
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new TestDeadLock1(true));
        Thread thread2 = new Thread(new TestDeadLock1(false));
        thread1.start();
        thread2.start();
    }
}
