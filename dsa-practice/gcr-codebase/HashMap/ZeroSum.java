import java.util.*;

public class ZeroSum {

    // Method to find all zero-sum subarrays
    public static void findZeroSumSubarrays(int[] arr) {

        // Map to store prefix sum and list of indices
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        int sum = 0;

        // For sum = 0 at index -1 (important case)
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        boolean found = false;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            // If same sum exists, zero-sum subarray found
            if (map.containsKey(sum)) {

                for (int startIndex : map.get(sum)) {
                    System.out.println("Zero-sum subarray found from index "
                            + (startIndex + 1) + " to " + i);
                    found = true;
                }
            }

            // Store index for current sum
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        if (!found) {
            System.out.println("No zero-sum subarrays found.");
        }
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

        findZeroSumSubarrays(arr);

    }
}
