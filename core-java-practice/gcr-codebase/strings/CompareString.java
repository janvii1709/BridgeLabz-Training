import java.util.Scanner;
public class CompareString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //taking input of both the strings 
        System.out.println("Enter The First String : " );
        String Str1 = sc.nextLine();
        System.out.println("Enter The Second String");
        String Str2 = sc.nextLine();
        // Variable to store result of charAt() comparison
        boolean Char_At_Result = true;
        // Checking if lengths of both strings are equal
        if (Str1.length() != Str2.length()) {
            Char_At_Result = false; // If lengths differ, strings are not equal
        } else {
            // Comparing each character using charAt()
            for (int i = 0; i < Str1.length(); i++) {
                // If any character does not match
                if (Str1.charAt(i) != Str2.charAt(i)) {
                    Char_At_Result = false;
                    break; // Exit loop if mismatch found
                }
            }
        }
        // Comparing strings using built-in equals() method
        boolean Equals_Result = Str1.equals(Str2);
        // Displaying after both the comparisons
        System.out.println("Result using charAt() method: " + Char_At_Result);
        System.out.println("Result using equals() method: " + Equals_Result);
        // Check whether both methods give same result
        if (Char_At_Result == Equals_Result) {
            System.out.println("Both methods give the SAME result.");
        } else {
            System.out.println("Both methods give DIFFERENT results.");
        }
    }
}
