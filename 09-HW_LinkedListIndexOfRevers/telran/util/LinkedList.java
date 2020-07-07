package telran.util;

public class LinkedList<T> {
	private static class Node<T> {
		public T obj;
		public Node<T> next;
		public Node<T> prev;

		public Node(T obj) {
			this.obj = obj;
		}
	}

	private Node<T> head; // reference to the first node
	private Node<T> tail; // reference to the first node
	private int size;
	public void add(T obj) {
		Node<T> node = new Node<>(obj);
		if (head == null) {
			head = tail = node;
		} else {
			node.prev = tail;
			tail.next = node;
			tail = node;
		}
		size++;
	}

	public int size() {
		return size;
	}

	public T get(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
//		return (index < size / 2) ?  getFromLeft(index) : getFromRight(index);
		Node<T> nodeIndex = getNode(index);
		return nodeIndex.obj;
	}

	private Node<T> getNode(int index) {
		return (index < size / 2) ? getFromLeft(index) : getFromRight(index);
	}

	private Node<T> getFromRight(int index) {
		Node<T> current = tail;
		for (int i = size - 1; i > index; i--) {
			current = current.prev;
		}
		return current;
	}

	private Node<T> getFromLeft(int index) {
		Node<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	public boolean add(int index, T obj) {
		if (index < 0 || index > size) {
			return false;
		}
		if (index == 0) {
			addHead(obj);
			size++;
		} else if(index == size){
			add(obj);
		} else {
			addMiddle(index, obj);
			size++;
		}
		// size++;
		return true;
	}

	private void addMiddle(int index, T obj) {
		Node<T> node = new Node<>(obj);
		Node<T> nodeIndex = getNode(index);
		Node<T> nodePrev = nodeIndex.prev;
		nodePrev.next = node;
		node.prev = nodePrev;
		nodeIndex.prev = node;
		node.next = nodeIndex;
	}
	
	private void addHead(T obj) {
		Node<T> node = new Node<>(obj);
		head.prev = node;
		node.next = head;
		head = node;
	}



	public T remove(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		Node<T> node = getNode(index);
		T res = node.obj;		
		if (head == tail) {
			head = tail = null;
		} else {
			if (index == 0) {
				removeHead();
			} else if (index == size - 1) {
				removeTail();
			} else {
				removeNode(node);
			}
		}
			
			
		size--;
		return res;
	}
	
	private void removeNode(Node<T> node) {
		Node<T> nodeNext = node.next;
		Node<T> nodePrev = node.prev;
		nodePrev.next = nodeNext;
		nodeNext.prev = nodePrev;
		
	}

	private void removeTail() {
		tail = tail.prev;
		tail.next = null;
	}
	
	private void removeHead() {
		head = head.next;
		head.prev = null;
	}
	
	public int indexOf(Object pattern) {
		Node <T> currentNode = head;
		for (int i = 0; i < size; i++) {
			if (currentNode.obj.equals(pattern)) {
				return i;
			}
			currentNode = currentNode.next;
		}
		return -1;
	}
	
	public int lastIndexOf(Object pattern) {
		Node <T> currentNode = tail;
		for (int i = size-1; i >= 0; i--) {
			if (currentNode.obj.equals(pattern)) {
				return i;
			}
			currentNode = currentNode.prev;
		}
		return -1;
	}
	
	public void revers() {
		Node <T> leftNode = head;
		Node <T> rightNode = tail;
		for (int i = 0; i < size/2; i++) {
			T tempObj = leftNode.obj;
			leftNode.obj = rightNode.obj;
			rightNode.obj = tempObj;
			leftNode = leftNode.next;
			rightNode = rightNode.prev;
		}
	}

}
