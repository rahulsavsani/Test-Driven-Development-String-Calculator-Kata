package com.calc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {
	
	private static final int EMPTY_STRING_SUM_VALUE = 0;
	
	int add(String numbers) {

		if(isEmptyString(numbers))
			return EMPTY_STRING_SUM_VALUE;
		
		return handleMultipleNums(numbers);
	}
	

	private int handleMultipleNums(String numbers) {

		List<Integer> nums = tokenize(numbers); 
		
		return getTokenSum(nums);
		
	}


	private int getTokenSum(List<Integer> nums) {
		int sum = 0;
		for(int i : nums)
			sum += i;
		return sum;
	}


	private List<Integer> tokenize(String numbers) {
		String[] strNums;
		
		if(numbers.startsWith("//")) {
			
			String[] str = numbers.split("\n");
			strNums = str[1].split(String.valueOf(str[0].charAt(2)));			
		}
		else {
			strNums = numbers.split(",|\n");			
		}
		
		return Stream.of(strNums).map(Integer::valueOf).collect(Collectors.toList());
	}

	private boolean isEmptyString(String numbers) {
		return numbers.isEmpty();
	}

}
