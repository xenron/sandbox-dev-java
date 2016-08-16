package ch7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
 
public class BlockingQueue<T> implements IBlockingQueue<T> {
	public static ReentrantLock lock=new ReentrantLock();
	public static Condition condition = lock.newCondition();
	private Queue<T> queue = new LinkedList<T>();
	private int capacity;

	public BlockingQueue(int capacity) {
		this.capacity = capacity;
	}

	public void put(T element) throws InterruptedException {
		lock.lock();
		while (queue.size() == capacity) {
			condition.await();
		}
		queue.add(element);
		condition.signalAll();
		lock.unlock();
		
	}

	public T take() throws InterruptedException {
		lock.lock();
		while (queue.isEmpty()) {
			condition.await();
		}
		T item = queue.remove();
		
		condition.signalAll();
		lock.unlock();
		return item;
	}
}
