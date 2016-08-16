package dg.concurrency.hw.ch101.implementations;

import dg.concurrency.hw.ch101.Counter;

public class Volatile implements Counter
{
	private volatile long counter;
	
	public long getCounter()
	{
		return counter;
	}
	
	public void increment() 
	{
		++counter;
	}
}