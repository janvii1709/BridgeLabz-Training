import java.util.*;
public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        // List of numbers to get elements from
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        // Convert k to 0-based index
        k--;

        StringBuilder result = new StringBuilder();

        for (int i = n; i >= 1; i--) {
            int index = k / factorial[i - 1];
            result.append(numbers.get(index));
            numbers.remove(index);
            k = k % factorial[i - 1];
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n (1 <= n <= 9): ");
        int n = sc.nextInt();
        System.out.print("Enter k (1 <= k <= n!): ");
        int k = sc.nextInt();

        // Validating the input
        if (n < 1 || n > 9) {
            System.out.println("Invalid n. Must be between 1 and 9.");
            return;
        }

        int fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;
        if (k < 1 || k > fact) {
            System.out.println("Invalid k. Must be between 1 and " + fact);
            return;
        }
        // Get kth permutation
        String permutation = getPermutation(n, k);
        System.out.println("The " + k + "th permutation sequence is: " + permutation);
    }
}
