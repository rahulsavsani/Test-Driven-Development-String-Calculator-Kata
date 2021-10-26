package com.calc;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestStringCalculator {
	
	private static StringCalculator sc;
	private String numbers;
	private int expectedResult;
	
	public TestStringCalculator(String numbers, int expectedResult) {
		super();
		this.numbers = numbers;
		this.expectedResult = expectedResult;
	}
	
	@Parameters
	public static Iterable<Object[]> inputs() {
		return Arrays.asList(new Object[][] {
			{"1",1},
			{"2",2}
		});
	}

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
		
		assertEquals(expectedResult, sc.add(numbers));
	}
	
}
