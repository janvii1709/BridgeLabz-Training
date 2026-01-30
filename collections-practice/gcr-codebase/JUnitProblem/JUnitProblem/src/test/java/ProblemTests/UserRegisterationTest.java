package ProblemTests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Problems.UserRegisteration;
public class UserRegisterationTest {
    private UserRegisteration registration;
    @BeforeEach
    void setUp() {
        registration = new UserRegisteration();
    }
    //  Valid user registration
    @Test
    void testValidRegistration() {
        assertTrue(
            registration.registerUser(
                "john_doe",
                "john@gmail.com",
                "password123"
            )
        );
    }
    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () ->
            registration.registerUser(
                "",
                "john@gmail.com",
                "password123"
            )
        );
    }
    // Invalid email
    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () ->
            registration.registerUser(
                "john_doe",
                "johngmail.com",
                "password123"
            )
        );
    }
    //  Invalid password
    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () ->
            registration.registerUser(
                "john_doe",
                "john@gmail.com",
                "pass"
            )
        );
    }
}
