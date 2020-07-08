package telran.util.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.LinkedList;

class LinkedListTest {

	int [] arrayInt = {10,-7, 20, 9, 13, 18};
	String [] arrayStr = {"abd","lm", "hello"};
	LinkedList<Integer> listInt;
	LinkedList<String> listStr;
	@BeforeEach
	void setUp() {
		listInt = new LinkedList<>();
		listStr = new LinkedList<>();
		for(int i = 0; i < arrayInt.length; i++) {
			listInt.add(arrayInt[i]);
		}
		for(int i = 0; i < arrayStr.length; i++) {
			listStr.add(arrayStr[i]);
		}
		
	}
		@Test
		void testAddGet() {
			assertEquals(arrayInt.length, listInt.size());
			assertEquals(arrayStr.length, listStr.size());
			for (int i = 0; i < arrayInt.length; i++) {
				assertEquals(arrayInt[i], listInt.get(i));
			}
			for (int i = 0; i < arrayStr.length; i++) {
				assertEquals(arrayStr[i], listStr.get(i));
			}
			assertEquals(null, listInt.get(50));
			assertEquals(null, listInt.get(-50));
		}
		
		
		@Test
		void testAddIndex() {
			int [] expected = {10,-7, 20, 9, 44, 22, 13, 18}; 
			assertTrue(listInt.add(4, 22));
			assertTrue(listInt.add(4, 44));
			for (int i = 0; i < expected.length; i++) {
				assertEquals(expected[i], listInt.get(i));
			}
			assertFalse(listInt.add(-4, 22));
			assertFalse(listInt.add(400,22));
		}
		
		@Test
		void testAddHead() {
			int [] expected = {44, 22, 10,-7, 20, 9, 13, 18}; 
			assertTrue(listInt.add(0, 22));
			assertTrue(listInt.add(0, 44));
			for (int i = 0; i < expected.length; i++) {
				assertEquals(expected[i], listInt.get(i));
			}
		}
		
		
		@Test
		void testAddTail() {
			int [] expected = {10,-7, 20, 9, 13, 18, 22, 44}; 
			assertTrue(listInt.add(6, 22));
			assertTrue(listInt.add(7, 44));
			for (int i = 0; i < expected.length; i++) {
				System.out.println(listInt.get(i));
				assertEquals(expected[i], listInt.get(i));
			}
		}
		
		
		@Test
		void testRemoveIndex() {
			int [] expected = {10,-7, 9, 13, 18}; 
			assertEquals(20, listInt.remove(2));
			for (int i = 0; i < expected.length; i++) {
				assertEquals(expected[i], listInt.get(i));
			}
			assertNull(listInt.remove(-4));
			assertNull(listInt.remove(400));
		}
		
		@Test
		void testRemoveIndexTail() {
			int [] expected = {-7, 20, 9, 13}; 
			assertEquals(18, listInt.remove(5));
			assertEquals(10, listInt.remove(0));
			for (int i = 0; i < expected.length; i++) {
				assertEquals(expected[i], listInt.get(i));
			}
			assertEquals(-7, listInt.remove(0));
			assertEquals(20, listInt.remove(0));
			assertEquals(9, listInt.remove(0));
			assertEquals(13, listInt.remove(0));
			assertNull(listInt.remove(-4));
			assertNull(listInt.remove(400));
		}
		
		@Test
		void testGetWrongIdex() {
			assertEquals(null, listInt.get(-1));
			assertEquals(null, listInt.get(500));
		}
		
		@Test
		void testIndexOf() {
			int[] expected = {10,-7, 20, 9, 13, 18};
			for (int i = 0; i < expected.length; i++) {
				int pattern = expected[i];
				assertEquals(i, listInt.indexOf(pattern));
			}
			assertEquals(-1, listInt.indexOf(-100));
			assertEquals(-1, listInt.indexOf(100));
		}
		
		@Test
		void testLastIndexOf() {
			
			int[] expected = {10,-7, 20, 9, 13, 18};
			
			assertEquals (4, listInt.lastIndexOf(13));
			assertEquals (5, listInt.lastIndexOf(18));
			
			for (int i = 0; i < expected.length; i++) {
				int pattern = expected[i];
				assertEquals(i, listInt.lastIndexOf(pattern));
			}
			
			assertEquals(-1, listInt.lastIndexOf(1));
			assertEquals(-1, listInt.lastIndexOf(2));
			
			listInt.add(5, 20);
			assertEquals(5, listInt.lastIndexOf(20));
			assertEquals(-1, listInt.lastIndexOf(-100));
			assertEquals(-1, listInt.lastIndexOf(100));
		}
		
		@Test
		void testRevers() {
			int[] expected = { 18, 13, 9, 20, -7, 10 };
			listInt.revers();
			for (int i = 0; i < expected.length; i++) {
				assertEquals(expected[i], listInt.get(i));
			}
			listInt.add(5, 20);
			listInt.revers();
			int[] expected2 = { 10, 20, -7, 20, 9, 13, 18 };
			for (int i = 0; i < expected.length; i++) {
				assertEquals(expected2[i], listInt.get(i));
			}

		}
		
}

