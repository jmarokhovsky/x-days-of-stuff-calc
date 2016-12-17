package com.engine;

import static org.junit.Assert.*;

import org.junit.Before;
//import org.junit.Ignore;
import org.junit.Test;

public class XDaysAdderTraditionalTest {
	private XDaysAdderTraditional adder;
	
	@Before
	public void setUp() {
		adder = new XDaysAdderTraditional();
	}
	
	@Test
	public void testNewAdder() {
		assertNotNull(new XDaysAdderTraditional());
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
	public void test2Days() {
		assertEquals(3, adder.getTotalItems(2));
	}

}
