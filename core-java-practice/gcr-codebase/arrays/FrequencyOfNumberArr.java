import java.util.*;
public class FrequencyOfNumberArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long Numb = sc.nextLong(); // Use long to handle large numbers
        // counting the digits
        long Temp = Numb;
        int COUNT_DIGITS = 0;
        while (Temp != 0) {
            Temp /= 10; // Remove last digit
            COUNT_DIGITS++;
        }
        // storing digits in the array
        int[] Digits = new int[COUNT_DIGITS]; // Array to store each digit
        Temp = Numb;
        for (int i = COUNT_DIGITS - 1; i >= 0; i--) {
            Digits[i] = (int)(Temp % 10); // Extract last digit
            Temp /= 10;
        }
        // calculating the frequency
        int[] Freq = new int[10]; // Array for frequency of digits from 0-9
        for (int i = 0; i < COUNT_DIGITS; i++) {
            Freq[Digits[i]]++; // Increasing frequency of the digits
        }
        // frequency of each digit in the number is displayed
        for (int i = 0; i < 10; i++) {
            if (Freq[i] > 0) {
                System.out.println("Digit " + i + " occurs " + Freq[i] + " time(s)");
            }
        }

    }
}


