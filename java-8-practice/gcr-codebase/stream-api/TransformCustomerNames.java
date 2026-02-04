import java.util.*;
public class TransformCustomerNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of customers:");
        int n = sc.nextInt();
        sc.nextLine();
        List<String> names = new ArrayList<>();
        System.out.println("Enter customer names:");
        for (int i = 0; i < n; i++) {
            names.add(sc.nextLine());
        }
        System.out.println("\nCustomer Names (Uppercase & Sorted):");
        names.stream()
             .map(String::toUpperCase)
             .sorted()                 
             .forEach(System.out::println);
    }
}
