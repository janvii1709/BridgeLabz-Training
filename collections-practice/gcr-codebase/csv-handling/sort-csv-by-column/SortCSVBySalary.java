import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
class Employee {
    String id;
    String name;
    String department;
    int salary;
    Employee(String id, String name, String department, int salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return id + ", " + name + ", " + department + ", " + salary;
    }
}
public class SortCSVBySalary {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // skip header
            if (line == null) {
                System.out.println("CSV file is empty!");
                return;
            }
            // Read each record and create Employee objects
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Employee emp = new Employee(data[0], data[1], data[2], Integer.parseInt(data[3]));
                employees.add(emp);
            }
        } catch (IOException e) {
            System.out.println("Error reading the CSV file.");
            e.printStackTrace();
            return;
        }
        // Sort employees by salary descending
        employees.sort(Comparator.comparingInt((Employee e) -> e.salary).reversed());
        // Print top 5 highest-paid employees
        System.out.println("Top 5 highest-paid employees:");
        System.out.println("ID, Name, Department, Salary");
        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            System.out.println(employees.get(i));
        }
    }
}
