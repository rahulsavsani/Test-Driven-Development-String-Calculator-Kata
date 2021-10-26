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
			{"",0},						//addEmptyStringReturnsZero
			
			{"1",1},					//addSingleNumReturnsNum
			{"2",2},					//addSingleNumReturnsNum
			
			{"1,2",3},					//addTwoNumsReturnsSum
			{"1,3",4}					//addTwoNumsReturnsSum
			
		});
	}

	@BeforeClass
	public static void initialize() {
		
		sc = new StringCalculator();
	}
	
	@Test
	public void testStringCalculator() {
		
		assertEquals(expectedResult, sc.add(numbers));
	}

}
