package dg.concurrency.hw.ch101.implementations;

import dg.concurrency.hw.ch101.Counter;

public class Dirty implements Counter
{
	private long counter;
	
	public long getCounter()
	{
		return counter;
	}
	
	public void increment() 
	{
		++counter;
	}
}
