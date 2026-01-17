import java.util.*;
public class RotationPoint {
    public static int findRotationIndex(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                // minimum is in right half
                left = mid + 1;
            } else {
                // minimum is in left half or mid
                right = mid;
            }
        }
        // index of smallest element
        return left;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the rotated sorted array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int rotationIndex = findRotationIndex(arr);
        System.out.println("Rotation index: " + rotationIndex);
        System.out.println("Smallest element: " + arr[rotationIndex]);
    }
}
