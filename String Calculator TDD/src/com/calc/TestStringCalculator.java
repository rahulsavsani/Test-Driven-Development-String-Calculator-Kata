package com.calc;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestStringCalculator {
	
	private static StringCalculator sc;
	
	@BeforeClass
	public static void initialize() {
		
		sc = new StringCalculator();
	}

	@Test
	public void addEmptyStringReturnsZero() {
		
		assertEquals(0, sc.add(""));
	}
	
	@Test
	public void addSingleNumReturnsNum() {
		
		assertEquals(1, sc.add("1"));
	}
}
