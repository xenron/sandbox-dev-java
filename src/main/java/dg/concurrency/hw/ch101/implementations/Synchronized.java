package dg.concurrency.hw.ch101.implementations;

import dg.concurrency.hw.ch101.Counter;

public class Synchronized implements Counter
{
	private Object lock = new Object();
	
	private int counter;
	
	public long getCounter()
	{
		synchronized (lock)
		{
			return counter;
		}
	}
	
	public void increment() 
	{
		synchronized (lock)
		{
			++counter;
		}
	}
}
