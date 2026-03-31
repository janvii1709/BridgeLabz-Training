import java.util.Scanner;
public class AnagramsStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take user input
        System.out.print("Enter first text: ");
        String Str1 = sc.nextLine();

        System.out.print("Enter second text: ");
        String Str2 = sc.nextLine();

        // Call method to check anagram
        boolean Res = Is_Anagram(Str1, Str2);

        // OUTPUT  OF THE ABOVE
        if (Res) {
            System.out.println("The given texts are Anagrams.");
        } else {
            System.out.println("The given texts are NOT Anagrams.");
        }
    }

    // Method to check if two texts are anagrams
    public static boolean Is_Anagram(String Str1, String Str2) {

        // Remove spaces and convert to lowercase
        Str1 = Str1.replaceAll("\\s", "").toLowerCase();
        Str2 = Str2.replaceAll("\\s", "").toLowerCase();

        // Check if lengths are equal
        if (Str1.length() != Str2.length()) {
            return false;
        }

        //  Create frequency arrays
        int[] Freq1 = new int[26];
        int[] Freq2 = new int[26];

        //  Find frequency of characters
        for (int i = 0; i < Str1.length(); i++) {
            Freq1[Str1.charAt(i) - 'a']++;
            Freq2[Str2.charAt(i) - 'a']++;
        }

        // Compare frequencies
        for (int i = 0; i < 26; i++) {
            if (Freq1[i] != Freq2[i]) {
                return false;
            }
        }

        return true;
    }
}
