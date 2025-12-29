import java.util.Scanner;
public class RohanLibraryReminderApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int FinePerDay = 5;
        // Month lengths (non-leap year)
        int[] MonthDays = {0,31,28,31,30,31,30,31,31,30,31,30,31}; // index 1=Jan
        for (int i = 1; i <= 5; i++) {
            System.out.println("Book " + i + ":");
            int DueDay=0, DueMonth=0, DueYear=0;
            int ReturnDay=0, ReturnMonth=0, ReturnYear=0;
            // Input due date (single line) with validation
            while (true) {
                System.out.print("Enter due date (day month year): ");
                String Input = sc.nextLine();
                String[] Parts = Input.trim().split("\\s+");
                if (Parts.length == 3) {
                    try {
                        int Day = Integer.parseInt(Parts[0]);
                        int Month = Integer.parseInt(Parts[1]);
                        int Year = Integer.parseInt(Parts[2]);
                        if (Month >= 1 && Month <= 12 && Day >= 1 && Day <= MonthDays[Month]) {
                            DueDay = Day;
                            DueMonth = Month;
                            DueYear = Year;
                            break; // valid
                        } else {
                            System.out.println("Invalid due date! Enter again.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Enter numbers only.");
                    }
                } else {
                    System.out.println("Enter day, month and year separated by spaces!");
                }
            }

            // Input return date (single line) with validation
            while (true) {
                System.out.print("Enter return date (day month year): ");
                String Input = sc.nextLine();
                String[] Parts = Input.trim().split("\\s+");
                if (Parts.length == 3) {
                    try {
                        int Day = Integer.parseInt(Parts[0]);
                        int Month = Integer.parseInt(Parts[1]);
                        int Year = Integer.parseInt(Parts[2]);

                        if (Month >= 1 && Month <= 12 && Day >= 1 && Day <= MonthDays[Month]) {
                            ReturnDay = Day;
                            ReturnMonth = Month;
                            ReturnYear = Year;
                            break; // valid
                        } else {
                            System.out.println("Invalid return date! Enter again.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Enter numbers only.");
                    }
                } else {
                    System.out.println("Enter day, month and year separated by spaces!");
                }
            }

            // Convert dates to total days for difference
            int DueTotalDays = DueYear*365 + cumulativeDays(DueMonth, MonthDays) + DueDay;
            int ReturnTotalDays = ReturnYear*365 + cumulativeDays(ReturnMonth, MonthDays) + ReturnDay;

            int DaysLate = ReturnTotalDays - DueTotalDays;

            if (DaysLate > 0) {
                int Fine = DaysLate * FinePerDay;
                System.out.println("Late by " + DaysLate + " day(s). Fine = INR " + Fine);
            } else {
                System.out.println("Book returned on time. No fine.");
            }

            System.out.println();
        }
    }

    // Helper method: cumulative days till previous month
    public static int cumulativeDays(int Month, int[] MonthDays) {
        int Sum = 0;
        for (int i = 1; i < Month; i++) {
            Sum += MonthDays[i];
        }
        return Sum;
    }
}
