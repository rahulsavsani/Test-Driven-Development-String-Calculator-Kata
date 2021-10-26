package com.calc;

public class StringCalculator {
	
	int add(String numbers) {
		
		if(numbers.length() == 3)
			return handleTwoNums(numbers);
		
		if(numbers.isEmpty())
			return handleEmptyString();
		
		return handleSingleNum(numbers);
	}

	private int handleSingleNum(String numbers) {
		return Integer.parseInt(numbers);
	}

	private int handleEmptyString() {
		return 0;
	}

	private int handleTwoNums(String numbers) {
		
		return Integer.parseInt(String.valueOf(numbers.charAt(0))) + Integer.parseInt(String.valueOf(numbers.charAt(2)));
	}
}
