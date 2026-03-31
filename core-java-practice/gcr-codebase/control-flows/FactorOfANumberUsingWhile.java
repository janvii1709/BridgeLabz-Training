import java.util.*;
public class FactorOfANumberUsingWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();// Taking number input
        if (number <= 0) { // // Check if number is positive
            System.out.println("Enter a positive integer.");
        } else {
            int count = 1;// Count variable starting from 1
            System.out.println("Factors of " + number + " are:");
            while (count < number) {// Loop runs till count is less than number
                if (number % count == 0) {// Check if count divides number completely
                    System.out.println(count);
                }
                count++;// Increment count
            }
        }
    }
}
