import java.util.Scanner;
public class NumberChecker4 {

    // Method to check Prime number
    public static boolean IsPrime(int Number) {
        if (Number <= 1)
            return false;

        for (int i = 2; i <= Math.sqrt(Number); i++) {
            if (Number % i == 0)
                return false;
        }
        return true;
    }

    // Method to check Neon number
    public static boolean IsNeon(int Number) {
        int Square = Number * Number;
        int Sum = 0;
        while (Square > 0) {
            Sum += Square % 10;
            Square /= 10;
        }
        return Sum == Number;
    }

    // Method to check Spy number
    public static boolean IsSpy(int Number) {
        int Sum = 0, Product = 1;
        while (Number > 0) {
            int Digit = Number % 10;
            Sum += Digit;
            Product *= Digit;
            Number /= 10;
        }
        return Sum == Product;
    }

    // Method to check Automorphic number
    public static boolean IsAutomorphic(int Number) {
        int Square = Number * Number;
        int Temp = Number;

        while (Temp > 0) {
            if (Square % 10 != Temp % 10)
                return false;
            Square /= 10;
            Temp /= 10;
        }
        return true;
    }

    // Method to check Buzz number
    public static boolean IsBuzz(int Number) {
        return (Number % 7 == 0 || Number % 10 == 7);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int Number = sc.nextInt();

        System.out.println("Prime Number: " + IsPrime(Number));
        System.out.println("Neon Number: " + IsNeon(Number));
        System.out.println("Spy Number: " + IsSpy(Number));
        System.out.println("Automorphic Number: " + IsAutomorphic(Number));
        System.out.println("Buzz Number: " + IsBuzz(Number));
    }
}
