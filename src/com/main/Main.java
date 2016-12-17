/**
 * 
 */
package com.main;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import com.engine.IXDaysAdder;
import com.engine.XDaysAdderTraditional;

/**
 * @author jmaro
 *
 */
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main.mainRunner(System.in, System.out, args);

	}
	
	protected static void mainRunner(InputStream in, PrintStream out,
			String[] args) {
		IXDaysAdder adder;
		try {
			Scanner keyboard = new Scanner(in);
			out.println("input");
			int input = keyboard.nextInt();
			adder = new XDaysAdderTraditional();
			out.println(adder.getTotalItems(input));
			keyboard.close();
		} catch (Exception e) {
			System.out.println("Exception caught: " + e.getMessage());
		}
	}

}
