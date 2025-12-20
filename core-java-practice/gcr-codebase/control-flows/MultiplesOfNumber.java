import java.util.*;
public class MultiplesOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number ");
        int number = sc.nextInt();// taking input from user as number
        // Checking if the number is positive and less than 100
        if(number > 0 && number < 100){
            for (int i = 100; i >= 1; i--) { // Looping backwards to print multiples in descending order
                if (i % number == 0) {
                    System.out.println(i); 
                }
            }
        }
    }
}