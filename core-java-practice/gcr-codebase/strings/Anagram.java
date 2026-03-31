
import java.util.*;


public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input two strings
        System.out.print("Enter the first string: ");
        String str1 = sc.nextLine().replaceAll("\\s", "").toLowerCase(); // Remove spaces and convert to lowercase

        System.out.print("Enter the second string: ");
        String str2 = sc.nextLine().replaceAll("\\s", "").toLowerCase(); // Remove spaces and convert to lowercase

        // Check if lengths are equal
        if (str1.length() != str2.length()) {
            System.out.println("The strings are not anagrams.");
            return;
        }

        // Convert strings to character arrays
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        // Sort the arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Compare sorted arrays
        if (Arrays.equals(arr1, arr2)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }
    }
}
