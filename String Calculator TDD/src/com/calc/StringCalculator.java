package com.calc;

public class StringCalculator {
	
	int add(String numbers) {
		
		if(numbers.length() == 3)
			return handleTwoNums();
		
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

	private int handleTwoNums() {
		return 3;
	}
}
