package com.engine;

import static org.junit.Assert.*;

import org.junit.Test;

public class IXDaysAdderInterfaceTest {
	private IXDaysAdder adder;
	
	@Test
	public void testNewTraditional() {
		adder = new XDaysAdderTraditional();
		assertEquals(6, adder.getTotalItems(3)); 
	}
	
	@Test
	public void testNewAlternative() {
		adder = new XDaysAdderAlternate();
		assertEquals(10, adder.getTotalItems(3));
	}
	
	@Test
	public void testSwitchingBetweenAdders() {
		int sum1; // this will be traditional 4
		int sum2; // this will be alternate 4
		int days = 4;
		adder = new XDaysAdderTraditional();
		sum1 = adder.getTotalItems(days);
		adder = new XDaysAdderAlternate();
		sum2 = adder.getTotalItems(days);
		assertNotEquals(sum1, sum2);
		assertEquals(10, sum1);
		assertEquals(20, sum2);
	}

}
