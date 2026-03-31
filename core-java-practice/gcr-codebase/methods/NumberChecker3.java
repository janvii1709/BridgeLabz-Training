import java.util.*;

public class NumberChecker3 {

    // Method to count the number of digits in a number
    public static int CountDigits(int Number) {
        if (Number == 0) return 1; // Special case: 0 has 1 digit

        int Count = 0;
        while (Number != 0) {
            Count++;
            Number /= 10; // Remove last digit
        }
        return Count;
    }

    // Method to store each digit of the number in an array
    public static int[] StoreDigits(int Number) {
        int Count = CountDigits(Number);
        int[] Digits = new int[Count];
        for (int i = Count - 1; i >= 0; i--) {
            Digits[i] = Number % 10;
            Number /= 10;
        }
        return Digits;
    }

    // Method to reverse an array of digits
    public static int[] ReverseArray(int[] Digits) {
        int[] Reverse = new int[Digits.length];
        for (int i = 0; i < Digits.length; i++) {
            Reverse[i] = Digits[Digits.length - 1 - i];
        }
        return Reverse;
    }

    // Method to compare two arrays
    public static boolean CompareArrays(int[] Arr1, int[] Arr2) {
        if (Arr1.length != Arr2.length) return false;
        for (int i = 0; i < Arr1.length; i++) {
            if (Arr1[i] != Arr2[i]) return false;
        }
        return true;
    }

    // Method to check if a number is a palindrome
    public static boolean IsPalindrome(int Number) {
        int[] Digits = StoreDigits(Number);
        int[] Reverse = ReverseArray(Digits);
        return CompareArrays(Digits, Reverse);
    }

    // Method to check if a number is a Duck Number
    // Duck Number: number has at least one zero NOT in the first digit
    public static boolean IsDuckNumber(int[] Digits) {
        for (int i = 1; i < Digits.length; i++) { // Start from second digit
            if (Digits[i] == 0) return true;
        }
        return false;
    }

    // Main method: program execution starts here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int Number = sc.nextInt();

        int[] Digits = StoreDigits(Number);
        int[] ReverseDigits = ReverseArray(Digits);

        System.out.println("Count of digits: " + CountDigits(Number));
        System.out.println("Is Palindrome: " + IsPalindrome(Number));
        System.out.println("Is Duck Number: " + IsDuckNumber(Digits));

        System.out.print("Original Digits: ");
        for (int d : Digits) System.out.print(d + " ");

        System.out.print("\nReversed Digits: ");
        for (int d : ReverseDigits) System.out.print(d + " ");
    }
}
