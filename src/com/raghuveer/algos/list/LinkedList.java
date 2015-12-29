package com.raghuveer.algos.list;
import java.util.NoSuchElementException;


public class LinkedList {

	private Node head;

	public LinkedList() {
		head = null;
	}

	public static void main(String args[]) {

		LinkedList list = new LinkedList();
		
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list.tostring());
		list.add(4);
		System.out.println(list.tostring());
		list.add(5);
		System.out.println(list.tostring());
		list.add(6);
		System.out.println(list.tostring());
		list.remove();
		System.out.println(list.tostring());
		list.remove(0);
		System.out.println(list.tostring());
		list.add(7);
		System.out.println(list.tostring());		
	}

	public void remove() {

		Node temp;
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			temp = head;
			head = temp.next;
			temp= null;
		}
	}
	
	public void remove(int index){
		Node temp,previousnode;
		int count =0 ;
		if(isEmpty()){
			throw new NoSuchElementException();
		}else{
			temp = head;
			previousnode= temp;
			while(temp.next!=null){
				if(count== index){
					if(index==0){
						head = head.next;	
					}
					previousnode.next = temp.next;
					temp = null;
					break;
				}else{
				previousnode= temp;
				temp = temp.next;
				count = count + 1;
				}
			}
		}
	}

	public int get(int index) {
		Node temp;
		int count = 0;
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else if (index > size()) {
			throw new NoSuchElementException();
		} else {
			temp = head;
			while (temp.next != null) {
				count++;
				if (count == index) {
					return temp.data;
				}
				temp = temp.next;
			}
		}
		return 0;
	}

	public int indexof(int data) {

		Node temp;
		int count = 0;

		temp = head;
		while (temp.next != null) {

			if (temp.data == data) {
				return count;
			}
			count++;
			temp = temp.next;
		}

		return 0;
	}

	public String tostring() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node temp;
		if (isEmpty()) {
			throw new NoSuchElementException();
			
		} else {
			temp = head;
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

	public void add(int data) {
		Node temp;
		Node node = new Node(data);
		if (isEmpty()) {
			head = node;
		} else {
			temp = head;
			while(temp.next!=null){
				temp= temp.next;
			}
			temp.next = node;
		}
	}

	public void addFirst(int data) {

		Node node = new Node(data);
		node.next = head;
		head = node;
	}

	public void addLast(int data) {
		Node temp;
		temp = head;
		Node node = new Node(data);
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
	}

	public boolean contains(int data) {

		Node temp;
		temp = head;
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			while (temp.next != null) {
				if (temp.data == data) {
					return true;
				}
				temp = temp.next;
			}
		}
		return false;
	}

	public void add(int data, int index) {

		int count = 0;
		Node temp = null;
		Node node = new Node(data);

		if (isEmpty()) {
			if (index == 0) {
				addFirst(data);
			} else {
				throw new NoSuchElementException();
			}

		} else {
			if (index > size()) {
				throw new NoSuchElementException();
			} else {
				temp = head;
				while (temp.next != null) {
					count++;
					if (count == index) {
						Node nexttemp;
						nexttemp = temp.next;
						temp.next = node;
						node.next = nexttemp;
					}
					temp = temp.next;
				}
			}
		}
	}

	private boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	public int size() {
		Node temp;
		temp = head;
		int count = 1;
		if (isEmpty()) {
			return 0;
		} else {
			while (temp.next != null) {
				count = count + 1;
				temp = temp.next;
			}
			return count;
		}
	}

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}

	}

}
