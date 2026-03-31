import java.util.Scanner;
public class Factors {

    // Method to find factors of a number and return as an array
    public static int[] findFactors(int number) {
        // First loop to count the number of factors
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        // Initialize array with exact size
        int[] factors = new int[count];
        int index = 0;

        // Second loop to store factors in array
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }

        return factors;
    }

    // Method to calculate sum of elements in array
    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    // Method to calculate product of elements in array
    public static long productOfFactors(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    // Method to calculate sum of squares of elements in array
    public static int sumOfSquares(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += Math.pow(factor, 2); // Using Math.pow()
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Find factors
        int[] factors = findFactors(number);

        // Display factors
        System.out.print("Factors of " + number + " are: ");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        System.out.println();

        // Calculate and display sum of factors
        System.out.println("Sum of factors: " + sumOfFactors(factors));

        // Calculate and display product of factors
        System.out.println("Product of factors: " + productOfFactors(factors));

        // Calculate and display sum of squares of factors
        System.out.println("Sum of squares of factors: " + sumOfSquares(factors));
    }
}
