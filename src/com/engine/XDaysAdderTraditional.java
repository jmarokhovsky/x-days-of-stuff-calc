/**
 * 
 */
package com.engine;

import java.io.PrintStream;

/**
 * @author jmaro
 *
 */
public class XDaysAdderTraditional implements IXDaysAdder {
	private int days = 0;

	/* (non-Javadoc)
	 * @see com.engine.IXDaysAdder#getTotalItems(int)
	 */
	@Override
	public int getTotalItems(int days) {
		int result = days;
		this.days = days;
		if (days > 1) {
			result = 0;
			for (int i = 1; i <= days; i++) {
				result += i;
			}
		}
		return result;
	}

	@Override
	public void printItems(PrintStream ps) {
		String outputList = "Day: 1\nItems: 1 partridge in a pear tree\n";
		String secondDay = "Day: 2\nItems: 2 turtle doves\n";
		if (days == 0) {
			outputList = "No days were supplied.";
		}
		if (days > 1) {
			outputList = outputList.concat(secondDay);
		}
		ps.print(outputList);
	}

}
