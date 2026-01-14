import java.util.HashMap;
import java.util.Scanner;

public class LongestConsecutiveSequence {

    // Method to find longest consecutive sequence
    public static int longestConsecutive(int[] nums) {

        HashMap<Integer, Boolean> map = new HashMap<>();

        // Step 1: Store all elements as unvisited
        for (int num : nums) {
            map.put(num, false);
        }

        int longest = 0;

        // Step 2: Find consecutive sequences
        for (int num : nums) {

            // Skip if already visited
            if (map.get(num)) {
                continue;
            }

            map.put(num, true);
            int currentLength = 1;

            // Check left side
            int left = num - 1;
            while (map.containsKey(left) && !map.get(left)) {
                map.put(left, true);
                currentLength++;
                left--;
            }

            // Check right side
            int right = num + 1;
            while (map.containsKey(right) && !map.get(right)) {
                map.put(right, true);
                currentLength++;
                right++;
            }

            longest = Math.max(longest, currentLength);
        }

        return longest;
    }

    // Main method with user input
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = longestConsecutive(arr);

        System.out.println("Length of Longest Consecutive Sequence: " + result);

    }
}
