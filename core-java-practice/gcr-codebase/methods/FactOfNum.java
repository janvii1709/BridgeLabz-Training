import java.util.Scanner;
public class FactOfNum {
    // Method to find all factors of a number and return as array
    public static int[] FindFactors(int Number) {
        // First loop: count factors
        int Count = 0;
        for (int i = 1; i <= Number; i++) {
            if (Number % i == 0) {
                Count++;
            }
        }
        // Create array of required size
        int[] Factors = new int[Count];
        int Index = 0;

        // Second loop: store factors in array
        for (int i = 1; i <= Number; i++) {
            if (Number % i == 0) {
                Factors[Index++] = i;
            }
        }

        return Factors;
    }

    // Method to find the greatest factor
    public static int FindGreatestFactor(int[] Factors) {
        int Greatest = Factors[0];
        for (int factor : Factors) {
            if (factor > Greatest) {
                Greatest = factor;
            }
        }
        return Greatest;
    }

    // Method to find sum of factors
    public static int FindSumOfFactors(int[] Factors) {
        int Sum = 0;
        for (int factor : Factors) {
            Sum += factor;
        }
        return Sum;
    }

    // Method to find product of factors
    public static long FindProductOfFactors(int[] Factors) {
        long Product = 1;
        for (int factor : Factors) {
            Product *= factor;
        }
        return Product;
    }

    // Method to find product of cube of factors
    public static double FindProductOfCubes(int[] Factors) {
        double Product = 1;
        for (int factor : Factors) {
            Product *= Math.pow(factor, 3);
        }
        return Product;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int Number = sc.nextInt();

        int[] Factors = FindFactors(Number);

        System.out.print("Factors are: ");
        for (int factor : Factors) {
            System.out.print(factor + " ");
        }
        System.out.println();

        System.out.println("Greatest Factor: " + FindGreatestFactor(Factors));
        System.out.println("Sum of Factors: " + FindSumOfFactors(Factors));
        System.out.println("Product of Factors: " + FindProductOfFactors(Factors));
        System.out.println("Product of Cube of Factors: " + FindProductOfCubes(Factors));
    }
}
