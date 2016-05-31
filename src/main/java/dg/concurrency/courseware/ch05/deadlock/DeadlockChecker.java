package dg.concurrency.courseware.ch05.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DeadlockChecker {
	private final static ThreadMXBean mbean = ManagementFactory.getThreadMXBean();
	final static Runnable deadlockCheck = new Runnable() {
		@Override
		public void run() {
			while (true) {
				long[] deadlockedThreadIds = mbean.findDeadlockedThreads();
				if (deadlockedThreadIds != null) {
					ThreadInfo[] threadInfos = mbean.getThreadInfo(deadlockedThreadIds);
					for (Thread t : Thread.getAllStackTraces().keySet()) {
						for (int i = 0; i < threadInfos.length; i++) {
							if (t.getId() == threadInfos[i].getThreadId()) {
								t.interrupt();
							}
						}
					}
				}
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
				}
			}
		}
	};

	public static void check() {
		Thread t = new Thread(deadlockCheck);
		t.setDaemon(true);
		t.start();
	}
}
