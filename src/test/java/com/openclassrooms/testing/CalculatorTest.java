package com.openclassrooms.testing;

import static org.junit.jupiter.api.Assertions.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@Slf4j
class CalculatorTest {

	Calculator calculatorUnderTest;

	@BeforeEach
	void initCalculator() {
		log.info("Init Calculator");
		calculatorUnderTest = new Calculator();
	}

	@Test
	void testAddTwoPositiveNumbers() {
		// Arrange
		int a = 2;
		int b = 3;
		Calculator calculator = new Calculator();

		// Act
		int somme = calculator.add(a, b);

		// Assert
		assertEquals(5, somme);
	}

	@Test
	void multiply_shouldReturnTheProduct_ofTwoIntegers() {
		int a = 2;
		int b = 3;
		int expected = 6;

		int actual = calculatorUnderTest.multiply(a, b);

		assertEquals(expected, actual);
	}

	@ParameterizedTest(name = "{0} x 0 should be equal to 0")
	@ValueSource(ints = {1, 3, 323, 42231, 4})
	void multiply_shouldReturnZero_WhenMulpliedAnIntegerWithZero(int arg) {
		int actual =  calculatorUnderTest.multiply(arg, 0);
		assertEquals(0, actual);
	}

	@ParameterizedTest(name = "{0} + {1} should be equal to {2}")
	@CsvSource({"1,2,3", "2,3,5", "44,55,99"})
	void add_shouldReturnTheSum_ofTwoIntegers(int a, int b, int expected) {
		int actual = calculatorUnderTest.add(a, b);
		assertEquals(expected, actual);
	}

	@Test
	@Timeout(200)
	void longCalculation_shouldCompute_InLessThan1Second() {
		calculatorUnderTest.longCalculation();
	}

}
