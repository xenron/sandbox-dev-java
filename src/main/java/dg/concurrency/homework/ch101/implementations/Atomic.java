package dg.concurrency.hw.ch101.implementations;

import java.util.concurrent.atomic.AtomicLong;

import dg.concurrency.hw.ch101.Counter;

public class Atomic implements Counter
{
	private final AtomicLong atomic = new AtomicLong();
	
	public long getCounter()
	{
		return atomic.get();
	}
	
	public void increment()
	{
		atomic.incrementAndGet();
	}
}
