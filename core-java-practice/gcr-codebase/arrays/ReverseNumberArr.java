import java.util.*;
public class ReverseNumberArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take input from the user
        System.out.print("Enter a number: ");
        int Number = sc.nextInt();
        // Special case: if number is 0
        if (Number == 0) {
            System.out.println("Reversed Number: 0");
            return;
        }
        // Store absolute value to handle negative numbers
        int Temp = Math.abs(Number);
        // count number of digits
        int Digit_Count = 0;

        while (Temp != 0) {
            Temp = Temp / 10;
            Digit_Count++;
        }
        // store digits in array
        int[] Digits = new int[Digit_Count];
        Temp = Math.abs(Number);
        // Digits are stored in reverse order automatically
        for (int i = 0; i < Digit_Count; i++) {
            Digits[i] = Temp % 10;   // Extract last digit
            Temp = Temp / 10;        // Remove last digit
        }
        //displays reversed array
        System.out.print("Reversed Number: ");
        // Print minus sign if original number was negative
        if (Number < 0) {
            System.out.print("-");
        }
        // Print digits array (already reversed)
        for (int i = 0; i < Digit_Count; i++) {
            System.out.print(Digits[i]);
        }
    }
}
