import java.util.Random;
public class EmployeeWageComputationProblem {
    // Constants
    static final int WAGE_PER_HOUR = 20;      // Wage per hour
    static final int FULL_TIME_HOUR = 8;      // Hours for full-time
    static final int PART_TIME_HOUR = 4;      // Hours for part-time
    static final int MAX_DAYS = 20;           // Maximum working days in a month (UC5)
    static final int MAX_HOURS = 100;         // Maximum working hours in a month (UC6)
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        Random random = new Random();
        int TotalHours = 0;          // Total hours worked in month (UC6)
        int TotalWage = 0;           // Total wage earned in month (UC5/UC6)
        int TotalWorkingDays = 0;    // Count of days employee was present (UC5)
        // Loop for each day until max 20 days or 100 hours reached (UC5 & UC6)
        for (int Day = 1; Day <= MAX_DAYS && TotalHours < MAX_HOURS; Day++) {
            System.out.println("\nDay " + Day + " :");
            // UC1: Attendance check using RANDOM
            // 0 = Absent, 1 = Present
            int Attendance = random.nextInt(2);

            int DailyHours = 0;       // Hours worked today
            int DailyWage = 0;        // Wage earned today

            if (Attendance == 0) {
                // Employee is absent (UC1)
                System.out.println("The employee is ABSENT today !");
                System.out.println("Today's wage of the employee is ZERO.");
            } else {
                // Employee is present (UC1)
                System.out.println("The employee is PRESENT today !");

                // UC3 & UC4: Decide if employee works full time or part time
                // 0 = Full Time, 1 = Part Time
                int EmpType = random.nextInt(2);

                if (EmpType == 0) {
                    // UC2: Full Time Employee Wage Calculation
                    DailyHours = FULL_TIME_HOUR;
                    DailyWage = DailyHours * WAGE_PER_HOUR;
                    System.out.println("The employee is FULL TIME.");
                    System.out.println("Today's wage of the employee is INR " + DailyWage + ".");
                } else {
                    // UC3: Part Time Employee Wage Calculation
                    DailyHours = PART_TIME_HOUR;
                    DailyWage = DailyHours * WAGE_PER_HOUR;
                    System.out.println("The employee is PART TIME.");
                    System.out.println("Today's wage of the employee is INR " + DailyWage + ".");
                }
                // Count working day only if present (UC5)
                TotalWorkingDays++;
            }
            // UC6: Ensure maximum 100 hours limit is not crossed
            if (TotalHours + DailyHours > MAX_HOURS) {
                DailyHours = MAX_HOURS - TotalHours;
                DailyWage = DailyHours * WAGE_PER_HOUR;
            }
            // Update monthly totals
            TotalHours += DailyHours;   // Total hours worked (UC6)
            TotalWage += DailyWage;     // Total wage earned (UC5/UC6)
        }
        // Final Monthly Outcome (UC5 & UC6)
        System.out.println("\nSo the overall outcome of the employee is : ");
        System.out.println("Total Working Days = " + TotalWorkingDays);   // UC5
        System.out.println("Total Working Hours = " + TotalHours);       // UC6
        System.out.println("Total Monthly Wage = " + TotalWage);         // UC5/UC6
    }
}
