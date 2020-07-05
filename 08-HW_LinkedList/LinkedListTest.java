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
		}
		
		
		@Test
		void testAddIndex() {
			int [] expected = {10,-7, 20, 9, 22, 13, 18}; 
			assertTrue(listInt.add(4, 22));
			for (int i = 0; i < expected.length; i++) {
				assertEquals(expected[i], listInt.get(i));
			}
			assertFalse(listInt.add(-4, 22));
			assertFalse(listInt.add(400,22));
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
}
