import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {

    // Method to find two sum indices
    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int remaining = target - nums[i];

            // Check if required number already exists
            if (map.containsKey(remaining)) {
                return new int[]{map.get(remaining), i};
            }

            // Store current number with index
            map.put(nums[i], i);
        }

        return new int[]{}; // no solution
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take array size
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Take array elements
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Take target value
        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        // Call twoSum method
        int[] result = twoSum(arr, target);

        // Print result
        if (result.length == 2) {
            System.out.println("Indices found: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No two elements found with given target sum.");
        }

        
    }
}
