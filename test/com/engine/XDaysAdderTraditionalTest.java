package com.engine;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
//import org.junit.Ignore;
import org.junit.Test;

public class XDaysAdderTraditionalTest {
	private XDaysAdderTraditional adder;
	private PrintStream outPrint;
	private ByteArrayOutputStream out;
	
	@Before
	public void setUp() {
		adder = new XDaysAdderTraditional();
		out = new ByteArrayOutputStream();
		outPrint = new PrintStream(out);
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
		getTotalItemsAndPrint(1);
		String expectedOut = "Day: 1\tItems: 1 partridge in a pear tree\n";
		assertEquals(expectedOut, out.toString());
	}
	
	@Test
	public void testPrint0Day() {
		getTotalItemsAndPrint(0);
		String expectedOut = "No days were supplied.";
		assertEquals(expectedOut, out.toString());
	}
	
	@Test
	public void testPrintSecondDay() {
		getTotalItemsAndPrint(2);
		String expectedOut = "Day: 1\tItems: 1 partridge in a pear tree\n" +
		                     "Day: 2\tItems: 2 turtle doves\n";
		assertEquals(expectedOut, out.toString());
	}
	
	
	/***** private methods to make testing easier ******/
	private void getTotalItemsAndPrint(int days) {
		adder.getTotalItems(days);
		adder.printItems(outPrint);
	}

}
