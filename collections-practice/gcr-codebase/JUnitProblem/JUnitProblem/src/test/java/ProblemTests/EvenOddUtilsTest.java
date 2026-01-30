package ProblemTests;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import Problems.EvenOddUtils;
public class EvenOddUtilsTest {
	    private EvenOddUtils utils = new EvenOddUtils();
	    // Test even numbers
	    @ParameterizedTest
	    @ValueSource(ints = {2, 4, 6})
	    void testEvenNumbers(int number) {
	        assertTrue(utils.isEven(number),number + " should be even");
	    }
	    // Test odd numbers
	    @ParameterizedTest
	    @ValueSource(ints = {7, 9})
	    void testOddNumbers(int number) {
	        assertFalse(utils.isEven(number),number + " should be odd");
	    }
}

