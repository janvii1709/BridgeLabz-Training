import java.util.Scanner;
public class IntegerSquareRoot {
    // Function to compute integer square root
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int left = 1, right = x, result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // To avoid overflow, compare mid <= x / mid instead of mid*mid <= x
            if (mid <= x / mid) {
                result = mid;  // mid*mid <= x, store result
                left = mid + 1;
            } else {
                right = mid - 1; // mid*mid > x
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a non-negative integer x: ");
        int x = sc.nextInt();
        if (x < 0) {
            System.out.println("Invalid input. x must be non-negative.");
            return;
        }

        int sqrt = mySqrt(x);
        System.out.println("The integer square root of " + x + " is: " + sqrt);
    }
}
