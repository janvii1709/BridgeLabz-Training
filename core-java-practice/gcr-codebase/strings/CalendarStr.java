import java.util.Scanner;
public class CalendarStr {

    // a) Method to get month name
    static String getMonthName(int Month) {
        String[] Months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        return Months[Month - 1];
    }

    // Leap year check
    static boolean Is_Leap_Year(int Year) {
        return (Year % 400 == 0) || (Year % 4 == 0 && Year % 100 != 0);
    }
    // b) Method to get number of days in a month
    static int Get_Days_In_Month(int Month, int Year) {
        int[] Days = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };
        if (Month == 2 && Is_Leap_Year(Year))
            return 29;

        return Days[Month - 1];
    }
    // c) Method to get first day of month (0=Sun, 6=Sat)
    static int Get_First_Day(int Day, int Month, int Year) {
        int y0 = Year - (14 - Month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = Month + 12 * ((14 - Month) / 12) - 2;
        int d0 = (Day + x + (31 * m0) / 12) % 7;
        return d0;
    }

    // d) Method to display calendar
    static void displayCalendar(int Month, int Year) {
        System.out.println("\n   " + getMonthName(Month) + " " + Year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int First_Day = Get_First_Day(1, Month, Year);
        int Days_In_Month = Get_Days_In_Month(Month, Year);
        // First for-loop for indentation
        for (int i = 0; i < First_Day; i++) {
            System.out.printf("%3s", " ");
        }

        // Second for-loop to print dates
        for (int Day = 1; Day <= Days_In_Month; Day++) {
            System.out.printf("%3d", Day);

            if ((Day + First_Day) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int Month = sc.nextInt();

        System.out.print("Enter year: ");
        int Year = sc.nextInt();

        displayCalendar(Month, Year);
    }
}