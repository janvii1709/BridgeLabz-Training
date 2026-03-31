package ProblemTests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Problems.DateFormatter;
public class DateFormatterTest {
    private DateFormatter formatter;
    @BeforeEach
    void setUp() {
        formatter = new DateFormatter();
    }
    @Test
    void testValidDate() {
        assertEquals("30-01-2024",
                formatter.formatDate("2024-01-30"));
    }
    @Test
    void testInvalidDate() {
        assertThrows(IllegalArgumentException.class, () ->
                formatter.formatDate("30/01/2024"));
    }
    @Test
    void testNullDate() {
        assertThrows(IllegalArgumentException.class, () ->
                formatter.formatDate(null));
    }
}
