package Problems;
public class UserRegisteration {
    public boolean registerUser(String username, String email, String password) {

        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid username");
        }

        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }

        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Invalid password");
        }

        // If all validations pass
        return true;
    }
}
