import java.util.*;
public class StoreTheDigitArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking number input from the user
        System.out.print("Enter a number: ");
        int Num = sc.nextInt();
        // Maximum digits allowed to store
        int Max_Digit = 10;
        // Array to store digits of the number
        int[] Digits = new int[Max_Digit];
        // Index variable to track array position
        int INDEX = 0;
        // Converting number to positive to handle negative inputs
        Num = Math.abs(Num);
        // Extracting digits from the number and storing them in the array
        while (Num != 0) {
            // Stop storing digits if array size limit is reached
            if (INDEX == Max_Digit) {
                break;
            }
            // Store last digit of the number in array
            Digits[INDEX] = Num % 10;
            // Remove last digit from the number
            Num = Num / 10;
            // Move to next index
            INDEX++;
        }
        // Variables to store largest and second largest digits
        int Largest = 0;
        int Second_Largest = 0;
        // Loop only through stored digits
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
