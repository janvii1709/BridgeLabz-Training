import java.util.*;
public class EmployeeBonusArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 10; // Total number of employees
        // Arrays to store employee data
        double[] SALARY = new double[N];        // Old salary of employees
        double[] Years_Of_Service = new double[N];// Years of service
        double[] BONUS = new double[N];         // Bonus amount
        double[] NEW_SALARY = new double[N];     // Salary after bonus
        // Variables to store total values
        double Total_BONUS= 0.0;
        double TOTAL_OLD_SALARY= 0.0;
        double TOTAL_NEW_SALARY = 0.0;
        // Taking salary and years of service for 10 employees
        for (int i = 0; i < N; i++) {
            System.out.println("Enter details for Employee " + (i + 1));
            System.out.print("Enter the salary: ");
            SALARY[i] = sc.nextDouble();
            System.out.print("Enter years of service: ");
            Years_Of_Service[i] = sc.nextDouble();
            // Validation check (Salary should be > 0 and years of service >= 0)
            if (SALARY[i] <= 0 || Years_Of_Service[i] < 0) {
                System.out.println("Invalid input! Please enter it again.");
                i--; // index is decremented to re enter the data
            }
        }
        // Calculating bonus, new salary and totals
        for (int i = 0; i < N; i++) {
            // If years of service more than 5 then bonus = 5% 
            if (Years_Of_Service[i] > 5) {
                BONUS[i] = SALARY[i] * 0.05;
            }// else bonus = 2 %
            else {
                BONUS[i] = SALARY[i] * 0.02;
            }
            // New salary = old salary + bonus
            NEW_SALARY[i] = SALARY[i] + BONUS[i];
            //adding the values to the total vairables declared above
            Total_BONUS+= BONUS[i];
            TOTAL_OLD_SALARY = TOTAL_OLD_SALARY + SALARY[i];
            TOTAL_NEW_SALARY = TOTAL_NEW_SALARY +  NEW_SALARY[i];
        }
        // NOW WRITING THE OUTPUT
        System.out.println("Total Old Salary  : " + TOTAL_OLD_SALARY);
        System.out.println("Total Bonus Paid : " +Total_BONUS);
        System.out.println("Total New Salary : " + TOTAL_NEW_SALARY);
        
    }
    
}
