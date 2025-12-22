import java.util.*;
public class NonRepeatingCharStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take input string from user
        System.out.print("Enter a string: ");
        String Str = sc.nextLine();
        // Calculate string length manually without using length()
        int Num = 0;
        try {
            while (true) {
                Str.charAt(Num); // Try to access character at index n
                Num++;           // Increment count
            }
        } catch (IndexOutOfBoundsException e) {
            // Exception occurs when index exceeds string length
            // n now holds the length of the string
        }

        // Create frequency array for all ASCII characters (0-255)
        int[] Freq = new int[256];

        // Count frequency of each character in the string
        for (int i = 0; i < Num; i++) {
            char Ch = Str.charAt(i); // Get character at position i
            Freq[Ch]++;              // Increment its frequency
        }

        // Initialize variable to store first non-repeating character
        char First_Non_Repeating = '\0';

        // Loop to find the first character with frequency 1
        for (int i = 0; i < Num; i++) {
            if (Freq[Str.charAt(i)] == 1) {
                First_Non_Repeating = Str.charAt(i); // Found first non-repeating
                break;                             // Exit loop after finding
            }
        }

        // Display the result
        if (First_Non_Repeating != '\0') {
            System.out.println("First non-repeating character is: " + First_Non_Repeating);
        } else {
            System.out.println("No non-repeating character found.");
        }

    }
    
}
