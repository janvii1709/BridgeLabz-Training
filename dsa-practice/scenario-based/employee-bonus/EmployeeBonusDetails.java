import java.util.Scanner;
// Abstract class
abstract class Employee {
    private final String name;
    private final double salary;
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    // Getter
    public double getSalary() {
        return salary;
    }
    // Polymorphic method
    public abstract double getBonus();
}
// Manager class
class Manager extends Employee {
    private final double bonus; // cached bonus
    public Manager(String name, double salary) {
        super(name, salary);
        this.bonus = salary * 0.10; // 10% bonus
    }
    @Override
    public double getBonus() {
        return bonus;
    }
}
// Developer class
class Developer extends Employee {
    private final double bonus; // cached bonus
    public Developer(String name, double salary) {
        super(name, salary);
        this.bonus = salary > 50000 ? salary * 0.05 : 0.0;
    }
    @Override
    public double getBonus() {
        return bonus;
    }
}
public class EmployeeBonusDetails {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Select Employee Role:");
        System.out.println("1. Manager");
        System.out.println("2. Developer");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        Employee employee;

        if (choice == 1) {
            employee = new Manager(name, salary);
        } else if (choice == 2) {
            employee = new Developer(name, salary);
        } else {
            System.out.println(" Invalid choice!");
            return;
        }

        System.out.printf("Calculated Bonus: %.2f%n", employee.getBonus());
    }
}
