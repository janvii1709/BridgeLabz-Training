import java.util.Scanner;
// Base class
class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }
}

// Manager subclass
class Manager extends Employee {
    int teamSize;

    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayDetails() {
        System.out.println("Employee Type: Manager");
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

// Developer subclass
class Developer extends Employee {
    String programmingLanguage;

    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void displayDetails() {
        System.out.println("Employee Type: Developer");
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

// Intern subclass
class Intern extends Employee {
    int duration; // months

    Intern(String name, int id, double salary, int duration) {
        super(name, id, salary);
        this.duration = duration;
    }

    @Override
    void displayDetails() {
        System.out.println("Employee Type: Intern");
        super.displayDetails();
        System.out.println("Internship Duration: " + duration + " months");
    }
}

// Main class
public class EmployeeManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Employee[] employees = new Employee[3];

        // -------- Manager Input --------
        System.out.println("Enter Manager Details:");
        System.out.print("Name: ");
        String mName = sc.nextLine();
        System.out.print("ID: ");
        int mId = sc.nextInt();
        System.out.print("Salary: ");
        double mSalary = sc.nextDouble();
        System.out.print("Team Size: ");
        int teamSize = sc.nextInt();
        employees[0] = new Manager(mName, mId, mSalary, teamSize);
        sc.nextLine(); // consume newline

        // -------- Developer Input --------
        System.out.println("\nEnter Developer Details:");
        System.out.print("Name: ");
        String dName = sc.nextLine();
        System.out.print("ID: ");
        int dId = sc.nextInt();
        System.out.print("Salary: ");
        double dSalary = sc.nextDouble();
        sc.nextLine(); // consume newline
        System.out.print("Programming Language: ");
        String lang = sc.nextLine();
        employees[1] = new Developer(dName, dId, dSalary, lang);

        // -------- Intern Input --------
        System.out.println("\nEnter Intern Details:");
        System.out.print("Name: ");
        String iName = sc.nextLine();
        System.out.print("ID: ");
        int iId = sc.nextInt();
        System.out.print("Salary: ");
        double iSalary = sc.nextDouble();
        System.out.print("Internship Duration (months): ");
        int duration = sc.nextInt();
        employees[2] = new Intern(iName, iId, iSalary, duration);

        // -------- Display All Employees (Polymorphism) --------
        System.out.println("\n--- Employee Details ---");
        for (Employee emp : employees) {
            System.out.println("------------------------");
            emp.displayDetails();
        }
    }
}
