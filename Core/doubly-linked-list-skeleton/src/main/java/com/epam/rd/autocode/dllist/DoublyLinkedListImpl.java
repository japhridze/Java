package com.epam.rd.autocode.dllist;

import java.util.Optional;

public class DoublyLinkedListImpl implements DoublyLinkedList {

	private Node head;
	private Node tail;

	private static class Node {
		Object element;
		Node next;
		Node prev;

		Node(Object element, Node prev, Node next) {
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
	}

	@Override
	public boolean addFirst(Object element) {
		if (element == null) {
			throw new NullPointerException();
		}
		Node newNode = new Node(element, null, head);
		if (head != null) {
			head.prev = newNode;
		}
		head = newNode;
		if (tail == null) {
			tail = newNode;
		}
		return true;
	}

	@Override
	public boolean addLast(Object element) {
		if (element == null) {
			throw new NullPointerException();
		}
		Node newNode = new Node(element, tail, null);
		if (tail != null) {
			tail.next = newNode;
		}
		tail = newNode;
		if (head == null) {
			head = newNode;
		}
		return true;
	}

	@Override
	public void delete(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		if (current.prev != null) {
			current.prev.next = current.next;
		} else {
			head = current.next;
		}
		if (current.next != null) {
			current.next.prev = current.prev;
		} else {
			tail = current.prev;
		}
	}

	@Override
	public Optional<Object> remove(Object element) {
		if (element == null) {
			throw new NullPointerException();
		}
		for (Node current = head; current != null; current = current.next) {
			if (element.equals(current.element)) {
				if (current.prev != null) {
					current.prev.next = current.next;
				} else {
					head = current.next;
				}
				if (current.next != null) {
					current.next.prev = current.prev;
				} else {
					tail = current.prev;
				}
				return Optional.of(element);
			}
		}
		return Optional.empty();
	}

	@Override
	public boolean set(int index, Object element) {
		if (element == null) {
			throw new NullPointerException();
		}
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		current.element = element;
		return true;
	}

	@Override
	public int size() {
		int size = 0;
		for (Node current = head; current != null; current = current.next) {
			size++;
		}
		return size;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size()];
		Node current = head;
		for (int i = 0; i < array.length; i++) {
			array[i] = current.element;
			current = current.next;
		}
		return array;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Node current = head; current != null; current = current.next) {
			if (sb.length() > 0) {
				sb.append(" ");
			}
			sb.append(current.element.toString());
		}
		return sb.toString();
	}
}