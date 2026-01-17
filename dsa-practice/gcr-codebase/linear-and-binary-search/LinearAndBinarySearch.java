import java.util.*;
public class LinearAndBinarySearch {
    // Linear Search For The First Missing Positive Integer
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n + 1];
        // Mark the visited positive numbers
        for (int num : nums) {
            if (num > 0 && num <= n) {
                visited[num] = true;
            }
        }
        // Find the first missing positive
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                return i;
            }
        }
        return n + 1;
    }
    // Binary Search For Finding The index of target
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter target element: ");
        int target = sc.nextInt();
        int missing = firstMissingPositive(arr);
        System.out.println("First Missing Positive Integer: " + missing);
        Arrays.sort(arr);
        int index = binarySearch(arr, target);
        System.out.println("Index of target " + target + ": " + index);
    }
}