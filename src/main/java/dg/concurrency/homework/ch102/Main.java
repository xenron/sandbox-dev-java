package dg.concurrency.hw.ch102;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main
{
	public static long TARGET_NUMBER 	= 100000000l;
	public static int READ_THREADS 			= 10;
	public static int WRITE_THREADS 			= 1;
	public static int ROUNDS 			= 1;
	private static String COUNTER 		= Counters.STAMPED.toString();
	
	private static ExecutorService es;
	
	private static int round;
	private static long start;
	
	private static Boolean[] rounds;
	
	private static enum Counters
	{
		ReadWriteLockTet,
		STAMPED
	}
	
	public static void main(String[] args)
	{
		COUNTER = Counters.ReadWriteLockTet.toString();
		
		rounds = new Boolean[ROUNDS];
		
		System.out.println("Using " + COUNTER + ". threads: " + ". rounds: " + ROUNDS + ". Target: " + TARGET_NUMBER);
		
		for (round = 0; round < ROUNDS; round++)
		{
			rounds[round] = Boolean.FALSE;
			
			Counter counter = getCounter();
			
			es = Executors.newFixedThreadPool(WRITE_THREADS + READ_THREADS);
			
			start = System.currentTimeMillis();

			for (int j = 0; j < WRITE_THREADS; j++)
			{
				es.execute(new Writer(counter));
			}
			for (int j = 0; j < READ_THREADS; j++)
			{	
				es.execute(new Reader(counter));
			}
			
			try
			{
				es.awaitTermination(10, TimeUnit.MINUTES);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static Counter getCounter()
	{
		Counters counterTypeEnum = Counters.valueOf(COUNTER);
		
		switch (counterTypeEnum)
		{
			case ReadWriteLockTet:
				return new ReadWriteLockTet();
			case STAMPED:
				return new StampedLockTest();
		}
		
		return null;
	}
	
	public static void publish(long end)
	{
		synchronized (rounds[round])
		{
			if (rounds[round] == Boolean.FALSE)
			{
				System.out.println(end-start);
				
				rounds[round] = Boolean.TRUE;
				
				es.shutdownNow();
			}
		}
	}
}
