import java.util.*;

public class MyLinkedList<T> extends AbstractList<T>  {
	
	Node head;
	Node tail;
	int size;
	int changes = 0;

    protected class Node {
        T data;
        Node next;
        Node prev;

        public Node(T data) {
        	this.data = data;
        }
    }

    protected class MyLinkedListIterator implements ListIterator<T> {
    	MyLinkedList<T> ourList;
    	Node prevNode;
    	Node nextNode;
    	int changes = 0;
    	int currentIndex = 0;
    	int direction = 0;
    	// forward : 1
    	// backwards : 2
    	// neither : 0
    	
    	public MyLinkedListIterator(MyLinkedList<T> ourList) {
    		this.ourList = ourList;
    		this.prevNode = ourList.head;
    		this.nextNode = prevNode.next;
    	}

		public boolean hasNext() {
			if (nextNode == tail) {
				return false;
			} else {
				return true;
			}
		}

		@Override
		public T next() {
			if (! this.hasNext()) {
				throw new NoSuchElementException("No more elements in the list!");
			} else {
				nextNode = nextNode.next;
				prevNode = prevNode.next;
				currentIndex++;
				direction = 1;
				return prevNode.data;
				
			}
		}

		@Override
		public boolean hasPrevious() {
			if (prevNode == head) {
				return false;
			} else {
				return true;
			}
		}

		@Override
		public T previous() {
			if (! this.hasPrevious()) {
				throw new NoSuchElementException("You've already reached the beginning of the list!");
			} else {
				prevNode = prevNode.prev;
				nextNode = nextNode.prev;
				currentIndex--;
				direction = 3;
				return nextNode.data;
			}
		}

		@Override
		public int nextIndex() {
			return currentIndex;
		}

		@Override
		public int previousIndex() {
			return currentIndex - 1;
		}

		@Override
		public void remove() {
			if (this.changes == ourList.changes) {
				if(direction == 1) {
					if(this.hasNext()) {
						ourList.remove(currentIndex - 1);
						prevNode = nextNode.prev;
						currentIndex--;
						this.changes++;
						ourList.changes++;
					} else {
						throw new IndexOutOfBoundsException();
					}
				} else if (direction == 2) {
					if(this.hasPrevious()) {
						ourList.remove(currentIndex);
						nextNode = prevNode.next;
						this.changes++;
						ourList.changes++;
					} else {
						throw new IndexOutOfBoundsException();
					}
				} else {
					throw new IllegalStateException();
				}
			}
		}

		@Override
		public void set(T element) {
			if (this.changes == ourList.changes) {
				if(direction == 1) {
					ourList.set(currentIndex - 1, element);
					this.changes++;
					ourList.changes++;
				} else if (direction == 2) {
					ourList.set(currentIndex, element);
					this.changes++;
					ourList.changes++;
				} else {
					throw new IllegalStateException();
				}
			}
		}

		@Override
		public void add(T element) {
			if (this.changes == ourList.changes) {
				if(direction == 1) {
					if(this.hasNext()) {
						ourList.add(currentIndex, element);
						prevNode = nextNode.prev;
						currentIndex++;
						this.changes++;
						ourList.changes++;
					} else {
						throw new IndexOutOfBoundsException();
					}
				} else if (direction == 2) {
					if(this.hasPrevious()) {
						ourList.add(currentIndex+1, element);
						nextNode = prevNode.next;
						this.changes++;
						ourList.changes++;
					} else {
						throw new IndexOutOfBoundsException();
					}
				} else {
					throw new IllegalStateException();
				}
				direction = 0;
			}
		}
    }
    
    public ListIterator<T> listIterator() {
    	return new MyLinkedListIterator(this);
    }
    
    public Iterator<T> iterator() {
    	return new MyLinkedListIterator(this);
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
