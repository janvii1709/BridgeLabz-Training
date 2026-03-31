import java.util.*;
public class FizzBuzzFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// input a number from user
        if (n <= 0) { // loop to check if the number is positive or not
            System.out.println("Enter a positive integer.");
        } else {
            for (int i = 1; i <= n; i++) { 
                if (i % 3 == 0 && i % 5 == 0) {// loop to check divisibility of number with both 3 and 5
                    System.out.println("FizzBuzz");
                } else if (i % 3 == 0) {// loop to check divisibility of number with 3 
                    System.out.println("Fizz");
                } else if (i % 5 == 0) {// loop to check divisibility of number with 5
                    System.out.println("Buzz");
                } else {
                    System.out.println(i);
                }
            }
        }
    }
}

