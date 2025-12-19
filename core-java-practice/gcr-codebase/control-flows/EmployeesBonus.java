import java.util.Scanner;
public class EmployeesBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double salary = sc.nextDouble();// input salary of employee
        int YearsOfService = sc.nextInt();// input years of service of employees
        // calculating bonus based on year of service
        if (YearsOfService > 5) {
            double bonus = salary * 0.05;   // 5 % bonus for more than 5 years of service
            System.out.println("Bonus amount is: " + bonus);
        } else {
            System.out.println("Bonus amount is: 0");
        }
        
    }
    
}
