package com.engine;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
	
	@Test
	public void test12DaysOfXMas() {
		// The sum of accumulating the correct amount of each item
		int sum = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12;
		assertEquals(sum, adder.getTotalItems(12));
	}
	
	@Test
	public void testPrint1Day() {
		adder.getTotalItems(1);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PrintStream outPrint = new PrintStream(out);
		adder.printItems(outPrint);
		String expectedOut = "Day: 1\nItems: 1 partridge in a pear tree";
		assertEquals(expectedOut, out.toString());
	}

}
