import java.util.*;
public class Main {
    // ===== Class Method with Parameters =====
    static void computeEmployeeWage(String companyName,int wagePerHour,int maxWorkingDays,int maxWorkingHours) {
        int fullDayHours = 8;
        int partTimeHours = 4;
        int totalWorkingDays = 0;
        int totalWorkingHours = 0;
        int totalMonthlyWage = 0;
        Random random = new Random();
        while (totalWorkingDays < maxWorkingDays && totalWorkingHours < maxWorkingHours) {
            totalWorkingDays++;
            int employeeCheck = random.nextInt(3); // 0,1,2
            int workingHours = 0;
            switch (employeeCheck) {
                case 1:
                    System.out.println(companyName + ": Employee is Part Time");
                    workingHours = partTimeHours;
                    break;
                case 2:
                    System.out.println(companyName + ": Employee is Full Time");
                    workingHours = fullDayHours;
                    break;
                default:
                    System.out.println(companyName + ": Employee is Absent");
                    workingHours = 0;
            }
            totalWorkingHours += workingHours;
            int dailyWage = workingHours * wagePerHour;
            totalMonthlyWage += dailyWage;
            System.out.println(companyName + ": Daily Wage = INR " + dailyWage);
        }
        System.out.println("\nCompany: " + companyName);
        System.out.println("Total Working Days: " + totalWorkingDays);
        System.out.println("Total Working Hours: " + totalWorkingHours);
        System.out.println("Total Monthly Wage: INR " + totalMonthlyWage);
        System.out.println("--------------------------------------------------");
    }
    public static void main(String[] args) {
        System.out.println("Welcome To Employee Wage Computation Program");
        computeEmployeeWage("TCS", 20, 20, 100);
        computeEmployeeWage("Infosys", 25, 22, 110);
        computeEmployeeWage("Wipro", 18, 20, 90);
    }
}
