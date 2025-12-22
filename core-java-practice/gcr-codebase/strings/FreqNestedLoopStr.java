import java.util.Scanner;
public class FreqNestedLoopStr {
    // Method to find frequency of each character in the string
    static String[] Frequency(String Str) {
        char[] chars = Str.toCharArray(); // Convert string to character array
        int[] Freq = new int[chars.length]; // Array to store frequency of each character
        // Loop through each character to count frequency
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') continue; // Skip characters already counted
            Freq[i] = 1; // Initialize frequency as 1 for current character

            // Inner loop to check for duplicates
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    Freq[i]++; // Increment frequency
                    chars[j] = '0'; // Mark duplicate as counted
                }
            }
        }
        // Count number of unique characters
        int Count = 0;
        for (int i = 0; i < Freq.length; i++)
            if (Freq[i] > 0 && chars[i] != '0')
                Count++;
        // Create result array to store frequency information
        String[] Res = new String[Count];
        int index = 0;
        // Fill result array with character : frequency strings
        for (int i = 0; i < Freq.length; i++) {
            if (Freq[i] > 0 && chars[i] != '0') {
                Res[index++] = chars[i] + " : " + Freq[i];
            }
        }
        return Res; // Return array of frequency strings
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String Str = sc.nextLine(); // Read input string from user
        // Get frequency of each character
        String[] Res = Frequency(Str);
        // Print frequency of each character
        for (String s : Res)
            System.out.println(s);
    }
}
