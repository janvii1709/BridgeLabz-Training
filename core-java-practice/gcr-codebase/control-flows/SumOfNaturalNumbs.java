import java.util.Scanner;
public class SumOfNaturalNumbs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// Input from user
        int n = sc.nextInt();// Read a number
        // check if the number is a natural number and calculate the sum
        if (n > 0) {
            int s = n * (n + 1) / 2;   // formula for sum of first n natural numbers
            System.out.println("Sum of first " + n + " natural numbers is: " + s);
        } 
    }
}
