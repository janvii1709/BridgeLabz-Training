import java.util.Scanner;
public class PowerOfTwo {
    public static boolean isPowerOfTwoBit(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
    public static boolean isPowerOfTwoLoop(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();

        boolean result = isPowerOfTwoBit(n);
        System.out.println(result);
    }
}
