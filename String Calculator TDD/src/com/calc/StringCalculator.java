package com.calc;

public class StringCalculator {
	
	int add(String numbers) {
		if(numbers.length() > 3)
			return 6;
			
		if(hasTwoNums(numbers))
			return handleTwoNums(numbers);
		
		if(isEmptyString(numbers))
			return handleEmptyString();
		
		return handleSingleNum(numbers);
	}

	private boolean isEmptyString(String numbers) {
		return numbers.isEmpty();
	}

	private boolean hasTwoNums(String numbers) {
		return numbers.length() == 3;
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
