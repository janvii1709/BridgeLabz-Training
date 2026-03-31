import java.util.Scanner;
public class FreqUniqueStr {
    // Method to find unique characters in a string using nested loops
    static char[] Unique_Characters(String Str) {
        char[] Chars = Str.toCharArray();
        String Unique = ""; // String to store unique characters
        for (int i = 0; i < Chars.length; i++) {
            boolean Is_Unique = true;
            // Check if character is already in unique string
            for (int j = 0; j < Unique.length(); j++) {
                if (Chars[i] == Unique.charAt(j)) {
                    Is_Unique = false;
                    break;
                }
            }
            if (Is_Unique) {
                Unique += Chars[i]; // Add character if not already present
            }
        }

        return Unique.toCharArray(); // Return unique characters as char array
    }

    // Method to find frequency of characters and return as 2D array
    static String[][] Frequency(String Str) {
        int[] Freq = new int[256]; // ASCII table size
        // Count frequency of each character
        for (int i = 0; i < Str.length(); i++) {
            char C = Str.charAt(i);
            Freq[C]++; // Use ASCII value as index
        }

        char[] Unique_Chars = Unique_Characters(Str); // Get unique characters
        String[][] Res = new String[Unique_Chars.length][2];

        // Store character and its frequency in 2D array
        for (int i = 0; i < Unique_Chars.length; i++) {
            Res[i][0] = Character.toString(Unique_Chars[i]);
            Res[i][1] = Integer.toString(Freq[Unique_Chars[i]]);
        }

        return Res; // Return 2D array
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String Str = sc.nextLine(); // Read input string

        // Get frequency of unique characters
        String[][] Freq_Result = Frequency(Str);

        // Display result
        System.out.println("Character : Frequency");
        for (int i = 0; i < Freq_Result.length; i++) {
            System.out.println(Freq_Result[i][0] + " : " + Freq_Result[i][1]);
        }
    }
}
