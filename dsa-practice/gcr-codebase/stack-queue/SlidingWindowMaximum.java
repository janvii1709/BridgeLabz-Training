import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//Sliding Window Maximum using Deque
public class SlidingWindowMaximum {

    // Function to find max in each window
    public static void findSlidingWindowMax(int[] arr, int k) {

        Deque<Integer> deque = new LinkedList<>();
        int n = arr.length;

        // Process first k elements
        for (int i = 0; i < k; i++) {

            // Remove smaller elements from back
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.removeLast();
            }

            deque.addLast(i);
        }

        // Process remaining elements
        for (int i = k; i < n; i++) {

            // Front of deque is max of previous window
            System.out.print(arr[deque.peek()] + " ");

            // Remove indices out of current window
            while (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.removeFirst();
            }

            // Remove smaller elements from back
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.removeLast();
            }

            deque.addLast(i);
        }

        // Print max of last window
        System.out.print(arr[deque.peek()]);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter window size (k): ");
        int k = sc.nextInt();

        if (k > n || k <= 0) {
            System.out.println("Invalid window size!");
            return;
        }

        System.out.println("\nSliding Window Maximum:");
        findSlidingWindowMax(arr, k);

    }
}
