package dg.concurrency.courseware.ch05;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterLock2 implements Runnable{
	public static ReentrantLock lock=new ReentrantLock();
	public static int i=0;
	@Override
	public void run() {
		for(int j=0;j<10000000;j++){
			lock.lock();
			lock.lock();
			try{
				i++;
			}finally{
				lock.unlock();
				lock.unlock();
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		ReenterLock2 tl=new ReenterLock2();
		Thread t1=new Thread(tl);
		Thread t2=new Thread(tl);
		t1.start();t2.start();
		t1.join();t2.join();
		System.out.println(i);
	}
}

