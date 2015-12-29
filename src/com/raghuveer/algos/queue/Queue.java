package com.raghuveer.algos.queue;

import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;

public class Queue {

	private Node front;
	private Node rear;

	public Queue() {

		front = null;
		rear = null;
	}

	public void enqueue(int data) {
		Node node = new Node(data);
		if (isEmpty()) {
			front = node;
			rear = front;
		} else {
			rear.next = node;
			rear = node;
		}
	}

	public String toString() {

		System.out.println("tostring");
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node temp;
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			temp = front;
			while (temp.next != null) {
				sb.append(temp.data);
				temp = temp.next;
			}
			sb.append(temp.data);
			sb.append("]");
		}
		return sb.toString();
	}

	public int dequeue() {

		int data;
		if (isEmpty()) {
		    throw new NoSuchElementException();
		}else{
		    data = front.data;
		    front = front.next;
		    return data;
		}
	}

	public static void main(String args[]) {

		Queue queue = new Queue();

		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		System.out.println("" + queue.toString());
		queue.enqueue(4);
		System.out.println("" + queue.toString());
		queue.dequeue();
		System.out.println("" + queue.toString());
		System.out.println("get front" + queue.getFront());
		System.out.println("get back " + queue.getBack());

	}
	
	public int getFront(){
		return front.data;
	}
	
	public int getBack(){
		return rear.data;
	}

	public boolean isEmpty() {
		if (front == null) {
			return true;
		} else {
			return false;
		}
	}

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

}
