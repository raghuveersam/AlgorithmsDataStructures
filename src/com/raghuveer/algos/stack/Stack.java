package com.raghuveer.algos.stack;

import java.util.NoSuchElementException;

public class Stack<T> {

	Node<T> top;

	public Stack() {
		top = null;
	}

	public void push(T data){
		Node<T> node = new Node<T>(data);
		if(isEmpty()){
			top = node;
		}
		else{
		node.next = top;
		top = node;
		}	
	}
	
	public T pop(){
		if(isEmpty()){
			throw new NoSuchElementException();
		}else{
			T data;
			data = top.data;
			top = top.next;
			return data;
		}
	}
	
	public T peek(){
		if(isEmpty()){
			throw new NoSuchElementException();
		}else {
			return top.data;
		}
	}
	
	
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node<T> temp;
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
		
		
	}

	static class Node<T> {
		 T data;
		 Node<T> next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

}
