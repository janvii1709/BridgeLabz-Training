import java.util.*;
public class Main{
    public static void main(String[] args) {
        System.out.println("Welcome To Employee Wage Computation Program ");
        int wagePerHour = 20;
        int fullDayHours = 8;
        int partTimeHours = 4;
        int totalWorkingDays = 20;
        int totalMonthlyWage = 0;

        Random random = new Random();
        for (int day = 1; day <= totalWorkingDays; day++) {

        int employeeCheck = random.nextInt(3);// 0 or 1 or 2
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

        int dailyWage = workingHours * wagePerHour;
        System.out.println("Daily Employee Wage: INR " + dailyWage);
        totalMonthlyWage += dailyWage;
    }
    System.out.println("Total Monthly Wage: INR "  + totalMonthlyWage);
        
    }
}