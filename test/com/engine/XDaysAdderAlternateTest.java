package com.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class XDaysAdderAlternateTest {
	private XDaysAdderAlternate adder;
	private PrintStream outPrint;
	private ByteArrayOutputStream out;
	
	@Before
	public void setUp() {
		adder = new XDaysAdderAlternate();
		out = new ByteArrayOutputStream();
		outPrint = new PrintStream(out);
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
							 "Day: 2\tItems: 2 turtle doves, 1 partridge in a pear tree\n";
		assertEquals(expectedOut, out.toString());
	}
	
	@Test
	public void testPrint12Days() {
		getTotalItemsAndPrint(12);
		String expectedOut = "Day: 1\tItems: 1 partridge in a pear tree\n" +
				"Day: 2\tItems: 2 turtle doves, 1 partridge in a pear tree\n" +
				"Day: 3\tItems: 3 french hens, 2 turtle doves, "
				+ "1 partridge in a pear tree\n" +
				"Day: 4\tItems: 4 calling birds, 3 french hens, "
				+ "2 turtle doves, 1 partridge in a pear tree\n" +
				"Day: 5\tItems: 5 gold rings, 4 calling birds, 3 french hens, "
				+ "2 turtle doves, 1 partridge in a pear tree\n" +
				"Day: 6\tItems: 6 geese a-laying, 5 gold rings, "
				+ "4 calling birds, 3 french hens, 2 turtle doves, "
				+ "1 partridge in a pear tree\n" +
				"Day: 7\tItems: 7 swans a-swimming, 6 geese a-laying, "
				+ "5 gold rings, 4 calling birds, 3 french hens, "
				+ "2 turtle doves, 1 partridge in a pear tree\n" +
				"Day: 8\tItems: 8 maids a-milking, 7 swans a-swimming, "
				+ "6 geese a-laying, 5 gold rings, 4 calling birds, "
				+ "3 french hens, 2 turtle doves, "
				+ "1 partridge in a pear tree\n" +
				"Day: 9\tItems: 9 ladies dancing, 8 maids a-milking, "
				+ "7 swans a-swimming, 6 geese a-laying, 5 gold rings, "
				+ "4 calling birds, 3 french hens, 2 turtle doves, "
				+ "1 partridge in a pear tree\n" +
				"Day: 10\tItems: 10 lords a-leaping, 9 ladies dancing, "
				+ "8 maids a-milking, 7 swans a-swimming, 6 geese a-laying, "
				+ "5 gold rings, 4 calling birds, 3 french hens, "
				+ "2 turtle doves, 1 partridge in a pear tree\n" +
				"Day: 11\tItems: 11 pipers piping, 10 lords a-leaping, "
				+ "9 ladies dancing, 8 maids a-milking, 7 swans a-swimming, "
				+ "6 geese a-laying, 5 gold rings, 4 calling birds, "
				+ "3 french hens, 2 turtle doves, 1 partridge in a pear tree\n" +
				"Day: 12\tItems: 12 drummers drumming, 11 pipers piping, "
				+ "10 lords a-leaping, 9 ladies dancing, 8 maids a-milking, "
				+ "7 swans a-swimming, 6 geese a-laying, 5 gold rings, "
				+ "4 calling birds, 3 french hens, 2 turtle doves, "
				+ "1 partridge in a pear tree\n";
		assertEquals(expectedOut, out.toString());
	}
	
	@Test
	public void testPrint13Days() {
		getTotalItemsAndPrint(13);
		String expectedOut = "The amount of days given are outside of the scope of the current printer.";
		assertEquals(expectedOut, out.toString());
	}
	
	/***** private methods to make testing easier ******/
	private void getTotalItemsAndPrint(int days) {
		adder.getTotalItems(days);
		adder.printItems(outPrint);
	}

}
