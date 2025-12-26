import java.util.*;
public class VowelConsonantCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input from the user
        System.out.print("Enter a string: ");
        String Input = sc.nextLine();
        // Counters for vowels and consonants
        int Vowels = 0, Consonants = 0;
        // Convert string to lowercase to simplify checking
        String LowerInput = Input.toLowerCase();
        // Loop through each character
        for (int i = 0; i < LowerInput.length(); i++) {
            char Ch = LowerInput.charAt(i);
            // Check if character is a letter
            if (Ch >= 'a' && Ch <= 'z') {
                // Check for vowels
                if (Ch == 'a' || Ch == 'e' || Ch == 'i' || Ch == 'o' || Ch == 'u') {
                    Vowels++;
                } else {
                    Consonants++;
                }
            }
        }
        // Display the results
        System.out.println("Number of vowels: " + Vowels);
        System.out.println("Number of consonants: " + Consonants);
    }
}
