package com.bedpotato.Algorithms.C1;

public class Stack<T> {
	private Node first;
	private int number;

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("1");
		stack.push("2");
		System.out.println(stack.pop());
		stack.push("3");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return number;
	}

	public void push(T element) {
		Node node = new Node();
		node.item = element;
		node.next = first;
		first = node;
		number++;
	}

	public T pop() {
		T item = first.item;
		first = first.next;
		number--;
		return item;
	}

	class Node {
		T item;
		Node next;
	}
}
