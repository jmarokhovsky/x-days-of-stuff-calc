/**
 * 
 */
package com.engine;

import java.io.PrintStream;

/**
 * @author jmaro
 *
 */
public class XDaysAdderAlternate implements IXDaysAdder {
	private int days;

	/* (non-Javadoc)
	 * @see com.engine.IXDaysAdder#getTotalItems(int)
	 */
	@Override
	public int getTotalItems(int days) {
		int result = 0;
		this.days = days;
		if (days <= 1) {
			result = days;
		} else {
			for (int i = 1; i <= days; i++) {
				for (int j = i; j > 0; j--) {
					result += j;
				}
			}
		}
		return result;
	}

	@Override
	public void printItems(PrintStream ps) {
		String outputList = "No days were supplied.";
		if (days > 0) {
			outputList = "Day: 1\tItems: 1 partridge in a pear tree\n";
		}
		if (days > 1) {
			String secondDay = "Day: 2\tItems: 2 turtle doves and 1 partridge in a pear tree\n";
			outputList = outputList.concat(secondDay);
		}
		ps.print(outputList);
	}

}
