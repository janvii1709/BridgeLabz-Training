import java.util.*;
public class EmployeeNameUppercase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> employees = new ArrayList<>();
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter employee names:");
        for (int i = 0; i < n; i++) {
            employees.add(sc.nextLine());
        }
        System.out.println("\nEmployee Names in Uppercase:");
        employees.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
