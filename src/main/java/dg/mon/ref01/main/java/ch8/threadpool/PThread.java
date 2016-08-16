package ch8.threadpool;

import java.util.concurrent.FutureTask;


public class PThread extends Thread {
	private ThreadPool pool;
	private volatile FutureTask<?> target;
	private volatile boolean isShutDown = false;
	private volatile boolean isIdle = false;

	public PThread(FutureTask<?> target, String name, ThreadPool pool) {
		super(name);
		this.pool = pool;
		this.target = target;
	}

	public Runnable getTarget() {
		return target;
	}

	public boolean isIdle() {
		return isIdle;
	}

	public void run() {
		while (!isShutDown) {
			isIdle = false;
			if (target != null) {
				target.run();
			}
			isIdle = true;
			try {
				pool.repool(this);
				synchronized (this) {
					wait();
				}
			} catch (InterruptedException ie) {
			}
			isIdle = false;
		}
	}

	public synchronized void setTarget(FutureTask<?> newTarget) {
		target = newTarget;
 		notifyAll();
	}

	public synchronized void shutDown() {
		isShutDown = true;
		notifyAll();
	}
}
