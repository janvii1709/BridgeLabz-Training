import java.util.Scanner;
public class TrimStr  {
    // Method to find the start and end index after trimming spaces
    static int[] trimIndexes(String str) {
        int Start = 0;
        int End = str.length() - 1;
        // Find first non-space character from start
        while (Start <= End && str.charAt(Start) == ' ') {
            Start++;
        }
        // Find first non-space character from end
        while (End >= Start && str.charAt(End) == ' ') {
            End--;
        }

        return new int[]{Start, End}; // Return start and end index
    }
    // Method to create a substring manually using charAt()
    static String substringCharAt(String str, int Start, int End) {
        String Res = "";
        for (int i = Start; i <= End; i++) {
            Res += str.charAt(i); // Append each character to result
        }
        return Res;
    }

    // Method to compare two strings manually using charAt()
    static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false; // Length mismatch
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false; // Character mismatch
        }
        return true; // All characters match
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text with leading/trailing spaces: ");
        String T1 = sc.nextLine();

        // Get start and end indexes after trimming spaces
        int[] Index = trimIndexes(T1);

        // Create trimmed string manually
        String trimmedManual = substringCharAt(T1, Index[0], Index[1]);

        // Use built-in trim() method
        String trimmedBuiltIn = T1.trim();

        // Compare the manual trimmed string with built-in trim
        boolean Is_Equal = compareStrings(trimmedManual, trimmedBuiltIn);

        // Display results
        System.out.println("Trimmed manually: '" + trimmedManual + "'");
        System.out.println("Trimmed using trim(): '" + trimmedBuiltIn + "'");
        System.out.println("Are both strings equal? " + Is_Equal);
    }
}
