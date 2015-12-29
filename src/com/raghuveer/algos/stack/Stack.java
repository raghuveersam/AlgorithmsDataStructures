package com.raghuveer.algos.stack;

import java.util.NoSuchElementException;

public class Stack {

	Node top;

	public Stack() {
		top = null;
	}

	public void push(int data){
		Node node = new Node(data);
		if(isEmpty()){
			top = node;
		}
		else{
		node.next = top;
		top = node;
		}	
	}
	
	public int pop(){
		if(isEmpty()){
			throw new NoSuchElementException();
		}else{
			int data;
			data = top.data;
			top = top.next;
			return data;
		}
	}
	
	public int peek(){
		if(isEmpty()){
			throw new NoSuchElementException();
		}else {
			return top.data;
		}
	}
	
	
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node temp;
		if (isEmpty()) {
			throw new NoSuchElementException();
			
		} else {
			temp = top;
			while (temp.next != null) {
				sb.append(temp.data);
				sb.append(",");
				temp = temp.next;
			}
			sb.append(temp.data);
			sb.append("]");
		}
		return sb.toString();
		
	}

	public boolean isEmpty() {
		if (top == null) {
			return true;
		}
		return false;
	}

	public static void main(String args[]) {
		
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println("" + stack.toString());
		stack.push(40);
		System.out.println("" + stack.toString());
		stack.pop();
		System.out.println("" + stack.toString());
		System.out.println("Peek "+stack.peek());
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
