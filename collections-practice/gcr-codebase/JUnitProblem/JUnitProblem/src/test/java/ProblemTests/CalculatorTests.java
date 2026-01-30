package ProblemTests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Problems.Calculators;
public class CalculatorTests {
    private Calculators calculators;
    @BeforeEach
    void setUp() {
        calculators = new Calculators(); // Must match class name
    }
    // Test normal division
    @Test
    void testDivideNormal() {
        assertEquals(5, calculators.divide(10, 2));
        assertEquals(-3, calculators.divide(9, -3));
    }
    // Test division by zero exception
    @Test
    void testDivideByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class , () -> calculators.divide(10, 0));
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }
}
