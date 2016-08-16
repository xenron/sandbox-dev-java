package ch8.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadPoolDemo {
	
	static class TestThread implements Callable<String> {
		static volatile int handlerCount = 0;
		TestThread(){
			handlerCount ++;
		} 
		@Override
		public String call() throws Exception {
 			return "items " + handlerCount;
		}
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ThreadPool pool = ThreadPool.getInstance();
		for(int i=0;i<5;i++){
			FutureTask<String> ft = new FutureTask<String>(new TestThread());
			 pool.start(ft);
			 System.out.println(ft.get());
			 Thread.sleep(1000);
		}
		pool.shutdown();
	}
}
