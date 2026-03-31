import java.util.Scanner;
public class FactorialRec {
    // Method to take input
    static int GetInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        return sc.nextInt();
    }
    // Recursive method to calculate factorial
    static int Factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;   // Base condition
        }
        return n * Factorial(n - 1); // Recursive call
    }
    // Method to display output
    static void DisplayResult(int num, int Output) {
        System.out.println("Factorial of " + num + " = " + Output);
    }

    public static void main(String[] args) {
        int number = GetInput();
        int Output = Factorial(number);
        DisplayResult(number, Output);
    }
}
