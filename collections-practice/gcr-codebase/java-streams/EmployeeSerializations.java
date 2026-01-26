import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
// Employee class
class Employee implements Serializable {
    int id;
    String name;
    String department;
    double salary;
    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}
public class EmployeeSerializations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> empList = new ArrayList<>();
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));

            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Department: ");
            String dept = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            empList.add(new Employee(id, name, dept, salary));
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.dat"))) {
            oos.writeObject(empList);
            System.out.println("\nEmployees saved successfully to employees.dat");
        } catch (IOException e) {
            System.out.println("IOException during serialization: " + e.getMessage());
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.dat"))) {
            ArrayList<Employee> list = (ArrayList<Employee>) ois.readObject();

            System.out.println("\nEmployees read from file:");
            for (Employee emp : list) {
                System.out.println(
                        "ID: " + emp.id +
                        ", Name: " + emp.name +
                        ", Department: " + emp.department +
                        ", Salary: " + emp.salary
                );
            }

        } catch (IOException e) {
            System.out.println("IOException during deserialization: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
        }
    }
}
