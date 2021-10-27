package com.calc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {
	
	private static final int EMPTY_STRING_SUM_VALUE = 0;
	int callCount = 0;
	
	public int getCallCount() {
		return callCount;
	}
	
	int add(String numbers) throws RuntimeException {
		
		synchronized(this) {
			callCount++;
		}
		
		if(isEmptyString(numbers))
			return EMPTY_STRING_SUM_VALUE;
		
		return handleMultipleNums(numbers);
	}
	

	private int handleMultipleNums(String numbers) throws RuntimeException {

		List<Integer> nums = tokenize(numbers); 
		
		return getTokenSum(nums);
		
	}


	private int getTokenSum(List<Integer> nums) throws RuntimeException {
		int sum = 0;

		handleNegativeNums(nums);
		
		for(int i : nums) {
			
			if(isLessThan1000(i))
				sum += i;
		}
			
		return sum;
	}

	private boolean isLessThan1000(int i) {
		return i <= 1000;
	}


	private void handleNegativeNums(List<Integer> nums) throws RuntimeException {
		
		StringBuilder exceptionMsg = new StringBuilder("negatives not allowed : ");
		List<Integer> negatives = nums.stream().filter(x -> x<0).collect(Collectors.toList());
		
		if(!negatives.isEmpty()) {
			
			exceptionMsg.append(negatives.toString());
			throw new RuntimeException(exceptionMsg.toString());
		
		}
	}


	private List<Integer> tokenize(String numbers) {
		String[] strNums;
		
		if(containsCustomDelimeter(numbers)) 
			strNums = splitByCustomDelimeter(numbers);			
		
		else 
			strNums = splitByCommaNewLine(numbers);			
		
		return mapTokensToInteger(strNums);
	}


	private List<Integer> mapTokensToInteger(String[] strNums) {
		return Stream.of(strNums).map(Integer::valueOf).collect(Collectors.toList());
	}


	private String[] splitByCommaNewLine(String numbers) {
		String[] strNums;
		strNums = numbers.split(",|\n");
		return strNums;
	}


	private String[] splitByCustomDelimeter(String numbers) {

		String[] str = numbers.split("\n");

		return str[1].split(String.valueOf(str[0].charAt(2)));
	}


	private boolean containsCustomDelimeter(String numbers) {
		return numbers.startsWith("//");
	}

	private boolean isEmptyString(String numbers) {
		return numbers.isEmpty();
	}

}
