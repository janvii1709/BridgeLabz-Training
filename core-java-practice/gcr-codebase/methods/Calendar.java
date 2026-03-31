
import java.util.Scanner;

public class Calendar {

    // Method to get month name
    public static String GetMonthName(int Month) {
        String[] Months = {
            "January","February","March","April","May","June",
            "July","August","September","October","November","December"
        };
        return Months[Month - 1];
    }

    // Leap year check
    public static boolean IsLeapYear(int Year) {
        return (Year % 4 == 0 && Year % 100 != 0) || (Year % 400 == 0);
    }

    // Method to get number of days in month
    public static int GetDaysInMonth(int Month, int Year) {
        int[] Days = {31,28,31,30,31,30,31,31,30,31,30,31};

        if (Month == 2 && IsLeapYear(Year))
            return 29;

        return Days[Month - 1];
    }

    // Method to get first day of month (0 = Sunday)
    public static int GetFirstDay(int Month, int Year) {
        int d = 1;
        int m = Month;
        int y = Year;

        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;

        return d0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Month = sc.nextInt();
        int Year = sc.nextInt();

        System.out.println("\n" + GetMonthName(Month) + " " + Year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int FirstDay = GetFirstDay(Month, Year);
        int DaysInMonth = GetDaysInMonth(Month, Year);

        // First loop for indentation
        for (int i = 0; i < FirstDay; i++) {
            System.out.print("    ");
        }

        // Second loop for dates
        for (int Day = 1; Day <= DaysInMonth; Day++) {
            System.out.printf("%3d ", Day);

            if ((Day + FirstDay) % 7 == 0)
                System.out.println();
        }
    }
}