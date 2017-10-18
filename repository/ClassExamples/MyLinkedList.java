import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implementation of MyList with a linked list (a longer exercise would be to
 * implement the List interface as is done in the class java.util.LinkedList:
 * the source of the LinkedList class is available from Sun. Check it out).
 */

public class MyLinkedList<E> implements MyList<E> {

	// A private class to represent a Node in the linked list
	private class Node {
		public E item;

		public Node next;

		// a convenient constructor
		public Node(E o) {
			this.item = o;
			this.next = null;
		}
	}

	// The start of the linked list
	private Node head;

	// The last Node in the linked list
	private Node tail;

	// Number of elements in the list
	private int size;

	/**
	 * Creates an empty list (this constructor is not necessary)
	 */
	public MyLinkedList() {
	}

	/**
	 * Returns the number of elements in this list.
	 */
	public int size() {
		// if we didn't have a size field,
		// how to count the elements of the list?
		int count = 0;
		Node p = head;
		while (p != null) {
			count++;
			p = p.next;
		}
		// just as a test
		if (size != count) {
			throw new IllegalStateException("count = " + count + ", size = "
					+ size);
		}
		return size;
	}

	/**
	 * Returns true if this list contains no elements.
	 */
	public boolean isEmpty() {
		// return head == null;
		// return tail == null;
		return size == 0;
	}

	/**
	 * Appends the specified element to the end of this list
	 */
	public boolean add(E o) {
		Node n = new Node(o);
		// If this is the first element in the list
		if (tail == null) {
			head = tail = n;
		} else {
			// If the list is not empty, use tail
			tail.next = n;
			tail = n;
		}
		// update size
		size++;
		return true;
	}

	/**
	 * Empties this List
	 */
	public void clear() {
		// update head, tail and size
		head = tail = null;
		size = 0;
	}

	/**
	 * Returns the element at the specified position in this list.
	 */
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index = " + index);
		}
		// Find it
		Node p = head;
		for (int i = 1; i <= index; i++) {
			p = p.next;
		}

		return p.item;
	}

	/**
	 * Returns the index of the specified element (-1 if there is no match)
	 */
	public int indexOf(Object o) {
		Node p = head;
		int index = 0;
		while (p != null) {
			// If o is null
			if (o == null) // look for a null element in the list
			{
				if (p.item == null) {
					return index;
				}
			} else // o is an object (use equals)
			{
				if (o.equals(p.item)) {
					return index;
				}
			}
			p = p.next;
			index++;
		}

		// if we get here, o is not in the list
		return -1;
	}

	/**
	 * Returns true if this list contains the specified element.
	 */
	public boolean contains(Object o) {
		// easy with indexOf
		return indexOf(o) != -1;
	}

	/**
	 * Removes the element in the List at position index
	 */
	public boolean remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index = " + index);
		}
		// Find the corresponding node
		Node p = head;
		Node prev = null;
		for (int i = 1; i <= index; i++) {
			prev = p;
			p = p.next;
		}
		// Remove it
		// Special case for the first node
		if (index == 0) {
			head = head.next;
		} else {
			prev.next = p.next;
		}
		// If the last node has been removed, update tail
		if (index == size - 1) {
			tail = prev;
		}
		// update size
		size--;
		return true;
	}

	/**
	 * Removes the element in the List at position index
	 */
	public boolean remove(Object o) {
		// easy with indexOf and remove (but expensive)
		int index = indexOf(o);
		return (index != -1) ? remove(index) : false;
	}

	/**
	 * Adds the specified object at the specified location
	 */
	public boolean add(int index, E o) {
		if (index < 0 && index > size) {
			throw new IndexOutOfBoundsException("index = " + index);
		}
		// Find the corresponding node
		Node p = head;
		Node prev = null;
		for (int i = 1; i <= index; i++) {
			prev = p;
			p = p.next;
		}

		// Add a node between prev and p
		Node n = new Node(o);
		n.next = p;
		// Special case (first node)
		if (index == 0) {
			head = n;
		} else {
			prev.next = n;
		}
		// Update tail if necessary
		if (index == size) {
			tail = n;
		}
		// Update size
		size++;
		return true;
	}

	/**
	 * Is this List equal to the specified object?
	 */
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o instanceof MyLinkedList) {
			// o is a LinkedList
			MyLinkedList<E> list = (MyLinkedList<E>) o;
			// if the number of elements is not the same, this and o are not the
			// same
			if (size != list.size) {
				return false;
			}
			// Check the elements one by one
			Node p = head, q = list.head;
			for (int i = 0; i < size; i++) {
				if (p.item == null) {
					if (q.item != null) {
						return false;
					}
				} else if (!p.item.equals(q.item)) {
					return false;
				}
				p = p.next;
				q = q.next;
			}
			// At this point, the lists are equal
			return true;
		} else {
			return false;
		}
	}

	/**
	 * An inner class to define the iterator
	 */
	private class MyIterator implements Iterator<E> {
		private Node p;

		private MyLinkedList<E> list;

		private int currentIndex = 0;
		private int lastVisitedIndex = -1; // index of the most recently

		// visited node

		/**
		 * Create an iterator for a MyLinkedList
		 */
		public MyIterator(MyLinkedList<E> list) {
			this.list = list;
			p = list.head;
		}

		/**
		 * Any element left in the list?
		 */
		public boolean hasNext() {
			return p != null;
		}

		/**
		 * Return the current element in the list and move to the next element
		 */
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			} else {
				lastVisitedIndex = currentIndex;
				E item = p.item;
				currentIndex++;
				p = p.next;
				return item;
			}
		}

		/**
		 * Remove the object currently pointed at by the iterator
		 */
		public void remove() {
			if (lastVisitedIndex == -1) {
				throw new IllegalStateException();
			} else {
				list.remove(lastVisitedIndex);
				lastVisitedIndex = -1;
				currentIndex--;
			}
		}
	}

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 * 
	 * @return an iterator over the elements in this list in proper sequence.
	 */
	public Iterator<E> iterator() {
		return new MyIterator(this);
	}
}
