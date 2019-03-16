import static org.junit.Assert.*;

import java.util.ListIterator;

import org.junit.Test;

public class MyLinkedListTest {

	@Test(expected=IndexOutOfBoundsException.class)
	public void testTooHighAdd() {
		MyLinkedList<Integer> testList = new MyLinkedList<Integer>();
		testList.add(1, 5);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testIndexTooLowAdd() {
		MyLinkedList<Integer> testList = new MyLinkedList<Integer>();
		testList.add(1, 5);
	}
	
	@Test(expected=NullPointerException.class)
	public void testNullDataAdd() {
		MyLinkedList<Integer> testList = new MyLinkedList<Integer>();
		testList.add(0, null);
	}

	@Test
	public void testAdd() {
		MyLinkedList<Integer> testList = new MyLinkedList<Integer>();
		testList.add(0, 2);
		testList.add(1, 3);
		testList.add(0, 1);
		assertTrue(testList.get(0) == 1);
		assertTrue(testList.get(1) == 2);
		assertTrue(testList.get(2) == 3);
	}
	
	@Test
	public void testAddEnd() {
		MyLinkedList<Integer> testList = new MyLinkedList<Integer>();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		assertTrue(testList.get(0) == 1);
		assertTrue(testList.get(1) == 2);
		assertTrue(testList.get(2) == 3);
	}
	
	@Test
	public void testSet() {
		MyLinkedList<Integer> testList = new MyLinkedList<Integer>();
		testList.add(55);
		int oldNumber = testList.set(0, 14);
		assertTrue(testList.get(0) == 14);
		assertTrue(oldNumber == 55);
	}
	
	@Test
	public void testRemove() {
		MyLinkedList<String> testList = new MyLinkedList<String>();
		testList.add("Schwamm");
		testList.add("Doo");
		testList.add("Two and Heif");
		assertTrue(testList.remove(0) == "Schwamm");
	}
	
	@Test
	public void testClear() {
		MyLinkedList<String> testList = new MyLinkedList<String>();
		testList.add("Scheven");
		testList.add("Schforteentenn");
		testList.add("Schwenty One");
		testList.clear();
		assertTrue(testList.size() == 0);
	}
	
	@Test
	public void testIsEmpty() {
		MyLinkedList<Integer> testList = new MyLinkedList<Integer>();
		assertTrue(testList.isEmpty());
		testList.add(7);
		testList.add(4);
		assertFalse(testList.isEmpty());
		testList.remove(0);
		testList.remove(0);
		assertTrue(testList.isEmpty());
	}
	
	@Test
	public void testIterator() {
		MyLinkedList<Integer> testList = new MyLinkedList<Integer>();
		testList.add(1);
		testList.add(2);
		ListIterator<Integer> iterator = testList.listIterator();
		assertTrue(iterator.hasNext());
		assertTrue(iterator.next() == 1);
		assertEquals(iterator.nextIndex(), 1);
		assertTrue(iterator.next() == 2);
		assertFalse(iterator.hasNext());
		assertEquals(iterator.nextIndex(), 2);
		assertTrue(iterator.previous() == 2);
		assertEquals(iterator.previousIndex(), 0);
		assertTrue(iterator.previous() == 1);
		assertEquals(iterator.previousIndex(), -1);
		iterator.add(5);
	}
}




