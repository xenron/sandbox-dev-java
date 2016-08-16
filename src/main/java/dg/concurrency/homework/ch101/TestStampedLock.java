package dg.concurrency.hw.ch101;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.locks.StampedLock;

public class TestStampedLock {

    static Date startTime;
    static Date endTime;

    public static void main(String[] args) {

        final TestStampedLock readWrite = new TestStampedLock();
        startTime = new Date();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    readWrite.put();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

        for (int i = 0; i < 19; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        readWrite.get();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }


    private Object data = null;
    StampedLock lock = new StampedLock();

    public void get() throws Exception {

        lock.tryReadLock();

        try {
            System.out.println(Thread.currentThread().getName() + " 准备读数据!");
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println(Thread.currentThread().getName() + "读出的数据为 :" + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.tryUnlockRead();

        }

    }

    public void put() throws Exception {

        lock.tryWriteLock();

        try {
            System.out.println(Thread.currentThread().getName() + " 准备写数据!");
            for (int i = 0; i < 100000; i++) {
                this.data = new Random().nextInt(1000);
                System.out.println(Thread.currentThread().getName() + " 写入的数据: " + data);
            }
            endTime = new Date();
            System.out.println("run time: " + String.valueOf((endTime.getTime() - startTime.getTime())/1000) + " s ");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.tryUnlockWrite();
        }
    }

}

