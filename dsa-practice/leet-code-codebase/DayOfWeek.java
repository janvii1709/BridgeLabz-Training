import java.util.Scanner;
public class DayOfWeek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take user input
        System.out.print("Enter day: ");
        int day = sc.nextInt();
        System.out.print("Enter month: ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        // Days of the week (Jan 1, 1971 = Friday)
        String[] week = {"Friday", "Saturday", "Sunday","Monday", "Tuesday", "Wednesday", "Thursday"};
        // Days in months
        int[] daysInMonth = {31, 28, 31, 30, 31, 30,31, 31, 30, 31, 30, 31};
        int totalDays = 0;
        // Count days for years
        for (int y = 1971; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }
        // Adjust February for leap year
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }
        // Count days for months
        for (int m = 0; m < month - 1; m++) {
            totalDays += daysInMonth[m];
        }
        // Add days
        totalDays += day - 1;
        // Find day of week
        String result = week[totalDays % 7];
        System.out.println("Day of the week: " + result);
    }

    // Leap year check
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) ||(year % 4 == 0 && year % 100 != 0);
    }
}
