package ProblemTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import Problems.Calculator;

public class CalculatorTest {
	 Calculator calculator = new Calculator();

	    @Test
	    void testAdd() {
	        assertEquals(8, calculator.add(5, 3));
	    }

	    @Test
	    void testSubtract() {
	        assertEquals(2, calculator.subtract(5, 3));
	    }

	    @Test
	    void testMultiply() {
	        assertEquals(15, calculator.multiply(5, 3));
	    }

	    @Test
	    void testDivide() {
	        assertEquals(5, calculator.divide(10, 2));
	    }
	    @Test
	    void testDivideByZero() {
	        ArithmeticException exception = assertThrows(
	                ArithmeticException.class,
	                () -> calculator.divide(10, 0)
	        );

	        assertEquals("Division by zero is not allowed", exception.getMessage());

}
}
