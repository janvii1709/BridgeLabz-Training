import java.util.Scanner;
public class PrimeChecker {

    // Method to check if a number is prime
    static boolean IsPrime(int Num) {
        if (Num <= 1) {
            return false;
        }
        for (int i = 2; i <= Num / 2; i++) {
            if (Num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int Number = sc.nextInt();
        if (IsPrime(Number)) {
            System.out.println(Number + " is a Prime Number");
        } else {
            System.out.println(Number + " is NOT a Prime Number");
        }
    }
}
