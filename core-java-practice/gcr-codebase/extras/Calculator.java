import java.util.Scanner;
public class Calculator {
    // Method for Addition
    static double Add(double a, double b) {
        return a + b;
    }
    // Method for Subtraction
    static double Subtract(double a, double b) {
        return a - b;
    }
    // Method for Multiplication
    static double Multiply(double a, double b) {
        return a * b;
    }
    // Method for Division
    static double Divide(double a, double b) {
        if (b == 0) {
            System.out.println("Division by zero is not allowed.");
            return 0;
        }
        return a / b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter your choice: ");
        int Choice = sc.nextInt();
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();
        switch (Choice) {
            case 1:
                System.out.println("Output = " + Add(num1, num2));
                break;
            case 2:
                System.out.println("Output = " + Subtract(num1, num2));
                break;
            case 3:
                System.out.println("Output = " + Multiply(num1, num2));
                break;
            case 4:
                System.out.println("Output = " + Divide(num1, num2));
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
