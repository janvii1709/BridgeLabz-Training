import java.util.Scanner;
public class Gcd_Lcm {
    // Method to calculate GCD using Euclidean algorithm
    static int FindGCD(int a, int b) {
        while (b != 0) {
            int Remainder = a % b;
            a = b;
            b = Remainder;
        }
        return a;
    }
    // Method to calculate LCM using GCD
    static int FindLCM(int a, int b) {
        return (a * b) / FindGCD(a, b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        int Gcd = FindGCD(num1, num2);
        int Lcm = FindLCM(num1, num2);

        System.out.println("GCD = " + Gcd);
        System.out.println("LCM = " + Lcm);
    }
}
