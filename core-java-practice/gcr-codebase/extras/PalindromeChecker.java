import java.util.Scanner;
public class PalindromeChecker {
    // Method to take input
    static String GetInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        return sc.nextLine();
    }
    // Method to check palindrome
    static boolean IsPalindrome(String string) {
        int Start = 0;
        int End = string.length() - 1;

        while (Start < End) {
            if (string.charAt(Start) != string.charAt(End)) {
                return false;
            }
            Start++;
            End--;
        }
        return true;
    }

    // Method to display result
    static void DisplayResult(String string, boolean Output) {
        if (Output) {
            System.out.println(string + " is a Palindrome");
        } else {
            System.out.println(string + " is NOT a Palindrome");
        }
    }

    public static void main(String[] args) {
        String string = GetInput();
        boolean Output = IsPalindrome(string);
        DisplayResult(string, Output);
    }
}
