import java.util.Scanner;

public class GreatestFactorUsingFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// Taking number input
        int gf = 1;// Variable to store greatest factor
        for (int i = n - 1; i >= 1; i--) {// Loop from numbered -1 till 1
            // Check divisibility now
            if (n % i == 0) { 
                gf = i;
                break; // Stop loop after first largest factor
            }
        }
        System.out.println("Greatest factor besides itself is: " + gf);
    }
}
