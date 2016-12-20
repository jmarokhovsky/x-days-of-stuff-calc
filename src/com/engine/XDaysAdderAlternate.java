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
	private final String[] item_strs =
	{
			"partridge in a pear tree",
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
		String dayStr = "Day: ";
		String dISepStr = "\t";
		String itemStr = "Items: ";
		String endStr = "\n";
		if (days > 0 && days <= 12) {
			outputList = "";
			for (int i = 0; i < days; i++) {
				int currDay = i + 1;
				String currItems = "";
				for (int j = currDay; j > 0; j--) {
					currItems += j + " " + item_strs[j - 1];
					if (j > 1) {
						currItems += ", ";
					}
				}
				String currStr = dayStr + currDay + dISepStr + itemStr + currItems + endStr;
				outputList += currStr;
			}
		} else if (days > 12) {
			outputList = "The amount of days given are outside of the scope of the current printer.";
		}
		ps.print(outputList);
	}

}
