package com.stringCalculator.StringCalculator;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StringCalculatorApplication {
	public int add(String numbers){

		// Empty String Check
		if(numbers.length() == 0){
			return 0;
		}

		// String of length 1
		if(numbers.length() == 1){
			return Integer.parseInt(numbers);
		}

		// String of length > 1 and checking whether there can be other delimiter possible
		else{
			String currentDelimiter = ",";
			if(numbers.matches("//(.*)\n(.*)")) {
				currentDelimiter =  Character.toString(numbers.charAt(2));
				numbers = numbers.substring(4);
			}
			String [] numbersArray = numbers.split(currentDelimiter + "|[,\n]");
			return calculateSum(numbersArray);
		}
	}

	public int calculateSum(String[] numbersArray ){
		int total = 0;
		StringBuilder negativeNumber = new StringBuilder();
		for(String currentNumber : numbersArray){
			if(Integer.parseInt(currentNumber) < 0) {					// check wheter a number is negative
				if (negativeNumber.toString().equals("")) {
					negativeNumber = new StringBuilder(currentNumber);
				} else {
					negativeNumber.append(", ").append(currentNumber);
				}
			}
			total += Integer.parseInt(currentNumber);
		}
		if(!negativeNumber.toString().equals("")){						// if negative throw error
			throw new IllegalArgumentException("negatives not allowed: " + negativeNumber);
		}
		return total;
	}



}
