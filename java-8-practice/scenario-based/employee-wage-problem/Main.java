import java.util.*;
class EmpWageBuilder {
    // ===== Instance Variables =====
    String companyName;
    int wagePerHour;
    int maxWorkingDays;
    int maxWorkingHours;
    int totalMonthlyWage;
    int fullDayHours = 8;
    int partTimeHours = 4;

    // ===== Constructor =====
    EmpWageBuilder(String companyName,int wagePerHour,int maxWorkingDays,int maxWorkingHours) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.maxWorkingDays = maxWorkingDays;
        this.maxWorkingHours = maxWorkingHours;
    }
    // ===== Compute Wage Method (No Parameters Now) =====
    void computeEmployeeWage() {
        int totalWorkingDays = 0;
        int totalWorkingHours = 0;
        Random random = new Random();
        while (totalWorkingDays < maxWorkingDays &&totalWorkingHours < maxWorkingHours) {
            totalWorkingDays++;
            int employeeCheck = random.nextInt(3);
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
        System.out.println("Total Monthly Wage: INR " + totalMonthlyWage);
        System.out.println("--------------------------------------------------");
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome To Employee Wage Computation Program\n");
        // Create Objects for Each Company
        EmpWageBuilder tcs = new EmpWageBuilder("TCS", 20, 20, 100);
        EmpWageBuilder infosys = new EmpWageBuilder("Infosys", 25, 22, 110);
        EmpWageBuilder wipro = new EmpWageBuilder("Wipro", 18, 20, 90);
        tcs.computeEmployeeWage();
        infosys.computeEmployeeWage();
        wipro.computeEmployeeWage();
    }
}
