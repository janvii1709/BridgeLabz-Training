import java.util.Scanner;

public class PowerOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        // Negative numbers and 0 are not powers of 3
        if (n <= 0) {
            System.out.println(false);
            return;
        }

        // Divide by 3 until possible
        while (n % 3 == 0) {
            n = n / 3;
        }

        // If we reach 1, it is a power of 3
        if (n == 1) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
