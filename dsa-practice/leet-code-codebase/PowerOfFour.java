import java.util.Scanner;

public class PowerOfFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        // Power of 4 must be positive
        if (n <= 0) {
            System.out.println(false);
            return;
        }

        // Divide by 4 while possible
        while (n % 4 == 0) {
            n = n / 4;
        }

        // If result becomes 1, it is power of 4
        if (n == 1) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
