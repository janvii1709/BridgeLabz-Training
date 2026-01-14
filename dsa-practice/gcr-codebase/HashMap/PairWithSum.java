import java.util.HashMap;
import java.util.Scanner;

public class PairWithSum {

    // Method to check if pair exists
    public static boolean hasPairWithSum(int[] arr, int target) {

        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int num : arr) {

            int required = target - num;

            // Check if required number already exists
            if (map.containsKey(required)) {
                return true;
            }

            // Store current number as visited
            map.put(num, true);
        }

        return false;
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

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        boolean result = hasPairWithSum(arr, target);

        if (result) {
            System.out.println("Pair with given sum exists.");
        } else {
            System.out.println("No pair found with given sum.");
        }
    }
}
