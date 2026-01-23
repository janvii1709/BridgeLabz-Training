import java.util.*;
class Employee {
    String name;
    String department;
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    @Override
    public String toString() {
        return name;
    }
}
public class GroupByDepartment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for employee " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Department: ");
            String dept = sc.nextLine();
            employees.add(new Employee(name, dept));
        }
        Map<String, List<Employee>> deptMap = new HashMap<>();
        for (Employee emp : employees) {
            deptMap.putIfAbsent(emp.department, new ArrayList<>());
            deptMap.get(emp.department).add(emp);
        }
        System.out.println("\nEmployees grouped by department:");
        for (Map.Entry<String, List<Employee>> entry : deptMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
