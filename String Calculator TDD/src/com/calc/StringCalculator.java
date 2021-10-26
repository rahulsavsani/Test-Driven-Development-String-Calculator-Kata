package com.calc;

public class StringCalculator {
	
	int add(String numbers) {
		
		if(numbers.isEmpty()) 
			return 0;
		
		return Integer.parseInt(numbers);
	}
}
