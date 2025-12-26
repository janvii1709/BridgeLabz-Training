import java.util.*;
public class NumberChecker2 {
    // Method to find count of digits
    public static int CountDigits(int Number) {
        int Count = 0;
        while (Number != 0) {
            Count++;
            Number /= 10;
        }
        return Count;
    }

    // Method to store digits in array
    public static int[] StoreDigits(int Number) {
        int Count = CountDigits(Number);
        int[] Digits = new int[Count];

        for (int i = Count - 1; i >= 0; i--) {
            Digits[i] = Number % 10;
            Number /= 10;
        }
        return Digits;
    }

    // Method to find sum of digits
    public static int SumOfDigits(int[] Digits) {
        int Sum = 0;
        for (int d : Digits) {
            Sum += d;
        }
        return Sum;
    }

    // Method to find sum of squares of digits
    public static int SumOfSquares(int[] Digits) {
        int Sum = 0;
        for (int d : Digits) {
            Sum += Math.pow(d, 2);
        }
        return Sum;
    }

    // Method to check Harshad number
    public static boolean IsHarshadNumber(int Number, int[] Digits) {
        int Sum = SumOfDigits(Digits);
        return Number % Sum == 0;
    }

    // Method to find frequency of digits
    public static int[][] DigitFrequency(int[] Digits) {
        int[][] Freq = new int[10][2];

        for (int i = 0; i < 10; i++) {
            Freq[i][0] = i;   // digit
            Freq[i][1] = 0;   // frequency
        }

        for (int d : Digits) {
            Freq[d][1]++;
        }
        return Freq;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int Number = sc.nextInt();

        int[] Digits = StoreDigits(Number);

        System.out.println("Count of digits: " + CountDigits(Number));
        System.out.println("Sum of digits: " + SumOfDigits(Digits));
        System.out.println("Sum of squares of digits: " + SumOfSquares(Digits));

        if (IsHarshadNumber(Number, Digits))
            System.out.println("It is a Harshad Number");
        else
            System.out.println("It is NOT a Harshad Number");

        System.out.println("Digit Frequency:");
        int[][] Frequency = DigitFrequency(Digits);
        for (int i = 0; i < Frequency.length; i++) {
            if (Frequency[i][1] > 0) {
                System.out.println("Digit " + Frequency[i][0] + " :  " + Frequency[i][1]);
            }
        }
    }
}
