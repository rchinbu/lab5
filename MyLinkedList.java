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

    public MyLinkedList<T>() {
    	head = new Node(null);
    	tail = new Node(null);
    	size = 0;
    	head.next = tail;
    	head.prev = null;
    	tail.prev = head;
    	tail.next = null;
    }

    private Node getNth(int index) {
    	for (int i = 0; i <= index; i++) {
    		Node temp = head.next;
    		
    	}
    }
    
    public void add(int index, T data) {
    	Node newNode = new Node(data);
    	
    }

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}

