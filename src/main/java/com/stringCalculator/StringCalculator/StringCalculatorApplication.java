package com.stringCalculator.StringCalculator;

import org.springframework.boot.SpringApplication;
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

		// String of length > 1
		else{
			String [] numbersArray = numbers.split("[,\n]");
			return calculateSum(numbersArray);
		}
	}

	public int calculateSum(String[] numbersArray ){
		int total = 0;
		for(String currentNumber : numbersArray){
			total += Integer.parseInt(currentNumber);
		}
		return total;
	}



}
