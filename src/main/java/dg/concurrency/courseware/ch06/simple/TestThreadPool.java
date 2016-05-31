package dg.concurrency.courseware.ch06.simple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * ʹ�ü��̳߳غ�ֱ�ӿ����̵߳Ĳ��
 * @author Administrator
 *
 */
public class TestThreadPool {
	public static class MyThread implements Runnable{
		protected String name;
		public MyThread(){
		}
		public MyThread(String name){
			this.name=name;
		}
		@Override
		public void run() {
			try {
				Thread.sleep(100);
				//System.out.print(name+" ");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public  static void main(String args[]) throws InterruptedException {
		long starttime=System.currentTimeMillis();
		for(int i=0;i<1000;i++){
			ThreadPool.getInstance().start(new MyThread("testThreadPool"+Integer.toString(i)));
		}
		
		long endtime=System.currentTimeMillis();
		System.out.println("testThreadPool"+": "+(endtime-starttime));
		System.out.println("getCreatedThreadsCount:"+ThreadPool.getInstance().getCreatedThreadsCount());
		Thread.sleep(1000);
	}
	

}
