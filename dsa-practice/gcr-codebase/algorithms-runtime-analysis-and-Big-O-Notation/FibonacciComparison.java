import java.util.Scanner;
public class FibonacciComparison {
    // Recursive Fibonacci (O(2^N))
    public static long fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    // Iterative Fibonacci (O(N))
    public static long fibonacciIterative(int n) {
        if (n <= 1) return n;
        long a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of N for Fibonacci: ");
        int n = sc.nextInt();

        // Recursive computation
        long start = System.nanoTime();
        long fibRec = fibonacciRecursive(n);
        long end = System.nanoTime();
        double recTime = (end - start) / 1_000_000.0;
        System.out.printf("Recursive Fibonacci of %d: %d (Time: %.5f ms)\n", n, fibRec, recTime);

        // Iterative computation
        start = System.nanoTime();
        long fibIter = fibonacciIterative(n);
        end = System.nanoTime();
        double iterTime = (end - start) / 1_000_000.0;
        System.out.printf("Iterative Fibonacci of %d: %d (Time: %.5f ms)\n", n, fibIter, iterTime);

        // Output of the comparison
        System.out.println("\nExpected Result:");
        System.out.println("Recursive approach is infeasible for large N due to exponential growth.");
        System.out.println("Iterative approach is significantly faster and memory-efficient.");
    }
}
