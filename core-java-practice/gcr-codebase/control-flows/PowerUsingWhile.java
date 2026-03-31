import java.util.*;
public class PowerUsingWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number ");
        int number = sc.nextInt();// taking input from user as number
        System.out.print("Enter the power ");
        int power = sc.nextInt();//taking input as power from user
        int ResulT = 1;//initializing result as 1
        // Checking if the power is positive
        if(power > 0){
            int Counter = 0;
            // Looping to calculate power
            while(Counter < power){
                ResulT *= number; // Multiplying number for power
                Counter++; // Incrementing counter for next iteration
            }
            System.out.println("Number " + number + " raised to the power of " + power + " is " + ResulT);
        } else {
            System.out.println("Power should be a positive number"); // If power is not positive number then this else block will execute
        }
    }
}