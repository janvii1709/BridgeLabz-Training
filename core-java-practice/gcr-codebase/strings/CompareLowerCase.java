import java.util.*;
public class CompareLowerCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         // Taking the complete text input from user
        System.out.print("Enter the text: ");
        String Text = sc.nextLine();
         // Converting the text to lowercase using charAt()
        String User_Lower = "";
        for (int i = 0; i < Text.length(); i++) {
            char Ch = Text.charAt(i);
            // Checking  if character is uppercase (A-Z)
            if (Ch >= 'A' && Ch <= 'Z') {
                // Convert to lowercase using ASCII difference (32)
                Ch = (char) (Ch + 32);
            }
            User_Lower = User_Lower + Ch;
        }
        // Converting the text using built-in toLowerCase()
        String Built_In_Lower = Text.toLowerCase();
        // Comparing both the strings using charAt()
        boolean Is_Equal = true;
        if (User_Lower.length() != Built_In_Lower.length()) {
            Is_Equal = false;
        } else {
            for (int i = 0; i < User_Lower.length(); i++) {
                if (User_Lower.charAt(i) != Built_In_Lower.charAt(i)) {
                    Is_Equal = false;
                    break;
                }
            }
        }
        // Displaying the  results

        System.out.println("Lowercase using charAt(): " + User_Lower);
        System.out.println("Lowercase using toLowerCase(): " + Built_In_Lower);
        System.out.println("Are both results equal? " + Is_Equal);

    }
}

