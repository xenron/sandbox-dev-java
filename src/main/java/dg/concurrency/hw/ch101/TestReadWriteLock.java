package dg.concurrency.hw.ch101;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock {

    public static void main(String[] args) {

        final TestReadWriteLock readWrite = new TestReadWriteLock();

        Date startTime = new Date();


        for (int i = 0; i < 200; i++) {
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

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        readWrite.put(new Random().nextInt(8));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }

        Date endTime = new Date();
        System.out.println("run time: " + String.valueOf((endTime.getTime() - startTime.getTime())/1000) + " s ");

    }


    private Object data = null;
    ReadWriteLock rwlock = new ReentrantReadWriteLock();

    public void get() throws Exception {

        rwlock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + " 准备读数据!");
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println(Thread.currentThread().getName() + "读出的数据为 :" + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwlock.readLock().unlock();
        }

    }

    public void put(Object data) throws Exception {

        rwlock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + " 准备写数据!");
            Thread.sleep((long) (Math.random() * 1000));
            this.data = data;
            System.out.println(Thread.currentThread().getName() + " 写入的数据: " + data);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwlock.writeLock().unlock();
        }
    }

}

