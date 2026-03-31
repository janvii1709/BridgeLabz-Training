import java.util.Scanner;
public class GreatestFactorUsingWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();// Input number from user
        int gf = 1; // Initial greatest factor
        int counter = number - 1;// Counter starts from number-1
        // Loop until counter becomes 1
        while (counter >= 1) {
            // Check divisibility
            if (number % counter == 0) {
                gf = counter;
                break;
            }
            // Decrease counter
            counter--;
        }
        System.out.println("Greatest factor besides itself is: " + gf);
    }
}
