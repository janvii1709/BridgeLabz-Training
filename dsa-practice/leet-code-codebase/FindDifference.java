import java.util.Scanner;

public class FindDifference {

    public static char findTheDifference(String s, String t) {
        char result = 0;

        // XOR all characters of s
        for (int i = 0; i < s.length(); i++) {
            result ^= s.charAt(i);
        }

        // XOR all characters of t
        for (int i = 0; i < t.length(); i++) {
            result ^= t.charAt(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string s: ");
        String s = sc.nextLine();

        System.out.print("Enter string t: ");
        String t = sc.nextLine();

        char addedChar = findTheDifference(s, t);
        System.out.println("Output: " + addedChar);
    }
}
