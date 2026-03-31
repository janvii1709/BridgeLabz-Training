import java.time.LocalDate;
import java.util.Scanner;
public class InsuranceApp {
    public static void main(String[] args) {
        PolicyService service = new PolicyService();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Insurance Policy Management System ---");
            System.out.println("1. Add Policy");
            System.out.println("2. Get Policy by Number");
            System.out.println("3. Policies Expiring in Next 30 Days");
            System.out.println("4. Policies by Policy Holder");
            System.out.println("5. Remove Expired Policies");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Policy Number: ");
                    String number = sc.nextLine();
                    System.out.print("Enter Policy Holder Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Expiry Date (yyyy-mm-dd): ");
                    LocalDate date = LocalDate.parse(sc.nextLine());
                    service.addPolicy(new Policy(number, name, date));
                    System.out.println("Policy added successfully.");
                    break;
                case 2:
                    System.out.print("Enter Policy Number: ");
                    String searchNumber = sc.nextLine();
                    Policy policy = service.getPolicyByNumber(searchNumber);
                    if (policy != null)
                        System.out.println(policy);
                    else
                        System.out.println("Policy not found.");
                    break;
                case 3:
                    service.getPoliciesExpiringIn30Days();
                    break;
                case 4:
                    System.out.print("Enter Policy Holder Name: ");
                    String holder = sc.nextLine();
                    service.getPoliciesByHolder(holder);
                    break;
                case 5:
                    service.removeExpiredPolicies();
                    break;
                case 6:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
