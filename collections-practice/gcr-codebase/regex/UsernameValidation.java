import java.util.Scanner;
public class UsernameValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        if (username.matches(regex)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
