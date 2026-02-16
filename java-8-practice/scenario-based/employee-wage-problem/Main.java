import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome To Employee Wage Computation Program");
        int wagePerHour = 20;
        int fullDayHours = 8;
        int partTimeHours = 4;
        int totalWorkingDays = 0;
        int totalWorkingHours = 0;
        int maxWorkingDays = 20;
        int maxWorkingHours = 100;
        int totalMonthlyWage = 0;
        Random random = new Random();
        while (totalWorkingDays < maxWorkingDays && totalWorkingHours < maxWorkingHours) {
            totalWorkingDays++;
            int employeeCheck = random.nextInt(3); // 0,1,2
            int workingHours = 0;
            switch (employeeCheck) {
                case 1:
                    System.out.println("Employee is Part Time");
                    workingHours = partTimeHours;
                    break;
                case 2:
                    System.out.println("Employee is Full Time");
                    workingHours = fullDayHours;
                    break;
                default:
                    System.out.println("Employee is Absent");
                    workingHours = 0;
            }
            totalWorkingHours += workingHours;
            int dailyWage = workingHours * wagePerHour;
            totalMonthlyWage += dailyWage;
            System.out.println("Daily Wage: INR " + dailyWage);
        }
        System.out.println("\nTotal Working Days: " + totalWorkingDays);
        System.out.println("Total Working Hours: " + totalWorkingHours);
        System.out.println("Total Monthly Wage: INR " + totalMonthlyWage);
    }
}
