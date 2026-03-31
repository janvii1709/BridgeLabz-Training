import java.util.*;
public class FactorialUsingWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // input a number from user
        // check if the number is positive integer
        if (n <= 0 ){
            System.out.println("Please enter a valid positive integer ( greater than 0)");
        }
        else {
    
            // factorial using while loop
            long fact = 1;
            int i = 1; // initialize counter variable
            while (i <=n){
                fact *= i;
                i++;
            }
            System.out.println("Factorial using while loop is : " + fact); // print factorial using while loop
}
    }
}


    