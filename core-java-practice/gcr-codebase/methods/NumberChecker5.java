import java.util.*;
public class NumberChecker5 {
    // Method to check Perfect Number
    public static boolean IsPerfectNumber(int Number) {
        int Sum = 0;
        for (int i = 1; i <= Number / 2; i++) {
            if (Number % i == 0) {
                Sum += i;
            }
        }
        return Sum == Number;
    }

    // Method to check Abundant Number
    public static boolean IsAbundantNumber(int Number) {
        int Sum = 0;
        for (int i = 1; i <= Number / 2; i++) {
            if (Number % i == 0) {
                Sum += i;
            }
        }
        return Sum > Number;
    }

    // Method to check Deficient Number
    public static boolean IsDeficientNumber(int Number) {
        int Sum = 0;
        for (int i = 1; i <= Number / 2; i++) {
            if (Number % i == 0) {
                Sum += i;
            }
        }
        return Sum < Number;
    }

    // Method to calculate factorial
    public static int Factorial(int Digit) {
        int Fact = 1;
        for (int i = 1; i <= Digit; i++) {
            Fact *= i;
        }
        return Fact;
    }

    // Method to check Strong Number
    public static boolean IsStrongNumber(int Number) {
        int Temp = Number;
        int Sum = 0;

        while (Temp > 0) {
            int Digit = Temp % 10;
            Sum += Factorial(Digit);
            Temp /= 10;
        }
        return Sum == Number;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int Number = sc.nextInt();

        System.out.println("Perfect Number: " + IsPerfectNumber(Number));
        System.out.println("Abundant Number: " + IsAbundantNumber(Number));
        System.out.println("Deficient Number: " + IsDeficientNumber(Number));
        System.out.println("Strong Number: " + IsStrongNumber(Number));
    }
}
