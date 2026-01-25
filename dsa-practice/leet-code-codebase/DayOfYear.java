import java.util.Scanner;
public class DayOfYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take date input
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = sc.nextLine();
        // Split the date
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        // Days in each month
        int[] daysInMonth = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };
        // Check leap year
        boolean isLeap = (year % 400 == 0) ||(year % 4 == 0 && year % 100 != 0);
        // If leap year, February has 29 days
        if (isLeap) {
            daysInMonth[1] = 29;
        }
        int dayOfYear = 0;
        // Add days of previous months
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += daysInMonth[i];
        }
        // Add current day
        dayOfYear += day;
        System.out.println("Day number of the year: " + dayOfYear);
    }
}
