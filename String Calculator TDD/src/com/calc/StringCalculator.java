package com.calc;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StringCalculator {
	
	private static final int EMPTY_STRING_SUM_VALUE = 0;
	int callCount = 0;
	
	public int getCallCount() {
		return callCount;
	}
	
	int add(String numbers) throws RuntimeException {
		
		synchronized(this) {
			callCount++;
		}
		
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

		handleNegativeNums(nums);
		
		for(int i : nums) {
			
			if(isLessThan1000(i))
				sum += i;
		}
			
		return sum;
	}

	private boolean isLessThan1000(int i) {
		return i <= 1000;
	}


	private void handleNegativeNums(List<Integer> nums) throws RuntimeException {
		
		StringBuilder exceptionMsg = new StringBuilder("negatives not allowed : ");
		
		List<Integer> negatives = getNegatives(nums);
		
		if(!negatives.isEmpty()) {
			
			exceptionMsg.append(negatives.toString());
			throw new RuntimeException(exceptionMsg.toString());
		
		}
	}

	private List<Integer> getNegatives(List<Integer> nums) {
		return nums.stream().filter(x -> x<0).collect(Collectors.toList());
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
		
		if(containsMultiLengthCustDelimeter(numbers)) 
			return splitByMultiLengthCustomDelimeter(numbers);
			
		return str[1].split(String.valueOf(str[0].charAt(2)));
	}

	
	private String[] splitByMultiLengthCustomDelimeter(String numbers) {
		
		Matcher m = Pattern.compile("//(\\[.+\\])+\n(.*)").matcher(numbers);
		m.matches();
		String delimeter = m.group(1);
		String nums = m.group(2);
		
		String del = buildDelimeterString(delimeter);
		
		return nums.split(del);
	}

	
	private String buildDelimeterString(String delimeter) {
		
		StringBuilder sb = new StringBuilder();
		int l = delimeter.length();
		
		for(int i = 0; i<l; i++) {
			
			if(delimeter.charAt(i) == ']' && i != l-1) {
				sb.append('|');
			}
			else if(delimeter.charAt(i) != '[' && delimeter.charAt(i) != ']'){
				sb.append("\\");
				sb.append(delimeter.charAt(i));
			}
		}
		
		return sb.toString();
	}

	private boolean containsMultiLengthCustDelimeter(String numbers) {
		return numbers.startsWith("//[");
	}


	private boolean containsCustomDelimeter(String numbers) {
		return numbers.startsWith("//");
	}

	private boolean isEmptyString(String numbers) {
		return numbers.isEmpty();
	}

}
