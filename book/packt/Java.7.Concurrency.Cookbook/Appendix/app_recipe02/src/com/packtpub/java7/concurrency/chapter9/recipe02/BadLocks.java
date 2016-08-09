package com.packtpub.java7.concurrency.chapter9.recipe02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class BadLocks {

	private Lock lock1, lock2;
	
	public BadLocks(Lock lock1, Lock lock2) {
		this.lock1=lock1;
		this.lock2=lock2;
	}
	
	public void operation1(){
		lock1.lock();
		lock2.lock();
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock2.unlock();
			lock1.unlock();
		}
		
	}

	public void operation2(){
		lock2.lock();
		lock1.lock();
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock1.unlock();
			lock2.unlock();
		}
		
	}

}
