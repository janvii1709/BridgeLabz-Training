import java.util.*;
public class MultipleOfNumberUsingWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number ");
        int number = sc.nextInt();// taking input from user as number
        // Checking if the number is positive and less than 100
        if(number > 0 && number < 100){
            int Counter = number - 1;
            while(Counter > 1) { // Looping backwards to print multiples in descending order
                if(number % Counter == 0) {
                    System.out.println(Counter); // Printing the multiples except 1
                }
                Counter--; // Decrementing counter for next iteration
            }
        } else {
            System.out.println("Number should be positive and less than 100");
        }
    }
}