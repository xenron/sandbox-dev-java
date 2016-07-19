package com.bedpotato.Algorithms.C1;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
	private Node first;
	private Node last;
	private int number;

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		System.out.println(queue.dequque());
		queue.enqueue(3);
		queue.enqueue(4);
		System.out.println(queue.dequque());
		System.out.println(queue.dequque());
	}

	private class Node {
		T item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return number;
	}

	public void enqueue(T item) {
		Node lastOld = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			lastOld.next = last;
		}
		number++;
	}

	public T dequque() {
		T item = first.item;
		first = first.next;
		if (isEmpty()) {
			last = null;
		}
		number--;
		return item;
	}

	@Override
	public Iterator<T> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<T> {
		Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			T item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			
		}
	}
}
