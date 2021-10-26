package com.calc;

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
		if(numbers.length() == 3)
			return Integer.parseInt(String.valueOf(numbers.charAt(0))) + Integer.parseInt(String.valueOf(numbers.charAt(2)));
		
		return Integer.parseInt(String.valueOf(numbers.charAt(0))) + Integer.parseInt(String.valueOf(numbers.charAt(2))) + Integer.parseInt(String.valueOf(numbers.charAt(4)));
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
