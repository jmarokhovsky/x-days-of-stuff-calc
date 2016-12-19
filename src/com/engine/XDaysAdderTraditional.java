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
	private static final String[] itemText =
	{"partridge in a pear tree",
	 "turtle doves",
	 "french hens",
	 "calling birds",
	 "gold rings",
	 "geese a-laying",
	 "swans a-swimming",
	 "maids a-milking",
	 "ladies dancing",
	 "lords a-leaping",
	 "pipers piping",
	 "drummers drumming"
	};

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
		String outputList = "No days were supplied.";
		String currentDay = null;
		if (days > 0 && days <= 12) {
			outputList = ""; // clear the output list
			for (int i = 0; i < days; i++) {
				int currDay = i + 1;
				currentDay = "Day: " + currDay +
						     "\tItems: " + currDay + " " +
							 itemText[i] + "\n";
				outputList = outputList.concat(currentDay);
			}
		} 
		if (days > 12) {
			outputList = "The amount of days given are outside of the scope of "
					+ "the current printer.";
		}
		ps.print(outputList);
	}

}
