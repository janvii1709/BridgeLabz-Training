import java.util.*;
public class NumberChecking {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in); // input from user
         int n = sc.nextInt(); // read a number
         // checking if a number is positive,negative,zero
         if ( n > 0) {
             System.out.println("Positive");
         } else if (n < 0) {
             System.out.println("Negative");
         } else {
             System.out.println("Zero");
         }

    }
   

}
