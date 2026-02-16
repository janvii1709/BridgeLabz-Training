import java.util.*;
public class Main {
    // ===== Class Variables =====
    static final int WAGE_PER_HOUR = 20;
    static final int FULL_DAY_HOURS = 8;
    static final int PART_TIME_HOURS = 4;
    static final int MAX_WORKING_DAYS = 20;
    static final int MAX_WORKING_HOURS = 100;
    // ===== Class Method =====
    public static int computeEmployeeWage() {
        int totalWorkingDays = 0;
        int totalWorkingHours = 0;
        int totalMonthlyWage = 0;
        Random random = new Random();
        while (totalWorkingDays < MAX_WORKING_DAYS && totalWorkingHours < MAX_WORKING_HOURS) {
            totalWorkingDays++;
            int employeeCheck = random.nextInt(3); // 0,1,2
            int workingHours = 0;
            switch (employeeCheck) {
                case 1:
                    System.out.println("Employee is Part Time");
                    workingHours = PART_TIME_HOURS;
                    break;
                case 2:
                    System.out.println("Employee is Full Time");
                    workingHours = FULL_DAY_HOURS;
                    break;
                default:
                    System.out.println("Employee is Absent");
                    workingHours = 0;
            }
            totalWorkingHours += workingHours;
            int dailyWage = workingHours * WAGE_PER_HOUR;
            totalMonthlyWage += dailyWage;
            System.out.println("Daily Wage: INR " + dailyWage);
        }
        System.out.println("\nTotal Working Days: " + totalWorkingDays);
        System.out.println("Total Working Hours: " + totalWorkingHours);
        return totalMonthlyWage;
    }
    public static void main(String[] args) {
        System.out.println("Welcome To Employee Wage Computation Program");
        int totalWage = computeEmployeeWage();
        System.out.println("Total Monthly Wage: INR " + totalWage);
    }
}
