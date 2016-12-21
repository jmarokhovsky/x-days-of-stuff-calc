package com.engine;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Ignore;
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
	
	@Test
	public void testPrint12Days() {
		getTotalItemsAndPrint(12);
		String expectedOut = "Day: 1\tItems: 1 partridge in a pear tree\n" +
                			 "Day: 2\tItems: 2 turtle doves\n" +
                			 "Day: 3\tItems: 3 french hens\n" +
                			 "Day: 4\tItems: 4 calling birds\n" +
                			 "Day: 5\tItems: 5 gold rings\n" +
                			 "Day: 6\tItems: 6 geese a-laying\n" +
                			 "Day: 7\tItems: 7 swans a-swimming\n" +
                			 "Day: 8\tItems: 8 maids a-milking\n" +
                			 "Day: 9\tItems: 9 ladies dancing\n" +
                			 "Day: 10\tItems: 10 lords a-leaping\n" +
                			 "Day: 11\tItems: 11 pipers piping\n" +
                			 "Day: 12\tItems: 12 drummers drumming\n";
		assertEquals(expectedOut, out.toString());
	}
	
	@Test
	public void testPrint12Checking() {
		// This is to test out ways to test 13+ days.
		getTotalItemsAndPrint(12);
		String expectedOut = "Day: 12\tItems: 12";
		String[] outDays = out.toString().split("\n");
		assertEquals(expectedOut, outDays[11].substring(0, expectedOut.length()));
	}
	
	@Test
	public void testPrint13Days() {
		int days = 13;
		getTotalItemsAndPrint(days);
		String expectedOut = "Day: 13\tItems: 13";
		String[] outDays = out.toString().split("\n");
		assertEquals(expectedOut, outDays[days - 1].substring(0, expectedOut.length()));
	}
	
	@Test
	public void testGetRandomNoun() {
		assertNotNull(adder.getRandomNoun());
	}
	
	@Test
	public void testGetRandomNounDifferentResultsSecondCall() {
		String r1 = adder.getRandomNoun();
		String r2 = adder.getRandomNoun();
		assertNotEquals(r1, r2);
	}
	
	@Test
	public void testPrint31Days() {
		int days = 31;
		getTotalItemsAndPrint(days);
		String expectedOut = "Day: 31\tItems: 31";
		String[] outDays = out.toString().split("\n");
		assertEquals(expectedOut, outDays[days - 1].substring(0, expectedOut.length()));
	}
	
	/***** private methods to make testing easier ******/
	private void getTotalItemsAndPrint(int days) {
		adder.getTotalItems(days);
		adder.printItems(outPrint);
	}

}
