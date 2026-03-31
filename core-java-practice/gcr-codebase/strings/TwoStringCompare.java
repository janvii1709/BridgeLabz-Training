import java.util.Scanner;
public class TwoStringCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input two strings
        System.out.print("Enter String 1: ");
        String Str1 = sc.nextLine();
        System.out.print("Enter String 2: ");
        String Str2 = sc.nextLine();
        int MinLength = Math.min(Str1.length(), Str2.length());
        boolean AreEqual = true;
        for (int i = 0; i < MinLength; i++) {
            char Ch1 = Str1.charAt(i);
            char Ch2 = Str2.charAt(i);
            if (Ch1 < Ch2) {
                System.out.println("\"" + Str1 + "\" comes before \"" + Str2 + "\" in lexicographical order.");
                AreEqual = false;
                break;
            } else if (Ch1 > Ch2) {
                System.out.println("\"" + Str1 + "\" comes after \"" + Str2 + "\" in lexicographical order.");
                AreEqual = false;
                break;
            }
        }

        // If all characters so far are equal, compare lengths
        if (AreEqual) {
            if (Str1.length() < Str2.length()) {
                System.out.println("\"" + Str1 + "\" comes before \"" + Str2 + "\" in lexicographical order.");
            } else if (Str1.length() > Str2.length()) {
                System.out.println("\"" + Str1 + "\" comes after \"" + Str2 + "\" in lexicographical order.");
            } else {
                System.out.println("Both strings are equal.");
            }
        }
    }
}
