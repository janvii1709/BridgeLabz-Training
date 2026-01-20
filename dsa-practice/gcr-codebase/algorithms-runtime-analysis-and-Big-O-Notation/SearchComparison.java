import java.util.Arrays;
import java.util.Scanner;
public class SearchComparison {
    // Linear Search (O(N))
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1; // Not found
    }
    // Binary Search (O(log N))
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1; // Not found
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking user input for dataset size
        System.out.print("Enter dataset size (N): ");
        int n = sc.nextInt();

        // Creating a dataset (0 to N-1)
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = i;
        }

        // Target to search (last element to simulate worst-case for linear search)
        int target = n - 1;

        //Linear Search
        long start = System.nanoTime();
        int linearIndex = linearSearch(data, target);
        long end = System.nanoTime();
        double linearTime = (end - start) / 1_000_000.0;
        System.out.printf("Linear Search: Index=%d, Time=%.5f ms\n", linearIndex, linearTime);

        // Binary Search
        // Data is already sorted, so we can directly use binary search
        start = System.nanoTime();
        int binaryIndex = binarySearch(data, target);
        end = System.nanoTime();
        double binaryTime = (end - start) / 1_000_000.0;
        System.out.printf("Binary Search: Index=%d, Time=%.5f ms\n", binaryIndex, binaryTime);

        // Comparison result
        System.out.println("\nExpected Result:");
        System.out.println("Binary Search performs much better for large datasets, provided the data is sorted.");
        System.out.println("Linear Search is simple but slower for large datasets.");
    }
}
