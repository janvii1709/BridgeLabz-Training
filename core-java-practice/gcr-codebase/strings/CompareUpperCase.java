import java.util.*;
public class CompareUpperCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking complete text input from user
        System.out.print("Enter the text: ");
        String Text = sc.nextLine();
        // Convert text to uppercase using charAt()
        String User_Upper = "";
        for (int i = 0; i < Text.length(); i++) {
            char Ch = Text.charAt(i);
            // Checking if the character is lowercase (a-z)
            if (Ch >= 'a' && Ch <= 'z') {
                // Convert to uppercase using ASCII difference (32)
                Ch = (char) (Ch - 32);
            }

            User_Upper = User_Upper + Ch;
        }
        // Convering the text using built-in toUpperCase()

        String Built_In_Upper = Text.toUpperCase();
        // Compare both strings using charAt()

        boolean Is_Equal = true;

        if (User_Upper.length() != Built_In_Upper.length()) {
            Is_Equal = false;
        } else {
            for (int i = 0; i < User_Upper.length(); i++) {
                if (User_Upper.charAt(i) != Built_In_Upper.charAt(i)) {
                    Is_Equal = false;
                    break;
                }
            }
        }
        // Displaying the results
        System.out.println("Uppercase using charAt(): " + User_Upper);
        System.out.println("Uppercase using toUpperCase(): " + Built_In_Upper);
        System.out.println("Are both results equal ? " + Is_Equal);

    }
}

