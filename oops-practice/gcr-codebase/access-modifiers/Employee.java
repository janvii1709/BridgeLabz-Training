class Employee {

    // public variable
    public int employeeID;

    // protected variable
    protected String department;

    // private variable
    private double salary;

    // constructor
    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // public method to modify salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // public method to access salary
    public double getSalary() {
        return salary;
    }
}

// subclass
class Manager extends Employee {

    Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    void displayDetails() {
        System.out.println("Employee ID: " + employeeID);   // public
        System.out.println("Department: " + department);    // protected
    }
}

// main class
class EmployeeRecords {
    public static void main(String[] args) {

        Manager m1 = new Manager(101, "HR", 50000);

        // accessing public & protected data
        m1.displayDetails();

        // modifying private salary using public method
        m1.setSalary(60000);

        System.out.println("Updated Salary: " + m1.getSalary());
    }
}
