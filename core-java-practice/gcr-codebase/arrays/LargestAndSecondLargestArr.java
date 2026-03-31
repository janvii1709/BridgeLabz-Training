import java.util.*;
public class LargestAndSecondLargestArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking number input from the user
        System.out.print("Enter a number: ");
        int Numb = sc.nextInt();
        // Convert number to positive to handle negative input
        Numb = Math.abs(Numb);
        // Initial size of the array
        int Max_Digit = 10;
        // Array to store digits
        int[] Digits = new int[Max_Digit];
        // Index to track how many digits are stored
        int INDEX = 0;
        // Extract digits and store them in the array
        while (Numb != 0) {
            // If array is full, increase its size by 10
            if (INDEX == Max_Digit) {
                Max_Digit = Max_Digit + 10;
                // Create a temporary array with increased size
                int[] Temp = new int[Max_Digit];
                // Copy old digits into the new array
                for (int i = 0; i < Digits.length; i++) {
                    Temp[i] = Digits[i];
                }
                // Assign new array to digits reference
                Digits = Temp;
            }
            // Store the last digit of the number
            Digits[INDEX] = Numb % 10;
            // Remove last digit from the number
            Numb = Numb / 10;
            // Move to next index
            INDEX++;
        }

        // Variables to store largest and second largest digits
        int Largest = 0;
        int Second_Largest = 0;
        // Find largest and second largest from stored digits
        for (int i = 0; i < INDEX; i++) {
            if (Digits[i] > Largest) {
                Second_Largest = Largest;
                Largest = Digits[i];
            }
            else if (Digits[i] > Second_Largest && Digits[i] != Largest) {
                Second_Largest = Digits[i];
            }
        }
        System.out.println("Largest Digit: " + Largest);
        System.out.println("Second Largest Digit: " + Second_Largest);

    }
    
}
