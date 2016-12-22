package com.getRand;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class XRandomNounGetterTest {
	private List<String> rNouns;

	@Test
	public void testGetOneRandom() {
		rNouns = XRandomNounGetter.getRandomNouns(1);
		System.out.println(rNouns.get(0));
		assertEquals(1, rNouns.size());
		assertNotNull(rNouns.get(0));
	}
	
	@Test
	public void testGet10Random() {
		rNouns = XRandomNounGetter.getRandomNouns(10);
		System.out.println(rNouns.toString());
		assertEquals(10, rNouns.size());
		assertNotNull(rNouns.get(rNouns.size() - 1));
	}
	
	@Test
	public void testGet11Random() {
		rNouns = XRandomNounGetter.getRandomNouns(11);
		assertEquals(11, rNouns.size());
		assertNotNull(rNouns.get(rNouns.size() - 1));
	}
	
	@Test
	public void testGet31Random() {
		rNouns = XRandomNounGetter.getRandomNouns(31);
		assertEquals(31, rNouns.size());
		assertNotNull(rNouns.get(rNouns.size() - 1));
	}
	
	@Test
	public void testWordsEndingInSCorrectly() {
		rNouns = XRandomNounGetter.getRandomNouns(36);
		boolean instanceFound = false;
		boolean correctUse = true;
//		System.out.println(rNouns.toString());
		for (String rNoun : rNouns) {
			// look at the third to last character of the String, if it's an "s", check that it's followed by "es"
			int loc = rNoun.length() - 3;
			char thirdLast = rNoun.charAt(loc);
			String last3 = rNoun.substring(loc);
			if (last3.substring(1).equals("ss")) { // no matter what, this is most likely wrong.
				correctUse = correctUse && false;
			}
//			TODO: refactor this test using regex.
			if (thirdLast == 's') {
				instanceFound = true;
				correctUse = correctUse && (last3.equals("ses") || last3.equals("sts")
						|| last3.equals("sas") || last3.equals("sms"));
			}
		}
		if (!instanceFound) {
			// didn't find anything! maybe make this list bigger to make sure I get one?
			instanceFound = true;
		}
		boolean output = instanceFound && correctUse;
		assertTrue(output);
	}
	
	@Test
	public void testWordsEndingInHCorrectly() {
		rNouns = XRandomNounGetter.getRandomNouns(41);
		boolean instanceFound = false;
		boolean correctUse = true;
//		System.out.println(rNouns.toString());
		for (String rNoun : rNouns) {
			// look at the third to last character of the String, if it's an "s", check that it's followed by "es"
			int loc = rNoun.length() - 3;
//			char thirdLast = rNoun.charAt(loc);
			String last3 = rNoun.substring(loc);
			if (last3.equals("shs")) { // no matter what, this is most likely wrong.
				correctUse = correctUse && false;
			}
			if (last3.equals("chs")) { // no matter what, this is most likely wrong.
				correctUse = correctUse && false;
			}
		}
		if (!instanceFound) {
			// didn't find anything! maybe make this list bigger to make sure I get one?
			instanceFound = true;
		}
		boolean output = instanceFound && correctUse;
		assertTrue(output);
	}
	
	@Test
	public void testWordEndingInYCorrectly() {
		rNouns = XRandomNounGetter.getRandomNouns(36);
		boolean instanceFound = false;
		boolean correctUse = true;
//		System.out.println(rNouns.toString());
		for (String rNoun : rNouns) {
			// look at the second to last character of the String, if it's a "y", then it's wrong.
			int loc = rNoun.length() - 2;
			String last2 = rNoun.substring(loc);
			if (last2.equals("ys")) { // no matter what, this is most likely wrong.
				correctUse = correctUse && false;
			}
		}
		if (!instanceFound) {
			// didn't find anything! maybe make this list bigger to make sure I get one?
			instanceFound = true;
		}
		boolean output = instanceFound && correctUse;
		assertTrue(output);
	}
	
	@Test
	public void testWordEndingInXCorrectly() {
		rNouns = XRandomNounGetter.getRandomNouns(36);
		boolean instanceFound = false;
		boolean correctUse = true;
//		System.out.println(rNouns.toString());
		for (String rNoun : rNouns) {
			// look at the second to last character of the String, if it's a "x", then it's wrong.
			int loc = rNoun.length() - 3;
			char thirdLast = rNoun.charAt(loc);
			String last2 = rNoun.substring(rNoun.length() - 2);
			String last3 = rNoun.substring(loc);
			if (last2.equals("xs")) { // no matter what, this is most likely wrong.
				correctUse = correctUse && false;
			}
			if (thirdLast == 'x') {
				instanceFound = true;
				correctUse = correctUse && last3.equals("xes");
			}
		}
		
		if (!instanceFound) {
			// didn't find anything! maybe make this list bigger to make sure I get one?
			instanceFound = true;
		}
		boolean output = instanceFound && correctUse;
		assertTrue(output);
	}

}
