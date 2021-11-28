package edu.ncsu.csc316.airline_mileage.list;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests ArrayList
 * 
 * @author someshherath
 */
public class ArrayListTest {

	/**
	 * Tests ArrayList constructor
	 */
	@Test
	public void testConstructor() {
		ArrayList<String> list = new ArrayList<String>();
		assertEquals(0, list.size());
		
		try {
			list.get(2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
		}
		
		try {
			list.get(-2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
		}
	}
	
	/**
	 * Tests add
	 */
	@Test
	public void testAdd() {
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			list.add(0, "a");
			assertEquals(1, list.size());
		} catch (Exception e) {
			fail();
		}
		
		try {
			list.add(0, null);
			fail();
		} catch (NullPointerException e) {
			assertEquals(1, list.size());
		}

		try {
			list.add(2, "b");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(1, list.size());
		}
		
		try {
			list.add(-2, "b");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(1, list.size());
		}
		
		try {
			list.add(0, "b");
			assertEquals(2, list.size());
		} catch (Exception e) {
			fail();
		}
		
		try {
			list.add(0, "c");
			list.add(0, "d");
			list.add(0, "e");
			list.add(0, "f");
			list.add(0, "g");
			list.add(0, "h");
			list.add(0, "i");
			list.add(0, "j");
			list.add(0, "k");
			list.add(0, "l");
			assertEquals(12, list.size());
		} catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * Tests set
	 */
	@Test
	public void testSet() {
		ArrayList<String> list = new ArrayList<String>();
		list.add(0, "a");
		list.add(0, "b");
		
		try {
			list.set(0, null);
			fail();
		} catch (NullPointerException e) {
			assertEquals(2, list.size());
		}
		
		try {
			list.set(2, "c");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(2, list.size());
		}
		
		try {
			list.set(-2, "c");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(2, list.size());
		}
		
		try {
			list.set(1, "c");
			assertEquals(2, list.size());
			assertEquals("c", list.get(1));
		} catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * Tests remove
	 */
	@Test
	public void testRemove() {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add(0, "a");
		list.add(1, "b");
		list.add(2, "c");
		list.add(3, "d");
		list.add(4, "e");
		list.add(5, "f");
		list.add(6, "g");
		list.add(7, "h");
		list.add(8, "i");
		list.add(9, "j");
		list.add(10, "k");
		list.add(11, "l");
		
		try {
			list.remove(20);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(12, list.size());
		}
		
		try {
			list.remove(-2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(12, list.size());
		}
		
		try {
			assertEquals("b", list.remove(1));
			assertEquals(11, list.size());
		} catch (Exception e) {
			fail();
		}
		
		try {
			assertEquals("l", list.remove(10));
			assertEquals(10, list.size());
		} catch (Exception e) {
			fail();
		}
	}

}
