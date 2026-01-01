// Employee class is used to store employee information
class Employee {
    // Company name is same for all employees
    static String companyName = "Tech Solutions Inc.";
    // This variable keeps track of total employees
    private static int totalEmployees = 0;
    // Employee ID should not change, so it is final
    final int id;
    // These details are different for each employee
    String name;
    String designation;
    // Constructor to assign employee details
    // 'this' refers to the current employee object
    Employee(int id, String name, String designation) {
        this.id = id;                 // set employee ID
        this.name = name;             // set employee name
        this.designation = designation; // set employee designation
        totalEmployees++;             // increase employee count
    }
    // This method displays total number of employees
    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }
    // This method prints employee details
    // instanceof is used to check object type
    void displayDetails(Object obj) {
        if (obj instanceof Employee) {
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        }
    }
}
// Main class for starting the execution of program
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Creating first employee
        Employee employee1 = new Employee(101, "Thamarai", "Software Engineer");
        // Creating second employee
        Employee employee2 = new Employee(102, "Rohan", "Project Manager");
        // Display total employees
        Employee.displayTotalEmployees();
        // Display employee details
        employee1.displayDetails(employee1);
        employee2.displayDetails(employee2);
    }
}
