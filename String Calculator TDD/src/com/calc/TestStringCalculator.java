package com.calc;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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
			{"1,3",4},					//addTwoNumsReturnsSum
			
			{"1,2,3",6},					//addMultipleNumsReturnsSum
			{"1,2,4",7},					//addMultipleNumsReturnsSum
			{"1,2,3,4",10},					//addMultipleNumsReturnsSum
			
			{"1\n2",3},						//addNewLineDelimeterReturnsSum
			{"1\n2,3",6},					//addNewLineDelimeterReturnsSum
			
			{"//;\n1;2",3},					//addCustomDelimeterReturnsSum
			{"//&\n1&2&3",6}				//addCustomDelimeterReturnsSum
			
		});
	}

	@BeforeClass
	public static void initialize() {
		
		sc = new StringCalculator();
	}
	
	@Test
	public void testStringCalculatorPositiveNums() {
		
		assertEquals(expectedResult, sc.add(numbers));
	}
	
	@SuppressWarnings("deprecation")
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testStringCalculatorNegativeNums() throws RuntimeException{
		
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("negatives not allowed : -1");
		sc.add("-1");
//		RuntimeException e = assertThrows(RuntimeException.class, sc.add("-1"));
	}

}
