package ch8.pattern.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureMain {
	public static void main(String[] args) throws InterruptedException,ExecutionException {
		FutureTask<String> future = new FutureTask<String>(new RealData("a"));
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.submit(future);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
		System.out.println("value = " + future.get());
	}
}
