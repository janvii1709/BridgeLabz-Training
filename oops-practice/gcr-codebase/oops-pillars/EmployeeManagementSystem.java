import java.util.*;

//ABSTRACT CLASS
abstract class Employee {
    private int employeeId;
    private String name;
    protected double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Name        : " + name);
        System.out.println("Salary      : " + calculateSalary());
    }
}

//INTERFACE
interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

//FULL TIME EMPLOYEE 
class FullTimeEmployee extends Employee implements Department {
    private String department;

    public FullTimeEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    public double calculateSalary() {
        return baseSalary;
    }

    public void assignDepartment(String deptName) {
        department = deptName;
    }

    public String getDepartmentDetails() {
        return department;
    }
}

// PART TIME EMPLOYEE
class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private String department;

    public PartTimeEmployee(int id, String name, double hourlyRate, int hoursWorked) {
        super(id, name, hourlyRate);
        this.hoursWorked = hoursWorked;
    }

    public double calculateSalary() {
        return baseSalary * hoursWorked;
    }

    public void assignDepartment(String deptName) {
        department = deptName;
    }

    public String getDepartmentDetails() {
        return department;
    }
}

// MAIN CLASS 
public class EmployeeManagementSystem {

    // Validation Methods 
    static String getAlpha(Scanner sc, String msg) {
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
        } while (!input.matches("[a-zA-Z]+"));
        return input;
    }

    static int getNumericInt(Scanner sc, String msg) {
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
        } while (!input.matches("[0-9]+"));
        return Integer.parseInt(input);
    }

    static double getNumericDouble(Scanner sc, String msg) {
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
        } while (!input.matches("[0-9]+"));
        return Double.parseDouble(input);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {

            System.out.println("\nEmployee " + i);
            System.out.println("1. Full Time Employee");
            System.out.println("2. Part Time Employee");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            int id = getNumericInt(sc, "Employee ID : ");
            String name = getAlpha(sc, "Name : ");
            String dept = getAlpha(sc, "Department : ");

            if (choice == 1) {
                double salary = getNumericDouble(sc, "Salary : ");
                Employee e = new FullTimeEmployee(id, name, salary);
                ((Department) e).assignDepartment(dept);
                employees.add(e);
            }
            else if (choice == 2) {
                double rate = getNumericDouble(sc, "Hourly Rate : ");
                int hours = getNumericInt(sc, "Hours Worked : ");
                Employee e = new PartTimeEmployee(id, name, rate, hours);
                ((Department) e).assignDepartment(dept);
                employees.add(e);
            }
            else {
                System.out.println("Invalid choice!");
                i--;
            }
        }

        // ---------- Display Details ----------
        System.out.println("\n===== Employee Details =====");
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Department  : " +
                    ((Department) emp).getDepartmentDetails());
            System.out.println("----------------------------");
        }
    }
}
