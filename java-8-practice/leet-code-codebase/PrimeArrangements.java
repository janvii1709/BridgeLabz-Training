import java.util.Scanner;
public class PrimeArrangements {
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int n = sc.nextInt();
        int primeCount = countPrimes(n);
        int nonPrimeCount = n - primeCount;
        long result = (factorial(primeCount) * factorial(nonPrimeCount)) % MOD;
        System.out.println("The output is : ");
        System.out.println(result);
    }
    // Count primes from 1 to n using Sieve
    private static int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] isNotPrime = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i]) {
                count++;
                for (int j = i * 2; j <= n; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
        return count;
    }
    // Factorial with modulo
    private static long factorial(int x) {
        long res = 1;
        for (int i = 1; i <= x; i++) {
            res = (res * i) % MOD;
        }
        return res;
    }
}
