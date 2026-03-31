import java.util.Scanner;
public class PalindromeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input from the user
        System.out.print("Enter a string: ");
        String string = sc.nextLine();

        // Convert string to lowercase to ignore case
        String str = string.toLowerCase();

        boolean IsPalindrome = true;

        // Loop to check characters from start and end
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                IsPalindrome = false;
                break;
            }
        }

        // Display result
        if (IsPalindrome) {
            System.out.println("\"" +  string + "\" is a palindrome.");
        } else {
            System.out.println("\"" + string + "\" is not a palindrome.");
        }
    }
}
