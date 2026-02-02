import java.util.Scanner;
public class TestMaxLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter username: ");
            String username = sc.nextLine();
            User user = new User(username);
            System.out.println("User created successfully with username: " + user.getUsername());
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }
}
