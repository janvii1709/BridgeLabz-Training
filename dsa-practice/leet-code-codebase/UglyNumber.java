import java.util.*;
public class UglyNumber {
    public static boolean isUgly(int n) {
        if (n <= 0) return false; // Ugly numbers are positive

        int[] primes = {2, 3, 5};
        for (int prime : primes) {
            while (n % prime == 0) {
                n /= prime; // divide n by 2, 3, or 5 as long as possible
            }
        }

        return n == 1; // If remaining number is 1, it's ugly
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();

        boolean result = isUgly(n);
        System.out.println(result);
    }
}
