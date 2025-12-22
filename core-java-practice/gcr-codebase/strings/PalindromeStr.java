import java.util.Scanner;
public class PalindromeStr {
    // Logic 1: Check palindrome using a loop
    static boolean Is_Palindrome_Loop(String Str) {
        int Start = 0, End = Str.length() - 1; // Initialize start and end pointers
        while (Start < End) { // Loop until the pointers meet in the middle
            if (Str.charAt(Start) != Str.charAt(End)) // If characters don't match
                return false; // Not a palindrome
            Start++; // Move start forward
            End--;   // Move end backward
        }
        return true; // All characters matched, it's a palindrome
    }
    //Logic 2: Check palindrome using recursion
    static boolean Is_Palindrome_Rec(String Str, int Start, int End) {
        if (Start >= End) return true; // Base case: pointers crossed, palindrome
        if (Str.charAt(Start) != Str.charAt(End)) return false; // Characters don't match
        return Is_Palindrome_Rec(Str, Start + 1, End - 1); // Recur for inner substring
    }
    // Logic 3: Check palindrome by reversing into an array
    static boolean Is_Palindrome_Array(String Str) {
        char[] Org = Str.toCharArray(); // Original string as char array
        char[] Rev = new char[Org.length]; // Array to store reversed string

        for (int i = 0; i < Org.length; i++)
            Rev[i] = Str.charAt(Org.length - 1 - i); // Fill reversed array

        for (int i = 0; i < Org.length; i++)
            if (Org[i] != Rev[i]) // Compare original and reversed arrays
                return false; // Not a palindrome

        return true; // Original and reversed are the same
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String Str = sc.nextLine(); // Read input text

        // Display results from all three methods
        System.out.println("Logic 1: " + Is_Palindrome_Loop(Str));
        System.out.println("Logic 2: " + Is_Palindrome_Rec(Str, 0, Str.length() - 1));
        System.out.println("Logic 3: " + Is_Palindrome_Array(Str));
        sc.close(); // Close scanner
    }
}
