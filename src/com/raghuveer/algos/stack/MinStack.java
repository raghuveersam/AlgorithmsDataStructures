package com.raghuveer.algos.stack;

public class MinStack {

	private UserStack stack;
	private UserStack auxstack;

	public MinStack() {

		stack = new UserStack();
		auxstack = new UserStack();
	}

	public void push(int x) {

		stack.push(x);
		if (x < auxstack.top()) {
			auxstack.push(x);
		} else {
			auxstack.push(auxstack.top());
		}

	}

	public void pop() {

		stack.pop();
		auxstack.pop();

	}

	public int top() {

		return stack.top();
	}

	public int getMin() {

		return auxstack.top();

	}
	
	public static void main(String args[]){
		MinStack stack = new MinStack();
		stack.push(5);
		stack.pop();
		stack.push(3);
		stack.push(2);
		stack.push(7);
		stack.pop();
		System.out.println("min value "+stack.getMin());
		
	}

}

 class UserStack {

	private Node top;
	int max = Integer.MAX_VALUE;

	public UserStack() {
		top = null;
	}

	private static class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public int top() {
		if (!isEmpty()) {
			return top.data;
		} else {
			return max;
		}
	}

	public boolean isEmpty() {
		if (top == null) {
			return true;
		} else {
			return false;
		}
	}

	public void push(int data) {
		Node temp = new Node(data);
		temp.next = top;
		top = temp;
	}

	public void pop() {
		if (!isEmpty()) {
			top = top.next;
			
		}
	}
}
