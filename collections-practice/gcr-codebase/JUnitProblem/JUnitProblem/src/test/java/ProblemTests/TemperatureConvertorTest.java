package ProblemTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Problems.TemperatureConvertor;
import static org.junit.jupiter.api.Assertions.*;
public class TemperatureConvertorTest {
    private TemperatureConvertor convertor;
    @BeforeEach
    void setUp() {
        convertor = new TemperatureConvertor();
    }
    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, convertor.celsiusToFahrenheit(0), 0.01);
        assertEquals(212.0, convertor.celsiusToFahrenheit(100), 0.01);
    }
    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0, convertor.fahrenheitToCelsius(32), 0.01);
        assertEquals(100.0, convertor.fahrenheitToCelsius(212), 0.01);
    }
}
