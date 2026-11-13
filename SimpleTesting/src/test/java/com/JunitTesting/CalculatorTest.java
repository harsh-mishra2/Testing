package com.JunitTesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTest {
	
	@Test
	public void testAdd() {
		Calculator cal = new Calculator();
		int actualValue = cal.add(10, 20);
		int expectedValue = 30;
		
		Assertions.assertEquals(expectedValue, actualValue);
	}
	

}
