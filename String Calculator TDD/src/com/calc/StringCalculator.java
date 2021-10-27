package com.calc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {
	
	private static final int EMPTY_STRING_SUM_VALUE = 0;
	
	int add(String numbers) throws RuntimeException {

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
		StringBuilder exceptionMsg = new StringBuilder("negatives not allowed : ");
		List<Integer> negatives = new ArrayList<>();
		
		negatives = nums.stream().filter(x -> x<0).collect(Collectors.toList());
		
		for(int i : nums) {
			
			sum += i;
		}
		
		if(!negatives.isEmpty()) {
			exceptionMsg.append(negatives.toString());
			throw new RuntimeException(exceptionMsg.toString());
		}
			
		return sum;
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
