package ProblemTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Problems.PasswordValidator;
import static org.junit.jupiter.api.Assertions.*;
public class PasswordValidatorTest {
    private PasswordValidator validator;
    @BeforeEach
    void setUp() {
        validator = new PasswordValidator();
    }
    // Valid password test
    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("Password1"));
    }

    //  Less than 8 characters
    @Test
    void testPasswordTooShort() {
        assertFalse(validator.isValid("Pass1"));
    }
    @Test
    void testNoUppercase() {
        assertFalse(validator.isValid("password1"));
    }

    //  No digit
    @Test
    void testNoDigit() {
        assertFalse(validator.isValid("Password"));
    }

    //  Null password
    @Test
    void testNullPassword() {
        assertFalse(validator.isValid(null));
    }
}
