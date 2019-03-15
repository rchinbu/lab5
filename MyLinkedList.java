/**
 * TODO - your comments here
 */

import java.util.*;

public class MyLinkedList<T> extends AbstractList<T>  {
	
	Node head;
	Node tail;
	int size;

    protected class Node {
        T data;
        Node next;
        Node prev;

        public Node(T data) {
        	this.data = data;
        }
    }

    protected class MyListIterator implements ListIterator<T> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T previous() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void set(T e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void add(T e) {
			// TODO Auto-generated method stub
			
		}

        // TODO - your code here

    }

    public MyLinkedList() {
    	head = new Node(null);
    	tail = new Node(null);
    	size = 0;
    	head.next = tail;
    	head.prev = null;
    	tail.prev = head;
    	tail.next = null;
    }

    private Node getNth(int index) {
    	Node temp = head.next;
    	for (int i = 0; i < index; i++) {
    		temp = temp.next;
    	}
    	return temp;
    }
    
    public void add(int index, T data) {
    	if (index > size || index < 0) {
    		throw new IndexOutOfBoundsException("Index " + index + " out of bounds.");
    	} else if (data == null) {
    		throw new NullPointerException("Cannot add null to list");
    	} else {
	    	Node newNode = new Node(data);
	    	Node rightNode = getNth(index);
	    	Node leftNode = rightNode.prev;
	    	leftNode.next = newNode;
	    	rightNode.prev = newNode;
	    	newNode.prev = leftNode;
	    	newNode.next = rightNode;
	    	size++;
    	}
    }

    public boolean add(T data) {
    	if (data == null) {
    		throw new NullPointerException("Cannot add null to list");
    	}
    	else {
			Node newNode = new Node(data);
	    	Node rightNode = tail;
	    	Node leftNode = tail.prev;
	    	leftNode.next = newNode;
	    	rightNode.prev = newNode;
	    	newNode.prev = leftNode;
	    	newNode.next = rightNode;
	    	size++;
    	}
    	return true;
    }
    
    public T set(int index, T data) {
       	if (index >= size || index < 0) {
    		throw new IndexOutOfBoundsException("Index " + index + " out of bounds.");
    	} else if (data == null) {
    		throw new NullPointerException("Cannot add null to list");
    	} else {
    		Node nodeToChange = getNth(index);
    		T tempData = nodeToChange.data;
    		nodeToChange.data = data;
           	return tempData;
    	}
    }
    
    public T remove(int index) {
    	if (index >= size || index < 0) {
    		throw new IndexOutOfBoundsException("Index " + index + " out of bounds.");
    	} else {
    		Node nodeToRemove = getNth(index);
    		T tempData = nodeToRemove.data;
    		nodeToRemove.prev = nodeToRemove.next;
    		nodeToRemove.next = nodeToRemove.prev;
    		size--;
    		return tempData;
    	}
    }
    
    public void clear() {
    	head.next = tail;
    	tail.prev = head;
    	size = 0;
    }
    
    public boolean isEmpty() {
    	if (size == 0) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
	@Override
	public T get(int index) {
	   	if (index >= size || index < 0) {
    		throw new IndexOutOfBoundsException("Index " + index + " out of bounds.");
	   	} else {
	   		Node nthNode = getNth(index);
	   		return nthNode.data;
	   	}
	}

	@Override
	public int size() {
		return size;
	}
}
