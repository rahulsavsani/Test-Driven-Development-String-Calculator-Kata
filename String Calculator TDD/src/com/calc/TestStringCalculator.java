package com.calc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestStringCalculator {

	@Test
	public void addEmptyStringReturnsZero() {
		
		StringCalculator sc = new StringCalculator();
		
		assertEquals(0, sc.add(""));
	}
}
