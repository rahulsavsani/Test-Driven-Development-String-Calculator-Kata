package com.calc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {
	
	int add(String numbers) {

		if(isEmptyString(numbers))
			return handleEmptyString();
		
		return handleMultipleNums(numbers);
	}
	

	private int handleMultipleNums(String numbers) {

		List<Integer> nums = tokenize(numbers); 
		
		int sum = getTokenSum(nums);
		
		return sum;
	}


	private int getTokenSum(List<Integer> nums) {
		int sum = 0;
		for(int i : nums)
			sum += i;
		return sum;
	}


	private List<Integer> tokenize(String numbers) {
		String[] strNums;
		strNums = numbers.split(",|\n");
		
		List<Integer> nums = Stream.of(strNums).map(Integer::valueOf).collect(Collectors.toList());
		return nums;
	}

	private boolean isEmptyString(String numbers) {
		return numbers.isEmpty();
	}

	private int handleEmptyString() {
		return 0;
	}
}
