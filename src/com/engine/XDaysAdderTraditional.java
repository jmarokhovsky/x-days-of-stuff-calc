/**
 * 
 */
package com.engine;

/**
 * @author jmaro
 *
 */
public class XDaysAdderTraditional implements IXDaysAdder {

	/* (non-Javadoc)
	 * @see com.engine.IXDaysAdder#getTotalItems(int)
	 */
	@Override
	public int getTotalItems(int days) {
		int result = days;
		if (days > 1) {
			result = 0;
			for (int i = 1; i <= days; i++) {
				result += i;
			}
		}
		return result;
	}

}
