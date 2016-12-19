package com.main;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Ignore;
import org.junit.Test;

public class MainTest {

	@Test
	public void testNewMain() {
		Main pgm = new Main();
		assertNotNull(pgm);
	}
	
	@Ignore
	public void testNormalRun() {
		Main.main(null);
		assertTrue(true); // If it makes it this far there were no errors!
	}

	@Test
	public void testAlternateInputStreamSet() {
		String inputData = "12";
		InputStream input = new ByteArrayInputStream(inputData.getBytes());
		Main.mainRunner(input, System.out, null);
//		Main.setInputStr(stdIn);
//		Main.main(null);
		assertTrue(true); // If it makes it this far there were no errors!
	}
	
	@Test
	public void testAlternateOutputStreamSetNormalRun() {
		String inputData = "12";
		InputStream input = new ByteArrayInputStream(inputData.getBytes());
		ByteArrayOutputStream outData = new ByteArrayOutputStream();
		PrintStream output = new PrintStream(outData);
		Main.mainRunner(input, output, null);
		System.out.println("Output data: " + outData.toString().split("\n")[1]);
		assertEquals(78,
				Integer.parseInt(outData.toString().split("\n")[1].trim()));
	}
}
