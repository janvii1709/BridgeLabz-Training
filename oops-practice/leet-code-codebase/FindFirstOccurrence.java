import java.util.Scanner;
public class FindFirstOccurrence {
    public static int findIndex(String haystack, String needle) {
        // If needle is longer than haystack, it cannot exist
        if (needle.length() > haystack.length()) {
            return -1;
        }
        // Traverse haystack
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // Get substring of same length as needle
            String Part = haystack.substring(i, i + needle.length());
            // Compare using equals()
            if (Part.equals(needle)) {
                return i;
            }
        }

        return -1; // not found
    }

    // MAIN METHOD
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter haystack string: ");
        String haystack = sc.nextLine();
        System.out.print("Enter needle string: ");
        String needle = sc.nextLine();

        int Res = findIndex(haystack, needle);

        System.out.println("Output: " + Res);
    }
}
