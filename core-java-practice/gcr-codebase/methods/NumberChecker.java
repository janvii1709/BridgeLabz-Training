import java.util.Scanner;

public class NumberChecker {

    // Method to count how many digits are in the number
    public static int CountDigits(int Number) {
        int Count = 0;
        int temp = Number;

        if (temp == 0) return 1; // Special case: 0 has 1 digit

        while (temp != 0) {
            Count++;        // Increase count for each digit
            temp /= 10;     // Remove the last digit
        }

        return Count; // Return total number of digits
    }

    // Method to store each digit of the number in an array
    public static int[] StoreDigits(int Number) {
        int Count = CountDigits(Number);    // Get total digits
        int[] Digits = new int[Count];      // Create array to store digits
        int temp = Number;

        // Extract digits from right to left
        for (int i = Count - 1; i >= 0; i--) {
            Digits[i] = temp % 10;  // Store last digit in array
            temp /= 10;             // Remove last digit
        }

        return Digits; // Return array of digits
    }

    // Method to check if the number is a Duck Number
    // Duck Number: a number with at least one 0, not at the first digit
    public static boolean DuckNumber(int[] Digits) {
        for (int i = 1; i < Digits.length; i++) { // Start from second digit
            if (Digits[i] == 0) return true;     // Found a zero, it's a Duck Number
        }
        return false; // No zero found after first digit
    }

    // Method to check if the number is an Armstrong Number
    // Armstrong Number: sum of digits raised to power of total digits equals the number
    public static boolean ArmstrongNumber(int Number, int[] Digits) {
        int Sum = 0;
        int Power = Digits.length;

        for (int digit : Digits) {
            Sum += Math.pow(digit, Power); // Raise each digit to power and add
        }

        return Sum == Number; // True if sum equals original number
    }

    // Method to find largest and second largest digits in the number
    public static void FindLargestAndSecondLargest(int[] digits) {
        int Largest = Integer.MIN_VALUE;       // Start with smallest possible integer
        int SecondLargest = Integer.MIN_VALUE; // To find second largest

        for (int digit : digits) {
            if (digit > Largest) {             // Found a new largest
                SecondLargest = Largest;       // Previous largest becomes second largest
                Largest = digit;               // Update largest
            } else if (digit > SecondLargest && digit != Largest) {
                SecondLargest = digit;         // Update second largest if distinct
            }
        }

        System.out.println("Largest digit: " + Largest);
        if (SecondLargest == Integer.MIN_VALUE) {
            System.out.println("Second Largest digit: N/A"); // No distinct second largest
        } else {
            System.out.println("Second Largest digit: " + SecondLargest);
        }
    }

    // Method to find smallest and second smallest digits in the number
    public static void FindSmallestAndSecondSmallest(int[] Digits) {
        int Smallest = Integer.MAX_VALUE;       // Start with largest possible integer
        int SecondSmallest = Integer.MAX_VALUE; // To find second smallest

        for (int digit : Digits) {
            if (digit < Smallest) {             // Found a new smallest
                SecondSmallest = Smallest;      // Previous smallest becomes second smallest
                Smallest = digit;               // Update smallest
            } else if (digit < SecondSmallest && digit != Smallest) {
                SecondSmallest = digit;         // Update second smallest if distinct
            }
        }

        System.out.println("Smallest digit: " + Smallest);
        if (SecondSmallest == Integer.MAX_VALUE) {
            System.out.println("Second Smallest digit: N/A"); // No distinct second smallest
        } else {
            System.out.println("Second Smallest digit: " + SecondSmallest);
        }
    }

    // Main method: entry point of the program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int Number = sc.nextInt();              // Take input from user

        int[] Digits = StoreDigits(Number);    // Store digits in array

        // Display results
        System.out.println("Total Digits: " + CountDigits(Number));
        System.out.println("Is Duck Number: " + DuckNumber(Digits));
        System.out.println("Is Armstrong Number: " + ArmstrongNumber(Number, Digits));

        FindLargestAndSecondLargest(Digits);   // Print largest and second largest
        FindSmallestAndSecondSmallest(Digits); // Print smallest and second smallest
    }
}
