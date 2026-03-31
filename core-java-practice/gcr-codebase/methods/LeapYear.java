import java.util.Scanner;
public class LeapYear {
    // Method to check if a year is a leap year
    public static boolean isLeapYear(int year) {
        // Leap year condition for Gregorian calendar (year >= 1582)
        if (year < 1582) {
            return false; // Invalid for Gregorian calendar
        }
        // Leap year logic:
        // Divisible by 4 and not divisible by 100, OR divisible by 400
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter a year (>=1582): ");
        int year = sc.nextInt();

        // Validate input
        if (year < 1582) {
            System.out.println("Year must be 1582 or later (Gregorian calendar).");
            return;
        }

        // Call method to check for leap year
        if (isLeapYear(year)) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is NOT a Leap Year.");
        }
    }
}
