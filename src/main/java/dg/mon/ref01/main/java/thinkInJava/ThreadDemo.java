package thinkInJava;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
class  ThreadDemo
{
	class Demo extends Object
	{
		public void finalize()
		{
System.out.println("demo ok");
		}
	}
	
	
	class ticket implements Runnable
	{

		public void run() {
			while(true)
			{
				try {
System.out.println(getCurrentTimeStamp("yyyyMMddHHmmss"));
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	String getCurrentTimeStamp(String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date d = new Date();
		return sdf.format(d);
	}
	
	class Bank implements Serializable
	{
		private static final long serialVersionUID = 1L;
		private int sum;
		private Object obj = new Object();
		public void Add(int val)
		{
			synchronized(obj)
			{
				sum +=val;
System.out.println("bank sum is increacing to :" + sum);
			}
		}
	}
	
	class UseBank implements Runnable
	{
		private Bank bank = new Bank();
		public void run() {
			for (int i =0;i<3;i++)
				bank.Add(100);
		}
		
	}
	
	public static void main(String[] args) 
	{
		//new ThreadDemo().new Demo();
		//new ThreadDemo().new Demo();
		//new ThreadDemo().new Demo();
		//new ThreadDemo().new ticket().run();
		UseBank ub = new ThreadDemo().new UseBank();
		Thread t1 = new Thread(ub);
		Thread t2 = new Thread(ub);
		t1.start();
		t2.start();
		
		System.gc();
		System.out.println("Hello World!");
	
	}
}

