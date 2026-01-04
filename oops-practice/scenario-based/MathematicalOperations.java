import java.math.BigInteger;
import java.util.Scanner; // Needed for calculating large factorials 
// This class contains utility methods for mathematical operations
class MathUtility {
    // Method to calculate factorial of a number using BigInteger
    static BigInteger factorial(int n) {
        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return BigInteger.valueOf(-1); // Return -1 for invalid input
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i)); // Multiply numbers from 2 to n
        }
        return result;
    }
    // Method to check if a number is prime
    static boolean isPrime(int n) {
        if (n <= 1) {
            return false; // 0 and 1 are not prime
        }
        for (int i = 2; i <= Math.sqrt(n); i++) { // Only check up to sqrt(n)
            if (n % i == 0) {
                return false; // Divisible by a number other than 1 and itself
            }
        }
        return true;
    }
    // Method to find GCD (Greatest Common Divisor) of two numbers
    static int gcd(int a, int b) {
        if (a == 0) return Math.abs(b); // GCD(0, b) = b
        if (b == 0) return Math.abs(a); // GCD(a, 0) = a
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    // Method to find the nth Fibonacci number
    static long fibonacci(int n) {
        if (n < 0) {
            System.out.println("Fibonacci number is not defined for negative numbers.");
            return -1;
        }
        if (n == 0) return 0;
        if (n == 1) return 1;
        long a = 0, b = 1;
        long fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = a + b; // Sum of previous two numbers
            a = b;
            b = fib;
        }
        return fib;
    }
}
// Class to test MathUtility methods
public class MathematicalOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Test factorial
        System.out.print("Enter a number for factorial: ");
        int numFact = sc.nextInt();
        System.out.println("Factorial of " + numFact + " is: " + MathUtility.factorial(numFact));
        // Test prime
        System.out.print("Enter a number to check prime: ");
        int numPrime = sc.nextInt();
        if (MathUtility.isPrime(numPrime)) {
            System.out.println(numPrime + " is a prime number.");
        } else {
            System.out.println(numPrime + " is not a prime number.");
        }
        // Test GCD
        System.out.print("Enter first number for GCD: ");
        int a = sc.nextInt();
        System.out.print("Enter second number for GCD: ");
        int b = sc.nextInt();
        System.out.println("GCD of " + a + " and " + b + " is: " + MathUtility.gcd(a, b));
        // Test Fibonacci
        System.out.print("Enter n for nth Fibonacci number: ");
        int n = sc.nextInt();
        System.out.println("The " + n + "th Fibonacci number is: " + MathUtility.fibonacci(n));
    }
}

