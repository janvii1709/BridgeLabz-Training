import java.util.*;
public class FactorialUsingFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // input a number from user
        // check if the number is positive integer
        if (n <= 0 ){
            System.out.println("Please enter a valid positive integer ( greater than 0)");
        }
        else {
            // factorial using for loop
            long fact = 1;
            for (int i = 1; i <= n; i++){
                fact *= i;

            }
            System.out.println("Factorial using for loop is : " + fact); // print factorial using for loop
        }
    }
    
}
