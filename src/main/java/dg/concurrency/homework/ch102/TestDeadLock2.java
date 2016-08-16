package dg.concurrency.hw.ch102;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TestDeadLock2 implements Runnable {
    private boolean flag;
    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();

    public TestDeadLock2(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            if (flag) {
                lock1.lock();
                System.out.println("线程" + Thread.currentThread().getName() + "：取得 lock1");
                TimeUnit.SECONDS.sleep(1);
                lock2.lock();
                System.out.println("线程" + Thread.currentThread().getName() + "：取得 lock2");
            } else {
                lock2.lock();
                System.out.println("线程" + Thread.currentThread().getName() + "：取得 lock2");
                TimeUnit.SECONDS.sleep(1);
                lock1.lock();
                System.out.println("线程" + Thread.currentThread().getName() + "：取得 lock1");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new TestDeadLock2(true));
        Thread thread2 = new Thread(new TestDeadLock2(false));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
