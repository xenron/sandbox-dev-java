package ch7;

public class ProdConDemo {
	 static IBlockingQueue<String> queue = new BlockingQueue<String>(200);
	  
	public static class Producer extends Thread {
	 
		@Override
		public void run(){
			//produce all the time
			int cnt = 1;
			while(true)
				try { 
					queue.put("item" + cnt);
					cnt ++;
					Thread.sleep(100);
				} catch (InterruptedException e) { 
					e.printStackTrace();
				}
		}
	}
	
	public static class Consumer extends Thread {
		@Override
		public void run(){
			while(true)
			{ 
				try {
				System.out.println(	queue.take());
				Thread.sleep(100);	
				} catch (InterruptedException e) { 
					e.printStackTrace();
				}
		}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Producer p1 = new Producer();
		Consumer c1 = new Consumer();
		c1.start();
		p1.start();
		Thread.sleep(1000*2);
		p1.join();
		c1.join();
		
	}
	
	
}
