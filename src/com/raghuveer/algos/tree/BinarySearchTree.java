package com.raghuveer.algos.tree;


public class BinarySearchTree<T> {

	Node<T> root;

	public BinarySearchTree() {
		root = null;
	}

	private static class Node<T> {
		int data;
		Node<T> left;
		Node<T> right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

	public void insert(int data) {

		root = insertData(root, data);
	}

	private Node<T> insertData(Node<T> root, int data) {
		if (root == null) {
			root = new Node<T>(data);
			return root;
		} else {
			if (data > root.data) {
				root.right = insertData(root.right, data);
				return root;
			} else {
				root.left = insertData(root.left, data);
				return root;
			}
		}

	}

	public void delete(int data) {
		root = deleteData(root, data);
	}

	private Node<T> deleteData(Node<T> root,int data){
			if(root == null){
				return root;
			}else if(root.data == data){
				if(root.left == null && root.right == null){
					root = null;
					return root;
				}else if(root.left == null || root.right == null){
					if(root.left == null){
						root = root.right;
						return root;
					}else{
						root = root.left;
					    return root;
					}
				}
			}
			else{
				   if (data > root.data) {
					root.right =  deleteData(root.right, data);
				}else {
					root.left = deleteData(root.left, data);
				}	
			}
			return root;
	}

	public boolean search(int data) {
		return searchData(root, data);
	}

	private boolean searchData(Node<T> root, int data) {

		if (root == null) {
			return false;
		} else if (root.data == data) {
			return true;
		} else {
			if (data < root.data) {
				return searchData(root.left, data);
			} else {
				return searchData(root.right, data);
			}
		}
	}

	public void inOrderTraversal() {
		inOrderHelper(root);
	}

	private void inOrderHelper(Node r) {
		if (r != null) {
			inOrderHelper(r.left);
			System.out.print(r.data + " ");
			inOrderHelper(r.right);
		}
	}

	public void preOrderTraversal() {
		preOrderHelper(root);
	}

	private void preOrderHelper(Node<T> root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrderHelper(root.left);
			preOrderHelper(root.right);
		}
	}

	public void postOrderTraversal() {
		postOrderHelper(root);
	}

	private void postOrderHelper(Node<T> r) {
		if (r != null) {
			postOrderHelper(r.left);
			postOrderHelper(r.right);
			System.out.print(r.data + " ");
		}
	}

	public static void main(String args[]) {

		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();
		binarySearchTree.insert(7);
		binarySearchTree.insert(5);
		binarySearchTree.insert(3);
		System.out.println(binarySearchTree.search(1) + " ");
		binarySearchTree.inOrderTraversal();
		binarySearchTree.delete(5);
		binarySearchTree.inOrderTraversal();
		System.out.println("check");
	}

}
