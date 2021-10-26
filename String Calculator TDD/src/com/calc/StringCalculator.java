package com.calc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {
	
	int add(String numbers) {
		if(hasMultipleNums(numbers))
			return handleMultipleNums(numbers);
			
		if(isEmptyString(numbers))
			return handleEmptyString();
		
		return handleSingleNum(numbers);
	}

	private boolean hasMultipleNums(String numbers) {
		return numbers.length() > 1;
	}

	private int handleMultipleNums(String numbers) {

		String[] strNums;
		strNums = numbers.split(",");
		
		List<Integer> nums = Stream.of(strNums).map(Integer::valueOf).collect(Collectors.toList()); 
		
		int sum = 0;
		for(int i : nums)
			sum += i;
		
		return sum;
	}

	private boolean isEmptyString(String numbers) {
		return numbers.isEmpty();
	}

	private int handleSingleNum(String numbers) {
		return Integer.parseInt(numbers);
	}

	private int handleEmptyString() {
		return 0;
	}
}
