package dg.concurrency.hw.ch101.implementations;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import dataguru.concurrency.hw.ch101.Counter;

public class RWLock implements Counter
{
	private ReadWriteLock rwlock = new ReentrantReadWriteLock();
	
	private Lock rlock = rwlock.readLock();
	private Lock wlock = rwlock.writeLock();
	
	private long counter;
	
	public long getCounter()
	{
		try
		{
			rlock.lock();		
			return counter;
		}
		finally
		{
			rlock.unlock();
		}
	}
	
	public void increment()
	{
		try
		{
			wlock.lock();		
			++counter;
		}
		finally
		{
			wlock.unlock();
		}
	}
}
