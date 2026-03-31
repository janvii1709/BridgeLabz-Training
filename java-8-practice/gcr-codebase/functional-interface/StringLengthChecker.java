import java.util.Scanner;
import java.util.function.Function;
public class StringLengthChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your message: ");
        String message = sc.nextLine();
        System.out.print("Enter character limit: ");
        int limit = sc.nextInt();
        Function<String, Integer> lengthFunction = str -> str.length();
        int length = lengthFunction.apply(message);
        if (length > limit) {
            System.out.println("Message exceeds the character limit!");
        } else {
            System.out.println("Message is within the character limit.");
        }
        System.out.println("Message Length: " + length);
    }
}
