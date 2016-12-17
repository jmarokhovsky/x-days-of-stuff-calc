/**
 * 
 */
package com.engine;

/**
 * @author jmaro
 *
 */
public class XDaysAdderAlternate implements IXDaysAdder {

	/* (non-Javadoc)
	 * @see com.engine.IXDaysAdder#getTotalItems(int)
	 */
	@Override
	public int getTotalItems(int days) {
		int result = 0;
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

}
