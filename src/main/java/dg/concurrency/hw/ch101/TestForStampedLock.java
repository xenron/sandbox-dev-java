package dg.concurrency.hw.ch101;

import java.util.concurrent.locks.StampedLock;

public class TestForStampedLock {

    public static void main(String[] args) throws InterruptedException {
        StampedLock lock = new StampedLock();
        new Thread(new WriteThread(lock)).start();
        Thread.sleep(200);
        for (int i = 0; i < 20; ++i)
            new Thread(new ReadThread(lock)).start();
    }

    private static class WriteThread implements Runnable {
        private StampedLock lock;

        public WriteThread(StampedLock lock) {
            this.lock = lock;
        }

        public void run() {
            long writeLong = lock.writeLock();
            System.out.println(Thread.currentThread().getName() + " WRITE");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlockWrite(writeLong);
        }
    }

    private static class ReadThread implements Runnable {
        private StampedLock lock;

        public ReadThread(StampedLock lock) {

            this.lock = lock;
        }

        public void run() {
            long readLong = lock.readLock();
            System.out.println(Thread.currentThread().getName() + " READ");
            lock.unlockRead(readLong);
        }
    }

}
