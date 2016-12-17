package com.engine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class XDaysAdderAlternateTest {
	private XDaysAdderAlternate adder;
	
	@Before
	public void setUp() {
		adder = new XDaysAdderAlternate();
	}

	@Test
	public void testNewAdder() {
		assertNotNull(new XDaysAdderAlternate());
	}
	
	@Test
	public void test1Day() {
		assertEquals(1, adder.getTotalItems(1));
	}
	
	@Test
	public void test0Day() {
		assertEquals(0, adder.getTotalItems(0));
	}
	
	@Test
	public void test2Day() {
		assertEquals(4, adder.getTotalItems(2));
	}
	
	@Test
	public void test12Day() {
		// laying this out step by step so I don't mess up the test
		int sum = 1;
		sum += 1 + 2;
		sum += 1 + 2 + 3;
		sum += 1 + 2 + 3 + 4; // for the sake of ease, I'll use the other version of the adder.
		XDaysAdderTraditional tAdder = new XDaysAdderTraditional();
		sum += tAdder.getTotalItems(5);
		sum += tAdder.getTotalItems(6);
		sum += tAdder.getTotalItems(7);
		sum += tAdder.getTotalItems(8);
		sum += tAdder.getTotalItems(9);
		sum += tAdder.getTotalItems(10);
		sum += tAdder.getTotalItems(11);
		sum += tAdder.getTotalItems(12);
		
		assertEquals(sum, adder.getTotalItems(12));
	}

}
