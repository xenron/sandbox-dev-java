package dg.concurrency.hw.ch101.implementations;

import java.util.concurrent.atomic.LongAdder;

import dg.concurrency.hw.ch101.Counter;

public class Adder implements Counter
{
	private final LongAdder adder = new LongAdder();
	
	public long getCounter()
	{
		return adder.longValue();
	}
	
	public void increment()
	{
		adder.increment();
	}
}
