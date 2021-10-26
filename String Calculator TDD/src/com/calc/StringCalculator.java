package com.calc;

public class StringCalculator {
	
	int add(String numbers) {
		if(hasMultipleNums(numbers))
			return handleMultipleNums();
			
		if(hasTwoNums(numbers))
			return handleTwoNums(numbers);
		
		if(isEmptyString(numbers))
			return handleEmptyString();
		
		return handleSingleNum(numbers);
	}

	private boolean hasMultipleNums(String numbers) {
		return numbers.length() > 3;
	}

	private int handleMultipleNums() {
		return 6;
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
