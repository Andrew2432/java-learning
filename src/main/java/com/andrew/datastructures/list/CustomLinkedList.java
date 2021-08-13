/**
 * 
 */
package com.andrew.datastructures.list;

/**
 * @author Andrew
 *
 */
class Node<T> {
	private T data;
	private Node<T> next;

	public Node(T data) {
		this.data = data;
		this.next = null;
	}

	public T getData() {
		return this.data;
	}

	public Node<T> getNext() {
		return this.next;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
}

public class CustomLinkedList<T> {
	private Node<T> head = null;
	private Node<T> tail = null;

	public void addNode(T data) {
		Node<T> newNode = new Node<>(data);

		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
	}

	public void display() {
		Node<T> current = this.head;

		if (head == null) {
			System.out.println("List is empty");
			return;
		}

		while (current != null) {
			System.out.print(current.getData() + "->");
			current = current.getNext();
		}
	}
}
