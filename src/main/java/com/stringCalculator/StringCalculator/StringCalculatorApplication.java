package com.stringCalculator.StringCalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StringCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringCalculatorApplication.class, args);
		System.out.println("Hello");
	}


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
			return 0;
		}
	}



}
