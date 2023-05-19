package com.stringCalculator.StringCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class StringCalculatorApplicationTests {

	@Autowired StringCalculatorApplication stringCalculatorApplication;

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("Testing Empty String")
	void testEmptyString(){
		Assertions.assertEquals(0,stringCalculatorApplication.add(""));
	}

	@Test
	@DisplayName("Testing One Number At a Time")
	void testOneNumber(){
		Assertions.assertEquals(1,stringCalculatorApplication.add("1"));
		Assertions.assertEquals(5,stringCalculatorApplication.add("5"));
	}

	@Test
	@DisplayName("Testing Multiple Number")
	void testMultipleNumberSeparatedByComma(){
		Assertions.assertEquals(3,stringCalculatorApplication.add("1,2"));
		Assertions.assertEquals(22,stringCalculatorApplication.add("5,8,9"));
	}

	@Test
	@DisplayName("Testing New Line in String")
	void testNewLine(){
		Assertions.assertEquals(6,stringCalculatorApplication.add("1\n2,3"));
	}

	@Test
	@DisplayName("Testing new delimiter")
	void testNewDelimiter(){
		Assertions.assertEquals(3,stringCalculatorApplication.add("//;\n1;2"));
	}

	@Test
	@DisplayName("Testing negative numbers in String")
	void testSingleNegativeNumber(){
		try{
			stringCalculatorApplication.add("-1,2,3");
		}
		catch(IllegalArgumentException e){
			Assertions.assertEquals(e.getMessage(), "Negatives not allowed: -1");
		}
	}

	@Test
	@DisplayName("Testing negative numbers in String")
	void testMutipleNegativeNumbers(){
		try{
			stringCalculatorApplication.add("-1,2,-3");
		}
		catch(IllegalArgumentException e){
			Assertions.assertEquals(e.getMessage(), "Negatives not allowed: -1, -3");
		}
	}

}
