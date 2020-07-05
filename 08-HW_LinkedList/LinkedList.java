package telran.util;

public class LinkedList<T> {
	private static class Node<T> {
		public T obj;
		public Node<T> next;
		public Node<T> previous;
		
		public Node (T obj) {
			this.obj = obj;
		}
	}
	
	private Node<T> head; // reference to the first node
	private Node<T> tail; // reference to the first node
	private int size;
	
	public int size() {
		return size;
	}
	
	public T get (int index){
		if (index < 0 || index >= size) {
			System.out.println("Wrong index");
			return null;
		} else if (index <= size /2 ) {
			Node <T> current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			return current.obj;
		} else {
			Node <T> current = tail;
			for (int i = size-1; i > index; i--) {
				current = current.previous;
			}
			return current.obj;
		}
	}
	
	public void add (T obj) {
		Node<T> newNode = new Node<>(obj);
		if(head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.previous = tail;
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}
	
	public boolean add (int index, T obj) {
		Node<T> newNode = new Node<>(obj);
		
		if (index < 0 || index >= size) {
			System.out.println("Wrong index");
			return false;
		} else if(size == 0 || index == size-1) {
			add (obj);
		} else {
			Node <T> current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			newNode.previous = current.previous;
			newNode.next = current;
			current.previous.next = newNode;
			current.previous = newNode;
		}
		size++;
		return true;
	}
	
	public T remove (int index) {
		T res = null;
		if (index < 0 || index >= size) {
			System.out.println("Wrong index");
			return null;
		} else if (index == 0) {
			res = removeHead();
		} else if (index == size-1) {
			res = removeTail();
		} else {
			res = removeMidle(index);
		}
		size--;
		return res;
	}

	private T removeHead() {
		T res = head.obj;
		head = head.next;
		head.previous = null;
		return res;
	}
	
	private T removeMidle(int index) {
		T res = null;
		if (index <= size /2) {
			Node <T> current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			res = current.obj;
			Node <T> befor =current.previous;
			Node <T> after =current.next;
			befor.next = after;
			after.previous = befor;
		} else {
			Node <T> current = tail;
			for (int i = size - 1; i > index; i--) {
				current = current.previous;
			}
			res = current.obj;
			Node <T> befor =current.previous;
			Node <T> after =current.next;
			befor.next = after;
			after.previous = befor;
		}
		return res;
	}

	private T removeTail() {
		T res = tail.obj;
		tail = tail.next;
		tail.next = null;
		return res;
	}
}
