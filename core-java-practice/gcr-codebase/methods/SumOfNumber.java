import java.util.Scanner;
public class SumOfNumber {
    // Recursive method to calculate sum of n natural numbers
    public static int SumRecursion(int n) {
        if (n == 1) {
            return 1; // Base case: sum of 1 is 1
        }
        return n + SumRecursion(n - 1); // Recursive call
    }

    // Method to calculate sum using formula n*(n+1)/2
    public static int SumFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        // Validate input is a natural number
        if (n <= 0) {
            System.out.println("Please enter a natural number greater than 0.");
            return;
        }

        // Calculate sum using recursion
        int SumRec = SumRecursion(n);

        // Calculate sum using formula
        int SumForm = SumFormula(n);

        // Display results
        System.out.println("Sum of first " + n + " natural numbers (Recursion): " + SumRec);
        System.out.println("Sum of first " + n + " natural numbers (Formula): " + SumForm);

        // Compare results
        if (SumRec == SumForm) {
            System.out.println("Both methods give the same correct result!");
        } else {
            System.out.println("There is a mismatch in the results!");
        }
    }
}
