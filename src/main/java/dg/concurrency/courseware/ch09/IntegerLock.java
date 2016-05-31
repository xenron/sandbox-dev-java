package dg.concurrency.courseware.ch09;

public class IntegerLock {
	static Integer i=0;
	public static class AddThread extends Thread{
		public void run(){
			for(int k=0;k<100000;k++){
				synchronized(i){
					i++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		AddThread t1=new AddThread();
		AddThread t2=new AddThread();
		t1.start();t2.start();
		t1.join();t2.join();
		System.out.println(i);
	}
}
