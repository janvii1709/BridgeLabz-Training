import java.util.Scanner;
public class VowelConsonantsStr {
    // Method to check if a character is a vowel, consonant, or not a letter
    static String Char_Type(char C) {
        // Convert uppercase to lowercase using ASCII
        if (C >= 'A' && C <= 'Z') {
            C = (char)(C + 32);
        }

        // Check if character is a letter
        if (C >= 'a' && C <= 'z') {
            if (C == 'a' || C == 'e' || C == 'i' || C == 'o' || C == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

    // Method to analyze string and print character types
    static void analyzeString(String T1) {
        for (int i = 0; i < T1.length(); i++) {
            char C = T1.charAt(i);
            System.out.println("'" + C + "' is a " + Char_Type(C));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String T1 = sc.nextLine();

        // Analyze string and display results
        analyzeString(T1);
    }
}
