import java.util.Scanner;
public class NextGreatestLetter {
    public static char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return letters[low % letters.length];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();
        char[] letters = new char[n];
        System.out.println("Enter characters (space separated):");
        for (int i = 0; i < n; i++) {
            letters[i] = sc.next().charAt(0);
        }
        System.out.print("Enter target character: ");
        char target = sc.next().charAt(0);
        char result = nextGreatestLetter(letters, target);
        System.out.println("Next greatest letter is: " + result);
    }
}
